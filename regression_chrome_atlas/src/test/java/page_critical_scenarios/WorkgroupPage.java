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
import page_common_functions.AtlasNavBar;

public class WorkgroupPage {
	
	WebDriver driver;
	By settings = By.xpath("//span[contains(text(),'Settings')]");
	By workroom_Groups = By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]");

	public WorkgroupPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// ----------- POM Page Object model -----------------------------
	// ---------------user_Opens_Settings_Opens_Workroom_And_Group_Settings--------------
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
		// driver.findElement(workroom_Groups).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// -------Function Being called -----------
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		this.verify_Settings();
		this.click_SettingsBtn();
		this.verify_Manage_Workrooms_Groups();
		this.click_Manage_Workroom_Groups();
		System.out.println("------- Completed --> user_Opens_Settings_Opens_Workroom_And_Group_Settings() -----------");
	}
	
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_A() throws InterruptedException {
		//this.verify_Settings();
		//this.click_SettingsBtn();
		//this.verify_Manage_Workrooms_Groups();
		//this.click_Manage_Workroom_Groups();
		//Thread.sleep(1000);
		
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.admin_Opens_Site_Settings_Workrooms_And_Groups();
		this.verify_Active_WorkGroups_Tab();
		Thread.sleep(1000);
		this.click_Active_WorkGroups_Tab();
		Thread.sleep(1000);
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
	String group = "NewGroup";

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
		// driver.findElement(addNewBtn).click();
		WebElement element = driver.findElement(By.xpath("//button[@id='add-new']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_New_Group() {
		// driver.findElement(newGroup).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'New Group')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Group_Name_Field_SendKeys() {
		// driver.findElement(add_group_Name_Field).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='committeegroup_name']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.findElement(add_group_Name_Field).sendKeys(workGroupName);
	}

	public void click_SaveBtn() {
		// driver.findElement(saveBtn).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog']//button[@id='formsSubmit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Active_WorkGroups_Tab() {
		// driver.findElement(active_WorkGroups_Tab).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Active Workgroups')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// ----------- POM Page Object model -----------------------------
	public void user_Can_Create_New_Group() throws InterruptedException {
		this.verify_AddNewBtn();
		Thread.sleep(1500);
		this.click_Add_NewBtn();
		Thread.sleep(1500);
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
	
	public void user_Can_Create_New_Group_A() throws InterruptedException {
		this.verify_AddNewBtn();
		Thread.sleep(1000);
		this.click_Add_NewBtn();
		Thread.sleep(1000);
		this.verify_New_Group_NewBtn();
		Thread.sleep(1000);
		this.click_New_Group();
		this.verify_Add_Group_Name_Field();
		this.click_Group_Name_Field_SendKeys();
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Active_WorkGroups_Tab();
		Thread.sleep(1000);
		this.click_Active_WorkGroups_Tab();
		Thread.sleep(1000);
		this.verify_New_Workroom_Created();
		System.out.println("------- Completed --> user_Can_Create_New_Group() -----------");
	}
	
	public void navigate_To_Workgroups_Tab() throws InterruptedException {
		this.verify_AddNewBtn();
		Thread.sleep(1500);
		this.click_Active_WorkGroups_Tab();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Create_New_Group() -----------");
	}
	
	// ------------------User_Can_Delete_New_Group()-----------------------------------
	By group_Dropdown_Arrow = By.xpath("//div[@class='btn-group small pull-right']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By deleteBtn = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Delete')]");
	By editBtn = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Edit')]");
	By delete_group_field = By.xpath("//div[@class='modal-body']//input[@class='form-control']");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_DeleteBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteBtn)));
	}
	
	public void verify_EditBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(editBtn)));
	}

	public void verify_Delete_Group_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_group_field)));
	}

	public void click_Group_Dropdown_Arrow() {
		// driver.findElement(group_Dropdown_Arrow).click();
		WebElement element = driver.findElement(By.xpath("//a[@class='collapsed group-collapse placeholder'][contains(text(),'NewBEWorkGroup')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Group_Dropdown_Arrow_A() {
		// driver.findElement(group_Dropdown_Arrow).click();
		WebElement element = driver.findElement(By.xpath("//a[@class='collapsed group-collapse placeholder'][contains(text(),'NewGroup')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	
	public void click_EditBtn() {
		// driver.findElement(deleteBtn).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Edit')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_DeleteBtn() {
		// driver.findElement(deleteBtn).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Delete')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Delete_Group_Field_SendKeys() throws InterruptedException {
		// driver.findElement(delete_group_field).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-body']//input[@class='form-control']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		driver.findElement(delete_group_field).sendKeys(workGroupName);
	}
	
	public void edit_Group_Field_SendKeys() throws InterruptedException {
		driver.findElement(delete_group_field).clear();
		driver.findElement(delete_group_field).sendKeys(group);
	}

	public void click_ContinueBtn() {
		// driver.findElement(continueBtn).click();
		//WebElement element = driver.findElement(By.xpath("//button[@class='btn commit btn-danger']"));
		WebElement element = driver.findElement(By.xpath(" //div[starts-with (@id,'confirm-modal-')]//following::button[@class='btn commit btn-danger']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// ----------- POM Page Object model -----------------------------
	public void user_Can_Delete_New_Group() throws InterruptedException {
		this.click_Group_Dropdown_Arrow();
		Thread.sleep(2000);
		this.verify_DeleteBtn();
		this.click_DeleteBtn();
		Thread.sleep(2000);
		this.verify_Delete_Group_Field();
		Thread.sleep(2000);
		this.click_Delete_Group_Field_SendKeys();
		Thread.sleep(2000);
		this.click_ContinueBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_New_Group() -----------");
	}
	
	public void user_Can_Delete_New_Group_A() throws InterruptedException {
		this.click_Group_Dropdown_Arrow_A();
		Thread.sleep(2000);
		this.verify_DeleteBtn();
		this.click_DeleteBtn();
		Thread.sleep(2000);
		this.verify_Delete_Group_Field();
		Thread.sleep(1000);
		this.edit_Group_Field_SendKeys();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_New_Group() -----------");
	}
	
	public void user_Can_Edit_New_Group_A() throws InterruptedException {
		this.click_Group_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_EditBtn();
		this.click_EditBtn();
		Thread.sleep(1000);
		this.verify_Delete_Group_Field();
		this.edit_Group_Field_SendKeys();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Edit_New_Group_A() -----------");
	}
	
	// -----------------verify_Group_Deleted-----------------------
	By active_WorkGroups_Tab_2 = By.xpath("//a[contains(text(),'Active Workgroups')]");
	By workgroup_NOT_Present = By.xpath("//a[@class='collapsed group-collapse placeholder'][contains(text(),'NewBEWorkGroup')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By group_NOT_Present_A = By.xpath("//a[@class='collapsed group-collapse placeholder'][contains(text(),'NewBEWorkGroup')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By close_Settings = By.xpath("//a[@id='settingsModalClose']");

	public void verify_Active_WorkGroups_Tab_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(active_WorkGroups_Tab_2)));
	}

	public void verify_Workgroup_NOT_Present_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(workgroup_NOT_Present)));
	}
	
	public void verify_Group_NOT_Present_A() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(group_NOT_Present_A)));
	}

	public void verify_Close_Settings_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(close_Settings)));
	}

	public void click_Active_WorkGroups_Tab_2() {
		driver.findElement(active_WorkGroups_Tab_2).click();
	}

	public void click_Close_Settings() {
		WebElement element = driver.findElement(By.xpath("//a[@id='settingsModalClose']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// driver.findElement(close_Settings).click();
	}

	// ----------- POM Page Object model -----------------------------
	public void verify_Group_Deleted() throws InterruptedException {
		this.verify_Close_Settings_Btn();
		this.click_Close_Settings();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_Settings();
		this.click_SettingsBtn();
		this.verify_Manage_Workrooms_Groups();
		this.click_Manage_Workroom_Groups();
		Thread.sleep(1000);
		this.verify_Active_WorkGroups_Tab_2();
		Thread.sleep(2500);
		this.click_Active_WorkGroups_Tab_2();
		Thread.sleep(2500);
		this.verify_Workgroup_NOT_Present_Message();
		System.out.println("------- Completed --> verify_Group_Deleted() -----------");
	}
	
	public void verify_Group_Deleted_A() throws InterruptedException {
		//this.verify_Settings();
		//this.click_SettingsBtn();
		//Thread.sleep(1000);
		//this.verify_Manage_Workrooms_Groups();
		//this.click_Manage_Workroom_Groups();
		//Thread.sleep(1000);
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.admin_Opens_Site_Settings_Workrooms_And_Groups();
		this.verify_Active_WorkGroups_Tab_2();
		Thread.sleep(1500);
		this.click_Active_WorkGroups_Tab_2();
		Thread.sleep(1500);
		this.verify_Group_NOT_Present_A();
		System.out.println("------- Completed --> verify_Group_Deleted() -----------");
	}
}
