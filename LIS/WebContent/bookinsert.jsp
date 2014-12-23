<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 책 삽입 버튼을 누르면 빈 칸의 상세보기 목록이 나와야해서 따로 빼둔 화면 -->
<form action="<c:url value="/books/insertBook"/>" method="get">
	
	<table>
			<tr>
				<td>등록번호</td><td><input type="text" name="bookRegistNumber"> </td>
				<td> ISBN</td><td><input type="text" name="bookISBN"></td>
				<td> 이용자</td>
			</tr>
			<tr>
				<td>서명</td><td> <input type="text" name="bookTitle"> </td>
				<td>청구기호</td><td><input type="text" name="bookApplicationMark"></td>
				<td>대출상태</td><td><input type="text" name="bookStatus" value=6 disabled></td>		
			</tr>
			<tr>
				<td>저자 </td><td><input type="text" name="bookAuthor"></td>
				<td>분류</td>
				<td>
					<input type="radio" name="bookCategory" value="8"/>문학
					<input type="radio" name="bookCategory" value="9">역사
					<input type="radio" name="bookCategory" value="10">IT
					<input type="radio" name="bookCategory" value="11">예술
					<input type="radio" name="bookCategory" value="12">사회
					<input type="radio" name="bookCategory" value="13">기타
				</td>
				<td>대출날짜</td>
			</tr>
			<tr>
				<td>출판사</td><td><input type="text" name="bookPublisher"></td>
				<td>가격</td><td><input type="text" name="bookPrice"></td>
				<td>반납예정일</td>
			</tr>
			<tr>
				<td>출판년도</td><td><input type="text" name="bookPublicationYear"></td>
				<td>대출횟수</td><td><input type="text" name="bookCount" value=0 disabled></td>
			</tr>
		</table>
		
		<input type="submit" value="저장">			
	</form>
</body>
</html>