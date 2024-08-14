package com.ezen.springdatarest.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	// 일반 컨트롤러 내부에서 @ResponseBody를 붙이면 Rest 메서드가 된다.
	@ResponseBody
	@GetMapping(value = "/home/data", produces = "text/plain")
	public String data() {
		return "뷰 페이지 대신 응답하는 데이터";
	}
}
