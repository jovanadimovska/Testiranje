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
<<<<<<< HEAD
	 private String FIREFOX_PATH = "E:\\Jovana\\Fakultet\\treta god\\vtor semestar\\skit\\geckodriver-v0.25.0-win64\\geckodriver.exe";
=======
	 private String FIREFOX_PATH = "Drivers//geckodriver.exe";
>>>>>>> a42267570215041ca8b823d46c99042ccee47936
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
	  
<<<<<<< HEAD
	  @Test
	  public void vozenRedPrebaruvanje() {
	    driver.get("http://satbus.mk/");
	    driver.manage().window().setSize(new Dimension(550, 692));
	    driver.findElement(By.cssSelector(".fa-bars")).click();
	    driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
	    driver.findElement(By.cssSelector(".grid_4:nth-child(1) span")).click();
	    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b input")).click();
	    {
	      WebElement element = driver.findElement(By.cssSelector(".icons-mail"));
	      Action builder = (Action) new Actions(driver);
	      ((Actions) builder).moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Action builder = (Action) new Actions(driver);
	      ((Actions) builder).moveToElement(element, 0, 0).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.cssSelector(".icons-mail"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Action builder = (Action) new Actions(driver);
	      ((Actions) builder).moveToElement(element, 0, 0).perform();
	    }
	    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b input")).sendKeys("скопје");
	  }
=======
>>>>>>> a42267570215041ca8b823d46c99042ccee47936
}
