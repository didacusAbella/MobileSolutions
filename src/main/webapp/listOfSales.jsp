<%--
  Created by IntelliJ IDEA.
  User: dtrop
  Date: 21/02/2018
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ms:layout title="listOfSales">
    <jsp:body>
        <div class="grid-x">
        <div class="cell">
            <div class="cell">
                <table class="stack hover">
                    <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Datetime</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listOfSales}" var="sale">
                        <ms:sale sale="${sale}"/>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </jsp:body>
</ms:layout>

