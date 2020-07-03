package com.spark.laboratory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *  Spring Boot 项目启动类
 * @date 202/06/29
 * @author lxizheng
 */

@MapperScan("com.spark.laboratory.mapper")
@ComponentScan(basePackages = {"com.spark.laboratory.*"})
@SpringBootApplication
public class LaboratoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaboratoryApplication.class, args);
    }

}
