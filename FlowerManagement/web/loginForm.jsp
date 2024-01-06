
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="background-image: url(img/loginbackground.png); background-size: 100%">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="MainController" method="post" style="margin-left: auto; margin-right: auto;margin-top: 150px; width: 15%;  max-width: 400px; ">
            <h1 style="font-size: 26px">LOGIN FORM</h1>
            <h2>${requestScope.SUCCESS}</h2>
            <p><input type="text" name="txtemail" placeholder="Email" /></p>
            <p><input type="password" name="txtpassword" placeholder="Password"/></p>
            <input style="border: none; color: white;padding: 10px 65px;text-align: center; background-color: black; font-size: 16px;" type="submit" value="Login" name="action"/>
        </form>

        <h1>
            
            ${requestScope.FAIL}
        </h1>
     

    </body>
</html>
