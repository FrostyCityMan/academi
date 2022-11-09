<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-09
  Time: 오후 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
    <meta charset="UTF-8">
    <title>idCheck</title>
</head>
<body>
<h3>회원 등록 폼</h3>
<form name="memfrm">
    <table border="1" width="400px">
        <tr>
            <th>아이디</th>
            <td>
                <input type="text" id="userid">
                <input type="button" value="아이디중복확인" id="btn_userid">
                <br>
                <div id="panel" style="display:none"></div>
            </td>
        </tr>
    </table>
</form>
<script>
    //$.post("요청명령어",전달값,callback함수)
    // $("#btn_userid").click(
    //     function () {
    //         $.post(
    //             "idcheckproc.do"                // 요청 명령어
    //             , "userid=" + $("#userid").val()  // 전달값
    //             , responseProc);                 // 콜백함수
    //     });
    // // click() end

    $("#btn_userid").click(
        function () {
            let A = $("#userid").val();
            $.post("idcheckproc.do", "userid=" + A, responseProc);


        })//end of function

    //end of click
    function responseProc(result) {
        $("#panel").empty();
        $("#panel").html(result);
        $("#panel").show();
    }
</script>
</body>
</html>
