package ex07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

// DAO : Data Access Object
// 저장된 데이터에 접근하여 (데이터베이스에 접근하여)
// 조회, 추가, 수정, 삭제 등을 수행하는 객체
// 각 기능은 함수로 구현한다.
// DB에 접근할 수 있는 JDBC요소가 포함되어야 한다.

public class StudentDAO {

	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String url ="jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user ="c##itbank";
	private String password ="it";
	
	private String className = OracleDriver.class.getName();
	
	public StudentDAO() {
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
			e.printStackTrace();
		}
	}
	
	// 접속 확인
	public String test() {
		String result =null;
		String sql = "select banner from v$version";
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				result =rs.getString("banner");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// 검색목록 불러오기
		public List<StudentDTO> search(String param){
			List<StudentDTO> list = new ArrayList<StudentDTO>();
			String sql = "select * from student where name like '%%%s%%' order by name";
			sql = String.format(sql, param);
			try {
				conn = DriverManager.getConnection(url, user, password);
				stmt  = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					StudentDTO row = new StudentDTO();
					row.setName(rs.getString("name"));
					row.setAge(rs.getInt("age"));
					row.setGender(rs.getString("gender"));
					
					list.add(row);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
			
			
			return list;
			
		}
	

}
