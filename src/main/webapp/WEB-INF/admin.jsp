<%--
  Created by IntelliJ IDEA.
  User: sololobo
  Date: 2021/9/23
  Time: 下午6:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Admin Panel</title>
</head>
<body>
<h3>Admin Panel</h3>
<div>
    <button>All Users</button>
    <button>Books</button>
    <form action="/logout" method="post">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input type="submit" value="Logout">
    </form>
</div>
</body>
</html>
