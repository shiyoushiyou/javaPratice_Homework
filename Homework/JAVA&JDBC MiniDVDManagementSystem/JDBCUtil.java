package jp.co.brightstar.dvd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class JDBCUtil {
	final static String url =  "jdbc:mysql://localhost:3306/mysql?useSSL=false&characterEncoding=UTF-8";
	
	public static Connection Login(String usrName,String Password) throws SQLException {
	Driver driver=new Driver();
	Properties info =new Properties();
	info.setProperty("user", usrName);
	info.setProperty("password", Password);
	return driver.connect(url, info);
}


public static void close(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException {
if (conn!=null) {
	conn.close();
}
if(ps!=null) {
	ps.close();
}
if(rs!=null) {
	rs.close();
}
}

}

