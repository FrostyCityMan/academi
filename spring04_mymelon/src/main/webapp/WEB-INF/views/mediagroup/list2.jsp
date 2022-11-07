<!-- 페이지 리스트 -->
<c:if test="${requestScope.count>0}">
  <c:set var="pageCount" value="${requestScope.totalPage}"/>
  <c:set var="startPage" value="${requestScope.startPage}"/>
  <c:set var="endPage" value="${requestScope.endPage}"/>

  <div class="content">
    <c:if test="${endPage>pageCount}">
      <c:set var="endPage" value="${pageCount+1}"/>
    </c:if>

    <c:if test="${startPage>0}">
      <a href="./list.do?pageNum=${startPage}">[이전]</a>
    </c:if>

    <c:forEach var="i" begin="${startPage+1}" end="${endPage-1}">
      <c:choose>
        <c:when test="${pageNum==i}"><span style="font-weight: bold">${i}</span></c:when>
        <c:when test="${pageNum!=i}"><a href="./list.do?pageNum=${i}">${i}</a></c:when>
      </c:choose>
    </c:forEach>

    <c:if test="${endPage<pageCount}">
      <a href="./list.do?pageNum=${startPage+11}">[다음]</a>
    </c:if>
  </div>
</c:if>

</body>
</html>