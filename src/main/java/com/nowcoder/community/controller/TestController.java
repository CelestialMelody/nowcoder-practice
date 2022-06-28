package com.nowcoder.community.controller;

import com.nowcoder.community.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = "/hello")
    // need 不然不知道返回字符串
    @ResponseBody
    public String SayHello() {
        return "Hello, SpringBoot!";
    }

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/testDI")
    @ResponseBody
    public String testDI() {
        return testService.getSelect();
    }
}
