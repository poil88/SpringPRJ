<%@page import="poly.dto.NoticeDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="poly.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
NoticeDTO nDelete=(NoticeDTO)request.getAttribute("nDelete");

%>
	
<html>
<head>
<title>WEB!</title>
</head>
<body>
	<table style="height: 100%; width: 100%">
		<tr height="7%" bgcolor="#00D8FF">
			<td>
				<%@include file="/WEB-INF/view/top.jsp" %>
			</td>
		</tr>
			<tr bgcolor="">
				<td>
				<form action="/notice/noticeDelete.do">
				
				
				
				
				</form>
				
					<tr height="7%" bgcolor="#00D8FF">
						<td>
							<%@include file="/WEB-INF/view/bottom.jsp" %>
						</td>
					</tr>
	</table>
</body>
</html>