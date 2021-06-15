package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseInfo {
	static String jdbcDriver;
	static String jdbcUrl;
	static Connection conn;
	String sql;
	PreparedStatement pstmt; // sql문을 데이터베이스쪽으로 전달할 때 사용
	Integer result;
	ResultSet rs;
	static {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	
	public static void getConnect() {
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "sana", "sana");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
}
