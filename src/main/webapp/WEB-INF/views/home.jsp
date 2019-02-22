<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
	<script  src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#aa").click(function(){
				var data={"targetid":"user1","sender":"user2","message":"Hello"};
				$.ajax({
					type:"POST",
					url:"/controller/messages/",
					contentType:"application/json; charset=UTF-8",
					dataType:"JSON",
					data:JSON.stringify(data),
					success:function(data){
						
					},
					error:function(e){
						
					}
				});
			});
		})
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="sample/ex01?name=AAA&age=10">ex01</a>
<a href="sample/ex02?name=BBB&age=20">ex02</a>
<a href="sample/ex021?name=CCC&age=30">ex021</a>
<a href="sample/ex02List?ids=111&ids=222&ids=333">ex02List</a>
<a href="sample/ex04?name=DDD&age=40&page=1">ex04</a>
<a href="sample/ex041?name=EEE&age=50&page=2">ex041</a>
<a href="sample/ex06">ex06(json)</a>
<a href="sample/ex07">ex07(response)</a>
<a href="testTx">testTx</a><br>
<input type="button" id="aa">클릭
</body>
</html>
