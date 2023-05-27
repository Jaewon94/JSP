package member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;
import javax.naming.*;

public class MemberDAO {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public MemberDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.out.println("생성자 예외 : " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch (Exception e) {
		}
	}
	public String test() {
		String banner ="";
		String sql = "select banner from v$version";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				banner = rs.getString("banner");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return banner;
	}
	
	public MemberDTO login(String userId, String userPw) {
		MemberDTO dto = null;
		String sql = "select * from member1 where userId='%s' and userPw='%s'";
		sql = String.format(sql, userId, userPw);
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setAge(rs.getInt("age"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserPw(rs.getString("userPw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public List<MemberDTO> list() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from member1";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setAge(rs.getInt("age"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserName(rs.getString("userName"));
				dto.setUserPw(rs.getString("userPw"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public int join(MemberDTO dto) {
		int result =0;
		String sql = "insert into member1 (userid, userpw, username,email,birth,gender,age) VALUES ('%s','%s','%s','%s','%s','%s',%d)";
		sql = String.format(sql, dto.getUserId(),dto.getUserPw(),dto.getUserName(),dto.getEmail(),dto.getBirth(), dto.getGender(), dto.getAge());
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return result;
	}
	
	public int delete(int idx) {
		int result =0;
		String sql ="delete from member1 where idx=%d";
		sql = String.format(sql, idx);
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
	}
	
	public int modify(int idx,String userPw,String email){
		int result=0;
		String sql="update member1 SET userPw = '%s', email ='%s' where idx = %d";
		sql = String.format(sql, userPw, email, idx);
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return result;
	}
}
