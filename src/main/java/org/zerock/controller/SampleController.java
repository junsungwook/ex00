package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")


public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		logger.info(""+dto);
		return "ex01";
	}
	@GetMapping("/ex02")
	public String ex02(String name, int age) {
		logger.info("name : "+name);
		logger.info("age : "+age);
		return "ex02";
	}
	@GetMapping("/ex021")
	//보내는 이름과 받는 이름이 다를 떄 RequestParam을 써준다
	public String ex021(@RequestParam("name")String names, @RequestParam("age")int ages) {
		logger.info("name : "+names);
		logger.info("age : "+ages);
		return "ex021";
	}
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")String[] ids) {
		for(int i=0; i<ids.length; i++) {
			logger.info("ids : " + ids[i]);
		}
		return "ex02";
	}
	@GetMapping("/ex04")
	//객체는 자동으로 ex04로 넘어가지만 page는 넘어가지 않음 ( 해당되는 객체가 아니라서)
	//넘기려면 객체에 담거나 model어트리뷰트 해서 넘기자
	public String ex04(SampleDTO dto, int page) {
		logger.info("" + dto);
		logger.info("page : " + page);
		return "ex04";
	}
	@GetMapping("/ex041")
	//page는 자동으로 안넘어 가서 이렇게 넘겨줘야 한다
	public String ex041(SampleDTO dto,@ModelAttribute("page")int page) {
		logger.info("" + dto);
		logger.info("page : " + page);
		return "ex04";
	}
	
	//responsebody를 쓰면 리턴값이 jsp의 이름이 아니라 넘기고 싶은 객체를 리턴한다고 선언하는 것
	@GetMapping("/ex06")
	@ResponseBody
	public SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(20);
		dto.setName("홍길동");
		return dto;
	}
	
	@GetMapping("/ex07")
	//결과말고 정보를 조금 더 추가하고 싶을 때 쓰는게 ResponseEntity<String>다 header에 type이나 뭐 한글처리 같은거나 이런거
	public ResponseEntity<String> ex07() {
		logger.info("/ex07..............");
		String msg = "{\"name\" : \"홍길동\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type","application/json;charset=UTF-8");
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
}

