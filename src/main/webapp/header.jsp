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
            <li class="menu-text">Mobile Solutions</li>
            <c:choose>
                <c:when test="${user!=null}">
                    <li>
                        <a>Menu</a>
                        <ul class="menu vertical">
                            <li><a href="/MobileSolutions/ShowCart">Visualizza Carrello</a></li>
                            <li><a href="/MobileSolutions/ShowSales">Visualizza Acquisti</a></li>
                            <li><a href="/MobileSolutions/EditProfile">Modifica Profilo</a></li>
                            <li>
                                <form action="">
                                    <input type="submit" value="Logout" class="button">
                                </form>
                            </li>
                        </ul>
                    </li>
                    <li>Benvenuto ${user.name}</li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="signin.jsp">Login</a>
                    <li><a href="signup.jsp">Crea Account</a></li>
                    </li>
                </c:otherwise>
            </c:choose>
            <li><a href="advancedSearch.jsp">Ricerca Avanzata</a></li>
        </ul>
    </div>
    <div class="top-bar-right">
        <form name="search" action="Search" method="get">
            <ul class="menu">
                <li><input type="search" name="brand" placeholder="Cerca per brand"></li>
                <li><input type="submit" class="button" value="Cerca"/></li>
            </ul>
        </form>
    </div>
</nav>

