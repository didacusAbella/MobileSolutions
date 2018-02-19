<%--
  Created by IntelliJ IDEA.
  User: dtrop
  Date: 19/02/2018
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Component for package client object" pageEncoding="UTF-8" %>
<%@attribute name="booking" description="booking object" type="com.didacusabella.mobilesolutions.entities.Booking"
             rtexprvalue="true" required="true" %>


<tr>
    <td>${booking.productName}</td>
    <td>${booking.quantity}</td>
    <td>${booking.price}</td>
    <td><a href="Vedo dettagli=${booking.productID}">Visualizza Dettagli</a></td>
</tr>