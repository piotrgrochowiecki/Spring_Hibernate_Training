<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 5/28/2022
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Person Form</title>
</head>
<body>
<form:form method="post" action="/person/addByForm" modelAttribute="person">
    Login: <form:input type="text" path="login"/>
    Password: <form:input type="password" path="password"/>
    Email: <form:input type="email" path="email"/>
    <input type="submit">
</form:form>
</body>
</html>
