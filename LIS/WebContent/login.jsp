<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
<script type="text/javascript">
function login(){
	var userId = document.getElementById("userId").value;
	var userPwd =document.getElementById("userPwd").value;
	
}
</script>
</head>
<body>
	<center>
	<h1>도서관 정보 시스템</h1>
		<form action="users/login" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userId" id="userId"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="userPwd" id="userPwd"></td>
				</tr>
				<tr>
					<td><input type="submit" value="로그인"></td>
					<td><input type="button" value="회원가입" onclick="location.href='regist.jsp' "></td>
					<br>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
