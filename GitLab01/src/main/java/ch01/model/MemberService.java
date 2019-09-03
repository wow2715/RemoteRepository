package ch01.model;

import java.util.List;

public interface MemberService {

	boolean isDup(String id);

	int save(MemberBean mb);

	List<MemberBean> getAllMembers();

	MemberBean getMember(int pk);

	int deleteMember(int ipk);

	int updateMember(MemberBean mb);

}