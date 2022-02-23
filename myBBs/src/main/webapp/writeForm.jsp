<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write BBS</title>
</head>
<body>
<form name="frm_write" action="write" method="post">
	<input type="text" name="title" placeholder="input title"><br>
	<textarea name="content" placeholder="input your story"></textarea><br>
	<input type="text" name="writer" value="${user }" readonly><br>
	<input type="submit" value="등록" >
</form>
<hr>
<a href="list">목록보기</a>
</body>
</html>