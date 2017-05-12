package com.stargis.controller;

import com.stargis.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Admin on 2017-04-07.
 */
@Controller
@ResponseBody
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private int age;
    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot! -- "+girlProperties.getCupSize()+"====" +content+"......" + cupSize + "-" + age;
       // return "index";
    }
}
