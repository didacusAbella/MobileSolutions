package com.didacusabella.mobilesolutions.testutilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

/**
 *
 * @author didacusAbella
 */
public class SeleniumDriverFactory {
  
  private static final String CHROME_DRIVER_PATH = "D:\\Documenti\\chromedriver_win32\\chromedriver.exe";
  private static final String OPERA_BINARY_PATH = "C:\\Program Files\\Opera\\50.0.2762.67\\opera.exe";
  private static final String OPERA_DRIVER_PATH = "C:\\Users\\Diequ\\operadriver_win64\\operadriver.exe";
  private static final String FIREFOX_DRIVER_PATH = "/home/diego/Scaricati/geckodriver";
  
  public static WebDriver createDriver(String browser){
    switch(browser){
      case "opera":
        OperaOptions operaOptions = new OperaOptions();
        operaOptions.setBinary(OPERA_BINARY_PATH);
        System.setProperty("webdriver.opera.driver", OPERA_DRIVER_PATH);
        return new OperaDriver(operaOptions);
      case "firefox":
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        return new FirefoxDriver(firefoxOptions);
      default:
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }
  }
}
