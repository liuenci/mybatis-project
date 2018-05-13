package com.liuenci.third;

import com.liuenci.pojo.Dept;
import com.liuenci.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MapperTest {

    public static SqlSession sqlSession;
    public static DeptMapper deptMapper;
    @BeforeClass
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            deptMapper = sqlSession.getMapper(DeptMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试 if
     */
    @Test
    public void testIf(){
        List<DeptEmp> deptEmpList = deptMapper.testIf(7498,"");
        for (DeptEmp deptEmp:deptEmpList){
            System.out.println("部门信息:"+deptEmp);
            List<Emp> empList = deptEmp.getEmpList();
            for (Emp emp:empList){
                System.out.println("\t员工信息:"+emp);
            }
        }

    }

    /**
     * 测试 trim
     */
    @Test
    public void testTrim(){
        List<DeptEmp> deptEmpList = deptMapper.testTrim("ALLEN","SALESMAN");
        for (DeptEmp deptEmp:deptEmpList){
            System.out.println("部门信息:"+deptEmp);
            List<Emp> empList = deptEmp.getEmpList();
            if (!empList.isEmpty()){
                for (Emp emp:empList){
                    System.out.println("\t员工信息:"+emp);
                }
            }

        }
    }
    @Test
    public void testChooseWhen(){
        List<DeptEmp> deptEmpList = deptMapper.testChooseWhen("ALLEN","");
        for (DeptEmp deptEmp:deptEmpList){
            System.out.println("部门信息:"+deptEmp);
            List<Emp> empList = deptEmp.getEmpList();
            if (!empList.isEmpty()){
                for (Emp emp:empList){
                    System.out.println("\t员工信息:"+emp);
                }
            }
        }
    }
    @Test
    public void testForeach(){

    }
}
