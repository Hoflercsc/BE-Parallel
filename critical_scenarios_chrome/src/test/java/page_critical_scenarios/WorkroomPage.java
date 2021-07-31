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

public class WorkroomPage {
	WebDriver driver;
	By settings = By.xpath("//span[contains(text(),'Settings')]");
	By workroom_Groups = By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]");

	public WorkroomPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// ----------- POM Page Object model -----------------------------
	// ------------user_Opens_Settings_Opens_Workroom_And_Group_Settings--------------
	public void verify_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings)));
	}

	public void verify_Manage_Workrooms_Groups() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Groups)));
	}

	public void verify_Add_NewBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addNewBtn)));
	}

	public void click_SettingsBtn() {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(settings).click();
	}

	public void click_Manage_Workroom_Groups() {
		driver.findElement(workroom_Groups).click();
	}

	// ----------- POM Page Object model -----------------------------
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		this.verify_Settings();
		this.click_SettingsBtn();
		Thread.sleep(1000);
		this.verify_Manage_Workrooms_Groups();
		this.click_Manage_Workroom_Groups();
		System.out.println("------- Completed --> user_Opens_Settings_Opens_Workroom_And_Group_Settings() -----------");
	}
	
	// --------------------user_Can_Create_New_Workroom--------------------------------
	By addNewBtn = By.xpath("//button[@id='add-new']");
	By newWorkroom = By.xpath("//a[contains(text(),'New Workroom')]");
	By workroom_Name_Field = By.xpath("//input[@id='committee_name']");
	By saveBtn = By.xpath("//div[@class='modal-dialog']//button[@id='formsSubmit']");
	// By active_WorkRoom_Tab = By.xpath("//a[contains(text(),'Active Workrooms
	// (3)')]");
	By active_WorkRoom_Tab = By.xpath("//a[contains(text(),'Active Workrooms')]");
	By new_BE_Workroom = By.xpath("//a[contains(text(),'JH')]");
	String workRoomName = "JH";

	public void verify_AddNewBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addNewBtn)));
	}

	public void verify_New_WorkroomBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newWorkroom)));
	}

	public void verify_Workroom_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Name_Field)));
	}

	public void verify_Active_WorkRoom_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(active_WorkRoom_Tab)));
	}

	public void verify_New_Workroom_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_BE_Workroom)));
	}

	public void click_Add_NewBtn() {
		driver.findElement(addNewBtn).click();
	}

	public void click_New_Workroom() {
		driver.findElement(newWorkroom).click();
	}

	public void click_Workroom_Name_Field_SendKeys() {
		driver.findElement(workroom_Name_Field).click();
		driver.findElement(workroom_Name_Field).sendKeys(workRoomName);
	}

	public void click_SaveBtn() {
		driver.findElement(saveBtn).click();
	}

	public void click_Active_WorkRoom_Tab() {
		driver.findElement(active_WorkRoom_Tab).click();
	}

	// ----------- POM Page Object model -----------------------------
	public void user_Can_Create_New_Workroom() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_AddNewBtn();
		this.click_Add_NewBtn();
		Thread.sleep(1000);
		this.verify_New_WorkroomBtn();
		this.click_New_Workroom();
		Thread.sleep(1000);
		this.verify_Workroom_Name_Field();
		this.click_Workroom_Name_Field_SendKeys();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Active_WorkRoom_Tab();
		Thread.sleep(1000);
		this.click_Active_WorkRoom_Tab();
		Thread.sleep(1000);
		this.verify_New_Workroom_Created();
		System.out.println("------- Completed --> user_Can_Create_New_Workroom() -----------");
	}
	
	// ------------------User_Can_Delete_New_Workroom()-----------------------------------
	By workroom_Dropdown_Arrow = By.xpath("(//a[@class='collapsed committee-collapse placeholder'][contains(text(),'JH')]/following::div[@class='btn-group small'])[1]");
	By settingsBtn = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Settings')]");
	By deactivate_CheckBox = By.xpath("//input[@id='committee_disabled']");

	public void verify_Settings_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settingsBtn)));
	}

	public void click_Workroom_Dropdown_Arrow() {
		driver.findElement(workroom_Dropdown_Arrow).click();
	}

	public void click_Workroom_Settings_Btn() {
		driver.findElement(settingsBtn).click();
	}

	public void click_Deactivate_CheckBox() {
		driver.findElement(deactivate_CheckBox).click();
	}

	// ----------- POM Page Object model -----------------------------
	public void user_Can_Deactivate_Workroom() throws InterruptedException {
		Thread.sleep(1000);
		this.click_Workroom_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Settings_Btn();
		this.click_Workroom_Settings_Btn();
		Thread.sleep(1000);
		this.verify_Workroom_Name_Field();
		this.click_Deactivate_CheckBox();
		Thread.sleep(1000);
		this.click_SaveBtn();
		System.out.println("------- Completed --> user_Can_Deactivate_Workroom() -----------");
	}
	
	// -----------------user_Can_Delete_Workroom--------------------------
	By deactivated_Workrooms_Tab = By.xpath("//a[contains(text(),'Deactivated Workrooms')]");
	By deactivated_Workrooms_Dropdown_Arrow = By.xpath("//a[@class='collapsed deactive-committee-collapse placeholder'][contains(text(),'JH')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By deleteBtn = By.xpath("//a[contains(text(),'Delete')]");
	By form_Input_Field = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_Deactivated_Workrooms_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivated_Workrooms_Tab)));
	}

	public void verify_Workroom_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivated_Workrooms_Dropdown_Arrow)));
	}
	
	public void verify_Continue_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}
	
	public void verify_Workroom_Name_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(form_Input_Field)));
	}

	public void click_Deactivate_Workroom_Tab() {
		// driver.findElement(deactivated_Workrooms_Tab).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Deactivated Workrooms')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Deactivate_Workroom_Dropdown_Arrow() {
		// driver.findElement(deactivated_Workrooms_Dropdown_Arrow).click();
		WebElement element = driver.findElement(By.xpath("//a[@class='collapsed deactive-committee-collapse placeholder'][contains(text(),'JH')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_DeleteBtn() {
		// driver.findElement(deleteBtn).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Form_Input_Field_SendKeys() throws InterruptedException {
		
		driver.findElement(form_Input_Field).click();
		driver.findElement(form_Input_Field).sendKeys("JH");
		Thread.sleep(500);
	}

	public void click_ContinueBtn() {
		// driver.findElement(continueBtn).click();
		WebElement element = driver.findElement(By.xpath("//button[@class='btn commit btn-danger']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// -------------Function Being Called-----------------------
	public void user_Can_Delete_Workroom() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Deactivated_Workrooms_Tab();
		this.click_Deactivate_Workroom_Tab();
		Thread.sleep(1500);
		this.verify_Workroom_Dropdown_Arrow();
		this.click_Deactivate_Workroom_Dropdown_Arrow();
		Thread.sleep(1500);
		this.verify_Settings_Btn();
		Thread.sleep(1500);
		this.click_DeleteBtn();
		Thread.sleep(1500);
		this.verify_Workroom_Name_Input_Field();
		this.click_Form_Input_Field_SendKeys();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		System.out.println("------- Completed --> user_Can_Delete_Workroom() -----------");
	}
	
	// -------------Function Being Called-----------------------
	By deactivated_Workroom_Tab_2 = By.xpath("//a[contains(text(),'Deactivated Workrooms')]");
	By close_Settings = By.xpath("//a[@id='settingsModalClose']");

	public void verify_Deactivated_Workroom_Tab_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivated_Workroom_Tab_2)));
	}

	public void verify_Workroom_NOT_Present_Message() throws InterruptedException {
		String element = "//a[@class='collapsed deactive-committee-collapse placeholder']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}

	public void click_Deactivated_Workroom_Tab_2() {
		// driver.findElement(deactivated_Workroom_Tab_2).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Deactivated Workrooms')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// -------------Function Being Called-----------------------
	public void verify_Workroom_Deleted() throws InterruptedException {
		this.verify_Deactivated_Workroom_Tab_2();
		Thread.sleep(2000);
		this.click_Deactivated_Workroom_Tab_2();
		Thread.sleep(2000);
		this.verify_Workroom_NOT_Present_Message();
		System.out.println("------- Completed --> verify_Workroom_Deleted() -----------");
	}
}
