package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import page_workroom_library.BookPage;

public class BookScannedPDFPage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public BookScannedPDFPage(WebDriver driver) {
		this.driver = driver;
	}
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By library = By.xpath("//span[contains(text(),'Library')]");

	// -------- user_Open_Library_Page_For_Workroom()------------------
	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void verify_Library() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library)));
	}

	public void click_AutoBE() {
		driver.findElement(autoBE).click();
	}

	public void click_Library() {
		driver.findElement(library).click();
	}

	// ------------------Function Being called-----------------------------------
	public void user_Open_Library_Page_For_Workroom() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		this.verify_Library();
		this.click_Library();
		System.out.println("------- Completed --> user_Open_Library_Page_For_Workroom -----------");
	}
	
	// ------------------user_Can_Create_New_Book_Add_Title-----------------------------------
	By meeting_Books = By.xpath("//a[contains(text(),'Meeting Books')]");
	By newBook = By.xpath("//a[@class='btn btn-success no-mobile'][contains(text(),'New Book')]");
	By title_Field = By.xpath("//input[@id='book_title']");

	public void verify_Meeting_Books() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Books)));
	}

	public void verify_NewBook() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newBook)));
	}

	public void verify_Title_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Field)));
	}

	public void click_Meeting_Books() {
		driver.findElement(meeting_Books).click();
	}

	public void click_NewBook() {
		driver.findElement(newBook).click();
	}

	public void enter_Book_Title_SendKeys() {
		String book_title = " This is a Scanned Book ";
		driver.findElement(title_Field).sendKeys(book_title);
	}

	// ------------------Function Being called---------------------
	public void user_Can_Create_New_Book_Add_Title() throws InterruptedException {
		this.verify_Meeting_Books();
		this.click_Meeting_Books();
		this.verify_NewBook();
		this.click_NewBook();
		this.verify_Title_Field();
		this.enter_Book_Title_SendKeys();
		System.out.println("------- Completed --> user_Can_Create_New_Book_Add_Title -----------");
	}
	
	// ------------------user_Can_Add_Coverpage_---------------------
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

	public void user_Can_Add_CoverPage() throws InterruptedException {
		this.click_Coverpage_CheckBox();
		this.fill_Generate_Cover_Page_Form();
		System.out.println("------- Completed --> user_Can_Add_CoverPage -----------");
	}
	
	// ------------------user_Add_Agenda_To_Template---------------------
	By agenda_Title = By.xpath("//input[@id='agenda_title']");

	public void verify_Agenda_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(agenda_Title)));
	}

	public void enter_Agenda_Title() throws InterruptedException {
		String agenda_title = "This is an Agenda";
		driver.findElement(agenda_Title).sendKeys(agenda_title);
		Thread.sleep(500);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		this.verify_Agenda_Title();
		this.enter_Agenda_Title();
		this.click_Agenda_CheckBox();
		System.out.println("------- Completed --> user_Add_Agenda_To_Template() -----------");
	}
	
	// ------------------user_Can_Save_Scanned_Book-----------------------------------
	By Save_Continue_Btn = By.xpath("//*[@id='new_book']/div[3]/div[3]/p/button");

	public void click_Save_Continue_Btn() throws InterruptedException {
		driver.findElement(Save_Continue_Btn).click();
		Thread.sleep(1000);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Can_Save_Scanned_Book() throws InterruptedException {
		this.click_Save_Continue_Btn();
		System.out.println("------- Completed --> user_Can_Save_Scanned_Book() -----------");
	}
	
	// ------------------user_Add_First_Catagory_To_Scanned_Book_-----------------------------------
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
	public void user_Add_First_Catagory_To_Scanned_Book() throws InterruptedException {
		this.click_Main_Catagory_1();
		this.verify_Catagory_Name_Field();
		this.fill_Catagory_Form();
		this.click_Catagory_SaveBtn();
		this.verify_New_Catagory_Name();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Add_First_Catagory_To_Scanned_Book -----------");
	}
	
	// ------------------user_Add_Scanned_Book_To_First_Catagory------------------
	By click_For_More_Options = By.xpath("//a[contains(text(),'click for more options')]");
	By title_Field_2 = By.xpath("//input[@id='bookfolder_title']");
	By file_SaveBtn = By.xpath("//div[@id='newBookFileModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By file_Upload_Success_Message = By.xpath("//div//p[contains(text(),'The following files were uploaded:')]");

	public void verify_Click_For_More_Options() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options)));
	}

	public void verify_Title_Field_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Field_2)));
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
		driver.findElement(title_Field_2).sendKeys(file_title);
		Thread.sleep(1000);
	}

	public void add_First_Scanned_Book() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\ScannedDocument.pdf";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_Multiple_PDF_Files() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath1 = "C:\\uploadedFiles\\ScannedDocument.pdf";
		String filepath2 = "C:\\uploadedFiles\\ScannedDocument2.pdf";
		String filepath3 = "C:\\uploadedFiles\\ScannedDocument3.pdf";

		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath1 +"\n"+ filepath2 +"\n"+ filepath3);
	}

	public void file_Save_Btn() throws InterruptedException {
		driver.findElement(file_SaveBtn).click();
		Thread.sleep(1000);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_Scanned_Book_To_New_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		this.verify_Title_Field_2();
		this.title_Field_SendKeys();
		this.add_First_Scanned_Book();
		this.file_Save_Btn();
		this.verify_File_Upload_Success_Message();
		System.out.println("------- Completed --> user_Add_Scanned_Book_To_New_Catagory()  -----------");
	}
	
	public void user_Add_Multiple_PDF_Files_To_New_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		this.verify_Title_Field_2();
		this.title_Field_SendKeys();
		this.add_Multiple_PDF_Files();
		this.file_Save_Btn();
		this.verify_File_Upload_Success_Message();
		System.out.println("------- Completed --> user_Add_Multiple_PDF_Files_To_New_Catagory()  -----------");
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(400)).pollingEvery(Duration.ofMillis(600))
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

	// ----------------Function Being Called-----------------------
	public void user_Can_Build_Book() throws InterruptedException {
		this.verify_Build_Book();
		this.scroll_Up_To_Build_Book();
		this.click_Build_Book();
		this.verify_Build_DoneBtn();
		this.click_Build_DoneBtn();
		System.out.println("------- Completed --> build_Scanned_Book()  -----------");
	}
	
	// --------------------------make_Book_Visible------------------
	By edit_BookBtn = By.xpath("//a[@class='primary-action-btn btn-sidebar be-blue'][contains(text(),'Edit Book')]");
	By onswitch = By.xpath("//label[@class='onoffswitch-label']");
	By workroom_Library_Crumb = By.xpath("//*[contains(text(),'Workroom Library')]");
	By scanned_Book_Visible = By.xpath("//a[contains(text(),'This is a Scanned Book')]");
	By scanned_Book_Draft = By.xpath("//span[normalize-space(text())='Draft']");

	public void verify_Edit_BookBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_BookBtn)));
	}

	public void verify_Scanned_Book_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(scanned_Book_Visible)));
	}

	public void click_On_Switch() throws InterruptedException {
		driver.findElement(onswitch).click();
		Thread.sleep(1000);
	}

	public void click_Workroom_Library_Crumb() throws InterruptedException {
		driver.findElement(workroom_Library_Crumb).click();
		Thread.sleep(1000);
	}
	
	public void verify_Btn_Meeting_Book_Viewer_Present() throws InterruptedException {
		String element = "//span[contains(text(),'Meeting Book Viewer')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Btn_Download_PDF_Not_Present() throws InterruptedException {
		String element = "//*[starts-with (@id,'card-')]//div/a[contains(.,'Download Full PDF')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Workflow_Response_Received() throws InterruptedException {
		String element = "//span[contains(text(),'Responses Received')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	// --------------Function Being Called-----------------------
	public void make_Scanned_Book_Visible() throws InterruptedException {
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_On_Switch();
		this.click_Workroom_Library_Crumb();
		this.verify_Scanned_Book_Visible();
		System.out.println("------- Completed --> make_Scanned_Book_Visible()  -----------");
	}
	
	public void verify_Book_Is_View_Only() throws InterruptedException {
		this.verify_Scanned_Book_Visible();
		this.verify_Btn_Meeting_Book_Viewer_Present();
		this.verify_Btn_Download_PDF_Not_Present();
		System.out.println("------- Completed --> verify_Book_Is_View_Only()  -----------");
	}
	
	// ----------------EditHandbook--------------------------------
	By scanned_Book_Dropdown = By.xpath("//div[@class='dropdown header-actions']");
	By edit_option = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Edit')]");
	By expand_Cover_Page = By.xpath("(//span[contains(text(),'Generate Cover Page')]/following::a[@class='collapse-selection fl-right'])[1]");
	By preview_Left = By.xpath("//a[@id='cover_preview']//span[@class='icon icon_mb_thumbnail1 meeting-book-thumbnail']");
	By edit_SaveBtn = By.xpath("//button[@class='primary-action-btn']");
	By edited_Scanbook_Visible = By.xpath("//*[contains(text(),'This is an Edited Scanned Book')]");
	By coverpage_CheckBox = By.xpath("//span[contains(text(),'Generate Cover Page')]");
	By agenda_CheckBox = By.xpath("//span[contains(text(),'Generate Agenda')]");

	public void verify_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_option)));
	}

	public void verify_Edited_Scanbook_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Scanbook_Visible)));
	}

	public void click_Scanned_Book_Dropdown() throws InterruptedException {
		driver.findElement(scanned_Book_Dropdown).click();
		Thread.sleep(1000);
	}

	public void click_Edit_Option() throws InterruptedException {
		driver.findElement(edit_option).click();
		Thread.sleep(1000);
	}

	public void click_Edit_Book_Btn() throws InterruptedException {
		driver.findElement(edit_BookBtn).click();
		Thread.sleep(1000);
	}

	public void edited_Scanbook_Title_SendKeys() throws InterruptedException {
		String scannedbook_title = "This is an Edited Scanned Book";
		driver.findElement(title_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(title_Field).clear();
		driver.findElement(title_Field).sendKeys(scannedbook_title);
		// driver.findElement(top_Save_Btn).click();
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

	// --------------Function Being Called-------------------------------
	public void edit_Scanned_Book() throws InterruptedException {
		this.click_Scanned_Book_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		Thread.sleep(1500);
		this.click_Edit_Option();
		Thread.sleep(1500);
		this.verify_Edit_BookBtn();
		Thread.sleep(1500);
		this.click_Edit_Book_Btn();
		Thread.sleep(1500);
		this.verify_Title_Field();
		Thread.sleep(1500);
		this.edited_Scanbook_Title_SendKeys();
		Thread.sleep(1500);
		this.click_Coverpage_Expand();
		Thread.sleep(3000);
		this.edit_Generate_Cover_Page_Form();
		Thread.sleep(1500);
//		this.click_Preview_Left();// ---click this to make save btn appear
//		Thread.sleep(1500);
		//this.click_Coverpage_CheckBox();
		//Thread.sleep(1500);
		//this.click_Agenda_CheckBox();
		//Thread.sleep(1500);
		this.scroll_To_SaveBtn();
		Thread.sleep(1500);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_Build_Book();
		this.scroll_Up_To_Build_Book();
		this.click_Build_Book();
		Thread.sleep(1500);
		this.verify_Build_DoneBtn();
		Thread.sleep(1500);
		this.click_Build_DoneBtn();
		Thread.sleep(1500);
		this.verify_Edit_BookBtn();
		Thread.sleep(1500);
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1500);
		this.verify_Edited_Scanbook_Visible();
		System.out.println("------- Completed --> edit_Scanned_Book()  -----------");
	}
	
	public void navigate_To_Edit_Status() throws InterruptedException {
		this.click_Scanned_Book_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		this.verify_Title_Field();		
		System.out.println("------- Completed --> navigate_To_Edit_Status()  -----------");
	}
	
	public void navigate_To_Edit_Status_2() throws InterruptedException {
		this.click_Scanned_Book_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Build_Book();	
		System.out.println("------- Completed --> navigate_To_Edit_Status_2()  -----------");
	}
	
	public void verify_Scanned_Book_Draft() throws InterruptedException {
		String element = "//span[contains(text(),'Draft')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void click_Scanned_Book_Title() throws InterruptedException {
		driver.findElement(scanned_Book_Visible).click();
	}
	
	public void navigate_To_Edit_Status_Verify_Book_Draft() throws InterruptedException {
		this.click_Scanned_Book_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_Edit_BookBtn();
		Thread.sleep(1000);
		this.click_Edit_Book_Btn();
		Thread.sleep(1000);
		this.verify_Title_Field();	
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		this.verify_Scanned_Book_Visible();
		this.verify_Scanned_Book_Draft();
		this.click_Scanned_Book_Title();
		System.out.println("------- Completed --> navigate_To_Edit_Status_Then_Go_Back()  -----------");
	}
	
	public void navigate_To_Book_Verify_Response_Received() throws InterruptedException {
		this.click_Scanned_Book_Title();
		Thread.sleep(1000);
		this.verify_Title_Field();	
		Thread.sleep(1000);
		this.verify_Workflow_Response_Received();
		System.out.println("------- Completed --> navigate_To_Book_Verify_Response_Received()  -----------");
	}

	// -------------Open Book Template Scroll Down----------------------------
	By meeting_Book_Viewer = By.xpath("//div[@class='atlas-books-sidebar col-md-2']//a[@id='view_book']");
	By thumbnail = By.xpath("//body/div[@id='app']/div[contains(@class,'App')]/div[contains(@class,'Panel LeftPanel open')]/div[contains(@class,'left-panel-header')]/div[contains(@class,'LeftPanelTabs')]/div[1]");
	By newCategory = By.xpath("//div[contains(text(),'New Catagory')]");
	By pageSection2 = By.xpath("//div[@id='pageSection2']");
	By minutes_Image = By.xpath("//img[@id='thumb1']");
	

	
	public void verify_Meeting_Book_Viewer() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_Viewer)));
	}

	public void verify_Workroom_Library_Crumb() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Library_Crumb)));
	}
	
	public void verify_NewCategory() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newCategory)));
	}

	public void click_Edited_Scanned_Book_Title() throws InterruptedException {
		driver.findElement(edited_Scanbook_Visible).click();
		Thread.sleep(1000);
	}

	public void click_Meeting_Book_Viewer() throws InterruptedException {
		driver.findElement(meeting_Book_Viewer).click();
		Thread.sleep(3000);
	}
	
	public void click_New_Category() throws InterruptedException {
		driver.findElement(newCategory).click();
	}

	public void switch_Tab_Scroll_Scanned_Book() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/iframe[1]"));
		driver.switchTo().frame(iframe);
		// finding body of iframe 
		WebElement iframeThumbnail = driver.findElement(thumbnail);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframeThumbnail)));
		WebElement iframeSection = driver.findElement(By.xpath("//div[@id='pageSection15']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeSection);
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.close();
		// ---close 2nd Tab----
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
	
	public void boardmember_switch_Tab_Scroll_Scanned_Book() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/iframe[1]"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);

		// finding webviewer element 
		By panelBtn = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[1]/button[1]");
		WebElement panel = driver.findElement(panelBtn);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(panel)));
		//--scroll in viewer
		WebElement iframeSection = driver.findElement(By.xpath("//div[@id='pageSection15']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeSection);
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.close();
		// ---close 2nd Tab----
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
	
	public void switch_Tab_Verify_Minutes_Info() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("/html/body/div//iframe"));
		driver.switchTo().frame(iframe);
		
		// verify new category present
		WebElement iframeNewCategory = driver.findElement(newCategory);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframeNewCategory)));
		
		driver.findElement(newCategory).click();
		Thread.sleep(3000);
		
		String iframeMinutesImage = "//img[@id='thumb1']";
		Assert.assertTrue(driver.findElements(By.xpath(iframeMinutesImage)).size() > 0);

		/*WebElement iframeMinutesImage = driver.findElement(minutes_Image);
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait2.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframeMinutesImage)));
		*/
		
		driver.switchTo().defaultContent();
		driver.close();
		// ---close 2nd Tab----
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
	
	public void switch_Tab_Open_Library_File() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("/html/body/div//iframe"));
		driver.switchTo().frame(iframe);
		
		// verify new category present
		WebElement iframeNewCategory = driver.findElement(newCategory);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframeNewCategory)));
		
		driver.findElement(newCategory).click();
		Thread.sleep(2000);
		
		WebElement iframeMinutesImage = driver.findElement(minutes_Image);
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait2.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframeMinutesImage)));
		
		driver.switchTo().defaultContent();
		driver.close();
		// ---close 2nd Tab----
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
	
	public void switch_Tab_Verify_Print_Logo() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(1000);
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/iframe[1]"));
		driver.switchTo().frame(iframe);
		// finding image
		By print_Logo = By.xpath("//img[@id='thumb0']");
		WebElement iframeThumbnail = driver.findElement(thumbnail);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframeThumbnail)));
		
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.close();
		// ---close 2nd Tab----
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
	
	// --------------Function Being Called-------------------------------
	public void user_Opens_Meeting_Book_Viewer_And_Scroll() throws InterruptedException {
		this.click_Edited_Scanned_Book_Title();
		Thread.sleep(2000);
		this.verify_Meeting_Book_Viewer();
		this.click_Meeting_Book_Viewer();
		Thread.sleep(2000);
		this.switch_Tab_Scroll_Scanned_Book();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		System.out.println("------- Completed --> user_Opens_Meeting_Book_Viewer() -----------");
	}
	
	public void boardmember_Opens_Meeting_Book_Viewer_And_Scroll() throws InterruptedException {
		this.boardmember_switch_Tab_Scroll_Scanned_Book();
		driver.navigate().refresh();
		System.out.println("------- Completed --> boardmember_Opens_Meeting_Book_Viewer_And_Scroll() -----------");
	}
	
	public void user_Opens_Meeting_Book_Viewer_And_Scroll_2() throws InterruptedException {
		this.verify_Meeting_Book_Viewer();
		this.click_Meeting_Book_Viewer();
		Thread.sleep(2000);
		this.switch_Tab_Scroll_Scanned_Book();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		System.out.println("------- Completed --> user_Opens_Meeting_Book_Viewer_And_Scroll_2() -----------");
	}
	
	//---For Set Permissions Test Case -----
	public void click_Meeting_Book_Viewer_And_Scroll() throws InterruptedException {
		this.click_Meeting_Book_Viewer();
		Thread.sleep(2000);
		this.switch_Tab_Scroll_Scanned_Book();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		System.out.println("------- Completed --> click_Meeting_Book_Viewer_And_Scroll() -----------");
	}
	
	public void open_Library_File_In_Meeting_Book_Viewer() throws InterruptedException {
		this.verify_Meeting_Book_Viewer();
		this.click_Meeting_Book_Viewer();
		Thread.sleep(2000);
		this.switch_Tab_Open_Library_File();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		this.verify_Book_Title();
		System.out.println("------- Completed --> open_Library_File_In_Meeting_Book_Viewer() -----------");
	}
	
	By book_Title = By.xpath("//a[contains(text(),'This is a Book Title')]");
	
	public void verify_Book_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(book_Title)));
	}
	
	public void click_Book_Title() throws InterruptedException {
		driver.findElement(book_Title).click();
	}
	
	public void open_Meeting_Book_Viewer_Verify_Print_Logo() throws InterruptedException {
		this.click_Book_Title();
		Thread.sleep(2000);
		this.verify_Meeting_Book_Viewer();
		this.click_Meeting_Book_Viewer();
		Thread.sleep(2000);
		this.switch_Tab_Verify_Print_Logo();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		System.out.println("------- Completed --> user_Opens_Meeting_Book_Viewer() -----------");
	}
	
	public void open_Meeting_Book_Viewer_Verify_Print_Logo_And_URL() throws InterruptedException {
		this.click_Book_Title();
		Thread.sleep(2000);
		this.verify_Meeting_Book_Viewer();
		this.click_Meeting_Book_Viewer();
		Thread.sleep(2000);
		this.switch_Tab_Verify_Print_Logo();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		System.out.println("------- Completed --> open_Meeting_Book_Viewer_Verify_Print_Logo_And_URL() -----------");
	}
	
	public void open_Meeting_Book_Viewer_See_Minutes() throws InterruptedException {
		this.verify_Meeting_Book_Viewer();
		this.click_Meeting_Book_Viewer();
		Thread.sleep(2000);
		this.switch_Tab_Verify_Minutes_Info();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		System.out.println("------- Completed --> open_Meeting_Book_Viewer_See_Minutes() -----------");
	}
	
	public void boardmember_Meeting_Book_Viewer_See_Minutes() throws InterruptedException {
		this.verify_Book_Title();
		this.click_Book_Title();
		Thread.sleep(1000);
		this.verify_Meeting_Book_Viewer();
		this.click_Meeting_Book_Viewer();
		Thread.sleep(2000);
		this.switch_Tab_Verify_Minutes_Info();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		Thread.sleep(3000);
		System.out.println("------- Completed --> boardmember_Meeting_Book_Viewer_See_Minutes() -----------");
	}
	
	// --------------------------delete_Scanned_Book-----------------------------------------
	// By handbook_Dropdown = By.xpath("//div[@class='dropdown header-actions']");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By form_Input_field = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void verify_Form_Input_field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(form_Input_field)));
	}

	public void click_Delete_Option() throws InterruptedException {
		driver.findElement(delete_Option).click();
		Thread.sleep(1000);
	}

	public void click_Form_Input_SendKeys() throws InterruptedException {
		String delete = "delete";
		driver.findElement(form_Input_field).sendKeys(delete);
		Thread.sleep(1000);
	}

	public void click_ContinueBtn() throws InterruptedException {
		driver.findElement(continueBtn).click();
		Thread.sleep(1000);
	}

	// --------------Function Being Called-------------------------------
	public void delete_Scanned_Book() throws InterruptedException {
		this.click_Scanned_Book_Dropdown();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> delete_Scanned_Book()  -----------");
	}
	
	// --------------Function Being Called-------------------------------
	public void verify_Scanned_Book_NOT_Visible() throws InterruptedException {
		String handbook = "//a[contains(text(),'This is an Edited Scanned Book')]/following::div//span[@class='icon icon_mbm-visible-on visible active-on']/following::text()[contains(., 'Visible to Workroom')]";
		Assert.assertTrue(driver.findElements(By.xpath(handbook)).size() < 1);
	}
	
	public void verify_Scanned_Book_NOT_Visible_2() throws InterruptedException {
		String handbook = "//a[contains(text(),'This is a Scanned Book')]";
		Assert.assertTrue(driver.findElements(By.xpath(handbook)).size() < 1);
	}
	
	public void verify_Book_NOT_Visible() throws InterruptedException {
		String meetingbook = "//div[@class='dropdown header-actions']";
		Assert.assertTrue(driver.findElements(By.xpath(meetingbook)).size() < 1);
	}

	// --------------Function Being Called-------------------------------
	public void verify_Scanned_Book_Deleted() throws InterruptedException {
		this.verify_Meeting_Books();
		this.click_Meeting_Books();
		Thread.sleep(1500);
		this.verify_NewBook();
		driver.navigate().refresh();
		this.verify_Scanned_Book_NOT_Visible();
		System.out.println("------- Completed --> verify_Scanned_Book_Deleted()  -----------");
	}
	
	public void verify_Scanned_Book_Deleted_2() throws InterruptedException {
		this.verify_Meeting_Books();
		this.click_Meeting_Books();
		Thread.sleep(1500);
		this.verify_NewBook();
		driver.navigate().refresh();
		this.verify_Scanned_Book_NOT_Visible_2();
		System.out.println("------- Completed --> verify_Scanned_Book_Deleted()  -----------");
	}
	
	public void verify_Book_Deleted() throws InterruptedException {
		this.verify_Meeting_Books();
		this.click_Meeting_Books();
		Thread.sleep(3000);
		this.verify_NewBook();
		driver.navigate().refresh();
		this.verify_Book_NOT_Visible();
		System.out.println("------- Completed --> verify_Scanned_Book_Deleted()  -----------");
	}
	
	//----------------------------
	By preview_Files = By.xpath("//a[@class='btn btn-default btn-sidebar secondary-action-btn left'][contains(text(),'Preview Files')]");

	public void click_Preview_Files() throws InterruptedException {
		driver.findElement(preview_Files).click();
	}
	
	public void preview_Files() throws InterruptedException {
		this.verify_Build_Book();
		this.click_Preview_Files();
		Thread.sleep(1000);
		this.switch_Tab_Scroll_Scanned_Book();
		this.click_Workroom_Library_Crumb();
		this.verify_Scanned_Book_Visible();
		System.out.println("------- Completed --> preview_Files()  -----------");
	}
	
	//------------------------------
	By agenda_Collapse = By.xpath("//span[contains(text(),'Generate Agenda')]/following::a[@class='collapse-selection fl-right']");
	By edit_Font_Styling = By.xpath("//span[contains(text(),'Generate Agenda')]/following::a[@class='edit-font'][contains(.,'Edit Font Styling')]");
	By edit_Font_Modal = By.xpath("//h4[contains(text(),'Edit Agenda Font Styles')]");
	By meeting_Title_Drop_Dwn = By.xpath("//td[contains(text(),'Meeting Title')]/following::select[@id='book_agenda_meetingtitle_font']");
	By meeting_Title_Font = By.xpath("//*[@id='book_agenda_meetingtitle_font']/option[contains(.,'Times-Roman')]");
	By Agenda_Title_Drop_Dwn = By.xpath("//td[contains(text(),'Agenda Title')]/following::select[@id='book_agenda_title_font']");
	By Agenda_Title_Font = By.xpath("//*[@id='book_agenda_title_font']/option[contains(.,'Courier')]");
	By font_SaveBtn = By.xpath("//*[@id='agenda_font_styles']//button[@class='btn btn-done']");

	

	public void verify_AgendaCollapse() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(agenda_Collapse)));
	}
	
	public void verify_Edit_Font_Styling() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Font_Styling)));
	}
	
	public void verify_Edit_Font_Modal() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Font_Modal)));
	}
	
	public void click_AgendaCollapse() throws InterruptedException {
		driver.findElement(agenda_Collapse).click();
	}
	
	public void click_Edit_Font_Styling() throws InterruptedException {
		driver.findElement(edit_Font_Styling).click();
	}
	
	public void click_Meeting_Title_Drop_Dwn() throws InterruptedException {
		driver.findElement(meeting_Title_Drop_Dwn).click();
	}
	
	public void click_Meeting_Font() throws InterruptedException {
		driver.findElement(meeting_Title_Font).click();
	}
	
	public void click_Agenda_Title_Drop_Dwn() throws InterruptedException {
		driver.findElement(Agenda_Title_Drop_Dwn).click();
	}
	
	public void click_Agenda_Title_Font() throws InterruptedException {
		driver.findElement(Agenda_Title_Font).click();
	}
	
	public void click_Font_SaveBtn() throws InterruptedException {
		driver.findElement(font_SaveBtn).click();
	}
	
	
	public void edit_Font_Stylings() throws InterruptedException {
		this.verify_AgendaCollapse();
		this.click_AgendaCollapse();
		Thread.sleep(1000);
		this.verify_Edit_Font_Styling();
		this.click_Edit_Font_Styling();
		Thread.sleep(1000);
		this.verify_Edit_Font_Modal();
		this.click_Meeting_Title_Drop_Dwn();
		Thread.sleep(1000);
		this.click_Meeting_Font();
		Thread.sleep(1000);
		this.click_Agenda_Title_Drop_Dwn();
		Thread.sleep(1000);
		this.click_Agenda_Title_Font();
		Thread.sleep(1000);
		this.click_Font_SaveBtn();
		Thread.sleep(2000);
		BookPage obj = new BookPage(driver);
		obj.verify_Save_Continue_Btn();
		obj.click_Save_Contnue_Btn();
		System.out.println("------- Completed --> preview_Files()  -----------");
	}
	
	public void verify_Font_Options_Selected() throws InterruptedException {
		
		String selectedOne = new Select(driver.findElement(meeting_Title_Drop_Dwn)).getFirstSelectedOption().getText();
		Assert.assertEquals("Times-Roman",selectedOne);
		
		String selectedTwo = new Select(driver.findElement(Agenda_Title_Drop_Dwn)).getFirstSelectedOption().getText();
		Assert.assertEquals("Courier",selectedTwo);
	}
	
	public void veirfy_Font_Styling_Selected() throws InterruptedException {
		this.verify_AgendaCollapse();
		this.click_AgendaCollapse();
		Thread.sleep(1000);
		this.verify_Edit_Font_Styling();
		this.click_Edit_Font_Styling();
		Thread.sleep(1000);
		this.verify_Edit_Font_Modal();
		this.verify_Font_Options_Selected();
		driver.navigate().refresh();
		this.verify_Workroom_Library_Crumb();
		this.click_Workroom_Library_Crumb();
		Thread.sleep(1000);
		this.verify_Scanned_Book_Visible();
		System.out.println("------- Completed --> preview_Files()  -----------");
	}
}
