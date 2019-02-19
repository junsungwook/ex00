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
	//������ �̸��� �޴� �̸��� �ٸ� �� RequestParam�� ���ش�
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
	//��ü�� �ڵ����� ex04�� �Ѿ���� page�� �Ѿ�� ���� ( �ش�Ǵ� ��ü�� �ƴ϶�)
	//�ѱ���� ��ü�� ��ų� model��Ʈ����Ʈ �ؼ� �ѱ���
	public String ex04(SampleDTO dto, int page) {
		logger.info("" + dto);
		logger.info("page : " + page);
		return "ex04";
	}
	@GetMapping("/ex041")
	//page�� �ڵ����� �ȳѾ� ���� �̷��� �Ѱ���� �Ѵ�
	public String ex041(SampleDTO dto,@ModelAttribute("page")int page) {
		logger.info("" + dto);
		logger.info("page : " + page);
		return "ex04";
	}
	
	//responsebody�� ���� ���ϰ��� jsp�� �̸��� �ƴ϶� �ѱ�� ���� ��ü�� �����Ѵٰ� �����ϴ� ��
	@GetMapping("/ex06")
	@ResponseBody
	public SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(20);
		dto.setName("ȫ�浿");
		return dto;
	}
	
	@GetMapping("/ex07")
	//������� ������ ���� �� �߰��ϰ� ���� �� ���°� ResponseEntity<String>�� header�� type�̳� �� �ѱ�ó�� �����ų� �̷���
	public ResponseEntity<String> ex07() {
		logger.info("/ex07..............");
		String msg = "{\"name\" : \"ȫ�浿\"}";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type","application/json;charset=UTF-8");
		return new ResponseEntity<>(msg,header,HttpStatus.OK);
	}
}

