<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/modify.jsp"> 
<title>사원 정보수정</title>
</head>
<body>
<h1>사원정보 수정 페이지</h1>
<h3><a href="../../index.jsp">홈</a>
<a href="list.em">리스트로 돌아가기</a></h3>
<c:set var="evo" value="${evo}"/>
<form action="save.em" method="post">
<input type="hidden" name="empno" value='${evo.empno}'>
<table border="1">
	<tr>
		<td>사원번호</td>
		<td><input type="number" value='${evo.empno}' readonly></td>
	</tr>
	<tr>
		<td>사원이름</td>
		<td><input type="text" name="ename" value='${evo.ename}'></td>
	</tr>
	<tr>
		<td>사원직책</td>
		<td><input type="text" name="job" value='${evo.job}'></td>
	</tr>
	<tr>
		<td>상사번호</td>
		<td><input type="number" name="mgr" value='${evo.mgr}'></td>
	</tr>
	<tr>
		<td>입사날짜</td>
		<td><input type="date" name="hiredate" value='${evo.hiredate}'></td>
	</tr>
	<tr>
		<td>사원연봉</td>
		<td><input type="number" name="sal" value='${evo.sal}'></td>
	</tr>
	<tr>
		<td>보너스</td>
		<td><input type="number" name="comm" value='${evo.comm}'></td>
	</tr>
	<tr>
		<td>부서번호</td>
		<td>
		<select name="deptno" id="deptno"  required>
			<option value="" disabled selected>부서 선택</option>
			<c:forEach items="${deptnos}" var="dno">
			<option value="${dno}" 
				<c:if test="${dno eq evo.deptno}"> <c:out value="selected" /></c:if>
			>${dno}
			</option>
			</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="submit">사원정보수정</button>
			<button type="reset">작성초기화</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>











