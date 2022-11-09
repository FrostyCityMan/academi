<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>idCheck_cookie.jsp</title>
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
</head>
<body>

<!-- 쿠키를 활용하여 아이디 중복확인을 해야만 회원가입이 가능하다. -->

<h3>회원등록폼(cookie)</h3>

<form name="memfrm" method="post" action="./insert.do" onsubmit="return send()">
    <table border="1" width="400px" class="table table-bordered">
        <tr>
            <th>아이디</th>
            <td>
                <input type="text" name="userid" id="userid">
                <input type="button" value="아이디중복확인" id="btn_userid"> <br>
                <span id="panel"></span> <!-- 아이디 중복 관련 메세지 -->
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="passwd"></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="회원가입"></td>
        </tr>
    </table>

</form>

<script>

    //6)해당 페이지가 로딩되었을 때 아이디중복 확인과 관련된 쿠키변수 삭제
    $(function () {
        $.removeCookie("checkID");

    }); //end of function


    // 1) id="btn_userid" 아이디중복 확인 버튼을 클릭했을때
    $("#btn_userid").click(function () {

        // 2) 입력한 id="btn_userid" 값을 변수에 대입화기
        let params = "userid=" + $("#userid").val().trim();


        // 3) pose방식으로 서버에 요청해서 응답받기
        // 형식) $.post("요청명령어", 전달값, 콜백함수, 응답받는 형식)

        // 1. text 응답
        // $.post("idcheckcookieproc.do", params, checkID, "text");

        // 2. JSON 응답
        $.post("idcheckcookieproc.do", params, checkID, "json");

    }); // click() end


    // 4) 콜백함수
    function checkID(result) {

        //1. text 응답
        // alert(result);   // 0 또는 1

        //2. JSON 응답
        alert(result); // [object Object] 또는
        alert(result.count);

        // 5) 서버에서 응답받는 메세지(result)를 본문의 id= panel 에 출력하고
        //     쿠키변수에 저장
        let count = eval(result.count); // 형변환
        if (count == 0) {
            $("#panel").css("color", "blue");
            $("#panel").text("사용 가능한 아이디 입니다");
            $.cookie("checkID", "PASS"); // 아이디중복확인을 했다는 증거
        } else {
            $("#panel").css("color", "red");
            $("#panel").text("중복된 아이디 입니다");
            $("#userid").focus(); // 커서생성
        } // if end
    } // checkID() end

    //7)아이디 중복확인을 해야함 회원가임폼이 서버로 전송
    //Check ID duplication and send to server
    function send() {
        //아이디 입력했는지?
        //비밀번호를 입력했는지?
        //이름은 입력했는지?
        //이메일은 입력했는지?

        //아이디 중복확인을 했는지?
        let checkID = $.cookie("checkID");
        if (checkID == "PASS") {
            return true;
        } else {
            //panel font color green
            $("#panel").css("color", "green");
            $("#panel").text("아이디 중복 확인을 해주세요");
            $("#panel").focus();
            return false;
        }//end of checkID
    }//end of function

</script>
</body>
</html>