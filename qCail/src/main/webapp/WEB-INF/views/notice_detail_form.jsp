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
					<th>수정</th>
					<th>삭제</th>
				</tr>
		<c:forEach var ="replySelect" items="${replySelect}" varStatus="loop">
				<tr>
					<td>${replySelect.memberNickname}</td>
					<td>${replySelect.replyContent}</td>
					<td>${replySelect.replyRegDay}</td>
					<c:if test="${replySelect.memberSeq != null}"> <!-- 세션 사용? 으로 교체 -->
					<td><button type="button" id="replyUpdateBtn" data-replySeq="${replySelect.replySeq}">수정</button></td>
					<td><button type="button" class="replyDelete" data-replySeq="${replySelect.replySeq}">삭제</button></td>
					</c:if>
				</tr>
				
		</c:forEach>
		</table>
	<input type="button" value="공지 목록" onclick="location.href='<c:url value="/notice/list"/>'">
	<input type="button" value="메인 화면" onclick="location.href='<c:url value="/home"/>'">
</article>
</body>
</html>