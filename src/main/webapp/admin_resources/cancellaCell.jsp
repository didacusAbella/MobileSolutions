<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:choose>
  <c:when test="${phones.size() == 0}">
    <h1>Non Ci sono Telefoni nel magazzino</h1>
  </c:when>
  <c:otherwise>
    <div class="grid-container fluid">
      <h2>Lista Modelli</h2>
      <div class="grid-x">
        <div class="cell">
          <table class="stack">
            <thead>
              <tr>
                <th>Modello</th>
                <th>Elimina</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${phones}" var="phone_model">
                <tr>
                  <td>${phone_model}</td>
                  <td>
                    <form action="cancellaCell">
                      <input type="submit" class="button" value="Elimina ${phone_model}"/>
                    </form>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </c:otherwise>
</c:choose>