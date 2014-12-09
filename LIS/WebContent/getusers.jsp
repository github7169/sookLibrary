<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
		
<% int cnt=1; %>
      <c:forEach var="userlist" items="${USERLIST}">         
       <tr>
         
         <td><%= cnt++ %></td>
          <td>${userlist.userId}</td>
         <td>${userlist.userName}</td>
         <td>${userlist.userDepartment}</td>
         <td>${userlist.userPhoneNum}</td>
         <td>${userlist.userStatus }</td>
         <!--  
         <c:if test="${userlist.userStatus == '6'}"><td>대출제한</td></c:if> 
         <c:if test="${userlist.userStatus == '4'}"><td>연체중</td></c:if>
         <c:if test="${userlist.userStatus == '5'}"><td>대출가능</td></c:if>  
         -->
         <td>0원</td>
         <td>0권</td>
       </tr>
      </c:forEach>
		
	</table>
</body>
</html>