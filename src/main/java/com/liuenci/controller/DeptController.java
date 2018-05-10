package com.liuenci.controller;

import com.liuenci.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class DeptController {

    static SqlSession session;
    @BeforeClass
    public static void init(){
        try {
            // 1. 加载配置
            Reader config = Resources.getResourceAsReader("mybatis-config.xml");
            // 2. 创建 Session 工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
            // 3. 开启 Session 得到 Session 对象
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetAllDept(){
        // 4. 通过 Session 调用指定配置的 Sql 语句
        List<Dept> list = session.selectList("getAllDept");
        for (Dept dept: list){
            System.out.println(dept);
        }
    }

    @Test
    public void testAddNewDept(){
        Dept dept = new Dept();
        dept.setDeptno(100);
        dept.setDname("株洲");
        dept.setLoc("湖南工业大学");
        int result = session.insert("addNewDept",dept);
        session.commit();
        Assert.assertTrue(result == 1);
    }
}
