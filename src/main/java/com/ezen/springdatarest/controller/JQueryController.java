package com.ezen.springdatarest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JQueryController {
	@GetMapping("/jquery/")
	public String home() {
		return "/jqueryHome";
	}
}
