package com.stargis.controller;

import com.stargis.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Admin on 2017-04-07.
 */
@RestController
@RequestMapping("/helloBoot")
public class Hello2Controller {
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private int age;
    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;
    @RequestMapping(value = "/say",method = RequestMethod.POST)
    public String say(){
        return "Hello Spring Boot! -- "+girlProperties.getCupSize()+"====" +content+"......" + cupSize + "-" + age;
       // return "index";
    }
    @RequestMapping(value = "/{id}/say",method = RequestMethod.GET)
    public String sayId(@PathVariable("id") Integer id){
        return "id:" + id;
    }
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String sayId2(@RequestParam("id") Integer mId){
        return "id:" + mId;
    }
    @RequestMapping(value = "/sayId",method = RequestMethod.GET)
    public String sayId3(@RequestParam(value = "id",required=false,defaultValue = "0") Integer mId){
        return "id:" + mId;
    }
    @GetMapping(value = "sayId2")
    public String sayId4(@RequestParam(value = "id",required=false,defaultValue = "0") Integer mId){
        return "id:" + mId;
    }
}
