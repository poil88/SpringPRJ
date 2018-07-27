<%@page import="poly.util.CmmUtil"%>
<%@page import="poly.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<MemberDTO> mList = (List) request.getAttribute("mList");
	System.out.println(mList);
%>


<html>
<head>
<title>WEB!</title>
</head>
<body>
	<table style="height: 100%; width: 100%">
		<tr height="7%" bgcolor="#00D8FF">
			<td>
				<div align="right">
					<%@include file="/WEB-INF/view/top.jsp" %>
				</div>
			</td>
		</tr>
		<tr bgcolor="">
		<!-- main 에서 회원가입 클릭후 화면 지정해주기 위해 Reg.jsp 화면 구현 후 
			 회원가입을 눌렀을때 데이터를 전송할 memberProc를 액션으로 form태그를 구현한다.
			 이때 화면에서 입력해야할 ID값 PW값 NAME값 주소 상세주소를 jsp화면으로 만든후
			 memberController에서 memberProc value값으로 만들어준다.
		 -->
			<td>
				
			<form action="/notice/noticeReg.do" method="post">
				<table>
					<tr>
						<td>
					Title: <input type="text" name="title" required="required"><br>
						</td>
					</tr>
				
					<tr>
						<td>
					내용 :   <input type="text" name="contents" required="required"><br>
						</td>
					</tr>
					<tr>
						<td>
						   <input type="submit" value="등록">
						</td>
					</tr>	
					
				</table>		
			</form>
				
			</td>
		</tr>
		
		<tr height="7%" bgcolor="#00D8FF">
			<td>
				<%@include file="/WEB-INF/view/bottom.jsp" %>
			</td>
		</tr>
	</table>
</body>
</html>