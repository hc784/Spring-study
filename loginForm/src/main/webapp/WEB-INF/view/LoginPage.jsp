<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>main</title>
  </head>
  <body>
   	<form action = "login" method = "post">
   	<p>
   		<label>아이디:<br>
   		<input type = "text" name ="id" id = "id">
   		</label>
   	</p>
   	<p>
   		<label>비밀번호:<br>
   		<input type="password" name = "password" id = "password">
   		</label>
   	</p>
   	<input type = "submit" value = "로그인">
   	<a href = "Register"><input type = "button" value = "회원가입"></a>
   	<br>
   	<a href = "EmailSearch"><input type = "button" value = "회원검색"></a>
   	</form>
   	
   	
  </body>
</html>
