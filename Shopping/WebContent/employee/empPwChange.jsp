<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 비밀번호 변경</title>
</head>
<body>
<form action="empPwChangeOk.em" name="frm" method="post">
	비밀번호 : <input type="password" name="empPw" /><br/>
	<span>${pwFail1 }</span><br/>
	<input type="submit" value="확인"/>
</form>
</body>
</html>