package com.mycompany.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mycompany.vo.BoardVO;

@Repository
public class BoardImpl implements BoardDAO{

	@Inject
	private SqlSession sqlSession;

	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);
	}
	
}