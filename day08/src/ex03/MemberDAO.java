package ex03;

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
			System.out.println("DAO 생성자 예외 발생 : " + e);
			e.printStackTrace();
		}
	}
	
	// 전체 목록 불러오기
	public List<MemberDTO> selectAll(){
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from member1 order by idx";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setAge(rs.getInt("age"));
				dto.setBirth(rs.getString("birth"));
				dto.setEmail(rs.getString("email"));
				dto.setGender(rs.getString("gender"));
				dto.setIdx(rs.getInt("idx"));
				dto.setUserId(rs.getString("userid"));
				dto.setUserName(rs.getString("username"));
				dto.setUserPw(rs.getString("userpw"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if (rs != null) rs.close();
					if (stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return list;
	}
}
