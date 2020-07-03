package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author lixizheng
 */
@Controller
public class IndexController {

    @GetMapping(value = "/index")
    public String indexOne(){
        return "index";
    }

    @GetMapping(value = "/index.html")
    public String indexTwo(){
        return "index";
    }
}
