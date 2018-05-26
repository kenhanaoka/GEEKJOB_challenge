<%-- 
    Document   : JavaChallenge5-2
    Created on : 2018/05/26, 11:44:01
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
            int x = 3;
            switch(x) {
                case 1:
                    out.println("one");
                    break;
                case 2:
                    out.println("two");
                    break;
                default:
                    out.println("想定外");
                    break;
            }
        %>
    </body>
</html>
