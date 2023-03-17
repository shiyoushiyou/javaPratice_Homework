package jp.co.brightstar.dvd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DVDDao {
	
	public static void insertDVD(String name) {//新增DVD
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn =JDBCUtil.Login("root", "brightstar");
			
			//執行SQL
			String sql ="INSERT INTO DVD_BASIC_INFO(NAME) VALUES (?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.executeUpdate();
			//取得結果集
			} catch (SQLException e) {
			e.printStackTrace();
			}finally{
				//關閉連接
				try {
					JDBCUtil.close(conn, ps, null);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
	public static List<DVD> selectDVD(){//查看DVD
		List<DVD>dvds = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs  = null;
		
		try {
			conn = JDBCUtil.Login("root", "brightstar");
			//執行SQL
			StringBuilder sb =new StringBuilder ();
			sb.append(" SELECT ");
			sb.append(" 		DBI.ID ");
			sb.append(" 		, STATE_ ");
			sb.append(" 		, NAME ");
			sb.append(" 		, LEND_TIME ");
			sb.append(" 		, COUNT ");
			sb.append(" FROM ");
			sb.append(" 		DVD_BASIC_INFO DBI ");
			sb.append(" LEFT JOIN ");
			sb.append(" 		DVD_LENDING_DETAILS DLD ");
			sb.append(" ON ");
			sb.append(" 		DBI.ID = DLD.DVD_ID ");
			sb.append(" 		AND RETURN_TIME IS NULL ");
			sb.append(" WHERE ");
			sb.append(" 		DELETE_FLAG = 0 ");
			sb.append(" ORDER BY ");
			sb.append(" 		DBI.ID ");
			ps = conn.prepareStatement(sb.toString());
			//取得結果集
			rs = ps.executeQuery(); 
			while(rs.next()) {
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("ID"));
				dvd.setState(rs.getInt("STATE_"));
				dvd.setName(rs.getString("NAME"));
				dvd.setDate(rs.getDate("LEND_TIME"));
				dvd.setCount(rs.getInt("COUNT"));
				dvds.add(dvd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//關閉連接
				JDBCUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dvds;
		
	}
	public static void deleteDVD(int ID) {//刪除DVD
		//使用倫理刪除 沒有返回值，更新系SQL
		//在更新過後再次使用selectDVD 查看邏輯刪除後結果
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs  = null;
		try {
			conn = JDBCUtil.Login("root", "brightstar");
			String sql =" UPDATE  DVD_BASIC_INFO  SET  DELETE_FLAG = 1 ,  LAST_UPDATE_TIME  =  CURRENT_TIMESTAMP  WHERE  ID = " +ID;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//關閉連接
				JDBCUtil.close(conn, ps, null);
			} catch (SQLException e) {
				e.printStackTrace();
		}
		}
		
	}
	public static int DelectFlagZero()  {//查詢有沒有可刪除DVD
		int DelectFlagCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs  = null;
		try {
			conn = JDBCUtil.Login("root", "brightstar");
			String sql =" SELECT  COUNT(ID)  FROM  DVD_BASIC_INFO  WHERE  DELETE_FLAG  = 0  AND  STATE_ = 0 ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				DelectFlagCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//關閉連接
				JDBCUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
		}
		}
		return DelectFlagCount;
	}
	public static String idOfDelectFlag(int ID) {//通過id查詢DVD
		int DelectID= 0;
		String DVDName = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs  = null;
		try {
			conn = JDBCUtil.Login("root", "brightstar");
			String sql =" SELECT * FROM DVD_BASIC_INFO WHERE DELETE_FLAG = 0 AND ID =  "+ID;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			if(rs.next()) {
				DelectID = rs.getInt(1);
				DVDName = rs.getString("NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//關閉連接
				JDBCUtil.close(conn, ps, rs);
			} catch (SQLException e) {
				e.printStackTrace();
		}
		}
		return DVDName;
	}
	
}
