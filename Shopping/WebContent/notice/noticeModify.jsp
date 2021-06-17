<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="goodsModify.gd" method="post" name="frm">

<input type="hidden" name="prodNum" value="${dto.prodNum }"/>
    <table border = 1>
        <tr><th>글 번호</th>
            <td>${dto.noticeKind}-${dto.noticeNo }</td>
        </tr>
        <tr><th>제목</th>
            <td><input type="text" name="noticeSub" value="${dto.noticeSub }"></td></tr>
        <tr><th>내용</th>
            <td><textarea name="noticeCon" cols="50" rows="6">${dto.noticeCon }</textarea></td></tr>
        <tr><th>날짜</th>
            <td><input type="text" name="noticeDate" value="${dto.noticeDate }"></td></tr>
        <tr><th>글쓴이</th>
            <td><input type="text" name="employeeId" value="${dto.employeeId }"></td></tr>
        
        <tr><th colspan="2">
            <input type="submit" value="공지수정">
            <input type="reset" value="취소" onclick="javascript:history.back();">
            <input type="button" value="홈으로" onclick="javascript:location.href='main.sm'"/>
        </th></tr>
    </table>
</form>
</body>
</html>