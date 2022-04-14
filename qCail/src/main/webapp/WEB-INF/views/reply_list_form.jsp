<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 임시</title>
</head>
<body>
<header>
	<h1>댓글 임시 창</h1>
</header>
<form action="<c:url value='/reply' /> " method="post" name="writeForm">
    <table>
    	<tr>
       		<td>임시 게시판 번호 (게시판이 있어야 뽑아와서 사용 가능할 듯)</td>
       		<td><input name="boardSeq" type="text" size="10" maxlength="100"/></td>
       </tr>
       <tr>
       		<td>멤버 번호 (같은 이유)</td>
       		<td><input name="memberSeq" type="text" size="10" maxlength="100"/></td>
       </tr>
		<tr>
       		<td>댓글 쓰기</td>
       		<td><textarea name="replyContent" cols="25" rows="5"></textarea></td>
       		<td><input type="submit" value="등록" ></td>     
       </tr>
    </table>
</form>
		<table border = "1">
				<tr>
					<th>작성자</th>
					<th>내용</th>
					<th>작성 날짜</th>
				</tr>
		<c:forEach var ="replyList" items="${replyList}" varStatus="loop">
				<tr>
					<td>${replyList.memberNickname}</td>
					<td><a href="<c:url value="/notice/read/${replyList.boardSeq}"/>">${replyList.replyContent}</a></td>
					<td>${replyList.replyRegDay}</td>
				</tr>
		</c:forEach>
		</table>
		<input type="button" value="메인화면" onclick="location.href='<c:url value="/home"/>'">
		<input type="button" value="글쓰기" onclick="location.href='<c:url value="/notice/write"/>'">	
</body>
</html>