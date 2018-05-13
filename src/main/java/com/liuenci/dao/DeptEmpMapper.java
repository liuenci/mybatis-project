package com.liuenci.dao;

import com.liuenci.pojo.Dept1;
import com.liuenci.pojo.EmpBoss;
import com.liuenci.pojo.EmpBossDept;

import java.util.List;
import java.util.Map;

public interface DeptEmpMapper {
    List<Dept1> selectAllDeptAndEmp();
    EmpBoss selectEmpByEmpno(Integer empno);
    EmpBossDept selectEmpBossDeptByEmpno(Integer empno);
    List<Map<Object,Object>> selectDept();
    List<Map<Object,Object>> selectHire();
}
