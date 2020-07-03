package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CastingWebController {

    @ResponseBody
    @PostMapping("/CastingWeb/test")
    public void test(String name){
        System.out.println(name);
    }
}
