<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기 폼</title>
</head>
<body>
	<h1>요청게시판 글쓰기 창</h1>
	<form action = "/hongbapProejct/board/boardwrite.do" method="post">
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
 					<td> 글 제목</td>
 					<td><input type="text" name ="title" required></td>
 				</tr>
 				<tr>
 					<td> 글본문</td>
 					<td><textarea cols="50" rows="10" name="content"required></textarea></td>
 				</tr>
 				<tr>
 					<td> 글쓴이</td>
 					<td><input type="text" name="writer"value="${board.bWriter }" required></td>
 				</tr>
	 		</table>
	 		<input type = "submit" value="글쓰기">
	 		<input type = "reset" value="초기화">
	 </form>

</body>
</html>