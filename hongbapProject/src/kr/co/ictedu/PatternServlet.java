package kr.co.ictedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hongbapProject.board.service.BoardWriteService;
import hongbapProject.board.service.IBoardService;
import hongbapProject.restaurant.service.IResService;
import hongbapProject.restaurant.service.ResRandomService;
import kr.co.ictedu.service.IUserService;
import kr.co.ictedu.service.UserDeletService;
import kr.co.ictedu.service.UserInfoService;
import kr.co.ictedu.service.UserJoinService;
import kr.co.ictedu.service.UserLoginService;
import kr.co.ictedu.service.UserUpdateService;


/**
 * Servlet implementation class PatternServlet
 */
// *.do 濡� �옟�엺 �뙣�꽩�� .do濡� �걹�굹�뒗 �젒�냽二쇱냼瑜� 紐⑤몢 �옟�븘�샃�땲�떎. 
// �솗�옣�옄 �뙣�꽩�� /瑜� 鍮쇨퀬 �옉�꽦�빀�땲�떎. 
@WebServlet("*.do")
public class PatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatternServlet() { 
        super();
      
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRequest(request, response);
	}
	
	// 留뚯빟 �슂泥� 硫붿꽌�뱶(get, post) �긽愿� �뾾�씠 泥섎━�븯寃� 留뚮뱾怨� �떢�떎硫�
	// 硫붿꽌�뱶 �븯�굹瑜� �뜑 留뚮뱾�뼱�꽌 �슂泥��븳�떎. 
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// �꽌鍮꾩뒪 �샇異쒖쓣 �쐞�빐 紐⑤뱺 �꽌鍮꾩뒪�옄猷뚰삎�쓣 諛쏆쓣 �닔 �엳�뒗
		// �씤�꽣�럹�씠�뒪瑜� �깮�꽦�빀�땲�떎.
		//IBoardService sv = null;
		IUserService usv = null;
		IResService rsv = null;
		IBoardService bsv = null;
		
		// �빐�떦 濡쒖쭅�쓣 �떎�뻾�븳 �뮘�뿉 �꽆�뼱媛� .jsp �뙆�씪 紐낆묶/寃쎈줈 吏��젙
		String ui = null;
		
		// doGet�뿉 �엳�뜕 紐⑤뱺 肄붾뱶瑜� 媛��졇�샃�땲�떎.
		// �꽭�뀡 �벐�뒗 踰�(�꽭�뀡 �궡�옣媛앹껜瑜� �뒪�겕由쏀듃由우뿉�꽌�뒗 諛붾줈 session紐낆묶�쑝濡�
		// �벝 �닔 �엳�뿀�뒗�뜲 �꽌鍮꾩뒪�굹 而⑦듃濡ㅻ윭�뒗 �옄諛� 肄붾뱶�씪�꽌 �깮�꽦�씠 �븞 �릺�뼱 �엳�뼱�꽌
		// �꽭�뀡�씠�씪�뒗 �궡�옣媛앹껜瑜� �벐湲� �쐞�빐 �꽑�뼵�븯怨� �뼸�뼱�삤�뒗寃곷땲�떎.)
		HttpSession session=null;
		session = request.getSession();
		
		// �솗�옣�옄 �뙣�꽩�뿉�꽌 �솗�옣�옄瑜� �룷�븿�븳 二쇱냼媛믪쓣 媛��졇�삤湲� �쐞�빐�꽌
		// �븘�옒 肄붾뱶瑜� �궗�슜�빀�땲�떎.
		// 濡쒖뺄�샇�뒪�듃 8181 �뮘�쓽 uri �뙣�꽩�쓣 �옟�븘�삤�뒗 硫붿꽌�뱶!
		String uri = request.getRequestURI();
		System.out.println("uri : "+ uri);
		
		
		// 肄섏넄�씠 �븘�땶 �궗�슜�옄媛� �솗�씤�븷 �닔 �엳�룄濡� .jsp �솕硫댁뿉
		// 蹂��닔�뿉 �떞湲� �옄猷뚮�� 李띾뒗 out.print(); �궗�슜�쓣 �쐞�븳
		// �궗�쟾 以�鍮�
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// jsp �뙆�씪�씠 html �삎�떇�쑝濡� �씠猷⑥뼱�졇 �엳�쓬�쓣 �븣�젮二쇰뒗 肄붾뱶
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(uri.equals("/hongbapProject/join.do")) {
			usv= new UserJoinService();
			usv.execute(request, response);
			
			ui="/user/userLogin.jsp";
		}else if(uri.equals("/hongbapProject/logout.do")) {
			session.invalidate();
			ui = "/user/userLogin.jsp"; // �떎�떆 吏덈Ц�빐蹂댁옄. 
		
		} else if(uri.equals("/hongbapProject/login.do")) {
			usv = new UserLoginService();
			usv.execute(request, response);
			//�꽭�뀡�뿉�꽌 濡쒓렇�씤 �뿬遺� �솗�씤
			
			String result = (String)session.getAttribute("login");
			System.out.println("result : "+result);
					
			
			
			
			if(result!=null&&result.equals("fail")){
				session.invalidate();
				ui="/user/userLogin.jsp";
			} else {
				ui="/hongbapMain/hongbapMain.jsp";
			}
			
			
		} else if(uri.equals("/hongbapProject/userupdate.do")) {
				usv = new UserUpdateService();
				usv.execute(request, response);
				ui = "/user/userStatus.jsp";
				
			
		} else if(uri.equals("/hongbapProject/user/userDelete.do")) {
				usv = new UserDeletService();
				usv.execute(request, response);
				session.invalidate();
				ui = "/user/userLogin.jsp";
			
		} else if(uri.equals("/hongbapProject/userinfo.do")) {
				usv = new UserInfoService();
				usv.execute(request, response);
				ui = "/user/userStatus.jsp";
				
				
		} else if(uri.equals("/hongbapProject/randompick.do")) {
				rsv = new ResRandomService();
				rsv.excute(request, response);
				ui = "/res/randomPick.jsp";
				
			//寃뚯떆�뙋
		} else if(uri.equals("/hongbapProject/boardwrite.do")) {

			bsv = new BoardWriteService();
			bsv.execute(request, response);
			ui = "hongbapProject/boardselect.do";

					
					
		} else if(uri.equals("/MyFirstWeb/boardupdate.do")) {
			
			//sv = new BoardDetailService();
			//sv.execute(request, response);
			ui = "/board/board_update_form.jsp";
			
		} else if(uri.equals("/MyFirstWeb/boardupdateok.do")) {
			
			
			//sv = new BoardUpdateService();
			//sv.execute(request, response);
			ui = "/boardd=etail.do";
			
		} else if(uri.equals("/MyFirstWeb/boarddelete.do")) {
			
			//sv = new BoardDeleteService();
			//sv.execute(request, response);
			ui="/boardselect.do";
			
			
		} else if(uri.equals("/MyFirstWeb/boarddetail.do")) {
			
			//sv = new BoardDetailService();
			//sv.execute(request, response);
			ui = "/board/board_detail.jsp";
			
			
			
		} else if(uri.equals("/MyFirstWeb/boardselect.do")) {
			
//			sv = new BoardListService();
//			sv.execute(request, response);
//			ui = "/board/board_list.jsp";
// 			�쐞�쓽 �씪諛� �쟾泥닿쾶�떆臾� 媛��졇�삤湲곕�� �럹�씠吏� 媛��졇�삤湲곕줈 ��泥댄빐二쇱꽭�슂!
			
			//sv = new BoardPagingService();
			//sv.execute(request, response);
			
			ui = "/board/board_list.jsp";
			
			
			
		
		}else {
		
		}
		
		// �룷�썙�뱶 濡쒖쭅�� 議곌굔臾몄씠 紐⑤몢 �옉�룞�븳 �뮘�뿉 �떎�뻾�빀�땲�떎.
		// RequestDispatcher瑜� �궗�슜�빐 �룷�썙�뵫�쓣 �븯硫�
		// request, response瑜� jsp�럹�씠吏��뿉 �쟾�떖�븷 �닔 �엳�뒿�땲�떎.
		// 紐⑤뜽 2諛⑹떇�� �뒪�겕由쏀듃由우쓣 �벐吏� �븡湲� �븣臾몄뿉
		// 而⑦듃濡ㅻ윭�떒�뿉�꽌 異쒕젰�뿉 �븘�슂�븳 �뜲�씠�꽣瑜� 諛쏆븘�넧�떎
		// �룷�썙�뱶濡� .jsp�뿉 �쟾�떖�빀�땲�떎.
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
	}
	
	

}
