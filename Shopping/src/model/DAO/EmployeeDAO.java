package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.EmployeeDTO;
import model.DTO.MemberDTO;

public class EmployeeDAO {
	final String COLUMNS = " employee_id, emp_userid, emp_pw, emp_name, hire_date, job_id, ph_number, office_number, email, emp_address ";
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
	
	public void empDelete(String empId) { //추가
		sql = "delete from employees " + " where employee_id = ?";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
	public void empDel(String empUserid) { //추가
		sql = " delete from employees where EMP_USERID = ? ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empUserid);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
		
	
	public void pwChange(String empUserid, String empPw) { //추가
		sql = " update employees "
				+ " set EMP_PW = ? "
				+ " where EMP_USERID = ? ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empPw);
			pstmt.setString(2, empUserid);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void empUpdate(EmployeeDTO dto) { //추가
		sql = " update employees " + " set JOB_ID = ?, PH_NUMBER = ?, OFFICE_NUMBER = ?, EMAIL = ?, EMP_ADDRESS = ? " 
				+ " where emp_userid = ? ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getJobId());
			pstmt.setString(2, dto.getPhNumber());
			pstmt.setString(3, dto.getOfficeNumber());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getEmpAddress());
			pstmt.setString(6, dto.getEmpUserid());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public EmployeeDTO empDetail(String empUserid) { //추가
		EmployeeDTO dto = new EmployeeDTO();
		sql = " select " + COLUMNS + " from employees where emp_userid = ? ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empUserid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
	            dto.setEmployeeId(rs.getString("EMPLOYEE_ID"));
	            dto.setEmpUserid(rs.getString("EMP_USERID"));
	            dto.setEmpPw(rs.getString("EMP_PW"));
	            dto.setEmpName(rs.getString("EMP_NAME"));
	            dto.setHireDate(rs.getString("HIRE_DATE"));
	            dto.setJobId(rs.getString("JOB_ID"));
	            dto.setPhNumber(rs.getString("PH_NUMBER"));
	            dto.setOfficeNumber(rs.getString("OFFICE_NUMBER"));
	            dto.setEmail(rs.getString("EMAIL"));
	            dto.setEmpAddress(rs.getString("EMP_ADDRESS"));
	         }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	public EmployeeDTO empInfo(String empId) {
		EmployeeDTO dto = new EmployeeDTO();
		sql = " select " + COLUMNS + " from employees where employee_id = ? ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setEmployeeId(rs.getString("EMPLOYEE_ID"));
	            dto.setEmpUserid(rs.getString("EMP_USERID"));
	            dto.setEmpPw(rs.getString("EMP_PW"));
	            dto.setEmpName(rs.getString("EMP_NAME"));
	            dto.setHireDate(rs.getString("HIRE_DATE"));
	            dto.setJobId(rs.getString("JOB_ID"));
	            dto.setPhNumber(rs.getString("PH_NUMBER"));
	            dto.setOfficeNumber(rs.getString("OFFICE_NUMBER"));
	            dto.setEmail(rs.getString("EMAIL"));
	            dto.setEmpAddress(rs.getString("EMP_ADDRESS"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dto;
	}
	
	public List<EmployeeDTO> getEmpList(){
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		sql = "select " + COLUMNS + " from employees";
		getConnect();
		
		try {
			pstmt = conn.prepareStatement(sql); // 쿼리문 날려줌
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				dto.setEmpUserid(rs.getString(2)); // 숫자도 된다 근데 컬럼명이 더 좋음
				dto.setEmpPw(rs.getString("EMP_PW"));
				dto.setEmpName(rs.getString(4));
				dto.setHireDate(rs.getString("HIRE_DATE"));
				dto.setJobId(rs.getString("JOB_ID"));
				dto.setPhNumber(rs.getString("PH_NUMBER"));
				dto.setOfficeNumber(rs.getString("OFFICE_NUMBER"));
				dto.setEmail(rs.getString("EMAIL"));
				dto.setEmpAddress(rs.getString("EMP_ADDRESS"));
				list.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public int getEmpNo() {
		getConnect();
		sql = " select nvl(max(employee_id), 10000) + 1 from employees ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // 실행된 결과값 반환해옴
			rs.next(); // 레코드의 처음을 알리기 위해 BOF가 있기 때문에 그 다음 값부터 가져와야함
			result = rs.getInt(1); // 첫 번째 값 가져옴
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		System.out.println(result);
		return result; // page_controller dao.getEmpNO()로 반환됨
	}
	
	public void empInsert(EmployeeDTO dto) {
		sql = " insert into employees (" + COLUMNS + ")" 
				+ " values(?,?,?,?,?,?,?,?,?,?) ";
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
		} finally {
			close();
		}
	}
	
	private void close() {
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
