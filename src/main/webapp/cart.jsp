<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ms:layout title="Cart">
    <jsp:body>
        <div class="grid-x">
            <div class="cell">
                <c:forEach items="${cart}" var="book">
                    <div class="cell">
                        <ms:booking booking="${book}"/>
                    </div>
                </c:forEach>
            </div>
        </div>

    </jsp:body>
</ms:layout>
