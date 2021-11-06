<%--
  Created by IntelliJ IDEA.
  User: sololobo
  Date: 10/27/21
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user's borrow log</title>

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
        .switch {
            position: relative;
            display: inline-block;
            width: 60px;
            height: 34px;
        }

        .switch input {
            opacity: 0;
            width: 0;
            height: 0;
        }

        .slider {
            position: absolute;
            cursor: pointer;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: #ccc;
            -webkit-transition: .4s;
            transition: .4s;
        }

        .slider:before {
            position: absolute;
            content: "";
            height: 26px;
            width: 26px;
            left: 4px;
            bottom: 4px;
            background-color: white;
            -webkit-transition: .4s;
            transition: .4s;
        }

        input:checked + .slider {
            background-color: #2196F3;
        }

        input:focus + .slider {
            box-shadow: 0 0 1px #2196F3;
        }

        input:checked + .slider:before {
            -webkit-transform: translateX(26px);
            -ms-transform: translateX(26px);
            transform: translateX(26px);
        }

        /* Rounded sliders */
        .slider.round {
            border-radius: 34px;
        }

        .slider.round:before {
            border-radius: 50%;
        }
    </style>

</head>
<body>

<div class="overlay-content">
<h1 style="text-align: center">Borrow Info of ${user.name}</h1>
    <table id="borrowedBook">
        <tr>
            <th>ID</th>
            <th>ISBN</th>
            <th>Title</th>
            <th>Writer</th>
            <th>Type</th>
            <th>Borrowed Date</th>
            <th>Fine</th>

        </tr>

        <c:forEach items="${borrowLogFineDTOList}" var="item">
            <tr>
                <td>${item.borrowLog.id}</td>
                <td>${item.borrowLog.book.isbn}</td>
                <td>${item.borrowLog.book.title}</td>
                <td>${item.borrowLog.book.writer}</td>
                <td>${item.borrowLog.book.type}</td>
                <td>${item.borrowLog.date}</td>
                <td>${item.fine}</td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
