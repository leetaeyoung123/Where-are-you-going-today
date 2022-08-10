package com.varxyz.wgt.waiting.controller;

import javax.servlet.http.HttpSession;

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
	public String waitingForm(Model model, HttpSession session) {
		model.addAttribute("nowWaiting", waitingService.findAllWaiting("시류"));
		System.out.println(session.getAttribute("userId"));
		return "waiting/add_waiting";
	}

	@PostMapping("/controller/waiting")
	public String waiting(Waiting waiting, Model model) {
		// 가게 이름, 사용자ID 세션으로 받아와서 Dao
//		waitingService.addWaiting(waiting.getBarName(), waiting.getUserId(), waiting.getNum_people());
		return "redirect:/controller/get_waiting"; // 이전페이지로 ㄱㄱ
	}

	@GetMapping("/controller/get_waiting")
	public String getWaitingForm(Model model) {
		model.addAttribute("waiting", waitingService.findWaitingById("sssssg06"));
		return "waiting/get_waiting";
	}
	
	@PostMapping("/controller/get_waiting")
	public String getWaiting(Model model) {
		return "waiting/get_waiting";
	}
}
