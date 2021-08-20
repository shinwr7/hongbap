<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중식 게시판</title>
</head>
<body>
	<h1>${res.resCategory }게시판목록</h1>
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>글쓴이</th>
				<th>쓴날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="${res.resCategory }게시판" items="${게시판리스트}">
			<tr>
				<td>${res.resId }</td>
				<td><a href="게시판.do?게시판글넘버=${res.resId}">${res.resTitle }</a></td>
				<td>${user.UserNick }</td>
				<td>${date}</td>
				<td>${hit }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<%-- 페이징 버튼 만들기 --%>
	<c:if test="${pageDTO.hasBoard()}">
		<%-- 뒤로가기 버튼을 표시할지 말지 결정하는 부분 --%>
		<c:if test="${pageDTO.startPage>10 }">
		<%-- 1보다 크기만 해도 상관은없지만 직관적으로 표현하기위해 뒤로가기 링크를 10이상 으로 해놧음--%>
			<a href="/MyFirstWeb/boardselect.do?page=${pageDTO.startPage-10 }">[prev]</a>
		</c:if>
		<%--페이지 번호 10개 묶음을 깔아주는 부분 --%>
		<c:forEach var="pNo" begin="${pageDTO.startPage}" end="${pageDTO.endPage}">
			<a href="/MyFirstWeb/boardselect.do?page=${pNo}">[${pNo}]</a>
		</c:forEach>
		<%-- 다음으로 가기 버튼을 표시할지 말지 결정하는 부분 --%>
		<c:if test="${pageDTO.endPage<pageDTO.totalPages }">
			<a href="/MyFirstWeb/boardselect.do?page=${pageDTO.startPage+10}">[next]</a>
		</c:if>
	</c:if>
</body>
</html>