<%@page import="poly.dto.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
NoticeDTO nDetail=(NoticeDTO)request.getAttribute("nDetail");
//request.getAttribute("컨트롤러에서 모델에 올릴때 이름");
%>

	
<html>
<head>
<title>WEB!</title>
<script type="text/javascript">
function doDelete(noticeNo){
	if(confirm("삭제 하시겠습니까?")){
		location.href="/notice/noticeDelete.do?noticeNo="+noticeNo
	}
	
}
	


</script>

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
					제목 : <%=nDetail.getTitle() %>
					내용 : <%=nDetail.getContent() %>
					<br><br>
					<a href="#" onclick="doDelete('<%=nDetail.getNotice_no()%>')">삭제</a>
					<a href="/notice/noticeUpdateView.do?noticeTitle=<%=nDetail.getNotice_no()%>">수정</a>
					<tr height="7%" bgcolor="#00D8FF">
						<td>
							<%@include file="/WEB-INF/view/bottom.jsp" %>
						</td>
					</tr>
</body>
</html>