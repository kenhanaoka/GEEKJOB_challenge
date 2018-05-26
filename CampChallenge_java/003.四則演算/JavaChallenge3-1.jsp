<%-- 
    Document   : JavaChallenge3-1
    Created on : 2018/05/26, 10:26:51
    Author     : Ken Hanaoka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int x = 12;
            final int a = 10;
            int plus = x + a;
            int minus = x- a;
            int multiplication = x * a;
            double division = (double)x / a;
            int reminder = x % a;
            out.println(plus);
            out.println(minus);
            out.println(multiplication);
            out.println(division);
            out.println(reminder);
            
        %>
           
    </body>
</html>
