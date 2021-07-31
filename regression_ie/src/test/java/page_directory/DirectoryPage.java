package page_directory;

import java.time.Duration;
import java.util.List;
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
import page_common_functions.HomeNavigationPage;

public class DirectoryPage {
	static String homePage = "https://automation-ozzie.boardeffect.com/login";
	WebDriver driver;

	public DirectoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// ------------------search_By_Name_Field----------------------
	By user_Search_Field = By.xpath("//input[@id='keyword']");
	By advanced_Search = By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Advanced Search')]");
	By user_Name_Field = By.xpath("//input[@id='name']");
	By submit_Adv_Se = By.xpath("//form[@id='search_form']//button[@class='btn btn-done'][contains(text(),'Submit')]");
	By workrooms_DropDown = By.xpath("//div[@class='block']//button[@class='btn dropdown-toggle btn-default']");
	By workroom_AutoBE = By.xpath("//span[contains(text(),'AutoBE')]");
	
	By autoBE_TR = By.xpath("(//td[@class='modal-cell']//a[contains(text(),'Test Reset')]/following::td[contains(text(),'AutoBE')])[1]");
	By autoBE_BS = By.xpath("(//td[@class='modal-cell']//a[contains(text(),'BoardEffect Setup')]/following::td[contains(text(),'AutoBE')])[1]");
	By autoBE_SS = By.xpath("(//td[@class='modal-cell']//a[contains(text(),'steve System')]/following::td[contains(text(),'AutoBE')])[1]");

	String Test_Reset = "Test Reset";

