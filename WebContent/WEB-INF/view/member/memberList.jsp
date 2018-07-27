<%@page import="poly.util.CmmUtil"%>
<%@page import="poly.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
List<MemberDTO> mList=(List)request.getAttribute("mList");
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
				<%@include file="/WEB-INF/view/top.jsp" %>
			</td>
		</tr>
		<tr bgcolor="">
			<td>
				<table style="width:100%">
					<tr bgcolor="#59896B">
					  <td align="center">회원번호</td>
					  <td align="center">이름</td>
					  <td align="center">주소</td>
					  <td align="center">아이디</td>
					  <td align="center">등록일</td>
					  </tr>
					  <tr>
					<%for(int i=0;i<mList.size();i++){ %>
						
					  <tr>
					  	<td align="center"><%=mList.get(i).getMember_no() %></td>
					  	<td align="center">
					  		<a href="/member/memberDetail.do?memberNo=<%=mList.get(i).getMember_no()%>">
					  		<!-- 회원 목록 에서 상세보기를 위해 a태그를 이용 get방식으로 키값 벨류 키:memberNo 벨류 : mList.i번쨰 멤버 번호를 memberNo이름으로 가져간다. -->
					  			<%=mList.get(i).getMember_name() %>
					  		</a>
					  	</td>
					  	
					  	<td align="center"><%=CmmUtil.exchangeEscape(mList.get(i).getMember_addr()) %></td>
					  	<td align="center"><%=mList.get(i).getId() %></td>
					 	<td align="center"><%=mList.get(i).getReg_dt() %></td>
					  </tr>  
						
					<%} %>	
					
	
					
					</tr>
				</table>
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