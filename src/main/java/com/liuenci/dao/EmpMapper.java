package com.liuenci.dao;

import com.liuenci.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    int addNewEmp(Emp emp);

    int updateEmpByEmpno(Emp emp);

    int deleteEmpByEmpno(int empno);

    Emp getEmpByEmpno(int empno);

    List<Emp> getAllEmp();

    List<Emp> getEmpByCondition(@Param("start") Integer start, @Param("end") Integer end);
}
