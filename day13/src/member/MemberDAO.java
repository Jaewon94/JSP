package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Context init;
	private DataSource ds;

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
		}
	}

	public String test() {
		String banner = "";
		String sql = "select banner from v$version";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				banner = rs.getString("banner");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return banner;
	}
	
	private MemberDTO mapping(ResultSet rs) {
		MemberDTO row = new MemberDTO();
		try {
			row.setAge(rs.getInt("age"));
			row.setBirth(rs.getString("birth"));
			row.setEmail(rs.getString("email"));
			row.setGender(rs.getString("gender"));
			row.setIdx(rs.getInt("idx"));
			row.setUserId(rs.getString("userid"));
			row.setUserName(rs.getString("username"));
			row.setUserPw(rs.getString("userpw"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return row;
	}

	// 로그인 함수 (SQL을 수행하기 위한 파라미터는 가급적 하나로 받는 것이 좋다)
	public MemberDTO selectOne(MemberDTO dto) {
		MemberDTO row = null;
		String sql = "select * from member1 where userid =? and userpw=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = mapping(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return row;
	}
}