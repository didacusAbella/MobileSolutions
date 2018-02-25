package com.didacusabella.mobilesolutions.systemTest;

import com.didacusabella.mobilesolutions.testutilities.SeleniumDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Domenico Antonio Tropeano on 25/02/2018 at 17:11
 * @project MobileSolutions
 */
public class AddSmartphoneTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = SeleniumDriverFactory.createDriver("chrome");
        driver.get("http://localhost:8080/MobileSolutions/");
    }

    @Test
    public void testAddSmartphoneOK() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertTrue(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneBrandLong() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("abcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneBrandBad() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Mot0roL5 @");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneModelLong() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("abcdefghailmnopqrstuvzabcdefghailmnopqrstuvz");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneModelBad() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("L1T3 @");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testDisplayInchLong() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("45454554.515165156111514564");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneDisplayInchBad() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("5)4@");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneOSLong() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("AndroidAndroidAndroidAndroidAndroidAndroid");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneOSBad() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("i@S<>");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneCPULong() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("Athonbestcupevercreatedsssssssssssss");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneCPUBad() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("SpanDrag@n");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneRamLong() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("123");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneRamBad() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("-10");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneInternalStorageLong() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1234");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneInternalStorageBad() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("-152");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphoneCameraLong() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("10000000");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphonePriceLong() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("1200000000000");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }

    @Test
    public void testAddSmartphonePriceBad() {
        loginAdmin();
        driver.get("http://localhost:8080/MobileSolutions/AddSmartphone");
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
        brand.sendKeys("Sony Ericsson");
        model.sendKeys("Xperia X10");
        cpu.sendKeys("800Mhz");
        quantity.sendKeys("100");
        ram.sendKeys("1");
        internalStorage.sendKeys("1");
        camera.sendKeys("3");
        displayInch.sendKeys("3.2");
        os.sendKeys("Android");
        bluetooth.click();
        price.sendKeys("-120");
        WebElement form = driver.findElement(By.name("addSmartphone"));
        form.submit();
        Assert.assertFalse(driver.getPageSource().contains("Lista Modelli"));
        driver.close();
    }


    private void loginAdmin() {
        driver.get("http://localhost:8080/MobileSolutions/administration.jsp");
        WebElement usernameStuff = driver.findElements(By.name("username")).get(0);
        usernameStuff.sendKeys("gestore");
        WebElement passwordStuff = driver.findElements(By.name("password")).get(0);
        passwordStuff.sendKeys("gestore");
        WebElement form = driver.findElement(By.name("LoginAdmin"));
        form.submit();
    }
}
