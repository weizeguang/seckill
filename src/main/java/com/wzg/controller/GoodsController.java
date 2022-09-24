package com.wzg.controller;

import com.wzg.service.GoodsService;
import com.wzg.vo.GoodsDetailVo;
import com.wzg.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/")
    public String list(Model model){
        List<GoodsVo> goodsList = goodsService.getAllGoods();
        System.out.println(goodsList);
        model.addAttribute("goodsList",goodsList);
        return "list";
    }

    @GetMapping("/goodsDetail/{goodsId}")
    public String goodsDetail(@PathVariable("goodsId") String goodsId,Model model){
        GoodsDetailVo goodsDetailVo = goodsService.getGoodsByGoodsId(goodsId);
        model.addAttribute("goodsDetailVo",goodsDetailVo);
        Date startTime = goodsDetailVo.getStartTime();
        Date endTime = goodsDetailVo.getEndTime();
        Date nowTime = new Date();
        //判断秒杀的状态
        int status;
        //未开始的状态下，倒计时的秒数
        int remainSeconds = -1;
        if (nowTime.before(startTime)){
            //秒杀未开始
            status = 0;
            remainSeconds = (int)((startTime.getTime() - nowTime.getTime())/1000);
        }else if (nowTime.after(endTime)){
            //秒杀已结束
            status = 2;
        }else {
            //秒杀进行中
            status = 1;
        }
        model.addAttribute("status",status);
        model.addAttribute("remainSeconds",remainSeconds);
        return "detail";
    }

}
