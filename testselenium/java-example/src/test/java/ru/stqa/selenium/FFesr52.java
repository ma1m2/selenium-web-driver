package ru.stqa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FFesr52 {
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    //driver = new ChromeDriver();
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(FirefoxDriver.MARIONETTE, true);
    driver = new FirefoxDriver(caps);
    System.out.println(((HasCapabilities)driver).getCapabilities());
    wait = new  WebDriverWait(driver,10);
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
