package com.varxyz.wgt.waiting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.waiting.domain.Waiting;
import com.varxyz.wgt.waiting.service.WaitingService;
import com.varxyz.wgt.waiting.serviceImpl.WaitingServiceImpl;

@Controller("controller.waitingController")
public class WaitingController {
	
	WaitingService waitingService = new WaitingServiceImpl();

	@GetMapping("/controller/waiting")
	public String waitingForm() {
		return "waiting/add_waiting";
	}
	
	@PostMapping("/controller/waiting")
	public String waiting(Waiting waiting, Model model) {
//		waitingService.addWaiting(waiting.getBarName(), waiting.getUserId(), waiting.getNum_people());
		model.addAttribute("waiting", waiting);
		return "controller/get_waiting";
	}
	
	@GetMapping("/controller/get_waiting")
	public String getWaitingForm() {
		return "waiting/get_waiting";
	}
}
