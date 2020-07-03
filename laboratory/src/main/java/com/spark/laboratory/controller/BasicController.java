package com.spark.laboratory.controller;

import com.spark.laboratory.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *  基础常量定义类
 * @author Administrator
 */
@RestController
public class BasicController {

    @Autowired
    public RedisOperator redis;

    public final static String SESSION_KEY = "user";

    /**
     * redis 用户session key命名
     */
    public static final String USER_REDIS_SESSION = "user-redis-session";

    public static final String FILE_SPACE = "F:\\fengli_videos_dev";

    /**
     *  每页分页的记录数
      */
    public static final Integer PAGE_SIZE = 5;

}
