<%-- 
    Document   : second
    Created on : 10.2.2016, 13:20:39
    Author     : Opiframe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teacher</title>
    </head>
    <body>
        <div>
            <h1>Add new teacher information</h1>
            <form:form action="/teacher" method="POST" modelAttribute="teacher">
                <form:label path="">Name</form:label><br/>
                <form:input path="TName"></form:input><br/>
                <form:label path="">Email</form:label><br/>
                <form:input path="email"></form:input><br/>
                <form:label path="">Phone</form:label><br/>
                <form:input path="phone"></form:input><br/>
                <form:label path="">Subject</form:label><br/>
                <form:input path="TSubject"></form:input><br/>
                <input type="submit" value="Save Teacher"/>
            </form:form>
            <p>${save_info}</p>
        </div>
    </body>
</html>
