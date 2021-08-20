<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원님의 비밀 번호를 다시 입력해주세요</h2>
	<form action="http://localhost:8181/hongbapProject/user/userDelete.do" method="post">
		<input type="password" name="UserPw" placeholder="비밀번호입력">
		<input type="submit" value="제출">
	</form>

</body>
</html>