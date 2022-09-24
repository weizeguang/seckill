package com.wzg.mapper;

import com.wzg.model.Goods;

import java.util.List;

public interface GoodsMapper {

    List<Goods> getAllGoods();

    Goods getGoodsByGoodsId(String goodsId);
}
