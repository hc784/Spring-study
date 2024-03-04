<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>회원가입 실패</title>
  </head>
  <body>
   	회원가입을 실패했습니다. <br>
	Error : ${e.getMessage()}
   	<a href = "LoginPage">로그인 화면으로 이동</a>
  </body>
</html>
