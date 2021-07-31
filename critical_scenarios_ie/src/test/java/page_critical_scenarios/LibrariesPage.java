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

public class LibrariesPage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public LibrariesPage(WebDriver driver) {
		this.driver = driver;
	}
	By libraries = By.xpath("//span[contains(text(),'Libraries')]");
	By new_Folder = By.xpath("//a[@class='new-folder']");

	// --------------user_Can_Open_Libraries_Form()------------------------
	public void verify_Libraries() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(libraries)));
	}

	public void verify_New_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder)));
	}

	public void click_Libraries() {
		// driver.findElement(libraries).click();
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Libraries')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------- Function being called --------------------
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Libraries();
		Thread.sleep(1500);
		this.click_Libraries();
		Thread.sleep(1500);
		this.verify_New_Folder();
		System.out.println("------- Completed --> user_Can_Open_Libraries_Form() -----------");
	}
	
	// --------------- user_User_Create_New__Resource_Library_Folder------------
	By new_Folder_Name_Field = By.xpath("//input[@id='efolder_name']");
	By saveBtn = By.xpath("//button[@id='newFolderSubmit']");
	// By new_Folder_Created = By.xpath("//a[contains(text(),'New Library
	// Folder')]");
	// By new_Folder_Created = By.xpath("//*[starts-with
	// (@id,'resource_')]/td[2]/a");
	By new_Folder_Created = By.linkText("New Library Folder");

	public void verify_New_Folder_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Name_Field)));
	}

	public void verify_New_Folder_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Created)));
	}

	public void click_New_Folder() {
		driver.findElement(new_Folder).click();
	}

	public void folder_Name_SendKeys() {
		String folder_Name = "New Library Folder";
		driver.findElement(new_Folder_Name_Field).sendKeys(folder_Name);
	}

	public void click_SaveBtn() {
		driver.findElement(saveBtn).click();
	}

	// --------------- Function being called --------------------
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys();
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_New_Folder_Created();
		System.out.println("------- Completed --> user_Can_Create_New_Resource_Library_Folder() -----------");
	}
	
	// --------------- user_Can_Open_Resource_Library_Folder --------------------
	By click_More_Options = By.xpath("//a[contains(text(),'click for more options')]");
	By browseBtn = By.xpath("//span[@class='btn btn-primary btn-file']");

	public void verify_Click_More_Options() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_More_Options)));
	}

	public void verify_BrowseBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(browseBtn)));
	}

	public void click_New_Folder_Created() {
		// driver.findElement(new_Folder_Created).click();
		// WebElement element = driver.findElement(By.xpath("//a[contains(text(),'New
		// Library Folder')]"));
		WebElement element = driver.findElement(By.xpath("//*[starts-with (@id,'resource_')]/td[2]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_More_Options() {
		// driver.findElement(click_More_Options).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'click for more options')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------- Function being called --------------------
	public void user_Can_Open_Resource_Library_Folder() throws InterruptedException {
		this.click_New_Folder_Created();
		Thread.sleep(1500);
		this.verify_Click_More_Options();
		this.click_More_Options();
		Thread.sleep(1500);
		this.verify_BrowseBtn();
		System.out.println("------- Completed --> user_Can_Open_Resource_Library_Folder() -----------");
	}
	
	// --------------- user_Can_Add_Resource_File_To_Folder --------------------
	By resource_Title = By.xpath("//form[@id='new_vfile_file']//input[@id='vfile_name']");
	By description = By.xpath("//form[@id='new_vfile_file']//textarea[@id='vfile_description']");
	By saveBtn2 = By.xpath("//button[@id='newResourceSubmit']");
	By resource_Upload_Message = By.xpath("//p[contains(text(),'The following files were uploaded: resource file t')]");
	By resource_File_Title = By.xpath("//a[contains(text(),'resource file title')]");

	public void verify_Resource_Message_And_File_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(resource_Upload_Message),
				ExpectedConditions.elementToBeClickable(resource_File_Title)));
	}

	public void add_File_Resource() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
		String file_Title = "resource file title";
		String descrip = "this is a description of the resource title";
		driver.findElement(resource_Title).sendKeys(file_Title);
		driver.findElement(description).sendKeys(descrip);
	}

	public void click_SaveBtn_2() {
		driver.findElement(saveBtn2).click();
	}

	// --------------- Function being called --------------------
	public void user_Can_Add_Resource_File_To_Folder() throws InterruptedException {
		Thread.sleep(1500);
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_SaveBtn_2();
		Thread.sleep(1500);
		this.verify_Resource_Message_And_File_Title();
		System.out.println("------- Completed --> user_Can_Add_Resource_File_To_Folder() -----------");
	}
	
	// --------------- user_Can_Delete_File--------------------
	By resource_Dropdown = By.xpath("//a[contains(text(),'steve System')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By delete_Option2 = By.xpath("//li[@class='delete']//a");
	// By delete_Option = By.xpath("//*[starts-with
	// (@id,'resource_')]/td[6]/div/ul/li[5]/a");
	By delete_Option = By.partialLinkText("Del");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void click_Resource_Dropdown() {
		driver.findElement(resource_Dropdown).click();
	}

	public void click_Delete_Option() {
		// driver.findElement(delete_Option).click();
		WebElement del = driver.findElement(By.xpath("//li[@class='delete']//a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", del);
	}

	public void click_ContinueBtn() {
		driver.findElement(continueBtn).click();
	}

	// --------------- Function being called --------------------
	public void user_Can_Delete_File() throws InterruptedException {
		this.click_Resource_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		System.out.println("------- Completed --> user_Can_Delete_File() -----------");
	}
	
	// --------------- user_Can_Delete_Folder --------------------
	By resource_Library_BreadCrumb = By.xpath("//ol[@class='breadcrumb']//a[contains(text(),'Resource Library')]");
	// By folder_Dropdown = By.xpath("//a[contains(text(),'New Library
	// Folder')]/following::button[@class='btn btn-default btn-xs
	// dropdown-toggle']");
	By folder_Dropdown = By.xpath("//*[starts-with (@id,'resource_')]/td[2]/a/following::button[@class='btn btn-default btn-xs dropdown-toggle']");

	public void verify_Resource_Library_BreadCrumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Library_BreadCrumb)));
	}

	public void click_Resource_Library_BreadCrumb() {
		driver.findElement(resource_Library_BreadCrumb).click();
	}

	public void click_Folder_Dropdown() {
		driver.findElement(folder_Dropdown).click();
	}

	// --------------- Function being called --------------------
	public void user_Can_Delete_Folder() throws InterruptedException {
		this.verify_Resource_Library_BreadCrumb();
		Thread.sleep(1500);
		this.click_Resource_Library_BreadCrumb();
		Thread.sleep(1500);
		this.click_CloseBtn();
		// ------refresh page -----
		Thread.sleep(1500);
		driver.navigate().refresh();
		Thread.sleep(2500);
		// -------------------------
		this.verify_Libraries();
		Thread.sleep(1500);
		this.click_Libraries();
		Thread.sleep(2500);
		this.verify_New_Folder_Created();
		Thread.sleep(1500);
		this.click_Folder_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		Thread.sleep(2000);
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	// --------------- verify_Folder_Deleted --------------------
	By closeBtn = By.xpath("//div[@id='filesModal']//div[@class='modal-header']//a[1]");

	public void verify_Folder_NOT_Present() throws InterruptedException {
		// String file_Title = "//a[contains(text(),'New Library
		// Folder')]/following::button[@class='btn btn-default btn-xs
		// dropdown-toggle']";
		String file_Title = "//*[starts-with (@id,'resource_')]/td[2]/a/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(file_Title)).size() < 1);
	}

	public void click_CloseBtn() {
		driver.findElement(closeBtn).click();
	}
	
	// --------------- Function being called --------------------
	public void verify_Folder_Deleted() throws InterruptedException {
		Thread.sleep(3000);
		this.verify_Folder_NOT_Present();
		this.click_CloseBtn();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Folder_Deleted() -----------");
	}
}
