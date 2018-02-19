<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Modifica Profilo">
  <jsp:body>
    <div class="grid-container">
    <div class="grid-x">
      <div class="cell">
        <form name="editProfile" action="" method="post">
          <label>Nome:
            <input type="text" value="${user.name}"/>
          </label>
          <label>Cognome:
            <input type="text" value="${user.lastName}"/>
          </label>
          <label>Indirizzo:
            <input type="text" value="${user.address}"/>
          </label>
          <label>CAP:
            <input type="text" value="${user.cap}"/>
          </label>
          <label>Città:
            <input type="text" value="${user.city}"/>
          </label>
          <label>Telefono Cellulare:
            <input type="text" value="${user.mobilePhone}"/>
          </label>
          <label>Username:
            <input type="text" value="${user.username}"/>
          </label>
          <label>Email:
            <input type="text" value="${user.email}"/>
          </label>
          <label>Telefono:
            <input type="text" value="${user.telPhone}"/>
          </label>
          <label>Password:
            <input type="password" value="${user.password}"/>
          </label>
          <label>
            <input type="submit" class="button" value="Aggiorna Profilo"/>
          </label>
        </form>
      </div>
    </div>
  </div>
  </jsp:body>
</ms:layout>