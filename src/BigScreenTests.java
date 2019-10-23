import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;



public class BigScreenTests {
	
  private WebDriver driver;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");  
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void openVozenRedPage() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1552, 840));
    js.executeScript("window.scrollTo(0,1352)");
    driver.findElement(By.xpath("//*[@id=\"menu-item-3398\"]/a")).click();
    assertThat(driver.getTitle(), is("SatBUS Mk – ВОЗЕН РЕД"));
  }
  
  @Test
  public void openSatbusTravel() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.findElement(By.cssSelector("#mainnav > #menu-item-3507 > a")).click();
    driver.findElement(By.linkText("ЗА НАС")).click();
    js.executeScript("window.scrollTo(0,140.8000030517578)");
    driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click();
    {
      WebElement element = driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
  }
  @Test
  public void openZaNas() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1325, 773));
    driver.findElement(By.linkText("ЗА НАС")).click();
    assertThat(driver.getTitle(), is("SatBUS Mk – ЗА НАС"));
  }
  @Test
  public void openKontaktirajNe() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1325, 773));
    driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click();
    driver.findElement(By.cssSelector(".dismissButton")).click();
    assertThat(driver.getTitle(), is("SatBUS Mk – КОНТАКТИРАЈ НЕ"));
  }
  @Test
  public void openPogledni() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1325, 773));
    driver.findElement(By.cssSelector(".large > span")).click();
    assertThat(driver.getTitle(), is("SatBUS Mk – ВОЗЕН РЕД"));
  }
  @Test
  public void openLokalniLinii() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1326, 774));
    {
        WebElement element = driver.findElement(By.linkText("ВОЗЕН РЕД"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
      }
    driver.findElement(By.xpath("//*[@id=\"menu-item-3403\"]/a")).click();
    assertThat(driver.getTitle(), is("SatBUS Mk – Локални линии"));
  }
  @Test
  public void homeSearch() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1326, 774));
    driver.findElement(By.cssSelector(".search-pop-button")).click();
    driver.findElement(By.name("s")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("form > .toptip"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.name("s")).sendKeys("bosna");
    driver.findElement(By.cssSelector(".toptip > .fa-search")).click();
    assertThat(driver.findElement(By.cssSelector(".post_title > a")).getText(), is("BOSNA"));
  }
  @Test
  public void openMegjunarodniLinii() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1327, 775));
    {
        WebElement element = driver.findElement(By.linkText("ВОЗЕН РЕД"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
      }
    driver.findElement(By.xpath("//*[@id=\"menu-item-3399\"]/a")).click();
    assertThat(driver.getTitle(), is("SatBUS Mk – Meѓународни линии"));
  }
  @Test
  public void searchSkopje() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1552, 840));
    {
        WebElement element = driver.findElement(By.linkText("ВОЗЕН РЕД"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
      }
    driver.findElement(By.xpath("//*[@id=\"menu-item-3403\"]/a")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6bd6cd-6a32 input")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6bd6cd-6a32 input")).sendKeys("Скопје");
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6bd6cd-6a32 input")).sendKeys(Keys.ENTER);
    assertThat(driver.findElement(By.id("B3")).getText(), is("Скопје"));
  }
  @Test
  public void searchTirana() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1552, 840));
    {
        WebElement element = driver.findElement(By.linkText("ВОЗЕН РЕД"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
      }
    driver.findElement(By.xpath("//*[@id=\"menu-item-3399\"]/a")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b238f-8e9d input")).sendKeys("Тирана");
    assertThat(driver.findElement(By.id("B2")).getText(), is("Тирана"));
  }
  @Test
  public void showNotValidMessage() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click();
    driver.findElement(By.id("sendMessage")).click();
    assertThat(driver.findElement(By.cssSelector(".error-info")).getText(), is("Please fill out all fields."));
    driver.close();
  }
}
