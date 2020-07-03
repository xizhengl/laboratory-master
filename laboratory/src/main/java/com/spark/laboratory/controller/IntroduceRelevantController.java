package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceRelevantController {

    @RequestMapping("/introduce-relevant.html")
    public String introduceRelevant_1(){
        return "introduce-relevant";
    }

    @RequestMapping("/introduce-relevant")
    public String introduceRelevant_2(){
        return "introduce-relevant";
    }

}
