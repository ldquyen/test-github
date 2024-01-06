<%@page import="dto.Category"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MANAGE FLOWER</h1>
        <form action="AdminController" method="post">
            <input type="text" name="newCategory" placeholder="New Category">
            <input type="submit" value="CREATE" name="action">       
        </form> 
        ${requestScope.OKE} ${requestScope.FAIL}

        <form action="AdminController" method="post">
            <input type="submit" value="VIEW CATEGORY" name="action">       
        </form> 
        <a:if test="${ not empty sessionScope.categoryList}" >
            <table>
                <thead>
                    <tr>
                        <th style="border: 1px solid black">Category ID</th>
                        <th style="border: 1px solid black">Category Name</th>
                    </tr>
                </thead>
                <tbody>
                    <a:forEach var="c" items="${sessionScope.categoryList}">
                        <tr>
                            <td style="border: 1px solid black">${ c.catID }</td>
                            <td style="border: 1px solid black">${ c.catName }</td>
                        </tr>
                    </a:forEach> 
                </tbody>
            </table>

        </a:if>

        <form action="AdminController" method="post">
            New Item 
            <input type="text" name="itemName" placeholder="Item Name">
            <input type="text" name="itemPrice" placeholder="Item Price">
            <input type="text" name="itemStatus" placeholder="Item Status">
            <input type="text" name="itemImg" placeholder="Item Image">
            <select name="catid">
                <a:if test="${ not empty sessionScope.categoryList}" >
                    <a:forEach var="a" items="${sessionScope.categoryList}">
                        <option value="${a.catID}"> ${a.catName}</option>
                    </a:forEach> 
                </a:if>
            </select>
            <input type="submit" value="ADD" name="action">       
        </form>

        ${requestScope.AddOKE} ${requestScope.AddFAIL} 

        <form action="AdminController" method="post">
            <input type="submit" value="VIEW ITEM" name="action">       
        </form>   

        <a:if test="${ not empty sessionScope.itemList}" >
            <table style="border-collapse: collapse; border: 2px solid black;">
                <thead>
                    <tr>
                        <th style="border: 2px solid black;">Item ID</th>
                        <th style="border: 2px solid black;">Item Name</th>
                        <th style="border: 2px solid black;">Price</th>
                        <th style="border: 2px solid black;">Item Status</th>
                        <th style="border: 2px solid black;">Item Image</th>
                        <th style="border: 2px solid black;">Category ID</th>
                    </tr>
                </thead>
                <tbody>
                    <a:forEach var="i" items="${sessionScope.itemList}">
                        <tr>
                            <td style="border: 1px solid black;">${i.itemID}</td>
                            <td style="border: 1px solid black;">${i.itemName}</td>
                            <td style="border: 1px solid black;">${i.price}</td>
                            <td style="border: 1px solid black;">${i.itemStatus}</td>
                            <td style="border: 1px solid black;">${i.fileIMG}</td>
                            <td style="border: 1px solid black;">${i.catID}</td>
                        </tr>
                    </a:forEach> 
                </tbody>
            </table>
        </a:if>

        <form action="AdminController" method="post">
            Search flower: <input type="text" name="itemName" placeholder="Enter name">
            <input type="submit" value="SEARCH" name="action">
        </form>

        <a:if test="${not empty requestScope.ITEM}">
            <a:set var="x" value="${requestScope.ITEM}"></a:set>
            <p>Item: ${x.itemID} | Name: ${x.itemName} | Price: ${x.price} | Status: ${x.itemStatus} | Image: ${x.fileIMG} | Category ID: ${x.catID} </p>            
        </a:if>
        <a:if test="${not empty requestScope.ITEM}">
            <form action="AdminController" method="post">
                <b>INFORMATION:</b> 
                <input type="text" name="itemName" placeholder="Item Name" value="${x.itemName}">
                <input type="text" name="itemPrice" placeholder="Item Price" value="${x.price}">
                <input type="text" name="itemStatus" placeholder="Item Status" value="${x.itemStatus}">
                <input type="text" name="itemIMG" placeholder="Item Image" value="${x.fileIMG}">
                <input type="hidden" name="itemID" value="${x.itemID}">
                <input type="hidden" name="catID" value="${x.catID}">
                <input type="submit" value="CHANGE" name="action">
            </form>
        </a:if>
            ${requestScope.ChangeOKE}

        <form action="AdminController" method="post">
            <input type="submit" value="Admin page" name="action">       
        </form>    
    </body>
</html>
