<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:useBean id="employeeClass" class="com.app.EmployeeClass" scope="session" />
    <jsp:setProperty name="employeeClass" property="*"/>
    <jsp:setProperty name="employeeClass" property="emplName" value="Tarek Faham aa" />
    <h1>Hello World</h1>
    <p>
    <%
    out.println("This is from out.println xxx ...");
    %>
    </p>
    <span>Employee Name: </span> <jsp:getProperty name="employeeClass" property="emplName" />
    <p>${employeeClass.readJson(pageContext.request.getRealPath("/jsonfile.json"), pageContext.request)}</p>
    <p>Servlet Context xx</p>
    <p>${pageContext.request.getRealPath("")}</p>
	<p>${pageContext.request.getServletContext().getResource("/data/list.json")}</p>    
    <p>Read from URL yy:</p>
    <%
    	request.setAttribute("baseUrl", employeeClass.getRequestBaseUrl(request));
    %>
    <p>Base URL ${baseUrl}</p>
    <p>${employeeClass.readFileFromURL(baseUrl)}</p>
    <p>${employeeClass.readFileFromStream(pageContext.request)}</p>
</body>
</html>