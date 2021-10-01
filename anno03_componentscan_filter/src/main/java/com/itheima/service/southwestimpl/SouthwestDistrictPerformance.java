package com.itheima.service.southwestimpl;

import com.itheima.annotations.District;
import com.itheima.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 *  西南区绩效计算的具体实现
 */
@Service("districtPerformance")
@District("southwest")
public class SouthwestDistrictPerformance implements DistrictPerformance {

    @Override
    public void calcPerformance(String type) {
        if ("SUV".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"绩效是3");
        }else if ("CAR".equalsIgnoreCase(type)){
            System.out.println("西南区"+type+"绩效是5");
        }
    }
}
