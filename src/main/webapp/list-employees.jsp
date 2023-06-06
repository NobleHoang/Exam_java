<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>Employee Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="#" class="navbar-brand"> Employee
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Employees</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Employees</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                New Employee</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Birthday</th>
                <th>Address</th>
                <th>Position</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="employee" items="${employeeList}">

                <tr>
                    <td>
                        <c:out value="${employee.id}" />
                    </td>
                    <td>
                        <c:out value="${employee.full_name}" />
                    </td>
                    <td>
                        <c:out value="${employee.birthday}" />
                    </td>
                    <td>
                        <c:out value="${employee.address}" />
                    </td>
                    <td>
                        <c:out value="${employee.position}" />
                    </td>
                    <td>
                        <c:out value="${employee.department}" />
                    </td>

                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
        <div>
            <button class="btn btn-danger">
                <a class="text-white" href="delete-all">Delete All</a>
            </button>
        </div>
    </div>
</div>
</body>

</html>