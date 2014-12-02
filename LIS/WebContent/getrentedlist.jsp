<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menubar.jsp"></jsp:include>
	<br>
	<hr>
	<br>
	<table border="1">
		<tr>
			<th>no</th>
			<th>등록번호</th>
			<th>서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>청구기호</th>
			<th>대출일</th>
			<th>반납예정일</th>
		</tr>
		<tr>
			<td>1</td>
			<td>1131357</td>
			<td><a href="#">Software engineering/ 9th ed</a></td>
			<td> Ian Sommerville.</td>
			<td>Addison-Wesley</td>
			<td>005.1 S697s9 c2</td>
			<td>2014.11.9</td>
			<td>2014.11.25</td>
		</tr>
	</table>
	<br>
	<hr>
	<br>
	<jsp:include page="bookdetail.jsp"></jsp:include>
</body>
</html>