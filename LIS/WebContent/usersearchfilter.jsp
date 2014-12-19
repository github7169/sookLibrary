<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/users/getUsers"/>" method="POST">
		
		<select name="userFilter">
			<option value="default"></option>
			<option value="userId">학번</option>
			<option value="userName">이름</option>
		</select>
		<input type="text" name="keyword">
		상태
		<select name="statusFilter">
			<option value="default"></option>
			<option value="available">대출가능</option>
			<option value="restricted">대출제한</option>
			<option value="overdue">연체중</option>	
		</select>
		 <input type="submit"	value="검색" />
	</form>
</body>
</html>