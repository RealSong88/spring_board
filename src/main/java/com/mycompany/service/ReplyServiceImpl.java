package com.mycompany.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.mycompany.dao.ReplyDAO;
import com.mycompany.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject ReplyDAO dao;

	//댓글 조회
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return dao.readReply(bno);
	}
	
}