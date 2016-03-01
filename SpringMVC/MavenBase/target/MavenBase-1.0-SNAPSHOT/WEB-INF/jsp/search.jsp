<%-- 
    Document   : add_students
    Created on : 23.2.2016, 17:33:12
    Author     : Opiframe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css" />
        <script src='<c:url value="/resources/js/jquery-2.1.4.js" />'></script>
        <script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
        <script src='<c:url value="/resources/js/search.js" />'></script>
        <title>Search</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <h2>Select teacher or course or both to search information</h2>
            <select id="teach_id">
                <option value="">None</option>
                <c:forEach var="item" items="${teachers}">
                    <option value="${item.getId()}">${item.getTName()}</option>
                </c:forEach>
            </select>
            <select id="course_id">
                <option value="">None</option>
                <c:forEach var="item" items="${courses}">
                    <option value="${item.getId()}">${item.getCName()}</option>
                </c:forEach>
            </select>
            <br/>
            <br/>
            <input type="button" class="btn btn-primary" id="search" value="Serach Information"/>
        </div>
        <div class="result">
                
        </div>
    </body>
</html>
