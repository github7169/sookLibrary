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
<%  String button="";
	String check=""; 
	int cnt=1; %>
<jsp:include page="menubar.jsp"></jsp:include>
<jsp:include page="booksearchfilter.jsp"></jsp:include>
<table border="1">
<c:if test="${USER.userPosition == 'librarian'}">
<!-- if librarian -->
		<tr>
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
		
		<!-- 검색결과가 없습니다 -->
		<% 
			String notFound = (String) request.getAttribute("notFound");
			if( "notFound".equals(notFound)){ 	
				%><tr>
	    		<td colspan="11" align="center">검색결과가 없습니다.</td></tr>
		<% } %>
		
		<form method="post" action="bookdetail.jsp">
		<c:forEach var="booklist" items="${GETBOOKLIST}">			
    	<tr>
    		<td><%= cnt++ %></td>
    		<td>${booklist.bookRegistNumber}</td>
			<td>			 
			<a href="<c:url value="/books/getBooks?book_filter=registnum&keyword=${booklist.bookRegistNumber}&check=yes"/>">${booklist.bookTitle}</a>  					 
			</td>
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
		
		</form>		
</c:if>

<!-- if student -->
<c:if test="${USER.userPosition == 'student'}">
<!-- 등록번호, 서명, 저자, 출판사, 청구기호, 대출상태, 반납예정일 -->
		<tr>
			<th>no</th>
			<th>등록번호</th>
			<th>서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>청구기호</th>
			<th>대출상태</th>
			<th>반납예정일</th>
		</tr>
		
		<!-- 검색결과가 없습니다 -->
		<% 
			String notFound = (String) request.getAttribute("notFound");
			if( "notFound".equals(notFound)){ 	
				%>
				<tr>
	    			<td colspan="8" align="center">검색결과가 없습니다.</td>
	    		</tr>
		<% } %>
		
		<c:forEach var="booklist" items="${GETBOOKLIST}">	
			 		
    	<tr>
    		<td><%= cnt++ %></td>
    		<td>${booklist.bookRegistNumber}</td>
			<td>	
			<a href="<c:url value="/books/getBooks?book_filter=registnum&keyword=${booklist.bookRegistNumber}&check=yes"/>">${booklist.bookTitle}</a>  					 
			</td>
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
	
	<!--  책 삽입 버튼 눌렀을 때 빈 등록칸 뜨게 -->
	<%  button = request.getParameter("button");
		if( "insert".equals(button)){ 	%>
			<jsp:include page="bookinsert.jsp"></jsp:include>
	<% } %>
	
	<!--  각 책 제목 눌렀을 때 해당 상세정보가 뜨게 -->
	<%  check = request.getParameter("check");
		if( "yes".equals(check)){ 	%>
			<jsp:include page="bookdetail.jsp"></jsp:include>
	<% } %>
</body>
</html>