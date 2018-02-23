<%--
  Created by IntelliJ IDEA.
  User: dtrop
  Date: 21/02/2018
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ms:layout title="I tuoi acquisti">
  <jsp:body>
    <c:choose>
      <c:when test="${listOfSales.size() == 0}">
        <h3>Non hai ancora acquistato nessun prodotto.</h3>
      </c:when>
      <c:otherwise>
        <div class="grid-container fluid" style="margin-top: 20px;">
          <h2>Ecco la lista dei tuoi acquisti ${user.name}:</h2>
          <div class="grid-x">
            <div class="cell">
              <ul class="accordion" data-accordion data-allow-all-closed="true" data-multi-expand="true">
                <c:forEach items="${listOfSales}" var="sale">
                  <ms:sale sale="${sale}"/>
                </c:forEach>
              </ul>
            </div>
          </div>
        </c:otherwise>
      </c:choose>
    </jsp:body>
  </ms:layout>

