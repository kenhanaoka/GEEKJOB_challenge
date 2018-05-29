<%-- 
    Document   : JavaChallenge7-1
    Created on : 2018/05/26, 16:14:50
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
        <%@page import = "java.util.HashMap"  %>
        <%
            //配列のキーを指定し，要素を格納する（連想配列を作成する）//
            HashMap<String,String> detas = new HashMap<String,String>();
            detas.put("1", "AAA");
            detas.put("hello", "world");
            detas.put("soeda","33");
            detas.put("20", "20");
        %>
    </body>
</html>
