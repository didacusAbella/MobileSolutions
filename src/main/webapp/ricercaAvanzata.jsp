<html>

  <head>
    <title>BENVENUTI SU MOBILE MANIA</title>
    <link rel="stylesheet" type="text/css" href="stile.css">
    <LINK REL="shortcut icon" HREF="img/favicon.ICO">
    <meta name="author" content=Attanasio Carmine">
          <meta name="description" content="MOBILE'S INFINITY">
    <meta name="generator" content="jEdit">
  </head>

  <body>

    <jsp:include page="intestazione.jsp"/> 

    <table align="center">
      <form name="ricerca" action="ricerca" method="get">

        <tr><td><OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/
                        swflash.cab#version=5,0,0,0" WIDTH=120 HEIGHT=100 >
              <PARAM NAME=movie VALUE="img/ric24b.swf">
              <PARAM NAME=quality VALUE=high>
              <EMBED src="ric24b.swf" quality=high width=120 HEIGHT=100
                     type="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?
                     P1_Prod_Version=ShockwaveFlash"></EMBED>
            </OBJECT></td>
          <td><label>MARCA:</label></td> <td><select name="marca">
              <option selected>nokia</option>
              <option>Nokia</option>
              <option>samsung</option>
            </select></td>

          <td><label>MODELLO:</label></td> <td><input type="text" name="modello"></td>
          <td><input type="submit" value="Start" class="pulsante"></td>

          <td><OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/
                      swflash.cab#version=5,0,0,0" WIDTH=120 HEIGHT=100 >
              <PARAM NAME=movie VALUE="img/ric24b.swf">
              <PARAM NAME=quality VALUE=high>
              <EMBED src="ric24b.swf" quality=high width=120 HEIGHT=100
                     type="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?
                     P1_Prod_Version=ShockwaveFlash"></EMBED>
            </OBJECT></td></tr>
    </table>
  </form>
  <p align="center"><b>Rieffettua una ricerca semplice oppure effettua qui sotto una ricerca personalizzata</b></p>


  <table border="0" align="center" valign="top" width="900">
    <tr>
      <td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
      <td valign="top">

        <hr>       

        <br><br><br>
        <form name="ricerca" action="ricercaAvanzata" method="get">
          <table border="0">

            <tr> <td><label>TECNOLOGIA:</label></td>
              <td>
                <select name="tecnologia">
                  <option selected>Gsm</option>
                  <option>Gprs</option>
                  <option>Umts</option>
                  <option>Satellitare</option>
                  <option>Edge</option>
                  <option>Hscsd</option>

                </select>
              </td> 
              <td><label>CONNETTIVITA':</label></td>
              <td>
                <select name="connettivita">
                  <option selected>Bluetooth</option>
                  <option>Infrarossi</option>
                  <option>I-Mode</option>
                  <option>Wi-fi</option>
                  <option>ModemInterno</option>
                  <option>Bluetoot/Infraross</option>
                  <option>Usb</option>
                  <option>Sincro-PC/PDA</option>
                </select> </td> </tr>
            <tr><td>&nbsp</td></tr> 
            <tr> <td><label>PREZZO MASSIMO:</label></td>
              <td>
                <select name="prezzoMassimo">
                  <option selected>100</option>
                  <option>150</option>
                  <option>200</option>
                  <option>250</option>
                  <option>300</option>
                  <option>350</option>
                  <otion>400</option>
                </select> <label>€</label>
              </td> 
              <td><label>SUONERIE:</label></td>
              <td>
                <select name="suonerie">
                  <option selected>Polifoniche</option>
                  <option>Scaricabili</option>
                  <option>Polif/Scaric</option>

                </select> </td> </tr>
            <tr><td>&nbsp</td></tr>
            <tr> <td><label>MESSAGGISTICA:</label></td>
              <td>
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
              </td> 
              <td><label>RETE:</label></td>
              <td>
                <select name="rete">
                  <option selected>Gsm</option>
                  <option>Gsm-Dualband</option>
                  <option>Gsm-Triband</option>
                  <option>Gsm-Quadriband</option>
                  <option>Gsm-Umts</option>
                </select> </td> </tr>
            <tr><td>&nbsp</td></tr>

            <tr> <td><label>AUTONOMIA CONV.:</label></td>
              <td>
                <select name="autonomia">
                  <option selected>1</option>
                  <option>2</option>
                  <option>3</option>
                  <option>4</option>
                  <option>5</option>
                  <option>6</option>
                  <otion>7</option>
                </select> <label>h</label>
              </td> 
              <td><label>AUTONOMIA ST.:</label></td>
              <td>
                <select name="autonomiast">
                  <option selected>100</option>
                  <option>200</option>
                  <option>300</option>
                  <option>350</option>
                  <option>400</option>
                  <option>450</option>
                  <option>500</option>
                </select> <label>h</label> </td> </tr>
            <tr><td>&nbsp</td></tr> 
            <tr> <td><label>SISTEMA OPERATIVO:</label></td>
              <td>
                <select name="sisoper">
                  <option selected>Symbian</option>
                  <option>Mobile</option>

                </select>
              </td> 
              <td><label>PESO MASSIMO:</label></td>
              <td>
                <select name="peso">
                  <option selected>80</option>
                  <option>100</option>
                  <option>130</option>
                  <option>160</option>
                  <option>200</option>

                </select> <label>g</label> </td> </tr>
            <tr><td>&nbsp</td></tr>   
            <tr> <td><label>VIBRAZIONE:</label></td>
              <td>
                <select name="vibrazione">
                  <option selected>Si</option>
                  <option>No</option>

                </select>
              </td> 
              <td><label>BROWSER:</label></td>
              <td>
                <select name="browser">
                  <option selected>Si</option>
                  <option>No</option>

                </select>  </td> </tr>


            <tr><td>&nbsp</td></tr>   
            <tr> <td><label>GIOCHI:</label></td>
              <td>
                <select name="giochi">
                  <option selected>Si</option>
                  <option>No</option>

                </select>
              </td> 
              <td><label>JAVA:</label></td>
              <td>
                <select name="java">
                  <option selected>Si</option>
                  <option>No</option>

                </select>  </td> </tr>
            <tr><td>&nbsp</td></tr>   
            <tr> <td><label>VIDEOCHIAMATA:</label></td>
              <td>
                <select name="videochiamata">
                  <option selected>Si</option>
                  <option>No</option>

                </select>
              </td> 
              <td><label>GPS:</label></td>
              <td>
                <select name="gps">
                  <option selected>Si</option>
                  <option>No</option>

                </select>  </td> </tr>
            <tr><td>&nbsp</td></tr>   
            <tr> <td><label>LETTORI:</label></td>
              <td>
                <select name="lettori">
                  <option selected>Mp3</option>
                  <option>Wma</option>
                  <option>Mpeg</option>
                  <option>Mp3-Wma</option>
                  <option>Mp3-Mpeg</option>
                  <option>Wma-Mpeg</option>
                  <option>Mp3-Wma-Mpeg</option>
                </select>
              </td> 
              <td><label>VIVAVOCE:</label></td>
              <td>
                <select name="vivavoce">
                  <option selected>Si</option>
                  <option>No</option>

                </select>  </td> </tr>
            <tr><td>&nbsp</td></tr>   
            <tr> <td><label>RADIO:</label></td>
              <td>
                <select name="radio">
                  <option selected>Si</option>
                  <option>No</option>

                </select>
              </td> 
              <td><label>FOTOCAMERA:</label></td>
              <td>
                <select name="fotocamera">
                  <option selected>Si</option>
                  <option>No</option>

                </select>  </td> </tr>
            <tr><td>&nbsp</td></tr>   
            <tr> <td><label>MEMORIA INTERNA:</label></td>
              <td>
                <select name="memoriaint">
                  <option selected>Si</option>
                  <option>No</option>

                </select>
              </td> 
              <td><label>MEMORIA ESTERNA:</label></td>
              <td>
                <select name="memoriaest">
                  <option selected>Si</option>
                  <option>No</option>

                </select>  </td> </tr>

            <tr> <td> &nbsp </td> <td> &nbsp </td> </tr>

            <tr><td>&nbsp</td><td> <input type="submit" value="Start" class="pulsante"></td><td>&nbsp</td> <td><input type="reset" value="Reset" class="pulsante"><td></tr>
          </table>


        </form> <br><br><br>
        <p align="center"><a href="index.jsp">Indietro</a></p>
      </td>
      <td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
    </tr>
  </table>

</body>

</html>
