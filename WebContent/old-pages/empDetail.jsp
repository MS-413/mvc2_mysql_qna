<%@page import="model.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/empDetail.jsp"> 
<title>사원 상세정보</title>
</head>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("utf-8");
EmpVO evo = (EmpVO)request.getAttribute("evo");
%>
<body>
<h1>사원 상세정보 페이지</h1>
<h3><a href="../index.jsp">홈</a>
<a href="empList.jsp">리스트로 돌아가기</a></h3>
<table border="1">
	<tr>
		<td>사원번호</td>
		<td><%=evo.getEmpno() %></td>
	</tr>
	<tr>
		<td>사원이름</td>
		<td><%=evo.getEname() %></td>
	</tr>
	<tr>
		<td>사원직책</td>
		<td><%=evo.getJob() %></td>
	</tr>
	<tr>
		<td>상사번호</td>
		<td><%=evo.getMgr() %></td>
	</tr>
	<tr>
		<td>입사날짜</td>
		<td><%=evo.getHiredate() %></td>
	</tr>
	<tr>
		<td>사원연봉</td>
		<td><%=evo.getSal()%></td>
	</tr>
	<tr>
		<td>보너스</td>
		<td><%=evo.getComm() %></td>
	</tr>
	<tr>
		<td>부서번호</td>
		<td><%=evo.getDeptno() %></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="empModify.em?empno=<%=evo.getEmpno() %>">사원정보수정</a>
			<a href="deleteEmp.em?empno=<%=evo.getEmpno() %>">사원정보삭제</a>
		</td>
	</tr>
</table>
</body>
</html>











