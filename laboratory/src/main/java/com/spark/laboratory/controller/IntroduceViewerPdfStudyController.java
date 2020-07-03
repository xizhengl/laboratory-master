package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceViewerPdfStudyController {

    @RequestMapping("/introduce-viewer-pdf-study.html")
    public String IntroduceViewerPdfStudy_1(){
        return "introduce-viewer-pdf-study";
    }

    @RequestMapping("/introduce-viewer-pdf-study")
    public String IntroduceViewerPdfStudy_2(){
        return "introduce-viewer-pdf-study";
    }
}
