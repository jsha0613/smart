package controller.notice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.DAO.NoticeDAO;
import model.DTO.NoticeDTO;


public class NoticeUpdatePage {
	
	public void noticeUpdate(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		NoticeDTO dto = new NoticeDTO();
		dto.setNoticeSub(request.getParameter("noticeSub"));
		dto.setNoticeNo(request.getParameter("noticeNo"));
		dto.setNoticeCon(request.getParameter("noticeCon"));
		dto.setEmployeeId(request.getParameter("employeeId"));
		
		NoticeDAO dao = new NoticeDAO();
		dao.noticeUpdate(dto);
		
	}
}
