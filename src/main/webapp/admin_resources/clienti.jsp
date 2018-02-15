<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ms" tagdir="/WEB-INF/tags/"%>

<c:choose>
  <c:when test="${clients.size() == 0}">
    <h1>Non sono registrati clienti in questo Sistema</h1>
  </c:when>
  <c:otherwise>
    <div class="grid-container fluid">
      <div class="grid-x">
        <c:forEach items="${clients}" var="cl">
          <div class="small-12 medium-3 large-3 cell">
            <ms:cliente client="${cl}"/>
          </div>
        </c:forEach>
      </div>
    </div> 
  </c:otherwise>
</c:choose>