package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Domenico Antonio Tropeano on 25/02/2018 at 14:56
 * @project MobileSolutions
 */
public class BuyCart {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    public void addToCart(){
        loginClient();
        driver.get("http://localhost:8080/MobileSolutions/PhoneDetails?id=1");
        driver.get("http://localhost:8080/MobileSolutions/AddToCart?idProduct=2");

       //WebElement addToCartBtn=driver.findElement(By.name())
    }

    private void loginClient(){
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("cane");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("cane");
        WebElement form = driver.findElement(By.name("signinClient"));
        form.submit();
    }
}
