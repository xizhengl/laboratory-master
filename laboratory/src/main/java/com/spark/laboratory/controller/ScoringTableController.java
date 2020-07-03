package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScoringTableController {

    @RequestMapping("/scoring-table.html")
    public String scoringTable_1(){
        return "scoring-table";
    }

    @RequestMapping("/scoring-table")
    public String scoringTable_2(){
        return "scoring-table";
    }
}
