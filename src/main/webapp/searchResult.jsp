<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<ms:layout title="Risultati Ricerca">
  <jsp:body>
    <div class="grid-container" style="margin-top: 10px;">
      <c:choose>
        <c:when test="${phones.size() == 0}">
          <h2>La ricerca non ha prodotto risultati</h2>
        </c:when>
        <c:otherwise>
          <div class="grid-x grid-padding-x small-up-1 medium-up-3 large-up-4">
            <c:forEach items="${phones}" var="phone">
              <div class="cell">
                <ms:phoneComponent phone="${phone}"/>
              </div>
            </c:forEach>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </jsp:body>
</ms:layout>
