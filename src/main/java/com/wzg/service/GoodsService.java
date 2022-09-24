package com.wzg.service;

import com.wzg.model.Goods;
import com.wzg.vo.GoodsDetailVo;
import com.wzg.vo.GoodsVo;

import java.util.List;

public interface GoodsService {

    List<GoodsVo> getAllGoods();


    GoodsDetailVo getGoodsByGoodsId(String goodsId);
}
