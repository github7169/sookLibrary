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
			<option value="registnum">등록번호</option>
			<option value="title">서명</option>
			<option value="author">저자</option>
			<option value="publisher">출판사</option>
			<option value="ISBN">ISBN</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색" />
		
		<!-- if Librarian -->
		<input type="button" value="삽입"/>
		<input type="button" value="삭제" onClick="alert('정말로 삭제하시겠습니까?')"/>
	</form>
</body>
</html>