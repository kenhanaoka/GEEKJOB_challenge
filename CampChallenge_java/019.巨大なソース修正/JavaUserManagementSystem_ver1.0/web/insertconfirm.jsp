<%@page import="jums.DataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    DataBeans db = new DataBeans();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% if(!hs.getAttribute("name").equals("") && !hs.getAttribute("year").equals("") && !hs.getAttribute("month").equals("") && !hs.getAttribute("day").equals("") && !hs.getAttribute("type").equals("") && !hs.getAttribute("tell").equals("") && !hs.getAttribute("comment").equals("") ){ %>
        <h1>登録確認</h1>
        名前:<%= hs.getAttribute("name")%><br>
        生年月日:<%= hs.getAttribute("year")+"年"+hs.getAttribute("month")+"月"+hs.getAttribute("day")+"日"%><br>
        種別:<%= hs.getAttribute("type")%><br>
        電話番号:<%= hs.getAttribute("tell")%><br>
        自己紹介:<%= hs.getAttribute("comment")%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <%--課題2:直リンク防止用非表示データ送信--%>
            <input type="hidden" name="ac" value=<%= hs.getAttribute("ac")%>>
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <h1>入力が不完全です</h1>
        <% if (hs.getAttribute("name").equals("")) {%>
            <%= "名前" %>
        <% } %>
        <% if (hs.getAttribute("year").equals("")) {%>
            <%= "年" %>
        <% } %>
        <% if (hs.getAttribute("month").equals("")) {%>
            <%= "月" %>
        <% } %>
        <% if (hs.getAttribute("day").equals("")) {%>
            <%= "日" %>
        <% } %>
        <% if (hs.getAttribute("tell").equals("")) {%>
            <%= "電話番号" %>
        <% } %>
        <% if (hs.getAttribute("comment").equals("")) {%>
            <%= "自己紹介" %>
        <% } %>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <%--課題1:トップへのリンク--%>
        <footer>
            <%out.print(jums.JumsHelper.getInstance().home());%>
        </footer>
    </body>
</html>
