package kr.co.ictedu.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.user.model.UserDAO;
import hongbapProject.user.model.UserVO;

public class UserUpdateService implements IUserService {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 세션 쓰는법
		HttpSession session = null;
		session = request.getSession();
		String idSession = (String)session.getAttribute("id_session");
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(idSession == null) {
			try {
				String ui = "/users/userLogin.jsp";
				RequestDispatcher dp = request.getRequestDispatcher(ui);
				dp.forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
				
		// 파라미터  받아오기
		String UserId = request.getParameter("UserID");
		String UserPw = request.getParameter("UserPw");
		String UserName = request.getParameter("UserName");
		String UserEmail = request.getParameter("UserEmail");
		String UserPnum = request.getParameter("UserPnum");
		String UserNick = request.getParameter("UserNick");
		
		// VO생성해서 세터로 저장하기
		UserVO user = new UserVO();
		user.setUserId(UserId);
		user.setUserPw(UserPw);
		user.setUserName(UserName);
		user.setUserEmail(UserEmail);
		user.setUserPnum(UserPnum);
		user.setUserNick(UserNick);
		
		// DAO생성해서 입력
		UserDAO dao = UserDAO.getInstance();
		dao.UserUpdate(user);
		
	}
}
