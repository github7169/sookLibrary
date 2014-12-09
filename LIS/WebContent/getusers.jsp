<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import= "com.sook.DAO.UsersDAO" %>
<%@ page import= "com.sook.DTO.UsersDTO" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "com.sook.util.JDBCUtil" %>
<%@ page import= "com.sook.util.StatusUtil" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menubar.jsp"></jsp:include>
	<br>
	<hr>
	<br>
	<jsp:include page="usersearchfilter.jsp"></jsp:include>
	<table border="1">
		<tr>
			<th>no</th>
			<th>학번</th>
			<th>이름</th>
			<th>학과</th>
			<th>핸드폰 번호</th>
			<th>상태</th>
			<th>연체료</th>
			<th>대출권수</th>
		</tr>
		<tr>
			<td>2</td>
			<td>1210453</td>
			<td>임수지</td>
			<td>멀티미디어과학</td>
			<td>01077317169</td>
			<td>연체중</td>
			<td>200원</td>
			<td>4</td>
		</tr>

	</table>
</body>
</html>