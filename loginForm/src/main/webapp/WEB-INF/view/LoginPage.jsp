<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>main</title>
  </head>
  <body>
   	<form:form modelAttribute="loginCommand">
   	<p>
   		<label>이메일:<br>
   		<form:input path="email"/>
   		<form:errors path="email"/>
   		</label>
   	</p>
   	<p>
   		<label>비밀번호:<br>
   		<form:input path="password"/>
   		<form:errors path="password"/>
   		</label>
   	</p>
   	<p>
   		<label>이메일 기억하기<form:checkbox path="rememberEmail"/></label>
   	</p>
   	<input type = "submit" value = "로그인">
	
	</form:form>
   	
  </body>
</html>
