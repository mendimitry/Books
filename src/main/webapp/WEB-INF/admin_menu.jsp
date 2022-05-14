<%@ page import="com.journaldev.jsf.Chitateli" %>
<%@ page import="java.util.List" %>
<%@ page import="com.journaldev.jsf.UserDAO" %>
<%@ page import="java.util.concurrent.atomic.AtomicReference" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Консоль администратора</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Консоль администратора </a>
        </div>
    </nav>
</header>
<br>
<%
    List<Chitateli> col = new UserDAO().chitateliList();
    request.setAttribute("msgList", col);
%>

<div id="welcome"></div>

<script src="https://code.jquery.com/jquery-1.10.2.js"
        type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Users</h3>
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
                    <th>Номер читателя</th>
                    <th>Номер билета</td>
                    <th>Фамилия Имя Отчество</td>
                    <th>Адрес</th>
                    <th>Дом. телефон</td>
                    <th>Раб. телефон</td>
                </tr>
                <tread>
                    <c:forEach items="${msgList}" var="msg">
                <tbody>
                <tr>
                    <td> ${msg.numberChitatelya}</td>
                    <td> ${msg.numberBileta}</td>
                    <td> ${msg.familiyaImyaOtchestvo}</td>
                    <td> ${msg.address}</td>
                    <td> ${msg.telephoneDom}</td>
                    <td> ${msg.telephoneRab}</td>
                </tr>
                </tbody>

                </c:forEach>
                </tread>
            </table>

            <h1>Создание нового читателя</h1>

            <div class="center">
                <form action="${pageContext.request.contextPath}/Insert" method="POST">
                    <div class="inputbox">
                        <input type="text" name="NumberChitatelya" required="required">
                        <span>NumberChitatelya</span>
                    </div>
                    <div class="inputbox">
                        <input type="text" name="NumberBileta" required="required">
                        <span>NumberBileta</span>
                    </div>
                    <div class="inputbox">
                        <input type="text" name="FamiliyaImyaOtchestvo" required="required">
                        <span>FamiliyaImyaOtchestvo</span>
                    </div>
                    <div class="inputbox">
                        <input type="text" name="Address" required="required">
                        <span>Address</span>
                    </div>
                    <div class="inputbox">
                        <input type="text" name="TelephoneRab" required="required">
                        <span>TelephoneRab</span>
                    </div>
                    <div class="inputbox">
                        <input type="text" name="TelephoneDom" required="required">
                        <span>TelephoneDom</span>
                    </div>
                    <div class="inputbox">
                        <input type="submit" value="Создать">
                    </div>
                </form>

                <form>
                    Enter Your Name: <input type="text" id="userName" />
                </form>
                <strong>Ajax Response</strong>:
                <div id="ajaxGetUserServletResponse"></div>
            </div>
        </ul>
    </div>
</div>
</body>
</html>
