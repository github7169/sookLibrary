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
<c:if test="${USER.userPostion == 'librarian'}">
 ID : ${USER.userName }�� <a href="<c:url value="/getbooks.jsp"/>">���� ����</a> <a href="<c:url value="/getusers.jsp"/>">ȸ�� ��ȸ</a> <a href="<c:url value="/updateuser.jsp"/>">���� ����</a>
</c:if>
<!-- if student -->
<c:if test="${USER.userPostion == 'student'}">
 ID : ${USER.userName }�� <a href="<c:url value="/getbooks.jsp"/>">���� �˻�</a> <a href="<c:url value="/getrentedlist.jsp"/>">���� ���</a> <a href="<c:url value="/updateuser.jsp"/>">���� ����</a> 
</c:if>
</body>
</html>