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
	  
	  var loginVal = {
			  //리터럴객체.자바스크립트 오브젝트  형태로 loginVal에 넣음 
			  "memberid" : memberid,   
			  "memberpw" : memberpw
	  }
	  
	  if( memberid == null || memberid == "" || memberpw == null || memberpw == ""){
		  alert("ID와 PW를 다시 확인해 주세요! "); // 비어있지 않는지 확인 
	  }else{
		  $.ajax({  
			 type:"post",
			 url:"ajaxlogin.do",//를 실행 값을 가져오는 용도로. 
			 data: JSON.stringify(loginVal),  //자바스크립트옵젝트를 제이슨 형태의 문자열로 바꿔서 보냄  
			 contentType:"application/json", //어플리케이션 형태로 넘어가는데
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

