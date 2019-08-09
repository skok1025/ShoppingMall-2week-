package com.cafe24.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.mall.security.SecurityUser;
import com.cafe24.mall.service.BasketService;
import com.cafe24.mall.vo.BasketVo;

@Controller
@RequestMapping("/basket")
public class BasketController {

	@Autowired
	private BasketService basketService;
	
	@PostMapping("/user/add")
	public String userbasket(
			@ModelAttribute("basketVo") BasketVo basketVo
			,@AuthenticationPrincipal SecurityUser user
	) {
		
		System.out.println("----------------------------");
		System.out.println(basketVo.getGoodsBasketList());
		System.out.println("등록하려 하는 멤버번호: "+user.getNo());
		
		int result = basketService.addBasketManyGoods(user.getNo(),basketVo.getGoodsBasketList());
		
		if(result == 1) {
			return "redirect:/goods/view/"+basketVo.getGoodsNo()+"?addsuccess=yes";
		}
		
		return result+"";
	}

	@ResponseBody
	@PostMapping("/nonuser/add")
	public String nonuserbasket(
			@ModelAttribute("basketVo") BasketVo basketVo
			) {
		
		System.out.println("----------------------------");
		System.out.println(basketVo.getGoodsBasketList());
		
		return "test";
	}
	
}