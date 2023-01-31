package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {
	
	public List<MemberVO> memberList();
	
	public List<MemberVO> memberDetail();
	
	public int memberInsert(MemberVO memberVO);
	
	public int memberUpdate(MemberVO memberVO);
	
	
	
}
