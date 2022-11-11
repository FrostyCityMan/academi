<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-11
  Time: 오후 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="../js/jquery-3.6.1.min.js"></script>
    <script src="../js/jquery.cookie.js"></script>
    <meta charset="UTF-8">
    <title>detail</title>
    <script>
        function product_update() {
            document.form1.action = "/product/update";
            document.form1.submit();
        }  //end of function product_update

        //product_delete
        function product_delete() {
            if (confirm("삭제를 진행하겠습니까?")) {
                document.form1.action = "/product/delete";
                document.form1.submit();
            }//end of if
        }//end of function product_delete
    </script>
</head>
<body>
<div class="title">상품 상세보기/ 상품 수정/ 상품 삭제</div>
<div class="container">
    <button class="btn btn-light" onclick="location.href='/product/list'">상품전체목록</button>
    <form name="form1" method="post" enctype="multipart/form-data">
        <table class="table table-grid">
            <tr>
                <td>상품명</td>
                <td><input type="text" name="product_name" value="${product.PRODUCT_NAME}"></td>
            </tr>
            <tr>
                <td>상품가격</td>
                <td><input type="number" name="price" value="${product.PRICE}"></td>
            </tr>
            <tr>
                <td>상품설명</td>
                <td><textarea name="description" cols="60" rows="5">${product.DESCRIPTION}</textarea></td>
            </tr>
            <tr>
                <td>상품사진</td>
                <td>
                    <c:if test="${product.FILENAME!='-'}">
                        <img src="/storage/${product.FILENAME}" width="200px">
                    </c:if>
                    <br>
                    <input type="file" name="img">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="hidden" name="product_code" value="${product.PRODUCT_CODE}">
                    <button type="button" onclick="product_update()">상품수정</button>
                    <button type="button" onclick="product_delete()">상품삭제</button>
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <%--  댓글--%>
</div>
</body>
</html>
