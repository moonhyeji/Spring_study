<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
																		<!--  컨트롤러의 (/upload)로 이동 -->
    <h1>Upload form</h1>
    
    file<br>
    
       <input type="file" name="mfile"/>
       <br>
       <p style="color:red; font-weight: bold;">  <!-- 에너 났을 때 글자 css  -->
          <form:errors path="mfile"/> <!--  path : 필드값 / 바인딩 오류 및 입력값 검사 오류를 출력 -->
                                      <!-- (path= 필드) 필드에 설정돼있는 에러코드별 에러메시지를 출력 -->
       </p>        
       <!-- mfile 이라는 이름으로 / 에러를 가져와서 걸 출력. "Please select a file"  -->
       
       
       <br>
       description<br>
       <textarea rows="10" cols="60" name="desc"></textarea>
       <input type="submit" value="send">
       </form:form>
       
       
       
       <!-- 
         <form tag의 enctype 속성>
         1.application/www-form-urlencoded: 문자들이 encoding 됨 (default)
         2.multipart/form-data: fileupload 기능(무조건 post로 사용)
         3.text/plain :encoding 하지 않음. 
         
         spring form tag<spring이 제공하고 잇는 jstl>
           form:errors -> Errors, BindingResult를 사용할 때, command 객체의 특정 field에서 발생하는 에러메세지 출력 가능. 
         
       
       
        -->

</body>
</html>





























