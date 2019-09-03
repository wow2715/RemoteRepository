package ch01.model.impl;

import java.util.List;

import ch01.dao.MemberDao;
import ch01.dao.impl.MemberJDBCDaoImpl;
import ch01.model.MemberBean;
import ch01.model.MemberService;

public class MemberServiceImpl implements MemberService {

	@Override
	public boolean isDup(String id) {
		MemberDao dao = new MemberJDBCDaoImpl();
		return dao.isDup(id);
	}

	@Override
	public int save(MemberBean mb) {
		MemberDao dao = new MemberJDBCDaoImpl();
		return dao.save(mb);
	}

	@Override
	public List<MemberBean> getAllMembers() {
		MemberDao dao = new MemberJDBCDaoImpl();
		return dao.getAllMembers();
	}

	@Override
	public MemberBean getMember(int pk) {
		MemberDao dao = new MemberJDBCDaoImpl();
		return dao.getMember(pk);
	}

	@Override
	public int deleteMember(int ipk) {
		MemberDao dao = new MemberJDBCDaoImpl();
		return dao.deleteMember(ipk);
	}

	@Override
	public int updateMember(MemberBean mb) {
		MemberDao dao = new MemberJDBCDaoImpl();
		return dao.updateMember(mb);
	}

}
