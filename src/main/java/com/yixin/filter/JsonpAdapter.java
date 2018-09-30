package com.yixin.filter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by guohuawei on 2017/10/19.
 */
@ControllerAdvice(basePackages = {"com.yixin.controller"})
public class JsonpAdapter extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdapter(){
        super("_callback","jsonp");
    }
}
