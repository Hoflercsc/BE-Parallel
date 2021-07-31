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
import parallel.DriverFactory;

public class BookPage {
	// ----------- POM Page Object model -----------------------------
	
	// ---------------------------------workroom_Admin_Not_See_Event_Due_To_Permissions---------------------------------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By autoAttend = By.xpath("//a[contains(text(),'AutoAttend')]");
	By autoReview= By.xpath("//a[contains(text(),'AutoReview')]");
	By DC = By.xpath("//a[contains(text(),'DC')]");
	By home = By.xpath("//*[@id='wrap']/main//div/ul/li[contains(.,'Home')]");
	By library = By.xpath("//span[contains(text(),'Library')]");
	//By new_Book = By.xpath("(//*[@id='wrap']/main/div[1]/div[2]/div/div[3]/div[3]/a)[1]");
	By new_BookBtn = By.xpath("//*[@id='book-btn']/a[contains(.,'New Book')]");
	//By minutes = By.xpath("//body/div[@id='wrap']/main[1]//div//div[3]/a[contains(.,'Minutes')] ");
	By minutes = By.xpath("//body/div[@id='wrap']/main[1]//a[contains(.,'Minutes')]");
	By minutesManagerTitle = By.xpath("//div[contains(text(),'Minutes Manager')]");
	By takeMinutes = By.xpath("//body/div[@id='wrap']/main[1]//div/a[contains(.,'Take Minutes')]");
	By meetingMinutesForm = By.xpath("//form[@id='minutesPropertiesForm']");
	By takeMeetingMinutesForm = By.xpath("//div[contains(text(),'Create Meeting Minutes')]");

	//By meeting_Book_Viewer = By.xpath("//div[@class='sidebar-fixed-container']//a[@id='view_book']");
	By meeting_Book_Viewer = By.xpath("//*[@class='btn btn-default btn-sidebar secondary-action-btn left'][contains(.,'Meeting Book Viewer')]");


	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}
	
	public void verify_DC() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(DC)));
	}
	
	public void verify_Home() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(home)));
	}

	public void verify_Libary() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library)));
	}

	public void verify_New_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_BookBtn)));
	}
	
	public void verify_Minutes() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(minutes)));
	}
	
	public void verify_Minutes_Manager_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(minutesManagerTitle)));
	}
	
	public void verify_Take_Minutes() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(takeMinutes)));
	}
	
	public void verify_Minutes_Form_And_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meetingMinutesForm)));
	}
	
	public void verify_Take_Minutes_Form_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(takeMeetingMinutesForm)));
	}
	
	public void verify_Meeting_Book_Viewer() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_Viewer)));
	}
	
	public void verify_AutoAttend() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoAttend)));
	}
	
	public void verify_AutoReview() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoReview)));
	}

	public void click_AutoBE() {
		DriverFactory.getInstance().getDriver().findElement(autoBE).click();
	}
	
	public void click_AutoAttend() {
		DriverFactory.getInstance().getDriver().findElement(autoAttend).click();
	}
	
	public void click_AutoReview() {
		DriverFactory.getInstance().getDriver().findElement(autoReview).click();
	}
	
	public void click_DC() {
		DriverFactory.getInstance().getDriver().findElement(DC).click();
	}

	public void click_Library() {
		DriverFactory.getInstance().getDriver().findElement(library).click();
	}
	
	public void click_Minutes() {
		DriverFactory.getInstance().getDriver().findElement(minutes).click();
	}
	
	public void click_Take_Minutes() {
		DriverFactory.getInstance().getDriver().findElement(takeMinutes).click();
	}
	
	public void verify_Events_Library_Collaborate_NOT_Present() throws InterruptedException {
		String events = "//span[contains(text(),'Events')]";
		String library = "//span[contains(text(),'Library')]";
		String collaborate = "//span[contains(text(),'Collaborate')]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(events)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(library)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(collaborate)).size() < 1);
	}
	
	public void verify_Events_Library_Collaborate_ARE_Present() throws InterruptedException {
		String events = "//span[contains(text(),'Events')]";
		String library = "//span[contains(text(),'Library')]";
		String collaborate = "//span[contains(text(),'Collaborate')]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(events)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(library)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(collaborate)).size() > 0);
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
		AtlasNavBar obj  = new AtlasNavBar();
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
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_DC_Workroom();
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_Book_Visible();
		System.out.println("------- Completed --> open_Library_Page_For_Board_Member() -----------");
	}
	
	public void verify_Disabled_Access_For_DC_Workroom() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_DC_Workroom();
		this.verify_Events_Library_Collaborate_NOT_Present();
		System.out.println("------- Completed --> open_DC_Workroom_Verify_Disabled_Access() -----------");
	}
	
	public void verify_Enabled_Access_For_DC_Workroom() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_DC_Workroom();
		this.verify_Events_Library_Collaborate_ARE_Present();
		System.out.println("------- Completed --> verify_Enabled_Access_For_DC_Workroom() -----------");
	}
	
	public void verify_Book_Download_Btn_Not_Present() throws InterruptedException {
		String element = "//*[starts-with (@id,'card-')]//div/a[contains(.,'Download Full PDF')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Book_Meeting_Book2_Download_Btn_Not_Present() throws InterruptedException {
		this.verify_Meeting_Book_2_Name_Only();
		String element = "(//*[normalize-space(text())='meeting book 2']/following::div[@class='btn-group']//child::a[contains(.,'Download Full PDF')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void navigate_To_Minutes_Through_Workroom_Library() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
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
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		this.verify_Minutes_Manager_Title();
		Thread.sleep(4000);
		DriverFactory.getInstance().getDriver().close();
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		System.out.println("------- Completed --> switch_To_Print_Events_Tab() -----------");
	}
	
	public void switch_Verify_Minutes_B() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		this.verify_Minutes_Form_And_Input_Field();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().close();
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		System.out.println("------- Completed --> switch_To_Print_Events_Tab() -----------");
	}
	
	public void switch_Verify_Minutes_C() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		this.verify_Take_Minutes_Form_Title();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().close();
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
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
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
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
	
	public void open_Handbook_8_Navigate_To_Take_Minutes() throws InterruptedException {
		this.verify_Handbook_8_Title();
		this.click_Handbook_8_Title();
		Thread.sleep(1500);
		this.verify_Take_Minutes();
		this.click_Take_Minutes();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Handbook_8_Navigate_To_Take_Minutes() -----------");
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(title_Form_Field)));
	}

	public void click_New_Book() {
		DriverFactory.getInstance().getDriver().findElement(new_BookBtn).click();
	}

		
	public void enter_Book_Title(String bookTitleStaging1) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(bookTitleStaging1);
		Thread.sleep(1000);
	}
	
	public void book_Title_Add_Remove_Print_Logo() throws InterruptedException {
		String book_title = "Add Remove Print Logo";
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(book_title);
		Thread.sleep(1000);
	}
	
	// -------------Function Being Called-----------------------------
			
	public void user_Can_Create_Book_And_Add_Title(String bookTitleStaging1) throws InterruptedException {
		this.verify_Title_Input_Field();
		this.enter_Book_Title(bookTitleStaging1);
		System.out.println("------- Completed --> user_Create_Book_JH_Staging() -----------");
	}
	
	public void user_Can_Create_New_Book(String bookTitleStaging1) throws InterruptedException {
		this.verify_New_Book();
		this.click_New_Book();
		Thread.sleep(1000);
		this.verify_Title_Input_Field();
		this.enter_Book_Title(bookTitleStaging1);
		System.out.println("------- Completed --> user_Create_Book_JH_Staging() -----------");
	}
	
	public void create_Book_Add_Remove_Print_Logo() throws InterruptedException {
		this.click_New_Book();
		this.verify_Title_Input_Field();
		this.book_Title_Add_Remove_Print_Logo();
		System.out.println("------- Completed --> create_Book_Add_Remove_Print_Logo() -----------");
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
		DriverFactory.getInstance().getDriver().findElement(header_1).clear();
		DriverFactory.getInstance().getDriver().findElement(header_1).sendKeys(Header_1);
		DriverFactory.getInstance().getDriver().findElement(header_2).clear();
		DriverFactory.getInstance().getDriver().findElement(header_2).sendKeys(Header_2);
		// ------- date input field ------------------
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate = new Date();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Date CurrentDate = c1.getTime();
		String todayDate = (dateFormat.format(CurrentDate));
		System.out.println(todayDate);
		DriverFactory.getInstance().getDriver().findElement(date).click();
		DriverFactory.getInstance().getDriver().findElement(date).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(date).clear();
		
		DriverFactory.getInstance().getDriver().findElement(date).clear();
		DriverFactory.getInstance().getDriver().findElement(date).sendKeys(todayDate);
		
		DriverFactory.getInstance().getDriver().findElement(line_1).clear();
		DriverFactory.getInstance().getDriver().findElement(line_1).sendKeys(Line_1);
		
		DriverFactory.getInstance().getDriver().findElement(line_2).clear();
		DriverFactory.getInstance().getDriver().findElement(line_2).sendKeys(Line_2);
		
		DriverFactory.getInstance().getDriver().findElement(line_3).clear();
		DriverFactory.getInstance().getDriver().findElement(line_3).sendKeys(Line_3);
		
		DriverFactory.getInstance().getDriver().findElement(line_4).clear();
		DriverFactory.getInstance().getDriver().findElement(line_4).sendKeys(Line_4);
		
		DriverFactory.getInstance().getDriver().findElement(line_5).clear();
		DriverFactory.getInstance().getDriver().findElement(line_5).sendKeys(Line_5);
		
		DriverFactory.getInstance().getDriver().findElement(generate_Cover_Page).click();
		WebElement save = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"new_book\"]/div[3]/div[3]/p/button"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", save);
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
		DriverFactory.getInstance().getDriver().findElement(agenda_Title).sendKeys(agenda_title);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(generate_Agenda).click();
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
		DriverFactory.getInstance().getDriver().findElement(Save_Continue_Btn).click();
		Thread.sleep(1000);
	}

	// --------------Function Being Called-------------------------------
	public void user_Can_Save_Book_And_Continue() throws InterruptedException {
		this.click_Save_Continue_Btn();
		System.out.println("------- Completed --> user_Can_Save_Book_And_Continue() -----------");
	}
	
	
