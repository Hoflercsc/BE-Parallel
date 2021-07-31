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

public class BookLargeFilePage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public BookLargeFilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// ---------------------------------workroom_Admin_Not_See_Event_Due_To_Permissions---------------------------------------
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
	By generate_Coverpage = By.xpath("//span[contains(text(),'Generate Coverpage')]");

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
		driver.findElement(generate_Coverpage).click();
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
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\largebook_1.pdf";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void add_First_Cat_File_2() throws InterruptedException {
		String input = "//input[@id='files_']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\largebook_2.pdf";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	public void file_Save_Btn() throws InterruptedException {
		driver.findElement(file_SaveBtn).click();
		Thread.sleep(1000);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_Large_File_1_To_First_Catagory() throws InterruptedException {
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
		this.click_Workroom_Library_Crumb();
		this.verify_Book_Visible();
		System.out.println("------- Completed --> make_Book_Visible()  -----------");
	}
	
	// --------------delete_Book-----------------------------------
	By book_Dropdown = By.xpath("//a[contains(text(),'This is a Book Title')]/following::div[@class='dropdown header-actions']");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By form = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");

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
}