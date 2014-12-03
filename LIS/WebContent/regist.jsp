<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입 페이지</title>
</head>
<body>
	<form action="users/insertUser" method="post">
		<table>
			<tr>
				<td>*ID</td>
				<td><input type="text" name="id"></td>
				<!-- 조회 버튼은 학생의 경우 학생디비에서, 사서의 경우 교직원 디비에서 존재하는 학번, 교번인지 확인하는 것 -->
				<td><input type="button" value="조회" onclick="window.location.href='<c:url value="users/checkUserId"/>'"/></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pwd"> </td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>*학과</td>
				<td><input type="text" name="department"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>* 사서의 경우 교직원 번호와 부서를 입력합니다.</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="가입"> <input type="reset" value="취소">
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>