//	public void user_Can_Create_Book_And_Add_Title_B() throws InterruptedException {
//		this.click_New_Book();
//		Thread.sleep(1000);
//		this.verify_Title_Input_Field();
//		this.enter_Book_Title();
//		this.user_Can_Add_Cover_Page();
//		System.out.println("------- Completed --> user_Can_Create_Book_And_Add_Title_B() -----------");
//	}
	
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(catagory_Name_Field)));
	}

	public void verify_New_Catagory_Name() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Catagory)));
	}
	
	public void verify_Main_Catagory_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(main_Catagory_1)));
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
		System.out.println("------- Completed --> user_Add_First_Catagory_To_Book_Template -----------");
	}
	
	// ------------------user_Add_File_To_First_Catagory------------------
	By click_For_More_Options = By.xpath("//a[contains(text(),'click for more options')]");
	By title_Field = By.xpath("//input[@id='bookfolder_title']");
	By file_SaveBtn = By.xpath("//div[@id='newBookFileModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By file_Upload_Success_Message = By.xpath("//p[contains(text(),'The following files were uploaded:')]");
	
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options)));
	}

	public void verify_Title_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(title_Field)));
	}

	public void verify_File_Upload_Success_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(400))// ---wait 5 minutes for message
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(file_Upload_Success_Message)));
	}
	
	public void verify_File_Category_Error() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(400))// ---wait 5 minutes for message
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(file_Category_Error)));
	}
	
	public void verify_File_Error_Triangle() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(400))// ---wait 5 minutes for message
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(file_Error_Triangle)));
	}
	
	public void verify_RL_Attach_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(400))// ---wait 5 minutes for message
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(rl_Attach_Folder)));
	}

	public void verify_File_ToAttach() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(toAttach)));
	}
	
	public void verify_RL_File_Added() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(rl_file_Added)));
	}
	
	public void verify_Link_Address_Input() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(link_Address_Input)));
	}
	
	
	public void click_Click_For_More_Options() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(click_For_More_Options).click();
		Thread.sleep(1000);
	}

	public void title_Field_SendKeys() throws InterruptedException {
		String file_title = "Large Book";
		DriverFactory.getInstance().getDriver().findElement(title_Field).sendKeys(file_title);
		Thread.sleep(1000);
	}
	
	public void title_Field_SendKeys_2() throws InterruptedException {
		String file_title = "Library Files";
		DriverFactory.getInstance().getDriver().findElement(title_Field).sendKeys(file_title);
		Thread.sleep(1000);
	}
	
	public void title_Field_SendKeys_3() throws InterruptedException {
		String file_title = "Web Link";
		DriverFactory.getInstance().getDriver().findElement(title_Field).sendKeys(file_title);
		Thread.sleep(1000);
	}

	public void add_First_Cat_File_1() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void add_First_Cat_File_2() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_Bad_File_1() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\badfile.pdf";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void file_Save_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(file_SaveBtn).click();
		Thread.sleep(1000);
	}
	
	public void click_Libraries_Tab() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(libraries_Tab).click();
	}
	
	public void click_RL_Attach_Folder() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(rl_Attach_Folder).click();
	}
	
	public void click_To_Attach() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(toAttach).click();
	}
	
	public void click_Link_Tab() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(link_Tab).click();
	}
	
	public void sendKeys_Link_Address() throws InterruptedException {
		String url = "https://www.startrek.com/";
		DriverFactory.getInstance().getDriver().findElement(link_Address_Input).sendKeys(url);
	}
	
	public void scroll_Click_Web_Link() throws InterruptedException {
		String link = "//a[contains(text(),'Web Link')]";
		WebElement weblink = DriverFactory.getInstance().getDriver().findElement(By.xpath(link));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", weblink);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(By.xpath(link)).click();
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
	
	public void scroll_And_Click_Link_On_Book_26() throws InterruptedException {
		this.click_Meeting_Book_26_Title();
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
	By tempate_Auto_User_20_21_PDF = By.xpath("//span[contains(text(),'template_autouser20_21')]");

	By workroomAdmin_In_Template = By.xpath("//*[@class='person-name'][contains(.,'Workroom Admin')]");
	By auto_User_20_In_Template = By.xpath("//*[@class='person-name'][contains(.,'Auto User20')]");


	By save_AAW_Btn = By.xpath("//*[@id='manage-guest-list']//button[@class='btn btn-done pull-right']");
	By save_WFB = By.xpath("//*[@id='manage-guest-list']//div/button");
	By scanned_Book_Visible = By.xpath("//a[contains(text(),'This is a Scanned Book')]");

	
	public void verify_Scanned_Book_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(scanned_Book_Visible)));
	}
	
	public void verify_Book_Title_3_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title_3_Drp_Dwn)));
	}
	
	public void verify_File_Title_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Title_Drp_Dwn)));
	}
	
	public void verify_File_Title_Drp_Dwn_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Title_Drp_Dwn_2)));
		
		String element = "(//a[@class ='attached-doc'][contains(text(),'the file title')]/following::button[@class='btn dropdown-toggle'])[1]";
		WebElement fileTitle = DriverFactory.getInstance().getDriver().findElement(By.xpath(element));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", fileTitle);
	}
	
	public void verify_Rename_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(rename_Edit_Option)));
	}
	
	public void verify_Add_Approval_Workflow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(add_Approval_Workflow)));
	}
	
	public void verify_Edited_File_Title_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_File_Title_Drp_Dwn)));
	}
	
	public void verify_Orginal_File_Title_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Title_Drp_Dwn)));
	}
	
	public void verify_Built_File_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(built_File_Title)));
	}
	
	public void verify_Edit_Option_B3() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Option_B3)));
	}
	
	public void verify_Workflow_Modal() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workflow_Modal)));
	}
	
	public void verify_Workflow_Show_Modal() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workflow_Show_Modal)));
	}
	

	public void verify_Select_From_Template_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(select_From_Template_Drp_Dwn)));
	}
	
	public void verify_WorkroomAdmin_In_Template() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(workroomAdmin_In_Template)));
	}
	
	public void verify_Auto_User_20_In_Template() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User_20_In_Template)));
	}
	
	public void verify_Save_WFB() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(save_WFB)));
	}
	
	public void click_Edit_Option_B3() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_Option_B3).click();
	}
	
	public void click_Book_Title_3_Drp_Dwn() throws InterruptedException {
		String str ="(//h3//a[normalize-space(text())='This is a Book Title 3']/following::button[@class='btn btn-default dropdown-toggle'])[1]";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(str));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(book_Title_3_Drp_Dwn).click();
	}
	
	public void click_File_Title_Drp_Dwn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(file_Title_Drp_Dwn).click();
	}
	
	public void click_File_Title_Drp_Dwn_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(file_Title_Drp_Dwn_2).click();
	}
	
	//--------------
	public void click_File_Title_Drp_Dwn_Two() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(file_Title_Drp_Dwn_Two).click();
	}
	
	public void click_File_Title_Drp_Dwn_Three() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(file_Title_Drp_Dwn_Three).click();
	}
	//-----------------
	
	public void click_Edited_File_Title_Drp_Dwn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edited_File_Title_Drp_Dwn).click();
	}
	
	public void click_Add_Approval_Workflow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(add_Approval_Workflow).click();
	}
	
	public void click_Unordered_Approval_Workflow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(unordered_Approval).click();
	}
	
	public void click_Ordered_Approval_Workflow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(ordered_Approval).click();
	}
	
	//-------------------------
	public void click_Select_From_Template() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(select_From_Template).click();
	}
	
	public void click_Select_From_Template_Dropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(select_From_Template_Drp_Dwn).click();
	}
	
	public void click_Template_PDF() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(tempate_PDF).click();
	}
	
	public void click_Auto_User_20_21_Template_PDF() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(tempate_Auto_User_20_21_PDF).click();
	}
	
	public void click_Save_AAW_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(save_AAW_Btn).click();
	}
	
	public void click_Save_WFB_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(save_WFB).click();
	}
	
	//-------------------------
	
	public void click_View_Edit_Approval_Workflow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(view_Edit_Approval_Workflow).click();
	}
	
	public void click_View_Edit_Approval_Workflow_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(view_Edit_Approval_Workflow_2).click();
	}
	
	public void click_View_Edit_Approval_Workflow_3() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(view_Edit_Approval_Workflow_3).click();
	}
	
	public void edit_File_Name() throws InterruptedException {
		String edited_File_title = "edited file Title";
		DriverFactory.getInstance().getDriver().findElement(title_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(title_Field).sendKeys(edited_File_title);
		Thread.sleep(1000);
	}
	
	public void orginal_File_Name() throws InterruptedException {
		String orginal_File_Title = "the file Title";
		DriverFactory.getInstance().getDriver().findElement(title_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(title_Field).sendKeys(orginal_File_Title);
		Thread.sleep(1000);
	}
	
	public void click_Rename_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(rename_Edit_Option).click();
	}
	
	public void click_Scanned_Book_Title() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(scanned_Book_Visible).click();
	}
	
	public void verify_Workroom_Admin_File_Approved() throws InterruptedException {
		String element = "//td[contains(text(),'Workroom Admin')]/following::span[contains(text(),'Approved')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Workroom_Admin_File_Denied() throws InterruptedException {
		String element = "//td[contains(text(),'Workroom Admin')]/following::span[contains(text(),'Denied')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
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
	
	public void add_Unordered_Workflow_Using_Existing_Template_AutoUser20_21() throws InterruptedException {
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
		this.click_Auto_User_20_21_Template_PDF();
		Thread.sleep(1000);
		this.verify_Auto_User_20_In_Template();
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
	
	public void verify_Approval_Response_File_One_Received_Book_41() throws InterruptedException {
		this.click_Meeting_Book_41_Title();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_File_Title_Drp_Dwn_2();
		System.out.println("------- Completed --> verify_Approval_Response_File_Three_Received()  -----------");
	}
	
	//----------------------
	By wf_Current_Date = By.xpath("//input[@id='workflow_due_date']");
	By wf_Reminder_Date = By.xpath("//input[@id='workflow_reminder_date']");
	By save_WFB_2 = By.xpath("//a[contains(text(),'Back')]/following::button");
	By wadmin_Pending_Status = By.xpath("//td[contains(text(),'Workroom Admin')]/following::td[contains(.,'Pending')]");
	By wadmin_2_Pending_Status = By.xpath("//td[contains(text(),'Workroom Admin2')]/following::td[contains(.,'Pending')]");
	By autoDirector_Pending_Status = By.xpath("//td[contains(text(),'Auto Director')]/following::td[contains(.,'Pending')]");
	By autoUser_2_Pending_Status = By.xpath("//td[contains(text(),'Auto User2')]/following::td[contains(.,'Pending')]");
	By autoUser_13_Pending_Status = By.xpath("//td[contains(text(),'Auto User13')]/following::td[contains(.,'Pending')]");
	By autoUser_15_Pending_Status = By.xpath("//td[contains(text(),'Auto User15')]/following::td[contains(.,'Pending')]");
	By autoUser_17_Pending_Status = By.xpath("//td[contains(text(),'Auto User17')]/following::td[contains(.,'Pending')]");
	By autoUser_18_Pending_Status = By.xpath("//td[contains(text(),'Auto User18')]/following::td[contains(.,'Pending')]");
	By autoUser_20_Pending_Status = By.xpath("//td[contains(text(),'Auto User20')]/following::td[contains(.,'Pending')]");

	By wadmin_Approved_Status = By.xpath("(//td[contains(text(),'Workroom Admin')]/following::td[contains(.,'Approved')])[1]");
	By autoUser_2_Approved_Status = By.xpath("//td[contains(text(),'Auto User2')]/following::td[contains(.,'Approved')]");
	By autoUser_15_Approved_Status = By.xpath("//td[contains(text(),'Auto User15')]/following::td[contains(.,'Approved')]");
	By autoUser_18_Approved_Status = By.xpath("//td[contains(text(),'Auto User18')]/following::td[contains(.,'Approved')]");

	By autoUserAdmin1_Approved_Status = By.xpath("(//td[contains(text(),'Auto User Admin1')]/following::td[contains(.,'Approved')])[1]");
	By autoUserAdmin1_Pending_Status = By.xpath("//td[contains(text(),'Auto User Admin1')]/following::td[contains(.,'Pending')]");
	By workroom_AdminEng2_Pending_Status = By.xpath("//td[contains(text(),'workroom admineng2')]/following::td[contains(.,'Pending')]");
	By workroom_AdminEng2_Aproved_Status = By.xpath("//td[contains(text(),'workroom admineng2')]/following::td[contains(.,'Approved')]");

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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(wf_Current_Date)));
	}
	
	public void verify_Wadmin_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(wadmin_Pending_Status)));
	}
	
	public void verify_Wadmin_2_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(wadmin_2_Pending_Status)));
	}
	
	public void verify_Auto_User_2_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUser_2_Pending_Status)));
	}
	
	public void verify_Auto_User_13_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUser_13_Pending_Status)));
	}
	
	public void verify_Auto_User_15_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUser_15_Pending_Status)));
	}
	
	public void verify_Auto_User_17_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUser_17_Pending_Status)));
	}
	
	public void verify_Auto_User_18_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUser_18_Pending_Status)));
	}
	
	public void verify_Auto_User_20_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUser_20_Pending_Status)));
	}
	
	public void verify_AutoDirector_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoDirector_Pending_Status)));
	}
	
	public void verify_AutoUserAdmin1_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUserAdmin1_Pending_Status)));
	}
	
	public void verify_Workroom_AdminEng_2_Pending_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(workroom_AdminEng2_Pending_Status)));
	}
	
	public void verify_Wadmin_Approved_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(wadmin_Approved_Status)));
	}

	public void verify_Auto_User2_Approved_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUser_2_Approved_Status)));
	}
	
	public void verify_Auto_User15_Approved_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUser_15_Approved_Status)));
	}
	
	public void verify_Auto_User18_Approved_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUser_18_Approved_Status)));
	}
	
	public void verify_AutoUserAdmin1_Approved_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(autoUserAdmin1_Approved_Status)));
	}
	
	public void verify_Workroom_AdminEng2_Approved_Status() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(workroom_AdminEng2_Aproved_Status)));
	}
	
	public void verify_Approval_WF_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(approval_WF_Dropdown)));
	}
	
	public void verify_Finalize_Responses() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(finalize_Responses)));
	}
	
	public void verify_Message_Approvers() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(message_Approvers)));
	}
	
	public void verify_Response_Pending_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(response_Pending_1)));
	}
	
	public void verify_Response_Pending_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(response_Pending_2)));
	}
	
	public void verify_Response_Pending_3() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(response_Pending_3)));
	}
	
	public void verify_Comment_Input_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(comment_Input_Box)));
	}
	
	public void verify_Posted_Comment() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(posted_Comment)));
	}
	
	public void verify_Send_A_Message_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(send_A_Message)));
	}
	
	public void verify_Send_Button() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(send_Button)));
	}
	
	public void verify_Message_Sucessfull() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(message_Sucessfull)));
	}
	
	
	
	public void click_Save_WFB_2() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(save_WFB_2).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(save_WFB_2);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Approval_WF_Dropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(approval_WF_Dropdown).click();
	}
	
	public void click_Finalize_Responses() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(finalize_Responses).click();
	}
	
	public void click_Message_Approvers() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(message_Approvers).click();
	}
	
	public void click_Force_Approval() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(force_Approval).click();
	}
	
	public void click_Remove_Workflow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(remove_Workflow).click();
	}
	
	public void click_Comment_Tab() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(comment_Tab).click();
	}
	
	public void Send_Keys_Comment_Input_Box() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(comment_Input_Box).sendKeys("This is a System Admin Comment");
	}
	
	public void click_Post() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(post).click();
	}
	
	public void click_Send_Message_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(send_Button).click();
	}
	
	public void verify_Admin_Non_Admin_Responses() throws InterruptedException {
		String noneAdmin = "//*[contains(text(),'This is a Non Admin Comment')]";
		String sysAdmin = "//*[contains(text(),'This is a System Admin Comment')]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(noneAdmin)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(sysAdmin)).size() > 0);
	}
	
	public void workflow_Status_Window_Check() throws InterruptedException {
		String pending = "//*[@class='small-top plain-list']//li[contains(.,'Pending')]/span[contains(.,'1')]";
		String finalized = "//*[@class='small-top plain-list']//li[contains(.,'Finalized')]/span[contains(.,'1')]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(pending)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(finalized)).size() > 0);
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
		DriverFactory.getInstance().getDriver().findElement(wf_Current_Date).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(wf_Current_Date).clear();
		DriverFactory.getInstance().getDriver().findElement(wf_Current_Date).sendKeys(strDateOne);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(wf_Reminder_Date).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(wf_Reminder_Date).clear();
		DriverFactory.getInstance().getDriver().findElement(wf_Reminder_Date).sendKeys(strDateTwo);
	}
	
	public void verify_Workflow_Complete() throws InterruptedException {
		String element = "//span[contains(text(),'Workflow Complete')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void add_Workflow_Dates() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_WF_Current_Date();
		this.workflow_Calendar_Date();
		Thread.sleep(1000);
		this.click_Save_WFB_2();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_Workflow_Dates()  -----------");
	}
	
	public void verify_Workflow_Created() throws InterruptedException {
		this.verify_Wadmin_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created()  -----------");
	}
	
	public void verify_Workflow_Created_Wadmin_2() throws InterruptedException {
		this.verify_Wadmin_2_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created()  -----------");
	}
	
	public void verify_Workflow_Created_Auto_User_2() throws InterruptedException {
		this.verify_Auto_User_2_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created_Auto_User_2()  -----------");
	}
	
	public void verify_Workflow_Created_Auto_User_13() throws InterruptedException {
		this.verify_Auto_User_13_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created_Auto_User_13()  -----------");
	}
	
	public void verify_Workflow_Created_Auto_User_15() throws InterruptedException {
		this.verify_Auto_User_15_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created_Auto_User_15()  -----------");
	}
	
	public void verify_Workflow_Created_Auto_User_17() throws InterruptedException {
		this.verify_Auto_User_17_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created_Auto_User_17()  -----------");
	}
	
	public void verify_Workflow_Created_Auto_User_18() throws InterruptedException {
		this.verify_Auto_User_18_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created_Auto_User_18()  -----------");
	}
	
	public void verify_Workflow_Created_Auto_User_20() throws InterruptedException {
		this.verify_Auto_User_20_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created_Auto_User_20()  -----------");
	}
	
	public void verify_Workflow_Created_2() throws InterruptedException {
		this.verify_AutoDirector_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Workflow_Created_2()  -----------");
	}
	
	public void verify_Workflow_Created_3() throws InterruptedException {
		this.verify_AutoUserAdmin1_Pending_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> sysAdmin_Comment_Verify_Workflow_Created()  -----------");
	}
	
	public void sysAdmin_Comment_Verify_Workflow_Created_AutoDirector() throws InterruptedException {
		this.verify_AutoDirector_Pending_Status();
		Thread.sleep(1000);
		this.click_Comment_Tab();
		Thread.sleep(1000);
		this.verify_Comment_Input_Box();
		this.Send_Keys_Comment_Input_Box();
		this.click_Post();
		Thread.sleep(1000);
		this.verify_Posted_Comment();
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> force_Workflow_Approvals()  -----------");
	}
	
	public void force_Workflow_Approvals_Book_34() throws InterruptedException {
		this.verify_AutoUserAdmin1_Pending_Status();
		this.verify_Approval_WF_Dropdown();
		this.click_Approval_WF_Dropdown();
		Thread.sleep(1000);
		this.verify_Message_Approvers();
		this.click_Force_Approval();
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		this.verify_AutoUserAdmin1_Approved_Status();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> force_Workflow_Approvals_Book_34()  -----------");
	}
	
	public void force_Workflow_Approvals_Book_38() throws InterruptedException {
		this.verify_Workroom_AdminEng_2_Pending_Status();
		this.verify_Approval_WF_Dropdown();
		this.click_Approval_WF_Dropdown();
		Thread.sleep(1000);
		this.verify_Message_Approvers();
		this.click_Force_Approval();
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		this.verify_Workroom_AdminEng2_Approved_Status();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> force_Workflow_Approvals_Book_34()  -----------");
	}
	
	public void force_Workflow_Approvals_Book_40() throws InterruptedException {
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
		this.verify_Auto_User18_Approved_Status();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> force_Workflow_Approvals_B()  -----------");
	}
	
	public void force_Workflow_Approvals_Book_42() throws InterruptedException {
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
		this.verify_Auto_User15_Approved_Status();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> force_Workflow_Approvals_Book_42()  -----------");
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_Workflow_Complete();
		System.out.println("------- Completed --> finalize_Workflow_Response()  -----------");
	}

	public void finalize_Workflow_Response_Updated() throws InterruptedException {
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(4000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_Workflow_Complete();
		System.out.println("------- Completed --> finalize_Workflow_Response_Updated()  -----------");
	}
	
	//-------------
	By view_Workflows = By.xpath("//a[contains(text(),'View Workflows')]");
	By pending_Tab = By.xpath("//a[contains(text(),'Pending')]");
	By pending_Tab_Right_Arrow = By.xpath("//div[@class='active tab-pane small-top smallest-left']//i[@class='fa fa-chevron-right']");
	By back_Arrow = By.xpath("//a[contains(text(),'< Back to Workflow List')]");
	By finalized_Tab = By.xpath("//a[contains(text(),'Finalized')]");
	By finalized_Tab_Right_Arrow = By.xpath("//div[@class='tab-pane small-top smallest-left active']//i[@class='fa fa-chevron-right']");
	
	public void verify_Pending_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(pending_Tab_Right_Arrow)));
	}
	
	public void verify_Pending_Tab_Right_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(pending_Tab)));
	}
	
	public void verify_Finalized_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(finalized_Tab)));
	}
	
	public void verify_Finalized_Tab_Right_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(200))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(finalized_Tab_Right_Arrow)));
	}
	
	
	public void verify_Three_Workflow_Responses() throws InterruptedException {
		String one = "//span[contains(text(),'Workflow Complete')]";
		String two = "//span[contains(text(),'Responses Pending')]";
		String three = "//span[contains(text(),'Responses Received')]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(one)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(two)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(three)).size() > 0);
	}
	
	public void click_View_Workflows() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(view_Workflows).click();
	}
	
	public void click_Pending_Tab_Right_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(pending_Tab_Right_Arrow).click();
	}
	
	public void click_back_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(back_Arrow).click();
	}
	
	public void click_Finalized_Tab() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(finalized_Tab).click();
	}
	
	public void click_Finalized_Tab_Right_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(finalized_Tab_Right_Arrow).click();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Pending_AutoDirector_And_Finalized_WorkroomAdmin()  -----------");
	}
	
	public void verify_Pending_AutoUser15_And_Finalized_AutoUser2() throws InterruptedException {
		this.verify_File_Title_Drp_Dwn_2();
		this.workflow_Status_Window_Check();
		this.click_View_Workflows();
		Thread.sleep(1000);
		this.verify_Pending_Tab();
		this.click_Pending_Tab_Right_Arrow();
		Thread.sleep(1000);
		this.verify_Auto_User_2_Pending_Status();
		this.click_back_Arrow();
		Thread.sleep(1000);
		this.verify_Finalized_Tab();
		this.click_Finalized_Tab();
		Thread.sleep(1000);
		this.verify_Finalized_Tab_Right_Arrow();
		this.click_Finalized_Tab_Right_Arrow();
		this.verify_Auto_User15_Approved_Status();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Pending_AutoUser15_And_Finalized_AutoUser2()  -----------");
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> force_Workflow_Approvals()  -----------");
	}
	
		
	
	// ----------------------------build_Book()---------------------------------------
	By build_Handbook = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Build Book')]");
	By build_DoneBtn = By.xpath("//button[contains(text(),'Done')]");

	public void verify_Build_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(100))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(build_Handbook)));
	}

	public void verify_Build_DoneBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(1000))// --- wait 3 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
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

	// --------------Function Being Called--------------------
	public void user_Can_Build_Book() throws InterruptedException {
		this.verify_Build_Book();
		this.scroll_Up_To_Build_Book();
		Thread.sleep(2500);// ---adding delay to make sure book done button displays 		
		this.click_Build_Book();
		Thread.sleep(1000);
		this.verify_Build_DoneBtn();  
		this.click_Build_DoneBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Build_Book()  -----------");
	}
	
	public void user_Can_Build_Book_2() throws InterruptedException {
		Thread.sleep(2500);// ---adding delay to make sure book done button displays 
		this.click_Build_Book();
		Thread.sleep(1000);
		this.verify_Build_DoneBtn(); 
		Thread.sleep(2000);
		this.click_Build_DoneBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Build_Book_2()  -----------");
	}
	
	// ------------------make_Book_Visible--------------
	By edit_BookBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Book')]");
	By onswitch = By.xpath("//label[@class='onoffswitch-label']");
	By workroom_Library_Crumb = By.xpath("//a[contains(text(),'Workroom Library')]");
	By book_Title = By.xpath("//a[contains(text(),'This is a Book Title')]");
	
	//-------------------------------------new-------------------------------

	By book_Board_Member_Access_1 = By.xpath("//*[normalize-space(text())='Book Board Member Access 1']");
	By book_Board_Member_Access_1_Dropdown = By.xpath("//*[normalize-space(text())='Book Board Member Access 1']/following::div[@class='dropdown header-actions']");
	By book_Board_Member_Access_1_Delete_Option = By.xpath("//*[normalize-space(text())='Book Board Member Access 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	By book_Add_Remove_Print_Logo_Dropdown = By.xpath("//*[normalize-space(text())='Add Remove Print Logo']//following::div[@class='dropdown header-actions']");
	By edited_Book = By.xpath("//*[normalize-space(text())='This is an Edited Book')]/following::div[@class='dropdown header-actions']");
	By meeting_Book_2_Dropdown = By.xpath("//*[normalize-space(text())='meeting book 2']/following::div[@class='dropdown header-actions']");
	By meeting_Book_2_Name_Only = By.xpath("//*[normalize-space(text())='meeting book 2']");
	//By meeting_Book_2_Book_Viewer_Button = By.xpath("//*[normalize-space(text())='meeting book 2']/following::div[@class='dropdown header-actions']");
	By meeting_Book_2_Delete_Option = By.xpath("//*[normalize-space(text())='meeting book 2']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	By meeting_Book_3_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 3']/following::div[@class='dropdown header-actions']");
	By meeting_Book_3_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 3']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_5_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 5']/following::div[@class='dropdown header-actions']");
	By meeting_Book_5_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 5']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_6_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 6']/following::div[@class='dropdown header-actions']");
	By meeting_Book_6_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 6']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_7_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 7']/following::div[@class='dropdown header-actions']");
	By meeting_Book_7_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 7']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_8_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 8']/following::div[@class='dropdown header-actions']");
	By meeting_Book_8_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 8']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_9_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 9']/following::div[@class='dropdown header-actions']");
	By meeting_Book_9_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 9']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_10_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 10']/following::div[@class='dropdown header-actions']");
	By meeting_Book_10_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 10']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_11_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 11']/following::div[@class='dropdown header-actions']");
	By meeting_Book_11_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 11']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_12_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 12']/following::div[@class='dropdown header-actions']");
	By meeting_Book_12_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 12']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_13_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 13']/following::div[@class='dropdown header-actions']");
	By meeting_Book_13_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 13']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_14_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 14']/following::div[@class='dropdown header-actions']");
	By meeting_Book_14_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 14']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_15_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 15']/following::div[@class='dropdown header-actions']");
	By meeting_Book_15_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 15']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_16_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 16']/following::div[@class='dropdown header-actions']");
	By meeting_Book_16_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 16']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	
	By meeting_Book_17_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 17']/following::div[@class='dropdown header-actions']");
	By meeting_Book_17_Archive_Option = By.xpath("//*[normalize-space(text())='Meeting Book 17']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Archive')]");
	By meeting_Book_17_Restore_Option = By.xpath("//*[normalize-space(text())='Meeting Book 17']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Restore')]");
	By meeting_Book_17_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 17']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_18_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 18']/following::div[@class='dropdown header-actions']");
	By meeting_Book_18_Archive_Option = By.xpath("//*[normalize-space(text())='Meeting Book 18']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Archive')]");
	By meeting_Book_18_Copy_Option = By.xpath("//*[normalize-space(text())='Meeting Book 18']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Copy')]");
	By meeting_Book_18_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 18']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_19_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 19']/following::div[@class='dropdown header-actions']");
	By meeting_Book_19_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 19']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_20_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 20']/following::div[@class='dropdown header-actions']");
	By meeting_Book_20_Copy_Option = By.xpath("//*[normalize-space(text())='Meeting Book 20']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Copy')]");
	By meeting_Book_20_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 20']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_21_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 21']/following::div[@class='dropdown header-actions']");
	By meeting_Book_21_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 21']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_22_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 22']/following::div[@class='dropdown header-actions']");
	By meeting_Book_22_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 22']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	By meeting_Book_22_Copy_Option = By.xpath("//*[normalize-space(text())='Meeting Book 22']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Copy')]");
	
	By meeting_Book_23_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 23']/following::div[@class='dropdown header-actions']");
	By meeting_Book_23_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 23']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_24_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 24']/following::div[@class='dropdown header-actions']");
	By meeting_Book_24_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 24']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_25_Title = By.xpath("//*[normalize-space(text())='Meeting Book 25']");
	By meeting_Book_25_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 25']/following::div[@class='dropdown header-actions']");
	By meeting_Book_25_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 25']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_26_Title = By.xpath("//*[normalize-space(text())='Meeting Book 26']");
	By meeting_Book_26_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 26']/following::div[@class='dropdown header-actions']");
	By meeting_Book_26_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 26']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_27_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 27']/following::div[@class='dropdown header-actions']");
	By meeting_Book_27_Edit_Option = By.xpath("//*[normalize-space(text())='Meeting Book 27']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Edit')]");
	By meeting_Book_27_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 27']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_28_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 28']/following::div[@class='dropdown header-actions']");
	By meeting_Book_28_Edit_Option = By.xpath("//*[normalize-space(text())='Meeting Book 28']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Edit')]");
	By meeting_Book_28_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 28']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_29_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 29']/following::div[@class='dropdown header-actions']");
	By meeting_Book_29_Edit_Option = By.xpath("//*[normalize-space(text())='Meeting Book 29']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Edit')]");
	By meeting_Book_29_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 29']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_30_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 30']/following::div[@class='dropdown header-actions']");
	By meeting_Book_30_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 30']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_31_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 31']/following::div[@class='dropdown header-actions']");
	By meeting_Book_31_Edit_Option = By.xpath("//*[normalize-space(text())='Meeting Book 31']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Edit')]");
	By meeting_Book_31_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 31']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_32_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 32']/following::div[@class='dropdown header-actions']");
	By meeting_Book_32_Edit_Option = By.xpath("//*[normalize-space(text())='Meeting Book 32']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Edit')]");
	
	By meeting_Book_33_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 33']/following::div[@class='dropdown header-actions']");
	By meeting_Book_33_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 33']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_34_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 34']/following::div[@class='dropdown header-actions']");
	By meeting_Book_34_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 34']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_35_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 35']/following::div[@class='dropdown header-actions']");
	By meeting_Book_35_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 35']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_36_Title = By.xpath("//*[normalize-space(text())='Meeting Book 36']");
	By meeting_Book_36_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 36']/following::div[@class='dropdown header-actions']");
	By meeting_Book_36_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 36']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By meeting_Book_37_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 37']/following::div[@class='dropdown header-actions']");

	By meeting_Book_37_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 37']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	By meeting_Book_37_Edit_Option = By.xpath("//*[normalize-space(text())='Meeting Book 37']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Edit')]");

	By meeting_Book_38_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 38']/following::div[@class='dropdown header-actions']");
	By meeting_Book_38_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 38']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	By meeting_Book_39_Title = By.xpath("//*[normalize-space(text())='Meeting Book 39']");
	By meeting_Book_39_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 39']/following::div[@class='dropdown header-actions']");
	By meeting_Book_39_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 39']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	By meeting_Book_40_Title = By.xpath("//*[normalize-space(text())='Meeting Book 40']");
	By meeting_Book_40_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 40']/following::div[@class='dropdown header-actions']");
	By meeting_Book_40_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 40']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	By meeting_Book_41_Title = By.xpath("//*[normalize-space(text())='Meeting Book 41']");
	By meeting_Book_41_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 41']/following::div[@class='dropdown header-actions']");
	By meeting_Book_41_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 41']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	By meeting_Book_42_Dropdown = By.xpath("//*[normalize-space(text())='Meeting Book 42']/following::div[@class='dropdown header-actions']");
	By meeting_Book_42_Delete_Option = By.xpath("//*[normalize-space(text())='Meeting Book 42']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	
	public void verify_Book_Board_Member_Access_1_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Board_Member_Access_1_Dropdown)));
	}
	
	public void verify_Book_Board_Member_Access_1_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Board_Member_Access_1_Delete_Option)));
	}
	
	public void verify_Meeting_Book_2_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_2_Dropdown)));
	}
	
	public void verify_Meeting_Book_2_Name_Only() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_2_Name_Only)));
	}
	
	public void verify_Meeting_Book_2_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_2_Delete_Option)));
	}
	
	public void verify_Meeting_Book_3_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_3_Dropdown)));
	}
	
	public void verify_Meeting_Book_3_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_3_Delete_Option)));
	}
	
	public void verify_Meeting_Book_5_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_5_Dropdown)));
	}
	
	public void verify_Meeting_Book_5_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_5_Delete_Option)));
	}
	
	public void verify_Meeting_Book_6_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_6_Dropdown)));
	}
	
	public void verify_Meeting_Book_6_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_6_Delete_Option)));
	}
	
	public void verify_Meeting_Book_7_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_7_Dropdown)));
	}
	
	public void verify_Meeting_Book_7_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_7_Delete_Option)));
	}
	
	public void verify_Meeting_Book_8_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_8_Dropdown)));
	}
	
	public void verify_Meeting_Book_8_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_8_Delete_Option)));
	}
	
	public void verify_Meeting_Book_9_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_9_Dropdown)));
	}
	
	public void verify_Meeting_Book_9_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_9_Delete_Option)));
	}
	
	public void verify_Meeting_Book_10_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_10_Dropdown)));
	}
	
	public void verify_Meeting_Book_10_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_10_Delete_Option)));
	}
	
	public void verify_Meeting_Book_11_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_11_Dropdown)));
	}
	
	public void verify_Meeting_Book_11_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_11_Delete_Option)));
	}
	
	public void verify_Meeting_Book_12_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_12_Dropdown)));
	}
	
	public void verify_Meeting_Book_12_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_12_Delete_Option)));
	}
	
	public void verify_Meeting_Book_13_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_13_Dropdown)));
	}
	
	public void verify_Meeting_Book_13_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_13_Delete_Option)));
	}
	
	public void verify_Meeting_Book_14_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_14_Dropdown)));
	}
	
	public void verify_Meeting_Book_14_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_14_Delete_Option)));
	}
	
	public void verify_Meeting_Book_15_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_15_Dropdown)));
	}
	
	public void verify_Meeting_Book_15_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_15_Delete_Option)));
	}
	
	public void verify_Meeting_Book_16_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_16_Dropdown)));
	}
	
	public void verify_Meeting_Book_16_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_16_Delete_Option)));
	}
	
	public void verify_Meeting_Book_17_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_17_Dropdown)));
	}
	
	public void verify_Meeting_Book_17_Archive_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_17_Archive_Option)));
	}
	
	public void verify_Meeting_Book_17_Restore_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_17_Restore_Option)));
	}
	
	public void verify_Meeting_Book_17_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_17_Delete_Option)));
	}
	
	public void verify_Meeting_Book_18_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_18_Dropdown)));
	}
	
	public void verify_Meeting_Book_18_Archive_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_18_Archive_Option)));
	}
	
	public void verify_Meeting_Book_18_Copy_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_18_Copy_Option)));
	}
	
	public void verify_Meeting_Book_18_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_18_Delete_Option)));
	}
	
	public void verify_Meeting_Book_19_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_19_Dropdown)));
	}
	
	public void verify_Meeting_Book_19_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_19_Delete_Option)));
	}
	
	public void verify_Meeting_Book_20_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_20_Delete_Option)));
	}
	
	public void verify_Meeting_Book_20_Copy_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_20_Copy_Option)));
	}
	
	public void verify_Meeting_Book_21_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_21_Delete_Option)));
	}
	
	public void verify_Meeting_Book_22_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_22_Dropdown)));
	}
	
	public void verify_Meeting_Book_22_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_22_Delete_Option)));
	}
	
	public void verify_Meeting_Book_23_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_23_Dropdown)));
	}
	
	public void verify_Meeting_Book_23_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_23_Delete_Option)));
	}
	
	public void verify_Meeting_Book_24_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_24_Dropdown)));
	}
	
	public void verify_Meeting_Book_24_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_24_Delete_Option)));
	}
	
	public void verify_Meeting_Book_25_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_25_Dropdown)));
	}
	
	public void verify_Meeting_Book_25_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_25_Delete_Option)));
	}
	
	public void verify_Meeting_Book_26_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_26_Dropdown)));
	}
	
	public void verify_Meeting_Book_26_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_26_Delete_Option)));
	}
	
	public void verify_Meeting_Book_27_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_27_Dropdown)));
	}
	
	public void verify_Meeting_Book_27_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_27_Edit_Option)));
	}
	
	public void verify_Meeting_Book_27_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_27_Delete_Option)));
	}
	
	public void verify_Meeting_Book_28_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_28_Dropdown)));
	}
	
	public void verify_Meeting_Book_28_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_28_Edit_Option)));
	}
	
	public void verify_Meeting_Book_28_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_28_Delete_Option)));
	}
	
	public void verify_Meeting_Book_29_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_29_Dropdown)));
	}
	
	public void verify_Meeting_Book_29_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_29_Edit_Option)));
	}
	
	public void verify_Meeting_Book_29_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_29_Delete_Option)));
	}
	
	public void verify_Meeting_Book_30_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_30_Dropdown)));
	}
	
	public void verify_Meeting_Book_30_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_30_Delete_Option)));
	}
	
	public void verify_Meeting_Book_31_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_31_Dropdown)));
	}
	
	public void verify_Meeting_Book_31_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(meeting_Book_31_Edit_Option)));
	}
	
	public void verify_Meeting_Book_31_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_31_Delete_Option)));
	}
	
	public void verify_Meeting_Book_32_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(meeting_Book_32_Dropdown)));
	}
	
	public void verify_Meeting_Book_32_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_32_Edit_Option)));
	}
	
	public void verify_Meeting_Book_33_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_33_Dropdown)));
	}
	
	public void verify_Meeting_Book_33_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_33_Delete_Option)));
	}
	
	public void verify_Meeting_Book_34_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_34_Dropdown)));
	}
	
	public void verify_Meeting_Book_34_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_34_Delete_Option)));
	}
	
	public void verify_Meeting_Book_35_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_35_Dropdown)));
	}
	
	public void verify_Meeting_Book_35_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_35_Delete_Option)));
	}
	
	public void verify_Meeting_Book_36_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_36_Dropdown)));
	}
	
	public void verify_Meeting_Book_36_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_36_Delete_Option)));
	}
	
	public void verify_Meeting_Book_37_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_37_Dropdown)));
	}
	
	public void verify_Meeting_Book_37_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_37_Edit_Option)));
	}
	
	public void verify_Meeting_Book_37_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_37_Delete_Option)));
	}
	
	public void verify_Meeting_Book_38_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_38_Dropdown)));
	}
	
	public void verify_Meeting_Book_38_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_38_Delete_Option)));
	}
	
	public void verify_Meeting_Book_39_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_39_Dropdown)));
	}
	
	public void verify_Meeting_Book_39_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_39_Delete_Option)));
	}
	
	public void verify_Meeting_Book_40_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_40_Dropdown)));
	}
	
	public void verify_Meeting_Book_40_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_40_Title)));
	}
	
	public void verify_Meeting_Book_40_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_40_Delete_Option)));
	}
	
	public void verify_Meeting_Book_41_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_41_Dropdown)));
	}
	
	public void verify_Meeting_Book_41_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_41_Delete_Option)));
	}
	
	public void verify_Meeting_Book_42_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_42_Dropdown)));
	}
	
	public void verify_Meeting_Book_42_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_42_Delete_Option)));
	}
	
	public void verify_New_BookBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_BookBtn)));
	}
	
	public void click_Book_Board_Member_Access_1_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(book_Board_Member_Access_1_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(book_Board_Member_Access_1_Dropdown).click();
	}
	
	public void click_Meeting_Book_2_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_2_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_2_Dropdown).click();
	}
	
	public void click_Meeting_Book_3_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_3_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_3_Dropdown).click();
	}
	
	public void click_Meeting_Book_5_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_5_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_5_Dropdown).click();
	}
	
	public void click_Meeting_Book_6_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_6_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_6_Dropdown).click();
	}
	
	public void click_Meeting_Book_7_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_7_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_7_Dropdown).click();
	}
	
	public void click_Meeting_Book_8_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_8_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_8_Dropdown).click();
	}
	
	public void click_Meeting_Book_9_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_9_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_9_Dropdown).click();
	}
	
	public void click_Meeting_Book_10_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_10_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_10_Dropdown).click();
	}
	
	public void click_Meeting_Book_11_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_11_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_11_Dropdown).click();
	}
	
	public void click_Meeting_Book_12_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_12_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_12_Dropdown).click();
	}
	
	public void click_Meeting_Book_13_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_13_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_13_Dropdown).click();
	}
	
	public void click_Meeting_Book_14_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_14_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_14_Dropdown).click();
	}
	
	public void click_Meeting_Book_15_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_15_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_15_Dropdown).click();
	}
	
	public void click_Meeting_Book_16_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_16_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_16_Dropdown).click();
	}
	
	public void click_Meeting_Book_17_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_17_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_17_Dropdown).click();
	}
	
	public void click_Meeting_Book_18_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_18_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_18_Dropdown).click();
	}
	
	public void click_Meeting_Book_19_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_19_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_19_Dropdown).click();
	}
	
	public void click_Meeting_Book_20_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_20_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_20_Dropdown).click();
	}
	
	public void click_Meeting_Book_21_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_21_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_21_Dropdown).click();
	}
	
	public void click_Meeting_Book_22_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_22_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_22_Dropdown).click();
	}
	
	public void click_Meeting_Book_23_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_23_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_23_Dropdown).click();
	}
	
	public void click_Meeting_Book_24_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_24_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_24_Dropdown).click();
	}
	
	public void click_Meeting_Book_25_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_25_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_25_Title).click();
	}
	
	public void click_Meeting_Book_25_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_25_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_25_Dropdown).click();
	}
	
	public void click_Meeting_Book_26_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_26_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_26_Title).click();
	}
	
	public void click_Meeting_Book_26_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_26_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_26_Dropdown).click();
	}
	
	public void click_Meeting_Book_27_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_27_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_27_Dropdown).click();
	}
	
	public void click_Meeting_Book_28_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_28_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_28_Dropdown).click();
	}
	public void click_Meeting_Book_29_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_29_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_29_Dropdown).click();
	}
	public void click_Meeting_Book_30_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_30_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_30_Dropdown).click();
	}
	
	public void click_Meeting_Book_31_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_31_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_31_Dropdown).click();
	}
	
	public void click_Meeting_Book_32_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_32_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_32_Dropdown).click();
	}
	
	public void click_Meeting_Book_33_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_33_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_33_Dropdown).click();
	}
	
	public void click_Meeting_Book_34_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_34_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_34_Dropdown).click();
	}
	
	public void click_Meeting_Book_35_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_35_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_35_Dropdown).click();
	}
	
	public void click_Meeting_Book_36_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_36_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_36_Title).click();
	}
	
	public void click_Meeting_Book_36_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_36_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_36_Dropdown).click();
	}
	
	public void click_Meeting_Book_37_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_37_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_37_Dropdown).click();
	}
	
	public void click_Meeting_Book_38_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_38_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_38_Dropdown).click();
	}
	
	public void click_Meeting_Book_39_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_39_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_39_Title).click();
	}
	
	public void click_Meeting_Book_39_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_39_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_39_Dropdown).click();
	}
	
	public void click_Meeting_Book_40_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_40_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_40_Title).click();
	}
	
	public void click_Meeting_Book_40_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_40_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_40_Dropdown).click();
	}
	
	public void click_Meeting_Book_41_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_41_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_41_Title).click();
	}
	
	public void click_Meeting_Book_41_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_41_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_41_Dropdown).click();
	}
	
	public void click_Meeting_Book_42_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(meeting_Book_42_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_42_Dropdown).click();
	}
	
	public void click_Edited_Book_Dropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edited_Book).click();
	}
	
	public void click_Book_Board_Member_Access_1_Delete_Option() throws InterruptedException {
			DriverFactory.getInstance().getDriver().findElement(book_Board_Member_Access_1_Delete_Option).click();
	}
	
	public void click_Meeting_Book_2_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_2_Delete_Option).click();
	}
	
	public void click_Meeting_Book_3_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_3_Delete_Option).click();
	}
		
	public void click_Meeting_Book_5_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_5_Delete_Option).click();
	}
	
	public void click_Meeting_Book_6_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_6_Delete_Option).click();
	}
	
	public void click_Meeting_Book_7_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_7_Delete_Option).click();
	}
	
	public void click_Meeting_Book_8_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_8_Delete_Option).click();
	}
	
	public void click_Meeting_Book_9_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_9_Delete_Option).click();
	}
	
	public void click_Meeting_Book_10_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_10_Delete_Option).click();
	}
	
	public void click_Meeting_Book_11_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_11_Delete_Option).click();
	}
	
	public void click_Meeting_Book_12_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_12_Delete_Option).click();
	}
	
	public void click_Meeting_Book_13_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_13_Delete_Option).click();
	}
	
	public void click_Meeting_Book_14_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_14_Delete_Option).click();
	}
	
	public void click_Meeting_Book_15_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_15_Delete_Option).click();
	}
	
	public void click_Meeting_Book_16_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_16_Delete_Option).click();
	}
	
	public void click_Meeting_Book_17_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_17_Delete_Option).click();
	}
	
	public void click_Meeting_Book_17_Restore_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_17_Restore_Option).click();
	}
	
	public void click_Meeting_Book_17_Archive_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_17_Archive_Option).click();
	}
	
	public void click_Meeting_Book_18_Archive_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_18_Archive_Option).click();
	}
	
	public void click_Meeting_Book_18_Copy_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_18_Copy_Option).click();
	}
	
	public void click_Meeting_Book_18_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_18_Delete_Option).click();
	}
	
	public void click_Meeting_Book_19_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_19_Delete_Option).click();
	}
	
	public void click_Meeting_Book_20_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_20_Delete_Option).click();
	}
	
	public void click_Meeting_Book_20_Copy_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_20_Copy_Option).click();
	}
	
	public void click_Meeting_Book_21_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_21_Delete_Option).click();
	}
	
	public void click_Meeting_Book_22_Copy_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_22_Copy_Option).click();
	}
	
	public void click_Meeting_Book_22_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_22_Delete_Option).click();
	}
	
	public void click_Meeting_Book_23_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_23_Delete_Option).click();
	}
	
	public void click_Meeting_Book_24_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_24_Delete_Option).click();
	}
	
	public void click_Meeting_Book_25_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_25_Delete_Option).click();
	}
	
	public void click_Meeting_Book_26_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_26_Delete_Option).click();
	}
	
	public void click_Meeting_Book_27_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_27_Delete_Option).click();
	}
	
	public void click_Meeting_Book_27_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_27_Edit_Option).click();
	}
	
	public void click_Meeting_Book_28_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_28_Edit_Option).click();
	}
	
	public void click_Meeting_Book_28_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_28_Delete_Option).click();
	}
	
	public void click_Meeting_Book_29_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_29_Edit_Option).click();
	}
	
	public void click_Meeting_Book_29_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_29_Delete_Option).click();
	}
	
	public void click_Meeting_Book_30_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_30_Delete_Option).click();
	}
	
	public void click_Meeting_Book_31_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_31_Edit_Option).click();
	}
	
	public void click_Meeting_Book_37_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_37_Edit_Option).click();
	}
	
	public void click_Meeting_Book_32_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_32_Edit_Option).click();
	}
	
	public void click_Meeting_Book_31_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_31_Delete_Option).click();
	}
	
	public void click_Meeting_Book_33_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_33_Delete_Option).click();
	}
	
	public void click_Meeting_Book_34_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_34_Delete_Option).click();
	}
	
	public void click_Meeting_Book_35_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_35_Delete_Option).click();
	}
	
	public void click_Meeting_Book_36_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_36_Delete_Option).click();
	}
	
	public void click_Meeting_Book_37_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_37_Delete_Option).click();
	}
	
	public void click_Meeting_Book_38_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_38_Delete_Option).click();
	}
	
	public void click_Meeting_Book_39_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_39_Delete_Option).click();
	}
	
	public void click_Meeting_Book_40_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_40_Delete_Option).click();
	}
	
	public void click_Meeting_Book_41_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_41_Delete_Option).click();
	}
	
	public void click_Meeting_Book_42_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meeting_Book_42_Delete_Option).click();
	}
	//-----------------------------------------------------------------
	
	public void verify_Edit_BookBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(40)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(edit_BookBtn)));
	}

	public void verify_Book_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title)));
	}
	
	public void verify_Book_Add_Print_Logo_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Add_Remove_Print_Logo_Dropdown)));
	}

	public void verify_Workroom_Library_Crumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Library_Crumb)));
	}

	public void click_On_Switch() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(onswitch).click();
		Thread.sleep(1000);
	}

	public void click_Workroom_Library_Crumb() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(workroom_Library_Crumb).click();
		Thread.sleep(1000);
	}
	
	//--------------------------------------------------------
	
	public void click_Book_Title() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(book_Title).click();
	}
	
	// --------------Function Being Called-----------------------
	public void make_Book_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		Thread.sleep(1000);
		this.click_Workroom_Library_Crumb();
		System.out.println("------- Completed --> make_Book_Visible()  -----------");
	}
	
	public void make_Book_Visible_2() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		Thread.sleep(1000);
		System.out.println("------- Completed --> make_Book_Visible()  -----------");
	}
	
	public void make_Book_Board_Member_Access_1_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		Thread.sleep(1000);
		this.click_Workroom_Library_Crumb();
		this.verify_Book_Board_Member_Access_1_Visible();
		System.out.println("------- Completed --> make_Book_Board_Member_Access_1_Visible()  -----------");
	}
	
	public void make_Meeting_Book_2_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		Thread.sleep(1000);
		this.click_Workroom_Library_Crumb();
		this.verify_Meeting_Book_2_Dropdown();
		System.out.println("------- Completed --> make_Meeting_Book_2_Visible()  -----------");
	}
	
	public void make_Book_Add_Remove_Print_Logo_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		Thread.sleep(1000);
		this.click_Workroom_Library_Crumb();
		this.verify_Book_Add_Print_Logo_Visible();
		System.out.println("------- Completed --> make_Book_Add_Remove_Print_Logo_Visible()  -----------");
	}
	
	// ------------------ Functions ----------------------
	public void user_navigates_To_Book() throws InterruptedException {
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_New_BookBtn();
		System.out.println("------- Completed --> user_navigates_To_Book() -----------");
	}
	
	// --------------copied/achived/delete_Book-------------------------------
	By book_Dropdown = By.xpath("//a[contains(text(),'This is a Book Title')]/following::div[@class='dropdown header-actions']");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By form = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");
	By archive = By.xpath("//a[contains(.,'Archive')]");
	By archives = By.xpath("//a[@class='btn btn-default'][contains(.,'Archives')]");
	By archived_Books_Heading = By.xpath("//h1[contains(text(),'Visible Archived Books')]");
	By copy_Message = By.xpath("//p[contains(text(),'Successfully");
	
	public void verify_Book_Copy_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(copy_Message)));
	}
	
	public void verify_Archive_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(archive)));
	}
	
	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void verify_Form() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(form)));
	}
	
	public void verify_Archives() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(archives)));
	}
	
	public void verify_Archived_Books_Heading() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(archived_Books_Heading)));
	}
	
	public void verify_Book_Drop_Down() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(book_Dropdown)));
	}

	public void click_Book_Dropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(book_Dropdown).click();
	}

	public void verify_Edited_Book_Title_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Book)));
	}

	public void click_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(delete_Option).click();
	}
	
	
	public void click_Archive_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(archive).click();
	}
	
	public void click_Archives_Btn() throws InterruptedException {
		WebElement save = DriverFactory.getInstance().getDriver().findElement(archives);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", save);
		Thread.sleep(1000);

		DriverFactory.getInstance().getDriver().findElement(archives).click();
	}

	public void click_And_SendKeys() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(form).sendKeys("delete");
	}

	public void click_ContinueBtn() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(continueBtn);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	
	public void delete_Book_On_Staging_Board_Member_Access_1() throws InterruptedException {
		this.verify_Book_Board_Member_Access_1_Visible();
		this.click_Book_Board_Member_Access_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Book_Board_Member_Access_1_Delete_Option();
		this.click_Book_Board_Member_Access_1_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Book_On_Staging_Board_Member_Access_1()  -----------");
	}

	public void delete_Meeting_Book_2() throws InterruptedException {
		this.verify_Meeting_Book_2_Dropdown();
		this.click_Meeting_Book_2_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_2_Delete_Option();
		this.click_Meeting_Book_2_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_2()  -----------");
	}
	
	public void delete_Meeting_Book_3() throws InterruptedException {
		this.verify_Meeting_Book_3_Dropdown();
		this.click_Meeting_Book_3_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_3_Delete_Option();
		this.click_Meeting_Book_3_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_3()  -----------");
	}
	
	public void delete_Meeting_Book_5() throws InterruptedException {
		this.verify_Meeting_Book_5_Dropdown();
		this.click_Meeting_Book_5_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_5_Delete_Option();
		this.click_Meeting_Book_5_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_5()  -----------");
	}
	
	public void delete_Meeting_Book_6() throws InterruptedException {
		this.verify_Meeting_Book_6_Dropdown();
		this.click_Meeting_Book_6_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_6_Delete_Option();
		this.click_Meeting_Book_6_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_6()  -----------");
	}
	
	public void delete_Meeting_Book_7() throws InterruptedException {
		this.verify_Meeting_Book_7_Dropdown();
		this.click_Meeting_Book_7_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_7_Delete_Option();
		this.click_Meeting_Book_7_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_7()  -----------");
	}
	
	public void delete_Meeting_Book_8() throws InterruptedException {
		this.verify_Meeting_Book_8_Dropdown();
		this.click_Meeting_Book_8_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_8_Delete_Option();
		this.click_Meeting_Book_8_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_8()  -----------");
	}
	
	public void delete_Meeting_Book_9() throws InterruptedException {
		this.verify_Meeting_Book_9_Dropdown();
		this.click_Meeting_Book_9_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_9_Delete_Option();
		this.click_Meeting_Book_9_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_9()  -----------");
	}
	
	public void delete_Meeting_Book_10() throws InterruptedException {
		this.verify_Meeting_Book_10_Dropdown();
		this.click_Meeting_Book_10_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_10_Delete_Option();
		this.click_Meeting_Book_10_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_10()  -----------");
	}
	
	public void delete_Meeting_Book_11() throws InterruptedException {
		this.verify_Meeting_Book_11_Dropdown();
		this.click_Meeting_Book_11_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_11_Delete_Option();
		this.click_Meeting_Book_11_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_11()  -----------");
	}
	
	public void delete_Meeting_Book_12() throws InterruptedException {
		this.verify_Meeting_Book_12_Dropdown();
		this.click_Meeting_Book_12_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_12_Delete_Option();
		this.click_Meeting_Book_12_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_12()  -----------");
	}
	
	public void delete_Meeting_Book_13() throws InterruptedException {
		this.verify_Meeting_Book_13_Dropdown();
		this.click_Meeting_Book_13_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_13_Delete_Option();
		this.click_Meeting_Book_13_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_13()  -----------");
	}
	
	public void delete_Meeting_Book_14() throws InterruptedException {
		this.verify_Meeting_Book_14_Dropdown();
		this.click_Meeting_Book_14_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_14_Delete_Option();
		this.click_Meeting_Book_14_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_14()  -----------");
	}
	
	public void delete_Meeting_Book_15() throws InterruptedException {
		this.verify_Meeting_Book_15_Dropdown();
		this.click_Meeting_Book_15_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_15_Delete_Option();
		this.click_Meeting_Book_15_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_15()  -----------");
	}
	
	public void delete_Meeting_Book_16() throws InterruptedException {
		this.verify_Meeting_Book_16_Dropdown();
		this.click_Meeting_Book_16_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_16_Delete_Option();
		this.click_Meeting_Book_16_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_16()  -----------");
	}
	
	public void delete_Meeting_Book_17() throws InterruptedException {
		this.verify_Meeting_Book_17_Dropdown();
		this.click_Meeting_Book_17_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_17_Delete_Option();
		this.click_Meeting_Book_17_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_New_Book();
		System.out.println("------- Completed --> delete_Meeting_Book_17()  -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void archive_Meeting_Book_17() throws InterruptedException {
		this.click_Meeting_Book_17_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_17_Archive_Option();
		this.click_Meeting_Book_17_Archive_Option();
		Thread.sleep(1500);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1500);
		this.verify_Meeting_Book_17_Dropdown();
		System.out.println("------- Completed --> archive_Meeting_Book()  -----------");
	}
	
	public void restore_Meeting_Book_17() throws InterruptedException {
		this.click_Meeting_Book_17_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_17_Restore_Option();
		this.click_Meeting_Book_17_Restore_Option();
		Thread.sleep(1500);
		this.verify_Meeting_Book_17_Dropdown();
		System.out.println("------- Completed --> restore_Meeting_Book()  -----------");
	}
	
	public void archive_Meeting_Book_18() throws InterruptedException {
		this.verify_Meeting_Book_18_Dropdown();
		this.click_Meeting_Book_18_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_18_Archive_Option();
		this.click_Meeting_Book_18_Archive_Option();
		Thread.sleep(1500);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1500);
		this.verify_Meeting_Book_18_Dropdown();
		System.out.println("------- Completed --> delete_Meeting_Book_18()  -----------");
	}
	
	public void copy_Archived_Meeting_Book_18(String meetingbook19) throws InterruptedException {
		this.click_Meeting_Book_18_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_18_Copy_Option();
		this.click_Meeting_Book_18_Copy_Option();
		//-----------
		this.verify_Title_Input_Field();
		this.enter_Book_Title(meetingbook19);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.user_Can_Build_Book();// calling function
		this.make_Book_Visible();// calling function
		Thread.sleep(1000);
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> copy_Archived_Meeting_Book()  -----------");
	}
	
	public void delete_Archive_Meeting_Book_18() throws InterruptedException {
		this.verify_Meeting_Book_18_Dropdown();
		this.click_Meeting_Book_18_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_18_Delete_Option();
		this.click_Meeting_Book_18_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1500);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_18()  -----------");
	}
	
	public void navigate_To_Archived_Books() throws InterruptedException {
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1000);
		this.verify_Archived_Books_Heading();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> navigate_To_Archived_Books()  -----------");
	}
	
	public void delete_Meeting_Book_19() throws InterruptedException {
		this.click_Meeting_Book_19_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_19_Delete_Option();
		this.click_Meeting_Book_19_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> archive_Meeting_Book_19()  -----------");
	}
		
	public void copy_Meeting_Book_20(String meetingbook20) throws InterruptedException {
		this.click_Meeting_Book_20_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_20_Copy_Option();
		this.click_Meeting_Book_20_Copy_Option();
		Thread.sleep(1000);
		this.verify_Title_Input_Field();
		this.enter_Book_Title(meetingbook20);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.user_Can_Build_Book();// calling function
		this.make_Book_Visible();// calling function
		Thread.sleep(1000);
		this.verify_New_Book();
		System.out.println("------- Completed --> copy_Meeting_Book_20()  -----------");
	}
	
	public void delete_Meeting_Book_20() throws InterruptedException {
		this.click_Meeting_Book_20_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_20_Delete_Option();
		this.click_Meeting_Book_20_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_20()  -----------");
	}
	
	public void delete_Meeting_Book_21() throws InterruptedException {
		this.click_Meeting_Book_21_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_21_Delete_Option();
		this.click_Meeting_Book_21_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_2()  -----------");
	}
	
	public void delete_Meeting_Book_22() throws InterruptedException {
		this.verify_Meeting_Book_22_Dropdown();
		this.click_Meeting_Book_22_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_22_Delete_Option();
		this.click_Meeting_Book_22_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_22()  -----------");
	}
	
	public void delete_Meeting_Book_23() throws InterruptedException {
		this.verify_Meeting_Book_23_Dropdown();
		this.click_Meeting_Book_23_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_23_Delete_Option();
		this.click_Meeting_Book_23_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_23()  -----------");
	}
	
	public void delete_Meeting_Book_24() throws InterruptedException {
		this.verify_Meeting_Book_24_Dropdown();
		this.click_Meeting_Book_24_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_24_Delete_Option();
		this.click_Meeting_Book_24_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_24()  -----------");
	}
	
	public void delete_Meeting_Book_25() throws InterruptedException {
		this.verify_Meeting_Book_25_Dropdown();
		this.click_Meeting_Book_25_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_25_Delete_Option();
		this.click_Meeting_Book_25_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_24()  -----------");
	}
	
	public void delete_Meeting_Book_26() throws InterruptedException {
		this.verify_Meeting_Book_26_Dropdown();
		this.click_Meeting_Book_26_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_26_Delete_Option();
		this.click_Meeting_Book_26_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_26()  -----------");
	}
	
	public void delete_Meeting_Book_27() throws InterruptedException {
		this.verify_Meeting_Book_27_Dropdown();
		this.click_Meeting_Book_27_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_27_Delete_Option();
		this.click_Meeting_Book_27_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_27()  -----------");
	}
	
	public void navigate_To_Edit_Status_Book_27() throws InterruptedException {
		this.verify_Meeting_Book_27_Dropdown();
		this.click_Meeting_Book_27_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_27_Edit_Option();
		this.click_Meeting_Book_27_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> navigate_To_Edit_Status_Book_27()  -----------");
	}
	
	public void navigate_To_Edit_Status_Book_28() throws InterruptedException {
		this.verify_Meeting_Book_28_Dropdown();
		this.click_Meeting_Book_28_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_28_Edit_Option();
		this.click_Meeting_Book_28_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> navigate_To_Edit_Status_Book_28()  -----------");
	}
	
	public void navigate_To_Edit_Status_Book_29() throws InterruptedException {
		this.verify_Meeting_Book_29_Dropdown();
		this.click_Meeting_Book_29_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_29_Edit_Option();
		this.click_Meeting_Book_29_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> navigate_To_Edit_Status_Book_29()  -----------");
	}
	
	public void navigate_To_Edit_Status_Book_31() throws InterruptedException {
		this.verify_Meeting_Book_31_Dropdown();
		this.click_Meeting_Book_31_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_31_Edit_Option();
		this.click_Meeting_Book_31_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> navigate_To_Edit_Status_Book_31()  -----------");
	}
	
	public void navigate_To_Edit_Status_Verify_Book_37() throws InterruptedException {
		this.verify_Meeting_Book_37_Dropdown();
		this.click_Meeting_Book_37_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_37_Edit_Option();
		this.click_Meeting_Book_37_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		this.verify_Build_Book();
		DriverFactory.getInstance().getDriver().navigate().refresh();

		System.out.println("------- Completed --> navigate_To_Edit_Status_Verify_Book_37()  -----------");
	}
	
	public void delete_Meeting_Book_28() throws InterruptedException {
		this.verify_Meeting_Book_28_Dropdown();
		this.click_Meeting_Book_28_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_28_Delete_Option();
		this.click_Meeting_Book_28_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_28()  -----------");
	}
	
	public void delete_Meeting_Book_29() throws InterruptedException {
		this.verify_Meeting_Book_29_Dropdown();
		this.click_Meeting_Book_29_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_29_Delete_Option();
		this.click_Meeting_Book_29_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_29()  -----------");
	}
	
	public void delete_Meeting_Book_30() throws InterruptedException {
		this.verify_Meeting_Book_30_Dropdown();
		this.click_Meeting_Book_30_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_30_Delete_Option();
		this.click_Meeting_Book_30_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_30()  -----------");
	}
	
	public void delete_Meeting_Book_31() throws InterruptedException {
		this.verify_Meeting_Book_31_Dropdown();
		this.click_Meeting_Book_31_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_31_Delete_Option();
		this.click_Meeting_Book_31_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_31()  -----------");
	}
	
	public void delete_Edited_Meeting_Book_33() throws InterruptedException {
		this.verify_Meeting_Book_33_Dropdown();
		this.click_Meeting_Book_33_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_33_Delete_Option();
		this.click_Meeting_Book_33_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Edited_Meeting_Book_33()  -----------");
	}
	
	public void delete_Meeting_Book_34() throws InterruptedException {
		this.verify_Meeting_Book_34_Dropdown();
		this.click_Meeting_Book_34_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_34_Delete_Option();
		this.click_Meeting_Book_34_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_34()  -----------");
	}
	
	public void delete_Meeting_Book_35() throws InterruptedException {
		this.verify_Meeting_Book_35_Dropdown();
		this.click_Meeting_Book_35_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_35_Delete_Option();
		this.click_Meeting_Book_35_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_35()  -----------");
	}
	
	public void delete_Meeting_Book_36() throws InterruptedException {
		this.verify_Meeting_Book_36_Dropdown();
		this.click_Meeting_Book_36_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_36_Delete_Option();
		this.click_Meeting_Book_36_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_36()  -----------");
	}
	
	public void delete_Meeting_Book_37() throws InterruptedException {
		this.verify_Meeting_Book_37_Dropdown();
		this.click_Meeting_Book_37_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_37_Delete_Option();
		this.click_Meeting_Book_37_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_37()  -----------");
	}
	
	public void delete_Meeting_Book_38() throws InterruptedException {
		this.verify_Meeting_Book_38_Dropdown();
		this.click_Meeting_Book_38_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_38_Delete_Option();
		this.click_Meeting_Book_38_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_38()  -----------");
	}
	
	public void delete_Meeting_Book_39() throws InterruptedException {
		this.verify_Meeting_Book_39_Dropdown();
		this.click_Meeting_Book_39_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_39_Delete_Option();
		this.click_Meeting_Book_39_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_39()  -----------");
	}
	
	public void delete_Meeting_Book_40() throws InterruptedException {
		this.verify_Meeting_Book_40_Dropdown();
		this.click_Meeting_Book_40_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_40_Delete_Option();
		this.click_Meeting_Book_40_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_40()  -----------");
	}
	
	public void delete_Meeting_Book_41() throws InterruptedException {
		this.verify_Meeting_Book_41_Dropdown();
		this.click_Meeting_Book_41_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_41_Delete_Option();
		this.click_Meeting_Book_41_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_41()  -----------");
	}
	
	
	public void delete_Meeting_Book_42() throws InterruptedException {
		this.verify_Meeting_Book_42_Dropdown();
		this.click_Meeting_Book_42_Dropdown();
		Thread.sleep(1500);
		this.verify_Meeting_Book_42_Delete_Option();
		this.click_Meeting_Book_42_Delete_Option();
		Thread.sleep(1500);
		this.verify_Form();
		this.click_And_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Meeting_Book_42()  -----------");
	}
	
	public void delete_Extra_Books() throws InterruptedException {
		Thread.sleep(2500);

		for (int i = 1; i > 0; i++) {
			  
			By bookDropDown = By.xpath("//*[@class='btn btn-default dropdown-toggle']");
			
			DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Boolean book = DriverFactory.getInstance().getDriver().findElements(bookDropDown).size() > 0;
			DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			System.out.println("answer -> "+book);

			if (book == true) {
				DriverFactory.getInstance().getDriver().findElement(bookDropDown).click();
				Thread.sleep(1500);
				this.verify_Delete_Option();
				this.click_Delete_Option();
				Thread.sleep(1500);
				this.verify_Form();
				this.click_And_SendKeys();
				Thread.sleep(1500);
				this.click_ContinueBtn();
				Thread.sleep(2500);
				DriverFactory.getInstance().getDriver().navigate().refresh();
				this.verify_New_Book();
			}else {
				break;
			}
			
		}
		
		System.out.println("------- Completed --> delete_Extra_Books()  -----------");
	}
	
	
	public void clean_Up_Meeting_Books() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE_Library_Page();
		this.verify_New_Book();
		this.delete_Extra_Books();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> clean_Up_Meeting_Books()  -----------");
	}
	
	public void clean_Up_Meeting_Books_Constellation_WR() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_Constellation_Library_Page();
		this.verify_New_Book();
		this.delete_Extra_Books();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> clean_Up_Meeting_Books_Constellation_WR()  -----------");
	}



	// --------------verify_Book_Deleted -----------------------------
	public void verify_Book_Not_Present() throws InterruptedException {
		String element = "//a[contains(text(),'This is a Book Title')]/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Edited_Book_Not_Present() throws InterruptedException {
		String element = "//a[contains(text(),'This is an Edited Book')]/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Book_Title_On_Staging_1_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Book Board Member Access 1']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_2_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='meeting book 2']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_3_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 3']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_5_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 5']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_6_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 6']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_7_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 7']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_8_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 8']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_9_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 9']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_10_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 10']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_11_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 11']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_12_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 12']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_13_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 13']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_14_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 14']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_15_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 15']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_16_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 16']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_17_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 17']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Archived_Meeting_Book_18_19_VISIBLE() throws InterruptedException {		
		String element = "//*[normalize-space(text())='Meeting Book 18']/following::div[@class='dropdown header-actions']";
		String element2 = "//*[normalize-space(text())='Meeting Book 19']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element2)).size() > 0);
	}
	
	public void verify_Archived_Meeting_Book_18_19_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 18']/following::div[@class='dropdown header-actions']";
		String element2 = "//*[normalize-space(text())='Meeting Book 19']/following::div[@class='dropdown header-actions']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element2)).size() < 1);
	}
	
	public void verify_Meeting_Book_20_21_VISIBLE() throws InterruptedException {		
		String element = "//*[normalize-space(text())='Meeting Book 20']/following::div[@class='dropdown header-actions']";
		String element2 = "//*[normalize-space(text())='Meeting Book 21']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element2)).size() > 0);
	}
	
	public void verify_Meeting_Book_20_21_NOT_VISIBLE() throws InterruptedException {		
		String element = "//*[normalize-space(text())='Meeting Book 20']/following::div[@class='dropdown header-actions']";
		String element2 = "//*[normalize-space(text())='Meeting Book 21']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element2)).size() < 1);
	}
	
	public void verify_Meeting_Book_22_23_NOT_VISIBLE() throws InterruptedException {		
		String element = "//*[normalize-space(text())='Meeting Book 22']/following::div[@class='dropdown header-actions']";
		String element2 = "//*[normalize-space(text())='Meeting Book 23']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element2)).size() < 1);
	}
	
	public void verify_Meeting_Book_24_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 24']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_25_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 25']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_26_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 26']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_27_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 27']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_28_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 2']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_29_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 29']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_30_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 30']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_31_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 31']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_33_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 33']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_34_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 34']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_35_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 35']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_36_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 36']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_37_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 37']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_38_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 38']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_39_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 39']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_40_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 40']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_41_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 41']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_42_NOT_VISIBLE() throws InterruptedException {
		String element = "//*[normalize-space(text())='Meeting Book 42']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Book_Deleted() throws InterruptedException {
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_Edited_Book_Not_Present();
		System.out.println("------- Completed --> verify_Edited_Book_Deleted()  -----------");
	}
	
	// -------------------- user_Create_New_BookTemplate() ---------------------
	By book_Templates = By.xpath("//a[contains(text(),'Book Templates')]");
	By new_Template = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Template')]");

	public void verify_Book_Templates() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Templates)));
	}

	public void verify_New_Template() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Template)));
	}

	public void click_Book_Templates() {
		DriverFactory.getInstance().getDriver().findElement(book_Templates).click();
	}

	public void click_New_Templates() {
		DriverFactory.getInstance().getDriver().findElement(new_Template).click();
	}

	public void enter_Book_Template_Title(String meetingbook6) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(meetingbook6);
		Thread.sleep(1000);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Create_New_BookTemplate(String meetingbook6) throws InterruptedException {
		this.verify_Book_Templates();
		this.click_Book_Templates();
		this.verify_New_Template();
		this.click_New_Templates();
		this.verify_Title_Input_Field();
		this.enter_Book_Template_Title(meetingbook6);
		System.out.println("------- Completed --> user_Create_New_BookTemplate() -----------");
	}
	
	public void navigate_To_BookTemplate() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meetingBook)));
	}

	public void verify_NewBook() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newBook)));
	}
	
	public void verify_Diligent_Minutes_Container() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(diligent_Minutes_Container)));
	}
	
	public void click_Meeting_Book() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(meetingBook).click();
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
		System.out.println("------- Completed --> navigate_To_Meeting_Book_3() -----------");
	}

	
	// ------------------user_Add_Coverpage_To_Book_Template---------------------
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		this.fill_Generate_Cover_Page_Form();
		System.out.println("------- Completed --> user_Add_Coverpage_To_Book_Template() -----------");
	}
	
	// ------------------user_Add_Agenda_To_Template---------------------
	public void verify_Agenda_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
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
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void click_Diligent_Minutes() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(diligent_Minutes).click();
	}
	
	public void admin_CheckBox_Click_Import() throws InterruptedException {
		String admin_CheckBox = "div > article > div > div.table-body > div:nth-child(2) > div:nth-child(1) > dil-checkbox > div > input";
		String import_Btn = "div > footer > div > dil-button:nth-child(3) > button";

		//---click admin check box
		WebElement attachedElement = DriverFactory.getInstance().getDriver().findElement(By.tagName("import-minutes"));
		WebElement shadowRoot1 = (WebElement) ((JavascriptExecutor)DriverFactory.getInstance().getDriver()).executeScript("return arguments[0].shadowRoot", attachedElement);
		WebElement checkBox = shadowRoot1.findElement(By.cssSelector(admin_CheckBox));
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", checkBox);
		Thread.sleep(2000);

		//---click import button
		WebElement shadowRoot2 = (WebElement) ((JavascriptExecutor)DriverFactory.getInstance().getDriver()).executeScript("return arguments[0].shadowRoot", attachedElement);
		WebElement import_ = shadowRoot2.findElement(By.cssSelector(import_Btn));

		JavascriptExecutor executor2 = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor2.executeScript("arguments[0].click();", import_);
		
	}
	
	// ------------------user_Add_File_To_First_Catagory------------------
	public void add_First_Cat_PDF_File() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_File_To_First_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		Thread.sleep(1500);// adding due to app misbehavior 
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(template_Title)));
	}
	
	public void verify_Book_Template_Crumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Template_Title)));
	}

	public void verify_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Option)));
	}

	public void click_Template_Dropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(template_Dropdown).click();
	}

	public void click_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
		Thread.sleep(1000);
	}

	public void edited_Template_Title_SendKeys() throws InterruptedException {
		String handbook_title = "This is an Edited Book Template Title";
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(handbook_title);
		Thread.sleep(1000);
	}

	public void click_Coverpage_Expand() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(expand_Cover_Page).click();
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
		DriverFactory.getInstance().getDriver().findElement(header_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(header_1).clear();
		DriverFactory.getInstance().getDriver().findElement(header_1).sendKeys(Header_1);
		DriverFactory.getInstance().getDriver().findElement(header_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(header_2).clear();
		DriverFactory.getInstance().getDriver().findElement(header_2).sendKeys(Header_2);
		DriverFactory.getInstance().getDriver().findElement(line_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_1).clear();
		DriverFactory.getInstance().getDriver().findElement(line_1).sendKeys(Line_1);
		DriverFactory.getInstance().getDriver().findElement(line_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_2).clear();
		DriverFactory.getInstance().getDriver().findElement(line_2).sendKeys(Line_2);
		DriverFactory.getInstance().getDriver().findElement(line_3).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_3).clear();
		DriverFactory.getInstance().getDriver().findElement(line_3).sendKeys(Line_3);
		DriverFactory.getInstance().getDriver().findElement(line_4).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_4).clear();
		DriverFactory.getInstance().getDriver().findElement(line_4).sendKeys(Line_4);
		DriverFactory.getInstance().getDriver().findElement(line_5).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_5).clear();
		DriverFactory.getInstance().getDriver().findElement(line_5).sendKeys(Line_5);
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
		DriverFactory.getInstance().getDriver().findElement(header_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(header_1).clear();
		DriverFactory.getInstance().getDriver().findElement(header_1).sendKeys(Header_1);
		DriverFactory.getInstance().getDriver().findElement(header_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(header_2).clear();
		DriverFactory.getInstance().getDriver().findElement(header_2).sendKeys(Header_2);
		DriverFactory.getInstance().getDriver().findElement(line_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_1).clear();
		DriverFactory.getInstance().getDriver().findElement(line_1).sendKeys(Line_1);
		DriverFactory.getInstance().getDriver().findElement(line_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_2).clear();
		DriverFactory.getInstance().getDriver().findElement(line_2).sendKeys(Line_2);
		DriverFactory.getInstance().getDriver().findElement(line_3).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_3).clear();
		DriverFactory.getInstance().getDriver().findElement(line_3).sendKeys(Line_3);
		DriverFactory.getInstance().getDriver().findElement(line_4).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_4).clear();
		DriverFactory.getInstance().getDriver().findElement(line_4).sendKeys(Line_4);
		DriverFactory.getInstance().getDriver().findElement(line_5).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(line_5).clear();
		DriverFactory.getInstance().getDriver().findElement(line_5).sendKeys(Line_5);
	}

	public void click_Preview_Left() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(preview_Left).click();
		Thread.sleep(1000);
	}

	public void scroll_To_SaveBtn() throws InterruptedException {
		WebElement save = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@class='primary-action-btn']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", save);
	}

	public void click_Coverpage_CheckBox() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(coverpage_CheckBox).click();
		Thread.sleep(1000);
	}

	public void click_Agenda_CheckBox() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(agenda_CheckBox).click();
		Thread.sleep(1000);
	}

	public void click_SaveBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_SaveBtn).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_To_Drpdwn)));
	}
	
	public void verify_Auto_Attend() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Attend)));
	}
	
	public void verify_Auto_Attend_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(Auto_Attend_Breadcrumb)));
	}
	
	public void verify_Move_Here() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(move_Here)));
	}
	
	public void verify_Continue_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(continueBtn)));
	}
	
	public void verify_Invisibility_Of_Continue_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOfElementLocated(continueBtn)));
	}
	
	public void verify_Workroom_Template_Move() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(Auto_Attend_Breadcrumb)));
	}

	public void click_Book_Template_Title() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(template_Title).click();
	}
	
	public void click_Move_To_Drpdwn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(move_To_Drpdwn).click();
	}
	
	public void click_Auto_Attend() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(auto_Attend).click();
	}
	
	public void click_Move_Here() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(move_Here).click();
	}
	
	public void click_Book_Template_Crumb() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(Book_Template_Crumb).click();
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
	
	public void move_Book_36_Tempate_To_New_Workroom() throws InterruptedException {
		this.click_Meeting_Book_36_Title();
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
		System.out.println("------- Completed --> move_Book_36_Tempate_To_New_Workroom()  -----------");
	}
	
	// ------------------ Function Being called- -----------------------------------
	public void verify_Workroom_Move() throws InterruptedException {
		this.verify_Workroom_Template_Move();
		this.click_Book_Template_Crumb();
		Thread.sleep(1000);
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(adv_Settings)));
	}
	
	public void verify_All_Workrooms_And_Scroll() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(all_Workrooms)));
		
		WebElement adv_Settings = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'All Workrooms')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", adv_Settings);
	}
	
	public void verify_Save_Continue_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(save_Continue_Btn)));
	}
	
	public void verify_Save_Continue_Btn_NOT_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(save_Continue_Btn)));
	}
	
	public void verify_Logo_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(logo_Label)));
	}
	
	public void verify_View_Only_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(view_Only)));
	}

	public void verify_Contributor_Email_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(contributor_Email_Field)));
	}
	
	public void enter_Conributor_Email() throws InterruptedException {
		String email = "jhofler@diligent.com";
		DriverFactory.getInstance().getDriver().findElement(contributor_Email_Field).sendKeys(email);
	}
	
	public void click_View_Only() throws InterruptedException {
		String viewOnly = "//input[@id='book_disable_print']";
		WebElement viewonly = DriverFactory.getInstance().getDriver().findElement(By.xpath(viewOnly));
		
		if(!viewonly.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", viewonly);
		}	
	}
