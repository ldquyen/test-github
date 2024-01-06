
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>WELCOME Shipper ${sessionScope.shipper.accountID}</h1>
        <form action="ShipperController" method="post">
            <input type="hidden" name="id" value="${sessionScope.shipper.accountID}">
            <input type="submit" value="SEARCH" name="action">
        </form>


            <a:if test="${ not empty sessionScope.list}">
            <table style="border-collapse: collapse; border: 2px solid black;">
                <thead>
                    <tr>
                        <th style="border: 2px solid black;">Order ID</th>
                        <th style="border: 2px solid black;">Order Date</th>
                        <th style="border: 2px solid black;">Order Status</th>
                        <th style="border: 2px solid black;">Shipper ID</th>
                        <th style="border: 2px solid black;">Customer ID</th>
                    </tr>
                </thead>
                <tbody>
                    <a:forEach var="c" items="${sessionScope.list}">
                        <tr>
                            <td style="border: 1px solid black;"> ${c.orderID}</td>
                            <td style="border: 1px solid black;"> ${c.orderDate}</td>
                            <td style="border: 1px solid black;"> ${c.orderStatus}</td>
                            <td style="border: 1px solid black;"> ${c.shipperID}</td>
                            <td style="border: 1px solid black;"> ${c.cusID}</td>
                        </tr>
                    </a:forEach>
                </tbody>
            </table>
        </a:if>

            <a:forEach var="l" items="${sessionScope.list}">
            <form action="ShipperController" method="post">
                <select name="id">
                    <option>${l.orderID}</option>
                </select>
                <select name="status">
                    <option value="4">GIAO THÀNH CÔNG</option>
                    <option value="5">GIAO THẤT BẠI</option>
                </select>
                <input type="submit" value="CHANGE" name="action">
            </form>
        </a:forEach>
            <form action="MainController" method="post">
            <input type="submit" value="Logout" name="action">
        </form>
    </body>
</html>
