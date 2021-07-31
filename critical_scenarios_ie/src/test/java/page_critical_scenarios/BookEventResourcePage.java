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

public class BookEventResourcePage {
	WebDriver driver;

	public BookEventResourcePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// ----------- POM Page Object model -----------------------------
	// -----------workroom_Admin_Not_See_Event_Due_To_Permissions--------
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

	// --------------Function Being Called-------------------------------
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
	
	// -------------user_Can_Create_New_Book_And_Title------------------------
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

	// --------------Function Being Called-------------------------------
	public void user_Can_Create_New_Book_And_Add_Title() throws InterruptedException {
		this.click_New_Book();
		this.verify_Title_Input_Field();
		this.enter_Book_Title();
		System.out.println("------- Completed --> user_Can_Create_New_Book_And_Add_Title() -----------");
	}
	
	// ------------------user_Can_Add_Cover_Page---------------------------------
	// ------------------user_Add_Coverpage_To_Book_Template---------------------
	// ------------------generate coverpage------
	By header_1 = By.xpath("//input[@id='book_cover_h1']");
	By header_2 = By.xpath("//input[@id='book_cover_h2']");
	By date = By.xpath("//input[@id='book_cover_date']");
	By line_1 = By.xpath("//input[@id='book_cover_line1']");
	By line_2 = By.xpath("//input[@id='book_cover_line2']");
	By line_3 = By.xpath("//input[@id='book_cover_line3']");
	By line_4 = By.xpath("//input[@id='book_cover_line4']");
	By line_5 = By.xpath("//input[@id='book_cover_line5']");

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
		WebElement save = driver.findElement(By.xpath("//*[@id=\"new_book\"]/div[3]/div[3]/p/button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		Thread.sleep(2000);
	}

	// --------------Function Being Called-------------------------------
	public void user_Can_Add_Cover_Page() throws InterruptedException {
		this.fill_Generate_Cover_Page_Form();
		System.out.println("------- Completed --> user_Can_Add_Cover_Page() -----------");
	}
	
	// ---------------------------------user_Can_Add_Agenda---------------------------------------------
	By agenda_Title = By.xpath("//input[@id='agenda_title']");

	public void enter_Agenda_Title() throws InterruptedException {
		String agenda_title = "This is an Agenda";
		driver.findElement(agenda_Title).sendKeys(agenda_title);
		Thread.sleep(1000);
	}

	// --------------Function Being Called-------------------------------
	public void user_Can_Add_Agenda() throws InterruptedException {
		this.enter_Agenda_Title();
		System.out.println("------- Completed --> user_Can_Add_Agenda() -----------");
	}
	
	// ---------------------------------user_Can_Save_Book_And_Continue---------------------------------------------
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
	
	// ------------------user_Add_First_Catagory_To_Book_-----------------------------------
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
		this.click_Main_Catagory_1();
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

	public void click_Click_For_More_Options() throws InterruptedException {
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
	
	// ----------------------------build_Book()---------------------------------------
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

	// --------------Function Being Called-------------------------------
	public void user_Can_Build_Book() throws InterruptedException {
		this.verify_Build_Book();
		this.scroll_Up_To_Build_Book();
		this.click_Build_Book();
		this.verify_Build_DoneBtn();
		this.click_Build_DoneBtn();
		System.out.println("------- Completed --> user_Can_Build_Book()  -----------");
	}
	
	// --------------------------make_Book_Visible----------------------------------
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
	
	// --------------Function Being Called-------------------------------
	public void make_Book_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		this.click_Workroom_Library_Crumb();
		this.verify_Book_Visible();
		System.out.println("------- Completed --> make_Book_Visible()  -----------");
	}
	
	// -------------user_Can_Create_New_Event----------------------------------
	// -------------Create Event populate Form---------------------------------
	By form_Location = By.xpath("//input[@id='event_location']");
	By form_Address1 = By.xpath("//input[@id='event_address1']");
	By form_Address2 = By.xpath("//input[@id='event_address2']");
	By form_City = By.xpath("//input[@id='event_city']");
	By country_Option = By.xpath(
			"//div[@class='btn-group bootstrap-select chosen country']//span[@class='filter-option pull-left'][contains(text(),'Select an Option')]");
	By state_Option = By
			.xpath("//div[@class='btn-group bootstrap-select chosen state']//span[@class='filter-option pull-left'][contains(text(),'State')]");
	By zipCode = By.xpath("//input[@id='event_zip']");
	By meeting_Option = By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']");
	By form_Top_SaveBtn = By.xpath("//aside//button[@name='button'][contains(text(),'Save')]");
	By eventCatagory = By.xpath(
			"//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']//*[contains(text(),'Select an Option')]");
	By meetings = By.xpath("//span[contains(text(),'Meetings')]");
	By event_Title = By.xpath("//h1[contains(text(),'This is a New Event Title')]");
	By facilitator_Name = By.xpath("//input[@id='event_contact']");
	By facilitator_Email = By.xpath("//input[@id='event_email']");
	By website = By.xpath("//input[@id='event_website']");
	By event_Form_Title = By.xpath("//input[@id='event_title']");
	By eventsMenu = By.xpath("//span[@class='icon icon_wr-events active-off']");
	By newEventBtn = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Event')]");
	String form_Title_Name = " This is a New Event Title ";
	String meeting = "Meeting";

	public void click_Form_SaveBtn_Top() throws InterruptedException {
		WebElement SaveBtn = driver.findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(2000);
		driver.findElement(form_Top_SaveBtn).click();
	}

	public void new_Event_Form_Populate() throws InterruptedException {
		String location = "cool location";
		String address_1 = "22 Smith Street";
		String address_2 = "apt 335";
		String city = "Charlotte";
		String zipcode = "28217";
		String facilitator = "Someone";
		String facilitator_email = "Someone@diligent.com";
		String Website = "https://www.diligent.com";
		
		driver.findElement(event_Form_Title).sendKeys(form_Title_Name);
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(form_Location).clear();
		driver.findElement(form_Location).sendKeys(location);
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(form_Address1).sendKeys(address_1);
		driver.findElement(form_Address2).sendKeys(address_2);
		driver.findElement(form_City).sendKeys(city);
		form_Country_State_Select(); // -----calling method form_Country_State_Select()
		driver.findElement(zipCode).sendKeys(zipcode);
		
		// ---------------------switching to iframe-----------------
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("This is a new event");
		driver.switchTo().defaultContent();
		
		// --------------------select photo path -------------------------
		String input = "//input[@id='event_photo']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
		driver.findElement(facilitator_Name).sendKeys(facilitator);
		driver.findElement(facilitator_Email).sendKeys(facilitator_email);
		driver.findElement(website).sendKeys(Website);
		
		// ------------------- Event Category (Scroll into View)
		WebElement eventcatagory = driver.findElement(By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eventcatagory);
		// ---Event Catagory
		driver.findElement(eventCatagory).click();
		Thread.sleep(1000);
		driver.findElement(meetings).click();
	}

	public void form_Country_State_Select() throws InterruptedException {
		// ----------COUNTRY---------------
		driver.findElement(country_Option).click();
		Thread.sleep(2000);
		// By countryList =
		// By.xpath("//*[@id=\"new_event\"]/div/div/div[8]/div/div/div[1]/div/div/ul");
		By countryList = By.xpath("(//ul[@class='dropdown-menu inner'])[2]");
		String country = "United States";
		WebElement dropdownlist = driver.findElement(countryList);
		List<WebElement> options = dropdownlist.findElements(By.tagName("li"));
		// System.out.println(options + ",");
		/*
		 * MAven compiler dosent like this List<String> optionsList =
		 * options.stream().map(WebElement::getText).collect(Collectors.toList());
		 * System.out.println(optionsList); System.out.println("Testing -----------");
		 */
		for (WebElement c_option : options) {
			if (c_option.getText().equals(country)) {
				c_option.click(); // clicks desired option
				break;
			}
		}
		// ----------STATE---------------
		driver.findElement(state_Option).click();
		Thread.sleep(1000);
		By stateList = By.xpath("//*[@id=\"order_state_code_wrapper\"]/div/div/ul");
		String searchText2 = "North Carolina";
		WebElement dropdownlist2 = driver.findElement(stateList);
		List<WebElement> optionTwo = dropdownlist2.findElements(By.tagName("li"));
		// System.out.println(optionTwo + ",");
		/*
		 * List<String> stateOptionsList =
		 * optionTwo.stream().map(WebElement::getText).collect(Collectors.toList());
		 * System.out.println(stateOptionsList);
		 * System.out.println("Testing -----------");
		 */
		for (WebElement s_option : optionTwo) {
			if (s_option.getText().equals(searchText2)) {
				s_option.click(); // clicks desired option
				break;
			}
		}
		Thread.sleep(1000);
	}

	public void verify_New_Event_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title)));
	}

	public void verify_Form_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Form_Title)));
	}

	public void verify_New_Event_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newEventBtn)));
	}

	public void click_Events_Menu() throws InterruptedException {
		driver.findElement(eventsMenu).click();
	}

	public void click_New_Event_Btn() throws InterruptedException {
		driver.findElement(newEventBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Event() throws InterruptedException {
		this.click_Events_Menu();
		this.verify_New_Event_Btn();
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_Form_Populate();
		Thread.sleep(2000);
		this.click_Form_SaveBtn_Top();
		this.verify_New_Event_Title();
		System.out.println("------- Completed --> user_Can_Create_New_Event()  -----------");
	}
	
	// ------------user_Click_Attach_Create_And_Click_Resource_Tab---------
	By attach_Create_Btn = By.xpath("//a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')]");
	By resource_Tab = By.xpath("//a[contains(text(),'Resources')]");
	By autobe_Workroom = By.xpath("//a[ starts-with (@class,'workroom-')][contains(text(),'AutoBE')]");

	public void verify_Resource_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Tab)));
	}

	public void verify_Autobe_Workroom() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autobe_Workroom)));
	}

	public void verify_Attach_Create_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Btn)));
	}

	public void click_Attach_Create_Btn() throws InterruptedException {
		driver.findElement(attach_Create_Btn).click();
	}

	public void click_Resource_Tab() throws InterruptedException {
		driver.findElement(resource_Tab).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Click_Attach_Create_And_Click_Resource_Tab() throws InterruptedException {
		this.click_Attach_Create_Btn();
		Thread.sleep(1000);
		this.verify_Resource_Tab();
		this.click_Resource_Tab();
		Thread.sleep(1000);
		this.verify_Autobe_Workroom();
		System.out.println("------- Completed --> user_Can_Attach_Resource_To_Tab()  -----------");
	}
	
	// --------------user_Can_Attach_Resource_To_Event_And_Save---------------------------
	By folder_Name_Attach = By.xpath("//ul[@class='plain-list']//a[contains(text(),'Attach')]");
	By to_Attach = By.xpath("//a[@class='copy-file-to-event'][contains(text(),'ToAttach')]");
	By doneBtn = By.xpath("//button[@id='attached_resource'][contains(text(),'Done')]");

	public void verify_Folder_Name_Attach() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(folder_Name_Attach)));
	}

	public void verify_File_To_Attach() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(to_Attach)));
	}

	public void click_Autobe_Workroom() throws InterruptedException {
		driver.findElement(autobe_Workroom).click();
	}

	public void click_Folder_Name_Attach() throws InterruptedException {
		driver.findElement(folder_Name_Attach).click();
	}

	public void click_File_To_Attach() throws InterruptedException {
		driver.findElement(to_Attach).click();
	}

	public void click_DoneBtn() throws InterruptedException {
		driver.findElement(doneBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Attach_Resource_To_Event_And_Save() throws InterruptedException {
		this.click_Autobe_Workroom();
		Thread.sleep(1500);
		this.verify_Folder_Name_Attach();
		this.click_Folder_Name_Attach();
		Thread.sleep(1500);
		this.verify_File_To_Attach();
		this.click_File_To_Attach();
		Thread.sleep(2000);
		this.click_DoneBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> user_Can_Attach_Resource_To_Event_And_Save()  -----------");
	}
	
	// --------------user_Can_Attach_Book_To_Event ---------------------------
	By books_Title = By.xpath("//span[contains(text(),'This is a Book Title')]");
	By doneBtn2 = By.xpath("//button[@id='attached_book'][contains(text(),'Done')]");

	public void verify_Folder_Books_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(books_Title)));
	}

	public void click_Books_Title() throws InterruptedException {
		driver.findElement(books_Title).click();
	}

	public void click_DoneBtn2() throws InterruptedException {
		driver.findElement(doneBtn2).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Attach_Book_To_Event() throws InterruptedException {
		this.verify_Attach_Create_Btn();
		this.click_Attach_Create_Btn();
		Thread.sleep(1500);
		this.verify_Folder_Books_Title();
		this.click_Books_Title();
		Thread.sleep(1500);
		this.click_DoneBtn2();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> user_Can_Attach_Book_To_Event()  -----------");
	}
	
	// --------------verify_Book_And_Resource_Tabs_Appear_On_Event_Card---------------------------
	By books_Tab = By.xpath("//a[contains(text(),'Book')]");
	By resources_Tab = By.xpath("//a[contains(text(),'Resource')]");

	public void verify_Books_And_Resources_Tabs_Appear() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(
				ExpectedConditions.and(ExpectedConditions.elementToBeClickable(books_Tab), ExpectedConditions.elementToBeClickable(resources_Tab)));
	}

	public void verify_Events() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(eventsMenu)));
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Book_And_Resource_Tabs_Appear_On_Event_Card() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		this.verify_Events();
		this.click_Events_Menu();
		Thread.sleep(1000);
		this.verify_Books_And_Resources_Tabs_Appear();
		System.out.println("------- Completed --> verify_Book_And_Resource_Tabs_Appear_On_Event_Card()  -----------");
	}
	
	// --------------verify_Book_And_Resource_Tabs_Appear_On_Event_Details--------------
	By attachCreate = By.xpath("//a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')]");
	By event_Title_2 = By.xpath("//a[contains(text(),'This is a New Event Title')]");

	public void verify_Event_Details_Books_And_Resources_Tabs_Appear() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(attachCreate),
				ExpectedConditions.elementToBeClickable(resources_Tab)));
		// ---scroll down -----
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);
		// --------------------
	}

	public void click_Event_Title_2() throws InterruptedException {
		driver.findElement(event_Title_2).click();
	}

	// --------------Function Being Called ---------------------------
	public void verify_Book_And_Resource_Tabs_Appear_On_Event_Details() throws InterruptedException {
		this.click_Event_Title_2();
		Thread.sleep(2000);
		this.verify_Event_Details_Books_And_Resources_Tabs_Appear();
		System.out.println("------- Completed --> verify_Book_And_Resource_Tabs_Appear_On_Event_Details()  -----------");
	}
	
	// --------------Delete_Event-------------------------------------
	By deleteEvent = By.xpath("//a[@class='btn btn-danger no-mobile'][contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");
	By event_Deleted_Sucessful_Message = By.xpath("//div[@class='col-md-10 narrow']//p[contains(text(),'Successfully deleted Event')]");

	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void verify_Event_Deleted_Sucessfull_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(event_Deleted_Sucessful_Message)));
	}

	public void click_DeleteEvent() throws InterruptedException {
		driver.findElement(deleteEvent).click();
	}

	public void click_ContinueBtn() throws InterruptedException {
		driver.findElement(continueBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void delete_Event() throws InterruptedException {
		this.click_DeleteEvent();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		this.verify_Event_Deleted_Sucessfull_Message();
		System.out.println("------- Completed --> delete_Event()  -----------");
	}
	
	// --------------delete_Book--------------------------------------
	By book_Dropdown = By.xpath("//a[contains(text(),'This is a Book Title')]/following::div[@class='dropdown header-actions']");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By form = By.xpath("//div[@class='modal-body']//input[@class='form-control']");

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

	public void click_Book_Dropdown() throws InterruptedException {
		driver.findElement(book_Dropdown).click();
	}

	public void click_Delete_Option() throws InterruptedException {
		driver.findElement(delete_Option).click();
	}

	public void click_And_SendKeys() throws InterruptedException {
		driver.findElement(form).sendKeys("delete");
	}

	// --------------Function Being Called ---------------------------
	public void delete_Book() throws InterruptedException {
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

	// --------------verify_Book_Deleted -----------------------------
	public void verify_Book_Not_Present() throws InterruptedException {
		String element = "//a[contains(text(),'This is a Book Title')]/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Book_Deleted() throws InterruptedException {
		Thread.sleep(4000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_Book_Not_Present();
		System.out.println("------- Completed --> verify_Book_Deleted()  -----------");
	}
}