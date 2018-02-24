<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ms:layout title="Cart">
  <jsp:body>
    <div class="grid-container" style="margin-top: 20px;">
      <h2 class="text-center">Contenuto del tuo carrello</h2>
      <div class="grid-x">
        <div class="cell">
          <c:choose>
            <c:when test="${cart.size() == 0}">
              <h3 class="subheader">Non ci sono prodotti nel tuo carrello</h3>
            </c:when>
            <c:otherwise>
              <table class="stack hover">
                <thead>
                  <tr>
                    <th>Prodotto</th>
                    <th>Quantità</th>
                    <th>Prezzo</th>
                  </tr>
                </thead>
                <tbody>
                  <c:set var="total" scope="page" value="${0}"/>
                  <c:forEach items="${cart}" var="book">
                    <ms:booking booking="${book}"/>
                    <c:set var="total" scope="page" value="${total + (book.price * book.quantity)}"/>
                  </c:forEach>
                </tbody>
                 <tfoot>
                  <tr>
                    <td><a href="/MobileSolutions/PaymentLoader" class="button">Acquista</a></td>
                    <td>Totale: ${total}</td>
                  </tr>
                </tfoot>
              </table>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
  </jsp:body>
</ms:layout>
