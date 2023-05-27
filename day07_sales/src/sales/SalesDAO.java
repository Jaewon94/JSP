package sales;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class SalesDAO {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String url="jdbc:oracle:thin:@192.168.1.100:1521:xe";
	private String user = "c##itbank";
	private String password = "it";
	
	private String className = OracleDriver.class.getName();
	
	public SalesDAO() {
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
	
	public List<SalesDTO> selectAll(){
		List<SalesDTO> list = new ArrayList<SalesDTO>();
		String sql = "select * from sales order by idx";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				SalesDTO row = new SalesDTO();
				row.setIdx(rs.getString("idx"));
				row.setName(rs.getString("name"));
				row.setPrice(rs.getInt("price"));
				row.setCnt(rs.getInt("cnt"));
				row.setStatus(rs.getInt("status"));
				list.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public int changeStatus(String idx) {
		int result=0;
		String sql = "update sales set status = decode(status, 1, 0, 0, 1) where idx = '%s'";
		sql = String.format(sql, idx);
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public int add(SalesDTO dto) {
		int result=0;
		String sql="insert into sales (name, price, cnt) values ('%s', %d, %d)";
		sql = String.format(sql, dto.getName(), dto.getPrice(), dto.getCnt());
		
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
