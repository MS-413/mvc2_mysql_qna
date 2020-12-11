<%@page import="model.emp.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/empList.jsp"> 
<title>사원정보 목록</title>
</head>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("utf-8");

ArrayList<EmpVO> evo = (ArrayList<EmpVO>)request.getAttribute("list");
%>

<body>
<h1>사원정보 목록 페이지</h1>
	<h3>
		<a href="../index.jsp">홈</a>
		<a href="insertEmp.jsp">사원등록</a>
	</h3>	
	<form action="empSearchList.jsp" method="get">
		검색 키워드 <input type="text" name="keyword" placeholder="검색어 입력">
		<button type="submit">검색</button>
	</form>	
<table border="1">
	<tr>
		<td>사원번호</td>
		<td>사원이름</td>
		<td>사원직책</td>
		<td>입사날짜</td>
		<td>부서번호</td>
	</tr>
	<%
	for(int i = 0; i < evo.size(); i++){
	int empno = evo.get(i).getEmpno();%>
		<tr>
		<td><a href="empDetail.em?empno=<%=empno%>"><%=empno %></a></td>
		<td><%=evo.get(i).getEname() %></td>
		<td><%=evo.get(i).getJob() %></td>
		<td><%=evo.get(i).getHiredate() %></td>
		<td><%=evo.get(i).getDeptno() %></td>
		<td><a href="./empModify.em?empno=<%=empno%>">수정</a>
		<a href="./deleteEmp.em?empno=<%=empno%>">삭제</a>
		</td>
		</tr>	
	<%}
	%>
</table>
</body>
</html>