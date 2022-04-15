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
<script type="text/javascript"> //아직 열심히 수정 만지는 중
//데이터 전송 객체 생성!
var comment = {
  // 이벤트 등록
  init: function() {
    var _this = this;
    
   // 수정 버튼 변수화
   const updateBtns = document.querySelectorAll('.comment-update-btn');
   // 모든 수정 버튼별, 이벤트 등록
    updateBtns.forEach(function(item) {
      item.addEventListener('click', function() { // 클릭 이벤트 발생시,
        var form = this.closest('form'); // 클릭 이벤트가 발생한 버튼에 제일 가까운 폼을 찾고,
        _this.update(form); // 해당 폼으로, 업데이트 수행한다!
      });
    });
  },
//댓글 수정
update: function(form) {
  // 데이터
  var data = {
    id: form.querySelector('#comment-id').value,
    author: form.querySelector('#comment-author').value,
    content: form.querySelector('#comment-content').value,
  };
  // url에서 article의 id를 추출!
  var split = location.pathname.split('/');
  var articleId = split[split.length - 1];
  // 비동기 통신
  fetch('/api/comments/' + data.id, { // 요청을 보냄
    method: 'PUT',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json'
    }
  }).then(function(response) { // 응답 처리
    if (response.ok) { // 성공
      alert('댓글이 수정되었습니다.');
    } else { // 실패
      alert('댓글 수정 실패..!');
    }
    window.location.reload(true); // 페이지 리로드
  });
}
};
//객체 초기화!
comment.init();
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
					<td><button type="button" class="replyUpdateBtn" data-replySeq="${replySelect.replySeq}">수정</button></td>
					<td><button type="button" class="replyDelete" data-replySeq="${replySelect.replySeq}">삭제</button></td>
					</c:if>
				</tr>
				
		</c:forEach>
		</table>
</body>
</html>