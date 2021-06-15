package controller.member;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberModifyPage {
    public void memUpdate(HttpServletRequest request){

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        MemberDTO dto = new MemberDTO();
        dto.setDetailAdd(request.getParameter("detailAdd"));
        dto.setMemAccount(request.getParameter("memAccount"));
        dto.setMemAddress(request.getParameter("memAddress"));
        dto.setMemEmail(request.getParameter("memEmail"));
        dto.setMemEmailCk(request.getParameter("memEmailCk"));
        dto.setMemPhone(request.getParameter("memPhone"));
        dto.setPostNumber(request.getParameter("postNumber"));
        dto.setMemId(request.getParameter("memId"));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date memBirth = null;
        try {
            memBirth = sf.parse(request.getParameter("memBirth"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dto.setMemBirth(memBirth);
        MemberDAO dao = new MemberDAO();
        dao.memUpdate(dto);

    }
}