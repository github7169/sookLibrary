<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>계정 관리</title>
</head>
<body>
<jsp:include page="menubar.jsp"></jsp:include>
<form action="<c:url value="/users/updateUser"/>" method="post">
		<table>
			<tr>
				<td>*ID</td>
				<td> ${USER.userId} </td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="userPwd" value="${USER.userPwd }" maxlength="20"> </td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" value="${USER.userName }" maxlength="10"></td>
			</tr>
			<tr>
				<td>*학과</td>
				<td><input type="text" name="userDepartment" value="${USER.userDepartment}" maxlength="30"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" name="userPhoneNum" value="${USER.userPhoneNum}" maxlength="20"></td>
			</tr>
			<tr>
				<td>* 사서의 경우 교직원 번호와 부서를 입력합니다.</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="수정"> <input type="reset" value="취소"> <input type="button" value="탈퇴" onClick="confirm('정말로 탈퇴하시겠습니까?')">
				</td>			
			</tr>		
			</tr>
		</table>
	</form>
</body>
</html>