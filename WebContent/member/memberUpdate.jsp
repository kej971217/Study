<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
	<td colspan="2" style="height:50px;"><%= %>사진</td>
	<tr>
	<tr>
	<td>회원ID</td>
	<td><%= %></td>	
	<td>비밀번호</td>
	<td><input name="mempass" type="text"></td>	
	<td>회원이름</td>
	<td><input name="memname" type="text"></td>	
	<td>전화번호</td>
	<td><input name="memtel" type="text"></td>	
	<td>주소</td>
	<td><input name="memaddr" type="text"></td>	
	<td>주소</td>
	<td><input type="button" value="파일 선택"></td>	
	<td colspan="2"><input type="button" value="수정">
		<input type="button" value="삭제"><input type="button" value="회원목록">
	</td>
	</tr>

</table>
</body>
</html>