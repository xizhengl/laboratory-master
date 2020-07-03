package com.spark.laboratory.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class UserVO {

    private int id ;
    private String userName ;
    private String userMail ;
    private String userPhone ;
    private Date createTime ;
    private String uniqueToken;
//    private boolean isLogin;
    private String errorInfo;

}
