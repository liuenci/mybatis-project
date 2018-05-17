package com.liuenci.exercise_third;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    List<Emp> select(@Param("ename") String ename, @Param("job") String job, @Param("sal") Double sal, @Param("hiredate") String hiredate);

    List<Emp> selectLimit();
}
