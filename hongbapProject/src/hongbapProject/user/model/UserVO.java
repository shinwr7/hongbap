package hongbapProject.user.model;

public class UserVO {
	
	private String UserId;
	private String UserPw;
	private String UserName;
	private String UserEmail;
	private String UserPnum;
	private String UserNick;
	
	public UserVO() {
		
	}

	public UserVO(String userId, String userPw, String userName, String userEmail, String userPnum, String userNick) {
		super();
		UserId = userId;
		UserPw = userPw;
		UserName = userName;
		UserEmail = userEmail;
		UserPnum = userPnum;
		UserNick = userNick;
	}

	public String getUserNick() {
		return UserNick;
	}

	public void setUserNick(String userNick) {
		UserNick = userNick;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserPw() {
		return UserPw;
	}

	public void setUserPw(String userPw) {
		UserPw = userPw;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getUserPnum() {
		return UserPnum;
	}

	public void setUserPnum(String userPnum) {
		UserPnum = userPnum;
	}

	@Override
	public String toString() {
		return "UserVO [UserId=" + UserId + ", UserPw=" + UserPw + ", UserName=" + UserName + ", UserEmail=" + UserEmail
				+ ", UserPnum=" + UserPnum + "]";
	}

}