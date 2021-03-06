<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%String temp=""; %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 
<body>
<jsp:include page="menubar.jsp"></jsp:include>
	<br>
	<hr>
	<br>
	<jsp:include page="usersearchfilter.jsp"></jsp:include>
	<table border="1">
		<tr>
			<th>no</th>
			<th>학번</th>
			<th>이름</th>
			<th>학과</th>
			<th>핸드폰 번호</th>
			<th>상태</th>
			<th>연체료</th>
			<th>대출권수</th>
		</tr>
		<br>
		
		
		<% 
			String notFound = (String) request.getAttribute("notFound");
			if( "notFound".equals(notFound)){ 	
				%><tr>
	    		<td colspan="12" align="center">검색결과가 없습니다.</td></tr>
		<% } %>
		
		
<% int cnt=1; %>

      <c:forEach var="userlist" items="${USERLIST}">    
          
       <tr>
         
         <td><%= cnt++ %></td>
          <td>${userlist.userId}</td>
         <td>${userlist.userName}</td>
         <td>${userlist.userDepartment}</td>
         <td>${userlist.userPhoneNum}</td>
         <c:if test="${userlist.userStatus == '3'}"><td>대출제한</td></c:if> 
         <c:if test="${userlist.userStatus == '4'}"><td>연체중</td></c:if>
         <c:if test="${userlist.userStatus == '5'}"><td>대출가능</td></c:if> 
         <c:if test="${userlist.userStatus == '3'}"><td>0원</td></c:if> 
         <c:if test="${userlist.userStatus == '4'}"><td>100원</td></c:if>
         <c:if test="${userlist.userStatus == '5'}"><td>0원</td></c:if> 
         <c:if test="${userlist.userStatus == '3'}"><td>7권</td></c:if> 
         <c:if test="${userlist.userStatus == '4'}"><td>4권</td></c:if>
         <c:if test="${userlist.userStatus == '5'}"><td>3권</td></c:if> 
         
       </tr>
      </c:forEach>
	
	</table>
</body>
</html>