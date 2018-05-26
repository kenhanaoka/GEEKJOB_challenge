<%-- 
    Document   : JavaChallenge5-1
    Created on : 2018/05/26, 11:06:01
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
            if (x == 1) {
                out.println("1です！");
            } else if (x == 2) {
                out.println("プログラミングキャンプ！");
            } else {
                out.println("その他です！");
            }
        %>
    </body>
</html>
