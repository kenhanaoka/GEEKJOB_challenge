<%-- 
    Document   : JavaChallenge6-1
    Created on : 2018/05/26, 15:27:02
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
        <%@page import = "java.util.ArrayList" %>
        <%
            //配列に文字列を格納し，各要素を取得して画面に表示する// 
            ArrayList<String> detas = new ArrayList<String>();
            detas.add("10");
            detas.add("100");
            detas.add("soeda");
            detas.add("hayashi");
            detas.add("-20");
            detas.add("118");
            detas.add("END");
            out.println(detas.get(0));
            out.println(detas.get(1));
            out.println(detas.get(2));
            out.println(detas.get(3));
            out.println(detas.get(4));
            out.println(detas.get(5));
            out.println(detas.get(6));
            
        %>
    </body>
</html>
