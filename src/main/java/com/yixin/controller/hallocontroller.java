package com.yixin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by guohuawei on 2017/10/17.
 */
@RestController
public class hallocontroller {
    @RequestMapping("/hallo")
    public String say(){return "hallo java!";}
}
