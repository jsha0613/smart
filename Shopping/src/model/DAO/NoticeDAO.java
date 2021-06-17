package model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.NoticeDTO;

public class NoticeDAO extends DataBaseInfo{

	final String COLUMNS = "NOTICE_NO, NOTICE_SUB, NOTICE_CON, NOTICE_DATE, NOTICE_KIND, NOTICE_FILE, NOTICE_HITS, EMPLOYEE_ID "; 

	public void noticeUpdate(NoticeDTO dto) {
		sql = " update notice"
				+ " set notice_sub = ?, notice_con = ? , notice_date = ? , employee_id = ? "
				+ " where notice_no = ? ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNoticeSub());
			pstmt.setString(2, dto.getNoticeCon());
			pstmt.setString(3, dto.getNoticeDate());
			pstmt.setString(4, dto.getEmployeeId());
			pstmt.setString(5, dto.getNoticeNo());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public NoticeDTO NoticeOne(String noticeNo) {
		NoticeDTO dto = null;
		sql = " select " + COLUMNS + " from notice "
				+ " where notice_no = ? ";
		getConnect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new NoticeDTO();		
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setNoticeCon(rs.getString("notice_con"));
				dto.setNoticeDate(rs.getString("notice_date"));
				dto.setNoticeFile(rs.getString("notice_file"));
				dto.setNoticeHits(rs.getString("notice_hits"));
				dto.setNoticeKind(rs.getString("notice_kind"));
				dto.setNoticeNo(rs.getString("notice_no"));
				dto.setNoticeSub(rs.getString("notice_sub"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dto;
	}
	
	public void noticeInsert(NoticeDTO dto) {
		sql = " insert into notice ( " + COLUMNS + ") "
				+ " values(?,?,?,?,?,?,?,?) ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNoticeNo());
			pstmt.setString(2, dto.getNoticeSub());
			pstmt.setString(3, dto.getNoticeCon());
			pstmt.setString(4, dto.getNoticeDate());
			pstmt.setString(5, dto.getNoticeKind());
			pstmt.setString(6, dto.getNoticeFile());
			pstmt.setString(7, dto.getNoticeHits());
			pstmt.setString(8, dto.getEmployeeId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 입력되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String noticeNo() {
		String noticeNo = null;
		sql = " select notice_seq.nextval from dual ";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			noticeNo = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return noticeNo;
	}
	
	public List<NoticeDTO> noticeList() {
		List<NoticeDTO> list = new ArrayList<NoticeDTO>();
		sql = " select " + COLUMNS + " from notice ";
		getConnect();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setEmployeeId(rs.getString("employee_id"));
				dto.setNoticeCon(rs.getString("notice_con"));
				dto.setNoticeDate(rs.getString("notice_date"));
				dto.setNoticeFile(rs.getString("notice_file"));
				dto.setNoticeHits(rs.getString("notice_hits"));
				dto.setNoticeKind(rs.getString("notice_kind"));
				dto.setNoticeNo(rs.getString("notice_no"));
				dto.setNoticeSub(rs.getString("notice_sub"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	
		return list;
	}
	
	
}
