<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-09
  Time: 오후 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
    <meta charset="UTF-8">
    <title>bookTest</title>
</head>
<body>
<h3>교재선택</h3>
<select name="book" id="book">
    <option>--선택 --</option>
    <option value="0">spring</option>
    <option value="1">Android</option>
    <option value="2">jQuery</option>
    <option value="3">javaScript</option>
</select>
<br>
<div id="display"></div>
<script>
    $("#book").change(function () {
        $.post("booksend.do", "book=" + $(this).val(), responseProc);
    });//end of change


    function responseProc(data) {
        $("#display").html("<img src='../images/" + data + "'>");
    }//end of function response

</script>
</body>
</html>
