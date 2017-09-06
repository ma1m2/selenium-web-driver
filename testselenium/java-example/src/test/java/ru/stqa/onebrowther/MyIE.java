package ru.stqa.onebrowther;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyIE {
  WebDriver driver;
  WebDriverWait wait;
  DesiredCapabilities caps;

  @Before
  public void start(){
    caps = new DesiredCapabilities();
    caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
    driver = new InternetExplorerDriver(caps);
  //  driver = new InternetExplorerDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void test(){
    driver.get("https://www.google.ru");
    driver.findElement(By.name("q")).sendKeys("webdriver" + Keys.ENTER);
    wait.until(titleIs("webdriver - Поиск в Google"));
  }

  @After()
  public void stop(){
    driver.quit();
    driver = null;
  }
}
