<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-02
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>createForm.jsp</title>
    <style>
        * {
            font-family: Arial;
            font-size: 24px;
        }
    </style>
    <link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="title">미디어 그룹 목록</div>
<div class="content">
    <input type="button" value="그룹등록" onclick="location.href='create.do'">
</div>
<c:if test="${requestScope.count==0}">
    <table>
        <tr>
            <td>게시판에 글 없음!</td>
        </tr>
    </table>
</c:if>

<c:if test="${requestScope.count>0}">
    <table>
        <tr>
            <th>그룹번호</th>
            <th>그룹제목</th>
            <th>수정/삭제</th>
        </tr>
            <%--        list()함수의 mav.addobject("list")를 가리킴--%>
        <c:forEach var="dto" items="${list}">
            <tr>
                <td>${dto.mediagroupno}</td>
                <td>${dto.title}</td>
                <td><input type="button" value="수정">
                    <input type="button" value="삭제">
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<%--페이징--%>
<c:if test="${requestScope.count>0}">
    <c:set var="pageCount" value="${totalpage}"></c:set>
    <c:set var="startPage" value="${startPage}"></c:set>
    <c:set var="endPage" value="${endPage}"></c:set>

    <div class="content">
        <c:if test="${endPage>pageCount}">
            <c:set var="endPage" value="${pageCount+1}"></c:set>
        </c:if>
        <c:if test="${startPage>0}">
            <a class="btn btn-default" href="./list.do?pageNum=${startPage}">이전</a>
        </c:if>

        <c:forEach var="i" begin="${startPage+1}" end="${endPage-1}">
            <c:choose>
                <c:when test="${pageNum==i}"><span style="font-weight: bold"></span></c:when>
                <c:when test="${pageNum!=i}"><a class="btn btn-default" href="./list.do?pageNum=${i}"></a></c:when>
            </c:choose>
        </c:forEach>
        <c:if test="${endPage<pageCount}">
            <a class="btn btn-default" href="./list.do?pageNum=${startPage+pagePerBlock+1}">다음</a>
        </c:if>
    </div>
</c:if>
</body>
</html>
