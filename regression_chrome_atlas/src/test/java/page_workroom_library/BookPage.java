package page_workroom_library;

import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
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
import page_common_functions.AtlasNavBar;
import page_critical_scenarios.SecuredCategoryPage;

public class BookPage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public BookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// ---------------------------------workroom_Admin_Not_See_Event_Due_To_Permissions---------------------------------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By autoAttend = By.xpath("//a[contains(text(),'AutoAttend')]");
	By autoReview= By.xpath("//a[contains(text(),'AutoReview')]");
	By DC = By.xpath("//a[contains(text(),'DC')]");
	By home = By.xpath("//*[@id='wrap']/main//div/ul/li[contains(.,'Home')]");
	By library = By.xpath("//span[contains(text(),'Library')]");
	//By new_Book = By.xpath("(//*[@id='wrap']/main/div[1]/div[2]/div/div[3]/div[3]/a)[1]");
	By new_Book = By.xpath("//*[@id='book-btn']/a[contains(.,'New Book')]");
	//By minutes = By.xpath("//body/div[@id='wrap']/main[1]//div//div[3]/a[contains(.,'Minutes')] ");
	By minutes = By.xpath("//body/div[@id='wrap']/main[1]//a[contains(.,'Minutes')]");
	By minutesManagerTitle = By.xpath("//div[contains(text(),'Minutes Manager')]");
	By takeMinutes = By.xpath("//body/div[@id='wrap']/main[1]//div/a[contains(.,'Take Minutes')]");
	By meetingMinutesForm = By.xpath("//form[@id='minutesPropertiesForm']");
	By takeMeetingMinutesForm = By.xpath("//div[contains(text(),'Create Meeting Minutes')]");

	//By meeting_Book_Viewer = By.xpath("//div[@class='sidebar-fixed-container']//a[@id='view_book']");
	By meeting_Book_Viewer = By.xpath("//*[@class='btn btn-default btn-sidebar secondary-action-btn left'][contains(.,'Meeting Book Viewer')]");


	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}
	
	public void verify_DC() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(DC)));
	}
	
	public void verify_Home() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(home)));
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
	
	public void verify_Minutes() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(minutes)));
	}
	
	public void verify_Minutes_Manager_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(minutesManagerTitle)));
	}
	
	public void verify_Take_Minutes() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(takeMinutes)));
	}
	
	public void verify_Minutes_Form_And_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meetingMinutesForm)));
	}
	
	public void verify_Take_Minutes_Form_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(takeMeetingMinutesForm)));
	}
	
	public void verify_Meeting_Book_Viewer() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_Viewer)));
	}
	
	public void verify_AutoAttend() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoAttend)));
	}
	
	public void verify_AutoReview() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoReview)));
	}

	public void click_AutoBE() {
		driver.findElement(autoBE).click();
	}
	
	public void click_AutoAttend() {
		driver.findElement(autoAttend).click();
	}
	
	public void click_AutoReview() {
		driver.findElement(autoReview).click();
	}
	
	public void click_DC() {
		driver.findElement(DC).click();
	}

	public void click_Library() {
		driver.findElement(library).click();
	}
	
	public void click_Minutes() {
		driver.findElement(minutes).click();
	}
	
	public void click_Take_Minutes() {
		driver.findElement(takeMinutes).click();
	}
	
	public void verify_Events_Library_Collaborate_NOT_Present() throws InterruptedException {
		String events = "//span[contains(text(),'Events')]";
		String library = "//span[contains(text(),'Library')]";
		String collaborate = "//span[contains(text(),'Collaborate')]";

		Assert.assertTrue(driver.findElements(By.xpath(events)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(library)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(collaborate)).size() < 1);
	}
	
	public void verify_Events_Library_Collaborate_ARE_Present() throws InterruptedException {
		String events = "//span[contains(text(),'Events')]";
		String library = "//span[contains(text(),'Library')]";
		String collaborate = "//span[contains(text(),'Collaborate')]";

		Assert.assertTrue(driver.findElements(By.xpath(events)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(library)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(collaborate)).size() > 0);
	}

	// -------------Function Being Called----------------------------
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
	
	public void user_Can_Open_Library_Page_For_Workroom_2() throws InterruptedException {
		//this.verify_DC();
		//this.click_DC();
		//Thread.sleep(1000);
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.workroom_Member_Open_DC_Workroom();
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_New_Book();
		System.out.println("------- Completed --> user_Can_Open_Library_Page_For_Workroom_2() -----------");
	}
	
	public void user_Can_Open_Library_Page_For_Workroom_3() throws InterruptedException {
		this.verify_AutoAttend();
		this.click_AutoAttend();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_New_Book();
		System.out.println("------- Completed --> user_Can_Open_Library_Page_For_Workroom() -----------");
	}
	
	public void user_Can_Open_Library_Page_For_Workroom_4() throws InterruptedException {
		this.verify_AutoReview();
		this.click_AutoReview();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_New_Book();
		System.out.println("------- Completed --> user_Can_Open_Library_Page_For_Workroom() -----------");
	}
	
	public void open_Library_Page_For_Board_Member() throws InterruptedException {
		//this.verify_DC();
		//this.click_DC();
		//Thread.sleep(1000);
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.workroom_Member_Open_DC_Workroom();
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_Book_Visible();
		System.out.println("------- Completed --> open_Library_Page_For_Board_Member() -----------");
	}
	
	public void verify_Disabled_Access_For_DC_Workroom() throws InterruptedException {
		//this.verify_DC();
		//this.click_DC();
		//Thread.sleep(1000);
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.workroom_Member_Open_DC_Workroom();
		this.verify_Events_Library_Collaborate_NOT_Present();
		System.out.println("------- Completed --> open_DC_Workroom_Verify_Disabled_Access() -----------");
	}
	
	public void verify_Enabled_Access_For_DC_Workroom() throws InterruptedException {
		//this.verify_DC();
		//this.click_DC();
		//Thread.sleep(1000);
		//this.verify_Home();
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.workroom_Member_Open_DC_Workroom();
		this.verify_Events_Library_Collaborate_ARE_Present();
		System.out.println("------- Completed --> verify_Enabled_Access_For_DC_Workroom() -----------");
	}
	
	public void verify_Book_Download_Btn_Not_Present() throws InterruptedException {
		String element = "//*[starts-with (@id,'card-')]//div/a[contains(.,'Download Full PDF')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void navigate_To_Minutes_Through_Workroom_Library() throws InterruptedException {
		//this.verify_AutoBE();
		//this.click_AutoBE();
		//Thread.sleep(1000);
		//this.verify_Libary();
		//this.click_Library();
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.workroom_Member_Open_Workroom_AutoBE_Library_Page();
		Thread.sleep(1000);
		this.verify_Minutes();
		this.click_Minutes();
		Thread.sleep(1000);
		System.out.println("------- Completed --> navigate_To_Minutes_Through_Workroom_Library() -----------");
	}
	
	public void navigate_To_Workroom_Library() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		System.out.println("------- Completed --> navigate_To_Workroom_Library() -----------");
	}
	
	public void switch_Verify_Minutes() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		this.verify_Minutes_Manager_Title();
		Thread.sleep(4000);
		driver.close();
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		System.out.println("------- Completed --> switch_To_Print_Events_Tab() -----------");
	}
	
	public void switch_Verify_Minutes_B() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		this.verify_Minutes_Form_And_Input_Field();
		Thread.sleep(3000);
		driver.close();
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		System.out.println("------- Completed --> switch_To_Print_Events_Tab() -----------");
	}
	
	public void switch_Verify_Minutes_C() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		this.verify_Take_Minutes_Form_Title();
		Thread.sleep(3000);
		driver.close();
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		System.out.println("------- Completed --> switch_To_Print_Events_Tab() -----------");
	}
	
	public void switch_To_Minutes_Manager_Page() throws InterruptedException, AWTException {
		this.switch_Verify_Minutes();
		System.out.println("------- Completed --> switch_Tab_Verify_Minutes_Page() -----------");
	}
	
	public void open_Book_Navigate_To_Take_Minutes() throws InterruptedException {
		this.verify_Book_Visible();
		this.click_Book_Title();
		Thread.sleep(1000);
		this.verify_Take_Minutes();
		this.click_Take_Minutes();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Book_Navigate_To_Take_Minutes() -----------");
	}
	
	public void verify_Take_Minutes_Disabled() throws InterruptedException {
		String element = "//body/div[@id='wrap']/main[1]//div/a[5][contains(.,'Take Minutes')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void open_Book_Verify_Take_Minutes_Not_Present() throws InterruptedException {
		this.verify_Book_Visible();
		this.click_Book_Title();
		Thread.sleep(1000);
		this.verify_Meeting_Book_Viewer();
		this.verify_Take_Minutes_Disabled();
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Book_Navigate_To_Take_Minutes() -----------");
	}
	
	public void open_Handbook_Navigate_To_Take_Minutes() throws InterruptedException {
		this.click_Handbook_Title();
		Thread.sleep(1000);
		this.verify_Take_Minutes();
		this.click_Take_Minutes();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Book_Navigate_To_Take_Minutes() -----------");
	}
	
	public void switch_To_Minutes_Manager_Page_B() throws InterruptedException, AWTException {
		this.switch_Verify_Minutes_B();
		System.out.println("------- Completed --> switch_Tab_Verify_Minutes_Page() -----------");
	}
	
	public void switch_To_Minutes_Manager_Page_C() throws InterruptedException, AWTException {
		this.switch_Verify_Minutes_C();
		System.out.println("------- Completed --> switch_Tab_Verify_Minutes_Page() -----------");
	}
	
	// ----------user_Can_Create_New_Book_And_Title-----------------------
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
		driver.findElement(title_Form_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(title_Form_Field).clear();
		driver.findElement(title_Form_Field).sendKeys(book_title);
		Thread.sleep(1000);
	}

	// -------------Function Being Called-----------------------------
	public void user_Can_Create_Book_And_Add_Title() throws InterruptedException {
		this.click_New_Book();
		this.verify_Title_Input_Field();
		this.enter_Book_Title();
		System.out.println("------- Completed --> user_Can_Create_New_Book_And_Add_Title() -----------");
	}
	
	public void user_Can_Create_Book_And_Add_Title_2() throws InterruptedException {
		this.verify_Title_Input_Field();
		this.enter_Book_Title();
		System.out.println("------- Completed --> user_Can_Create_New_Book_And_Add_Title() -----------");
	}
	
	// -------------user_Can_Add_Cover_Page-----------------------------
	// -------------user_Add_Coverpage_To_Book_Template---------------------
	// -------------generate coverpage------
	By header_1 = By.xpath("//input[@id='book_cover_h1']");
	By header_2 = By.xpath("//input[@id='book_cover_h2']");
	By date = By.xpath("//input[@id='book_cover_date']");
	By line_1 = By.xpath("//input[@id='book_cover_line1']");
	By line_2 = By.xpath("//input[@id='book_cover_line2']");
	By line_3 = By.xpath("//input[@id='book_cover_line3']");
	By line_4 = By.xpath("//input[@id='book_cover_line4']");
	By line_5 = By.xpath("//input[@id='book_cover_line5']");
	By generate_Cover_Page = By.xpath("//span[contains(text(),'Generate Cover Page')]");

	public void fill_Generate_Cover_Page_Form() throws InterruptedException {
		String Header_1 = "This is Header 1";
		String Header_2 = "This is Header 2";
		String Line_1 = "This is Line 1";
		String Line_2 = "This is Line 2";
		String Line_3 = "This is Line 3";
		String Line_4 = "This is Line 4";
		String Line_5 = "This is Line 5";
		// ------coverpage form input fields--------
		driver.findElement(header_1).sendKeys(Header_1);
		driver.findElement(header_2).sendKeys(Header_2);
		// ------- date input field ------------------
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate = new Date();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Date CurrentDate = c1.getTime();
		;
		String todayDate = (dateFormat.format(CurrentDate));
		System.out.println(todayDate);
		driver.findElement(date).click();
		driver.findElement(date).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(date).clear();
		driver.findElement(date).sendKeys(todayDate);
		driver.findElement(line_1).sendKeys(Line_1);
		driver.findElement(line_2).sendKeys(Line_2);
		driver.findElement(line_3).sendKeys(Line_3);
		driver.findElement(line_4).sendKeys(Line_4);
		driver.findElement(line_5).sendKeys(Line_5);
		driver.findElement(generate_Cover_Page).click();
		WebElement save = driver.findElement(By.xpath("//*[@id=\"new_book\"]/div[3]/div[3]/p/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		Thread.sleep(2000);
	}

	// ------------Function Being Called------------------------------
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		this.fill_Generate_Cover_Page_Form();
		System.out.println("------- Completed --> user_Can_Add_Cover_Page() -----------");
	}
	
	// -------------user_Can_Add_Agenda--------------------------------
	By agenda_Title = By.xpath("//input[@id='agenda_title']");
	By generate_Agenda = By.xpath("//span[contains(text(),'Generate Agenda')]");

	public void enter_Agenda_Title() throws InterruptedException {
		String agenda_title = "This is an Agenda";
		driver.findElement(agenda_Title).sendKeys(agenda_title);
		Thread.sleep(1000);
		driver.findElement(generate_Agenda).click();
		Thread.sleep(1000);
	}

	// -------------Function Being Called--------------------------------
	public void user_Can_Add_Agenda() throws InterruptedException {
		this.enter_Agenda_Title();
		System.out.println("------- Completed --> user_Can_Add_Agenda() -----------");
	}
	
	// ------------user_Can_Save_Book_And_Continue------------------------
	By Save_Continue_Btn = By.xpath("//*[@id='new_book']/div[3]/div[3]/p/button");

	public void click_Save_Continue_Btn() throws InterruptedException {
		driver.findElement(Save_Continue_Btn).click();
		Thread.sleep(1000);
	}

	// --------------Function Being Called-------------------------------
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		this.click_Save_Continue_Btn();
		System.out.println("------- Completed --> user_Can_Save_Book_And_Continue() -----------");
	}
	
	
	public void user_Can_Create_Book_And_Add_Title_B() throws InterruptedException {
		this.click_New_Book();
		Thread.sleep(1000);
		this.verify_Title_Input_Field();
		this.enter_Book_Title();
		this.user_Can_Add_Cover_Page();
		System.out.println("------- Completed --> user_Can_Create_Book_And_Add_Title_B() -----------");
	}
	
	public void user_Can_Add_Agenda_B() throws InterruptedException {
		this.user_Can_Add_Agenda();
		this.user_Can_Save_Book_And_Continue();
		System.out.println("------- Completed --> user_Can_Add_Agenda_B() -----------");
	}

	// ------------------user_Add_First_Catagory_To_Book_----------
	By main_Catagory_1 = By.xpath("//div[@class='category-accordion ui-sortable']//a[1][contains(text(),'Add Main Category')]");
	By catagory_Name_Field = By.xpath("//input[@id='bookfolder_title']");
	By time_Field = By.xpath("//input[@id='bookfolder_time']");
	By presenter_Field = By.xpath("//input[@id='bookfolder_presenter']");
	By action_Field = By.xpath("//input[@id='bookfolder_action']");
	By additional_Notes_Field = By.xpath("//textarea[@id='bookfolder_notes']");
	By catagory_SaveBtn = By.xpath("//div[@class='modal-dialog']//button[@id='formsSubmit']");
	By new_Catagory = By.xpath("//a[contains(text(),'New Catagory')]");

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
	
	public void verify_Main_Catagory_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(main_Catagory_1)));
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
		driver.findElement(action_Field).sendKeys(Action);
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
		System.out.println("------- Completed --> user_Add_First_Catagory_To_Book_Template -----------");
	}
	
	// ------------------user_Add_File_To_First_Catagory------------------
	By click_For_More_Options = By.xpath("//a[contains(text(),'click for more options')]");
	By title_Field = By.xpath("//input[@id='bookfolder_title']");
	By file_SaveBtn = By.xpath("//div[@id='newBookFileModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By file_Upload_Success_Message = By.xpath("//div//p[contains(text(),'The following files were uploaded:')]");
	
	By file_Category_Error = By.xpath("//*[starts-with (@id,'node_')]/div[@class='book-box-fix category-error']");
	By file_Error_Triangle = By.xpath("//*[starts-with (@id,'node_')]/div/h3/span[@class='file-error']");
	By libraries_Tab = By.xpath("//a[contains(text(),'Libraries')]");
	By link_Tab = By.xpath("//a[contains(text(),'Link')]");
	By link_Address_Input = By.xpath("//input[@id='bookfolder_vfiles_other_content']");


	//By rl_Attach_Folder = By.xpath("//*[@id='resources']//div/ul[@class='plain-list']/li[contains(.,'Attach')]");
	By rl_Attach_Folder = By.xpath("(//*[@id='resources']//div/ul[@class='plain-list']/li/a/i[@class='fa fa-folder'])[1]");
	By toAttach = By.xpath("//*[contains(text(),'ToAttach')]");
	By rl_file_Added = By.xpath("//*[@id='resources']/p/span[contains(.,'ToAttach ')]");

	public void verify_Click_For_More_Options() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options)));
	}

	public void verify_Title_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Field)));
	}

	public void verify_File_Upload_Success_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(400))// ---wait 5 minutes for message
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Upload_Success_Message)));
	}
	
	public void verify_File_Category_Error() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(400))// ---wait 5 minutes for message
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(file_Category_Error)));
	}
	
	public void verify_File_Error_Triangle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(400))// ---wait 5 minutes for message
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(file_Error_Triangle)));
	}
	
	public void verify_RL_Attach_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(400))// ---wait 5 minutes for message
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(rl_Attach_Folder)));
	}

	public void verify_File_ToAttach() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(toAttach)));
	}
	
	public void verify_RL_File_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(rl_file_Added)));
	}
	
	public void verify_Link_Address_Input() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(link_Address_Input)));
	}
	
	
	public void click_Click_For_More_Options() throws InterruptedException {
		driver.findElement(click_For_More_Options).click();
		Thread.sleep(1000);
	}

	public void title_Field_SendKeys() throws InterruptedException {
		String file_title = "Large Book";
		driver.findElement(title_Field).sendKeys(file_title);
		Thread.sleep(1000);
	}
	
	public void title_Field_SendKeys_2() throws InterruptedException {
		String file_title = "Library Files";
		driver.findElement(title_Field).sendKeys(file_title);
		Thread.sleep(1000);
	}
	
	public void title_Field_SendKeys_3() throws InterruptedException {
		String file_title = "Web Link";
		driver.findElement(title_Field).sendKeys(file_title);
		Thread.sleep(1000);
	}

	public void add_First_Cat_File_1() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void add_First_Cat_File_2() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_Bad_File_1() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\badfile.pdf";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void file_Save_Btn() throws InterruptedException {
		driver.findElement(file_SaveBtn).click();
		Thread.sleep(1000);
	}
	
	public void click_Libraries_Tab() throws InterruptedException {
		driver.findElement(libraries_Tab).click();
	}
	
	public void click_RL_Attach_Folder() throws InterruptedException {
		driver.findElement(rl_Attach_Folder).click();
	}
	
	public void click_To_Attach() throws InterruptedException {
		driver.findElement(toAttach).click();
	}
	
	public void click_Link_Tab() throws InterruptedException {
		driver.findElement(link_Tab).click();
	}
	
	public void sendKeys_Link_Address() throws InterruptedException {
		String url = "https://www.startrek.com/";
		driver.findElement(link_Address_Input).sendKeys(url);
	}
	
	public void scroll_Click_Web_Link() throws InterruptedException {
		String link = "//a[contains(text(),'Web Link')]";
		WebElement weblink = driver.findElement(By.xpath(link));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", weblink);
		Thread.sleep(1500);
		driver.findElement(By.xpath(link)).click();
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_File_1_To_First_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		this.verify_Title_Field();
		this.title_Field_SendKeys();
		this.add_First_Cat_File_1();
		this.file_Save_Btn();
		// ---wait 5 minutes for message
		this.verify_File_Upload_Success_Message();
		Thread.sleep(1000);
		this.verify_Build_Book();
		System.out.println("------- Completed --> user_Add_Large_File_To_First_Catagory()  -----------");
	}

	public void add_Bad_File_Verify_Error_Message() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		this.verify_Title_Field();
		this.title_Field_SendKeys();
		this.add_Bad_File_1();
		this.file_Save_Btn();
		Thread.sleep(1500);
		// ---wait 5 minutes for message
		this.verify_File_Category_Error();
		this.verify_File_Error_Triangle();
		System.out.println("------- Completed --> add_Bad_File()  -----------");
	}
	
	public void user_Add_Library_File() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		this.verify_Title_Field();
		this.title_Field_SendKeys_2();
		this.click_Libraries_Tab();
		Thread.sleep(2000);
		this.verify_RL_Attach_Folder();
		this.click_RL_Attach_Folder();
		Thread.sleep(1000);
		this.verify_File_ToAttach();
		this.click_To_Attach();
		Thread.sleep(1000);
		this.verify_RL_File_Added();
		this.file_Save_Btn();
		Thread.sleep(2000);
		this.verify_Build_Book();
		System.out.println("------- Completed --> user_Add_Library_File_And_Link()  -----------");
	}
	
	public void user_Add_Web_Link() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		this.verify_Title_Field();
		this.title_Field_SendKeys_3();
		this.click_Link_Tab();
		Thread.sleep(1000);
		this.verify_Link_Address_Input();
		this.sendKeys_Link_Address();
		Thread.sleep(1000);
		this.file_Save_Btn();
		Thread.sleep(2000);
		this.verify_Build_Book();
		System.out.println("------- Completed --> user_Add_Web_Link()  -----------");
	}
	
	public void scroll_And_Click_Link() throws InterruptedException {
		this.click_Book_Title();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		this.scroll_Click_Web_Link();
		System.out.println("------- Completed --> scroll_And_Click_Link()  -----------");
	}
	
	// ------------------Function Being called-----------------------------------
	public void user_Add_Large_File_2_To_First_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		this.verify_Title_Field();
		this.title_Field_SendKeys();
		this.add_First_Cat_File_2();
		this.file_Save_Btn();
		// ---wait 5 minutes for message
		this.verify_File_Upload_Success_Message();
		System.out.println("------- Completed --> user_Add_Large_File_2_To_First_Catagory()  -----------");
	}
	
	//-----edit book file title -----
	By book_Title_3_Drp_Dwn = By.xpath("(//h3//a[normalize-space(text())='This is a Book Title 3']/following::button[@class='btn btn-default dropdown-toggle'])[1]");
	By file_Title_Drp_Dwn = By.xpath("(//a[@class ='attached-doc'][contains(text(),'the file Title')]/following::button[@class='btn dropdown-toggle'])[1]");
	//---- for work flow test case lowercase t for title
	By file_Title_Drp_Dwn_2 = By.xpath("(//a[@class ='attached-doc'][contains(text(),'the file title')]/following::button[@class='btn dropdown-toggle'])[1]");
	By file_Title_Drp_Dwn_Two = By.xpath("(//a[@class ='attached-doc'][contains(text(),'the file title')]/following::button[@class='btn dropdown-toggle'])[2]");
	By file_Title_Drp_Dwn_Three = By.xpath("(//a[@class ='attached-doc'][contains(text(),'the file title')]/following::button[@class='btn dropdown-toggle'])[3]");

	By rename_Edit_Option = By.xpath("//a[@class ='attached-doc']/following::a[contains(text(),'Rename / Edit Note')]");
	By rename_Edit_Option_2 = By.xpath("(//a[@class ='attached-doc']/following::a[contains(text(),'Rename / Edit Note')])[2]");
	By rename_Edit_Option_3 = By.xpath("(//a[@class ='attached-doc']/following::a[contains(text(),'Rename / Edit Note')])[2]");

	By edited_File_Title_Drp_Dwn = By.xpath("(//a[@class ='attached-doc'][contains(text(),'edited file Title')]/following::button[@class='btn dropdown-toggle'])[1]");
	By built_File_Title = By.xpath("//a[contains(text(),'the file Title')]");
	By edit_Option_B3 = By.xpath("//h3//a[normalize-space(text())='This is a Book Title 3']/following::ul[@class='dropdown-menu']//a[contains(text(),'Edit')]");
	By add_Approval_Workflow = By.xpath("//a[@class ='attached-doc']/following::a[contains(text(),'Add Approval Workflow')]");
	By workflow_Modal = By.xpath("//body/div[@id='workflowModal']//div[@class='modal-content']");
	By workflow_Show_Modal = By.xpath("//body/div[@id='workflowShowModal']//div[@class='modal-content']");

	By unordered_Approval = By.xpath("(//h5[contains(text(),'Create Unordered Approval Tree')]/following::a[contains(.,'Choose')])[1]");
	By ordered_Approval = By.xpath("(//h5[contains(text(),'Create Ordered Approval Tree')]/following::a[contains(.,'Choose')])[1]");
	By view_Edit_Approval_Workflow = By.xpath("//a[@class ='attached-doc']/following::a[contains(text(),'View/Edit Approval Workflow')]");
	By view_Edit_Approval_Workflow_2 = By.xpath("(//a[@class ='attached-doc']/following::a[contains(text(),'View/Edit Approval Workflow')])[2]");
	By view_Edit_Approval_Workflow_3 = By.xpath("(//a[@class ='attached-doc']/following::a[contains(text(),'View/Edit Approval Workflow')])[3]");
	
	By select_From_Template = By.xpath("(//h5[contains(text(),'Select from Template')]/following::a[contains(.,'Choose')])[1]");
	By select_From_Template_Drp_Dwn = By.xpath("//span[contains(text(),'Select a Template')]");
	By tempate_PDF = By.xpath("//span[contains(text(),'template_pdf_wa_ad')]");
	By workroomAdmin_In_Template = By.xpath("//*[@class='person-name'][contains(.,'Workroom Admin')]");

	By save_AAW_Btn = By.xpath("//*[@id='manage-guest-list']//button[@class='btn btn-done pull-right']");
	By save_WFB = By.xpath("//*[@id='manage-guest-list']//div/button");
	By scanned_Book_Visible = By.xpath("//a[contains(text(),'This is a Scanned Book')]");

	
	public void verify_Scanned_Book_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(scanned_Book_Visible)));
	}
	
	public void verify_Book_Title_3_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title_3_Drp_Dwn)));
	}
	
	public void verify_File_Title_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Title_Drp_Dwn)));
	}
	
	public void verify_File_Title_Drp_Dwn_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Title_Drp_Dwn_2)));
		
		String element = "(//a[@class ='attached-doc'][contains(text(),'the file title')]/following::button[@class='btn dropdown-toggle'])[1]";
		WebElement fileTitle = driver.findElement(By.xpath(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fileTitle);
	}
	
	public void verify_Rename_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(rename_Edit_Option)));
	}
	
	public void verify_Add_Approval_Workflow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(add_Approval_Workflow)));
	}
	
	public void verify_Edited_File_Title_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_File_Title_Drp_Dwn)));
	}
	
	public void verify_Orginal_File_Title_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Title_Drp_Dwn)));
	}
	
	public void verify_Built_File_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(built_File_Title)));
	}
	
	public void verify_Edit_Option_B3() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Option_B3)));
	}
	
	public void verify_Workflow_Modal() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workflow_Modal)));
	}
	
	public void verify_Workflow_Show_Modal() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workflow_Show_Modal)));
	}
	

	public void verify_Select_From_Template_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(select_From_Template_Drp_Dwn)));
	}
	
	public void verify_WorkroomAdmin_In_Template() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workroomAdmin_In_Template)));
	}
	
	public void verify_Save_WFB() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(save_WFB)));
	}
	
	public void click_Edit_Option_B3() throws InterruptedException {
		driver.findElement(edit_Option_B3).click();
	}
	
	public void click_Book_Title_3_Drp_Dwn() throws InterruptedException {
		String str ="(//h3//a[normalize-space(text())='This is a Book Title 3']/following::button[@class='btn btn-default dropdown-toggle'])[1]";
		WebElement element = driver.findElement(By.xpath(str));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		driver.findElement(book_Title_3_Drp_Dwn).click();
	}
	
	public void click_File_Title_Drp_Dwn() throws InterruptedException {
		driver.findElement(file_Title_Drp_Dwn).click();
	}
	
	public void click_File_Title_Drp_Dwn_2() throws InterruptedException {
		driver.findElement(file_Title_Drp_Dwn_2).click();
	}
	
	//--------------
	public void click_File_Title_Drp_Dwn_Two() throws InterruptedException {
		driver.findElement(file_Title_Drp_Dwn_Two).click();
	}
	
	public void click_File_Title_Drp_Dwn_Three() throws InterruptedException {
		driver.findElement(file_Title_Drp_Dwn_Three).click();
	}
	//-----------------
	
	public void click_Edited_File_Title_Drp_Dwn() throws InterruptedException {
		driver.findElement(edited_File_Title_Drp_Dwn).click();
	}
	
	public void click_Add_Approval_Workflow() throws InterruptedException {
		driver.findElement(add_Approval_Workflow).click();
	}
	
	public void click_Unordered_Approval_Workflow() throws InterruptedException {
		driver.findElement(unordered_Approval).click();
	}
	
	public void click_Ordered_Approval_Workflow() throws InterruptedException {
		driver.findElement(ordered_Approval).click();
	}
	
	//-------------------------
	public void click_Select_From_Template() throws InterruptedException {
		driver.findElement(select_From_Template).click();
	}
	
	public void click_Select_From_Template_Dropdown() throws InterruptedException {
		driver.findElement(select_From_Template_Drp_Dwn).click();
	}
	
	public void click_Template_PDF() throws InterruptedException {
		driver.findElement(tempate_PDF).click();
	}
	
	public void click_Save_AAW_Btn() throws InterruptedException {
		driver.findElement(save_AAW_Btn).click();
	}
	
	public void click_Save_WFB_Btn() throws InterruptedException {
		driver.findElement(save_WFB).click();
	}
	
	//-------------------------
	
	public void click_View_Edit_Approval_Workflow() throws InterruptedException {
		driver.findElement(view_Edit_Approval_Workflow).click();
	}
	
	public void click_View_Edit_Approval_Workflow_2() throws InterruptedException {
		driver.findElement(view_Edit_Approval_Workflow_2).click();
	}
	
	public void click_View_Edit_Approval_Workflow_3() throws InterruptedException {
		driver.findElement(view_Edit_Approval_Workflow_3).click();
	}
	
	public void edit_File_Name() throws InterruptedException {
		String edited_File_title = "edited file Title";
		driver.findElement(title_Field).clear();
		driver.findElement(title_Field).sendKeys(edited_File_title);
		Thread.sleep(1000);
	}
	
	public void orginal_File_Name() throws InterruptedException {
		String orginal_File_Title = "the file Title";
		driver.findElement(title_Field).clear();
		driver.findElement(title_Field).sendKeys(orginal_File_Title);
		Thread.sleep(1000);
	}
	
	public void click_Rename_Edit_Option() throws InterruptedException {
		driver.findElement(rename_Edit_Option).click();
	}
	
	public void click_Scanned_Book_Title() throws InterruptedException {
		driver.findElement(scanned_Book_Visible).click();
	}
	
	public void verify_Workroom_Admin_File_Approved() throws InterruptedException {
		String element = "//td[contains(text(),'Workroom Admin')]/following::span[contains(text(),'Approved')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Workroom_Admin_File_Denied() throws InterruptedException {
		String element = "//td[contains(text(),'Workroom Admin')]/following::span[contains(text(),'Denied')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void navigate_To_File_In_Book() throws InterruptedException {
		this.verify_Book_Title_3_Drp_Dwn();
		this.click_Book_Title_3_Drp_Dwn();
		Thread.sleep(1000);
		this.verify_Edit_Option_B3();
		this.click_Edit_Option_B3();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		this.verify_Build_Book();
		System.out.println("------- Completed --> navigate_To_File_In_Book()  -----------");
	}
	
	public void navigate_To_File_In_Book_2() throws InterruptedException {
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		this.verify_Build_Book();
		System.out.println("------- Completed --> navigate_To_File_In_Book_2()  -----------");
	}
	
	public void edit_File_In_Book() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn();
		this.click_File_Title_Drp_Dwn();
		Thread.sleep(1000);
		this.verify_Rename_Edit_Option();
		this.click_Rename_Edit_Option();
		Thread.sleep(1000);
		this.verify_Title_Field();
		this.edit_File_Name();
		this.click_Catagory_SaveBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_File_In_Book()  -----------");
	}
	
	public void edit_File_Back_To_Orginal_Name() throws InterruptedException {
		this.verify_Edited_File_Title_Drp_Dwn();
		this.click_Edited_File_Title_Drp_Dwn();
		Thread.sleep(1000);
		this.verify_Rename_Edit_Option();
		this.click_Rename_Edit_Option();
		Thread.sleep(1000);
		this.verify_Title_Field();
		this.orginal_File_Name();
		this.click_Catagory_SaveBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_File_Back_To_Orginal_Name()  -----------");
	}
	
	//---------add workflow to file -------------------------
	public void add_Unordered_Workflow_To_Meeting_Book_File() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_2();
		Thread.sleep(1000);
		this.verify_Rename_Edit_Option();
		this.click_Add_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Workflow_Modal();
		this.click_Unordered_Approval_Workflow();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_Unordered_Workflow_To_Meeting_Book_File_Part_One()  -----------");
	}
	
	//AddUnorderedWorkflowUsingExistingTemplate
	public void add_Unordered_Workflow_Using_Existing_Template() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_2();
		Thread.sleep(1000);
		this.verify_Rename_Edit_Option();
		this.click_Add_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Workflow_Modal();
		this.click_Select_From_Template();
		Thread.sleep(1000);
		this.verify_Select_From_Template_Drp_Dwn();
		this.click_Select_From_Template_Dropdown();
		Thread.sleep(1000);
		this.click_Template_PDF();
		Thread.sleep(1000);
		this.verify_WorkroomAdmin_In_Template();
		this.click_Save_AAW_Btn();
		Thread.sleep(1000);
		this.verify_Save_WFB();
		this.click_Save_WFB_Btn();
		System.out.println("------- Completed --> add_Unordered_Workflow_Using_Existing_Template()  -----------");
	}
	
	public void add_Unordered_Workflow_To_Meeting_Book_File_2() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_Two();
		Thread.sleep(1000);
		this.verify_Add_Approval_Workflow();
		this.click_Add_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Workflow_Modal();
		this.click_Unordered_Approval_Workflow();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_Unordered_Workflow_To_Meeting_Book_File_2()  -----------");
	}
	
	public void add_Unordered_Workflow_To_Meeting_Book_File_3() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_Three();
		Thread.sleep(1000);
		this.verify_Add_Approval_Workflow();
		this.click_Add_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Workflow_Modal();
		this.click_Unordered_Approval_Workflow();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_Unordered_Workflow_To_Meeting_Book_File_3()  -----------");
	}
	
	public void add_Ordered_Workflow_To_Meeting_Book_File_Part_One() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_2();
		Thread.sleep(1000);
		this.verify_Rename_Edit_Option();
		this.click_Add_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Workflow_Modal();
		this.click_Ordered_Approval_Workflow();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_Ordered_Workflow_To_Meeting_Book_File_Part_One()  -----------");
	}
	
	//-----------verify all responses received
	
	public void verify_Approval_Response_File_One_Received() throws InterruptedException {
		this.click_Scanned_Book_Title();
		Thread.sleep(1000);
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_2();
		Thread.sleep(1500);
		//this.verify_Add_Approval_Workflow();
		this.click_View_Edit_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Workflow_Show_Modal();
		this.verify_Workroom_Admin_File_Approved();
		Thread.sleep(500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Response_File_One_Received()  -----------");
	}
	
	public void verify_Deny_Response_File_Two_Received() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_Two();
		Thread.sleep(1500);
		//this.verify_Add_Approval_Workflow();
		this.click_View_Edit_Approval_Workflow_2();
		Thread.sleep(1000);
		this.verify_Workflow_Show_Modal();
		this.verify_Workroom_Admin_File_Denied();
		Thread.sleep(500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Deny_Response_File_Two_Received()  -----------");
	}
	
	public void verify_Approval_Response_File_Three_Received() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_Three();
		Thread.sleep(1500);
		//this.verify_Add_Approval_Workflow();
		this.click_View_Edit_Approval_Workflow_3();
		Thread.sleep(1000);
		this.verify_Workflow_Show_Modal();
		this.verify_Workroom_Admin_File_Approved();
		Thread.sleep(500);
		driver.navigate().refresh();
		this.verify_File_Title_Drp_Dwn_2();
		System.out.println("------- Completed --> verify_Approval_Response_File_Three_Received()  -----------");
	}
	
	//----------------------
	By wf_Current_Date = By.xpath("//input[@id='workflow_due_date']");
	By wf_Reminder_Date = By.xpath("//input[@id='workflow_reminder_date']");
	By save_WFB_2 = By.xpath("//a[contains(text(),'Back')]/following::button");
	By wadmin_Pending_Status = By.xpath("//td[contains(text(),'Workroom Admin')]/following::td[contains(.,'Pending')]");
	By autoDirector_Pending_Status = By.xpath("//td[contains(text(),'Auto Director')]/following::td[contains(.,'Pending')]");
	By wadmin_Approved_Status = By.xpath("(//td[contains(text(),'Workroom Admin')]/following::td[contains(.,'Approved')])[1]");
	By autoUserAdmin1_Pending_Status = By.xpath("//td[contains(text(),'Auto User Admin1')]/following::td[contains(.,'Pending')]");


	By approval_WF_Dropdown = By.xpath("//*[@id='workflowShowModal']//div/h5[@class='modal-title']/div[@class='btn-group small']");
	By finalize_Responses = By.xpath("//*[@id='workflowShowModal']//h5//li/a[contains(.,'Finalize Responses')]");
	By message_Approvers = By.xpath("//*[@id='workflowShowModal']//h5//li/a[contains(.,'Message Approvers')]");
	By force_Approval = By.xpath("//*[@id='workflowShowModal']//h5//li/a[contains(.,'Force Approval')]");
	By remove_Workflow = By.xpath("//*[@id='workflowShowModal']//h5//li/a[contains(.,'Remove Workflow')]");

	By send_A_Message = By.xpath("//div[@class='modal-dialog modal-md']//h1[@class='modal-title'][contains(text(),'Send A Message')]");
	By send_Button = By.xpath("//button[@id='user_message_submit']");
	By message_Sucessfull = By.xpath("//p[contains(text(),'This message was sent to the following recipients:')]");

	By response_Pending_1 = By.xpath("(//span[contains(text(),'Responses Pending')])[1]");
	By response_Pending_2 = By.xpath("(//span[contains(text(),'Responses Pending')])[2]");
	By response_Pending_3 = By.xpath("(//span[contains(text(),'Responses Pending')])[3]");
	By comment_Tab = By.xpath("//a[contains(text(),'Comments')]");
	By comment_Input_Box = By.xpath("//textarea[@id='comment_body']");
	By post = By.xpath("//*[@id='new_comment']//div/div/input");
	By posted_Comment = By.xpath("//p[contains(text(),'This is a System Admin Comment')]");
	


	// using refreshed
	public void verify_WF_Current_Date() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(wf_Current_Date)));
	}
	
	public void verify_Wadmin_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(wadmin_Pending_Status)));
	}
	
	public void verify_AutoDirector_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoDirector_Pending_Status)));
	}
	
	public void verify_AutoUserAdmin1_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUserAdmin1_Pending_Status)));
	}
	
	public void verify_Wadmin_Approved_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(wadmin_Approved_Status)));
	}
	
	public void verify_Approval_WF_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(approval_WF_Dropdown)));
	}
	
	public void verify_Finalize_Responses() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(finalize_Responses)));
	}
	
	public void verify_Message_Approvers() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(message_Approvers)));
	}
	
	public void verify_Response_Pending_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(response_Pending_1)));
	}
	
	public void verify_Response_Pending_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(response_Pending_2)));
	}
	
	public void verify_Response_Pending_3() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(response_Pending_3)));
	}
	
	public void verify_Comment_Input_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(comment_Input_Box)));
	}
	
	public void verify_Posted_Comment() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(posted_Comment)));
	}
	
	public void verify_Send_A_Message_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(send_A_Message)));
	}
	
	public void verify_Send_Button() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(send_Button)));
	}
	
	public void verify_Message_Sucessfull() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(message_Sucessfull)));
	}
	
	
	
	public void click_Save_WFB_2() throws InterruptedException {
		driver.findElement(save_WFB_2).click();
	}
	
	public void click_Approval_WF_Dropdown() throws InterruptedException {
		driver.findElement(approval_WF_Dropdown).click();
	}
	
	public void click_Finalize_Responses() throws InterruptedException {
		driver.findElement(finalize_Responses).click();
	}
	
	public void click_Message_Approvers() throws InterruptedException {
		driver.findElement(message_Approvers).click();
	}
	
	public void click_Force_Approval() throws InterruptedException {
		driver.findElement(force_Approval).click();
	}
	
	public void click_Remove_Workflow() throws InterruptedException {
		driver.findElement(remove_Workflow).click();
	}
	
	public void click_Comment_Tab() throws InterruptedException {
		driver.findElement(comment_Tab).click();
	}
	
	public void Send_Keys_Comment_Input_Box() throws InterruptedException {
		driver.findElement(comment_Input_Box).sendKeys("This is a System Admin Comment");
	}
	
	public void click_Post() throws InterruptedException {
		driver.findElement(post).click();
	}
	
	public void click_Send_Message_Btn() throws InterruptedException {
		driver.findElement(send_Button).click();
	}
	
	public void verify_Admin_Non_Admin_Responses() throws InterruptedException {
		String noneAdmin = "//*[contains(text(),'This is a Non Admin Comment')]";
		String sysAdmin = "//*[contains(text(),'This is a System Admin Comment')]";

		Assert.assertTrue(driver.findElements(By.xpath(noneAdmin)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(sysAdmin)).size() > 0);
	}
	
	public void workflow_Status_Window_Check() throws InterruptedException {
		String pending = "//*[@class='small-top plain-list']//li[contains(.,'Pending')]/span[contains(.,'1')]";
		String finalized = "//*[@class='small-top plain-list']//li[contains(.,'Finalized')]/span[contains(.,'1')]";

		Assert.assertTrue(driver.findElements(By.xpath(pending)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(finalized)).size() > 0);
	}
	
	public void workflow_Calendar_Date() throws InterruptedException {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		c2.add(Calendar.DATE, 2); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		Date CurrentDate = c1.getTime();
		
		String strDateOne = (dateFormat.format(CurrentDate));
		Date currentDatePlusTwo = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTwo));
		System.out.println(dateFormat.format(CurrentDate));
		System.out.println(strDateOne);
		System.out.println(dateFormat.format(currentDatePlusTwo));
		System.out.println(strDateTwo);
		driver.findElement(wf_Current_Date).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(wf_Current_Date).clear();
		driver.findElement(wf_Current_Date).sendKeys(strDateOne);
		Thread.sleep(1000);
		driver.findElement(wf_Reminder_Date).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(wf_Reminder_Date).clear();
		driver.findElement(wf_Reminder_Date).sendKeys(strDateTwo);
	}
	
	public void verify_Workflow_Complete() throws InterruptedException {
		String element = "//span[contains(text(),'Workflow Complete')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void add_Workflow_Dates() throws InterruptedException {
		this.verify_WF_Current_Date();
		this.workflow_Calendar_Date();
		Thread.sleep(1000);
		this.click_Save_WFB_2();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_Workflow_Dates()  -----------");
	}
	
	public void verify_Workflow_Created() throws InterruptedException {
		this.verify_Wadmin_Pending_Status();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created()  -----------");
	}
	
	public void verify_Workflow_Created_2() throws InterruptedException {
		this.verify_AutoDirector_Pending_Status();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created_2()  -----------");
	}
	
	public void verify_Workflow_Created_3() throws InterruptedException {
		this.verify_AutoUserAdmin1_Pending_Status();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created_2()  -----------");
	}
	
	public void message_Workflow_Approvers() throws InterruptedException {
		this.verify_Wadmin_Pending_Status();
		this.verify_Approval_WF_Dropdown();
		this.click_Approval_WF_Dropdown();
		Thread.sleep(1000);
		this.verify_Message_Approvers();
		this.click_Message_Approvers();
		Thread.sleep(1000);
		this.verify_Send_A_Message_Box();
		this.verify_Send_Button();
		this.click_Send_Message_Btn();
		this.verify_Message_Sucessfull();
		Thread.sleep(1500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> message_Workflow_Approvers()  -----------");
	}
	
	public void sysAdmin_Comment_Verify_Workflow_Created() throws InterruptedException {
		this.verify_Wadmin_Pending_Status();
		Thread.sleep(1000);
		this.click_Comment_Tab();
		Thread.sleep(1000);
		this.verify_Comment_Input_Box();
		this.Send_Keys_Comment_Input_Box();
		this.click_Post();
		Thread.sleep(1000);
		this.verify_Posted_Comment();
		driver.navigate().refresh();
		System.out.println("------- Completed --> sysAdmin_Comment_Verify_Workflow_Created()  -----------");
	}
	
	public void force_Workflow_Approvals() throws InterruptedException {
		this.verify_Wadmin_Pending_Status();
		this.verify_Approval_WF_Dropdown();
		this.click_Approval_WF_Dropdown();
		Thread.sleep(1000);
		this.verify_Message_Approvers();
		this.click_Force_Approval();
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		this.verify_Wadmin_Approved_Status();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> force_Workflow_Approvals()  -----------");
	}
	
	public void force_Workflow_Approvals_B() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_2();
		Thread.sleep(1000);
		this.verify_Rename_Edit_Option();
		this.click_View_Edit_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Approval_WF_Dropdown();
		this.click_Approval_WF_Dropdown();
		Thread.sleep(1000);
		this.verify_Message_Approvers();
		this.click_Force_Approval();
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		this.verify_Wadmin_Approved_Status();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> force_Workflow_Approvals_B()  -----------");
	}
	
	public void finalize_Workflow_Response() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_2();
		Thread.sleep(1000);
		this.verify_Rename_Edit_Option();
		this.click_View_Edit_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Approval_WF_Dropdown();
		this.click_Approval_WF_Dropdown();
		Thread.sleep(1000);
		this.verify_Finalize_Responses();
		this.click_Finalize_Responses();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		this.verify_Invisibility_Of_Continue_Btn();
		driver.navigate().refresh();
		this.verify_Workflow_Complete();
		System.out.println("------- Completed --> finalize_Workflow_Response()  -----------");
	}
	
	
	//-------------
	By view_Workflows = By.xpath("//a[contains(text(),'View Workflows')]");
	By pending_Tab = By.xpath("//a[contains(text(),'Pending')]");
	By pending_Tab_Right_Arrow = By.xpath("//div[@class='active tab-pane small-top smallest-left']//i[@class='fa fa-chevron-right']");
	By back_Arrow = By.xpath("//a[contains(text(),'< Back to Workflow List')]");
	By finalized_Tab = By.xpath("//a[contains(text(),'Finalized')]");
	By finalized_Tab_Right_Arrow = By.xpath("//div[@class='tab-pane small-top smallest-left active']//i[@class='fa fa-chevron-right']");


	
	public void verify_Pending_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(pending_Tab_Right_Arrow)));
	}
	
	public void verify_Pending_Tab_Right_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(pending_Tab)));
	}
	
	public void verify_Finalized_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(finalized_Tab)));
	}
	
	public void verify_Finalized_Tab_Right_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(finalized_Tab_Right_Arrow)));
	}
	
	
	public void verify_Three_Workflow_Responses() throws InterruptedException {
		String one = "//span[contains(text(),'Workflow Complete')]";
		String two = "//span[contains(text(),'Responses Pending')]";
		String three = "//span[contains(text(),'Responses Received')]";

		Assert.assertTrue(driver.findElements(By.xpath(one)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(two)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(three)).size() > 0);
	}
	
	public void click_View_Workflows() throws InterruptedException {
		driver.findElement(view_Workflows).click();
	}
	
	public void click_Pending_Tab_Right_Arrow() throws InterruptedException {
		driver.findElement(pending_Tab_Right_Arrow).click();
	}
	
	public void click_back_Arrow() throws InterruptedException {
		driver.findElement(back_Arrow).click();
	}
	
	public void click_Finalized_Tab() throws InterruptedException {
		driver.findElement(finalized_Tab).click();
	}
	
	public void click_Finalized_Tab_Right_Arrow() throws InterruptedException {
		driver.findElement(finalized_Tab_Right_Arrow).click();
	}
	
	public void verify_Pending_AutoDirector_And_Finalized_WorkroomAdmin() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.workflow_Status_Window_Check();
		this.click_View_Workflows();
		Thread.sleep(1000);
		this.verify_Pending_Tab();
		this.click_Pending_Tab_Right_Arrow();
		Thread.sleep(1000);
		this.verify_AutoDirector_Pending_Status();
		this.click_back_Arrow();
		Thread.sleep(1000);
		
		this.verify_Finalized_Tab();
		this.click_Finalized_Tab();
		Thread.sleep(1000);
		this.verify_Finalized_Tab_Right_Arrow();
		this.click_Finalized_Tab_Right_Arrow();
		this.verify_Wadmin_Approved_Status();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Pending_AutoDirector_And_Finalized_WorkroomAdmin()  -----------");
	}
	
	public void verify_All_Three_Response_Types() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.verify_Three_Workflow_Responses();
		System.out.println("------- Completed --> verify_All_Three_Response_Types()  -----------");
	}
	
	public void Verify_Comment_And_finalize_Workflow_Response() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_2();
		Thread.sleep(1000);
		this.verify_Rename_Edit_Option();
		this.click_View_Edit_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Approval_WF_Dropdown();
		//----------------
		this.click_Comment_Tab();
		Thread.sleep(1000);
		this.verify_Comment_Input_Box();
		this.verify_Admin_Non_Admin_Responses();
		//----------------
		this.click_Approval_WF_Dropdown();
		Thread.sleep(1000);
		this.verify_Finalize_Responses();
		this.click_Finalize_Responses();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		this.verify_Invisibility_Of_Continue_Btn();
		driver.navigate().refresh();
		this.verify_Workflow_Complete();
		System.out.println("------- Completed --> Verify_Comment_And_finalize_Workflow_Response()  -----------");
	}
	
	public void delete_Workflow() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.click_File_Title_Drp_Dwn_2();
		Thread.sleep(1000);
		this.verify_Rename_Edit_Option();
		this.click_View_Edit_Approval_Workflow();
		Thread.sleep(1000);
		this.verify_Approval_WF_Dropdown();
		this.click_Approval_WF_Dropdown();
		Thread.sleep(1000);
		this.verify_Message_Approvers();
		this.click_Remove_Workflow();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		this.verify_Invisibility_Of_Continue_Btn();
		driver.navigate().refresh();
		System.out.println("------- Completed --> force_Workflow_Approvals()  -----------");
	}
	
		
	
	// ----------------------------build_Book()---------------------------------------
	By build_Handbook = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Build Book')]");
	By build_DoneBtn = By.xpath("//button[contains(text(),'Done')]");

	public void verify_Build_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(build_Handbook)));
	}

	public void verify_Build_DoneBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
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

	// --------------Function Being Called--------------------
	public void user_Can_Build_Book() throws InterruptedException {
		this.verify_Build_Book();// --- wait 7 minutes for build book to show up
		this.scroll_Up_To_Build_Book();
		this.click_Build_Book();
		Thread.sleep(1000);
		this.verify_Build_DoneBtn(); // --- wait 10 minutes for build book to show up
		this.click_Build_DoneBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Build_Book()  -----------");
	}
	
	public void user_Can_Build_Book_2() throws InterruptedException {
		this.click_Build_Book();
		Thread.sleep(1000);
		this.verify_Build_DoneBtn(); // --- wait 10 minutes for build book to show up
		this.click_Build_DoneBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Build_Book_2()  -----------");
	}
	
	// ------------------make_Book_Visible--------------
	By edit_BookBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Book')]");
	By onswitch = By.xpath("//label[@class='onoffswitch-label']");
	By workroom_Library_Crumb = By.xpath("//a[contains(text(),'Workroom Library')]");
	By book_Title = By.xpath("//a[contains(text(),'This is a Book Title')]");
	
	public void verify_Edit_BookBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_BookBtn)));
	}

	public void verify_Book_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title)));
	}

	public void verify_Workroom_Library_Crumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Library_Crumb)));
	}

	public void click_On_Switch() throws InterruptedException {
		driver.findElement(onswitch).click();
		Thread.sleep(1000);
	}

	public void click_Workroom_Library_Crumb() throws InterruptedException {
		driver.findElement(workroom_Library_Crumb).click();
		Thread.sleep(1000);
	}
	
	public void click_Book_Title() throws InterruptedException {
		driver.findElement(book_Title).click();
	}
	
	// --------------Function Being Called-----------------------
	public void make_Book_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		Thread.sleep(1000);
		this.click_Workroom_Library_Crumb();
		this.verify_Book_Visible();
		System.out.println("------- Completed --> make_Book_Visible()  -----------");
	}
	
	public void make_Book_Visible_2() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		Thread.sleep(1000);
		System.out.println("------- Completed --> make_Book_Visible()  -----------");
	}
	
	// ------------------ Functions ----------------------
	public void user_navigates_To_Book() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_Book_Visible();
		System.out.println("------- Completed --> user_navigates_To_Book() -----------");
	}
	
	// --------------copied/achived/delete_Book-------------------------------
	By book_Dropdown = By.xpath("//a[contains(text(),'This is a Book Title')]/following::div[@class='dropdown header-actions']");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By form = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");
	By archive = By.xpath("//a[contains(.,'Archive')]");
	By archives = By.xpath("//a[@class='btn btn-default'][contains(.,'Archives')]");
	By copy_Option = By.xpath("//li[3]//a[1][contains(text(),'Copy')]");
	By copy_Message = By.xpath("//p[contains(text(),'Successfully created This is a Book Title - Copy')]");
	By copied_Meeting_Book = By.xpath("//a[contains(text(),'This is a Book Title - Copy')]");
	
	public void verify_Copy_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(copy_Option)));
	}
	
	public void verify_Copied_Archived_Meeting_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(copied_Meeting_Book)));
	}
	
	public void verify_Book_Copy_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(copy_Message)));
	}
	
	public void verify_Archive_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(archive)));
	}
	
	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void verify_Form() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(form)));
	}
	
	public void verify_Archives() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(archives)));
	}
	
	public void verify_Book_Drop_Down() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(book_Dropdown)));
	}

	public void click_Book_Dropdown() throws InterruptedException {
		driver.findElement(book_Dropdown).click();
	}
	
	public void click_Edited_Book_Dropdown() throws InterruptedException {
		driver.findElement(edited_Book).click();
	}


	public void click_Delete_Option() throws InterruptedException {
		driver.findElement(delete_Option).click();
	}
	
	public void click_Copy_Option() throws InterruptedException {
		driver.findElement(copy_Option).click();
	}
	
	public void click_Archive_Option() throws InterruptedException {
		driver.findElement(archive).click();
	}
	
	public void click_Archives_Btn() throws InterruptedException {
		driver.findElement(archives).click();
	}

	public void click_And_SendKeys() throws InterruptedException {
		driver.findElement(form).sendKeys("delete");
	}

	public void click_ContinueBtn() throws InterruptedException {
		driver.findElement(continueBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void delete_Book() throws InterruptedException {
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1500);
		this.click_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> delete_Book()  -----------");
	}
	
	public void delete_Book_2() throws InterruptedException {
		this.click_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		driver.navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Book()  -----------");
	}

	// --------------Function Being Called ---------------------------
	public void archive_Meeting_Book() throws InterruptedException {
		this.click_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Archive_Option();
		this.click_Archive_Option();
		Thread.sleep(1500);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1500);
		this.verify_Book_Visible();
		System.out.println("------- Completed --> archive_Meeting_Book()  -----------");
	}
	
	
	public void restore_Meeting_Book() throws InterruptedException {
		this.click_Book_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Restore_Option();
		Thread.sleep(1500);
		this.verify_Book_Drop_Down();
		System.out.println("------- Completed --> restore_Meeting_Book()  -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void copy_Archived_Meeting_Book() throws InterruptedException {
		this.click_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Copy_Option();
		this.click_Copy_Option();
		Thread.sleep(1500);
		this.verify_Book_Copy_Message();
		Thread.sleep(2000);
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> copy_Archived_Meeting_Book()  -----------");
	}
	
	public void copy_Meeting_Book() throws InterruptedException {
		this.click_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Copy_Option();
		this.click_Copy_Option();
		Thread.sleep(1500);
		this.verify_Book_Copy_Message();
		Thread.sleep(2000);
		//this.click_On_Switch();
		//Thread.sleep(1500);
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		this.verify_Book_Visible();
		System.out.println("------- Completed --> copy_Meeting_Book()  -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Copied_Archived_Meeting_Book_Created() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Book_Visible();
		this.verify_Copied_Archived_Meeting_Book();
		System.out.println("------- Completed --> verify_Copied_Archived_Meeting_Book_Created()  -----------");
	}
	
	public void delete_Archived_Meeting_Book() throws InterruptedException {
		this.click_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> delete_Archived_Meeting_Book()  -----------");
	}
	
	public void delete_Edited_Meeting_Book() throws InterruptedException {
		this.click_Edited_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> delete_Edited_Meeting_Book()  -----------");
	}
	
	public void delete_Copied_Archived_Meeting_Book() throws InterruptedException {
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1500);
		this.click_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> delete_Copied_Archived_Meeting_Book()  -----------");
	}
	
	public void delete_Extra_Books() throws InterruptedException {
		Thread.sleep(2500);

		for (int i = 1; i > 0; i++) {
			  
			By bookDropDown = By.xpath("//*[@class='btn btn-default dropdown-toggle']");
			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Boolean book = driver.findElements(bookDropDown).size() > 0;
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			System.out.println("answer -> "+book);

			
			if (book == true) {
				driver.findElement(bookDropDown).click();
				Thread.sleep(1500);
				this.verify_Delete_Option();
				this.click_Delete_Option();
				Thread.sleep(1500);
				this.verify_Form();
				this.click_And_SendKeys();
				Thread.sleep(1500);
				this.click_ContinueBtn();
				Thread.sleep(2500);
				driver.navigate().refresh();
				this.verify_New_Book();
			}else {
				break;
			}
			
		}
		
		System.out.println("------- Completed --> delete_Extra_Books()  -----------");
	}
	
	
	public void clean_Up_Meeting_Books() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.workroom_Member_Open_Workroom_AutoBE_Library_Page();
		this.verify_New_Book();
		this.delete_Extra_Books();
		driver.navigate().refresh();
		System.out.println("------- Completed --> clean_Up_Meeting_Books()  -----------");
	}


	// --------------verify_Book_Deleted -----------------------------
	public void verify_Book_Not_Present() throws InterruptedException {
		String element = "//a[contains(text(),'This is a Book Title')]/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Book_Not_Present_By_Value() throws InterruptedException {
		String element = "//h3//a[normalize-space(text())='This is a Book Title']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Edited_Book_Not_Present() throws InterruptedException {
		String element = "//a[contains(text(),'This is an Edited Book')]/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	// --------------Function Being Called ---------------------------
	public void verify_Book_Deleted() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_Book_Not_Present();
		System.out.println("------- Completed --> verify_Book_Deleted()  -----------");
	}
	
	public void verify_Book_Deleted_2() throws InterruptedException {
		Thread.sleep(2000);
		this.verify_Book_Not_Present();
		System.out.println("------- Completed --> verify_Book_Deleted_2()  -----------");
	}
	
	public void verify_Edited_Book_Deleted() throws InterruptedException {
		Thread.sleep(1500);
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_Edited_Book_Not_Present();
		System.out.println("------- Completed --> verify_Edited_Book_Deleted()  -----------");
	}
	
	// -------------------- user_Create_New_BookTemplate() ---------------------
	By book_Templates = By.xpath("//a[contains(text(),'Book Templates')]");
	By new_Template = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Template')]");

	public void verify_Book_Templates() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Templates)));
	}

	public void verify_New_Template() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Template)));
	}

	public void click_Book_Templates() {
		driver.findElement(book_Templates).click();
	}

	public void click_New_Templates() {
		driver.findElement(new_Template).click();
	}

	public void enter_Book_Template_Title() throws InterruptedException {
		String book_title = "This is a Book Template Title";
		driver.findElement(title_Form_Field).sendKeys(book_title);
		Thread.sleep(1000);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Create_New_BookTemplate() throws InterruptedException {
		this.verify_Book_Templates();
		this.click_Book_Templates();
		this.verify_New_Template();
		this.click_New_Templates();
		this.verify_Title_Input_Field();
		this.enter_Book_Template_Title();
		System.out.println("------- Completed --> user_Create_New_BookTemplate() -----------");
	}
	
	public void navigate_To_BookTemplate() throws InterruptedException {
		//this.verify_AutoBE();
		//this.click_AutoBE();
		//Thread.sleep(1000);
		//this.verify_Libary();
		//this.click_Library();
		//Thread.sleep(1000);
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.workroom_Member_Open_Workroom_AutoBE_Library_Page();
		this.verify_Book_Templates();
		this.click_Book_Templates();
		Thread.sleep(1500);
		this.verify_New_Template();;
		System.out.println("------- Completed --> navigate_To_BookTemplate() -----------");
	}
	
	public void navigate_Back_To_BookTemplate() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_Book_Templates();
		this.click_Book_Templates();
		Thread.sleep(1500);
		this.verify_New_Template();;
		System.out.println("------- Completed --> navigate_To_BookTemplate() -----------");
	}
	
	//------------------------------
	By meetingBook = By.xpath("//a[contains(text(),'Meeting Books')]");
	By newBook = By.xpath("//a[@class='btn btn-success no-mobile'][contains(text(),'New Book')]");
	By diligent_Minutes = By.xpath("//a[contains(text(),'Diligent Minutes')]");
	By diligent_Minutes_Container = By.xpath("//div[@id='diligent-minutes']");

	//div[@id='diligent-minutes']
	
	public void verify_MeetingBook() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meetingBook)));
	}

	public void verify_NewBook() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newBook)));
	}
	
	public void verify_Diligent_Minutes_Container() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(diligent_Minutes_Container)));
	}
	
	public void click_Meeting_Book() throws InterruptedException {
		driver.findElement(meetingBook).click();
		System.out.println("------- Completed --> click_Meeting_Book() -----------");
	}
	
	public void navigate_To_Meeting_Book() throws InterruptedException {
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		this.verify_MeetingBook();
		this.click_Meeting_Book();
		Thread.sleep(1000);
		this.verify_NewBook();
		System.out.println("------- Completed --> navigate_To_Meeting_Book() -----------");
	}
	
	public void navigate_To_Meeting_Book_2() throws InterruptedException {
		this.verify_MeetingBook();
		this.click_Meeting_Book();
		Thread.sleep(1000);
		this.verify_NewBook();
		System.out.println("------- Completed --> navigate_To_Meeting_Book_2() -----------");
	}
	
	public void navigate_To_Meeting_Book_3() throws InterruptedException {
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		this.verify_Book_Visible();
		System.out.println("------- Completed --> navigate_To_Meeting_Book_3() -----------");
	}

	
	// ------------------user_Add_Coverpage_To_Book_Template---------------------
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		this.fill_Generate_Cover_Page_Form();
		System.out.println("------- Completed --> user_Add_Coverpage_To_Book_Template() -----------");
	}
	
	// ------------------user_Add_Agenda_To_Template---------------------
	public void verify_Agenda_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(agenda_Title)));
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		this.verify_Agenda_Title();
		this.enter_Agenda_Title();
		System.out.println("------- Completed --> user_Add_Agenda_To_Template() -----------");
	}
	
	
	// ------------------Function Being called-----------------------------------
	public void user_Save_Book_Template() throws InterruptedException {
		this.click_Save_Continue_Btn();
		System.out.println("------- Completed --> user_Save_Book_Template -----------");
	}
	
	// ------------------user_Add_First_Catagory_To_Book_Template-----------------------------------
	
	// ------------------Function Being called-----------------------------------
	public void user_Add_First_Catagory_To_Book_Template() throws InterruptedException {
		this.click_Main_Catagory_1();
		this.verify_Catagory_Name_Field();
		this.fill_Catagory_Form();
		this.click_Catagory_SaveBtn();
		this.verify_New_Catagory_Name();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Add_First_Catagory_To_Book_Template -----------");
	}
	
	// ------------------user_Add_File_To_First_Catagory------------------
	public void add_First_Cat_File() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void click_Diligent_Minutes() throws InterruptedException {
		driver.findElement(diligent_Minutes).click();
	}
	
	public void admin_CheckBox_Click_Import() throws InterruptedException {
		String admin_CheckBox = "div > article > div > div.table-body > div:nth-child(2) > div:nth-child(1) > dil-checkbox > div > input";
		String import_Btn = "div > footer > div > dil-button:nth-child(3) > button";

		//---click admin check box
		WebElement attachedElement = driver.findElement(By.tagName("import-minutes"));
		WebElement shadowRoot1 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", attachedElement);
		WebElement checkBox = shadowRoot1.findElement(By.cssSelector(admin_CheckBox));
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", checkBox);
		Thread.sleep(2000);

		//---click import button
		WebElement shadowRoot2 = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", attachedElement);
		WebElement import_ = shadowRoot2.findElement(By.cssSelector(import_Btn));

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", import_);
		
	}
	
	// ------------------user_Add_File_To_First_Catagory------------------
	public void add_First_Cat_PDF_File() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		this.verify_Title_Field();
		this.title_Field_SendKeys();
		this.add_First_Cat_File();
		this.file_Save_Btn();
		this.verify_File_Upload_Success_Message();
		System.out.println("------- Completed --> user_Add_File_To_First_Catagory()  -----------");
	}
	
	public void user_Add_Meeting_Minutes_To_First_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		Thread.sleep(1000);
		this.click_Diligent_Minutes();
		Thread.sleep(1000);
		this.verify_Diligent_Minutes_Container();
		this.admin_CheckBox_Click_Import();
		Thread.sleep(2000);
		System.out.println("------- Completed --> user_Add_Meeting_Minutes_To_First_Catagory()  -----------");
	}
	
	// ------------------Function Being called-----------------------------------
	public void user_Add_PDF_To_First_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		this.verify_Title_Field();
		this.title_Field_SendKeys();
		this.add_First_Cat_PDF_File();
		this.file_Save_Btn();
		this.verify_File_Upload_Success_Message();
		System.out.println("------- Completed --> user_Add_PDF_To_First_Catagory()  -----------");
	}
	
	// ------------------open_Book_From_Templates_Page-----------------------------------
	By Book_Template_Crumb = By.xpath("//a[contains(text(),'Book Templates')]");
	By template_Title = By.xpath("//a[contains(text(),'This is a Book Template Title')]");

	public void verify_Template_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(template_Title)));
	}
	
	public void verify_Book_Template_Crumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(Book_Template_Crumb)));
	}

	// ------------------Function Being called-----------------------------------
	public void open_Book_From_Templates_Page() throws InterruptedException {
		this.click_Book_Template_Crumb();
		this.verify_Template_Title();
		System.out.println("------- Completed --> open_Book_From_Templates_Page()  -----------");
	}
	
	// ------------------ edit_Book_Template -------------------------------------
	By template_Dropdown = By.xpath("//div[@class='dropdown header-actions']");
	By edit_Option = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Edit')]");
	By expand_Cover_Page = By.xpath("(//span[contains(text(),'Generate Cover Page')]/following::a[@class='collapse-selection fl-right'])[1]");
	By preview_Left = By.xpath("//a[@id='cover_preview']//span[@class='icon icon_mb_thumbnail1 meeting-book-thumbnail']");
	By edit_SaveBtn = By.xpath("//button[@class='primary-action-btn']");
	By edited_Handbook_Visible = By.xpath("//*[contains(text(),'This is an Edited Handbook')]");
	By coverpage_CheckBox = By.xpath("//span[contains(text(),'Generate Cover Page')]");
	By agenda_CheckBox = By.xpath("//span[contains(text(),'Generate Agenda')]");
	By edited_Template_Title = By.xpath("//a[contains(text(),'This is an Edited Book Template Title')]");

	public void verify_Edited_Book_Template() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Template_Title)));
	}

	public void verify_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Option)));
	}

	public void click_Template_Dropdown() throws InterruptedException {
		driver.findElement(template_Dropdown).click();
	}

	public void click_Edit_Option() throws InterruptedException {
		driver.findElement(edit_Option).click();
		Thread.sleep(1000);
	}

	public void edited_Template_Title_SendKeys() throws InterruptedException {
		String handbook_title = "This is an Edited Book Template Title";
		driver.findElement(title_Form_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(title_Form_Field).clear();
		driver.findElement(title_Form_Field).sendKeys(handbook_title);
		Thread.sleep(1000);
	}

	public void click_Coverpage_Expand() throws InterruptedException {
		driver.findElement(expand_Cover_Page).click();
		Thread.sleep(1000);
	}

	public void edit_Generate_Cover_Page_Form() throws InterruptedException {
		String Header_1 = "This is Edited Header 1";
		String Header_2 = "This is Edited Header 2";
		String Line_1 = "This is Edited Line 1";
		String Line_2 = "This is Edited Line 2";
		String Line_3 = "This is Edited Line 3";
		String Line_4 = "This is Edited Line 4";
		String Line_5 = "This is Edited Line 5";
		// ------coverpage form input fields--------
		driver.findElement(header_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(header_1).clear();
		driver.findElement(header_1).sendKeys(Header_1);
		driver.findElement(header_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(header_2).clear();
		driver.findElement(header_2).sendKeys(Header_2);
		driver.findElement(line_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_1).clear();
		driver.findElement(line_1).sendKeys(Line_1);
		driver.findElement(line_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_2).clear();
		driver.findElement(line_2).sendKeys(Line_2);
		driver.findElement(line_3).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_3).clear();
		driver.findElement(line_3).sendKeys(Line_3);
		driver.findElement(line_4).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_4).clear();
		driver.findElement(line_4).sendKeys(Line_4);
		driver.findElement(line_5).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_5).clear();
		driver.findElement(line_5).sendKeys(Line_5);
	}
	
	public void edit_Generate_Cover_Page_Form_2() throws InterruptedException {
		String Header_1 = "Header One";
		String Header_2 = "Header Two";
		String Line_1 = "Line 1";
		String Line_2 = "Line 2";
		String Line_3 = "Line 3";
		String Line_4 = "Line 4";
		String Line_5 = "Line 5";
		// ------coverpage form input fields--------
		driver.findElement(header_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(header_1).clear();
		driver.findElement(header_1).sendKeys(Header_1);
		driver.findElement(header_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(header_2).clear();
		driver.findElement(header_2).sendKeys(Header_2);
		driver.findElement(line_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_1).clear();
		driver.findElement(line_1).sendKeys(Line_1);
		driver.findElement(line_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_2).clear();
		driver.findElement(line_2).sendKeys(Line_2);
		driver.findElement(line_3).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_3).clear();
		driver.findElement(line_3).sendKeys(Line_3);
		driver.findElement(line_4).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_4).clear();
		driver.findElement(line_4).sendKeys(Line_4);
		driver.findElement(line_5).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(line_5).clear();
		driver.findElement(line_5).sendKeys(Line_5);
	}

	public void click_Preview_Left() throws InterruptedException {
		driver.findElement(preview_Left).click();
		Thread.sleep(1000);
	}

	public void scroll_To_SaveBtn() throws InterruptedException {
		WebElement save = driver.findElement(By.xpath("//button[@class='primary-action-btn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
	}

	public void click_Coverpage_CheckBox() throws InterruptedException {
		driver.findElement(coverpage_CheckBox).click();
		Thread.sleep(1000);
	}

	public void click_Agenda_CheckBox() throws InterruptedException {
		driver.findElement(agenda_CheckBox).click();
		Thread.sleep(1000);
	}

	public void click_SaveBtn() throws InterruptedException {
		driver.findElement(edit_SaveBtn).click();
	}
	
	// ------------------ Function Being called- -----------------------------------
	public void edit_Book_Template() throws InterruptedException {
		this.click_Template_Dropdown();
		this.verify_Edit_Option();
		this.click_Edit_Option();
		this.verify_Title_Input_Field();
		this.edited_Template_Title_SendKeys();
		this.click_Coverpage_Expand();
		Thread.sleep(3000);
		this.edit_Generate_Cover_Page_Form();
		Thread.sleep(1000);
		this.click_Preview_Left();// ---click this to make save btn appear
		this.click_Coverpage_CheckBox();
		this.click_Agenda_CheckBox();
		this.scroll_To_SaveBtn();
		this.click_SaveBtn();
		this.click_Book_Template_Crumb();
		// this.verify_Template_Title();
		this.verify_Edited_Book_Template();
		System.out.println("------- Completed --> edit_Book_Template()  -----------");
	}
	
	// ------------------ move_Book_Tempate_To_New_Workroom -------------------------------------
	
	By move_To_Drpdwn = By.xpath("//button[@class='btn dropdown-toggle btn-default']");
	By auto_Attend = By.xpath("//span[contains(text(),'AutoAttend')]");
	By move_Here = By.xpath("//button[@class='btn btn-sidebar move-btn btn-success']");
	By Auto_Attend_Breadcrumb = By.xpath("//div[@id='wrap']//main//div/ol/li/a[contains(text(),'AutoAttend')]");

	public void verify_Move_To_Drpdwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_To_Drpdwn)));
	}
	
	public void verify_Auto_Attend() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Attend)));
	}
	
	public void verify_Auto_Attend_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(Auto_Attend_Breadcrumb)));
	}
	
	public void verify_Move_Here() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_Here)));
	}
	
	public void verify_Continue_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}
	
	public void verify_Invisibility_Of_Continue_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(continueBtn)));
	}
	
	public void verify_Workroom_Template_Move() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(Auto_Attend_Breadcrumb)));
	}

	public void click_Book_Template_Title() throws InterruptedException {
		driver.findElement(template_Title).click();
	}
	
	public void click_Move_To_Drpdwn() throws InterruptedException {
		driver.findElement(move_To_Drpdwn).click();
	}
	
	public void click_Auto_Attend() throws InterruptedException {
		driver.findElement(auto_Attend).click();
	}
	
	public void click_Move_Here() throws InterruptedException {
		driver.findElement(move_Here).click();
	}
	
	public void click_Book_Template_Crumb() throws InterruptedException {
		driver.findElement(Book_Template_Crumb).click();
	}
	
	// ------------------ Function Being called- -----------------------------------
	public void move_Book_Tempate_To_New_Workroom() throws InterruptedException {
		this.click_Book_Template_Title();
		Thread.sleep(1000);
		this.verify_Move_To_Drpdwn();
		this.click_Move_To_Drpdwn();
		Thread.sleep(1000);
		this.verify_Auto_Attend();
		this.click_Auto_Attend();
		Thread.sleep(1000);
		this.verify_Move_Here();
		this.click_Move_Here();
		this.verify_Continue_Btn();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> move_Book_Tempate_To_New_Workroom()  -----------");
	}
	
	// ------------------ Function Being called- -----------------------------------
	public void verify_Workroom_Move() throws InterruptedException {
		this.verify_Workroom_Template_Move();
		this.click_Book_Template_Crumb();
		Thread.sleep(1000);
		this.verify_Template_Title();
		System.out.println("------- Completed --> verify_Workroom_Move()  -----------");
	}
	
	// ------------------ Advanced Settings Share_Book_Tempate_All_Workrooms -----------------------------------
	By adv_Settings = By.xpath("//span[contains(text(),'Advanced Settings')]");
	By all_Workrooms = By.xpath("//label[contains(text(),'All Workrooms')]");
	By box_Adv_Settings = By.xpath("//input[@id='book_global_template']");
	By saveBtn_AS = By.xpath("//div[@id='advanced_settings']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By save_Continue_Btn = By.xpath("//button[@id='save-and-continue-book']");
	By logo_Label = By.xpath("//*[@id='advanced_settings']//div//label[contains(.,'Logo')]");
	By view_Only = By.xpath("//label[contains(text(),'View Only')]");
	By contributor_Email_Field = By.xpath("//input[@id='book_collaborator_notify_email']");
	By watermark = By.xpath("//input[@id='book_collaborator_notify_email']");


	public void verify_Adv_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(adv_Settings)));
	}
	
	public void verify_All_Workrooms_And_Scroll() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(all_Workrooms)));
		
		WebElement adv_Settings = driver.findElement(By.xpath("//label[contains(text(),'All Workrooms')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", adv_Settings);
	}
	
	public void verify_Save_Continue_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(save_Continue_Btn)));
	}
	
	public void verify_Save_Continue_Btn_NOT_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(save_Continue_Btn)));
	}
	
	public void verify_Logo_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(logo_Label)));
	}
	
	public void verify_View_Only_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(view_Only)));
	}

	public void verify_Contributor_Email_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(contributor_Email_Field)));
	}
	
	public void enter_Conributor_Email() throws InterruptedException {
		String email = "jhofler@diligent.com";
		driver.findElement(contributor_Email_Field).sendKeys(email);
	}
	
	public void click_View_Only() throws InterruptedException {
		String viewOnly = "//input[@id='book_disable_print']";
		WebElement viewonly = driver.findElement(By.xpath(viewOnly));
		
		if(!viewonly.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", viewonly);
		}	
	}
