<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<ms:layout title="Benvenuto su Mobile Solutions">
    <jsp:body>
        <div class="grid-x grid-padding-x small-up-1 medium-up-3 large-up-4">
            <c:choose>
                <c:when test="${phones == null}">
                </c:when>
                <c:otherwise>
                    <c:forEach items="${phones}" var="phone">
                        <div class="cell">
                            <ms:phoneComponent phone="${phone}"/>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </jsp:body>
</ms:layout>