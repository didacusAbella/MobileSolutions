<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Modifica Profilo">
  <jsp:body>
    <div class="grid-container">
      <div class="grid-x">
        <h3>Aggiorna il tuo profilo</h3>
        <div class="cell">
          <form name="editProfile" action="EditProfile" method="post">
            <label>Nome:
              <input type="text" value="${client.name}" name="name" required="true"/>
            </label>
            <label>Cognome:
              <input type="text" value="${client.lastName}" name="lastName" required="true"/>
            </label>
            <label>CodiceFiscale:
              <input type="text" value="${client.taxCode}" name="taxCode" required="true"/>
            </label>
            <label>Indirizzo:
              <input type="text" value="${client.address}" name="address" required="true"/>
            </label>
            <label>CAP:
              <input type="text" value="${client.cap}" name="cap" required="true"/>
            </label>
            <label>Città:
              <input type="text" value="${client.city}" name="city" required="true"/>
            </label>
            <label>Telefono Cellulare:
              <input type="text" value="${client.mobilePhone}" name="mobilePhone" required="true"/>
            </label>
            <label>Username:
              <input type="text" value="${client.username}" name="username" required="true" readonly="true"/>
            </label>
            <label>Email:
              <input type="text" value="${client.email}" name="email" required="true"/>
            </label>
            <label>Telefono:
              <input type="text" value="${client.telPhone}" name="telPhone" required="true"/>
            </label>
            <label>Fax:
              <input type="text" value="${client.fax}" name="fax" required="true"/>
            </label>
            <label>Password:
              <input type="password" value="${client.password}" name="password" required="true" readonly="true"/>
            </label>
            <label>Provincia:
              <select name="province">
                <option selected="true">SA</option>
                <option>AV</option>
              </select>
            </label>
            <input type="hidden" name="id" value="${client.id}" readonly="true"/>
            <input type="submit" class="button" value="Aggiorna Profilo"/>
          </form>
          <form method="post" action="DeleteAccount">
            <input type="hidden" name="id" value="${client.id}" readonly="true"/>
            <input type="sumbit" class="button" value="Rimuovi Account"/>
          </form>
        </div>
      </div>
    </div>
  </jsp:body>
</ms:layout>