package hongbapProject.restaurant.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hongbapProject.restaurant.model.ResDAO;
import hongbapProject.restaurant.model.ResVO;

public class ResInfoService implements IResService {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String strid = request.getParameter("resId");
			int resId = Integer.parseInt(strid);
		
			ResDAO dao = ResDAO.getInstance();
			
			ResVO result = new ResVO();
			
			result = dao.getResInfo(resId);
			
			request.setAttribute("result", result);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	

}
