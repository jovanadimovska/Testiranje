import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;



public class SmallScreen {
	
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
  public void openVozenRed() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(613, 775));
    driver.findElement(By.cssSelector(".fa-bars")).click();
    driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
    driver.close();
  }
  @Test
  public void openSatBusTravel() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(611, 774));
    driver.findElement(By.id("mobilepro")).click();
    driver.findElement(By.cssSelector("#mainnav > #menu-item-3507 > a")).click();
    assertThat(driver.getTitle(), is("SatBUS Mk – SATBUS Travel"));
    driver.close();
  }
  @Test
  public void openZaNas() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(611, 774));
    driver.findElement(By.cssSelector(".fa-bars")).click();
    driver.findElement(By.linkText("ЗА НАС")).click();
    js.executeScript("window.scrollTo(0,584)");
    assertThat(driver.getTitle(), is("SatBUS Mk – ЗА НАС"));
    driver.close();
  }
  @Test
  public void clickPogledni() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(611, 774));
    driver.findElement(By.xpath("//*[@id=\"post-197\"]/div[2]/div/div/div[2]/div/div[3]/a")).click();
    js.executeScript("window.scrollTo(0,1806.4000244140625)");
    driver.findElement(By.cssSelector(".large > span")).click();
    assertThat(driver.getTitle(), is("SatBUS Mk – ВОЗЕН РЕД"));
    driver.close();
  }
  @Test
  public void searchSkopje() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(611, 774));
    driver.findElement(By.cssSelector(".fa-bars")).click();
    driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b input")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b input")).sendKeys("Скопје");
    assertThat(driver.findElement(By.id("B3")).getText(), is("Скопје"));
    driver.close();
  }
  @Test
  public void searchBelgrad() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(611, 774));
    driver.findElement(By.cssSelector(".fa-bars")).click();
    driver.findElement(By.cssSelector(".fa-angle-down")).click();
    driver.findElement(By.linkText("Meѓународни линии")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b238f-8e9d input")).click();
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b238f-8e9d input")).sendKeys("Белград");
    assertThat(driver.findElement(By.id("B10")).getText(), is("Белград"));
    driver.close();
  }
  @Test
  public void showingValidMessage() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(611, 774));
    driver.findElement(By.id("mobilepro")).click();
    driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click();
    js.executeScript("window.scrollTo(0,143.1999969482422)");
    driver.findElement(By.id("sendMessage")).click();
    assertThat(driver.findElement(By.cssSelector(".error-info")).getText(), is("Please fill out all fields."));
    driver.close();
  }
}