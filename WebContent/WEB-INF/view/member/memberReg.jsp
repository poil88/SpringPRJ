<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>
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
				<form action="/member/memberProc.do" method="post">
				ID : <input type="text" name="id" required="required">
				PASSWORD :<input type="password" name="password" required="required">
				NAME    : <input type="text" name="name" required="required">
				<input type="text" id="sample6_postcode" placeholder="우편번호" required="required">
				<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				주소 :<input type="text" id="sample6_address" name="addr" required="required">
				상세주소 :<input type="text" id="sample6_address2" name="addrDetail" required="required">
				<input type="submit" value="회원 가입">
				
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