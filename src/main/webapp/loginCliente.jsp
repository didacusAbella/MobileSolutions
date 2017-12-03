<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Login">
  <jsp:body>
    <div class="grid-container">
      <div class="grid-x align-center">
        <div class="large-8 medium-8 small-12 cell">
          <form name="login_cliente" method="post" action="login_cliente">
            <fieldset class="fieldset">
              <legend>Login to MobileSolutions</legend>
            <label> Username
              <input type="text" placeholder="Inserisci Username"/>
            </label>
            <label>Password
              <input type="password" placeholder="Inserisci Password"/> 
            </label>
              <input type="submit" value="Login" class="button"/>
              <input type="reset" value="Reset" class="button"/>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </jsp:body>
</ms:layout>