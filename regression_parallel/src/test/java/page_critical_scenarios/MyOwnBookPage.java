package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import org.testng.Assert;
import parallel.DriverFactory;
import tests_critical_scenarios.BaseTestCriticalScenarios;

public class MyOwnBookPage {

	// ------------------workroom_Admin_Not_See_Event_Due_To_Permissions------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By library = By.xpath("//span[contains(text(),'Library')]");
	By new_Book = By.xpath("//a[@class='btn btn-success no-mobile'][contains(text(),'New Book')]");

	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void verify_Libary() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library)));
	}

	public void verify_New_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Book)));
	}

	public void click_AutoBE() {
		DriverFactory.getInstance().getDriver().findElement(autoBE).click();
	}

	public void click_Library() {
		DriverFactory.getInstance().getDriver().findElement(library).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1500);
		this.verify_New_Book();
		System.out.println("------- Completed --> user_Can_Open_Library_Page_For_Workroom() -----------");
	}
	
	// -----------------user_Can_Create_New_Book----------------------------
	By upload_My_Book_Link = By.xpath("//a[@class='upload-book']");

	public void verify_Upload_My_Book_Link() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(upload_My_Book_Link)));
	}

	public void click_New_Book() {
		DriverFactory.getInstance().getDriver().findElement(new_Book).click();
	}

	// ---------------------Function Being Called---------------------------
	public void user_Can_Create_New_Book() throws InterruptedException {
		this.click_New_Book();
		Thread.sleep(1500);
		this.verify_Upload_My_Book_Link();
		System.out.println("------- Completed --> user_Can_Create_New_Book() -----------");
	}
	
	// ------------------------user_Can_Upload_New_Book-------------------------
	By book_Title = By.xpath("//div[@class='form-group']//input[@id='book_title']");
	By upload = By.xpath("//button[contains(text(),'Upload')]");

	public void verify_Book_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title)));
	}

	public void click_Upload_My_Book_Link() {
		DriverFactory.getInstance().getDriver().findElement(upload_My_Book_Link).click();
	}

	public void sendKeys_And_Attach_Book() {
		DriverFactory.getInstance().getDriver().findElement(book_Title).sendKeys("My Own Test Book");
		String input = "//input[@id='book_filecontent']";
		String filepath = "C:\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void click_UploadBtn() {
		DriverFactory.getInstance().getDriver().findElement(upload).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Upload_New_Book() throws InterruptedException {
		this.click_Upload_My_Book_Link();
		Thread.sleep(1500);
		this.verify_Book_Title();
		this.sendKeys_And_Attach_Book();
		Thread.sleep(1500);
		this.click_UploadBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Upload_New_Book() -----------");
	}
	
	// --------------user_Can_Make_Book_Visible-----------------
	By onswitch = By.xpath("//label[@class='onoffswitch-label']");
	By upload_Book_Title = By.xpath("//h1[contains(text(),'My Own Test Book')]");

	public void verify_Upload_Book_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(upload_Book_Title)));
	}

	public void click_On_Switch() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(onswitch).click();
		Thread.sleep(1000);
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Make_Upload_Book_Visible() throws InterruptedException {
		this.verify_Upload_Book_Title();
		this.click_On_Switch();
		System.out.println("------- Completed --> user_Can_Make_Upload_Book_Visible() -----------");
	}
	
	// ---------------------------------user_Can_Delete_Book----------------------------------------------
	By library_BreadCrumb = By.xpath("//a[contains(text(),'Workroom Library')]");
	By upload_Book_Dropdown = By.xpath("//a[contains(text(),'My Own Test Book')]/following::div[@class='dropdown header-actions']");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By formField = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");

	public void verify_Upload_Book_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(upload_Book_Dropdown)));
	}

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void verify_Form_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(formField)));
	}

	public void click_Library_BreadCrumb() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(library_BreadCrumb).click();
	}

	public void click_Upload_Book_Dropwdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(upload_Book_Dropdown).click();
	}
	
	public void click_Upload_Book_Title() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(upload_Book_Title).click();
	}

	public void click_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(delete_Option).click();
	}

	public void form_Field_SendKeys() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(formField).sendKeys("delete");
	}

	public void click_ContinueBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void delete_Upload_My_Own_Book() throws InterruptedException {
		Thread.sleep(2000);
		this.click_Library_BreadCrumb();
		Thread.sleep(1500);
		this.verify_Upload_Book_Title();
		Thread.sleep(2000);
		this.click_Upload_Book_Title();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form_Field();
		this.form_Field_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> delete_Upload_My_Own_Book() -----------");
	}

	// --------------verify_Book_Deleted----------------------
	public void verify_Upload_Book_Not_Present() throws InterruptedException {
		String book = "//a[contains(text(),'My own test book')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(book)).size() < 1);
	}

	// --------------Function Being Called ---------------------------
	public void verify_Book_Deleted() throws InterruptedException {
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_Upload_Book_Not_Present();
		System.out.println("------- Completed --> verify_Book_Deleted() -----------");
	}
}
