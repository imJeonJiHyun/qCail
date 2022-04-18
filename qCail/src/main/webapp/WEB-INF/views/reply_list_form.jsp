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
function showReplyList(){

	var url = "${pageContext.request.contextPath}/restReply/reply";

	var paramData = {"bid" : "${boardContent.bid}"};

	$.ajax({

        type: 'POST',

        url: url,

        data: paramData,

        dataType: 'json',

        success: function(result) {

           	var htmls = "";

		if(result.length < 1){

			htmls.push("등록된 댓글이 없습니다.");

		} else {

                    $(result).each(function(){

                     htmls += '<div class="media text-muted pt-3" id="rid' + this.rid + '">';

                     htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';

                     htmls += '<title>Placeholder</title>';

                     htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';

                     htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';

                     htmls += '</svg>';

                     htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';

                     htmls += '<span class="d-block">';

                     htmls += '<strong class="text-gray-dark">' + this.reg_id + '</strong>';

                     htmls += '<span style="padding-left: 7px; font-size: 9pt">';

                     htmls += '<a href="javascript:void(0)" onclick="fn_editReply(' + this.rid + ', \'' + this.reg_id + '\', \'' + this.content + '\' )" style="padding-right:5px">수정</a>';

                     htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.rid + ')" >삭제</a>';

                     htmls += '</span>';

                     htmls += '</span>';

                     htmls += this.content;

                     htmls += '</p>';

                     htmls += '</div>';
                });	//each end
		}
		$("#replyList").html(htmls);
        }	   // Ajax success end
	});	// Ajax end
}

function replyUpdate()(rid, reg_id, content){

	var htmls = "";

	htmls += '<div class="media text-muted pt-3" id="rid' + rid + '">';

	htmls += '<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder:32x32">';

	htmls += '<title>Placeholder</title>';

	htmls += '<rect width="100%" height="100%" fill="#007bff"></rect>';

	htmls += '<text x="50%" fill="#007bff" dy=".3em">32x32</text>';

	htmls += '</svg>';

	htmls += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom horder-gray">';

	htmls += '<span class="d-block">';

	htmls += '<strong class="text-gray-dark">' + reg_id + '</strong>';

	htmls += '<span style="padding-left: 7px; font-size: 9pt">';

	htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' + rid + ', \'' + reg_id + '\')" style="padding-right:5px">저장</a>';

	htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';

	htmls += '</span>';

	htmls += '</span>';		

	htmls += '<textarea name="editContent" id="editContent" class="form-control" rows="3">';

	htmls += content;

	htmls += '</textarea>';

	

	htmls += '</p>';

	htmls += '</div>';

	

	$('#rid' + rid).replaceWith(htmls);

	$('#rid' + rid + ' #editContent').focus();

}
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
					<td><button type="button" onclick = "replyUpdate()" class="replyUpdateBtn" data-replySeq="${replySelect.replySeq}">수정</button></td>
					<td><button type="button" class="replyDelete" data-replySeq="${replySelect.replySeq}">삭제</button></td>
					</c:if>
				</tr>
				
		</c:forEach>
		</table>
</body>
</html>