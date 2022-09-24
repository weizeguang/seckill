package com.wzg.vo;

import lombok.Data;

/**
 * vo对象为什么要存在？
 * 为了区分数据库表结构 和 页面的展示数据结构
 * vo可能随着需求的变化而变化
 * 但数据库的表结构不会轻易变化
 *
 */
@Data
public class GoodsVo {

    private String goodsId;
    private String goodsName;
    private String goodsType;
    private Double price;
    private String imgPath;
    private Double secKillPrice;
    private Integer stockNum;

}
