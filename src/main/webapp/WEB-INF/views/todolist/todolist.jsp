<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		TODOLIST
	</div>
	<div>
		<form id="todo_form" method="post">
			<input name="todo" id="todo" type="text" width="100px" height="15px" placeholder="할일을 입력하세요."/>
		</form>
		<button id="write">등록하기</button>
		<div id="todolist">
			
		</div>
	</div>
</body>
</html>