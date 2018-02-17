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
      <li>
        <a href="signin.jsp">Account</a>
        <ul class="menu vertical">
          <li><a href="carrello.jsp">Visualizza Carrello</a></li>
          <li><a href="acquisti.jsp">Visualizza Acquisti</a></li>
          <li><a href="modificaCli.jsp">Modifica Profilo</a></li>
          <li><a href="cancellaCli.jsp">Chiudi l'account</a></li>
          <li>
            <form action="logout_cliente">
              <input type="submit" value="Logout" class="button">
          </li>
        </ul>
      </li>
        <li><a href="signup.jsp">Crea Account</a></li>
        <li><a href="advancedSearch.jsp">Ricerca Avanzata</a></li>
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

