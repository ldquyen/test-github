<%-- 
    Document   : home
    Created on : Oct 18, 2023, 5:19:26 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.customer.name}</h1>
        <form action="MainController" method="post">
            <input type="hidden" name="user" value="${sessionScope.customer}">
            <input type="submit" value="Logout" name="action">
        </form>
    </body>
</html>
