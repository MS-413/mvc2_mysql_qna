<%@page import="model.dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/deptList.jsp"> 
<title>부서정보 목록</title>
</head>
<body>
<h1>부서정보 목록 페이지</h1>
	<h3>
		<a href="../../index.jsp">홈</a>
		<a href="insertDept.jsp">부서등록</a>
	</h3>
<table border="1">
	<tr>
		<td>부서번호</td>
		<td>부서이름</td>		
		<td>부서위치</td>
		<td>부서설정</td>
	</tr>

<c:forEach items="${deptList}" var="dvo">
	<tr>
	<td>${dvo.getDeptno()}
	</td>
	<td>${dvo.dname}
	</td>
	<td>${dvo.loc}
	</td>
	<td><a href="./update.de?deptno=${dvo.getDeptno()}">수정</a>
		<a href="./delete.de?deptno=${dvo.getDeptno()}">삭제</a>
	</td>
	</tr>		
</c:forEach>

	
</table>
</body>
</html>