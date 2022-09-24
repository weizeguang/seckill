package com.wzg.service.impl;

import com.wzg.mapper.GoodsMapper;
import com.wzg.mapper.SecKillGoodsMapper;
import com.wzg.model.Goods;
import com.wzg.model.SecKillGoods;
import com.wzg.service.GoodsService;
import com.wzg.vo.GoodsDetailVo;
import com.wzg.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SecKillGoodsMapper secKillGoodsMapper;

    @Override
    public List<GoodsVo> getAllGoods() {
        List<Goods> goodsList = goodsMapper.getAllGoods();
        List<GoodsVo> result = new ArrayList<>();
        for (Goods goods : goodsList) {
            SecKillGoods secKillGoods = secKillGoodsMapper.getSecKillGoodsByGoodsId(goods.getGoods_id());
            GoodsVo goodsVo = new GoodsVo();
            goodsVo.setGoodsId(goods.getGoods_id());
            goodsVo.setGoodsName(goods.getGoods_name());
            goodsVo.setGoodsType(goods.getGoods_type());
            goodsVo.setPrice(goods.getPrice());
            goodsVo.setImgPath(goods.getImg_path());
            goodsVo.setSecKillPrice(secKillGoods.getSecKill_price());
            goodsVo.setStockNum(secKillGoods.getStock_num());
            result.add(goodsVo);
        }
        return result;
    }

    @Override
    public GoodsDetailVo getGoodsByGoodsId(String goodsId) {
        Goods goods = goodsMapper.getGoodsByGoodsId(goodsId);
        SecKillGoods secKillGoods = secKillGoodsMapper.getSecKillGoodsByGoodsId(goodsId);
        GoodsDetailVo goodsDetailVo = new GoodsDetailVo();
        goodsDetailVo.setGoodsName(goods.getGoods_name());
        goodsDetailVo.setGoodsId(goods.getGoods_id());
        goodsDetailVo.setImgPath(goods.getImg_path());
        goodsDetailVo.setPrice(goods.getPrice());
        goodsDetailVo.setSecKillPrice(secKillGoods.getSecKill_price());
        goodsDetailVo.setStockNum(secKillGoods.getStock_num());
        goodsDetailVo.setStartTime(secKillGoods.getStart_time());
        goodsDetailVo.setEndTime(secKillGoods.getEnd_time());
        return goodsDetailVo;
    }
}
