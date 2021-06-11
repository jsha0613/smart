package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DTO.EmployeeDTO;

public class EmployeeDAO {
	static String jdbcDriver;
	static String jdbcUrl;
	static Connection conn;
	String sql;
	PreparedStatement pstmt; // sql문을 데이터베이스쪽으로 전달할 때 사용
	Integer result;
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
	
	public void empInsert(EmployeeDTO dto) {
		sql = "insert into employees (employee_id, emp_userid, emp_pw, emp_name, hire_date, job_id, ph_number, office_number, email, emp_address)" 
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getEmployeeId());
			pstmt.setString(2, dto.getEmpUserid());
			pstmt.setString(3, dto.getEmpPw());
			pstmt.setString(4, dto.getEmpName());
			pstmt.setString(5, dto.getHireDate());
			pstmt.setString(6, dto.getJobId());
			pstmt.setString(7, dto.getPhNumber());
			pstmt.setString(8, dto.getOfficeNumber());
			pstmt.setString(9, dto.getEmail());
			pstmt.setString(10, dto.getEmpAddress());
			
			result = pstmt.executeUpdate(); // Int를 반환
			
			System.out.println(result + "개 행이 저장되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
