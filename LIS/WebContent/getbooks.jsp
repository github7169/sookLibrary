<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menubar.jsp"></jsp:include>
<jsp:include page="booksearchfilter.jsp"></jsp:include>
<table border="1">
<c:if test="${USER.userPostion == 'librarian'}">
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
		<tr>
			<td><input type="checkbox" name="isChecked"></td>
			<td>1</td>
			<td>1094080</td>
			<td><a href="#">Head first servlets ＆ JSP™ :상상력을 자극하는 몰입의 학습법</a></td>
			<td>Sierra, Kathy.</td>
			<td>한빛미디어</td>
			<td>9788979146639</td>
			<td>005.133 S572hs2K</td>
			<td></td>
			<td>대출가능</td>
			<td></td>
			<td></td>
		</tr>
</c:if>
<!-- if student -->
<c:if test="${USER.userPostion == 'student'}">
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
		<tr>
			<td><input type="checkbox" name="isChecked"></td>
			<td>1</td>
			<td>1094080</td>
			<td><a href="#">Head first servlets ＆ JSP™ :상상력을 자극하는 몰입의 학습법</a></td>
			<td>Sierra, Kathy.</td>
			<td>한빛미디어</td>
			<td>9788979146639</td>
			<td>대출가능</td>
			<td></td>
		</tr>
</c:if>
	</table>
	<jsp:include page="bookdetail.jsp"></jsp:include>
</body>
</html>