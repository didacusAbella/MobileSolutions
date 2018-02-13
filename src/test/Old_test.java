import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Domenico Antonio Tropeano on 12/02/2018 at 14:56
 * @project MobileSolutions
 */
public class Old_test {
    private static ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Documenti\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @Test
    public void testLoginClienteOk() {
        WebElement usernameStuff = driver.findElementsByName("username").get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElementsByName("password").get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        WebElement logged = driver.findElement(By.cssSelector("form[action='logout_cliente']"));
        Assert.assertNotEquals(logged, null);
        driver.close();
    }

    @Test
    public void testLoginGestoreOk() {
        WebElement form = driver.findElementByName("login_gestore");
        WebElement usernameStuff = driver.findElementsByName("username").get(1);
        usernameStuff.sendKeys("gestore");
        WebElement passwordStuff = driver.findElementsByName("password").get(1);
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
            WebElement usernameStuff = driver.findElementsByName("username").get(0);
            usernameStuff.sendKeys("umber");
            WebElement passwordStuff = driver.findElementsByName("password").get(0);
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
        WebElement form = driver.findElementByName("ricerca");
        WebElement nameForSearch = driver.findElementsByName("modello").get(0);
        nameForSearch.sendKeys("6633");
        form.submit();
        Assert.assertEquals(driver.getPageSource().contains("6633"), true);
        driver.close();
    }

    @Test
    public void testRicercaCellFail() {
        WebElement form = driver.findElementByName("ricerca");
        WebElement nameForSearch = driver.findElementsByName("modello").get(0);
        nameForSearch.sendKeys("mambo");
        form.submit();
        Assert.assertEquals(driver.getPageSource().contains("6633"), false);
        driver.close();
    }

    @Test
    public void testInserisciCarrello() {
        WebElement usernameStuff = driver.findElementsByName("username").get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElementsByName("password").get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        WebElement form2 = driver.findElementByName("ricerca");
        WebElement nameForSearch = driver.findElementsByName("modello").get(0);
        nameForSearch.sendKeys("6633");
        form2.submit();
        WebElement form3 = driver.findElement(By.cssSelector("form[action='insertCarrello']"));
        form3.submit();
        Assert.assertEquals(driver.getPageSource().contains("img/ok.jpg"), true);
        driver.close();

    }

    @Test
    public void testAcquistaCell() {
        WebElement usernameStuff = driver.findElementsByName("username").get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElementsByName("password").get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        WebElement form2 = driver.findElementByName("ricerca");
        WebElement nameForSearch = driver.findElementsByName("modello").get(0);
        nameForSearch.sendKeys("6633");
        form2.submit();
        WebElement form3 = driver.findElement(By.cssSelector("form[action='insertCarrello']"));
        form3.submit();
        Assert.assertEquals(driver.getPageSource().contains("img/ok.jpg"), true);
        driver.get("http://localhost:8080/carrello.jsp");
        //new stuff
        WebElement form4 = driver.findElement(By.cssSelector("form[action='acquistaCarrello']"));
        form4.submit();
        WebElement form5 = driver.findElement(By.cssSelector("form[action='invioOrdini']"));
        form5.submit();
    }

    @Test
    public void testAddCellulare() {
        WebElement form = driver.findElementByName("login_gestore");
        WebElement usernameStuff = driver.findElementsByName("username").get(1);
        usernameStuff.sendKeys("gestore");
        WebElement passwordStuff = driver.findElementsByName("password").get(1);
        passwordStuff.sendKeys("gestore");
        form.submit();
        driver.get("http://localhost:8080/inserimento.jsp");
        WebElement marca = driver.findElementByName("marca");
        marca.sendKeys("Samsung");
        WebElement modello = driver.findElementByName("modello");
        modello.sendKeys("S8");
        WebElement dimensioni = driver.findElementByName("dimensioni");
        dimensioni.sendKeys("200x500");
        WebElement fotocamera = driver.findElementByName("fotocamera");
        fotocamera.sendKeys("12");
        WebElement memoria = driver.findElementByName("memoria");
        memoria.sendKeys("512");
        WebElement risSchermo = driver.findElementByName("risSchermo");
        risSchermo.sendKeys("1024");
        new Select(driver.findElement(By.name("connettivita"))).selectByVisibleText("Infrarossi");
        WebElement prezzo = driver.findElementByName("prezzo");
        prezzo.sendKeys("120");
        new Select(driver.findElement(By.name("quantita"))).selectByVisibleText("3");
        WebElement button = driver.findElement(By.cssSelector("input[value='INSERISCI']"));
        button.click();
        Assert.assertEquals(driver.getPageSource().contains("img/ok.jpg"), true);
        driver.close();
    }
    public void testEliminaAccount(){}
    public void testEliminaCarrello(){}
    public void testModificaCarrello(){}
    public void testRegistrazione(){}   //Attenzione
}
