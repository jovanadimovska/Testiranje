package MozillaFirefoxTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
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
			List<WebElement> elements = driver
					.findElements(By.xpath("//table[@id=\'supsystic-table-1\']/tbody/tr[2]/td"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void openLokalni() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(1550, 838));
		{
			WebElement element = driver.findElement(By.cssSelector(".icons-rss"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}
		driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
		assertThat(driver.getTitle(), is("SatBUS Mk – ВОЗЕН РЕД"));
	}

	@Test
	public void openSatbusTravel() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(1550, 838));
		driver.findElement(By.cssSelector("#mainnav > #menu-item-3507 > a")).click();
		assertThat(driver.getTitle(), is("SatBUS Mk – SATBUS Travel"));
	}

	@Test
	public void openKontakt() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(1550, 838));
		driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click();
		assertThat(driver.getTitle(), is("SatBUS Mk – КОНТАКТИРАЈ НЕ"));
	}

	@Test
	public void openMegjunarodni() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(1550, 838));
		driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
		driver.findElement(By.cssSelector(".section_row:nth-child(3)")).click();
		driver.findElement(By.cssSelector(".tabs-content")).click();
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".tabs-content"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void openZaNas() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(1550, 838));
		driver.findElement(By.linkText("ЗА НАС")).click();
		assertThat(driver.getTitle(), is("SatBUS Mk – ЗА НАС"));
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
		assertThat(driver.findElement(By.cssSelector(".dataTables_empty")).getText(),
				is("Градот не постои. Пробајте повторно со кирилица."));
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

	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}

	@Test
	public void showInvalidLink() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(1550, 838));
		driver.findElement(By.cssSelector("#mainnav > #menu-item-3507 > a")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".tbutton > span")).click();
		vars.put("win1881", waitForWindow(2000));
		vars.put("root", driver.getWindowHandle());
		driver.switchTo().window(vars.get("win1881").toString());
		driver.findElement(By.cssSelector("h1")).click();
		assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("404 Not Found"));
		driver.switchTo().window(vars.get("root").toString());
		driver.close();
		driver.switchTo().window(vars.get("win1881").toString());
	}

	@Test
	public void showNotValidContact() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(1550, 838));
		driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click();
		js.executeScript("window.scrollTo(0,92)");
		driver.findElement(By.id("sendMessage")).click();
		assertThat(driver.findElement(By.cssSelector(".error-info")).getText(), is("Please fill out all fields."));
		driver.findElement(By.cssSelector(".error-info")).click();
		driver.findElement(By.cssSelector(".error-info")).click();
	}

}
