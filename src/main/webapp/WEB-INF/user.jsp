<%--
  Created by IntelliJ IDEA.
  User: sololobo
  Date: 2021/9/27
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    <style>
        * {
            box-sizing: border-box;
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
        #thisInput {
            /*background-image: url('/css/searchicon.png');*/
            background-position: 10px 10px;
            background-repeat: no-repeat;
            width: 100%;
            font-size: 16px;
            padding: 12px 20px 12px 40px;
            border: 1px solid #ddd;
            margin-bottom: 12px;
        }




        .overlay {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: rgb(0,0,0);
            background-color: rgba(0,0,0, 0.9);
            overflow-x: hidden;
            transition: 0.5s;
        }

        .overlay-content {
            position: relative;
            top: 25%;
            width: 100%;
            text-align: center;
            margin-top: 30px;
        }

        .overlay a {
            padding: 8px;
            text-decoration: none;
            font-size: 36px;
            color: #818181;
            display: block;
            transition: 0.3s;
        }

        .overlay a:hover, .overlay a:focus {
            color: #f1f1f1;
        }

        .overlay .closebtn {
            position: absolute;
            top: 20px;
            right: 45px;
            font-size: 60px;
        }

        @media screen and (max-height: 450px) {
            .overlay a {font-size: 20px}
            .overlay .closebtn {
                font-size: 40px;
                top: 15px;
                right: 35px;
            }
        }
        .topnav-right {
            float: right;
        }
    </style>
</head>
<body>
<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Borrow List</span>
<div class="topnav-right">
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout">
    </form>
</div>

<div id="myNav" class="overlay">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <div class="overlay-content">
        <h1>Your Borrowed Books</h1>
        <table id="borrowedBook">
            <tr>
                <th>ID</th>
                <th>ISBN</th>
                <th>Title</th>
                <th>Writer</th>
                <th>Type</th>
                <th>Available Amount</th>
                <th>return</th>
            </tr>

            <c:forEach items="${book}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.isbn}</td>
                    <td>${item.title}</td>
                    <td>${item.writer}</td>
                    <td>${item.type}</td>
                    <td>${item.available}</td>
                    <td>
                        <i class='fas fa-undo-alt'></i>
                        <form action="/borrow?bookId=${item.id}&userId=${user.id}" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="submit" value="Logout">
                        </form>
<%--                        <button style='font-size:24px;color:lawngreen'>--%>
<%--                            <i class='fas fa-undo-alt'></i>--%>
<%--                            <a href="/borrow?bookId=${item.id}&userId=${user.id}"></a>--%>

<%--                        </button>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<h2 style="text-align: center">Welcome to the Library</h2>
<br>

<input type="text" id="thisInput" onkeyup="thisSearch()" placeholder="Search book by title..." title="Type in a name">

<table id="bookTable">
    <tr>
        <th>ID</th>
        <th>ISBN</th>
        <th>Title</th>
        <th>Writer</th>
        <th>Type</th>
        <th>Borrow</th>
    </tr>

    <c:forEach items="${book}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.isbn}</td>
            <td>${item.title}</td>
            <td>${item.writer}</td>
            <td>${item.type}</td>
            <td>
<%--                <button style='font-size:24px;color:lawngreen'><i class='fas fa-plus'></i>--%>
<%--                    --%>
<%--                </button>--%>
            <form action="${pageContext.request.contextPath}/borrow?bookId=${item.id}" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" value="Borrow" style='font-size:24px;color:lawngreen'>
            </form>
            </td>
        </tr>
    </c:forEach>

</table>

<script>
    function thisSearch() {
        let input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("thisInput");
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

    function openNav() {
        document.getElementById("myNav").style.width = "100%";
    }

    function closeNav() {
        document.getElementById("myNav").style.width = "0%";
    }

</script>
</body>
</html>
