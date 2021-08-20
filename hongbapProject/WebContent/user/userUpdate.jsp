<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hong Bop 회원정보수정창</title>
	<style>
		td{
			color : blue;
		}
	
	</style>
</head>
<body>
	
		<h2>회원 정보 수정</h2>
	
	<form action="http://localhost:8181/hongbapProject/user/userUpdate.do" method="post">
	 	<input type="hidden" value="${user.userId}" name="UserId">
		<input type="hidden" value="${user.userPw }" name="UserPw">
		<input type="hidden" value="${user.userEmail }" name="UserEmail">
		<input type="hidden" value="${user.userName }" name="UserName">
		<input type="hidden" value="${user.userNick }" name="UserNick">
		<input type="hidden" value="${user.userPnum }" name="UserPnum"> 
		<table border="1">
			<tr>
				<td><strong>ID</strong> : <input type="text" name="UserId" placeholder="ID" required></td>
			</tr>
			<tr>
				<td><strong>PW</strong> : <input type="password" name="UserPw" placeholder="PW"required></td>
			</tr>
			<tr>
				<td><strong>Name</strong> : <input type="text" name="Name" placeholder="Name"required></td>
			</tr>
			<tr>
				<td><strong>NickName</strong> : <input type="text" name="UserNick" placeholder="NickName"required></td>
			</tr>
			<tr>
				<td><strong>Email</strong> : 
				<input type="email" name="UserEmail" placeholder="email"></td>
			</tr>
			<tr>
				<td><strong>Pnum</strong> : 
				<input type="tel" name="UserPnum" placeholder="Pnum"></td>
			</tr>
		</table>
		<table>
			<tr>
				<th><input type ="submit" value="제출" ></th>
				<th><input type ="reset" value="초기화"></th>
			</tr>
		</table>
	</form>

</body>
</html>
