package com.spark.laboratory.service;

import com.spark.laboratory.pojo.User;
import com.spark.laboratory.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * User 测试类
 * @author lixizheng
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testLogin(){
        User login = userService.login("2425220864", "123456");
        System.out.println(login);
    }
}
