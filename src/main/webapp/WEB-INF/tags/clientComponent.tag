<%-- 
    Document   : clientComponent
    Created on : 8-dic-2017, 16.32.04
    Author     : diego
--%>

<%@tag description="Component for package client object" pageEncoding="UTF-8"%>
<%@attribute name="client" description="client object" type="com.didacusabella.mobilesolutions.entities.Client" rtexprvalue="true" required="true"%>

<tr>
  <td>${client.id}</td>
  <td>${client.name}</td>
  <td>${client.lastName}</td>
  <td>${client.username}</td>
  <td>${client.email}</td>
  <td><a href="completaAcquisti?cliente=${client.id}">Visualizza Acquisti</a></td>
</tr>