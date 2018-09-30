package com.yixin.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by guohuawei on 2017/10/25.
 */
public class StatisticsHotEntity {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpell() {
        return Spell;
    }

    public void setSpell(String spell) {
        Spell = spell;
    }

    public Date getCreateTime() { return CreateTime; }

    public void setCreateTime(Date createTime) { CreateTime = createTime; }

    /*
    主键，隐藏
     */
    @JSONField(serialize = false)
    private int id;
    /*
    品牌名称
     */
    @JSONField(name = "BrandName")
    private String Name;
    /*
    品牌别名
     */
    @JSONField(name = "alias")
    private String Spell;
    /*
    数据创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date CreateTime;

}
