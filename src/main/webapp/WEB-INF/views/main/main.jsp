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
					<td><label>아이디 : </label></td><td><input name="userId" id="userId" width="20px"/></td>
				</tr>
				<tr>
					<td><label>비밀번호 : </label></td><td><input name="userPasswd" id="userPasswd" type="password" width="20px"/></td>
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
		
		let loginForm = $("#login_form").serialize();
		
		console.log(loginForm);
		
		$.ajax({
			url : "${pageContext.request.contextPath}/member/login",
			type : "post",
			data : $("#login_form").serialize(),
			success : function(data) {
				if (data == "1") {
	 				document.location.href="${pageContext.request.contextPath}/todolist/";
				} else {
					alert("아이디 혹은 비밀번호를 확인해주세요.");
				}
			},
			error :  function (request, status, error) {
				alert("실패" + status +  error);
			}
		})
	});
</script>
</body>
</html>
