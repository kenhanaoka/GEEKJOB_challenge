<%-- 
    Document   : FortuneTellingResult
    Created on : 2018/05/28, 13:47:35
    Author     : Ken Hanaoka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "org.camp.servlet.ResultData"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            ResultData data = (ResultData)request.getAttribute("DATA");
        %>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //日付と占い結果を表示する//
            if (data != null) {
                out.print("<h1>あなたの" + data.getD() + "の運勢は" + data.getLuck() + "です!<h1>");
            }
        %>
    </body>
</html>
