<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<div>
		<h1>HongBap Random Pick</h1>
		<h2> 오늘의 추천식당~!!!</h2>
		<div class="randomimg">
			${randomResult.resName} <%--뒷배경가게사진 --%>
		</div>
		<p><a href="가게리스트.do?page=${randomResult.resId}">보러가기~</a></p>	
	</div>
	<div>
	<a href="http://localhost:8181/hongbapProject/randompick.do"><input type="button"value="다른식당뽑기~!"></a>
	<a href="http://localhost:8181/hongbapProject/login.do"><input type="button"value="뒤로가기"></a>
	</div>
</body>
</html>