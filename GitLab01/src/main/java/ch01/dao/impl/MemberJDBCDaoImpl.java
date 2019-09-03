package ch01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch01.dao.MemberDao;
import ch01.model.MemberBean;

//實作介面或繼承父類別,程式使用時直接寫父類別/介面名稱
public class MemberJDBCDaoImpl implements MemberDao  {
	String resource = "java:comp/env/jdbc/memberDB";

	@Override
	public boolean isDup(String id) {
		boolean result = false;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			
			String sql = "SELECT * FROM Member where id = ?";
			try (
				Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
			) {
				pstmt.setString(1, id);
				try (ResultSet rs = pstmt.executeQuery();) 
				{
					if (rs.next()) {
						result = true;
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public int save(MemberBean mb) {
		int count = 0;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			
			String sql = "INSERT INTO Member VALUES(?, ?, ?)";
			try (
				Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
			) {
				pstmt.setString(1, mb.getId());
				pstmt.setString(2, mb.getPswd());
				pstmt.setString(3, mb.getName());
				count = pstmt.executeUpdate(); 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}

	@Override
	public List<MemberBean> getAllMembers() {
		List<MemberBean> list = new ArrayList<>();
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			
			String sql = "SELECT * FROM Member";
			try (
				Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();	
			) {
				while (rs.next()) {
					MemberBean mb = new MemberBean(
							rs.getInt(1),
							rs.getString(2), 
							rs.getString(3), 
							rs.getString(4)
					);
					list.add(mb);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberBean getMember(int pk) {
		MemberBean mb = null;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			
			String sql = "SELECT * FROM Member where pk = ?";
			try (
					Connection con = ds.getConnection(); 
					PreparedStatement pstmt = con.prepareStatement(sql);
				) {
					pstmt.setInt(1, pk);
					try (ResultSet rs = pstmt.executeQuery();) 
					{
						if (rs.next()) {
							mb = new MemberBean(
									rs.getInt(1),
									rs.getString(2), 
									rs.getString(3), 
									rs.getString(4)
							);
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mb;
	}

	@Override
	public int deleteMember(int pk) {
		
		int count = 0;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			
			String sql = "DELETE FROM Member WHERE pk = ?";
			try (
				Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
			) {
				pstmt.setInt(1, pk);
				count = pstmt.executeUpdate(); 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateMember(MemberBean mb) {
		int count = 0;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			
			String sql = "UPDATE Member SET id=?, pswd=?, name=? WHERE pk = ?";
			try (
				Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
			) {
				pstmt.setString(1, mb.getId());
				pstmt.setString(2, mb.getPswd());
				pstmt.setString(3, mb.getName());
				pstmt.setInt(4, mb.getPk());
				count = pstmt.executeUpdate(); 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return count;
	}
}
