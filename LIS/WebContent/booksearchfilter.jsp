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
	<form action="<c:url value="/books/getBooks"/>" method="get">
		<select name="book_filter">
			<option value="registnum">등록번호</option>
			<option value="title">서명</option>
			<option value="author">저자</option>
			<option value="publisher">출판사</option>
			<option value="ISBN">ISBN</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색" />
		
		<!-- if Librarian -->
		<input type="button" value="삽입" onClick=/>
		<input type="button" value="삭제" onClick="alert('정말로 삭제하시겠습니까?')"/>
	</form>
</body>
</html>