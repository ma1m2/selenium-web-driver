package ru.stqa.selenium;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FFesr52 {
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start(){
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(FirefoxDriver.MARIONETTE, false);
    driver = new FirefoxDriver(caps);

  }
}
