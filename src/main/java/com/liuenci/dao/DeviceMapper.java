package com.liuenci.dao;

import com.liuenci.pojo.BuyerRecode;
import com.liuenci.pojo.DeviceIn;
import com.liuenci.pojo.DeviceRecode;
import com.liuenci.pojo.RecodeSum;

import java.util.List;

public interface DeviceMapper {
    List<DeviceIn> selectDeviceInByDate(String inDate);

    List<DeviceRecode> selectRecodeByDevice(Integer code);

    List<RecodeSum> selectSum(String code);

    List<BuyerRecode> selectBuy(String buyer);
}
