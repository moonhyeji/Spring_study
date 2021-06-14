<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	file : ${fileObj.name }<br>
	desc : ${fileObj.desc }<br> <!--  //글자표시 --> 
	
	
	<form action="download" method="post">
	  <input type="hidden" name="name" value='${fileObj.name }'/>
	  <input type="submit" value="download">
	</form>
	
	<!-- mime-type(Multipurpose Internet Mail Extension) 
	request header에 지정된느, 데이터가 어떤 종류의 stream인지를 나타내 주는 프로토콜 
	//보내는 데이터가 어떤 종류인지 알려주는 것. 
	
	
	
	<mime-mapping>
	   <extension>hwp</extension>
	   <mime-type>application/unknown</mime-type>
	</mime-mapping>
	이런식으로 설정 해주면 됨. 
	-->
</body>
</html>