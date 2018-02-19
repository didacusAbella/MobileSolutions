<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="grid-container">
  <div class="grid-x">
    <div class="cell">
      <form action="EditPhone" method="post">
        <label>Quantità:
          <input type="number" value="${phone.quantity}"/>
        </label>
        <label>RAM:
          <input type="number" value="${phone.ram}"/>
        </label>
        <label>Memoria Interna:
          <input type="number" value="${phone.internalStorage}"/>
        </label>
        <label>Fotocamera:
          <input type="number" value="${phone.camera}"/>
        </label>
        <label>Brand:
          <input type="text" value="${phone.brand}"/>
        </label>
        <label>Model:
          <input type="text" value="${phone.model}"/>
        </label>
        <label>CPU:
          <input type="text" value="${phone.cpu}"/>
        </label>
        <label>Schermo:
          <input type="text" value="${phone.displayInch}"/>
        </label>
        <label>OS:
          <input type="text" value="${phone.os}"/>
        </label>
        <label>Price:
          <input type="number" value="${phone.price}"/>
        </label>
        <label>
          <input type="sumbit" value="Applica Modifiche" class="button"/>
        </label>
      </form>
    </div>
  </div>
</div>

