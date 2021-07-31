package page_resource_library;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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

	public void click_Libraries() {
		driver.findElement(libraries).click();
	}

	// --------------- Function being called --------------------
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		this.verify_Libraries();
		this.click_Libraries();
		Thread.sleep(1500);
		this.verify_New_Folder();
		System.out.println("------- Completed --> user_Can_Open_Libraries_Form() -----------");
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
		driver.findElement(new_Folder_Link).click();
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
	
	//---------------------add_File_To_Private_Folder----------------------
	By your_Private_Folder = By.xpath("//*[@id=\"filesModal\"]/div/div/div[2]/div/div[3]/div[1]/div/div/ul/a");
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
	By sub_Folder1_Created = By.xpath("//span[contains(text(),'Sub Folder1')]");
	By sub_Folder2_Created = By.xpath("//span[contains(text(),'Sub Folder2')]");

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
	
	public void verify_More_Options_Link() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_More_Options_Link)));
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
	
	// --------------- Edit-Existing-Folder-To-View-Only --------------------
	By new_Library_Folder = By.xpath("//span[contains(text(),'New Library Folder')]");
	By file_Created_2 = By.xpath("//*[contains(text(),'ScannedDocument.pdf')]");
	By new_Library_Folder_2 = By.xpath("//a[contains(text(),'New Library Folder')]");
	By pdf_Drp_Dwn = By.xpath("//*[contains(text(),'ScannedDocument.pdf')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	

	public void verify_File_Created_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Created_2)));
	}
	
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
	
	public void click_New_Lib_Folder() {
		driver.findElement(new_Library_Folder).click();
	}
	
	public void folder_Name_SendKeys_3() {
		String folder_Name = "Sub Folder1";
		driver.findElement(new_Folder_Name_Field).sendKeys(folder_Name);
	}
	
	public void folder_Name_SendKeys_4() {
		String folder_Name = "Sub Folder2";
		driver.findElement(new_Folder_Name_Field).sendKeys(folder_Name);
	}
	
	public void add_File_Resource_Copy_Link() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void verify_View_Only_Folder_Permissions_Enabled() {
		String new_Folder = "//a[@class='new-folder']";
		String folder_Dropdown = "//span[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(new_Folder)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(folder_Dropdown)).size() < 1);
	}
	
	public void verify_View_Only_File_Permissions_Enabled() {
		String click_For_More_Options = "//a[contains(text(),'click for more options')]";
		Assert.assertTrue(driver.findElements(By.xpath(click_For_More_Options)).size() < 1);
	}
	
	public void verify_View_Only_Folder_Permissions_Disabled() {
		String view_Only_Icon = "//i[@class='fa fa-desktop smallest-left']";
		Assert.assertTrue(driver.findElements(By.xpath(view_Only_Icon)).size() < 1);
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
	
	public void user_Can_Add_File_Folder_2() throws InterruptedException {
		this.click_New_Lib_Folder();
		Thread.sleep(1500);
		this.click_More_Options_Link();
		this.verify_Browse();
		this.add_File_Resource_Copy_Link();
		Thread.sleep(1500);
		this.click_Resource_Save_Btn();
		Thread.sleep(1500);
		this.verify_File_Created_2();
		System.out.println("------- Completed --> user_Can_Add_File_to_2nd_Folder() -----------");
	}
	// --------------- Function being called --------------------
	public void verify_Folder_Not_Present() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Folder2_NOT_Present();
		this.close_Modal();
		System.out.println("------- Completed --> verify_Folder_Not_Present() -----------");
	}
	
	// --------------- Function being called --------------------
	public void verify_File_Not_Present_in_Folder() throws InterruptedException {
		this.click_New_Folder_2();
		Thread.sleep(2000);
		this.verify_File_Not_Present();
		this.close_Modal();
		System.out.println("------- Completed --> verify_File_Not_Present_in_Folder() -----------");
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
	
	public void create_Sub_Folder1() throws InterruptedException {
		this.click_New_Lib_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder();
		this.click_New_Folder();
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys_3();
		this.click_SaveBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> create_Sub_Folder1() -----------");
	}
	
	public void create_Sub_Folder2() throws InterruptedException {
		this.verify_New_Folder();
		this.click_New_Folder();
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys_4();
		this.click_SaveBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> create_Sub_Folder2() -----------");
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
		Thread.sleep(1000);
		//this.verify_MR_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> move_File_From_View_Only_To_Non_View_Only() -----------");
	}
	
	// --------------- user_Can_Move_File--------------------
	By file_Dropdown = By.xpath("//a[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	//String fileDropdown ="//a[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	String fileDropdown ="//*[contains(text(),'Word_1.docx')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	String fileDropdown2 ="//a[contains(text(),'sisco.jpg')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	String fileDropdown3 ="//*[contains(text(),'ScannedDocument.pdf')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']";
	By Move_New_Libary_Folder = By.xpath("//ul[@id='library']//li[1]//a[1]");
	By workroom_Admin = By.xpath("//div[contains(text(),'Workroom Admin')]");
	By workroom_Admin_User = By.xpath("//div[@class='row small-left']//div[@class='person-name'][contains(text(),'Workroom Admin')]");

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
		System.out.println("------- Completed --> user_Can_Move_File() -----------");
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
		
	// --------------- Function being called --------------------
	public void user_Can_Add_Security_To_Folder_2() throws InterruptedException {
		this.verify_Folder_2_Dropdown();
        this.click_Dropdown_2();
		Thread.sleep(1000);
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
		this.close_Modal();
		System.out.println("------- Completed --> user_Can_Move_File() -----------");
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
	
	// --------------- verify_Folders_In_Secured_Folders_Catergory() --------------------
	By approvals = By.xpath("//li[@class='approvals']//a[contains(text(),'Approvals')]");
	By allow_Comments = By.xpath("//label[contains(text(),'Allow Comments')]");
	By submit = By.xpath("//div[@id='approvals_modal']//button[@class='btn btn-done'][contains(text(),'Submit')]");
	By workroom_Admin_2 = By.xpath("//div[@id='approvals_modal']//a[@class='active'][contains(text(),'People')]/following::div[@class='person-name'][contains(text(),'Workroom Admin')]");
	By auto_Director = By.xpath("//div[@id='approvals_modal']//a[@class='active'][contains(text(),'People')]/following::div[@class='person-name'][contains(text(),'Auto Director')]");
	By verify_Workroom_Admin_2_Added = By.xpath("//div[@class='person-name'][contains(text(),'Workroom Admin')]/following::span[@class='glyphicon glyphicon-remove remove-icon']");
	By close_Approvers_Box = By.xpath("//a[contains(text(),'Close')]");
	By secured_Folders = By.xpath("//a[contains(text(),'Secured Folders')]");
	By secured_Folders_Title = By.xpath("//h1[contains(text(),'Secured Folders')]");
	By resource_Library = By.xpath("//a[contains(text(),'Resource Library')]");
	
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
	
	public void click_Approvals() {
		//driver.findElement(approvals).click();
		WebElement element = driver.findElement(By.xpath("//li[@class='approvals']//a[contains(text(),'Approvals')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Allow_Comments() {
		//driver.findElement(allow_Comments).click();
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Allow Comments')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
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
	
	public void verify_Approvers_Added() throws InterruptedException {
		String wa_approver = "//div[contains(text(),'Workroom Admin')]";
		String ad_approver = "//div[contains(text(),'Auto Director')]";
		Assert.assertTrue(driver.findElements(By.xpath(wa_approver)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(ad_approver)).size() > 0);
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
		System.out.println("------- Completed --> user_Can_Verify_Approvers_Added() -----------");
	}		
	
	
	// --------------- user_Moves_New_Folder --------------------
	By move_Option = By.xpath("//span[contains(text(),'Move')]");
	By security_Option = By.xpath("//li[@class='security']//a[contains(text(),'Security')]");
	By security_Option_2 = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Security')]");
	By security_Option_2B = By.xpath("//a[contains(text(),'Security')]");
	By autoBE_Resource = By.xpath("//a[contains(@class,'workroom-2305')]");
	By moveBtn = By.xpath("//button[contains(text(),'Move')]");
	By move_Message = By.xpath("//p[contains(text(),'Files/Folders were successfully moved.')]");
	By close_Modal = By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']");

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
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Security')]"));
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
		//this.click_File_Dropdown();
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
	
	public void user_Can_Edit_File_2() throws InterruptedException {
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
	
	public void click_Dropdown_1() {
		//driver.findElement(dropdown).click();
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
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
		Thread.sleep(2500);
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
