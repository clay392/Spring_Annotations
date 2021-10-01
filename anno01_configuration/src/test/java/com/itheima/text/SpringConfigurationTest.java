package com.itheima.text;


import config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  测试Configuration注解
 */
public class SpringConfigurationTest {

    @Test
    public void test(){
        //传入要扫描包的方式
        //1、创建容器
        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        //2、获取对象
        //SpringConfiguration springConfiguration = ac.getBean(SpringConfiguration.class);
        //3、输出结果
        //System.out.println(springConfiguration);


        //传入被注解的类的字节码的方式
        //1、创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、获取对象
        SpringConfiguration springConfiguration = ac.getBean(SpringConfiguration.class);
        //3、输出结果
        System.out.println(springConfiguration);
    }
}
