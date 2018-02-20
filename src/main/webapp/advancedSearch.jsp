<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Ricerca Avanzata">
  <jsp:body>
    <form name="advancedSearch" action="AdvancedSearch" method="get" novalidate="true" data-abide>
       <div data-abide-error class="alert callout" style="display: none;">
         <p><i class="fi-alert"></i>La compilazione del form ha degli errori</p>
       </div>
      <div class="grid-container">
        <h2 class="text-center">Effettua una ricerca personalizzata</h2>
        <div class="grid-x">
          <div class="large-10 medium-10 small-12 cell">
            <label>Sistema Operativo
              <select name="os">
                <option selected>Android</option>
                <option>Windows Phone</option>
                <option>IOS</option>
              </select>
            </label>
            <label>Display
              <input type="number" name="displayInch" placeholder="Display in pollici" pattern="integer"/>
              <span class="form-error">nel campo display devono esserci solo numeri</span>
            </label>
            <label>Memoria Interna
              <input type="number" name="internalStorage" placeholder="Memoria Interna" pattern="integer"/>
              <span class="form-error">nel campo memoria devono esserci solo numeri</span>
            </label>
            <label>RAM
              <input type="number" name="ram" placeholder="RAM" pattern="integer"/>
              <span class="form-error">nel campo RAM devono esserci solo numeri</span>
            </label>
            <label>Brand
              <input type="text" name="brand" placeholder="Brand" pattern="alpha"/>
              <span class="form-error">nel campo brand devono esserci solo lettere</span>
            </label>
            <fieldset>
              <input type="checkbox" value="false" name="bluetooth" id="bluetooth"/><label for="bluetooth">Bluetooth</label>
              <input type="checkbox" value="false" name="lte" id="lte"/><label for="lte">LTE</label>
            </fieldset>
            <input type="submit" class="button" value="Ricerca"/>
          </div>  
        </div>
      </div>
    </form>
  </jsp:body>
</ms:layout>