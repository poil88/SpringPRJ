<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="a.do">a로 이동</a>

<form action="a.do" method="post">

<select name="top">

<option selected="selected">상의사이즈 	:
<option value="95">95
<option value="100">100
<option value="105">105
<option value="110">110
</option>
</select>

<select name="bottom">
<option>
<option selected="selected">하의사이즈 :
<option value="28">28
<option value="29">29
<option value="30">30
</option>
</select>

<input type="submit" value="사이즈 선택완료">

</form>

<form action="e.do" method="post">
휴대폰번호 : <input type="text" name="phone">
		  <input type="submit" value="전송">

</form>

여기는 d 페이지 입니다.
</body>
</html>