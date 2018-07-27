<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg = (String) request.getAttribute("msg");
	String url = (String)request.getAttribute("url");
%>
<!-- 회원가입 성공했을때 브라우저에 성공 또느 실패를 띄우기 위해 alert라는 jsp 만들고
	 메세지로 띄울 msg 변수를 만들고 값을 getAttribute로 키값지정
	 url도 똑같이. 

 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var msg = '<%=msg%>';
	var url = '<%=url%>';
	
	alert(msg);
	location.href=url;
	
	

</script>
</head>
<body>

</body>
</html>