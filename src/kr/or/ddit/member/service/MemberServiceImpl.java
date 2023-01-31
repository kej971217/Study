package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDAO dao;
	private static MemberServiceImpl service;
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
	}
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public List<MemberVO> memberList() {
		
		return dao.memberList() ;
	}
	@Override
	public List<MemberVO> memberDetail() {
		
		return dao.memberList() ;
	}
	@Override
	public int memberInsert(MemberVO memberVO) {
		
		return dao.memberInsert(memberVO) ;
	}
	@Override
	public int memberUpdate(MemberVO memberVO) {
		
		return dao.memberUpdate(memberVO) ;
	}

}
