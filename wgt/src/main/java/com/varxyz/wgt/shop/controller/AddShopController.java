package com.varxyz.wgt.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.varxyz.wgt.shop.domain.Menu;
import com.varxyz.wgt.shop.domain.Shop;
import com.varxyz.wgt.shop.service.ShopService;
import com.varxyz.wgt.shop.service.ShopServiceImpl;

@Controller
public class AddShopController {
	Menu menu = new Menu();
	Shop shop = new Shop();
	List<Menu> menuList = new ArrayList<>();
	
	// 첫번째 폼
	@GetMapping("/add_shop")
	public String addShopGo() {
		return "shop/addShop";
	}
	
	// 첫번째 폼 작성 후 두번째 폼 이동
	@PostMapping("/add_shop2")
	public String addShop2Form(@RequestParam("bns_num") String bnsNum,
							   @RequestParam("shop_name") String shopName,
							   @RequestParam("shop_address") String shopAddress, HttpSession session){
		shop.setShopBusinessNum(bnsNum);
		shop.setShopName(shopName);
		shop.setShopAddress(shopAddress);
		
		return "shop/addShop2";
	}
	
	// 두번째 폼 작성 후 세번째 폼 이동
	@PostMapping("/add_shop3")
	public String addShop3Form(@RequestParam("shop_hour") String shopHour,
							   @RequestParam("shop_table") String shopTables,
							   @RequestParam("shop_max_people") String shopMaxPeople, HttpSession session) {
		shop.setShopHours(shopHour);
		shop.setShopTables(shopTables);
		shop.setShopMaxPeople(shopMaxPeople);
		return "shop/addShop3";
	}
	
	//3번째 폼 작성 후 4번째 폼 이동 이 폼에서는 가게의 사진을 업로드하는 과정이 이루어짐
	@PostMapping("/add_shop4")
	public String addShop4Form(@RequestParam("shop_img") MultipartFile file, Model model) {
		
		
		String fileRealName = file.getOriginalFilename(); // 실제 파일 명을 알수있는 메소드
		long size = file.getSize(); // 파일 사이즈
		
		// 사용자가 이미지를 업로드 하지 않았을 경우 예외 처리
		if (fileRealName == null || fileRealName.length() == 0) {
			
			shop.setShopImg("default");
			model.addAttribute("msg","사진이 기본 사진으로 설정 되었습니다.");
			model.addAttribute("url","add_shop4");
			return "alert/alert";
			
		}
		
		System.out.println("파일명 : " + fileRealName);
		System.out.println("용량 크기(byte) : " + size);
		//서버에 저장할 파일이름 fileextension으로 .jsp이런식의  확장자 명을 구함
		
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		
		// resources에 temp 폴더 절대 경로 입력 String uploadFolder = "";  
		// 점주가 등록 취소 할 수 있기때문에 우선은 temp폴더에 임시 저장
		String uploadFolder = "C:\\Hbackend\\Where-are-you-going-today\\wgt\\src\\main\\webapp\\resources\\temp";
		
		/*
		  파일 업로드시 파일명이 동일한 파일이 이미 존재할 수도 있고 사용자가 
		  업로드 하는 파일명이 언어 이외의 언어로 되어있을 수 있다. 
		  타인어를 지원하지 않는 환경에서는 정산 동작이 되지 않습니다.(리눅스가 대표적인 예시)
		  고유한 랜던 문자를 통해 db와 서버에 저장할 파일명을 새롭게 만들어 준다.
		 */
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유 문자열 : " + uniqueName );
		shop.setShopImg(uniqueName);
		System.out.println("확장자명 : " + fileExtension);
		// File saveFile = new File(uploadFolder+"\\"+fileRealName); uuid 적용 전
		File saveFile = new File(uploadFolder + "\\" + uniqueName + fileExtension); // 적용 후
		
		try {
			file.transferTo(saveFile); // 실제 파일 저장메소드(filewriter 작업을 손쉽게 한방에 처리해준다.
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return "shop/addShop4";
	}
	
	@GetMapping("/add_shop4")
	public String addShop4Go() {
		return "shop/addShop4";
	}
	
	@PostMapping("/add_shop5")
	public String addShop5Form(@RequestParam("menu_img") MultipartFile file,
							   @RequestParam("menu_name") String menuName,
							   @RequestParam("menu_price") int menuPrice,
							   @RequestParam("menu_intro") String menuIntro,
							   Model model) {
		menu.setMenuName(menuName);
		menu.setMenuPrice(menuPrice);
		menu.setMenuIntro(menuIntro);
		menu.setBusinessNumber(shop.getShopBusinessNum());
		
		String fileRealName = file.getOriginalFilename(); // 실제 파일 명을 알수있는 메소드
		long size = file.getSize(); // 파일 사이즈
		
		// 사용자가 이미지를 업로드 하지 않았을 경우 예외 처리
		if (fileRealName == null || fileRealName.length() == 0) {
			
			menu.setMenuImg("default");
			menuList.add(menu);
			model.addAttribute("msg","메뉴 사진을 등록해주세요!");
			model.addAttribute("url","add_shop4");
			return "alert/alert";
		}
		
		System.out.println("파일명 : " + fileRealName);
		System.out.println("용량 크기(byte) : " + size);
		//서버에 저장할 파일이름 fileextension으로 .jsp이런식의  확장자 명을 구함
		
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		
		// resources에 temp 폴더 절대 경로 입력 String uploadFolder = "";  
		// 점주가 등록 취소 할 수 있기때문에 우선은 temp폴더에 임시 저장
		String uploadFolder = "C:\\Hbackend\\Where-are-you-going-today\\wgt\\src\\main\\webapp\\resources\\temp";
		
		/*
		  파일 업로드시 파일명이 동일한 파일이 이미 존재할 수도 있고 사용자가 
		  업로드 하는 파일명이 언어 이외의 언어로 되어있을 수 있다. 
		  타인어를 지원하지 않는 환경에서는 정산 동작이 되지 않습니다.(리눅스가 대표적인 예시)
		  고유한 랜던 문자를 통해 db와 서버에 저장할 파일명을 새롭게 만들어 준다.
		 */
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		System.out.println("생성된 고유 문자열 : " + uniqueName );
		menu.setMenuImg(uniqueName);
		System.out.println("확장자명 : " + fileExtension);
		// File saveFile = new File(uploadFolder+"\\"+fileRealName); uuid 적용 전
		File saveFile = new File(uploadFolder + "\\" + uniqueName + fileExtension); // 적용 후
		
		try {
			file.transferTo(saveFile); // 실제 파일 저장메소드(filewriter 작업을 손쉽게 한방에 처리해준다.
		}catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		if (menuList.size() == 10) {
			shop.setMenuList(menuList);
			ShopService service = new ShopServiceImpl();
			service.addShop(shop);
			service.addMenu(menu);
			
			return "shop/addShop5";
		}else {
			menuList.add(menu);
			model.addAttribute("menuListSize", menuList.size());
		}
		
		return "shop/addShop4";
		
	}
	
	@GetMapping("add_shop5")
	public String addShop5Go() {
		return "shop/addShop5";
	}
 }
