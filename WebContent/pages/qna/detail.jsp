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
<h1>QNA 상세 페이지</h1>
	<h3><a href="../../index.jsp">홈</a>
		<a href="list.qn">목록으로 돌아가기</a>

	</h3>	
<table border = 1>
<tbody>
<c:set var="qvo" value="${qvo}" />
<tr>
<td rowspan="2" colspan="2">
<img alt="" src="${qvo.imgfile}" width="100" height="100">
</td>
<td>
${qvo.qno}
</td>
<td>
${qvo.title}
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
</tr>
<tr>
<td colspan="5">
${qvo.content }
</td>
</tr>
<tr>
<td colspan="7">
<a href="modify.qn?qno=${qvo.qno}">수정</a> <a href="delete.qn?qno=${qvo.qno}">삭제</a>
</td>
</tr>
</tbody>
</table>
</body>
</html>