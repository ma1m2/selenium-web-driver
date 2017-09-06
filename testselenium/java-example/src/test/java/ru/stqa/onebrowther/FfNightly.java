package ru.stqa.onebrowther;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FfNightly {
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
  /*  FirefoxOptions options = new FirefoxOptions().setLegacy(false);
    driver = new FirefoxDriver(options);//новая схема, более явно с версии 3.3*/
    FirefoxOptions options = new FirefoxOptions();
    options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")));
  //  options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Firefox Developer Edition\\firefox.exe")));
    driver = new FirefoxDriver(options);//path to Firefox Nightly
  //  System.out.println(((HasCapabilities)driver).getCapabilities());
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void test(){
    driver.get("https://www.google.ru");
    driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    wait.until(titleIs("webdriver - Поиск в Google"));
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
