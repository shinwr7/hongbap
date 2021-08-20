package hongbapProject.board.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.board.model.BoardDAO;
import hongbapProject.board.model.BoardVO;
import hongbapProject.user.model.UserVO;

public class BoardWriteService implements IBoardService {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = null;
		session = request.getSession();
		
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String bTitle = request.getParameter("title");
		String bContent = request.getParameter("content");
		String userNick = (String)session.getAttribute("userNick");
		BoardVO board = new BoardVO();
		board.setbTitle(bTitle);
		board.setbWriter(userNick);
		board.setbContent(bContent);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int resultCode = dao.boardWrite(board);
		
		
		if (resultCode == 1) {
			System.out.println("글쓰기 성공");
			request.setAttribute("board", board);
		
		} else {
			System.out.println("글쓰기 실패");
		}
				
		
		
		
		
	}
}
