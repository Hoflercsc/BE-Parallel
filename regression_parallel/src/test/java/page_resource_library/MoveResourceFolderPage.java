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
import page_common_functions.AtlasNavBar;
import parallel.DriverFactory;

public class MoveResourceFolderPage {
	// ----------- POM Page Object model -----------------------------
	
	By libraries = By.xpath("//span[contains(text(),'Libraries')]");
	By new_Folder_Link = By.xpath("//a[@class='new-folder']");
	By new_Folder = By.xpath("//a[contains(text(),'New Library Folder')]");
	By approvals_Folder = By.xpath("//a[contains(text(),'Approvals')]");
	By autoBE_Library = By.xpath("//a[contains(@class,'break-name')][contains(text(),'AutoBE')]");
	By private_Folder = By.xpath("//a[contains(text(),'Your Private Folder')]");
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By autoBE_RL = By.xpath("//body/div[@id='filesModal']//div/ul/li/a[contains(.,'AutoBE')]");
	By resource_Library_Table_Sorter = By.xpath("//table[@id='resource-library-tablesorter']");
	By attach_Folder = By.xpath("//a[contains(text(),'Attach')]");
	By large_Book_Folder = By.xpath("//a[contains(text(),'Large Book')]");
	By click_For_More_Options = By.xpath("//a[contains(text(),'click for more options')]");
	By file_Created_RL = By.xpath("//a[contains(text(),'Word_1.docx')]");
	By new_Folder_2 = By.xpath("//a[contains(text(),'New Library Folder 2')]");

