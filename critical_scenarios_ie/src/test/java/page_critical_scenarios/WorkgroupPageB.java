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

public class WorkgroupPageB {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;
	By settings = By.xpath("//span[contains(text(),'Settings')]");
	By workroom_Groups = By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]");

	public WorkgroupPageB(WebDriver driver) {
		this.driver = driver;
	}
	
	// -------------user_Opens_Settings_Opens_Workroom_And_Group_Settings---------
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

	// -------Function Being called -----------
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		this.verify_Settings();
		this.click_SettingsBtn();
		this.verify_Manage_Workrooms_Groups();
		this.click_Manage_Workroom_Groups();
		System.out.println("------- Completed --> user_Opens_Settings_Opens_Workroom_And_Group_Settings() -----------");
	}
	
	// --------------------user_Can_Create_New_Group--------------------------------
	By addNewBtn = By.xpath("//button[@id='add-new']");
	By newGroup = By.xpath("//a[contains(text(),'New Group')]");
	By add_group_Name_Field = By.xpath("//input[@id='committeegroup_name']");
	By saveBtn = By.xpath("//div[@class='modal-dialog']//button[@id='formsSubmit']");
	By active_WorkGroups_Tab = By.xpath("//a[contains(text(),'Active Workgroups')]");
	By new_BE_WorkGroup = By.xpath("//a[@class='collapsed group-collapse placeholder'][contains(text(),'NewBEWorkGroup')]");
	String workGroupName = "NewBEWorkGroup";

	public void verify_AddNewBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addNewBtn)));
	}

	public void verify_New_Group_NewBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newGroup)));
	}

	public void verify_Add_Group_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_group_Name_Field)));
	}

	public void verify_Active_WorkGroups_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(active_WorkGroups_Tab)));
	}

	public void verify_New_Workroom_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_BE_WorkGroup)));
	}

	public void click_Add_NewBtn() {
		driver.findElement(addNewBtn).click();
	}

	public void click_New_Group() {
		driver.findElement(newGroup).click();
	}

	public void click_Group_Name_Field_SendKeys() {
		driver.findElement(add_group_Name_Field).click();
		driver.findElement(add_group_Name_Field).sendKeys(workGroupName);
	}

	public void click_SaveBtn() {
		driver.findElement(saveBtn).click();
	}

	public void click_Active_WorkGroups_Tab() {
		driver.findElement(active_WorkGroups_Tab).click();
	}

	// ----------------Function Being Called--------------------------
	public void user_Can_Create_New_Group() throws InterruptedException {
		this.verify_AddNewBtn();
		Thread.sleep(1000);
		this.click_Add_NewBtn();
		this.verify_New_Group_NewBtn();
		Thread.sleep(1000);
		this.click_New_Group();
		this.verify_Add_Group_Name_Field();
		this.click_Group_Name_Field_SendKeys();
		this.click_SaveBtn();
		this.verify_Active_WorkGroups_Tab();
		Thread.sleep(2000);
		this.click_Active_WorkGroups_Tab();
		Thread.sleep(1000);
		this.verify_New_Workroom_Created();
		System.out.println("------- Completed --> user_Can_Create_New_Group() -----------");
	}
	
	// ------------------User_Can_Delete_New_Group()-----------------------------------
	By group_Dropdown_Arrow = By.xpath("//a[@class='collapsed group-collapse placeholder'][contains(text(),'NewBEWorkGroup')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By deleteBtn = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Delete')]");
	By delete_group_field = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_DeleteBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteBtn)));
	}

	public void verify_Delete_Group_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_group_field)));
	}

	public void click_Group_Dropdown_Arrow() {
		driver.findElement(group_Dropdown_Arrow).click();
	}

	public void click_DeleteBtn() {
		driver.findElement(deleteBtn).click();
	}

	public void click_Delete_Group_Field_SendKeys() {
		driver.findElement(delete_group_field).click();
		driver.findElement(delete_group_field).sendKeys(workGroupName);
	}

	public void click_ContinueBtn() {
		driver.findElement(continueBtn).click();
	}

	// ----------------Function Being Called--------------------------
	public void user_Can_Delete_New_Group() throws InterruptedException {
		this.click_Group_Dropdown_Arrow();
		this.verify_DeleteBtn();
		this.click_DeleteBtn();
		this.verify_Delete_Group_Field();
		Thread.sleep(1000);
		this.click_Delete_Group_Field_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		System.out.println("------- Completed --> user_Can_Delete_New_Group() -----------");
	}
	
	// ------------------------verify_Group_Deleted-----------------------------------
	By active_Workgroups_Tab = By.xpath("//a[contains(text(),'Active Workgroups')]");
	By no_Active_Workgroups_Message = By.xpath("//span[contains(text(),'There are currently no active Workgroups.')]");

	public void verify_Active_Workgroups_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(active_Workgroups_Tab)));
	}

	public void verify_No_Active_Workgroups_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(no_Active_Workgroups_Message)));
	}

	public void click_Active_Workgroups_Tab() {
		driver.findElement(active_Workgroups_Tab).click();
	}

	public void verify_Group_Not_Present() throws InterruptedException {
		String group = "//a[@class='collapsed group-collapse placeholder'][contains(text(),'NewBEWorkGroup')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(group)).size() < 1);
	}

	public void verify_Group_Deleted() throws InterruptedException {
		Thread.sleep(2000);
		this.verify_Active_Workgroups_Tab();
		Thread.sleep(2000);
		this.click_Active_Workgroups_Tab();
		this.click_Active_Workgroups_Tab();
		Thread.sleep(3000);
		this.verify_Group_Not_Present();
		System.out.println("------- Completed --> verify_Group_Deleted() -----------");
	}
	
	// --------------------create_workgroup_attch_workroom-------------------------------------
	By active_Workrooms = By.xpath("//a[contains(text(),'Active Workrooms')]");
	By dc_Workroom_Dropdown = By.xpath("(//a[@class='collapsed committee-collapse placeholder'][contains(text(),'DC')]/following::div[@class='btn-group small'])[1]");
	By drp_settings = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Settings')]");
	By workroom_Group_dropdown = By.xpath("//select[@id='committee_group_id']");
	By newBEWorkGroup = By.xpath("//option[contains(text(),'NewBEWorkGroup')]");

	public void verify_DC_Workroom_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(dc_Workroom_Dropdown)));
	}

	public void verify_Drpdown_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(drp_settings)));
	}

	public void verify_Workroom_Group_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Group_dropdown)));
	}

	public void click_Active_Workrooms_Tab() {
		driver.findElement(active_Workrooms).click();
	}

	public void click_DC_Workroom_Dropdown() {
		driver.findElement(dc_Workroom_Dropdown).click();
	}

	public void click_Drp_Settings() {
		driver.findElement(drp_settings).click();
	}

	public void click_workroom_Group_Dropdown() {
		driver.findElement(workroom_Group_dropdown).click();
	}

	public void click_NewBEWorkGroup() {
		driver.findElement(newBEWorkGroup).click();
	}

	public void user_attach_workgroup_to_workroom() throws InterruptedException {
		this.click_Active_Workrooms_Tab();
		Thread.sleep(1500);
		this.verify_DC_Workroom_Dropdown();
		this.click_DC_Workroom_Dropdown();
		this.verify_Drpdown_Settings();
		this.click_Drp_Settings();
		this.verify_Workroom_Group_Dropdown();
		this.click_workroom_Group_Dropdown();
		Thread.sleep(1500);
		this.click_NewBEWorkGroup();
		Thread.sleep(1000);
		this.click_SaveBtn();
		System.out.println("------- Completed --> user_attach_workgroup_to_workroom() -----------");
	}
	
	// ------------------------------verify_Workroom_Attached()--------------------------------------
	By active_Workgroups = By.xpath("//a[contains(text(),'Active Workgroups')]");
	By newBEWorkgroup = By.xpath("//a[@class='collapsed group-collapse placeholder'][contains(text(),'NewBEWorkGroup')]");
	By attached_DC_Workroom = By.xpath("//a[ starts-with (@class,'collapsed committee-')][contains(text(),'DC')]");

	public void verify_NewBEWorkGroup() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newBEWorkgroup)));
	}

	public void verify_Attached_DC_Workroom() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attached_DC_Workroom)));
	}

	public void click_Active_Workgroups() {
		driver.findElement(active_Workgroups).click();
	}

	public void click_newBEWorkgroup() {
		driver.findElement(newBEWorkgroup).click();
	}

	public void verify_Workroom_Attached() throws InterruptedException {
		Thread.sleep(3000);
		this.click_Active_Workgroups();
		Thread.sleep(1000);
		this.verify_NewBEWorkGroup();
		this.click_newBEWorkgroup();
		Thread.sleep(3000);
		this.verify_Attached_DC_Workroom();
		System.out.println("------- Completed --> verify_Workroom_Attached() -----------");
	}
	
	// ------------------------------deactivate_Delete_Workroom()--------------------------------------
	By nested_DC_dropdown = By.xpath("//a[ starts-with (@class,'collapsed committee-')][contains(text(),'DC')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By null_Dropdown_Option = By.xpath("//div[@id='formsModal']//option[1]");

	public void click_Nested_DC_dropdown() {
		driver.findElement(nested_DC_dropdown).click();
	}


	public void click_Null_Dropdown_Option() {
		driver.findElement(null_Dropdown_Option).click();
	}
	
	// --------------Function Being Called ---------------------------------
	public void verify_Group_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(group_Dropdown_Arrow)));
	}

	public void verify_Workroom_Group_dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Group_dropdown)));
	}

	// --------------Function Being Called ---------------------------------
	public void deactivate_Workgroup() throws InterruptedException {
		this.click_Nested_DC_dropdown();
		this.verify_Drpdown_Settings();
		this.click_Drp_Settings();
		Thread.sleep(1000);
		this.verify_Workroom_Group_dropdown();
		this.click_workroom_Group_Dropdown();
		this.click_Null_Dropdown_Option();
		this.click_SaveBtn();
		Thread.sleep(3000);
		System.out.println("------- Completed --> deactivate_Workgroup()-----------");
	}
	
	// --------------delete_Workgroup()---------------------------------
	By group_WorkroomField = By.xpath("//div[@class='modal-dialog']//input[@class='form-control']");

	public void verify_Delete_Workgroup_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_group_field)));
	}

	public void click_Delete_WorkGroup_Field_SendKeys() {
		driver.findElement(group_WorkroomField).click();
		driver.findElement(group_WorkroomField).sendKeys(workGroupName);
	}

	// --------------Function Being Called ---------------------------------
	public void delete_Workgroup() throws InterruptedException {
		this.click_Active_WorkGroups_Tab();
		Thread.sleep(1000);
		this.verify_Group_Dropdown_Arrow();
		this.click_Group_Dropdown_Arrow();
		this.verify_DeleteBtn();
		this.click_DeleteBtn();
		this.verify_Delete_Workgroup_Field();
		Thread.sleep(1000);
		this.click_Delete_WorkGroup_Field_SendKeys();
		this.click_ContinueBtn();
		Thread.sleep(3000);
		System.out.println("------- Completed --> delete_Workgroup()-----------");
	}
}
