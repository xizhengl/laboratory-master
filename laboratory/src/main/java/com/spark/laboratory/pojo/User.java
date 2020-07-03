package com.spark.laboratory.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String userName;

    private String userPassword;

    private String userMail;

    private String userPhone;

    private String userNickname;

    private Date createTime;

    private String isDelete;

}