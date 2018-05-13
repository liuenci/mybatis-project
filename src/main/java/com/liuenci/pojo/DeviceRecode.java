package com.liuenci.pojo;

import java.util.List;

public class DeviceRecode {
    private String code;
    private String name;

    private List<DeviceIn>deviceIns;

    public DeviceRecode(String code, String name, List<DeviceIn> deviceIns) {
        this.code = code;
        this.name = name;
        this.deviceIns = deviceIns;
    }

    public DeviceRecode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeviceIn> getDeviceIns() {
        return deviceIns;
    }

    public void setDeviceIns(List<DeviceIn> deviceIns) {
        this.deviceIns = deviceIns;
    }

    @Override
    public String toString() {
        return "DeviceRecode{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", deviceIns=" + deviceIns +
                '}';
    }
}
