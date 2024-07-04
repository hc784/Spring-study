<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Hello</title>
  </head>
  <body>
	${requestScope.member.getEmail()}
	${requestScope.member.getName()}
	${requestScope.member.getPassword()}
  </body> <br>
  <a href = "main">메인으로 이동</a>
</html>
