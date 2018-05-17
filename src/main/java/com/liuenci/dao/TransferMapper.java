package com.liuenci.dao;

import com.liuenci.pojo.Account;
import com.liuenci.pojo.Transfer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransferMapper {
    int insertAccount(Account account);

    Account selectAccountById(Integer aid);

    int updateAccount(Account account);

    int insertTransfer(Transfer transfer);

    List<Account> selectAllAccount();

    Double selectSum(@Param("aid") Integer aid, @Param("type") String type);

    List<Transfer> selectAllTransferById(Integer aid);
}