//---------------------------------------------------------------	
	
	public void click_Watermark() throws InterruptedException {
		String element = "//input[@id='book_watermark']";
		WebElement watermark = driver.findElement(By.xpath(element));
		
		if(!watermark.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", watermark);
		}	
	}

	public void verify_Watermark_Checked() throws InterruptedException {
		String element = "//input[@id='book_watermark']";
		WebElement watermark = driver.findElement(By.xpath(element));
		
		Assert.assertEquals(watermark.isSelected(),true);
	}
	
//---------------------------------------------------------------	
	
	public void click_Preserve_Bookmarks() throws InterruptedException {
		String element = "//input[@id='book_preserve_bookmarks']";
		WebElement bookmark = driver.findElement(By.xpath(element));
		
		if(!bookmark.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", bookmark);
		}	
	}
	
	public void verify_Preserve_Bookmarks_Checked() throws InterruptedException {
		String element = "//input[@id='book_preserve_bookmarks']";
		WebElement bookmark = driver.findElement(By.xpath(element));
		
		Assert.assertEquals(bookmark.isSelected(),true);
	}
	
//-----------------------------------------------------------------
	
	public void click_Include_Orginal_Bookmarks() throws InterruptedException {
		String element = "//input[@id='book_show_original']";
		WebElement bookmark = driver.findElement(By.xpath(element));
		
		if(!bookmark.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", bookmark);
		}	
	}
	
	public void verify_Include_Orginal_Files_Enabled() throws InterruptedException {
		String element = "//input[@id='book_show_original']";
		WebElement bookmark = driver.findElement(By.xpath(element));
		
		Assert.assertEquals(bookmark.isSelected(),true);
	}
	
