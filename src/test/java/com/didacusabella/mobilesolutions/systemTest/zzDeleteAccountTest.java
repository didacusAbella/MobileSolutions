package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Domenico Antonio Tropeano on 25/02/2018 at 21:12
 * @project MobileSolutions
 */
public class zzDeleteAccountTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    @Test
    public void testDelete() {
        loginClient();
        driver.get("http://localhost:8080/MobileSolutions/EditProfile");
        WebElement form = driver.findElement(By.name("deleteForm"));
        form.submit();
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("umber");
        WebElement form1 = driver.findElement(By.name("signinClient"));
        form1.submit();
        boolean logged = driver.getPageSource().contains("I parametri della richiesta sono errati. Controlla i campi");
        Assert.assertNotEquals(logged, null);
        driver.close();
    }

    private void loginClient() {
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("signinClient"));
        form.submit();
    }
}
