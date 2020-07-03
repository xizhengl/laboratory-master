package com.spark.laboratory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceTeacherTeamController {

    @RequestMapping("/introduce-teacher-team.html")
    public String introduceTeacherTeam_1(){
        return "introduce-teacher-team";
    }

    @RequestMapping("/introduce-teacher-team")
    public String introduceTeacherTeam_2(){
        return "introduce-teacher-team";
    }
}