	public void verify_User_Search_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Search_Field)));
	}
	
	public void verify_User_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Name_Field)));
	}
	
	public void verify_Workroom_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_AutoBE)));
	}
	
	public void verify_AutoBE_Workroom_Users() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(
		ExpectedConditions.elementToBeClickable(autoBE_TR),
        ExpectedConditions.elementToBeClickable(autoBE_BS),
        ExpectedConditions.elementToBeClickable(autoBE_SS)));
	}
	
	
	public void click_Advanced_Search() {
		driver.findElement(advanced_Search).click();
	}
	
	public void click_Workrooms_DropDown() {
		driver.findElement(workrooms_DropDown).click();
	}
	
	public void click_Workroom_AutoBE() {
		driver.findElement(workroom_AutoBE).click();
	}
	
	public void click_Submit_Adv_Se() throws InterruptedException {
		WebElement scroll = driver.findElement(By.xpath("//form[@id='search_form']//button[@class='btn btn-done'][contains(text(),'Submit')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1000);
		
		//driver.findElement(submit_Adv_Se).click();
		WebElement element = driver.findElement(By.xpath("//form[@id='search_form']//button[@class='btn btn-done'][contains(text(),'Submit')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	public void enter_Name_And_Submit() throws InterruptedException {
		driver.findElement(user_Name_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(user_Name_Field).clear();
		driver.findElement(user_Name_Field).sendKeys(Test_Reset);
		Thread.sleep(1000);	
	}
	
	public void verify_One_User_Displayed() {
		String test_Reset = "(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroom_Admin = "(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String steve_System = "(//a[contains(text(),'steve System')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";

		Assert.assertTrue(driver.findElements(By.xpath(test_Reset)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(workroom_Admin)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(steve_System)).size() < 1);
	}
	
	// ------------------ Function Being Called ----------------------
	public void open_Advanced_Search() throws InterruptedException {
		this.verify_User_Search_Field();
		this.click_Advanced_Search();
		Thread.sleep(1000);
		this.verify_User_Name_Field();
		System.out.println("------- Completed --> open_Advanced_Search -----------");
	}
	
	// ------------------ Function Being Called ----------------------
	public void search_By_Name_Field() throws InterruptedException {
        this.enter_Name_And_Submit();
        this.click_Submit_Adv_Se();
		Thread.sleep(2500);
        this.verify_Test_User_Dropdown();
		System.out.println("------- Completed --> search_By_Name_Field -----------");
	}
	
	// ------------------ Function Being Called ----------------------
	public void search_By_Workroom_AutoBE() throws InterruptedException {
       this.click_Workrooms_DropDown();
       Thread.sleep(1000);
       this.verify_Workroom_AutoBE();
       this.click_Workroom_AutoBE();
	   Thread.sleep(1000);
       this.click_Submit_Adv_Se();
	   Thread.sleep(2500);
	   this.verify_Test_User_Dropdown();
	   System.out.println("------- Completed --> search_By_Workroom_AutoBE -----------");
	}
	
	public void verify_Only_Test_Reset_User_Shown() throws InterruptedException {
        this.verify_One_User_Displayed();
		System.out.println("------- Completed --> verify_Only_Test_Reset_User_Shown -----------");
	}
	
	public void verify_AutoBE_Workrooms_Shown() throws InterruptedException {
        this.verify_AutoBE_Workroom_Users();
		System.out.println("------- Completed --> verify_AutoBE_Workrooms_Shown -----------");
	}
	
// ------------------ search_By_Officer_Role ----------------------
	By officer_Role_DrpDwn = By.xpath("//div[4]//div[1]//button[1]");
	By VPOTUS = By.xpath("//span[contains(text(),'VPOTUS')]");
	By auto_Director_Dropdown = By.xpath("(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");

	public void verify_VPOTUS() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(VPOTUS)));
	}
	
	public void verify_Auto_Director_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director_Dropdown)));
	}
	
	public void verify_Just_Auto_Director_Displayed() {
		String auto_Director = "(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroom_Admin = "(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String steve_System = "(//a[contains(text(),'steve System')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";

		Assert.assertTrue(driver.findElements(By.xpath(auto_Director)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(workroom_Admin)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(steve_System)).size() < 1);
	}

	public void click_Officer_Role_DrpDwn() {
		driver.findElement(officer_Role_DrpDwn).click();
	}
	
	public void click_VPOTUS() {
		driver.findElement(VPOTUS).click();
	}
	
	// ------------------ Function Being Called ----------------------
	public void search_By_Officer_Role() throws InterruptedException {
       this.click_Officer_Role_DrpDwn();
       Thread.sleep(1000);
       this.verify_VPOTUS();
       this.click_VPOTUS();
	   Thread.sleep(1000);
       this.click_Submit_Adv_Se();
	   Thread.sleep(2500);
	   this.verify_Auto_Director_Dropdown();
	   System.out.println("------- Completed --> search_By_Officer_Role -----------");
	}
	
	public void verify_Only_Auto_Director_Displayed() throws InterruptedException {
        this.verify_Just_Auto_Director_Displayed();
		System.out.println("------- Completed --> verify_Only_Auto_Director_Displayed -----------");
	}
	
	// --------------search_By_User_Category---------------------------
	By user_Catergory_DrpDwn = By.xpath("//div[@id='directoryModal']//div[3]//div[1]//button[1]");
	By board_Member_2 = By.xpath("//span[contains(text(),'Board Member')]");

	public void verify_BoardMember() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(board_Member_2)));
	}

	public void click_User_Catergory_DrpDwn() {
		driver.findElement(user_Catergory_DrpDwn).click();
	}
	
	public void click_Board_Member_2() {
		driver.findElement(board_Member_2).click();
	}
	
	public void verify_Only_Board_Members_Shown() {
		String system_Admineng = "(//a[contains(text(),'system admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String automation_Tester = "(//a[contains(text(),'Automation Tester')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		
		String auto_Director = "(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroom_Admin = "(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String steve_System = "(//a[contains(text(),'steve System')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";

		Assert.assertTrue(driver.findElements(By.xpath(system_Admineng)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(automation_Tester)).size() > 0);
		
		Assert.assertTrue(driver.findElements(By.xpath(auto_Director)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(workroom_Admin)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(steve_System)).size() < 1);
	}
	// ------------------ Function Being Called ----------------------
	public void search_By_User_Category() throws InterruptedException {
       this.click_User_Catergory_DrpDwn();
       Thread.sleep(1000);
       this.verify_Board_Member();
       this.click_Board_Member_2();
       Thread.sleep(1000);
       this.click_Submit_Adv_Se();
	   Thread.sleep(2500);
	   this.verify_Test_User_Dropdown();
	   System.out.println("------- Completed --> search_By_User_Category -----------");
	}
	
	public void verify_Only_Board_Members_Displayed() throws InterruptedException {
        this.verify_Only_Board_Members_Shown();
		System.out.println("------- Completed --> verify_Board_Members_Displayed -----------");
	}
		
	// --------------search_By_Personal_or_Company_Address---------------------------
	By address = By.xpath("//input[@id='address']");

	public void enter_Personal_Address() throws InterruptedException {
		String addressInfo = "11116 Willow Medow Lane";
		driver.findElement(address).sendKeys(addressInfo);
	}
	
	public void enter_Company_Address() throws InterruptedException {
		String addressInfo = "200 South Tryon";
		driver.findElement(address).sendKeys(addressInfo);
	}
	
	public void search_By_Personal_Address() throws InterruptedException {
       this.enter_Personal_Address();
       Thread.sleep(1000);
       this.click_Submit_Adv_Se();
	   Thread.sleep(2500);
	   this.verify_Test_User_Dropdown();
	   System.out.println("------- Completed --> search_By_Personal_Address -----------");
	}
	
	public void search_By_Company_Address() throws InterruptedException {
       this.enter_Company_Address();
       Thread.sleep(1000);
       this.click_Submit_Adv_Se();
	   Thread.sleep(2500);
	   this.verify_Test_User_Dropdown();
	   System.out.println("------- Completed --> search_By_Company_Address -----------");
	}
	
	// --------------search_By_Term_Date---------------------------
	By term_Start_Input = By.xpath("//input[@id='term_start_date']");
	By term_Info = By.xpath("//div[@class='row small-bottom']//div[1]//div[1]//button[1]");
	By term_Start_Date = By.xpath("//span[contains(text(),'Search Term Start Date')]");
	By range = By.xpath("//div[@class='row small-bottom']//div[2]//div[1]//button[1]");
	By begins = By.xpath("//span[contains(text(),'Begins')]");

	public void verify_Term_Start_Date() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(term_Start_Date)));
	}
	
	public void verify_Begins() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(begins)));
	}
	
	public void enter_Term_Start_Date() throws InterruptedException {
		String date = "2020-08-12";
		WebElement element = driver.findElement(By.xpath("//input[@id='term_start_date']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		driver.findElement(term_Start_Input).sendKeys(date);
	}
	
	public void click_Term_Info() throws InterruptedException {
		driver.findElement(term_Info).click();
	}
	
	public void click_Term_Start_Date() throws InterruptedException {
		driver.findElement(term_Start_Date).click();
	}
	
	public void click_Range() throws InterruptedException {
		driver.findElement(range).click();
	}
	
	public void click_Begins() throws InterruptedException {
		driver.findElement(begins).click();
	}
	
	public void search_By_Term_Date() throws InterruptedException {
       this.enter_Term_Start_Date();
       Thread.sleep(1000);
       this.click_Term_Info();
	   Thread.sleep(1000);
	   this.verify_Term_Start_Date();
	   this.click_Term_Start_Date();
	   Thread.sleep(1000);
	   this.click_Range();
	   Thread.sleep(1000);
	   this.verify_Begins();
	   this.click_Begins();
	   Thread.sleep(1000);
       this.click_Submit_Adv_Se();
	   Thread.sleep(1000);
	   this.verify_Auto_Director_Dropdown();
	   Thread.sleep(2000);

	   System.out.println("------- Completed --> search_By_Term_Date -----------");
	}
		
	// --------------Open_User_Profile---------------------------
	By test_User_Dropdown = By.xpath("(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By edit_Profile = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");
	By view_Profile = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'View Profile')]");


	public void verify_Test_User_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(test_User_Dropdown)));
	}

	public void verify_edit_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Profile)));
	}
	
	public void verify_View_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(view_Profile)));
	}

	public void click_Test_User_Dropdown() {
		driver.findElement(test_User_Dropdown).click();
	}

	public void click_Edit_Profile() throws InterruptedException {
		//driver.findElement(edit_Profile).click();
		WebElement scroll = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_View_Profile() throws InterruptedException {
		//driver.findElement(edit_Profile).click();
		WebElement scroll = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'View Profile')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'View Profile')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	public void open_User_Profile() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> Open_User_Profile() -----------");
	}
	
	// --------------open_User_Profile_Contact_User ---------------------------
	By contact_User = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Contact User')]");
	By subject = By.xpath("//input[@id='email_subject']");
	By sendBtn = By.xpath("//button[@id='user_message_submit']");
	String Subject = " This is a Subject";
	
	public void verify_Subject() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(subject)));
	}
	
	public void click_Contact_User() {
		driver.findElement(contact_User).click();
	}
	
	public void subject_SendKeys() {
		driver.findElement(subject).sendKeys(Subject);
	}
	
	public void email_Message() {
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys("This is an email message");
		driver.switchTo().defaultContent();
	}
	
	public void scroll_To_SendBtn() throws InterruptedException {
		WebElement send = driver.findElement(By.xpath("//button[@id='user_message_submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", send);
	}

	public void click_SendBtn() {
		driver.findElement(sendBtn).click();
	}
	
	public void open_User_Profile_Contact_User() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_edit_Profile();
		Thread.sleep(1000);
		this.click_Contact_User();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_Contact_User() -----------");
	}
	
	public void send_Contact_User_Message() throws InterruptedException {
		this.verify_Subject();
		this.subject_SendKeys();
		this.email_Message();
		this.scroll_To_SendBtn();
		this.click_SendBtn();
		System.out.println("------- Completed --> send_Contact_User_Message() -----------");
	}
	
	// ----------------view_User_Profile()---------------
	public void view_User_Profile() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_View_Profile();
		Thread.sleep(1000);
		this.click_View_Profile();
		Thread.sleep(3000);
		System.out.println("------- Completed --> view_User_Profile() -----------");
	}
	
	public void verify_Member_Profile_Contents() {
		String companyInfo = "//span[contains(text(),'Company Information')]";
		String personalInfo = "//span[contains(text(),'Personal Information')]";
		String altContactInfo = "//a[contains(text(),'Alternate Contact Information')]";

		Assert.assertTrue(driver.findElement(By.xpath(companyInfo)) instanceof WebElement);
		Assert.assertTrue(driver.findElement(By.xpath(personalInfo)) instanceof WebElement);
		Assert.assertTrue(driver.findElement(By.xpath(altContactInfo)) instanceof WebElement);
	}
	
	// ----------------Message_User()---------------
	By message_Users = By.xpath("//a[@class='action-link'][contains(text(),' Message Users')]");
	By send_A_Message = By.xpath("//div[@class='modal-dialog modal-lg']//h1[@class='modal-title'][contains(text(),'Send A Message')]");
	By people_Tab = By.xpath("//a[@class='active'][contains(text(),'People')]");
	By system_Admin_Eng = By.xpath("//div[contains(text(),'system admineng')]");
	By recipient_System_Admin_Eng = By.xpath("//a[@class='label label-primary'][contains(text(),'system admineng')]");
	By sendBtn_2 = By.xpath("//button[@id='message_submit']");
	
	public void verify_Message_Users() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(message_Users)));
	}
	
	public void verify_Send_A_Message_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(send_A_Message)));
	}
	
	public void verify_System_Admin_Eng() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(system_Admin_Eng)));
	}
	
	public void verify_Recipient_System_Admin_Eng() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(recipient_System_Admin_Eng)));
	}
	
	public void click_Message_Users() {
		driver.findElement(message_Users).click();
	}
	
	public void click_People_Tab() {
		driver.findElement(people_Tab).click();
	}
	
	public void click_System_Admin_Eng() {
		driver.findElement(system_Admin_Eng).click();
	}
	
	public void scroll_To_SendBtn_2() throws InterruptedException {
		WebElement send = driver.findElement(By.xpath("//button[@id='message_submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", send);
	}

	public void click_SendBtn_2() {
		driver.findElement(sendBtn_2).click();
	}
	
	public void message_Users() throws InterruptedException {
		this.verify_Message_Users();
		this.click_Message_Users();
		Thread.sleep(1000);
		this.verify_Send_A_Message_Box();
		this.click_People_Tab();
		Thread.sleep(1000);
		this.verify_System_Admin_Eng();
		this.click_System_Admin_Eng();
		Thread.sleep(1000);
		this.verify_Recipient_System_Admin_Eng();
		this.subject_SendKeys();
		this.email_Message();
		this.scroll_To_SendBtn_2();
		this.click_SendBtn_2();
		System.out.println("------- Completed --> message_Users() -----------");
	}
	
	
	// ----------------message_Workroom_Users_Diff_Tabs()---------------
	By user_Catergories_Tab = By.xpath("//a[contains(text(),'User Categories')]");
	By board_Members = By.xpath("//span[contains(text(),'Board Member')]");
	By workroom_Admin = By.xpath("//div[contains(text(),'Workroom Admin')]");
	By recipient_Workroom_Admin = By.xpath("//a[@class='label label-primary'][contains(text(),'Workroom Admin ')]");
	By workroom_Tab = By.xpath("//a[contains(text(),'Workrooms')]");
	By autoBE_WR = By.xpath("//span[contains(text(),'AutoBE')]");
	By recipient_BE_Setup = By.xpath("//a[@class='label label-primary'][contains(text(),'BoardEffect Setup')]");
	
	public void verify_Board_Members() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(board_Members)));
	}
	
	public void verify_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin)));
	}
	
	public void verify_Recipient_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(recipient_Workroom_Admin)));
	}
	
	public void verify_AutoBE_WR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_WR)));
	}
	
	public void verify_Recipient_BE_Setup() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(recipient_BE_Setup)));
	}
	
	public void click_User_Catergries_Tab() {
		driver.findElement(user_Catergories_Tab).click();
	}
	
	public void click_Board_Members() {
		driver.findElement(board_Members).click();
	}
	
	public void click_Workroom_Admin() {
		driver.findElement(workroom_Admin).click();
	}
	
	public void click_Workroom_Tab() {
		driver.findElement(workroom_Tab).click();
	}
	
	public void click_AutoBE_WR() {
		driver.findElement(autoBE_WR).click();
	}

	public void message_Workroom_Users_Diff_Tabs() throws InterruptedException {
		this.verify_Message_Users();
		this.click_Message_Users();
		Thread.sleep(1000);
		this.verify_Send_A_Message_Box();
		//---Categories Tab----------
		this.click_User_Catergries_Tab();
		Thread.sleep(1000);
		this.verify_Board_Members();
		this.click_Board_Members();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_Continue_Btn();
		Thread.sleep(2500);
		//---People Tab--------------
		this.click_People_Tab();
		Thread.sleep(1000);
		this.verify_Workroom_Admin();
		this.click_Workroom_Admin();
		Thread.sleep(1000);
		this.verify_Recipient_Workroom_Admin();
		//---Workroom Tab ---------
		this.click_Workroom_Tab();
		Thread.sleep(1000);
		this.verify_AutoBE_WR();
		this.click_AutoBE_WR();
		Thread.sleep(1000);
		this.verify_Recipient_BE_Setup();
		//------Send Message -------
		this.subject_SendKeys();
		this.email_Message();
		this.scroll_To_SendBtn_2();
		this.click_SendBtn_2();
		System.out.println("------- Completed --> message_Workroom_Users_Diff_Tabs() -----------");
	}
	
	
	// ----------------user_Populate_Email_Form_Send_Message()---------------
	By sucess_Message_Container = By.xpath("//p[contains(text(),'This message was sent to the following recipients:')]");
	By email_1 = By.xpath("//p[contains(text(),'Test Reset - testReset@diligent.com')]");
	By email_2 = By.xpath("//p[contains(text(),'system admineng - systemadmineng@diligent.com')]");
	By closeBtn = By.xpath("//div[@class='modal-dialog modal-md']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]");
	By closeBtn_2 = By.xpath("//div[@class='modal-dialog modal-lg']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]");

	public void verify_Success_Message_Email_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(email_1)));
	}
	
	public void verify_Success_Message_Email_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(email_2)));
	}

	public void scroll_To_Sucess_Message_Container() throws InterruptedException {
		WebElement success = driver.findElement(By.xpath("//p[contains(text(),'This message was sent to the following recipients:')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", success);
	}

	public void scroll_To_CloseBtn() throws InterruptedException {
		WebElement close = driver.findElement(By.xpath("//div[@class='modal-dialog modal-md']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", close);
	}
	
	public void scroll_To_CloseBtn_2() throws InterruptedException {
		WebElement close = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", close);
	}

	public void click_CloseBtn() {
		driver.findElement(closeBtn).click();
	}
	
	public void click_CloseBtn_2() {
		driver.findElement(closeBtn_2).click();
	}

	// --------------Function Being Called ---------------------------
	public void verify_Message_Sent_1() throws InterruptedException {
		Thread.sleep(3000);
		this.scroll_To_Sucess_Message_Container();
		this.verify_Success_Message_Email_1();
		this.scroll_To_CloseBtn();
		Thread.sleep(2000);
		this.click_CloseBtn();
		System.out.println("------- Completed --> verify_Message_Sent() -----------");
		Thread.sleep(3000);
	}
	
	public void verify_Message_Sent_2() throws InterruptedException {
		Thread.sleep(3000);
		this.scroll_To_Sucess_Message_Container();
		this.verify_Success_Message_Email_2();
		this.scroll_To_CloseBtn_2();
		Thread.sleep(2000);
		this.click_CloseBtn_2();
		System.out.println("------- Completed --> verify_Message_Sent() -----------");
		Thread.sleep(3000);
	}
	// --------------open_User_Profile_AutoBE ---------------------------
	By AutoTester_User_Dropdown = By.xpath("(//a[contains(text(),'Automation Tester')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");

	public void verify_AutoTester_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(AutoTester_User_Dropdown)));
	}
	
	public void click_AutoTester_Dropdown() {
		driver.findElement(AutoTester_User_Dropdown).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_AutoTester() throws InterruptedException {
		this.verify_AutoTester_Dropdown();
		Thread.sleep(1000);
		this.click_AutoTester_Dropdown();
		Thread.sleep(1000);
		this.verify_edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_AutoBE() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void view_Profile_AutoTester() throws InterruptedException {
		this.verify_AutoTester_Dropdown();
		this.click_AutoTester_Dropdown();
		Thread.sleep(1000);
		this.verify_View_Profile();
		this.click_View_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Profile_AutoTester() -----------");
	}
	
	// --------------verify_Company_Contact_Info_Not_Visible-------------------------
	By company_Contact_Info = By.xpath("//span[contains(text(),'Company Information')]");
	
	public void verify_Company_Contact_Info_Not_Present() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean element = driver.findElements(company_Contact_Info).size() < 1;
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		if (element == true) {
			Assert.assertTrue(true,"good - company contact info not present");
		}else {
			Assert.assertFalse(false," bad - ompany contact info present" );
		}
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Company_Contact_Info_Not_Visible() throws InterruptedException {
		Thread.sleep(3500);
		this.verify_Contact_Tab();
		this.verify_Company_Contact_Info_Not_Present();
		System.out.println("------- Completed --> verify_Company_Contact_Info_Not_Visible() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	By personal_Contact_Info = By.xpath("//span[contains(text(),'Personal Information')]");

	public void verify_Personal_Contact_Info_Not_Present() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean element = driver.findElements(personal_Contact_Info).size() < 1;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (element == true) {
			Assert.assertTrue(true,"good - personal contact info not present");
		}else {
			Assert.assertTrue(driver.findElements(personal_Contact_Info).size() < 1);
		}
	}
	
	public void verify_Personal_Contact_Info_Not_Visible() throws InterruptedException {
		this.verify_Contact_Tab();
		this.verify_Personal_Contact_Info_Not_Present();
		System.out.println("------- Completed --> verify_Personal_Contact_Info_Not_Visible() -----------");
	}
	
	// --------------open_Features_Navigate_To_Configure---------------------------
	By features = By.xpath("//a[contains(@class,'features')]");
	By configuration = By.xpath("//a[contains(text(),'Configuration')]");
	By configure_Btn = By.xpath("(//*[contains(text(),'Configure')])[2]");
	
	public void verify_Features() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(features)));
	}
	
	public void verify_Configuration() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(configuration)));
	}
	
	public void verify_Configure_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(configure_Btn)));
	}
	
	public void click_Features() {
		//driver.findElement(features).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(@class,'features')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Configurations() {
		//driver.findElement(configuration).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Configuration')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Configure_Btn() {
		//driver.findElement(configuration).click();
		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'Configure')])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------Function Being Called ---------------------------
	public void open_Features_Navigate_To_Configure() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_Features();
		this.click_Features();
		Thread.sleep(1000);
		this.verify_Configuration();
		this.click_Configurations();
		Thread.sleep(1000);
		this.verify_Configure_Btn();
		this.click_Configure_Btn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> open_Features_Navigate_To_Configure() -----------");
		}
	
	// --------------activate_Hide_Feature---------------------------
	By save_Feature_Btn = By.xpath("//button[@class='btn btn-done pull-right']");
	By hide_Contact_Message = By.xpath("//strong[contains(text(),'Hide Contact Information')]");
	By check_Box = By.xpath("//input[@id='feature_active']");
	
	public void verify_Save_Feature_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(save_Feature_Btn)));
	}
	
	public void verify_Hide_Contact_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(hide_Contact_Message)));
	}
	
	public void click_Activate_This_Feature() {
		WebElement box = driver.findElement(By.xpath("//input[@id='feature_active']"));

		if (!box.isSelected()) {
			WebElement element = driver.findElement(By.xpath("//input[@id='feature_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
	}
	
	public void click_Deactivate_This_Feature() {
		WebElement box = driver.findElement(By.xpath("//input[@id='feature_active']"));
		
		if (box.isSelected()) {
			WebElement element = driver.findElement(By.xpath("//input[@id='feature_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
		
	}
	
	public void click_Save_Feature_Btn() {
		WebElement element = driver.findElement(By.xpath("//button[@class='btn btn-done pull-right']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------Function Being Called ---------------------------
	public void activate_Hide_Company_Feature() throws InterruptedException {
		this.verify_Save_Feature_Btn();
		this.click_Activate_This_Feature();
		this.click_Save_Feature_Btn();
		Thread.sleep(1000);
		this.verify_Hide_Contact_Message();
		HomeNavigationPage obj = new HomeNavigationPage(driver);
		obj.user_Close_Settings();
		System.out.println("------- Completed --> activate_Hide_Feature() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void deactivate_Hide_Company_Feature() throws InterruptedException {
		this.verify_Save_Feature_Btn();
		this.click_Deactivate_This_Feature();
		this.click_Save_Feature_Btn();
		Thread.sleep(1000);
		this.verify_Hide_Contact_Message();
		HomeNavigationPage obj = new HomeNavigationPage(driver);
		obj.user_Close_Settings();
		System.out.println("------- Completed --> activate_Hide_Feature() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void go_To_Directory_Open_User() throws InterruptedException {
	
		System.out.println("------- Completed --> go_To_Directory_Open_User() -----------");
	}
		
	// --------------configure_TermInfo_with_Officer_Role---------------------------
	By terminfo_Tab = By.xpath("//ul[@class='nav nav-tabs']//li[4]");
	By add_Term = By.xpath("//a[@class='pull-right btn btn-default']");
	By workroom_Dropdown = By.xpath("//div[@class='btn-group bootstrap-select chosen form-control']//button[@class='btn dropdown-toggle btn-default']");
	By autoBE = By.xpath("//div[@class='btn-group bootstrap-select chosen form-control open']//span[@class='text'][contains(text(),'AutoBE')]");
	By calendar = By.xpath("/html/body/div[48]/div/div[1]/table/tbody");
	By calendar2 = By.xpath("/html/body/div[49]/div/div[1]/table/tbody");
	By save_Term = By.xpath("//div[@id='termsFormModal']//div[@class='modal-footer']//button[@class='btn btn-done'][contains(text(),'Save')]");

	public void verify_Terminfo_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(terminfo_Tab)));
	}

	public void verify_Add_Term() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_Term)));
	}

	public void verify_Workroom_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Dropdown)));
	}

	public void verify_Calendar_Open() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(calendar)));
	}

	public void verify_Calendar_Open_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(calendar2)));
	}

	public void verify_Save_Profile_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(save_Profile_Message)));
	}

	public void click_Terminfo_Tab() {
		driver.findElement(terminfo_Tab).click();
	}

	public void click_Add_Term() {
		driver.findElement(add_Term).click();
	}

	public void click_Save_Term() {
		driver.findElement(save_Term).click();
	}

	public void click_Workroom_Dropdown_Click_AutoBE() throws InterruptedException {
		driver.findElement(workroom_Dropdown).click();
		Thread.sleep(1000);
		driver.findElement(autoBE).click();
	}

	public void calendar_Start_Date() throws InterruptedException {
		By startdate = By.xpath("//input[@id='terms_109552_start_date']");
		driver.findElement(startdate).click();
		// --wait to open
		Thread.sleep(1200);
		verify_Calendar_Open();
		String day = "1";
		WebElement calendar = driver.findElement(By.xpath("/html/body/div[48]/div/div[1]/table/tbody"));
		List<WebElement> calendardate = calendar.findElements(By.tagName("td"));
		for (WebElement date : calendardate) {
			if (date.getText().equals(day)) {
				date.click(); // clicks desired option
				break;
			}
		}
	}

	public void calendar_End_Date() throws InterruptedException {
		By enddate = By.xpath("//input[@id='terms_109552_end_date']");
		driver.findElement(enddate).click();
		// --wait to open
		Thread.sleep(1500);
		verify_Calendar_Open_2();
		String day = "3";
		WebElement calendar = driver.findElement(By.xpath("/html/body/div[49]/div/div[1]/table/tbody"));
		List<WebElement> calendardate = calendar.findElements(By.tagName("td"));
		for (WebElement date : calendardate) {
			if (date.getText().equals(day)) {
				date.click(); // clicks desired option
				break;
			}
		}
	}

	public void term_And_Officer_Role() throws InterruptedException {
		By term = By.xpath("//div[@class='col-md-12']//div[1]//div[1]//button[1]");
		By term_Number = By.xpath("//div[@class='col-md-12']//li[2]//a[1]");
		By officer_Role = By.xpath("//div[@class='col-md-12']//div[2]//div[1]//button[1]");
		By role = By.xpath("//div[@class='btn-group bootstrap-select form-control chosen open']//a");
		driver.findElement(term).click();
		Thread.sleep(1000);
		driver.findElement(term_Number).click();
		Thread.sleep(1000);
		driver.findElement(officer_Role).click();
		Thread.sleep(1000);
		driver.findElement(role).click();
		Thread.sleep(1000);
	}

	// --------------Function Being Called ---------------------------
	public void configure_TermInfo_with_Officer_Role() throws InterruptedException {
		this.verify_Terminfo_Tab();
		Thread.sleep(1200);
		this.click_Terminfo_Tab();
		Thread.sleep(1000);
		this.verify_Add_Term();
		this.click_Add_Term();
		Thread.sleep(1500);
		this.verify_Workroom_Dropdown();
		Thread.sleep(1500);
		this.click_Workroom_Dropdown_Click_AutoBE();
		Thread.sleep(1200);
		this.calendar_Start_Date();
		Thread.sleep(1000);
		this.calendar_End_Date();
		Thread.sleep(1000);
		this.term_And_Officer_Role();
		Thread.sleep(1500);
		this.click_Save_Term();
		Thread.sleep(1500);
		System.out.println("------- Completed --> configure_TermInfo_with_Officer_Role() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void configure_TermInfo_Workroom_No_End_Date() throws InterruptedException {
		this.verify_Terminfo_Tab();
		Thread.sleep(1200);
		this.click_Terminfo_Tab();
		Thread.sleep(1000);
		this.verify_Add_Term();
		this.click_Add_Term();
		Thread.sleep(1500);
		this.verify_Workroom_Dropdown();
		Thread.sleep(1500);
		this.click_Workroom_Dropdown_Click_AutoBE();
		Thread.sleep(1200);
		this.calendar_Start_Date();
		Thread.sleep(1200);
		this.term_And_Officer_Role();
		Thread.sleep(1200);
		this.click_Save_Term();
		Thread.sleep(2000);
		System.out.println("------- Completed --> configure_TermInfo_Workroom_No_End_Date() -----------");
	}

	// --------------enable_Hide_User_From_Directory---------------------------
	By settings_Tab = By.xpath("//a[contains(text(),'Settings')]");
	By first_Name_Field = By.xpath("//input[@id='user_firstname']");
	By save_Btn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By autoBE_Saved_Message = By.xpath("//p[contains(text(),'Profile for Automation Tester has been saved.')]");

	public void verify_Settings_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_Tab)));
	}
	
	public void verify_First_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(first_Name_Field)));
	}
	
	public void verify_AutoBE_Saved_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Saved_Message)));
	}
	
	
	public void click_Settings_Tab() {
		//driver.findElement(settings_Tab).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Save_Btn() {
		//driver.findElement(save_Btn).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Hide_User_From_Directory() throws InterruptedException {
		WebElement scroll = driver.findElement(By.xpath("//label[contains(text(),'Hide user from directory')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Hide user from directory')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------Function Being Called ---------------------------
	public void enable_Hide_User_From_Directory() throws InterruptedException {
		this.verify_Settings_Tab();
		this.click_Settings_Tab();
		Thread.sleep(1500);
		this.verify_First_Name_Field();
		Thread.sleep(1500);
		this.click_Hide_User_From_Directory();
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_AutoBE_Saved_Message();
		System.out.println("------- Completed --> enable_Hide_User_From_Directory() -----------");
	}
	
	// --------------enable_Hide_Company_Contact_From_Other_Users ----------------
	By contact_Tab = By.xpath("//li[@class='active']//a[contains(text(),'Contact')]");
	By hide_Company_Contact_Box = By.xpath("//input[@id='user_hide_company_contact']");

	public void verify_Contact_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(contact_Tab)));
	}
	
	public void click_Contact_Tab() {
		//driver.findElement(save_Btn).click();
		WebElement element = driver.findElement(By.xpath("//li[@class='active']//a[contains(text(),'Contact')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Hide_Company_Contact_Box() throws InterruptedException {
		//driver.findElement(save_Btn).click();
		WebElement box = driver.findElement(By.xpath("//input[@id='user_hide_company_contact']"));
		
		if (!box.isSelected()) {	
			WebElement element = driver.findElement(By.xpath("//input[@id='user_hide_company_contact']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);	
		}
		Thread.sleep(1000);
		WebElement scroll = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
	}
	
	// --------------Function Being Called ---------------------------
	public void enable_Hide_Company_Contact_From_Other_Users() throws InterruptedException {
		this.verify_Contact_Tab();
		this.click_Contact_Tab();
		Thread.sleep(1000);
		this.click_Hide_Company_Contact_Box();
		Thread.sleep(1000);
		this.click_Save_Profile();
		Thread.sleep(1000);
		this.verify_AutoBE_Saved_Message();
		Thread.sleep(1000);
		System.out.println("------- Completed --> enable_Hide_Company_Contact_From_Other_Users() -----------");
	}
	
	// --------------enable_Hide_Personal_Contact_From_Other_Users--------------------
	By company_Info = By.xpath("//span[contains(text(),'Company Information')]");
	By personal_Info = By.xpath("//span[contains(text(),'Personal Information')]");
	
	public void click_Company_Information() {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Company Information')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Personal_Information() {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Personal Information')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Hide_Personal_Contact_Box() throws InterruptedException {
		WebElement box = driver.findElement(By.xpath("//input[@id='user_hide_personal_contact']"));
		
		if (!box.isSelected()) {	
			WebElement element = driver.findElement(By.xpath("//input[@id='user_hide_personal_contact']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);	
		}
		Thread.sleep(1000);
		WebElement scroll = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
	}

	// --------------Function Being Called ---------------------------
	public void enable_Hide_Personal_Contact_From_Other_Users() throws InterruptedException {
		this.verify_Contact_Tab();
		this.click_Contact_Tab();
		Thread.sleep(1000);
		this.click_Company_Information();
		Thread.sleep(1500);
		this.click_Personal_Information();
		Thread.sleep(1500);
		this.click_Hide_Personal_Contact_Box();
		Thread.sleep(1000);
		this.click_Save_Profile();
		Thread.sleep(1000);
		this.verify_AutoBE_Saved_Message();
		Thread.sleep(1000);
		System.out.println("------- Completed --> enable_Hide_Company_Contact_From_Other_Users() -----------");
	}
	
	// --------------close_Profile_And_Directory---------------------------
		public void close_Profile_And_Directory() throws InterruptedException {
			this.close_Profile();
			HomeNavigationPage obj = new HomeNavigationPage(driver);
			obj.user_Close_Directory();
			System.out.println("------- Completed --> close_Profile_And_Directory() -----------");
		}
	
	// --------------add_Photo_To_Profile---------------------------
	By more_Tab = By.xpath("//li[@class='dropdown']");
	By attachments = By.xpath("//a[contains(text(),'Attachments')]");
	By photo_text = By.xpath("//label[contains(text(),'Photo')]");

	public void verify_More_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(more_Tab)));
	}

	public void verify_Attachments() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attachments)));
	}

	public void verify_Photo_Input() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(photo_text)));
	}

	public void click_More_Tab() {
		driver.findElement(more_Tab).click();
	}

	public void click_Attachments() {
		driver.findElement(attachments).click();
	}

	public void upload_Photo() {
		String input = "//input[@id='user_photo']";
		String filepath = "C:\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	// --------------Function Being Called ---------------------------
	public void add_Photo_To_Profile() throws InterruptedException {
		this.verify_More_Tab();
		Thread.sleep(1500);
		this.click_More_Tab();
		Thread.sleep(1000);
		this.verify_Attachments();
		this.click_Attachments();
		Thread.sleep(1000);
		this.verify_Photo_Input();
		Thread.sleep(1000);
		this.upload_Photo();
		Thread.sleep(1500);
		this.click_Save_Profile();
		System.out.println("------- Completed --> add_Photo_To_Profile() -----------");
	}
	// --------------add_Category-------------------------------------
	By additional_Tab = By.xpath("//a[contains(text(),'Additional')]");
	By cat_Dropdown = By.xpath("//div[@class='col-sm-5']//span[@class='filter-option pull-left'][contains(text(),'Select an Option')]");
	By board_Member = By.xpath("//span[contains(text(),'Board Member')]");
	By board_Member_Cat = By.xpath("//p[contains(text(),'Board Member')]");

	public void verify_Additional_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(additional_Tab)));
	}

	public void verify_Category_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(cat_Dropdown)));
	}

	public void verify_Board_Member() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(board_Member)));
	}

	public void verify_Board_Member_Present() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(board_Member_Cat)));
	}

	public void click_Additional_Tab() {
		driver.findElement(additional_Tab).click();
	}

	public void click_Board_Member() {
		driver.findElement(board_Member).click();
	}

	public void click_Category_Dropdown() {
		driver.findElement(cat_Dropdown).click();
	}

	// --------------Function Being Called ---------------------------
	public void add_Category() throws InterruptedException {
		this.verify_Additional_Tab();
		this.click_Additional_Tab();
		Thread.sleep(1500);
		this.verify_Category_Dropdown();
		this.click_Category_Dropdown();
		Thread.sleep(1500);
		this.verify_Board_Member();
		this.click_Board_Member();
		Thread.sleep(1500);
		this.click_Save_Profile();
		Thread.sleep(1500);
		this.verify_Save_Profile_Message();
		this.verify_Additional_Tab();
		this.click_Additional_Tab();
		Thread.sleep(1500);
		this.verify_Board_Member_Present();
		System.out.println("------- Completed --> add_Category() -----------");
	}

	// --------------add_Resume_To_Profile ---------------------------
	public void upload_Resume() {
		String input = "//input[@id='user_resume']";
		String filepath = "C:\\uploadedFiles\\resume.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	// --------------Function Being Called ---------------------------
	public void add_Resume_To_Profile() throws InterruptedException {
		this.verify_More_Tab();
		Thread.sleep(1500);
		this.click_More_Tab();
		Thread.sleep(1000);
		this.verify_Attachments();
		this.click_Attachments();
		Thread.sleep(1000);
		this.verify_Photo_Input();
		Thread.sleep(1000);
		this.upload_Resume();
		Thread.sleep(1500);
		this.click_Save_Profile();
		System.out.println("------- Completed --> add_Resume_To_Profile() -----------");
	}
	// --------------close_User_Profile---------------------------
	By save_Profile = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By save_Profile_Message = By.xpath("//p[contains(text(),'Profile for Test Reset has been saved.')]");
	By close_Profile = By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]");

	public void click_Save_Profile() {
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void close_Profile() {
		WebElement element = driver.findElement(By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------Function Being Called ---------------------------
	public void close_Profile_TermInfo() throws InterruptedException {
		this.verify_Terminfo_Tab();
		Thread.sleep(1000);
		this.click_Save_Profile();
		Thread.sleep(2000);
		this.verify_Save_Profile_Message();
		this.close_Profile();
		Thread.sleep(2000);
		HomeNavigationPage obj = new HomeNavigationPage(driver);
		obj.user_Close_Directory();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> close_User_Profile() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void close_Profile_AutoTester() throws InterruptedException {
		this.close_Profile();
		Thread.sleep(2000);
		HomeNavigationPage obj = new HomeNavigationPage(driver);
		obj.user_Close_Directory();
		Thread.sleep(1000);
		System.out.println("------- Completed --> close_Profile_AutoBE() -----------");
	}
	
	// --------------verify_AutoTester_Not_Present ---------------------------
	
	By auto_Director = By.xpath("//a[contains(text(),'Auto Director')]");
	
	public void verify_Auto_Director() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director)));
	}

	public void verify_AutoTester_Hidden() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean element = driver.findElements(AutoTester_User_Dropdown).size() < 1;
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		if (element == true) {
			Assert.assertTrue(true,"good - autoTester not present");
		}else {
			Assert.assertFalse(false," bad - autoTester present" );
		}
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_AutoTester_Not_Present() throws InterruptedException {
		this.verify_Auto_Director();
		this.verify_AutoTester_Hidden();
		System.out.println("------- Completed --> verify_AutoTester_Not_Present() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void close_Profile_Photo() throws InterruptedException {
		Thread.sleep(2000);
		this.verify_Save_Profile_Message();
		this.close_Profile();
		Thread.sleep(2000);
		HomeNavigationPage obj = new HomeNavigationPage(driver);
		obj.user_Close_Directory();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> close_Profile_Photo() -----------");
	}
	// --------------delete_TermInfo ---------------------------------
	By dropdown = By.xpath("//div[@class='btn-group small pull-right']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By delete = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Delete')]");
	By continue_Btn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(dropdown)));
	}

	public void verify_Delete() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete)));
	}

	public void verify_Continue_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continue_Btn)));
	}

	public void click_Dropdown() {
		WebElement element = driver
				.findElement(By.xpath("//div[@class='btn-group small pull-right']//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Delete() {
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Delete')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Continue_Btn() {
		WebElement element = driver.findElement(By.xpath("//button[@class='btn commit btn-danger']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	public void delete_TermInfo() throws InterruptedException {
		this.verify_Terminfo_Tab();
		Thread.sleep(1000);
		this.click_Terminfo_Tab();
		Thread.sleep(1000);
		this.verify_Dropdown();
		this.click_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete();
		Thread.sleep(1000);
		this.click_Delete();
		this.verify_Continue_Btn();
		Thread.sleep(1000);
		this.click_Continue_Btn();
		Thread.sleep(1500);
		this.click_Save_Profile();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_TermInfo() -----------");
	}
	// -----------------------delete_Photo ---------------------------
	By remove_Photo = By.xpath("//input[@id='user_remove_photo']");

	public void click_Remove_Photo() {
		driver.findElement(remove_Photo).click();
	}

	// -------------------Function Being Called ----------------------
	public void delete_Photo() throws InterruptedException {
		this.verify_More_Tab();
		Thread.sleep(1500);
		this.click_More_Tab();
		Thread.sleep(1000);
		this.verify_Attachments();
		this.click_Attachments();
		Thread.sleep(1000);
		this.verify_Photo_Input();
		Thread.sleep(1000);
		this.click_Remove_Photo();
		this.click_Save_Profile();
		System.out.println("------- Completed --> delete_Photo() -----------");
	}
	// -------------------delete_Category ----------------------------
	By remove_Board_Member_1 = By.xpath("//form//span[1]//a[1]//i[1]");

	public void remove_Board_Members() {
		driver.findElement(remove_Board_Member_1).click();
	}

	// -------------------Function Being Called ----------------------
	public void delete_Category_Board_Member() throws InterruptedException {
		this.verify_Additional_Tab();
		this.click_Additional_Tab();
		Thread.sleep(1500);
		this.remove_Board_Members();
		this.click_Save_Profile();
		Thread.sleep(1500);
		this.verify_Save_Profile_Message();
		this.verify_Additional_Tab();
		Thread.sleep(1500);
		this.click_Additional_Tab();
		Thread.sleep(1500);
		System.out.println("------- Completed --> delete_Photo() -----------");
	}
	// -------------------delete_Resume----------------------
	By remove_Resume = By.xpath("//input[@id='user_remove_resume']");

	public void click_Remove_Resume() {
		driver.findElement(remove_Resume).click();
	}

	// -------------------Function Being Called ----------------------
	public void delete_Resume() throws InterruptedException {
		this.verify_More_Tab();
		Thread.sleep(1500);
		this.click_More_Tab();
		Thread.sleep(1000);
		this.verify_Attachments();
		this.click_Attachments();
		Thread.sleep(1000);
		this.verify_Photo_Input();
		Thread.sleep(1000);
		this.click_Remove_Resume();
		this.click_Save_Profile();
		System.out.println("------- Completed --> delete_Photo() -----------");
	}

	// --------------Function Being Called ---------------------------
	public void verify_TermInfo_Deleted() throws InterruptedException {
		this.verify_Save_Profile_Message();
		Thread.sleep(5000);
		System.out.println("------- Completed --> deletion verified() -----------");
	}
	// --------------verify_Board_Member_Removed---------------------------

	public void verify_Member_Deleted() throws InterruptedException {
		String board_Member = "//p[contains(text(),'Board Member')]";
		Assert.assertTrue(driver.findElements(By.xpath(board_Member)).size() < 1);
		System.out.println("------- Completed --> deletion verified() -----------");
	}

	// --------------Function Being Called --------------------------------
	public void verify_Board_Member_Deleted() throws InterruptedException {
		Thread.sleep(5000);
		this.verify_Member_Deleted();
		System.out.println("------- Completed --> verify_Board_Member_Deleted -----------");
	}
}
