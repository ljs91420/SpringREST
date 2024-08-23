package com.ezen.springdatarest.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.springdatarest.dto.FruitDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/entity")
@RestController
public class ResponseEntityTestController {
	// 응답하는 ResponseEntity의 제네릭은 응답 내용(body)에 들어가는 데이터의 타입을 의미한다.
	@GetMapping("/test1")
	public ResponseEntity<String> test1() {
		// 원하는 응답 인스턴스 생성하기(스태틱 메서드를 활용)
		// 응답은 메서드 체이닝 방식을 통해 생성한다.
		return ResponseEntity.status(200).contentType(MediaType.TEXT_HTML).body("<html><head><meta charset=\"UTF-8\"><title>수제 응답 생성하기</title></head><body><h1>내가 만든 HTML 응답</h1></body></html>");
	}
	
	// jackson-databind가 ResponseEntity의 body 내용도 JSON 형식으로 변환해준다.
	@GetMapping("/test2")
	public ResponseEntity<FruitDTO> test2() {
		FruitDTO fruit = new FruitDTO();
		
		fruit.setFid(33);
		fruit.setFname("천도복숭아");
		fruit.setPrice(3500);
		fruit.setLocation_id(2000);		
		
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(fruit);
	}
	
	@PatchMapping("/test3")
	public ResponseEntity<String> test3(FruitDTO fruitDTO) {
		log.info("fruitDTO={}", fruitDTO);
		
		return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("오케이!");
	}
	
	// jackson-databind로 JSON 데이터가 DTO에 바인딩되기 위해서는 @RequestBody가 필요하다.
	@PutMapping("/test4")
	public ResponseEntity<String> test4(@RequestBody FruitDTO fruitDTO) {
		log.info("fruitDTO={}", fruitDTO);
		
		// 받은 정보를 통해 DB에 업데이트를 진행한 후 결과를 받아왔다고 가정
		boolean updateResult = false;
		
		if (updateResult) {
			return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("테스트 4번 통과!");
		} else {
			return ResponseEntity.status(502).contentType(MediaType.TEXT_PLAIN).body("테스트 4번 실패!");
		}
	}
	
	@GetMapping("/test5")
	public FruitDTO test5(Integer id) {
		log.info("받은 id: {}", id);
		
		FruitDTO fruit = new FruitDTO();
		
		fruit.setFid(110);
		fruit.setFname("메론");
		fruit.setPrice(18000);
		fruit.setLocation_id(3000);		
		
		return fruit;
	}
}
