<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 5/30/2022
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student form</title>
</head>
<body>
<%--<form:form modelAttribute="student">--%>
<%--  First Name: <form:input path="firstName"/><br>--%>
<%--  Last Name: <form:input path="lastName"/> <br>--%>
<%--  Male: <form:radiobutton path="gender" value="M" />--%>
<%--  Female: <form:radiobutton path="gender" value="F" /> <br>--%>
<%--  Country: <form:select path="country" items="${countries}" multiple="false"/> <br>--%>
<%--  Notes: <form:textarea path="notes" rows="3" cols="20"/> <br>--%>
<%--  Mailing list: <form:checkbox path="mailingList" /> <br>--%>
<%--  Programming skills: <form:select path="programmingSkills"  items="${programmingSkills}" multiple="true"/> <br>--%>
<%--  Hobbies:<form:checkbox path="hobbies" items="${hobbies}"/>--%>
<%--  <input type="submit">--%>
<%--</form:form>--%>
<form:form modelAttribute="student" method="post">
    <form:input path="firstName" />
    <input type="submit">
</form:form>
test, czy mnie widać???
</body>
</html>
