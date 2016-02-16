<%-- 
    Document   : second
    Created on : 10.2.2016, 13:20:39
    Author     : Opiframe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" />
        <title>Teacher</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1>Add new teacher information</h1>
                    <form:form action="/admin/teacher" method="POST" modelAttribute="teacher">
                        <form:label path="">Name</form:label><br/>
                        <form:input cssClass="form-control" path="TName"></form:input><br/>
                        <form:label path="">Email</form:label><br/>
                        <form:input cssClass="form-control" path="email"></form:input><br/>
                        <form:label path="">Phone</form:label><br/>
                        <form:input cssClass="form-control" path="phone"></form:input><br/>
                        <form:label path="">Subject</form:label><br/>
                        <form:input cssClass="form-control" path="TSubject"></form:input><br/>
                        <input class="btn btn-primary" type="submit" value="Save Teacher"/>
                    </form:form>
                    <p>${save_info}</p>
                </div>
                <div class="col-md-6">
                    <h1>All Teachers</h1>
                    <table class="table table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Subject</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="teach" items="${teachers}">
                            <tr>
                                <td>${teach.getTName()}</td>
                                <td>${teach.getEmail()}</td>
                                <td>${teach.getPhone()}</td>
                                <td>${teach.getTSubject()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
            </div>
        </div>
    </body>
</html>
