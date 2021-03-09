package com.mycompany.service;

import java.util.List;

import com.mycompany.vo.ReplyVO;

public interface ReplyService {

	public List<ReplyVO> readReply(int bno) throws Exception;
	
	public void writeReply(ReplyVO vo) throws Exception;
}
