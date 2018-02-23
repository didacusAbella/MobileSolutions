<%--
  Created by IntelliJ IDEA.
  User: dtrop
  Date: 19/02/2018
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Component for package client object" pageEncoding="UTF-8" %>
<%@attribute name="sale" description="sale object" type="com.didacusabella.mobilesolutions.entities.Sale"
             rtexprvalue="true" required="true" %>





<li class="accordion-item" data-accordion-item>
  <a class="accordion-title">${sale.productName}</a>
  <div class="accordion-content" data-tab-content>
    <h5 class="subheader">Dettagli acquisto:</h5>
    
    <p style="font-style: italic;">Data d'acquisto: ${sale.date}</p>
    <p style="font-style: italic;">Quantità acquistate: ${sale.quantity}</p>
    <p style="font-style: italic;">Prezzo singola quantità: ${sale.price}</p>
    <p style="font-style: italic;">Prezzo totale: ${sale.price * sale.quantity}</p>
    <p style="font-style: italic;"><a href="/MobileSolutions/PhoneDetails?id=${sale.product}">Dettagli telefono</a></p>
  </div>
</li>