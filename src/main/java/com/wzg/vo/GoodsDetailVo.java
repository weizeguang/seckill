package com.wzg.vo;

import lombok.Data;

import java.util.Date;

/**
 * 商品详情
 */
@Data
public class GoodsDetailVo {

    private String goodsName;
    private String goodsId;
    private String imgPath;
    private Double price;
    private Double secKillPrice;
    private Integer stockNum;
    private Date startTime;
    private Date endTime;
}
