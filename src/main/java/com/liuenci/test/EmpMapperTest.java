package com.liuenci.test;

import com.liuenci.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpMapperTest {
    static SqlSession session;
    static Logger logger;
    @BeforeClass
    public static void init(){
        logger = Logger.getLogger(EmpMapperTest.class);
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testAddNewEmp(){
        Emp emp = new Emp();
        emp.setEmpno(4396);
        emp.setEname("厂长");
        emp.setJob("职业打野");
        emp.setMgr(7698);
        emp.setHiredate("2018-1-1");
        emp.setSal(10000.0);
        emp.setComm(1000.0);
        emp.setDeptno(20);
        int result = session.insert("addNewEmp",emp);
        Assert.assertTrue(result > 0);
        session.commit();
    }
    @Test
    public void testUpdateEmpByEmpno(){
        Emp emp = new Emp();
        emp.setEmpno(4396);
        emp.setEname("厂长");
        emp.setJob("职业打野");
        emp.setMgr(7698);
        emp.setHiredate("2018-1-2");
        emp.setSal(10000.0);
        emp.setComm(1000.0);
        emp.setDeptno(20);
        int result = session.update("updateEmpByEmpno",emp);
        Assert.assertTrue(result > 0);
        session.commit();
    }

    @Test
    public void testDeleteEmpByEmpno(){
        int result = session.delete("deleteEmpByEmpno",4396);
        Assert.assertTrue(result > 0);
        session.commit();
    }

    @Test
    public void testGetEmpByEmpno(){
        Emp emp = session.selectOne("getEmpByEmpno",7498);
        logger.info(emp);
    }

    @Test
    public void testGetAllEmp(){
        List<Emp> emps = session.selectList("getAllEmp");
        for (Emp emp : emps){
            logger.info(emp);
        }
    }

    @Test
    public void testGetEmpByCondition(){
        Map map = new HashMap();
        map.put("start",2000);
        map.put("end",3000);
        List<Emp> emps = session.selectList("getEmpByCondition",map);
        for (Emp emp : emps){
            logger.info(emp);
        }
    }
}
