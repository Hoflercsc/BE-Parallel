package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.time.Duration;
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

public class UserProfilePage {
	
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;
	String userFirstName = "Super";
	String userLastName = "Testman";
	String userLogin = "SuperTestman";
	String userLoginUpdated = "EliTestman";
	String userPassword = "Passw0rd";
	String companyEmail = "superTestman@diligent.com";
	String companyEmailUpdated = "EliTestman@diligent.com";
	String userFirstNameUpdated = "Eli";
	String userLastNameUpdated = "Testman";
	By WelcomeHeader = By.xpath("//h1[contains(text(),'Welcome')]");
	By directoryMenu = By.xpath("//span[contains(text(),'Directory')]");
	By userSearchField = By.xpath("//input[@id='keyword']");
	By dropdownBtn = By.xpath("//td[@class='modal-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By deactivateUser = By.xpath("//a[contains(text(),'Deactivate User')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");
	By profile_deactivated_Message = By.xpath("//p[contains(text(),'Profile for Super Testman has been deactivated.')]");
	By saveBtn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By closeBtn = By.xpath("//div[@id='directoryModal']//div[@class='modal-header']//a[1]");
	By settings = By.xpath("//span[contains(text(),'Settings')]");
	By settings_side_Menu_Bar = By.xpath("//div[@id='settingsModal']//div[@class='modal-sidebar-container']");
	By manageUsers = By.xpath("//a[contains(text(),'Manage Users')]");
	// By inactiveUsers = By.xpath("//a[contains(text(),'Inactive Users')]");
	By inactiveUsers = By.xpath("//ul[@class='nav nav-tabs']//li[2]");
	// ---contains---following xpath ---
	By supertestman = By.xpath(
			"//a[contains(text(),'Super Testman')]/following::div[@class='btn-group small open']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By deleteUser = By.xpath("//a[contains(text(),'Delete User')]");
	By formInputField = By.xpath("//div[@class='modal-dialog']//input[@class='form-control']");
	By continueBtn2 = By.xpath("(//button[@class='btn commit btn-danger'][contains(text(),'Continue')])[2]");
	By sucessfully_Deleted_User_Message = By.xpath("//p[contains(text(),'Successfully deleted User')]");
	By closeModal = By.xpath("//a[@id='settingsModalClose']");

	public UserProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	// ------------------ Methods ---------------------
	public void verifyWelcomeHeader() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(WelcomeHeader)));
	}

	public void verifyUserSearchField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(userSearchField)));
	}

	public void verifyDeactivateUser() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivateUser)));
	}

	public void verifyContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void verify_Profile_Deactivated_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_deactivated_Message)));
	}

	public void verify_CloseBtn_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(closeBtn)));
	}

	public void verifySettings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings)));
	}

	public void verify_Settings_Side_Menu_Bar() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_side_Menu_Bar)));
	}

	public void verifyInactiveUsers() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(inactiveUsers)));
	}

	public void verifySuperTestManPresent() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(supertestman)));
	}

	public void verifyDeleteUserPresent() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteUser)));
	}

	public void verifyFormInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(formInputField)));
	}

	public void verify_Sucessfully_Deleted_User_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sucessfully_Deleted_User_Message)));
	}

	// ------------------ Elements ---------------------
	public void clickDirectoryMenu() {
		WebElement directorymenu = driver.findElement(By.xpath("//span[contains(text(),'Directory')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", directorymenu);
		// driver.findElement(directoryMenu).click();
	}

	public void clickUserSearchAndSendKeys() throws InterruptedException {
		driver.findElement(userSearchField).click();
		driver.findElement(userSearchField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(userSearchField).sendKeys(userFirstName + " " + userLastName);
		Thread.sleep(1000);
		driver.findElement(userSearchField).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	public void clickDeactivateUser() {
		driver.findElement(deactivateUser).click();
	}

	public void clickContinueBtn() {
		// driver.findElement(continueBtn).click();
		WebElement element = driver.findElement(By.xpath("//button[@class='btn commit btn-danger']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickSaveBtn() throws InterruptedException {
		WebElement SaveBtn = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(saveBtn).click();
	}

	public void clickDirectoryCloseBtn() {
		WebElement closeBtn1 = driver.findElement(By.xpath("//div[@id='directoryModal']//div[@class='modal-header']//a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", closeBtn1);
		// driver.findElement(closeBtn).click();
	}

	public void clickSettingsBtn() {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(settings).click();
	}

	public void clickManageUsers() {
		// driver.findElement(manageUsers).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Manage Users')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickInactiveUsers() {
		driver.findElement(inactiveUsers).click();
	}

	public void verifySuperTestMan() {
		driver.findElement(inactiveUsers).click();
	}

	public void click_SuperTestMan_Dropdown() {
		// driver.findElement(supertestman).click();
		WebElement element = driver.findElement(By.xpath(
				"(//a[contains(text(),'Super Testman')]/following::div[@class='btn-group small']//button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickDeleteUser() {
		driver.findElement(deleteUser).click();
	}

	public void form_Input_Field_SendKeys() {
		driver.findElement(formInputField).click();
		driver.findElement(formInputField).sendKeys(userLastName);
	}

	public void clickContinueBtn2() {
		driver.findElement(continueBtn2).click();
	}

	public void clickCloseModal() {
		WebElement closemodal = driver.findElement(By.xpath("//a[@id='settingsModalClose']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closemodal);
		WebElement closemodalclick = driver.findElement(By.xpath("//a[@id='settingsModalClose']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", closemodalclick);
		// driver.findElement(closeModal).click();
	}

	public void verify_Username1_Not_Created() throws InterruptedException {
		String userFullName = "//a[contains(text(),'Super Testman')]";
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean name = driver.findElements(By.xpath(userFullName)).size() < 1;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (name == false) {
			// ----process to delete user if created ------
			driver.findElement(supertestman).click();
			verifyDeactivateUser();
			clickDeactivateUser();
			verifyContinueBtn();
			clickContinueBtn();
			verify_Profile_Deactivated_Message();
			clickSaveBtn();
			Thread.sleep(2000);
			verify_CloseBtn_Visible();
			clickDirectoryCloseBtn();
			// verifyWelcomeHeader();
			verifySettings();
			clickSettingsBtn();
			verify_Settings_Side_Menu_Bar();
			clickManageUsers();
			verifyInactiveUsers();
			clickInactiveUsers();
			verifySuperTestManPresent();// ---contains xpath library 1.0
										// https://www.guru99.com/using-contains-sbiling-ancestor-to-find-element-in-selenium.html
			click_SuperTestMan_Dropdown();
			verifyDeleteUserPresent();
			clickDeleteUser();
			verifyFormInputField();
			form_Input_Field_SendKeys();
			clickContinueBtn2();
			verify_Sucessfully_Deleted_User_Message();
			clickCloseModal();
			verifyWelcomeHeader();
		} else {
			driver.findElement(closeBtn).click();
		}
	}

	// ------------------ Function Being Called ----------------------
	public void systemAdmin_Open_Directory_Search_For_User() throws InterruptedException {
		this.verifyWelcomeHeader();
		this.clickDirectoryMenu();
		this.verifyUserSearchField();
		this.clickUserSearchAndSendKeys();
		// -----------this is a complex function----------------------
		this.verify_Username1_Not_Created();
		System.out.println("------- Completed --> System Admin Open Directory Search For User -----------");
	}
	
	// -----------System Admin Create Old User--------------------------
	By addUserDropdown = By.xpath("//button[@id='new_users']");
	By addOneUser = By.xpath("//div[@id='settingsModal']//a[@class='no-mobile'][contains(text(),'Add One User')]");
	By newUser_Input_FirstName = By.xpath("//input[@id='user_firstname']");
	By newUser_Input_LastName = By.xpath("//input[@id='user_lastname']");
	By newUser_Input_LogIn = By.xpath("//input[@id='user_login']");
	By newUser_Password = By.xpath("//input[@id='user_password']");
	By newUser_PasswordConfirm = By.xpath("//input[@id='user_password_confirmation']");
	By newUser_CompanyEmail = By.xpath("//input[@id='user_companyemail']");
	By newUser_SaveBtn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By newUser_CreatedMessage = By
			.xpath("//div[@id='profileModal']//div[@class='flash']//p[contains(text(),'Profile for Super Testman has been created. ')]");
	By newUser_CreatedMessag2 = By
			.xpath("//div[@id='profileModal']//div[@class='flash']//p[contains(text(),'Profile for Eli Testman has been created. ')]");
	By profile_Saved_Message = By.xpath("//p[contains(text(),'Profile for Super Testman has been saved.')]");
	By profile_Saved_Message_2 = By.xpath("//p[contains(text(),'Profile for Eli Testman has been saved.')]");
	By profileCloseBtn = By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]");
	By settingsCloseBtn = By.xpath("//a[@id='settingsModalClose']");

	public void verifyAddOneUser() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addOneUser)));
	}

	public void verify_NewUser_InputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newUser_Input_FirstName)));
	}

	public void verify_NewUser_CreatedMessage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newUser_CreatedMessage)));
	}

	public void verify_NewUser_CreatedMessage_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newUser_CreatedMessag2)));
	}

	public void verify_Profile_Saved_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(profile_Saved_Message)));
	}

	public void verify_Profile_Saved_Message_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_Saved_Message_2)));
	}

	public void clickAddUser() {
		driver.findElement(addUserDropdown).click();
	}

	public void clickAddOneUser() {
		driver.findElement(addOneUser).click();
	}

	public void newUserFormFill() {
		driver.findElement(newUser_Input_FirstName).sendKeys(userFirstName);
		driver.findElement(newUser_Input_LastName).sendKeys(userLastName);
		driver.findElement(newUser_Input_LogIn).sendKeys(userLogin);
		driver.findElement(newUser_Password).sendKeys(userPassword);
		driver.findElement(newUser_PasswordConfirm).sendKeys(userPassword);
		driver.findElement(newUser_CompanyEmail).sendKeys(companyEmail);
		driver.findElement(newUser_SaveBtn).click();
	}

	public void newUserFormFill2() {
		driver.findElement(newUser_Input_FirstName).sendKeys(userFirstNameUpdated);
		driver.findElement(newUser_Input_LastName).sendKeys(userLastName);
		driver.findElement(newUser_Input_LogIn).sendKeys(userLoginUpdated);
		driver.findElement(newUser_Password).sendKeys(userPassword);
		driver.findElement(newUser_PasswordConfirm).sendKeys(userPassword);
		driver.findElement(newUser_CompanyEmail).sendKeys(companyEmailUpdated);
		driver.findElement(newUser_SaveBtn).click();
	}

	public void scrolldownClickSave() throws InterruptedException {
		WebElement SaveBtn = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(2000);
		WebElement SaveBtn2 = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", SaveBtn2);
		// driver.findElement(newUser_SaveBtn).click();
	}

	public void clickProfileCloseBtn() throws InterruptedException {
		WebElement closeBtn = driver.findElement(By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", closeBtn);
		// driver.findElement(profileCloseBtn).click();
	}

	public void clickSettingsCloseBtn() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(settingsCloseBtn).click();
	}

	// --------------------Function Being Called -----------------------
	public void systemAdmin_Create_Old_User_1() throws InterruptedException {
		this.verifyWelcomeHeader();
		this.clickSettingsBtn();
		this.verify_Settings_Side_Menu_Bar();
		Thread.sleep(2000);
		this.clickManageUsers();
		Thread.sleep(2000);
		this.verifyInactiveUsers();
		this.clickAddUser();
		this.verifyAddOneUser();
		Thread.sleep(2000);
		this.clickAddOneUser();
		// ----create 1st old user ------------
		this.verify_NewUser_InputField();
		this.newUserFormFill();
		this.verify_NewUser_CreatedMessage();
		this.scrolldownClickSave();
		Thread.sleep(2000);
		this.verify_Profile_Saved_Message();
		this.clickProfileCloseBtn();
		Thread.sleep(1500);
		this.verify_Settings_Side_Menu_Bar();
		System.out.println("------- Completed --> systemAdmin_Create_Old_User_1 -----------");
	}

	// --------------------Function Being Called -----------------------
	public void systemAdmin_Create_Old_User_2() throws InterruptedException {
		this.clickSettingsCloseBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		this.clickSettingsBtn();
		this.verify_Settings_Side_Menu_Bar();
		Thread.sleep(2000);
		this.clickManageUsers();
		Thread.sleep(1000);
		this.verifyInactiveUsers();
		this.clickAddUser();
		this.verifyAddOneUser();
		Thread.sleep(2000);
		this.clickAddOneUser();
		this.verify_NewUser_InputField();
		this.newUserFormFill2();
		this.verify_NewUser_CreatedMessage_2();
		this.scrolldownClickSave();
		this.verify_Profile_Saved_Message_2();
		this.clickProfileCloseBtn();
		this.verify_Settings_Side_Menu_Bar();
		this.clickSettingsCloseBtn();
		this.verifyWelcomeHeader();
		driver.navigate().refresh();
		driver.navigate().refresh();
		System.out.println("------- Completed --> System_Admin_Create_Old_User_2 -----------");
	}

	// ---------- Methods for -> Verifying 2 Old Users Created------------
	public void verify_Old_User1_Created() throws InterruptedException {
		String supertestman = "(//a[contains(text(),'Super Testman')]/following::div[@class='btn-group small'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(supertestman)).size() > 0);
	}

	public void verify_Old_User2_Created() throws InterruptedException {
		String elitestman = "(//a[contains(text(),'Eli Testman')]/following::div[@class='btn-group small'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(elitestman)).size() > 0);
	}

	// --------------------Function Being Called -----------------------
	public void verify_Old_Users_Created() throws InterruptedException {
		this.clickDirectoryMenu();
		this.verifyUserSearchField();
		// this.clickUserSearchAndSendKeys();
		this.verify_Old_User1_Created();
		this.verify_Old_User2_Created();
		System.out.println("------- Completed --> verify_Old_Users_Created -----------");
	}
	
	// ----------- Element/Methods--> For Deactivate Older Users ---------
	By elitestman = By.xpath("//a[contains(text(),'Eli Testman')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By deactivate_User_inList = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Deactivate User')]");
	By profile_deactivated_Message_2 = By.xpath("//p[contains(text(),'Profile for Eli Testman has been deactivated')]");

	public void verify_Deactivate_User_inList() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Deactivate User')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivate_User_inList)));
	}

	public void verify_Profile_Deactivated_Message_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_deactivated_Message_2)));
	}

	public void clickEliArrowBtn() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(elitestman).click();
	}

	public void click_Deactivate_User_inList() throws InterruptedException {
		// driver.findElement(deactivate_User_inList).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Deactivate User')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------------Function Being Called -----------------------
	public void systemAdmin_Deactivate_Old_Users_Close_Directory() throws InterruptedException {
		// -----Deactivate super Testman -----
		this.click_SuperTestMan_Dropdown();
		Thread.sleep(2000);
		this.verify_Deactivate_User_inList();
		Thread.sleep(1000);
		this.click_Deactivate_User_inList();
		Thread.sleep(2000);
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(2000);
		this.verify_Profile_Deactivated_Message();
		this.clickSaveBtn();
		this.verify_CloseBtn_Visible();
		this.clickDirectoryCloseBtn();
		this.verifyWelcomeHeader();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.clickDirectoryMenu();
		this.verifyUserSearchField();
		// ----- Deativate Eli Testman ---------
		this.clickEliArrowBtn();
		Thread.sleep(2000);
		this.verify_Deactivate_User_inList();
		this.click_Deactivate_User_inList();
		Thread.sleep(2000);
		this.verifyContinueBtn();
		Thread.sleep(1000);
		this.clickContinueBtn();
		Thread.sleep(2000);
		this.verify_Profile_Deactivated_Message_2();
		this.clickSaveBtn();
		Thread.sleep(2000);
		this.verify_CloseBtn_Visible();
		this.clickDirectoryCloseBtn();
		// this.verifyWelcomeHeader();
		System.out.println("------- Completed --> systemAdmin_Deactivate_Old_Users_Close_Director -----------");
	}

	public void systemAdmin_Open_Settings_Open_ManageUsers() throws InterruptedException {
		this.verifyWelcomeHeader();
		driver.navigate().refresh();
		this.clickSettingsBtn();
		this.verify_Settings_Side_Menu_Bar();
		this.clickManageUsers();
		Thread.sleep(3000);
		this.verifyInactiveUsers();
		Thread.sleep(2000);
	}
	
	// --------------systemAdmin_Open_InactiveUsersTab_Delete_Old_Users()-------------------
	By deleteUser1 = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete User')]");
	By deleteUser2 = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete User')]");
	//By deleteUser1 = By.xpath("(//a[contains(text(),'Delete User')])[1]");
	// By deleteUser2 = By.xpath("(//a[contains(text(),'Delete User')])[2]");
	// By continueBtn3 = By.xpath("(//button[@class='btn commit
	// btn-danger'][contains(text(),'Continue')])[3]");
	By continueBtn3 = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");
	// By continueBtn4 = By.xpath("(//button[@class='btn commit
	// btn-danger'][contains(text(),'Continue')])[4]");

	public void verifyDeleteUser1Present() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteUser1)));
	}

	public void verifyDeleteUser2Present() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteUser2)));
	}

	public void clickDeleteUser1() throws InterruptedException {
		driver.findElement(deleteUser1).click();
	}

	public void clickDeleteUser2() throws InterruptedException {
		driver.findElement(deleteUser2).click();
	}

	public void clickContinueBtn3() {
		driver.findElement(continueBtn3).click();
	}

	public void clickContinueBtn4() {
		driver.findElement(continueBtn3).click();
	}

	// -----------Function Being Called ------------------------
	public void systemAdmin_Open_InactiveUsersTab_Delete_Old_Users() throws InterruptedException {
		this.clickInactiveUsers();
		this.clickInactiveUsers();
		Thread.sleep(3000);
		// -------Delete Super User -----------------
		this.click_SuperTestMan_Dropdown();
		this.verifyDeleteUser2Present();
		this.clickDeleteUser2();
		this.verifyFormInputField();
		this.form_Input_Field_SendKeys();
		this.clickContinueBtn3();
		this.verify_Sucessfully_Deleted_User_Message();
		this.clickCloseModal();
		this.verifyWelcomeHeader();
		driver.navigate().refresh();
		this.clickSettingsBtn();
		this.verify_Settings_Side_Menu_Bar();
		Thread.sleep(1000);
		this.clickManageUsers();
		this.verifyInactiveUsers();
		this.clickInactiveUsers();
		Thread.sleep(1000);
		// -------Delete Eli User -----------------
		this.clickEliArrowBtn();
		this.verifyDeleteUser1Present();
		this.clickDeleteUser1();
		this.verifyFormInputField();
		this.form_Input_Field_SendKeys();
		this.clickContinueBtn4();
		this.verify_Sucessfully_Deleted_User_Message();
		this.clickCloseModal();
		System.out.println("------- Completed --> systemAdmin_Open_InactiveUsersTab_Delete_Old_Users() -----------");
	}

	// ------------Function being called--------------------
	public void verifyAddUser() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addUserDropdown)));
	}

	public void systemAdmin_Create_Save_New_User() throws InterruptedException {
		// systemAdmin_Open_Settings_Open_ManageUsers();//---calling function agian ---
		this.verifyWelcomeHeader();
		driver.navigate().refresh();
		this.clickSettingsBtn();
		this.verify_Settings_Side_Menu_Bar();
		Thread.sleep(1500);
		this.clickManageUsers();
		Thread.sleep(3000);
		this.verifyAddUser();
		Thread.sleep(1500);
		// ---------------------------
		this.clickAddUser();
		Thread.sleep(2000);
		this.verifyAddOneUser();
		this.clickAddOneUser();
		Thread.sleep(2000);
		// ----create 1st old user ------------
		this.verify_NewUser_InputField();
		this.newUserFormFill();
		Thread.sleep(2000);
		this.verify_NewUser_CreatedMessage();
		Thread.sleep(2000);
		this.clickProfileCloseBtn();
		Thread.sleep(2000);
		this.clickCloseModal();
		System.out.println("------- Completed --> systemAdmin_Create_Save_New_User() -----------");
	}
	By workroomTab = By.xpath("//form[@id='profile-form']//a[contains(text(), 'Workrooms')]");
	By workroom_Select_Dropdown = By.xpath(
			"//div[@class='col-sm-6']//div[@class='btn-group bootstrap-select show-tick form-control chosen']//button[@class='btn dropdown-toggle btn-default']");
	// By workroom_Select_Dropdown=
	// By.xpath("//div[@class='col-sm-6']//div[@class='btn-group bootstrap-select
	// show-tick form-control chosen']//span[@class='bs-caret']");
	By autoBE = By.xpath("//div[@id='workrooms-tab']//li[3]//a[1]//span[contains(text(),'AutoBE')]");
	By saveUsers = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");

	public void verify_workroom_Select_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Select_Dropdown)));
	}

	public void clickWorkroomTab() {
		WebElement workroomtab = driver.findElement(By.xpath("//form[@id='profile-form']//a[contains(text(), 'Workrooms')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", workroomtab);
		// driver.findElement(workroomTab).click();
	}

	public void click_Workroom_Select_Dropdown() {
		driver.findElement(workroom_Select_Dropdown).click();
	}

	public void click_AutoBE() {
		driver.findElement(autoBE).click();
	}

	public void click_SaveUsers() {
		driver.findElement(saveUsers).click();
	}
	
	// -----------------------systemAdmin_Open_WorkroomTab_Add_Workroom_2_User--------------
	By editProfile = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");
	By closeProfileBtn = By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]");

	public void verify_WorkroomTab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomTab)));
	}

	public void click_Edit_Profile() {
		driver.findElement(editProfile).click();
	}

	// -------Function Being called -----------
	public void systemAdmin_Open_WorkroomTab_Add_Workroom_2_User() throws InterruptedException {
		driver.navigate().refresh();// ----refresh page ------
		driver.navigate().refresh();// ----refresh page ------
		this.verifyWelcomeHeader();
		this.clickDirectoryMenu();
		this.verifyUserSearchField();
		this.click_SuperTestMan_Dropdown();
		this.verify_Deactivate_User_inList();
		this.click_Edit_Profile();
		Thread.sleep(3000);
		// this.verify_WorkroomTab();
		this.clickWorkroomTab();
		Thread.sleep(1000);
		this.verify_workroom_Select_Dropdown();
		this.click_Workroom_Select_Dropdown();
		this.click_AutoBE();
		this.click_SaveUsers();
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(3000);
		clickProfileCloseBtn();
		Thread.sleep(2000);
		this.clickCloseModal();
		System.out.println("------- Completed --> systemAdmin_Open_WorkroomTab_Add_Workroom_2_User() -----------");
	}

	public void systemAdmin_Search_For_User_Open_Profile() throws InterruptedException {
		this.verifySettings();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("------- page refreshed -----------");
		this.clickDirectoryMenu();
		this.verifyUserSearchField();
		this.clickUserSearchAndSendKeys();
		// this.clickSaveBtn();
		// this.clickProfileCloseBtn();
		this.verify_Old_User1_Created();
		this.click_SuperTestMan_Dropdown();
		this.verify_Deactivate_User_inList();
		this.click_Edit_Profile();
		System.out.println("------- Completed --> systemAdmin_Search_For_User_Open_Profile() -----------");
	}
	
	// -----------------------systemAdmin_Edit_Save_User_Profile()--------------
	By settingsTab = By.xpath("//a[contains(text(),'Settings')]");
	By contactTab = By.xpath("//li[@class='active']//a[contains(text(),'Contact')]");

	public void verify_SettingsTab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settingsTab)));
	}

	public void click_SettingsTab() {
		WebElement settings = driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", settings);
		// driver.findElement(settingsTab).click();
	}

	public void click_ContactTab() {
		WebElement contact = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Contact')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", contact);
	}

	public void updateUserSearchAndSendKeys() throws InterruptedException {
		// -------upadted firstname field
		driver.findElement(newUser_Input_FirstName).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(newUser_Input_FirstName).clear();
		driver.findElement(newUser_Input_FirstName).sendKeys(userFirstNameUpdated);
		// -------upadted lastname field
		driver.findElement(newUser_Input_LastName).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(newUser_Input_LastName).clear();
		driver.findElement(newUser_Input_LastName).sendKeys(userLastNameUpdated);
		// -------upadted login field
		driver.findElement(newUser_Input_LogIn).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(newUser_Input_LogIn).clear();
		driver.findElement(newUser_Input_LogIn).sendKeys(userLoginUpdated);
		driver.findElement(newUser_Password).sendKeys(userPassword);
		driver.findElement(newUser_PasswordConfirm).sendKeys(userPassword);
	}

	public void update_Email_SendKeys() throws InterruptedException {
		// -------upadted company email field-------
		WebElement companyemail = driver.findElement(By.xpath("//input[@id='user_companyemail']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", companyemail);
		driver.findElement(newUser_CompanyEmail).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(newUser_CompanyEmail).clear();
		driver.findElement(newUser_CompanyEmail).sendKeys(companyEmailUpdated);
		WebElement SaveBtn = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(2000);
		driver.findElement(newUser_SaveBtn).click();
	}

	public void verify_EliTestman_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(elitestman)));
	}

	// -------Function Being called -----------
	public void systemAdmin_Edit_Save_User_Profile() throws InterruptedException {
		this.verify_SettingsTab();
		this.click_SettingsTab();
		this.verify_NewUser_InputField();
		this.updateUserSearchAndSendKeys();
		this.click_ContactTab();
		Thread.sleep(2000);
		this.update_Email_SendKeys();
		Thread.sleep(2000);
		this.verify_Profile_Saved_Message_2();
		this.clickProfileCloseBtn();
		// Thread.sleep(3000);
		// driver.navigate().refresh();
		// driver.navigate().refresh();
		// Thread.sleep(3000);
		//
		// this.verify_EliTestman_Visible();
		System.out.println("------- Completed --> systemAdmin_Edit_Save_User_Profile() -----------");
	}

	public void click_SendKeys_Updated_User_Search() throws InterruptedException {
		driver.findElement(userSearchField).click();
		driver.findElement(userSearchField).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(userSearchField).sendKeys(userFirstNameUpdated + " " + userLastNameUpdated);
		Thread.sleep(1000);
		driver.findElement(userSearchField).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	// -------Function Being called -----------
	public void systemAdmin_Close_Profile_Form_Searh_4_Updated_User() throws InterruptedException {
		this.clickDirectoryCloseBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verifySettings();
		this.clickDirectoryMenu();
		this.verifyUserSearchField();
		this.click_SendKeys_Updated_User_Search();
		Thread.sleep(3000);
		this.verify_Old_User2_Created();
		System.out.println("------- Completed --> systemAdmin_Close_Profile_Form_Searh_4_Updated_User() -----------");
	}

	// -------Function Being called -----------
	public void systemAdmin_Deactivate_Updated_User() throws InterruptedException {
		// ----- Deativate Eli Testman ---------
		this.clickEliArrowBtn();
		this.verify_Deactivate_User_inList();
		Thread.sleep(2000);
		this.click_Deactivate_User_inList();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(2000);
		System.out.println("------- Completed --> systemAdmin_Deactivate_Updated_User() -----------");
	}

	public void systemAdmin_Close_Access_Permissions_and_Directory_Form() throws InterruptedException {
		this.verify_Profile_Deactivated_Message_2();
		this.clickSaveBtn();
		this.verify_CloseBtn_Visible();
		this.clickDirectoryCloseBtn();
		System.out.println("------- Completed --> systemAdmin_Close_Access_Permissions_and_Directory_Form() -----------");
	}

	// -------Function Being called -----------
	public void systemAdmin_Open_Settings_Manage_Users_Then_Inactive_Users_Tab() throws InterruptedException {
		driver.navigate().refresh();
		driver.navigate().refresh();
		this.verifySettings();
		this.clickSettingsBtn();
		this.verify_Settings_Side_Menu_Bar();
		Thread.sleep(2000);
		this.clickManageUsers();
		this.verifyInactiveUsers();
		this.clickInactiveUsers();
		System.out.println("------- Completed --> systemAdmin_Open_Settings_Manage_Users_Then_Inactive_Users_Tab() -----------");
	}

	// -------Function Being called -----------
	public void systemAdmin_Can_Delete_Updated_User() throws InterruptedException {
		// ----- Delete Eli Testman ---------
		// driver.navigate().refresh();// this prevents stale element
		// driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_EliTestman_Visible();
		this.clickEliArrowBtn();
		this.verifyDeleteUser1Present();
		this.clickDeleteUser1();
		this.verifyFormInputField();
		this.form_Input_Field_SendKeys();
		this.clickContinueBtn4();
		this.verify_Sucessfully_Deleted_User_Message();
		this.clickCloseModal();
		System.out.println("------- Completed --> systemAdmin_Can_Delete_Updated_User() -----------");
	}

	public void verify_UsernameEli_Not_Present() throws InterruptedException {
		String eli = "//a[contains(text(),'Eli Testman')]";
		Assert.assertTrue(driver.findElements(By.xpath(eli)).size() < 1);
	}

	// -------Function Being called -----------
	public void systemAdmin_Open_Directory_Search_Updated_User_NOT_To_Be_Present() throws InterruptedException {
		this.verifySettings();
		this.clickDirectoryMenu();
		Thread.sleep(3000);
		// this.verifyUserSearchField();
		this.click_SendKeys_Updated_User_Search();
		Thread.sleep(1000);
		this.verify_Username1_Not_Created();
		System.out.println("------- Completed --> systemAdmin_Open_Directory_Search_Updated_User_NOT_To_Be_Present -----------");
	}
}
