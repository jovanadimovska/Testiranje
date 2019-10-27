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

public class SmallScreenTests {
	private WebDriver driver;
	private Map<String, Object> vars;
	private String FIREFOX_PATH = "Drivers//geckodriver.exe";
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", FIREFOX_PATH);
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void openKontaktSmallTest() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(616, 701));
		driver.findElement(By.cssSelector(".fa-bars")).click();
		driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click();
		assertThat(driver.getTitle(), is("SatBUS Mk – КОНТАКТИРАЈ НЕ"));
	}

	@Test
	public void openLokalni() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(688, 651));
		driver.findElement(By.cssSelector(".fa-bars")).click();
		driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
		driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b input")).click();
		assertThat(driver.getTitle(), is("SatBUS Mk – ВОЗЕН РЕД"));
	}

	@Test
	public void openMegjunarodni() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(688, 651));
		driver.findElement(By.cssSelector(".fa-bars")).click();
		driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
		driver.findElement(By.cssSelector(".section_row:nth-child(3)")).click();
		driver.findElement(By.cssSelector(".tabs-content")).click();
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".tabs-content"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void openSatBusTravel() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(589, 603));
		driver.findElement(By.id("mobilepro")).click();
		driver.findElement(By.cssSelector("#mainnav > #menu-item-3507 > a")).click();
		assertThat(driver.getTitle(), is("SatBUS Mk – SATBUS Travel"));
	}

	@Test
	public void openVozenRedSmall() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(448, 701));
		driver.findElement(By.cssSelector(".fa-bars")).click();
		driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
		assertThat(driver.getTitle(), is("SatBUS Mk – ВОЗЕН РЕД"));
	}

	@Test
	public void openZaNas() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(616, 701));
		driver.findElement(By.cssSelector(".fa-bars")).click();
		driver.findElement(By.linkText("ЗА НАС")).click();
		assertThat(driver.getTitle(), is("SatBUS Mk – ЗА НАС"));
	}

	@Test
	public void searchLatinica() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(880, 701));
		driver.findElement(By.cssSelector(".fa-bars")).click();
		driver.findElement(By.cssSelector(".fa-angle-down")).click();
		driver.findElement(By.linkText("Meѓународни линии")).click();
		driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b238f-8e9d input")).click();
		driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b238f-8e9d input")).sendKeys("tirana");
		driver.findElement(By.cssSelector("#t-1441921988-1-38cda2-ca6b238f-8e9d input")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".dataTables_empty")).click();
		assertThat(driver.findElement(By.cssSelector(".dataTables_empty")).getText(),
				is("Градот не постои. Пробајте повторно со кирилица."));
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
	public void searchSkopje() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(339, 701));
		driver.findElement(By.cssSelector(".fa-bars")).click();
		{
			WebElement element = driver.findElement(By.linkText("ВОЗЕН РЕД"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.linkText("ВОЗЕН РЕД")).click();
		driver.findElement(By.cssSelector(".grid_4:nth-child(1) span")).click();
		driver.findElement(By.linkText("Петок")).click();
		driver.findElement(By.cssSelector("#t-1441922686905-4-4cda2-ca6b input")).click();
		driver.findElement(By.cssSelector("#t-1441922686905-4-4cda2-ca6b input")).sendKeys("скопје");
		driver.findElement(By.cssSelector("#t-1441922686905-4-4cda2-ca6b input")).sendKeys(Keys.ENTER);
		{
			List<WebElement> elements = driver.findElements(By.cssSelector(".tabs-content"));
			assert (elements.size() > 0);
		}
	}

	@Test
	public void showInvalidLink() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(638, 578));
		driver.findElement(By.cssSelector(".fa-bars")).click();
		driver.findElement(By.cssSelector("#mainnav > #menu-item-3507 > a")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".tbutton > span")).click();
		vars.put("win7357", waitForWindow(2000));
		driver.switchTo().window(vars.get("win7357").toString());
		assertThat(driver.getTitle(), is("404 Not Found"));
	}

	@Test
	public void showNotValidContact() {
		driver.get("http://satbus.mk/");
		driver.manage().window().setSize(new Dimension(586, 653));
		js.executeScript("window.scrollTo(0,0)");
		driver.findElement(By.cssSelector(".fa-bars")).click();
		driver.findElement(By.linkText("КОНТАКТИРАЈ НЕ")).click();
		js.executeScript("window.scrollTo(0,289.6000061035156)");
		driver.findElement(By.id("sendMessage")).click();
		js.executeScript("window.scrollTo(0,372.79998779296875)");
		assertThat(driver.findElement(By.cssSelector(".error-info")).getText(), is("Please fill out all fields."));
	}

}