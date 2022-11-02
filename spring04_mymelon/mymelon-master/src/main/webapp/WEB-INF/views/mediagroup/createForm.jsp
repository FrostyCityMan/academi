<%--
  Created by IntelliJ IDEA.
  User: Nakhwa
  Date: 2022-11-02
  Time: 오전 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        * {
            font-family: gulim;
            font-size: 24px
        }
    </style>
    <link rel="stylesheet" href="../css/style.css" type="text/css">
    <title>createForm.jsp</title>
</head>
<body>
<div class="title">미디어그룹 등록</div>
<form name='frm' method="post" action="create.do">
    <table class="table">
        <tr>
            <th>미디어 그룹 제목</th>
            <td><input type="text" name="title" size="50" value="2022년 댄스 음악"></td>
        </tr>
    </table>
<%--    end of table--%>
    <div>
        <button>등록</button>
        <input type="button" value="목록" onclick="location.href='list.do'">
    </div>
</form>
<%--end of form--%>
</body>
</html>
