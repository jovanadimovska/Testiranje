package MozillaFirefoxTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SmallScreenTests {
	 private WebDriver driver;
	 private String FIREFOX_PATH = "Drivers//geckodriver.exe";
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
		System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);  
	    driver = new FirefoxDriver();
	    js = (JavascriptExecutor) driver;
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  
}
