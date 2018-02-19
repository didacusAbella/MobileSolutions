package mobilesolutions.old;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.mobilesolutions.testutilities.SeleniumDriverFactory;

/**
 * @author Domenico Antonio Tropeano on 12/02/2018 at 14:56
 * @project MobileSolutions
 */
public class Old_test {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    @Test
    public void testLoginClienteOk() {
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        WebElement logged = driver.findElement(By.cssSelector("form[action='logout_cliente']"));
        Assert.assertNotEquals(logged, null);
        driver.close();
    }

    @Test
    public void testLoginGestoreOk() {
        WebElement form = driver.findElement(By.name("login_gestore"));
        WebElement usernameStuff = driver.findElements(By.name("username")).get(1);
        usernameStuff.sendKeys("gestore");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(1);
        passwordStuff.sendKeys("gestore");
        form.submit();
        WebElement logged = driver.findElement(By.cssSelector("form[action='logout_gestore']"));
        Assert.assertNotEquals(logged, null);
        driver.close();
    }

    @Test
    public void testLoginClienteFail() {
        WebElement logged = null;
        try {
            WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
            usernameStuff.sendKeys("umber");
            WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
            passwordStuff.sendKeys("umber");
            WebElement form = driver.findElement(By.name("login_cliente"));
            form.submit();
            logged = driver.findElement(By.cssSelector("form[action='logout_cliente']"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Assert.assertNotEquals(logged, null);
            driver.close();
        }
    }

    @Test
    public void testRicercaCellOk() {
        WebElement form = driver.findElement(By.name("ricerca"));
        WebElement nameForSearch = driver.findElements(By.name("modello")).get(0);
        nameForSearch.sendKeys("6633");
        form.submit();
        Assert.assertEquals(driver.getPageSource().contains("6633"), true);
        driver.close();
    }

    @Test
    public void testRicercaCellFail() {
        WebElement form = driver.findElement(By.name("ricerca"));
        WebElement nameForSearch = driver.findElements(By.name("modello")).get(0);
        nameForSearch.sendKeys("mambo");
        form.submit();
        Assert.assertEquals(driver.getPageSource().contains("6633"), false);
        driver.close();
    }

    @Test
    public void testInserisciCarrello() {
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        WebElement form2 = driver.findElement(By.name("ricerca"));
        WebElement nameForSearch = driver.findElements(By.name("modello")).get(0);
        nameForSearch.sendKeys("6633");
        form2.submit();
        WebElement form3 = driver.findElement(By.cssSelector("form[action='insertCarrello']"));
        form3.submit();
        Assert.assertEquals(driver.getPageSource().contains("img/ok.jpg"), true);
        driver.close();

    }

    @Test
    public void testAcquistaCell() {
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        WebElement form2 = driver.findElement(By.name("ricerca"));
        WebElement nameForSearch = driver.findElements(By.name("modello")).get(0);
        nameForSearch.sendKeys("6633");
        form2.submit();
        WebElement form3 = driver.findElement(By.cssSelector("form[action='insertCarrello']"));
        form3.submit();
        Assert.assertEquals(driver.getPageSource().contains("img/ok.jpg"), true);
        driver.get("http://localhost:8080/MobileSolutions/cart.jsp");
        //new stuff
        WebElement form4 = driver.findElement(By.cssSelector("form[action='acquistaCarrello']"));
        form4.submit();
        WebElement form5 = driver.findElement(By.cssSelector("form[action='invioOrdini']"));
        form5.submit();
        driver.close();
    }

    @Test
    public void testAddCellulare() {
        WebElement form = driver.findElement(By.name("login_gestore"));
        WebElement usernameStuff = driver.findElements(By.name("username")).get(1);
        usernameStuff.sendKeys("gestore");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(1);
        passwordStuff.sendKeys("gestore");
        form.submit();
        driver.get("http://localhost:8080/MobileSolutions/inserimento.jsp");
        WebElement marca = driver.findElement(By.name("marca"));
        marca.sendKeys("Samsung");
        WebElement modello = driver.findElement(By.name("modello"));
        modello.sendKeys("S8");
        WebElement dimensioni = driver.findElement(By.name("dimensioni"));
        dimensioni.sendKeys("200x500");
        WebElement fotocamera = driver.findElement(By.name("fotocamera"));
        fotocamera.sendKeys("12");
        WebElement memoria = driver.findElement(By.name("memoria"));
        memoria.sendKeys("512");
        WebElement risSchermo = driver.findElement(By.name("risSchermo"));
        risSchermo.sendKeys("1024");
        new Select(driver.findElement(By.name("connettivita"))).selectByVisibleText("Infrarossi");
        WebElement prezzo = driver.findElement(By.name("prezzo"));
        prezzo.sendKeys("120");
        new Select(driver.findElement(By.name("quantita"))).selectByVisibleText("3");
        WebElement button = driver.findElement(By.cssSelector("input[value='INSERISCI']"));
        button.click();
        Assert.assertEquals(driver.getPageSource().contains("img/ok.jpg"), true);
        driver.close();
    }
    @Test
    public void testEliminaAccount(){
        WebElement usernameStuff = driver.findElement(By.name("username"));
        usernameStuff.sendKeys("dom");
        WebElement passwordStuff = driver.findElement(By.name("password"));
        passwordStuff.sendKeys("dom");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        driver.get("http://localhost:8080/MobileSolutions/cancellaCli.jsp");
        WebElement button = driver.findElement(By.cssSelector("input[value='CHIUDI ACCOUNT']"));
        button.click();
        Assert.assertEquals(driver.getPageSource().contains("password"), true);
        driver.close();

    }
    public void testEliminaCarrello(){}
    public void testModificaCarrello(){}

    public void testModificaAccount(){
      WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
      usernameStuff.sendKeys("umber");
      WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
      passwordStuff.sendKeys("umber");
      WebElement form = driver.findElement(By.name("login_cliente"));
      form.submit();
      driver.get("http://localhost:8080/MobileSolutions/modificaCli.jsp");
      WebElement nameElement = driver.findElement(By.name("nome"));
      nameElement.sendKeys("Diego");
      WebElement lastNameElement = driver.findElement(By.name("cognome"));
      lastNameElement.sendKeys("Avella");
      WebElement coElement = driver.findElement(By.name("cofiscale"));
      coElement.sendKeys("VLLDGI93A08C361G");
      WebElement place = driver.findElement(By.name("tipoindirizzo"));
      WebElement tmp = driver.findElement(By.name("indirizzo"));
      WebElement cap = driver.findElement(By.name("cap"));
      WebElement city = driver.findElement(By.name("citta"));
      WebElement prov = driver.findElement(By.name("prov"));
      WebElement phoneNumber = driver.findElement(By.name("telcas"));
      WebElement cellPhone = driver.findElement(By.name("telcel"));
      WebElement fax = driver.findElement(By.name("fax"));
      WebElement email = driver.findElement(By.name("email"));
      WebElement password = driver.findElement(By.name("password"));
      driver.close();
    }
    
    @Test
    public void testModificaCellulare(){
        WebElement form = driver.findElement(By.name("login_gestore"));
        WebElement usernameStuff = driver.findElements(By.name("username")).get(1);
        usernameStuff.sendKeys("gestore");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(1);
        passwordStuff.sendKeys("gestore");
        form.submit();
        driver.get("http://localhost:8080/MobileSolutions/modificaCell.jsp");
        WebElement select = driver.findElement(By.name("modelloCell"));
        WebElement form_phone = driver.findElement(By.cssSelector("form[action='modificaCellulare']"));
        form_phone.submit();
        WebElement editPhoneForm = driver.findElement(By.cssSelector("form[action='modCaratt']"));
        WebElement type = driver.findElement(By.name("marca"));
        type.sendKeys("Samsung");
        WebElement model = driver.findElement(By.name("modello"));
        model.sendKeys("S8");
        WebElement image = driver.findElement(By.name("immagine"));
        image.sendKeys("SamsungImage,jpg");
        WebElement dimension = driver.findElement(By.name("dimensioni"));
        dimension.sendKeys("50 x 110 x 80");
        WebElement camera = driver.findElement(By.name("fotocamera"));
        camera.sendKeys("12px");
        WebElement memory = driver.findElement(By.name("memoria"));
        memory.sendKeys("12GB");
        WebElement screen = driver.findElement(By.name("risSchermo"));
        screen.sendKeys("10");
        WebElement connection = driver.findElement(By.name("connettivita"));
        connection.sendKeys("Bluetooth");
        WebElement price = driver.findElement(By.name("prezzo"));
        price.sendKeys("800.45");
        WebElement quantity = driver.findElement(By.name("quantita"));
        quantity.sendKeys("10");
        editPhoneForm.submit();
        Assert.assertEquals(driver.getPageSource().contains("img/ok.jpg"), true);
        driver.close();
    }
    
    @Test
    public void testRicercaAvanzata(){
      driver.get("http://localhost:8080/MobileSolutions/ricercaAvanzata.jsp");
      WebElement search = driver.findElement(By.name("ricerca"));
      Select tech = new Select(driver.findElement(By.name("tecnologia")));
      tech.selectByIndex(3);
      Select price = new Select(driver.findElement(By.name("prezzoMassimo")));
      price.selectByIndex(0);
      Select connection= new Select(driver.findElement(By.name("connettivita")));
      connection.selectByIndex(0);
      Select messages = new Select(driver.findElement(By.name("messaggi")));
      messages.selectByIndex(1);
      Select web = new Select(driver.findElement(By.name("rete")));
      web.selectByIndex(0);
      Select autonomy = new Select(driver.findElement(By.name("autonomia")));
      autonomy.selectByIndex(1);
      Select autonmyast = new Select(driver.findElement(By.name("autonomiast")));
      autonmyast.selectByIndex(1);
      Select os = new Select(driver.findElement(By.name("sisoper")));
      os.selectByIndex(0);
      Select weight = new Select(driver.findElement(By.name("peso")));
      weight.selectByIndex(1);
      Select vibration = new Select(driver.findElement(By.name("vibrazione")));
      vibration.selectByIndex(0);
      Select browser = new Select(driver.findElement(By.name("browser")));
      browser.selectByIndex(0);
      Select games = new Select(driver.findElement(By.name("giochi")));
      games.selectByIndex(0);
      Select java = new Select(driver.findElement(By.name("java")));
      java.selectByIndex(0);
      Select videoCall = new Select(driver.findElement(By.name("videochiamata")));
      videoCall.selectByIndex(0);
      Select gps = new Select(driver.findElement(By.name("gps")));
      gps.selectByIndex(0);
      Select readers = new Select(driver.findElement(By.name("lettori")));
      readers.selectByIndex(2);
      Select voicelive = new Select(driver.findElement(By.name("vivavoce")));
      voicelive.selectByIndex(0);
      Select radio = new Select(driver.findElement(By.name("radio")));
      radio.selectByIndex(0);
      Select camera = new Select(driver.findElement(By.name("fotocamera")));
      camera.selectByIndex(0);
      Select internalMemory = new Select(driver.findElement(By.name("memoriaint")));
      internalMemory.selectByIndex(0);
      Select externalMemory = new Select(driver.findElement(By.name("memoriaest")));
      externalMemory.selectByIndex(0);
      search.submit();
      Assert.assertTrue(driver.getPageSource().contains("Cellulare non presente"));
      driver.close();
    }
    
    @Test
    public void testRimuoviCellulare(){
      WebElement form = driver.findElement(By.name("login_gestore"));
      WebElement usernameStuff = driver.findElements(By.name("username")).get(1);
      usernameStuff.sendKeys("gestore");
      WebElement passwordStuff = driver.findElements(By.name("password")).get(1);
      passwordStuff.sendKeys("gestore");
      form.submit();
      driver.get("http://localhost:8080/MobileSolutions/cancellaCell.jsp");
      WebElement removeForm = driver.findElement(By.cssSelector("form[action='cancellaCell']"));
      Select model = new Select(driver.findElement(By.name("cancCell")));
      model.selectByIndex(1);
      removeForm.submit();
      Assert.assertEquals(driver.getPageSource().contains("img/ok.jpg"), true);
      driver.close();
    }
    
    @Test
    public void testVisualizzaClienti(){
      WebElement form = driver.findElement(By.name("login_gestore"));
      WebElement usernameStuff = driver.findElements(By.name("username")).get(1);
      usernameStuff.sendKeys("gestore");
      WebElement passwordStuff = driver.findElements(By.name("password")).get(1);
      passwordStuff.sendKeys("gestore");
      form.submit();
      driver.get("http://localhost:8080/MobileSolutions/clienti.jsp");
      Assert.assertTrue(driver.findElements(By.tagName("label")).size() > 0);
      driver.close();
    }
    
    @Test
    public void testProdottiEsaurimento(){
      WebElement form = driver.findElement(By.name("login_gestore"));
      WebElement usernameStuff = driver.findElements(By.name("username")).get(1);
      usernameStuff.sendKeys("gestore");
      WebElement passwordStuff = driver.findElements(By.name("password")).get(1);
      passwordStuff.sendKeys("gestore");
      form.submit();
      driver.get("http://localhost:8080/MobileSolutions/esaurimento.jsp");
      WebElement innerForm = driver.findElement(By.name("scortaMinima"));
      Select quantity = new Select(driver.findElement(By.name("scorta")));
      quantity.selectByIndex(3);
      innerForm.submit();
      Assert.assertTrue(driver.getPageSource().contains("6630"));
      driver.close();
    }
}
