<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-09
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ajaxTest02</title>
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
</head>
<body>
<h3>* $.ajax() 테스트</h3>
<button id="btn">서버에서 응답받기</button>
<div id="pannel"></div>
<script>
    //1)$.ajax() 함수
    // 형식) $.ajax({name:value, name:value, name:value})
    // $("#btn").click(function () {
    //         $.ajax({
    //             type: "GET",        //get방식
    //             url: "message.do", //요청 명령어
    //             dataType: "text", //응답메세지 자료형
    //             error: function (error) {
    //                 alert("error" + error.responseText);
    //             },//end of error
    //             success: function (result) {
    //                 //result in pannel, append
    //                 $("#pannel").append(result + "<br>");
    //                 //
    //             }//end of success
    //
    //         })//end of ajax;
    //     }//end of function
    // ); //end of click

    //2)#.get()방식
    //형식) $.get("요청 명령어", callback함수)
    //AJAX를 get방식으로 요청하는 법.

    //btn get
    $("#btn").click(function () {
        $.get("message.do", responseProc);
    });//end of click

    function responseProc(data) {
        $("#pannel").append(data + "<br>");
    }


</script>

</body>
</html>
