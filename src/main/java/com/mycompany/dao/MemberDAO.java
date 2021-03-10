package com.mycompany.dao;

import com.mycompany.vo.MemberVO;

public interface MemberDAO {

	// 회원가입
	public void register(MemberVO vo) throws Exception;
}
