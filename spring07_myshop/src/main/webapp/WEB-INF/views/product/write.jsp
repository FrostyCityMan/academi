*<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-11
  Time: 오후 12:43
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
    <title>write</title>
</head>
<body>
<div class="title"> 상품 등록</div>
<div class="container">
    <button type="button" class="btn btn-light" onclick="location.href='list'">상품전체목록</button>
    <form action="insert" name="form1" method="post" enctype="multipart/form-data">
        <table class="table table-grid">
            <tr>
                <td>상품명</td>
                <td><input type="text" name="product_name"></td>
            </tr>
            <tr>
                <td>상품가격</td>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <td>상품설명</td>
                <td>
                    <textarea name="description" cols="60" rows="5"></textarea>
                </td>
            </tr>
            <tr>
                <td>상품사진</td>
                <td>
                    <input type="file" name="img">
                </td>
            </tr>
            <tr>
                <td colspan="2" alignh="center">
                    <button class="btn btn-light">상품등록</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
