<form name="addSmartphone" action="AddSmartphone" method="post" novalidate="true" data-abide>
    <div data-abide-error class="alert callout" style="display: none;">
        <p><i class="fi-alert"></i>Ci sono errori nella Form. Controlla i campi</p>
    </div>
    <h2>Da questa pagina puoi inserire un nuovo Smartphone</h2>
    <div class="grid-container fluid">
        <div class="grid-x grid-padding-x">
            <div class="large-6 medium-6 small-12 cell">
                <label>Brand
                    <input type="text" name="brand" placeholder="Inserisci Brand"  required="true"
                           pattern="^[a-zA-Z\s]*$"/>
                    <span class="form-error">Il brand deve essere composto da lettere</span>
                </label>
                <label>Modello
                    <input type="text" name="model" placeholder="Inserisci Modello"  required="true"
                           pattern="^[0-9a-zA-Z\s]*$"/>
                    <span class="form-error">Il modello deve essere composto da lettere e numeri</span>
                </label>
                <label>Memoria Interna
                    <input type="text" name="internalStorage" placeholder="Inserisci Memoria" required="true"
                           pattern="integer"/>
                    <span class="form-error">La memoria deve essere composto da numeri</span>
                </label>
                <label>RAM
                    <input type="number" name="ram" placeholder="Inserisci RAM" maxlength="2" required="true"
                           pattern="[0-9]*"/>
                    <span class="form-error">La RAM deve essere composta da numeri</span>
                </label>
                <label>Prezzo
                    <input type="number" name="price" pattern="number" required="true" placeholder="Inserisci Prezzo"/>
                    <span class="form-error">Il prezzo deve essere composto da decimali</span>
                </label>
                <label>Quantità
                    <input type="number" name="quantity" required="true" pattern="integer"/>
                    <span class="form-error">La quantit&agrave; deve essere numeri</span>
                </label>
            </div>
            <div class="large-6 medium-6 small-12 cell">
                <label>Os
                    <input type="text" name="os" placeholder="Inserisci Sistema Operativo" pattern="alpha_numeric"
                           required="true"/>
                    <span class="form-error">Il sistema operativo deve essere composto da lettere e numeri</span>
                </label>
                <label>Fotocamera
                    <input type="text" name="camera" placeholder="Inserisci Fotocamera" pattern="integer"
                           required="true"/>
                    <span class="form-error">La fotocamera deve essere composta da numeri</span>
                </label>
                <label>Schermo
                    <input type="text" name="displayInch" placeholder="Inserisci risoluzione" pattern="[0-9]\.[0-9]"
                           required="true"/>
                    <span class="form-error">La risoluzione deve essere composta da lettere e numeri</span>
                </label>
                <label>CPU
                    <input type="text" name="cpu" id="cpu" pattern="alpha_numeric" required="true"
                           placeholder="Inserisci CPU"/>
                    <span class="form-error">La CPU deve essere composta da lettere e numeri</span>
                </label>
                <fieldset>
                    <input type="checkbox" name="lte" value="false" id="lte"/><label
                        for="lte">LTE</label>
                    <input type="checkbox" name="bluetooth" value="false" id="bluetooth"/><label
                        for="bluetooth">Bluetooth</label>
                    <input type="submit" value="INSERISCI" class="button"/>
                </fieldset>
            </div>
        </div>
    </div>
</form>
