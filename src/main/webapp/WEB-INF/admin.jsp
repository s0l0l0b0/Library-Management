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

    <style>
        * {
            box-sizing: border-box;
        }

        .row {
            margin-left:-5px;
            margin-right:-5px;
        }

        .column {
            float: left;
            width: 50%;
            padding: 5px;
        }

        /* Clearfix (clear floats) */
        .row::after {
            content: "";
            clear: both;
            display: table;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
            width: 100%;
            border: 1px solid #ddd;
        }

        th, td {
            text-align: left;
            padding: 16px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #searchBook, #searchUser {
            /*background-image: url('/css/searchicon.png');*/
            background-position: 10px 10px;
            background-repeat: no-repeat;
            width: 100%;
            font-size: 16px;
            padding: 12px 20px 12px 40px;
            border: 1px solid #ddd;
            margin-bottom: 12px;
        }
    </style>
</head>

<body>
<h1 style="text-align: center">Admin Panel</h1>

<div>
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout">
    </form>
    <button><a href="add_new_book">Add New Book</a>
    </button>
</div>

<div class="row">
    <div class="column">
        <table id="userTable">
            <center><h2>USERS</h2></center>
            <input type="text" id="searchUser" onkeyup="toFindUser()"
                   placeholder="Search for user by ID" title="Type in a name">

            <tr>
                <th>ID</th>
                <th>User Name</th>
                <th>User Role</th>
<%--                <th>Password</th>--%>
                <th>Email</th>
                <th>Email</th>
                <th>Edit</th>
            </tr>

            <c:forEach items="${user}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.role}</td>
<%--                    <td>${item.password}</td>--%>
                    <td>${item.email}</td>
                    <td>${item.isActive}</td>
                    <th><button>Deactivate</button>
                </tr>
            </c:forEach>

        </table>
    </div>


    <div class="column">
        <center><h2>BOOKS</h2></center>
        <input type="text" id="searchBook" onkeyup="toFindBook()" placeholder="Search for books by ID" title="Type in a name">
        <table id="bookTable">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Writer</th>
                <th>Type</th>
                <th>Total Amount</th>
                <th>Available Amount</th>
                <th>Edit</th>
            </tr>
            <c:forEach items="${book}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.title}</td>
                    <td>${item.writer}</td>
                    <td>${item.type}</td>
                    <td>${item.totalAmount}</td>
                    <td>${item.available}</td>
                    <th><button>Edit</button>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>


<script>
    function toFindUser() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("searchUser");
        filter = input.value.toUpperCase();
        table = document.getElementById("userTable");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
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

    function toFindBook() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("searchBook");
        filter = input.value.toUpperCase();
        table = document.getElementById("bookTable");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
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
