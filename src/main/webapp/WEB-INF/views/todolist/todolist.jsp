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
			<input name="todo" id="todo" type="text" width="100px" height="15px" placeholder="할일을 입력하세요."/>
		</form>
		<button id=btnWrite>등록하기</button>
	</div>
	<div>
		<table id="todolist" border="1px solid #444444">
			<tr>
				<td>할일</td>
				<td>등록일자</td>
			</tr>
		</table>
	</div>
<script>
	$(document).ready(function() {
		selectTodo();
	});
	
	
	$("#btnWrite").click(function() {
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
				if (data == "11") {
					addTodo();
				}
			},
			error : function(request, status, error) {
				alert("문제가 발생했습니다.");
				return;
			}
		})
	});
	
	function selectTodo() {
		let userId = $("#userId").val();
		$.ajax({
			url: "${pageContext.request.contextPath}/todo/select",
			type: "POST",
			datatype: "JSON",
	        contentType: "application/json",
			data: JSON.stringify({"userId" : userId}),
			success: function(data) {
				if(data.length > 0) {
					$.each(data, function (index, item) {
						$("#todolist").append("<tr><td>"+data[index].TODO+"</td><td>" + data[index].REGDATE +"</td></tr>")
					})
				}
			},
			error: function(request, status, error) {
				alert("문제가 발생");
				return;
			}
		})
	}
	
	function addTodo() {
		let userId = $("#userId").val();
		$.ajax({
			url: "${pageContext.request.contextPath}/todo/add",
			type: "POST",
			datatype: "JSON",
	        contentType: "application/json",
			data: JSON.stringify({"userId" : userId}),
			success: function(data) {
				let index = data.length - 1;
				$("#todolist").append("<tr><td>"+data[index].TODO+"</td><td>" + data[index].REGDATE +"</td></tr>")
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
