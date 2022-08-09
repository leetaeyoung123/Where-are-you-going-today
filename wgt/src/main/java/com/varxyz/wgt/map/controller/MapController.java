package com.varxyz.wgt.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.map.domain.Map;
import com.varxyz.wgt.map.service.MapService;
import com.varxyz.wgt.map.service.MapServiceImpl;

@Controller("controller.mapController")
public class MapController {
	MapService service = new MapServiceImpl();

	@GetMapping("/map/map")
	public String mapForm(Map map,Model model) {
		model.addAttribute("map", map.getAddress());
		System.out.println(map.getAddress());
		return "map/map";
	}
	
	@PostMapping("/map/map")
	public String map(Map map, Model model) {
		model.addAttribute("searchName", service.search(map.getSearchName()));
		System.out.println("1: " + model.addAttribute("searchName", service.search(map.getSearchName())));
		return "map/map";
	}
}
