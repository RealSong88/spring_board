package com.mycompany.dao;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mycompany.service.MemberService;
import com.mycompany.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject MemberDAO dao;
	
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}
}
