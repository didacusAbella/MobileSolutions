<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="ms" %>
<ms:layout title="Registrazione">
  <jsp:body>
    <form name="registra" action="registrazione" method="post">
      <div class="grid-container fluid">
        <h2 class="text-center">Registrati subito e diventa nostro cliente</h2>
        <div class="grid-x grid-padding-x">
          <div class="large-6 medium-6 small-12 cell">
            <label>Nome
              <input type="text" name="nome" placeholder="Inserisci Nome"/>
            </label>
            <label>Codice Fiscale
              <input type="text" name="cofiscale" placeholder="Inserisci Codice Fiscale"/>
            </label>
            <label>Indirizzo
              <input type="text" name="indirizzo" placeholder="Indirizzo"/>
            </label>
            <label>Provincia
              <select name="prov">
                <option selected>Agrigento</option>
                <option>Alessandria</option>
                <option>Ancona</option>
                <option>Aosta</option>
                <option>Arezzo</option>
                <option>Ascoli Piceno</option>
                <option>Asti</option>
                <option>Avellino</option>
                <option>Bari</option>
                <option>Belluno</option>
                <option>Benevento</option>
                <option>Bergamo</option>
                <option>Biella</option>
                <option>Bologna</option>
                <option>Bolzano</option>
                <option>Brescia</option>
                <option>Brindisi</option>
                <option>Cagliari</option>
                <option>Caltanisetta</option>
                <option>Campobasso</option>
                <option>Caserta</option>
                <option>Catania</option>
                <option>Catanzaro</option>
                <option>Chieti</option>
                <option>Como</option>
                <option>Cosenza</option>
                <option>Cremona</option>
                <option>Crotone</option>
                <option>Cuneo</option>
                <option>Enna</option>
                <option>Estero</option>
                <option>Ferrara</option>
                <option>Firenze</option>
                <option>Foggia</option>
                <option>Forli</option>
                <option>Forli-Cesena</option>
                <option>Frosinone</option>
                <option>Genova</option>
                <option>Gorizia</option>
                <option>Grosseto</option>
                <option>Imperia</option>
                <option>Isernia</option>
                <option>L'Aquila</option>
                <option>La Spezia</option>
                <option>Latina</option>
                <option>Lecce</option>
                <option>Lecco</option>
                <option>Livorno</option>
                <option>Lodi</option>
                <option>Lucca</option>
                <option>Macerata</option>
                <option>Mantova</option>
                <option>Massa Carrara</option>
                <option>Matera</option>
                <option>Messina</option>
                <option>Milano</option>
                <option>Modena</option>
                <option>Monza e Brianza</option>
                <option>Napoli</option>
                <option>Novara</option>
                <option>Nuoro</option>
                <option>Oristano</option>
                <option>Padova</option>
                <option>Palermo</option>
                <option>Parma</option>
                <option>Pavia</option>
                <option>Perugia</option>
                <option>Pesaro</option>
                <option>Pesaro-Urbino</option>
                <option>Pescara</option>
                <option>Piacenza</option>
                <option>Pisa</option>
                <option>Pistoia</option>
                <option>Pordenone</option>
                <option>Potenza</option>
                <option>Prato</option>
                <option>Ragusa</option>
                <option>Ravenna</option>
                <option>Reggio Calabria</option>
                <option>Reggio Emilia</option>
                <option>Rieti</option>
                <option>Rimini</option>
                <option>Roma</option>
                <option>Rovigo</option>
                <option>Salerno</option>
                <option>Sassari</option>
                <option>Savona</option>
                <option>Siena</option>
                <option>Siracusa</option>
                <option>Sondrio</option>
                <option>Taranto</option>
                <option>Teramo</option>
                <option>Terni</option>
                <option>Torino</option>
                <option>Trapani</option>
                <option>Trento</option>
                <option>Treviso</option>
                <option>Trieste</option>
                <option>Udine</option>
                <option>Varese</option>
                <option>Venezia</option>
                <option>Verbania</option>
                <option>Vercelli</option>
                <option>Verona</option>
                <option>Vibo Valentia</option>
                <option>Vicenza</option>
                <option>Viterbo</option>
              </select>
            </label>
            <label>Telefono-Cellulare
              <input type="text" name="telcel" placeholder="Telefono Cellulare"/>
            </label>
            <label>Username
              <input type="text" name="username" placeholder="Username"/>
            </label>
            <label>Conferma Password
              <input type="password" name="confpassword" placeholder="Conferma password"/>
            </label>
          </div>
          <div class="large-6 medium-6 small-12 cell">
            <label>Cognome
              <input type="text" name="cognome" placeholder="Inserisci Cognome"/>
            </label>
            <label> Indirizzo
              <select name="tipoindirizzo">
                <option selected>Largo</option>
                <option>Piazza</option>
                <option>Porta</option>
                <option>Via</option> 
                <option>Viale</option>
                <option>Vicolo</option>  
              </select>
            </label>
            <label>Cap
              <input type="text" name="cap" placeholder="Inserisci CAP"/>
            </label>
            <label>Telefono-Casa
              <input type="text" name="telcas" placeholder="Inserisci Telefono"/>
            </label>
            <label>Fax
              <input type="text" name="fax" placeholder="Inserisci Fax"/>
            </label>
            <label>Password
              <input type="password" name="password" placeholder="Inserisci Password"/>
            </label>
            <label>Email
              <input type="email" name="email" placeholder="Inserisci password"/>
            </label>
          </div>
          <div class="large-6 medium-6 small-12 cell">
             <fieldset>
              <p>Leggi <a href="privacy.jsp">L'INFORMATIVA</a> relativa al trattamento dei tuoi dati personali</p>
              <input id="clausola1" type="checkbox" name="clausola1"><label for="clausola1">Termini per il servizio</label>
              <input id="clausola2" type="checkbox" name="clausola2"><label for="clausola2">Trattamento dei dati personali</label>
            </fieldset>
          </div>
           <div class="large-6 medium-6 small-12 cell">
              <input type="submit" value="Invio" class="button"/>
           </div>
        </div>
      </div>    
    </form>
  </jsp:body>
</ms:layout>