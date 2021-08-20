package kr.co.ictedu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hongbapProject.user.model.UserDAO;
import hongbapProject.user.model.UserVO;

//인터페이스 구현하기!
	public class UserJoinService implements IUserService {

		public void execute(HttpServletRequest request,
				HttpServletResponse response) {
			// 폼에서 날린 데이터 받기!
			try {
				
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				String UserId = request.getParameter("UserId");
				String UserPw = request.getParameter("UserPw");
				String UserName = request.getParameter("UserName");
				String UserEmail = request.getParameter("UserEmail");
				String UserPnum = request.getParameter("UserPnum");
				String UserNick = request.getParameter("UserNick");
				
				// DAO 생성!
	            UserDAO dao = UserDAO.getInstance();
				// VO 생성!
				UserVO user = new UserVO();
				// 데이터 입력!
				user.setUserId(UserId);
				user.setUserPw(UserPw);
				user.setUserName(UserName);
				user.setUserEmail(UserEmail);
				user.setUserPnum(UserPnum);
				user.setUserNick(UserNick);
				
				dao.JoinUser(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

}