//---------------------------------------------------------------	
	
	public void click_Watermark() throws InterruptedException {
		String element = "//input[@id='book_watermark']";
		WebElement watermark = DriverFactory.getInstance().getDriver().findElement(By.xpath(element));
		
		if(!watermark.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", watermark);
		}	
	}

	public void verify_Watermark_Checked() throws InterruptedException {
		String element = "//input[@id='book_watermark']";
		WebElement watermark = DriverFactory.getInstance().getDriver().findElement(By.xpath(element));
		
		Assert.assertEquals(watermark.isSelected(),true);
	}
	
//---------------------------------------------------------------	
	
	public void click_Preserve_Bookmarks() throws InterruptedException {
		String element = "//input[@id='book_preserve_bookmarks']";
		WebElement bookmark = DriverFactory.getInstance().getDriver().findElement(By.xpath(element));
		
		if(!bookmark.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", bookmark);
		}	
	}
	
	public void verify_Preserve_Bookmarks_Checked() throws InterruptedException {
		String element = "//input[@id='book_preserve_bookmarks']";
		WebElement bookmark = DriverFactory.getInstance().getDriver().findElement(By.xpath(element));
		
		Assert.assertEquals(bookmark.isSelected(),true);
	}
	
//-----------------------------------------------------------------
	
	public void click_Include_Orginal_Bookmarks() throws InterruptedException {
		String element = "//input[@id='book_show_original']";
		WebElement bookmark = DriverFactory.getInstance().getDriver().findElement(By.xpath(element));
		
		if(!bookmark.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", bookmark);
		}	
	}
	
	public void verify_Include_Orginal_Files_Enabled() throws InterruptedException {
		String element = "//input[@id='book_show_original']";
		WebElement bookmark = DriverFactory.getInstance().getDriver().findElement(By.xpath(element));
		
		Assert.assertEquals(bookmark.isSelected(),true);
	}
	
