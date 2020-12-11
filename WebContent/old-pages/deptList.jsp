<%@page import="model.dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/deptList.jsp"> 
<title>부서정보 목록</title>
</head>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("utf-8");
ArrayList<DeptVO> deptList = (ArrayList<DeptVO>)request.getAttribute("deptList");
%>

<body>
<h1>부서정보 목록 페이지</h1>
	<h3>
		<a href="../index.jsp">홈</a>
		<a href="insertDept.jsp">부서등록</a>
	</h3>
<table border="1">
	<tr>
		<td>부서번호</td>
		<td>부서이름</td>		
		<td>부서위치</td>
		<td>부서설정</td>
	</tr>

<%
	for(int i=0; i<deptList.size(); i++){
		%>
	<tr>
	<td><%=deptList.get(i).getDeptno() %>
	</td>
	<td><%=deptList.get(i).getDname() %>
	</td>
	<td><%=deptList.get(i).getLoc() %>
	</td>
	<%int  deptno = deptList.get(i).getDeptno(); %>
	<td><a href="./updateDept.de?deptno=<%=deptno%>">수정</a>
		<a href="./deleteDept.de?deptno=<%=deptno%>">삭제</a>
	</td>
	</tr>		
		<%
		}
%>

	
</table>
</body>
</html>