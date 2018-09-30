package com.yixin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guohuawei on 2017/10/17.
 */
@RestController
public class testcontroller {
    @RequestMapping("/test/index")
    public String say(){return "hallo test!";}
}
