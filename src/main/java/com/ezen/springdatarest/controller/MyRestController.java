package com.ezen.springdatarest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.springdatarest.dto.FruitDTO;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/rest")
@Slf4j
@RestController
public class MyRestController {
	// produces : 응답 헤더의 content-type을 변경한다.(content-type을 보고 브라우저가 받은 데이터를 어떻게 해석할지 결정)	
	@RequestMapping(value = "/v1", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String value1() {
		return "<h1>Hello, @RestController!</h1>";
	}
	
	@RequestMapping(value = "/v2", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	public String value2() {
		return "<h1>Hello, @RestController!</h1>";
	}
	
	// 빈(Bean) 형태의 객체를 응답하면 해당 객체를 JSON 형식으로 변환하여 응답한다.
	// (jackson-databind 라이브러리의 기능)
	@GetMapping(value = "/v3", produces = "application/json; charset=UTF-8")
	public FruitDTO value3() {
		FruitDTO fruitDTO = new FruitDTO();
		
		fruitDTO.setFid(10);
		fruitDTO.setFname("삼계탕");
		fruitDTO.setLocation_id(1800);
		fruitDTO.setQty(50);
		fruitDTO.setPrice(8800);
		fruitDTO.setExp_date(new Date());
		
		return fruitDTO;
	}
	
	@GetMapping(value = "/v4", produces = MediaType.APPLICATION_XML_VALUE)
	public FruitDTO value4() {
		FruitDTO fruitDTO = new FruitDTO();
		
		fruitDTO.setFid(10);
		fruitDTO.setFname("삼계탕");
		fruitDTO.setLocation_id(1800);
		fruitDTO.setQty(50);
		fruitDTO.setPrice(8800);
		fruitDTO.setExp_date(new Date());
		
		return fruitDTO;
	}
	
	@GetMapping(value = "/v5", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FruitDTO> value5() {
		List<FruitDTO> fruits = new ArrayList<>();
		
		FruitDTO fruit1 = new FruitDTO();
		FruitDTO fruit2 = new FruitDTO();
		
		fruit1.setFid(11);
		fruit1.setFname("순대국");
		fruit1.setLocation_id(1800);
		fruit1.setQty(50);
		fruit1.setPrice(8800);
		fruit1.setExp_date(new Date());
		
		fruit2.setFid(12);
		fruit2.setFname("감자탕");
		fruit2.setLocation_id(1900);
		fruit2.setQty(55);
		fruit2.setPrice(11000);
		fruit2.setExp_date(new Date());
		
		fruits.add(fruit1);
		fruits.add(fruit2);
		fruits.add(fruit1);
		fruits.add(fruit2);
		
		return fruits;
	}
	
	@GetMapping(value = "/v6", produces = MediaType.APPLICATION_XML_VALUE)
	public List<FruitDTO> value6() {
		List<FruitDTO> fruits = new ArrayList<>();
		
		FruitDTO fruit1 = new FruitDTO();
		FruitDTO fruit2 = new FruitDTO();
		
		fruit1.setFid(10);
		fruit1.setFname("삼계탕");
		fruit1.setLocation_id(1800);
		fruit1.setQty(50);
		fruit1.setPrice(8800);
		fruit1.setExp_date(new Date());
		
		fruit2.setFid(12);
		fruit2.setFname("감자탕");
		fruit2.setLocation_id(1900);
		fruit2.setQty(55);
		fruit2.setPrice(11000);
		fruit2.setExp_date(new Date());
		
		fruits.add(fruit1);
		fruits.add(fruit2);
		fruits.add(fruit1);
		fruits.add(fruit2);
		
		return fruits;
	}
}
