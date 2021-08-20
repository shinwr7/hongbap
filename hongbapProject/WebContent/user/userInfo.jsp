<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

유저 정보: ${userInfo}

</head>
<body>
	<form>
		아이디<input type="text" value="${userInfo.userId}"><br/>
		패스워드<input type="password" value="${userInfo.userPw}"><br/>
		이름<input type="text" value="${userInfo.userName}"><br/>
		이메일<input type="text" value="${userInfo.userEmail}"><br/>
		전화번호<input type="text" value="${userInfo.userPnum}">
	</form>
</body>
</html>