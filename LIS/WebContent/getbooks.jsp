<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menubar.jsp"></jsp:include>
<jsp:include page="booksearchfilter.jsp"></jsp:include>
<table border="1">
<c:if test="${USER.userPosition == 'librarian'}">
<!-- if librarian -->
		<tr>
			<th><input type="checkbox" name="isChecked"></th>
			<th>no</th>
			<th>등록번호</th>
			<th>서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>ISBN</th>
			<th>청구기호</th>
			<th>이용자</th>
			<th>대출상태</th>
			<th>대출일</th>
			<th>반납예정일</th>
		</tr>
		
    	<% int cnt=1; %>
		<c:forEach var="booklist" items="${GETBOOKLIST}">			
    	<tr>
    		<td><input type="checkbox" name="isChecked"></td>
			<td><%= cnt++ %></td>
    		<td>${booklist.bookRegistNumber}</td>
			<td>${booklist.bookTitle}</td>
			<td>${booklist.bookAuthor}</td>
			<td>${booklist.bookPublisher}</td>
			<td>${booklist.bookISBN}</td>
			<td>${booklist.bookApplicationMark}</td>
			<td>${booklist.bookRentedBy.userId}</td>
			<!-- 대출상태 -->
			<c:if test="${booklist.bookStatus == '6'}"><td>대출가능</td></c:if> 
			<c:if test="${booklist.bookStatus == '7'}"><td>대출중</td></c:if> 
			<td>${booklist.bookRentDate}</td>
			<td>${booklist.bookReturnDate}</td>
    	</tr>
		</c:forEach>
		
</c:if>
<!-- if student -->
<c:if test="${USER.userPosition == 'student'}">
<!-- 등록번호, 서명, 저자, 출판사, 청구기호, 대출상태, 반납예정일 -->
		<tr>
			<th><input type="checkbox" name="isChecked"></th>
			<th>no</th>
			<th>등록번호</th>
			<th>서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>청구기호</th>
			<th>대출상태</th>
			<th>반납예정일</th>
		</tr>
		<% int cnt=1; %>
		<c:forEach var="booklist" items="${GETBOOKLIST}">			
    	<tr>
    		<td><input type="checkbox" name="isChecked"></td>
			<td><%= cnt++ %></td>
    		<td>${booklist.bookRegistNumber}</td>
			<td>${booklist.bookTitle}</td>
			<td>${booklist.bookAuthor}</td>
			<td>${booklist.bookPublisher}</td>
			<td>${booklist.bookApplicationMark}</td>
			<!-- 대출상태 -->
			<c:if test="${booklist.bookStatus == '6'}"><td>대출가능</td></c:if> 
			<c:if test="${booklist.bookStatus == '7'}"><td>대출중</td></c:if> 
			<td>${booklist.bookReturnDate}</td>
    	</tr>
		</c:forEach>
</c:if>
	</table>
	<jsp:include page="bookdetail.jsp"></jsp:include>
</body>
</html>
