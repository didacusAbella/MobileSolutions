<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="ms" %>
<ms:layout title="Registrazione">
    <jsp:body>
        <form name="signup" action="Signup" method="post" novalidate="true" data-abide>
            <div data-abide-error class="alert callout" style="display: none;">
                <p><i class="fi-alert"></i> Ci sono errori in qualche campo della form.</p>
            </div>
            <div class="grid-container fluid">
                <h2 class="text-center">Registrati subito e diventa nostro cliente</h2>
                <div class="grid-x grid-padding-x">
                    <div class="large-6 medium-6 small-12 cell">
                        <label>Nome
                            <input type="text" name="name" placeholder="Inserisci Nome" required="true"
                                   pattern="[a-zA-Z0-9\s]+" minlength="2" maxlength="40"/>
                            <span class="form-error">Il campo nome deve contenere solo lettere</span>
                        </label>
                        <label>Codice Fiscale
                            <input type="text" name="taxCode" placeholder="Inserisci Codice Fiscale" minlength="2"
                                   maxlength="16" required="true"
                                   pattern="alpha_numeric"/>
                            <span class="form-error">Il campo codice fiscale deve caratteri alfanumerici</span>
                        </label>
                        <label>Indirizzo
                            <input type="text" name="address" placeholder="Indirizzo" pattern="[a-zA-Z0-9\s]+"
                                   required="true" minlength="2" maxlength="40"/>
                            <span class="form-error">Il campo indirizzo deve contenere solo lettere</span>
                        </label>
                        <label>Provincia
                            <select name="province">
                                <option selected>AG</option>
                                <option>AL</option>
                                <option>AN</option>
                                <option>AO</option>
                                <option>AR</option>
                                <option>AP</option>
                                <option>AT</option>
                                <option>AV</option>
                                <option>BA</option>
                                <option>BL</option>
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
                            <input type="text" name="mobilePhone" placeholder="Telefono Cellulare" pattern="integer"
                                   required="true" minlength="2" maxlength="14"/>
                            <span class="form-error">Il campo telefono deve contenere solo numeri</span>
                        </label>
                        <label>Username
                            <input type="text" name="username" placeholder="Username" pattern="alpha_numeric"
                                   required="true" minlength="2" maxlength="16"/>
                            <span class="form-error">Il username deve contenere solo lettere o numeri</span>
                        </label>
                        <label>Città
                            <input type="text" name="city" placeholder="Inserisci città" required="true" pattern="alpha"
                                   required="true" minlength="2" maxlength="100"/>
                            <span class="form-error">Il campo password deve contenere solo lettere</span>
                        </label>
                    </div>
                    <div class="large-6 medium-6 small-12 cell">
                        <label>Cognome
                            <input type="text" name="lastName" placeholder="Inserisci Cognome" pattern="alpha"
                                   required="true"/>
                            <span class="form-error">Il campo cognome deve contenere solo lettere</span>
                        </label>
                        <label>Cap
                            <input type="text" name="cap" placeholder="Inserisci CAP" pattern="integer"
                                   required="true" minlength="4" maxlength="45"/>
                            <span class="form-error">Il campo CAP deve contenere solo numeri</span>
                        </label>
                        <label>Telefono-Casa
                            <input type="text" name="telPhone" placeholder="Inserisci Telefono" pattern="integer"
                                   required="true" minlength="2" maxlength="14"/>
                            <span class="form-error">Il campo telefono deve contenere solo numeri</span>
                        </label>
                        <label>Fax
                            <input type="text" name="fax" placeholder="Inserisci Fax" pattern="integer"
                                   required="true" minlength="2" maxlength="14"/>
                            <span class="form-error">Il campo fax deve contenere solo numeri</span>
                        </label>
                        <label>Password
                            <input type="password" name="password" placeholder="Inserisci Password"
                                   pattern="alpha_numeric" required="true" minlength="2" maxlength="20"/>
                            <span class="form-error">Il campo password deve essere composto da lettere e numeri</span>
                        </label>
                        <label>Email
                            <input name="email" type="text" placeholder="Inserisci Email" pattern="email"
                                   required="true" minlength="4" maxlength="25"/>
                            <span class="form-error">Il campo email non è valido</span>
                        </label>
                    </div>
                    <div class="large-6 medium-6 small-12 cell">
                        <fieldset>
                            <p>Leggi <a href="privacy.jsp">L'INFORMATIVA</a> relativa al trattamento dei tuoi dati
                                personali</p>
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