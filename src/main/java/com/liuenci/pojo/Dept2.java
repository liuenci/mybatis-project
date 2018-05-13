package com.liuenci.pojo;

public class Dept2 {
    private Integer deptno;
    private String dname;
    private Integer number;

    public Dept2() {
    }

    public Dept2(Integer deptno, String dname, Integer number) {
        this.deptno = deptno;
        this.dname = dname;
        this.number = number;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Dept2{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", number=" + number +
                '}';
    }
}
