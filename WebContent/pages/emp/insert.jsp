<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/insertEmp.jsp">
<title>사원등록 페이지</title>
</head>
<body>
<h1>사원등록 페이지</h1>
<h3><a href="../../index.jsp">홈</a>
<a href="list.em">리스트로 돌아가기</a></h3>
<form action="save.em" method="post">
<table border="1">
	<tr>
		<td>사원번호</td>
		<td><input type="number" name="empno" max="9999" min="1000" placeholder="사원번호 4자리" required></td>
	</tr>
	<tr>
		<td>사원이름</td>
		<td><input type="text" name="ename" placeholder="사원이름" required></td>
	</tr>
	<tr>
		<td>사원직책</td>
		<td><input type="text" name="job" placeholder="사원직책" required></td>
	</tr>
	<tr>
		<td>입사날짜</td>
		<td><input type="date" name="hiredate" placeholder="입사날짜" required></td>
	</tr>
	<tr>
		<td>사원연봉</td>
		<td><input type="number" name="sal" min="0" placeholder="사원연봉" required></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="submit">사원등록</button>
			<button type="reset">작성초기화</button>
		</td>
	</tr>
</table>
</form>	
</body>
</html>