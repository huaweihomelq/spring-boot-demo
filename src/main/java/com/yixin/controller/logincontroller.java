package com.yixin.controller;

import com.yixin.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yixin.service.IUserService;

/**
 * Created by guohuawei on 2017/10/17.
 */
@RestController
public class logincontroller {
    @Autowired
    private IUserService _iUserService;

    @RequestMapping("/login/index")
    public String say(){return "hallo login!";}

    /***
     * 获取用户信息
     * @param id
     * @return
     */
    @RequestMapping("/login/{id}")
    public UserEntity get(@PathVariable long id){
        UserEntity user = _iUserService.GetUser(id);
        return  user;
    }
}
