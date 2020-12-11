<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="page/updateDept.jsp"> 
<title>부서 정보 수정 페이지</title>
</head>
<body>
<h1>부서등록 페이지</h1>
<h3><a href="../../index.jsp">홈</a>
<a href="list.de">리스트로 돌아가기</a></h3>
<form action="./modify.de" method="post">
<c:set var="dvo" value="${dvo}"/>
<table border="1">
	<tr>
		<td>부서번호</td>
		<td><input type="number" name="deptno" value="${dvo.deptno }" readonly></td>
	</tr>
	<tr>
		<td>부서이름</td>
		<td><input type="text" name="dname" value="${dvo.getDname()}"></td>
	</tr>
	<tr>
		<td>부서위치</td>
		<td><input type="text" name="loc" value="${dvo.loc}"></td>
	</tr>	
	<tr>
		<td colspan="2">
			<button type="submit">부서수정</button>
			<button type="reset">작성초기화</button>
		</td>
	</tr>
</table>
</form>	
</body>
</html>