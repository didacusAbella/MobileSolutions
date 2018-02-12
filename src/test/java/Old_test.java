import java.io.File;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

/**
 * @author Domenico Antonio Tropeano on 12/02/2018 at 14:56
 * @project MobileSolutions
 */
public class Old_test {
    private static OperaDriver driver;
    private static OperaOptions options = new OperaOptions();
    
    @Before
    public void setUp(){
        options.setBinary(new File("C:\\Program Files\\Opera\\50.0.2762.67\\opera.exe"));
        System.setProperty("webdriver.opera.driver", "C:\\Users\\Diequ\\operadriver_win64\\operadriver.exe");
        driver = new OperaDriver(options);
        driver.get("http://localhost:8080/MobileSolutions/");
    }
    
    @Test
    public void testLoginCliente(){
        WebElement usernameStuff = driver.findElementsByName("username").get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElementsByName("password").get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        WebElement logged = driver.findElement(By.cssSelector("form[action='logout_cliente']"));
        Assert.assertNotEquals(logged,null);
    }
    
    @Test
    public void testLoginGestore(){
        WebElement form = driver.findElementByName("login_gestore");
        WebElement usernameStuff = driver.findElementsByName("username").get(1);
        usernameStuff.sendKeys("gestore");
        WebElement passwordStuff = driver.findElementsByName("password").get(1);
        passwordStuff.sendKeys("gestore");
        form.submit();
        WebElement logged = driver.findElement(By.cssSelector("form[action='logout_gestore']"));
        Assert.assertNotEquals(logged,null);
    }
    
    @Test
    public void testLoginClienteFail(){
        WebElement logged = null;
        try{
        WebElement usernameStuff = driver.findElementsByName("username").get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElementsByName("password").get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        logged = driver.findElement(By.cssSelector("form[action='logout_cliente']"));
        }catch(Exception e){
            e.printStackTrace();
        }finally {
          Assert.assertNotEquals(logged,null);  
        }
    }
}
