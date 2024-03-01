<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Hello</title>
  </head>
  <body>
	${requestScope.memberId.getEmail()}
	${requestScope.memberId.getName()}
	${requestScope.memberId.getPassword()}
  </body>
</html>
