package com.liuenci.test;

import com.liuenci.dao.DeptMapper1;
import com.liuenci.pojo.Dept;
import com.liuenci.pojo.Dept1;
import com.liuenci.pojo.Emp;
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

public class DeptTest1 {

    public static Logger logger;

    public static SqlSession session;
    @BeforeClass
    public static void init(){
        logger = Logger.getLogger(DeptTest1.class);
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelectAllDeptEmp(){
        DeptMapper1 deptMapper1 = session.getMapper(DeptMapper1.class);
        List<Dept1> dept1List = deptMapper1.selectAllDept();
        for (Dept1 dept1 : dept1List){
            logger.debug("部门信息:"+dept1);
            for (Emp emp : dept1.getEmpList()){
                logger.debug("员工信息："+emp);
            }
        }
    }
}
