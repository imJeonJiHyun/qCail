<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 글쓰기</title>
</head>
<body>
<header>
	<h1>공지 사항 글쓰기</h1>
</header>
<form action="<c:url value='/notice/write' /> " method="post" name="writeForm">
    <table width="700" border="3" bordercolor="lightgray" align="center">
       <tr>
       		<td>제 목</td>
       		<td><input name="noticeTitle" type="text" size="70" maxlength="100"/></td>
       </tr>
       <tr>
       		<td>작성자</td>
       		<c:if test="${adminSeq != null}">
       		<td>{$adminNickname}</td>
       		</c:if>
       </tr>
       <tr>
       		<td>내 용</td>
       		<td><textarea name="noticeContent" cols="72" rows="20"></textarea></td>     
       </tr>
       <tr align="center" valign="middle">
            <td colspan="5">
                <input type="reset" value="작성취소" >
                <input type="submit" value="등록" >
                <input type="button" value="목록" onclick="location.href='<c:url value="/notice/list"/>'">	            
            </td>
        </tr>
    </table>    
    </form>
</body>
</html>