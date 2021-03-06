package ru.stqa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.security.Key;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstClass {
  private WebDriver driver;
  private WebDriverWait wait;
  //private WebElement q;

  @Before
  public void start() {
  //  driver = new InternetExplorerDriver();//Убрать галочку Включить защищенный режим для всех 4-х зон.
  /*  DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("marionette", "false");
    driver = new FirefoxDriver(caps);*/
  /*  FirefoxOptions options = new FirefoxOptions().setLegacy(true);//false
    WebDriver driver = new FirefoxDriver(options);*/
    driver = new FirefoxDriver();
  //  driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    //if Se cannot findElement at once, it will wait 10 seconds
    wait = new WebDriverWait(driver, 20);
  }

  @Test
  public void myFirstTest() {
    driver.get("https://www.google.ru");
    /*    driver.findElement(By.id("gs_ok0")).click();//opening screen keyboard
        driver.findElement(By.id("K32")).click();
        driver.findElement(By.id("gs_ok0")).click();//closing screen keyboard
        driver.findElement(By.id("K32")).click();*/
    /*    q = driver.findElement(By.name("q"));
      System.out.println("Нашли : " + q);
        driver.navigate().refresh();
        q.sendKeys("webdriver" + Keys.ENTER);*/
    driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    wait.until(titleIs("webdriver - Поиск в Google"));
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
