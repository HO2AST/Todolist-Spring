<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery-3.5.1.min.js" type="text/javascript" type="text/javascript"></script>
</head>
<body>
	<div>
		TODOLIST
	</div>
	<div>
		<form id="todo_form" method="post">
			<input type="hidden" id="userId" name="userId" value="${id}"/>
			<input name="todo" id="todo" type="text" width="100px" height="15px" placeholder="할일을 입력하세요."/><button id="write">등록하기</button>
		</form> 
		<div id="todolist">
			
		</div>
	</div>
	

<script>
	$("#write").click(function() {
		let todolist = $("#todo").val();
		
		if (todolist == "") {
			alert("할일을 입력하세요.")
			return false;
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/todolist/wirte",
			type : "post"
			data : $("#todo_form").serialize(),
			success : function(data) {
				let addTodo = ""
				addTodo += '<div class="todo">'+data.todo+'</div>';
				$("#todolist").append(addTodo);
			},
			error : function(request, status, error) {
				alert("문제가 발생했습니다.");
			}
		})
	});
</script>
</body>
</html>