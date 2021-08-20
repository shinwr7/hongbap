<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="유저요청게시판.do" method="post">
	 		<table border="1">
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
	 		</tr>
 				<tr>
 					<td> 가게이름</td>
 					<td><input type="text" name ="title" required></td>
 				</tr>
 				<tr>
 					<td> 글본문</td>
 					<td><textarea cols="100" rows="10" name="content"required placeholder="추천 하고자 하시는 가게의 정보 및 이유를 작성해주세요 검토후 추후 업데이트에 반영하겠습니다.">
가게이름 :
가게위치 :
가게주소 : 
가게전화번호 :
가게추천메뉴(다메뉴 추천 가능) : 
 					</textarea></td>
 				</tr>
 				<tr>
 					<td> 글쓴이</td>
 					<td><input type="text" name="writer"value="${board.bName }" required></td>
 				</tr>
	 		</table>
	 		<input type = "submit" value="글쓰기">
	 		<input type = "reset" value="초기화">
	 </form>
		

</body>
</html>