package com.liuenci.test;

import com.liuenci.pojo.Emp1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class EmpMapperTest1 {

    public static Logger logger;
    public static SqlSession sqlSession;

    @BeforeClass
    public static void init(){
        logger = Logger.getLogger(EmpMapperTest1.class);
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelectAllEmp(){
        List<Emp1> emp1List = sqlSession.selectList("selectAllEmp");
        for (Emp1 emp1 : emp1List){
            logger.info(emp1);
        }
    }
}
