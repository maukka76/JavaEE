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
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap-duallistbox.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src='<c:url value="/resources/js/jquery-2.1.4.js" />'></script>
        <script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
        <script src='<c:url value="/resources/js/jquery.bootstrap-duallistbox.js" />'></script>
        <script src='<c:url value="/resources/js/scripts.js" />'></script>

        
        <title>Create Course</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <h2>Select Teacher, course and students</h2>
            <div class="row">
                <div class="md-offset-4 md-col-4">
                    
                        <select id="teach_id">
                            <c:forEach var="item" items="${teachers}">
                                <option value="${item.getId()}">${item.getTName()}</option>
                            </c:forEach>
                        </select>
                        <select id="course_id">
                            <c:forEach var="item" items="${courses}">
                                <option value="${item.getId()}">${item.getCName()}<option>
                            </c:forEach>
                        <select>
                </div>
                <div class="md-col-4">
                    <select multiple="multiple" size="10" class="students">
                        <c:forEach var="item" items="${students}">
                            <option value="${item.getId()}">${item.getSName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <br/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="button" class="btn btn-primary" id="send" value="Create Course"/>
            </div>
        </div>
    </body>
</html>
