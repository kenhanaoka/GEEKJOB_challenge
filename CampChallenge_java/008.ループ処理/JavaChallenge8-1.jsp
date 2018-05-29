<%-- 
    Document   : JAvaChallenge8-1
    Created on : 2018/05/26, 16:25:34
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
            //for文により，8の20乗を計算する//
            long total = 1;
            for(int i = 0; i< 20; i++) {
                total *= 8;
            }
            out.println(total);
        %>
    </body>
</html>
