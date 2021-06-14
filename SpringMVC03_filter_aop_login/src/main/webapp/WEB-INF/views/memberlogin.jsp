<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

  $(function(){
	$("#loginChk").hide();  
  });
   
  function login(){
	  var memberid = $("#memberid").val().trim();
	  var memberpw = $("#memberpw").val().trim(); //id.pw 가져와서 
	  
	  var loginVal = { //객체형태로 바꿔줌 
			  //자바스크립트의 리터럴객체.자바스크립트 오브젝트형태로 loginVal에 넣음 
			  "memberid" : memberid,  //프로퍼티(키이름:값) ->여러 개를 하나로 모은 복합 데이터로 연관 배열 을 객체리터럴이라고함.  
			  "memberpw" : memberpw
	  }
	  
	  if( memberid == null || memberid == "" || memberpw == null || memberpw == ""){
		  alert("ID와 PW를 다시 확인해 주세요! "); // 비어있지 않는지 확인  유효성검사 
	  }else{
		  $.ajax({  
			 type:"post", // post이기때문에 body(안보이는)에 담겨서 전송 get은 header(주소값 같이 보냄 ) 
			 url:"ajaxlogin.do",//를 실행 값을 가져오는 용도로. 
			 data: JSON.stringify(loginVal),  //자바스크립트옵젝트형태(loginVal)를 제이슨(JSON)형태로 바꿔서 보냄  
			 contentType:"application/json",  //어플리케이션 형태로 넘어가는데
			 dataType:"json", //형태
			 success:function(msg){
				 if(msg.check == true){  //key에 대한 값 가져옴 map 형태로 
					 location.href="list.do";
					 
					 
				 }else{
					 $("#loginChk").show();
		  			 $("#loginChk").html("id 혹은 pw를 다시 확인해 주세요 ")
				 }
				 
			 },
			 error: function(){
				 alert("통신 실패");
			 }
		  });
	  }
  }


</script>



</head>
<body>

  <table border="1">
     <tr>
       <th>ID</th>
       <td><input type="text" id="memberid"></td>
     </tr>
     <tr>
       <th>PW</th>
       <td><input type="text" id="memberpw"></td>
     </tr>
     <tr>
       <td colspan="2"><input type="button" value="login" onclick="login();"></td>
     </tr>
     <tr>
       <td colspan="2" align="center" id="loginChk"></td>
     </tr>
  
  </table>
</body>
</html>

