package hongbapProject.board.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.board.model.BoardDAO;
import hongbapProject.board.model.BoardVO;

public class BoardDetailService implements IBoardService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		
		HttpSession session = null;
		session = request.getSession();
		String idSession = (String)session.getAttribute("i_s");
		
		if(idSession== null) {
			try {
				// 서비스 내부에서 포워딩 시키면
				// 리다이렉트가 아니기 때문에 실행됨
				String ui = "/users/user_login.jsp";
				RequestDispatcher dp =
						request.getRequestDispatcher(ui);
				dp.forward(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		//url 에 묻어온 글 번호를  getParameter 를 이용해 얻습니다. 
		String bId = request.getParameter("bid"); 
							
		// DAO 를 생성합니다
		BoardDAO dao = BoardDAO.getInstance();
		
		//조회수 올리는 메서드, 먼저 조회수를 올리고 가져와야 최신 조회수 표시가능
		dao.upHit(bId);
		
		// DAO 에 글 번호를 넘겨서 detail 페이지 데이터를 얻어옵니다.
		BoardVO board = dao.getBoardDetail(bId);
		// 포워딩을 위해 setAttribute()로 데이터를 실어줍니다.
		request.setAttribute("board", board);
		
		
	}
}

