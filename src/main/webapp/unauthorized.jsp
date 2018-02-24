<%-- 
    Document   : unauthorized
    Created on : 16-feb-2018, 14.17.34
    Author     : diego
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Unauthorized">
  <jsp:body>
    <div class="grid-container">
      <div class="grid-x">
        <div class="cell">
          <h1 class="text-center">Unauthorized</h1>
          <br>
          <h3 class="text-center">La pagina che hai richiesto non può essere autorizzata</h3>
          <h3 class="text-center">Forse sei qui perchè:</h3>
          <br>
          <h3 class="text-center">Controlla che le credenziali che hai fornito</h3>
          <h3 class="text-center">Controlla se l'indirizzo contiene errori</h3>
          <a href="/MobileSolutions/signin.jsp" class="button">HOME</a>
        </div>
      </div>
    </div>
  </jsp:body>
</ms:layout>
