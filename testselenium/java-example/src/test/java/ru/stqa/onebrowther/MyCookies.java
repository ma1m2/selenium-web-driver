package ru.stqa.onebrowther;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Set;

public class MyCookies {
  private WebDriver wd1;
  private WebDriver wd2;

  @Before
  public void start(){
  //  wd1 = new ChromeDriver();
  //  wd2 = new ChromeDriver();
    wd1 = new InternetExplorerDriver();
    wd2 = new InternetExplorerDriver();
  }

  @Test
  public void coocie(){
    wd1.get("https://selenium2.ru");
    wd2.get("https://selenium2.ru");
    System.out.print("#1 ");
    getCookies(wd1);
    System.out.print("#2 ");
    getCookies(wd2);
    wd1.manage().deleteAllCookies();
    System.out.print("#1 after deleted ");
    getCookies(wd1);
    System.out.print("#2 ");
    getCookies(wd2);
  }

  private void getCookies(WebDriver wd) {
    Set<Cookie> cookies = wd.manage().getCookies();
    System.out.println("Cookies: " + wd.toString());
    for (Cookie coo : cookies){
      System.out.println(coo.toString());
    }
  }

  @After
  public void stop(){
    wd1.quit();
    wd2.quit();
    wd1 = null;
    wd2 = null;
  }
}
