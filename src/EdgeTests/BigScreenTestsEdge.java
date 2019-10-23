package EdgeTests;


import org.junit.Test;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;



public class BigScreenTestsEdge {
	
  private WebDriver driver;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.edge.driver", "Drivers\\MicrosoftWebDriver.exe");  
    driver = new EdgeDriver();
    js = (JavascriptExecutor) driver;
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void openKontaktirajNe() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1325, 773));
    driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click(); 
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    driver.findElement(By.cssSelector(".dismissButton")).click();
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    assertThat(driver.getTitle(), is("SatBUS Mk – КОНТАКТИРАЈ НЕ"));
  }
  @Test
  public void openPogledni() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1325, 773));
    driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    assertThat(driver.getTitle(), is("SatBUS Mk – ВОЗЕН РЕД"));
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
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    driver.findElement(By.xpath("//*[@id=\"menu-item-3399\"]/a")).click();try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
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
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    driver.findElement(By.xpath("//*[@id=\"menu-item-3403\"]/a")).click();
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6bd6cd-6a32 input")).click();
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6bd6cd-6a32 input")).sendKeys("Скопје");
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6bd6cd-6a32 input")).sendKeys(Keys.ENTER);
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    assertThat(driver.findElement(By.id("B3")).getText(), is("Скопје"));
  }
  @Test
  public void showNotValidMessage() {
    driver.get("http://satbus.mk/");
    driver.manage().window().setSize(new Dimension(1552, 840));
    driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click();
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    driver.findElement(By.id("sendMessage")).click();
    try {
		Thread.sleep(9000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	};
    assertThat(driver.findElement(By.cssSelector(".error-info")).getText(), is("Please fill out all fields."));
    driver.close();
  }
}
