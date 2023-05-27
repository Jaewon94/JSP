package member1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class MemberDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String url ="jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user ="c##itbank";
	private String password = "it";
	
	private String className = OracleDriver.class.getName();
	
	public MemberDAO() {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
		}
	}
	
	public String test() {
		String banner = "";
		String sql = "select banner from v$version";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				banner = rs.getString("banner");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return banner;
		
	}
	
	public MemberDTO login(String id, String pw) {
		MemberDTO dto = null; 
		String sql = "select * from member1 where userid = '%s' and userpw = '%s'";
		sql = String.format(sql, id, pw);
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserPw(rs.getString("userPw"));
				dto.setUserName(rs.getString("userName"));
				dto.setEmail(rs.getString("email"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getInt("age"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dto;
	}
	
	public List<MemberDTO> selectAll() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from member1";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setIdx(rs.getInt("idx"));
				dto.setUserId(rs.getString("userId"));
				dto.setUserPw(rs.getString("userPw"));
				dto.setUserName(rs.getString("userName"));
				dto.setEmail(rs.getString("email"));
				dto.setBirth(rs.getString("birth"));
				dto.setGender(rs.getString("gender"));
				dto.setAge(rs.getInt("age"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
	public int insert(MemberDTO input) {
		int result =0;
		String sql="insert INTO member1 (userid, userpw, username, email, birth, gender, age) VALUES ('%s','%s','%s','%s', '%s', '%s', %d)";
		sql = String.format(sql, input.getUserId(),input.getUserPw(), input.getUserName(),input.getEmail(), input.getBirth(),input.getGender(),input.getAge());
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	public int delete(int idx) {
		int result =0;
		String sql = "delete member1 where idx = %d";
		sql = String.format(sql, idx);
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
