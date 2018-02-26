<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<div class="grid-container">
  <div class="grid-x">
    <div class="cell">
      <form name="EditPhone" action="EditPhone" method="post" novalidate="true" data-abide>
        <div data-abide-error class="alert callout" style="display: none;">
          <p><i class="fi-alert"></i> Ci sono errori nella Form. Controlla i campi</p>
        </div>
        <label>Quantità:
          <input type="number" value="${phone.quantity}" name="quantity" required="true" pattern="integer"/>
          <span class="form-error">La quantit&agrave; deve essere numeri</span>
        </label>
        <label>RAM:
          <input type="number" value="${phone.ram}" required="true" pattern="integer" name="ram"/>
          <span class="form-error">La RAM deve essere composta da numeri</span>
        </label>
        <label>Memoria Interna:
          <input type="number" value="${phone.internalStorage}" required="true" pattern="integer" name="internalStorage"/>
          <span class="form-error">La memoria deve essere composto da numeri</span>
        </label>
        <label>Fotocamera:
          <input type="number" value="${phone.camera}" pattern="integer" required="true" name="camera"/>
          <span class="form-error">La fotocamera deve essere composta da numeri</span>
        </label>
        <label>Brand:
          <input type="text" value="${phone.brand}" required="true" pattern="^[a-zA-Z\s]*$" name="brand"/>
          <span class="form-error">Il brand deve essere composto da lettere</span>
        </label>
        <label>Model:
          <input type="text" value="${phone.model}" required="true" pattern="^[0-9a-zA-Z\s]*$" name="model"/>
          <span class="form-error">Il modello deve essere composto da lettere e numeri</span>
        </label>
        <label>CPU:
          <input type="text" value="${phone.cpu}" name="cpu" pattern="^[\.0-9a-zA-Z\s]*$" required="true"/>
          <span class="form-error">La CPU deve essere composta da lettere e numeri</span>
        </label>
        <label>Schermo:
          <input type="text" value="${phone.displayInch}" name="displayInch" pattern="[0-9]*\.[0-9]*" required="true"/>
          <span class="form-error">La risoluzione deve essere composta da lettere e numeri</span>
        </label>
        <label>OS:
          <input type="text" value="${phone.os}" pattern="^[a-zA-Z\s]*$" required="true" name="os"/>
          <span class="form-error">Il sistema operativo deve essere composto da lettere e numeri</span>
        </label>
        <label>Price:
          <input type="number" value="${phone.price}" pattern="number" required="true" name="price"/>
          <span class="form-error">Il prezzo deve essere composto da decimali</span>
        </label>
        <fieldset>
          <input type="checkbox" name="lte"  id="lte" value="false"/><label for="lte">LTE</label>
          <input type="checkbox" name="bluetooth"  id="bluetooth" value="false"/><label for="bluetooth">Bluetooth</label>
          <input type="submit" value="Applica Modifiche" class="button"/>
          <input type="hidden" value="${phone.id}" name="id" readonly="true"/>
        </fieldset>
      </form>
    </div>
  </div>
</div>

