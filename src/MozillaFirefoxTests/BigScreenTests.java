package MozillaFirefoxTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
public class BigScreenTests {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void openVozenRed() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1550, 838));
    driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
    driver.findElement(By.cssSelector(".tabs-content")).click();
    driver.findElement(By.cssSelector(".tabs-content")).click();
    driver.findElement(By.cssSelector(".section_row:nth-child(3)")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//table[@id=\'supsystic-table-1\']/tbody/tr[2]/td"));
      assert(elements.size() > 0);
    }
  }
  
  @Test
  public void searchLatinica() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1550, 838));
    {
      WebElement element = driver.findElement(By.cssSelector(".icons-social-facebook"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b input")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b input")).sendKeys("skopje");
    driver.findElement(By.id("supsystic-table-1_wrapper")).click();
    driver.findElement(By.cssSelector(".dataTables_empty")).click();
    driver.findElement(By.cssSelector(".dataTables_empty")).click();
    assertThat(driver.findElement(By.cssSelector(".dataTables_empty")).getText(), is("Градот не постои. Пробајте повторно со кирилица."));
  }
  
  @Test
  public void searchTirana() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1550, 838));
    driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b238f-8e9d input")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b238f-8e9d input")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b238f-8e9d input")).sendKeys("Тирана");
    assertThat(driver.findElement(By.id("B2")).getText(), is("Тирана"));
  }

  @Test
  public void searchSkopje() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1550, 838));
    driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b input")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b input")).sendKeys("Скопје");
    {
      WebElement element = driver.findElement(By.id("B3"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    assertThat(driver.findElement(By.id("B3")).getText(), is("Скопје"));
  }
  	
}
