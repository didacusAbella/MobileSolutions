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
 * @author Domenico Antonio Tropeano on 26/02/2018 at 16:42
 * @project MobileSolutions
 */
public class SignupTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/signup.jsp");

    }

    @Test
    public void testSignupOk() {
        WebElement name = driver.findElement(By.name("name"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement taxCode = driver.findElement(By.name("taxCode"));
        WebElement address = driver.findElement(By.name("address"));
        WebElement cap = driver.findElement(By.name("cap"));
        WebElement city = driver.findElement(By.name("city"));
        WebElement mobilePhone = driver.findElement(By.name("mobilePhone"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement telPhone = driver.findElement(By.name("telPhone"));
        WebElement fax = driver.findElement(By.name("fax"));
        Select province = new Select(driver.findElement(By.name("province")));
        name.sendKeys("Carmine");
        lastName.sendKeys("Viola");
        address.sendKeys("Via Roma 47");
        cap.sendKeys("83100");
        taxCode.sendKeys("FTMDCT55D68C135P");
        city.sendKeys("Avellino");
        province.selectByIndex(0);
        telPhone.sendKeys("89341367");
        mobilePhone.sendKeys("3315807943");
        fax.sendKeys("334567980");
        email.sendKeys("carmineilgrande@mail.com");
        username.sendKeys("Carmine");
        password.sendKeys("Il Grande");
        WebElement form = driver.findElement(By.name("signup"));
        form.submit();
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("Carmine");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("Il Grande");
        WebElement form1 = driver.findElement(By.name("signinClient"));
        form1.submit();
        boolean logged = driver.getPageSource().contains("Benvenuto");
        Assert.assertTrue(logged);
        driver.close();
    }
    @Test
    public void testEditProfileNameLength() {
        
        WebElement name = driver.findElement(By.name("name"));
        name.clear();
        name.sendKeys("abcdefghailmnopqrstuvz");
        Assert.assertNotEquals(name.getText(), "abcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileNamePattern() {
        
        WebElement name = driver.findElement(By.name("name"));
        name.clear();
        name.sendKeys("ant10");
        Assert.assertTrue(driver.getPageSource().contains("Il campo nome deve contenere solo lettere"));
        driver.close();

    }

    @Test
    public void testEditProfileLastNamePattern() {
        
        WebElement name = driver.findElement(By.name("lastName"));
        name.clear();
        name.sendKeys("Ross1");
        Assert.assertTrue(driver.getPageSource().contains("Il campo cognome deve contenere solo lettere"));
        driver.close();

    }

    @Test
    public void testEditProfileLastNameLength() {
        
        WebElement name = driver.findElement(By.name("lastName"));
        name.clear();
        name.sendKeys("abcdefghailmnopqrstuvz");
        Assert.assertNotEquals(name.getText(), "abcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileTaxCodeLength() {
        
        WebElement code = driver.findElement(By.name("taxCode"));
        code.clear();
        code.sendKeys("FTMDCT55D68C135PFTMDCT55D68C135P");
        Assert.assertNotEquals(code.getText(), "FTMDCT55D68C135PFTMDCT55D68C135P");
        driver.close();
    }

    @Test
    public void testEditProfileTaxCodePattern() {
        
        WebElement code = driver.findElement(By.name("taxCode"));
        code.clear();
        code.sendKeys("@()+*-+.");
        Assert.assertTrue(driver.getPageSource().contains("Il campo codice fiscale deve caratteri alfanumerici"));
        driver.close();

    }

    @Test
    public void testEditProfileAddressLength() {
        
        WebElement element = driver.findElement(By.name("address"));
        element.clear();
        element.sendKeys("abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        Assert.assertNotEquals(element.getText(), "abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileAddressPattern() {
        
        WebElement element = driver.findElement(By.name("address"));
        element.clear();
        element.sendKeys("Via Rom@ 4+");
        Assert.assertTrue(driver.getPageSource().contains("Il campo indirizzo deve contenere solo lettere"));
        driver.close();

    }

    @Test
    public void testEditProfileCapPattern() {
        
        WebElement element = driver.findElement(By.name("cap"));
        element.clear();
        element.sendKeys("1500000");
        Assert.assertTrue(driver.getPageSource().contains("Il campo CAP deve contenere solo numeri"));
        driver.close();

    }

    @Test
    public void testEditProfileCapLength() {
        
        WebElement element = driver.findElement(By.name("cap"));
        element.clear();
        element.sendKeys("88888888");
        Assert.assertNotEquals(element.getText(), "Helloooo");
        driver.close();
    }

    @Test
    public void testEditProfileCityPattern() {
        
        WebElement element = driver.findElement(By.name("city"));
        element.clear();
        element.sendKeys("Ave15646512");
        Assert.assertTrue(driver.getPageSource().contains("Il campo città deve contenere solo lettere"));
        driver.close();

    }

    @Test
    public void testEditProfileCityLength() {
        
        WebElement element = driver.findElement(By.name("city"));
        element.clear();
        element.sendKeys("abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        Assert.assertNotEquals(element.getText(), "abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileTelPhonePattern() {
        
        WebElement element = driver.findElement(By.name("telPhone"));
        element.clear();
        element.sendKeys("0893413f67");
        Assert.assertTrue(driver.getPageSource().contains("Il campo telefono deve contenere solo numeri"));
        driver.close();
    }

    @Test
    public void testEditProfileTelPhoneLength() {
        
        WebElement element = driver.findElement(By.name("telPhone"));
        element.clear();
        element.sendKeys("abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        Assert.assertNotEquals(element.getText(), "abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileMobilePhonePattern() {
        
        WebElement element = driver.findElement(By.name("mobilePhone"));
        element.clear();
        element.sendKeys("331580794d");
        Assert.assertTrue(driver.getPageSource().contains("Il campo telefono deve contenere solo numeri"));
        driver.close();
    }

    @Test
    public void testEditProfileMobilePhoneLength() {
        
        WebElement element = driver.findElement(By.name("mobilePhone"));
        element.clear();
        element.sendKeys("3315807943245");
        Assert.assertNotEquals(element.getText(), "3315807943245");
        driver.close();
    }

    @Test
    public void testEditProfileFaxPattern() {
        
        WebElement element = driver.findElement(By.name("fax"));
        element.sendKeys("33456798W");
        Assert.assertTrue(driver.getPageSource().contains("Il campo fax deve contenere solo numeri"));
        driver.close();

    }

    @Test
    public void testEditProfileFaxLength() {
        
        WebElement element = driver.findElement(By.name("fax"));
        element.clear();
        element.sendKeys("3345679801235");
        Assert.assertNotEquals(element.getText(), "3345679801235");
        driver.close();
    }

    @Test
    public void testEditProfileEmailPattern() {
        
        WebElement element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys("verylongemail.com");
        Assert.assertTrue(driver.getPageSource().contains("Il campo email non è valido"));
        driver.close();

    }

    @Test
    public void testEditProfileEmailLength() {
        
        WebElement element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys("verylongestemailevercreated@mail.com");
        Assert.assertNotEquals(element.getText(), "verylongestemailevercreated@mail.com");
        driver.close();
    }

}
