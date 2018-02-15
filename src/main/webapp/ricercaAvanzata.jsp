<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Ricerca Avanzata">
  <jsp:body>
    <form name="ricerca" action="ricercaAvanzata" method="get">
      <div class="grid-container fluid">
        <h2 class="text-center">Effettua qui sotto una ricerca personalizzata</h2>
        <div class="grid-x">
          <div class="large-10 medium-10 small-12 cell">
            <label>Tecnologia
              <select name="tecnologia">
                <option selected>Gsm</option>
                <option>Gprs</option>
                <option>Umts</option>
                <option>Satellitare</option>
                <option>Edge</option>
                <option>Hscsd</option>
              </select>
            </label>
            <label>Connetività
              <select name="connettivita">
                <option selected>Bluetooth</option>
                <option>Infrarossi</option>
                <option>I-Mode</option>
                <option>Wi-fi</option>
                <option>ModemInterno</option>
                <option>Bluetoot/Infraross</option>
                <option>Usb</option>
                <option>Sincro-PC/PDA</option>
              </select>
            </label>
            <label>Suonerie:
              <select name="suonerie">
                  <option selected>Polifoniche</option>
                  <option>Scaricabili</option>
                  <option>Polif/Scaric</option>
                </select>
            </label>
            <label>Messagistica
                <select name="messaggi">
                  <option selected>Sms</option>
                  <option>Mms</option>
                  <option>Ems</option>
                  <option>Email</option>
                  <option>Chat</option> 
                  <option>Msn</option>
                  <option>Sms-Mms</option>
                  <option>Sms-Ems</option>
                  <otion>Sms-Email</option>
                    <option>Ems-Mms</option>
                    <option>Ems-Email</option>
                    <option>Mms-Email</option>
                    <option>Sms-Mms-Ems</option>
                    <option>Sms-Mms-Email-Chat</option> 
                    <option>Sms-Mms-Ems-Email</option>
                </select>
            </label>
            <label>Rete
            <select name="rete">
                  <option selected>Gsm</option>
                  <option>Gsm-Dualband</option>
                  <option>Gsm-Triband</option>
                  <option>Gsm-Quadriband</option>
                  <option>Gsm-Umts</option>
                </select>
            </label>
            <label>Autonomia Conv.
            <select name="autonomia">
                  <option selected>1</option>
                  <option>2</option>
                  <option>3</option>
                  <option>4</option>
                  <option>5</option>
                  <option>6</option>
                  <otion>7</option>
                </select>
            </label>
            <label>Autonomia St
              <select name="autonomiast">
                  <option selected>100</option>
                  <option>200</option>
                  <option>300</option>
                  <option>350</option>
                  <option>400</option>
                  <option>450</option>
                  <option>500</option>
                </select>
            </label>
            <label>Sistema Operativo
             <select name="sisoper">
                  <option selected>Symbian</option>
                  <option>Mobile</option>
                </select>
            </label>
             <label>Peso Massimo
              <select name="peso">
                  <option selected>80</option>
                  <option>100</option>
                  <option>130</option>
                  <option>160</option>
                  <option>200</option>
                </select>
             </label>
            <label>Lettori:
             <select name="lettori">
                  <option selected>Mp3</option>
                  <option>Wma</option>
                  <option>Mpeg</option>
                  <option>Mp3-Wma</option>
                  <option>Mp3-Mpeg</option>
                  <option>Wma-Mpeg</option>
                  <option>Mp3-Wma-Mpeg</option>
                </select>
            </label>
          </div>
          <div class="large-10 medium-10 small-12 cell">
            <fieldset>
              <legend>Vibrazione</legend>
              <input type="radio" name="vibrazione"  id="vibr_t" required><label for="vibr_t">Sì</label>
              <input type="radio" name="vibrazione"  id="vibr_f"><label for="vibr_f">No</label>
            </fieldset>
            <fieldset>
              <legend>Browser</legend>
              <input type="radio" name="browser"  id="brw_t" required><label for="brw_t">Sì</label>
              <input type="radio" name="browser"  id="brw_f"><label for="brw_f">No</label>
            </fieldset>
            <fieldset>
              <legend>Giochi</legend>
              <input type="radio" name="giochi"  id="game_t" required><label for="game_t">Sì</label>
              <input type="radio" name="giochi"  id="game_f"><label for="game_f">No</label>
            </fieldset>
            <fieldset>
              <legend>Java</legend>
              <input type="radio" name="java"  id="vibr_t" required><label for="java_t">Sì</label>
              <input type="radio" name="java"  id="vibr_f"><label for="java_f">No</label>
            </fieldset>
            <fieldset>
              <legend>Videochiamata</legend>
              <input type="radio" name="videochiamata"  id="video_t" required><label for="video_t">Sì</label>
              <input type="radio" name="videochiamata"  id="video_f"><label for="video_f">No</label>
            </fieldset>
            <fieldset>
              <legend>GPS</legend>
              <input type="radio" name="gps" id="gps_t" required><label for="gps_t">Sì</label>
              <input type="radio" name="gps" id="gps_f"><label for="gps_f">No</label>
            </fieldset>
            <fieldset>
              <legend>Vivavoce</legend>
              <input type="radio" name="vivavoce" id="voice_t" required><label for="voice_t">Sì</label>
              <input type="radio" name="vivavoce" id="voice_f"><label for="voice_f">No</label>
            </fieldset>
            <fieldset>
              <legend>Fotocamera</legend>
              <input type="radio" name="fotocamera" id="fot_t" required><label for="fot_t">Sì</label>
              <input type="radio" name="fotocamera" id="fot_f"><label for="fot_f">No</label>
            </fieldset>
              <fieldset>
              <legend>Radio</legend>
              <input type="radio" name="radio" id="rad_t" required><label for="rad_t">Sì</label>
              <input type="radio" name="radio" id="rad_f"><label for="rad_f">No</label>
            </fieldset>
              <fieldset>
              <legend>Memoria Interna</legend>
              <input type="radio" name="memoriaint" id="memi_t" required><label for="memi_t">Sì</label>
              <input type="radio" name="memoriaint" id="memi_f"><label for="memi_f">No</label>
            </fieldset>
              <fieldset>
              <legend>Memoria Esterna</legend>
              <input type="radio" name="memoriaest" id="meme_t" required><label for="meme_t">Sì</label>
              <input type="radio" name="memoriaest" id="meme_f"><label for="meme_f">No</label>
            </fieldset>
            <input type="submit" class="button" value="Ricerca"/>
          </div>
        </div>
      </div>
    </form>
  </jsp:body>
</ms:layout>