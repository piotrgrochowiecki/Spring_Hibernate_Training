<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 6/4/2022
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book validation results</title>
</head>
<body>
<c:forEach items="${errors}" var="error">
    <h1>${error.getPropertyPath()} : ${error.getMessage()}</h1><br>
</c:forEach></body>
</html>
