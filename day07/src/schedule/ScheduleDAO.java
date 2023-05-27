package schedule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class ScheduleDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String url="jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	private String className = OracleDriver.class.getName();
	
	public ScheduleDAO() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return banner;
	}
	
	public List<ScheduleDTO> list() {
		List<ScheduleDTO> list = new ArrayList<ScheduleDTO>();
		String sql = "select * from schedule order by sdate";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ScheduleDTO row = new ScheduleDTO();
				row.setIdx(rs.getInt("idx"));
				row.setTitle(rs.getString("title"));
				row.setMemo(rs.getString("memo"));
				row.setSdate(rs.getString("sdate"));
				list.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public int add(ScheduleDTO dto) {
		int result=0;
		String sql ="insert into schedule (title, memo, sdate) VALUES('%s','%s','%s')";
		sql = String.format(sql, dto.getTitle(), dto.getMemo(), dto.getSdate());
		
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
		int result = 0;
		String sql="delete from schedule where idx = %d";
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
