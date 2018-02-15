<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Pagamenti">
  <jsp:body>
    <div class="grid-container fluid">
      <div class="grid-x">
        <div class="cell">
          <h2>Modalità Pagamenti</h2>
          <p>Questo esercizio commerciale utilizza i più sicuri sistemi di 
            pagamento per le transazioni on-line per tutelare la clientela dal 
            punto di vista della sicurezza di cotali,oltre che per ridurre lo 
            scetticismo che ancora si fa largo tra molti potenziali clienti che 
            preferiscono per i loro acquisti il canale diretto anzichè quello virtuale.
          </p>
          <ul class="menu expanded" data-magellan>
            <li><a href="#primo">PayPal</a></li>
            <li><a href="#secondo">PostePay</a></li>
            <li><a href="#terzo">Conto corrente postale</a></li>
            <li><a href="#quarto">Contrassegno</a></li>
            <li><a href="#quinto">Vaglia postale</a></li>
            <li><a href="#sesto">Bonifico bancario</a></li>
          </ul>
          <div class="sections">
            <section id="primo" data-magellan-target="primo">
              <h4>Paypal</h4>
              <p>Paypal è una società che ti permette di fare acquisti in tutta 
                tranquillità e sicurezza nell'ambito delle transazioni online,
                inerenti pagamenti e ricezioni di denaro. L'ideale per chi vuole
                effettuare acquisti con la massima sicurezza e discrezione.
                Paypal funge da mediatore che si interpone tra chi compra e chi 
                vende sul Web.Le aziende e i consumatori che usano Paypal conoscono 
                solo l'indirizzo E-mail del mittente,la data di registrazione e 
                se egli è un utente Paypal verificato.I dati personali (e sopratutto 
                numeri di carte di credito o prepagate) non vengono mai comunicati 
                alle parti in causa,ma vengono solo custoditi nell'archivio di Paypal. 
                La comunicazione dei dati su paypal è garantita dal trasporto criptato 
                SSL3 a 128 bit per la sicurezza delle informazizoni(standard più 
                alto nella sicurezza online). Pagamenti protetti da sistemi di 
                criptazione,le parti in causa NON conoscono i dati reciproci, solo Paypal 
                conosce i relativi dati. Inoltre si possono utilizzare CARTE RICARICABILI.
              </p>
              <ul>
                <li><strong>Veloce.</strong> I pagamenti avvengono in tempo reale</li>
                <li><strong>Semplice.</strong> La registrazione a tale servizio si esegue in pochi minuti e le istruzioni sono accurate e in italiano</li>
                <li><strong>Internazionale.</strong> Si possono inviare e ricevere pagamenti in 56 paesi</li>
                <li><strong>Gratuito.</strong> Le spese sono 0 per chi effettua pagamenti</li>
                <li><strong>Funzionamento.</strong> Sul sito <a href="http://www.paypal.it">www.paypal.it</a> 
                  basta registrarsi compilando i vari moduli tra cui quello relativo all'
                  inserimento del numero di carta di credito (Visa, Visa Electron, 
                  MasterCard) oppure il numero della carta prepagata (Postepay, 
                  Vodafone,Kalibra). La carta sarà collegata al conto Paypal creato. 
                  Per poter effettuare pagamenti bisogna solo conosce l'indirizzo 
                  email del destinatario. All'atto del pagamento Paypal addebita 
                  l'importo direttamente sulla tua carta di credito o prepagata.
                </li>
                <li><strong>Utente verificato.</strong> Gli utenti Paypal possono  trasferire soldi 
                  fino a 750 euro al mese. Per non avere limitazioni nei versamenti,
                  bisogna ottenere lo stato di utente verificato. Basta richiedere 
                  a Paypal l'invio del codice di verifica: questo codice a 4 cifre 
                  viene inviato via email entro 4 giorni e va inserito in un 
                  apposito modulo di Paypal. Il costo di attivazione è di circa 2 euro.
                </li>
                <li><strong>Pagamento.</strong> All'atto dell'acquisto del prodotto 
                  su Mobile's Infinity se il cliente sceglierà tale strumento di
                  pagamento esso verrà linkato sul sito sicuro Paypal per il 
                  completamento della transazione commerciale.
                </li>
              </ul>
            </section>
            <section id="secondo" data-magellan-target="secondo">
              <h4>Postepay</h4>
              <p> E' possibile utilizzare la carta postepay qualora il cliente 
                ne fosse in possesso per farci pervenire i pagamenti. Il numero 
                di carta sul quale effettuale la ricarica è: <strong>1111-2222-3333-4444.</strong>
              </p>
            </section>
            <section id="terzo" data-magellan-target="terzo">
              <h4>Conto Corrente Postale</h4>
              <p>E' possibile utilizzare il conto corrente postale per farci pervenire il pagamento dell'ordine.</p>
              <ul>
                <li>Numero C/C:88888888</li>
                <li>Intestato a: <em>Mobile's Solutions srl via Torino 100, 84000 Milano</em></li>
                <li>Causale: <em>Marca Modello Prezzo</em></li>
              </ul>
            </section>
            <section id="quarto" data-magellan-target="quarto">
              <h4>Contrassegno</h4>
              <p> E' possibile uitilizzare il pagamento in contrassegno. 
                Il pagamento verrï¿½ effettuato alla consegna del prodotto. 
                All'atto della consegna si deve fornire al portapacchi la somma dovuta. 
                Il fattorino non consegna il sabato e la domenica. In caso di 
                assenza del destinatario il portapacchi lascerà un avviso nella 
                cassetta delle lettere ed il pacco dovrà quindi essere ritirato 
                presso l'ufficio postale.
              </p>
            </section>
            <section id="quinto" data-magellan-target="quinto">
              <h4>Vaglia postale</h4>
              <p>E' possibile utilizzare il vaglia postale per farci pervenire il pagamento</p>
              <p>Parametri vaglia:</p>
              <ul>
                <li>Intestato a: <em>Mobile's Solutions srl</em></li>
                <li>Indirizzo: <em>via Torino 100, 84000 Milano</em></li>
                <li>Causale: <em>Marca Modello Prezzo</em></li>
              </ul>
            </section>
            <section id="sesto" data-magellan-target="sesto">
              <h4>Bonifico Bancario</h4>
              <p>E' possibile utilizzare il bonifico bancario per farci pervenire il pagamento.</p>
              <p>Parametri Bonifico</p>
              <ul>
                <li>Numero C/C: <em>00000088888</em></li>
                <li>Intestato a: <em>Mobile Solutions srl</em></li>
                <li>Divisa: <em>EURO</em></li>
                <li>Cod. paese:<em>IT</em></li>
                <li>Cod. ABI:<em>10000</em></li>
                <li>Cod. CAB:<em>10000</em></li>
                <li>Cod. CIN:<em>B</em></li>
                <li>BIC/SWIFT:<em>HJUKLOT1000</em></li>
                <li>IBAN:<em>HFT5JUYGT6HJYGGHYOLK8RDGHJ88</em></li>
              </ul>
            </section>
          </div>
        </div>
      </div>
    </div>
  </jsp:body>
</ms:layout>