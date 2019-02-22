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


//responsbody + controller�� ������̼��̴� �׷��� ���ϰ��� ���� �ּҰ� �ƴ϶� ��ü�� ���� �� �ִ°�
@RestController   
@RequestMapping("/messages/*")
public class MessageController {
	
	//�굵 ������Ѽ� �� ��ü ������ִ� ������̼�
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

