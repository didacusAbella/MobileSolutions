<%-- 
    Document   : adminDashboard
    Created on : 6-dic-2017, 17.23.37
    Author     : diego
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Admin Home">
  <jsp:body>
    <div class="off-canvas-wrapper">
      <div class="off-canvas position-left" id="offcanvas" data-off-canvas>
        <ul class="vertical menu">
          <li><a href="/MobileSolutions/dashboard?page=inserimento.jsp">Inserisci Cellulare</a></li>
          <li><a href="/MobileSolutions/dashboard?page=modificaCell.jsp">Modifica Cellulare</a></li>
          <li><a href="/MobileSolutions/dashboard?page=cancellaCell.jsp">Cancella Cellulare</a> </li>
          <li><a href="/MobileSolutions/dashboard?page=clienti.jsp">Visualizza Clienti</a></li>
          <li><a href="/MobileSolutions/dashboard?page=esaurimento.jsp">Esaurimento Cellulari</a></li>
          <li><a href="/MobileSolutions/dashboard?page=importazione.jsp">Importa XML esterno</a></li>
          <li>
            <form action="logout_gestore">
              <input type="submit" class="button" value="LOGOUT"/>
            </form>
          </li>
        </ul>
      </div>
      <div class="off-canvas-content" data-off-canvas-content>
        <button type="button" class="button" data-toggle="offcanvas">Open Menu</button>
        <jsp:include page="${partial}"/>
      </div>
    </div>
  </jsp:body>
</ms:layout>