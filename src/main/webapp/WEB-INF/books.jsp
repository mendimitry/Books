<%@ page import="java.util.List" %>
<%@ page import="com.journaldev.jsf.Books" %>
<%@ page import="com.journaldev.jsf.UserDAO" %>
<%@ page import="com.journaldev.jsf.Books" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    List<Books> col = new UserDAO().pilotsList();
    request.setAttribute("msgList", col);
%>
<!DOCTYPE html>
<html>

<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> User
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="home" class="nav-link">Users</a></li>
        </ul>
        <ul class="navbar-nav">
            <li><a href="${pageContext.request.contextPath}" class="nav-link">Консоль администратора</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">Каталог книг</h3>
        <hr>
        <div class="container text-left">

            <a href="/home" class="btn btn-success">Add
                New User</a>
        </div>
        <br>
        <ul>
        <table class="table">
<thead>
        <tr>
            <th>Номер книги</th>
            <th>Шифр</td>
            <th>Название</td>
            <th>Автор</th>
            <th>Место издания</td>
            <th>Издательство</td>
            <th>Год издания</th>
            <th>Количество страниц</td>
        </tr>
        <tread>
            <c:forEach items="${msgList}" var="msg">
                <tbody>
                    <tr>
                        <td> ${msg.numberKnigi}</td>
                        <td> ${msg.chif}</td>
                        <td> ${msg.nazvanie}</td>
                        <td> ${msg.avtor}</td>
                        <td> ${msg.mestoIzdaniya}</td>
                        <td> ${msg.izadtelstvo}</td>
                        <td> ${msg.setYearIzdaniya()}</td>
                        <td> ${msg.kolStranic}</td>
                    </tr>
                </tbody>

            </c:forEach>
        </tread>
        </table>
            </ul>
    </div>


</div>
</body>

</html>