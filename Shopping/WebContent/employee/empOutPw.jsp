<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function outConfirm(){
		if(confirm("정말 탈퇴하시겠습니까?")){
			document.frm.submit();
		}else{
			return false;
		}
		
	}
	
</script>
<title>Insert title here</title>
</head>
<body>
<form action="" method="post" onsubmit="return outConfirm()">
	비밀번호 : <input type="password" name="empPw" /><br/>
	<span>${pwFail }</span>
	<input type="submit" value="탈퇴" />
</form>
</body>
</html>