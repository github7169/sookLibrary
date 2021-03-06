<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*
	function deleteBook(){
		var status = confirm("정말로 삭제하시겠습니까?");
		if(status==true)
			window.location.href='<c:url value="books/deleteBook"/>';
	}*/
	
	function sendUpdate(){
		alert("sendUpdate");
		document.detailform.action="updateBook";
		document.detailform.submit();		
	}
	
	function sendDelete(){
		alert("sendDelete");
		document.detailform.action="deleteBook";
		document.detailform.submit();	
	}
	
</script>
</head>
<body>
<!-- <form action="books/insertBook" method="post">
	 -->
	 <form name="detailform" method="post">
	<c:if test="${USER.userPosition == 'librarian'}">	
	
	<c:forEach var="booklist" items="${GETBOOKLIST}">
	<!--  		
	 <c:set var="book" value="${GETBOOK}"/>
	  -->
	<table>
			<tr>
				<td>등록번호</td><td> <input type="text" name="bookRegistNumber" value="${booklist.bookRegistNumber}"> </td>
				<td> ISBN</td><td> <input type="text" name="bookISBN" value="${booklist.bookISBN}"></td>
				<td> 이용자 </td><td>${booklist.bookRentedBy.userId}</td>
			</tr>
			<tr>
				<td>서명</td><td> <input type="text" name="bookTitle" value="${booklist.bookTitle}"> </td>
				<td>청구기호</td><td> <input type="text" name="bookApplicationMark" value="${booklist.bookApplicationMark}"></td>
				<td>대출상태 </td>
				<c:if test="${booklist.bookStatus == '6'}"><td>대출가능</td></c:if> 
				<c:if test="${booklist.bookStatus == '7'}"><td>대출중</td></c:if> 
			</tr>
			<tr>
				<td>저자 </td><td><input type="text" name="bookAuthor" value="${booklist.bookAuthor}"></td>
				<td>분류</td>
				<td>
					<input type="radio" name="bookCategory" value="8" <c:if test="${booklist.bookCategory == '8'}">
					checked="checked" </c:if> >문학
					<input type="radio" name="bookCategory" value="9" <c:if test="${booklist.bookCategory == '9'}">
					checked="checked" </c:if> >역사
					<input type="radio" name="bookCategory" value="10" <c:if test="${booklist.bookCategory == '10'}">
					checked="checked" </c:if> >IT
					<input type="radio" name="bookCategory" value="11" <c:if test="${booklist.bookCategory == '11'}">
					checked="checked" </c:if> >예술
					<input type="radio" name="bookCategory" value="12" <c:if test="${booklist.bookCategory == '12'}">
					checked="checked" </c:if> >사회
					<input type="radio" name="bookCategory" value="13" <c:if test="${booklist.bookCategory == '13'}">
					checked="checked" </c:if> >기타
				</td>
				<td>대출날짜</td><td>${booklist.bookRentDate}</td>
			</tr>
			<tr>
				<td>출판사</td><td><input type="text" name="bookPublisher" value="${booklist.bookPublisher}"></td>
				<td>가격</td><td><input type="text" name="bookPrice" value="${booklist.bookPrice}"></td>
				<td>반납예정일</td><td>${booklist.bookReturnDate}</td>
			</tr>
			<tr>
				<td>출판년도</td><td> <input type="text" name="bookPublicationYear" value="${booklist.bookPublicationYear}"></td>
				<td>대출횟수</td><td>${booklist.bookCount}</td>
				<td></td>
			</tr>
		</table>
		</c:forEach>
		
		<input type="button" value="수정" onclick="sendUpdate()">		
		<input type="button" value="삭제" onClick="sendDelete()">
	</c:if>
	</form>
	
	
	<c:if test="${USER.userPosition == 'student'}">
	<c:forEach var="booklist" items="${GETBOOKLIST}">	
	<table>
		<tr>
			<td>등록번호</td><td>${booklist.bookRegistNumber}</td>
			<td> ISBN</td><td>${booklist.bookISBN}</td>
			<td>대출상태 </td>
			<c:if test="${booklist.bookStatus == '6'}"><td>대출가능</td></c:if> 
			<c:if test="${booklist.bookStatus == '7'}"><td>대출중</td></c:if> 				
		</tr>
		<tr>
			<td>서명</td><td>${booklist.bookTitle}</td>
			<td>청구기호</td><td>${booklist.bookApplicationMark}</td>
			<td>대출날짜</td><td>${booklist.bookRentDate}</td>
		</tr>
		<tr>
			<td>저자 </td><td>${booklist.bookAuthor}</td>
			<td>분류</td>
			<td>
				<input type="radio" name="bookCategory" value="8" <c:if test="${booklist.bookCategory == '8'}">
				checked="checked" </c:if> >문학
				<input type="radio" name="bookCategory" value="9" <c:if test="${booklist.bookCategory == '9'}">
				checked="checked" </c:if> >역사
				<input type="radio" name="bookCategory" value="10" <c:if test="${booklist.bookCategory == '10'}">
				checked="checked" </c:if> >IT
				<input type="radio" name="bookCategory" value="11" <c:if test="${booklist.bookCategory == '11'}">
				checked="checked" </c:if> >예술
				<input type="radio" name="bookCategory" value="12" <c:if test="${booklist.bookCategory == '12'}">
				checked="checked" </c:if> >사회
				<input type="radio" name="bookCategory" value="13" <c:if test="${booklist.bookCategory == '13'}">
				checked="checked" </c:if> >기타
			</td>
			<td>반납예정일</td><td>${booklist.bookReturnDate}</td>
		</tr>
		<tr>
			<td>출판사</td><td>${booklist.bookPublisher}</td>
		</tr>
		<tr>
			<td>출판년도</td><td>${booklist.bookPublicationYear}</td>
		</tr>
	</table>
	</c:forEach>
	</c:if>
</body>
</html>
