package controller.member;

import model.DAO.MemberDAO;
import model.DTO.MemberDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MemberListPage {
    public void memList(HttpServletRequest request){
        MemberDAO dao = new MemberDAO();
        List<MemberDTO> list = dao.memList();
        request.setAttribute("lists",list);
    }


}