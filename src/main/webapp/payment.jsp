<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ms:layout title="Payment">
    <jsp:body>
        <div class="grid-x">
            <div class="payment">
                <form name="buyForm" action="BuyCart" method="post">
                    <div class="cell">
                        <c:forEach items="${shipmentList}" var="shipment">
                            <input name="shipmentType" type="radio" value="${shipment.id}">${shipment.name}<br>
                        </c:forEach>
                        <c:forEach items="${paymentList}" var="payment">
                            <input name="paymentType" type="radio" value="${payment.id}">${payment.name}<br>
                        </c:forEach>
                    </div>
                    <input class="button" type="submit" value="Buy">
                </form>
            </div>
        </div>
    </jsp:body>
</ms:layout>