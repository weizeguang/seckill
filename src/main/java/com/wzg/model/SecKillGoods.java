package com.wzg.model;

import lombok.Data;

import java.util.Date;

@Data
public class SecKillGoods {
    private Long id;
    private String goods_id;
    private Double secKill_price;
    private Integer stock_num;
    private Date start_time;
    private Date end_time;
}
