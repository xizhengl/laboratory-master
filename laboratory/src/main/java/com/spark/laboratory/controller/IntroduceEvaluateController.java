package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceEvaluateController {

    @RequestMapping("/introduce-evaluate.html")
    public String IntroduceEvaluate_1(){
        return "introduce-evaluate";
    }

    @RequestMapping("/introduce-evaluate")
    public String IntroduceEvaluate_2(){
        return "introduce-evaluate";
    }
}
