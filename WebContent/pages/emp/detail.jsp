<%@page import="model.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/emp/detail.jsp"> 
<title>사원 상세정보</title>
</head>
<body>
<h1>사원 상세정보 페이지</h1>
<h3><a href="../../index.jsp">홈</a>
<a href="list.em">리스트로 돌아가기</a></h3>
<!-- var : 변수 명, value : 값 -->
<c:set var="evo" value="${evo}"/>
<c:set var="empno" value="${evo.empno}"/>
<table border="1">
	<tr>
		<td>사원번호</td>
		<td>${evo.empno}</td>
	</tr>
	<tr>
		<td>사원이름</td>
		<td>${evo.ename}</td>
	</tr>
	<tr>
		<td>사원직책</td>
		<td>${evo.job}</td>
	</tr>
	<tr>
		<td>상사번호</td>
		<td>${evo.mgr}</td>
	</tr>
	<tr>
		<td>입사날짜</td>
		<td>${evo.hiredate}</td>
	</tr>
	<tr>
		<td>사원연봉</td>
		<td>${evo.sal}</td>
	</tr>
	<tr>
		<td>보너스</td>
		<td>${evo.comm}</td>
	</tr>
	<tr>
		<td>부서번호</td>
		<td>${evo.deptno}</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="./modify.em?empno=${empno }">사원정보수정</a>
			<a href="./delete.em?empno=${empno }">사원정보삭제</a>
		</td>
	</tr>
</table>
</body>
</html>











