<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JUMSトップ</title>
    <%
        HttpSession hs = request.getSession();
        hs.removeAttribute("name");
        hs.removeAttribute("year");
        hs.removeAttribute("month");
        hs.removeAttribute("day");
        hs.removeAttribute("type");
        hs.removeAttribute("tell");
        hs.removeAttribute("comment");
    %>
</head>
<body>
    <h1>ユーザー情報管理トップ</h1><br>
    <h3>ここでは、ユーザー情報管理システムとしてユーザー情報の登録や検索、
        付随して修正や削除を行うことができます</h3><br>
    <a href="insert">新規登録</a><br>
    <a href="" >検索(修正・削除)</a><br>
    <%--課題1:トップへのリンク--%>
    <footer>
        <%out.print(jums.JumsHelper.getInstance().home());%>
    </footer>
</body>
</html>
