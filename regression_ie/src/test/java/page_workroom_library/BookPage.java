package page_workroom_library;

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

public class BookPage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public BookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// ---------------------------------workroom_Admin_Not_See_Event_Due_To_Permissions---------------------------------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By library = By.xpath("//span[contains(text(),'Library')]");
	By new_Book = By.xpath("(//*[@id=\"wrap\"]/main/div[1]/div[2]/div/div[3]/div[3]/a)[1]");

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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(400))// ---wait 5 minutes for message
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(file_Upload_Success_Message)));
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

	public void file_Save_Btn() throws InterruptedException {
		driver.findElement(file_SaveBtn).click();
		Thread.sleep(1000);
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
	
	// ----------------------------build_Book()---------------------------------------
	By build_Handbook = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Build Book')]");
	By build_DoneBtn = By.xpath("//button[contains(text(),'Done')]");

	public void verify_Build_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(400))// --- wait 7 minutes for build book to show up
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(build_Handbook)));
	}

	public void verify_Build_DoneBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(600))// --- wait 10 minutes for build book to show up
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
		this.verify_Build_DoneBtn(); // --- wait 10 minutes for build book to show up
		this.click_Build_DoneBtn();
		System.out.println("------- Completed --> user_Can_Build_Book()  -----------");
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

	public void click_On_Switch() throws InterruptedException {
		driver.findElement(onswitch).click();
		Thread.sleep(1000);
	}

	public void click_Workroom_Library_Crumb() throws InterruptedException {
		driver.findElement(workroom_Library_Crumb).click();
		Thread.sleep(1000);
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
	By archive = By.xpath("//a[contains(text(),'Archive')]");
	By archives = By.xpath("//a[@class='btn btn-default'][contains(text(),'Archives')]");
	By copy_Option = By.xpath("//div[@class='col-md-10 narrow']//li[3]//a[1][contains(text(),'Copy')]");
	By copy_Message = By.xpath("//div[@class='margin-top-small']//p[contains(text(),'Successfully created This is a Book Title - Copy')]");
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

	public void click_Book_Dropdown() throws InterruptedException {
		driver.findElement(book_Dropdown).click();
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

	// --------------Function Being Called ---------------------------
	public void archive_Meeting_Book() throws InterruptedException {
		this.click_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Archive_Option();
		this.click_Archive_Option();
		Thread.sleep(1500);
		this.verify_Archives();
		this.click_Archives_Btn();
		Thread.sleep(1500);
		this.verify_Book_Visible();
		System.out.println("------- Completed --> archive_Meeting_Book()  -----------");
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


	// --------------verify_Book_Deleted -----------------------------
	public void verify_Book_Not_Present() throws InterruptedException {
		String element = "//a[contains(text(),'This is a Book Title')]/following::div[@class='dropdown header-actions']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Book_Deleted() throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_Book_Not_Present();
		System.out.println("------- Completed --> verify_Book_Deleted()  -----------");
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
	
	// ------------------user_Add_Coverpage_To_Book_Template---------------------
	// ------------------Function Being called-----------------------------------
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
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\Word_1.docx";
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
	
	// ------------------open_Book_From_Templates_Page-----------------------------------
	By Book_Template_Crumb = By.xpath("//a[contains(text(),'Book Templates')]");
	By template_Title = By.xpath("//a[contains(text(),'This is a Book Template Title')]");

	public void verify_Template_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(template_Title)));
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
	By Auto_Attend_Breadcrumb = By.xpath("//a[contains(text(),'AutoAttend')]");

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
	
	// ------------------ share_Book_Tempate_All_Workrooms -----------------------------------
	By adv_Settings = By.xpath("//span[contains(text(),'Advanced Settings')]");
	By all_Workrooms = By.xpath("//label[contains(text(),'All Workrooms')]");
	By box_Adv_Settings = By.xpath("//input[@id='book_global_template']");
	By saveBtn_AS = By.xpath("//div[@id='advanced_settings']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By save_Continue_Btn = By.xpath("//button[@id='save-and-continue-book']");

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
	
	// ------------------ Function Being called- -----------------------------------
	public void verify_Book_Template_Shared() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Auto_Attend_2();
		this.click_Autto_Attend_2();
		Thread.sleep(2000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_Book_Templates();
		this.click_Book_Templates();
		this.verify_Template_Title();
		this.verify_Book_Template_Shared_AutoBE();
		System.out.println("------- Completed --> verify_Book_Template_Shared()  -----------");
	}
	
	public void navigate_Back_To_Auto_Attend_Library() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Libary();
		this.click_Library();
		Thread.sleep(1000);
		this.verify_Book_Templates();
		this.click_Book_Templates();
		Thread.sleep(1000);
		this.verify_Template_Title();
		System.out.println("------- Completed --> navigate_Back_To_Auto_Attend_Library()  -----------");
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
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_Book_Template_NOT_Visible();
		System.out.println("------- Completed --> verify_Book_Template_Deleted()  -----------");
	}
		
	// ------------------Hand_Book -----------------------------------
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
	By handbook_Created_Message = By.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'Successfully created This is a Handbook')]");

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
	By handbook_Visible = By.xpath("//*[contains(text(),'This is a Handbook')]");

	public void verify_Handbook_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Visible)));
	}

	public void click_Handbook_Crumb() throws InterruptedException {
		driver.findElement(handbook_Crumb).click();
		Thread.sleep(1000);
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
	
	// ---------------copy_Handbook---------------------------------
	By copy = By.xpath("//div[@class='col-md-10 narrow']//li[3]//a[1][contains(., 'Copy')]");
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
	
	public void delete_Handbook() throws InterruptedException {
		this.click_Handbook_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		System.out.println("------- Completed --> delete_Handbook()  -----------");
	}
	
	public void verify_Handbook_NOT_Visible() throws InterruptedException {
		//String handbook = "//a[contains(text(),'This is an Edited Handbook')]/following::div//span[@class='icon icon_mbm-visible-on visible active-on']/following::text()[contains(., 'Visible to Workroom')]";
		String handbook2 = "//a[contains(text(),'This is a Handbook')]";
		String handbook3 = "//a[contains(text(),'This is an Edited Handbook')]";

		//Assert.assertTrue(driver.findElements(By.xpath(handbook)).size() < 1);
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
	
}
	
	