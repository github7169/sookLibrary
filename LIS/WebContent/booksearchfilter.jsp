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
		<select name="book_filter">
			<option value="registnum">��Ϲ�ȣ</option>
			<option value="title">����</option>
			<option value="author">����</option>
			<option value="publisher">���ǻ�</option>
			<option value="ISBN">ISBN</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="�˻�" />
		
		<!-- if Librarian -->
		<input type="button" value="����"/>
		<input type="button" value="����" onClick="alert('������ �����Ͻðڽ��ϱ�?')"/>
	</form>
</body>
</html>