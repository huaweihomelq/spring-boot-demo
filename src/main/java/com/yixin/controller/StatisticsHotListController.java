package com.yixin.controller;

import com.yixin.entity.StatisticsHotEntity;
import com.yixin.service.IStatisticsHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import io.swagger.annotations.*;

/**
 * 热门统计数据
 * Created by guohuawei on 2017/10/25.
 */
@RestController
public class StatisticsHotListController {

    @Autowired
    private IStatisticsHotService iStatisticsHotService;

    /***
     * 热门统计品牌数据
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/statistics/index", method = RequestMethod.GET)
    public List<StatisticsHotEntity> Index(){
        return iStatisticsHotService.getStatisticsHotList();
    }
}
