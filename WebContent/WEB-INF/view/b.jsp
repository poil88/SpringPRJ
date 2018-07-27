<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- b.jsp 화면에서 c로 몸무게와 키를 넘겨줘야하므로 input태그를 이용해서 키와 몸무게 값을 텍스트 값으로 넘겨준다
	 이때 action에서 jsp같은경우에는 넘겨줄 페이지를 적었엇는데 스프링도 마찬가지로 넘어가질 페이지이지만 
	 spring은 무조건 Controller 로 가서 해당 데이터를 받아줄 메소드를 찾고 그 메소드 안에서
	 데이터 값을 입력받는다 이때 값을 받을때 매개변수안에 HttpServeltRequest requset를 적어서
	 requset.getParameter("받을name값")을 명시 
	 값확인을 위해 System.out.println(변수명) 으로 확인해준다.

  -->
<form action="c.do" method="post">
<input type="text" name="test" value="test">
<input type="submit" value="b에서C로이동">

키 : <input type="text" name="cm" value="">
몸무게 : <input type="text" name="kg" value="">
<input type="submit" value="몸무게와 키">

 </form>

여기는 b 페이지 입니다.
</body>
</html>