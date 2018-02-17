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
          <h1>Unauthorized</h1>
          <br>
          <h3>La pagina che hai richiesto non può essere autorizzata</h3>
          <h3>Forse sei qui perchè:</h3>
          <br>
          <h3>Controlla che le credenziali che hai fornito</h3>
          <h3>Controlla se l'indirizzo contiene errori</h3>
          <a href="index.jsp" class="button">HOME</a>
        </div>
      </div>
    </div>
  </jsp:body>
</ms:layout>
