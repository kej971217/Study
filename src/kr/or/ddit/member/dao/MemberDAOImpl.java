package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements IMemberDAO {
	private SqlMapClient smc;
	private static MemberDAOImpl dao;
	private MemberDAOImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
public static MemberDAOImpl getInstance() {
	if(dao == null) dao = new MemberDAOImpl();
	return dao;
}

	@Override
	public List<MemberVO> memberList() {
		List<MemberVO> list = null;
		
		try {
			list = smc.queryForList("mymember.memberList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public List<MemberVO> memberDetail() {
		List<MemberVO> list = null;
		
		try {
			list = smc.queryForList("mymember.memberDetail");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int memberInsert(MemberVO memberVO) {
		int cnt = 0;
		
	try {
		cnt = (int) smc.insert("mymember.memberInsert", memberVO);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return cnt;
	}
	@Override
	public int memberUpdate(MemberVO memberVO) {
		int cnt = 0;
		
		try {
			cnt = (int) smc.update("mymember.memberUpdate", memberVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

}
