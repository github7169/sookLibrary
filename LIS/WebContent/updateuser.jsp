<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ����</title>
</head>
<body>
<form action="users/updateUser" method="post">
		<table>
			<tr>
				<td>*ID</td>
				<td>dbwls878</td>
			</tr>
			<tr>
				<td>�н�����</td>
				<td><input type="password" name="pwd"> </td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>*�а�</td>
				<td><input type="text" name="department"></td>
			</tr>
			<tr>
				<td>* �缭�� ��� ������ ��ȣ�� �μ��� �Է��մϴ�.</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="����"> <input type="reset" value="���"> <input type="button" value="Ż��" onClick="confirm('������ Ż���Ͻðڽ��ϱ�?')">
				</td>			
			</tr>		
			</tr>
		</table>
	</form>
</body>
</html>