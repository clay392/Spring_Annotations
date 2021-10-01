package com.itheima.test;

import com.itheima.service.DistrictPercentage;
import com.itheima.service.DistrictPerformance;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  测试类
 */
public class SpringFilterTest {

    @Test
    public void test(){
        //1、创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        //2、获取对象
        DistrictPercentage districtPercentage = ac.getBean("districtPercentage",DistrictPercentage.class);
        //3、执行方法
        districtPercentage.salePercentage("SUV");

        //获取对象
        DistrictPerformance districtPerformance = ac.getBean("districtPerformance", DistrictPerformance.class);
        //执行方法
        districtPerformance.calcPerformance("SUV");
    }
}
