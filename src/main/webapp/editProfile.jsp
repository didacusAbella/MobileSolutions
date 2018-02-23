<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Modifica Profilo">
  <jsp:body>
    <div class="grid-container">
      <div class="grid-x">
        <h3>Aggiorna il tuo profilo</h3>
        <div class="cell">
          <form name="editProfile" action="EditProfile" method="post" novalidate="true" data-abide>
            <div data-abide-error class="alert callout" style="display: none;">
              <p><i class="fi-alert"></i> Ci sono errori in qualche campo della form.</p>
            </div>
            <label>Nome:
              <input type="text" value="${client.name}" name="name" required="true" pattern="[a-zA-Z0-9\s]+" minlength="2" maxlength="40"/>
              <span class="form-error">Il campo nome deve contenere solo lettere</span>
            </label>
            <label>Cognome:
              <input type="text" value="${client.lastName}" name="lastName" required="true" pattern="alpha"/>
              <span class="form-error">Il campo cognome deve contenere solo lettere</span>
            </label>
            <label>CodiceFiscale:
              <input type="text" value="${client.taxCode}" name="taxCode" required="true" minlength="2" maxlength="16" pattern="alpha_numeric"/>
              <span class="form-error">Il campo codice fiscale deve caratteri alfanumerici</span>
            </label>
            <label>Indirizzo:
              <input type="text" value="${client.address}" name="address" required="true" pattern="[a-zA-Z0-9\s]+" minlength="2" maxlength="40"/>
              <span class="form-error">Il campo indirizzo deve contenere solo lettere</span>
            </label>
            <label>CAP:
              <input type="text" value="${client.cap}" name="cap" required="true"  pattern="integer" minlength="4" maxlength="45"/>
              <span class="form-error">Il campo CAP deve contenere solo numeri</span>
            </label>
            <label>Città:
              <input type="text" value="${client.city}" name="city" pattern="alpha" required="true" minlength="2" maxlength="100"/>
              <span class="form-error">Il campo password deve contenere solo lettere</span>
            </label>
            <label>Telefono Cellulare:
              <input type="text" value="${client.mobilePhone}" name="mobilePhone" required="true"  pattern="integer" minlength="2" maxlength="14"/>
              <span class="form-error">Il campo telefono deve contenere solo numeri</span>
            </label>
            <label>Username:
              <input type="text" value="${client.username}" name="username" pattern="alpha_numeric" required="true" minlength="2" maxlength="16"/>
              <span class="form-error">Il username deve contenere solo lettere o numeri</span>
            </label>
            <label>Email:
              <input type="email" value="${client.email}" name="email" required="true"  pattern="email" minlength="4" maxlength="25"/>
              <span class="form-error">Il campo email non è valido</span>
            </label>
            <label>Telefono-Casa:
              <input type="text" value="${client.telPhone}" name="telPhone" pattern="integer" required="true" minlength="2" maxlength="14"/>
              <span class="form-error">Il campo telefono deve contenere solo numeri</span>
            </label>
            <label>Fax:
              <input type="text" value="${client.fax}" name="fax" pattern="integer" required="true" minlength="2" maxlength="14"/>
              <span class="form-error">Il campo fax deve contenere solo numeri</span>
            </label>
            <label>Password:
              <input type="password" value="${client.password}" name="password" required="true" readonly="true" pattern="alpha_numeric" minlength="2" maxlength="20"/>
              <span class="form-error">Il campo password deve essere composto da lettere e numeri</span>
            </label>
            <label>Provincia:
              <select name="province">
                <option value="ag" selected="true">Agrigento</option>
                <option value="al">Alessandria</option>
                <option value="an">Ancona</option>
                <option value="ao">Aosta</option>
                <option value="ar">Arezzo</option>
                <option value="ap">Ascoli Piceno</option>
                <option value="at">Asti</option>
                <option value="av">Avellino</option>
                <option value="ba">Bari</option>
                <option value="bt">Barletta-Andria-Trani</option>
                <option value="bl">Belluno</option>
                <option value="bn">Benevento</option>
                <option value="bg">Bergamo</option>
                <option value="bi">Biella</option>
                <option value="bo">Bologna</option>
                <option value="bz">Bolzano</option>
                <option value="bs">Brescia</option>
                <option value="br">Brindisi</option>
                <option value="ca">Cagliari</option>
                <option value="cl">Caltanissetta</option>
                <option value="cb">Campobasso</option>
                <option value="ci">Carbonia-iglesias</option>
                <option value="ce">Caserta</option>
                <option value="ct">Catania</option>
                <option value="cz">Catanzaro</option>
                <option value="ch">Chieti</option>
                <option value="co">Como</option>
                <option value="cs">Cosenza</option>
                <option value="cr">Cremona</option>
                <option value="kr">Crotone</option>
                <option value="cn">Cuneo</option>
                <option value="en">Enna</option>
                <option value="fm">Fermo</option>
                <option value="fe">Ferrara</option>
                <option value="fi">Firenze</option>
                <option value="fg">Foggia</option>
                <option value="fc">Forl&igrave;-Cesena</option>
                <option value="fr">Frosinone</option>
                <option value="ge">Genova</option>
                <option value="go">Gorizia</option>
                <option value="gr">Grosseto</option>
                <option value="im">Imperia</option>
                <option value="is">Isernia</option>
                <option value="sp">La spezia</option>
                <option value="aq">L'aquila</option>
                <option value="lt">Latina</option>
                <option value="le">Lecce</option>
                <option value="lc">Lecco</option>
                <option value="li">Livorno</option>
                <option value="lo">Lodi</option>
                <option value="lu">Lucca</option>
                <option value="mc">Macerata</option>
                <option value="mn">Mantova</option>
                <option value="ms">Massa-Carrara</option>
                <option value="mt">Matera</option>
                <option value="vs">Medio Campidano</option>
                <option value="me">Messina</option>
                <option value="mi">Milano</option>
                <option value="mo">Modena</option>
                <option value="mb">Monza e della Brianza</option>
                <option value="na">Napoli</option>
                <option value="no">Novara</option>
                <option value="nu">Nuoro</option>
                <option value="og">Ogliastra</option>
                <option value="ot">Olbia-Tempio</option>
                <option value="or">Oristano</option>
                <option value="pd">Padova</option>
                <option value="pa">Palermo</option>
                <option value="pr">Parma</option>
                <option value="pv">Pavia</option>
                <option value="pg">Perugia</option>
                <option value="pu">Pesaro e Urbino</option>
                <option value="pe">Pescara</option>
                <option value="pc">Piacenza</option>
                <option value="pi">Pisa</option>
                <option value="pt">Pistoia</option>
                <option value="pn">Pordenone</option>
                <option value="pz">Potenza</option>
                <option value="po">Prato</option>
                <option value="rg">Ragusa</option>
                <option value="ra">Ravenna</option>
                <option value="rc">Reggio di Calabria</option>
                <option value="re">Reggio nell'Emilia</option>
                <option value="ri">Rieti</option>
                <option value="rn">Rimini</option>
                <option value="rm">Roma</option>
                <option value="ro">Rovigo</option>
                <option value="sa">Salerno</option>
                <option value="ss">Sassari</option>
                <option value="sv">Savona</option>
                <option value="si">Siena</option>
                <option value="sr">Siracusa</option>
                <option value="so">Sondrio</option>
                <option value="ta">Taranto</option>
                <option value="te">Teramo</option>
                <option value="tr">Terni</option>
                <option value="to">Torino</option>
                <option value="tp">Trapani</option>
                <option value="tn">Trento</option>
                <option value="tv">Treviso</option>
                <option value="ts">Trieste</option>
                <option value="ud">Udine</option>
                <option value="va">Varese</option>
                <option value="ve">Venezia</option>
                <option value="vb">Verbano-Cusio-Ossola</option>
                <option value="vc">Vercelli</option>
                <option value="vr">Verona</option>
                <option value="vv">Vibo valentia</option>
                <option value="vi">Vicenza</option>
                <option value="vt">Viterbo</option>
              </select>
            </label>
            <input type="hidden" name="id" value="${client.id}" readonly="true"/>
            <input type="submit" class="button" value="Aggiorna Profilo"/>
          </form>
          <form method="post" action="DeleteAccount">
            <input type="hidden" name="id" value="${client.id}" readonly="true"/>
            <input type="sumbit" class="button" value="Rimuovi Account"/>
          </form>
        </div>
      </div>
    </div>
  </jsp:body>
</ms:layout>