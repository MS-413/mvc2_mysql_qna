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
<h1>QNA 수정 페이지</h1>
	<h3><a href="../../index.jsp">홈</a>
		<a href="list.qn">목록으로 돌아가기</a>

	</h3>	
<c:set var="qvo" value="${qvo}"/>
<form method="post" action="update.qn">
<input type="hidden" name="qno" value="${qvo.qno}">
<table>
<tr>
<td>writer</td>
<td>
<input type="text" name="writer" value="${qvo.writer}" readonly></td>
</td>
</tr>
<tr>
<td>title</td>
<td><input type="text" name="title" value="${qvo.title}" required></td>
</tr>
<tr>
<td>img</td>
<td><input type="text" name="imgfile" value="${qvo.imgfile}" required></td>
</tr>
<tr>
<td>content</td>
<td><input type="text" name="content" value="${qvo.content}" required></td>
</tr>
<tr>
<td colspan="2">
<button type="submit">수정</button>
<button type="reset">초기화</button>
</td>
</tr>
</table>
</form>	
</body>
</html>