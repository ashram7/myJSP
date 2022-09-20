<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
   String name = "듀크";
   public String getName(){ return name;}
%>     
<!DOCTYPE html>
<!-- 변수 선언문 -->
<html>
<head>
	<meta charset="UTF-8">
	<title>선언문 연습</title>
</head>
<body>
	<!-- 표현식 변수 -->
	<h1>안녕하세요 <%=name %>님!!</h1>
</body>
</html>



