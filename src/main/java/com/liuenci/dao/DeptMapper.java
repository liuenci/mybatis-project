package com.liuenci.dao;

import com.liuenci.pojo.Dept;

import java.util.List;
public interface DeptMapper {

    int addNewDept(Dept dept);

    int updateDeptInformation();

    List<Dept> getAllDept();


}
