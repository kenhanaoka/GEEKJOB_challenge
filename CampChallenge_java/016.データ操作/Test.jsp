<%-- 
    Document   : Test.jsp
    Created on : 2018/06/05, 14:39:39
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
        <h1>
            <%
            request.setCharacterEncoding("UTF-8");
            out.println(request.getParameter("txtName"));
            out.println(request.getParameter("sex"));
            out.println(request.getParameter("hoby"));
            %>
        </h1>
    </body>
</html>
