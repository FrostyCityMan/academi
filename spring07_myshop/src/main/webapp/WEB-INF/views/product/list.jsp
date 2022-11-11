<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-11
  Time: 오후 12:32
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
    <title>list</title>
</head>
<body>
<div class="title">
    <h3>상품목록</h3>
</div>
<div class="container">
    <p>
        <button type="button" onclick="location.href='write'">상품등록</button>
        <button type="button" onclick="location.href='list'">상품전체목록</button>

    </p>
    <form action="search" method="post">
        상품명 : <a href="detail/${row.product_code}">${row.product_name}</a> <input type="text" name="product_name"
                                                                                  value="${product_name}">
        <button> 검색</button>
    </form>

    <hr>
    상품갯수 : ${fn:length(list)}
    <br>
    <table class="table table-grid">
        <tr>
            <c:forEach var="row" items="${list}" varStatus="vs">
            <td>
                <c:choose>
                    <c:when test="${row.FILENAME !='-'}">
                        <img src="/storage/${row.FILENAME}" width="200px">
                    </c:when>
                    <c:otherwise>
                        등록된 사진 없음!! <br>
                    </c:otherwise>
                </c:choose>

                <br>
                상품명 : <a href="detail/${row.PRODUCT_CODE}">${row.PRODUCT_NAME}</a>
                <br>
                상품가격 : <fmt:formatNumber value="${row.PRICE}" pattern="#,###"/>
            </td>
            <c:if test="${vs.count mod 5==0}">
        <tr></tr>
        </c:if>
        </c:forEach>
        </tr>
    </table>
</div>
</body>
</html>
