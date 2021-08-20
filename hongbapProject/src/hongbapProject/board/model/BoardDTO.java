package hongbapProject.board.model;

import java.util.List;

public class BoardDTO {
	private int total;
	private int currentPage;
	private List<BoardVO> boardList;
	private int startPage;
	private int endPage;
	private int totalPages;
	
	// 전체 글 개수, 현재 페이지, 페이징된 글 목록을 받아서 
	// 나머지 정보를 얻어냅니다.
	
	public BoardDTO(int total,
						int currentPage,
						List<BoardVO> boardList) {
		this.total = total;
		this.currentPage = currentPage;
		this.boardList = boardList;
	
	//아래부터 위 3개를 토대로 가공해서 나머지 변수를 채웁니다.
	// 글이 없는 경우 페이지및 버튼 자체가 필요없음
	if(total == 0) {
		this.totalPages = 0;
		this.startPage =0;
		this.endPage = 0;
	} else {
		// 게시글 총 개수를 이용해 전체 페이지 개수부터 구하기
		this.totalPages = total/10;
		if(this.total % 10 >0) {
			// 만약 나눴을때 10개로 딱떨어지지 않으면
			// 마지막에 페이지를 하나 더 추가해야함
			this.totalPages +=1; 
		}
	}
	}
}