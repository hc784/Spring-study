<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Hello</title>
  </head>
  <body>
  <form action = "searchEmailForUpdate" method = "post">
   	<label>수정할 이메일<input type = "text" name = "email" id = "email" value=${email}></label>
  </form> 	
  
  
   	<c:if test = "${emailSucess}">
   	<form action = "updateMember" method="post">
	   	<br><br>
	   	<input type = "hidden" name = "email" value = "${email}">
	   	<label>수정할 비밀번호<input type = "text" name = "password" id = "password"></label>
	   	<br><br>
	   	<label>수정할 비밀번호 확인<input type = "text" name = "passwordconfirm" id = "passwordconfirm"></label>
	   	<br><br>
	    <label>수정할 이름<input type = "text" name = "name" id = "name"></label>
	    <br><br>
	    <input type = "submit" value = "완료">
    </form>
   	</c:if>
  </body>
</html>
