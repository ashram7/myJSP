<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int dan=Integer.parseInt(request.getParameter("dan"));
%>      
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>구구단 출력창</title>
</head>
<body>
<!-- 
	@ 디렉티브 (jsp 문서형식선언)
	! 선언문 (변수선언)
	= 표현식 (변수)
	  스트립트릿 (변수선언 포함 문장)
-->
	<table border="1" width="800">
		<tr align="center" bgcolor="#ffff66">
			<td colspan="2"><%= dan %> 단 출력</td>
		</tr>
		<!-- for문을 넣어야 함 -->
		<% 
		for(int i=1; i<10; i++){
			if(i%2==1){
		%>	
				<tr align="center"  bgcolor="#ff0066">
		<% 			
			}else{
		%>	
				<tr align="center"  bgcolor="#ff00ff">
		<% 						
			}
		%>			
			<td width="400"><%= dan %>  *  <%= i %></td>
			<td width="400"><%= i*dan %></td>
		</tr>
		<%
		}
		%>
	</table>	
</body>
</html>








