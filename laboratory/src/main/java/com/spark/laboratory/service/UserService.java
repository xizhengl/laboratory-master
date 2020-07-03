package com.spark.laboratory.service;

import com.spark.laboratory.pojo.User;
import org.springframework.stereotype.Service;

/**
 * 用户业务层接口
 * @author lixizheng
 */
@Service
public interface UserService {

    /**
     * 登录
     * @param username 用户账号
     * @param password 用户密码
     * @return 用户实体
     */
    User login(String username, String password);

    /**
     * 查询用户名是否存在
     * @param userName 用户名
     * @return boolean
     */
    boolean queryUsernameIsExist(String userName);

    /**
     * 保存用户
     * @param user 用户
     */
    void saveUser(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @param md5Str 用户密码
     * @return user
     */
    User queryUserForLogin(String username, String md5Str);
}
