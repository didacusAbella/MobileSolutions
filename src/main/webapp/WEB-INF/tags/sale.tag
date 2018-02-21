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


<tr>
    <td>${sale.productName}</td>
    <td>${sale.date}</td>
    <td>${sale.quantity}</td>
    <td>${sale.price}</td>
</tr>