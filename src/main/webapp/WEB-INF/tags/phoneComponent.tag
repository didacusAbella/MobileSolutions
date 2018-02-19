<%-- 
    Document   : phoneComponent
    Created on : 18-feb-2018, 17.05.54
    Author     : diego
--%>

<%@tag description="Component for phone object" pageEncoding="UTF-8"%>
<%@attribute name="phone" description="phone object" required="true" rtexprvalue="true" type="com.didacusabella.mobilesolutions.entities.Smartphone"%>

<div class="card">
  <div class="card-divider">
    <h4>${phone.brand}</h4>
  </div>
  <img alt="phone image" src="./img/smartphone.png"/>
  <div class="card-section">
    <h5>${phone.model}</h5>
    <p>Prezzo: ${phone.price}</p>
    <p><a href="/MobileSolutions/phoneDetails?id=${phone.id}">Visualizza Dettagli</a></p>
  </div>
</div>