package ru.stqa.onebrowther;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FFesr52old {
  //сначала установить esr52 в папку по умолчанию, сейчас там 55
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    FirefoxOptions options = new FirefoxOptions().setLegacy(true);// старая схема более явно
    driver = new FirefoxDriver(options);
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
