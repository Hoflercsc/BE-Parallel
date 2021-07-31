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

public class SecuredCategoryPage {
	
	
	// ----------- POM Page Object model -----------------------------
	// ---------workroom_Admin_Not_See_Event_Due_To_Permissions-------
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Form_Field)));
	}

	public void click_New_Book() {
		DriverFactory.getInstance().getDriver().findElement(new_Book).click();
	}

	public void enter_Book_Title() throws InterruptedException {
		String book_title = "Book Secured Category";
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(book_title);
	}
	
	public void enter_Book_Title_2(String meetingbook11) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(meetingbook11);
	}
	
	public void click_Generate_Coverpage() {
		DriverFactory.getInstance().getDriver().findElement(generate_Coverpage).click();
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
	By book_Template_10_Option = By.xpath("//span[contains(text(),'Meeting Book 10')]");

	public void click_Book_Template_DropDown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(bookTemplateDropDown).click();
		System.out.println("------- Completed --> click_Book_Template_DropDown() -----------");
	}
	
	public void click_Book_Template_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(bookTemplateOption).click();
		System.out.println("------- Completed --> click_Book_Template_Option() -----------");
	}
	
	public void click_Book_Template_10_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(book_Template_10_Option).click();
		System.out.println("------- Completed --> click_Book_Template_Option() -----------");
	}
		
	public void create_Book_From_Template_With_Secured_Category(String meetingbook11) throws InterruptedException {
		this.click_New_Book();
		this.verify_Title_Input_Field();
		this.enter_Book_Title_2(meetingbook11);
		this.click_Book_Template_DropDown();
		Thread.sleep(1000);
		this.click_Book_Template_10_Option();
		Thread.sleep(4000);// wait for collapse
		DriverFactory.getInstance().getDriver().findElement(Save_Continue_Btn).click();
		System.out.println("------- Completed --> create_Book_From_Template_With_Secured_Category() -----------");
	}
	
	// -------------------user_Can_Save_Book_And_Continue---------------
	By Save_Continue_Btn = By.xpath("//*[@id='new_book']/div[3]/div[3]/p/button");

	public void click_Save_Continue_Btn() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"new_book\"]/div[3]/div[3]/p/button"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(Save_Continue_Btn).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(main_Catagory_1)));
	}

	public void verify_Catagory_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(catagory_Name_Field)));
	}

	public void verify_New_Catagory_Name() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Catagory)));
	}

	public void click_Main_Catagory_1() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(main_Catagory_1).click();
		Thread.sleep(1000);
	}

	public void fill_Catagory_Form() throws InterruptedException {
		String catagory_Name = "New Catagory";
		String time = "the time";
		String presenter = "john presenter";
		String Action = "the action";
		String additional_Notes = "this is some notes";
		DriverFactory.getInstance().getDriver().findElement(catagory_Name_Field).sendKeys(catagory_Name);
		DriverFactory.getInstance().getDriver().findElement(time_Field).sendKeys(time);
		DriverFactory.getInstance().getDriver().findElement(presenter_Field).sendKeys(presenter);
		DriverFactory.getInstance().getDriver().findElement(action_Field).sendKeys(Action);
		DriverFactory.getInstance().getDriver().findElement(additional_Notes_Field).sendKeys(additional_Notes);
		Thread.sleep(1000);
	}

	public void click_Catagory_SaveBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(catagory_SaveBtn).click();
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
		DriverFactory.getInstance().getDriver().findElement(agenda_Title).sendKeys(agenda_title);
		Thread.sleep(1000);
	}

	public void click_Generate_Agenda() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(generate_Agenda).click();
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
	By file_Upload_Success_Message = By.xpath("//p[contains(text(),'The following files were uploaded:')]");

	public void verify_Click_For_More_Options() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options)));
	}

	public void verify_Title_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Field)));
	}

	public void verify_File_Upload_Success_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Upload_Success_Message)));
	}

	public void click_For_More_Options() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(click_For_More_Options).click();
		Thread.sleep(1000);
	}

	public void title_Field_SendKeys() throws InterruptedException {
		String file_title = "the file title";
		DriverFactory.getInstance().getDriver().findElement(title_Field).sendKeys(file_title);
		Thread.sleep(1000);
	}

	public void add_First_Cat_File() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void file_Save_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(file_SaveBtn).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newCat_Dropdown)));
	}
	
	public void verify_NewCat_Dropdown_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newCat_Dropdown_2)));
	}

	public void verify_Security() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security)));
	}

	
	public void verify_Manage_Contributors() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(manage_Contributors)));
	}

	public void click_NewCat_Dropdown() throws InterruptedException {
		// DriverFactory.getInstance().getDriver().findElement(newCat_Dropdown).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'New Catagory')]/following::button[@id='dropdownMenn-doc1'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
	}

	public void click_Security() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(security).click();
		Thread.sleep(1000);
	}

	public void click_Manage_Contributors() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(manage_Contributors).click();
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
	By workroom_Admin_2 = By.xpath("(//div[contains(text(),'Workroom Admin2')])[1]");
	By workroom_Admin_Eng = By.xpath("(//div[contains(text(),'workroom admineng')])[1]");
	By workroom_Admin_Eng_2 = By.xpath("(//div[contains(text(),'workroom admineng2')])[1]");
	By system_Admin_Eng = By.xpath("(//div[contains(text(),'system admineng')])[1]");

	By auto_Director = By.xpath("(//div[contains(text(),'Auto Director')])[1]");
	By auto_Director_2 = By.xpath("(//div[contains(text(),'Auto Director2')])[1]");
	By auto_User_17 = By.xpath("(//div[contains(text(),'Auto User17')])[1]");
	By auto_User_18 = By.xpath("(//div[contains(text(),'Auto User18')])[1]");
	By auto_User_2 = By.xpath("(//div[contains(text(),'Auto User2')])[1]");
	By auto_User_13 = By.xpath("(//div[contains(text(),'Auto User13')])[1]");
	By auto_User_15 = By.xpath("(//div[contains(text(),'Auto User15')])[1]");
	By auto_User_20 = By.xpath("(//div[contains(text(),'Auto User20')])[1]");

	By auto_User_Admin1 = By.xpath("(//div[contains(text(),'Auto User Admin1')])[1]");
	By auto_User_Admin3 = By.xpath("(//div[contains(text(),'Auto User Admin3')])[1]");

	By workroom_Admin_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Workroom Admin')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By workroom_Admin_2_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Workroom Admin2')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By workroom_Admin_Eng_Added = By.xpath("(//div[@class='person-name'][contains(text(),'workroom admineng')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By workroom_Admin_Eng_2_Added = By.xpath("(//div[@class='person-name'][contains(text(),'workroom admineng2')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign

	By auto_Director_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto Director')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By auto_Director_2_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto Director2')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By auto_User_2_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto User2')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign

	By auto_User_13_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto User13')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By auto_User_15_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto User15')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign

	By auto_User_17_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto User17')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By auto_User_18_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto User18')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By auto_User_20_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto User20')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign

	By auto_User_Admin1_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto User Admin1')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign
	By auto_User_Admin3_Added = By.xpath("(//div[@class='person-name'][contains(text(),'Auto User Admin3')]/following::span[@class='icon minus-sign-icon'])[1]"); // looking for minus sign

	By close = By.xpath("//div[@id='secure']//button[@class='btn btn-default'][contains(text(),'Close')]");
	By save_WFB = By.xpath("//*[@id='manage-guest-list']//div/button");

	
	public void verify_Add_User_Search() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_User_Search)));
	}
	
	//using refreshed
	public void verify_Add_User_Search_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(add_User_Search)));
	}

	public void verify_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workroom_Admin_2)));
	}
	
	public void verify_Workroom_Admin_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workroom_Admin)));
	}
	
	public void verify_Workroom_Admin_Eng_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workroom_Admin_Eng_2)));
	}
	
	public void verify_Auto_Director() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_Director)));
	}
	
	public void verify_Auto_User_17() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workroom_Admin_2)));
	}

	public void verify_Auto_User_Admin1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User_Admin1)));
	}
	
	public void verify_Workroom_Admin_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(workroom_Admin_Added)));
	}
	
	public void verify_Workroom_Admin_2_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(workroom_Admin_2_Added)));
	}

	public void verify_Workroom_Admin_Eng_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(workroom_Admin_Eng_Added)));
	}
	
	public void verify_Workroom_Admin_Eng_2_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(workroom_Admin_Eng_2_Added)));
	}
	
	public void verify_Auto_Director_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_Director_Added)));
	}
	
	public void verify_Auto_Director_2_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_Director_2_Added)));
	}
	
	public void verify_Auto_User_2_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_User_2_Added)));
	}
	
	public void verify_Auto_User_13_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_User_13_Added)));
	}
	
	public void verify_Auto_User_15_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_User_15_Added)));
	}
	
	public void verify_Auto_User_17_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_User_17_Added)));
	}
	
	public void verify_Auto_User_18_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_User_18_Added)));
	}
	
	public void verify_Auto_User_20_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_User_20_Added)));
	}
	
	public void verify_Auto_User_Admin1_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_User_Admin1_Added)));
	}
	
	public void verify_Auto_User_Admin3_Added() {
		// using refreshed
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(
				// looking for minus sign
				ExpectedConditions.elementToBeClickable(auto_User_Admin3_Added)));
	}
	
	public void click_Workroom_Admin() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(workroom_Admin).click();
	}
	
	public void click_Workroom_Admin_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(workroom_Admin_2).click();
	}
	
	public void click_Workroom_Admin_Eng() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Eng).click();
	}
	
	public void click_Workroom_Admin_Eng_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Eng_2).click();
	}
	
	public void click_System_Admin_Eng() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(system_Admin_Eng).click();
	}
	
	public void click_Auto_Director() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(auto_Director).click();
	}
	
	public void click_Auto_Director_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(auto_Director_2).click();
	}
	
	public void click_AutoUser_2() throws InterruptedException {
		WebElement user = DriverFactory.getInstance().getDriver().findElement(auto_User_2);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", user);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(auto_User_2).click();
	}
	
	public void click_AutoUser_13() throws InterruptedException {
		WebElement user = DriverFactory.getInstance().getDriver().findElement(auto_User_13);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", user);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(auto_User_13).click();
	}
	
	public void click_AutoUser_15() throws InterruptedException {
		WebElement user = DriverFactory.getInstance().getDriver().findElement(auto_User_15);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", user);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(auto_User_15).click();
	}
	
	public void click_AutoUser_17() throws InterruptedException {
		WebElement user = DriverFactory.getInstance().getDriver().findElement(auto_User_17);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", user);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(auto_User_17).click();
	}
	
	public void click_AutoUser_18() throws InterruptedException {
		WebElement user = DriverFactory.getInstance().getDriver().findElement(auto_User_18);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", user);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(auto_User_18).click();
	}
	
	public void click_AutoUser_20() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(auto_User_20).click();
	}

	public void click_Auto_User_Admin1() throws InterruptedException {
		WebElement user = DriverFactory.getInstance().getDriver().findElement(auto_User_Admin1);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", user);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(auto_User_Admin1).click();
	}
	
	public void click_Auto_User_Admin3() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(auto_User_Admin3).click();
	}
	
	public void click_Close() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(close).click();
		Thread.sleep(1000);
	}
	
	public void click_Save_WFB() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(save_WFB).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(save_WFB);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// ------------------Function Being called-----------------------------------
	public void Workroom_Admin_Added_As_Secured_Category_User() throws InterruptedException {
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
	
	public void Workroom_Admin_2_Can_Add_User_As_Secured_Category_User() throws InterruptedException {
		this.verify_Add_User_Search();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_2();
		this.click_Workroom_Admin_2();
		Thread.sleep(3000);
		this.verify_Workroom_Admin_2_Added();
		this.click_Close();
		Thread.sleep(3000);
		System.out.println("------- Completed --> Workroom_Admin_2_Can_Add_User_As_Secured_Category_User()  -----------");
	}
	
	public void Workroom_Admin_Eng_2_Can_Add_User_As_Secured_Category_User() throws InterruptedException {
		this.verify_Add_User_Search();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_Eng_2();
		this.click_Workroom_Admin_Eng_2();
		Thread.sleep(3000);
		this.verify_Workroom_Admin_Eng_2_Added();
		this.click_Close();
		Thread.sleep(3000);
		System.out.println("------- Completed --> Workroom_Admin_Eng_2_Can_Add_User_As_Secured_Category_User()  -----------");
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
	
	public void add_Single_User_Unordered_Approval_AutoUser2() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_AutoUser_2();
		Thread.sleep(1500);
		this.verify_Auto_User_2_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> add_Single_User_Unordered_Approval_AutoUser2()  -----------");
	}
	
	public void add_Single_User_Unordered_Approval_AutoUser13() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_AutoUser_13();
		Thread.sleep(1500);
		this.verify_Auto_User_13_Added();
		Thread.sleep(1000);// added for site issues
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> add_Single_User_Unordered_Approval_AutoUser13()  -----------");
	}
	
	public void add_Single_User_Unordered_Approval_AutoUser15() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_AutoUser_15();
		Thread.sleep(1500);
		this.verify_Auto_User_15_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> add_Single_User_Unordered_Approval_AutoUser15()  -----------");
	}
	
	public void add_Single_User_Unordered_Approval_AutoUser17() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_AutoUser_17();
		Thread.sleep(1500);
		this.verify_Auto_User_17_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> add_Single_User_Unordered_Approval_AutoUser17()  -----------");
	}
	
	public void add_Single_User_Unordered_Approval_AutoUser18() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_AutoUser_18();
		Thread.sleep(1500);
		this.verify_Auto_User_18_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> add_Single_User_Unordered_Approval_AutoUser18()  -----------");
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
	
	public void add_Unordered_Approval_Users_Auto_User_17_Auto_User_20() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Auto_User_17();
		this.click_AutoUser_17();
		Thread.sleep(1500);
		this.click_AutoUser_20();
		Thread.sleep(1500);
		this.verify_Auto_User_17_Added();
		this.verify_Auto_User_20_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> add_Unordered_Approval_Users_Auto_User_17_Auto_User_20()  -----------");
	}
	
	public void Add_Ordered_Approval_Users_WorkroomAdmin_2_Workroom_Admin_Eng() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_2();
		this.click_Workroom_Admin_2();
		Thread.sleep(1000);
		this.click_Workroom_Admin_Eng();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_2_Added();
		this.verify_Workroom_Admin_Eng_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> Add_Ordered_Approval_Users_WorkroomAdmin_2_Workroom_Admin_Eng()  -----------");
	}
	
	
	public void Add_Ordered_Approval_Users_AutoUserAdmin1_AutoUserAdmin3() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_Eng_2();
		this.click_Auto_User_Admin1();
		Thread.sleep(1000);
		this.click_Auto_User_Admin3();
		Thread.sleep(1000);
		this.verify_Auto_User_Admin1_Added();
		this.verify_Auto_User_Admin3_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> Add_Ordered_Approval_Users_AutoUserAdmin1_AutoUserAdmin3()  -----------");
	}
	
	public void Add_Ordered_Approval_Users_SystemAdminEng_WorkroomAdminEng2() throws InterruptedException {
		this.verify_Add_User_Search_2();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_Eng_2();
		this.click_Workroom_Admin_Eng_2();
		Thread.sleep(1000);
		this.click_System_Admin_Eng();
		Thread.sleep(1000);
		this.verify_Workroom_Admin_Eng_2_Added();
		this.click_Save_WFB();
		Thread.sleep(3000);
		System.out.println("------- Completed --> Add_Ordered_Approval_Users_SystemAdminEng_WorkroomAdminEng2()  -----------");
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_Workroom_Admin_As_Contributor()  -----------");
	}
	
	// ------------------Function Being called-----------------------------------
	By main_Catagory_2 = By.xpath("//div[@class='category-accordion ui-sortable']//a[2][contains(text(),'Add Main Category')]");
	By new_Catagory_2 = By.xpath("//a[contains(text(),'New Category 2')]");

	public void verify_Main_Catagory_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(main_Catagory_2)));
	}

	public void verify_New_Catagory_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Catagory_2)));
	}

	public void click_Main_Catagory_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(main_Catagory_2).click();
		Thread.sleep(1000);
	}

	public void fill_Catagory_Form_2() throws InterruptedException {
		String catagory_Name = "New Category 2";
		String time = "the time";
		String presenter = "john presenter";
		String Action = "the action";
		String additional_Notes = "this is some notes";
		DriverFactory.getInstance().getDriver().findElement(catagory_Name_Field).sendKeys(catagory_Name);
		DriverFactory.getInstance().getDriver().findElement(time_Field).sendKeys(time);
		DriverFactory.getInstance().getDriver().findElement(presenter_Field).sendKeys(presenter);
		DriverFactory.getInstance().getDriver().findElement(action_Field).sendKeys(Action);
		DriverFactory.getInstance().getDriver().findElement(additional_Notes_Field).sendKeys(additional_Notes);
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options_2)));
	}

	public void click_Click_For_More_Options_2() throws InterruptedException {
		WebElement option2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'click for more options')])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", option2);
		// DriverFactory.getInstance().getDriver().findElement(click_For_More_Options_2).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(build_Handbook)));
	}

	public void verify_Build_DoneBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(100)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(build_DoneBtn)));
	}

	public void scroll_Up_To_Build_Book() throws InterruptedException {
		WebElement build_Book = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Build Book')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", build_Book);
		Thread.sleep(1000);
	}

	public void click_Build_Book() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(build_Handbook).click();
		Thread.sleep(1000);
	}

	public void click_Build_DoneBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(build_DoneBtn).click();
		Thread.sleep(1000);
	}

	// ---------------Function Being Called-------------------
	public void user_Can_Build_Book() throws InterruptedException {
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_Build_Book();
		this.scroll_Up_To_Build_Book();
		Thread.sleep(2500);
		this.click_Build_Book();
		Thread.sleep(2500);
		this.verify_Build_DoneBtn();
		this.click_Build_DoneBtn();
		System.out.println("------- Completed --> user_Can_Build_Book()  -----------");
	}
	
	// ------------------make_Book_Visible----------------------
	By edit_BookBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Book')]");
	By onswitch = By.xpath("//label[@class='onoffswitch-label']");
	By workroom_Library_Crumb = By.xpath("//a[contains(text(),'Workroom Library')]");
	By book_Title_Secured_Category = By.xpath("//*[contains(text(),'Book Secured Category')]");
	By book_Title_11 = By.xpath("//*[normalize-space(text())='Meeting Book 11']");


	public void verify_Edit_BookBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_BookBtn)));
	}

	public void verify_Book_Secured_Category_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title_Secured_Category)));
	}
	
	public void verify_Book_Title_11_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(book_Title_11)));
	}
	
	public void click_Book_Title_11() throws InterruptedException {
		WebElement build_Book = DriverFactory.getInstance().getDriver().findElement(book_Title_11);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", build_Book);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(book_Title_11).click();
	}

	public void click_On_Switch() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(onswitch).click();
		Thread.sleep(1000);
	}

	public void click_Workroom_Library_Crumb() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(workroom_Library_Crumb).click();
		Thread.sleep(1000);
	}
	
	// ---------------Function Being Called-------------------
	public void make_Secured_Book_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		this.click_Workroom_Library_Crumb();
		this.verify_Book_Secured_Category_Visible();
		System.out.println("------- Completed --> make_Book_Visible()  -----------");
	}
	
	// ------------------systemAdmin_Close_And_Logout-----------------
	By user_Profile_Dropdown = By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By sign_Out = By.xpath("//a[contains(text(),'Sign Out')]");

	public void verify_User_Profile_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Profile_Dropdown)));
	}

	public void verify_Sign_Out() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sign_Out)));
	}

	public void click_User_Profile_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(user_Profile_Dropdown).click();
	}

	public void click_Sign_Out() {
		DriverFactory.getInstance().getDriver().findElement(sign_Out).click();
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

	public void click_Book_Title_Secured_Category() {
		DriverFactory.getInstance().getDriver().findElement(book_Title_Secured_Category).click();
	}

	public void verify_NewCatagory_Not_Visible() throws InterruptedException {
		String newcategory = "//h3[contains(text(),'New Catagory')]";	
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(newcategory)).size() < 1);
	}
	
	// ---------------Function Being Called-------------------
	public void workroom_Member_Secured_Category_Not_Displayed() throws InterruptedException {
		this.verify_Book_Secured_Category_Visible();
		Thread.sleep(1000);
		this.click_Book_Title_Secured_Category();
		Thread.sleep(1000);
		this.verify_Book_Secured_Category_Visible();
		Thread.sleep(1000);
		this.verify_NewCatagory_Not_Visible();
		System.out.println("------- Completed --> workroom_Member_Navigate_To_Book_Secured_Category_Not_Displayed() -----------");
	}
	
	public void workroom_Member_Book_11_Secured_Category_Not_Displayed() throws InterruptedException {
		this.verify_Book_Title_11_Visible();
		this.click_Book_Title_11();
		Thread.sleep(1000);
		this.verify_Book_Title_11_Visible();
		Thread.sleep(1000);
		this.verify_NewCatagory_Not_Visible();
		System.out.println("------- Completed --> workroom_Member_Book_11_Secured_Category_Not_Displayed() -----------");
	}

	public void verify_New_Catagory_2_Present() {
		String categortTwo = "//h3[contains(text(),'New Category 2')]";	
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(categortTwo)).size() > 0);
	}

	// ---------------Function Being Called-------------------
	public void workroom_Member_Sees_New_Category_2_Present() throws InterruptedException {
		this.verify_New_Catagory_2_Present();
		System.out.println("------- Completed --> workroom_Member_See_New_Category_2_Present() -----------");
	}
	
	// --------------------workroom_Member_Navigate_To_Book_Secured_Category_Is_Displayed-----------------------
	By newCatagory_2 = By.xpath("//h3[contains(text(),'New Category 2')]");

	public void verify_NewCatagory_NewCatagory2_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(
				ExpectedConditions.and(ExpectedConditions.elementToBeClickable(newCatagory), ExpectedConditions.elementToBeClickable(newCatagory_2)));
	}
	
	public void verify_NewCatagory_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(newCatagory)));
	}

	// ---------------Function Being Called-------------------
	
	public void workroom_Member_Book_11_NewCatagory_Is_Displayed() throws InterruptedException {
		this.verify_Book_Title_11_Visible();
		this.click_Book_Title_11();
		Thread.sleep(1000);
		this.verify_Book_Title_11_Visible();
		Thread.sleep(1000);
		this.verify_NewCatagory_Visible();
		System.out.println("------- Completed --> workroom_Member_Book_11_NewCatagory_Is_Displayed() -----------");
	}
	
	public void workroom_Member_NewCatagory_And_NewCatagory2_Is_Displayed() throws InterruptedException {
		this.verify_Book_Secured_Category_Visible();
		Thread.sleep(1000);
		this.click_Book_Title_Secured_Category();
		Thread.sleep(1000);
		this.verify_Book_Secured_Category_Visible();
		Thread.sleep(1000);
		this.verify_NewCatagory_NewCatagory2_Visible();
		System.out.println("------- Completed --> workroom_Member_NewCatagory_And_NewCatagory2_Is_Displayed() -----------");
	}
	
	// --------------------------workroom_Admim_Can_Delete_Book---------------------------------------------------
	By book_Secured_Category_DropDown = By.xpath("//*[contains(text(),'Book Secured Category')]/following::div[@class='dropdown header-actions']");
	By book_Secured_Category_Title = By.xpath("//*[contains(text(),'Book Secured Category')]/following::div[@class='dropdown header-actions']");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By delete_Option_Inside = By.xpath("//a[contains(text(),'Delete')]");
	By formField = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_Book_Secured_Category_DropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Secured_Category_DropDown)));
	}

	public void verify_Book_Secured_Category_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Secured_Category_Title)));
	}
	
	public void verify_Delete() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}
	
	public void verify_Delete_Option_Inside() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option_Inside)));
	}

	public void verify_Form_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(formField)));
	}

	public void click_Book_Secured_Category_DropDown() {
		DriverFactory.getInstance().getDriver().findElement(book_Secured_Category_DropDown).click();
	}
	
	public void click_Book_Secured_Category_Title() {
		DriverFactory.getInstance().getDriver().findElement(book_Secured_Category_Title).click();
	}

	public void click_Delete() {
		DriverFactory.getInstance().getDriver().findElement(delete_Option).click();
	}
	
	public void click_Delete_Option_Inside() {
		DriverFactory.getInstance().getDriver().findElement(delete_Option_Inside).click();
	}

	public void click_And_SendKeys() {
		DriverFactory.getInstance().getDriver().findElement(formField).sendKeys("delete");
	}

	public void click_Continue() {
		DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
	}

	// ---------------Function Being Called-------------------
	public void delete_Book_Secured_Category() throws InterruptedException {
		this.verify_Book_Secured_Category_Title();
		this.click_Book_Secured_Category_Title();
		Thread.sleep(1000);
		this.verify_Delete_Option_Inside();
		this.click_Delete_Option_Inside();
		Thread.sleep(1000);
		this.verify_Form_Field();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_Continue();
		System.out.println("------- Completed --> workroom_Admim_Can_Delete_Book() -----------");
	}

	// ------------------------------verify_Book_Deleted-------------------------------------------------
	public void verify_Book_NOT_Displayed() throws InterruptedException {
		String book = "//*[contains(text(),'Book Secured Category')]";	
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(book)).size() < 1);
	}

	// ---------------Function Being Called-------------------
	public void verify_Book_Deleted() throws InterruptedException {
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_Book_NOT_Displayed();
		System.out.println("------- Completed --> verify_Book_Deleted() -----------");
	}
}
