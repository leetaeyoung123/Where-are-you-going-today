package com.varxyz.wgt.shop.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shop {
	private String shopBusinessNum;
	private String shopName;
	private String shopTel;
	private String shopAddress;
	private String shopHours;
	private String shopTables;
	private String shopMaxPeople;
	private String shopImg;
	private List<Menu> menuList;
}
