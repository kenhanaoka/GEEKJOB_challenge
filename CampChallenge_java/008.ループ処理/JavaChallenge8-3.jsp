<%-- 
    Document   : JavaChallenge8-3
    Created on : 2018/05/27, 14:26:29
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
            //for文により，0～100の値を足し合わせて表示//
            int total = 0;
            for (int i = 0; i <= 100; i++) {
                total += i;
            }
            out.print(total);
        %>
    </body>
</html>
