<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
List<MemberVO> detailList = (List<MemberVO>)request.getAttribute("memberDetail");
%>
</head>
<body>
<h3>회원 상세 보기</h3>
<table border="1">
	<tr>
	<td colspan="2" style="height:50px;"><%= %>사진</td>
	<tr>
	<tr>
	<td>회원ID</td>
	<td><%= %></td>	
	<td>비밀번호</td>
	<td><%= %></td>	
	<td>회원이름</td>
	<td><%= %></td>	
	<td>전화번호</td>
	<td><%= %></td>	
	<td>주소</td>
	<td><%= %></td>	
	<td colspan="2"><input type="button" value="수정">
		<input type="button" value="삭제"><input type="button" value="회원목록">
	</td>
	</tr>

</table>
</body>
</html>