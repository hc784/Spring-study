<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Hello</title>
  </head>
  <body>
  <form action = "searchEmailForUpdate" method = "post">
   	<label>수정할 이메일<input type = "text" name = "email" id = "email"></label>
  </form> 	
  
  
   	<c:if test = "${emailSucess}">
   	<form action = "updateMember" method="post">
	   	<br><br>
	   	<label>수정할 비밀번호<input type = "text" name = "password" id = "password"></label>
	   	<br><br>
	   	<label>수정할 비밀번호 확인<input type = "text" name = "passwordconfirm" id = "passwordconfirm"></label>
	   	<br><br>
	    <label>수정할 이름<input type = "text" name = "name" id = "name"></label>
    </form>
   	</c:if>
  </body>
</html>
