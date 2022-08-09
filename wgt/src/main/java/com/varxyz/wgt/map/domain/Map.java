package com.varxyz.wgt.map.domain;

import com.varxyz.wgt.shop.domain.Shop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Map {
	Shop shop;
	private String shopNameSearch;
	private String menuSearch;
}
