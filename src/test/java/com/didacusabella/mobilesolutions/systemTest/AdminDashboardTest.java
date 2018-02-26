package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Domenico Antonio Tropeano on 26/02/2018 at 19:38
 * @project MobileSolutions
 */
public class AdminDashboardTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    @Test
    public void testSeeAllClient() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/ShowClients");
        Assert.assertTrue(driver.getPageSource().contains("Utenti"));
        driver.close();
    }

    @Test
    public void testShowRemainingPhones() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AdminDashboard?page=remainingPhones.jsp");
        Select quantity = new Select(driver.findElement(By.name("quantity")));
        quantity.selectByIndex(5);
        WebElement form = driver.findElement(By.name("remainingPhones"));
        form.submit();
        Assert.assertTrue(driver.getCurrentUrl().contains("http://localhost:8080/MobileSolutions/RemainingPhones?quantity="));
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
