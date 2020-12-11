<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>질문 등록 페이지</h1>
	<h3><a href="../../index.jsp">홈</a>
		<a href="list.qn">목록으로</a>
	</h3>
<form method="post" action="save.qn">
<table>
<tr>
<td>writer</td>
<td>
<select name="writer" required>
<option selected disabled value="">사원 선택
</option>
<c:forEach var="elist" items="${list}">
<option value="${elist.ename}">
${elist.ename}
</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>title</td>
<td><input type="text" name="title" required></td>
</tr>
<tr>
<td>img</td>
<td><input type="text" name="imgfile" required></td>
</tr>
<tr>
<td>content</td>
<td><input type="text" name="content" required></td>
</tr>
<tr>
<td colspan="2">
<button type="submit">작성</button>
<button type="reset">초기화</button>
</td>
</tr>
</table>
</form>	
</body>
</html>