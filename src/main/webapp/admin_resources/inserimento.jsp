<form name="insertNote" action="addSmartphone" method="get" novalidate="true" data-abide>
    <div data-abide-error class="alert callout" style="display: none;">
        <p><i class="fi-alert"></i> There are some errors in your form.</p>
    </div>
    <h2>Da questa pagina puoi inserire un nuovo Smartphone</h2>
    <div class="grid-container fluid">
        <div class="grid-x grid-padding-x">
            <div class="large-6 medium-6 small-12 cell">
                <label>Brand
                    <input type="text" name="brand" placeholder="Inserisci Brand" required="true" pattern="alpha"/>
                    <span class="form-error">Il brand deve essere composto da lettere</span>
                </label>
                <label>Model
                    <input type="text" name="model" placeholder="Inserisci Dimensioni" required="true"
                           pattern="alpha_numeric"/>
                    <span class="form-error">Il modello deve essere composto da lettere e numeri</span>
                </label>
                <label>Internal Storage
                    <input type="text" name="internalStorage" placeholder="Inserisci Memoria" required="true"
                           pattern="integer"/>
                    <span class="form-error">La memoria deve essere composto da numeri</span>
                </label>
                <label>RAM
                    <input type="text" name="ram" placeholder="Inserisci RAM" required="true" pattern="integer"/>
                    <span class="form-error">La RAM deve essere composta da numeri</span>
                </label>
                <label>Price
                    <input type="text" name="prezzo" pattern="numeric" required="true" placeholder="Inserisci Prezzo"/>
                    <span class="form-error">Il prezzo deve essere composto da decimali</span>
                </label>
                <label>Quantity
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
                <label>Camera
                    <input type="text" name="camera" placeholder="Inserisci Fotocamera" pattern="integer"
                           required="true"/>
                    <span class="form-error">La fotocamera deve essere composta da numeri</span>
                </label>
                <label>Screen Resolution
                    <input type="text" name="risSchermo" placeholder="Inserisci risoluzione" pattern="alpha_numeric"
                           required="true"/>
                    <span class="form-error">La risoluzione deve essere composta da lettere e numeri</span>
                </label>
                <label>CPU
                    <input type="text" name="cpu" id="cpu" pattern="alpha_numeric" required="true"
                           placeholder="Inserisci CPU"/>
                    <span class="form-error">La CPU deve essere composta da lettere e numeri</span>
                </label>
                <input type="checkbox" name="lte" required="true" value="lte" id="lte"/><label for="lte">LTE</label>
                <input type="checkbox" name="bluetooth" required="true" value="bluetooth" id="bluetooth"/><label
                    for="bluetooth">Bluetooth</label>
                <label>
                    <input type="submit" value="INSERISCI" class="button">
                </label>
            </div>
        </div>
    </div>
</form>
