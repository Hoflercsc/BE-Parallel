package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
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
import com.aventstack.extentreports.ExtentTest;
import page_common_functions.AtlasNavBar;
import parallel.DriverFactory;
import tests_critical_scenarios.BaseTestCriticalScenarios;

public class RsUserPwPage {
	
	
	// -------------POM Page Object model------------
	// ---------user_Opens_Settings_Form_Open_Reports-------------
	By directory = By.xpath("//span[contains(text(),'Directory')]");
	By search_Field = By.xpath("//input[@id='keyword']");
	By reports = By.xpath("//span[@class='translation_missing'][contains(text(),'Reports')]");
	String testRest = "Test Reset";

	public void verify_Directory() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(directory)));
	}

	public void verify_Search_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(search_Field)));
	}

	public void click_Directory() {
		DriverFactory.getInstance().getDriver().findElement(directory).click();
	}

	public void click_Search_Field_Sendkeys_Enter() {
		DriverFactory.getInstance().getDriver().findElement(search_Field).sendKeys(testRest);
		DriverFactory.getInstance().getDriver().findElement(search_Field).sendKeys(Keys.ENTER);
	}

	// -------Function Being called -----------
	public void systemAdmin_Opens_Directory_Search_For_User() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Directory();
		this.click_Search_Field_Sendkeys_Enter();
		Thread.sleep(2000);
		System.out.println("------- Completed --> systemAdmin_Opens_Directory_Search_For_User() -----------");
	}
	
	// -------systemAdmin_Update_User_Password -----------
	By user = By
			.xpath("//a[contains(text(),'Test Reset')]/following::td[@class='modal-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By test_Reset_Drpdown = By.xpath("//h4[contains(text(),'Test Reset')]//following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By edit_Profile_Option = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");
	By settings = By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Settings')]");
	By password_1 = By.xpath("//input[@id='user_password']");
	By password_2 = By.xpath("//input[@id='user_password_confirmation']");
	By saveBtn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By profile_Saved_Message = By.xpath("//p[contains(text(),'Profile for')]");
	By current_Password = By.xpath("//input[@id='user_current_password']");


	public void verify_Edit_Profile_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Profile_Option)));
	}

	public void verify_Settings_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings)));
	}

	public void verify_Password_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(password_1)));
	}
	
	public void verify_Current_Password() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(current_Password)));
	}

	public void verify_Profile_Saved_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_Saved_Message)));
	}

	public void click_Test_User_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(user).click();
	}

	public void click_Edit_Profile_Option() {
		DriverFactory.getInstance().getDriver().findElement(edit_Profile_Option).click();
	}

	public void click_Settings() {
		DriverFactory.getInstance().getDriver().findElement(settings).click();
	}

	public void password_Fields_SendKeys() {
		String pass = "Passw1rd";
		String pass_Conf = "Passw1rd";
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_1).clear();
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(pass);
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_2).clear();
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(pass_Conf);
	}
	
	public void password_Fields_SendKeys_Orginal() {
		String pass = "Passw0rd";
		String pass_Conf = "Passw0rd";
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_1).clear();
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(pass);
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_2).clear();
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(pass_Conf);
	}


	public void clickSaveBtn() throws InterruptedException {
		WebElement save = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", save);
		DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}
	
	public void clickSaveBtn2() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='formsSubmit']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
		//DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}

	// -------Function Being called -----------
	public void systemAdmin_Update_User_Password() throws InterruptedException {
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile_Option();
		this.click_Edit_Profile_Option();
		this.verify_Settings_Tab();
		this.click_Settings();
		this.verify_Password_Field();
		this.password_Fields_SendKeys();
		this.clickSaveBtn();
		this.verify_Profile_Saved_Message();
		System.out.println("------- Completed --> systemAdmin_Update_User_Password() -----------");
	}
	
	public void systemAdmin_Update_User_Password_Back_To_Original() throws InterruptedException {
		Thread.sleep(2000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile_Option();
		this.click_Edit_Profile_Option();
		Thread.sleep(1000);
		this.verify_Settings_Tab();
		this.click_Settings();
		Thread.sleep(1000);
		this.verify_Password_Field();
		this.password_Fields_SendKeys_Orginal();
		this.clickSaveBtn();
		Thread.sleep(1000);
		this.verify_Profile_Saved_Message();
		System.out.println("------- Completed --> systemAdmin_Update_User_Password_Back_To_Original() -----------");
	}
	
	// -------systemAdmin_Close_Profile_And_Logout -----------
	By profile_CloseBtn = By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]");
	By profile_CloseBtn_2 = By.xpath("//div[@id='quick_add']//button[@class='close']");
	By directory_Close_Btn = By.xpath("//div[@id='directoryModal']//div[@class='modal-header']//a[1]");
	By user_Dropdown = By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By sign_Out = By.xpath("//a[contains(text(),'Sign Out')]");

	public void verify_User_DropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Dropdown)));
	}

	public void verify_Sign_Out() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sign_Out)));
	}

	public void click_Profile_CloseBtn() {
		DriverFactory.getInstance().getDriver().findElement(profile_CloseBtn).click();
	}
	
	public void click_Profile_CloseBtn_2() {
		DriverFactory.getInstance().getDriver().findElement(profile_CloseBtn_2).click();
	}

	public void click_Directory_CloseBtn() {
		DriverFactory.getInstance().getDriver().findElement(directory_Close_Btn).click();
	}

	public void click_User_Dropdown() {
		// DriverFactory.getInstance().getDriver().findElement(user_Dropdown).click();
		WebElement dropdown = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", dropdown);
	}

	public void click_Sign_Out() {
		DriverFactory.getInstance().getDriver().findElement(sign_Out).click();
	}

	// -------Function Being called -----------
	public void systemAdmin_Close_Profile_And_Logout() throws InterruptedException {
		this.click_Profile_CloseBtn();
		Thread.sleep(2000);
		this.click_Directory_CloseBtn();
		Thread.sleep(2000);
		this.verify_User_DropDown();
		this.click_User_Dropdown();
		this.verify_Sign_Out();
		this.click_Sign_Out();
		System.out.println("------- Completed --> systemAdmin_Close_Profile_And_Logout() -----------");
	}
	
	// ------- workroom_Member_Login_To_BoardEffect -----------
	By usernameinput = By.xpath("//input[@id='login_login']");
	By passwordinput = By.xpath("//input[@id='login_password']");
	By loginbutton = By.xpath("//button[@class='btn btn-success']");
	By profile_Dropdown = By.xpath("//span[@class='user-name'][contains(text(),'Test Reset')]/following::div[@class='btn-group small']");

	public void verify_Login_UserName() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(usernameinput)));
	}

	public void verify_Profile_Name_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_Dropdown)));
	}

	public void new_UserName_Password() {
		String username = "testReset";
		String password = "Passw1rd";
		DriverFactory.getInstance().getDriver().findElement(usernameinput).sendKeys(username);
		DriverFactory.getInstance().getDriver().findElement(passwordinput).sendKeys(password);
	}
	
	public void orginal_UserName_Password() {
		String username = "testReset";
		String password = "Passw0rd";
		DriverFactory.getInstance().getDriver().findElement(usernameinput).sendKeys(username);
		DriverFactory.getInstance().getDriver().findElement(passwordinput).sendKeys(password);
	}


	public void click_BoardEffect_Login() {
		DriverFactory.getInstance().getDriver().findElement(loginbutton).click();
	}

	// -------Function Being called -----------
	public void workroom_Member_Login_To_BoardEffect() throws InterruptedException {
		this.verify_Login_UserName();
		this.new_UserName_Password();
		this.click_BoardEffect_Login();
		this.verify_Profile_Name_Dropdown();
		System.out.println("------- Completed --> workroom_Member_Login_To_BoardEffect() -----------");
	}
	
	
	public void workroom_Member_Login_To_BoardEffect_Orginal_Password() throws InterruptedException {
		this.verify_Login_UserName();
		this.orginal_UserName_Password();
		
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean newSignIn = DriverFactory.getInstance().getDriver().findElements(newLoginButton).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if (newSignIn == true) {
			  this.click_New_Log_In_Button();
			  Thread.sleep(1500);
			} else {
			  this.click_BoardEffect_Login();
			  Thread.sleep(1500);
			}
		System.out.println("------- Completed --> workroom_Member_Login_To_BoardEffect_Orginal_Password() -----------");
	}
	
	// ------- workroom_Member_Reset_Password -----------
	By reset_Password = By.xpath("//a[contains(text(),'Reset Password')]");
	By newLoginButton = By.xpath("//button[@class='signin-button']");


	public void verify_Reset_Password() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(reset_Password)));
	}

	public void click_Reset_Password() {
		DriverFactory.getInstance().getDriver().findElement(reset_Password).click();
	}
	
	public void click_New_Log_In_Button() {
		DriverFactory.getInstance().getDriver().findElement(newLoginButton).click();
	}

	public void password_Fields_SendKeys_2() {
		String pass = "Passw0rd";
		String pass_Conf = "Passw0rd";
		String current_Pass = "Passw1rd";
		DriverFactory.getInstance().getDriver().findElement(current_Password).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(current_Password).clear();
		DriverFactory.getInstance().getDriver().findElement(current_Password).sendKeys(current_Pass);
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_1).clear();
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(pass);
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_2).clear();
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(pass_Conf);
	}
	
	public void password_Settings_1() {	
		String current_Pass = "Passw0rd";
		String new_Passw0rd = "!Passw0rd11";
		
		DriverFactory.getInstance().getDriver().findElement(current_Password).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(current_Password).clear();
		DriverFactory.getInstance().getDriver().findElement(current_Password).sendKeys(current_Pass);
		
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_1).clear();
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(new_Passw0rd);
		
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_2).clear();
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(new_Passw0rd);
	}
	
	public void password_Settings_2() {	
		String current_Pass = "!Passw0rd11";
		String new_Passw0rd = "Passw0rd";
		
		DriverFactory.getInstance().getDriver().findElement(current_Password).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(current_Password).clear();
		DriverFactory.getInstance().getDriver().findElement(current_Password).sendKeys(current_Pass);
		
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_1).clear();
		DriverFactory.getInstance().getDriver().findElement(password_1).sendKeys(new_Passw0rd);
		
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(password_2).clear();
		DriverFactory.getInstance().getDriver().findElement(password_2).sendKeys(new_Passw0rd);
	}
	
	public void workroom_Member_Login_To_BoardEffect_2() throws InterruptedException {
		this.verify_Login_UserName();
		this.new_UserName_Password();
		
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean newSignIn = DriverFactory.getInstance().getDriver().findElements(newLoginButton).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if (newSignIn == true) {
			  this.click_New_Log_In_Button();
			  Thread.sleep(1500);
			} else {
			  this.click_BoardEffect_Login();
			  Thread.sleep(1500);
			}
		System.out.println("------- Completed --> workroom_Member_Login_To_BoardEffect() -----------");
	}

	// -------Function Being called -----------
	public void workroom_Member_Reset_Password() throws InterruptedException {
		this.click_User_Dropdown();
		this.verify_Reset_Password();
		this.click_Reset_Password();
		this.verify_Current_Password();
		this.password_Fields_SendKeys_2();
		this.clickSaveBtn2();
		this.verify_Profile_Saved_Message();
		this.click_Profile_CloseBtn_2();
		System.out.println("------- Completed --> workroom_Member_Reset_Password() -----------");
	}
	
	By profile_Drp_Dwn_Button = By.xpath("//*[@id='profileModal']/div/div/div[1]/h4/div/button");

	
	public void click_Profile_Drp_Dwn_Button() {
		DriverFactory.getInstance().getDriver().findElement(profile_Drp_Dwn_Button).click();
	}
	
	public void reset_Password_For_Password_Settings_1() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Profile();
		this.click_Profile_Drp_Dwn_Button();
		Thread.sleep(1000);
		this.click_Reset_Password();
		Thread.sleep(1000);

		this.verify_Current_Password();
		this.password_Settings_1();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verify_Profile_Saved_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> modify_Password_Settings_1() -----------");
	}
	
	public void reset_Password_For_Password_Settings_2() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Profile();
		this.click_Profile_Drp_Dwn_Button();
		Thread.sleep(1000);
		this.click_Reset_Password();
		Thread.sleep(1000);

		this.verify_Current_Password();
		this.password_Settings_2();
		this.clickSaveBtn2();
		Thread.sleep(1000);
		this.verify_Profile_Saved_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		//this.click_Profile_CloseBtn_2();
		System.out.println("------- Completed --> modify_Password_Settings_1() -----------");
	}

	public void workroom_Member_Close_Profile_And_Logout() throws InterruptedException {
		Thread.sleep(2000);
		this.verify_User_DropDown();
		this.click_User_Dropdown();
		this.verify_Sign_Out();
		this.click_Sign_Out();
		System.out.println("------- Completed --> workroom_Member_Close_Profile_And_Logout() -----------");
	}

	// -------workroom_Member_Login_With_Updated_Password -----------
	public void new_UserName_Password_2() {
		String username = "testReset";
		String password = "Passw0rd";
		DriverFactory.getInstance().getDriver().findElement(usernameinput).sendKeys(username);
		DriverFactory.getInstance().getDriver().findElement(passwordinput).sendKeys(password);
	}

	// -------Function Being called -----------
	public void workroom_Member_Login_With_Updated_Password() throws InterruptedException {
		this.verify_Login_UserName();
		this.new_UserName_Password_2();
		this.click_BoardEffect_Login();
		this.verify_Profile_Name_Dropdown();
		Thread.sleep(2000);
		System.out.println("------- Completed --> workroom_Member_Login_With_Updated_Password() -----------");
	}
}
