package phonebook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.*;

public class PhonebookDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Context init;
	private DataSource ds;
	
	private static PhonebookDAO instance = new PhonebookDAO();
	
	public static PhonebookDAO getInstance() {
		return instance;
	}
	
	private PhonebookDAO() {
		try {
			init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null) conn.close();
		}catch (Exception e) {
		}
	}
	
	public String test() {
		String banner="안녕";
		System.out.println("1");
		String sql="select banner from v$version";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
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
	
	public PhonebookDTO mapping(ResultSet rs) throws SQLException {
		PhonebookDTO row = new PhonebookDTO();
		row.setIdx(rs.getInt("idx"));
		row.setName(rs.getString("name"));
		row.setPnum(rs.getString("pnum"));
		row.setFavorites(rs.getInt("favorites"));
		return row;
	}
	
	public List<PhonebookDTO> selectAll(){
		List<PhonebookDTO> list = new ArrayList<PhonebookDTO>();
		String sql = "select * from phonebook order by favorites desc, name";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhonebookDTO row = mapping(rs);
				list.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public int insert(String name, String pnum) {
		int result =0;
		String sql = "insert into phonebook (name, pnum) VALUES (?,?)";
		
		try {
			conn =ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pnum);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return result;
	}
	
	public PhonebookDTO selectOne(int idx) {
		PhonebookDTO row = null;
		String sql = "select * from phonebook where idx =?";
		
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				row = mapping(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}

		return row;
	}
	
	public int delete(int idx) {
		int result = 0;
		String sql = "delete phonebook where idx=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	public int update(String name, String pnum, int idx) {
		int result = 0;
		String sql = "update phonebook set name=?, pnum=? where idx=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pnum);
			pstmt.setInt(3, idx);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public List<PhonebookDTO> search(String search){
		List<PhonebookDTO> list = new ArrayList<PhonebookDTO>();
		String sql = "select * from phonebook where name like '%%%s%%' order by favorites desc, name";
		sql = String.format(sql, search);
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PhonebookDTO row = mapping(rs);
				list.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	public int change(int idx) {
		int result=0;
		String sql = "update phonebook set Favorites = decode(Favorites, 0,1,1,0) where idx=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}
