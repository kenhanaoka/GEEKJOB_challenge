<%-- 
    Document   : JavaChallenge8-4
    Created on : 2018/05/27, 15:00:08
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
            //while文により，100以下になるまで1000を繰り返し半減させる//
            double x = 1000;
            while (x >= 100) {
                x /= 2;
            }
            out.print(x);
        %>
    </body>
</html>
