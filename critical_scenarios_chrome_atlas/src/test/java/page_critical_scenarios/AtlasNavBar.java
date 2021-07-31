package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;

public class AtlasNavBar {
	WebDriver driver;

	public AtlasNavBar(WebDriver driver) {
		this.driver = driver;
	}
	
	// ----------- Atlas Left Nav Bar -----------------------------
	//By atlas_Left_Nav = By.xpath("//*[@id='wrap']//div[@class='atlas-leftnav expanded atlas-l']");
	By atlas_Left_Nav = By.xpath("//*[@id='wrap']//div[@class='atlas-leftnav atlas-l expanded']");
	By workrooms = By.xpath("//li[@id='workroom-leftnav-toggle']");
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By library = By.xpath("//span[contains(text(),'Library')]");
	By new_Book = By.xpath("//a[@class='btn btn-success no-mobile'][contains(text(),'New Book')]");
	By mesage_Workroom = By.xpath("//a[contains(text(),'Message Workroom')]");

	public void verify_Atlas_Left_Nav() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(atlas_Left_Nav)));
	}

	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void verify_Libary() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library)));
	}

	public void verify_New_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Book)));
	}
	
	public void verify_Mesage_Workroom() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mesage_Workroom)));
	}

	public void click_Workrooms() {
		driver.findElement(workrooms).click();
	}
	
	public void click_AutoBE() {
		driver.findElement(autoBE).click();
	}

	public void click_Library() {
		driver.findElement(library).click();
	}

	// ---------------Function Being Called------------------------------------------
	public void admin_Open_Workroom_AutoBE_Library_Page() throws InterruptedException {
		this.verify_Atlas_Left_Nav();
		this.click_Workrooms();
		Thread.sleep(1000);
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_New_Book();
		System.out.println("------- Completed --> open_Workroom_AutoBE_Library_Page() -----------");
	}
	
	public void workroom_Member_Open_Workroom_AutoBE_Library_Page() throws InterruptedException {
		this.verify_Atlas_Left_Nav();
		this.click_Workrooms();
		Thread.sleep(1000);
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Workroom_AutoBE_Library_Page() -----------");
	}
	
	public void workroom_Member_Open_Workroom_AutoBE() throws InterruptedException {
		this.verify_Atlas_Left_Nav();
		this.click_Workrooms();
		Thread.sleep(1000);
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Mesage_Workroom();
		System.out.println("------- Completed --> workroom_Member_Open_Workroom_AutoBE() -----------");
	}
	
	// ----------- Atlas Left Nav Sign Out -----------------------------
	By sign_Out = By.xpath("//*[@id='wrap']/main/div/ul//li/a[contains(.,'Sign Out')]");

	public void verify_Sign_Out() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sign_Out)));
	}

	public void click_Sign_Out() {
		driver.findElement(sign_Out).click();
	}

	// --------------Function Being called-------------------------------------
	public void user_Can_Sign_Out() throws InterruptedException {
		this.verify_Sign_Out();
		this.click_Sign_Out();
		Thread.sleep(1500);
		System.out.println("------- Completed -->  user_Can_Sign_Out() -----------");
	}
	
	// ----------- Atlas Left Nav Site Settings -----------------------------
	By site_Settings = By.xpath("//*[@id='wrap']/main/div/ul//li/a[contains(.,'Site Settings')]");
	By workroom_Groups = By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]");
	By settings_side_Menu_Bar = By.xpath("//div[@id='settingsModal']//div[@class='modal-sidebar-container']");
	By reports = By.xpath("//span[@class='translation_missing'][contains(text(),'Reports')]");


	public void verify_Site_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(site_Settings)));
	}

	public void verify_Manage_Workrooms_Groups() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Groups)));
	}

	public void verify_Settings_Side_Menu_Bar() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_side_Menu_Bar)));
	}
	
	public void verify_Reports() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(reports)));
	}
	
	public void click_Site_Settings() {
		driver.findElement(site_Settings).click();
	}
	
	public void click_Reports() {
		driver.findElement(reports).click();
	}

	public void click_Manage_Workroom_Groups() {
		// driver.findElement(workroom_Groups).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// -------Function Being called -----------
	public void admin_Opens_Site_Settings_Workrooms_And_Groups() throws InterruptedException {
		this.verify_Site_Settings();
		this.click_Site_Settings();
		Thread.sleep(1000);
		this.verify_Manage_Workrooms_Groups();
		this.click_Manage_Workroom_Groups();
		Thread.sleep(1000);
		System.out.println("------- Completed --> admin_Opens_Site_Settings_Workrooms_And_Groups() -----------");
	}
	
	public void admin_Opens_Site_Settings() throws InterruptedException {
		this.verify_Site_Settings();
		this.click_Site_Settings();
		Thread.sleep(1000);
		this.verify_Settings_Side_Menu_Bar();
		System.out.println("------- Completed --> admin_Opens_Site_Settings() -----------");
	}
	
	public void admin_Opens_Site_Settings_Reports() throws InterruptedException {
		this.verify_Site_Settings();
		this.click_Site_Settings();
		Thread.sleep(1000);
		this.verify_Reports();
		this.click_Reports();
		Thread.sleep(1000);
		System.out.println("------- Completed --> admin_Opens_Site_Settings() -----------");
	}
	
	// ----------- Atlas Left Nav Discussions Settings -----------------------------
	By collaborateActiveOff = By.xpath("//span[@class='icon icon_wr-collaboration active-off']");
	
	public void verify_Collaborate_Active_Off() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(collaborateActiveOff)));
	}
	
	public void click_Collaborate_Active_Off() {
		driver.findElement(collaborateActiveOff).click();
	}
	
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		this.verify_Atlas_Left_Nav();
		this.click_Workrooms();
		Thread.sleep(1000);
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Collaborate_Active_Off();
		this.click_Collaborate_Active_Off();
		Thread.sleep(1000);
		System.out.println("------- Completed --> admin_Open_Workroom_AutoBE_Collaborate() -----------");
	}
	
	// ----------- Atlas Left Nav Events -----------------------------
	By eventsMenu = By.xpath("//span[@class='icon icon_wr-events active-off']");
	By newEventBtn = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Event')]");

	public void verify_Events_Menu() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(eventsMenu)));
	}
	
	public void verify_New_Event_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newEventBtn)));
	}
	
	public void click_Events_Menu() {
		driver.findElement(eventsMenu).click();
	}
	
	public void admin_Open_Workroom_AutoBE_Events() throws InterruptedException {
		this.verify_Atlas_Left_Nav();
		this.click_Workrooms();
		Thread.sleep(1000);
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1000);
		this.verify_New_Event_Btn();
		System.out.println("------- Completed --> admin_Open_Workroom_AutoBE_Events() -----------");
	}
	
