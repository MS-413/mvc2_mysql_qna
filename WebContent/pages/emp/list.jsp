<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/emp/list.jsp"> 
<title>사원정보 목록</title>
</head>

<body>
<h1>사원정보 목록 페이지</h1>
	<h3><a href="../../index.jsp">홈</a>
		<a href="insert.jsp">사원등록</a>
	</h3>	
	<form action="search.jsp" method="get">
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
	<c:forEach items="${list}" var="evo">
		<tr> 
		<td><a href="detail.em?empno=${evo.empno}">${evo.empno}</a></td>
		<td>${evo.ename}</td>
		<td>${evo.job}</td>
		<td>${evo.hiredate}</td>
		<td>${evo.deptno}</td>
		<td><a href="./modify.em?empno=${evo.empno}">수정</a>
		<a href="./delete.em?empno=${evo.empno}">삭제</a>
		</td>
		</tr>
	</c:forEach>	
</table>
</body>
</html>