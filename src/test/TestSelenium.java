


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * @author Domenico Antonio Tropeano on 12/02/2018 at 14:16
 * @project MobileSolutions
 */
public class TestSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Documenti\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        WebElement usernameStuff = driver.findElement(By.name("username"));
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElement(By.name("password"));
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("login_cliente"));
        form.submit();
        WebElement logged = driver.findElement(By.cssSelector("form[action='logout_cliente']"));
        Assert.assertNotEquals(logged,null);
    }
}