	// ----------------user_Can_Open_Libraries_Form()---------------------------------
	public void verify_Libraries() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(libraries)));
	}

	public void verify_New_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Link)));
	}

	public void verify_AutoBE_Library() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Library)));
	}
	
	public void verify_Your_Private_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(private_Folder)));
	}
	
	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}
	
	public void verify_AutoBE_RL() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_RL)));
	}
	
	public void verify_Resource_Library_Table_Sorter() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Library_Table_Sorter)));
	}

	public void verify_Click_For_More_Options() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options)));
	}
	
	public void verify_Word_1_Docx_File_Created_RL() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Created_RL)));
	}
	
	public void verify_New_Folder_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder)));
	}

	public void click_Libraries() {
		//DriverFactory.getInstance().getDriver().findElement(libraries).click();
		String library = "//span[contains(text(),'Libraries')]";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(library));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_New_Folder_2() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_2).click();
	}
	
	public void click_AutoBE_Resource_Library_WR() {
		DriverFactory.getInstance().getDriver().findElement(autoBE_RL).click();
	}
	
	public void click_Attach_Folder() {
		DriverFactory.getInstance().getDriver().findElement(attach_Folder).click();
	}
	
	public void click_Large_Book_Folder() {
		DriverFactory.getInstance().getDriver().findElement(large_Book_Folder).click();
	}
	
	public void click_For_More_Options() {
		DriverFactory.getInstance().getDriver().findElement(click_For_More_Options).click();
	}

	public void verify_Board_Member_Folders_Present() {
		String attach = "//a[contains(text(),'Attach')]";
		String largeBook = "//a[contains(text(),'Large Book')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(attach)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(largeBook)).size() > 0);
	}
	
	public void verify_Board_Member_Folders_Present_2() {
		// difference between 1 & 2 is the spelling of large book 
		String attach = "//a[contains(text(),'Attach')]";
		String largeBook = "//a[contains(text(),'Large Book')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(attach)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(largeBook)).size() > 0);
	}
	
	public void verify_Files_in_Attach_Folder() {
		String minutesExport = "//a[contains(text(),'MinutesExport (15).docx')]";
		String toAttach = "//a[contains(text(),'ToAttach')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(minutesExport)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(toAttach)).size() > 0);
	}
	
	public void verify_Created_File_NOT_Present() throws InterruptedException {
		String created_File = "//*[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(created_File)).size() < 1);
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Attach_Folder_Files_Present() -----------");
	}
	
	public void verify_Secured_File_Not_Present() throws InterruptedException {
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.verify_File_Not_Present_In_Library_Folder();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Attach_Folder_Files_Present() -----------");
	}
		
	public void verify_Large_Book_Folder_Files_Present() throws InterruptedException {
		this.click_Large_Book_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.verify_Files_in_Attach_Folder();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		this.verify_Word_1_Docx_File_Created_RL();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> add_File_To_Attach_Folder() -----------");
	}
	
	public void verify_Created_File() throws InterruptedException {
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		Thread.sleep(1000);
		this.verify_Word_1_Docx_File_Created_RL();
		System.out.println("------- Completed --> add_File_To_Attach_Folder() -----------");
	}
	
	public void user_Can_Delete_File_RL() throws InterruptedException {
		this.click_Word_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete();
		this.click_Delete();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
	By new_Folder_Approvals = By.xpath("//*[starts-with (@id,'resource_')]/td/a[contains(.,'Approvals')]");
	By sub_Folder1_Created = By.xpath("//*[contains(text(),'Sub Folder1')]");
	By sub_Folder2_Created = By.xpath("//*[contains(text(),'Sub Folder2')]");
	//------------------------------
	By resource_Libray_Folder_2_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 2']");
	By resource_Libray_Folder_3_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 3']");
	By resource_Libray_Folder_4_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 4']");
	By resource_Libray_Folder_5_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 5']");
	By resource_Libray_Folder_6_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 6']");
	By resource_Libray_Folder_7_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 7']");
	By resource_Libray_Folder_8_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 8']");
	By resource_Libray_Folder_11_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 11']");
	By resource_Libray_Folder_12_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 12']");
	By resource_Libray_Folder_14_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 14']");
	By resource_Libray_Folder_15_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 15']");
	By resource_Libray_Folder_16_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 16']");
	By resource_Libray_Folder_17_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 17']");
	By resource_Libray_Folder_18_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 18']");
	By resource_Libray_Folder_19_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 19']");
	By resource_Libray_Folder_20_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 20']");
	By resource_Libray_Folder_21_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 21']");

	//------------------------------
	By new_Folder_1 = By.xpath("//*[@id='library']/li/a");
	By new_Folder_4 = By.xpath("//a[contains(text(),'New Library Folder 4')]");
	By new_Folder_5 = By.xpath("//a[contains(text(),'New Library Folder 5')]");
	By new_Folder_6 = By.xpath("//a[contains(text(),'New Library Folder 6')]");
	By new_Folder_7 = By.xpath("//a[contains(text(),'New Library Folder 7')]");
	By new_Folder_8 = By.xpath("//a[contains(text(),'New Library Folder 8')]");
	By new_Folder_9 = By.xpath("//*[normalize-space(text()) ='New Library Folder 9']"); // need the //*
	By new_Folder_11 = By.xpath("//*[normalize-space(text()) ='New Library Folder 11']"); // need the //*
	By new_Folder_12 = By.xpath("//*[normalize-space(text()) ='New Library Folder 12']"); // need the //*
	By new_Folder_14 = By.xpath("//*[normalize-space(text()) ='New Library Folder 14']"); // need the //*
	By new_Folder_16 = By.xpath("//*[normalize-space(text()) ='New Library Folder 16']"); // need the //*
	By new_Folder_17 = By.xpath("//*[normalize-space(text()) ='New Library Folder 17']"); // need the //*
	By new_Folder_18 = By.xpath("//*[normalize-space(text()) ='New Library Folder 18']"); // need the //*
	By new_Folder_19 = By.xpath("//*[normalize-space(text()) ='New Library Folder 19']"); // need the //*
	By new_Folder_20 = By.xpath("//*[normalize-space(text()) ='New Library Folder 20']"); // need the //*
	
	By view_Only_Folder_2 = By.xpath("//*[contains(text(),'New View Only Folder 2')]");
	By view_Only_Folder_9 = By.xpath("//*[normalize-space(text()) ='New Library Folder 9']/i[@title='View Only']");
	By view_Only_Folder_17 = By.xpath("//*[normalize-space(text()) ='New Library Folder 17']/i[@title='View Only']");
	By view_Only_Folder_13 = By.xpath("//*[normalize-space(text()) ='New Library Folder 13']");
	
	public void verify_Resource_Libray_Folder_2_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_2_Created)));
	}
	
	public void verify_Resource_Libray_Folder_3_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_3_Created)));
	}
	
	public void verify_Resource_Libray_Folder_4_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_4_Created)));
	}
	
	public void verify_Resource_Libray_Folder_5_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_5_Created)));
	}
	
	public void verify_Resource_Libray_Folder_6_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_6_Created)));
	}
	
	public void verify_Resource_Libray_Folder_7_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_7_Created)));
	}
	
	public void verify_Resource_Libray_Folder_8_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_8_Created)));
	}
	
	public void verify_View_Only_Permissions_View_Only_Folder_9_Enabled() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(view_Only_Folder_9)));
	}
	
	public void verify_View_Only_Permissions_View_Only_Folder_17_Enabled() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(view_Only_Folder_17)));
	}
	
	public void verify_View_Only_Permissions_View_Only_Folder_17_Disabled() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_Folder_17)));
	}
	
	public void verify_Resource_Libray_Folder_11_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_11_Created)));
	}
	
	public void verify_Resource_Libray_Folder_12_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_12_Created)));
	}
	
	public void verify_View_Only_Folder_13() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(view_Only_Folder_13)));
	}
	
	public void verify_Resource_Libray_Folder_14_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_14_Created)));
	}
	
	public void verify_Resource_Libray_Folder_15_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_15_Created)));
	}
	
	public void verify_Resource_Libray_Folder_16_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_16_Created)));
	}
	
	public void verify_Resource_Libray_Folder_17_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_17_Created)));
	}
	
	public void verify_Resource_Libray_Folder_18_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_18_Created)));
	}
	
	public void verify_Resource_Libray_Folder_19_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_19_Created)));
	}
	
	public void verify_Resource_Libray_Folder_20_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_20_Created)));
	}
	
	public void verify_Resource_Libray_Folder_21_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_21_Created)));
	}
	
	//------------------------------
	public void verify_New_Folder_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Name_Field)));
	}

	public void verify_New_Folder_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Created)));
	}
	
	public void verify_Approval_Folder_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_Folder_Approvals)));
	}

	public void click_New_Folder() {
		String new_Folder_Link = "//a[@class='new-folder']";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(new_Folder_Link));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_View_Only_Folder_2() {
		DriverFactory.getInstance().getDriver().findElement(view_Only_Folder_2).click();
	}
	
	public void click_New_Folder_1() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_1).click();
	}
	
	public void click_New_Folder_4() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_4).click();
	}
	
	public void click_New_Folder_5() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_5).click();
	}
	
	public void click_New_Folder_6() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_6).click();
	}

	public void click_New_Folder_7() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_7).click();
	}
	
	public void click_New_Folder_8() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_8).click();
	}
	
	public void click_New_Folder_9() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_9).click();
	}
	
	public void click_New_Folder_11() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_11).click();
	}
	
	public void click_New_Folder_12() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_12).click();
	}
	
	public void click_View_Only_Folder_13() {
		DriverFactory.getInstance().getDriver().findElement(view_Only_Folder_13).click();
	}
	
	public void click_New_Folder_16() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_16).click();
	}
	
	public void click_New_Folder_17() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_17).click();
	}
	
	public void click_New_Folder_20() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_20).click();
	}
	
	public void click_Approvals_Folder() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_6).click();
	}
	
	
	public void click_New_Folder_In_Workroom() {
		DriverFactory.getInstance().getDriver().findElement(new_Folder).click();
	}

	public void folder_Name_SendKeys(String newlibraryfolder2) {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_Name_Field).sendKeys(newlibraryfolder2);
	}
	
	public void folder_Named_Approvals() {
		String folder_Name = "Approvals";
		DriverFactory.getInstance().getDriver().findElement(new_Folder_Name_Field).sendKeys(folder_Name);
	}

	public void click_SaveBtn() {
		DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}

	public void click_To_Enable_View_Only_Box() {
		String string = "//input[@id='efolder_view_only']";
		WebElement view_Only = DriverFactory.getInstance().getDriver().findElement(By.xpath(string));
		
		if(!view_Only.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", view_Only);
		}
	}
	// --------------- Function being called --------------------
		
	public void user_Can_Create_Folder_Named_Approvals_Folder() throws InterruptedException {
		Thread.sleep(1500);// add wait so folder appears in workroom
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Named_Approvals();
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_Approval_Folder_Created();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Create Folder_Name_Approvals_Folder() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Create_Resource_Library_Folder_2(String newlibraryfolder2) throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder2);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_Resource_Libray_Folder_2_Created();
		System.out.println("------- Completed --> user_Can_Create_2nd_Resource_Library_Folder() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_3(String newlibraryfolder3) throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_Resource_Libray_Folder_3_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_3() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_4(String newlibraryfolder3) throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_Resource_Libray_Folder_4_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_4() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_5(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_Resource_Libray_Folder_5_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_5() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_6(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1000); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_6_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_6() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_7(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1000); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_7_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_7() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_8(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(2000); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_8_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_8() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_11(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(2000); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_11_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_11() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_12(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(2000); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_11_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_12() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_15(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(2000); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_15_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_15() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_16(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_16_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_16() -----------");
	}
	
	public void user_Create_View_Only_Resource_Library_Folder_17(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_To_Enable_View_Only_Box();
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_17_Created();
		System.out.println("------- Completed --> user_Create_View_Only_Resource_Library_Folder_17() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_18(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_18_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_11() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_19(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_19_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_19() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_20(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_20_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_20() -----------");
	}
	
	public void user_Create_Resource_Library_Folder_21(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(2000); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_21_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_21() -----------");
	}
	
	
	// --------------- Edit-Existing-Folder-To-View-Only --------------------
	By new_Library_Folder = By.xpath("//span[contains(text(),'New Library Folder')]");
	By new_Library_Folder_2 = By.xpath("//a[contains(text(),'New Library Folder')]");
	By pdf_Drp_Dwn = By.xpath("//*[contains(text(),'ScannedDocument.pdf')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	
	//------------------Parallel--------------
	By new_View_Only_Folder_1 = By.xpath("//*[normalize-space(text()) ='New View Only Folder 1']");
	By sub_Folders_In_View_Only = By.xpath("//*[normalize-space(text()) ='Sub Folders In View Only']");

	public void click_New_View_Only_Folder_1() {
		DriverFactory.getInstance().getDriver().findElement(new_View_Only_Folder_1).click();
	}
	
	public void click_Sub_Folders_In_View_Only() {
		DriverFactory.getInstance().getDriver().findElement(sub_Folders_In_View_Only).click();
	}
	
	public void verify_View_Only_Folder_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_View_Only_Folder_1)));
	}
	
	public void verify_Sub_Folders_In_View_Only() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sub_Folders_In_View_Only)));
	}
	
	
	public void verify_View_Only_Folder_Permissions_Enabled() {
		String view_Only = "//tbody//tr/td[2]/a[1]/span[1]/i[@title='View Only']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(view_Only)).size() > 0);
	}
	
	//-----------------------------
	
	public void verify_New_Lib_Folder_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Library_Folder_2)));
	}
	
	public void verify_PDF_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pdf_Drp_Dwn)));
	}

	public void verify_View_Only_Folder_Permissions_Disabled() {
		String view_Only_Icon = "//i[@class='fa fa-desktop smallest-left']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(view_Only_Icon)).size() < 1);
	}
	
	public void verify_View_Only_File_Permissions_Enabled() {
		String click_For_More_Options = "//a[contains(text(),'click for more options')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(click_For_More_Options)).size() < 1);
	}
	
	public void verify_View_PDF_File_Permissions_Enabled() {
		String pdf = "//*[normalize-space(text()) ='ScannedDocument.pdf']/i[@title='View Only']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pdf)).size() > 0);
	}
	
	public void verify_View_PDF_File_Permissions_Disabled() {
		String pdf = "//*[normalize-space(text()) ='ScannedDocument.pdf']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pdf)).size() < 1);
	}
	
	public void verify_View_Only_File_Permissions_Disabled() {
		String click_For_More_Options = "//a[contains(text(),'click for more options')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(click_For_More_Options)).size() > 0);
	}
	
	public void click_PDF_Drp_Dwn() {
		DriverFactory.getInstance().getDriver().findElement(pdf_Drp_Dwn).click();
	}
	
	public void click_Scanned_PDF() {
		DriverFactory.getInstance().getDriver().findElement(scanned_PDF_File).click();
	}
	
	public void add_File_Resource_Copy_Link() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void verify_View_Only_Permissions() throws InterruptedException {
		this.verify_New_Library_Folder_1();
		this.verify_View_Only_Folder_Permissions_Enabled();
		this.click_New_View_Only_Folder_1();
		Thread.sleep(1500);
		this.verify_Scanned_PDF_File_Created();
		this.verify_View_Only_File_Permissions_Enabled();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_View_Only_Permissions() -----------");
	}
	
	public void verify_View_Only_Permissions_Folder_9() throws InterruptedException {
		Thread.sleep(1500);//---pause make sure inside folder
		this.verify_View_Only_Permissions_View_Only_Folder_9_Enabled();
		this.click_New_Folder_9();
		Thread.sleep(1500);
		this.verify_Scanned_PDF_File_Created();
		this.verify_View_PDF_File_Permissions_Enabled();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_View_Only_Permissions_Folder_9() -----------");
	}
	
	public void verify_View_Only_Permissions_Folder_17() throws InterruptedException {
		this.verify_View_Only_Permissions_View_Only_Folder_17_Enabled();
		this.click_New_Folder_17();
		Thread.sleep(1500);
		this.verify_Scanned_PDF_File_Created();
		this.verify_View_PDF_File_Permissions_Enabled();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_View_Only_Permissions_Folder_17() -----------");
	}
	
	public void verify_View_Only_Permissions_Folder_17_Disabled() throws InterruptedException {
		this.verify_New_Lib_Folder_2();
		this.verify_View_Only_Permissions_View_Only_Folder_17_Disabled();
		this.click_New_Folder_17();
		Thread.sleep(1000);
		this.verify_Scanned_PDF_File_Created();
		this.verify_View_PDF_File_Permissions_Enabled();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_View_Only_Permissions_Disabled() -----------");
	}
	
	public void verify_Boardmember_View_Only_Permissions() throws InterruptedException {
		this.verify_View_Only_Folder_1();
		this.verify_View_Only_Folder_Permissions_Enabled();
		this.click_New_View_Only_Folder_1();
		Thread.sleep(1500);
		this.verify_Scanned_PDF_File_Created();
		//this.verify_View_Only_File_Permissions_Enabled(); board member can add files
		this.click_Scanned_PDF();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_View_Only_Permissions() -----------");
	}
	
	By hour_Glass = By.xpath("//tbody/tr[starts-with(@id,'resource_')]/td[3]/span[1]/i[1]");
	public void verify_Hour_Glass_Invisible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(hour_Glass)));
	}
	
	public void can_Add_File_View_Only_Folder() throws InterruptedException {
		this.click_New_View_Only_Folder_1();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_Copy_Link();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(500);
		this.verify_Hour_Glass_Invisible();
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> can_Add_File_View_Only_Folder() -----------");
	}
	
	public void user_Can_Add_File_To_Folder_Copy_File_Link_Non_View_Only() throws InterruptedException {
		this.click_Copy_File_Link_Folder();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_Copy_Link();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(1000);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_To_Folder_Copy_File_Link_Non_View_Only() -----------");
	}
	

	public void add_File_To_Folder_Copy_Link_Folder_2_View_Only() throws InterruptedException {
		this.click_Copy_File_Link_Folder_2();
		Thread.sleep(1000);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_1B();
		Thread.sleep(1000);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		//this.verify_Word_1_Docx_File_Created();
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> add_File_To_Copy_Link_Folder_2_View_Only() -----------");
	}
	
	public void user_Can_Add_File_To_Workroom_Folder() throws InterruptedException {
		this.click_New_Folder_In_Workroom();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_Copy_Link();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(1000);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_Folder_Non_Read_Only() -----------");
	}
	
	public void user_Can_Add_File_To_Workroom_Folder_20() throws InterruptedException {
		this.verify_Resource_Libray_Folder_20_Created();
		this.click_New_Folder_20();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_Copy_Link();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(1000);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_To_Workroom_Folder_20() -----------");
	}
	
	public void create_Sub_Folder1(String subfolder1) throws InterruptedException {
		Thread.sleep(1500); // give time make sure under correct folder 
		this.verify_Sub_Folders_In_View_Only();
		this.click_Sub_Folders_In_View_Only();
		Thread.sleep(1500);
		this.verify_New_Folder();
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(subfolder1);
		this.click_SaveBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> create_Sub_Folder1() -----------");
	}
	
	public void create_Sub_Folder2(String subfolder2) throws InterruptedException {
		Thread.sleep(1500); // give time make sure under correct folder 
		this.verify_New_Folder();
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(subfolder2);
		this.click_SaveBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> create_Sub_Folder2() -----------");
	}
	
	public void copy_File_Link() throws InterruptedException, UnsupportedFlavorException, IOException {
		this.verify_New_Library_Folder_1();
		this.click_New_View_Only_Folder_1();
		Thread.sleep(2000);
		this.verify_PDF_Drp_Dwn();
		this.click_PDF_Drp_Dwn();
		Thread.sleep(1000);
		this.verify_Copy_Link();
		this.click_Copy_Link();
		Thread.sleep(2000);
		System.out.println("------- Completed --> open_Email_File_Link() -----------");
	}
	
	public void copy_File_Link_Non_View_Only_Folder() throws InterruptedException, UnsupportedFlavorException, IOException {
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
	
	public void copy_File_Link_Non_View_Only_Folder_20() throws InterruptedException, UnsupportedFlavorException, IOException {
		Thread.sleep(1000);// pause to make sure under right folder
		this.verify_Copy_File_Link_Folder_20();
		this.click_Copy_File_Link_Folder_20();
		Thread.sleep(1000);
		this.verify_PDF_Drp_Dwn();
		this.click_PDF_Drp_Dwn();
		Thread.sleep(1000);
		this.verify_Copy_Link();
		this.click_Copy_Link();
		Thread.sleep(3000);// wait 3 seconds after copy
		System.out.println("------- Completed --> copy_File_Link_Non_View_Only_Folder_20() -----------");
	}
	
	public void copy_File_Link_In_Copy_File_View_Only_Folder_2() throws InterruptedException, UnsupportedFlavorException, IOException {
		this.verify_Copy_File_Link_Folder_2();
		this.click_Copy_File_Link_Folder_2();
		Thread.sleep(1000);
		this.verify_PDF_Drp_Dwn();
		this.click_PDF_Drp_Dwn();
		Thread.sleep(1000);
		this.verify_Copy_Link();
		this.click_Copy_Link();
		Thread.sleep(2000);
		System.out.println("------- Completed --> copy_File_Link_In_Copy_File_View_Only_Folder_2() -----------");
	}
	
	By agendaTab_MR = By.xpath("//div[@class='col-md-4']//a[contains(.,'AgendaTab')]");
	By autoBE_MR = By.xpath("//div[@class='col-md-4']//a[contains(.,'AutoBE')]");
	By attach_MR = By.xpath("//*[@id='library']/li[1]/a[contains(.,'Attach')]");
	By email_Link = By.xpath("(//*[starts-with (@id,'resource_')]/td/div/ul/li/a[contains(.,'Email Link')])[2]");

	By mr_New_Library_Folder_2 = By.xpath("//a[contains(text(),'New Library Folder 2')]");
	By mr_Destination_Text_Change = By.xpath("//span[@class='destination-name'][contains(text(),'New Library Folder 2')]");
	By mr_Move = By.xpath("//button[contains(text(),'Move')]");
	By mr_Message = By.xpath("//p[contains(text(),'Files/Folders were successfully moved')]");

	
	
	public void verify_AgendaTab_MR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(agendaTab_MR)));
	}
	
	public void verify_AutoBE_MR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(autoBE_MR)));
	}
	
	public void verify_Destination_Text_Change() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mr_Destination_Text_Change)));
	}
	
	public void verify_MR_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mr_Message)));
	}
	
	public void verify_New_Folder_MR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_Folder)));
	}
	
	public void verify_Attach_MR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(attach_MR)));
	}
	
	public void verify_Email_Link() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(email_Link)));
	}
	
	public void click_AgendaTab_MR() {
		DriverFactory.getInstance().getDriver().findElement(agendaTab_MR).click();
	}
	
	public void click_AutoBE_MR() {
		DriverFactory.getInstance().getDriver().findElement(autoBE_MR).click();
	}
	
	public void click_MR_DC_Library_Folder() {
		DriverFactory.getInstance().getDriver().findElement(mr_New_Library_Folder_2).click();
	}
	
	public void click_MR_Move() {
		DriverFactory.getInstance().getDriver().findElement(mr_Move).click();
	}
	
	public void click_Move_Option_2() {
		DriverFactory.getInstance().getDriver().findElement(move_Option_2).click();
	}
	
	public void click_Attach() {
		DriverFactory.getInstance().getDriver().findElement(attach_MR).click();
	}
	
	public void click_Email_Link() {
		DriverFactory.getInstance().getDriver().findElement(email_Link).click();
	}
	
	public void verify_File_Back_In_Workroom() throws InterruptedException {
		Thread.sleep(1500);
		this.click_Attach_Folder();
		this.verify_Click_For_More_Options();
		
		String element = "//*[contains(text(),'ToAttach')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	
	public void move_File_From_View_Only_Folder_13_To_Non_View_Only_Folder_14() throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.verify_View_Only_Folder_13();
		this.click_View_Only_Folder_13(); // view only folder with //span element
		Thread.sleep(1000);
		this.verify_Scanned_PDF_File_Created();
		this.click_Scanned_PDF_File_Dropdown();
		Thread.sleep(1000);
		this.verify_Move_Option();
        this.click_Move_Option();
		Thread.sleep(1000);
		this.verify_Space_Move_Resource_Folder();
		this.click_Space_Under_Move_Resource_Modal();
		Thread.sleep(2000); // wait 2 seconds for library folder surring parrellel execution
		this.verify_New_Library_Folder_14();
		this.click_New_Library_Folder_14();
		Thread.sleep(1000);
		this.click_MR_Move();
		Thread.sleep(1000);
		this.verify_Move_Message();
		this.click_Close_Resource();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> move_File_From_View_Only_To_Non_View_Only() -----------");
	}
	
	
	public void move_File_From_AutoBE_To_AgendaTab() throws InterruptedException {
		Thread.sleep(1500);// make sure under correct folder
		this.click_Attach_Folder();
		Thread.sleep(1500);
		this.click_File_Dropdown_C(); 
		Thread.sleep(1000);
		this.verify_Move_Option_2();
        this.click_Move_Option_2();
		Thread.sleep(1500);
		this.verify_AgendaTab_MR();
		this.click_AgendaTab_MR();
		Thread.sleep(1000);
		this.verify_New_Folder_MR();
		this.click_New_Folder_1();
		Thread.sleep(1000);
		//this.verify_Destination_Text_Change();
		this.click_MR_Move();
		Thread.sleep(3000);
		//this.verify_MR_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> move_File_From_AutoBE_To_AgendaTab() -----------");
	}
	
	public void go_To_Resource_Library_Email_Link() throws InterruptedException {
		Thread.sleep(1500); // pause to make sure under correct folder
		this.click_Attach_Folder();
		Thread.sleep(1500);
		this.click_File_Dropdown_C(); 
		Thread.sleep(1000);
		this.verify_Email_Link();
        this.click_Email_Link();
		Thread.sleep(1000);
		System.out.println("------- Completed --> go_To_Resource_Library_Email_Link() -----------");
	}
	
	public void move_File_Back_To_AutoBE() throws InterruptedException {
		Thread.sleep(1500); // pause to make sure under correct folder
		this.click_File_Dropdown_C(); 
		Thread.sleep(1000);
		this.verify_Move_Option();
        this.click_Move_Option();
		Thread.sleep(1500);
		this.verify_AutoBE_MR();
		this.click_AutoBE_MR();
		Thread.sleep(1000);
		this.verify_Attach_MR();
		this.click_Attach();
		Thread.sleep(1000);
		this.click_MR_Move();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> move_File_Back_To_AutoBE() -----------");
	}
	
	public void open_File_Link() throws InterruptedException {
	  //1st way to do this

	   	try {
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			Object data = clipboard.getData(DataFlavor.stringFlavor);
	         
			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			js.executeScript("window.open(\""+data+"\")");
			System.out.println(data);
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Thread.sleep(2000);

		/* 2nd way to do this
		WebElement copyfilepath = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='copy-file-path']"));
		String attribute = copyfilepath.getAttribute("data-clipboard-text");
		System.out.println(attribute);
		
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		js.executeScript("window.open(\""+attribute+"\")");
		*/
		System.out.println("------- Completed --> open_File_Link() -----------");
	}
	
	public void switch_Tab_Verify_Viewer_Element() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		// switching to iframe
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/iframe[1]"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// wait for element to apear in iframe
		//By panel = By.xpath("//body/div[@id='app']/div[@class='App']/div[@class='Header open']/div[@class='HeaderItems']/div[1]");
		By panel = By.xpath("//body/div[@id='app']/div[@class='App']");
		WebElement iframePanel = DriverFactory.getInstance().getDriver().findElement(panel);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframePanel)));
		Thread.sleep(4000);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		DriverFactory.getInstance().getDriver().close();
		// ---close 2nd Tab----
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh(); // back to main page
	}
	
	
	
	//---------------------add_File_To_Private_Folder----------------------
	By your_Private_Folder = By.xpath("//a[contains(text(),'Your Private Folder')]");
	By select_PC_File = By.xpath("//a[contains(text(),'select from your computer')]");
	By name_Header = By.xpath("//div[contains(text(),'Name')]");

	public void verify_Select_PC_File() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(select_PC_File)));
	}
	
	public void click_Your_Private_Folder() {
		//DriverFactory.getInstance().getDriver().findElement(your_Private_Folder).click();	
		WebElement element = DriverFactory.getInstance().getDriver().findElement(your_Private_Folder);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Select_PC_File() {
		//DriverFactory.getInstance().getDriver().findElement(select_PC_File).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(select_PC_File);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Name_Header() {
		//DriverFactory.getInstance().getDriver().findElement(name_Header).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(name_Header);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void verify_JPG_Following_Word_docx() {
		// sisco.jpg should be 1st followed by word file
		String element = "//*[contains(text(),'sisco.jpg')]/following::i[@class='fa fa-file-word-o fa-2x']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Word_Folowing_JPG() {
		// sisco.jpg should be 1st followed by word file
		String element = "//*[contains(text(),'Word_3.docx')]/following::i[@class='fa fa-file-image-o fa-2x']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
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
	
	public void add_File_To_Private_Folder_For_Sorting_1() throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_Select_PC_File();
		this.click_Select_PC_File();
		Thread.sleep(1500);
		this.verify_Browse();
		this.add_File_Resource_JPG();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> add_File_To_Private_Folder_For_Sorting() -----------");
	}
	
	public void add_File_To_Private_Folder_For_Sorting_2() throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_Select_PC_File();
		this.click_Select_PC_File();
		Thread.sleep(1500);
		this.verify_Browse();
		this.add_File_Resource_Word_3();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		System.out.println("------- Completed --> add_File_To_Private_Folder_For_Sorting_2() -----------");
	}
	
	// --------------- Function being called --------------------
	
	
	// --------------- Function being called --------------------
	public void verify_Sort_For_Private_Folder_Headers() throws InterruptedException {
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_Select_PC_File();
		this.click_Name_Header();
		Thread.sleep(1000);
		this.click_Name_Header();
		Thread.sleep(1000);
		this.verify_JPG_Following_Word_docx();
		this.click_Name_Header();
		Thread.sleep(1000);
		//this.verify_Word_Folowing_JPG();
		System.out.println("------- Completed --> verify_Sort_For_Private_Folder_Headers() -----------");
	}
		
	//---------------------user_Can_Add_Multiple_Files_To_Folder----------------------
	By click_More_Options_Link = By.xpath("//a[contains(text(),'click for more options')]");
	By browse = By.xpath("//div[@class='form-group']//span[@class='input-group-btn']");
	By resource_Save_Btn = By.xpath("//button[@id='newResourceSubmit']");
	//By file_Created = By.xpath("//a[contains(text(),'Word_1.docx')]");
	By scanned_PDF_File = By.xpath("//*[contains(text(),'ScannedDocument.pdf')]");
	By toAttach = By.xpath("//*[contains(text(),'ToAttach')]");


	public void click_More_Options_Link() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(click_More_Options_Link).click();
	}
	
	public void verify_Browse() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(browse)));
	}
	
	public void verify_Scanned_PDF_File_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(scanned_PDF_File)));
	}
	
	public void verify_File_ToAttach() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(toAttach)));
	}
	
	public void verify_Sub_Folder1_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(sub_Folder1_Created)));
	}
	
	public void verify_Sub_Folder2_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sub_Folder2_Created)));
	}
	
	public void verify_More_Options_Link() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_More_Options_Link)));
	}
	
	public void verify_Both_Files_Word_JPG_Not_Present() {
		String file = "//a[contains(text(),'Word_3.docx')]";
		String file2 = "//a[contains(text(),'sisco.jpg')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file2)).size() < 1);
	}
	
	public void add_File_Resource() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	
	public void add_File_Resource_Word_3() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_3.docx";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_File_Resource_1B() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_File_Resource_2() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_2.docx";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_File_Resource_JPG() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void click_Resource_Save_Btn() {
		//DriverFactory.getInstance().getDriver().findElement(resource_Save_Btn).click();	
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Save_Btn);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------- Function being called --------------------
	
	
	public void user_Can_Add_File_View_Only_Folder() throws InterruptedException {
		this.click_View_Only_Folder_2();
		Thread.sleep(1000);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_View_Only_Folder_2() -----------");
	}
	
	public void user_Can_Add_File_To_Folder() throws InterruptedException {
		this.click_New_Folder_4();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_to_2nd_Folder() -----------");
	}
	
	public void user_Can_Add_File_Folder_4() throws InterruptedException {
		this.click_New_Folder_4();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_Folder_4() -----------");
	}
	
	public void user_Can_Add_Multiple_Files_To_Folder_5() throws InterruptedException {
		this.click_New_Folder_5();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		//------------------------
		DriverFactory.getInstance().getDriver().navigate().refresh();
		AtlasNavBar obj = new AtlasNavBar();
		obj.workroom_Member_Open_Resource_Library_AutoAttend_WR();
		this.click_New_Folder_5();
		Thread.sleep(1500);
		this.verify_More_Options_Link();
		//--------------------------
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_2();
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> user_Can_Add_Multiple_Files_To_Folder_5() -----------");
	}
	
	public void user_Can_Add_File_Folder_6() throws InterruptedException {
		this.click_New_Folder_6();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_Folder_6() -----------");
	}
	
	public void user_Can_Add_File_View_Only_Folder_9() throws InterruptedException {
		this.click_New_Folder_9();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_1B();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_View_Only_Folder_9() -----------");
	}
	
	public void user_Can_Add_File_Folder_12() throws InterruptedException {
		this.click_New_Folder_12();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_Folder_12() -----------");
	}
	
	public void user_Can_Add_File_To_View_Only_Folder_13() throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_View_Only_Folder_13();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_1B();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(2500);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_Folder_13() -----------");
	}
	
	public void user_Can_Add_File_To_Folder_16() throws InterruptedException {
		this.click_New_Folder_16();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(1500);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_To_View_Only_Folder_16() -----------");
	}
	
	public void user_Can_Add_File_To_Folder_17() throws InterruptedException {
		this.click_New_Folder_17();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_1B();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(1500);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_To_Folder_17() -----------");
	}
	
	public void user_Can_Add_File_To_Folder_20() throws InterruptedException {
		Thread.sleep(1000);// pause to make sure under right folder
		this.click_New_Folder_20();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_1B();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(1500);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_To_Folder_20() -----------");
	}
	
	public void user_Can_Add_File_Folder_1B() throws InterruptedException {
		this.click_New_Folder_4();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_1B();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_Folder_1B() -----------");
	}
	
	public void user_Can_Add_File_Folder_8() throws InterruptedException {
		this.click_New_Folder_8();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_1B();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_Folder_8() -----------");
	}
	
	public void user_Can_Add_File_To_Approvals_Folder() throws InterruptedException {
		this.click_Approvals_Folder();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_1B();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(3500);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_To_Approvals_Folder() -----------");
	}
	// --------------- Function being called --------------------
	
	
	public void add_File_For_Board_Member() throws InterruptedException {
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(2500);
		this.verify_Word_1_Docx_File_Created();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> add_File_For_Board_Member() -----------");
	}
	
	// --------------- Function being called --------------------
	
	
	// --------------- Function being called --------------------
	public void verify_Folder_Not_Present() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Resource_Library_Folder_2_NOT_Present();
		this.close_Modal();
		System.out.println("------- Completed --> verify_Folder_Not_Present() -----------");
	}
	
	// --------------- user_Can_Move_File--------------------
	By file_Dropdown = By.xpath("//a[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By file_Dropdown_B = By.xpath("//*[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By file_Dropdown_2B = By.xpath("//*[contains(text(),'ScannedDocument.pdf')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By file_Dropdown_C = By.xpath("//*[contains(text(),'ToAttach')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");

	String wordfileDropdown ="//*[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	String wordfile3Dropdown ="//*[contains(text(),'Word_3.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	String fileDropdown2 ="//a[contains(text(),'sisco.jpg')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	String scanned_PDF_File_Dropdown ="//*[contains(text(),'ScannedDocument.pdf')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	By Move_New_Libary_Folder = By.xpath("//ul[@id='library']//li[1]//a[1]");
	By workroom_Admin = By.xpath("//div[contains(text(),'Workroom Admin')]");
	By workroom_Admin_User = By.xpath("//div[@class='row small-left']//div[@class='person-name'][contains(text(),'Workroom Admin')]");
	By lockout_User = By.xpath("//div[contains(text(),'lockout user')]");
	By lockout_User_2 = By.xpath("//div[contains(text(),'lockout user 2')]");
	By lockout_User_Added = By.xpath("//div[@class='row small-left']//div[@class='person-name'][contains(text(),'lockout user')]");
	By lockout_User_2_Added = By.xpath("//div[@class='row small-left']//div[@class='person-name'][contains(text(),'lockout user 2')]");
	By dc_Move_Resource = By.xpath("//*[@id=\"moveResourceModal\"]//div/ul/li/a[contains(text(),'DC')]");
	By autoAttend_Move_Resource = By.xpath("//*[@id='moveResourceModal']//div/ul/li/a[contains(text(),'AutoAttend')]");
	By space_Move_Resource = By.xpath("//*[@id='moveResourceModal']//div/ul/li/a[contains(text(),'Space')]");


	By new_MR_Library_Folder_11 = By.xpath("(//*[@id='library']/li/a[@class='move-to'])[1]"); // rest is in iframe
	By new_MR_Library_Folder_14 = By.xpath("(//*[@id='library']/li/a[@class='move-to'])[2]"); // rest is in iframe
	

	public void verify_Move_Library_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(Move_New_Libary_Folder)));
	}
	
	public void verify_DC_Move_Resource_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(dc_Move_Resource)));
	}
	
	public void verify_AutoAttend_Move_Resource_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(autoAttend_Move_Resource)));
	}
	
	public void verify_Space_Move_Resource_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(space_Move_Resource)));
	}
	
	public void verify_New_Library_Folder_11() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_MR_Library_Folder_11)));
	}
	
	public void verify_New_Library_Folder_14() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_MR_Library_Folder_14)));
	}
	
	public void verify_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin)));
	}
	
	public void verify_Workroom_Admin_User() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_User)));
	}
	
	public void verify_Approval_File() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Dropdown)));
	}
	
	public void verify_Approval_File_B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Dropdown_B)));
	}
	
	public void verify_Approval_File_2B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Dropdown_2B)));
	}
	
	public void verify_Lockout_User() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(lockout_User)));
	}
	
	public void verify_Lockout_User_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(lockout_User_2)));
	}
	
	public void verify_Lockout_User_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(lockout_User_Added)));
	}
	
	public void verify_Lockout_User_2_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(lockout_User_2_Added)));
	}
	
	public void click_New_Library_Folder_11() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(new_MR_Library_Folder_11);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_New_Library_Folder_14() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(new_Folder_14);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	public void click_Word_File_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(wordfileDropdown));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_JPG_File_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(fileDropdown2));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_File_Dropdown_2() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(wordfileDropdown));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Scanned_PDF_File_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(scanned_PDF_File_Dropdown));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_File_Dropdown_C() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement((file_Dropdown_C));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	public void click_New_Library_Folder() {
		//DriverFactory.getInstance().getDriver().findElement(Move_New_Libary_Folder).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//ul[@id='library']//li[1]//a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_DC_Under_Move_Resource_Modal() {
		//DriverFactory.getInstance().getDriver().findElement(Move_New_Libary_Folder).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(dc_Move_Resource);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AutoAttend_Under_Move_Resource_Modal() {
		//DriverFactory.getInstance().getDriver().findElement(Move_New_Libary_Folder).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(autoAttend_Move_Resource);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Space_Under_Move_Resource_Modal() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(space_Move_Resource);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Workroom_Admin() {
		//DriverFactory.getInstance().getDriver().findElement(Move_New_Libary_Folder).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Workroom Admin')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Lockout_User() {
		//DriverFactory.getInstance().getDriver().findElement(Move_New_Libary_Folder).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'lockout user')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Lockout_User_2() {
		//DriverFactory.getInstance().getDriver().findElement(Move_New_Libary_Folder).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'lockout user 2')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Move_File() throws InterruptedException {
		this.click_Word_File_Dropdown();
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
	
	public void user_Can_Move_File_Folder_11() throws InterruptedException {
		this.click_Word_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Move_Option();
        this.click_Move_Option();
		Thread.sleep(1500);
		this.verify_DC_Move_Resource_Folder();
		this.click_DC_Under_Move_Resource_Modal();
		Thread.sleep(1000);
		this.verify_New_Library_Folder_11();
		this.click_New_Library_Folder_11();
		Thread.sleep(1500);
		this.click_Move_Btn();
		Thread.sleep(1000);
		this.verify_Move_Message();
		this.click_Close_Resource();
		System.out.println("------- Completed --> user_Can_Move_File() -----------");
	}
	
	public void verify_File_Moved_To_Folder_11() throws InterruptedException {
		this.verify_Resource_Libray_Folder_11_Created();
		this.click_New_Folder_11();
		Thread.sleep(1500);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> verify_File_Moved() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Add_Security_To_File() throws InterruptedException {
		this.click_Word_File_Dropdown();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Security_To_File() -----------");
	}
	
	public void add_Security_To_File_Board_member() throws InterruptedException {
		this.click_Word_File_Dropdown();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> add_Security_To_File_Board_member() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Copy_File_Link_And_Download_File() throws InterruptedException, UnsupportedFlavorException, IOException {
		this.click_Word_File_Dropdown();
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
          
          JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
          js.executeScript("popup_window = window.open('"+ paste+ "');");
          Thread.sleep(3000);
          js.executeScript("popup_window.close()");

*/		
		this.close_Modal();
	    Thread.sleep(3000);
	    //DriverFactory.getInstance().getDriver().navigate().refresh();
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
	public void user_Can_Add_Security_To_Folder_7() throws InterruptedException {
		this.verify_Resource_Library_Folder_7_Dropdown();
        this.click_Resource_Library_Folder_7_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option_Folder_7();
        this.click_Security_Option_Folder_7();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_User();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Security_To_Folder_2B() -----------");
	}
	
	public void add_Security_BoardMember_Folder() throws InterruptedException {
		this.verify_Resource_Library_Folder_3_Dropdown();
        this.click_Resource_Library_Folder_3_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option_BM();
        this.click_Security_Option_BM();
		Thread.sleep(1000);
		this.verify_Lockout_User_2();
		this.click_Lockout_User_2();
		Thread.sleep(1000);
		this.verify_Lockout_User_2_Added();
		Thread.sleep(1000);
		this.click_Close_Security_Box();
		Thread.sleep(2500);
		System.out.println("------- Completed --> add_Security_BoardMember_Folder() -----------");
	}
	
	public void user_Can_Add_Security_To_Folder_18() throws InterruptedException {
		this.verify_Resource_Library_Folder_18_Dropdown();
        this.click_Resource_Library_Folder_18_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option_Folder_18();
        this.click_Security_Option_Folder_18();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_User();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Security_To_Folder_18() -----------");
	}
	
	public void user_Can_Add_Security_To_Folder_19() throws InterruptedException {
		this.verify_Resource_Library_Folder_19_Dropdown();
        this.click_Resource_Library_Folder_19_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option_Folder_19();
        this.click_Security_Option_Folder_19();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_User();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Security_To_Folder_19() -----------");
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(allow_Comments)));
	}
	
	public void verify_Workroom_Admin_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_2)));
	}
	
	public void verify_Workroom_Admin_2_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(verify_Workroom_Admin_2_Added)));
	}
	
	public void verify_Auto_Director_2_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(verify_Auto_Director_2_Added)));
	}
	
	public void click_Approvals() {
		DriverFactory.getInstance().getDriver().findElement(approvals).click();
	}
	
	public void click_Allow_Comments() {
		DriverFactory.getInstance().getDriver().findElement(allow_Comments).click();
	}
	
	public void click_Submit() {
		DriverFactory.getInstance().getDriver().findElement(submit).click();
	}
	
	public void click_Workroom_Admin_2() {
		DriverFactory.getInstance().getDriver().findElement(workroom_Admin_2).click();
	}
	
	public void click_Auto_Director() {
		DriverFactory.getInstance().getDriver().findElement(auto_Director).click();
	}
	
	public void click_Close_Approvers_Box() {
		//DriverFactory.getInstance().getDriver().findElement(close_Approvers_Box).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Close')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void verify_Approvers_Added() throws InterruptedException {
		String wa_approver = "//div[contains(text(),'Workroom Admin')]";
		String ad_approver = "//div[contains(text(),'Auto Director')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(wa_approver)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(ad_approver)).size() > 0);
	}
	
	public void verify_Approvers_Added_2() throws InterruptedException {
		String ad_approver = "//div[contains(text(),'Auto Director')]";
		String ss_approver = "//div[contains(text(),'steve System')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(ad_approver)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(ss_approver)).size() > 0);
	}
	
	public void question_Box_SendKeys() {
		String sentence = "Please approve or deny this item";
		DriverFactory.getInstance().getDriver().findElement(question_Box).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(question_Box).clear();
		DriverFactory.getInstance().getDriver().findElement(question_Box).sendKeys(sentence);
	}
	
	public void scroll_Click_Steve_System() throws InterruptedException {
		WebElement steveSystem = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='approvals_modal']//a[@class='active'][contains(text(),'People')]/following::div[@class='person-name'][contains(text(),'steve System')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", steveSystem);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(steve_System).click();
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Add_Approvers_To_File() throws InterruptedException {
		this.click_Word_File_Dropdown();
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
		this.click_Word_File_Dropdown();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Approvers_To_File_2() -----------");
	}
	
	public void user_Can_Add_Approvers_To_File_2b() throws InterruptedException {
		this.click_Scanned_PDF_File_Dropdown();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Approvers_To_File_2b() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Verify_Approvers_Added_To_New_Folder_4() throws InterruptedException {
		this.click_New_Folder_4();
		Thread.sleep(1000);
		this.verify_Word_1_Docx_File_Created();
		this.click_Word_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Approvals();
		Thread.sleep(1000);
		this.verify_Approvers_Added();
		//this.click_Close_Approvers_Box();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Verify_Approvers_Added_To_New_Folder_4() -----------");
	}
	
	public void user_Can_Verify_Approvers_Added_2() throws InterruptedException {
		this.click_New_Folder_4();
		Thread.sleep(1000);
		this.verify_Approval_File_2B();
		this.click_Scanned_PDF_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Approvals();
		Thread.sleep(1000);
		this.verify_Approvers_Added_2();
		//this.click_Close_Approvers_Box();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Verify_Approvers_Added_2() -----------");
	}
	
	public void user_Can_Verify_Approvers_Added_Folder_8() throws InterruptedException {
		this.click_New_Folder_8();
		Thread.sleep(1000);
		this.verify_Approval_File_2B();
		this.click_Scanned_PDF_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Approvals();
		Thread.sleep(1000);
		this.verify_Approvers_Added_2();
		//this.click_Close_Approvers_Box();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Verify_Approvers_Added_2() -----------");
	}
	
	public void user_Can_Verify_Approvers_Added_3() throws InterruptedException {
		this.click_Approvals_Folder();
		Thread.sleep(1000);
		this.verify_Approval_File_2B();
		this.click_Scanned_PDF_File_Dropdown();
		Thread.sleep(1500);
		this.verify_Security_Option();
        this.click_Approvals();
		Thread.sleep(1000);
		this.verify_Approvers_Added_2();
		//this.click_Close_Approvers_Box();
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(ellipsis)));
	}
	
	public void verify_History() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(history)));
	}
	
	public void verify_Manage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(manage)));
	}
	
	public void verify_Manage_Approvals() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(manage_Approvals)));
	}
	
	public void verify_Response_Required() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(response_Required)));
	}
	
	public void verify_Response_Approve() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(response_Approve)));
	}
	
	public void verify_Approve_Or_Deny() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(approve_or_Deny)));
	}
	
	public void hover_And_Click_Actions_Hide() throws InterruptedException {
		WebElement ellipsis_Menu = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='tips-drawer drawer-toggle']//i[@class='fa fa-ellipsis-h']"));
		// move to element
		Actions action = new Actions(DriverFactory.getInstance().getDriver());
        action.moveToElement(ellipsis_Menu).build().perform();
		Thread.sleep(2000);
		
        // click on element
		WebElement actions_Menu = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id='wrap']/main//div/a[@class='tips-drawer drawer-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", actions_Menu);
	}
	
	public void click_Response_Required() throws InterruptedException {
		By expand = By.xpath("//*[starts-with (@id,'headingApprovals_')]/div/a/span[contains(.,'Expand')]");

		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean expand_Element = DriverFactory.getInstance().getDriver().findElements(By.xpath("//*[starts-with (@id,'headingApprovals_')]/div/a/span[contains(.,'Expand')]")).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (expand_Element == true) {
			DriverFactory.getInstance().getDriver().findElement(expand).click();
			Thread.sleep(1000);
			this.verify_Response_Required();
			DriverFactory.getInstance().getDriver().findElement(response_Required).click();
		}else {
			DriverFactory.getInstance().getDriver().findElement(response_Required).click();
		}
		
	}
	
	public void click_Response_Approve() {
		DriverFactory.getInstance().getDriver().findElement(response_Approve).click();
	}
	
	public void click_Submit_2() {
		DriverFactory.getInstance().getDriver().findElement(submit_2).click();
	}
	
	public void click_Manage() {
		DriverFactory.getInstance().getDriver().findElement(manage).click();
	}
	
	public void click_Manage_Approvals() {
		DriverFactory.getInstance().getDriver().findElement(manage_Approvals).click();
	}
	
	public void user_Can_Open_Actions_Menu_And_Respond() throws InterruptedException {
		Thread.sleep(5000);// waiting for PDF to process
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.hover_And_Click_Actions_Hide();
		Thread.sleep(5000);// waiting for PDF to process
		DriverFactory.getInstance().getDriver().navigate().refresh();
		//this.verify_AutoBE();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Open_Actions_Menu() -----------");
	}
	
	public void user_Can_Open_Actions_Menu_And_Respond_2() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.verify_Atlas_Left_Nav();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Open_Actions_Menu_2() -----------");
	}
	
	public void user_Can_Open_Actions_Menu_View_Response() throws InterruptedException {
		//this.verify_AutoBE();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Open_Actions_Menu() -----------");
	}
	//--------------------------------
	By workflow = By.xpath("//a[contains(text(),'Workflows')]");
	By awaiting_Responses = By.xpath("//a[@id='awaiting_responses_link']");
	By wf_Expand = By.xpath("//div[@class='panel-title']/a['collapseWorkflows_']");
	By vote_Required = By.xpath("//*[starts-with(@id,'dropdownMenuVote')]");
	By approve = By.xpath("//a[contains(text(),'Approve')]");
	By deny = By.xpath("//a[contains(text(),'Deny')]");
	By responded_To = By.xpath("//a[@id='responded_to_link']");
	By left_Arrow = By.xpath("//a[@class ='pull-left']/i[@class ='fa fa-arrow-left']");
	By comment_Non_Admin = By.xpath("//textarea[starts-with (@id,'comment_body_')]");
	By post = By.xpath("//*[@id='new_comment']//div/div/input");

	//textarea[starts-with (@id,'comment_body_')]
	// refreshed used below 
	public void verify_Workflow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workflow)));
	}
	
	public void verify_Awaiting_Responses() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(awaiting_Responses)));
	}
	
	public void verify_WF_Expand() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(wf_Expand)));
	}
	
	public void verify_Vote_Required() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(vote_Required)));
	}
	
	public void verify_Respond_To() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(responded_To)));
	}
	
	public void verify_Left_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(left_Arrow)));
	}
	
	public void click_Workflow() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Workflows')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Awaiting_Responses() {
		DriverFactory.getInstance().getDriver().findElement(awaiting_Responses).click();
	}
	
	public void click_WF_Expand() {
		DriverFactory.getInstance().getDriver().findElement(wf_Expand).click();
	}
	
	public void click_Vote_Required() {
		DriverFactory.getInstance().getDriver().findElement(vote_Required).click();
	}
	
	public void click_Approve() {
		DriverFactory.getInstance().getDriver().findElement(approve).click();
	}
	
	public void click_Deny() {
		DriverFactory.getInstance().getDriver().findElement(deny).click();
	}
	
	public void click_Left_Arrow() {
		DriverFactory.getInstance().getDriver().findElement(left_Arrow).click();
	}
	
	public void sendKeys_Non_Admin_Comment() {
		DriverFactory.getInstance().getDriver().findElement(comment_Non_Admin).sendKeys("This is a Non Admin Comment");
	}
	
	public void click_Post() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(post).click();
	}
	
	
	public void user_Can_Approve_Workflow() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.verify_Atlas_Left_Nav();
		this.verify_Ellipsis();
		this.hover_And_Click_Actions_Hide();
		Thread.sleep(2000);
		this.verify_Workflow();
		this.click_Workflow();
		Thread.sleep(2000);
		this.verify_Awaiting_Responses();
		this.click_Awaiting_Responses();
		Thread.sleep(2000);
		this.verify_WF_Expand();
		this.click_WF_Expand();
		Thread.sleep(2000);
		this.verify_Vote_Required();
		this.click_Vote_Required();
		Thread.sleep(2000);
		this.click_Approve();
		Thread.sleep(2000);
		System.out.println("------- Completed --> user_Can_Approve_Workflow() -----------");
	}
	
	public void user_Can_Comment_And_Approve_Workflow() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.verify_Atlas_Left_Nav();
		this.verify_Ellipsis();
		this.hover_And_Click_Actions_Hide();
		Thread.sleep(1500);
		this.verify_Workflow();
		this.click_Workflow();
		Thread.sleep(1000);
		this.verify_Awaiting_Responses();
		this.click_Awaiting_Responses();
		Thread.sleep(1000);
		this.verify_WF_Expand();
		this.click_WF_Expand();
		Thread.sleep(1000);
		this.verify_Vote_Required();
		this.sendKeys_Non_Admin_Comment();
		Thread.sleep(1000);
		this.click_Post();
		Thread.sleep(1500);
		this.click_Vote_Required();
		Thread.sleep(1000);
		this.click_Approve();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Approve_Workflow() -----------");
	}
	
	public void user_Can_Deny_Approve_Workflow() throws InterruptedException {
		this.verify_Vote_Required();
		this.click_Vote_Required();
		Thread.sleep(2000);
		this.click_Deny();
		Thread.sleep(2000);
		this.verify_Vote_Required();
		this.click_Vote_Required();
		Thread.sleep(2000);
		this.click_Approve();
		Thread.sleep(2000);
		//this.verify_Left_Arrow();
		//this.click_Left_Arrow();
		//Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Deny_Approve_Workflow() -----------");
	}
	
	public void verify_Workflow_Approved() throws InterruptedException {
		this.verify_Workflow();
		this.click_Workflow();
		Thread.sleep(1000);
		this.verify_Respond_To();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Approved() -----------");
	}
	
	// --------------- verify_Folders_In_Secured_Folders_Catergory() --------------------
	By secured_Folders = By.xpath("//a[contains(text(),'Secured Folders')]");
	By secured_Folders_Title = By.xpath("//h1[contains(text(),'Secured Folders')]");
	By resource_Library = By.xpath("//a[contains(text(),'Resource Library')]");
	
	public void verify_Secured_Folder_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(secured_Folders_Title)));
	}
	
	public void click_Secured_Folder_Cat() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Secured Folders')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Resource Library')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void verify_Secured_Folders_18_19_Present() throws InterruptedException {
		String sec_folder1 = "(//span[contains(text(),'New Library Folder 18')])[1]";
		String sec_folder2 = "(//span[contains(text(),'New Library Folder 19')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(sec_folder1)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(sec_folder2)).size() > 0);
	}
	
	// --------------- Function being called --------------------
	public void verify_Folders_18_19_In_Secured_Folders_Catergory() throws InterruptedException {
		this.click_Secured_Folder_Cat();
		Thread.sleep(1000);
        this.verify_Secured_Folder_Title();
        this.verify_Secured_Folders_18_19_Present();
        this.click_Resource_Library();
		Thread.sleep(1500);
		System.out.println("------- Completed --> verify_Folders_18_19_In_Secured_Folders_Catergory() -----------");
	}
	
	// --------------- verify_File_Moved --------------------
	By folder_Path_Move = By.xpath("//ol[@class='breadcrumb']//a[contains(text(),'Resource Library')]/following::li[contains(text(),'New Library Folder')]");
	By library_Folder_1 = By.xpath("(//a[contains(text(),'New Library Folder')])[1]");

	public void verify_New_Library_Folder_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library_Folder_1)));
	}
	
	public void click_New_Library_Folder_1() {
		//DriverFactory.getInstance().getDriver().findElement(library_Folder_1).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'New Library Folder')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------- Function being called --------------------
	public void verify_File_Moved() throws InterruptedException {
		this.verify_New_Library_Folder_1();
		this.click_New_Library_Folder_1();
		Thread.sleep(1500);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> verify_File_Moved() -----------");
	}
	
	public void verify_File_Moved_To_Library_Folder_14() throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.verify_Resource_Libray_Folder_14_Created();
		this.click_New_Library_Folder_14();
		Thread.sleep(1500);
		this.verify_Scanned_PDF_File_Created();
		System.out.println("------- Completed --> verify_File_Moved_To_Library_Folder_14() -----------");
	}
	
	public void verify_File_Moved_WR_2_WR() throws InterruptedException {
		Thread.sleep(1500); // pause to make sure under correct folder
		this.verify_New_Library_Folder_1();
		this.click_New_Library_Folder_1();
		Thread.sleep(1500);
		this.verify_File_ToAttach();
		System.out.println("------- Completed --> verify_File_Moved_WR_2_WR() -----------");
	}
	
	// --------------- user_Moves_New_Folder --------------------
	By move_Option = By.xpath("//span[contains(text(),'Move')]");
	By move_Option_2 = By.xpath("(//*[starts-with (@id,'resource_')]/td/div/ul/li/a[contains(.,'Move')])[2]");	
	By security_Option = By.xpath("//li[@class='security']//a[contains(text(),'Security')]");
	By security_Option_2 = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Security')]");
	//By security_Option_2B = By.xpath("//*[starts-with(@id,'resource_')]/td/div/ul/li/a[contains(.,'Security')]");
	By security_Option_Folder_7 = By.xpath("//*[normalize-space(text()) ='New Library Folder 7']/following::div[@class='btn-group small open']//child::a[contains(text(),'Security')]");
	By security_Option_Folder_18 = By.xpath("//*[normalize-space(text()) ='New Library Folder 18']/following::div[@class='btn-group small open']//child::a[contains(text(),'Security')]");
	By security_Option_Folder_19 = By.xpath("//*[normalize-space(text()) ='New Library Folder 19']/following::div[@class='btn-group small open']//child::a[contains(text(),'Security')]");
	By copy_Link = By.xpath("//a[@class='copy-file-path']");
	By autoBE_Resource = By.xpath("//a[contains(@class,'workroom-2305')]");
	By autoBE_Resource_B = By.xpath("//a[contains(@class,'workroom-5828')]");
	By moveBtn = By.xpath("//button[contains(text(),'Move')]");
	By move_Message = By.xpath("//p[contains(text(),'Files/Folders were successfully moved.')]");
	By close_Modal = By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']");
	//By security_Option_BM = By.xpath("//tbody/tr[@id='resource_21010']/td/div/ul/li/a[contains(.,'Security')]");
	By security_Option_BM = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Security')]");
	
	public void verify_Move_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_Option)));
	}
	
	public void verify_Move_Option_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_Option_2)));
	}
	
	public void verify_Security_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security_Option)));
	}
	
	public void verify_Security_Option_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security_Option_2)));
	}
	
	public void verify_Security_Option_Folder_7() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security_Option_Folder_7)));
	}
	
	public void verify_Security_Option_Folder_18() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(security_Option_Folder_18)));
	}
	
	public void verify_Security_Option_Folder_19() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(security_Option_Folder_19)));
	}
	
	public void verify_Copy_Link() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_Link)));
	}

	public void verify_AutoBE_Resource() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(autoBE_Resource)));
	}
	
	public void verify_AutoBE_Resource_B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(autoBE_Resource_B)));
	}

	public void verify_Move_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_Message)));
	}
	
	public void verify_Security_Option_BM() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security_Option_BM)));
	}

	

	public void click_Move_Option() {
		// DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(),'Move')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option() {
		// DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//li[@class='security']//a[contains(text(),'Security')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option_2() {
		// DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//li[@class='security']//a[contains(text(),'Security')])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option_Folder_7() {
		// DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(security_Option_Folder_7);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option_Folder_18() {
		// DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(security_Option_Folder_18);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option_Folder_19() {
		// DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(security_Option_Folder_19);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Security_Option_BM() {
		// DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//*[starts-with (@id,'resource_')]/td[7]/div/ul/li[3]/a[1])[3]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Copy_Link() {
		// DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='copy-file-path']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	

	public void click_AutoBE_Resource() {
		// DriverFactory.getInstance().getDriver().findElement(autoBE_Resource).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(@class,'workroom-2305')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_AutoBE_Resource_B() {
		// DriverFactory.getInstance().getDriver().findElement(autoBE_Resource).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(autoBE_Resource_B);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	
	public void click_Move_Btn() {
		// DriverFactory.getInstance().getDriver().findElement(cancel_Btn).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[contains(text(),'Move')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Close_Resource() {
		// DriverFactory.getInstance().getDriver().findElement(close_Modal).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='moveResourceModal']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Close_Security_Box() {
		// DriverFactory.getInstance().getDriver().findElement(close_Modal).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='resourceAddUsersModal']//span[contains(text(),'×')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	public void close_Modal() {
		// DriverFactory.getInstance().getDriver().findElement(close_Modal).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------- Function being called --------------------
	public void user_Moves_Folder_15_To_AutoBE_Workroom() throws InterruptedException {
		this.click_Resource_Library_Folder_15_Dropdown();
		Thread.sleep(1000);
		this.verify_Move_Option();
		this.click_Move_Option();
		Thread.sleep(1000);
		this.verify_AutoBE_Resource();
		this.click_AutoBE_Resource();
		Thread.sleep(2500);
		this.click_Move_Btn();
		Thread.sleep(1500);
		this.verify_Move_Message();
		this.click_Close_Resource();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Moves_Fodler_15_To_AutoBE_Workroom() -----------");
	}
	
	
	public void user_Moves_Folder_21_To_AutoBE_Workroom_Based_On_Site() throws InterruptedException {
		
		String url = DriverFactory.getInstance().getDriver().getCurrentUrl();
		
		if (url.contains("ozzie")) {
			this.user_Moves_Folder_21_To_AutoBE_Workroom();
		}else {
			this.user_Moves_Folder_21_To_AutoBE_Workroom_B();
		}
		
		System.out.println("------- Completed -->  User_Can_Login() -----------");
		
	}
	
	public void user_Moves_Folder_21_To_AutoBE_Workroom() throws InterruptedException {
		this.click_Resource_Library_Folder_21_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_21_Move_Option();
		this.click_Resource_Library_Folder_21_Move_Option();
		Thread.sleep(1000);
		this.verify_AutoBE_Resource();
		this.click_AutoBE_Resource();
		Thread.sleep(1500);
		this.click_Move_Btn();
		Thread.sleep(1500);
		this.verify_Move_Message();
		this.click_Close_Resource();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Moves_Folder_21_To_AutoBE_Workroom() -----------");
	}
	
	public void user_Moves_Folder_21_To_AutoBE_Workroom_B() throws InterruptedException {
		this.click_Resource_Library_Folder_21_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_21_Move_Option();
		this.click_Resource_Library_Folder_21_Move_Option();
		Thread.sleep(1000);
		this.verify_AutoBE_Resource_B();
		this.click_AutoBE_Resource_B();
		Thread.sleep(1500);
		this.click_Move_Btn();
		Thread.sleep(1500);
		this.verify_Move_Message();
		this.click_Close_Resource();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Moves_Folder_21_To_AutoBE_Workroom() -----------");
	}
	
	// --------------- click_New_Folder_2 --------------------

	By edit = By.xpath("//span[@class='translation_missing'][contains(text(),'Edit')]");
	By edit_Resource_Title = By.xpath("//form[@id='edit_vfile_file']//label[contains(text(),'Resource Title')]");
	By sample_File = By.xpath("//*[contains(text(),'Sample File')]");
	
	public void verify_Edit() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit)));
	}
	
	public void verify_Edit_Resource_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(edit_Resource_Title)));
	}
	
	public void verify_Sample_File_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(sample_File)));
	}
	
	public void click_Edit() {
		//DriverFactory.getInstance().getDriver().findElement(library_Folder_1).edit();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[@class='translation_missing'][contains(text(),'Edit')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void edit_Resource_Title_SendKeys() {
		By input = By.xpath("//form[@id='edit_vfile_file']//input[@id='vfile_name']");
		String file_Title_Name ="Sample File";
		DriverFactory.getInstance().getDriver().findElement(input).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(input).clear();
		DriverFactory.getInstance().getDriver().findElement(input).sendKeys(file_Title_Name);	
	}
	
	public void user_Can_Edit_File() throws InterruptedException {
		this.click_Word_File_Dropdown();
		this.verify_Edit();
		this.click_Edit();
		Thread.sleep(1000);
		this.verify_Edit_Resource_Title();
		this.edit_Resource_Title_SendKeys();
		Thread.sleep(1000);
		this.click_Resource_Save_Btn();
//		this.verify_Hour_Glass_Invisible();
//		Thread.sleep(3500);
//		this.verify_Sample_File_Created();
		System.out.println("------- Completed --> user_Can_Edit_File() -----------");
	}
	
	public void user_Can_Edit_File_In_Folder_11() throws InterruptedException {
		this.click_Word_File_Dropdown();
		this.verify_Edit();
		this.click_Edit();
		Thread.sleep(1000);
		this.verify_Edit_Resource_Title();
		this.edit_Resource_Title_SendKeys();
		Thread.sleep(1000);
		this.click_Resource_Save_Btn();
		System.out.println("------- Completed --> user_Can_Edit_File() -----------");
	}
	
	public void verify_Resource_File_Edited() throws InterruptedException {
		this.click_View_Only_Folder_2();
		this.verify_Sample_File_Created();
		System.out.println("------- Completed --> verify_Resource_File_Edited() -----------");
	}
	
	public void user_Can_Edit_File_2() throws InterruptedException {
		this.click_Scanned_PDF_File_Dropdown();
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
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='keyword']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	} 
	
	public void sendKeys_Folder_File_Name(String folder1) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(resource_Search).clear();
		DriverFactory.getInstance().getDriver().findElement(resource_Search).click();
		DriverFactory.getInstance().getDriver().findElement(resource_Search).sendKeys(folder1);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(resource_Search).sendKeys(Keys.ENTER);
		Thread.sleep(2500);
	} 
	
	public void verify_Folder_Or_File() throws InterruptedException {
		String folder = "//a[contains(text(),'New Library Folder 16')]";
		String file = "//a[contains(text(),'Word_1.docx')]";
		
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean Folder = DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() > 0;
		Boolean File = DriverFactory.getInstance().getDriver().findElements(By.xpath(file)).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (Folder == true) {
			Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() > 0);
		}else if(File == true){
			Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file)).size() > 0);
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_File)));
	}
	
	public void click_Sample_File_Dropdrown() {
		String sample_File_Dropdown ="//a[contains(text(),'Sample File')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(sample_File_Dropdown));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Delete() {
		//DriverFactory.getInstance().getDriver().findElement(delete_File).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
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
		this.verify_Word_1_Docx_File_Created();
		this.click_Word_1_Docx_File_Dropdown();
		Thread.sleep(1000);
		this.click_Word_1_Docx_File_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3500);
		System.out.println("------- Completed --> user_Can_Delete_Private_Folder_File() -----------");
	}
	
	public void user_Can_Delete_Private_Folder_Word_File() throws InterruptedException {
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_Word_3_Docx_File_Created();
		this.click_Word_3_Docx_File_Dropdown();
		Thread.sleep(1000);
		this.click_Word_3_Docx_File_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3500);
		System.out.println("------- Completed --> user_Can_Delete_Private_Folder_File() -----------");
	}
	
	public void user_Can_Delete_Private_Folder_File_JPG() throws InterruptedException {
		this.click_Your_Private_Folder();
		Thread.sleep(1500);
		this.verify_Select_PC_File();
		this.click_JPG_File_Dropdown();
		Thread.sleep(1500);
		//this.verify_Delete();
		this.click_Delete();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> user_Can_Delete_Private_Folder_File() -----------");
	}
	
	// --------------- user_Can_Delete_Folder --------------------
	By library_Folder = By.xpath("//a[contains(text(),'New Library Folder')]");
	By checkbox = By.xpath("(//a[contains(text(),'New Library Folder')]/preceding::p//input[starts-with(@id,'folder_')])[3]");
	By dropdown = By.xpath("//a[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By delete_Option = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_New_Library_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(library_Folder)));
	}

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}
	

	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void click_AutoBE_Library() {
		// DriverFactory.getInstance().getDriver().findElement(autoBE_Library).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(@class,'break-name')][contains(text(),'AutoBE')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Check_Box() {
		//DriverFactory.getInstance().getDriver().findElement(checkbox).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'New Library Folder')]/preceding::p//input[starts-with(@id,'folder_')])[3]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Dropdown() {
		//DriverFactory.getInstance().getDriver().findElement(dropdown).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Delete_Option() {
		//DriverFactory.getInstance().getDriver().findElement(delete_Option).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_ContinueBtn() {
		//DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@class='btn commit btn-danger']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	
	
	// --------------- Function being called --------------------
	public void user_Can_Delete_Resource_Library_Folder_5() throws InterruptedException {
		this.verify_Resource_Library_Folder_5_Dropdown();
		this.click_Resource_Library_Folder_5_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_5_Delete_Option();
		this.click_Resource_Library_Folder_5_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	// --------------- user_Delete_Both_Folders --------------------
	By dropdown_1_Sec = By.xpath("//span[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By new_Folder_Dropdown = By.xpath("//*[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	
	//-----------------------------------

	By resource_Library_Folder_2_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 2']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_2_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 2']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");

	By resource_Library_Folder_3_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 3']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_3_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 3']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_4_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 4']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_4_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 4']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_5_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 5']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_5_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 5']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");

	By resource_Library_Folder_6_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 6']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_6_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 6']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_7_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 7']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_7_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 7']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_8_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 8']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_8_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 8']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_11_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 11']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_11_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 11']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");

	By resource_Library_Folder_12_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 12']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_12_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 12']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");

	By resource_Library_Folder_15_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 15']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_15_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 15']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_16_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 16']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_16_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 16']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_18_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 18']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_18_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 18']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_19_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 19']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_19_Delete_Option = By.xpath("(//*[normalize-space(text()) ='New Library Folder 19']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')])[1]");
	
	By resource_Library_Folder_20_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 20']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_20_Delete_Option = By.xpath("(//*[normalize-space(text()) ='New Library Folder 20']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')])[1]");
	
	By resource_Library_Folder_21_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 21']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_21_Delete_Option = By.xpath("(//*[normalize-space(text()) ='New Library Folder 21']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')])[1]");
	By resource_Library_Folder_21_Move_Option = By.xpath("(//*[normalize-space(text()) ='New Library Folder 21']/following::div[@class='btn-group small open']//child::a[contains(.,'Move')])[1]");

	
	By sub_Folders_In_View_Only_Dropdown = By.xpath("(//*[normalize-space(text()) ='Sub Folders In View Only']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By sub_Folders_In_View_Only_Delete_Option = By.xpath("//*[normalize-space(text()) ='Sub Folders In View Only']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By copy_File_Link_Folder_Dropdown = By.xpath("(//*[normalize-space(text()) ='Copy File Link Folder']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By copy_File_Link_Folder_Delete_Option = By.xpath("//*[normalize-space(text()) ='Copy File Link Folder']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By copy_File_Link_Folder_2_Dropdown = By.xpath("(//*[normalize-space(text()) ='Copy File Link Folder 2']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By copy_File_Link_Folder_2_Delete_Option = By.xpath("//*[normalize-space(text()) ='Copy File Link Folder 2']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By word_1_Docx_File_Dropdown = By.xpath("(//*[contains(text(),'Word_1.docx')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"); 
	By word_1_Docx_File_Delete_Option = By.xpath("(//*[normalize-space(text()) ='Word_1.docx']/following::div[@class='btn-group small open']//child::span[contains(text(),'Delete')])[1]");
	
	By word_3_Docx_File_Dropdown = By.xpath("(//*[contains(text(),'Word_3.docx')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"); 
	By word_3_Docx_File_Delete_Option = By.xpath("(//*[normalize-space(text()) ='Word_3.docx']/following::div[@class='btn-group small open']//child::span[contains(text(),'Delete')])[1]");

	public void verify_Resource_Library_Folder_2_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Library_Folder_2_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_2_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Library_Folder_2_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_3_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Library_Folder_3_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_3_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Library_Folder_3_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_4_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Library_Folder_4_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_4_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_4_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_5_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_5_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_5_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_5_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_6_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_6_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_6_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_6_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_7_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_7_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_7_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_7_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_8_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_8_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_8_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_8_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_11_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_11_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_11_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_11_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_12_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_12_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_12_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_12_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_15_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_15_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_15_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_15_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_16_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_16_Dropdown)));
	}

	public void verify_Resource_Library_Folder_16_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_16_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_18_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_18_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_18_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_18_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_19_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_19_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_19_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_19_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_20_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_20_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_20_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_20_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_21_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_21_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_21_Move_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_21_Move_Option)));
	}
	
	public void verify_Resource_Library_Folder_21_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_21_Delete_Option)));
	}
	
	public void verify_Copy_File_Link_Folder_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_File_Link_Folder_Dropdown)));
	}
	
	public void verify_Copy_File_Link_Folder_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_File_Link_Folder_Delete_Option)));
	}
	
	public void verify_Copy_File_Link_Folder_2_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_File_Link_Folder_2_Dropdown)));
	}
	
	public void verify_Copy_File_Link_Folder_2_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_File_Link_Folder_2_Delete_Option)));
	}
	
	public void verify_Sub_Folders_In_View_Only_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(sub_Folders_In_View_Only_Dropdown)));
	}
	
	public void verify_Sub_Folders_In_View_Only_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(sub_Folders_In_View_Only_Delete_Option)));
	}
	
	public void click_Resource_Library_Folder_2_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_2_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_2_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_2_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_2_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Resource_Library_Folder_3_Dropdown() {
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_3_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_3_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_3_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_3_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_4_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_4_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_4_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_4_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_4_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_5_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_5_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_5_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_5_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_5_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_6_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_6_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_6_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_6_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_6_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_7_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_7_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_7_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_7_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_7_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_8_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_8_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_8_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_8_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_8_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_11_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_11_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_11_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_11_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_11_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_12_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_12_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_12_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_12_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_12_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_15_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_15_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_15_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_15_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_15_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_16_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_16_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_16_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_20_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_20_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_20_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_21_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_21_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_21_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_16_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_16_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_18_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_18_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_18_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_18_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_18_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_19_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_19_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_19_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Resource_Library_Folder_19_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_19_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_20_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_20_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_21_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_21_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_21_Move_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_21_Move_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Copy_File_Link_Folder_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Copy_File_Link_Folder_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Copy_File_Link_Folder_2_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_2_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_2_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Copy_File_Link_Folder_2_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_2_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Sub_Folders_In_View_Only_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(sub_Folders_In_View_Only_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(sub_Folders_In_View_Only_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Sub_Folders_In_View_Only_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(sub_Folders_In_View_Only_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Word_3_Docx_File_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(word_3_Docx_File_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(word_3_Docx_File_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Word_3_Docx_File_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(word_3_Docx_File_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Word_1_Docx_File_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(word_1_Docx_File_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(word_1_Docx_File_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Word_1_Docx_File_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(word_1_Docx_File_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	//----------------
	By library_Folder_2 = By.xpath("//*[normalize-space(text()) = 'New Library Folder 2']");
	By word_1_Docx_File = By.xpath("//*[contains(text(),'Word_1.docx')]");
	By word_3_Docx_File = By.xpath("//*[contains(text(),'Word_3.docx')]");
	By copy_File_Link_Folder = By.xpath("//*[normalize-space(text()) ='Copy File Link Folder']");
	By copy_File_Link_Folder_2 = By.xpath("//*[normalize-space(text()) ='Copy File Link Folder 2']");
	By copy_File_Link_Folder_20 = By.xpath("//*[normalize-space(text()) ='New Library Folder 20']");

	public void click_Library_Folder_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(library_Folder_2).click();
	}
	
	public void click_Copy_File_Link_Folder() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder).click();
	}
	
	public void click_Copy_File_Link_Folder_2() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_2);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_2).click();
	}
	
	public void click_Copy_File_Link_Folder_20() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_20);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		DriverFactory.getInstance().getDriver().findElement(copy_File_Link_Folder_20).click();
	}
	
	public void verify_File_Not_Present_In_Library_Folder() {
		String file = "//a[contains(text(),'Word_1.docx')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file)).size() < 1);
	}
	
	public void verify_Word_1_Docx_File_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(word_1_Docx_File)));
	}
	
	public void verify_Word_3_Docx_File_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(word_3_Docx_File)));
	}
	
	public void verify_Copy_File_Link_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_File_Link_Folder)));
	}
	
	public void verify_Copy_File_Link_Folder_20() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_File_Link_Folder_20)));
	}
	
	public void verify_Copy_File_Link_Folder_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_File_Link_Folder_2)));
	}
	
	public void verify_File_Not_In_Library_Folder_2() throws InterruptedException {
		this.click_Library_Folder_2();
		Thread.sleep(2000);
		this.verify_File_Not_Present_In_Library_Folder();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_File_Not_In_Library_Folder_2() -----------");
	}
	
	public void verify_File_Not_In_Library_Folder_6() throws InterruptedException {
		this.click_New_Folder_6();
		Thread.sleep(2000);
		this.verify_File_Not_Present_In_Library_Folder();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_File_Not_In_Library_Folder_6() -----------");
	}
	
	public void user_Can_Add_File_To_Library_Folder_2() throws InterruptedException {
		this.click_Library_Folder_2();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.click_Resource_Save_Btn();
		Thread.sleep(3000);
		this.verify_Word_1_Docx_File_Created();
		System.out.println("------- Completed --> user_Can_Add_File_To_Library_Folder_2() -----------");
	}
	
	//---------------------------------
	
	// --------------- verify_Folder_Deleted --------------------

	public void verify_Word_1_Docx_NOT_Present() throws InterruptedException {
		String file_Title = "//*[normalize-space(text()) ='Word_1.docx']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
		System.out.println("------- Completed --> verify_Word_1_Docx_NOT_Present() -----------");
	}

	public void verify_Resource_Library_Folder_2_NOT_Present() throws InterruptedException {
		String file_Title = "//*[normalize-space(text()) ='New Library Folder 2']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
		System.out.println("------- Completed --> verify_Folder2_NOT_Present() -----------");
	}
	//----------------------------

	public void verify_Folder_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(dropdown)));
	}
	
	public void verify_Folder_1_Dropdown_Sec() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(dropdown_1_Sec)));
	}
	
	public void verify_Folder_1_Dropdown_B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Dropdown)));
	}
	
	public void click_Dropdown_1() {
		//DriverFactory.getInstance().getDriver().findElement(dropdown).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Dropdown_1_B() {
		//DriverFactory.getInstance().getDriver().findElement(dropdown).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Approvals_Folder_Dropdown() {
		//DriverFactory.getInstance().getDriver().findElement(dropdown).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[contains(text(),'Approvals')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
		
//	public void user_Delete_Folder_1() throws InterruptedException {
//		this.verify_Folder_1_Dropdown_B();
//		this.click_Dropdown_1_B();
//		Thread.sleep(1000);
//		this.verify_Delete_Option();
//		this.click_Delete_Option();
//		Thread.sleep(1500);
//		this.verify_ContinueBtn();
//		this.click_ContinueBtn();
//		Thread.sleep(2000);
//		System.out.println("------- Completed --> user_Delete_Folder_1() -----------");
//	}
//	
	public void user_Delete_Approvals_Folder() throws InterruptedException {
		this.verify_Approval_Folder_Created();
		this.click_Approvals_Folder_Dropdown();
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
	public void user_Delete_Both_18_19_Folders() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_18_Dropdown();
		this.click_Resource_Library_Folder_18_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_18_Delete_Option();
		this.click_Resource_Library_Folder_18_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		//------------------------
		DriverFactory.getInstance().getDriver().navigate().refresh();
		AtlasNavBar obj  = new AtlasNavBar();
		obj.user_Open_Resource_Library();
		//this.user_Can_Open_Libraries_Form_2();
		//--------------------------
        this.verify_Resource_Library_Folder_19_Dropdown();
        this.click_Resource_Library_Folder_19_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_19_Delete_Option();
		this.click_Resource_Library_Folder_19_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Both_Folders() -----------");
	}
	
	public void delete_Resource_Library_Folder_2() throws InterruptedException {
        this.verify_Resource_Library_Folder_2_Dropdown();
        this.click_Resource_Library_Folder_2_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_2_Delete_Option();
		this.click_Resource_Library_Folder_2_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Resource_Library_Folder_2() -----------");
	}
	
	// --------------- Function being called ----------------------
	public void user_Delete_Resource_Library_Folder_3() throws InterruptedException {
        this.verify_Resource_Library_Folder_3_Dropdown();
        this.click_Resource_Library_Folder_3_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_3_Delete_Option();
		this.click_Resource_Library_Folder_3_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Resource_Library_Folder_3() -----------");
	}
	
	
	public void user_Delete_Folder_4() throws InterruptedException {
	    this.verify_Resource_Library_Folder_4_Dropdown();
	    this.click_Resource_Library_Folder_4_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Folder_2() -----------");
	}
	
	public void user_Delete_Resource_Library_Folder_6() throws InterruptedException {
        this.verify_Resource_Library_Folder_6_Dropdown();
        this.click_Resource_Library_Folder_6_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_6_Delete_Option();
		this.click_Resource_Library_Folder_6_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Resource_Library_Folder_3() -----------");
	}
	
	public void delete_Resource_Library_Folder_7() throws InterruptedException {
        this.verify_Resource_Library_Folder_7_Dropdown();
        this.click_Resource_Library_Folder_7_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_7_Delete_Option();
		this.click_Resource_Library_Folder_7_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Resource_Library_Folder_7() -----------");
	}
	
	public void delete_Resource_Library_Folder_8() throws InterruptedException {
        this.verify_Resource_Library_Folder_8_Dropdown();
        this.click_Resource_Library_Folder_8_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_8_Delete_Option();
		this.click_Resource_Library_Folder_8_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Resource_Library_Folder_8() -----------");
	}
	
	public void user_Delete_Folders_11_And_12() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_11_Dropdown();
		this.click_Resource_Library_Folder_11_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_11_Delete_Option();
		this.click_Resource_Library_Folder_11_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		//------------------------
		DriverFactory.getInstance().getDriver().navigate().refresh();
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Resource_Library_DC();
		//this.user_Can_Open_Libraries_Form_2();
		//--------------------------
        this.verify_Resource_Library_Folder_12_Dropdown();
        this.click_Resource_Library_Folder_12_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_12_Delete_Option();
		this.click_Resource_Library_Folder_12_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Folders_11_And_12() -----------");
	}
	// --------------- Function being called --------------------
	public void user_Delete_Resource_Library_Folder_15() throws InterruptedException {
	    this.verify_Resource_Library_Folder_15_Dropdown();
	    this.click_Resource_Library_Folder_15_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_15_Delete_Option();
		this.click_Resource_Library_Folder_15_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	public void user_Delete_Resource_Library_Folder_16() throws InterruptedException {
	    this.verify_Resource_Library_Folder_16_Dropdown();
	    this.click_Resource_Library_Folder_16_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_16_Delete_Option();
		this.click_Resource_Library_Folder_16_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Resource_Library_Folder_16() -----------");
	}
	
	public void user_Delete_Resource_Library_Folder_20() throws InterruptedException {
		Thread.sleep(1000);// pause to make sure under right folder
	    this.verify_Resource_Library_Folder_20_Dropdown();
	    this.click_Resource_Library_Folder_20_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_20_Delete_Option();
		this.click_Resource_Library_Folder_20_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Resource_Library_Folder_20() -----------");
	}
	
	public void user_Delete_Resource_Library_Folder_21() throws InterruptedException {
		Thread.sleep(1500);// pause to make sure under right folder
	    this.verify_Resource_Library_Folder_21_Dropdown();
	    this.click_Resource_Library_Folder_21_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_21_Delete_Option();
		this.click_Resource_Library_Folder_21_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Resource_Library_Folder_21() -----------");
	}
	
	public void delete_Folder_Sub_Folders_In_ViewOnly_Folder() throws InterruptedException {
		Thread.sleep(1500); // give time make sure under correct folder 
        this.verify_Sub_Folders_In_View_Only_Dropdown();
        this.click_Sub_Folders_In_View_Only_Dropdown();
		Thread.sleep(1000);
		this.verify_Sub_Folders_In_View_Only_Delete_Option();
		this.click_Sub_Folders_In_View_Only_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Folder_Sub_Folders_In_ViewOnly_Folder() -----------");
	}
	
	public void delete_Resource_Library_Folder_Copy_File_Link_Folder() throws InterruptedException {
        this.verify_Copy_File_Link_Folder_Dropdown();
        this.click_Copy_File_Link_Folder_Dropdown();
		Thread.sleep(1000);
		this.verify_Copy_File_Link_Folder_Delete_Option();
		this.click_Copy_File_Link_Folder_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Resource_Library_Folder_Copy_File_Link_Folder() -----------");
	}
	
	public void delete_Resource_Library_Folder_Copy_File_Link_Folder_2() throws InterruptedException {
        this.verify_Copy_File_Link_Folder_2_Dropdown();
        this.click_Copy_File_Link_Folder_2_Dropdown();
		Thread.sleep(1000);
		this.verify_Copy_File_Link_Folder_2_Delete_Option();
		this.click_Copy_File_Link_Folder_2_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Resource_Library_Folder_Copy_File_Link_Folder_2() -----------");
	}
	
	// --------------- verify_Folder_Deleted --------------------
	public void verify_Folder_NOT_Present() throws InterruptedException {
		String folder = "//a[contains(text(),'New Library Folder')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
	}
	
	public void verify_Resource_Library_Folder_3_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 3']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_3_NOT_Present() -----------");
	}
	
	public void verify_Resource_Library_Folder_4_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 4']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_4_NOT_Present() -----------");
	}
	
	public void verify_Resource_Library_Folder_5_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 5']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_5_NOT_Present() -----------");
	}
	
	public void verify_Resource_Library_Folder_6_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 6']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_6_NOT_Present() -----------");
	}
	
	public void verify_Resource_Library_Folder_7_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 7']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_7_NOT_Present() -----------");
	}
	
	public void verify_Resource_Library_Folder_8_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 8']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_8_NOT_Present() -----------");
	}
	
	public void verify_Copy_Link_Folder_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='Copy File Link Folder']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_7_NOT_Present() -----------");
	}
	
	public void verify_Copy_Link_Folder_2_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='Copy File Link Folder 2']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Copy_Link_Folder_2_NOT_Present() -----------");
	}
	
	// --------------- verify_Folder_Deleted --------------------
	public void verify_Both_Folders_11_And_12_NOT_Present() throws InterruptedException {
		String str = "(//*[normalize-space(text()) ='New Library Folder 11']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String str2 = "(//*[normalize-space(text()) ='New Library Folder 12']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(str)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(str2)).size() < 1);
	}

	public void verify_Resource_Library_Folder_15_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 15']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_15_NOT_Present() -----------");
	}
	
	public void verify_Resource_Library_Folder_16_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 16']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_16_NOT_Present() -----------");
	}
	
	public void verify_Resource_Library_Folder_20_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 20']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_20_NOT_Present() -----------");
	}
	
	public void verify_Resource_Library_Folder_21_NOT_Present() throws InterruptedException {
		String folder = "//*[normalize-space(text()) ='New Library Folder 21']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(folder)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Folder_21_NOT_Present() -----------");
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
	public void verify_Folders_11_And_12_Deleted() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Both_Folders_11_And_12_NOT_Present();
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
