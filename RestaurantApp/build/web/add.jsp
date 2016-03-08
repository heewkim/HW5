<%-- 
    Document   : add
    Created on : 2016. 3. 7, 오후 9:46:36
    Author     : Kim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD A NEW RESTAURANT</title>
    </head>
    <body>
        <h1>ADD A NEW RESTAURANT</h1>
        <form name="Addform" action="addRestaurant" method="get">
            
            <label>Restaurant's Name:</label>
            <input type="text" name="resName" value="" />
            <br>
            <label>Restaurant's Phone Number:</label>
            <input type="text" name="resPhonenumber" value="" />
            <br>
            <label>Restaurant's Address:</label>
            <input type="text" name="resAddress" value="" />
            <br>
            <label>Restaurant's Signiture Menu:</label>
            <input type="text" name="resSigMenu" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
        </form>
    </body>
</html>
