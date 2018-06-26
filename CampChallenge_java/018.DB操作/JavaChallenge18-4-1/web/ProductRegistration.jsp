<%-- 
    Document   : ProductRegistration
    Created on : 2018/06/25, 22:50:04
    Author     : Ken Hanaoka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            HttpSession hs = request.getSession();
            String productName = (String)hs.getAttribute("productName");
            Integer productPrice = (Integer)hs.getAttribute("productPrice");
            String productType = (String)hs.getAttribute("productType");
        %>
    </head>
    <body>
        <form action="./ProductRegistrationResult" method="post" >
            <p>商品名：<input type="text" name="productName" value="<%if(productName != null) {%><%=productName%><%}%>"></p>
            <p>価格：<input type="number" name="productPrice" value="<%if(productPrice != null) {%><%=productPrice%><%}%>"></p>
            <p>種別：<input type="text" name="productType" value="<%if(productName != null) {%><%=productType%><%}%>"></p>
            <p><button type="submit" name="submit" value="registration">登録</button></p>
        </form>
    </body>
</html>
