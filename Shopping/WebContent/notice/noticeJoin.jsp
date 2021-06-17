<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지사항</title>
</head>
<body>
<form action="noticeJoin.nt" method="post" name="frm"
      enctype="multipart/form-data">
    <table border = 1>
        <tr>
          <th>글 번호</th>
            <td>
                <input type="text" name="noticeNo" value="${noticeNum }">
            </td>
        </tr>
        <tr><th>제목</th>
            <td><input type="text" name="noticeSub"></td></tr>
        <tr><th>내용</th>
            <td><textarea name="noticeCon" cols="50" rows="6"></textarea></td></tr>
        <tr><th>날짜</th>
            <td><input type="text" name="noticeDate"></td></tr>
        <tr><th>공지종류</th>
            <td>
               <select name="noticeKind">
                <option value="all">전체공지</option>
                <option value="event">이벤트</option>
                <option value="order">주문</option>
                <option value="del">배송</option>
                <option value="etc">기타</option>
               </select>
            </td>
        </tr>
        <tr><th>첨부파일</th>
            <td>
                <input type="file" name="noticeFile" /> <br />
                <input type="file" name="noticeFile" /> <br />
                <input type="file" name="noticeFile" /> <br />
            </td></tr>
        <tr><th>조회수</th>
            <td><input type="text" name="noticeHits"></td></tr>
        <tr><th>글쓴이</th>
            <td><input type="text" name="employeeId"></td></tr>
        <tr><th colspan="2">
            <input type="submit" value="공지 등록">
            <input type="reset" value="취소">
            <input type="button" value="홈으로" onclick="javascript:location.href='main.sm'"/>
        </th></tr>
    </table>
</form>
</body>
</html>