<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ms:layout title="Errore">
  <jsp:body>
    <h1 class="text-ceter">C'è stato un errore:</h1>
    <h2 class="subheader">${errorMessage}</h2>
    <p><a href="/MobileSolutions/${redirect}" class="button">TORNA INDIETRO</a></p>
  </jsp:body>
</ms:layout>