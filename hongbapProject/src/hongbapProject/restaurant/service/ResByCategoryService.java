package hongbapProject.restaurant.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hongbapProject.restaurant.model.ResDAO;
import hongbapProject.restaurant.model.ResDTO;
import hongbapProject.restaurant.model.ResVO;

public class ResByCategoryService implements IResService {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String resCategory = request.getParameter("resCategory");
		String strPage = request.getParameter("page");
		int page = 1;
		if(strPage != null) {
			page = Integer.parseInt(strPage);
		}
		
		ResDAO dao = ResDAO.getInstance();
		
		List<ResVO> ResList = dao.getAllResByCategory(resCategory , page -1 * 10);
		
		int countNum = dao.getResCount();
		
		ResDTO ResDTO = new ResDTO(countNum, page, ResList);
		
		request.setAttribute("ResList", ResList);
		request.setAttribute("ResDTO", ResDTO);
	}

}