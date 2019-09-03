package ch01.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch01.model.MemberBean;
import ch01.model.MemberService;
import ch01.model.impl.MemberServiceImpl;

@WebServlet({ "/ch01/updateMember.do" })
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession hsession = request.getSession();
		Map<String,String> errorMsg = new HashMap<>();
		hsession.setAttribute("error", errorMsg);
		String modify = request.getParameter("finalDecision");
		String pk = request.getParameter("pk");
		int ipk = Integer.parseInt(pk);
		System.out.println("modify="+modify);
		MemberService ms = new MemberServiceImpl();
		int count=0;
		if(modify.equalsIgnoreCase("DELETE")){
			count = ms.deleteMember(ipk);
			if(count ==1){
				hsession.setAttribute("modify", "刪除成功");
			}else{
				hsession.setAttribute("modify", "刪除時發生異常");
			}
			String url = request.getContextPath()+"/ch01/queryMember.do";
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
			
		}else if(modify.equalsIgnoreCase("UPDATE")){
			String name = request.getParameter("name");
			String pswd = request.getParameter("pswd");
			String id = request.getParameter("id");
			//檢查輸入的資料
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("name", "姓名欄不能空白");
			}			
			if (pswd == null || pswd.trim().length() == 0) {
				errorMsg.put("pswd", "密碼欄不能空白");
			}
			//如果輸入資料都正確,進行修改動作
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("updateMember.jsp");
				rd.forward(request, response);
				return;
			}
			
			MemberBean mb = new MemberBean(ipk,id,pswd,name);
			count = ms.updateMember(mb);
			if(count==1){
				hsession.setAttribute("modify", "修改成功");
			}else{
				hsession.setAttribute("modify", "修改時發生異常");
			}
			String url = request.getContextPath()+"/ch01/queryMember.do";
			String newurl = response.encodeRedirectURL(url);
			response.sendRedirect(newurl);
		}
	}
}
