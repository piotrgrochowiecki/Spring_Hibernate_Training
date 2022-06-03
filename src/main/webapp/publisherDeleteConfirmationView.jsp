<%--
  Created by IntelliJ IDEA Ultimate.
  User: piotr
  Date: 6/3/2022
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete Confirmation</title>
</head>
<body>
<c:out value="Are you sure you want to delete publisher ${publisher.name}?"></c:out>
<a href="/publishers/delete/${publisher.id}">Yes, delete</a>
<a href="/publishers/findAll">No, go back to publishers list</a>
</body>
</html>
