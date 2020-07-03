package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class introduceController {

    @RequestMapping("/introduce.html")
    public String introduce_1(){
        return "introduce";
    }

    @RequestMapping("/introduce")
    public String introduce_2(){
        return "introduce";
    }
}
