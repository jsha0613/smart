package controller.notice;

import javax.servlet.http.HttpServletRequest;

import model.DAO.NoticeDAO;

public class NoticeNumberPage {
	public void seqNum(HttpServletRequest request) {
		  NoticeDAO dao = new NoticeDAO();
		  String noticeNo = dao.noticeNo();
		  request.setAttribute("noticeNo", noticeNo);
	}
}
