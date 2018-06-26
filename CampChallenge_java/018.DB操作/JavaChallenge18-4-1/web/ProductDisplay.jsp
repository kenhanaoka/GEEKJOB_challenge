<%-- 
    Document   : ProductDisplay
    Created on : 2018/06/26, 12:22:37
    Author     : Ken Hanaoka
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="org.camp.servlet.UserDTO"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        HttpSession hs = request.getSession();
        ArrayList<UserDTO> list = (ArrayList<UserDTO>)hs.getAttribute("list");
        %>
    </head>
    <body>
        <table border >
            <caption>商品一覧</caption>
                <tr>
                    <th>商品名</th>
                    <th>価格</th>
                    <th>種別</th>
                </tr>
                <% for(UserDTO dto : list) { %>
                <tr>
                    <td><%= dto.getProductName()%></td>
                    <td><%= dto.getProductPrice()%></td>
                    <td><%= dto.getProductType()%></td>
                </tr>
                <% } %>
        </table>
    </body>
</html>
