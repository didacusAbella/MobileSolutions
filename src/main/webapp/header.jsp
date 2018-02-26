<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Document   : header
    Created on : 22-nov-2017, 15.33.17
    Author     : didacusAbella
--%>
<div class="title-bar" data-responsive-toggle="ms" data-hide-for="medium">
  <button class="menu-icon" type="button" data-toggle="ms"></button>
  <div class="title-bar-title">Menu</div>
</div>
<nav class="top-bar" id="ms">
  <div class="top-bar-left">
    <ul class="vertical medium-horizontal menu" data-responsive-menu="accordion medium-dropdown">
      <c:choose>
        <c:when test="${user != null}">
          <li class="menu-text">Benvenuto ${user.name}</li>
          <li>
            <a><i class="fi-list"></i> Menu</a>
            <ul class="menu vertical">
              <li><a href="/MobileSolutions/Catalog"><i class="fi-home"></i> Home</a></li>
              <li><a href="/MobileSolutions/ShowCart"><i class="fi-shopping-cart"></i> Visualizza Carrello</a></li>
              <li><a href="/MobileSolutions/ShowSales"><i class="fi-shopping-bag"></i> Visualizza Acquisti</a></li>
              <li><a href="/MobileSolutions/EditProfile"><i class="fi-torsos-all"></i> Modifica Profilo</a></li>
              <li>
                <form action="LogoutClient" method="get">
                  <input type="submit" value="Logout" class="button">
                </form>
              </li>
            </ul>
          </li>
        </c:when>
        <c:when test="${admin != null}">
          <li class="menu-text">Benvenuto Amministratore</li>
          <li>
            <a><i class="fi-list"></i> Menu</a>
            <ul class="menu vertical">
              <li><a href="/MobileSolutions/Catalog"><i class="fi-list-thumbnails"></i> Mostra Catalogo</a></li>
               <li><a href="/MobileSolutions/AdminDashboard"><i class="fi-home"></i> Dashboard</a></li>
            </ul>
          </li>
        </c:when>
        <c:otherwise>
          <li class="menu-text">Mobile Solutions</li>
          <li><a href="signin.jsp"><i class="fi-lock"></i> Login</a></li>
          <li><a href="signup.jsp">Crea Account</a></li>
        </c:otherwise>
      </c:choose>
          <li><a href="advancedSearch.jsp"><i class="fi-magnifying-glass"></i> Ricerca Avanzata</a></li>
    </ul>
  </div>
  <div class="top-bar-right">
    <form name="search" action="Search" method="get">
      <ul class="menu">
        <li><input type="search" name="brand" required="true"
                   pattern="^[a-zA-Z\s]*$" maxlength="20" placeholder="Cerca per brand"></li>
        <li><input name="searchButton" type="submit" class="button" value="Cerca"/></li>
      </ul>
    </form>
  </div>
</nav>

