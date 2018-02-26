package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.validation.constraints.AssertTrue;

/**
 * @author Domenico Antonio Tropeano on 26/02/2018 at 21:25
 * @project MobileSolutions
 */
public class EditPhoneTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    @Test
    public void testEditPhoneOk() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/EditPhone?id=1");
        WebElement brand = driver.findElements(By.name("brand")).get(1);
        WebElement model = driver.findElement(By.name("model"));
        WebElement cpu = driver.findElement(By.name("cpu"));
        WebElement quantity = driver.findElement(By.name("quantity"));
        WebElement ram = driver.findElement(By.name("ram"));
        WebElement internalStorage = driver.findElement(By.name("internalStorage"));
        WebElement camera = driver.findElement(By.name("camera"));
        WebElement displayInch = driver.findElement(By.name("displayInch"));
        WebElement os = driver.findElement(By.name("os"));
        WebElement bluetooth = driver.findElement(By.name("bluetooth"));
        WebElement lte = driver.findElement(By.name("lte"));
        WebElement price = driver.findElement(By.name("price"));
        brand.clear();
        brand.sendKeys("Samsung");
        model.clear();
        model.sendKeys("S8");
        cpu.clear();
        cpu.sendKeys("6.4Ghz");
        quantity.clear();
        quantity.sendKeys("500");
        ram.clear();
        ram.sendKeys("4");
        internalStorage.clear();
        internalStorage.sendKeys("128");
        camera.clear();
        camera.sendKeys("15");
        displayInch.clear();
        displayInch.sendKeys("5.2");
        os.clear();
        os.sendKeys("Android");
        bluetooth.click();
        lte.click();
        price.clear();
        price.sendKeys("620");
        WebElement form = driver.findElement(By.name("EditPhone"));
        form.submit();
        Assert.assertTrue(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    private void loginAdmin() {
        driver.get("http://localhost:8080/MobileSolutions/administration.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("admin");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("admin");
        WebElement form = driver.findElement(By.name("LoginAdmin"));
        form.submit();
    }
}
