<%-- 
    Document   : registerForm
    Created on : Nov 5, 2023, 11:43:55 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body style="background-image: url(img/fptuhcm.jpeg);background-size: cover">
        
        <div  style="margin-left: auto; margin-right: auto;margin-top: 100px; width: 15%;  max-width: 400px; ">
            <h1 style="margin-left: 25px">Đăng Kí</h1>
        <h2>${requestScope.FAIL}</h2>
        <h2>${requestScope.SUCCESS}</h2>
        <form action="MainController" method="post">
            <p><input type="text" name="txtemail" placeholder="Email"/></p>
            <p><input type="password" name="txtpassword" placeholder="Password"/></p>
            <p><input type="text" name="txtname" placeholder="Name"/></p>
            <p><input type="text" name="txtaddress" placeholder="Address"/></p>
            <p><input type="text" name="txtphone" placeholder="Phone"/></p>
            <p><input style="border: none; color: white;padding: 10px 44px;text-align: center; background-color: black; font-size: 16px;" type="submit" name = "action"value="REGISTER"></p>
        </form>
        <form action="MainController" method="post">
            <p><input style="border: none; color: white;padding: 10px 60px;text-align: center; background-color: black; font-size: 16px;" type="submit" name = "action"value="LOGIN"></p>
        </form>
        </div>
    </body>
</html>
