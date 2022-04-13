<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항 세부 글</title>
</head>
<body>
<header>
	<h1>공지사항 디테일</h1>
</header>
<article>
	<table border = "1">
		<tr>
			<td rowspan="5">${noticeDetail.noticeTitle}</td>
			<td>${noticeDetail.noticeRegDay}</td>
		</tr>
		<tr>
			<td rowspan="10">${noticeDetail.noticeContent}</td>
		</tr>
	</table>
	<input type="button" value="공지 목록" onclick="location.href='<c:url value="/notice/list"/>'">
	<input type="button" value="메인 화면" onclick="location.href='<c:url value="/home"/>'">
</article>
</body>
</html>