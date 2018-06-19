<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    String name = (String)hs.getAttribute("name");
    String tell = (String)hs.getAttribute("tell");
    String comment = (String)hs.getAttribute("comment");
    Integer year = (Integer)hs.getAttribute("year");
    Integer month = (Integer)hs.getAttribute("month");
    Integer day = (Integer)hs.getAttribute("day");
    Integer type = (Integer)hs.getAttribute("type");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <!--課題5：再入力時のフォーム初期値設定-->
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<% if(name != null) { %><%=name%><% } %>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="<% if(year != null) { %><%=year%><% } else { %>1950<% } %>">
                <% if(year != null) { %>
                <%=year%>
                <% } else { %>
                1950
                <% } %>
            </option>
            <%
            for(int i=1951; i<=2010; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="<% if(month != null) { %><%=month%><% } else { %>1<% } %>">
                <% if(month != null) { %>
                <%=month%>
                <% } else { %>
                1
                <% } %>
            </option>
            <%
            for(int i = 2; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="<% if(day != null) { %><%=day%><% } else { %>1<% } %>"> 
                <% if(day != null) { %>
                <%=day%>
                <% } else { %>
                1
                <% } %>
            </option>
            <%
            for(int i = 2; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <% if(type != null) {
            if( type == 1) { %>
                <%="checked"%>
            <% } %>
        <% } 
         else { %>
            <%="checked"%>
        <% } %>>エンジニア<br>
        <input type="radio" name="type" value="2" <% if(type != null) {
            if( type == 2) { %>
                <%="checked"%>
            <% } %>
        <% } %>>営業<br>
        <input type="radio" name="type" value="3" <% if(type != null) {
            if( type == 3) { %>
                <%="checked"%>
            <% } %>
        <% } %>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<% if(tell != null) {%><%=tell%><% } %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><% if(comment != null) {%><%=comment%><% } %></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%--課題1:トップへのリンク--%>
        <footer>
            <%out.print(jums.JumsHelper.getInstance().home());%>
        </footer>
    </body>
</html>
