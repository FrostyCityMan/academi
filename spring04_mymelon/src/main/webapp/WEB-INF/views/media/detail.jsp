<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-03
  Time: 오후 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="kr">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" as="style"
          href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.5/dist/web/static/pretendard-dynamic-subset.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Read</title>
</head>
<body>
<div class="container">음원 목록</div>
<div class="container">
    <button type="button" class="btn btn-light"
            onclick="location.href='create.do?mediagroupno=${requestScope.mediagroupno}'">음원 등록
    </button>
    <button type="button" class="btn btn-light" onclick="location.href='/home.do'">HOME</button>
</div>
<div class="container">
    <table class="table table-grid">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>등록일</th>
            <th>음원파일명</th>
            <th>수정/삭제</th>
        </tr>
        <for:each var="mediaDTO" items="${detail}">
            <tr>
                <td>${mediaDTO.mediano}</td>
                <td>${mediaDTO.title}</td>
                <td>${mediaDTO.rdate}</td>
                <td>
                        ${mediaDTO.filename} <br>
                        ${mediaDTO.filesize} <br>
                    <c:set var="filesize" value="${fn:substringBefore(mediaDTO.filesize/1024,'.' )}"></c:set>
                        ${filesize}
                </td>
                <td>
                    <input type="button" value="수정">
                    <input type="button" value="삭제">
                </td>
            </tr>
        </for:each>
    </table>
</div>
</body>
</html>
