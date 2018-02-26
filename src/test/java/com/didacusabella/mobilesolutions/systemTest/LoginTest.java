package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Domenico Antonio Tropeano on 25/02/2018 at 11:11
 * @project MobileSolutions
 */
public class LoginTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    @Test
    public void testLoginClientOk() {
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("signinClient"));
        form.submit();
        boolean logged = driver.getPageSource().contains("Benvenuto");
        Assert.assertTrue(logged);
        driver.close();
    }

    @Test
    public void testLoginClientNotExist() {
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("mare");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("marino");
        WebElement form = driver.findElement(By.name("signinClient"));
        form.submit();
        boolean logged = driver.getPageSource().contains("I parametri della richiesta sono errati. Controlla i campi");
        Assert.assertTrue(logged);
        driver.close();
    }

    @Test
    public void testLoginClientWrongPassword() {
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("cagnolino");
        WebElement form = driver.findElement(By.name("signinClient"));
        form.submit();
        boolean logged = driver.getPageSource().contains("I parametri della richiesta sono errati. Controlla i campi");
        Assert.assertTrue(logged);
        driver.close();
    }

    @Test
    public void testLoginClientUsernameTooLong() {
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("didacusAbella93000000000000000");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("cagnolino");
        Assert.assertNotEquals(usernameStuff.getText(), "didacusAbella93000000000000000");
        driver.close();
    }

    @Test
    public void testLoginClientUsernameBadPattern() {
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("DIcso@_?0.-èe+]");
        boolean errorStuff = driver.getPageSource().contains("Il campo username deve contenere solo lettere e numeri");
        Assert.assertTrue(errorStuff);
        driver.close();
    }

    @Test
    public void testLoginClientPasswordTooLong() {
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("cagnolinooooooooooooooooooooo");
        Assert.assertNotEquals(passwordStuff.getText(), "cagnolinooooooooooooooooooooo");
        driver.close();
    }

    @Test
    public void testLoginClientPasswordBadPattern() {
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("DIcso@_?0.-èe+]");
        boolean errorStuff = driver.getPageSource().contains("Il campo username deve contenere solo lettere e numeri");
        Assert.assertTrue(errorStuff);
        driver.close();
    }
}
