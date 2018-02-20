<%-- 
    Document   : contatti
    Created on : 24-nov-2017, 15.47.55
    Author     : diego
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="ms" %>

<ms:layout title="Contatti">
  <jsp:body>
    <div class="grid-container fluid">
      <div class="grid-x">
        <div class="cell">
          <h2 class="text-center">Contatti</h2>
          <h3 class="text-center">Siamo a disposizione dei nostri clienti nei seguenti orari: Lun-Ven 9-13/14-20</h3>
        </div>
        <div class="cell">
          <table class="unstriped">
            <thead>
              <tr><th>Tipo di Contatto</th><th>Informazioni</th></tr>
            </thead>
            <tbody>
              <tr>
                <td><h4><i class="fi-telephone"></i></h4></td>
                <td><h4>089-100-100</h4></td>
              </tr>
              <tr>
                <td><h4><i class="fi-print"></i></h4></td>
                <td><h4>089-888-888</h4></td>
              </tr>
              <tr>
                <td><h4><i class="fi-social-myspace"></i></h4></td>
                <td><h4>infomobilesinfinity@hotmail.it</h4></td>
              </tr>
              <tr>
                <td><h4><i class="fi-mail"></i></h4></td>
                <td><h4><a href="mailto:info@mobilesinfinity.com">info@mobilesinfinity.com</a></h4></td></tr>
            </tbody>
          </table>
        </div>
      </div>
      <form name="infor" action="informazioni" method="post">
        <div class="cell">
          <fieldset class="fieldset">
            <legend>In alternativa utilizzare il seguente form compilato in tutte le sue parti per informazioni specifiche</legend>
            <label>Nome
              <input type="text" name="nome" placeholder="Inserisci Nome"/>
            </label>
            <label>Cognome
              <input type="text" name="cognome" placeholder="Inserisci Cognome"/>
            </label>
            <label>Email
              <input type="email" name="email" placeholder="Inserisci Email"/>
            </label>
            <label>Oggetto
              <input type="text" name="oggetto" placeholder="Inserisci Oggetto"/>
            </label>
            <label>Specifiche
              <textarea name="specifiche" rows="7"></textarea>
            </label>
            <input type="submit" class="button" value="Invia Email"/>
          </fieldset>
        </div>
      </form>
    </div>
  </jsp:body>
</ms:layout>



