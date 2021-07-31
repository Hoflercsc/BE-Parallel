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

public class MyOwnBookPage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public MyOwnBookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// ------------------workroom_Admin_Not_See_Event_Due_To_Permissions------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By library = By.xpath("//span[contains(text(),'Library')]");
	By new_Book = By.xpath("//a[@class='btn btn-success no-mobile'][contains(text(),'New Book')]");

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

	public void click_AutoBE() {
		driver.findElement(autoBE).click();
	}

	public void click_Library() {
		driver.findElement(library).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(upload_My_Book_Link)));
	}

	public void click_New_Book() {
		driver.findElement(new_Book).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title)));
	}

	public void click_Upload_My_Book_Link() {
		driver.findElement(upload_My_Book_Link).click();
	}

	public void sendKeys_And_Attach_Book() {
		driver.findElement(book_Title).sendKeys("My own test book");
		String input = "//input[@id='book_filecontent']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void click_UploadBtn() {
		driver.findElement(upload).click();
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
	By new_Book_Title = By.xpath("//h1[contains(text(),'My own test book')]");

	public void verify_New_Book_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Book_Title)));
	}

	public void click_On_Switch() throws InterruptedException {
		driver.findElement(onswitch).click();
		Thread.sleep(1000);
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Make_Book_Visible() throws InterruptedException {
		this.verify_New_Book_Title();
		this.click_On_Switch();
		System.out.println("------- Completed --> user_Can_Make_Book_Visible() -----------");
	}
	
	// ---------------------------------user_Can_Delete_Book----------------------------------------------
	By library_BreadCrumb = By.xpath("//a[contains(text(),'Workroom Library')]");
	By bookDropDown = By.xpath("//a[contains(text(),'My own test book')]/following::div[@class='dropdown header-actions']");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By formField = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");

	public void verify_BookDropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(bookDropDown)));
	}

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void verify_Form_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(formField)));
	}

	public void click_Library_BreadCrumb() throws InterruptedException {
		driver.findElement(library_BreadCrumb).click();
	}

	public void click_BookDropDown() throws InterruptedException {
		driver.findElement(bookDropDown).click();
	}

	public void click_Delete_Option() throws InterruptedException {
		driver.findElement(delete_Option).click();
	}

	public void form_Field_SendKeys() throws InterruptedException {
		driver.findElement(formField).sendKeys("delete");
	}

	public void click_ContinueBtn() throws InterruptedException {
		driver.findElement(continueBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Delete_Book() throws InterruptedException {
		Thread.sleep(2000);
		this.click_Library_BreadCrumb();
		Thread.sleep(1500);
		this.verify_BookDropDown();
		Thread.sleep(2000);
		this.click_BookDropDown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form_Field();
		this.form_Field_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> user_Can_Delete_Book() -----------");
	}

	// --------------verify_Book_Deleted----------------------
	public void verify_Book_Not_Present() throws InterruptedException {
		String element = "//a[contains(text(),'My own test book')]/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}

	// --------------Function Being Called ---------------------------
	public void verify_Book_Deleted() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		this.verify_Book_Not_Present();
		System.out.println("------- Completed --> verify_Book_Deleted() -----------");
	}
}
