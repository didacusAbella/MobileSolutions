<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ms" tagdir="/WEB-INF/tags/"%>

<c:choose>
  <c:when test="${clients.size() == 0}">
    <h1>Non sono registrati clienti in questo Sistema</h1>
  </c:when>
  <c:otherwise>
    <div class="grid-container fluid">
      <p><h1>Utenti</h1> lista degli utenti registrati</p>
    <div class="grid-x">
      <table class="stack hover">
        <thead>
          <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Username</th>
            <th>Email</th>
            <th>Azioni</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${clients}" var="cl">
            <ms:clientComponent client="${cl}"/>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div> 
</c:otherwise>
</c:choose>