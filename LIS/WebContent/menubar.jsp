<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
<!-- if librarian -->
<c:if test="${USER.userPosition == 'librarian'}">
 ID : ${USER.userName }님 <a href="<c:url value="/getbooks.jsp"/>">도서 관리</a> <a href="<c:url value="/getusers.jsp"/>">회원 조회</a> 
</c:if>
<!-- if student -->
<c:if test="${USER.userPosition == 'student'}">
 ID : ${USER.userName }님 <a href="<c:url value="/getbooks.jsp"/>">도서 검색</a> <a href="<c:url value="/getrentedlist.jsp"/>">대출 목록</a>
</c:if>
<a href="<c:url value="/updateuser.jsp"/>">계정 관리</a> <a href="<c:url value="/users/logout"/>">로그아웃</a> 
</body>
</html>