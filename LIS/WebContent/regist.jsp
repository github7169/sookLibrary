<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>회원가입 페이지</title>
</head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
function check(){
	var userId = document.getElementById("userId").value;
	alert(userId);
	 $.ajax({
	   		type : "POST",
	   		url : "users/checkUserId",
	   		data : { userId : userId },
	   		success : function(data){
	   			if(data.result=="ok"){
	   				alert('존재하는 학번 / 교번입니다.');
	   			 $('#userPosition').val(data.position); 
	   			} else {
	   				alert('존재하지 않는 학번 /교번 입니다.');
	   			}
	   				
	   			}
	   		}
	 );
	   		
	   		
}
function regist(){
	var userId = document.getElementById("userId");
	var userPwd = document.getElementById("userPwd");
	var userName = document.getElementById("userName");
	var userDepartment = document.getElementById("userDepartment");
	var userPhoneNum = document.getElementById("userPhoneNum");
	var userPosition = document.getElementById("userPosition");
	if(userId != null & userPwd!=null & userName!=null & userDepartment!=null & userPhoneNum != null & userPosition!=null )
		location.href="<c:url value='/users/insertUser'/>?userId="+userId.value+"&userPwd="+userPwd.value+"&userName="+userName.value+"&userDepartment="+userDepartment.value+"&userPhoneNum="+userPhoneNum.value+"&userPosition="+userPosition.value;
	else
		alert("모든 항목을 입력하세요");
		
}
</script>
<body>
	<form action="regist()" method="post">
		<table>
			<tr>
				<td>*ID</td>
				<td><input type="text"  id="userId" name="userId" maxlength="7"></td>
				<!-- 조회 버튼은 학생의 경우 학생디비에서, 사서의 경우 교직원 디비에서 존재하는 학번, 교번인지 확인하는 것 -->
				<td><input type="button" value="조회" onclick="check()" /></td>
			</tr>
			<tr>
				<td>신분</td>
				<td>
					<input type="text"  id="userPosition" class="userPosition" maxlength="7" readonly="readonly"/>
					<!-- <a class="position" name="userPosition" value="학번 / 교번을 조회하세요">학번 / 교번을 조회하세요</a> -->
				</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" id="userPwd" name="userPwd" maxlength="20"> </td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="userName"  name ="userName" maxlength="10"></td>
			</tr>
			<tr>
				<td>*학과</td>
				<td><input type="text" id="userDepartment" name="userDepartment" maxlength="30"></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><input type="text" id="userPhoneNum" name="userPhoneNum" maxlength="20"></td>
			</tr>
			<tr>
				<td>* 사서의 경우 교직원 번호와 부서를 입력합니다.</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="가입" onClick="regist();"> <input type="reset" value="취소">
				</td>			
			</tr>
		</table>
	</form>
</body>
</html>
