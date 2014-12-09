<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteBook(){
		var status = confirm("������ �����Ͻðڽ��ϱ�?");
		if(status==true)
			window.location.href='<c:url value="books/deleteBook"/>';
	}
</script>
</head>
<body>
<form action="books/insertBook" method="post">
	<c:if test="${USER.userPosition == 'librarian'}">
		<table>
			<tr>
				<td>��Ϲ�ȣ</td><td> <input type="text" name="bookRegistNumber"> </td>
				<td> ISBN</td><td> <input type="text" name="bookISBN"></td>
				<td> �̿��� </td><td><input type="text" name="bookRentedBy"></td>
			</tr>
			<tr>
				<td>����</td><td> <input type="text" name="bookTitle"> </td>
				<td>û����ȣ</td><td> <input type="text" name="bookApplicationMark"></td>
				<td>������� </td><td><input type="text" name="bookStatus"></td>
			</tr>
			<tr>
				<td>���� </td><td><input type="text" name="bookAuthor"> </td>
				<td>�з�</td>
				<td>
					<input type="radio" name="bookCategory" value="8">����
					<input type="radio" name="bookCategory" value="9">����
					<input type="radio" name="bookCategory" value="10">IT
					<input type="radio" name="bookCategory" value="11">����
					<input type="radio" name="bookCategory" value="12">��ȸ
					<input type="radio" name="bookCategory" value="13">��Ÿ
				</td>
				<td>���⳯¥ </td><td><input type="text" name="bookRentDate"></td>
			</tr>
			<tr>
				<td>���ǻ�</td><td> <input type="text" name="bookPublisher"></td>
				<td>����</td><td> <input type="text" name="bookPrice"></td>
				<td>�ݳ�������</td><td> <input type="text" name="bookReturnDate"></td>
			</tr>
			<tr>
				<td>���ǳ⵵</td><td> <input type="text" name="bookPublicationYear"></td>
				<td>����Ƚ��</td><td> <input type="text" name="bookCount"></td>
			</tr>
		</table>
		
		<input type="button" value="����" onclick="window.location.href='<c:url value="books/updateBook"/>'">
		<input type="submit" value="����">			
		<input type="button" value="����" onClick="deleteBook()">
	</c:if>
	</form>
	<c:if test="${USER.userPosition == 'student'}">
		<table>
			<tr>
				<td>��Ϲ�ȣ</td><td>${BOOK.bookRegistNumber }</td>
				<td>ISBN</td><td>${BOOK.bookISBN }</td>
				<td>������� </td><td>${BOOK.bookStatus }</td>
				
			</tr>
			<tr>
				<td>����</td><td>${BOOK.bookTitle }</td>
				<td>û����ȣ</td><td>${BOOK.bookApplicationMark }</td>
				<td>������</td><td>${BOOK.bookRentDate }</td>
			</tr>
			<tr>
				<td>���� </td><td>${BOOK.bookAuthor }</td>
				<td>�з� </td><td>${BOOK.bookCategory }</td>
				<td>�ݳ�������</td><td>${BOOK.bookReturnDate }</td>
				<td></td>
			</tr>
			<tr>
				<td>���ǻ�</td><td>${BOOK.bookPublisher }</td>
				<td></td><td></td>
				<td></td>
			</tr>
			<tr>
				<td>���ǳ⵵</td><td>${BOOK.bookPublicationYear }</td>
				<td></td>
				<td></td>
			</tr>
		</table>
		</c:if>
</body>
</html>