<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hong Bop Login</title>
	<style>
		td{
			color : blue;
		}
	
	</style>
</head>
<body>
	<form action="http://localhost:8181/hongbapProject/login.do" method="post">
		<table border="1">
			<tr >
				<th>HongBob 로그인!!</th>
			</tr>
			<tr>
				<td><strong>ID</strong> : <input type="text" name="UserId" placeholder="ID"></td>
			</tr>
			<tr>
				<td><strong>PW</strong> : <input type="password" name="UserPw" placeholder="PW"></td>
			</tr>
		</table>
		<table >
			<tr >
				<th><input type ="submit" value="로그인"></th>
				<th><a href="http://localhost:8181/hongbapProject/user/userJoin.jsp"><input type ="button" value="회원가입"></a></th>
				
			</tr>
		</table>
	</form>

</body>
</html>
