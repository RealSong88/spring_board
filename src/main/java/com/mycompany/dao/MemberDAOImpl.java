package com.mycompany.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mycompany.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject SqlSession sql;

	// 회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		sql.insert("memberMapper.register", vo);
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sql.selectOne("memberMapper.login", vo);
	}

	// 회원정보 수정
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		// vo에 담긴 파라미터들은 memberMapper.xml에 memberMapper라는 Namespcae에
		// 아이디가 memberUpdate인 쿼리에 파라미터를 넣어준다.
		sql.update("memberMapper.memberUpdate", vo);
	}

	// 회원탈퇴
	@Override
	public void memberDelete(MemberVO vo) throws Exception {
		sql.delete("memberMapper.memberDelete", vo);
	}
	
	// 패스워드 체크
	@Override
	public int passChk(MemberVO vo) throws Exception {
		int result = sql.selectOne("memberMapper.passChk", vo);
		return result;
	}
}
