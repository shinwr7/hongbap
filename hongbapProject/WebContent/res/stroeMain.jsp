<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${가게이름 }</title>
</head>
<body>
<h1>${res.resName }</h1>
    <img width="300px" height="300px" src="이미지파일 주소">
    <ul>
        <li>전화번호 : ${res.resPnum} </li>
        <li>주소 : ${res.resAddr}</li>
        <li>영업시간 : ${res.resTime}</li>
        <li>휴무일 : ${res.resHoliday}</li>
        <li><a href="${res.resHomepage }">홈페이지</a></li>
    </ul>
 <%--    <form action="상의필요" method="post">
    	<p>식당 만족도</p>
    	<div>
    		<input type="radio" name="" value="상">
    		<input type="radio"  name="" value="중">
    		<input type="radio" name="" value="하">
    	</div>
    	<input type="submit" value="평점주기">
    </form> --%>
    <p><a href="#">뒤로가기</a></p>
    


</body>
</html>