<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인창</title>
<style>
	h1{ margin:0; text-indent: 35px;}
	.random{width: 180px; padding: 25px;
               text-align: justify;}
    .randomTable{ background-image:url("img\tabacco.jpg");
        			background-color:#D9ETFF;}
</style>
</head>
<body>
<h1>HongBap</h1><h2>SELCET * FROM Menu </h2>
<h3>${id_session}님 오신것을 환영합니다~!</h3>
	<form action ="메인.do" method="post">
		<a href="http://localhost:8181/hongbapProject/logout.do"><input type=button value="로그아웃"></a>
		<a href="http://localhost:8181/hongbapProject/userinfo.do"><input type=button value="회원정보"></a>
		<table border="1">
			<tr>
				<th>중식</th>
				<th>한식</th>
				<th>양식</th>
			</tr>
			<tr>
				<td><a href ="한식.do">이미지</a></td>
				<td><a href ="중식.do">이미지</a></td>
				<td><a href ="일식.do">이미지</a></td>
			</tr>
		</table ></br>
		<table border="1">
			<tr>
				<th>양식</th>
				<th>분식</th>
				<th>패스트푸드</th>
			</tr>
			<tr>
				<td><a href ="중식.do">이미지</a></td>
				<td><a href ="한식.do">이미지</a></td>
				<td><a href ="양식.do">이미지</a></td>
			</tr>
		</table ><br/>
		<table class="randomTable" border="1">
			<tr>
				<th class="random">
				<a href="http://localhost:8181/hongbapProject/randompick.do">
				<input type="button" value="Hongbap Random Pick">
				</a>
				</th>
			</tr>
			
		</table>
	</form>
	
	
</body>
</html>