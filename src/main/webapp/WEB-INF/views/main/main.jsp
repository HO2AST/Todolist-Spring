<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOLIST</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js" type="text/javascript" type="text/javascript"></script>
<script>
	function loginCheck() {
		alert('안녕하세요');
	}
</script>
</head>
<body>
	<div>
		<div>
			<h1>MY TODO LIST</h1>
		</div>
	
		<div id="main">
			<table>
				<tr>
					<td><lable>아이디 : </lable></td><td><input id="userId" width="20px" placeholder="아이디"/></td>
				</tr>
				<tr>
					<td><lable>비밀번호 : </lable></td><td><input id="userPasswd" width="20px"/></td>
				</tr>
			</table>
		</div>
	</div>
	<div>
		<button id="btnLogin" onclick="loginCheck()">로그인</button>
	</div>
</body>
</html>