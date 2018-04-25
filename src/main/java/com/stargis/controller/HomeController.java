package com.stargis.controller;/**
 * Created by Chen.YH
 * 2018-04-25 18:42
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author Chen.YH
 * @Date 2018-04-25 18:42
 * @Version 1.0
 **/
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/grilList")
    public String grilList() {
        return "grilList";
    }
}
