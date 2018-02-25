package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

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
}
