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
    <ul class="dropdown menu" data-dropdown-menu>
      <li class="menu-text">Mobile Solutions</li>
      <li><a href="loginCliente.jsp">Login</a></li>
      <li><a href="registrazione.jsp">Crea Account</a></li>
      <li><a href="ricercaAvanzata.jsp">Ricerca Avanzata</a></li>
    </ul>
  </div>
   <div class="top-bar-right">
     <form name="ricerca" action="ricerca" method="get">
       <ul class="menu">
        <li><input type="search" placeholder="Cerca"></li>
        <li><button type="button" class="button">Cerca</button></li>
      </ul>
     </form>
  </div>
</nav>

