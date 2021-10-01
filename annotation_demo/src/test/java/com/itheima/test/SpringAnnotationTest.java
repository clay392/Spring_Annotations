package com.itheima.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *  测试spring注解驱动开发的入门案例
 */
public class SpringAnnotationTest {

    @Test
    public void test(){
        //1、创建容器(基于注解的创建方式)
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        //2、根据bean的id获取对象
        JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3、执行操作
        jdbcTemplate.update("insert into account(name,money) values(?,?) ","test",12345);
    }


}
