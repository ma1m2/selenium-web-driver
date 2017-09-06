package ru.stqa.searchelements;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertFalse;

public class SearchTest extends TestBase{

  @Test
  public void myFirstTest(){
    driver.navigate().to("https://www.google.ru");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    assertFalse(isElementPrestnt(By.name("XXX")));
  }
}
