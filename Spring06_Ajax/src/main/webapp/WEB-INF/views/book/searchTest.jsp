<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-10
  Time: 오전 9:49
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
    <title>searchTest</title>
</head>
<body>
<br>
<div class="container" style="font-family: 'Yoon 윤고딕 540_TT'">
    <h3>교재검색</h3>
    <form name="search" id="search" class="table table-bordered">
        <input type="text" name="keyword" id="keyword">
        <button id="btn">검색</button>
    </form>
    <%--!검색결과 출력--%>
    <div id="panel"></div>
</div>


<script>
    //keyword keyup
    $("#keyword").keyup(function () {
        //if keyword is null then panel hide
        // if ($("#keyword").val() == "") {
        //     $("#panel").hide();
        // }//end of if

        //1) keyword value
        // let keyword = $("#keyword").val();
        // alert(keyword);

        //2)<form id="search"></form>
        //serialize search
        let params = $("#search").serialize();

        // print in panel
        $.post("searchproc.do", params, responseProc);

        function responseProc(data) {
            if (data.length > 0) {
                let result = data.split("|");
                let title = result[1].split(", ");
                let str = "";
                $.each(title, function (index, key) {
                    str += "<a href='#'>" + key + "</a>";
                    str += "<br>"
                });//end of each

                $("#panel").html(str);
                $("#panel").show();
            } else {
                $("#panel").hide();
            }
        }
    });//end of keyword


</script>
</body>
</html>
