package ch01.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch01.model.MemberBean;
import ch01.model.MemberService;
import ch01.model.impl.MemberServiceImpl;

@WebServlet("/ch01/queryMember.do")
public class QueryAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService ms = new MemberServiceImpl();
		List <MemberBean>list = ms.getAllMembers();
		//Collection<MemberBean> coll = ms.getAllMembers();
		//用List不用Collection,因為List是子代,功能比較多
		request.setAttribute("allMembers", list);
		RequestDispatcher rd = request.getRequestDispatcher("showMembers.jsp");
		rd.forward(request, response);
		return;		
	}

}
