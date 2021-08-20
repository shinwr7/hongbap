package kr.co.ictedu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.user.model.UserDAO;
import hongbapProject.user.model.UserVO;

public class UserInfoService implements IUserService{
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		
//		HttpSession session = null;
//		session = request.getSession();
//
//		String sid = (String)session.getAttribute("id_session");
//		
//		UserDAO dao = UserDAO.getInstance();
//		UserVO user = new UserVO();
//		user.setUserId(sid);
//		
//		UserVO userInfo = new UserVO();
//		
//		userInfo=dao.GetUserInfo(user);
//		System.out.println("userInfo 값 : " + userInfo);
//		
//		request.setAttribute("userInfo", userInfo);
		
}
}
