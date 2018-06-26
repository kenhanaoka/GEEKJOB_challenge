<%-- 
    Document   : ProductRegistrationResult
    Created on : 2018/06/25, 23:33:46
    Author     : Ken Hanaoka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            HttpSession hs = request.getSession();
            String chk = (String)hs.getAttribute("chk");
        %>
    </head>
    <%--未入力がなければ商品登録完了，未入力があればその項目を示し，商品登録画面に戻す--%>
    <body>
        <%if(chk == null) { %>
        <h1>登録完了</h1>
        <a href=ProductRegistration.jsp>商品登録</a>
        <a href=ProductDispray.jsp>商品一覧</a>
        <%
            hs.removeAttribute("productName");
            hs.removeAttribute("productPrice");
            hs.removeAttribute("productType");
        %>
        <% }
        else { %>
        <h1>未入力項目を確認</h1>
        <p><%=chk%></p>
        <a href=ProductRegistration.jsp>商品登録</a>
        <% } %>
    </body>
</html>
