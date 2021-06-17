<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 리스트</title>
</head>
<body>
공지 리스트 페이지입니다.<br/>
<table border = 1>
<tr><th>글번호</th>
   <th>카테고리</th>
   <th>제목</th>
   <th>조회수</th>
   <th>글쓴이</th></tr>
   
   <c:forEach items="${lists }" var="dto">
   <tr>
   	  <td><a href="noticeDetail.nt?noticeNo=${dto.noticeNo }">${dto.noticeNo }</a></td>
      <td>${dto.noticeKind }</td>
      <td>${dto.noticeSub }</td>
      <td>${dto.noticeHits }</td>
      <td>${dto.employeeId }</td>
   </tr>
   </c:forEach>   
</table>

<a href="noticeRegist.nt">공지등록</a>
</body>
</html>