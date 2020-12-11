<%@page import="java.util.ArrayList"%>
<%@page import="model.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/empModify.jsp"> 
<title>사원 정보수정</title>
</head>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("utf-8");
%>
<body>
<h1>사원정보 수정 페이지</h1>
<h3><a href="../index.jsp">홈</a>
<a href="empList.em">리스트로 돌아가기</a></h3>
<%
EmpVO evo = (EmpVO)request.getAttribute("evo"); 
%>
<form action="../pages/saveEmp.em" method="post">
<input type="hidden" name="empno" value='<%=evo.getEmpno() %>'>
<table border="1">
	<tr>
		<td>사원번호</td>
		<td><input type="number" value='<%=evo.getEmpno() %>' readonly></td>
	</tr>
	<tr>
		<td>사원이름</td>
		<td><input type="text" name="ename" value='<%=evo.getEname()%>'></td>
	</tr>
	<tr>
		<td>사원직책</td>
		<td><input type="text" name="job" value='<%=evo.getJob() %>'></td>
	</tr>
	<tr>
		<td>상사번호</td>
		<td><input type="number" name="mgr" value='<%=evo.getMgr() %>'></td>
	</tr>
	<tr>
		<td>입사날짜</td>
		<td><input type="date" name="hiredate" value='<%=evo.getHiredate() %>'></td>
	</tr>
	<tr>
		<td>사원연봉</td>
		<td><input type="number" name="sal" value='<%=evo.getSal() %>'></td>
	</tr>
	<tr>
		<td>보너스</td>
		<td><input type="number" name="comm" value='<%=evo.getComm() %>'></td>
	</tr>
	<tr>
		<td>부서번호</td>
		<%-- <td><input type="select" name="deptno" value='<%=evo.getDeptno() %>'></td> --%>
		<td>
		<%ArrayList<Integer> deptnos = (ArrayList)request.getAttribute("deptnos"); %>
		<select name="deptno" id="deptno"  required>
			<option value="" disabled selected>부서 선택</option>
			<%for(int d: deptnos) {%>
				<option value="<%=d%>" <%if(evo.getDeptno()==d)out.print("selected"); %>><%=d%></option>
			<%} %>
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











