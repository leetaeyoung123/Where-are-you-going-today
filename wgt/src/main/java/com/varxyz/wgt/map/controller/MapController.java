package com.varxyz.wgt.map.controller;

import java.util.List;

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
		model.addAttribute("name", service.search(map.getName()));
		return "map/map";
	}
	
	@PostMapping("/map/map")
	public String map(Map map, Model model) {
		model.addAttribute("name", service.search(map.getName()));
		List<Map> a = service.search(map.getName());
		model.addAttribute("addr", a.get(0).getAddress());
		model.addAttribute("autoName", a.get(0).getName());
		return "map/map";
	}
}
