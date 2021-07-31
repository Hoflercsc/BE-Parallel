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

public class SecuredCategoryPage {
	WebDriver driver;

	public SecuredCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// ----------- POM Page Object model -----------------------------
	// ---------workroom_Admin_Not_See_Event_Due_To_Permissions-------
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

	// ---------------Function Being Called-------------------
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_New_Book();
		System.out.println("------- Completed --> user_Can_Open_Library_Page_For_Workroom() -----------");
	}
	
	// ------------user_Can_Create_New_Book_And_Title-----------------
	By generate_Coverpage = By.xpath("//span[contains(text(),'Generate Cover Page')]");
	By title_Form_Field = By.xpath("//input[@id='book_title']");

	public void verify_Title_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Form_Field)));
	}

	public void click_New_Book() {
		driver.findElement(new_Book).click();
	}

	public void enter_Book_Title() throws InterruptedException {
		String book_title = "This is a Book Title";
		driver.findElement(title_Form_Field).sendKeys(book_title);
		Thread.sleep(1000);
	}

	public void click_Generate_Coverpage() {
		driver.findElement(generate_Coverpage).click();
	}

	// ---------------Function Being Called----------------------------
	public void user_Can_Create_New_Book_And_Add_Title() throws InterruptedException {
		this.click_New_Book();
		this.verify_Title_Input_Field();
		this.enter_Book_Title();
		this.click_Generate_Coverpage();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Create_New_Book_And_Add_Title() -----------");
	}
	
    //----------create_New_Book_From_Template_With_Secured_Category-----
	
	By bookTemplateDropDown = By.xpath("//*[@id='new_book']//div/button[contains(.,'Select an Option')]");
	By bookTemplateOption = By.xpath("//span[contains(text(),'This is a Book Template Title')]");

	public void click_Book_Template_DropDown() throws InterruptedException {
		driver.findElement(bookTemplateDropDown).click();
		System.out.println("------- Completed --> click_Book_Template_DropDown() -----------");
	}
	
	public void click_Book_Template_Option() throws InterruptedException {
		driver.findElement(bookTemplateOption).click();
		System.out.println("------- Completed --> click_Book_Template_Option() -----------");
	}
		
	public void create_New_Book_From_Template_With_Secured_Category() throws InterruptedException {
		this.click_New_Book();
		this.verify_Title_Input_Field();
		this.enter_Book_Title();
		this.click_Book_Template_DropDown();
		Thread.sleep(1000);
		this.click_Book_Template_Option();
		Thread.sleep(4000);// wait for collapse
		driver.findElement(Save_Continue_Btn).click();
		System.out.println("------- Completed --> create_New_Book_From_Template_With_Secured_Category() -----------");
	}
	
	// -------------------user_Can_Save_Book_And_Continue---------------
	By Save_Continue_Btn = By.xpath("//*[@id='new_book']/div[3]/div[3]/p/button");

	public void click_Save_Continue_Btn() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"new_book\"]/div[3]/div[3]/p/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		driver.findElement(Save_Continue_Btn).click();
		Thread.sleep(1000);
	}

	// ---------------Function Being Called-------------------
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		this.click_Save_Continue_Btn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Save_Book_And_Continue() -----------");
	}
	
	// ------------------user_Add_First_Catagory_To_Book_-----------------------------------
	By main_Catagory_1 = By.xpath("//div[@class='category-accordion ui-sortable']//a[1][contains(text(),'Add Main Category')]");
	By catagory_Name_Field = By.xpath("//input[@id='bookfolder_title']");
	By time_Field = By.xpath("//input[@id='bookfolder_time']");
	By presenter_Field = By.xpath("//input[@id='bookfolder_presenter']");
	By action_Field = By.xpath("//input[@id='bookfolder_action']");
	By additional_Notes_Field = By.xpath("//textarea[@id='bookfolder_notes']");
	By catagory_SaveBtn = By.xpath("//div[@class='modal-dialog']//button[@id='formsSubmit']");
	By new_Catagory = By.xpath("//a[contains(text(),'New Catagory')]");

	public void verify_Main_Catagory_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(main_Catagory_1)));
	}

	public void verify_Catagory_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(catagory_Name_Field)));
	}

	public void verify_New_Catagory_Name() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Catagory)));
	}

	public void click_Main_Catagory_1() throws InterruptedException {
		driver.findElement(main_Catagory_1).click();
		Thread.sleep(1000);
	}

	public void fill_Catagory_Form() throws InterruptedException {
		String catagory_Name = "New Catagory";
		String time = "the time";
		String presenter = "john presenter";
		String Action = "the action";
		String additional_Notes = "this is some notes";
		driver.findElement(catagory_Name_Field).sendKeys(catagory_Name);
		driver.findElement(time_Field).sendKeys(time);
		driver.findElement(presenter_Field).sendKeys(presenter);
		;
		driver.findElement(action_Field).sendKeys(Action);
		;
		driver.findElement(additional_Notes_Field).sendKeys(additional_Notes);
		Thread.sleep(1000);
	}

	public void click_Catagory_SaveBtn() throws InterruptedException {
		driver.findElement(catagory_SaveBtn).click();
		Thread.sleep(1000);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_First_Catagory_To_Book() throws InterruptedException {
		this.verify_Main_Catagory_1();
		this.click_Main_Catagory_1();
		Thread.sleep(1000);
		this.verify_Catagory_Name_Field();
		this.fill_Catagory_Form();
		this.click_Catagory_SaveBtn();
		this.verify_New_Catagory_Name();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Add_First_Catagory_To_Book -----------");
	}
	
	// ---------------------------------user_Can_Add_Agenda---------------------------------------------
	By agenda_Title = By.xpath("//input[@id='agenda_title']");
	By generate_Agenda = By.xpath("//span[contains(text(),'Generate Agenda')]");

	public void enter_Agenda_Title() throws InterruptedException {
		String agenda_title = "This is an Agenda";
		driver.findElement(agenda_Title).sendKeys(agenda_title);
		Thread.sleep(1000);
	}

	public void click_Generate_Agenda() throws InterruptedException {
		driver.findElement(generate_Agenda).click();
		Thread.sleep(1000);
	}

	// ---------------Function Being Called-------------------
	public void user_Can_Add_Agenda() throws InterruptedException {
		this.enter_Agenda_Title();
		this.click_Generate_Agenda();
		System.out.println("------- Completed --> user_Can_Add_Agenda() -----------");
	}
	
	// ------------------user_Add_File_To_First_Catagory------------------
	By click_For_More_Options = By.xpath("//a[contains(text(),'click for more options')]");
	By title_Field = By.xpath("//input[@id='bookfolder_title']");
	By file_SaveBtn = By.xpath("//div[@id='newBookFileModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By file_Upload_Success_Message = By
			.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'The following files were uploaded:')]");

	public void verify_Click_For_More_Options() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options)));
	}

	public void verify_Title_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Field)));
	}

	public void verify_File_Upload_Success_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Upload_Success_Message)));
	}

	public void click_For_More_Options() throws InterruptedException {
		driver.findElement(click_For_More_Options).click();
		Thread.sleep(1000);
	}

	public void title_Field_SendKeys() throws InterruptedException {
		String file_title = "the file title";
		driver.findElement(title_Field).sendKeys(file_title);
		Thread.sleep(1000);
	}

	public void add_First_Cat_File() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void file_Save_Btn() throws InterruptedException {
		driver.findElement(file_SaveBtn).click();
		Thread.sleep(1000);
	}

	// ------------------Function Being called-------------------------------
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_For_More_Options();
		this.verify_Title_Field();
		this.title_Field_SendKeys();
		this.add_First_Cat_File();
		this.file_Save_Btn();
		this.verify_File_Upload_Success_Message();
		System.out.println("------- Completed --> user_Add_File_To_First_Catagory()  -----------");
	}
	
	// ------------------user_Can_Open_Secured_Category--------------------------
	By newCat_Dropdown = By.xpath("(//a[contains(text(),'New Catagory')]/following::div[@class='dropdown header-actions-nofloat no-mobile'])[1]");
	By newCat_Dropdown_2 = By.xpath("(//a[contains(text(),'the file Title')]/following::div[@class='dropdown header-actions-nofloat no-mobile'])[1]");
	By security = By.xpath("//a[contains(text(),'Security')]");
	By manage_Contributors = By.xpath("//a[contains(text(),'Manage Contributors')]");

	public void verify_NewCat_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newCat_Dropdown)));
	}
	
	public void verify_NewCat_Dropdown_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newCat_Dropdown_2)));
	}

	public void verify_Security() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security)));
	}

	
	public void verify_Manage_Contributors() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(manage_Contributors)));
	}

	public void click_NewCat_Dropdown() throws InterruptedException {
		// driver.findElement(newCat_Dropdown).click();
		WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'New Catagory')]/following::button[@id='dropdownMenn-doc1'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
	}

	public void click_Security() throws InterruptedException {
		driver.findElement(security).click();
		Thread.sleep(1000);
	}

	public void click_Manage_Contributors() throws InterruptedException {
		driver.findElement(manage_Contributors).click();
	}

	// ------------------Function Being called-----------------------------------
	public void user_Can_Open_Secured_Category() throws InterruptedException {
		this.verify_NewCat_Dropdown();
		Thread.sleep(1000);
		this.click_NewCat_Dropdown();
		Thread.sleep(1000);
		this.verify_Security();
		this.click_Security();
		System.out.println("------- Completed --> user_Can_Open_Secured_Category()  -----------");
	}
	
	public void user_Can_Open_Manage_Contributors() throws InterruptedException {
		this.verify_NewCat_Dropdown();
		this.click_NewCat_Dropdown();
		Thread.sleep(1000);
		this.verify_Manage_Contributors();
		this.click_Manage_Contributors();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Open_Secured_Category()  -----------");
	}
	
	public void open_Book_Template_Secured_Category() throws InterruptedException {
		this.verify_NewCat_Dropdown_2();
		Thread.sleep(1000);
		this.click_NewCat_Dropdown();
		Thread.sleep(1000);
		this.verify_Security();
		this.click_Security();
		System.out.println("------- Completed --> open_Book_Template_Secured_Category()  -----------");
	}
	
	// ------------------Workroom_Admin_Can_Add_User_As_Secured_Category_User-----------
	By add_User_Search = By.xpath("//input[@placeholder='Search']");
	By workroom_Admin = By.xpath("(//div[contains(text(),'Workroom Admin')])[1]");
	By auto_Director = By.xpath("(//div[contains(text(),'Auto Director')])[1]");
	By auto_User_Admin1 = By.xpath("(//div[contains(text(),'Auto User Admin1')])[1]");

	By workroom_Admin_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Workroom Admin')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By auto_Director_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto Director')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By auto_User_Admin1_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto User Admin1')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign

	By close = By.xpath("//div[@id='secure']//button[@class='btn btn-default'][contains(text(),'Close')]");
	By save_WFB = By.xpath("//*[@id='manage-guest-list']//div/button");

	
	public void verify_Add_User_Search() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_User_Search)));
	}
	
	//using refreshed
	public void verify_Add_User_Search_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(add_User_Search)));
	}

	public void verify_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workroom_Admin)));
	}
	
	public void verify_Auto_Director() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_Director)));
	}

	public void verify_Auto_User_Admin1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User_Admin1)));
	}
	
	public void verify_Workroom_Admin_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(workroom_Admin_Added)));
	}

	public void verify_Auto_Director_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_Director_Added)));
	}
	
	public void verify_Auto_User_Admin1_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_User_Admin1_Added)));
	}
	
	public void click_Workroom_Admin() throws InterruptedException {
		driver.findElement(workroom_Admin).click();
	}
	
	public void click_Auto_Director() throws InterruptedException {
		driver.findElement(auto_Director).click();
	}

	public void click_Auto_User_Admin1() throws InterruptedException {
		driver.findElement(auto_User_Admin1).click();
	}
	
	public void click_Close() throws InterruptedException {
		driver.findElement(close).click();
		Thread.sleep(1000);
	}
	

	public void click_Save_WFB() throws InterruptedException {
		driver.findElement(save_WFB).click();
	}

	// ------------------Function Being called-----------------------------------
	public void Workroom_Admin_Can_Add_User_As_Secured_Category_User() throws InterruptedException {
		this.verify_Add_User_Search();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(3000);
		this.verify_Workroom_Admin_Added();
		this.click_Close();
		Thread.sleep(3000);
		System.out.println("------- Completed --> Workroom_Admin_Can_Add_User_As_Secured_Category_User()  -----------");
	}
	
	public void add_Single_User_Unordered_Approval_WorkroomAdmin() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1500);
		this.verify_Workroom_Admin_Added();
		this.click_Save_WFB();
		Thread.sleep(3500);
		System.out.println("------- Completed --> add_Single_User_Unordered_Approval_WorkroomAdmin()  -----------");
	}
	
	public void add_Single_User_Unordered_Approval_AutoDirector() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Auto_Director();
		this.click_Auto_Director();
		Thread.sleep(1500);
		this.verify_Auto_Director_Added();
		this.click_Save_WFB();
		Thread.sleep(3500);
		System.out.println("------- Completed --> add_Single_User_Unordered_Approval_AutoDirector()  -----------");
	}
	
	public void add_Single_User_Unordered_Approval_AutoUserAdmin1() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Auto_User_Admin1();
		this.click_Auto_User_Admin1();
		Thread.sleep(1500);
		this.verify_Auto_User_Admin1_Added();
		this.click_Save_WFB();
		Thread.sleep(3500);
		System.out.println("------- Completed --> add_Single_User_Unordered_Approval_AutoUserAdmin1()  -----------");
	}
	
	public void add_Unordered_Approval_Users_WorkroomAdmin_Auto_Director() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1500);
		this.click_Auto_Director();
		Thread.sleep(1500);
		this.verify_Workroom_Admin_Added();
		this.verify_Auto_Director_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> add_Unordered_Approval_User_WorkroomAdmin()  -----------");
	}
	
	public void Add_Ordered_Approval_Users_WorkroomAdmin_AutoDirector() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_Auto_Director();
		Thread.sleep(1500);
		this.click_Workroom_Admin();
		Thread.sleep(1500);
		this.verify_Auto_Director_Added();
		this.verify_Workroom_Admin_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> Add_Ordered_Approval_Users_WorkroomAdmin_AutoDirector()  -----------");
	}
	
	public void user_Can_Add_Workroom_Admin_As_Contributor() throws InterruptedException {
		this.verify_Add_User_Search();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(3000);
		this.verify_Workroom_Admin_Added();
		this.click_Close();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Workroom_Admin_As_Contributor()  -----------");
	}
	
	// ------------------Function Being called-----------------------------------
	By main_Catagory_2 = By.xpath("//div[@class='category-accordion ui-sortable']//a[2][contains(text(),'Add Main Category')]");
	By new_Catagory_2 = By.xpath("//a[contains(text(),'New Category 2')]");

	public void verify_Main_Catagory_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(main_Catagory_2)));
	}

	public void verify_New_Catagory_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Catagory_2)));
	}

	public void click_Main_Catagory_2() throws InterruptedException {
		driver.findElement(main_Catagory_2).click();
		Thread.sleep(1000);
	}

	public void fill_Catagory_Form_2() throws InterruptedException {
		String catagory_Name = "New Category 2";
		String time = "the time";
		String presenter = "john presenter";
		String Action = "the action";
		String additional_Notes = "this is some notes";
		driver.findElement(catagory_Name_Field).sendKeys(catagory_Name);
		driver.findElement(time_Field).sendKeys(time);
		driver.findElement(presenter_Field).sendKeys(presenter);
		;
		driver.findElement(action_Field).sendKeys(Action);
		;
		driver.findElement(additional_Notes_Field).sendKeys(additional_Notes);
		Thread.sleep(1000);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_Second_Catagory_To_Book() throws InterruptedException {
		this.verify_Main_Catagory_2();
		this.click_Main_Catagory_2();
		Thread.sleep(1000);
		this.verify_Catagory_Name_Field();
		this.fill_Catagory_Form_2();
		this.click_Catagory_SaveBtn();
		this.verify_New_Catagory_2();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Add_First_Catagory_To_Book -----------");
	}
	
	// --------------------------add_File_To_Second_Catagory()---------------------------
	By click_For_More_Options_2 = By.xpath("(//a[contains(text(),'click for more options')])[2]");

	public void verify_Click_For_More_Options_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options_2)));
	}

	public void click_Click_For_More_Options_2() throws InterruptedException {
		WebElement option2 = driver.findElement(By.xpath("(//a[contains(text(),'click for more options')])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", option2);
		// driver.findElement(click_For_More_Options_2).click();
		Thread.sleep(1000);
	}

	// ---------------Function Being Called-------------------
	public void add_File_To_Second_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options_2();
		this.click_Click_For_More_Options_2();
		this.verify_Title_Field();
		this.title_Field_SendKeys();
		this.add_First_Cat_File();// used for 2nd Catagory here
		this.file_Save_Btn();
		Thread.sleep(1000);
		this.verify_File_Upload_Success_Message();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_File_To_Second_Catagory()  -----------");
	}
	
	// -------------------build_Book()---------------------
	By build_Handbook = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Build Book')]");
	By build_DoneBtn = By.xpath("//button[contains(text(),'Done')]");

	public void verify_Build_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(build_Handbook)));
	}

	public void verify_Build_DoneBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(build_DoneBtn)));
	}

	public void scroll_Up_To_Build_Book() throws InterruptedException {
		WebElement build_Book = driver.findElement(By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Build Book')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", build_Book);
		Thread.sleep(1000);
	}

	public void click_Build_Book() throws InterruptedException {
		driver.findElement(build_Handbook).click();
		Thread.sleep(1000);
	}

	public void click_Build_DoneBtn() throws InterruptedException {
		driver.findElement(build_DoneBtn).click();
		Thread.sleep(1000);
	}

	// ---------------Function Being Called-------------------
	public void user_Can_Build_Book() throws InterruptedException {
		driver.navigate().refresh();
		this.verify_Build_Book();
		this.scroll_Up_To_Build_Book();
		this.click_Build_Book();
		this.verify_Build_DoneBtn();
		this.click_Build_DoneBtn();
		System.out.println("------- Completed --> user_Can_Build_Book()  -----------");
	}
	
	// ------------------make_Book_Visible----------------------
	By edit_BookBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Book')]");
	By onswitch = By.xpath("//label[@class='onoffswitch-label']");
	By workroom_Library_Crumb = By.xpath("//a[contains(text(),'Workroom Library')]");
	By book_Title = By.xpath("//a[contains(text(),'This is a Book Title')]");

	public void verify_Edit_BookBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_BookBtn)));
	}

	public void verify_Book_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title)));
	}

	public void click_On_Switch() throws InterruptedException {
		driver.findElement(onswitch).click();
		Thread.sleep(1000);
	}

	public void click_Workroom_Library_Crumb() throws InterruptedException {
		driver.findElement(workroom_Library_Crumb).click();
		Thread.sleep(1000);
	}
	
	// ---------------Function Being Called-------------------
	public void make_Book_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		this.click_Workroom_Library_Crumb();
		this.verify_Book_Visible();
		System.out.println("------- Completed --> make_Book_Visible()  -----------");
	}
	
	// ------------------systemAdmin_Close_And_Logout-----------------
	By user_Profile_Dropdown = By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By sign_Out = By.xpath("//a[contains(text(),'Sign Out')]");

	public void verify_User_Profile_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Profile_Dropdown)));
	}

	public void verify_Sign_Out() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sign_Out)));
	}

	public void click_User_Profile_Dropdown() {
		driver.findElement(user_Profile_Dropdown).click();
	}

	public void click_Sign_Out() {
		driver.findElement(sign_Out).click();
	}

	// ---------------Function Being Called-------------------
	public void workroomAdmin_Close_And_Logout() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_User_Profile_Dropdown();
		this.click_User_Profile_Dropdown();
		Thread.sleep(1000);
		this.verify_Sign_Out();
		this.click_Sign_Out();
		Thread.sleep(3000);
		System.out.println("------- Completed --> systemAdmin_Close_And_Logout() -----------");
	}

	// ---------------workroom_Member_Open_Library_Page_For_Workroom-----------
	// ---------------Function Being Called-------------------
	public void workroom_Member_Open_Library_Page_For_Workroom() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		System.out.println("------- Completed --> workroom_Member_Open_Library_Page_For_Workroom() -----------");
	}
	
	// ------------------workroom_Member_Navigate_To_Book_Secured_Category_Not_Displayed------
	By newCatagory = By.xpath("//h3[contains(text(),'New Catagory')]");
	By book_Title_2 = By.xpath("//h1[contains(text(),'This is a Book Title')]");

	public void verify_Book_Title_2_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title_2)));
	}

	public void click_Book_Title() {
		driver.findElement(book_Title).click();
	}

	public void verify_NewCatagory_Not_Visible() throws InterruptedException {
		String newcategory = "//h3[contains(text(),'New Catagory')]";	
		Assert.assertTrue(driver.findElements(By.xpath(newcategory)).size() < 1);
		Thread.sleep(1500);
	}

	// ---------------Function Being Called-------------------
	public void workroom_Member_Secured_Category_Not_Displayed() throws InterruptedException {
		this.verify_Book_Visible();
		Thread.sleep(1000);
		this.click_Book_Title();
		Thread.sleep(1000);
		this.verify_Book_Title_2_Visible();
		Thread.sleep(2000);
		this.verify_NewCatagory_Not_Visible();
		System.out.println("------- Completed --> workroom_Member_Navigate_To_Book_Secured_Category_Not_Displayed() -----------");
	}

	public void verify_New_Catagory_2_Present() {
		String newcategory2 = "//h3[contains(text(),'New Category 2')]";
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		boolean category2 = driver.findElements(By.xpath(newcategory2)).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (category2 == true) {
			WebElement cat2 = driver.findElement(By.xpath(newcategory2));
			Assert.assertTrue(category2, cat2.getText() + " is present");
		} else {
			Assert.assertFalse(category2, " New Category 2 Not Present");
		}
	}

	// ---------------Function Being Called-------------------
	public void workroom_Member_Sees_New_Category_2_Present() throws InterruptedException {
		this.verify_New_Catagory_2_Present();
		System.out.println("------- Completed --> workroom_Member_See_New_Category_2_Present() -----------");
	}
	
	// --------------------workroom_Member_Navigate_To_Book_Secured_Category_Is_Displayed-----------------------
	By newCatagory_2 = By.xpath("//h3[contains(text(),'New Category 2')]");

	public void verify_NewCatagory_NewCatagory2_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(
				ExpectedConditions.and(ExpectedConditions.elementToBeClickable(newCatagory), ExpectedConditions.elementToBeClickable(newCatagory_2)));
	}
	
	public void verify_NewCatagory_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(newCatagory)));
	}

	// ---------------Function Being Called-------------------
	
	public void workroom_Member_NewCatagory_Is_Displayed() throws InterruptedException {
		this.verify_Book_Visible();
		Thread.sleep(1000);
		this.click_Book_Title();
		Thread.sleep(1000);
		this.verify_Book_Title_2_Visible();
		Thread.sleep(1000);
		this.verify_NewCatagory_Visible();
		System.out.println("------- Completed --> workroom_Member_NewCatagory_And_NewCatagory2_Is_Displayed() -----------");
	}
	
	public void workroom_Member_NewCatagory_And_NewCatagory2_Is_Displayed() throws InterruptedException {
		this.verify_Book_Visible();
		Thread.sleep(1000);
		this.click_Book_Title();
		Thread.sleep(1000);
		this.verify_Book_Title_2_Visible();
		Thread.sleep(1000);
		this.verify_NewCatagory_NewCatagory2_Visible();
		System.out.println("------- Completed --> workroom_Member_NewCatagory_And_NewCatagory2_Is_Displayed() -----------");
	}
	
	// --------------------------workroom_Admim_Can_Delete_Book---------------------------------------------------
	// By book_DropDown = By.xpath("//a[contains(text(),'This is a Book
	// Title')]/following::div[@class='dropdown header-actions']");
	By book_DropDown = By.xpath("//*[starts-with (@id,'card-')]/div[2]/div[1]/h3/a/following::div[@class='dropdown header-actions']");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By formField = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_Book_DropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_DropDown)));
	}

	public void verify_Delete() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void verify_Form_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(formField)));
	}

	public void click_Book_DropDown() {
		driver.findElement(book_DropDown).click();
	}

	public void click_Delete() {
		driver.findElement(delete_Option).click();
	}

	public void click_And_SendKeys() {
		driver.findElement(formField).sendKeys("delete");
	}

	public void click_Continue() {
		driver.findElement(continueBtn).click();
	}

	// ---------------Function Being Called-------------------
	public void user_Can_Delete_Book() throws InterruptedException {
		this.verify_Book_DropDown();
		this.click_Book_DropDown();
		Thread.sleep(1000);
		this.verify_Delete();
		this.click_Delete();
		Thread.sleep(1000);
		this.verify_Form_Field();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_Continue();
		System.out.println("------- Completed --> workroom_Admim_Can_Delete_Book() -----------");
	}

	// ------------------------------verify_Book_Deleted-------------------------------------------------
	public void verify_Book_NOT_Displayed() throws InterruptedException {
		// String element = "//a[contains(text(),'This is a Book
		// Title')]/following::div[@class='dropdown header-actions']";
		for (int i = 0; i < 1; i++) {
			String book = "//*[starts-with (@id,'card-')]/div[2]/div[1]/h3/a/following::div[@class='dropdown header-actions']";
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			boolean mybook = driver.findElements(By.xpath(book)).size() < 1;
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			if (mybook == true) {
				Assert.assertTrue(mybook, "Book NOT present");
				break;
			} else if (mybook == false) {
				this.user_Can_Delete_Book();
				Thread.sleep(3000);
				driver.navigate().refresh();
				driver.navigate().refresh();
				Thread.sleep(3000);
				Assert.assertTrue(driver.findElements(By.xpath(book)).size() < 1);
			}
		} // end for loop
	}

	// ---------------Function Being Called-------------------
	public void verify_Book_Deleted() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		this.verify_Book_NOT_Displayed();
		System.out.println("------- Completed --> verify_Book_Deleted() -----------");
	}
}
