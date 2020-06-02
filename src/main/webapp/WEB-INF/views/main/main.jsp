<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODOLIST</title>
<script src="/resources/js/jquery-3.5.1.min.js" type="text/javascript" type="text/javascript"></script>
</head>
<body>
	<div>
		<div>
			<h1>MY TODO LIST</h1>
		</div>
		
		<form id="login_form" method="post">
		<div id="main">
			<table>
				<tr>
					<td><lable>아이디 : </lable></td><td><input name="userId" id="userId" width="20px"/></td>
				</tr>
				<tr>
					<td><lable>비밀번호 : </lable></td><td><input name="userPasswd" id="userPasswd" type="password" width="20px"/></td>
				</tr>
			</table>
		</div>
		</form>
	</div>
	<div>
		<button id="btnLogin">로그인</button>
	</div>
	
<script>
	$("#btnLogin").click(function () {
		let userId = $("#userId").val();
		let userPasswd = $("#userPasswd").val();
		
		if(userId == '') {
			alert('아이디를 입력하세요.');
			return;
		} else if (userPasswd == ''){
			alert('패스워드를 입력하세요.');
			return;
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/login",
			dataType : "Json",
			type : "post",
			data : $("#login_form").serialized(),
			success : function() {
				document.location.href="${pageContext.request.contextPath}/todolist";
			}
		})
	});
</script>
</body>
</html>
