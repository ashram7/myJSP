<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
   String name = request.getParameter("name" ) ;
   String imgName = request.getParameter("imgName" ) ;
%>    
<!DOCTYPE html>
<!-- 
@ 디렉티브 (jsp 문서형식선언문)
! 선언문(변수선언)
= 표현식(변수)
스트립트릿 (변수선언 포함 문장)
-->
<html>
<head>
	<meta charset="UTF-8">
	<title>듀크이미지</title>
</head>
<body>
	<br><br>
	<h1>이름은 <%= name%>입니다. </h1><br><br>
	<img src="./image/<%=imgName %>"  />	
</body>
</html>












