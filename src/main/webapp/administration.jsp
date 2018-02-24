<%--
  Created by IntelliJ IDEA.
  User: dtrop
  Date: 19/02/2018
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Mobile Solutions Administration">
  <jsp:body>
    <div class="grid-container">
      <div class="grid-x">
        <div class="cell">
          <h2 class="text-center">Attenzione! Area riservata agli amministratori</h2>
          <form name="LoginAdmin" action="LoginAdmin" method="post" novalidate="true" data-abide>
            <div data-abide-error class="alert callout" style="display: none;">
              <p><i class="fi-alert"></i>Ci sono errori nella form. Controlla i campi.</p>
            </div>
            <fieldset class="fieldset">
              <legend>Accedi</legend>
              <label> Username
                <input name="username" type="text" placeholder="Inserisci Username" pattern="alpha_numeric" required="true"/>
                <span class="form-error">Il campo username deve contenere solo lettere e numeri</span>
              </label>
              <label>Password
                <input name="password" type="password" placeholder="Inserisci Password" pattern="alpha_numeric" required="true"/>
                <span class="form-error">Il campo password deve contenere solo lettere e numeri</span>
              </label>
              <label>
                <input type="submit" value="Login" class="button"/>
              </label>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </jsp:body>
</ms:layout>
