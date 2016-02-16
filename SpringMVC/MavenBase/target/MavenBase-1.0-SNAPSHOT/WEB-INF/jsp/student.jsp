<%-- 
    Document   : student
    Created on : 16.2.2016, 13:53:15
    Author     : Opiframe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
       <%@include file="header.jsp" %>
       <div class="container">
           <div class="row">
               <div class="col-md-6">
                   <h1>Add New Student Info</h1>
                   <form:form action="/admin/student" method="POST" modelAttribute="student">
                       <form:label path="">Name</form:label><br/>
                       <form:input cssClass="form-control" path="SName"></form:input><br/>
                       <form:label path="">Address</form:label><br/>
                       <form:input cssClass="form-control" path="address"></form:input><br/>
                       <form:label path="">Email</form:label><br/>
                       <form:input cssClass="form-control" path="email"></form:input><br/>
                        <form:label path="">Phone</form:label><br/>
                       <form:input cssClass="form-control" path="phone"></form:input><br/>
                       <input class="btn btn-primary" type="submit" value="Save Student"/>
                   </form:form>
               </div>
               <div class="col-md-6">
                   <h1>All Students</h1>
                   <table class="table table-hover table-bordered">
                       <thead>
                           <tr>
                               <th>Name</th>
                               <th>Address</th>
                               <th>Email</th>
                               <th>Phone</th>
                           </tr>
                       </thead>
                       <tbody>
                           <c:forEach var="stud" items="${students}">
                               <tr>
                                   <td>${stud.getSName()}</td>
                                   <td>${stud.getAddress()}</td>
                                   <td>${stud.getEmail()}</td>
                                   <td>${stud.getPhone()}</td>
                               </tr>
                           </c:forEach>
                       </tbody>
                   </table>
               </div>
           </div>
       </div>
    </body>
</html>
