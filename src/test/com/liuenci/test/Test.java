package com.liuenci.test;

import com.liuenci.dao.DeptEmpMapper;
import com.liuenci.pojo.Dept1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test{
    @org.junit.Test
    public  void  test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DeptEmpMapper deptMapper = applicationContext.getBean(DeptEmpMapper.class);
        List<Dept1> dept1List =  deptMapper.selectAllDeptAndEmp();
        System.out.println(dept1List);

    }
}
