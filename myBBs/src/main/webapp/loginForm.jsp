<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frm" action="login" method="get">
	<input type="text" name="id" placeholder="id를 입력하세요"><br>
	<input type="password" name="pw" placeholder="pw를 입력하세요"><br><br>
	<input type="submit" value="login"><br>
	<input type="button" name="btn_join" value="회원가입"><br>
</form>


<script>

	var btn_join = document.querySelector("input[name='btn_join']");
	btn_join.addEventListener("click", function(){
		
		location.href="join";
	});
	
	
	
</script>
</body>
</html>