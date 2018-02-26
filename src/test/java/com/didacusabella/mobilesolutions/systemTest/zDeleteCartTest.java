package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Domenico Antonio Tropeano on 25/02/2018 at 21:26
 * @project MobileSolutions
 */
public class zDeleteCartTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    @Test
    public void testDeleteCart() {
        loginClient();
        driver.get("http://localhost:8080/MobileSolutions/ShowCart");
        driver.get("http://localhost:8080/MobileSolutions/DeleteCart");
        Assert.assertTrue(driver.getPageSource().contains("Non ci sono prodotti nel tuo carrello"));
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
