package ru.stqa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class PathWebDriver {
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    ChromeOptions options = new ChromeOptions();
    options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
    //указываем полный путь к файлу запуска браузера
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void testPathToDriver(){
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
