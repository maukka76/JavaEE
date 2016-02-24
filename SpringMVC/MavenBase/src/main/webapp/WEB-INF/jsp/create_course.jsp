<%-- 
    Document   : create_course
    Created on : 23.2.2016, 14:55:04
    Author     : Opiframe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Course</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="md-offset-6 md-col-6">
                    <form action="/admin/add" method="POST">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <select name="teach_id">
                            <c:forEach var="item" items="${teachers}">
                                <option value="${item.getId()}">${item.getTName()}</option>
                            </c:forEach>
                        </select>
                        <select name="course_id">
                            <c:forEach var="item" items="${courses}">
                                <option value="${item.getId()}">${item.getCName()}<option>
                            </c:forEach>
                        <select>
                        <input type="submit" value="Create Course"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
