package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceStepController {

    @RequestMapping("/introduce-step.html")
    public String introduceStep_1(){
        return "introduce-step";
    }

    @RequestMapping("/introduce-step")
    public String introduceStep_2(){
        return "introduce-step";
    }
}
