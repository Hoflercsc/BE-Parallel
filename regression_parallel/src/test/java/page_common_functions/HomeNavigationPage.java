package page_common_functions;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import parallel.DriverFactory;
import tests_workroom_home.BaseTestWorkroomHome;

public class HomeNavigationPage {
	
	// ---------Settings ------
	By settings = By.xpath("//span[contains(text(),'Settings')]");
	By eventsMenu = By.xpath("//span[@class='icon icon_wr-events active-off']");
	By newEventBtn = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Event')]");
	By event_Form_Title = By.xpath("//input[@id='event_title']");
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	String form_Title_Name = " This is a New Event Title ";

	public void verify_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings)));
	}
	
	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void click_Settings() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(settings).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(),'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// ---------Functions being called -----------------------
	public void user_Can_Open_Settings() throws InterruptedException {
		this.verify_Settings();
		this.click_Settings();
		System.out.println("------- Completed --> user_Can_Open_Settings() -----------");
	}
	
	// ---------Directory ------------------------------------
	By directory = By.xpath("//span[contains(text(),'Directory')]");
	By close_Directory = By.xpath("//div[@id='directoryModal']//a[@class='atlas-close pull-right']");

	public void verify_Directory() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(directory)));
	}

	public void click_Directory() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(directory).click();
	}

	// ---------Functions being called ---------------------------
	public void user_Can_Open_Directory() throws InterruptedException {
		this.verify_Directory();
		this.click_Directory();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Open_Settings() -----------");
	}
	
	// ---------user_Can_Open_Directory_Spanish --------------------
	By directory_s = By.xpath("//span[contains(text(),'Directorio')]");
	By close_Directory_s = By.xpath("//div[@id='directoryModal']//a[@class='atlas-close pull-right']");

	public void verify_Directory_Spanish() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(directory_s)));
	}

	public void click_Directory_Spanish() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(directory_s).click();
	}

	// ---------Functions being called ------
	public void user_Can_Open_Directory_Spanish() throws InterruptedException {
		this.verify_Directory_Spanish();
		this.click_Directory_Spanish();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Open_Settings() -----------");
	}
	
	// ---------user_Close_Directory ------
	public void verify_Directory_Close_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(close_Directory)));
	}

	public void click_Close_Directory() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(close_Directory).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='directoryModal']//a[@class='atlas-close pull-right']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	// ---------------Functions Being Called ------------------
	public void user_Close_Directory() throws InterruptedException {
		this.verify_Directory_Close_Btn();
		this.click_Close_Directory();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Close_Directory() -----------");
	}
	
	// ---------------user_Close_Directory_Profile ------------
	By profile_Modal = By.xpath("//div[@id='profileModal']//a[@class='atlas-close pull-right']");
	
	public void verify_Directory_Profile_Close_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_Modal)));
	}

	public void click_Close_Directory_Profile() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(profile_Modal).click();
	}
	
	// ---------------Functions Being Called ------------------
	public void user_Close_Directory_Profile() throws InterruptedException {
		this.verify_Directory_Profile_Close_Btn();
		this.click_Close_Directory_Profile();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Close_Directory_Profile() -----------");
	}
	
	// ----------------user_Close_Settings ----------
	By close_Settings = By.xpath("//div[@id='settingsModal']//a[@id='settingsModalClose']");

	public void verify_Settings_Close_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(close_Settings)));
	}
	
	public void click_Close_Settings() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(close_Settings).click();
	}
	
	// ---------Functions being called ------
	public void user_Close_Settings() throws InterruptedException {
		this.verify_Settings_Close_Btn();
		this.click_Close_Settings();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Close_Directory() -----------");
	}
}
