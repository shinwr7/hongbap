<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>관리자용 음식점 추가폼</h2>
	<form action="가게추가.do" method="post">
	<div> 가게 이미지 : <img src="이미지파일위치"></div>
		<table>
		<tr>
	 			<td>음식카테고리</td>
	 			<td><select name="resCategory">
	 				<option value="한식">한식</option>
	 				<option value="중식">중식</option>
	 				<option value="일식">일식</option>
	 				<option value="양식">양식</option>
	 				<option value="분식">분식</option>
	 				<option value="패스트푸드">패스트푸드</option>
	 			</select></td>
	 		</tr></table>
		<input type="text" name="resName" value="가게이름"><br/>
		<input type="text" name="resAddr" value="가게주소"><br/>
		<input type="tel" name="resPnum" value="가게전화번호"><br/>
		<input type="text" name="resTime" value="영업시간"><br/>
		<input type="text" name="resHoliday" value="가게 휴무일"><br/>
		<input type="text" name="resHomepage" value="가게홈페이지"><br/>
	</form>
	<div><input type="submit" value="제출"><input type="reset" value="초기화"><br/></div>
	<div>
		<a href="메인게시판.do"><input type="button" value="메인홈"></a>
	</div>

</body>
</html>