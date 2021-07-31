package page_directory;

import java.awt.AWTException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import parallel.DriverFactory;

public class DirectoryPage {
	
	// ------------------search_By_Name_Field----------------------
	By user_Search_Field = By.xpath("//input[@id='keyword']");
	//By advanced_Search = By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Advanced Search')]");
	By advanced_Search = By.xpath("//div[@id='advanced-search-link']");
	By user_Name_Field = By.xpath("//input[@id='name']");
	By submit_Adv_Se = By.xpath("//form[@id='search_form']//button[@class='btn btn-done'][contains(text(),'Submit')]");
	By workrooms_DropDown = By.xpath("//div[@class='block']//button[@class='btn dropdown-toggle btn-default']");
	By workroom_AutoBE = By.xpath("//span[contains(text(),'AutoBE')]");
	
	By autoBE_TR = By.xpath("(//td[@class='modal-cell']//a[contains(text(),'Test Reset')]/following::td[contains(text(),'AutoBE')])[1]");
	By autoBE_BS = By.xpath("(//td[@class='modal-cell']//a[contains(text(),'BoardEffect Setup')]/following::td[contains(text(),'AutoBE')])[1]");
	By autoBE_SS = By.xpath("(//td[@class='modal-cell']//a[contains(text(),'steve System')]/following::td[contains(text(),'AutoBE')])[1]");

	String Test_Reset = "Test Reset";

