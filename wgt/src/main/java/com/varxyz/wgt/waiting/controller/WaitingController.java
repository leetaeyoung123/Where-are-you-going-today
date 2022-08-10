package com.varxyz.wgt.waiting.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.shop.service.ShopService;
import com.varxyz.wgt.shop.service.ShopServiceImpl;
import com.varxyz.wgt.waiting.domain.Waiting;
import com.varxyz.wgt.waiting.service.WaitingService;
import com.varxyz.wgt.waiting.serviceImpl.WaitingServiceImpl;

@Controller("controller.waitingController")
public class WaitingController {

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	WaitingService waitingService = new WaitingServiceImpl();
	ShopService shopService = new ShopServiceImpl();

	@GetMapping("/controller/waiting")
	public String waitingForm(Model model, HttpSession session) {
		List<Waiting> nowWaiting = waitingService.findAllWaiting("시류");
		long count = 0;
		for (int i = 0; i < nowWaiting.size(); i++) {
			count++;
		}
		model.addAttribute("barName", "시류");
		model.addAttribute("nowWaiting", count);
		return "waiting/add_waiting";
	}

	@PostMapping("/controller/waiting")
	public String waiting(Waiting waiting, Model model) {
		waitingService.addWaiting("시류", "sssssg06", waiting.getNum_people());
		return "redirect:/controller/get_waiting"; // 이전페이지로 ㄱㄱ
	}

	@GetMapping("/controller/get_waiting")
	public String getWaitingForm(Model model) {
		// 웨이팅을 하지 않았을 때
		if( waitingService.findWaitingById("sssssg06").get(0).getBarName() == "없음" ) {
			List<Waiting> noWaiting = waitingService.findWaitingById("sssssg06");
			model.addAttribute("frontCount", "0");
			model.addAttribute("allCount", "0");
			model.addAttribute("waiting", noWaiting);
			model.addAttribute("shopTel", "-");
			return "waiting/get_waiting";
		}
		
		//웨이팅 해둔 상태 일때
		List<Waiting> waitingList = waitingService.findAllWaiting(waitingService.findWaitingById("sssssg06").get(0).getBarName());
		long allCount = 0;
		long frontCount = 0;
		
		try {
			Date day1;
			Date day2;
			day2 = format.parse(waitingService.findWaitingById("sssssg06").get(0).getRegDate());
			for (int i = 0; i < waitingList.size(); i++) {
				allCount++; //특정 매장에대한 나 포함 모든 웨이팅 수
				day1 = format.parse(waitingList.get(i).getRegDate());
				int compare = day1.compareTo(day2);
				if( compare < 0) {
					frontCount ++; //내 앞의 웨이팅 수
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("frontCount", frontCount);
		model.addAttribute("allCount", allCount);
		model.addAttribute("waiting", waitingService.findWaitingById("sssssg06"));
		model.addAttribute("shopTel",shopService.findAllByShopName(
				waitingService.findWaitingById("sssssg06").get(0).getBarName()).get(0).getShopTel());
		
		return "waiting/get_waiting";
	}

	@PostMapping("/controller/get_waiting")
	public String getWaiting(Model model) {
		waitingService.deleteWaiting("sssssg06");
		return "waiting/get_waiting";
	}
}
