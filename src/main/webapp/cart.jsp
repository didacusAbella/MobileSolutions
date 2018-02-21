<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ms:layout title="Cart">
    <jsp:body>
        <div class="grid-x">
        <div class="cell">
            <div class="cell">
                <table class="stack hover">
                    <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cart}" var="book">
                        <ms:booking booking="${book}"/>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="cell">
            <a href="/MobileSolutions/PaymentLoader">Acquista</a>
        </div>

    </jsp:body>
</ms:layout>