	public void verify_User_Search_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Search_Field)));
	}
	
	public void verify_User_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Name_Field)));
	}
	
	public void verify_Workroom_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_AutoBE)));
	}
	
	public void verify_AutoBE_Workroom_Users() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(
		ExpectedConditions.elementToBeClickable(autoBE_TR),
        ExpectedConditions.elementToBeClickable(autoBE_BS),
        ExpectedConditions.elementToBeClickable(autoBE_SS)));
	}
	
	
	public void click_Advanced_Search() {
		DriverFactory.getInstance().getDriver().findElement(advanced_Search).click();
	}
	
	public void click_Workrooms_DropDown() {
		DriverFactory.getInstance().getDriver().findElement(workrooms_DropDown).click();
	}
	
	public void click_Workroom_AutoBE() {
		DriverFactory.getInstance().getDriver().findElement(workroom_AutoBE).click();
	}
	
	public void click_Submit_Adv_Se() throws InterruptedException {
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(By.xpath("//form[@id='search_form']//button[@class='btn btn-done'][contains(text(),'Submit')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1000);
		
		//DriverFactory.getInstance().getDriver().findElement(submit_Adv_Se).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//form[@id='search_form']//button[@class='btn btn-done'][contains(text(),'Submit')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void enter_Name_And_Submit() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(user_Name_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(user_Name_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(user_Name_Field).sendKeys(Test_Reset);
		Thread.sleep(1000);	
	}
	
	public void enter_Name_In_Default_Search(String autouser1) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(user_Search_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(user_Search_Field).sendKeys(autouser1);
		DriverFactory.getInstance().getDriver().findElement(user_Search_Field).sendKeys(Keys.RETURN);
		Thread.sleep(1000);	
	}
	
	public void verify_One_User_Displayed() {
		String test_Reset = "(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroom_Admin = "(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String steve_System = "(//a[contains(text(),'steve System')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(test_Reset)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(workroom_Admin)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(steve_System)).size() < 1);
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
	   System.out.println("------- Completed --> search_By_Workrooms -----------");
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
	//By officer_Role_DrpDwn = By.xpath("//div[4]//div[1]//button[1]");
	By officer_Role_DrpDwn = By.xpath("(//body//div[@id='directoryModal']//div//label[contains(text(),'Officer Role')]/following::button)[1]");
	By VPOTUS = By.xpath("//span[contains(text(),'VPOTUS')]");
	By auto_Director_Dropdown = By.xpath("(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By test_Reset_Dropdown = By.xpath("(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");


	public void verify_VPOTUS() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(VPOTUS)));
	}
	
	public void verify_Auto_Director_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director_Dropdown)));
	}
	
	public void verify_Test_Reset_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(test_Reset_Dropdown)));
	}
	
	public void verify_Just_Auto_Director_Displayed() {
		String auto_Director = "(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroom_Admin = "(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String steve_System = "(//a[contains(text(),'steve System')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(auto_Director)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(workroom_Admin)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(steve_System)).size() < 1);
	}

	public void click_Officer_Role_DrpDwn() {
		
		WebElement role = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//body//div[@id='directoryModal']//div//label[contains(text(),'Officer Role')]/following::button)[1]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", role);
		
		DriverFactory.getInstance().getDriver().findElement(officer_Role_DrpDwn).click();
	}
	
	public void click_VPOTUS() {
		DriverFactory.getInstance().getDriver().findElement(VPOTUS).click();
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
	//By board_Member = By.xpath("//span[contains(text(),'Board Member')]");

	public void click_User_Catergory_DrpDwn() {
		DriverFactory.getInstance().getDriver().findElement(user_Catergory_DrpDwn).click();
	}
	
	public void click_Board_Member_2() {
		DriverFactory.getInstance().getDriver().findElement(board_Member).click();
	}
	
	public void verify_Only_Board_Members_Shown() {
		String system_Admineng = "(//*[normalize-space(text())='system admineng']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String automation_Tester = "(//*[normalize-space(text())='Automation Tester']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		
		String auto_Director2 = "(//*[normalize-space(text())='Auto Director2']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroom_Admin = "(//*[normalize-space(text())='Workroom Admin']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String steve_System = "(//*[normalize-space(text())='steve System']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(system_Admineng)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(automation_Tester)).size() > 0);
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(auto_Director2)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(workroom_Admin)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(steve_System)).size() < 1);
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
	   //this.verify_Test_User_Dropdown();
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
		DriverFactory.getInstance().getDriver().findElement(address).sendKeys(addressInfo);
	}
	
	public void enter_Company_Address() throws InterruptedException {
		String addressInfo = "200 South Tryon";
		DriverFactory.getInstance().getDriver().findElement(address).sendKeys(addressInfo);
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(term_Start_Date)));
	}
	
	public void verify_Begins() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(begins)));
	}
	
	public void enter_Term_Start_Date() throws InterruptedException {
		String date = "2020-08-12";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='term_start_date']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(term_Start_Input).sendKeys(date);
	}
	
	public void click_Term_Info() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(term_Info).click();
	}
	
	public void click_Term_Start_Date() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(term_Start_Date).click();
	}
	
	public void click_Range() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(range).click();
	}
	
	public void click_Begins() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(begins).click();
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
		
	// ----------------add_Multiple_Users------------------------
	By add_User = By.xpath("//div[@id='directoryModal']//div[@id='new_users_buttons']//button[1][contains(., 'Add User')]");
	By multiple_Users = By.xpath("//div[@class='directory-actions']//a[@class='no-mobile'][contains(text(),'Add Multiple Users')]");
	By quick_Add_Modal = By.xpath("//h4[contains(text(),'Quick Add')]");
	By close_Quick_Add = By.xpath("//div[@id='quick_add']//button[@class='btn btn-default'][contains(text(),'Close')]");
	By add_Another = By.xpath("//a[@class='small-top inline-block add-another']");
	By first_Name_2nd_Row = By.xpath("//div[3]//div[3]//div[1]//div[1]//label[1]");
	By saveBtn_1 = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='formsSubmit']"); // for adding multiple users
	By everybody = By.xpath("//a[contains(text(),'Everybody')]");
	By angela_Moore_DrpDwn = By.xpath("(//a[contains(text(),'Angela Moore')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By angel_Morgan_DrpDwn = By.xpath("(//a[contains(text(),'Angel Morgan')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By deactivate_User = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Deactivate User')]");
	By profile_deactivated_Message = By.xpath("//p[contains(text(),'has been deactivated.')]");
	By settings_side_Menu_Bar = By.xpath("//div[@id='settingsModal']//div[@class='modal-sidebar-container']");
	By inactiveUsers = By.xpath("//ul[@class='nav nav-tabs']//li[2]");
	By deleteUser = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete User')]");
	By formInputField = By.xpath("//div[@class='modal-dialog']//input[@class='form-control']");
	By sucessfully_Deleted_User_Message = By.xpath("//p[contains(text(),'Successfully deleted User')]");
	String userLastName1 = "Moore";
	String userLastName2 = "Morgan";
	
	public void verify_Add_User() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_User)));
	}

	public void verify_Multiple_Users() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(multiple_Users)));
	}
	
	public void verify_Quick_Add_Modal() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(quick_Add_Modal)));
	}
	
	public void verify_CloseBtn_Quick_Add() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(close_Quick_Add)));
	}
	
	public void verify_Add_Another() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_Another)));
	}
	
	public void verify_First_Name_2nd_Row() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(first_Name_2nd_Row)));
	}
	
	public void verify_SaveBtn_User_Form() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(saveBtn_1)));
	}
	
	public void verify_Everybody() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(everybody)));
	}
	
	public void verify_Angela_Moore_And_Morgan_DrpDwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(angela_Moore_DrpDwn),
				(ExpectedConditions.elementToBeClickable(angel_Morgan_DrpDwn))));
	}
	
	public void verify_Deactivate_User() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivate_User)));
	}
	
	public void verify_Profile_Deactivated_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_deactivated_Message)));
	}
	
	public void verify_Angel_Morgan_DrpDwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(angel_Morgan_DrpDwn)));
	}
	
	public void verify_Settings_Side_Menu_Bar() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_side_Menu_Bar)));
	}
	
	public void verifyInactiveUsers() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(inactiveUsers)));
	}
	
	public void verifyDeleteUserPresent() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteUser)));
	}
	
	public void verifyFormInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(formInputField)));
	}
	
	public void verify_Sucessfully_Deleted_User_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sucessfully_Deleted_User_Message)));
	}
	
	public void click_Add_User() {
		DriverFactory.getInstance().getDriver().findElement(add_User).click();
	}
	
	public void click_Multiple_Users() {
		DriverFactory.getInstance().getDriver().findElement(multiple_Users).click();
	}
	
	public void click_Close_Quick_Add() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(close_Quick_Add).click();
	}
	
	public void click_Add_Another() {
		DriverFactory.getInstance().getDriver().findElement(add_Another).click();
	}
	
	public void click_Everybody() {
		DriverFactory.getInstance().getDriver().findElement(everybody).click();
	}
	
	public void click_Angela_Moore_DrpDwn() throws InterruptedException {
		
		WebElement SaveBtn = DriverFactory.getInstance().getDriver().findElement(angela_Moore_DrpDwn);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(angela_Moore_DrpDwn).click();
	}
	
	public void click_Deactivate_User() {
		DriverFactory.getInstance().getDriver().findElement(deactivate_User).click();
	}
	
	public void clickSaveBtn() throws InterruptedException {
		WebElement SaveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(2000);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
		// DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}
	
	public void click_Angel_Morgan_DrpDwn() throws InterruptedException {
		
		WebElement SaveBtn = DriverFactory.getInstance().getDriver().findElement(angel_Morgan_DrpDwn);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(angel_Morgan_DrpDwn).click();
	}
	
	public void clickManageUsers() {
		// DriverFactory.getInstance().getDriver().findElement(manageUsers).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Manage Users')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void clickInactiveUsers() {
		DriverFactory.getInstance().getDriver().findElement(inactiveUsers).click();
	}
	
	public void click_Angela_Moore_Dropdown() {
		// DriverFactory.getInstance().getDriver().findElement(supertestman).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Angela Moore')]/following::div[@class='btn-group small']//button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Angel_Morgan_Dropdown() {
		// DriverFactory.getInstance().getDriver().findElement(supertestman).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Angel Morgan')]/following::div[@class='btn-group small']//button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void clickDeleteUser() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(deleteUser).click();
	}

	public void form_Input_Field_SendKeys(String userlastname) {
		DriverFactory.getInstance().getDriver().findElement(formInputField).click();
		DriverFactory.getInstance().getDriver().findElement(formInputField).sendKeys(userlastname);
	}
	
	public void verify_Moore_Morgan_NOT_Visible() {
		String moore = "(//a[contains(text(),'Angela Moore')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String morgan = "(//a[contains(text(),'Angela Morgan')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(moore)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(morgan)).size() < 1);
	}

	
	public void populate_Multiple_User_Form() throws InterruptedException {
		
		By first_Name_1 = By.xpath("//input[@id='users__firstname']");
		By last_Name_1 = By.xpath("//input[@id='users__lastname']");
		By login_1 = By.xpath("//input[@id='users__login']");
		By prefered_Email_1 = By.xpath("//input[@id='users__preferred_email']");
		
		String firstName_1 = "Angela";
		String lastName_1 = "Moore";
		String email_1 = "aMoore@gmail.com";
		//------------------------------------------------------
		
		By first_Name_2 = By.xpath("//div[3]//div[3]//div[1]//div[1]//input[1]");
		By last_Name_2 = By.xpath("//div[3]//div[3]//div[1]//div[2]//input[1]");
		By login_2 = By.xpath("//div[3]//div[3]//div[1]//div[3]//input[1]");
		By prefered_Email_2 = By.xpath("//div[3]//div[3]//div[1]//div[4]//input[1]");
		
		String firstName_2 = "Angel";
		String lastName_2 = "Morgan";
		String email_2 = "aMorgan@gmail.com";
		
		//------------------------------------------------------
		
		DriverFactory.getInstance().getDriver().findElement(first_Name_1).sendKeys(firstName_1);
		DriverFactory.getInstance().getDriver().findElement(last_Name_1).sendKeys(lastName_1);
		DriverFactory.getInstance().getDriver().findElement(login_1).click();
		DriverFactory.getInstance().getDriver().findElement(prefered_Email_1).sendKeys(email_1);
		DriverFactory.getInstance().getDriver().findElement(prefered_Email_1).sendKeys(Keys.TAB);
		
		this.verify_Add_Another();
		this.click_Add_Another();
		Thread.sleep(1000);
		this.verify_First_Name_2nd_Row();
		
		DriverFactory.getInstance().getDriver().findElement(first_Name_2).sendKeys(firstName_2);
		DriverFactory.getInstance().getDriver().findElement(last_Name_2).sendKeys(lastName_2);
		DriverFactory.getInstance().getDriver().findElement(login_2).click();
		DriverFactory.getInstance().getDriver().findElement(prefered_Email_2).sendKeys(email_2);
		DriverFactory.getInstance().getDriver().findElement(prefered_Email_2).sendKeys(Keys.TAB);

		this.verify_SaveBtn_User_Form();
		DriverFactory.getInstance().getDriver().findElement(saveBtn_1).click();
		
	}
	
	// --------------Function Being Called ----------------------
	public void open_Multiple_User_Form() throws InterruptedException {
		this.verify_Add_User();
		this.click_Add_User();
		Thread.sleep(1000);
		this.verify_Multiple_Users();
		this.click_Multiple_Users();
		Thread.sleep(1000);
		this.verify_Quick_Add_Modal();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Multiple_User_Form() -----------");
	}
	
	// --------------Function Being Called ----------------------
	public void fill_Multiple_User_Form() throws InterruptedException {
		this.populate_Multiple_User_Form();
		Thread.sleep(1500);
		this.verify_CloseBtn_Quick_Add();
		this.click_Close_Quick_Add();
		Thread.sleep(2000);
		this.verify_Everybody();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> fill_Multiple_User_Form() -----------");
	}
	
	public void verify_Multiple_Users_Created() throws InterruptedException {
		this.verify_Angela_Moore_And_Morgan_DrpDwn();
		System.out.println("------- Completed --> verify_Multiple_Users_Created() -----------");
	}
	
	public void deactivate_Angela_Moore() throws InterruptedException {
		this.click_Angela_Moore_DrpDwn();
		Thread.sleep(1000);
		this.verify_Deactivate_User();
		this.click_Deactivate_User();
		this.verify_Continue_Btn();
		this.click_Continue_Btn();
		Thread.sleep(1500);
		this.verify_Profile_Deactivated_Message();
		this.click_Save_Btn();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> deactivate_Delete_Angela_Moore() -----------");
	}
	
	public void deactivate_Angela_Morgan() throws InterruptedException {
		this.verify_Angel_Morgan_DrpDwn();
		this.click_Angel_Morgan_DrpDwn();
		Thread.sleep(1000);
		this.verify_Deactivate_User();
		this.click_Deactivate_User();
		this.verify_Continue_Btn();
		this.click_Continue_Btn();
		Thread.sleep(1500);
		this.verify_Profile_Deactivated_Message();
		this.click_Save_Btn();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> deactivate_Angela_Morgan() -----------");
	}
	
	public void delete_Angela_Moore(String userlastname) throws InterruptedException {
		this.verify_Settings_Side_Menu_Bar();
		Thread.sleep(1000);
		this.clickManageUsers();
		this.verifyInactiveUsers();
		this.clickInactiveUsers();
		Thread.sleep(3000);
		this.click_Angela_Moore_Dropdown();
		this.verifyDeleteUserPresent();
		this.clickDeleteUser();
		this.verifyFormInputField();
		this.form_Input_Field_SendKeys(userlastname);
		this.click_Continue_Btn();
		this.verify_Sucessfully_Deleted_User_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> deactivate_Angela_Morgan() -----------");
	}
	
	public void delete_Angel_Morgan(String userlastname2) throws InterruptedException {
		this.verify_Settings_Side_Menu_Bar();
		Thread.sleep(1000);
		this.clickManageUsers();
		this.verifyInactiveUsers();
		this.clickInactiveUsers();
		Thread.sleep(3000);
		this.click_Angel_Morgan_Dropdown();
		this.verifyDeleteUserPresent();
		this.clickDeleteUser();
		this.verifyFormInputField();
		this.form_Input_Field_SendKeys(userlastname2);
		this.click_Continue_Btn();
		this.verify_Sucessfully_Deleted_User_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Angela_Morgan() -----------");
	}
	
	public void verify_Users_Moore_Morgan_Deleted() throws InterruptedException {	
		this.verify_Test_User_Dropdown();
		this.verify_Moore_Morgan_NOT_Visible();
		System.out.println("------- Completed --> verify_Users_Moore_Morgan_Deleted() -----------");
	}
		
	// --------------Open_User_Profile---------------------------
	By test_User_Dropdown = By.xpath("(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	//By test_Reset_Edit_Profile = By.xpath("(//a[contains(text(),'Test Reset')]/following::div[@class='btn-group small open']//child::a[contains(text(),'Edit Profile')])[1]");
	By test_Reset_Edit_Profile = By.xpath("(//a[contains(.,'Test Reset')]/following::div//child::a[contains(.,'Edit Profile')])[1]");
	By test_Reset_View_Profile = By.xpath("(//a[contains(text(),'Test Reset')]/following::div[@class='btn-group small open']//child::a[contains(text(),'View Profile')])[1]");

	By auto_User1 = By.xpath("(//a[contains(text(),'Auto User1')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User2 = By.xpath("(//a[contains(text(),'Auto User2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User3 = By.xpath("(//a[contains(text(),'Auto User3')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User4 = By.xpath("(//a[contains(text(),'Auto User4')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User5 = By.xpath("(//a[contains(text(),'Auto User5')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User6 = By.xpath("(//a[contains(text(),'Auto User6')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User8 = By.xpath("(//a[contains(text(),'Auto User8')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User9 = By.xpath("(//a[contains(text(),'Auto User9')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User10 = By.xpath("(//a[contains(text(),'Auto User10')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User11 = By.xpath("(//a[contains(text(),'Auto User11')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_User12 = By.xpath("(//a[contains(text(),'Auto User12')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");

	By autoAdminUserGS1 = By.xpath("(//a[contains(text(),'Auto Admin User GS 1')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");

	By edit_Profile = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");
	By view_Profile = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'View Profile')]");

	public void verify_Test_User_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(test_User_Dropdown)));
	}
	
	public void verify_Test_Reset_Edit_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(test_Reset_Edit_Profile)));
	}
	
	public void verify_Test_Reset_View_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(test_Reset_View_Profile)));
	}
	
	public void verify_Auto_User_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User1)));
	}
	
	public void verify_Auto_User_2_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User2)));
	}
	
	public void verify_Auto_User_3_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User3)));
	}
	
	public void verify_Auto_User_4_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User4)));
	}

	public void verify_Auto_User_5_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User5)));
	}
	
	public void verify_Auto_User_6_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User6)));
	}
	
	public void verify_Auto_User_8_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User8)));
	}
	
	public void verify_Auto_User_9_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User9)));
	}
	
	public void verify_Auto_User_10_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User10)));
	}
	
	public void verify_Auto_User_11_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User11)));
	}
	
	public void verify_Auto_User_12_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User12)));
	}
	
	public void verify_AutoAdminUserGS1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(autoAdminUserGS1)));
	}
	
	public void verify_Edit_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Profile)));
	}
	
	public void verify_View_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(view_Profile)));
	}

	public void click_Test_User_Dropdown() {
		//DriverFactory.getInstance().getDriver().findElement(test_User_Dropdown).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(test_User_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Test_Reset_Edit_Profile() throws InterruptedException {
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(test_Reset_Edit_Profile);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1000);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(test_Reset_Edit_Profile);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Test_Reset_View_Profile() throws InterruptedException {
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(test_Reset_View_Profile);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1000);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(test_Reset_View_Profile);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_1_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User1);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Auto_User_2_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User2);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_3_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User3);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_4_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User4);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_5_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User5);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_6_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User6);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_8_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User8);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_9_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User9);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_10_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User10);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_11_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User11);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Auto_User_12_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User12);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AutoAdminUserGS1_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(autoAdminUserGS1);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edit_Profile() throws InterruptedException {
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(edit_Profile);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1000);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(edit_Profile);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	
	public void click_View_Profile() throws InterruptedException {
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(view_Profile);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1000);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(view_Profile);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	public void open_Test_Reset_User_Profile(String testreset) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(testreset);
		Thread.sleep(1000);
		this.verify_Test_User_Dropdown();
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Test_Reset_Edit_Profile();
		this.click_Test_Reset_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Test_Reset_User_Profile() -----------");
	}
	
	public void view_Test_Reset_User_Profile(String testreset) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(testreset);
		Thread.sleep(1000);
		this.verify_Test_User_Dropdown();
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Test_Reset_View_Profile();
		this.click_Test_Reset_View_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> view_Test_Reset_User_Profile() -----------");
	}
	
	public void open_Auto_User_1_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(1000);
		this.verify_Auto_User_1_Dropdown();
		this.click_Auto_User_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_1_Profile() -----------");
	}
	
	public void open_Auto_User_2_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(1000);
		this.verify_Auto_User_2_Dropdown();
		this.click_Auto_User_2_Dropdown();
		Thread.sleep(500);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_2_Profile() -----------");
	}
	
	public void open_Auto_User_2_View_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(1000);
		this.verify_Auto_User_2_Dropdown();
		this.click_Auto_User_2_Dropdown();
		Thread.sleep(500);
		this.verify_View_Profile();
		this.click_View_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_2_View_Profile() -----------");
	}
	
	public void open_Auto_User_3_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(1000);
		this.verify_Auto_User_3_Dropdown();
		this.click_Auto_User_3_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_3_Profile() -----------");
	}
	
	public void open_Auto_User_4_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(1000);
		this.verify_Auto_User_4_Dropdown();
		this.click_Auto_User_4_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_4_Profile() -----------");
	}
	
	public void open_Auto_User_5_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(1000);
		this.verify_Auto_User_5_Dropdown();
		this.click_Auto_User_5_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_4_Profile() -----------");
	}
	
	public void open_Auto_User_6_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		this.verify_Auto_User_6_Dropdown();
		this.click_Auto_User_6_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_4_Profile() -----------");
	}
	
	public void open_Auto_User_8_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		this.verify_Auto_User_8_Dropdown();
		this.click_Auto_User_8_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_4_Profile() -----------");
	}
	
	public void open_Auto_User_9_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(1000);
		this.verify_Auto_User_9_Dropdown();
		this.click_Auto_User_9_Dropdown();
		Thread.sleep(500);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_9_Profile() -----------");
	}
	
	public void open_Auto_User_10_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(500);
		this.verify_Auto_User_10_Dropdown();
		this.click_Auto_User_10_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_10_Profile() -----------");
	}
	
	public void open_Auto_User_11_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		this.verify_Auto_User_11_Dropdown();
		this.click_Auto_User_11_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_11_Profile() -----------");
	}
	
	public void open_Auto_User_12_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		this.verify_Auto_User_12_Dropdown();
		this.click_Auto_User_12_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Auto_User_12_Profile() -----------");
	}
	
	public void open_AutoAdminUserGS1_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(2000);
		this.verify_AutoAdminUserGS1_Dropdown();
		this.click_AutoAdminUserGS1_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_AutoAdminUserGS1_Profile() -----------");
	}
	
	public void view_AutoAdminUserGS1_Profile(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(2000);
		this.verify_AutoAdminUserGS1_Dropdown();
		this.click_AutoAdminUserGS1_Dropdown();
		this.verify_View_Profile();
		this.click_View_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_AutoAdminUserGS1_Profile() -----------");
	}
	
	// --------------open_User_Profile_Contact_User ---------------------------
	By contact_User = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Contact User')]");
	By subject = By.xpath("//input[@id='email_subject']");
	By sendBtn = By.xpath("//button[@id='user_message_submit']");
	String Subject = " This is a Subject";
	
	public void verify_Subject() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(subject)));
	}
	
	public void click_Contact_User() {
		DriverFactory.getInstance().getDriver().findElement(contact_User).click();
	}
	
	public void subject_SendKeys() {
		DriverFactory.getInstance().getDriver().findElement(subject).clear();
		DriverFactory.getInstance().getDriver().findElement(subject).sendKeys(Subject);
	}
	
	public void email_Message() {
		// switching to iframe
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys("This is an email message");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}
	
	public void scroll_To_SendBtn() throws InterruptedException {
		WebElement send = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@id='user_message_submit']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", send);
	}

	public void click_SendBtn() {
		DriverFactory.getInstance().getDriver().findElement(sendBtn).click();
	}
	
	public void open_Test_Reset_Profile_Click_Contact_User() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Contact_User();
		Thread.sleep(1500);
		System.out.println("------- Completed --> open_Test_Reset_Profile_Click_Contact_User() -----------");
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

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(By.xpath(companyInfo)) instanceof WebElement);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(By.xpath(personalInfo)) instanceof WebElement);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(By.xpath(altContactInfo)) instanceof WebElement);
	}
	
	// ----------------user_Can_Set_Date_Time_Format()---------------
	By general_Settings = By.xpath("//a[contains(text(),'General Settings')]");
	By look_And_Feel = By.xpath("//*[@id='settingsModal']//div[@class='modal-content-header']//a[contains(.,'Look and Feel')]");
	By default_Date_Time_Label = By.xpath("//label[contains(text(),'Default Date/Time Format')]");
	By date_Time_Drp_Dwn = By.xpath("//body/div[@id='clientLookFeel']/div[1]/div[1]/div[2]/form[1]/div[5]/div[1]/div[1]/button[1]");
	By date_Time_NO_AM_PM = By.xpath("//*[starts-with (@id,'edit_client_')]/div[5]/div/div/div/ul/li[2]/a");
	
	By timezone_Drp_Dwn = By.xpath("//body/div[@id='clientLookFeel']/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/div[1]/button[1]");
	By pacific_Time = By.xpath("//span[contains(text(),'(GMT-08:00) Pacific Time (US & Canada)')]");
	By eastern_Time = By.xpath("//span[contains(text(),'(GMT-05:00) Eastern Time (US & Canada)')]");

	By save_LF = By.xpath("//body/div[@id='clientLookFeel']/div[1]/div[1]/div[3]/button[2]");
	
	public void verify_General_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(general_Settings)));
	}
	
	public void verify_Look_And_Feel() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(look_And_Feel)));
	}
	
	public void verify_Default_Date_Time_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(default_Date_Time_Label)));
	}
	
	public void click_General_Settings() {
		DriverFactory.getInstance().getDriver().findElement(general_Settings).click();
	}
	
	public void click_Look_And_Feel() {
		DriverFactory.getInstance().getDriver().findElement(look_And_Feel).click();
	}
	
	public void click_Date_Time_Drp_Dwn() {
		DriverFactory.getInstance().getDriver().findElement(date_Time_Drp_Dwn).click();
	}
	
	public void click_Date_Time_AM_PM() {
		By date_Time_PM = By.xpath("//span[contains(text(),'PM')]");
		By date_Time_AM = By.xpath("//span[contains(text(),'AM')]");
		
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean date_time_pm = DriverFactory.getInstance().getDriver().findElements(date_Time_PM).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		if (date_time_pm == true) {
			DriverFactory.getInstance().getDriver().findElement(date_Time_PM).click();
		}else {
			DriverFactory.getInstance().getDriver().findElement(date_Time_AM).click();
		}

	}
	
	public void click_Date_Time_NO_AM_PM() {
		DriverFactory.getInstance().getDriver().findElement(date_Time_NO_AM_PM).click();
	}
	
	public void click_Timezone_Drp_Dwn() {
		DriverFactory.getInstance().getDriver().findElement(timezone_Drp_Dwn).click();
	}
	
	public void click_Pacific_Timezone() {
		DriverFactory.getInstance().getDriver().findElement(pacific_Time).click();
	}
	public void click_Eastern_Timezone() {
		DriverFactory.getInstance().getDriver().findElement(eastern_Time).click();
	}
	
	public void click_Save_Btn_LF() throws InterruptedException {
		WebElement saveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//body/div[@id='clientLookFeel']/div[1]/div[1]/div[3]/button[2]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(save_LF).click();
	}
	
	public void navigate_To_Look_And_Feel() throws InterruptedException {
		this.verify_General_Settings();
		Thread.sleep(1000);
		this.click_General_Settings();
		Thread.sleep(1000);
		this.verify_Look_And_Feel();
		this.click_Look_And_Feel();
		Thread.sleep(1000);
		System.out.println("------- Completed --> navigate_To_Look_And_Feel() -----------");
	}
	
	public void set_New_Date_Time_Format() throws InterruptedException {
		this.verify_Default_Date_Time_Label();
		Thread.sleep(1000);
		this.click_Date_Time_Drp_Dwn();
		Thread.sleep(1500);
		this.click_Date_Time_AM_PM();
		Thread.sleep(1500);
		this.click_Save_Btn_LF();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> set_New_Date_Time_Format() -----------");
	}
	
	public void set_Back_To_Orginal_Date_Time_Format() throws InterruptedException {
		this.verify_Default_Date_Time_Label();
		Thread.sleep(1000);
		this.click_Date_Time_Drp_Dwn();
		Thread.sleep(1500);
		this.click_Date_Time_NO_AM_PM();
		Thread.sleep(1500);
		this.click_Save_Btn_LF();
		Thread.sleep(2600);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> set_Back_To_Orginal_Date_Time_Format() -----------");
	}
	
	public void set_Time_Zone_To_Pacific_Time() throws InterruptedException {
		this.verify_Default_Date_Time_Label();
		Thread.sleep(1000);
		this.click_Timezone_Drp_Dwn();
		Thread.sleep(1500);
		this.click_Pacific_Timezone();
		Thread.sleep(1500);
		this.click_Save_Btn_LF();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> set_Time_Zone_To_Pacific_Time() -----------");
	}
	
	public void set_New_Time_Zone_To_Eastern_Time() throws InterruptedException {
		this.verify_Default_Date_Time_Label();
		Thread.sleep(1000);
		this.click_Timezone_Drp_Dwn();
		Thread.sleep(1500);
		this.click_Eastern_Timezone();
		Thread.sleep(1500);
		this.click_Save_Btn_LF();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> set_New_Time_Zone_To_Eastern_Time() -----------");
	}
	
	// ----------------Message_User()---------------
	//By message_Users = By.xpath("//a[@class='action-link'][contains(text(),' Message Users')]");
	By message_Users = By.xpath("//*[@id='directory-message-users']/a[contains(text(),' Message Users')]");
	By message_Users_Dir = By.xpath("//a[@class='btn btn-default'][contains(text(),' Message Users')]");
	By send_A_Message = By.xpath("//div[@class='modal-dialog modal-lg']//h1[@class='modal-title'][contains(text(),'Send A Message')]");
	By people_Tab = By.xpath("//a[@class='active'][contains(text(),'People')]");
	By system_Admin_Eng = By.xpath("//div[contains(text(),'system admineng')]");
	By recipient_System_Admin_Eng = By.xpath("//a[@class='label label-primary'][contains(text(),'system admineng')]");
	By sendBtn_2 = By.xpath("//button[@id='message_submit']");

	public void verify_Message_Users() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(message_Users)));
	}
	
	public void verify_Send_A_Message_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(send_A_Message)));
	}
	
	public void verify_System_Admin_Eng() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(system_Admin_Eng)));
	}
	
	public void verify_Recipient_System_Admin_Eng() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(recipient_System_Admin_Eng)));
	}
	
	public void verify_Message_Users_Dir() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(message_Users_Dir)));
	}
	
	
	public void click_Message_Users() {
		DriverFactory.getInstance().getDriver().findElement(message_Users).click();
	}
	
	public void click_Message_Users_Dir() {
		DriverFactory.getInstance().getDriver().findElement(message_Users_Dir).click();
	}
	
	public void click_People_Tab() {
		DriverFactory.getInstance().getDriver().findElement(people_Tab).click();
	}
	
	public void click_System_Admin_Eng() {
		DriverFactory.getInstance().getDriver().findElement(system_Admin_Eng).click();
	}
	
	public void scroll_To_SendBtn_2() throws InterruptedException {
		WebElement send = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@id='message_submit']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", send);
	}

	public void click_SendBtn_2() {
		DriverFactory.getInstance().getDriver().findElement(sendBtn_2).click();
	}
	
	public void message_Users() throws InterruptedException {
		this.verify_Message_Users_Dir();
		this.click_Message_Users_Dir();
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
	
	public void message_Users_Via_Email_Link() throws InterruptedException {
		Thread.sleep(1500); // pause to make sure under correct folder
		this.verify_Send_A_Message_Box();
		this.subject_SendKeys();
		this.scroll_To_SendBtn_2();
		this.click_SendBtn_2();
		System.out.println("------- Completed --> message_Users_Via_Email_Link() -----------");
	}
	
	public void message_Workroom_Users() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Messaging();
		Thread.sleep(1000);
		this.verify_Send_A_Message_Box();
		this.click_Workrooms_Tab_B();
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
		Thread.sleep(1000);
		System.out.println("------- Completed --> message_Workroom_Users() -----------");
	}
	
	//div[@class='btn-group bootstrap-select show-tick form-control chosen open']//ul//li//span[contains(text(),'Board Member')]
	// ----------------message_Workroom_Users_Diff_Tabs()---------------
	By user_Catergories_Tab = By.xpath("//a[contains(text(),'User Categories')]");
	By board_Member = By.xpath("//span[contains(text(),'Board Member')]");
	By board_Member_B = By.xpath("//*[starts-with(span,'Board Member ')]");// this contians a space after member on purpose
	By board_Member_C = By.xpath("//*[@id='additional']//div/ul/li/a/span[contains(.,'Board Member')]");

	By workroom_Admin = By.xpath("//div[contains(text(),'Workroom Admin')]");
	By recipient_Workroom_Admin = By.xpath("//a[@class='label label-primary'][contains(text(),'Workroom Admin ')]");
	By workroom_Tab = By.xpath("//a[contains(text(),'Workrooms')]");
	By workroom_Tab_B = By.xpath("//*[@id='people']/li/a[contains(text(),'Workrooms')]");
	By autoBE_WR = By.xpath("//span[contains(text(),'AutoBE')]");
	By autoBE_WR_B = By.xpath("//*[starts-with (@id,'workroom-messaging')]/span[contains(.,'AutoBE')]");
	By recipient_BE_Setup = By.xpath("//a[@class='label label-primary'][contains(text(),'BoardEffect Setup')]");
	
	public void verify_Board_Member() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(board_Member)));
	}
	
	public void verify_Board_Member_B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(board_Member_B)));
	}
	
	public void verify_Board_Member_C() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(board_Member_C)));
	}
	
	public void verify_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin)));
	}
	
	public void verify_Recipient_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(recipient_Workroom_Admin)));
	}
	
	public void verify_AutoBE_WR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(autoBE_WR)));
	}
	
	public void verify_AutoBE_WR_B() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(autoBE_WR_B)));
	}
	
	public void verify_Recipient_BE_Setup() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(recipient_BE_Setup)));
	}
	
	
	
	public void click_User_Catergries_Tab() {
		DriverFactory.getInstance().getDriver().findElement(user_Catergories_Tab).click();
	}
	
	public void click_Board_Member() {
		DriverFactory.getInstance().getDriver().findElement(board_Member).click();
	}
	
	public void click_Board_Member_B() {
		DriverFactory.getInstance().getDriver().findElement(board_Member_B).click();
	}
	
	public void click_Board_Member_C() {
		DriverFactory.getInstance().getDriver().findElement(board_Member_C).click();
	}
	
	public void click_Workroom_Admin() {
		DriverFactory.getInstance().getDriver().findElement(workroom_Admin).click();
	}
	
	public void click_Workrooms_Tab() {
		DriverFactory.getInstance().getDriver().findElement(workroom_Tab).click();
	}
	
	public void click_AutoBE_WR() {
		DriverFactory.getInstance().getDriver().findElement(autoBE_WR).click();
	}
	
	public void click_AutoBE_WR_B() {
		DriverFactory.getInstance().getDriver().findElement(autoBE_WR_B).click();
	}
	
	public void click_Workrooms_Tab_B() {
		DriverFactory.getInstance().getDriver().findElement(workroom_Tab_B).click();
	}

	public void message_Workroom_Users_Diff_Tabs() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Directory();
		this.verify_Message_Users();
		this.click_Message_Users();
		Thread.sleep(1000);
		this.verify_Send_A_Message_Box();
		//---Categories Tab----------
		this.click_User_Catergries_Tab();
		Thread.sleep(1000);
		this.verify_Board_Member_B();
		this.click_Board_Member_B();
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
		this.click_Workrooms_Tab_B();
		Thread.sleep(1000);
		this.verify_AutoBE_WR_B();
		this.click_AutoBE_WR_B();
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
	By email_BoardMembers_Message = By.xpath("//p[contains(text(),'You will receive an email with a copy of the messa')]");

	By closeBtn = By.xpath("//div[@class='modal-dialog modal-md']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]");
	By closeBtn_2 = By.xpath("//div[@class='modal-dialog modal-lg']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]");

	public void verify_Success_Message_Email_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(email_1)));
	}
	
	public void verify_Success_Message_Email_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(email_2)));
	}
	
	public void verify_Success_Message_For_BoardMembers() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(email_BoardMembers_Message)));
	}
	
	public void verify_Sucess_Message_Container() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(sucess_Message_Container)));
	}

	public void scroll_To_Sucess_Message_Container() throws InterruptedException {
		WebElement success = DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'This message was sent to the following recipients:')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", success);
	}
	
	public void scroll_To_Sucess_Message_Container_For_BoardMembers() throws InterruptedException {
		WebElement success = DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'You will receive an email with a copy of the messa')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", success);
	}

	public void scroll_To_CloseBtn() throws InterruptedException {
		WebElement close = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-md']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", close);
	}
	
	public void scroll_To_CloseBtn_2() throws InterruptedException {
		WebElement close = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", close);
	}

	public void click_CloseBtn() {
		DriverFactory.getInstance().getDriver().findElement(closeBtn).click();
	}
	
	public void click_CloseBtn_2() {
		DriverFactory.getInstance().getDriver().findElement(closeBtn_2).click();
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
		Thread.sleep(2500);
		//this.verify_Success_Message_Email_2();
		//this.scroll_To_Sucess_Message_Container();
		this.scroll_To_Sucess_Message_Container_For_BoardMembers();
		this.scroll_To_CloseBtn_2();
		Thread.sleep(2000);
		this.click_CloseBtn_2();
		System.out.println("------- Completed --> verify_Message_Sent() -----------");
		Thread.sleep(3000);
	}
	
	public void verify_Message_Sent_3() throws InterruptedException {
		Thread.sleep(2500);
		this.verify_Success_Message_Email_2();
		this.scroll_To_Sucess_Message_Container();
		this.scroll_To_CloseBtn_2();
		Thread.sleep(2000);
		this.click_CloseBtn_2();
		System.out.println("------- Completed --> verify_Message_Sent() -----------");
		Thread.sleep(3000);
	}
	
	public void verify_Message_Sent_To_BoardMembers() throws InterruptedException {
		Thread.sleep(3000);
		this.scroll_To_Sucess_Message_Container_For_BoardMembers();
		this.verify_Success_Message_For_BoardMembers();
		this.scroll_To_CloseBtn_2();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Message_Sent_To_BoardMembers() -----------");
		Thread.sleep(3000);
	}
	
	public void verify_Email_Link_Message_Sent() throws InterruptedException {
		Thread.sleep(3000);
		this.scroll_To_Sucess_Message_Container();
		this.verify_Sucess_Message_Container();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Email_Link_Message_Sent() -----------");
		Thread.sleep(3000);
	}

	// --------------Download_Directory_Excel/PDF ---------------------------
	By download_As_Excel = By.xpath("//a[@class='excel-link']");
	By download_As_PDF = By.xpath("//a[@class='pdf-link']");
	By download_Progress_Bar_100 = By.xpath("//div[@id='job-progress'][contains(.,'100%')]");

	By download_At_A_Glance = By.xpath("//a[@class='ataglance-link']");
	By download_Report_Btn = By.xpath("//a[@id='download_report_button']");
	
	public void verify_Download_As_Excel() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(download_As_Excel)));
	}
	
	public void verify_Download_As_PDF() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(download_As_PDF)));
	}

	public void verify_Download_At_A_Glance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(download_At_A_Glance)));
	}
	
	public void verify_Download_Report_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(download_Report_Btn)));
	}
	
	public void verify_Progress_Bar_100() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(download_Progress_Bar_100)));
	}
	
	public void click_Download_Directory() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(edit_Profile).click();
		WebElement directoryScroll = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[contains(text(),'Download Directory')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", directoryScroll);
		Thread.sleep(1500);
		WebElement directory = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[contains(text(),'Download Directory')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", directory);
	}
	
	public void click_Download_As_Excel() {
		DriverFactory.getInstance().getDriver().findElement(download_As_Excel).click();
	}
	
	public void click_Download_As_PDF() {
		DriverFactory.getInstance().getDriver().findElement(download_As_PDF).click();
	}
	
	public void click_Download_At_A_Glance() {
		DriverFactory.getInstance().getDriver().findElement(download_At_A_Glance).click();
	}
	
	public void click_Download_Report_Btn() {
		DriverFactory.getInstance().getDriver().findElement(download_Report_Btn).click();
	}
	
	public void switch_Tabs() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		//---wait a few seconds ---- 
		this.verify_Download_Report_Btn();
		this.verify_Progress_Bar_100();
		this.click_Download_Report_Btn();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().close();
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		System.out.println("------- Completed --> switch_To_Print_Events_Tab() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Download_Directory_In_Excel() throws InterruptedException, AWTException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Download_Directory();
		this.verify_Download_As_Excel();
		this.click_Download_As_Excel();
		Thread.sleep(1500);
		this.switch_Tabs();
		this.verify_Test_User_Dropdown();
		System.out.println("------- Completed --> open_Download_Directory_In_Excel() -----------");
	}
	
	public void user_Can_Download_Directory_In_PDF() throws InterruptedException, AWTException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Download_Directory();
		this.verify_Download_As_PDF();
		this.click_Download_As_PDF();
		Thread.sleep(1500);
		this.switch_Tabs();
		this.verify_Test_User_Dropdown();
		System.out.println("------- Completed --> open_Download_Directory_In_PDF() -----------");
	}
	
	public void user_Can_Download_Directory_At_A_Glance() throws InterruptedException, AWTException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Download_Directory();
		this.verify_Download_At_A_Glance();
		this.click_Download_At_A_Glance();
		Thread.sleep(1500);
		this.switch_Tabs();
		this.verify_Test_User_Dropdown();
		System.out.println("------- Completed --> user_Can_Download_Directory_At_A_Glance() -----------");
	}
	
	// --------------open_User_Profile_AutoBE ---------------------------
	By AutoTester_User_Dropdown = By.xpath("(//a[contains(text(),'Automation Tester')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By custom_Fields = By.xpath("//span[contains(text(),'Custom Fields')]");
	By custom_Field_Collapse = By.xpath("//*[@id='headingFormUngroupedCF']/div/a[@class='collapsed']");
	By label = By.xpath("//body/div[@id='profileModal']//div//form[1]//div//ul//li//label/label[contains(.,'label')]");



	public void verify_AutoTester_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(AutoTester_User_Dropdown)));
	}
	
	public void click_AutoTester_Dropdown() {
		//DriverFactory.getInstance().getDriver().findElement(AutoTester_User_Dropdown).click();
		WebElement directory = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Automation Tester')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", directory);
	}
	
	public void click_Test_Reset_Dropdown() {
		//DriverFactory.getInstance().getDriver().findElement(AutoTester_User_Dropdown).click();
		WebElement directory = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", directory);
	}
	
	public void verify_Custom_Fields() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(custom_Fields)));
	}
	
	public void verify_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(label)));
	}
	
	public void click_Custom_Fields() {
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean customField = DriverFactory.getInstance().getDriver().findElements(custom_Field_Collapse).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		if (customField == true) {
			DriverFactory.getInstance().getDriver().findElement(custom_Fields).click();
		}
		
	}
	
	public void click_Auto_Director_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(auto_Director_Dropdown).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_AutoTester() throws InterruptedException {
		this.verify_AutoTester_Dropdown();
		Thread.sleep(1000);
		this.click_AutoTester_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_AutoBE() -----------");
	}
	
	public void open_User_Profile_Test_Rest() throws InterruptedException {
		this.verify_Test_Reset_Dropdown();
		Thread.sleep(1000);
		this.click_Test_Reset_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_AutoBE() -----------");
	}
	
	public void open_User_Profile_AutoDirector() throws InterruptedException {
		this.verify_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.click_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
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
	
	public void verify_Custom_Field_Created() throws InterruptedException {
		this.verify_Additional_Tab();
		this.click_Additional_Tab();
		Thread.sleep(1000);
		this.verify_Custom_Fields();
		this.click_Custom_Fields();
		Thread.sleep(2000);
		this.verify_Label();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> verify_Custom_Field_Created() -----------");
	}
	
	// --------------verify_Company_Contact_Info_Not_Visible-------------------------
	By company_Contact_Info = By.xpath("//span[contains(text(),'Company Information')]");
	
	public void verify_Company_Contact_Info_Not_Present() {
		String company_Contact_Info = "//span[contains(text(),'Company Information')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(company_Contact_Info)).size() < 1);
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Company_Contact_Info_Not_Visible() throws InterruptedException {
		this.verify_Contact_Tab();
		this.verify_Company_Contact_Info_Not_Present();
		System.out.println("------- Completed --> verify_Company_Contact_Info_Not_Visible() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	By personal_Contact_Info = By.xpath("//span[contains(text(),'Personal Information')]");

	public void verify_Personal_Contact_Info_Not_Present() {
		String personal_Contact = "//span[contains(text(),'Personal Information')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(personal_Contact)).size() < 1);
	}
	
	public void verify_Personal_Contact_Info_Not_Visible() throws InterruptedException {
		this.verify_Contact_Tab();
		this.verify_Personal_Contact_Info_Not_Present();
		System.out.println("------- Completed --> verify_Personal_Contact_Info_Not_Visible() -----------");
	}
	
	// --------------open_Features_Navigate_To_Configure---------------------------
	By features = By.xpath("//a[contains(@class,'features')]");
	By configuration = By.xpath("//a[contains(text(),'Configuration')]");
	By configure_Btn = By.xpath("(//*[contains(text(),' Configure')])[2]");
	
	
	public void verify_Features() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(features)));
	}
	
	public void verify_Configuration() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(configuration)));
	}
	
	public void verify_Configure_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(configure_Btn)));
	}
	
	public void click_Features() {
		//DriverFactory.getInstance().getDriver().findElement(features).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(@class,'features')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	

	public void click_Configurations() {
		//DriverFactory.getInstance().getDriver().findElement(configuration).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Configuration')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Configure_Btn() {
		//DriverFactory.getInstance().getDriver().findElement(configuration).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//*[contains(text(),'Configure')])[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
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
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Features_Navigate_To_Configure() -----------");
		}
	
	// --------------activate_Hide_Feature---------------------------
	By save_Feature_Btn = By.xpath("//button[@class='btn btn-done pull-right']");
	By hide_Contact_Message = By.xpath("//strong[contains(text(),'Hide Contact Information')]");
	By check_Box = By.xpath("//input[@id='feature_active']");
	
	public void verify_Save_Feature_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(save_Feature_Btn)));
	}
	
	public void verify_Hide_Contact_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(hide_Contact_Message)));
	}
	
	public void click_Activate_This_Feature() {
		WebElement box = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='feature_active']"));

		if (!box.isSelected()) {
			WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='feature_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
		}
	}
	
	public void click_Deactivate_This_Feature() {
		WebElement box = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='feature_active']"));
		
		if (box.isSelected()) {
			WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='feature_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
		}
		
	}
	
	public void click_Save_Feature_Btn() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@class='btn btn-done pull-right']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------Function Being Called ---------------------------
	public void activate_Hide_Company_Feature() throws InterruptedException {
		this.verify_Save_Feature_Btn();
		this.click_Activate_This_Feature();
		this.click_Save_Feature_Btn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> activate_Hide_Feature() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void deactivate_Hide_Company_Feature() throws InterruptedException {
		this.verify_Save_Feature_Btn();
		this.click_Deactivate_This_Feature();
		this.click_Save_Feature_Btn();
		Thread.sleep(1000);
		this.verify_Hide_Contact_Message();
		HomeNavigationPage obj = new HomeNavigationPage();
		obj.user_Close_Settings();
		System.out.println("------- Completed --> activate_Hide_Feature() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void go_To_Directory_Open_User() throws InterruptedException {
	
		System.out.println("------- Completed --> go_To_Directory_Open_User() -----------");
	}
		
	// --------------configure_TermInfo_with_Officer_Role---------------------------
	By terminfo_Tab = By.xpath("//ul[@class='nav nav-tabs']//li[4]");
	By terminfo_Tab_2 = By.xpath("//a[contains(text(),'Term Info')]");
	By add_Term = By.xpath("//a[@class='pull-right btn btn-default']");
	By workroom_Dropdown = By.xpath("//div[@class='btn-group bootstrap-select chosen form-control']//button[@class='btn dropdown-toggle btn-default']");
	By autoBE = By.xpath("//div[@class='btn-group bootstrap-select chosen form-control open']//span[@class='text'][contains(text(),'AutoBE')]");
	By calendar = By.xpath("/html/body/div[48]/div/div[1]/table/tbody");
	By calendar2 = By.xpath("/html/body/div[49]/div/div[1]/table/tbody");
	By save_Term = By.xpath("//div[@id='termsFormModal']//div[@class='modal-footer']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By startdate = By.xpath("(//*[starts-with(@id,'terms_')])[1]");
	By enddate = By.xpath("(//*[starts-with(@id,'terms_')])[2]");

	public void verify_Terminfo_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(terminfo_Tab)));
	}
	
	public void verify_Terminfo_Tab_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(terminfo_Tab_2)));
	}

	public void verify_Add_Term() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_Term)));
	}

	public void verify_Workroom_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Dropdown)));
	}

	public void verify_Calendar_Open() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(calendar)));
	}

	public void verify_Calendar_Open_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(calendar2)));
	}

	public void verify_Save_Profile_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(save_Profile_Message)));
	}
	
	public void term_Info_NOT_Present() {
		String element = "//span[@class='small-right col-sm-2'][contains(text(),'1st Term')]/following::span[@class='small-right col-sm-4'][contains(text(),'POTUS')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}

	public void click_Terminfo_Tab() {
		DriverFactory.getInstance().getDriver().findElement(terminfo_Tab).click();
	}
	
	public void click_Terminfo_Tab_2() {
		//DriverFactory.getInstance().getDriver().findElement(terminfo_Tab_2).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Term Info')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Add_Term() {
		DriverFactory.getInstance().getDriver().findElement(add_Term).click();
	}

	public void click_Save_Term() {
		DriverFactory.getInstance().getDriver().findElement(save_Term).click();
	}

	public void click_Workroom_Dropdown_Click_AutoBE() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(workroom_Dropdown).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(autoBE).click();
	}

	public void calendar_Start_Date() throws InterruptedException {
		By startdate = By.xpath("//input[@id='terms_109552_start_date']");
		DriverFactory.getInstance().getDriver().findElement(startdate).click();
		// --wait to open
		Thread.sleep(1200);
		verify_Calendar_Open();
		String day = "1";
		WebElement calendar = DriverFactory.getInstance().getDriver().findElement(By.xpath("/html/body/div[48]/div/div[1]/table/tbody"));
		List<WebElement> calendardate = calendar.findElements(By.tagName("td"));
		for (WebElement date : calendardate) {
			if (date.getText().equals(day)) {
				date.click(); // clicks desired option
				break;
			}
		}
	}
	
	public void calendar_Start_Date_A() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(startdate).click();
		Thread.sleep(1200);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		// manipulate date
		// c.add(Calendar.YEAR, 1);
		// c.add(Calendar.MONTH, 1);
		c1.add(Calendar.DATE, 2); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.DATE, 5); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// c.add(Calendar.HOUR, 1);
		// c.add(Calendar.MINUTE, 1);
		// c.add(Calendar.SECOND, 1);
		// convert calendar to date
		Date currentDatePlusFive = c1.getTime();
		String strDateOne = (dateFormat.format(currentDatePlusFive));
		System.out.println(dateFormat.format(currentDatePlusFive));
		System.out.println(strDateOne);
		Date currentDatePlusTen = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTen));
		System.out.println(dateFormat.format(currentDatePlusTen));
		System.out.println(strDateTwo);
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionStart).click();
		DriverFactory.getInstance().getDriver().findElement(startdate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(startdate).clear();
		DriverFactory.getInstance().getDriver().findElement(startdate).sendKeys(strDateOne);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(enddate).click();
		Thread.sleep(1200);

		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionEnd).click();
		DriverFactory.getInstance().getDriver().findElement(enddate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(enddate).clear();
		DriverFactory.getInstance().getDriver().findElement(enddate).sendKeys(strDateTwo);
	}
	
	


	public void calendar_End_Date() throws InterruptedException {
		By enddate = By.xpath("//input[@id='terms_109552_end_date']");
		DriverFactory.getInstance().getDriver().findElement(enddate).click();
		// --wait to open
		Thread.sleep(1500);
		verify_Calendar_Open_2();
		String day = "3";
		WebElement calendar = DriverFactory.getInstance().getDriver().findElement(By.xpath("/html/body/div[49]/div/div[1]/table/tbody"));
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
		DriverFactory.getInstance().getDriver().findElement(term).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(term_Number).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(officer_Role).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(role).click();
		Thread.sleep(1000);
	}

	// --------------Function Being Called ---------------------------
	public void configure_TermInfo_with_Officer_Role() throws InterruptedException {
		this.verify_Terminfo_Tab();
		Thread.sleep(1000);
		this.click_Terminfo_Tab();
		Thread.sleep(1000);
		this.verify_Add_Term();
		this.click_Add_Term();
		Thread.sleep(1000);
		this.verify_Workroom_Dropdown();
		this.click_Workroom_Dropdown_Click_AutoBE();
		Thread.sleep(1200);
		//this.calendar_Start_Date();
		this.calendar_Start_Date_A();
		Thread.sleep(1000);
		//this.calendar_End_Date();
		this.term_And_Officer_Role();
		Thread.sleep(1000);
		this.click_Save_Term();
		Thread.sleep(1500);
		System.out.println("------- Completed --> configure_TermInfo_with_Officer_Role() -----------");
	}
	
	// --------------Term_Info_With_Everything_Settings---------------------------
	By select_Users_Dropdown = By.xpath("//div[@class='btn-group bootstrap-select show-tick chosen']//button[@class='btn dropdown-toggle btn-default']");
	By test_User_MU = By.xpath("//span[contains(text(),'Test Reset')]");
	By add_Term_Info_MU = By.xpath("//button[@id='add_terms']");
	By save_Term_MU = By.xpath("//div[@id='settingsModal']//button[@class='btn btn-done'][contains(text(),'Save')]");
	By autoBE_Text = By.xpath("//span[contains(text(),'AutoBE')]");
	
	public void verify_Select_Users() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(select_Users_Dropdown)));
	}
	
	public void verify_Add_Term_Info_MU() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_Term_Info_MU)));
	}
	
	public void verify_AutoBE_Text_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Text)));
	}
	
	public void click_Select_Users_Click_Test_User() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(select_Users_Dropdown).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(test_User_MU).click();
	}
	
	public void click_Add_Term_Info_MU() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(add_Term_Info_MU).click();
	}
	
	public void click_Save_Term_MU() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(save_Term_MU).click();
	}
	
	public void click_Workroom_Dropdown() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(workroom_Dropdown).click();
	}
	public void click_AutoBE_Text() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(autoBE_Text).click();
	}
	
	public void calendar_Start_End_Date_MU() throws InterruptedException {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		// manipulate date
		// c.add(Calendar.YEAR, 1);
		// c.add(Calendar.MONTH, 1);
		c1.add(Calendar.DATE, 2); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.DATE, 5); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// c.add(Calendar.HOUR, 1);
		// c.add(Calendar.MINUTE, 1);
		// c.add(Calendar.SECOND, 1);
		// convert calendar to date
		Date currentDatePlus2 = c1.getTime();
		String strDateOne = (dateFormat.format(currentDatePlus2));
		System.out.println(dateFormat.format(currentDatePlus2));
		System.out.println(strDateOne);
		Date currentDatePlus5 = c2.getTime();
		String endDate = (dateFormat.format(currentDatePlus5));
		System.out.println(dateFormat.format(currentDatePlus5));
		
		System.out.println(strDateOne);
		By startdate = By.xpath("//input[@id='terms_109552_start_date']");
		DriverFactory.getInstance().getDriver().findElement(startdate).clear();
		DriverFactory.getInstance().getDriver().findElement(startdate).sendKeys(strDateOne);
		
		System.out.println(endDate);
		By enddate = By.xpath("//input[@id='terms_109552_end_date']");
		DriverFactory.getInstance().getDriver().findElement(enddate).clear();
		DriverFactory.getInstance().getDriver().findElement(enddate).sendKeys(endDate);
	}
	
	
	public void term_And_Officer_Role_MU() throws InterruptedException {
		By term_Dropdown = By.xpath("//div[@class='col-md-12']//div[1]//div[1]//button[1]");
		By term_Number_One = By.xpath("(//div[@class='col-md-12']//li[2]//a[1])[2]");
		By officer_Role = By.xpath("//div[@class='col-md-12']//div[2]//div[1]//button[1]");
		By POTUS = By.xpath("(//span[contains(text(),'POTUS')])[1]");
		
		DriverFactory.getInstance().getDriver().findElement(term_Dropdown).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(term_Number_One).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(officer_Role).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(POTUS).click();
	}
	
	public void verify_First_Term() throws InterruptedException {
		String first_Term = "//span[contains(text(),'1st Term')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(first_Term)).size() > 0);
		System.out.println("------- Completed --> verify_First_Term() -----------");
	}
	
	
	// --------------Function Being Called ---------------------------
	public void configure_TermInfo_with_Officer_Role_Settings() throws InterruptedException {
		this.verify_Terminfo_Tab_2();
		this.click_Terminfo_Tab_2();
		Thread.sleep(1000);
		this.verify_Select_Users();
		this.click_Select_Users_Click_Test_User();
		Thread.sleep(1000);
		this.verify_Add_Term_Info_MU();
		this.click_Add_Term_Info_MU();
		Thread.sleep(1000);
		this.verify_Workroom_Dropdown();
		this.click_Workroom_Dropdown();
		Thread.sleep(1000);
		this.verify_AutoBE_Text_Option();
		this.click_AutoBE_Text();
		Thread.sleep(1000);
		this.calendar_Start_End_Date_MU();
		Thread.sleep(1000);
		this.term_And_Officer_Role_MU();
		Thread.sleep(1000);
		this.click_Save_Term_MU();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> configure_TermInfo_with_Officer_Role_Settings() -----------");
	}
	
	By term_Drop_Down = By.xpath("//*[@id='profileTermInfo_2305']//*[@class='btn-group small pull-right']");
	By edit_Option = By.xpath("//*[@id='profileTermInfo_2305']//*/ul/li[1][contains(.,' Edit')]");
	By new_Term_Info_Box = By.xpath("//*[@id='profileTermInfo_2305']//*/ul/li[1][contains(.,' Edit')]");
	By term_Number_Btn = By.xpath("//*[@id='termsFormModal']//*/form/div/div/div[4]/div/button");
	By term_2 = By.xpath("//*[@id='termsFormModal']//*/form//div[4]//ul/li[3][contains(.,'2')]");


	public void verify_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Option)));
	}
	
	public void verify_Term_Number_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(term_Number_Btn)));
	}
	
	public void click_Term_Drop_Down() {
		DriverFactory.getInstance().getDriver().findElement(term_Drop_Down).click();
	}
	
	public void click_Edit_Option() {
		DriverFactory.getInstance().getDriver().findElement(edit_Option).click();
	}
	
	public void click_Term_Number_Select_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(term_Number_Btn).click();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(term_2).click();
	}
	
	public void edit_TermInfo_with_Officer_Role() throws InterruptedException {
		this.verify_Terminfo_Tab();
		Thread.sleep(1000);
		this.click_Terminfo_Tab();
		Thread.sleep(1200);
		this.verify_Add_Term();
		this.click_Term_Drop_Down();
		Thread.sleep(1200);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1500);
		this.verify_Term_Number_Btn();
		this.click_Term_Number_Select_2();
		Thread.sleep(1500);
		this.click_Save_Term();
		Thread.sleep(2500);
		System.out.println("------- Completed --> edit_TermInfo_with_Officer_Role() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void configure_TermInfo_Workroom_No_End_Date() throws InterruptedException {
		this.verify_Terminfo_Tab();
		Thread.sleep(500);
		this.click_Terminfo_Tab();
		Thread.sleep(1000);
		this.verify_Add_Term();
		this.click_Add_Term();
		Thread.sleep(1000);
		this.verify_Workroom_Dropdown();
		this.click_Workroom_Dropdown_Click_AutoBE();
		Thread.sleep(1200);
		this.calendar_Start_Date_A();
		Thread.sleep(1200);
		this.term_And_Officer_Role();
		Thread.sleep(1200);
		this.click_Save_Term();
		Thread.sleep(2000);
		System.out.println("------- Completed --> configure_TermInfo_Workroom_No_End_Date() -----------");
	}

	// --------------enable_Hide_User_From_Directory---------------------------
	By settings_Tab = By.xpath("//body/div[@id='profileModal']//div/form/div/ul/li/a[contains(.,'Settings')]");
	By first_Name_Field = By.xpath("//input[@id='user_firstname']");
	By save_Btn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By autoBE_Saved_Message = By.xpath("//p[contains(text(),'has been saved.')]");

	public void verify_Settings_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_Tab)));
	}
	
	public void verify_First_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(first_Name_Field)));
	}
	
	public void verify_AutoBE_Saved_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Saved_Message)));
	}
	
	
	public void click_Settings_Tab() {
		//DriverFactory.getInstance().getDriver().findElement(settings_Tab).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//body/div[@id='profileModal']//div/form/div/ul/li/a[contains(.,'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Save_Btn() {
		//DriverFactory.getInstance().getDriver().findElement(save_Btn).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Hide_User_From_Directory_Enable() throws InterruptedException {
		String _label = "//label[contains(text(),'Hide user from directory')]";
		String _checkbox = "//input[@id='user_directory_hidden']";
		
		WebElement label = DriverFactory.getInstance().getDriver().findElement(By.xpath(_label));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", label);
		Thread.sleep(1000);
		
		WebElement checkbox = DriverFactory.getInstance().getDriver().findElement(By.xpath(_checkbox));
		if (!checkbox.isSelected()) {	
			WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(_checkbox));
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);	
		}

	}
	
	public void click_Hide_User_From_Directory_Disable() throws InterruptedException {
		String _label = "//label[contains(text(),'Hide user from directory')]";
		String _checkbox = "//input[@id='user_directory_hidden']";
		
		WebElement label = DriverFactory.getInstance().getDriver().findElement(By.xpath(_label));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", label);
		Thread.sleep(1000);
		
		WebElement checkbox = DriverFactory.getInstance().getDriver().findElement(By.xpath(_checkbox));
		if (checkbox.isSelected()) {	
			WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(_checkbox));
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);	
		}

	}
	
	// --------------Function Being Called ---------------------------
	public void enable_Hide_User_From_Directory() throws InterruptedException {
		this.verify_Settings_Tab();
		this.click_Settings_Tab();
		Thread.sleep(1000);
		this.verify_First_Name_Field();
		Thread.sleep(1000);
		this.click_Hide_User_From_Directory_Enable();
		this.click_Save_Btn();
		Thread.sleep(1000);
		this.verify_AutoBE_Saved_Message();
		System.out.println("------- Completed --> enable_Hide_User_From_Directory() -----------");
	}
	
	public void disable_Hide_User_From_Directory() throws InterruptedException {
		this.verify_Settings_Tab();
		this.click_Settings_Tab();
		Thread.sleep(1000);
		this.verify_First_Name_Field();
		Thread.sleep(1000);
		this.click_Hide_User_From_Directory_Disable();
		this.click_Save_Btn();
		Thread.sleep(1000);
		this.verify_AutoBE_Saved_Message();
		System.out.println("------- Completed --> disable_Hide_User_From_Directory() -----------");
	}
	
	
	// --------------enable_Hide_Company_Contact_From_Other_Users ----------------
	By contact_Tab = By.xpath("//li[@class='active']//a[contains(text(),'Contact')]");
	By hide_Company_Contact_Box = By.xpath("//input[@id='user_hide_company_contact']");

	public void verify_Contact_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(contact_Tab)));
	}
	
	public void click_Contact_Tab() {
		//DriverFactory.getInstance().getDriver().findElement(save_Btn).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//li[@class='active']//a[contains(text(),'Contact')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Hide_Company_Contact_Box() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(save_Btn).click();
		WebElement box = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='user_hide_company_contact']"));
		
		if (!box.isSelected()) {	
			WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='user_hide_company_contact']"));
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);	
		}
		Thread.sleep(1000);
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
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
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(),'Company Information')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Personal_Information() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(),'Personal Information')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Hide_Personal_Contact_Box() throws InterruptedException {
		WebElement box = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='user_hide_personal_contact']"));
		
		if (!box.isSelected()) {	
			WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='user_hide_personal_contact']"));
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);	
		}
		Thread.sleep(1000);
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
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
		HomeNavigationPage obj = new HomeNavigationPage();
		obj.user_Close_Directory();
		System.out.println("------- Completed --> close_Profile_And_Directory() -----------");
	}
	
	// --------------add_Photo_To_Profile---------------------------
	By more_Tab = By.xpath("//li[@class='dropdown']");
	By attachments = By.xpath("//a[contains(text(),'Attachments')]");
	By photo_text = By.xpath("//label[contains(text(),'Photo')]");

	public void verify_More_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(more_Tab)));
	}

	public void verify_Attachments() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attachments)));
	}

	public void verify_Photo_Input() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(photo_text)));
	}

	public void click_More_Tab() {
		DriverFactory.getInstance().getDriver().findElement(more_Tab).click();
	}

	public void click_Attachments() {
		DriverFactory.getInstance().getDriver().findElement(attachments).click();
	}

	public void upload_Photo() {
		String input = "//input[@id='user_photo']";
		String filepath = "C:\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
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
		Thread.sleep(1000);
		this.verify_Save_Profile_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> add_Photo_To_Profile() -----------");
	}
	// --------------add_Category-------------------------------------
	By additional_Tab = By.xpath("//a[contains(text(),'Additional')]");
	//By additional_Tab = By.xpath("//*[@id=\"profile-form\"]//div/ul/li/a[contains(.,'Additional')]");
	By cat_Dropdown = By.xpath("//div[@class='col-sm-5']//span[@class='filter-option pull-left'][contains(text(),'Select an Option')]");
	//By board_Member = By.xpath("//div[@id='additional']//li[2]//a[1]");
	By board_Member_Cat = By.xpath("//p[contains(text(),'Board Member')]");

	public void verify_Additional_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(additional_Tab)));
	}

	public void verify_Category_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(cat_Dropdown)));
	}

	public void verify_Board_Member_Present() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(board_Member_Cat)));
	}

	public void click_Additional_Tab() {
		DriverFactory.getInstance().getDriver().findElement(additional_Tab).click();
	}

	public void click_Category_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(cat_Dropdown).click();
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
	
	public void add_Category_2() throws InterruptedException {
		this.verify_Additional_Tab();
		this.click_Additional_Tab();
		Thread.sleep(1000);
		this.verify_Category_Dropdown();
		this.click_Category_Dropdown();
		Thread.sleep(1000);
		this.verify_Board_Member_C();
		this.click_Board_Member_C();
		Thread.sleep(1000);
		this.click_Save_Profile();
		Thread.sleep(1000);
		this.verify_Save_Profile_Message();
		this.verify_Additional_Tab();
		this.click_Additional_Tab();
		Thread.sleep(1000);
		this.verify_Board_Member_Present();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> add_Category_2() -----------");
	}

	// --------------add_Resume_To_Profile ---------------------------
	public void upload_Resume() {
		String input = "//input[@id='user_resume']";
		String filepath = "C:\\uploadedFiles\\resume.docx";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}

	// --------------Function Being Called ---------------------------
	public void add_Resume_To_Profile() throws InterruptedException {
		this.verify_More_Tab();
		Thread.sleep(500);
		this.click_More_Tab();
		Thread.sleep(1000);
		this.verify_Attachments();
		this.click_Attachments();
		Thread.sleep(1000);
		this.verify_Photo_Input();
		this.upload_Resume();
		this.click_Save_Profile();
		Thread.sleep(1000);
		this.verify_Save_Profile_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> add_Resume_To_Profile() -----------");
	}
	
	//----------------add_Workroom_To_Profile------------------
	By workroomTab = By.xpath("//form[@id='profile-form']//a[contains(text(), 'Workrooms')]");
	By workroom_Select_Dropdown = By.xpath(
			"//div[@class='col-sm-6']//div[@class='btn-group bootstrap-select show-tick form-control chosen']//button[@class='btn dropdown-toggle btn-default']");
	// By workroom_Select_Dropdown=
	// By.xpath("//div[@class='col-sm-6']//div[@class='btn-group bootstrap-select
	// show-tick form-control chosen']//span[@class='bs-caret']");
	//By autoBE = By.xpath("//div[@id='workrooms-tab']//li[3]//a[1]//span[contains(text(),'AutoBE')]");
	By auto_Attend_Option = By.xpath("//div[@id='workrooms-tab']//li//span[contains(text(),'AutoAttend')]");
	By auto_Attend_X = By.xpath("(//*[starts-with(@id,'row-')]/div[1]/div[contains(.,'AutoAttend')]/following::i[@class='fa fa-remove'])[1]");
	By saveUsers = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");

	public void verify_workroom_Select_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Select_Dropdown)));
	}

	public void clickWorkroomTab() {
		WebElement workroomtab = DriverFactory.getInstance().getDriver().findElement(By.xpath("//form[@id='profile-form']//a[contains(text(), 'Workrooms')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", workroomtab);
		// DriverFactory.getInstance().getDriver().findElement(workroomTab).click();
	}

	public void click_Workroom_Select_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(workroom_Select_Dropdown).click();
	}

	public void click_Auto_Attend() {
		DriverFactory.getInstance().getDriver().findElement(auto_Attend_Option).click();
	}

	public void click_SaveUsers() {
		DriverFactory.getInstance().getDriver().findElement(saveUsers).click();
	}
	
	public void click_AutoAttend_X() {
		DriverFactory.getInstance().getDriver().findElement(auto_Attend_X).click();
	}
	
	public void add_Workroom_To_Profile() throws InterruptedException {
		this.clickWorkroomTab();
		Thread.sleep(1000);
		this.verify_workroom_Select_Dropdown();
		this.click_Workroom_Select_Dropdown();
		this.click_Auto_Attend();
		this.click_SaveUsers();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> add_Resume_To_Profile() -----------");
	}
	
	public void remove_Workroom_Auto_Attend_From_Profile() throws InterruptedException {
		this.clickWorkroomTab();
		Thread.sleep(1000);
		this.verify_workroom_Select_Dropdown();
		this.click_AutoAttend_X();
		this.click_SaveUsers();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> remove_Workroom_Auto_Attend_From_Profile() -----------");
	}
	
	public void verify_Auto_Attend_Workroom_NOT_PRESENT() throws InterruptedException {
		String workroom = "(//*[starts-with(@id,'row-')]/div[1]/div[contains(.,'AutoAttend')]/following::i[@class='fa fa-remove'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(workroom)).size() < 1);
		System.out.println("------- Completed --> verify_Auto_Attend_Workroom_Removed() -----------");
	}
	
	public void verify_Auto_Attend_Workroom_Removed() throws InterruptedException {
		this.clickWorkroomTab();
		Thread.sleep(1000);
		this.verify_workroom_Select_Dropdown();
		this.verify_Auto_Attend_Workroom_NOT_PRESENT();
		System.out.println("------- Completed --> verify_Auto_Attend_Workroom_Removed() -----------");
	}
	
	// --------------close_User_Profile---------------------------
	By save_Profile = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By save_Profile_Message = By.xpath("//p[contains(text(),'has been saved.')]");
	By term_Info_Dropdown = By.xpath("//span[@class='small-right col-sm-2'][contains(text(),'1st Term')]/following::div[@class='btn-group small pull-right']");
	By close_Profile = By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]");

	public void click_Save_Profile() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void close_Profile() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------Function Being Called ---------------------------
	public void close_Profile_TermInfo() throws InterruptedException {
		this.verify_Terminfo_Tab();
		Thread.sleep(1000);
		this.click_Save_Profile();
		Thread.sleep(3000);
		this.verify_Save_Profile_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> close_User_Profile() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void close_Profile_AutoTester() throws InterruptedException {
		this.close_Profile();
		Thread.sleep(2000);
		HomeNavigationPage obj = new HomeNavigationPage();
		obj.user_Close_Directory();
		Thread.sleep(1000);
		System.out.println("------- Completed --> close_Profile_AutoBE() -----------");
	}
	
	// --------------verify_AutoTester_Not_Present ---------------------------
	By auto_Director = By.xpath("//a[contains(text(),'Auto Director')]");
	
	public void verify_Auto_Director() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director)));
	}

	public void verify_AutoTester_Hidden() {
		String autoTester = "(//a[contains(text(),'Automation Tester')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(autoTester)).size() < 1);
	}
	
	public void verify_Test_Reset_Hidden() {
		String autoTester = "(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(autoTester)).size() < 1);
	}
	
	public void verify_Auto_User_7_Hidden() {
		String autoUser7 = "(//a[contains(text(),'Auto User7')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(autoUser7)).size() < 1);
	}
	
	public void verify_Auto_User_8_Hidden() {
		String autoTester = "(//a[contains(text(),'Auto User8')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(autoTester)).size() < 1);
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_AutoTester_Not_Present() throws InterruptedException {
		this.verify_Auto_Director();
		this.verify_AutoTester_Hidden();
		System.out.println("------- Completed --> verify_AutoTester_Not_Present() -----------");
	}
	
	public void verify_Test_Reset_Not_Present() throws InterruptedException {
		this.verify_Auto_Director();
		this.verify_Test_Reset_Hidden();
		System.out.println("------- Completed --> verify_Test_Reset_Not_Present() -----------");
	}
	
	public void verify_Auto_User_7_Not_Present() throws InterruptedException {
		this.verify_Auto_Director();
		this.verify_Auto_User_7_Hidden();
		System.out.println("------- Completed --> verify_Auto_User_7_Not_Present() -----------");
	}
	
	
	// --------------delete_TermInfo ---------------------------------
	By dropdown = By.xpath("//div[@class='btn-group small pull-right']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By delete = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Delete')]");
	By continue_Btn = By.xpath("//button[@class='btn commit btn-danger']");
	By second_Term = By.xpath("//span[contains(text(),'2nd Term')]");


	public void verify_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(dropdown)));
	}

	public void verify_Delete() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete)));
	}

	public void verify_Continue_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continue_Btn)));
	}
	
	public void verify_Second_Term() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(second_Term)));
	}

	public void click_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[@class='btn-group small pull-right']//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Delete() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Delete')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Continue_Btn() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@class='btn commit btn-danger']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	public void delete_TermInfo() throws InterruptedException {
		this.verify_Terminfo_Tab();
		this.click_Terminfo_Tab();
		Thread.sleep(1000);
		this.verify_Dropdown();
		this.click_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete();
		this.click_Delete();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_Continue_Btn();
		Thread.sleep(1000);
		this.click_Save_Profile();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();

		System.out.println("------- Completed --> delete_TermInfo() -----------");
	}
	
	public void verify_Delete_TermInfo() throws InterruptedException {
		this.verify_Terminfo_Tab();
		this.click_Terminfo_Tab();
		Thread.sleep(1500);
		this.verify_Dropdown();
		this.verify_First_Term();// verify term created 
		this.click_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete();
		this.click_Delete();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_Continue_Btn();
		Thread.sleep(1500);
		this.click_Save_Profile();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Delete_TermInfo() -----------");
	}
	
	public void verify_Term_Change() throws InterruptedException {
		this.verify_Terminfo_Tab();
		Thread.sleep(1000);
		this.click_Terminfo_Tab();
		Thread.sleep(1000);
		this.verify_Second_Term();
		System.out.println("------- Completed --> delete_TermInfo() -----------");
	}
	
	public void deleted_Edited_Term_Info() throws InterruptedException {
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
		Thread.sleep(2500);
		System.out.println("------- Completed --> deleted_Edited_Term_Info() -----------");
	}
	
	// -----------------------delete_Photo ---------------------------
	By remove_Photo = By.xpath("//input[@id='user_remove_photo']");

	public void click_Remove_Photo() {
		DriverFactory.getInstance().getDriver().findElement(remove_Photo).click();
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
		Thread.sleep(1000);
		this.click_Save_Profile();
		System.out.println("------- Completed --> delete_Photo() -----------");
	}
	// -------------------delete_Category ----------------------------
	By remove_Board_Member_1 = By.xpath("//form//span[1]//a[1]//i[1]");

	public void remove_Board_Members() {
		DriverFactory.getInstance().getDriver().findElement(remove_Board_Member_1).click();
	}

	// -------------------Function Being Called ----------------------
	public void delete_Category_Board_Member() throws InterruptedException {
		this.verify_Additional_Tab();
		this.click_Additional_Tab();
		Thread.sleep(1500);
		this.remove_Board_Members();
		this.click_Save_Profile();
		Thread.sleep(1000);
		this.verify_Save_Profile_Message();
		this.verify_Additional_Tab();
		this.click_Additional_Tab();
		Thread.sleep(1500);
		System.out.println("------- Completed --> delete_Photo() -----------");
	}
	// -------------------delete_Resume----------------------
	By remove_Resume = By.xpath("//input[@id='user_remove_resume']");

	public void click_Remove_Resume() {
		DriverFactory.getInstance().getDriver().findElement(remove_Resume).click();
	}
	
	public void verify_Resume_NOT_Present() throws InterruptedException {
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(remove_Resume).size() < 1);
		System.out.println("------- Completed --> verify_Remove_Photo_NOT_Present() -----------");
	}

	// -------------------Function Being Called ----------------------
	public void delete_Resume() throws InterruptedException {
		this.verify_More_Tab();
		Thread.sleep(500);
		this.click_More_Tab();
		Thread.sleep(1000);
		this.verify_Attachments();
		this.click_Attachments();
		Thread.sleep(1000);
		this.verify_Photo_Input();
		this.click_Remove_Resume();
		Thread.sleep(1000);
		this.click_Save_Profile();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> delete_Photo() -----------");
	}
	
	public void verify_Resume_Deleted() throws InterruptedException {
		this.verify_More_Tab();
		this.click_More_Tab();
		Thread.sleep(1000);
		this.verify_Attachments();
		this.click_Attachments();
		Thread.sleep(1000);
		this.verify_Photo_Input();
		this.verify_Resume_NOT_Present();
		System.out.println("------- Completed --> verify_Resume_Deleted() -----------");
	}

	// --------------Function Being Called ---------------------------
	public void verify_TermInfo_Deleted() throws InterruptedException {
		this.verify_Terminfo_Tab_2();
		this.click_Terminfo_Tab_2();
		Thread.sleep(1500);
		this.term_Info_NOT_Present();
		System.out.println("------- Completed --> verify_TermInfo_Deleted() -----------");
	}
	
	// --------------Function Being Called ---------------------------	
	public void verify_Photo_Deleted() throws InterruptedException {
		this.verify_Terminfo_Tab_2();
		Thread.sleep(1000);
		this.click_More_Tab();
		Thread.sleep(1000);
		this.verify_Attachments();
		this.click_Attachments();
		Thread.sleep(1000);
		this.verify_Photo_Input();
		this.verify_Remove_Photo_NOT_Present();
		System.out.println("------- Completed --> verify_TermInfo_Deleted() -----------");
	}
	
	
	
	
	
	public void verify_Remove_Photo_NOT_Present() throws InterruptedException {
		String remove_Photo = "//input[@id='user_remove_photo']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(remove_Photo)).size() < 1);
		System.out.println("------- Completed --> verify_Remove_Photo_NOT_Present() -----------");
	}
	
	// --------------verify_Board_Member_Removed---------------------------

	public void verify_Member_Deleted() throws InterruptedException {
		String board_Member = "//p[contains(text(),'Board Member')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(board_Member)).size() < 1);
		System.out.println("------- Completed --> deletion verified() -----------");
	}

	// --------------Function Being Called --------------------------------
	public void verify_Board_Member_Deleted() throws InterruptedException {
		this.verify_Member_Deleted();
		System.out.println("------- Completed --> verify_Board_Member_Deleted -----------");
	}
	
		
}
