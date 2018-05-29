<%-- 
    Document   : JavaChallenge8-2
    Created on : 2018/05/27, 14:22:44
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
            //for文により，Aを30コ連結して表示//
            String name = "A";
            for (int i = 0; i < 30; i++) {
                name += "A";
            }
            out.print(name);
        %>
    </body>
</html>
