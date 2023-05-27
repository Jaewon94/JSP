package member;

// 1) 싱글톤 구현
// 2) 커넥션 풀 연결
// 3) pstmt 사용하기 : SQL에서 파라미터가 많이 사용될 경우, 순서대로 값을 넣어주는 객체

// stmt = conn. createStatement();
// rs = stmt.executeQuery(sql);

// pstmt = conn.preparedStatement(sql);	// 자료형에 따라 쿼리문을 다르게 만들어준다.
// pstmt.setString(1, dto.getName());	// 문자열은 자동으로 따옴표로 묶어준다.
// pstmt.setInt(2,dto.getAge());		// 숫자는 그냥 입력한다.
// rs = pstmt.executeQuery();			// 이미 쿼리문을 전달했지 때문에 인자를 추가로 전달하지 않는다.
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;
import javax.naming.*;

public class MemberDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	
	// 싱글톤 
	private static MemberDAO instance = new MemberDAO();
	
	// 생성자 대신 객체를 받는 함수 작성 (객체가 없는 상태에서 객체를 받아야 하니 static으로 처리)
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private MemberDAO() {	// 외부에서 생성자를 호출하지 못하게 private으로 변경
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			System.err.println("생성자 예외 : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// close를 메서드로 빼놓은 것
	private void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch (Exception e) {
		}
	}
	public String test() {
		String banner ="";
		String sql = "select banner from v$version";
		
		try {
			conn = ds.getConnection();
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);	// 미리 준비한 SQL을 넣어서 pstmt를 받는다.
			
//			rs = stmt.executeQuery(sql);
			rs = pstmt.executeQuery();
			
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
	
	// rs를 전달받아서, MemberDTO하나를 반환하는 함수 (내부에서만 사용)
	private MemberDTO mapping(ResultSet rs) throws SQLException {
		MemberDTO dto = new MemberDTO();
		dto.setIdx(rs.getInt("idx"));
		dto.setAge(rs.getInt("age"));
		dto.setBirth(rs.getString("birth"));
		dto.setEmail(rs.getString("email"));
		dto.setGender(rs.getString("gender"));
		dto.setUserId(rs.getString("userId"));
		dto.setUserName(rs.getString("userName"));
		dto.setUserPw(rs.getString("userPw"));
		return dto;
	}
	
	// 전체 리스트를 불러오는 메서드
	public List<MemberDTO> selectAll() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from member1";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberDTO dto = mapping(rs);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	// 추가
	public int insert(MemberDTO dto) {
		int result =0;
		String sql = "insert into member1 (userid, userpw, username,email,birth,gender,age) VALUES (?,?,?,?,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPw());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getBirth());
			pstmt.setString(6, dto.getGender());
			pstmt.setInt(7, dto.getAge());
			result =  pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// idx로 단일 회원 조회하기
	public MemberDTO selectOne(int idx) {
		MemberDTO dto = null;
		String sql = "select * from member1 where idx=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = mapping(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dto;
	}
	
	// 삭제하는 메서드
	public int delete(int idx) {
		int result =0;
		String sql ="delete from member1 where idx=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);	// ? 갯수 만큼 값을 넣었는지 확인하자
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
	}
	
	// 수정하는 메서드
	public int modify(MemberDTO input){
		int result=0;
		String sql="update member1 SET userPw=?, userName=?,email=?, birth=?, gender=?, age=? where userId=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input.getUserPw());
			pstmt.setString(2, input.getUserName());
			pstmt.setString(3, input.getEmail());
			pstmt.setString(4, input.getBirth());
			pstmt.setString(5, input.getGender());
			pstmt.setInt(6, input.getAge());
			pstmt.setString(7, input.getUserId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return result;
	}
	
	
}
