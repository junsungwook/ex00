package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.MessageVO;
import org.zerock.mapper.MessageMapper;
import org.zerock.mapper.PointMapper;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageMapper mapper;
	@Autowired
	private PointMapper pmapper;
	
	@Transactional
	@Override
	public void addMessage(MessageVO vo) {
		mapper.create(vo);
		pmapper.updatePoint(10,vo.getSender());
		
	}

	@Override
	public MessageVO readMessage(String userid, int mno) {
		// TODO Auto-generated method stub
		return null;
	}

}
