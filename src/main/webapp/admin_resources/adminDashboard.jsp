<%-- 
    Document   : adminDashboard
    Created on : 6-dic-2017, 17.23.37
    Author     : diego
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Admin Dashboard">
  <jsp:body>
    <div class="off-canvas-wrapper">
      <div class="off-canvas position-left" id="offcanvas" data-off-canvas>
        <ul class="vertical menu">
          <li><a href="/MobileSolutions/ShowClients"><i class="fi-torsos"></i> Visualizza Clienti</a></li>
          <li><a href="/MobileSolutions/AdminDashboard?page=remainingPhones.jsp" class="fi-archive"> Esaurimento Cellulari</a></li>
          <li><a href="/MobileSolutions/AdminDashboard?page=importXml.jsp"><i class="fi-page-add"></i> Importa XML esterno</a></li>
          <li><a href="/MobileSolutions/AllPhones"><i class="fi-mobile"></i> Gestione Smartphone</a></li>
          <li>
            <form action="LogoutAdmin" method="get">
              <input type="submit" class="button" value="LOGOUT"/>
            </form>
          </li>
        </ul>
      </div>
      <div class="off-canvas-content" data-off-canvas-content>
        <button type="button" class="button" data-toggle="offcanvas"><i class="fi-list"></i> Opzioni Avanzate</button>
        <jsp:include page="${partial}"/>
      </div>
  </jsp:body>
</ms:layout>