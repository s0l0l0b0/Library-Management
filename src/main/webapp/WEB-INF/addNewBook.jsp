<%--
  Created by IntelliJ IDEA.
  User: sololobo
  Date: 2021/9/27
  Time: 下午8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            * {
                box-sizing: border-box;
            }

            input[type=text], select, textarea {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                resize: vertical;
            }

            label {
                padding: 12px 12px 12px 0;
                display: inline-block;
            }

            input[type=submit] {
                background-color: #04AA6D;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: right;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            .container {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }

            .col-25 {
                float: left;
                width: 25%;
                margin-top: 6px;
            }

            .col-75 {
                float: left;
                width: 75%;
                margin-top: 6px;
            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 600px) {
                .col-25, .col-75, input[type=submit] {
                    width: 100%;
                    margin-top: 0;
                }
            }
        </style>
        <title></title>
    </head>
    <body>

    <h2 style="text-align: center">Add New Book</h2>


        <div class="container">
            <form action="/addNewBook" method="post">
                <c:if test="${not empty book}">
                    <input type="hidden" name="id" value="${book.id}">
                </c:if>
                <div class="row">
                    <div class="col-25">
                        <label for="isbn">ISBN</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="isbn" name="isbn" value="${book.isbn}" placeholder="enter the isbn here...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="title">Title</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="title" name="title" value="${book.title}" placeholder="enter the title here...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="title">Writer</label>
                    </div>
                    <div class="col-75">
                        <input type="text" id="writer" name="writer" value="${book.writer}" placeholder="enter the name of writer here...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="type">Type</label>
                    </div>
                    <div class="col-75">
                        <select id="type" name="type">
                            <c:forEach items="${typeOfBooks}" var="item">
                            <option ${book.type == item? "selected":""}>
                                ${item}
                            </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <br>
                <div class="row">
                    <input type="submit" value="Submit">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </body>
</html>