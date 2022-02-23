<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Detail Page</h1>
<hr>
<p>제목 : ${dto.title }</p>
<p>내용 : ${dto.content }</p>
<p>작성자 : ${dto.writer }</p>
<p>작정일자 : ${dto.regdate }</p>

<hr>
<button name="btn_modify" >수정</button>
<button name="btn_delete">삭제</button>
</body>
</html>