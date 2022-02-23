<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 폼</h1>
<form name="frm_join" action="regist" >
	<input type="text" name="id" placeholder="id를 입력하세요" onchange="idchange()">
	<input type="button" name="idcheck" value="중복확인" onclick="idcheck1()" >
	<input type="text" id="regflag" size="3" value="0" >
	<br>
	<div id="checkmsg">아이디 중복확인 하세요.</div>
	<input type="text" name="pw" placeholder="pw를 입력하세요"><br>
	<input type="text" name="username" placeholder="이름을 입력하세요"><br>
	<input type="submit" value="등록" onclick="return checkForm()">
	
</form>
<script>
	window.open("popup.html", "new", "width=700, height=700");
	
	var checkmsg = document.querySelector("#checkmsg");
	var regflag = document.querySelector("#regflag");
	
	var xhr = new XMLHttpRequest();
	function idcheck1(){
		var id = document.querySelector("input[name='id']").value;
		//alert("idcheck1.......실행");
		if(id == ""){
			alert("id를 입력하세요.");
			//document.querySelector("input[name='id']").focus();
			return;
		}
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200 ){
				var result = xhr.responseText;
				if(result == 1){
					regflag.value = "0";
					checkmsg.innerHTML = "<span style='color: red'>사용중인 아이디 입니다. 다른 아이디를 사용하세요.</span>";
				}else{
					regflag.value = "1";					
					checkmsg.innerHTML = "<span style='color: blue'>사용가능한 아이디 입니다.</span>";
				}
			}
		}
		xhr.open("get", "idcheck?id="+id, true);
		xhr.send();
	}
	function idcheck(){
		alert("idcheck...실행");
		
	}
	
	function idchange(){
		//alert("id changed!!");
		regflag.value = "0";
	}
	
	function checkForm(){
		if(document.querySelector("input[name='id']").value.length == 0){
			alert("id를 입력하세요.");
			document.querySelector("input[name='id']").focus();
			return false;
		}
		if(document.querySelector("input[name='pw']").value.length == 0){
			alert("pw를 입력하세요.");
			document.querySelector("input[name='pw']").focus();
			return false;
		}
		if(regflag.value != "1"){
			alert("id 중복확인 하세요.");
			//docuemnt.querySelector("input[name='id']").focus();
			return false;
		}

		if(document.querySelector("input[name='username']").value.length == 0){
			alert("이름을 입력하세요.");
			document.querySelector("input[name='username']").focus();
			return false;
		}
				
		return true;
	}
</script>
</body>
</html>