package com.wzg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    private Long id;
    private String goods_id;
    private String goods_name;
    private String goods_type;
    private Double price;
    private String img_path;
}