// ----------- Atlas Left Nav User Profile -----------------------------
	By directory = By.xpath("//*[@id='wrap']/main/div/ul//li/a[contains(.,'Directory')]");
	By user_Search_Field = By.xpath("//input[@id='keyword']");

	public void verifyUserSearchField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Search_Field)));
	}
	
	public void verify_Directory() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(directory)));
	}
	
	public void click_Directory() {
		driver.findElement(directory).click();
	}
	
	public void admin_Open_Directory() throws InterruptedException {
		this.verify_Atlas_Left_Nav();
		this.verify_Directory();
		this.click_Directory();
		Thread.sleep(1000);
		this.verifyUserSearchField();
		System.out.println("------- Completed --> admin_Open_Workroom_AutoBE_Events() -----------");
	}
	
	public void admin_Open_Directory_With_Refresh() throws InterruptedException {
		this.verify_Atlas_Left_Nav();
		driver.navigate().refresh(); // due to stale element
		this.verify_Directory();
		this.click_Directory();
		Thread.sleep(1000);
		this.verifyUserSearchField();
		System.out.println("------- Completed --> admin_Open_Directory_With_Refresh() -----------");
	}

	// ----------- Atlas Left Nav Libraries -----------------------------
	By library_RL = By.xpath("//*[@id='wrap']/main/div/ul//li/a[normalize-space(text())='Library']");
	By new_Folder = By.xpath("//a[@class='new-folder']");

	public void verify_Library_RL() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library_RL)));
	}
	
	public void verify_New_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder)));
	}
	
	public void click_Library_RL() {
		driver.findElement(library_RL).click();
	}
	
	public void workroom_Member_Open_Resource_Library() throws InterruptedException {
		//this.verify_Atlas_Left_Nav();
		this.verify_Library_RL();
		this.click_Library_RL();
		Thread.sleep(1000);
		this.verify_New_Folder();
		System.out.println("------- Completed --> workroom_Member_Open_Resource_Library() -----------");
	}

}
