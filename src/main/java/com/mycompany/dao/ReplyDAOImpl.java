package com.mycompany.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mycompany.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{

	@Inject SqlSession sql;

	// 댓글조회
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return sql.selectList("replyMapper.readReply", bno);
	}
	
}
