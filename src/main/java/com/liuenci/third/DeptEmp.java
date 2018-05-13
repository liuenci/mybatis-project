package com.liuenci.third;

import com.liuenci.pojo.Emp;

import java.util.List;

public class DeptEmp {
    private Integer deptno;
    private String dname;
    private String loc;

    private List<Emp> empList;

    public DeptEmp() {
    }

    public DeptEmp(Integer deptno, String dname, String loc, List<Emp> empList) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        this.empList = empList;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "DeptEmp{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
