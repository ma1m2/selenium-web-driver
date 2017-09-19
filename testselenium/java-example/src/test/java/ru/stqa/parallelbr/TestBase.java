package ru.stqa.parallelbr;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

  public static WebDriver driver;//драйвер объявлен как singlton
  public static WebDriverWait wait;

  @Before
  public void start(){
    if (driver != null){
      return;
    }
    driver = new FirefoxDriver();
    System.out.println(((HasCapabilities) driver).getCapabilities());
    wait = new WebDriverWait(driver, 10);

    //фрагмент кода д.б. выполнен в самом конце, чтобы закрыть драйвер
    Runtime.getRuntime().addShutdownHook(
            new Thread(()-> {driver.quit(); driver = null;}));
  }

  @After
  public void stop(){
  //  driver.quit();
  //  driver = null;
  }
}
