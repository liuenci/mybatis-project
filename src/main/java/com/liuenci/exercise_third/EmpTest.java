package com.liuenci.exercise_third;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class EmpTest {

    public static SqlSession session;
    public static EmpMapper empMapper;
    public static int size;

    public static void main(String[] args) {
        EmpTest empTest = new EmpTest();
        empTest.init();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字:");
        int n = scanner.nextInt();
        int flag = n;
        while (n != 0) {
            switch (n) {
                case 1:
                    empTest.query(n);
                    flag = n;
                    break;
                case 2:
                    empTest.query(flag - 1);
                    flag = flag - 1;
                    break;
                case 3:
                    empTest.query(flag + 1);
                    flag = flag + 1;
                    break;
                case 4:
                    empTest.query(size);
                    flag = size;
                    break;
                default:
                    break;
            }
            System.out.println("请输入数字:");
            n = scanner.nextInt();
        }
        System.out.println("程序结束");
    }

    public void init() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sqlSessionFactory.openSession();
            empMapper = session.getMapper(EmpMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void query(int pageNum) {
        Page<Emp> page = PageHelper.startPage(pageNum, 3);
        size = page.getPages();
        List<Emp> emps = empMapper.selectLimit();
        System.out.println(page);
        System.out.println("总记录条数:" + page.getTotal());
        System.out.println("总页数:" + page.getPages());
    }
}
