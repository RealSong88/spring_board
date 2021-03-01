package com.mycompany.dao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mycompany.service.BoardService;
import com.mycompany.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;

	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}
	
}
