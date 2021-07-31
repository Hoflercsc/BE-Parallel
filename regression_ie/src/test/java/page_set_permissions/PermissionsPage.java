package page_set_permissions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import page_common_functions.HomeNavigationPage;

public class PermissionsPage {
	static String homePage = "https://automation-ozzie.boardeffect.com/login";
	WebDriver driver;

	public PermissionsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// --------------Open_User_Profile---------------------------
	By test_User_Dropdown = By.xpath("(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By set_Permissions = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Set Permissions')]");
	By edit_Profile = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");
	By view_Profile = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'View Profile')]");
	By directory = By.xpath("//span[contains(text(),'Directory')]");

	public void verify_Directory() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(directory)));
	}
	
	public void verify_Test_User_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(test_User_Dropdown)));
	}

	public void verify_Edit_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Profile)));
	}
	
	public void verify_Set_Permissions() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(set_Permissions)));
	}

	public void click_Test_User_Dropdown() {
		driver.findElement(test_User_Dropdown).click();
	}

	public void click_Set_Permissions() {
		driver.findElement(set_Permissions).click();
	}
	
	public void click_Edit_Profile() {
		driver.findElement(edit_Profile).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Set_Permissions();
		Thread.sleep(1000);
		System.out.println("------- Completed --> Open_User_Profile() -----------");
	}

