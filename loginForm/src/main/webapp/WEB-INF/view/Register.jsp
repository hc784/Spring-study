<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>회원가입</title>
  </head>
  <body>
  <form action = "register" method = "post">
	  <p>
	  <label>이메일</label><br><input type = "text" name = "email" id = "email">
	  </p>
	  <p>
	  <label>이름</label><br><input type = "text" name = "name" id = "name">
	  </p>
	  <p>
	  <label>비밀번호</label><br><input type = "password" name = "password" id ="password">
	  </p>
	  <p>
	  <label>비밀번호 확인</label><br><input type = "password" name = "passwordConfirm" id ="passwordConfirm">
	  </p>
	  <input type = "submit" value = "가입완료">
  
  </form>
   	
  </body>
</html>
