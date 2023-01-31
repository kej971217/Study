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
	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
%>
</head>
<body>
<h3>회원 목록 보기</h3>
<table border="1">
	<tr>
		<td colspan="5" style="text-align: right;"><input type="button" value="회원추가"></td>
	</tr>
	<tr>
		<td>ID</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>전화</td>
		<td>주소</td>
	</tr>
<%
if(memberList == null || memberList.size() ==0){
%>
<tr>
	<td colspan="5" style="text-align:center;">저장된 회원이 없습니다.</td>
</tr>
<%
}else{
	for(MemberVO memberVO : memberList){
%>
	<tr>
		<td><a href="#"><%=memberVO.getMem_id() %></a></td>
		<td><%=memberVO.getMem_pass() %></td>
		<td><%=memberVO.getMem_name() %></td>
		<td><%=memberVO.getMem_tel() %></td>
		<td><%=memberVO.getMem_addr() %></td>
	</tr>
<%
	}
}
%>
</table>
</body>
</html>