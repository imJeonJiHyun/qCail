<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>
</head>
<body>
<header>
	<h1>공지 사항 게시판</h1>
</header>
		<table border = "1">
				<tr>
					<th>작성 번호</th>
					<th>제목</th>
					<th>작성 날짜</th>
				</tr>
		<c:forEach var ="noticeList" items="${noticeList}" varStatus="loop">
				<tr>
					<td>${noticeList.boardSeq}</td>
					<td><a href="<c:url value="/notice/read/${noticeList.boardSeq}"/>">${noticeList.noticeTitle}</a></td>
					<td>${noticeList.noticeRegDay}</td>
				</tr>
		</c:forEach>
		</table>
		<input type="button" value="메인화면" onclick="location.href='<c:url value="/home"/>'">
		<c:if test="${adminSeq != null}">
		<input type="button" value="글쓰기" onclick="location.href='<c:url value="/notice/write"/>'">	
		</c:if>
</body>
</html>