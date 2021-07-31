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
	By custom_Fields = By.xpath("//a[contains(text(),'Custom Fields')]");


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
	
	public void verify_Custom_Fields() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(custom_Fields)));
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
	
	public void click_Custom_Fields() {
		driver.findElement(custom_Fields).click();
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
	
	// ----------- POM Page Object model -----------------------------
	public void user_Opens_Settings_Opens_Custom_Fields() throws InterruptedException {
		this.verify_Settings();
		this.click_SettingsBtn();
		Thread.sleep(1000);
		this.verify_Custom_Fields();
		this.click_Custom_Fields();
		System.out.println("------- Completed --> user_Opens_Settings_Opens_Custom_Fields() -----------");
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
	By workroom_Dropdown_Arrow_2 = By.xpath("(//a[@class='collapsed committee-collapse placeholder'][contains(text(),'DC')]/following::div[@class='btn-group small'])[1]");
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
	
	public void click_Workroom_Dropdown_Arrow_2() {
		driver.findElement(workroom_Dropdown_Arrow_2).click();
	}

	public void click_Workroom_Settings_Btn() {
		driver.findElement(settingsBtn).click();
	}

	public void click_Deactivate_CheckBox() {
		driver.findElement(deactivate_CheckBox).click();
	}
	
	public void enable_View_Only_Check_Box() {
		String string = "//input[@id='committee_view_only']";
		WebElement viewOnly = driver.findElement(By.xpath(string));
		
		if(!viewOnly.isSelected()) {
			//driver.findElement(deactivate_Resources).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", viewOnly);
		}	
	}
	
	public void disable_View_Only_Check_Box() {
		String string = "//input[@id='committee_view_only']";
		WebElement viewOnly = driver.findElement(By.xpath(string));
		
		if(viewOnly.isSelected()) {
			//driver.findElement(deactivate_Resources).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", viewOnly);
		}	
	}
	
	public void verify_View_Only_Books_Box_Not_Checked() throws InterruptedException {
		WebElement checkBox_View_Only_Books = driver.findElement(By.xpath("//input[@id='committee_view_only']"));
		Assert.assertNull(checkBox_View_Only_Books.getAttribute("checked"));
	}
	
	public void disable_Events_Libraries_Collaborate_Discussions() {
		String str = "//input[@id='can_access_events']";
		String str2 = "//input[@id='can_access_files']";
		String str3 = "//input[@id='can_access_collaborate']";
		String str4 = "//input[@id='can_access_discussions']";

		WebElement events = driver.findElement(By.xpath(str));
		WebElement libraries = driver.findElement(By.xpath(str2));
		WebElement collaborate = driver.findElement(By.xpath(str3));
		WebElement discussions = driver.findElement(By.xpath(str4));
		
		if(events.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", events);
		}	
		
		if(libraries.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", libraries);
		}
		
		if(collaborate.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", collaborate);
		}	
		
		if(discussions.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", discussions);
		}	
	}
	
	public void enable_Events_Libraries_Collaborate_Discussions() {
		String str = "//input[@id='can_access_events']";
		String str2 = "//input[@id='can_access_files']";
		String str3 = "//input[@id='can_access_collaborate']";
		String str4 = "//input[@id='can_access_discussions']";

		WebElement events = driver.findElement(By.xpath(str));
		WebElement libraries = driver.findElement(By.xpath(str2));
		WebElement collaborate = driver.findElement(By.xpath(str3));
		WebElement discussions = driver.findElement(By.xpath(str4));
		
		if(!events.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", events);
		}	
		
		if(!libraries.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", libraries);
		}
		
		if(!collaborate.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", collaborate);
		}	
		
		if(!discussions.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", discussions);
		}	
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
	
	public void enable_Workroom_To_View_Only_Books() throws InterruptedException {
		this.verify_AddNewBtn();
		Thread.sleep(1000);
		this.click_Workroom_Dropdown_Arrow_2();
		Thread.sleep(1000);
		this.verify_Settings_Btn();
		this.click_Workroom_Settings_Btn();
		Thread.sleep(1000);
		this.verify_Workroom_Name_Field();
		this.enable_View_Only_Check_Box();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> set_Workroom_To_View_Only_Books() -----------");
	}
	
	public void disable_Workroom_To_View_Only_Books() throws InterruptedException {
		this.verify_AddNewBtn();
		Thread.sleep(1000);
		this.click_Workroom_Dropdown_Arrow_2();
		Thread.sleep(1000);
		this.verify_Settings_Btn();
		this.click_Workroom_Settings_Btn();
		Thread.sleep(1000);
		this.verify_Workroom_Name_Field();
		this.disable_View_Only_Check_Box();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> disable_Workroom_To_View_Only_Books() -----------");
	}
	
	public void verify_View_Only_Books_Not_Checked() throws InterruptedException {
		this.verify_AddNewBtn();
		Thread.sleep(1000);
		this.click_Workroom_Dropdown_Arrow_2();
		Thread.sleep(1000);
		this.verify_Settings_Btn();
		this.click_Workroom_Settings_Btn();
		Thread.sleep(1000);
		this.verify_Workroom_Name_Field();
		this.verify_View_Only_Books_Box_Not_Checked();
		System.out.println("------- Completed --> verify_View_Only_Books_Not_Checked() -----------");
	}
	
	public void disable_Workroom_Access_To_Events_Library_Collaborate() throws InterruptedException {
		this.verify_AddNewBtn();
		Thread.sleep(1000);
		this.click_Workroom_Dropdown_Arrow_2();
		Thread.sleep(1000);
		this.verify_Settings_Btn();
		this.click_Workroom_Settings_Btn();
		Thread.sleep(1000);
		this.verify_Workroom_Name_Field();
		this.disable_Events_Libraries_Collaborate_Discussions();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> disable_Workroom_Access_To_Events_Library_Collaborate() -----------");
	}
	
	public void enable_Workroom_Access_To_Events_Library_Collaborate() throws InterruptedException {
		this.verify_AddNewBtn();
		Thread.sleep(1000);
		this.click_Workroom_Dropdown_Arrow_2();
		Thread.sleep(1000);
		this.verify_Settings_Btn();
		this.click_Workroom_Settings_Btn();
		Thread.sleep(1000);
		this.verify_Workroom_Name_Field();
		this.enable_Events_Libraries_Collaborate_Discussions();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> disable_Workroom_Access_To_Events_Library_Collaborate() -----------");
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
	
	// -----------------user_Can_Create/Edit/Delete_Custom_Field--------------------------
	
	By manangeBtn = By.xpath("//body/div[@id='settingsModal']//div/button[contains(.,'Manage')]");
	By new_Custom_Field = By.xpath("//body/div[@id='settingsModal']//div/ul/li/a[contains(.,'New Custom Field')]");
	By new_Group = By.xpath("//body/div[@id='settingsModal']//div/ul/li/a[contains(.,'New Group')]");
	By text_Field = By.xpath("//body/div[@id='settingsModal']//div/form[1]//div/a[1][contains(.,'Text Field')]");
	By text_Box = By.xpath("//textarea[@id='custom_field_label']");
	By description_Box = By.xpath("//textarea[@id='custom_field_description']");
	By group_Name_Field = By.xpath("//input[@id='custom_field_group_name']");

	By saveBtn_CF = By.xpath("//body/div[@id='settingsModal']//div/button[2]");
	By saveBtn_CF_2 = By.xpath("//body/div[@id='formsModal']//div/button[2]");

	By label = By.xpath("//body/div[@id='settingsModal']//div/ul/li//div[1]/label[1]");
	By label_Dropdown = By.xpath("//body/div[@id='settingsModal']//div/ul/li//div[1]/label[1]/following::div[@class='btn-group small pull-right']");
	By edit = By.xpath("//body/div[@id='settingsModal']//div/ul/li//div/ul/li[1]/a[contains(.,'Edit')]");
	By delete = By.xpath("//body/div[@id='settingsModal']//div/ul/li//div/ul/li[2]/a[contains(.,'Delete')]");
	By group_Dropdown = By.xpath("//body/div[@id='settingsModal']//div/ul[1]/li[1]//div/a[2][normalize-space (text())='Group Name']/following::div[@class='btn-group small pull-right']");
	By edited_Group_Dropdown = By.xpath("//body/div[@id='settingsModal']//div/ul[1]/li[1]//div/a[2][normalize-space (text())='Edited Group Name']/following::div[@class='btn-group small pull-right']");
	
	String textBox = "label";
	String description = "description";
	
	String editedTextBox = "edited label";
	String editedDescription = "edited description";
	
	String groupName = "Group Name";
	String editedGroupName = "Edited Group Name";

	public void verify_ManageBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(manangeBtn)));
	}
	
	public void verify_Label_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(label_Dropdown)));
	}
	
	public void verify_New_Custom_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Custom_Field)));
	}
	
	public void verify_Text_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(text_Field)));
	}
	
	public void verify_Text_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(text_Box)));
	}
	
	public void verify_Edit() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit)));
	}
	
	public void verify_Group_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(group_Name_Field)));
	}

	public void click_ManageBtn() {
		driver.findElement(manangeBtn).click();
	}
	
	public void click_New_Custom_Field() {
		driver.findElement(new_Custom_Field).click();
	}
	
	public void click_New_Group() {
		driver.findElement(new_Group).click();
	}
	
	public void click_Text_Field() {
		driver.findElement(text_Field).click();
	}
	
	public void sendKeys_To_Label_Description() {
		driver.findElement(text_Box).sendKeys(textBox);
		driver.findElement(description_Box).sendKeys(description);
	}
	
	public void sendKeys_To_Group_Name_Field() {
		driver.findElement(group_Name_Field).sendKeys(groupName);
	}
	
	public void click_SaveBtn_CF() {
		driver.findElement(saveBtn_CF).click();
	}
	
	public void click_SaveBtn_CF_2() {
		driver.findElement(saveBtn_CF_2).click();
	}
	
	public void verify_Label_Created() {
		String element = "//body/div[@id='settingsModal']//div/ul/li//div[1]/label[1][text()='label']/following::div[@class='btn-group small pull-right']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Group_Created() {
		String element = "//body/div[@id='settingsModal']//div/ul[1]/li[1]//div/a[2][normalize-space (text())='Group Name']/following::div[@class='btn-group small pull-right']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void click_Label_Dropdown() {
		driver.findElement(label_Dropdown).click();
	}
	
	public void click_Group_Dropdown() {
		driver.findElement(group_Dropdown).click();
	}
	
	public void click_Edited_Group_Dropdown() {
		driver.findElement(edited_Group_Dropdown).click();
	}
	
	public void click_Edit() {
		driver.findElement(edit).click();
	}
	
	public void verify_Edited_Label_Created() {
		String element = "//body/div[@id='settingsModal']//div/ul/li//div[1]/label[1][text()='edited label']/following::div[@class='btn-group small pull-right']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Edited_Group_Created() {
		String element = "//body/div[@id='settingsModal']//div/ul[1]/li[1]//div/a[2][normalize-space (text())='Edited Group Name']/following::div[@class='btn-group small pull-right']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Edited_Group_Created_2() {
		String element = "//body/div[@id='settingsModal']//div/ul[1]/li[1]//div/a[2][normalize-space (text())='label']/following::div[@class='btn-group small pull-right']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Custom_Field_NOT_Present() {
		String element = "//body/div[@id='settingsModal']//div/ul/li//div[1]/label[1][text()='edited label']/following::div[@class='btn-group small pull-right']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Edited_Custom_Field_Group_NOT_Present() {
		String element = "//body/div[@id='settingsModal']//div/ul[1]/li[1]//div/a[2][normalize-space (text())='Edited Group Name']/following::div[@class='btn-group small pull-right']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Edited_Custom_Field_Group_NOT_Present_2() {
		String element = "//body/div[@id='settingsModal']//div/ul[1]/li[1]//div/a[2][normalize-space (text())='label']/following::div[@class='btn-group small pull-right']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void sendKeys_Edit_Label_Description() {
		driver.findElement(text_Box).clear();
		driver.findElement(text_Box).sendKeys(editedTextBox);
		
		driver.findElement(description_Box).clear();
		driver.findElement(description_Box).sendKeys(editedDescription);
	}
	
	public void sendKeys_Edit_Group_Name_Field() {
		driver.findElement(group_Name_Field).clear();
		driver.findElement(group_Name_Field).sendKeys(editedGroupName);
	}
	
	public void click_Delete() {
		driver.findElement(delete).click();
	}
	
	public void create_Custom_Field() throws InterruptedException {
		this.verify_ManageBtn();
		this.click_ManageBtn();
		Thread.sleep(1000);
		this.verify_New_Custom_Field();
		this.click_New_Custom_Field();
		Thread.sleep(1000);
		this.verify_Text_Field();
		this.click_Text_Field();
		Thread.sleep(1000);
		this.verify_Text_Box();
		this.sendKeys_To_Label_Description();
		this.click_SaveBtn_CF();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> create_Custom_Field() -----------");
	}
	
	public void create_Custom_Field_Group() throws InterruptedException {
		this.verify_ManageBtn();
		this.click_ManageBtn();
		Thread.sleep(1000);
		this.verify_New_Custom_Field();
		this.click_Group_Dropdown();
		Thread.sleep(1000);
		this.verify_Group_Name_Field();
		this.sendKeys_To_Group_Name_Field();
		Thread.sleep(1000);
		this.click_SaveBtn_CF_2();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> create_Custom_Field_Group() -----------");
	}
	
	public void edit_Custom_Field() throws InterruptedException {
		this.verify_ManageBtn();
		this.verify_Label_Created();
		this.click_Label_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit();
		this.click_Edit();
		Thread.sleep(1000);
		this.verify_Text_Box();
		this.sendKeys_Edit_Label_Description();
		this.click_SaveBtn_CF();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> edit_Custom_Field() -----------");
	}
	
	public void edit_Custom_Field_Group() throws InterruptedException {
		this.verify_ManageBtn();
		this.verify_Group_Created();
		this.click_Group_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit();
		this.click_Edit();
		Thread.sleep(1000);
		this.verify_Group_Name_Field();
		this.sendKeys_Edit_Group_Name_Field();
		this.click_SaveBtn_CF_2();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> edit_Custom_Field_Group() -----------");
	}
	
	public void delete_Custom_Field() throws InterruptedException {
		this.verify_ManageBtn();
		this.verify_Edited_Label_Created();
		this.click_Label_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit();
		this.click_Delete();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		driver.navigate().refresh();
		System.out.println("------- Completed --> delete_Custom_Field() -----------");
	}
	
	public void delete_Custom_Field_Group() throws InterruptedException {
		this.verify_ManageBtn();
		this.verify_Edited_Group_Created();
		this.click_Edited_Group_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit();
		this.click_Delete();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		driver.navigate().refresh();
		System.out.println("------- Completed --> delete_Custom_Field_Group() -----------");
	}
	
	public void delete_Custom_Field_Group_2() throws InterruptedException {
		this.verify_ManageBtn();
		this.verify_Label_Dropdown();
		this.click_Label_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit();
		this.click_Delete();
		Thread.sleep(1000);
		this.verify_Continue_Btn();
		this.click_ContinueBtn();
		driver.navigate().refresh();
		System.out.println("------- Completed --> delete_Custom_Field_Group_2() -----------");
	}
	
	public void verify_Custom_Field_Deleted() throws InterruptedException {
		this.verify_ManageBtn();
		this.verify_Custom_Field_NOT_Present();
		System.out.println("------- Completed --> verify_Custom_Field_Deleted() -----------");
	}
	
	public void verify_Custom_Field_Group_Deleted() throws InterruptedException {
		this.verify_ManageBtn();
		this.verify_Edited_Custom_Field_Group_NOT_Present();
		System.out.println("------- Completed --> verify_Custom_Field_Group_Deleted() -----------");
	}
	
	public void verify_Custom_Field_Group_Deleted_2() throws InterruptedException {
		this.verify_ManageBtn();
		this.verify_Edited_Custom_Field_Group_NOT_Present_2();
		System.out.println("------- Completed --> verify_Custom_Field_Group_Deleted_2() -----------");
	}

}
