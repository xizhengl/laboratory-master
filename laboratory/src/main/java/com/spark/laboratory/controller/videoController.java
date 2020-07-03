package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class videoController {

    @RequestMapping("/video.html")
    public String video_1(){
        return "video";
    }

    @RequestMapping("/video")
    public String video_2(){
        return "video";
    }

}
