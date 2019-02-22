package org.zerock.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.MessageVO;
import org.zerock.service.MessageService;


//responsbody + controller의 어노테이션이다 그래서 리턴값이 보낼 주소가 아니라 개체를 보낼 수 있는거
@RestController   
@RequestMapping("/messages/*")
public class MessageController {
	
	//얘도 연결시켜서 새 객체 만들어주는 어노테이션
	@Inject
	MessageService service;
	
	@RequestMapping(value="/",	method=RequestMethod.POST)	
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
		ResponseEntity<String> entity=null;
		try {
			System.out.println("MessageController :" + vo);
			service.addMessage(vo);

			entity=new ResponseEntity<>("success"	,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity=new ResponseEntity<>(e.getMessage()	,HttpStatus.BAD_REQUEST);
		}
		System.out.println(entity);
		return entity;
	}
}

