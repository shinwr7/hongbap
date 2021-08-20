package hongbapProject.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource ds;
	
	private BoardDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}//생성자 끝
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return dao;
	}//getInstance 끝
	
public int boardWrite(BoardVO board) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	int resultCode = 0;
	
	String sql = "INSERT INTO requestBoard (bwriter, btitle, bcontent, bdate, bhit)"
			+ "VALUES (?, ?, ?, now(), 0)";
	
	try { 
		
		
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, board.getbWriter());
		pstmt.setString(2, board.getbTitle());
		pstmt.setString(3, board.getbContent());
		
		pstmt.executeUpdate();
		// 커넥션 생성 및 pstmt에 쿼리문 넣고 완성시켜서 실행까지 하고
		// close()로 메모리회수까지 해주세요.
		resultCode = 1;
	} catch(Exception e) {
		e.printStackTrace();
		resultCode = 0;
	} finally {
		try {
			if(con!=null && !con.isClosed()) {
				con.close();
			}
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	return resultCode;
}// write 끝
	
public List<BoardVO> getPageList(int pageNum) {
	// 내부에서 사용할 변수 선언
	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs= null;
	List<BoardVO> boardList = new ArrayList<BoardVO>();
	String sql = "SELECT * FROM requestBoard ORDER BY bid DESC limit ?, 10";
	// 쿼리문(SELECT 구문, 역순, 10개씩 pageNum에 맞춰서);
	
		try {	
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pageNum);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setbId(rs.getInt("bid"));
				board.setbWriter(rs.getString("bwriter"));
				board.setbTitle(rs.getString("btitle"));
				board.setbContent(rs.getString("bcontent"));
				board.setbHit(rs.getInt("bhit"));
				board.setbDate(rs.getTimestamp("bdate"));
				
				boardList.add(board);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		
		} finally {
			
			try {
				if(con!=null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if(rs !=null && !rs.isClosed()) {
					rs.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
	
} return boardList;
		
}// paging 끝


public int getCountBoard() {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	int countBoard = 0 ;
	
	String sql = "SELECT COUNT(*) FROM requestBoard";
	
	try {
		con = ds.getConnection();
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
		countBoard = rs.getInt(1);
		}
		
				
		
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(con!=null&&!con.isClosed()) {
				con.close();
			}
			if(pstmt!=null&&!pstmt.isClosed()) {
				con.close();
			}
			if(rs!=null&&!rs.isClosed()) {
				rs.close();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	return countBoard;
}

public BoardVO getBoardDetail(String bId) {
	// bId에 해당하는 글 정보를 가져와서 리턴하도록 로직 작성해주셍
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	BoardVO board = new BoardVO();
	
	String sql = "SELECT * FROM requestBoard WHERE bid=?";
	
	try {
		con=ds.getConnection();
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bId);
		rs=pstmt.executeQuery();
		
		
		if(rs.next()) {
			board.setbId(rs.getInt("bid"));
			board.setbTitle(rs.getString("btitle"));
			board.setbContent(rs.getString("bcontent"));
			board.setbWriter(rs.getString("bwriter"));
			board.setbDate(rs.getTimestamp("bdate"));
			board.setbHit(rs.getInt("bhit"));
		}
		
		
		
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(con!=null&&!con.isClosed() ) {
				con.close();
			}
			if(pstmt!=null&&!pstmt.isClosed() ) {
				pstmt.close();
			}
			if(rs!=null&&!rs.isClosed() ) {
				rs.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} return board;
}// getBoardDetail 끝

public void upHit(String bid) {
	// 필요 변수들을 생성
	Connection con = null;
	PreparedStatement pstmt = null;
	
	// 특정 글의 조회수를 1 올리는 쿼리문
	String sql = "UPDATE requestBoard SET bhit = bhit + 1 " +
	"WHERE bid = ?";
	
	
	// DB 연결 후 코드 실행
	try { 
		con=ds.getConnection();
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bid);
		pstmt.executeUpdate();
		
				
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			
			if(con!=null&&!con.isClosed()) {
				con.close();
			}
			if(pstmt!=null&&!pstmt.isClosed()) {
				pstmt.close();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
} // upHit 끝
	
}
