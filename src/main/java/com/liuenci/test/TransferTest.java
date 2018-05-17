package com.liuenci.test;

import com.liuenci.pojo.Account;
import com.liuenci.service.TransferService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

public class TransferTest {

    public static ApplicationContext applicationContext;
    public static TransferService service;
    @BeforeClass
    public static void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = applicationContext.getBean("transferService",TransferService.class);
    }
    @Test
    public void testRegister(){
        Account account = new Account();
        account.setName("赞哥");
        account.setPassword("123456");
        account.setSex("男");
        account.setCode("430");
        account.setOpenMoney(2000);
        account.setOpenTime(Date.valueOf("2018-1-1"));
        account.setBalance(2000);
        service.register(account);
    }
    @Test
    public void testUpdatePassword(){
        service.updatePassword(102,"123456","123");
    }
    @Test
    public void testTransfer() throws Exception {
        service.transfer(2,102,100);
    }
    @Test
    public void testCheckMoney(){
        service.checkMoney();
    }
    @Test
    public void testGetAccountTransfer(){
        service.getAccountTransfer(102);
    }
}
