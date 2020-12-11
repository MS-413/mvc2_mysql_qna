<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="pages/emp/delete.jsp">
<title>Insert title here</title>
</head>
<body>
<h1>부서 삭제 여부 </h1>
	<h3><a href="../../index.jsp">홈</a>
		<a href="list.em">부서목록</a>
	</h3>
<%int result = (Integer)request.getAttribute("result"); %>
<h1>
<%out.print(result == 0 ?"사원 정보 삭제 실패..":"사원 정보 삭제 성공!!"); %>
</h1>
</body>
</html>