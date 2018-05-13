package com.liuenci.test;

import com.liuenci.dao.DeptEmpMapper;
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
import java.util.Map;

public class DeptEmpTest {

    public static SqlSession session;
    public static DeptEmpMapper deptEmpMapper;

    @BeforeClass
    public static void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            deptEmpMapper = session.getMapper(DeptEmpMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAllDeptEmp() {
        List<Dept1> deptList = deptEmpMapper.selectAllDeptAndEmp();
        for (Dept1 dept1 : deptList) {
            System.out.println("部门信息:" + dept1);
            if (!dept1.getEmpList().isEmpty()) {
                List<Emp> emps = dept1.getEmpList();
                for (Emp emp : emps) {
                    System.out.println("\t员工信息:" + emp);
                }
            }
        }
    }

    @Test
    public void testSelectEmpByEmpno() {
        EmpBoss emp = deptEmpMapper.selectEmpByEmpno(7499);
        System.out.println("员工信息:" + emp);
        System.out.println("员工上级信息:" + emp.getEmp());
    }

    @Test
    public void testSelectEmpBossDeptByEmpno() {
        EmpBossDept empBossDept = deptEmpMapper.selectEmpBossDeptByEmpno(7499);
        System.out.println("员工信息:" + empBossDept);
        System.out.println("员工上级信息:" + empBossDept.getEmp());
        System.out.println("员工部门信息:" + empBossDept.getDept());

    }

    @Test
    public void testSelectDept() {
        List<Map<Object, Object>> mapList = deptEmpMapper.selectDept();
        for (Map<Object, Object> map : mapList) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            }

            System.out.println("==============");
        }
    }

    @Test
    public void testSelectHire() {
        List<Map<Object, Object>> mapList = deptEmpMapper.selectHire();
        for (Map<Object, Object> map : mapList) {
            for (Map.Entry<Object,Object> entry:map.entrySet()){
                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            }
            System.out.println("==============");
        }
    }
}
