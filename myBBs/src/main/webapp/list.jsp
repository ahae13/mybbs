<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>list Page</h1>
<hr>
<c:if test="${user ne null }" >
<p>${user } 접속중 &nbsp;&nbsp; <a href="logout">로그아웃</a></p>
<button name="btn_write">글쓰기</button><br>
</c:if>
<c:if test="${user eq null }" >
<p>guest 접속중  &nbsp;&nbsp; <a href="loginForm">로그인</a></p>
</c:if>

<table border="1">
	<tr>
		<th>no</th><th>title</th><th>writer</th><th>regdate</th><th>replyCnt</th>
	</tr>

	<tr>
	<c:forEach var="bbs" items="${list }">
	<tr>
		<td>${bbs.num }</td>
		<td><a href="bbs_detail?num=${bbs.num }">${bbs.title }</a></td>
		<td>${bbs.writer }</td>
		<td>${bbs.regdate }</td>
		<td>${bbs.replycnt }</td>
	</c:forEach>
	</tr>
</table>

</body>
</html>