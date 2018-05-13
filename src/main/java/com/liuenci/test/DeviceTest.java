package com.liuenci.test;

import com.liuenci.dao.DeviceMapper;
import com.liuenci.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class DeviceTest {
    public static SqlSession session;
    public static DeviceMapper deviceMapper;
    @BeforeClass
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            deviceMapper = session.getMapper(DeviceMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelectDeviceInByDate(){
        List<DeviceIn> deviceInList = deviceMapper.selectDeviceInByDate("2018-5-12");
        System.out.println(deviceInList);
        for (DeviceIn deviceIn : deviceInList){
            System.out.println(deviceIn);
        }
    }
    @Test
    public void testSelectDeviceRecode(){
        List<DeviceRecode> deviceRecodeList = deviceMapper.selectRecodeByDevice(1);
        for (DeviceRecode deviceRecode : deviceRecodeList){
            System.out.println(deviceRecode);
        }
    }
    @Test
    public void testSelectSum(){
        List<RecodeSum> recodeSumList = deviceMapper.selectSum("1");
        for (RecodeSum recodeSum:recodeSumList){
            System.out.println(recodeSum);
        }

    }

    @Test
    public void testSelectBuy(){
        List<BuyerRecode> buyerRecodes = deviceMapper.selectBuy("encier");
        for (BuyerRecode buyerRecode : buyerRecodes){

            System.out.println(buyerRecode);
        }
    }
}
