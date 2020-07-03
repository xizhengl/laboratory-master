package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceViewerPdfPropertyController {

    @RequestMapping("/introduce-viewer-pdf-property.html")
    public String introduceViewerPdfProperty_1(){
        return "introduce-viewer-pdf-property";
    }

    @RequestMapping("/introduce-viewer-pdf-property")
    public String introduceViewerPdfProperty(){
        return "introduce-viewer-pdf-property";
    }
}
