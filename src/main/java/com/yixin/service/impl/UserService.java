package com.yixin.service.impl;

import com.yixin.entity.UserEntity;
import com.yixin.mapper.financial.FinancialUserMapper;
import com.yixin.mapper.test.TestUserMapper;
import com.yixin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

/**
 * Created by guohuawei on 2017/10/17.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private FinancialUserMapper financialUserMapper;

    @Autowired
    private TestUserMapper testUserMapper;

/*    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;*/

    @Autowired
    @Resource(name = "redisArticleTemplate")
    private StringRedisTemplate temple;

    @Autowired
    @Resource(name = "redisDefaultTemplate")
    private StringRedisTemplate temple2;

    protected final Logger logger = LogManager.getLogger();

    /***
     * 获取用户信息
     * @param id
     * @return
     */
    public UserEntity GetUser(long id){

        String value = (String) temple.opsForValue().get("temple");
        if(value == null || "".equals(value)){
            temple.opsForValue().set("temple","temple");
            temple2.opsForValue().set("temple2","temple2");
        }

        logger.info("这是一个错误提示" + new Date().toString());

        UserEntity financialUser = financialUserMapper.getOne(id);

        UserEntity testUser = testUserMapper.getOne(id);

        return  testUser;
    }
}
