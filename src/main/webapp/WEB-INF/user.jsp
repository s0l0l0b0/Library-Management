<%--
  Created by IntelliJ IDEA.
  User: sololobo
  Date: 2021/9/27
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <center><h1>ALL AIRPORTS</h1></center>
<body>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout">
    </form>
</div>

<div class="column">
    <center><h2>BOOKS</h2></center>
    <input type="text" id="searchBook" onkeyup="toFindBook()" placeholder="Search for books by Title"
           title="Type in a name">
    <table id="bookTable">
        <tr>
            <th>ID</th>
            <th>ISBN</th>
            <th>Title</th>
            <th>Writer</th>
            <th>Type</th>
            <th>Available Amount</th>
            <th>Borrow</th>
        </tr>

        <c:forEach items="${book}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.isbn}</td>
                <td>${item.title}</td>
                <td>${item.writer}</td>
                <td>${item.type}</td>
                <td>${item.available}</td>
                <th>
                    <button></button>
            </tr>
        </c:forEach>

    </table>
</div>

<script>
    function toFindBook() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("searchBook");
        filter = input.value.toUpperCase();
        table = document.getElementById("bookTable");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[2];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
</body>
</html>
