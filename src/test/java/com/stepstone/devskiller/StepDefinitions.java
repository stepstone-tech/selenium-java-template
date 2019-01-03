package com.stepstone.devskiller;

import com.stepstone.devskiller.pages.GoogleHomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

  GoogleHomePage googleHomePage;
  private static WebDriver driver;
  private static WebDriverWait wait;

  @Given("^I am on google home page$")
  public void iAmOnHomePage() {
    driver.get("https://www.google.com");
    googleHomePage = new GoogleHomePage(driver);
  }

  @Before
  public void start() {
    File chromeDriver = new File("chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 15);

  }

  @After()
  public void closeBrowser() {
    driver.quit();
  }
}