<%@page import="poly.dto.NoticeDTO"%>
<%@page import="poly.util.CmmUtil"%>
<%@page import="poly.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
List<NoticeDTO> nList=(List)request.getAttribute("nList");
System.out.println("nList : "+ nList);
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
				<form action="/notice/noticeList.do" method="post">
					<table style="width:100%">
						<tr bgcolor="#59896B">
						  <td align="center">제목</td>
						  <td align="center">조회수</td>
						  <td align="center">등록일</td>
						  
						  </tr>
						  <tr>
						  <%for(int i=0;i<nList.size();i++){ %>
						  <td align="center"><a href="/notice/noticeDetail.do?noticeNo=<%=nList.get(i).getNotice_no()%>"><%=nList.get(i).getTitle() %></a></td>
						  <td align="center"><%=nList.get(i).getCnt() %></td>
						  <td align="center"><%=nList.get(i).getReg_dt() %></td>
						<tr height="7%" bgcolor="#00D8FF">
						</tr>
						
					<%} %>	
					</table>
				</form>
					<tr height="7%" bgcolor="#00D8FF">
						<td>
							<%@include file="/WEB-INF/view/bottom.jsp" %>
						</td>
					</tr>
</body>
</html>