package page_announcekit;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.naming.ldap.ExtendedRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import parallel.DriverFactory;

public class AnnouncekitPage {
	
	
	By whats_New = By.xpath("//*[@id='wrap']/header//div[contains(text(),\"What's New\")]");
	By iframe_CloseBtn = By.xpath("//*[@id=\"widget\"]/div/header/h1/div");
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By workroom_Side_Nav = By.xpath("//*[@id='wrap']//div[@class='atlas-leftnav atlas-l expanded']");


	public void verify_Workroom_Side_Nav() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Side_Nav)));
	}
	
	public void verify_WhatsNew_Link() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(whats_New)));
	}
	
	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}
	
	public void verify_Whats_New_Not_Visible() throws InterruptedException {
		String question1 = "//span[contains(text(),\"What's New\")]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(question1)).size() < 1);
		Thread.sleep(3000);
	}

	
	public void click_Whats_New() {
		DriverFactory.getInstance().getDriver().findElement(whats_New).click();
	}
	
	public void verify_Whats_New_Modal_And_Scroll() throws InterruptedException {
		
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[1]"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeThumbnail = DriverFactory.getInstance().getDriver().findElement(iframe_CloseBtn);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframeThumbnail)));
		
		WebElement iframeSection = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id='widget']//div/section//h1[contains(.,'Now available')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", iframeSection);
		Thread.sleep(1500);
		
		DriverFactory.getInstance().getDriver().findElement(iframe_CloseBtn).click();
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	
	public void open_Interact_With_WhatsNew() throws InterruptedException {
		this.click_Whats_New();
		Thread.sleep(2000);
		this.verify_Whats_New_Modal_And_Scroll();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> open_Interact_With_WhatsNew -----------");
	}
	
	
	
}
