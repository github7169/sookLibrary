<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method="get">
		<select name="user_filter">
			<option value="registnum">학번</option>
			<option value="title">이름</option>
		</select>
		<input type="text" name="keyword">
		상태
		<select name="user_filter">
			<option value="default"></option>
			<option value="rentavilable">대출가능</option>
			<option value="rentlimit">대출제한</option>
			<option value="overdue">연체중</option>	
		</select>
		 <input type="submit"	value="검색" />
	</form>
</body>
</html>