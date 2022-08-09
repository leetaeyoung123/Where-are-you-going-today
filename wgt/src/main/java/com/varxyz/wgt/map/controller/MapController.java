package com.varxyz.wgt.map.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("controller.mapController")
public class MapController {
	
	@GetMapping("/map/map")
	public String mapForm() {
		return "map/map";
	}
}
