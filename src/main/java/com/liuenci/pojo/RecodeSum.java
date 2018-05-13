package com.liuenci.pojo;

public class RecodeSum {

    private String code;
    private String dsum;

    public RecodeSum() {
    }

    public RecodeSum(String code, String dsum) {
        this.code = code;
        this.dsum = dsum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDsum() {
        return dsum;
    }

    public void setDsum(String dsum) {
        this.dsum = dsum;
    }

    @Override
    public String toString() {
        return "RecodeSum{" +
                "code='" + code + '\'' +
                ", dsum='" + dsum + '\'' +
                '}';
    }
}
