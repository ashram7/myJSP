<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     request.setCharacterEncoding("utf-8");
     String user_id=request.getParameter("user_id");
     String user_pw=request.getParameter("user_pw");
%>	    
<!DOCTYPE html>
<!-- 
	@ 디렉티브 (jsp 문서형식선언)
	! 선언문 (변수선언)
	= 표현식 (변수)
	  스트립트릿 (변수선언 포함 문장)
-->
<html>
<head>
	<meta charset="UTF-8">
	<title>결과출력창</title>
</head>
<body>
<%
	if(user_id==null || user_id.length()==0){
%>
	아이디를 입력하세요.<br>
	<a href="/pro12/login.html">로그인하기</a>
<%	
	} else {
%>		
	<h1>아이디  : <%= user_id %></h1>	
<%		
	}
%>    
    	
</body>
</html>






