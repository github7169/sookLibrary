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
			<option value="registnum">�й�</option>
			<option value="title">�̸�</option>
		</select>
		<input type="text" name="keyword">
		����
		<select name="user_filter">
			<option value="default"></option>
			<option value="rentavilable">���Ⱑ��</option>
			<option value="rentlimit">��������</option>
			<option value="overdue">��ü��</option>	
		</select>
		 <input type="submit"	value="�˻�" />
	</form>
</body>
</html>