package com.qunar.tools.flight.tools.controller;

import com.qunar.tools.flight.tools.properties.Self;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by jiabin.niu on 2018.11.13 21:47
 */
@RestController
public class HelloController {

    @Resource
    private Self self;

    @RequestMapping("/hello")
    public String index() {
        System.out.println("-------------123111a111abbbaa11111222111111111111111111" + self.getName());
        return "Hello World";
    }
}