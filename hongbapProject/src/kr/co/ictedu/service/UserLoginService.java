package kr.co.ictedu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.user.model.UserDAO;
import hongbapProject.user.model.UserVO;

//인터페이스 구현하기!
public class UserLoginService implements IUserService {

	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		// 폼에서 날린 데이터 받기!
		try {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String UserId = request.getParameter("UserId");
		String UserPw = request.getParameter("UserPw");
		
		// 세션 쓰는법!
		HttpSession session = null;
		session = request.getSession();
		
		String s_id = (String)session.getAttribute("id_session");
		String s_pw = (String)session.getAttribute("pw_session");
		
		// VO 생성 및 데이터 입력!
		UserVO user = new UserVO();
		
		if(s_id==null) {
		user.setUserId(UserId);
		user.setUserPw(UserPw);
		} else {
			user.setUserId(s_id);
			user.setUserPw(s_pw);
		}
		// DAO 생성 및 호출!
		UserDAO dao = UserDAO.getInstance();
		
		int resultCode = dao.UserLogin(user);
		String userNick = dao.getUserNick(user.getUserId());
		if(resultCode == 1) {
			
		// 통과시 세션발급!
			session.setAttribute("id_session", UserId);
			session.setAttribute("pw_session", UserPw);
			session.setAttribute("nick_session", userNick);
			
		} else if(resultCode == 0) {
			session.setAttribute("login", "fail");
		}	
	
	   } catch(Exception e) {
		e.printStackTrace();
}	
}

}
