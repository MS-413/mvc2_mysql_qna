<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/insertDept.jsp"> 
<title>부서등록 페이지</title>
</head>
<body>
<h1>부서등록 페이지</h1>
<h3><a href="../index.jsp">홈</a>
<a href="../index.jsp">리스트로 돌아가기</a></h3>
<!-- .do로 보냄  
src와 WebContent는 물리적으로 달라보이지만 논리적으로는 같은 곳에서 관리함
:: 시작 경로가 같음
-->
<form action="./saveDept.de" method="post">
<table border="1">
	<tr>
		<td>부서번호</td>
		<td><input type="number" name="deptno" max="99" min="10" placeholder="부서번호 2자리" required></td>
	</tr>
	<tr>
		<td>부서이름</td>
		<td><input type="text" name="dname" placeholder="부서이름" required></td>
	</tr>
	<tr>
		<td>부서위치</td>
		<td><input type="text" name="loc" placeholder="부서위치" required></td>
	</tr>	
	<tr>
		<td colspan="2">
			<button type="submit">부서등록</button>
			<button type="reset">작성초기화</button>
		</td>
	</tr>
</table>
</form>	
</body>
</html>