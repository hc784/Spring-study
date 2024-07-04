<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>회원가입</title>
  </head>
  <body>
<%--   <form action = "register" method = "post">
	  <p>
	  <label>이메일</label><br><input type = "text" name = "email" id = "email" value = "${memberForm.email}">
	  </p>
	  <p>
	  <label>이름</label><br><input type = "text" name = "name" id = "name" value = "${memberForm.name}">
	  </p>
	  <p>
	  <label>비밀번호</label><br><input type = "password" name = "password" id ="password" value = "${memberForm.password}">
	  </p>
	  <p>
	  <label>비밀번호 확인</label><br><input type = "password" name = "passwordconfirm" id ="passwordconfirm" value = "${memberForm.passwordconfirm}">
	  </p>
	  <input type = "submit" value = "가입완료">
  
  </form> --%>
 
    <form:form action = "register" modelAttribute = "memberForm">
	  <p>
	  <label>이메일</label><br><form:input path = "email" />
	  <form:errors path = "email"/>
	  </p>
	  <p>
	  <label>이름</label><br><form:input path = "name" />
	  <form:errors path = "name"/>
	  </p>
	  <p>
	  <label>비밀번호</label><br><form:input path = "password" />
	  <form:errors path = "password"/>
	  </p>
	  <p>
	  <label>비밀번호 확인</label><br><form:input path = "passwordconfirm" />
	  <form:errors path = "passwordconfirm"/>
	  </p>
	  <input type = "submit" value = "가입완료">
  
  </form:form>
    
<%--   <c:if test ="${requestScope.e}!=NULL">
  <br> <% String err = model.getAttribute.getMessage(); %>
  </c:if> --%>
   	
  </body>
</html>
