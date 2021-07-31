package page_resource_library;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MoveResourceFolderPage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public MoveResourceFolderPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By libraries = By.xpath("//span[contains(text(),'Libraries')]");
	By new_Folder_Link = By.xpath("//a[@class='new-folder']");
	By new_Folder = By.xpath("//a[contains(text(),'New Library Folder')]");
	By new_Folder_2 = By.xpath("//a[contains(text(),'New Library Folder 2')]");
	By autoBE_Library = By.xpath("//a[contains(@class,'break-name')][contains(text(),'AutoBE')]");
	By private_Folder = By.xpath("//a[contains(text(),'Your Private Folder')]");
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By autoBE_RL = By.xpath("//body/div[@id='filesModal']//div/ul/li/a[contains(.,'AutoBE')]");
	
	By resource_Library_Table_Sorter = By.xpath("//table[@id='resource-library-tablesorter']");
	By attach_Folder = By.xpath("//a[contains(text(),'Attach')]");
	By large_Book_Folder = By.xpath("//a[contains(text(),'Large Book')]");
	By click_For_More_Options = By.xpath("//a[contains(text(),'click for more options')]");
	By file_Created_RL = By.xpath("//a[contains(text(),'Word_1.docx')]");

	// ----------------user_Can_Open_Libraries_Form()---------------------------------
	public void verify_Libraries() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(libraries)));
	}

	public void verify_New_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Link)));
	}

	public void verify_AutoBE_Library() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Library)));
	}
	
	public void verify_Your_Private_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(private_Folder)));
	}
	
	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}
	
	public void verify_AutoBE_RL() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_RL)));
	}
	
	public void verify_Resource_Library_Table_Sorter() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Library_Table_Sorter)));
	}
	
	public void verify_New_Folder_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_2)));
	}

	public void verify_Click_For_More_Options() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options)));
	}
	
	public void verify_File_Created_RL() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Created_RL)));
	}

	public void click_Libraries() {
		//driver.findElement(libraries).click();
		String library = "//span[contains(text(),'Libraries')]";
		WebElement element = driver.findElement(By.xpath(library));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AutoBE_Resource_Library_WR() {
		driver.findElement(autoBE_RL).click();
	}
	
	public void click_Attach_Folder() {
		driver.findElement(attach_Folder).click();
	}
	
	public void click_Large_Book_Folder() {
		driver.findElement(large_Book_Folder).click();
	}
	
	public void click_For_More_Options() {
		driver.findElement(click_For_More_Options).click();
	}

	public void verify_Board_Member_Folders_Present() {
		String attach = "//a[contains(text(),'Attach')]";
		String largeBook = "//a[contains(text(),'Large Book')]";
		Assert.assertTrue(driver.findElements(By.xpath(attach)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(largeBook)).size() > 0);
	}
	
	public void verify_Board_Member_Folders_Present_2() {
		// difference between 1 & 2 is the spelling of large book 
		String attach = "//a[contains(text(),'Attach')]";
		String largeBook = "//a[contains(text(),'LargeBook')]";
		Assert.assertTrue(driver.findElements(By.xpath(attach)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(largeBook)).size() > 0);
	}
	
	public void verify_Files_in_Attach_Folder() {
		String minutesExport = "//a[contains(text(),'MinutesExport (15).docx')]";
		String toAttach = "//a[contains(text(),'ToAttach')]";
		Assert.assertTrue(driver.findElements(By.xpath(minutesExport)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(toAttach)).size() > 0);
	}
	
	public void verify_Created_File_NOT_Present() throws InterruptedException {
		String created_File = "//*[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(created_File)).size() < 1);
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		this.verify_Libraries();
		this.click_Libraries();
		Thread.sleep(1500);
		this.verify_New_Folder();
		System.out.println("------- Completed --> user_Can_Open_Libraries_Form() -----------");
	}
	
	public void open_Resource_Library_AutoBE_WR() throws InterruptedException {
		this.verify_Libraries();
		this.click_Libraries();
		Thread.sleep(1500);
		this.verify_AutoBE_RL();
		this.click_AutoBE_Resource_Library_WR();
		System.out.println("------- Completed --> user_Can_Open_Libraries_Form() -----------");
	}
	
	public void verify_BoardMember_Folders_Present() throws InterruptedException {
		this.verify_Resource_Library_Table_Sorter();
		this.verify_Board_Member_Folders_Present();
		System.out.println("------- Completed --> verify_BoardMember_Folders_Present() -----------");
	}

	public void verify_Attach_Folder_Files_Present() throws InterruptedException {
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.verify_Files_in_Attach_Folder();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Attach_Folder_Files_Present() -----------");
	}
	
	public void verify_Secured_File_Not_Present() throws InterruptedException {
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.verify_File_Not_Present();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Attach_Folder_Files_Present() -----------");
	}
		
	public void verify_Large_Book_Folder_Files_Present() throws InterruptedException {
		this.click_Large_Book_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.verify_Files_in_Attach_Folder();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Large_Book_Folder_Files_Present() -----------");
	}
	
	public void add_File_To_Attach_Folder() throws InterruptedException {
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.click_For_More_Options();
		Thread.sleep(1000);
		this.verify_Browse();
		this.add_File_Resource();
		this.click_Resource_Save_Btn();
		Thread.sleep(1500);
		this.verify_File_Created_RL();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> add_File_To_Attach_Folder() -----------");
	}
	
	public void verify_Created_File() throws InterruptedException {
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		Thread.sleep(1000);
		this.verify_File_Created_RL();
		System.out.println("------- Completed --> add_File_To_Attach_Folder() -----------");
	}
	
	public void user_Can_Delete_File_RL() throws InterruptedException {
		this.click_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete();
		this.click_Delete();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_File() -----------");
	}
	
	public void verify_File_Deleted() throws InterruptedException {
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.verify_Created_File_NOT_Present();
		System.out.println("------- Completed --> verify_File_Deleted() -----------");
	}
	
	public void user_Can_Open_Libraries_Form_2() throws InterruptedException {
		this.verify_Libraries();
		this.click_Libraries();
		Thread.sleep(1500);
		this.verify_AutoBE_Library();
		System.out.println("------- Completed --> user_Can_Open_Libraries_Form_2() -----------");
	}
	
	public void user_Can_Open_Test_User_Libraries_Form() throws InterruptedException {
		this.verify_Libraries();
		this.click_Libraries();
		Thread.sleep(1500);
		this.verify_Your_Private_Folder();
		System.out.println("------- Completed --> user_Can_Open_Test_User_Libraries_Form() -----------");
	}
	
	// ------------user_User_Create_New__Resource_Library_Folder--------------------
	By new_Folder_Name_Field = By.xpath("//input[@id='efolder_name']");
	By saveBtn = By.xpath("//button[@id='newFolderSubmit']");
	By new_Folder_Created = By.xpath("//a[contains(text(),'New Library Folder')]");
	By new_Folder_2_Created = By.xpath("//a[contains(text(),'New Library Folder 2')]");
	By sub_Folder1_Created = By.xpath("//*[contains(text(),'Sub Folder1')]");
	By sub_Folder2_Created = By.xpath("//*[contains(text(),'Sub Folder2')]");

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
	
	public void verify_New_Folder_2_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_2_Created)));
	}

	public void click_New_Folder() {
		String new_Folder_Link = "//a[@class='new-folder']";
		WebElement element = driver.findElement(By.xpath(new_Folder_Link));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_New_Folder_1() {
		driver.findElement(new_Folder).click();
	}
	
	public void click_New_Folder_2() {
		driver.findElement(new_Folder_2).click();
	}

	public void folder_Name_SendKeys() {
		String folder_Name = "New Library Folder";
		driver.findElement(new_Folder_Name_Field).sendKeys(folder_Name);
	}
	
	public void folder_Name_SendKeys_2() {
		String folder_Name = "New Library Folder 2";
		driver.findElement(new_Folder_Name_Field).sendKeys(folder_Name);
	}
	
	public void folder_Name_SendKeys_3() {
		String folder_Name = "Sub Folder1";
		driver.findElement(new_Folder_Name_Field).sendKeys(folder_Name);
	}
	
	public void folder_Name_SendKeys_4() {
		String folder_Name = "Sub Folder2";
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
	
	// --------------- Function being called --------------------
	public void user_Can_Create_2nd_Resource_Library_Folder() throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys_2();
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_New_Folder_2_Created();
		System.out.println("------- Completed --> user_Can_Create_2nd_Resource_Library_Folder() -----------");
	}
	
	// --------------- Edit-Existing-Folder-To-View-Only --------------------
	By new_Library_Folder = By.xpath("//span[contains(text(),'New Library Folder')]");
	By new_Library_Folder_2 = By.xpath("//a[contains(text(),'New Library Folder')]");
	//By pdf_Drp_Dwn = By.xpath("//a[contains(text(),'ScannedDocument.pdf')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By pdf_Drp_Dwn = By.xpath("//*[contains(text(),'ScannedDocument.pdf')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	
	public void verify_New_Lib_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Library_Folder)));
	}
	
	public void verify_New_Lib_Folder_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Library_Folder_2)));
	}
	
	public void verify_PDF_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pdf_Drp_Dwn)));
	}

	public void verify_View_Only_Folder_Permissions_Enabled() {
		//String folder_Dropdown = "//span[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		String folder_Dropdown = "//span[contains(text(),'New Library Folder')]";
		String view_Only = "//tbody//tr/td[2]/a[1]/span[1]/i[@title='View Only']";
		Assert.assertTrue(driver.findElements(By.xpath(folder_Dropdown)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(view_Only)).size() > 0);
	}
	
	public void verify_View_Only_Folder_Permissions_Disabled() {
		String view_Only_Icon = "//i[@class='fa fa-desktop smallest-left']";
		Assert.assertTrue(driver.findElements(By.xpath(view_Only_Icon)).size() < 1);
	}
	
	public void verify_View_Only_File_Permissions_Enabled() {
		String click_For_More_Options = "//a[contains(text(),'click for more options')]";
		Assert.assertTrue(driver.findElements(By.xpath(click_For_More_Options)).size() < 1);
	}
	
	public void verify_View_Only_File_Permissions_Disabled() {
		String click_For_More_Options = "//a[contains(text(),'click for more options')]";
		Assert.assertTrue(driver.findElements(By.xpath(click_For_More_Options)).size() > 0);
	}
	
	public void click_New_Lib_Folder() {
		driver.findElement(new_Library_Folder).click();
	}
	
	public void click_PDF_Drp_Dwn() {
		driver.findElement(pdf_Drp_Dwn).click();
	}
	
	public void click_Scanned_PDF() {
		driver.findElement(file_Created_2).click();
	}
	
	public void add_File_Resource_Copy_Link() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void verify_View_Only_Permissions() throws InterruptedException {
		this.verify_New_Lib_Folder();
		this.verify_View_Only_Folder_Permissions_Enabled();
		this.click_New_Lib_Folder();
		Thread.sleep(1500);
		this.verify_File_Created_2();
		this.verify_View_Only_File_Permissions_Enabled();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_View_Only_Permissions() -----------");
	}
	
	public void verify_Boardmember_View_Only_Permissions() throws InterruptedException {
		this.verify_New_Lib_Folder();
		this.verify_View_Only_Folder_Permissions_Enabled();
		this.click_New_Lib_Folder();
		Thread.sleep(1500);
		this.verify_File_Created_2();
		//this.verify_View_Only_File_Permissions_Enabled(); board member can add files
		this.click_Scanned_PDF();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_View_Only_Permissions() -----------");
	}
	
	public void verify_View_Only_Permissions_Disabled() throws InterruptedException {
		this.verify_New_Lib_Folder_2();
		this.verify_View_Only_Folder_Permissions_Disabled();
		this.click_New_Library_Folder_1();
		Thread.sleep(1000);
		this.verify_File_Created_2();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_View_Only_Permissions_Disabled() -----------");
	}
	
	By hour_Glass = By.xpath("//tbody/tr[starts-with(@id,'resource_')]/td[3]/span[1]/i[1]");
	public void verify_Hour_Glass_Invisible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(hour_Glass)));
	}
	
	public void user_Can_Add_File_Folder_2() throws InterruptedException {
		this.click_New_Lib_Folder();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_Copy_Link();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(500);
		this.verify_Hour_Glass_Invisible();
		this.verify_File_Created_2();
		System.out.println("------- Completed --> user_Can_Add_File_to_2nd_Folder() -----------");
	}
	
	public void create_Sub_Folder1() throws InterruptedException {
		this.click_New_Lib_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder();
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys_3();
		this.click_SaveBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> create_Sub_Folder1() -----------");
	}
	
	public void create_Sub_Folder2() throws InterruptedException {
		this.verify_New_Folder();
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys_4();
		this.click_SaveBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> create_Sub_Folder2() -----------");
	}
	
	public void copy_File_Link() throws InterruptedException, UnsupportedFlavorException, IOException {
		this.verify_New_Lib_Folder();
		this.click_New_Lib_Folder();
		Thread.sleep(2000);
		this.verify_PDF_Drp_Dwn();
		this.click_PDF_Drp_Dwn();
		Thread.sleep(1000);
		this.verify_Copy_Link();
		this.click_Copy_Link();
		Thread.sleep(2000);
		System.out.println("------- Completed --> open_Email_File_Link() -----------");
	}
	
	public void copy_File_Link_Non_View_Only() throws InterruptedException, UnsupportedFlavorException, IOException {
		this.verify_New_Folder_2();
		this.click_New_Folder_2();
		Thread.sleep(2000);
		this.verify_PDF_Drp_Dwn();
		this.click_PDF_Drp_Dwn();
		Thread.sleep(1000);
		this.verify_Copy_Link();
		this.click_Copy_Link();
		Thread.sleep(2000);
		System.out.println("------- Completed --> copy_File_Link_Non_View_Only() -----------");
	}
	
	By mr_Resource_Library = By.xpath("//div[@class='col-md-4']//a[@class='active'][contains(text(),'Resource Library')]");
	By mr_New_Library_Folder_2 = By.xpath("//a[contains(text(),'New Library Folder 2')]");
	By mr_Destination_Text_Change = By.xpath("//span[@class='destination-name'][contains(text(),'New Library Folder 2')]");
	By mr_Move = By.xpath("//button[contains(text(),'Move')]");
	By mr_Message = By.xpath("//p[contains(text(),'Files/Folders were successfully moved')]");


	public void verify_Resource_Library_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mr_Resource_Library)));
	}
	
	public void verify_Destination_Text_Change() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mr_Destination_Text_Change)));
	}
	
	public void verify_MR_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mr_Message)));
	}
	
	public void click_MR_Resource_Library_2() {
		driver.findElement(mr_Resource_Library).click();
	}
	
	public void click_MR_New_Library_Folder_2() {
		driver.findElement(mr_New_Library_Folder_2).click();
	}
	
	public void click_MR_Move() {
		driver.findElement(mr_Move).click();
	}
	
	public void move_File_From_View_Only_To_Non_View_Only() throws InterruptedException {
		this.click_New_Lib_Folder(); // view only folder with //span element
		Thread.sleep(1000);
		this.verify_File_Created_2();
		this.click_File_Dropdown_3();
		Thread.sleep(1000);
		this.verify_Move_Option();
        this.click_Move_Option();
		Thread.sleep(1000);
		this.verify_Resource_Library_2();
		this.click_MR_Resource_Library_2();
		Thread.sleep(1000);
		this.verify_Resource_Library_2();
		this.click_MR_New_Library_Folder_2();
		Thread.sleep(1000);
		//this.verify_Destination_Text_Change();
		this.click_MR_Move();
		Thread.sleep(3000);
		//this.verify_MR_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> move_File_From_View_Only_To_Non_View_Only() -----------");
	}
	
	public void open_File_Link() throws InterruptedException {
	  //1st way to do this
	   
	   	try {
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			Object data = clipboard.getData(DataFlavor.stringFlavor);
	         
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.open(\""+data+"\")");
			System.out.println(data);
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread.sleep(2000);

		/* 2nd way to do this
		WebElement copyfilepath = driver.findElement(By.xpath("//a[@class='copy-file-path']"));
		String attribute = copyfilepath.getAttribute("data-clipboard-text");
		System.out.println(attribute);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open(\""+attribute+"\")");
		*/
		System.out.println("------- Completed --> open_File_Link() -----------");
	}
	
	public void switch_Tab_Verify_Viewer_Element() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/iframe[1]"));
		driver.switchTo().frame(iframe);
		// wait for element to apear in iframe
		//By panel = By.xpath("//body/div[@id='app']/div[@class='App']/div[@class='Header open']/div[@class='HeaderItems']/div[1]");
		By panel = By.xpath("//body/div[@id='app']/div[@class='App']");
		WebElement iframePanel = driver.findElement(panel);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframePanel)));
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.close();
		// ---close 2nd Tab----
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		driver.navigate().refresh(); // back to main page
	}
	
	
	
	//---------------------add_File_To_Private_Folder----------------------
	By your_Private_Folder = By.xpath("//a[contains(text(),'Your Private Folder')]");
	By select_PC_File = By.xpath("//a[contains(text(),'select from your computer')]");
	By name_Header = By.xpath("//div[contains(text(),'Name')]");

	public void verify_Select_PC_File() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(select_PC_File)));
	}
	
	public void click_Your_Private_Folder() {
		driver.findElement(your_Private_Folder).click();
	}
	
	public void click_Select_PC_File() {
		driver.findElement(select_PC_File).click();
	}
	
	public void click_Name_Header() {
		driver.findElement(name_Header).click();
	}
	
	public void verify_JPG_Word_Sort_Order() {
		// sisco.jpg should be 1st followed by word file
		String element = "//a[contains(text(),'sisco.jpg')]/following::i[@class='fa fa-file-word-o fa-2x']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Word_JPG_Sort_Order() {
		// sisco.jpg should be 1st followed by word file
		String element = "//a[contains(text(),'Word_1.docx')]/following::i[@class='fa fa-file-image-o fa-2x']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	// --------------- Function being called --------------------
	public void add_File_To_Private_Folder() throws InterruptedException {
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_Select_PC_File();
		this.click_Select_PC_File();
		Thread.sleep(1500);
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		System.out.println("------- Completed --> add_File_To_Private_Folder() -----------");
	}
	
	// --------------- Function being called --------------------
	public void add_2nd_File_To_Private_Folder() throws InterruptedException {
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_Select_PC_File();
		this.click_Select_PC_File();
		Thread.sleep(1500);
		this.verify_Browse();
		this.add_File_Resource_3();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		System.out.println("------- Completed --> add_2nd_File_To_Private_Folder() -----------");
	}
	
	// --------------- Function being called --------------------
	public void verify_Sort_For_Private_Folder_Headers() throws InterruptedException {
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_Select_PC_File();
		this.click_Name_Header();
		Thread.sleep(1000);
		this.click_Name_Header();
		Thread.sleep(1000);
		this.verify_JPG_Word_Sort_Order();
		this.click_Name_Header();
		Thread.sleep(1000);
		this.verify_Word_JPG_Sort_Order();
		System.out.println("------- Completed --> verify_Sort_For_Private_Folder_Headers() -----------");
	}
		
	//---------------------user_Can_Add_Multiple_Files_To_Folder----------------------
	By click_More_Options_Link = By.xpath("//a[contains(text(),'click for more options')]");
	By browse = By.xpath("//div[@class='form-group']//span[@class='input-group-btn']");
	By resource_Save_Btn = By.xpath("//button[@id='newResourceSubmit']");
	//By file_Created = By.xpath("//a[contains(text(),'Word_1.docx')]");
	By file_Created = By.xpath("//*[contains(text(),'Word_1.docx')]");
	By file_Created_2 = By.xpath("//*[contains(text(),'ScannedDocument.pdf')]");

	public void click_More_Options_Link() throws InterruptedException {
		driver.findElement(click_More_Options_Link).click();
	}
	
	public void verify_Browse() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(browse)));
	}
	
	public void verify_File_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Created)));
	}
	
	public void verify_File_Created_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Created_2)));
	}
	
	public void verify_Sub_Folder1_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sub_Folder1_Created)));
	}
	
	public void verify_Sub_Folder2_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sub_Folder2_Created)));
	}
	
	public void verify_More_Options_Link() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_More_Options_Link)));
	}
	
	public void verify_File_Not_Present() {
		String file = "//a[contains(text(),'Word_1.docx')]";
		Assert.assertTrue(driver.findElements(By.xpath(file)).size() < 1);
	}
	
	public void verify_Both_Files_Not_Present() {
		String file = "//a[contains(text(),'Word_1.docx')]";
		String file2 = "//a[contains(text(),'sisco.jpg')]";
		Assert.assertTrue(driver.findElements(By.xpath(file)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(file2)).size() < 1);
	}
	
	public void add_File_Resource() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_File_Resource_1B() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_File_Resource_2() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_2.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_File_Resource_3() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void click_Resource_Save_Btn() {
		driver.findElement(resource_Save_Btn).click();
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Add_Multiple_Files_To_Folder() throws InterruptedException {
		this.click_New_Folder_1();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		//------------------------
		this.user_Close_Library_Folder();
		this.user_Can_Open_Libraries_Form_2();
		this.click_New_Folder_1();
		Thread.sleep(1500);
		this.verify_More_Options_Link();
		//--------------------------
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_2();
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_to_2nd_Folder() -----------");
	}

// --------------- Function being called --------------------
	public void user_Can_Add_File_Folder() throws InterruptedException {
		this.click_New_Folder_1();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_to_2nd_Folder() -----------");
	}
	
	public void user_Can_Add_File_Folder_1B() throws InterruptedException {
		this.click_New_Folder_1();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_1B();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_File_Created_2();
		System.out.println("------- Completed --> user_Can_Add_File_Folder_1B() -----------");
	}
	// --------------- Function being called --------------------
	public void user_Can_Add_File_to_2nd_Folder() throws InterruptedException {
		this.click_New_Folder_2();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_to_2nd_Folder() -----------");
	}
	
	public void user_Can_Add_File_Folder_Non_Read_Only() throws InterruptedException {
		this.click_New_Folder_2();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_Copy_Link();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(1000);
		this.verify_File_Created_2();
		System.out.println("------- Completed --> user_Can_Add_File_Folder_Non_Read_Only() -----------");
	}
	
	public void add_File_For_Board_Member() throws InterruptedException {
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(2500);
		this.verify_File_Created();
		driver.navigate().refresh();
		System.out.println("------- Completed --> add_File_For_Board_Member() -----------");
	}
	
	// --------------- Function being called --------------------
	public void verify_File_Not_Present_in_Folder() throws InterruptedException {
		this.click_New_Folder_2();
		Thread.sleep(2000);
		this.verify_File_Not_Present();
		this.close_Modal();
		System.out.println("------- Completed --> verify_File_Not_Present_in_Folder() -----------");
	}
	
	// --------------- Function being called --------------------
	public void verify_Folder_Not_Present() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Folder2_NOT_Present();
		this.close_Modal();
		System.out.println("------- Completed --> verify_Folder_Not_Present() -----------");
	}
	
	// --------------- user_Can_Move_File--------------------
	By file_Dropdown = By.xpath("//a[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By file_Dropdown_B = By.xpath("//*[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By file_Dropdown_2B = By.xpath("//*[contains(text(),'ScannedDocument.pdf')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	String fileDropdown ="//*[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	String fileDropdown2 ="//a[contains(text(),'sisco.jpg')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	String fileDropdown3 ="//*[contains(text(),'ScannedDocument.pdf')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	By Move_New_Libary_Folder = By.xpath("//ul[@id='library']//li[1]//a[1]");
	By workroom_Admin = By.xpath("//div[contains(text(),'Workroom Admin')]");
	By workroom_Admin_User = By.xpath("//div[@class='row small-left']//div[@class='person-name'][contains(text(),'Workroom Admin')]");
	By lockout_User = By.xpath("//div[contains(text(),'lockout user')]");
	By lockout_User_Added = By.xpath("//div[@class='row small-left']//div[@class='person-name'][contains(text(),'lockout user')]");



	public void verify_Move_Library_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(Move_New_Libary_Folder)));
	}
	
	public void verify_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin)));
	}
	
	public void verify_Workroom_Admin_User() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_User)));
	}
	
	public void verify_Approval_File() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Dropdown)));
	}
	
	public void verify_Approval_File_B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Dropdown_B)));
	}
	
	public void verify_Approval_File_2B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Dropdown_2B)));
	}
	
	public void verify_Lockout_User() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(lockout_User)));
	}
	
	public void verify_Lockout_User_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(lockout_User_Added)));
	}
	
	
	public void click_File_Dropdown() {
		//driver.findElement(file_Dropdown).click();
		WebElement element = driver.findElement(By.xpath(fileDropdown));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_File_Dropdown_2() {
		//driver.findElement(file_Dropdown).click();
		WebElement element = driver.findElement(By.xpath(fileDropdown));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_File_Dropdown_3() {
		//driver.findElement(file_Dropdown).click();
		WebElement element = driver.findElement(By.xpath(fileDropdown3));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_New_Library_Folder() {
		//driver.findElement(Move_New_Libary_Folder).click();
		WebElement element = driver.findElement(By.xpath("//ul[@id='library']//li[1]//a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Workroom_Admin() {
		//driver.findElement(Move_New_Libary_Folder).click();
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Workroom Admin')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Lockout_User() {
		//driver.findElement(Move_New_Libary_Folder).click();
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'lockout user')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Move_File() throws InterruptedException {
		this.click_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Move_Option();
        this.click_Move_Option();
		Thread.sleep(1500);
		this.verify_Move_Library_Folder();
		this.click_New_Library_Folder();
		Thread.sleep(1000);
		this.click_Move_Btn();
		Thread.sleep(1000);
		this.verify_Move_Message();
		this.click_Close_Resource();
		Thread.sleep(2500);
		System.out.println("------- Completed --> user_Can_Move_File() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Add_Security_To_File() throws InterruptedException {
		this.click_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Security_Option();
		Thread.sleep(1500);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_User();
		Thread.sleep(1000);
		this.click_Close_Security_Box();
		Thread.sleep(2500);
		this.close_Modal();
		System.out.println("------- Completed --> user_Can_Add_Security_To_File() -----------");
	}
	
	public void add_Security_To_File_Board_member() throws InterruptedException {
		this.click_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Security_Option();
		Thread.sleep(1500);
		this.verify_Lockout_User();
		this.click_Lockout_User();
		Thread.sleep(1000);
		this.verify_Lockout_User_Added();
		Thread.sleep(1000);
		this.click_Close_Security_Box();
		driver.navigate().refresh();
		System.out.println("------- Completed --> add_Security_To_File_Board_member() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Copy_File_Link_And_Download_File() throws InterruptedException, UnsupportedFlavorException, IOException {
		this.click_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Copy_Link();
		this.click_Copy_Link();
		Thread.sleep(1000);
/*		
		String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
		System.out.println(data);
		
	      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
          String paste = (String) clipboard.getContents(null).getTransferData(DataFlavor.stringFlavor);
          
          //open in separate tab
          
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("popup_window = window.open('"+ paste+ "');");
          Thread.sleep(3000);
          js.executeScript("popup_window.close()");

*/		
		this.close_Modal();
	    Thread.sleep(3000);
	    //driver.navigate().refresh();
		//--- finished returning string 
		System.out.println("------- Completed --> user_Can_Copy_File_Link_And_Download_File() -----------");
	}
	
	// --------------- Function being called --------------------
	//https://stackoverflow.com/questions/30726126/detecting-a-file-downloaded-in-selenium-java

	public boolean verify_File_Download_Deletion(String downloadPath, String fileName) throws InterruptedException {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i <= dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          // File has been found, it can now be deleted:
		          dirContents[i].delete();
		  			System.out.println("------- Completed --> download_Verified_File_Deleted() -----------");

		          return true;
		      }
		          }
		      return false;
	}
	
	
	// --------------- Function being called --------------------
	public void user_Can_Add_Security_To_Folder_1() throws InterruptedException {
		this.verify_Folder_1_Dropdown();
        this.click_Dropdown();
		Thread.sleep(1000);
		this.verify_Security_Option();
        this.click_Security_Option();
		Thread.sleep(1500);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_User();
		Thread.sleep(1000);
		this.click_Close_Security_Box();
		Thread.sleep(2500);
		System.out.println("------- Completed --> user_Can_Add_Security_To_Folder_1() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Add_Security_To_Folder_2B() throws InterruptedException {
		this.verify_Folder_2_Dropdown();
        this.click_Dropdown_2();
		Thread.sleep(2000);
		this.verify_Security_Option_2B();
        this.click_Security_Option_2B();
		Thread.sleep(1500);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_User();
		Thread.sleep(1000);
		this.click_Close_Security_Box();
		Thread.sleep(2500);
		System.out.println("------- Completed --> user_Can_Add_Security_To_Folder_2B() -----------");
	}
	
	public void add_Security_BoardMember_Folder() throws InterruptedException {
		this.verify_Folder_2_Dropdown();
        this.click_Dropdown_2();
		Thread.sleep(1500);
		this.verify_Security_Option_BM();
        this.click_Security_Option_BM();
		Thread.sleep(1000);
		this.verify_Lockout_User();
		this.click_Lockout_User();
		Thread.sleep(1000);
		this.verify_Lockout_User_Added();
		Thread.sleep(1000);
		this.click_Close_Security_Box();
		Thread.sleep(2500);
		System.out.println("------- Completed --> add_Security_BoardMember_Folder() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Add_Security_To_Folder_2() throws InterruptedException {
		this.verify_Folder_2_Dropdown();
        this.click_Dropdown_2();
		Thread.sleep(2000);
		this.verify_Security_Option_2();
        this.click_Security_Option_2();
		Thread.sleep(1500);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_User();
		Thread.sleep(1000);
		this.click_Close_Security_Box();
		Thread.sleep(2500);
		System.out.println("------- Completed --> user_Can_Add_Security_To_Folder_2() -----------");
	}
	
	// --------------- verify_Folders_In_Secured_Folders_Catergory() --------------------
	By approvals = By.xpath("//li[@class='approvals']//a[contains(text(),'Approvals')]");
	By allow_Comments = By.xpath("//label[contains(text(),'Allow Comments')]");
	By submit = By.xpath("//div[@id='approvals_modal']//button[@class='btn btn-done'][contains(text(),'Submit')]");
	By workroom_Admin_2 = By.xpath("//div[@id='approvals_modal']//a[@class='active'][contains(text(),'People')]/following::div[@class='person-name'][contains(text(),'Workroom Admin')]");
	By auto_Director = By.xpath("//div[@id='approvals_modal']//a[@class='active'][contains(text(),'People')]/following::div[@class='person-name'][contains(text(),'Auto Director')]");
	By verify_Workroom_Admin_2_Added = By.xpath("//div[@class='person-name'][contains(text(),'Workroom Admin')]/following::span[@class='glyphicon glyphicon-remove remove-icon']");
	By close_Approvers_Box = By.xpath("//a[contains(text(),'Close')]");
	By question_Box = By.xpath("//textarea[@id='approval_question']");
	By steve_System = By.xpath("//div[@id='approvals_modal']//a[@class='active'][contains(text(),'People')]/following::div[@class='person-name'][contains(text(),'steve System')]");
	//By verify_Auto_Director_2_Added = By.xpath("(//div[@class='people-snippet'][contains(.,'Auto Director')]//following::span[@class='glyphicon glyphicon-remove remove-icon'])[1]");
	//By verify_Steve_System_2_Added = By.xpath("//div[@class='people-snippet'][contains(.,'steve System')]//following::span[@class='glyphicon glyphicon-remove remove-icon']");
	By verify_Auto_Director_2_Added = By.xpath("//div[@class='people-snippet'][contains(.,'Auto Director')]");
	By verify_Steve_System_2_Added = By.xpath("//div[@class='people-snippet'][contains(.,'steve System')]");
	//div[@id='approvals_modal']//button[@class='btn btn-default'][contains(text(),'Close')]
	
	public void verify_Allow_Comments() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(allow_Comments)));
	}
	
	public void verify_Workroom_Admin_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_2)));
	}
	
	public void verify_Workroom_Admin_2_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(verify_Workroom_Admin_2_Added)));
	}
	
	public void verify_Auto_Director_2_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(verify_Auto_Director_2_Added)));
	}
	
	public void click_Approvals() {
		driver.findElement(approvals).click();
	}
	
	public void click_Allow_Comments() {
		driver.findElement(allow_Comments).click();
	}
	
	public void click_Submit() {
		driver.findElement(submit).click();
	}
	
	public void click_Workroom_Admin_2() {
		driver.findElement(workroom_Admin_2).click();
	}
	
	public void click_Auto_Director() {
		driver.findElement(auto_Director).click();
	}
	
	public void click_Close_Approvers_Box() {
		//driver.findElement(close_Approvers_Box).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Close')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void verify_Approvers_Added() throws InterruptedException {
		String wa_approver = "//div[contains(text(),'Workroom Admin')]";
		String ad_approver = "//div[contains(text(),'Auto Director')]";
		Assert.assertTrue(driver.findElements(By.xpath(wa_approver)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(ad_approver)).size() > 0);
	}
	
	public void verify_Approvers_Added_2() throws InterruptedException {
		String ad_approver = "//div[contains(text(),'Auto Director')]";
		String ss_approver = "//div[contains(text(),'steve System')]";
		Assert.assertTrue(driver.findElements(By.xpath(ad_approver)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(ss_approver)).size() > 0);
	}
	
	public void question_Box_SendKeys() {
		String sentence = "Please approve or deny this item";
		driver.findElement(question_Box).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(question_Box).clear();
		driver.findElement(question_Box).sendKeys(sentence);
	}
	
	public void scroll_Click_Steve_System() throws InterruptedException {
		WebElement steveSystem = driver.findElement(By.xpath("//div[@id='approvals_modal']//a[@class='active'][contains(text(),'People')]/following::div[@class='person-name'][contains(text(),'steve System')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", steveSystem);
		Thread.sleep(1000);
		
		driver.findElement(steve_System).click();
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Add_Approvers_To_File() throws InterruptedException {
		this.click_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Approvals();
		Thread.sleep(1500);
		this.verify_Allow_Comments();
		this.click_Allow_Comments();
		Thread.sleep(1000);
		this.click_Submit();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_2();
		this.click_Workroom_Admin_2();
		Thread.sleep(2000);
		this.click_Auto_Director();
		Thread.sleep(2000);
		this.verify_Workroom_Admin_2_Added();
		this.click_Close_Approvers_Box();
		System.out.println("------- Completed --> user_Can_Add_Approvers_To_File() -----------");
	}
	
	public void user_Can_Add_Approvers_To_File_2() throws InterruptedException {
		this.click_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Approvals();
		Thread.sleep(1000);
		this.verify_Allow_Comments();
		this.click_Allow_Comments();
		Thread.sleep(1000);
		this.question_Box_SendKeys();// enter text in box
		this.click_Submit();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_2();
		this.click_Auto_Director();
		Thread.sleep(1000);
		this.scroll_Click_Steve_System();// scroll click stevesystem
		this.verify_Auto_Director_2_Added();
		this.click_Close_Approvers_Box();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Approvers_To_File_2() -----------");
	}
	
	public void user_Can_Add_Approvers_To_File_2b() throws InterruptedException {
		this.click_File_Dropdown_3();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Approvals();
		Thread.sleep(1000);
		this.verify_Allow_Comments();
		this.click_Allow_Comments();
		Thread.sleep(1000);
		this.question_Box_SendKeys();// enter text in box
		this.click_Submit();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_2();
		this.click_Auto_Director();
		Thread.sleep(1000);
		this.scroll_Click_Steve_System();// scroll click stevesystem
		this.verify_Auto_Director_2_Added();
		this.click_Close_Approvers_Box();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Approvers_To_File_2b() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Verify_Approvers_Added() throws InterruptedException {
		this.click_New_Folder_2();
		Thread.sleep(1000);
		this.verify_File_Created();
		this.click_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Approvals();
		Thread.sleep(1000);
		this.verify_Approvers_Added();
		//this.click_Close_Approvers_Box();
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Verify_Approvers_Added() -----------");
	}
	
	public void user_Can_Verify_Approvers_Added_2() throws InterruptedException {
		this.click_New_Folder_1();
		Thread.sleep(1000);
		this.verify_Approval_File_2B();
		this.click_File_Dropdown_3();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Approvals();
		Thread.sleep(1000);
		this.verify_Approvers_Added_2();
		//this.click_Close_Approvers_Box();
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Verify_Approvers_Added_2() -----------");
	}
	
	// ---------------Approving an Approval --------------------
	By ellipsis = By.xpath("//*[@class='tips-drawer drawer-toggle']//i[@class='fa fa-ellipsis-h']");
	By history = By.xpath("//a[contains(text(),'History')]");
	By manage = By.xpath("//a[contains(text(),'Manage')]");
	By manage_Approvals = By.xpath("//a[contains(text(),'Manage Approvals')]");
	By approve_or_Deny = By.xpath("//a[contains(text(),'Please approve or deny this item')]");
	By response_Required = By.xpath("//a[contains(text(),'Response Required')]");
	By response_Approve = By.xpath("//*[@id='approval_response_buttons']/label[contains(.,'Approve')]");
	By submit_2 = By.xpath("//body/div[@id='response_modal']/div[1]/div[1]/div[3]/button[2]");

	
	public void verify_Ellipsis() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(ellipsis)));
	}
	
	public void verify_History() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(history)));
	}
	
	public void verify_Manage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(manage)));
	}
	
	public void verify_Manage_Approvals() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(manage_Approvals)));
	}
	
	public void verify_Response_Required() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(response_Required)));
	}
	
	public void verify_Response_Approve() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(response_Approve)));
	}
	
	public void verify_Approve_Or_Deny() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(approve_or_Deny)));
	}
	
	public void hover_And_Click_Actions_Hide() throws InterruptedException {
		WebElement ellipsis_Menu = driver.findElement(By.xpath("//*[@class='tips-drawer drawer-toggle']//i[@class='fa fa-ellipsis-h']"));
		// move to element
		Actions action = new Actions(driver);
        action.moveToElement(ellipsis_Menu).build().perform();
		Thread.sleep(2000);
		
        // click on element
		WebElement actions_Menu = driver.findElement(By.xpath("//*[@id='wrap']/main/div[1]/div[1]/a[@class='tips-drawer drawer-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", actions_Menu);
	}
	
	public void click_Response_Required() throws InterruptedException {
		By expand = By.xpath("//*[starts-with (@id,'headingApprovals_')]/div/a/span[contains(.,'Expand')]");

		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean expand_Element = driver.findElements(By.xpath("//*[starts-with (@id,'headingApprovals_')]/div/a/span[contains(.,'Expand')]")).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (expand_Element == true) {
			driver.findElement(expand).click();
			Thread.sleep(1000);
			this.verify_Response_Required();
			driver.findElement(response_Required).click();
		}else {
			driver.findElement(response_Required).click();
		}
		
	}
	
	public void click_Response_Approve() {
		driver.findElement(response_Approve).click();
	}
	
	public void click_Submit_2() {
		driver.findElement(submit_2).click();
	}
	
	public void click_Manage() {
		driver.findElement(manage).click();
	}
	
	public void click_Manage_Approvals() {
		driver.findElement(manage_Approvals).click();
	}
	
	public void user_Can_Open_Actions_Menu_And_Respond() throws InterruptedException {
		Thread.sleep(5000);// waiting for PDF to process
		driver.navigate().refresh();
		this.hover_And_Click_Actions_Hide();
		Thread.sleep(5000);// waiting for PDF to process
		driver.navigate().refresh();
		this.verify_AutoBE();
		this.verify_Ellipsis();
		this.hover_And_Click_Actions_Hide();
		Thread.sleep(1500);
		this.verify_History();
		this.click_Response_Required();
		Thread.sleep(1500);
		this.verify_Response_Approve();
		this.click_Response_Approve();
		Thread.sleep(1500);
		this.click_Submit_2();
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Open_Actions_Menu() -----------");
	}
	
	public void user_Can_Open_Actions_Menu_And_Respond_2() throws InterruptedException {
		this.verify_AutoBE();
		this.verify_Ellipsis();
		this.hover_And_Click_Actions_Hide();
		Thread.sleep(1500);
		this.verify_Manage();
		this.click_Response_Required();
		Thread.sleep(1500);
		this.verify_Response_Approve();
		this.click_Response_Approve();
		Thread.sleep(1500);
		this.click_Submit_2();
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Open_Actions_Menu_2() -----------");
	}
	
	public void user_Can_Open_Actions_Menu_View_Response() throws InterruptedException {
		this.verify_AutoBE();
		this.verify_Ellipsis();
		this.hover_And_Click_Actions_Hide();
		Thread.sleep(1500);
		this.verify_Manage();
		this.click_Manage();
		Thread.sleep(1500);
		this.verify_Manage_Approvals();
		this.click_Manage_Approvals();
		Thread.sleep(1500);
		this.verify_Approve_Or_Deny();
		//-----------verify something here-------------
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Open_Actions_Menu() -----------");
	}
	
	// --------------- verify_Folders_In_Secured_Folders_Catergory() --------------------
	By secured_Folders = By.xpath("//a[contains(text(),'Secured Folders')]");
	By secured_Folders_Title = By.xpath("//h1[contains(text(),'Secured Folders')]");
	By resource_Library = By.xpath("//a[contains(text(),'Resource Library')]");
	
	public void verify_Secured_Folder_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(secured_Folders_Title)));
	}
	
	public void click_Secured_Folder_Cat() {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Secured Folders')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library() {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Resource Library')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void verify_Secured_Folders_Present() throws InterruptedException {
		String sec_folder1 = "(//span[contains(text(),'New Library Folder')])[1]";
		String sec_folder2 = "(//span[contains(text(),'New Library Folder 2')])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(sec_folder1)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(sec_folder2)).size() > 0);
	}
	
	// --------------- Function being called --------------------
	public void verify_Folders_In_Secured_Folders_Catergory() throws InterruptedException {
		this.click_Secured_Folder_Cat();
		Thread.sleep(1500);
        this.verify_Secured_Folder_Title();
        this.verify_Secured_Folders_Present();
        this.click_Resource_Library();
		Thread.sleep(1500);
		System.out.println("------- Completed --> verify_Folders_In_Secured_Folders_Catergory() -----------");
	}
	
	// --------------- verify_File_Moved --------------------
	By folder_Path_Move = By.xpath("//ol[@class='breadcrumb']//a[contains(text(),'Resource Library')]/following::li[contains(text(),'New Library Folder')]");
	By library_Folder_1 = By.xpath("(//a[contains(text(),'New Library Folder')])[1]");
	
	public void verify_New_Library_Folder_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library_Folder_1)));
	}
	
	public void click_New_Library_Folder_1() {
		//driver.findElement(library_Folder_1).click();
		WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'New Library Folder')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------- Function being called --------------------
	public void verify_File_Moved() throws InterruptedException {
		this.verify_New_Library_Folder_1();
		this.click_New_Library_Folder_1();
		Thread.sleep(1500);
		this.verify_File_Created();
		System.out.println("------- Completed --> verify_File_Moved() -----------");
	}
	
	public void verify_File_Moved_2() throws InterruptedException {
		this.verify_New_Library_Folder_1();
		this.click_New_Library_Folder_1();
		Thread.sleep(1500);
		this.verify_File_Created_2();
		System.out.println("------- Completed --> verify_File_Moved_2() -----------");
	}
	
	// --------------- user_Moves_New_Folder --------------------
	By move_Option = By.xpath("//span[contains(text(),'Move')]");
	By security_Option = By.xpath("//li[@class='security']//a[contains(text(),'Security')]");
	By security_Option_2 = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Security')]");
	By security_Option_2B = By.xpath("//*[starts-with(@id,'resource_')]/td[6]/div/ul/li/a[contains(.,'Security')]");
	By copy_Link = By.xpath("//a[@class='copy-file-path']");
	By autoBE_Resource = By.xpath("//a[contains(@class,'workroom-2305')]");
	By moveBtn = By.xpath("//button[contains(text(),'Move')]");
	By move_Message = By.xpath("//p[contains(text(),'Files/Folders were successfully moved.')]");
	By close_Modal = By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']");
	//By security_Option_BM = By.xpath("//tbody/tr[@id='resource_21010']/td/div/ul/li/a[contains(.,'Security')]");
	By security_Option_BM = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Security')]");
	
	public void verify_Move_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_Option)));
	}
	
	public void verify_Security_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security_Option)));
	}
	
	public void verify_Security_Option_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security_Option_2)));
	}
	
	public void verify_Security_Option_2B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security_Option_2B)));
	}
	
	public void verify_Copy_Link() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(copy_Link)));
	}

	public void verify_AutoBE_Resource() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Resource)));
	}

	public void verify_Move_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_Message)));
	}
	
	public void verify_Security_Option_BM() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security_Option_BM)));
	}

	public void click_New_Folder_Dropdown() {
		// driver.findElement(new_Folder_Created).click();
		WebElement element = driver
				.findElement(By.xpath("//td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Move_Option() {
		// driver.findElement(edit_Option).click();
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Move')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option() {
		// driver.findElement(edit_Option).click();
		WebElement element = driver.findElement(By.xpath("//li[@class='security']//a[contains(text(),'Security')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option_2() {
		// driver.findElement(edit_Option).click();
		WebElement element = driver.findElement(By.xpath("(//li[@class='security']//a[contains(text(),'Security')])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option_2B() {
		// driver.findElement(edit_Option).click();
		WebElement element = driver.findElement(By.xpath("//*[starts-with(@id,'resource_')]/td[6]/div/ul/li/a[contains(.,'Security')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option_BM() {
		// driver.findElement(edit_Option).click();
		WebElement element = driver.findElement(By.xpath("(//*[starts-with (@id,'resource_')]/td[7]/div/ul/li[3]/a[1])[3]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Copy_Link() {
		// driver.findElement(edit_Option).click();
		WebElement element = driver.findElement(By.xpath("//a[@class='copy-file-path']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	

	public void click_AutoBE_Resource() {
		// driver.findElement(autoBE_Resource).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(@class,'workroom-2305')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Move_Btn() {
		// driver.findElement(cancel_Btn).click();
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Move')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Close_Resource() {
		// driver.findElement(close_Modal).click();
		WebElement element = driver.findElement(By.xpath("//div[@id='moveResourceModal']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Close_Security_Box() {
		// driver.findElement(close_Modal).click();
		WebElement element = driver.findElement(By.xpath("//div[@id='resourceAddUsersModal']//span[contains(text(),'×')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public void close_Modal() {
		// driver.findElement(close_Modal).click();
		WebElement element = driver.findElement(By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------- Function being called --------------------
	public void user_Moves_New_Folder() throws InterruptedException {
		this.click_New_Folder_Dropdown();
		Thread.sleep(1500);
		this.verify_Move_Option();
		this.click_Move_Option();
		Thread.sleep(1500);
		this.verify_AutoBE_Resource();
		this.click_AutoBE_Resource();
		Thread.sleep(4000);
		this.click_Move_Btn();
		Thread.sleep(1500);
		this.verify_Move_Message();
		Thread.sleep(1500);
		this.click_Close_Resource();
		Thread.sleep(1500);
		this.close_Modal();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Moves_New_Folder() -----------");
	}
	
	// --------------- click_New_Folder_2 --------------------

	By edit = By.xpath("//span[@class='translation_missing'][contains(text(),'Edit')]");
	By edit_Resource_Title = By.xpath("//form[@id='edit_vfile_file']//label[contains(text(),'Resource Title')]");
	By sample_File = By.xpath("//*[contains(text(),'Sample File')]");
	
	public void verify_Edit() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit)));
	}
	
	public void verify_Edit_Resource_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Resource_Title)));
	}
	
	public void verify_Sample_File_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sample_File)));
	}
	
	public void click_Edit() {
		//driver.findElement(library_Folder_1).edit();
		WebElement element = driver.findElement(By.xpath("//span[@class='translation_missing'][contains(text(),'Edit')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void edit_Resource_Title_SendKeys() {
		By input = By.xpath("//form[@id='edit_vfile_file']//input[@id='vfile_name']");
		String file_Title_Name ="Sample File";
		driver.findElement(input).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(input).clear();
		driver.findElement(input).sendKeys(file_Title_Name);	
	}
	
	public void user_Can_Edit_File() throws InterruptedException {
		this.click_File_Dropdown();
		this.verify_Edit();
		this.click_Edit();
		Thread.sleep(1500);
		this.verify_Edit_Resource_Title();
		this.edit_Resource_Title_SendKeys();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(2500);
		this.verify_Sample_File_Created();
		System.out.println("------- Completed --> user_Can_Edit_File() -----------");
	}
	
	public void user_Can_Edit_File_2() throws InterruptedException {
		this.click_File_Dropdown_3();
		this.verify_Edit();
		this.click_Edit();
		Thread.sleep(1500);
		this.verify_Edit_Resource_Title();
		this.edit_Resource_Title_SendKeys();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(2500);
		this.verify_Sample_File_Created();
		System.out.println("------- Completed --> user_Can_Edit_File() -----------");
	}
	
	// --------------- user_Can_Search_For_File --------------------
	
	By resource_Search = By.xpath("//input[@id='keyword']");
	By New_Resource_Folder_2 = By.xpath("//a[contains(text(),'New Resource Folder 2')]");

	public void click_Search_Field() {
		WebElement element = driver.findElement(By.xpath("//input[@id='keyword']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	} 
	
	public void sendKeys_Folder_File_Name(String folder1) throws InterruptedException {
		driver.findElement(resource_Search).clear();
		driver.findElement(resource_Search).click();
		driver.findElement(resource_Search).sendKeys(folder1);
		Thread.sleep(1500);
		driver.findElement(resource_Search).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
	} 
	
	public void verify_Folder_Or_File() throws InterruptedException {
		String folder = "//a[contains(text(),'New Library Folder')]";
		String file = "//a[contains(text(),'Word_1.docx')]";
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean Folder = driver.findElements(By.xpath(folder)).size() > 0;
		Boolean File = driver.findElements(By.xpath(file)).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (Folder == true) {
			Assert.assertTrue(driver.findElements(By.xpath(folder)).size() > 0);
		}else if(File == true){
			Assert.assertTrue(driver.findElements(By.xpath(file)).size() > 0);
		}
	} 

	public void user_Can_Search_For_Folder_File_Name(String folder1) throws InterruptedException {
		this.click_Search_Field();
		this.sendKeys_Folder_File_Name(folder1);
		this.verify_Folder_Or_File();
		System.out.println("------- Completed --> user_Can_Search_For_Folder_File_Name() -----------");
	}
	
	// --------------- user_Can_Delete_File --------------------
	By delete_File = By.xpath("//span[contains(text(),'Delete')]");
	
	public void verify_Delete() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_File)));
	}
	
	public void click_Sample_File_Dropdrown() {
		String sample_File_Dropdown ="//a[contains(text(),'Sample File')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
		WebElement element = driver.findElement(By.xpath(sample_File_Dropdown));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Delete() {
		//driver.findElement(delete_File).click();
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Delete')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	} 
	
	public void user_Can_Delete_File() throws InterruptedException {
		this.click_Sample_File_Dropdrown();
		Thread.sleep(1500);
		this.verify_Delete();
		this.click_Delete();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> user_Can_Delete_File() -----------");
	}
	
	public void user_Can_Delete_Private_Folder_File() throws InterruptedException {
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_File_Created();
		this.click_File_Dropdown();
		Thread.sleep(1500);
		//this.verify_Delete();
		this.click_Delete();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3500);
		System.out.println("------- Completed --> user_Can_Delete_Private_Folder_File() -----------");
	}
	
	public void user_Can_Delete_Private_Folder_File_2() throws InterruptedException {
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_Select_PC_File();
		this.click_File_Dropdown_2();
		Thread.sleep(1500);
		//this.verify_Delete();
		this.click_Delete();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3500);
		System.out.println("------- Completed --> user_Can_Delete_Private_Folder_File() -----------");
	}
	
	// --------------- user_Can_Delete_Folder --------------------
	By library_Folder = By.xpath("//a[contains(text(),'New Library Folder')]");
	By checkbox = By.xpath("(//a[contains(text(),'New Library Folder')]/preceding::p//input[starts-with(@id,'folder_')])[3]");
	By dropdown = By.xpath("//a[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By delete_Option = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_New_Library_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library_Folder)));
	}

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

	public void click_AutoBE_Library() {
		// driver.findElement(autoBE_Library).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(@class,'break-name')][contains(text(),'AutoBE')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Check_Box() {
		//driver.findElement(checkbox).click();
		WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'New Library Folder')]/preceding::p//input[starts-with(@id,'folder_')])[3]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Dropdown() {
		//driver.findElement(dropdown).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Delete_Option() {
		//driver.findElement(delete_Option).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_ContinueBtn() {
		//driver.findElement(continueBtn).click();
		WebElement element = driver.findElement(By.xpath("//button[@class='btn commit btn-danger']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------- Function being called --------------------
	public void user_Can_Delete_Folder() throws InterruptedException {
		this.click_AutoBE_Library();
		Thread.sleep(1500);
		this.verify_New_Library_Folder();
		this.click_Check_Box();
		Thread.sleep(1500);
		this.click_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		this.close_Modal();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Delete_Folder_B() throws InterruptedException {
		this.verify_New_Library_Folder();
		this.click_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		this.close_Modal();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	// --------------- user_Delete_Both_Folders --------------------
	By dropdown_1_Sec = By.xpath("//span[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By dropdown_2 = By.xpath("//a[contains(text(),'New Library Folder 2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By dropdown_2_Sec = By.xpath("//span[contains(text(),'New Library Folder 2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By new_Folder_Dropdown = By.xpath("//*[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");


	public void verify_Folder_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(dropdown)));
	}
	
	public void verify_Folder_1_Dropdown_Sec() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(dropdown_1_Sec)));
	}
	
	public void verify_Folder_2_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(dropdown_2)));
	}
	
	public void verify_Folder_2_Dropdown_Sec() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(dropdown_2_Sec)));
	}
	
	public void verify_Folder_1_Dropdown_B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Dropdown)));
	}
	
	public void click_Dropdown_1() {
		//driver.findElement(dropdown).click();
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Dropdown_1_B() {
		//driver.findElement(dropdown).click();
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Dropdown_2() {
		//driver.findElement(dropdown).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'New Library Folder 2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Dropdown_2b() {
		//driver.findElement(dropdown).click();
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'New Library Folder 2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void user_Delete_Folder_1() throws InterruptedException {
		this.verify_Folder_1_Dropdown_B();
		this.click_Dropdown_1_B();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		System.out.println("------- Completed --> user_Delete_Folder_1() -----------");
	}
	// --------------- Function being called ----------------------
	public void user_Delete_Both_Folders() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_Folder_1_Dropdown_Sec();
		this.click_Dropdown_1();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		//------------------------
		this.user_Close_Library_Folder();
		this.user_Can_Open_Libraries_Form_2();
		//--------------------------
        this.verify_Folder_2_Dropdown_Sec();
        this.click_Dropdown_2b();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Both_Folders() -----------");
	}
	
	public void user_Delete_Both_Folders_B() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_Folder_1_Dropdown();
		this.click_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		//------------------------
		this.user_Close_Library_Folder();
		this.user_Can_Open_Libraries_Form_2();
		//--------------------------
        this.verify_Folder_2_Dropdown();
        this.click_Dropdown_2();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Both_Folders() -----------");
	}
	// --------------- Function being called ----------------------
	public void user_Delete_Folder_2() throws InterruptedException {
        this.verify_Folder_2_Dropdown();
        this.click_Dropdown_2();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Folder_2() -----------");
	}
	
	// --------------- Function being called ----------------------
	public void user_Delete_Folder_2b() throws InterruptedException {
        this.verify_Folder_2_Dropdown_Sec();
        this.click_Dropdown_2b();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Folder_2b() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Close_Library_Folder() throws InterruptedException {
		this.close_Modal();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Close_Library_Folder() -----------");
	}

	// --------------- verify_Folder_Deleted --------------------
	public void verify_Folder_NOT_Present() throws InterruptedException {
		String file_Title = "//a[contains(text(),'New Library Folder')]";
		Assert.assertTrue(driver.findElements(By.xpath(file_Title)).size() < 1);
	}
	
	// --------------- verify_Folder_Deleted --------------------
	public void verify_Folder2_NOT_Present() throws InterruptedException {
		String file_Title = "//a[contains(text(),'New Library Folder 2')]";
		Assert.assertTrue(driver.findElements(By.xpath(file_Title)).size() < 1);
		System.out.println("------- Completed --> verify_Folder2_NOT_Present() -----------");

	}
	
	// --------------- verify_Folder_Deleted --------------------
	public void verify_Both_Folders_NOT_Present() throws InterruptedException {
		String file_Title = "//a[contains(text(),'New Library Folder')]";
		String file_Title_2 = "//a[contains(text(),'New Library Folder 2')]";
		Assert.assertTrue(driver.findElements(By.xpath(file_Title)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(file_Title_2)).size() < 1);
	}

	// --------------- Function being called --------------------
	public void verify_AutoBE_Folder_Deleted() throws InterruptedException {
		Thread.sleep(2000);
		this.click_AutoBE_Library();
		Thread.sleep(1500);
		this.verify_Folder_NOT_Present();
		this.close_Modal();
		Thread.sleep(1500);
		System.out.println("------- Completed --> verify_Folder_Deleted() -----------");
	}
	
	// --------------- Function being called --------------------
	public void verify_Folder_Deleted_B() throws InterruptedException {
		Thread.sleep(2000);
		this.verify_Folder_NOT_Present();
		this.close_Modal();
		Thread.sleep(1500);
		System.out.println("------- Completed --> verify_Folder_Deleted() -----------");
	}
	
// --------------- Function being called --------------------
	public void verify_Both_Folders_Deleted() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Both_Folders_NOT_Present();
		this.close_Modal();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_Both_Folders_Deleted() -----------");
	}
	
	// --------------- Function being called --------------------
	public void verify_Resource_Library_Folder_Deleted() throws InterruptedException {		
		this.verify_Folder_NOT_Present();
		this.close_Modal();
		Thread.sleep(1500);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_Deleted() -----------");
	}
}
