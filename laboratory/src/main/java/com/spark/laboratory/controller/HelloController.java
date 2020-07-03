package com.spark.laboratory.controller;

import com.spark.laboratory.pojo.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Control 测试
 * @author Administrator
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String show(Model model ,HttpSession session, HttpServletRequest request){
        model.addAttribute("uid","123456789");
        model.addAttribute("name","Jerry");
        model.addAttribute("now", new Date());
        model.addAttribute("message", "Welcome to BeiJing!");
        session.setAttribute("user", new UserVO());

        UserVO vo = new UserVO();
//        vo.setUid("99");
//        vo.setName("尼古拉丁.赵四");
//        vo.setAge(16);
//        vo.setSalary(1000.00);
//        vo.setBirthday(new Date());
        model.addAttribute("member", vo);

        Set<String> allNames = new HashSet<>() ;
        List<Integer> allIds = new ArrayList<>() ;
        for (int x = 0 ; x < 5 ; x ++) {
            allNames.add("boot-" + x) ;
            allIds.add(x) ;
        }
        model.addAttribute("names", allNames) ;
        model.addAttribute("ids", allIds) ;
        model.addAttribute("mydate", new Date()) ;

        request.setAttribute("requestMessage", "springboot-request");
        request.getSession().setAttribute("sessionMessage", "springboot-session");
        request.getServletContext().setAttribute("applicationMessage",
                "springboot-application");
        model.addAttribute("url", "www.baidu.cn");
        request.setAttribute("url2",
                "<span style='color:red'>www.baidu.cn</span>");

        return "demo";
    }

}
