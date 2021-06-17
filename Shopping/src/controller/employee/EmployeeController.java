package controller.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.member.MemberDetailPage;
import controller.member.MemberOutPage;
import controller.member.MemberPwChangePage;
import controller.member.MemberPwConfirmPage;
import controller.member.MemberUpdatePage;

public class EmployeeController extends HttpServlet implements Servlet{
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		if(command.equals("/empList.em")) {
			EmployeeListPage action = new EmployeeListPage();
			action.empList(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeList.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/empRegest.em")) {
			EmployeeNumPage action = new EmployeeNumPage();
			action.getNum(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeForm.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/empJoin.em")) {
			EmployeeJoinPage action = new EmployeeJoinPage();
			action.empInsert(request);
			response.sendRedirect("empList.em");
		} else if (command.equals("/empInfo.em")) { 
	         EmployeeInfoPage action = new EmployeeInfoPage();
	         action.empInfo(request);
	         RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeInfo.jsp");
	         dispatcher.forward(request, response);
	    } else if(command.equals("/empModify.em")) {
	    	EmployeeInfoPage action = new EmployeeInfoPage();
	    	action.empInfo(request);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("employee/employeeModify.jsp");
	        dispatcher.forward(request, response);
	    } else if(command.equals("/empModifyOk.em")) {
	    	EmployeeModifyPage action = new EmployeeModifyPage();
	    	action.empModify(request);
	    	response.sendRedirect("empList.em");
	    } else if(command.equals("/empDelete.em")) {
	    	EmployeeDeletePage action = new EmployeeDeletePage();
	    	action.empDelete(request);
	    	response.sendRedirect("empList.em");
	    } else if(command.equals("/empMyPage.em")) { //여기부터 추가함
	    	response.setCharacterEncoding("utf-8");
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empMyPage.jsp");
			dispatcher.forward(request, response);
	    } else if(command.equals("/empDetail.em")) { 
			EmployeeDetailPage action = new EmployeeDetailPage();
			action.employeeDetail(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empDetail.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/empSujung.em")) {
			EmployeeDetailPage action = new EmployeeDetailPage();
			action.employeeDetail(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empSujung.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/empSujungOk.em")) {
			EmployeeUpdatePage action = new EmployeeUpdatePage();
			int i = action.employeeUpdate(request);
			if(i == 1) {
				response.sendRedirect("empDetail.em");
			} else {
				response.sendRedirect("empSujung.em");
			}
		} else if(command.equals("/emOut.em")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empOutPw.jsp");
			dispatcher.forward(request, response);
			
		} else if(command.equals("/emOutOk.em")) {
			EmployeeOutPage action = new EmployeeOutPage();
			int i = action.empOut(request);
			if(i == 1) {
				response.sendRedirect("main.sm");
			} else {
				response.sendRedirect("emOut.em");
			}
		} else if(command.equals("/emPwChange.em")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empPwChange.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/empPwChangeOk.em")) {
			EmployeePwConfirmPage action = new EmployeePwConfirmPage();
			String path = action.pwConfirm(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if(command.equals("/EmpChangePw.em")) {
			EmployeePwChangePage action = new EmployeePwChangePage();
			int i = action.pwChange(request);
			if(i == 1) {
				response.sendRedirect("main.sm");
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("employee/empPwChange.jsp");
				dispatcher.forward(request, response);
			}
			
		} 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doProcess(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doProcess(req, resp);
		
	}
}
