<%-- 
    Document   : LoginResult
    Created on : 2018/06/17, 23:01:04
    Author     : Ken Hanaoka
--%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            HttpSession hs = request.getSession();
            boolean dicision = (Boolean)hs.getAttribute("decision");
            String submit = (String)hs.getAttribute("submit");
        %>
    </head>
    <body>
        <%--trueなら商品情報ページ，商品登録ページへ，falseならログイン画面に遷移--%>
        <% if(dicision)  { %>
            <h1>ログインしました</h1>
            <p><a href="ProductRegistration.jsp">商品登録</a></p>
            <p><a href="./ProductDisplay">商品一覧</a></p>
        <% }
        else { %>
            <h1>ログインできませんでした</h1>
            <a href="Login.jsp">ログインページ</a>
        <% } %>
    </body>
</html>
