<form action="importazione" method="post" name="importazione">
  <div class="grid-container">
    <div class="grid-x">
      <div class="cell">
        <fieldset class="fieldset">
          <legend>DA QUESTA PAGINA PUOI IMPORTARE UN FILE XML ESTERNO</legend>
          <p> Ricorda di inserire il file XML esterno nella cartella database di WEB-INF prima di importarlo.
            Inoltre il file XML esterno deve avere un ulteriore tag quantita.
          </p>
          <label for="upload_xml" class="button">Scegli il file XML Esterno</label>
          <input type="file" id="upload_xml" class="show-for-sr" value="IMPORTA" name="esterno"/>
        </fieldset>
      </div>
    </div>
  </div>
</form>
