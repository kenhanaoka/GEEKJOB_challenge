<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フォーム</title>
        <%--セッションの情報を取得する（次回アクセス時に前回の入力情報を表示するため）--%>
        <%
            request.setCharacterEncoding("UTF-8");
            HttpSession hs = request.getSession();
            String name = (String)hs.getAttribute("name");
            String sex = (String)hs.getAttribute("sex");
            String hobby = (String)hs.getAttribute("hobby");
        %>
    </head>
    <body>
        <%--名前，性別，趣味を入力し，サーブレットに送信--%>
        <form action="./InputData" method="post">
            <p>
                名前：<textarea name="name">
                    <%
                        if(name != null) {
                            out.print(name);
                        }
                    %></textarea>
            </p>
            <p>
                男<input type="radio" name="sex" value="man" 
                    <%
                        if(sex != null && sex.equals("man")) {
                            out.print("checked=\"checked\"");
                        }
                    %>>
                女<input type="radio" name="sex" value="woman"
                    <%
                        if(sex != null && sex.equals("woman")) {
                            out.print("checked=\"checked\"");
                        }
                    %>>
            </p>
            <p>
                趣味<textarea name="hobby">
                    <%
                        if(name != null) {
                            out.print(hobby);
                        }
                    %></textarea>
            </p>
            <p>
                <input type="submit" name="btnSubmit" value="登録">
            </p>
        
    </body>
</html>
