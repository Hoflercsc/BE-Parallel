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

public class RsUserPwPage {
	WebDriver driver;

	public RsUserPwPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// -------------POM Page Object model-----------------------
	// -------------user_Opens_Settings_Form_Open_Reports------------------------
	By directory = By.xpath("//span[contains(text(),'Directory')]");
	By search_Field = By.xpath("//input[@id='keyword']");
	By reports = By.xpath("//span[@class='translation_missing'][contains(text(),'Reports')]");
	String testRest = "Test Reset";

	public void verify_Directory() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(directory)));
	}

	public void verify_Search_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(search_Field)));
	}

	public void click_Directory() {
		driver.findElement(directory).click();
	}

	public void click_Search_Field_Sendkeys_Enter() {
		driver.findElement(search_Field).sendKeys(testRest);
		driver.findElement(search_Field).sendKeys(Keys.ENTER);
	}

	// -------Function Being called -----------
	public void systemAdmin_Opens_Directory_Search_For_User() throws InterruptedException {
		this.click_Directory();
		this.verify_Search_Field();
		this.click_Search_Field_Sendkeys_Enter();
		Thread.sleep(2000);
		System.out.println("------- Completed --> systemAdmin_Opens_Directory_Search_For_User() -----------");
	}
	
	// -------systemAdmin_Update_User_Password -----------
	By user = By.xpath("//a[contains(text(),'Test Reset')]/following::td[@class='modal-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By test_Reset_Drpdown = By.xpath("//h4[contains(text(),'Test Reset')]//following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By edit_Profile_Option = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");
	By settings = By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Settings')]");
	By password_1 = By.xpath("//input[@id='user_password']");
	By password_2 = By.xpath("//input[@id='user_password_confirmation']");
	By saveBtn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By profile_Saved_Message = By.xpath("//p[contains(text(),'Profile for Test Reset has been saved.')]");

	public void verify_Edit_Profile_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Profile_Option)));
	}

	public void verify_Settings_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings)));
	}

	public void verify_Password_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(password_1)));
	}

	public void verify_Profile_Saved_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_Saved_Message)));
	}

	public void click_Test_User_Dropdown() {
		driver.findElement(user).click();
	}

	public void click_Edit_Profile_Option() {
		driver.findElement(edit_Profile_Option).click();
	}

	public void click_Settings() {
		driver.findElement(settings).click();
	}

	public void password_Fields_SendKeys() {
		String pass = "Passw1rd";
		String pass_Conf = "Passw1rd";
		driver.findElement(password_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(password_1).clear();
		driver.findElement(password_1).sendKeys(pass);
		driver.findElement(password_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(password_2).clear();
		driver.findElement(password_2).sendKeys(pass_Conf);
	}

	public void clickSaveBtn() throws InterruptedException {
		WebElement save = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		driver.findElement(saveBtn).click();
	}

	// -------Function Being called -----------
	public void systemAdmin_Update_User_Password() throws InterruptedException {
		this.click_Test_User_Dropdown();
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
	
	// -------systemAdmin_Close_Profile_And_Logout -----------
	By profile_CloseBtn = By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]");
	By directory_Close_Btn = By.xpath("//div[@id='directoryModal']//div[@class='modal-header']//a[1]");
	By user_Dropdown = By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By sign_Out = By.xpath("//a[contains(text(),'Sign Out')]");

	public void verify_User_DropDown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Dropdown)));
	}

	public void verify_Sign_Out() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sign_Out)));
	}

	public void click_Profile_CloseBtn() {
		driver.findElement(profile_CloseBtn).click();
	}

	public void click_Directory_CloseBtn() {
		driver.findElement(directory_Close_Btn).click();
	}

	public void click_User_Dropdown() {
		// driver.findElement(user_Dropdown).click();
		WebElement dropdown = driver.findElement(By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", dropdown);
	}

	public void click_Sign_Out() {
		driver.findElement(sign_Out).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(usernameinput)));
	}

	public void verify_Profile_Name_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_Dropdown)));
	}

	public void new_UserName_Password() {
		String username = "testReset";
		String password = "Passw1rd";
		driver.findElement(usernameinput).sendKeys(username);
		driver.findElement(passwordinput).sendKeys(password);
	}

	public void click_BoardEffect_Login() {
		driver.findElement(loginbutton).click();
	}

	// -------Function Being called -----------
	public void workroom_Member_Login_To_BoardEffect() throws InterruptedException {
		this.verify_Login_UserName();
		this.new_UserName_Password();
		this.click_BoardEffect_Login();
		this.verify_Profile_Name_Dropdown();
		System.out.println("------- Completed --> workroom_Member_Login_To_BoardEffect() -----------");
	}
	
	// ------- workroom_Member_Reset_Password -----------
	By reset_Password = By.xpath("//a[contains(text(),'Reset Password')]");
	By current_Password = By.xpath("//input[@id='user_current_password']");
	By close_Window = By.xpath("//div[@id='quick_add']//button[@class='close']");

	public void verify_Reset_Password() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(reset_Password)));
	}
	
	public void verify_Current_Password() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(current_Password)));
	}

	public void click_Reset_Password() {
		driver.findElement(reset_Password).click();
	}
	
	public void close_Password_Window() {
		driver.findElement(close_Window).click();
	}
	
	public void clickSaveBtn2() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='formsSubmit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		//driver.findElement(saveBtn).click();
	}

	public void password_Fields_SendKeys_2() {
		String pass = "Passw0rd";
		String pass_Conf = "Passw0rd";
		String current_Pass = "Passw1rd";
		driver.findElement(current_Password).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(current_Password).clear();
		driver.findElement(current_Password).sendKeys(current_Pass);
		driver.findElement(password_1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(password_1).clear();
		driver.findElement(password_1).sendKeys(pass);
		driver.findElement(password_2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(password_2).clear();
		driver.findElement(password_2).sendKeys(pass_Conf);
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
		this.close_Password_Window();
		System.out.println("------- Completed --> workroom_Member_Reset_Password() -----------");
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
		driver.findElement(usernameinput).sendKeys(username);
		driver.findElement(passwordinput).sendKeys(password);
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