//---------------------------------------------------------------
	
	public void click_Adv_Settings() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(adv_Settings).click();
	}
	
	public void click_Box_Adv_Settings() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(box_Adv_Settings).click();
	}
	
	public void click_SaveBtn_AS() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(saveBtn_AS).click();
	}
	
	public void click_Save_Contnue_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(save_Continue_Btn).click();
	}
	
	public void click_Autto_Attend_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(Auto_Attend_Breadcrumb).click();
	}
	
	public void verify_Book_Template_Shared_AutoBE() throws InterruptedException {
		String template = "//div[@class='no-mobile pull-right'][contains(text(),'Shared from AutoBE ')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(template)).size() > 0);
	}
	
	
	public void scroll_To_Logo() throws InterruptedException {
		WebElement save = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id='advanced_settings']//div//label[contains(.,'Logo')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", save);
	}
	
	public void add_BT_Logo_Image() {
		String input = "//input[@id='book_print_logo']";
		String filepath = "C:\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void verify_BT_Logo_Image_Present() throws InterruptedException {
		String sisco = "//*[@id='advanced_settings']//img";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(sisco)).size() > 0);
	}
	
	// ------------------ Function Being called- -----------------------------------
	public void share_Book_Tempate_All_Workrooms() throws InterruptedException {
//		this.click_Book_Template_Title();
//		Thread.sleep(1000);
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_Adv_Settings();
		this.click_Adv_Settings();
		Thread.sleep(1000);
		this.verify_Logo_Label();
		this.scroll_To_Logo();
		Thread.sleep(1000);
		this.verify_BT_Logo_Image_Present();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_Book_Template_Crumb();
		this.click_Book_Template_Crumb();
		System.out.println("------- Completed --> verify_Logo_To_Book_Template_Added()  -----------");
	}
	
	
	// ------------------ Function Being called- -----------------------------------
	public void verify_Book_39_Template_Shared() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoAttend_Library_Page();
		this.verify_Book_Templates();
		this.click_Book_Templates();
		Thread.sleep(1000);
		this.verify_New_Template();
		this.verify_Book_Template_Shared_AutoBE();
		this.click_Meeting_Book_39_Title();
		System.out.println("------- Completed --> verify_Book_39_Template_Shared()  -----------");
	}
	
	public void navigate_Back_To_AutoBE_Library() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Library_Page();
		this.verify_Book_Templates();
		this.click_Book_Templates();
		Thread.sleep(1000);
		System.out.println("------- Completed --> navigate_Back_To_AutoBE_Library()  -----------");
	}
	
	
	// ------------------ delete_Book_Template -----------------------------------
	By delete = By.xpath("//a[contains(text(),'Delete')]");
	By form_Input_field = By.xpath("//div[@class='modal-body']//input[@class='form-control']");

	public void verify_Form_Input_field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(form_Input_field)));
	}

	public void click_Delete() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(delete).click();
		Thread.sleep(1000);
	}

	public void click_Form_Input_SendKeys() throws InterruptedException {
		String delete = "delete";
		DriverFactory.getInstance().getDriver().findElement(form_Input_field).sendKeys(delete);
		Thread.sleep(1000);
	}
	
	// ------------------user_Can_Create_New_Handbook() ---------------------
	By handbooks = By.xpath("//a[contains(text(),'Handbooks')]");
	By new_Handbooks = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Handbook')]");
	By top_Save_Btn = By.xpath("//a[@id='save_and_close']");

	public void verify_Handbooks() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbooks)));
	}

	public void verify_New_Handbooks() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_Handbooks)));
	}

	public void verify_Title_Form_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Form_Field)));
	}

	public void click_Handbooks() {
		DriverFactory.getInstance().getDriver().findElement(handbooks).click();
	}

	public void click_New_Handbooks() {
		DriverFactory.getInstance().getDriver().findElement(new_Handbooks).click();
	}

	public void Enter_Handbook_Title(String handbook1) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(handbook1);
		// DriverFactory.getInstance().getDriver().findElement(top_Save_Btn).click();
		Thread.sleep(1000);
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Handbook(String handbook1) throws InterruptedException {
		this.verify_Handbooks();
		this.click_Handbooks();
		this.verify_New_Handbooks();
		this.click_New_Handbooks();
		this.verify_Title_Form_Field();
		this.Enter_Handbook_Title(handbook1);
		System.out.println("------- Completed --> user_Create_New_Handbook() -----------");
	}
	
	// --------------------------user_Save_HandBook-----------------------------------
	By handbook_Created_Message = By.xpath("//div//p[contains(text(),'Successfully')]");

	public void verify_Handbook_Created_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
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
	By handbook_8_Title = By.xpath("//*[normalize-space(text())='Hand Book 8']");

	public void verify_Handbook_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Visible)));
	}
	
	public void verify_Handbook_8_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_8_Title)));
	}
	
	public void verify_Handbook_Crumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Crumb)));
	}

	public void click_Handbook_Crumb() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_Crumb).click();
		Thread.sleep(1000);
	}
	
	public void click_Handbook_8_Title() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_8_Title).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void make_Handbook_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		this.click_Handbook_Crumb();
		Thread.sleep(1000);
		this.verify_New_Handbooks();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		System.out.println("------- Completed --> verify_Handbook_Workroom_Move()  -----------");
	}
		
	// -----------Edit Handbook-----------------
	By handbook_1_Dropdown = By.xpath("//*[normalize-space(text())='Hand Book 1']/following::div[@class='dropdown header-actions']");
	By handbook_1_Delete_Option = By.xpath("//*[normalize-space(text())='Hand Book 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	By handbook_1_Archive_Option = By.xpath("//*[normalize-space(text())='Hand Book 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Archive')]");
	By handbook_1_Edit_Option = By.xpath("//*[normalize-space(text())='Hand Book 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Edit')]");
	By handbook_1_Restore_Option = By.xpath("//*[normalize-space(text())='Hand Book 1']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Restore')]");

	By handbook_2_Dropdown = By.xpath("//*[normalize-space(text())='Hand Book 2']/following::div[@class='dropdown header-actions']");
	By handbook_2_Delete_Option = By.xpath("//*[normalize-space(text())='Hand Book 2']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By handbook_3_Dropdown = By.xpath("//*[normalize-space(text())='Hand Book 3']/following::div[@class='dropdown header-actions']");
	By handbook_3_Copy_Option = By.xpath("//*[normalize-space(text())='Hand Book 3']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Copy')]");
	By handbook_3_Delete_Option = By.xpath("//*[normalize-space(text())='Hand Book 3']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By handbook_4_Dropdown = By.xpath("//*[normalize-space(text())='Hand Book 4']/following::div[@class='dropdown header-actions']");
	By handbook_4_Delete_Option = By.xpath("//*[normalize-space(text())='Hand Book 4']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By handbook_5_Dropdown = By.xpath("//*[normalize-space(text())='Hand Book 5']/following::div[@class='dropdown header-actions']");
	By handbook_5_Copy_To_Template_Option = By.xpath("//*[normalize-space(text())='Hand Book 5']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Copy to Template')]");
	By handbook_5_Delete_Option = By.xpath("//*[normalize-space(text())='Hand Book 5']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By handbook_6_Dropdown = By.xpath("//*[normalize-space(text())='Hand Book 6']/following::div[@class='dropdown header-actions']");
	By handbook_6_Delete_Option = By.xpath("//*[normalize-space(text())='Hand Book 6']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	By handbook_7_Dropdown = By.xpath("//*[normalize-space(text())='Hand Book 7']/following::div[@class='dropdown header-actions']");
	By handbook_7_Delete_Option = By.xpath("//*[normalize-space(text())='Hand Book 7']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	By handbook_8_Dropdown = By.xpath("//*[normalize-space(text())='Hand Book 8']/following::div[@class='dropdown header-actions']");
	By handbook_8_Delete_Option = By.xpath("//*[normalize-space(text())='Hand Book 8']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");

	By handbook_9_Dropdown = By.xpath("//*[normalize-space(text())='Hand Book 9']/following::div[@class='dropdown header-actions']");
	By handbook_9_Delete_Option = By.xpath("//*[normalize-space(text())='Hand Book 9']/following::div[@class='dropdown header-actions open']//child::a[contains(text(),'Delete')]");
	
	By edit_option = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Edit')]");
	By restore_Option = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Restore')]");
	
	public void verify_Edited_Handbook_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Handbook_Visible)));
	}

	public void click_Edit_Book_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(edit_BookBtn).click();
		Thread.sleep(1000);
	}

	public void edited_Handbook_Title_SendKeys() throws InterruptedException {
		String handbook_title = "This is an Edited Handbook";
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(handbook_title);
		// DriverFactory.getInstance().getDriver().findElement(top_Save_Btn).click();
		Thread.sleep(1000);
	}
	
	public void edited_Book_Title_SendKeys(String meetingbook33) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(title_Form_Field).sendKeys(meetingbook33);
	}
	
	public void verify_Handbook_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_1_Dropdown)));
	}
	
	public void verify_Handbook_1_Archive_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(archive)));
	}
	
	public void verify_Hand_Book_1_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_1_Edit_Option)));
	}
	
	public void verify_Handbook_1_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_1_Delete_Option)));
	}
	
	public void verify_Handbook_2_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_2_Delete_Option)));
	}
	
	public void verify_Handbook_3_Copy_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_3_Copy_Option)));
	}
	
	public void verify_Handbook_3_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_3_Delete_Option)));
	}
	
	public void verify_Handbook_4_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_4_Delete_Option)));
	}
	
	public void verify_Handbook_5_Copy_To_Template_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_5_Copy_To_Template_Option)));
	}
	
	public void verify_Handbook_5_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_5_Delete_Option)));
	}
	
	public void verify_Handbook_6_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_6_Delete_Option)));
	}
	
	public void verify_Handbook_7_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_7_Dropdown)));
	}
	
	public void verify_Handbook_7_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_7_Delete_Option)));
	}
	
	public void verify_Handbook_8_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_8_Dropdown)));
	}
	
	public void verify_Handbook_8_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_8_Delete_Option)));
	}
	
	public void verify_Handbook_9_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_9_Dropdown)));
	}
	
	public void verify_Handbook_9_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_9_Delete_Option)));
	}
	
	public void click_Handbook_1_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(handbook_1_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(handbook_1_Dropdown).click();
	}
	
	public void click_Handbook_2_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(handbook_2_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(handbook_2_Dropdown).click();
	}
	
	public void click_Handbook_3_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(handbook_3_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(handbook_3_Dropdown).click();
	}
	
	public void click_Handbook_4_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(handbook_4_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(handbook_4_Dropdown).click();
	}
	
	public void click_Handbook_5_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(handbook_5_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(handbook_5_Dropdown).click();
	}
	
	public void click_Handbook_6_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(handbook_6_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(handbook_6_Dropdown).click();
	}
	
	public void click_Handbook_7_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(handbook_7_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(handbook_7_Dropdown).click();
	}
	
	public void click_Handbook_8_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(handbook_8_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(handbook_8_Dropdown).click();
	}
	
	public void click_Handbook_9_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(handbook_9_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(handbook_9_Dropdown).click();
	}
	
	public void click_Handbook_1_Archive_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_1_Archive_Option).click();
	}
	
	public void click_Handbook_1_Restore_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_1_Restore_Option).click();
	}
	
	public void click_Handbook_1_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_1_Delete_Option).click();
	}
	
	public void click_Handbook_2_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_2_Delete_Option).click();
	}
	
	public void click_Handbook_3_Copy_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_3_Copy_Option).click();
	}
	
	public void click_Handbook_3_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_3_Delete_Option).click();
	}
	
	public void click_Handbook_4_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_4_Delete_Option).click();
	}
	
	public void click_Handbook_5_Copy_To_Template_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_5_Copy_To_Template_Option).click();
	}

	public void click_Handbook_5_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_5_Delete_Option).click();
	}
	
	public void click_Handbook_6_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_6_Delete_Option).click();
	}
	
	public void click_Handbook_7_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_7_Delete_Option).click();
	}
	
	public void click_Handbook_8_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_8_Delete_Option).click();
	}
	
	public void click_Handbook_9_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_9_Delete_Option).click();
	}

	
	// --------------Function Being Called ---------------------------
	public void edit_Handbook() throws InterruptedException {
		this.click_Handbook_1_Dropdown();
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
	
	public void edit_Meeting_Book_32(String meetingbook33) throws InterruptedException {
		this.verify_Meeting_Book_32_Dropdown();
		this.click_Meeting_Book_32_Dropdown();
		Thread.sleep(1000);
		this.verify_Meeting_Book_32_Edit_Option();
		this.click_Meeting_Book_32_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		this.verify_Title_Form_Field();
		this.edited_Book_Title_SendKeys(meetingbook33);
		this.click_Coverpage_Expand();
		Thread.sleep(2500);
		this.edit_Generate_Cover_Page_Form_2();
		Thread.sleep(1000);
		this.scroll_To_SaveBtn();
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Build_Book();
		this.click_Build_Book();
		Thread.sleep(1000);
		this.verify_Build_DoneBtn();
		this.click_Build_DoneBtn();
		Thread.sleep(1000);
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		System.out.println("------- Completed --> edit_Meeting_Book_31()  -----------");
	}
	
	// ---------------copy_Handbook---------------------------------
	By copy = By.xpath("//li[3]//a[1][contains(., 'Copy')]");
	By handbook_Copy_BreadCrumb = By.xpath("//li[@class='active'][contains(., 'Edit This is a Handbook - Copy')]");
	By handbook_Copy = By.xpath("//*[contains(text(),'This is a Handbook - Copy')]");
	By copy_To_Template = By.xpath("//a[contains(text(),'Copy to Template')]");

	public void verify_Handbook_Copy_Crumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Copy_BreadCrumb)));
	}
	
	public void verify_Handbook_Copy() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Copy)));
	}
	
	public void click_Copy() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(copy).click();
	}
	
	public void click_Copy_To_Template() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(copy_To_Template).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void copy_Handbook_3(String handbook4) throws InterruptedException {
		this.click_Handbook_3_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_3_Copy_Option();
		this.click_Handbook_3_Copy_Option();
		Thread.sleep(1000);
		this.verify_Title_Input_Field();
		this.enter_Book_Title(handbook4);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.user_Can_Build_Book();// calling function
		this.make_Handbook_Visible();// calling function
		Thread.sleep(1000);
		System.out.println("------- Completed --> copy_Handbook_3()  -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void copy_Handbook_5_To_Template(String handbook6) throws InterruptedException {
		this.click_Handbook_5_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_5_Copy_To_Template_Option();
		this.click_Handbook_5_Copy_To_Template_Option();
		Thread.sleep(1000);
		this.verify_Title_Input_Field();
		this.enter_Book_Title(handbook6);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Handbook_Crumb();
		this.click_Handbook_Crumb();
		Thread.sleep(1000);
		this.verify_New_Handbooks();
		System.out.println("------- Completed --> copy_Handbook_5_To_Template()  -----------");
	}
	
	public void copy_Meetings_Book_22_To_Template(String meetingbook23) throws InterruptedException {
		this.verify_Meeting_Book_22_Dropdown();
		this.click_Meeting_Book_22_Dropdown();
		Thread.sleep(1000);
		this.click_Meeting_Book_22_Copy_Option();
		Thread.sleep(1000);
		this.verify_Title_Input_Field();
		this.enter_Book_Title(meetingbook23);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.user_Can_Build_Book();// calling function
		this.make_Book_Visible();// calling function
		this.verify_New_Book();
		Thread.sleep(1000);
		System.out.println("------- Completed --> copy_Meetings_Book_21_To_Template()  -----------");
	}

	public void archive_Handbook_1() throws InterruptedException {
		this.verify_Handbook_1_Dropdown();
		this.click_Handbook_1_Dropdown();
		Thread.sleep(1500);
		this.verify_Handbook_1_Archive_Option();
		this.click_Handbook_1_Archive_Option();
		Thread.sleep(1500);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1500);
		this.verify_Handbook_1_Dropdown();
		System.out.println("------- Completed --> archive_Handbook()  -----------");
	}
	
	public void restore_Handbook() throws InterruptedException {
		this.verify_Handbook_1_Dropdown();
		this.click_Handbook_1_Dropdown();
		Thread.sleep(1500);
		this.verify_Hand_Book_1_Edit_Option();
		this.click_Handbook_1_Restore_Option();
		Thread.sleep(1500);
		this.verify_Handbook_1_Dropdown();
		System.out.println("------- Completed --> restore_Handbook()  -----------");
	}
	
	public void view_Handbook_In_Meeting_Book_Viewer() throws InterruptedException {
		this.click_Handbook_1_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		this.click_Meeting_Book_17_Restore_Option();
		Thread.sleep(1500);
		this.verify_Handbook_Visible();
		System.out.println("------- Completed --> view_Handbook_In_Meeting_Book_Viewer()  -----------");
	}
		
	// ---------------delete_Handbook---------------------------------
	// --------------Function Being Called ---------------------------
	
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
	
	public void delete_Handbook_1() throws InterruptedException {
		this.click_Handbook_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_1_Delete_Option();
		this.click_Handbook_1_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> delete_Handbook_1()  -----------");
	}
	
	public void delete_Handbook_2() throws InterruptedException {
		this.click_Handbook_2_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_2_Delete_Option();
		this.click_Handbook_2_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> delete_Handbook_2()  -----------");
	}
	
	public void delete_Handbook_3() throws InterruptedException {
		this.click_Handbook_3_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_3_Delete_Option();
		this.click_Handbook_3_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Handbook_Copy()  -----------");
	}
	
	public void delete_Handbook_4() throws InterruptedException {
		this.click_Handbook_4_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_4_Delete_Option();
		this.click_Handbook_4_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Handbook_4()  -----------");
	}
	
	public void delete_Handbook_5() throws InterruptedException {
		this.click_Handbook_5_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_5_Delete_Option();
		this.click_Handbook_5_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Handbook_5()  -----------");
	}
	
	public void delete_Handbook_6() throws InterruptedException {
		this.click_Handbook_6_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_6_Delete_Option();
		this.click_Handbook_6_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Handbook_6()  -----------");
	}
	
	public void delete_Handbook_7() throws InterruptedException {
		this.click_Handbook_7_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_7_Delete_Option();
		this.click_Handbook_7_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	public void delete_Handbook_8() throws InterruptedException {
		this.click_Handbook_8_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_8_Delete_Option();
		this.click_Handbook_8_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	public void delete_Handbook_9() throws InterruptedException {
		this.click_Handbook_9_Dropdown();
		Thread.sleep(1000);
		this.verify_Handbook_9_Delete_Option();
		this.click_Handbook_9_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	public void verify_Handbook_1_NOT_Visible() throws InterruptedException {
		String handbook = "//*[normalize-space(text())='Hand Book 1']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook)).size() < 1);
	}
	
	public void verify_Handbook_2_NOT_Visible() throws InterruptedException {
		String handbook = "//*[normalize-space(text())='Hand Book 2']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook)).size() < 1);
	}
	
	public void verify_Handbook_3_4_NOT_Visible() throws InterruptedException {
		String handbook3 = "//*[normalize-space(text())='Hand Book 3']/following::div[@class='dropdown header-actions']";
		String handbook4 = "//*[normalize-space(text())='Hand Book 4']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook3)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook4)).size() < 1);
	}
	
	public void verify_Handbook_5_6_Visible() throws InterruptedException {
		String handbook5 = "//*[normalize-space(text())='Hand Book 5']/following::div[@class='dropdown header-actions']";
		String handbook6 = "//*[normalize-space(text())='Hand Book 6']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook5)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook6)).size() > 0);
	}
	
	public void verify_Handbook_5_6_NOT_Visible() throws InterruptedException {
		String handbook5 = "//*[normalize-space(text())='Hand Book 5']/following::div[@class='dropdown header-actions']";
		String handbook6 = "//*[normalize-space(text())='Hand Book 6']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook5)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook6)).size() < 1);
	}
	
	public void verify_Handbook_7_NOT_Visible() throws InterruptedException {
		String handbook = "//*[normalize-space(text())='Hand Book 7']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook)).size() < 1);
	}
	
	public void verify_Handbook_8_NOT_Visible() throws InterruptedException {
		String handbook = "//*[normalize-space(text())='Hand Book 8']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook)).size() < 1);
	}
	
	public void verify_Handbook_9_NOT_Visible() throws InterruptedException {
		String handbook = "//*[normalize-space(text())='Hand Book 9']/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(handbook)).size() < 1);
	}

	public void verify_Handbook_Deleted() throws InterruptedException {
		Thread.sleep(4000);
		this.click_Handbook_Crumb();
		this.verify_New_Handbooks();
		this.verify_Handbook_1_NOT_Visible();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(advanced_Search_Modal)));
	}

	public void verify_Advanced_Search() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(advanced_Search)));
	}
	
	public void verify_Alphabetical_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(alphabetical_Btn)));
	}
	
	public void verify_Book_Title_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title_Box)));
	}
	
	public void click_Advanced_Search() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(advanced_Search).click();
	}
	
	public void click_Alphabetical_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(alphabetical_Btn).click();
	}
	
	public void click_Radio_Descending() {
		String radioDesc = "//input[@id='book_sort_desc']";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(radioDesc));
		if(!element.isSelected()) {
			DriverFactory.getInstance().getDriver().findElement(By.xpath(radioDesc)).click();
		}
	}
	
	public void click_Radio_Ascending() {
		String radioDesc = "//input[@id='book_sort_asc']";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(radioDesc));
		if(!element.isSelected()) {
			DriverFactory.getInstance().getDriver().findElement(By.xpath(radioDesc)).click();
		}
	}
	
	public void click_Submit_Adv_Se() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(submit_Adv_Se).click();
	}
	
	public void verify_Book_Position_Descending_Order() throws InterruptedException {
		String bookB_Following_BookA = "//h3//a[normalize-space(text())='This is a Book Title B']/following::a[normalize-space(text())='This is a Book Title A']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookB_Following_BookA)).size() > 0);
	}
	
	public void verify_Book_Position_Accending_Order() throws InterruptedException {
		String bookB_Following_BookA = "//h3//a[normalize-space(text())='This is a Book Title A']/following::a[normalize-space(text())='This is a Book Title B']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookB_Following_BookA)).size() > 0);
	}
	
	public void verify_Only_Book_Title_A_Present() throws InterruptedException {
		String bookA = "//h3//a[normalize-space(text())='This is a Book Title A']";
		String bookB = "//h3//a[normalize-space(text())='This is a Book Title B']";
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookA)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookB)).size() < 1);
	}
	
	public void verify_Only_Book_Title_B_Present() throws InterruptedException {
		String bookB = "//h3//a[normalize-space(text())='This is a Book Title B']";
		String bookA = "//h3//a[normalize-space(text())='This is a Book Title A']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookB)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookA)).size() < 1);
	}
	
	public void type_Book_Title_A() throws InterruptedException {
		String title = "This is a Book Title A";
		DriverFactory.getInstance().getDriver().findElement(book_Title_Box).clear();
		DriverFactory.getInstance().getDriver().findElement(book_Title_Box).sendKeys(title);
	}

	public void type_Book_Title_B() throws InterruptedException {
		String title = "This is a Book Title B";
		DriverFactory.getInstance().getDriver().findElement(book_Title_Box).clear();
		DriverFactory.getInstance().getDriver().findElement(book_Title_Box).sendKeys(title);
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().findElement(created_Btn).click();
	}
	
	public void type_Created_After_Date() throws InterruptedException {
		String date = "2021-02-02";
		DriverFactory.getInstance().getDriver().findElement(created_After_Date_Input).sendKeys(date);
	}
	
	public void type_Created_Before_Date() throws InterruptedException {
		String date = "2021-02-04";
		DriverFactory.getInstance().getDriver().findElement(created_Before_Date_Input).sendKeys(date);
	}
	
	public void verify_Only_Book_Titles_B_A_Present() throws InterruptedException {
		String bookB = "//h3//a[normalize-space(text())='This is a Book Title B']";
		String bookA = "//h3//a[normalize-space(text())='This is a Book Title A']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookB)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookA)).size() > 0);
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
		DriverFactory.getInstance().getDriver().findElement(event_Date_Btn).click();
	}
	
	public void type_Event_Date_After() throws InterruptedException {
		String date = "2021-02-07";
		DriverFactory.getInstance().getDriver().findElement(event_Date_After).sendKeys(date);
	}
	
	public void type_Event_Date_Before() throws InterruptedException {
		String date = "2021-02-09";
		DriverFactory.getInstance().getDriver().findElement(event_Date_Before).sendKeys(date);
	}
	
	public void verify_Only_Book_A_With_Event_Present() throws InterruptedException {
		String bookA = "//h3//a[normalize-space(text())='This is a Book Title A']";
		String event = "//a[contains(text(),'This is a New Event Title')]";
		String bookB = "//h3//a[normalize-space(text())='This is a Book Title B']";
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookA)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookB)).size() < 1);
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
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(visibleFlag));
		if(!element.isSelected()) {
			DriverFactory.getInstance().getDriver().findElement(By.xpath(visibleFlag)).click();
		}
	}
	
	public void verify_Only_Books_E_And_F_Visible() throws InterruptedException {
		String bookC = "//h3//a[normalize-space(text())='This is a Book Title C']";
		String bookD = "//h3//a[normalize-space(text())='This is a Book Title D']";
		String bookE = "//h3//a[normalize-space(text())='This is a Book Title E']";
		String bookF = "//h3//a[normalize-space(text())='This is a Book Title F']";
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookC)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookD)).size() < 1);

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookE)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookF)).size() > 0);
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
		DriverFactory.getInstance().getDriver().findElement(last_Published).click();
	}
	
	public void verify_Book_Published_Order_E_Then_F_Then_C_Then_D() throws InterruptedException {
		// last published: is by last published date & time
		String bookE_Following_BookF = "//h3//a[normalize-space(text())='This is a Book Title E']/following::a[normalize-space(text())='This is a Book Title F']";
		String bookC_Following_BookD = "//h3//a[normalize-space(text())='This is a Book Title C']/following::a[normalize-space(text())='This is a Book Title D']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookE_Following_BookF)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(bookC_Following_BookD)).size() > 0);

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
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(archivedFlag));
		if(!element.isSelected()) {
			DriverFactory.getInstance().getDriver().findElement(By.xpath(archivedFlag)).click();
		}
	}
	
	public void verify_Book_Achived_Book_Visible() throws InterruptedException {
		// last published: is by last published date & time
		String archivedBook = "//h3//a[normalize-space(text())='This is a Archived Book']/following::button[@class='btn btn-default dropdown-toggle']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(archivedBook)).size() > 0);
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
	
	