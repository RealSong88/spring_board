package com.mycompany.dao;

import java.util.List;

import com.mycompany.vo.ReplyVO;

public interface ReplyDAO {

	//댓글조회
	public List<ReplyVO> readReply(int bno) throws Exception;
}