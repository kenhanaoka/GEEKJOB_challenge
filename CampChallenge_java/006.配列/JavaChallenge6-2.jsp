<%-- 
    Document   : JavaChallenge6-2
    Created on : 2018/05/26, 15:40:43
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
        <%@ page import = "java.util.ArrayList" %>
        <%
            //配列に7つの文字列を格納して，3つ目（要素番号2）の要素の中身を変更して画面に表示//
            ArrayList<String> detas = new ArrayList<String>();
            detas.add("10");
            detas.add("100");
            detas.add("soeda");
            detas.add("hayashi");
            detas.add("-20");
            detas.add("118");
            detas.add("END");
            detas.set(2, "33");
            out.println(detas.get(2));
        %>
    </body>
</html>
