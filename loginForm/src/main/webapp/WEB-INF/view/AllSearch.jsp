<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>전체회원정보</title>
  </head>
  <body>
  <c:forEach var="item" items = "${requestScope.memberList}">
  	<p>
  	Email : ${item.getEmail()} <br>
  	Name : ${item.getName()} <br>
  	Password : ${item.getPassword()}<br>
  	</p>
  </c:forEach>   	
  <a href = "LoginPage">로그인 화면으로 이동</a>
  </body>
</html>
