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
		TODOLIST
	</div>
	<div>
		<form id="todo_form" method="post">
			<input type="hidden" id="userId" name="userId" value="${id}"/>
			<input name="todo" id="todo" type="text" width="100px" height="15px" placeholder="할일을 입력하세요."/><button id="writeTodo">등록하기</button>
		</form> 
	</div>
	<div id="todolist">
		
	</div>
<script>
	$("#writeTodo").click(function() {
		let todolist = $("#todo").val();
		
		if (todolist == "") {
			alert("할일을 입력하세요.")
			return false;
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/todo/write",
			type : "post",
			data : $("#todo_form").serialize(),
			success : function(data) {
				console.log("/write = " + data);
				if (data == "11") {
					selectTodo();
				}
			},
			error : function(request, status, error) {
				alert("문제가 발생했습니다.");
				return;
			}
		})
	});
	
	function selectTodo() {
		$.ajax({
			url: "${pageContext.request.contextPath}/todo/select",
			type: "post",
			datatype: "JSON",
			data: {userId : $("#userId").val()},
			success: function(data) {
				consol.log(data.get(1));
				if(data.size() > 0) {
	 				document.location.href="${pageContext.request.contextPath}/todo";
				}
			},
			error: function(request, status, error) {
				alert("문제가 발생");
				return;
			}
		})
	}
</script>
</body>
</html>