<%-- 
    Document   : Login.jsp
    Created on : 2018/06/15, 13:16:55
    Author     : Ken Hanaoka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="javax.servlet.http.HttpSession" %>
        <%
            HttpSession hs = request.getSession();
            String name = (String)hs.getAttribute("name");
            String password = (String)hs.getAttribute("password");
            String submit = (String)hs.getAttribute("submit");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <h1>ログインメニュー</h1>
        <form action="./LoginResult" method="post">
            <p>ユーザー名 : <input type="text" name="name" value="<% if(name != null) { %><%=name%><% } %>"></p>
            <p>パスワード : <input type="password" name="password" value="<% if(name != null) { %><%=password%><% } %>"></p>
            <%--ログインボタン表示,ログイン中ならログアウトボタン表示--%>
            <p><button type="submit" name="submit" value="login">ログイン</button></p>
            <% if(submit != null) {
                if (submit.equals("login")) { %>
                    <p><button type="submit" name="submit" value="logout">ログアウト</button></p>
                <% } %>
            <% } %>
        </form>
    </body>
</html>