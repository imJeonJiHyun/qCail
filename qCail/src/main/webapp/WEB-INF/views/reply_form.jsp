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
<!-- Reply Form {s} -->
	<article>
			<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
				<form:form name="form" id="form" role="form" modelAttribute="writeForm" method="post">
				<form:hidden path="${replySelect.boardSeq}" id="boardSeq"/>
				<div class="row">
					<div class="col-sm-10">
						<form:textarea path="content" id="content" class="form-control" rows="3" placeholder="댓글을 입력해 주세요"></form:textarea>
					</div>
					<div class="col-sm-2">
						<form:input path="reg_id" class="form-control" id="reg_id" placeholder="댓글 작성자"></form:input>
						<button type="button" class="btn btn-sm btn-primary" id="btnReplySave" style="width: 100%; margin-top: 10px"> 저 장 </button>
					</div>
				</div>
				</form:form>
			</div>
			<!-- Reply Form {e} -->
			<!-- Reply List {s}-->
			<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
				<h6 class="border-bottom pb-2 mb-0">Reply list</h6>
				<div id="replyList"></div>
			</div> 
			<!-- Reply List {e}-->
	</article>
</body>
</html>