package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Domenico Antonio Tropeano on 25/02/2018 at 14:56
 * @project MobileSolutions
 */
public class BuyCartTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }
    @Test
    public void addToCart() {
        loginClient();
        driver.get("http://localhost:8080/MobileSolutions/PhoneDetails?id=1");
        driver.get("http://localhost:8080/MobileSolutions/AddToCart?idProduct=2");
        driver.get("http://localhost:8080/MobileSolutions/ShowCart");
        boolean added = driver.getPageSource().contains("Contenuto del tuo carrello");
        Assert.assertTrue(added);
        driver.close();
    }
    @Test
    public void testBuyCart() {
        loginClient();
        driver.get("http://localhost:8080/MobileSolutions/ShowCart");
        driver.get("http://localhost:8080/MobileSolutions/PaymentLoader");
        WebElement shipmentType = driver.findElements(By.name("shipmentType")).get(0);
        shipmentType.click();
        WebElement paymentType = driver.findElements(By.name("paymentType")).get(0);
        paymentType.click();
        WebElement form = driver.findElement(By.name("buyForm"));
        form.submit();
        boolean errorFound = driver.getPageSource().contains("C'è stato un errore");
        Assert.assertFalse(errorFound);
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