//---------------------------------------------------------------
	
	public void click_Adv_Settings() throws InterruptedException {
		driver.findElement(adv_Settings).click();
	}
	
	public void click_Box_Adv_Settings() throws InterruptedException {
		driver.findElement(box_Adv_Settings).click();
	}
	
	public void click_SaveBtn_AS() throws InterruptedException {
		driver.findElement(saveBtn_AS).click();
	}
	
	public void click_Save_Contnue_Btn() throws InterruptedException {
		driver.findElement(save_Continue_Btn).click();
	}
	
	public void click_Autto_Attend_2() throws InterruptedException {
		driver.findElement(Auto_Attend_Breadcrumb).click();
	}
	
	public void verify_Book_Template_Shared_AutoBE() throws InterruptedException {
		String template = "//div[@class='no-mobile pull-right'][contains(text(),'Shared from AutoBE ')]";
		Assert.assertTrue(driver.findElements(By.xpath(template)).size() > 0);
	}
	
	
	public void scroll_To_Logo() throws InterruptedException {
		WebElement save = driver.findElement(By.xpath("//*[@id='advanced_settings']//div//label[contains(.,'Logo')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
	}
	
	public void add_BT_Logo_Image() {
		String input = "//input[@id='book_print_logo']";
		String filepath = "C:\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void verify_BT_Logo_Image_Present() throws InterruptedException {
		String sisco = "//*[@id='advanced_settings']//img";
		Assert.assertTrue(driver.findElements(By.xpath(sisco)).size() > 0);
	}
	
	// ------------------ Function Being called- -----------------------------------
	public void share_Book_Tempate_All_Workrooms() throws InterruptedException {
		this.click_Book_Template_Title();
		Thread.sleep(1000);
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_All_Workrooms_And_Scroll();
		Thread.sleep(1000);
		this.click_Box_Adv_Settings();
		Thread.sleep(500);
		this.click_SaveBtn_AS();
		Thread.sleep(2000);
		this.verify_Save_Continue_Btn();
		this.click_Save_Contnue_Btn();
		Thread.sleep(3000);
		System.out.println("------- Completed --> share_Book_Tempate_All_Workrooms()  -----------");
	}
	
	public void set_Book_To_View_Only() throws InterruptedException {
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_View_Only_Option();
		this.click_View_Only();
		Thread.sleep(1000);
		this.click_SaveBtn_AS();
		Thread.sleep(2000);
		this.verify_Save_Continue_Btn();
		this.click_Save_Contnue_Btn();
		Thread.sleep(3000);
		System.out.println("------- Completed --> share_Book_Tempate_All_Workrooms()  -----------");
	}
	
	public void set_Contributor_Notification_Email() throws InterruptedException {
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Contributor_Email_Field();
		this.enter_Conributor_Email();
		Thread.sleep(1000);
		this.click_SaveBtn_AS();
		Thread.sleep(2000);
		this.verify_Save_Continue_Btn();
		this.click_Save_Contnue_Btn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> set_Contributor_Notification_Email()  -----------");
	}
	
	public void enable_Watermark_For_Book() throws InterruptedException {
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Contributor_Email_Field();
		this.click_Watermark(); // water mark click
		Thread.sleep(1000);
		this.click_SaveBtn_AS();
		Thread.sleep(2000);
		this.verify_Save_Continue_Btn();
		this.click_Save_Contnue_Btn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> enable_Watermark_For_Book()  -----------");
	}
	
	public void verify_Watermark_Enabled() throws InterruptedException {
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Contributor_Email_Field();
		this.verify_Watermark_Checked(); // water mark enabled
		Thread.sleep(1000);
		this.click_SaveBtn_AS();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Watermark_Enabled()  -----------");
	}
	
	public void enable_Preserve_Bookmarks_For_Book() throws InterruptedException {
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Contributor_Email_Field();
		this.click_Preserve_Bookmarks(); // water mark click
		Thread.sleep(1000);
		this.click_SaveBtn_AS();
		Thread.sleep(2000);
		this.verify_Save_Continue_Btn();
		this.click_Save_Contnue_Btn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> enable_Preserve_Bookmarks_For_Book()  -----------");
	}
	
	public void verify_Preserve_Bookmarks_Enabled() throws InterruptedException {
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Contributor_Email_Field();
		this.verify_Preserve_Bookmarks_Checked(); // water mark enabled
		Thread.sleep(1000);
		this.click_SaveBtn_AS();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Preserve_Bookmarks_Enabled()  -----------");
	}
	
	public void enable_Include_Orginal_Files_For_Book() throws InterruptedException {
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Contributor_Email_Field();
		this.click_Include_Orginal_Bookmarks(); // water mark click
		Thread.sleep(1000);
		this.click_SaveBtn_AS();
		Thread.sleep(2000);
		this.verify_Save_Continue_Btn();
		this.click_Save_Contnue_Btn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> enable_Include_Orginal_Files_For_Book()  -----------");
	}
	
	public void verify_Include_Orginal_Files_Checked() throws InterruptedException {
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Contributor_Email_Field();
		this.verify_Include_Orginal_Files_Enabled(); // water mark enabled
		Thread.sleep(1000);
		this.click_SaveBtn_AS();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Include_Orginal_Files_Enabled()  -----------");
	}
	
	//-----------------------------
	public void add_Logo_To_Book_Template() throws InterruptedException {
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Logo_Label();
		this.scroll_To_Logo();
		this.add_BT_Logo_Image();
		this.click_SaveBtn_AS();
		Thread.sleep(1500);
		this.verify_Save_Continue_Btn();
		this.click_Save_Contnue_Btn();
		Thread.sleep(1500);
		this.verify_Save_Continue_Btn_NOT_Visible();
		System.out.println("------- Completed --> user_Add_PDF_To_First_Catagory()  -----------");
	}
	
	public void verify_Logo_To_Book_Template_Added() throws InterruptedException {
		driver.navigate().refresh();
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Logo_Label();
		this.scroll_To_Logo();
		Thread.sleep(1000);
		this.verify_BT_Logo_Image_Present();
		driver.navigate().refresh();
		this.verify_Book_Template_Crumb();
		this.click_Book_Template_Crumb();
		System.out.println("------- Completed --> verify_Logo_To_Book_Template_Added()  -----------");
	}
	
	
	// ------------------ Function Being called- -----------------------------------
	public void verify_Book_Template_Shared() throws InterruptedException {
		//this.verify_AutoBE();
		//this.click_AutoBE();
		//Thread.sleep(1000);
		//this.verify_Auto_Attend_2();
		//this.click_Autto_Attend_2();
		//Thread.sleep(2000);
		//this.verify_Libary();
		//this.click_Library();
		//Thread.sleep(1000);
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.admin_Open_Workroom_AutoAttend_Library_Page();
		this.verify_Book_Templates();
		this.click_Book_Templates();
		this.verify_Template_Title();
		this.verify_Book_Template_Shared_AutoBE();
		System.out.println("------- Completed --> verify_Book_Template_Shared()  -----------");
	}
	
	public void navigate_Back_To_AutoBE_Library() throws InterruptedException {
		//this.verify_AutoBE();
		//this.click_AutoBE();
		//Thread.sleep(1000);
		//this.verify_Libary();
		//this.click_Library();
		//Thread.sleep(1000);
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.admin_Open_Workroom_AutoBE_Library_Page();
		this.verify_Book_Templates();
		this.click_Book_Templates();
		Thread.sleep(1000);
		this.verify_Template_Title();
		System.out.println("------- Completed --> navigate_Back_To_AutoBE_Library()  -----------");
	}
	
	
	// ------------------ delete_Book_Template -----------------------------------
	By delete = By.xpath("//a[contains(text(),'Delete')]");
	By form_Input_field = By.xpath("//div[@class='modal-body']//input[@class='form-control']");

	public void verify_Form_Input_field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(form_Input_field)));
	}

	public void click_Delete() throws InterruptedException {
		driver.findElement(delete).click();
		Thread.sleep(1000);
	}

	public void click_Form_Input_SendKeys() throws InterruptedException {
		String delete = "delete";
		driver.findElement(form_Input_field).sendKeys(delete);
		Thread.sleep(1000);
	}

	// ------------------ Function Being called- -----------------------------------
	public void delete_Book_Template() throws InterruptedException {
		this.click_Template_Dropdown();
		Thread.sleep(1000);
		this.click_Delete();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> delete_Book_Template()  -----------");
	}

	// ------------------ verify_Edited_Book_Template_Deleted------------------
	public void verify_Book_Template_NOT_Visible() throws InterruptedException {
		String template = "//a[contains(text(),'This is an Book Template Title')]";
		Assert.assertTrue(driver.findElements(By.xpath(template)).size() < 1);
	}
	
	// ------------------ Function Being called- -----------------------------------
	public void verify_Book_Template_Deleted() throws InterruptedException {
		Thread.sleep(4000);
		this.click_Book_Template_Crumb();
		this.verify_New_Template();
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_Book_Template_NOT_Visible();
		System.out.println("------- Completed --> verify_Book_Template_Deleted()  -----------");
	}
		
	// ------------------Hand_Book -----------------------------------

	// ------------------user_Can_Create_New_Handbook() ---------------------
	By handbooks = By.xpath("//a[contains(text(),'Handbooks')]");
	By new_Handbooks = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Handbook')]");
	By top_Save_Btn = By.xpath("//a[@id='save_and_close']");

	public void verify_Handbooks() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbooks)));
	}

	public void verify_New_Handbooks() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Handbooks)));
	}

	public void verify_Title_Form_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Form_Field)));
	}

	public void click_Handbooks() {
		driver.findElement(handbooks).click();
	}

	public void click_New_Handbooks() {
		driver.findElement(new_Handbooks).click();
	}

	public void Enter_Handbook_Title() throws InterruptedException {
		String handbook_title = "This is a Handbook";
		driver.findElement(title_Form_Field).sendKeys(handbook_title);
		// driver.findElement(top_Save_Btn).click();
		Thread.sleep(1000);
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Handbook() throws InterruptedException {
		this.verify_Handbooks();
		this.click_Handbooks();
		this.verify_New_Handbooks();
		this.click_New_Handbooks();
		this.verify_Title_Form_Field();
		this.Enter_Handbook_Title();
		System.out.println("------- Completed --> user_Create_New_Handbook() -----------");
	}
	
	// --------------------------user_Save_HandBook-----------------------------------
	By handbook_Created_Message = By.xpath("//div//p[contains(text(),'Successfully created This is a Handbook')]");

	public void verify_Handbook_Created_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Created_Message)));
	}

	// --------------Function Being Called ---------------------------
	public void user_Save_HandBook() throws InterruptedException {
		this.click_Save_Continue_Btn();
		this.verify_Handbook_Created_Message();
		System.out.println("------- Completed --> user_Save_HandBook -----------");
		Thread.sleep(1000);
	}
	
	// --------------------------make_handbook_Visible----------------------------------
	By handbook_Crumb = By.xpath("//a[contains(text(),'Handbooks')]");
	By handbook_Visible = By.xpath("//a[contains(text(),'This is a Handbook')]");
	By handbook_Title = By.xpath("//*[contains(text(),'This is a Handbook')]");

	public void verify_Handbook_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Visible)));
	}
	
	public void verify_Handbook_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Title)));
	}
	
	public void verify_Handbook_Crumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Crumb)));
	}

	public void click_Handbook_Crumb() throws InterruptedException {
		driver.findElement(handbook_Crumb).click();
		Thread.sleep(1000);
	}
	
	public void click_Handbook_Title() throws InterruptedException {
		driver.findElement(handbook_Title).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void make_Handbook_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		this.click_Handbook_Crumb();
		this.verify_Handbook_Visible();
		System.out.println("------- Completed --> make_handbook_Visible()  -----------");
	}
	
	public void make_Handbook_Visible_2() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		System.out.println("------- Completed --> make_Handbook_Visible_2()  -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void move_Handbook_To_New_Workroom() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_Move_To_Drpdwn();
		this.click_Move_To_Drpdwn();
		Thread.sleep(1000);
		this.verify_Auto_Attend();
		this.click_Auto_Attend();
		Thread.sleep(1000);
		this.verify_Move_Here();
		this.click_Move_Here();
		this.verify_Continue_Btn();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> move_Handbook_To_New_Workroom()  -----------");
	}
	
	public void verify_Handbook_Workroom_Move() throws InterruptedException {
		this.verify_Workroom_Template_Move();
		this.click_Handbook_Crumb();
		Thread.sleep(1000);
		this.verify_Handbook_Title();
		System.out.println("------- Completed --> verify_Handbook_Workroom_Move()  -----------");
	}
		
	// -----------Edit Handbook-----------------
	By handbook_Dropdown = By.xpath("//div[@class='dropdown header-actions']");
	By edit_option = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Edit')]");

	public void verify_Edited_Handbook_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Handbook_Visible)));
	}

	public void click_Handbook_Dropdown() throws InterruptedException {
		driver.findElement(handbook_Dropdown).click();
		Thread.sleep(1000);
	}

	public void click_Edit_Book_Btn() throws InterruptedException {
		driver.findElement(edit_BookBtn).click();
		Thread.sleep(1000);
	}

	public void edited_Handbook_Title_SendKeys() throws InterruptedException {
		String handbook_title = "This is an Edited Handbook";
		driver.findElement(title_Form_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(title_Form_Field).clear();
		driver.findElement(title_Form_Field).sendKeys(handbook_title);
		// driver.findElement(top_Save_Btn).click();
		Thread.sleep(1000);
	}
	
	public void edited_Book_Title_SendKeys() throws InterruptedException {
		String handbook_title = "This is an Edited Book";
		driver.findElement(title_Form_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(title_Form_Field).clear();
		driver.findElement(title_Form_Field).sendKeys(handbook_title);
	}

	// --------------Function Being Called ---------------------------
	public void edit_Handbook() throws InterruptedException {
		this.click_Handbook_Dropdown();
		this.verify_Edit_Option();
		this.click_Edit_Option();
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		this.verify_Title_Form_Field();
		this.edited_Handbook_Title_SendKeys();
		this.click_Coverpage_Expand();
		Thread.sleep(3000);
		this.edit_Generate_Cover_Page_Form();
		Thread.sleep(1000);
		this.click_Preview_Left();// ---click this to make save btn appear
		this.click_Coverpage_CheckBox();
		this.click_Agenda_CheckBox();
		this.scroll_To_SaveBtn();
		this.click_SaveBtn();
		this.verify_Build_Book();
		this.click_Build_Book();
		this.verify_Build_DoneBtn();
		this.click_Build_DoneBtn();
		this.verify_Handbooks();
		this.click_Handbook_Crumb();
		this.verify_Edited_Handbook_Visible();
		System.out.println("------- Completed --> edit_Handbook()  -----------");
	}
	
	By edited_Book = By.xpath("//a[contains(text(),'This is an Edited Book')]/following::div[@class='dropdown header-actions']");

	public void verify_Edited_Book_Title_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Book)));
	}
	
	public void edit_Meeting_Book() throws InterruptedException {
		this.click_Book_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		this.verify_Title_Form_Field();
		this.edited_Book_Title_SendKeys();
		this.click_Coverpage_Expand();
		Thread.sleep(2500);
		this.edit_Generate_Cover_Page_Form_2();
		Thread.sleep(1000);
		//this.click_Preview_Left();// ---click this to make save btn appear
		//this.click_Coverpage_CheckBox();
		//this.click_Agenda_CheckBox();
		this.scroll_To_SaveBtn();
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Build_Book();
		this.click_Build_Book();
		this.verify_Build_DoneBtn();
		this.click_Build_DoneBtn();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		this.verify_Edited_Book_Title_Visible();
		Thread.sleep(1500);
		System.out.println("------- Completed --> edit_Meeting_Book()  -----------");
	}
	
	// ---------------copy_Handbook---------------------------------
	By copy = By.xpath("//li[3]//a[1][contains(., 'Copy')]");
	By handbook_Copy_BreadCrumb = By.xpath("//li[@class='active'][contains(., 'Edit This is a Handbook - Copy')]");
	By handbook_Copy = By.xpath("//*[contains(text(),'This is a Handbook - Copy')]");
	By copy_To_Template = By.xpath("//a[contains(text(),'Copy to Template')]");

	public void verify_Handbook_Copy_Crumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Copy_BreadCrumb)));
	}
	
	public void verify_Handbook_Copy() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Copy)));
	}
	
	public void click_Copy() throws InterruptedException {
		driver.findElement(copy).click();
	}
	
	public void click_Copy_To_Template() throws InterruptedException {
		driver.findElement(copy_To_Template).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void copy_Handbook() throws InterruptedException {
		this.click_Handbook_Dropdown();
		this.verify_Edit_Option();
		this.click_Copy();
		Thread.sleep(1000);
		this.verify_Handbook_Copy_Crumb();
		this.verify_Build_Book();
		this.click_Build_Book();
		Thread.sleep(1000);
		this.verify_Build_DoneBtn(); // --- wait 10 minutes for build book to show up
		this.click_Build_DoneBtn();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		Thread.sleep(1000);
		this.click_Handbook_Crumb();
		this.verify_Handbook_Copy();
		System.out.println("------- Completed --> edit_Handbook()  -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void copy_Handbook_To_Template() throws InterruptedException {
		this.click_Handbook_Dropdown();
		this.verify_Edit_Option();
		this.click_Copy_To_Template();
		Thread.sleep(1000);
		this.verify_Handbook_Copy_Crumb();
		Thread.sleep(1000);
		this.click_Handbook_Crumb();
		Thread.sleep(1000);
		this.verify_Handbook_Visible();
		System.out.println("------- Completed --> edit_Handbook()  -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Handbook_Template_Created() throws InterruptedException {
		this.verify_Book_Templates();
		this.click_Book_Templates();
		this.verify_Handbook_Copy();
		System.out.println("------- Completed --> verify_Handbook_Template_Created()  -----------");
	}
	
	public void copy_Meetings_Book_To_Template() throws InterruptedException {
		this.click_Book_Dropdown();
		this.verify_Edit_Option();
		this.click_Copy_To_Template();
		Thread.sleep(1000);
		this.verify_Title_Input_Field();
		Thread.sleep(1000);
		this.click_Book_Templates();
		Thread.sleep(1000);
		System.out.println("------- Completed --> copy_Meetings_Book_To_Template()  -----------");
	}
	
	//---------- archive handbook -------------
	By restore_Option = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Restore')]");
	
	public void click_Restore_Option() throws InterruptedException {
		driver.findElement(restore_Option).click();
	}

	public void archive_Handbook() throws InterruptedException {
		this.click_Handbook_Dropdown();
		Thread.sleep(1500);
		this.verify_Archive_Option();
		this.click_Archive_Option();
		Thread.sleep(1500);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1500);
		this.verify_Handbook_Visible();
		System.out.println("------- Completed --> archive_Handbook()  -----------");
	}
	
	public void restore_Handbook() throws InterruptedException {
		this.click_Handbook_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		this.click_Restore_Option();
		Thread.sleep(1500);
		this.verify_Handbook_Visible();
		System.out.println("------- Completed --> restore_Handbook()  -----------");
	}
	
	public void view_Handbook_In_Meeting_Book_Viewer() throws InterruptedException {
		this.click_Handbook_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		this.click_Restore_Option();
		Thread.sleep(1500);
		this.verify_Handbook_Visible();
		System.out.println("------- Completed --> view_Handbook_In_Meeting_Book_Viewer()  -----------");
	}
		
	// ---------------delete_Handbook---------------------------------
	// --------------Function Being Called ---------------------------
	public void delete_Handbook_Copy() throws InterruptedException {
		this.click_Handbook_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> delete_Handbook_Copy()  -----------");
	}
	
	public void navigate_Back_To_Handbook() throws InterruptedException {
		this.verify_Handbooks();
		this.click_Handbooks();
		Thread.sleep(1000);
		this.verify_Handbook_Visible();
		System.out.println("------- Completed --> navigate_Back_To_Handbook()  -----------");
	}
	
	public void navigate_Back_To_Handbook_2() throws InterruptedException {
		this.verify_Handbooks();
		this.click_Handbooks();
		Thread.sleep(1000);
		this.verify_New_Handbooks();
		System.out.println("------- Completed --> navigate_Back_To_Handbook_2()  -----------");
	}
	
	public void delete_Handbook() throws InterruptedException {
		this.click_Handbook_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> delete_Handbook()  -----------");
	}
	
	public void verify_Handbook_NOT_Visible() throws InterruptedException {
		String handbook = "//a[contains(text(),'This is an Edited Handbook')]/following::div//span[@class='icon icon_mbm-visible-on visible active-on']/following::text()[contains(., 'Visible to Workroom')]";
		String handbook2 = "//a[contains(text(),'This is a Handbook')]";
		String handbook3 = "//a[contains(text(),'This is an Edited Handbook')]";

		Assert.assertTrue(driver.findElements(By.xpath(handbook)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(handbook2)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(handbook3)).size() < 1);
	}

	public void verify_Handbook_Deleted() throws InterruptedException {
		Thread.sleep(4000);
		this.click_Handbook_Crumb();
		this.verify_New_Handbooks();
		this.verify_Handbook_NOT_Visible();
		System.out.println("------- Completed --> verify_Handbook_Deleted()  -----------");
	}
	
	//-----------advanced_Search------------
	By advanced_Search_Modal = By.xpath("//body/div[@id='advanced_search']/div[1]/div[1]");
	By advanced_Search = By.xpath("//a[contains(text(),'Advanced Search')]");
	By alphabetical_Btn = By.xpath("//button[contains(text(),'Alphabetical')]");
	By radio_Descending = By.xpath("//input[@id='book_sort_desc']");
	By submit_Adv_Se = By.xpath("//*[@id='advanced_search']//div[@class='modal-footer']/button[contains(.,'Submit')]");
	By book_Title_Box = By.xpath("//input[@id='title']");
	
	public void verify_Advanced_Search_Modal_Disapeared() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(advanced_Search_Modal)));
	}

	public void verify_Advanced_Search() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(advanced_Search)));
	}
	
	public void verify_Alphabetical_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(alphabetical_Btn)));
	}
	
	public void verify_Book_Title_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title_Box)));
	}
	
	public void click_Advanced_Search() throws InterruptedException {
		driver.findElement(advanced_Search).click();
	}
	
	public void click_Alphabetical_Btn() throws InterruptedException {
		driver.findElement(alphabetical_Btn).click();
	}
	
	public void click_Radio_Descending() {
		String radioDesc = "//input[@id='book_sort_desc']";
		WebElement element = driver.findElement(By.xpath(radioDesc));
		if(!element.isSelected()) {
			driver.findElement(By.xpath(radioDesc)).click();
		}
	}
	
	public void click_Radio_Ascending() {
		String radioDesc = "//input[@id='book_sort_asc']";
		WebElement element = driver.findElement(By.xpath(radioDesc));
		if(!element.isSelected()) {
			driver.findElement(By.xpath(radioDesc)).click();
		}
	}
	
	public void click_Submit_Adv_Se() throws InterruptedException {
		driver.findElement(submit_Adv_Se).click();
	}
	
	public void verify_Book_Position_Descending_Order() throws InterruptedException {
		String bookB_Following_BookA = "//h3//a[normalize-space(text())='This is a Book Title B']/following::a[normalize-space(text())='This is a Book Title A']";
		Assert.assertTrue(driver.findElements(By.xpath(bookB_Following_BookA)).size() > 0);
	}
	
	public void verify_Book_Position_Accending_Order() throws InterruptedException {
		String bookB_Following_BookA = "//h3//a[normalize-space(text())='This is a Book Title A']/following::a[normalize-space(text())='This is a Book Title B']";
		Assert.assertTrue(driver.findElements(By.xpath(bookB_Following_BookA)).size() > 0);
	}
	
	public void verify_Only_Book_Title_A_Present() throws InterruptedException {
		String bookA = "//h3//a[normalize-space(text())='This is a Book Title A']";
		String bookB = "//h3//a[normalize-space(text())='This is a Book Title B']";
		
		Assert.assertTrue(driver.findElements(By.xpath(bookA)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(bookB)).size() < 1);
	}
	
	public void verify_Only_Book_Title_B_Present() throws InterruptedException {
		String bookB = "//h3//a[normalize-space(text())='This is a Book Title B']";
		String bookA = "//h3//a[normalize-space(text())='This is a Book Title A']";

		Assert.assertTrue(driver.findElements(By.xpath(bookB)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(bookA)).size() < 1);
	}
	
	public void type_Book_Title_A() throws InterruptedException {
		String title = "This is a Book Title A";
		driver.findElement(book_Title_Box).clear();
		driver.findElement(book_Title_Box).sendKeys(title);
	}

	public void type_Book_Title_B() throws InterruptedException {
		String title = "This is a Book Title B";
		driver.findElement(book_Title_Box).clear();
		driver.findElement(book_Title_Box).sendKeys(title);
	}
	
	public void advanced_Search_Verify_Alphabetical_Descending_Order() throws InterruptedException {
		this.verify_Advanced_Search();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_Alphabetical_Btn();
		this.click_Alphabetical_Btn();
		Thread.sleep(1000);
		this.click_Radio_Descending();
		Thread.sleep(1000);
		this.click_Submit_Adv_Se();
		Thread.sleep(1000);
		this.verify_Advanced_Search_Modal_Disapeared();
		this.verify_Book_Position_Descending_Order();
		System.out.println("------- Completed --> advanced_Search_Verify_Alphabetical_Descending_Order()  -----------");
	}
	
	public void advanced_Search_Verify_Alphabetical_Accending_Order() throws InterruptedException {
		this.verify_Advanced_Search();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_Alphabetical_Btn();
		this.click_Alphabetical_Btn();
		Thread.sleep(1000);
		this.click_Radio_Ascending();
		Thread.sleep(1000);
		this.click_Submit_Adv_Se();
		Thread.sleep(1000);
		this.verify_Advanced_Search_Modal_Disapeared();
		this.verify_Book_Position_Accending_Order();
		driver.navigate().refresh();
		System.out.println("------- Completed --> advanced_Search_Verify_Alphabetical_Accending_Order()  -----------");
	}
	
	public void advanced_Search_Search_By_Book_Title_A() throws InterruptedException {
		this.verify_Advanced_Search();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_Alphabetical_Btn();
		this.click_Alphabetical_Btn();
		Thread.sleep(1000);
		this.verify_Book_Title_Box();
		this.type_Book_Title_A();
		this.click_Submit_Adv_Se();
		Thread.sleep(1000);
		this.verify_Advanced_Search_Modal_Disapeared();
		System.out.println("------- Completed --> advanced_Search_Search_By_Book_Title()  -----------");
	}
	
	public void advanced_Search_Search_By_Book_Title_B() throws InterruptedException {
		this.verify_Advanced_Search();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_Alphabetical_Btn();
		this.click_Alphabetical_Btn();
		Thread.sleep(1000);
		this.verify_Book_Title_Box();
		this.type_Book_Title_B();
		this.click_Submit_Adv_Se();
		Thread.sleep(1000);
		this.verify_Advanced_Search_Modal_Disapeared();
		System.out.println("------- Completed --> advanced_Search_Search_By_Book_Title_B()  -----------");
	}
	
	//------------------
	By created_Btn = By.xpath("//button[contains(text(),'Created')]");
	By created_After_Date_Input = By.xpath("//input[@id='created_start']");
	By created_Before_Date_Input = By.xpath("//input[@id='created_end']");
	
	public void click_Created_Btn() throws InterruptedException {
		driver.findElement(created_Btn).click();
	}
	
	public void type_Created_After_Date() throws InterruptedException {
		String date = "2021-02-02";
		driver.findElement(created_After_Date_Input).sendKeys(date);
	}
	
	public void type_Created_Before_Date() throws InterruptedException {
		String date = "2021-02-04";
		driver.findElement(created_Before_Date_Input).sendKeys(date);
	}
	
	public void verify_Only_Book_Titles_B_A_Present() throws InterruptedException {
		String bookB = "//h3//a[normalize-space(text())='This is a Book Title B']";
		String bookA = "//h3//a[normalize-space(text())='This is a Book Title A']";

		Assert.assertTrue(driver.findElements(By.xpath(bookB)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(bookA)).size() > 0);
	}
	
	public void advanced_Search_Search_By_Created_Date_After_Before() throws InterruptedException {
		this.verify_Advanced_Search();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_Alphabetical_Btn();
		this.click_Created_Btn();
		Thread.sleep(1000);
		this.verify_Book_Title_Box();
		this.type_Created_After_Date();
		this.type_Created_Before_Date();
		Thread.sleep(1000);
		this.click_Submit_Adv_Se();
		Thread.sleep(1000);
		this.verify_Advanced_Search_Modal_Disapeared();
		System.out.println("------- Completed --> advanced_Search_Search_By_Created_Date_After_Before()  -----------");
	}
	
	
	//------------------
	By event_Date_Btn = By.xpath("//button[contains(text(),'Event Date')]");
	By event_Date_After = By.xpath("//input[@id='event_start']");
	By event_Date_Before= By.xpath("//input[@id='event_end']");
	
	public void click_Event_Date_Btn() throws InterruptedException {
		driver.findElement(event_Date_Btn).click();
	}
	
	public void type_Event_Date_After() throws InterruptedException {
		String date = "2021-02-07";
		driver.findElement(event_Date_After).sendKeys(date);
	}
	
	public void type_Event_Date_Before() throws InterruptedException {
		String date = "2021-02-09";
		driver.findElement(event_Date_Before).sendKeys(date);
	}
	
	public void verify_Only_Book_A_With_Event_Present() throws InterruptedException {
		String bookA = "//h3//a[normalize-space(text())='This is a Book Title A']";
		String event = "//a[contains(text(),'This is a New Event Title')]";
		String bookB = "//h3//a[normalize-space(text())='This is a Book Title B']";
		
		Assert.assertTrue(driver.findElements(By.xpath(bookA)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(event)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(bookB)).size() < 1);
	}
	
	
	public void advanced_Search_Search_By_Event_Date() throws InterruptedException {
		this.verify_Advanced_Search();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_Alphabetical_Btn();
		this.click_Event_Date_Btn();
		Thread.sleep(1000);
		this.type_Event_Date_After();
		this.type_Event_Date_Before();		
		Thread.sleep(1000);
		this.click_Submit_Adv_Se();
		Thread.sleep(1000);
		this.verify_Advanced_Search_Modal_Disapeared();
		System.out.println("------- Completed --> advanced_Search_Search_By_Event_Date()  -----------");
	}
	
	//-----------------
	
	public void click_Visible_Check_Box() {
		String visibleFlag = "//input[@id='visibility_flag']";
		WebElement element = driver.findElement(By.xpath(visibleFlag));
		if(!element.isSelected()) {
			driver.findElement(By.xpath(visibleFlag)).click();
		}
	}
	
	public void verify_Only_Books_E_And_F_Visible() throws InterruptedException {
		String bookC = "//h3//a[normalize-space(text())='This is a Book Title C']";
		String bookD = "//h3//a[normalize-space(text())='This is a Book Title D']";
		String bookE = "//h3//a[normalize-space(text())='This is a Book Title E']";
		String bookF = "//h3//a[normalize-space(text())='This is a Book Title F']";
		
		Assert.assertTrue(driver.findElements(By.xpath(bookC)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(bookD)).size() < 1);

		Assert.assertTrue(driver.findElements(By.xpath(bookE)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(bookF)).size() > 0);
	}
	
	public void advanced_Search_Search_By_Book_Visible() throws InterruptedException {
		this.verify_Advanced_Search();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_Alphabetical_Btn();
		this.click_Visible_Check_Box();
		Thread.sleep(1000);
		this.click_Submit_Adv_Se();
		Thread.sleep(1000);
		this.verify_Advanced_Search_Modal_Disapeared();
		System.out.println("------- Completed --> advanced_Search_Search_By_Event_Visible()  -----------");
	}
	
	
	//-----------------
	By last_Published = By.xpath("//button[contains(text(),'Last Published')]");
	
	public void click_Last_Published() throws InterruptedException {
		driver.findElement(last_Published).click();
	}
	
	public void verify_Book_Published_Order_E_Then_F_Then_C_Then_D() throws InterruptedException {
		// last published: is by last published date & time
		String bookE_Following_BookF = "//h3//a[normalize-space(text())='This is a Book Title E']/following::a[normalize-space(text())='This is a Book Title F']";
		String bookC_Following_BookD = "//h3//a[normalize-space(text())='This is a Book Title C']/following::a[normalize-space(text())='This is a Book Title D']";

		Assert.assertTrue(driver.findElements(By.xpath(bookE_Following_BookF)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(bookC_Following_BookD)).size() > 0);

	}
	
	public void advanced_Search_Search_By_Last_Published() throws InterruptedException {
		this.verify_Advanced_Search();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_Alphabetical_Btn();
		this.click_Last_Published();
		Thread.sleep(1000);
		this.click_Submit_Adv_Se();
		Thread.sleep(1000);
		this.verify_Advanced_Search_Modal_Disapeared();
		System.out.println("------- Completed --> advanced_Search_Search_By_Last_Published()  -----------");
	}
	
	//---------
	
	public void click_Archived_Check_Box() {
		String archivedFlag = "//input[@id='archived_flag']";
		WebElement element = driver.findElement(By.xpath(archivedFlag));
		if(!element.isSelected()) {
			driver.findElement(By.xpath(archivedFlag)).click();
		}
	}
	
	public void verify_Book_Achived_Book_Visible() throws InterruptedException {
		// last published: is by last published date & time
		String archivedBook = "//h3//a[normalize-space(text())='This is a Archived Book']/following::button[@class='btn btn-default dropdown-toggle']";

		Assert.assertTrue(driver.findElements(By.xpath(archivedBook)).size() > 0);
	}
	
	public void advanced_Search_Search_By_Archived_Book() throws InterruptedException {
		this.verify_Advanced_Search();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_Alphabetical_Btn();
		this.click_Archived_Check_Box();
		Thread.sleep(1000);
		this.click_Submit_Adv_Se();
		Thread.sleep(1000);
		this.verify_Advanced_Search_Modal_Disapeared();
		System.out.println("------- Completed --> advanced_Search_Search_By_Archived_Book()  -----------");
	}
	
}
	
	