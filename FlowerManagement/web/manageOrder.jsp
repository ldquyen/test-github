
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="a" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MANAGE ORDER</h1>
        <form action="AdminController" method="post">
            <input type="submit" value="VIEW ORDER" name="action">           
        </form>
        <a:if test="${ not empty sessionScope.ORDERLIST}">
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
                    <a:forEach var="o" items="${sessionScope.ORDERLIST}">
                        <tr>
                            <td style="border: 1px solid black;"> ${o.orderID}</td>
                            <td style="border: 1px solid black;"> ${o.orderDate}</td>
                            <td style="border: 1px solid black;"> ${o.orderStatus}</td>
                            <td style="border: 1px solid black;"> ${o.shipperID}</td>
                            <td style="border: 1px solid black;"> ${o.cusID}</td>
                        </tr>
                    </a:forEach>
                </tbody>
            </table>
        </a:if>

        <form action="AdminController" method="post">
            <input type="text" name="cusid" placeholder="INPUT CUSTOMER ID">
            <input type="submit" value="SEARCH BY CUSTOMER" name="action">           
        </form>
        ${requestScope.NULLCUSID}

        <a:if test="${ not empty sessionScope.listbyCusID}">
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
                    <a:forEach var="c" items="${sessionScope.listbyCusID}">
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

        <form action="AdminController" method="post">
            <input type="text" name="orderid" placeholder="INPUT ORDER ID">
            <input type="submit" value="SEARCH BY ID" name="action">           
        </form>
        ${requestScope.NULLID}
        <a:if test="${not empty sessionScope.order}">
            <a:set var="o" value="${sessionScope.order}"></a:set>
            <p><b>ORDER ID:</b> ${o.orderID} | <b>DATE:</b> ${o.orderDate} | <b>SHIPPER ID:</b> ${o.shipperID} | <b>STATUS:</b>  
                <a:if test="${o.orderStatus == 1}">CHỜ XÁC NHẬN</a:if> 
                <a:if test="${o.orderStatus == 2}">ĐANG GIAO HÀNG</a:if>
                <a:if test="${o.orderStatus == 3}">HỦY ĐƠN</a:if>
                <a:if test="${o.orderStatus == 4}">GIAO THÀNH CÔNG</a:if> 
                <a:if test="${o.orderStatus == 5}">GIAO THẤT BẠI</a:if> 
                </p>
        </a:if>

        <a:if test="${not empty sessionScope.customer}">
            <a:set var="c" value="${sessionScope.customer}"></a:set>
            <p><b>SEND TO:</b> ${c.name} | <b>EMAIL</b> ${c.email} | <b>ADDRESS</b> ${c.address} | <b>PHONE</b> ${c.phone}</p>
        </a:if>
        <a:if test="${not empty o.orderStatus}">
            <form action="AdminController" method="post">
                <input type="hidden" name="orderid" value="${o.orderID}">
                <select name="status">
                    <option value="1">CHỜ XÁC NHẬN</option>
                    <option value="2">ĐANG GIAO HÀNG</option>
                </select>
                <input type="submit" value="CHANGE STATUS" name="action">
            </form>
        </a:if>
             ${requestScope.ChangeOKE}
        <a:if test="${o.orderStatus == 1}">
            <form action="AdminController" method="post">
                 <input type="hidden" name="orderid" value="${o.orderID}">
                Shipper: <select name="shipperid">         
                     <a:forEach var="s" items="${sessionScope.listShipper}">
                         <option value="${s.accountID}">${s.accountID}</option>
                     </a:forEach>                 
                 </select>
                 <input type="submit" value="ASSIGN" name="action">
            </form>
        </a:if>
             ${requestScope.AssignOKE}
        <form action="AdminController" method="post">
            <input type="submit" value="Admin page" name="action">       
        </form>    

    </body>
</html>