// --------------open_User_Profile_Deactivate_Resource---------------------------
	By deactivate_Resources_Label = By.xpath("//label[contains(text(),'Deactivate Resources')]");

	public void verify_Deactivate_Resources_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivate_Resources_Label)));
	}
	
	public void verify_Resource_Library_Hidden() {
		String resource_Library = "//span[contains(text(),'Libraries')]";
		Assert.assertTrue(driver.findElements(By.xpath(resource_Library)).size() < 1);
		System.out.println("------- Completed --> verify_Resource_Library_Hidden() -----------");
	}
	
	public void verify_AuttoAttend_WR_Hidden() {
		String autoAttend_WR = "//a[contains(text(),'AutoAttend')]";
		Assert.assertTrue(driver.findElements(By.xpath(autoAttend_WR)).size() < 1);
		System.out.println("------- Completed --> verify_AuttoAttend_Workroom_Hidden() -----------");
	}
	
	public void click_Deactivate_Resources() {
		String string = "//input[@id='user_resources_disabled']";
		WebElement dr_box = driver.findElement(By.xpath(string));
		
		if(!dr_box.isSelected()) {
			//driver.findElement(deactivate_Resources).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", dr_box);
		}	
	}
	
	public void click_Activate_Resources() {
		String string = "//input[@id='user_resources_disabled']";
		WebElement dr_box = driver.findElement(By.xpath(string));
		
		if(dr_box.isSelected()) {
			//driver.findElement(deactivate_Resources).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", dr_box);
		}
	}
	
	public void verify_Resource_Library_Deactivated() throws InterruptedException {
		this.verify_My_BoardEffect();
		Thread.sleep(1000);
		this.Message_User_Disabled();
		System.out.println("------- Completed --> verify_Resource_Library_Deactivated() -----------");
		}
	
	public void verify_AutoAttend_Workroom_Deactivated() throws InterruptedException {
		this.verify_My_BoardEffect();
		Thread.sleep(1000);
		this.verify_AuttoAttend_WR_Hidden();
		System.out.println("------- Completed --> verify_Resource_Library_Deactivated() -----------");
		}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_Deactivate_Resource() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Set_Permissions();
		Thread.sleep(1000);
		this.verify_Deactivate_Resources_Label();
		this.click_Deactivate_Resources();
		Thread.sleep(1000);
		this.click_Save_Btn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> open_User_Profile_Deactivate_Resource() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_Activate_Resource() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Set_Permissions();
		Thread.sleep(1000);
		this.verify_Deactivate_Resources_Label();
		this.click_Activate_Resources();
		Thread.sleep(1000);
		this.click_Save_Btn();
		Thread.sleep(2500);
	}
	
	// --------------open_User_Profile_Enable_Private_Directory---------------------------
	By wanda_Martin_Dropdown = By.xpath("(//a[contains(text(),'Wanda Martin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By private_Directory_Box = By.xpath("//input[@id='directory_view']");
	
	public void verify_Wanda_Martin_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(wanda_Martin_Dropdown)));
	}
	
	public void verify_Private_Directory_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivate_Resources_Label)));
	}
	
	public void click_Wanda_Martin_Dropdown() {
		driver.findElement(wanda_Martin_Dropdown).click();
	}
	
	public void click_To_Enable_Private_Directory_Box() {
		String string = "//input[@id='directory_view']";
		WebElement pd_box = driver.findElement(By.xpath(string));
		
		if(!pd_box.isSelected()) {
			//driver.findElement(deactivate_Resources).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", pd_box);
		}	
	}
	
	public void click_To_Disable_Private_Directory_Box() {
		String string = "//input[@id='directory_view']";
		WebElement pd_box = driver.findElement(By.xpath(string));
		
		if(pd_box.isSelected()) {
			//driver.findElement(deactivate_Resources).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", pd_box);
		}	
	}
	
	public void verify_Other_Users_NOT_Shown() {
		String testUser = "(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String autoDirector = "(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroomAdmin = "(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(testUser)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(autoDirector)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(workroomAdmin)).size() < 1);
		System.out.println("------- Completed --> verify_Only_Wanda_Martin_Shown() -----------");
		}
	
	public void verify_Everyone_Shown() {
		String testUser = "(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String autoDirector = "(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroomAdmin = "(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(testUser)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(autoDirector)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(workroomAdmin)).size() > 0);
		System.out.println("------- Completed --> verify_Only_Wanda_Martin_Shown() -----------");
		}
	

	// --------------Function Being Called ---------------------------
	public void open_User_Profile_Enable_Private_Directory() throws InterruptedException {
		this.verify_Wanda_Martin_Dropdown();
		Thread.sleep(1000);
		this.click_Wanda_Martin_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Set_Permissions();
		Thread.sleep(1000);
		this.verify_Private_Directory_Label();
		this.click_To_Enable_Private_Directory_Box();
		Thread.sleep(1000);
		this.click_Save_Btn();
		Thread.sleep(2500);
		driver.navigate().refresh(); // back to home page
		System.out.println("------- Completed --> open_User_Profile_Enable_Private_Directory() -----------");
	}
	
	public void verify_Only_Wanda_Martin_Visible() throws InterruptedException {
		this.verify_Wanda_Martin_Dropdown();
		this.verify_Other_Users_NOT_Shown();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Only_Wanda_Martin_Visible() -----------");
	}
	
	public void verify_Everyone_Visible() throws InterruptedException {
		this.verify_Wanda_Martin_Dropdown();
		this.verify_Everyone_Shown();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Everyone_Visible() -----------");
	}
	
	public void open_User_Profile_Disable_Private_Directory() throws InterruptedException {
		this.verify_Wanda_Martin_Dropdown();
		Thread.sleep(1000);
		this.click_Wanda_Martin_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Set_Permissions();
		Thread.sleep(1000);
		this.verify_Private_Directory_Label();
		this.click_To_Disable_Private_Directory_Box();
		Thread.sleep(1000);
		this.click_Save_Btn();
		Thread.sleep(2500);
		driver.navigate().refresh(); // back to main page
		System.out.println("------- Completed --> open_User_Profile_Enable_Private_Directory() -----------");
	}
	
	
	public void open_Settings_Enable_Workroom_Admin() throws InterruptedException {
		this.verify_Wanda_Martin_Dropdown();
		
		System.out.println("------- Completed --> open_Settings_Enable_Workroom_Admin() -----------");
	}
	
	// --------------open_User_Profile_Deactivate_Workroom---------------------------
	By open_Manage_Workrooms = By.xpath("//a[contains(text(),'Click Here to open Manage Workrooms and Groups')]");
	By introduction_Menu = By.xpath("//a[contains(text(),'Introduction')]");
	By manage_Workrooms_Groups_Active = By.xpath("//a[@class='active'][contains(text(),'Manage Workrooms and Groups')]");
	By autoAttend_Dropdown = By.xpath("(//a[@class='collapsed committee-collapse placeholder'][contains(text(),'AutoAttend')]/following::div[@class='btn-group small'])[1]");
	By autoAttend_Dropdown_Deactivate = By.xpath("(//a[@class='collapsed deactive-committee-collapse placeholder'][contains(text(),'AutoAttend')]/following::div[@class='btn-group small'])");
	By settings_WR = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Settings')]");
	By deactivate_Label = By.xpath("//div[@class='col-sm-6 controls checkbox checkbox-info']//label[contains(text(),'Deactivate')]");
	By save_WR = By.xpath("//div[@class='modal-dialog']//button[@id='formsSubmit']");
	By deactivate_Workroom_Tab = By.xpath("//a[contains(text(),'Deactivated Workrooms')]");
	
	public void verify_Introduction() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(introduction_Menu)));
	}
	
	public void verify_AutoAttend_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoAttend_Dropdown)));
	}
	
	public void verify_AutoAttend_Dropdown_Deactivate() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoAttend_Dropdown_Deactivate)));
	}
	
	public void verify_Settings_WR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_WR)));
	}
	
	public void verify_Deactivate_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivate_Label)));
	}
	
	public void click_Open_Manage_Workrooms() {
		driver.findElement(open_Manage_Workrooms).click();
	}
	
	public void click_Manage_Workrooms_Groups_Active() {
		driver.findElement(manage_Workrooms_Groups_Active).click();
	}
	
	public void click_AutoAttend_Dropdown() {
		driver.findElement(autoAttend_Dropdown).click();
	}
	
	public void click_AutoAttend_Dropdown_Deactivate() {
		driver.findElement(autoAttend_Dropdown_Deactivate).click();
	}
	
	public void click_Settings_WR() {
		driver.findElement(settings_WR).click();
	}
	
	public void click_Save_WR() {
		driver.findElement(save_WR).click();
	}
	
	public void click_Deactivate_Workroom_Tab() {
		String string = "//a[contains(text(),'Deactivated Workrooms')]";
		
		WebElement dr_Tab = driver.findElement(By.xpath(string));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", dr_Tab);
	}
	
	public void click_Deactivate_Box_To_Disable() {
		String string = "//input[@id='committee_disabled']";
		WebElement deact = driver.findElement(By.xpath(string));
		
		if(!deact.isSelected()) {
			//driver.findElement(deactivate_Resources).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", deact);
		}
	}
	
	public void click_Deactivate_Box_To_Enable() {
		String string = "//input[@id='committee_disabled']";
		WebElement deact = driver.findElement(By.xpath(string));
		
		if(deact.isSelected()) {
			//driver.findElement(deactivate_Resources).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", deact);
		}
	}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_Click_Manage_Workrooms() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Set_Permissions();
		Thread.sleep(1000);
		this.verify_Deactivate_Resources_Label();
		this.click_Open_Manage_Workrooms();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_Click_Manage_Workrooms() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void restrict_Workroom_Access() throws InterruptedException {
		this.verify_Introduction();
		this.click_Manage_Workrooms_Groups_Active();
		Thread.sleep(1000);
		this.verify_AutoAttend_Dropdown();
		this.click_AutoAttend_Dropdown();
		Thread.sleep(1000);
		this.verify_Settings_WR();
		this.click_Settings_WR();
		Thread.sleep(1000);
		this.verify_Deactivate_Label();
		this.click_Deactivate_Box_To_Disable(); // disable
		Thread.sleep(1000);
		this.click_Save_WR();
		Thread.sleep(1500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> restrict_Workroom_Access() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void enable_Workroom_Access() throws InterruptedException {
		this.verify_Introduction();
		this.click_Manage_Workrooms_Groups_Active();
		Thread.sleep(1000);
		this.click_Deactivate_Workroom_Tab();
		Thread.sleep(1000);
		this.verify_AutoAttend_Dropdown_Deactivate();
		this.click_AutoAttend_Dropdown_Deactivate();
		Thread.sleep(1000);
		this.verify_Settings_WR();
		this.click_Settings_WR();
		Thread.sleep(1000);
		this.verify_Deactivate_Label();
		this.click_Deactivate_Box_To_Enable(); // enable
		Thread.sleep(1000);
		this.click_Save_WR();
		Thread.sleep(1500);
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("------- Completed --> open_User_Profile_Enable_Workroom() -----------");
	}
			
	// --------------enable_User_As_System_Administrator---------------------------
	By system_Admin_Check_Box = By.xpath("//label[contains(text(),'System Administrator')]");
	By mobile_Only_Check_Box = By.xpath("//label[contains(text(),'Mobile Only')]");
	By manage_Files_Check_Box = By.xpath("//label[contains(text(),'Manage Files')]");
	By deativate_Message_Check_Box = By.xpath("//input[@id='user_can_email']");
	By save_Btn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By everybody = By.xpath("//div[@class='col-md-2 sidebar-modal']//li[1]");
	By close_Directory_Btn = By.xpath("//div[@id='directoryModal']//a[@class='atlas-close pull-right']");

	public void verify_System_Admin_Check_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(system_Admin_Check_Box)));
	}
	
	public void verify_Manage_Files_Check_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(manage_Files_Check_Box)));
	}
	
	public void verify_Mobile_Only_Check_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mobile_Only_Check_Box)));
	}
	
	public void verify_Everybody() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(everybody)));
	}
	
	public void click_system_Admin_Check_Box() {
		//driver.findElement(system_Admin_Check_Box).click();
		WebElement element = driver.findElement(By.xpath(" //input[starts-with (@id,'system_administrator')]"));
		if(!element.isSelected()) {
			driver.findElement(By.xpath("//input[starts-with (@id,'system_administrator')]")).click();
		}
	}
	
	public void unclick_system_Admin_Check_Box() {
		//driver.findElement(system_Admin_Check_Box).click();
		WebElement element = driver.findElement(By.xpath(" //input[starts-with (@id,'system_administrator')]"));
		if(element.isSelected()) {
			driver.findElement(By.xpath("//input[starts-with (@id,'system_administrator')]")).click();
		}
	}
	
	public void click_Mobile_Only_Check_Box() {
		//driver.findElement(mobile_Only_Check_Box).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='user_mobile_only']"));
		if(!element.isSelected()) {
			driver.findElement(By.xpath("//input[@id='user_mobile_only']")).click();
		}
	}
	
	public void unclick_Mobile_Only_Check_Box() {
		//driver.findElement(mobile_Only_Check_Box).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='user_mobile_only']"));
		if(element.isSelected()) {
			driver.findElement(By.xpath("//input[@id='user_mobile_only']")).click();
		}
	}
	
	public void click_Manage_Files() {
		WebElement element = driver.findElement(By.xpath("//input[@id='manage_resources']"));
		if(!element.isSelected()) {
			driver.findElement(manage_Files_Check_Box).click();
		}
	}
	
	public void click_Manage_Files_2() {
		WebElement element = driver.findElement(By.xpath("//input[@id='manage_resources']"));
		if(element.isSelected()) {
			driver.findElement(manage_Files_Check_Box).click();
		}
	}
	
	public void click_Deactivate_Message_Check_Box() {
		//driver.findElement(deativate_Message_Check_Box).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='user_can_email']"));
		if(!element.isSelected()) {
			driver.findElement(By.xpath("//input[@id='user_can_email']")).click();
		}
	}
	
	public void unclick_Deactivate_Message_Check_Box() {
		//driver.findElement(deativate_Message_Check_Box).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='user_can_email']"));
		if(element.isSelected()) {
			driver.findElement(By.xpath("//input[@id='user_can_email']")).click();
		}
	}
	
	public void click_Save_Btn() {
		driver.findElement(save_Btn).click();
	}
	
	public void click_Close_Directory_Btn() {
		driver.findElement(close_Directory_Btn).click();
	}
	
	public void click_Everybody() {
		driver.findElement(everybody).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void enable_User_As_System_Administrator() throws InterruptedException {
		this.verify_System_Admin_Check_Box();
		this.click_system_Admin_Check_Box();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3500);// wait for star to appear
		System.out.println("------- Completed --> enable_User_As_System_Administrator() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void disable_User_As_System_Administrator() throws InterruptedException {
		this.verify_System_Admin_Check_Box();
		this.unclick_system_Admin_Check_Box();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3500);// wait for star to appear
		System.out.println("------- Completed --> enable_User_As_System_Administrator() -----------");
	}
	// --------------Function Being Called ---------------------------
	public void enable_User_To_Mobile_Only_Save() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.click_Mobile_Only_Check_Box();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3000);// wait for star to appear
		System.out.println("------- Completed --> enable_User_To_Mobile_Only_Save() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void disable_User_To_Mobile_Only_Save() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.unclick_Mobile_Only_Check_Box();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3000);// wait for star to appear
		System.out.println("------- Completed --> enable_User_To_Mobile_Only_Save() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void click_To_Activate_Deactivate_Messaging() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.click_Deactivate_Message_Check_Box();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3000);// wait for star to appear
		System.out.println("------- Completed --> Deactivate_Messaging_For_User() -----------");
	}
	
	public void click_To_Deactivate_Messaging() throws InterruptedException {
		this.verify_Manage_Files_Check_Box();
		this.unclick_Deactivate_Message_Check_Box();
		this.click_Save_Btn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> click_To_Deactivate_Messaging() -----------");
	}
	
	// --------------set_User_To_Hidden ---------------------------
	By workroom_Admin_Dropdown = By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	
	public void verify_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Dropdown)));
	}
	
	public void click_User_Is_Hidden() {
		String radio = "//label[contains(text(),'User is Hidden')]/preceding::input[@id='global_visible1_1']";
		WebElement user_Is_Hidden = driver.findElement(By.xpath(radio));
		
		if (!user_Is_Hidden.isSelected()) {
			//driver.findElement(By.xpath(radio)).click();
			WebElement element = driver.findElement(By.xpath("//label[contains(text(),'User is Hidden')]/preceding::input[@id='global_visible1_1']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
	}
	
	public void click_User_Is_Visible() {
		String radio = "//label[contains(text(),'User is Visible')]/preceding::input[@id='global_visible1_0']";
		WebElement user_Is_Visible = driver.findElement(By.xpath(radio));
		
		if (!user_Is_Visible.isSelected()) {
			//driver.findElement(By.xpath(radio)).click();
			WebElement element = driver.findElement(By.xpath("//label[contains(text(),'User is Visible')]/preceding::input[@id='global_visible1_0']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
	}
	
	public void verify_Test_User_Hidden() {
		String test_Reset = "(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(test_Reset)).size() < 1);
	}
	
	public void verify_Test_User_Visible() {
		String test_Reset = "(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(test_Reset)).size() > 0);
	}
	
	// --------------Function Being Called ---------------------------
	public void set_User_To_Hidden() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.click_User_Is_Hidden();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3000);// wait for hidden icon to appear
		System.out.println("------- Completed --> set_User_To_Hidden() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Test_User_Not_In_List() throws InterruptedException {
		this.verify_Workroom_Admin();
		this.verify_Test_User_Hidden();
		System.out.println("------- Completed --> verify_Test_User_Not_In_List() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Test_User_Is_In_List() throws InterruptedException {
		this.verify_Workroom_Admin();
		this.verify_Test_User_Visible();
		System.out.println("------- Completed --> verify_Test_User_Is_In_List() -----------");
	}
		
	
	// --------------Function Being Called ---------------------------
	public void set_User_To_Visible() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.click_User_Is_Visible();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3000);// wait for hidden icon to appear
		System.out.println("------- Completed --> set_User_To_Visible() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void enable_User_To_Manage_Files() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.click_Manage_Files();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3000);// wait for star to appear
		System.out.println("------- Completed --> enable_User_To_Mobile_Only_Save() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void disable_User_To_Manage_Files() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.click_Manage_Files_2();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3000);// wait for star to appear
		System.out.println("------- Completed --> disable_User_To_Manage_Files() -----------");
	}
	
	// --------------- verify_New_Folder_Present_And_Close --------------------
	public void verify_Folder_Present() throws InterruptedException {
		String folder = "//a[@class='new-folder']";
		Assert.assertTrue(driver.findElements(By.xpath(folder)).size() > 0);
	}
	
	public void close_Modal() {
		// driver.findElement(close_Modal).click();
		WebElement element = driver.findElement(By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_New_Folder_Present_And_Close() throws InterruptedException {
		this.verify_Folder_Present();
		Thread.sleep(1000);
		this.close_Modal();
		System.out.println("------- Completed --> verify_New_Folder_Present() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	By my_BoardEffect = By.xpath("//a[contains(text(),'My BoardEffect')]");
	By message_Users = By.xpath("//i[@class='fa fa-envelope']");

	public void verify_My_BoardEffect() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(my_BoardEffect)));
	}
	
	public void Message_User_Disabled() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean element = driver.findElements(message_Users).size() < 1;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (element == true) {
			Assert.assertTrue(true,"good - message_users not present");
		}else {
			Assert.assertTrue(driver.findElements(message_Users).size() < 1 );
		}
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Message_Users_Disabled() throws InterruptedException {
		this.verify_My_BoardEffect();
		Thread.sleep(1000);
		this.Message_User_Disabled();
		System.out.println("------- Completed --> verify_Message_Users_Disabled() -----------");
		}
		
	// --------------user_Can_See_Settings_Option---------------------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By settings = By.xpath("//span[contains(text(),'Settings')]");

		public void verify_autoBE() {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
		}
		
		public void verify_Settings_Visible() {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Boolean element = driver.findElements(settings).size() > 0;
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			
			if (element == true) {
				Assert.assertTrue(true,"Settings option enabled for user");
			}else {
				Assert.assertFalse(false,"Settings option disabled for user" );
			}
		}
			
	// --------------Function Being Called ---------------------------
	public void user_Can_See_Settings_Option() throws InterruptedException {
		this.verify_autoBE();
		Thread.sleep(1000);
		this.verify_Settings_Visible();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_See_Settings_Option() -----------");
	}
	
	// --------------user_Can_See_Settings_Option---------------------------
	By login_Failed = By.xpath("//div[@id='login']//p[contains(text(),'Your account is not enabled for Portal Access')]");
	
	public void verify_Login_Declined() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean element = driver.findElements(login_Failed).size() > 0;
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		if (element == true) {
			Assert.assertTrue(true,"good -login failed");
		}else {
			Assert.assertFalse(false," bad - login sucessful" );
		}
	}

	// --------------Function Being Called ---------------------------
	public void user_Login_Declined() throws InterruptedException {
		Thread.sleep(3000);
		this.verify_Login_Declined();
		System.out.println("------- Completed --> user_Login_Declined() -----------");
	}
	
	// --------------user_Opens_Settings_Opens_Workroom_And_Group_Settings--------------
	By workroom_Groups = By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]");

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

	public void click_SettingsBtn() {
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Manage_Workroom_Groups() {
		driver.findElement(workroom_Groups).click();
	}
	
	// --------------Function Being Called -----------------------
	public void user_Open_Settings_Then_Workroom_And_Group_Settings() throws InterruptedException {
		this.verify_Settings();
		Thread.sleep(1000);
		this.click_SettingsBtn();
		Thread.sleep(1000);
		this.verify_Manage_Workrooms_Groups();
		this.click_Manage_Workroom_Groups();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Open_Settings_Then_Workroom_And_Group_Settings() -----------");
	}
	

	// ---------------systemAdmin_Set_User_As_Workroom_Admin-----------
	
	By autoBE_Expand = By.xpath("//a[@class='collapsed committee-collapse placeholder'][contains(text(),'AutoBE')]");
	By autoBE_Collapse = By.xpath("//a[@class='committee-collapse placeholder']");
	By test_User = By.xpath("//a[contains(text(),'Test Reset')]");
	By make_Admin = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Make Admin')]");
	By workroom_Admin = By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By workroom_Admin_Moved = By.xpath("//div[@class='col-sm-12 panel-section-heading'][contains(text(),'Workroom Administrators')]/following::tr[ starts-with (@id,'settings-users-info-')]/td[2]/a");
	By make_Hidden = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Make Hidden')]");
	By remove_Hidden = By.xpath("//a[contains(text(),'Remove Hidden')]");

	public void verify_AutoBE_Expand() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Expand)));
	}
	
	public void verify_Make_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(make_Admin)));
	}

	public void verify_WorkroomAdmin_Under_WorkroomAdministrators() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Moved)));
	}
	
	public void verify_Test_User() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(test_User)));
	}
	
	public void click_AutoBE_Expand() {
		// driver.findElement(autoBE_Expand).click();
		WebElement element2 = driver.findElement(By.xpath("//a[@class='collapsed committee-collapse placeholder'][contains(text(),'AutoBE')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Close_Settings() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//a[@id='settingsModalClose']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("//a[@id='settingsModalClose']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
		// driver.findElement(close_Settings).click();
	}
	
	public void click_AutoBE() {
		driver.findElement(autoBE).click();
	}
	
	public void click_AutoBE_Collapse() {
		driver.findElement(autoBE_Collapse).click();
	}

	public void click_Workroom_Admin_Dropdown() {
		// driver.findElement(workroom_Admin).click();
		WebElement element2 = driver.findElement(By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}

	public void click_Make_Admin() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Make Admin')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		// driver.findElement(make_Admin).click();
		WebElement element2 = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Make Admin')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Make_Hidden() throws InterruptedException {
		WebElement WR_Members = driver.findElement(By.xpath("(//*[contains(text(),'Workroom Members')])[2]"));
		WebElement Make_Hidden = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Make Hidden')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WR_Members);
		Thread.sleep(1500);
		
		// driver.findElement(make_Admin).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Make_Hidden);
	}
	
	public void click_Remove_Hidden() throws InterruptedException {
		WebElement WR_Members = driver.findElement(By.xpath("(//*[contains(text(),'Workroom Members')])[2]"));
		WebElement Remove_Hidden = driver.findElement(By.xpath("//a[contains(text(),'Remove Hidden')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WR_Members);
		Thread.sleep(1500);
		// driver.findElement(make_Admin).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Remove_Hidden);
	}
	
	public void check_Workroom_Admin_Not_Visible() throws InterruptedException {
		String element = "//a[contains(text(),'Workroom Admin')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void check_Workroom_Admin_Visible() throws InterruptedException {
		String element = "//a[contains(text(),'Workroom Admin')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_User_Hidden_Icon_Not_Present() throws InterruptedException {
		String icon = "//body[@class='workrooms inside drawer drawer--right modal-open']/div[@id='settingsModal']/div[@class='modal-dialog modal-fs']/div[@class='modal-content']/div[@class='modal-body']/div[@class='modal-content-main']/div[@class='row']/div[@class='col-md-10 narrow main-content']/div[@class='modal-content-container']/div[@id='workroom_and_group_setting']/div[@class='row']/div/div[@class='tab-content']/div[@id='active_workrooms']/div[@class='sortable-committees ui-sortable']/ul[@class='plain-list']/li[@id='committee_2305']/div[@class='panel panel-default manage-wr-panels']/div[@id='collapseWorkroomSettings_2305']/div[@class='panel-body workroom-permissions permissions']/div[@class='workrooms']/div[@class='row pad-bottom']/div[@class='workroom-users']/table[@class='modal-table-list']/tbody/tr[@id='settings-users-info-109550']/td[@class='modal-cell']/i[1]";
		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'Workroom Members')])[2]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElements(By.xpath(icon)).size() < 1);
		
		System.out.println("------- Completed --> verify_User_Hidden_Icon_Not_Present() -----------");
	}

	// --------------Function Being Called ---------------------------
	public void systemAdmin_Set_User_To_Hidden() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.click_Workroom_Admin_Dropdown();
		Thread.sleep(1000);
		this.verify_Make_Admin();
		this.click_Make_Hidden(); //make hidden
		Thread.sleep(2000);
		this.click_Close_Settings();
		Thread.sleep(1500);
		driver.navigate().refresh();
		this.verify_Settings();
		System.out.println("------- Completed --> systemAdmin_Set_User_As_Workroom_Admin() -----------");
	}
	
	public void verify_Workroom_Admin_Hidden() throws InterruptedException {
		this.verify_autoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Test_User();
		this.check_Workroom_Admin_Not_Visible();
		System.out.println("------- Completed --> verify_Workroom_Admin_Hidden() -----------");
	}
	
	public void verify_Workroom_Admin_Visible() throws InterruptedException {
		this.verify_autoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Test_User();
		this.check_Workroom_Admin_Visible();
		System.out.println("------- Completed --> verify_Workroom_Admin_Visible() -----------");
	}
	
	public void navigate_Back_To_Workroom_Members() throws InterruptedException {
		this.verify_Settings();
		this.click_SettingsBtn();
		this.verify_Manage_Workrooms_Groups();
		this.click_Manage_Workroom_Groups();
		Thread.sleep(1500);
		// -------------
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(1500);
		this.verify_WorkroomAdmin_Under_WorkroomAdministrators();
		System.out.println("------- Completed --> navigate_Back_To_Workroom_Members() -----------");
	}
	
	public void make_Workroom_Admin_Visible() throws InterruptedException {
		this.click_Workroom_Admin_Dropdown();
		Thread.sleep(1000);
		this.verify_Make_Admin();
		this.click_Remove_Hidden();
		Thread.sleep(1500);
		this.click_Close_Settings();
		Thread.sleep(1500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> make_Workroom_Admin_Visible() -----------");
	}
	
	
	// ---------------add_Users_To_A_Workroom-----------
	By workroomsTab = By.xpath("//form[@id='profile-form']//a[contains(text(),'Workrooms')]");
	By workroom_DrpDwn = By.xpath("//div[@class='col-sm-6']//div[@class='btn-group bootstrap-select show-tick form-control chosen']");
	//By marvel_Workroom = By.xpath("//div[@id='workrooms-tab']//li[4]//a[1][contains(.,'Marvel')]");
	By marvel_Workroom = By.xpath("//span[contains(text(),'Marvel')]");
	By remove_Marvel_Workroom = By.xpath("//div[starts-with(@id,'row-')]//div[@class='col-sm-5']//div[1][contains(.,'Marvel')]/following::i[@class='fa fa-remove']");
	By saveBtn_Profile = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By profile_Save_Message = By.xpath("//p[contains(text(),'has been saved.')]");
	
	public void verify_Workrooms_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomsTab)));
	}
	
	public void verify_Workroom_DrpDwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_DrpDwn)));
	}
	
	public void verify_Marvel_Woorkroom() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(marvel_Workroom)));
	}
	
	public void verify_Marvel_Woorkroom_X() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(remove_Marvel_Workroom)));
	}
	
	public void verify_Workroom_Admin_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Dropdown)));
		
		WebElement element = driver.findElement(By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Profile_Save_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_Save_Message)));
	}
	
	public void click_Auto_Director_Dropdown() {
		// driver.findElement(workroom_Admin).click();
		WebElement element2 = driver.findElement(By.xpath("(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Workrooms_Tab() {
		// driver.findElement(workroom_Admin).click();
		WebElement element2 = driver.findElement(By.xpath("//form[@id='profile-form']//a[contains(text(),'Workrooms')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Workroom_DrpDwn() {
		driver.findElement(workroom_DrpDwn).click();
	}
	
	public void click_To_Add_Marvel_Workroom() {
		driver.findElement(marvel_Workroom).click();
	}
	
	public void click_To_Remove_Marvel_Workroom() {
		driver.findElement(remove_Marvel_Workroom).click();
	}
	
	public void click_SaveBtn_Profile() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		
		driver.findElement(saveBtn_Profile).click();
	}
	
	public void add_Auto_Director_To_A_Workroom() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.verify_Workroom_Admin_Dropdown();
		this.click_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile(); //make hidden
		Thread.sleep(1000);
		this.verify_Workrooms_Tab();
		this.click_Workrooms_Tab();
		Thread.sleep(1000);
		this.verify_Workroom_DrpDwn();
		this.click_Workroom_DrpDwn();
		Thread.sleep(1000);
		this.verify_Marvel_Woorkroom();
		this.click_To_Add_Marvel_Workroom(); // add marvel from workroom
		Thread.sleep(1000);
		this.click_SaveBtn_Profile();
		Thread.sleep(1500);
		this.verify_Profile_Save_Message();
		driver.navigate().refresh();
		this.verify_Settings();
		System.out.println("------- Completed --> add_Auto_Director_To_A_Workroom() -----------");
	}
	
	public void remove_Auto_Director_From_A_Workroom() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.click_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile(); //make hidden
		Thread.sleep(1000);
		this.verify_Workrooms_Tab();
		this.click_Workrooms_Tab();
		Thread.sleep(1000);
		this.verify_Marvel_Woorkroom_X();
		this.click_To_Remove_Marvel_Workroom(); // remove marvel from workroom
		Thread.sleep(1000);
		this.click_SaveBtn_Profile();
		Thread.sleep(1500);
		this.verify_Profile_Save_Message();
		driver.navigate().refresh();
		this.verify_Settings();
		System.out.println("------- Completed --> add_Auto_Director_To_A_Workroom() -----------");
	}
	
	public void add_Test_User_To_A_Workroom() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile(); //make hidden
		Thread.sleep(1000);
		this.verify_Workrooms_Tab();
		this.click_Workrooms_Tab();
		Thread.sleep(1000);
		this.verify_Workroom_DrpDwn();
		this.click_Workroom_DrpDwn();
		Thread.sleep(1000);
		this.verify_Marvel_Woorkroom();
		this.click_To_Add_Marvel_Workroom(); // add marvel from workroom
		Thread.sleep(1000);
		this.click_SaveBtn_Profile();
		Thread.sleep(1500);
		this.verify_Profile_Save_Message();
		driver.navigate().refresh();
		this.verify_Settings();
		System.out.println("------- Completed --> add_Test_User_To_A_Workroom() -----------");
	}
	
	public void remove_Test_User_From_A_Workroom() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile(); //make hidden
		Thread.sleep(1000);
		this.verify_Workrooms_Tab();
		this.click_Workrooms_Tab();
		Thread.sleep(1000);
		this.verify_Marvel_Woorkroom_X();
		this.click_To_Remove_Marvel_Workroom(); // remove marvel from workroom
		Thread.sleep(1000);
		this.click_SaveBtn_Profile();
		Thread.sleep(1500);
		this.verify_Profile_Save_Message();
		driver.navigate().refresh();
		this.verify_Settings();
		System.out.println("------- Completed --> add_Test_User_To_A_Workroom() -----------");
	}
	
	public void check_Marvel_Workroom_Visible() throws InterruptedException {
		String element = "//a[contains(text(),'Marvel')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Marvel_Workroom() throws InterruptedException {
		this.verify_autoBE();
		this.check_Marvel_Workroom_Visible();
		System.out.println("------- Completed --> verify_Marvel_Workroom() -----------");
	}
	
	//-----------"Validate-User-Role-Permissions"------------
	By add_Remove_Accounts = By.xpath("//div[@class='account-name'][contains(.,'Add/Remove Accounts')]");
	By add_Remove_Accounts_Modal = By.xpath("//div[@id='addUsersModal']//div[@class='modal-header']");
	By group1 = By.xpath("//a[@class='workroom-name'][contains(.,'Group1')]");
	By nebula = By.xpath("//a[contains(text(),'Nebula')]");
	By galaxy = By.xpath("//a[contains(text(),'Galaxy')]");
	By auto_User_Admin_1_Workroom_Admin = By.xpath("//a[contains(text(),'Auto User Admin1')]/following::span[contains(.,'Workroom Administrator')]");

	public void verify_Add_Remove_Accounts() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_Remove_Accounts)));
	}
	
	public void verify_Add_Remove_Accounts_Modal() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_Remove_Accounts_Modal)));
	}
	
	public void verify_Group1() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(group1)));
	}
	
	public void verify_Nebula() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(nebula)));
	}
	
	public void verify_Galaxy() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(galaxy)));
	}
	
	public void verify_Auto_User_Admin_1_Workroom_Admin() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_User_Admin_1_Workroom_Admin)));
	}
	
	public void verify_AutoBE_Workroom_Users() throws InterruptedException {
		String workroom_Admin = "//div[contains(text(),'Workroom Admin')]";
		String workroom_Admin_Eng = "//div[contains(text(),'workroom admineng')]";
		String system_Admin_Eng = "//div[contains(text(),'system admineng')]";
		String auto_Director = "//div[contains(text(),'Auto Director')]";

		String auto_User1 = "//div[contains(text(),'Auto User1')]";
		String auto_User2 = "//div[contains(text(),'Auto User2')]";
		String auto_User3 = "//div[contains(text(),'Auto User3')]";

		Assert.assertTrue(driver.findElements(By.xpath(workroom_Admin)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(workroom_Admin_Eng)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(system_Admin_Eng)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_Director)).size() > 0);
		
		//--scroll to to bottom -----
		WebElement element = driver.findElement(By.xpath(auto_User3));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(3000);

		Assert.assertTrue(driver.findElements(By.xpath(auto_User1)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_User2)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_User3)).size() > 0);
		
	}
	
	public void verify_Group_Nebula_And_Galaxy_Users() throws InterruptedException {
		String auto_User1 = "//a[contains(text(),'Auto User1')]";
		String auto_User2 = "//a[contains(text(),'Auto User2')]";
		String auto_User3 = "//a[contains(text(),'Auto User3')]";

		Assert.assertTrue(driver.findElements(By.xpath(auto_User1)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_User2)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_User3)).size() > 0);
	}
	
	public void click_Add_Remove_Accounts() {
		driver.findElement(add_Remove_Accounts).click();
	}
	
	public void click_Group1() {
		driver.findElement(group1).click();
	}
	
	public void click_Nebula() {
		driver.findElement(nebula).click();
	}
	
	public void click_Galaxy() {
		driver.findElement(galaxy).click();
	}
	
	public void verify_AutoBE_Add_Remove_Accounts_Visible() throws InterruptedException {
		this.verify_autoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Add_Remove_Accounts();
		System.out.println("------- Completed --> verify_AutoBE_Add_Remove_Remove_Accounts_Visible() -----------");
	}
	
	public void verify_AutoBE_User_Accounts_Visible() throws InterruptedException {
		this.click_Add_Remove_Accounts();
		Thread.sleep(1000);
		this.verify_Add_Remove_Accounts_Modal();
		this.verify_AutoBE_Workroom_Users();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_AutoBE_User_Accounts_Visible() -----------");
	}
	
	public void verify_Group1_Nebula() throws InterruptedException {
		this.verify_Group1();
		this.click_Group1();
		Thread.sleep(1000);
		this.verify_Nebula();
		this.click_Nebula();
		Thread.sleep(1000);
		this.verify_Auto_User_Admin_1_Workroom_Admin();
		this.verify_Group_Nebula_And_Galaxy_Users();
		System.out.println("------- Completed --> verify_Group1_Nebula() -----------");
	}
	
	public void verify_Group1_Galaxy() throws InterruptedException {		
		this.click_Galaxy();
		Thread.sleep(1000);
		this.verify_Auto_User_Admin_1_Workroom_Admin();
		this.verify_Group_Nebula_And_Galaxy_Users();
		System.out.println("------- Completed --> verify_Group1_Galaxy() -----------");
	}
	
	public void Auto_Admin3_Verify_All_Directory_Users() throws InterruptedException {
		String workroom_Admin_Eng = "//a[contains(text(),'workroom admineng')]";
		String system_Admin_Eng = "//a[contains(text(),'system admineng')]";
		String auto_Director = "//a[contains(text(),'Auto Director')]";
		String wanda_Martin = "//a[contains(text(),'Wanda Martin')]";
		String test_Rest = "//a[contains(text(),'Test Reset')]";
		String steve_System = "//a[contains(text(),'steve System')]";

		String autoAdmin1 = "//a[contains(text(),'Auto User Admin1')]";
		String autoAdmin3 = "//td[@class='modal-cell']//a[contains(text(),'Auto User Admin3')]";
		String auto_User1 = "//td[@class='modal-cell']//a[contains(text(),'Auto User1')]";
		String auto_User2 = "//td[@class='modal-cell']//a[contains(text(),'Auto User2')]";
		String auto_User3 = "//td[@class='modal-cell']//a[contains(text(),'Auto User3')]";

		Assert.assertTrue(driver.findElements(By.xpath(workroom_Admin_Eng)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(system_Admin_Eng)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_Director)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(wanda_Martin)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(test_Rest)).size() > 0);

		//--scroll to to bottom -----
		WebElement element = driver.findElement(By.xpath(auto_User3));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		
		Assert.assertTrue(driver.findElements(By.xpath(steve_System)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(autoAdmin1)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(autoAdmin3)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_User1)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_User2)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_User3)).size() > 0);
		
	}
	
	public void Auto_Admin3_Verify_All_Users_In_Directory() throws InterruptedException {		
		this.verify_Workroom_Admin();
		Thread.sleep(1000);
		this.Auto_Admin3_Verify_All_Directory_Users();
		driver.navigate().refresh();
		System.out.println("------- Completed --> Auto_Admin3_Verify_All_Users_In_Directory() -----------");
	}
		
	
	
	
}
