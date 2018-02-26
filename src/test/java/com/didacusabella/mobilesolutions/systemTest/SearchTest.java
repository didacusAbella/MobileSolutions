package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Domenico Antonio Tropeano on 26/02/2018 at 19:00
 * @project MobileSolutions
 */
public class SearchTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    @Test
    public void testSearchOk() {
        WebElement searchBox = driver.findElements(By.name("brand")).get(0);
        searchBox.sendKeys("Samsung");
        WebElement formSearch = driver.findElement(By.name("search"));
        formSearch.submit();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8080/MobileSolutions/Search?brand=Samsung");
        driver.close();
    }

    @Test
    public void testSearchLong() {
        WebElement searchBox = driver.findElements(By.name("brand")).get(0);
        searchBox.sendKeys("SamsungSamsungSamsungSamsungSamsung");
        Assert.assertNotEquals(searchBox.getText(), "SamsungSamsungSamsungSamsungSamsung");
        driver.close();
    }

    @Test
    public void testSearchBad() {
        WebElement searchBox = driver.findElements(By.name("brand")).get(0);
        searchBox.sendKeys("S@mSùn6_");
        WebElement btnSearch = driver.findElement(By.name("searchButton"));
        btnSearch.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8080/MobileSolutions/");
        driver.close();
    }

}
