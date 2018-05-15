package com.liuenci.third;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {

    List<DeptEmp> testIf(@Param("empno") Integer empno, @Param("ename") String ename);

    List<DeptEmp> testTrim(@Param("ename") String ename,@Param("job") String job);

    List<DeptEmp> testChooseWhen(@Param("ename") String ename,@Param("job") String job);

    List<DeptEmp> testForeachList(List<Integer> deptnos);

    List<DeptEmp> testForeachArray(@Param("ids") Integer[] ids);
}
