<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ms:layout title="Payment">
    <jsp:body>
        <div class="grid-x">
            <div class="payment">
                <c:forEach items="${cart}" var="carIterator">
                    <ms:clientComponent client="${cl}"/>
                </c:forEach>
            </div>
        </div>
    </jsp:body>
</ms:layout>