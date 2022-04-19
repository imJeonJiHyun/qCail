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
<script>
// 'request'라는 id를 가진 버튼 클릭 시 실행.
$("#replyUpdateBtn").click(function(){

    // ajax 통신
    $.ajax({
        type : "POST",            // HTTP method type(GET, POST) 형식이다.
        url : "/test/ajax",      // 컨트롤러에서 대기중인 URL 주소이다.
        data : params,            // Json 형식의 데이터이다.
        success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            // 응답코드 > 0000
            alert(res.code);
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            alert("통신 실패.")
        }
    });
});
</script>
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
					<th>수정</th>
					<th>삭제</th>
				</tr>
		<c:forEach var ="replySelect" items="${replySelect}" varStatus="loop">
				<tr>
					<td>${replySelect.memberNickname}</td>
					<td><a href="<c:url value="/notice/read/${replySelect.boardSeq}"/>">${replySelect.replyContent}</a></td>
					<td>${replySelect.replyRegDay}</td>
					<c:if test="${replySelect.memberSeq != null}"> <!-- 세션 사용? 으로 교체 -->
					<td><button type="button" id="replyUpdateBtn" data-replySeq="${replySelect.replySeq}">수정</button></td>
					<td><button type="button" class="replyDelete" data-replySeq="${replySelect.replySeq}">삭제</button></td>
					</c:if>
				</tr>
				
		</c:forEach>
		</table>
</body>
</html>