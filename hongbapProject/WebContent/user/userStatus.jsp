<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="회원정보.do" method="post">
		<div>
			<p>ID : ${userInfo.userId }</p>
		</div>
		<div>
			<p>PW : ${userInfo.userPw }</p>
		</div>
		<div>
			<p>NickName : ${userInfo.userNick }</p>
		</div>
		<div>
			<p>Email : ${userInfo.userEmail }</p>
		</div>
		<div>
			<p>PhoneNumber : ${userInfo.userPnum }</p>
		</div>
		
		<a href="http://localhost:8181/hongbapProject/user/userUpdate.jsp"><input type="button" value="회원정보수정"></a>
		<a href="http://localhost:8181/hongbapProject/user/userDelete.jsp"><input type="button" value="회원탈퇴요청"></a>
		<a href="http://localhost:8181/hongbapProject/hongbapMain/hongbapMain.jsp"><input type="button" value="메인게시판이동"></a>
		
	</form>
	
	

</body>
</html>