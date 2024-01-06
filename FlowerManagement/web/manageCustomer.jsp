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
        <h1>MANAGE CUSTOMER</h1>
        <form action="AdminController" method="post">
            <input type="submit" value="Show all customer" name="action">       
        </form>

        <c:if test="${not empty requestScope.list}">
            <table style="border-collapse: collapse; border: 2px solid black">
                <thead>
                    <tr>
                        <th style="border: 2px solid black">ID</th>
                        <th style="border: 2px solid black">Email</th>
                        <th style="border: 2px solid black">Name</th>
                        <th style="border: 2px solid black">Address</th>
                        <th style="border: 2px solid black">Phone</th>
                        <th style="border: 2px solid black">Blocked</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="l" items="${requestScope.list}">
                        <tr>
                            <td style="border: 1px solid black">${l.cusID}</td>
                            <td style="border: 1px solid black">${l.email}</td>
                            <td style="border: 1px solid black">${l.name}</td>
                            <td style="border: 1px solid black">${l.address}</td>
                            <td style="border: 1px solid black">${l.phone}</td>
                            <td style="border: 1px solid black" >${l.cusStatus}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

        <form action="AdminController" method="post">
            <input type="text" name="name_email" placeholder="Input name/email">
            <input type="submit" value="Find customer" name="action">       
        </form>   
        ${requestScope.FAIL}       

        <c:if test="${not empty requestScope.CustomerByNameEmail}">
            <c:set var="c" value="${requestScope.CustomerByNameEmail}"></c:set>
                <p>
                    <b>ID:</b> ${c.cusID} | <b>Email:</b> ${c.email} | <b>Name:</b> ${c.name} | <b>Address:</b> ${c.address} | <b>Phone:</b> ${c.phone} | <b>Blocked:</b> ${c.cusStatus}
            </p>

        </c:if>
        <c:if test="${c.cusStatus eq false }">
            <form action="AdminController" method="post">
                <input type="hidden" name="cusID" value="${c.cusID}">
                <input type="hidden" name="cusStatus" value="${c.cusStatus}">
                <input type="submit" value="Block"  name="action">
            </form>
        </c:if>
        <c:if test="${c.cusStatus eq true }">
            <form action="AdminController" method="post">
                <input type="hidden" name="cusID" value="${c.cusID}">
                <input type="hidden" name="cusStatus" value="${c.cusStatus}">
                <input type="submit" value="Unblock" name="action">
            </form>
        </c:if>


        <form action="AdminController" method="post">
            <input type="submit" value="Admin page" name="action">       
        </form>    
    </body>
</html>
