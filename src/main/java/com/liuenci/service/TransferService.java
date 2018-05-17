package com.liuenci.service;

import com.liuenci.dao.TransferMapper;
import com.liuenci.pojo.Account;
import com.liuenci.pojo.Transfer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TransferService {
    private static Logger logger = Logger.getLogger(TransferService.class);
    @Autowired
    private TransferMapper transferMapper;

    /**
     * 注册新账户
     *
     * @param account
     */
    public void register(Account account) {
        int result = transferMapper.insertAccount(account);
        if (result > 0) {
            logger.debug("注册账户成功");
            return;
        }
        logger.debug("注册账户失败");
    }

    /**
     * 更新密码
     *
     * @param aid
     * @param oldPassword
     * @param newPassword
     */
    public void updatePassword(int aid, String oldPassword, String newPassword) {
        Account account = transferMapper.selectAccountById(aid);
        if (account == null && !account.getPassword().equals(oldPassword)) {
            logger.info("用户不存在或者密码错误");
            return;
        }
        account.setPassword(newPassword);
        int updateResult = transferMapper.updateAccount(account);
        if (updateResult == 0) {
            logger.info("更新密码失败");
            return;
        }
        logger.info("更新密码成功");
    }

    @Transactional(rollbackFor = Exception.class)
    public void transfer(int aid1,int aid2,double money) throws Exception {

        Account account1 = transferMapper.selectAccountById(aid1);
        account1.setBalance(account1.getBalance() + money);
        int transferInResult1 = transferMapper.updateAccount(account1);
        Account account2 = transferMapper.selectAccountById(aid2);
        if (account2.getBalance() < money){
            logger.debug("账户余额不足，无法转账");
            throw new Exception();
        }
        account2.setBalance(account2.getBalance() - money);
        int transferInResult2 = transferMapper.updateAccount(account2);
        if (transferInResult1 == 0 || transferInResult2 == 0){
            logger.debug("转账异常，转账失败");
            throw new Exception();
        }
        Transfer transfer1 = new Transfer();
        transfer1.setaId(aid1);
        transfer1.setTransMoney(money);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String s  = simpleDateFormat.format(date);
        transfer1.setTransTime(java.sql.Date.valueOf(s));
        transfer1.setTtype("转入");
        int result1 = transferMapper.insertTransfer(transfer1);

        Transfer transfer2 = new Transfer();
        transfer2.setaId(aid2);
        transfer2.setTransMoney(money);
        transfer2.setTransTime(java.sql.Date.valueOf(s));
        transfer2.setTtype("转出");
        int result2 = transferMapper.insertTransfer(transfer2);

        if (result1 == 0 || result2 == 0){
            logger.debug("交易记录添加失败");
            throw new Exception();
        }
        logger.debug("交易成功");
    }

    /**
     * 对账
     */
    public void checkMoney(){
        List<Account> accountList = transferMapper.selectAllAccount();
        if (accountList.isEmpty()){
            logger.info("系统还没有任何账户");
            return;
        }
        for (Account account : accountList){
            // 获取账户开户金额
            double openMoney = account.getOpenMoney();
            // 获取转出总金额
            double transferOut = transferMapper.selectSum(account.getAid(),"转出") == null ? 0.0:transferMapper.selectSum(account.getAid(),"转出");
            // 获取转入总金额
            double transferIn = transferMapper.selectSum(account.getAid(),"转入") == null ? 0.0 :transferMapper.selectSum(account.getAid(),"转入");
            // 获取账户余额
            double balance = account.getBalance();
            boolean result = balance == openMoney - transferOut + transferIn;
            if (result == true){
                logger.info(account.getName()+":对账成功无坏账");
            }else{
                logger.info(account.getName()+":对账成功发现坏账");
            }
        }
    }

    /**
     * 获取所有交易记录
     * @param aid
     */
    public void getAccountTransfer(int aid){
        List<Transfer> transfers = transferMapper.selectAllTransferById(aid);
        if (transfers.isEmpty()){
            logger.debug("没有交易记录");
            return;
        }
        for (Transfer transfer:transfers){
            logger.debug(transfer);
        }
    }
}
