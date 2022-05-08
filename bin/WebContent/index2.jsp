<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.app.EmployeeClass"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="employeeClass" class="com.app.Test" scope="session">
        <jsp:setProperty name="employeeClass" property="emplName" value="Tarek Faham" />
    </jsp:useBean>
    <h1>Hello World</h1>
    <p>
    <%
    out.println("This is from out.println ...");
    %>
    </p>
    <span>Employee Name: </span> <jsp:getProperty name="employeeClass" property="emplName" />
</body>
</html>