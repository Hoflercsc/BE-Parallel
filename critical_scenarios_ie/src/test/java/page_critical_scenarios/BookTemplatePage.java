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

public class BookTemplatePage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public BookTemplatePage(WebDriver driver) {
		this.driver = driver;
	}
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By library = By.xpath("//span[contains(text(),'Library')]");

	// -------------------- user_Open_Workroom() ---------------------------------
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
	public void open_Library_Page_for_Workroom() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		this.verify_Library();
		this.click_Library();
		System.out.println("------- Completed --> open_Library_Page_for_Workroom() -----------");
	}
	
	// -------------------- user_Create_New_BookTemplate() ---------------------
	By book_Templates = By.xpath("//a[contains(text(),'Book Templates')]");
	By new_Template = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Template')]");
	By title_Form_Field = By.xpath("//input[@id='book_title']");

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

	public void verify_Title_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(title_Form_Field)));
	}

	public void click_Book_Templates() {
		driver.findElement(book_Templates).click();
	}

	public void click_New_Templates() {
		driver.findElement(new_Template).click();
	}

	public void enter_Book_Title() throws InterruptedException {
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
		this.enter_Book_Title();
		System.out.println("------- Completed --> user_Create_New_BookTemplate() -----------");
	}
	
	// ------------------user_Add_Coverpage_To_Book_Template---------------------
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

	// ------------------Function Being called-----------------------------------
	public void user_Add_Coverpage_To_Book_Template() throws InterruptedException {
		this.fill_Generate_Cover_Page_Form();
		System.out.println("------- Completed --> user_Add_Coverpage_To_Book_Template() -----------");
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
		Thread.sleep(1000);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Add_Agenda_To_Template() throws InterruptedException {
		this.verify_Agenda_Title();
		this.enter_Agenda_Title();
		System.out.println("------- Completed --> user_Add_Agenda_To_Template() -----------");
	}
	
	// ------------------user_Save_Book_Template-----------------------------------
	By Save_Continue_Btn = By.xpath("//*[@id='new_book']/div[3]/div[3]/p/button");

	public void click_Save_Continue_Btn() throws InterruptedException {
		driver.findElement(Save_Continue_Btn).click();
		Thread.sleep(1000);
	}
	
	// ------------------Function Being called-----------------------------------

	public void user_Save_Book_Template() throws InterruptedException {
		this.click_Save_Continue_Btn();
		System.out.println("------- Completed --> user_Save_Book_Template -----------");
	}
	
	// ------------------user_Add_First_Catagory_To_Book_Template-----------------------------------
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
	By click_For_More_Options = By.xpath("//a[contains(text(),'click for more options')]");
	By title_Field = By.xpath("//input[@id='bookfolder_title']");
	By file_SaveBtn = By.xpath("//div[@id='newBookFileModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By file_Upload_Success_Message = By.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'The following files were uploaded:')]");

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
	
	// ----------------user_Add_Second_Catagory_To_Handbook----------------------
	By main_Catagory_2 = By.xpath(
			"//body[@class='books edit inside drawer drawer--right']/div[@id='wrap']/main/div[@class='content-main']/div[@class='be-container']/div[@class='row']/div[@class='col-md-10 narrow meeting-details']/div[@class='meeting-book']/div[@class='form']/div[@class='category-accordion ui-sortable']/a[2]");

	public void verify_Main_Catagory_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(main_Catagory_2)));
	}

	public void click_Main_Catagory_2() throws InterruptedException {
		driver.findElement(main_Catagory_2).click();
		Thread.sleep(1000);
	}

	public void fill_Catagory_Form_2() throws InterruptedException {
		String catagory_Name = "New Catagory 2";
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
	public void user_Add_Second_Catagory_To_Handbook() throws InterruptedException {
		// Thread.sleep(3000);
		this.verify_Main_Catagory_2();
		this.click_Main_Catagory_2();
		this.fill_Catagory_Form_2();
		this.click_Catagory_SaveBtn();
		System.out.println("------- Completed --> user_Add_Second_Catagory()  -----------");
	}
	
	// ------------------add_File_To_Second_Catagory-----------------------------------
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

	// ------------------Function Being called-----------------------------------
	public void add_File_To_Second_Catagory() throws InterruptedException {
		this.verify_Click_For_More_Options_2();
		this.click_Click_For_More_Options_2();
		this.verify_Title_Field();
		this.title_Field_SendKeys();
		this.add_First_Cat_File();// used for 2nd Catagory here
		this.file_Save_Btn();
		//this.verify_File_Upload_Success_Message();
		System.out.println("------- Completed --> add_File_To_Second_Catagory()  -----------");
	}
	
	// ------------------open_Book_From_Templates_Page-----------------------------------
	By Book_Template_Crumb = By.xpath("//a[contains(text(),'Book Templates')]");
	By template_Title = By.xpath("//a[contains(text(),'This is a Book Template Title')]");

	public void verify_Template_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(template_Title)));
	}

	public void click_Book_Template_Crumb() throws InterruptedException {
		driver.findElement(Book_Template_Crumb).click();
		Thread.sleep(1000);
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
	
	// ------------------ Function Being called------------------------------------
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
	
	// ------------------ delete_Book_Template -----------------------------------
	By delete = By.xpath("//a[contains(text(),'Delete')]");
	By form_Input_field = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");

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

	public void click_ContinueBtn() throws InterruptedException {
		driver.findElement(continueBtn).click();
		Thread.sleep(1000);
	}

	// ------------------ Function Being called- -----------------------------------
	public void delete_Book_Template() throws InterruptedException {
		this.click_Template_Dropdown();
		this.click_Delete();
		this.verify_Form_Input_field();
		this.click_Form_Input_SendKeys();
		this.click_ContinueBtn();
		System.out.println("------- Completed --> delete_Book_Template()  -----------");
	}

	// --------------verify_Edited_Book_Template_Deleted--------------------
	public void verify_Book_Template_NOT_Visible() throws InterruptedException {
		String template = "//a[contains(text(),'This is an Edited Book Template Title')]";
		Assert.assertTrue(driver.findElements(By.xpath(template)).size() < 1);
	}
	
	// ------------------ Function Being called- -----------------------------------
	public void verify_Book_Template_Deleted() throws InterruptedException {
		Thread.sleep(3500);
		this.click_Book_Template_Crumb();
		this.verify_New_Template();
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_Book_Template_NOT_Visible();
		System.out.println("------- Completed --> verify_Book_Template_Deleted()  -----------");
	}
}
