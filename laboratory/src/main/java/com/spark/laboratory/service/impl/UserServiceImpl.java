package com.spark.laboratory.service.impl;

import com.spark.laboratory.mapper.UserMapper;
import com.spark.laboratory.pojo.User;
import com.spark.laboratory.pojo.UserExample;
import com.spark.laboratory.service.UserService;
import com.spark.laboratory.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        String md5Str = "";
        try {
             md5Str = MD5Utils.getMD5Str(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        UserExample userExample = new UserExample();
        // 去除重复，boolean型，true为选择不重复的记录。
        userExample.setDistinct(true);
        UserExample.Criteria criteria = new UserExample().createCriteria();
        criteria.andUserNameEqualTo(md5Str);
        criteria.andUserPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        System.out.println(users);
        if (users.size() >= 1){
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    public boolean queryUsernameIsExist(String userName) {
        User user = userMapper.selectByUserName(userName);
        return user != null;
    }

    @Override
    public void saveUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public User queryUserForLogin(String username, String md5Str) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        criteria.andUserPasswordEqualTo(md5Str);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() >= 1){
            return users.get(0);
        }
        return null;
    }

}
