<%-- 
    Document   : detailedPhone
    Created on : 19-feb-2018, 11.23.42
    Author     : diego
--%>
<%@tag description="Detailed info about phone" pageEncoding="UTF-8" %>
<%@attribute name="phone" type="com.didacusabella.mobilesolutions.entities.Smartphone" required="true"
             rtexprvalue="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="grid-container" style="margin-top: 10px;">
    <div class="grid-x">
        <div class="media-object">
            <div class="media-object-section middle">
                <div class="thumbnail">
                    <img src="./img/smartphone.png" alt="phone image">
                </div>
            </div>
            <div class="media-object-section">
                <h4>${phone.brand}</h4>
                <p><strong>Modello: </strong>${phone.model}</p>
                <p><strong>Prezzo: </strong>${phone.price}</p>
                <p><strong>Quantità disponibile: </strong>${phone.quantity}</p>
                <p><strong>Sistema Operativo: </strong>${phone.os}</p>
                <p><strong>RAM: </strong>${phone.ram}</p>
                <p><strong>Fotocamera: </strong>${phone.camera}</p>
                <p><strong>CPU: </strong>${phone.cpu}</p>
                <p><strong>Memoria Interna: </strong>${phone.internalStorage}</p>
                <c:if test="${phone.lte}">
                    <p><strong>LTE: </strong>Presente</p>
                </c:if>
                <c:if test="${phone.bluetooth}">
                    <p><strong>Bluetooth: </strong>Presente</p>
                </c:if>
                <c:if test="${sessionScope.user!=null}">
                    <p><a href="/MobileSolutions/AddToCart?idProduct=${phone.id}">Aggiungi Al Carrello</a></p>
                </c:if>
            </div>
        </div>
    </div>
</div>