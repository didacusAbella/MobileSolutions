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
 * @author diego
 */
public class EditProfileTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    private void repeatStep() {
        driver.get("http://localhost:8080/MobileSolutions/signin.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("umber");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("umber");
        WebElement form = driver.findElement(By.name("signinClient"));
        form.submit();
        driver.get("http://localhost:8080/MobileSolutions/EditProfile");
    }

    @Test
    public void testEditProfileUpdateOk() throws Exception {
        repeatStep();
        WebElement name = driver.findElement(By.name("name"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement taxCode = driver.findElement(By.name("taxCode"));
        WebElement address = driver.findElement(By.name("address"));
        WebElement cap = driver.findElement(By.name("cap"));
        WebElement city = driver.findElement(By.name("city"));
        WebElement mobilePhone = driver.findElement(By.name("mobilePhone"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement telPhone = driver.findElement(By.name("telPhone"));
        WebElement fax = driver.findElement(By.name("fax"));
        Select province = new Select(driver.findElement(By.name("province")));
        name.clear();
        name.sendKeys("Mario");
        lastName.clear();
        lastName.sendKeys("Rossi");
        address.clear();
        address.sendKeys("Via Roma 47");
        cap.clear();
        cap.sendKeys("83100");
        taxCode.clear();
        taxCode.sendKeys("FTMDCT55D68C135P");
        city.clear();
        city.sendKeys("Avellino");
        province.selectByIndex(0);
        telPhone.clear();
        telPhone.sendKeys("89341367");
        mobilePhone.clear();
        mobilePhone.sendKeys("3315807943");
        fax.clear();
        fax.sendKeys("334567980");
        email.clear();
        email.sendKeys("verylongemail@mail.com");
        WebElement submitform = driver.findElement(By.name("editProfile"));
        submitform.submit();
        Assert.assertTrue(driver.getPageSource().contains("Aggiorna il tuo profilo"));
        driver.close();
    }

    @Test
    public void testEditProfileNameLength() {
        repeatStep();
        WebElement name = driver.findElement(By.name("name"));
        name.clear();
        name.sendKeys("abcdefghailmnopqrstuvz");
        Assert.assertNotEquals(name.getText(), "abcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileNamePattern() {
        repeatStep();
        WebElement name = driver.findElement(By.name("name"));
        name.clear();
        name.sendKeys("ant10");
        Assert.assertTrue(driver.getPageSource().contains("Il campo nome deve contenere solo lettere"));
        driver.close();

    }

    @Test
    public void testEditProfileLastNamePattern() {
        repeatStep();
        WebElement name = driver.findElement(By.name("lastName"));
        name.clear();
        name.sendKeys("Ross1");
        Assert.assertTrue(driver.getPageSource().contains("Il campo cognome deve contenere solo lettere"));
        driver.close();

    }

    @Test
    public void testEditProfileLastNameLength() {
        repeatStep();
        WebElement name = driver.findElement(By.name("lastName"));
        name.clear();
        name.sendKeys("abcdefghailmnopqrstuvz");
        Assert.assertNotEquals(name.getText(), "abcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileTaxCodeLength() {
        repeatStep();
        WebElement code = driver.findElement(By.name("taxCode"));
        code.clear();
        code.sendKeys("FTMDCT55D68C135PFTMDCT55D68C135P");
        Assert.assertNotEquals(code.getText(), "FTMDCT55D68C135PFTMDCT55D68C135P");
        driver.close();
    }

    @Test
    public void testEditProfileTaxCodePattern() {
        repeatStep();
        WebElement code = driver.findElement(By.name("taxCode"));
        code.clear();
        code.sendKeys("@()+*-+.");
        Assert.assertTrue(driver.getPageSource().contains("Il campo codice fiscale deve caratteri alfanumerici"));
        driver.close();

    }

    @Test
    public void testEditProfileAddressLength() {
        repeatStep();
        WebElement element = driver.findElement(By.name("address"));
        element.clear();
        element.sendKeys("abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        Assert.assertNotEquals(element.getText(), "abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileAddressPattern() {
        repeatStep();
        WebElement element = driver.findElement(By.name("address"));
        element.clear();
        element.sendKeys("Via Rom@ 4+");
        Assert.assertTrue(driver.getPageSource().contains("Il campo indirizzo deve contenere solo lettere"));
        driver.close();

    }

    @Test
    public void testEditProfileCapPattern() {
        repeatStep();
        WebElement element = driver.findElement(By.name("cap"));
        element.clear();
        element.sendKeys("1500000");
        Assert.assertTrue(driver.getPageSource().contains("Il campo CAP deve contenere solo numeri"));
        driver.close();

    }

    @Test
    public void testEditProfileCapLength() {
        repeatStep();
        WebElement element = driver.findElement(By.name("cap"));
        element.clear();
        element.sendKeys("88888888");
        Assert.assertNotEquals(element.getText(), "Helloooo");
        driver.close();
    }

    @Test
    public void testEditProfileCityPattern() {
        repeatStep();
        WebElement element = driver.findElement(By.name("city"));
        element.clear();
        element.sendKeys("Ave15646512");
        Assert.assertTrue(driver.getPageSource().contains("Il campo città deve contenere solo lettere"));
        driver.close();

    }

    @Test
    public void testEditProfileCityLength() {
        repeatStep();
        WebElement element = driver.findElement(By.name("city"));
        element.clear();
        element.sendKeys("abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        Assert.assertNotEquals(element.getText(), "abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileTelPhonePattern() {
        repeatStep();
        WebElement element = driver.findElement(By.name("telPhone"));
        element.clear();
        element.sendKeys("0893413f67");
        Assert.assertTrue(driver.getPageSource().contains("Il campo telefono deve contenere solo numeri"));
        driver.close();
    }

    @Test
    public void testEditProfileTelPhoneLength() {
        repeatStep();
        WebElement element = driver.findElement(By.name("telPhone"));
        element.clear();
        element.sendKeys("abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        Assert.assertNotEquals(element.getText(), "abcdefghailmnopqrstuvzabcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        driver.close();
    }

    @Test
    public void testEditProfileMobilePhonePattern() {
        repeatStep();
        WebElement element = driver.findElement(By.name("mobilePhone"));
        element.clear();
        element.sendKeys("331580794d");
        Assert.assertTrue(driver.getPageSource().contains("Il campo telefono deve contenere solo numeri"));
        driver.close();
    }

    @Test
    public void testEditProfileMobilePhoneLength() {
        repeatStep();
        WebElement element = driver.findElement(By.name("mobilePhone"));
        element.clear();
        element.sendKeys("3315807943245");
        Assert.assertNotEquals(element.getText(), "3315807943245");
        driver.close();
    }

    @Test
    public void testEditProfileFaxPattern() {
        repeatStep();
        WebElement element = driver.findElement(By.name("fax"));
        element.sendKeys("33456798W");
        Assert.assertTrue(driver.getPageSource().contains("Il campo fax deve contenere solo numeri"));
        driver.close();

    }

    @Test
    public void testEditProfileFaxLength() {
        repeatStep();
        WebElement element = driver.findElement(By.name("fax"));
        element.clear();
        element.sendKeys("3345679801235");
        Assert.assertNotEquals(element.getText(), "3345679801235");
        driver.close();
    }

    @Test
    public void testEditProfileEmailPattern() {
        repeatStep();
        WebElement element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys("verylongemail.com");
        Assert.assertTrue(driver.getPageSource().contains("Il campo email non è valido"));
        driver.close();

    }

    @Test
    public void testEditProfileEmailLength() {
        repeatStep();
        WebElement element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys("verylongestemailevercreated@mail.com");
        Assert.assertNotEquals(element.getText(), "verylongestemailevercreated@mail.com");
        driver.close();
    }

}
