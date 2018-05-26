<%-- 
    Document   : JavaChallenge5-3
    Created on : 2018/05/26, 11:44:17
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
            char character = 'a';
            switch(character) {
                case 'A':
                    out.println("英語");
                    break;
                case 'あ':
                    out.println("日本語");
                    break;
            }
        %>
    </body>
</html>
