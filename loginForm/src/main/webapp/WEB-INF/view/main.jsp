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
  	<c:if test = "${empty authInfo}">
   	<a href = "LoginPage"><input type = "button" value = "로그인"></a>
   	<a href = "Register"><input type = "button" value = "회원가입"></a> 
   	</c:if>
   	
   	<c:if test = "${! empty authInfo}">
   	<a href = "logout"><input type = "button" value = "로그아웃"></a>
   	</c:if>
   	
   	
   	
   	<br><br>
   	<a href = "EmailSearch"><input type = "button" value = "회원검색"></a>
   	<br><br>
   	<a href = "AllSearch"><input type = "button" value = "전체회원정보"></a>
   	<br><br>
   	<a href = "UpdateMember"><input type = "button" value = "회원정보수정"></a>
   	<br><br>
   	<a href = "DeleteMember"><input type = "button" value = "회원삭제"></a>
   		
   	<c:if test = "${empty authInfo}">
   	<p>환영합니다. 로그아웃 상태 </p>
   	</c:if>
   	
   	<c:if test = "${! empty authInfo}">
   	<p>${authInfo.name}님, 환영합니다.</p>
   	</c:if>
   	
  </body>
</html>
