<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO ud = (UserDataDTO)hs.getAttribute("updateData");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>更新結果</h1><br>
        名前:<%= ud.getName()%><br>
        生年月日:<%= ud.getBirthday()%><br>
        種別:<%= ud.getType()%><br>
        電話番号:<%= ud.getTell()%><br>
        自己紹介:<%= ud.getComment()%><br>
        以上の内容で更新しました。<br>
        
        <% hs.removeAttribute("updateData");             %>
    </body>
    <%=jh.home()%>
    </body>
</html>
