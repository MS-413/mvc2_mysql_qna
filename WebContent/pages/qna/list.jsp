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
<h1>QNA 목록 페이지</h1>
	<h3><a href="../../index.jsp">홈</a>
		<a href="write.qn">질문 등록</a>

	</h3>	
<table border = 1>
<thead>
<tr>
<td> no
</td>
<td> thumb
</td>
<td> 
title
</td>
<td> writer 
</td>
<td> readCount 
</td>
<td> regDate
</td>
</tr>
</thead>
<tbody>
<c:forEach var="qvo" items="${aqvo}">
<tr>
<td>
${qvo.qno}
</td>
<td>
<img alt="" src="${qvo.thumbnail}" width="30" height="30">
</td>
<td><a href="detail.qn?qno=${qvo.qno}">
${qvo.title}</a>
</td>
<td>
${qvo.writer}
</td>
<td>
${qvo.readcount}
</td>
<td>
${qvo.regdate}
</td>
<td>
<a href="modify.qn?qno=${qvo.qno}">수정</a> <a href="delete.qn?qno=${qvo.qno}">삭제</a>
</td>
<tr>
</c:forEach>
</tbody>
</table>
</body>
</html>