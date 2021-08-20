/*
 * �쉶�썝媛��엯 諛� 濡쒓렇�씤 DAO
UserDAO
DB�뀒�씠釉붾챸�� user
蹂��닔 : 
�쑀�� �븘�씠�뵒 UserId
�쑀�� 鍮꾨�踰덊샇 UserPw
�쑀�� �씠由� UserName
�쑀�� �씠硫붿씪 UserEmail
�쑀�� �룿踰덊샇 UserPnum
 */

  
package hongbapProject.user.model;
import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	
	private DataSource ds;
	
	// �븘�씠�뵒 �궘�젣 由ы꽩蹂��닔
	private static final int ID_DELETE_SUCCESS = 1;
	private static final int ID_DELETE_FAIL = 0;
	
	// �븘�씠�뵒 濡쒓렇�씤 由ы꽩蹂��닔
	private static final int ID_LOGIN_SUCCESS = 1;
	private static final int ID_LOGIN_FAIL = 0;
	
	// �븘�씠�뵒 �닔�젙 由ы꽩蹂��닔
	private static final int ID_UPDATE_SUCCESS = 1;
	private static final int ID_UPDATE_FAIL = 0;
	
	// 而ㅻ꽖�뀡 ��
	private UserDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		return dao;
	}// �뿬湲� 源뚯� 而ㅻ꽖�뀡 ��
	
	// �쉶�썝 媛��엯
	public int JoinUser(UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = ds.getConnection();
			String sql = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(5, user.getUserPnum());
			pstmt.setString(6, user.getUserNick());
			
			pstmt.executeUpdate();
			
		
		} catch(SQLException e) {
			System.out.println("�뿉�윭 : "+e);
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}// end JoinUser
	
	// �쑀�� �궘�젣 
	public int UserDelete(UserVO user, String UserPw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if(user.getUserPw().equals(UserPw)) {
				
			
				con = ds.getConnection();
			String sql = "DELETE FROM user WHERE UserId=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
		
			
			pstmt.executeUpdate();
			
			return ID_DELETE_SUCCESS;
		}else {
			
			return ID_DELETE_FAIL;
		}
		
		} catch(SQLException e) {
			System.out.println("�뿉�윭 : "+e);
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ID_DELETE_FAIL;
	}// end UserDelete
	
	// �쑀�� 濡쒓렇�씤
	public int UserLogin(UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM user WHERE UserId=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			
			// DB�뿉�꽌 媛��졇�삤�뒗 �븘�씠�뵒, 鍮꾨쾲
			String dbId = rs.getString("UserId");
			String dbPw = rs.getString("UserPw");
			
				if(user.getUserId().equals(dbId)&&user.getUserPw().equals(dbPw)) {
					return ID_LOGIN_SUCCESS;
				} else {
					return ID_LOGIN_FAIL;
				}
				
			} else {
				return ID_LOGIN_FAIL;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}  finally{
			try {
			if(con != null && !con.isClosed()){
			con.close();
			}
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
		return ID_LOGIN_FAIL;
	}// end UserLogin 
	
	// �닔�젙�쓣 �쐞�븳 �쑀�� �젙蹂� 
	public UserVO GetUserInfo(UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		UserVO resultData = new UserVO();
		
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM user WHERE UserId=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				resultData.setUserId(rs.getString("UserId"));
				resultData.setUserPw(rs.getString("UserPw"));
				resultData.setUserName(rs.getString("UserName"));
				resultData.setUserEmail(rs.getString("UserEmail"));
				resultData.setUserPnum(rs.getString("UserPnum"));
				resultData.setUserNick(rs.getString("UserNick"));
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		}  finally{
			try {
			if(con != null && !con.isClosed()){
			con.close();
			}
			if(pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
		return resultData;
		
}// end GetUserInfo
	
	// �쑀�� �닔�젙
	public int UserUpdate(UserVO user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
				
			
			
			con = ds.getConnection();
			String sql = "UPDATE user SET UserPw=?, UserName=?, UserEmail=?, UserNick=?, UserPnum=? WHERE UserId=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserPw());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserNick());
			pstmt.setString(5, user.getUserPnum());
			pstmt.setString(6, user.getUserId());
		
			
			pstmt.executeUpdate();
			
			return ID_UPDATE_SUCCESS;
		
			
			
		
		
		} catch(SQLException e) {
			System.out.println("�뿉�윭 : "+e);
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ID_UPDATE_FAIL;
	}// end userUpdate
	
	// �쑀�� �젙蹂� 由ъ뒪�듃
	public ArrayList<UserVO> GetAllUser() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<UserVO> userList = new ArrayList<>();
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM user";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				UserVO user = new UserVO();
				String UserId = rs.getString("UserId");
				String UserPw = rs.getString("UserPw");
				String UserName = rs.getString("UserName");
				String UserEmail = rs.getString("UserEmail");
				String UserNick = rs.getString("UserNick");
				String UserPnum = rs.getString("UserPnum");
				
				user.setUserId(UserId);
				user.setUserPw(UserPw);
				user.setUserName(UserName);
				user.setUserEmail(UserEmail);
				user.setUserNick(UserNick);
				user.setUserPnum(UserPnum);
				userList.add(user);
			}
			
			} catch(SQLException e) {
				System.out.println("�뿉�윭 : "+e);
			} finally {
				try {
					if(con != null && !con.isClosed()) {
						con.close();
					}
					if(pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}	
			return userList;
		}// end GetAllUser
	
	public String getUserNick (String userId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT UserNick FROM user WHERE UserId=?";
		String userNick = null;
		
		try {
			
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				userNick=rs.getString("UserNick");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null&&!con.isClosed()) {
					con.close();
				}
				if(pstmt!=null&&!pstmt.isClosed()) {
					pstmt.close();
				}
				if(rs!=null&&!rs.isClosed()) {
					rs.close();
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return userNick;
	}
	
	}


