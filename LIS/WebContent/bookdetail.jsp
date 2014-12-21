<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteBook(){
		var status = confirm("정말로 삭제하시겠습니까?");
		if(status==true)
			window.location.href='<c:url value="books/deleteBook"/>';
	}
</script>
</head>
<body>
<form action="books/insertBook" method="post">
	<c:if test="${USER.userPostion == 'librarian'}">
		<table>
			<tr>
				<td>등록번호</td><td> <input type="text" name="bookRegistNumber"> </td>
				<td> ISBN</td><td> <input type="text" name="bookISBN"></td>
				<td> 이용자 </td><td><input type="text" name="bookRentedBy"></td>
			</tr>
			<tr>
				<td>서명</td><td> <input type="text" name="bookTitle"> </td>
				<td>청구기호</td><td> <input type="text" name="bookApplicationMark"></td>
				<td>대출상태 </td><td><input type="text" name="bookStatus"></td>
			</tr>
			<tr>
				<td>저자 </td><td><input type="text" name="bookAuthor"> </td>
				<td>분류 </td><td><input type="text" name="bookCategory"></td>
				<td>대출날짜 </td><td><input type="text" name="bookRentDate"></td>
			</tr>
			<tr>
				<td>출판사</td><td> <input type="text" name="bookPublisher"></td>
				<td>가격</td><td> <input type="text" name="bookPrice"></td>
				<td>반납예정일</td><td> <input type="text" name="bookReturnDate"></td>
			</tr>
			<tr>
				<td>출판년도</td><td> <input type="text" name="bookPublicationYear"></td>
				<td>대출횟수</td><td> <input type="text" name="bookCount"></td>
			</tr>
		</table>
		
		<input type="button" value="수정" onclick="window.location.href='<c:url value="books/updateBook"/>'">
		<input type="submit" value="저장">			
		<input type="button" value="삭제" onClick="deleteBook()">
	</c:if>
	</form>
	<c:if test="${USER.userPostion == 'student'}">
		<table>
			<tr>
				<td>등록번호</td><td>${BOOK.bookRegistNumber }</td>
				<td>ISBN</td><td>${BOOK.bookISBN }</td>
				<td>대출상태 </td><td>${BOOK.bookStatus }</td>
				
			</tr>
			<tr>
				<td>서명</td><td>${BOOK.bookTitle }</td>
				<td>청구기호</td><td>${BOOK.bookApplicationMark }</td>
				<td>대출일</td><td>${BOOK.bookRentDate }</td>
			</tr>
			<tr>
				<td>저자 </td><td>${BOOK.bookAuthor }</td>
				<td>분류 </td><td>${BOOK.bookCategory }</td>
				<td>반납예정일</td><td>${BOOK.bookReturnDate }</td>
				<td></td>
			</tr>
			<tr>
				<td>출판사</td><td>${BOOK.bookPublisher }</td>
				<td></td><td></td>
				<td></td>
			</tr>
			<tr>
				<td>출판년도</td><td>${BOOK.bookPublicationYear }</td>
				<td></td>
				<td></td>
			</tr>
		</table>
		</c:if>
</body>
</html>