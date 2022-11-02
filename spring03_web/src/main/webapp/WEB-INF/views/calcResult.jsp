<%--
  Created by IntelliJ IDEA.
  User: ITWILL
  Date: 2022-11-01
  Time: 오전 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>co_itwill</title>
</head>
<body>
<h1>계산결과</h1>
<h2>1)JSP</h2>
<%=request.getAttribute("message")%> <br>
숫자1 : <%=request.getAttribute("no1")%> <br>
숫자2 : <%=request.getAttribute("no2")%> <br>
결과 : <%=request.getAttribute("result")%> <br>
<hr>
<h2>2)EL</h2>
${message}<br>
숫자1: ${no1}<br>
숫자2: ${no2}<br>
결과: ${result}<br>
<hr>

</body>
</html>
