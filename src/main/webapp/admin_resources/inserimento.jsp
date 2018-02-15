<form name="insertNote" action="inserimento" method="get">
  <h2>Da questa pagina puoi inserire un nuovo Cellulare</h2>
  <div class="grid-container fluid">
    <div class="grid-x grid-padding-x">
      <div class="large-6 medium-6 small-12 cell">
        <label>Marca
          <input type="text" name="marca" placeholder="Inserisci Marca"/>
        </label>
        <label>Dimensioni
          <input type="text" name="dimensioni" placeholder="Inserisci Dimensioni"/>
        </label>
        <label>Memoria
          <input type="text" name="memoria" placeholder="Inserisci Memoria"/>
        </label>
        <label>Connettivit&agrave;
          <select name="connettivita">
            <option selected>Bluetooth</option>
            <option>Infrarossi</option>
            <option>Bluetooth-Infrarossi</option>
            <option>USB</option>
          </select>
        </label>
        <label>Prezzo
          <input type="number" name="prezzo"/>
        </label>
        <label>Quantit&agrave;
          <select name="quantita">
            <option selected>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
            <option>11</option>
            <option>12</option>
            <option>13</option>
            <option>14</option>
            <option>15</option>
            <option>16</option>
            <option>17</option>
            <option>18</option>
            <option>19</option>
            <option>20</option>
          </select>
        </label>
      </div>
      <div class="large-6 medium-6 small-12 cell">
        <label>Modello
          <input type="text" name="modello" placeholder="Inserisci Modello"/>
        </label>
        <label>Fotocamera
          <input type="text" name="fotocamera" placeholder="Inserisci Fotocamera"/>
        </label>
        <label>Risoluzione Schermo
          <input type="text" name="risSchermo" placeholder="Inserisci risoluzione"/>
        </label>
        <label for="image-phone" class="button">Immagine
          <input type="file" name="immagine" id="image-phone" class="show-for-sr"/>
        </label>
        <label>
          <input type="submit" value="INSERISCI" class="button">
        </label>
      </div>
    </div>
  </div>
</form>
