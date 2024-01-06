
<%@page import="java.util.ArrayList"%>
<%@page import="dto.Account"%>
<%@page import="dto.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ADMIN PAGE ${sessionScope.admin.accountID}</h1>       
        <form action="AdminController" method="post">
            <input type="submit" value="Manage Customer" name="action">       
        </form>
        <form action="AdminController" method="post">
            <input type="submit" value="Manage Flower" name="action">       
        </form>
        <form action="AdminController" method="post">
            <input type="submit" value="Manage Order" name="action">       
        </form>
        <form action="MainController" method="post">
            <input type="submit" value="Logout" name="action">
        </form>
    </body>
</html>
