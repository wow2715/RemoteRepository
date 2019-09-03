package ch01.dao;

import java.util.List;

import ch01.model.MemberBean;

public interface MemberDao {

	boolean isDup(String id);

	int save(MemberBean mb);

	List<MemberBean> getAllMembers();

	MemberBean getMember(int pk);

	int deleteMember(int pk);

	int updateMember(MemberBean mb);

}