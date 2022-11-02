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
<div class="title">알림</div>
<div class="content">
    <dd>${msg1!=null?img:""} ${msg1}</dd>
    <dd>${msg2!=null?img:""} ${msg2} </dd>
    <dd>${msg3!=null?img:""} ${msg3}</dd>
    <p>
        ${link1} ${link2} ${link3}
    </p>
</div>

</body>
</html>
