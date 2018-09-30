package com.yixin.service.impl;

import com.yixin.entity.StatisticsHotEntity;
import com.yixin.service.IStatisticsHotService;
import com.yixin.mapper.sqlserver.StatisticsHotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by guohuawei on 2017/10/25.
 */
@Service
public class StatisticsHotService implements IStatisticsHotService {

    @Autowired
    private StatisticsHotMapper statisticsHotMapper;

    public List<StatisticsHotEntity> getStatisticsHotList(){
        List<StatisticsHotEntity> list = statisticsHotMapper.getStatisticsHotList();
        return list;
    }
}
