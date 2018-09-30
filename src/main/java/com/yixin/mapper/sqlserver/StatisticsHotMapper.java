package com.yixin.mapper.sqlserver;

import com.yixin.entity.StatisticsHotEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 热门统计数据
 * Created by guohuawei on 2017/10/25.
 */
@Mapper
public interface StatisticsHotMapper {
    List<StatisticsHotEntity> getStatisticsHotList();
}
