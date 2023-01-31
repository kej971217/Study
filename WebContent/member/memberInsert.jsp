<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	
	/* id 데이터 검증 */
	$('#uid').on('keyup', function() {
		// 입력한 id값 가져오기
		idvalue = $('#uid').val().trim();
		
		idreg = /^[a-z][a-z0-9]{3,7}$/;
		
		if(!(idreg.test(idvalue))){
			// 틀린 경우
			$(this).css('border', '2px solid red');
			$('#idcheck').prop('disabled', true);
		}else {
			// 맞은 경우
			$(this).css('border', '2px solid blue');
			$('#idcheck').prop('disabled', false);
		}
		
	})
	
	/* 이름 데이터 검증 */
	$('#uname').on('keyup', function() {
		// 입력한 이름 가져오기
		namevalue = $(this).val().trim();
		
		namereg = /^[가-힣]+|^[a-zA-Z]+$/;
		
		if(namereg.test(namevalue)){
			rkor = /^[가-힣]{2,5}$/;
			reng = /^[a-zA-Z]{5,20}$/;
			
			if(rkor.test(namevalue)){
					// 한글
					$(this).css('border', '2px solid blue');
				}else if(reng.test(namevalue)){
					// 영문
					$(this).css('border', '2px solid blue');
				}else {
					$(this).css('border', '2px solid red');
				}
			}else {
				// 한글, 영문 X
				$(this).css('border', '2px solid red');
			}
		
	})
	
	/* 이메일 검증 */
	$('#umail').on('keyup', function() {
		//입력한 값 가져오기
		mailvalue = $(this).val().trim();
		
		mailreg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z]+){1,2}$/;
		
		
	})
	
	
	/* 전화번호 검증 */
	$('#utel').on('keyup', function() {
		telvalue = $(this).val().trim();
		
		telreg = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/;
		//telreg = /^\d{3}-\d{4}-\d{4}$/;
	})
	
	/* 비밀번호 검증 - 영문 대(65-90)소문자(97-122) 숫자(48-57) 특수문자 반드시 포함 */
	// 전방탐색 찾을문자(?=기준문자) 찾을문자가 표현되지 않으면 기준문자는 반드시 포함되어야 한다.
	$('#pwd').on('keyup', function() {
		passvalue = $(this).val().trim();
// 		passreg = /.*(?=[a-z])/
		passreg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_-]).{10,20}$/;
		
		if(passreg.test(passvalue)){
			$(this).css('border', '2px solid blue');
		}else {
			$(this).css('border', '2px solid red');
		}
		
	})
	
	/* 번호 검색 */
	$('#zipbtn').on('click', function(){
		window.open("zipsearch.jsp", "우편번호찾기", "width=500 height=500 top=100 left=200")
	})
	
	
	/* id중복검사  */
	$('#idcheck').on('click', function(){
		// 입력한 id값 가져오기
		idvalue = $('#uid').val().trim();
		
		if(idvalue.length < 1){
			alert("ID를 입력 하세요.");
			return false;
		}
		
		// 서버로 전송
		$.ajax({
// 			url : '/jquerypro/IDCheck.do', 
// 			url : 'http://localhost/jquerypro/IDCheck.do', 
			url : '<%=request.getContextPath()%>/IDCheck.do',
			type : 'get',
			data : { "id" : idvalue },
			success : function(res){
				//alert(res.sw);
				$('#idres').html(res.sw).css('color', 'red');
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : 'json'
		})
		
	})
	
	
	/* 전송 - 가입하기 */
	// input type=button / button type=button 일 경우
	$('#send').on('click', function(){

	formdata = $('form').serializeJSON();
	
	console.log(formdata);
	
	// 서버로 보내기
	$.ajax({
		url : '<%=request.getContextPath()%>/memberInsert.do',
		type : 'post',
		data : formdata,
		dataType: 'json',
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		success : function(res){
			alert(res.sw);
		}
		
	})
	
	})
	
	 // input type = submit / button type=submit일 경우 - form태그에서 onsubmit="return false;"
	   $('form').on('submit', function(){
	      //alert("hello submit");
	      
	   })
	   /* 우편번호 모달 띄우기 - 특별한 이벤트 없이 해당버튼에 아래 속성들을 설정한다.  */
	   //data-toggle="modal" data-target="#zipModal"
	   
	   
	   /* 우편번호 모달에서 dong입력 후 확인버튼 클릭시*/
	   $('#searchdong').on('click', function(){
	      //입력한 동을 가져온다.
	      dongvalue = $('#dong').val().trim();
	      
	      if(dongvalue.length < 1){
	         alert("동을 입력하세요");
	         return false;
	      }
	      
	      //서버로 보낸다.
	      $.ajax({
	         url : '<%=request.getContextPath()%>/ZipSearch.do',
	         type : 'Post',
	         data : {"dong" : dongvalue},
	         success : function(res){
	            
	            code = "<table><tr><td>우편번호</td><td>주소</td><td>번지</td></tr>";
	            $.each(res, function(i, v){
	               code += "<tr class='ziptr'><td>" + v.code + "</td>"
	               code += "<td>" + v.addr + "</td>"
	               code += "<td>" + v.bunji + "</td></tr>";
	            })
	            code += "</table>";
	            
	            $('#res').html(code);
	            
	         },
	         error : function(xhr){
	            alert("상태 : " + xhr.status);
	         },
	         dataType : 'json'
	         
	     	 })
	      })
	      	
	      
	      // 동적으로 새롭게 생성된 요소의 이벤트 - delegate
   $(document).on('click',function() {
      codetext = $('td', this). eq(0).text();
      addrtext = $('td', this). eq(1).text();
      
      $('#uzip').val(codetext);
      $('#uadd1').val(addrtext);
      
      $('#zipModal').modal('hide');
   })// click
   /* 모달 닫기 이벤트 */
   $('#zipModal').on('hide.bs.modal', function(){
	   
	   $('#dong').val("");
	   $('#res').empty();
	   
   })
   
	
}) //$function
</script>
</head>
<body>
<h3>회원 정보 입력 폼</h3>
<table>
	<tr>
	<td>회원ID</td>
	<td><input id="uid" name="memid" type="text"><input type="button"></td>	
	<td>비밀번호</td>
	<td><input id="upass" name="mempass" type="text"></td>	
	<td>회원이름</td>
	<td><input id="uname" name="memname" type="text"></td>	
	<td>전화번호</td>
	<td><input id="utel" name="memtel" type="text"></td>	
	<td>주소</td>
	<td><input id="uaddr" name="memaddr" type="text"></td>	
	<td>프로필사진</td>
	<td><input id="uprofile" type="button" vlaue="파일선택"></td>	
	<td colspan="2"><input type="button" value="수정">
		<input type="button" value="삭제"><input type="button" value="회원목록">
	</td>
	</tr>
	<tr>
	<td colspan="2"><input type="button" value="저장">
					<input type="button" value="취소"><input type="button" value="회원목록">
					</td>
	</tr>

</table>

</body>
</html>