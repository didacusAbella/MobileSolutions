<%-- 
    Document   : cliente
    Created on : 8-dic-2017, 16.32.04
    Author     : diego
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="client" description="client object" type="com.didacusabella.mobilesolutions.beans.Cliente" rtexprvalue="true" required="true"%>

<div class="media-object">
  <div class="media-object-section">
    <div class="thumbnail">
      <h2><i class="fi-torso"></i></h2>
    </div>
  </div>
  <div class="media-object-section">
    <p><strong>Nome:</strong>${client.nome}</p>
    <p><strong>Cognome:</strong>${client.cognome}</p>
    <p><strong>Username:</strong>${client.username}</p>
    <p><strong>Email:</strong>${client.email}</p>
    <p><strong>Telefono:</strong>${client.telcell}</p>
    <p><a href="completaAcquisti?cliente=${client.username}"> Visualizza gli Acquisti</a></p>
  </div>
</div>