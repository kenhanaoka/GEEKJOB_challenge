<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataDTO" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Date" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultData");
    Calendar cal = Calendar.getInstance();
    cal.setTime(udd.getBirthday());
    int birthYear = cal.get(Calendar.YEAR);
    int birthMonth = cal.get(Calendar.MONTH-1);
    int birthDay = cal.get(Calendar.DAY_OF_MONTH);
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
        <%--更新前のデータを初期値とする--%>
    <form action="UpdateResult" method="POST">
        名前:
        <input type="text" name="name" value="<%=udd.getName()%>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="<%=birthYear%>"><%=birthYear%></option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" ><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="<%=birthMonth%>"><%=birthMonth%></option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" ><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="<%=birthDay%>"><%=birthDay%></option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"<%if(i == udd.getType()){%><%="checked = \"checked\""%><% } %>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=udd.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udd.getComment()%></textarea><br><br>
       
        <input type="submit" name="btnSubmit" value="確認画面へ">
        
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
