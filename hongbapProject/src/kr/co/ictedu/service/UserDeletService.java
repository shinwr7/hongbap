package kr.co.ictedu.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.user.model.UserDAO;
import hongbapProject.user.model.UserVO;

public class UserDeletService implements IUserService {

	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = null;
		session = request.getSession();
		String idSession = (String)session.getAttribute("id_session");
		String pwSession = (String)session.getAttribute("pw_session");
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		response.setCharacterEncoding("utf-8");
		
		if(idSession == null) {
			try {
				
				String ui = "/user/userLogin.jsp";
				RequestDispatcher dp = request.getRequestDispatcher(ui);
				dp.forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		String UserPw = request.getParameter("UserPw");
		System.out.println("UserPw 값:" + UserPw);
		
		UserDAO Userdao = UserDAO.getInstance();
		
		UserVO user = new UserVO();
		user.setUserId(idSession);
		user.setUserPw(pwSession);
		
		Userdao.UserDelete(user , UserPw);
	
}
}