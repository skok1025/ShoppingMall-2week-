package com.cafe24.mall.service;

import java.util.List;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.mall.dto.JSONResult;
import com.cafe24.mall.vo.GoodsVo;


@Service
public class MainService {

	public String getGoodsList(int startNo) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		//JSONResult<List<GoodsVo>> result2 = restTemplate.getForObject("http://localhost:8099/ShoppingMall_backend/api/goods/list/"+startNo, JSONResult<List<GoodsVo>>.class);
		String result = restTemplate.getForObject("http://localhost:8099/ShoppingMall_backend/api/goods/list/"+startNo, String.class);
		
		return result;
	}

}
