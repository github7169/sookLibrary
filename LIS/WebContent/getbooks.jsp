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
			<th>��Ϲ�ȣ</th>
			<th>����</th>
			<th>����</th>
			<th>���ǻ�</th>
			<th>ISBN</th>
			<th>û����ȣ</th>
			<th>�̿���</th>
			<th>�������</th>
			<th>������</th>
			<th>�ݳ�������</th>
		</tr>
		<tr>
			<td><input type="checkbox" name="isChecked"></td>
			<td>1</td>
			<td>1094080</td>
			<td><a href="#">Head first servlets �� JSP�� :������ �ڱ��ϴ� ������ �н���</a></td>
			<td>Sierra, Kathy.</td>
			<td>�Ѻ��̵��</td>
			<td>9788979146639</td>
			<td>005.133 S572hs2K</td>
			<td></td>
			<td>���Ⱑ��</td>
			<td></td>
			<td></td>
		</tr>
</c:if>
<!-- if student -->
<c:if test="${USER.userPostion == 'student'}">
<!-- ��Ϲ�ȣ, ����, ����, ���ǻ�, û����ȣ, �������, �ݳ������� -->
		<tr>
			<th><input type="checkbox" name="isChecked"></th>
			<th>no</th>
			<th>��Ϲ�ȣ</th>
			<th>����</th>
			<th>����</th>
			<th>���ǻ�</th>
			<th>û����ȣ</th>
			<th>�������</th>
			<th>�ݳ�������</th>
		</tr>
		<tr>
			<td><input type="checkbox" name="isChecked"></td>
			<td>1</td>
			<td>1094080</td>
			<td><a href="#">Head first servlets �� JSP�� :������ �ڱ��ϴ� ������ �н���</a></td>
			<td>Sierra, Kathy.</td>
			<td>�Ѻ��̵��</td>
			<td>9788979146639</td>
			<td>���Ⱑ��</td>
			<td></td>
		</tr>
</c:if>
	</table>
	<jsp:include page="bookdetail.jsp"></jsp:include>
</body>
</html>