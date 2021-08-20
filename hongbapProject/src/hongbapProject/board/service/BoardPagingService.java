package hongbapProject.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.board.model.BoardDAO;
import hongbapProject.board.model.BoardDTO;
import hongbapProject.board.model.BoardVO;

public class BoardPagingService implements IBoardService{
	public void execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = null;
		session = request.getSession();
		
		// page 파라미터에 있던 값을 가져옵니다.(get방식)
				String strPage = request.getParameter("page");
				// 가져온 데이터는 String 타입이므로 int 타입으로 전환
				// null이 저장된 상황에는 int로 바꿔줄 수없음
				// 파라미터가 없을 때 들어갈 기본 페이지는 1페이지임 
				int page =1;
				if(strPage!=null) {
					page=Integer.parseInt(strPage);
				}
				
				// DAO 생성
				BoardDAO dao = BoardDAO.getInstance();
				
				// 현재 보고 있는 페이지의 전체 글 가져오기
				List<BoardVO> boardList =dao.getPageList((page-1)*10);
				
				// 얻어온 글 전체 개수와 현재 조회중인 페이지 정보를 DTO에 넘겨줌
				
				// DTO의 역할은 페이지 하단에 링크만들 정보를 계산하는 것.
				
				// 전체 행 개수 가져오기
				int countBoard = dao.getCountBoard();
				
				BoardDTO pageDTO = new BoardDTO(countBoard,page,boardList);
						
				System.out.println("링크버튼 정보 : "+ pageDTO);
				
				
				
				// 포워딩하기위해 적재하기
				request.setAttribute("boardList", boardList);
				request.setAttribute("pageDTO", pageDTO);
			}
		}
