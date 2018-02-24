<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:choose>
  <c:when test="${phones.size() == 0}">
    <h1>Non Ci sono Telefoni nel magazzino</h1>
  </c:when>
  <c:otherwise>
    <div class="grid-container fluid">
      <h2>Lista Modelli</h2>
      <a href="/MobileSolutions/addSmartphone" class="button"><i class="fi-plus"></i> Aggiungi Telefono</a>
      <div class="grid-x">
        <div class="cell">
          <table class="stack">
            <thead>
              <tr>
                <th>Modello</th>
                <th>Modifica <i class="fi-pencil"></i></th>
                <th>Elimina <i class="fi-trash"></i></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${phones}" var="phone">
                <tr>
                  <td>${phone.model}</td>
                  <td><a class="button" href="/MobileSolutions/EditPhone?id=${phone.id}">Modifica</a></td>
                  <td>
                    <form name="deletePhone" action="RemoveSmartphone">
                      <input type="hidden" value="${phone.id}" name="id"/>
                      <input type="submit" class="button" value="Elimina"/>
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