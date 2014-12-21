<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
		<% int cnt=1; %>
			<c:forEach var="rentedlist" items="${GETRENTEDBOOKLIST}">			
	    	<tr>
				<td><%= cnt++ %></td>
	    		<td>${rentedlist.bookRegistNumber}</td>
				<td>${rentedlist.bookTitle}</td>
				<td>${rentedlist.bookAuthor}</td>
				<td>${rentedlist.bookPublisher}</td>
				<td>${rentedlist.bookApplicationMark}</td> 
				<td>${rentedlist.bookRentDate}</td>
				<td>${rentedlist.bookReturnDate}</td>
	    	</tr>
			</c:forEach>
	</table>
	<br>
	<hr>
	<br>
	<jsp:include page="bookdetail.jsp"></jsp:include>
</body>
</html>