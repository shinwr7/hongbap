package hongbapProject.restaurant.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hongbapProject.restaurant.model.ResDAO;
import hongbapProject.restaurant.model.ResVO;

public class ResRandomService implements IResService {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ResDAO dao = ResDAO.getInstance();
		int randomId = dao.getRandomResId();
		System.out.println("랜덤아이디 : " + randomId);
		
		ResVO randomResult = new ResVO();
		randomResult = dao.getResInfo(randomId);
		System.out.println(randomResult);
		
		request.setAttribute("randomResult", randomResult);
		
		
	}
	

}
