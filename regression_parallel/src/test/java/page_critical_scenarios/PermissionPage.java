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
import page_common_functions.AtlasNavBar;
import parallel.DriverFactory;
import tests_critical_scenarios.BaseTestCriticalScenarios;

public class PermissionPage {
	// ----------- POM Page Object model -----------------------------
	
	By settings = By.xpath("//span[contains(text(),'Settings')]");
	By workroom_Groups = By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]");

	
	// --------------user_Opens_Settings_Opens_Workroom_And_Group_Settings--------------
	public void verify_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings)));
	}

	public void verify_Manage_Workrooms_Groups() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Groups)));
	}

	public void click_SettingsBtn() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(),'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Manage_Workroom_Groups() {
		DriverFactory.getInstance().getDriver().findElement(workroom_Groups).click();
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
	
	// --------------systemAdmin_Can_Set_User_As_Workroom_Member---------
	By autoBE_Expand = By.xpath("//a[@class='collapsed committee-collapse placeholder'][contains(text(),'AutoBE')]");
	By remove_Admin_Option = By.xpath("//a[contains(text(),'Remove Admin')]");
	By remove_Admin_Option_WorkroomAdmin = By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']/span/following::ul//child::a[contains(text(),'Remove Admin')])[1]");
	By remove_Admin_Option_WorkroomAdminEng = By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'workroom admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']/span/following::ul//child::a[contains(text(),'Remove Admin')])[1]");
	By remove_Admin_Option_WorkroomAdminEng2 = By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'workroom admineng2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']/span/following::ul//child::a[contains(text(),'Remove Admin')])[1]");

	By autoBE_Collapse = By.xpath("//a[@class='committee-collapse placeholder']");

	public void verify_AutoBE_Expand() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Expand)));
	}

	public void verify_Remove_Admin_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(remove_Admin_Option)));
	}
	
	public void verify_Workroom_Admin_Remove_Admin_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(remove_Admin_Option_WorkroomAdmin)));
	}
	
	public void verify_WorkroomAdminEng_Remove_Admin_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(remove_Admin_Option_WorkroomAdminEng)));
	}
	
	public void verify_WorkroomAdminEng2_Remove_Admin_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(remove_Admin_Option_WorkroomAdminEng2)));
	}
	
	

	public void click_AutoBE_Expand() {
		// DriverFactory.getInstance().getDriver().findElement(autoBE_Expand).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='collapsed committee-collapse placeholder'][contains(text(),'AutoBE')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	public void click_Remove_Admin_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Remove Admin')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(remove_Admin_Option).click();
	}
	
	public void click_Workroom_Admin_Remove_Admin_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(remove_Admin_Option_WorkroomAdmin);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(remove_Admin_Option_WorkroomAdmin).click();
	}
	
	public void click_WorkroomAdminEng_Remove_Admin_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(remove_Admin_Option_WorkroomAdminEng);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(remove_Admin_Option_WorkroomAdminEng).click();
	}
	
	public void click_WorkroomAdminEng2_Remove_Admin_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(remove_Admin_Option_WorkroomAdminEng);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(remove_Admin_Option_WorkroomAdminEng2).click();
	}

	public void verify_If_Workroom_Admin_Exist() throws InterruptedException {
		String workroomadmin = "(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		boolean workroomAdmin = DriverFactory.getInstance().getDriver().findElements(By.xpath(workroomadmin)).size() != 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (workroomAdmin == true) {
			WebElement element = DriverFactory.getInstance().getDriver().findElement(
					By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
			((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(1000);
			DriverFactory.getInstance().getDriver().findElement(By.xpath(workroomadmin)).click();
			Thread.sleep(1000);
			this.verify_Remove_Admin_Option();
			this.click_Remove_Admin_Option();
			Thread.sleep(2000);
		}
	}

	public void click_AutoBE_Collapse() {
		DriverFactory.getInstance().getDriver().findElement(autoBE_Collapse).click();
	}
	
	// ------------------systemAdmin_Restrict_User_Access_From_Events-----------
	//By workroom_Admin_Dropdown = By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By workroom_Admin_Dropdown = By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By test_User_Dropdown = By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By set_Permissions_Option = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Set Permissions')]");
	By workroom_Admin_Eng_Dropdown = By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'workroom admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By workroom_Admin_Eng_2_Dropdown = By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'workroom admineng2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By events = By.xpath("//div[@id='collapseWorkroom_2305']//div[@class='row small-left']//label[contains(text(),'Events')]");
	By events_B = By.xpath("//div[@id='collapseWorkroom_3052']//div[@class='row small-left']//label[contains(text(),'Events')]");
	By saveBtn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");

	public void verify_Workroom_Admin_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Dropdown)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Workroom_Admin_Eng_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Eng_Dropdown)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Eng_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Workroom_Admin_Eng_2_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Eng_2_Dropdown)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Eng_2_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Test_User_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(test_User_Dropdown)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}

	public void verify_Set_Permissions_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(set_Permissions_Option)));
	}

	public void verify_Events() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(events)));
		
		//WebElement element = driver.findElement(By.xpath("//a[@class='active'][contains(text(),'AutoBE')]"));
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//body/div[@id='profileModal']//div/form//div/a[contains(text(),'AutoBE')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Events_B() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(events_B)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='active'][contains(text(),'AutoBE')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Events_C() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(events_B)));
		
		//WebElement element = driver.findElement(By.xpath("//input[@id='can_access_events_3052']"));
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='profileModal']//div/form//a[contains(.,'AutoBE')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}

	public void click_Workroom_Admin_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Dropdown).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Test_User_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(test_User_Dropdown).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	public void click_Set_Permissions_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Set Permissions')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		// DriverFactory.getInstance().getDriver().findElement(set_Permissions_Option).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Set Permissions')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	public void click_Workroom_Admin_Eng_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'workroom admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Dropdown).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'workroom admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Workroom_Admin_Eng_2_Dropdown() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Eng_2_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Dropdown).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Eng_2_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Events() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='can_access_events_2305']"));

		if ((element.isSelected())) {
			Thread.sleep(1000);
			//element.click();
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
		}
	}

	public void click_Events_2() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='can_access_events_2305']"));

		if ((!element.isSelected())) {
			Thread.sleep(1000);
			//element.click();
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
		}
	}
	
	public void click_Events_B() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='can_access_events_3052']"));

		if ((element.isSelected())) {
			Thread.sleep(1000);
			//element.click();
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
		}
	}

	public void scoll_And_Click_SaveBtn() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	// --------------Function Being Called ---------------------------
	public void systemAdmin_Restrict_User_Access_From_Events() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(1500);
		this.verify_Workroom_Admin_Dropdown();
		this.click_Workroom_Admin_Dropdown();
		Thread.sleep(2000);
		this.verify_Set_Permissions_Option();
		this.click_Set_Permissions_Option();
		Thread.sleep(2000);
		
		String url = DriverFactory.getInstance().getDriver().getCurrentUrl();
		String ozzie = "automation-ozzie.boardeffect.com";
		String lab = "lab-automation.boardeffect.com";
		
		if (url.contains(ozzie)) {
			this.verify_Events();
			this.click_Events();
		}else if(url.contains(lab)){
			this.verify_Events_C();
			this.click_Events_B();
		}else {
			this.verify_Events_B();
			this.click_Events_B();
		}
		
		Thread.sleep(2000);
		this.scoll_And_Click_SaveBtn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> systemAdmin_Restrict_User_Access_From_Events() -----------");
		System.out.println("------- Completed --> systemAdmin_Restrict_User_Access_From_Events() -----------");
	}
	
	// ---------------------------------systemAdmin_Close_And_Logout-----------------------------------
	By close_Settings = By.xpath("//a[@id='settingsModalClose']");
	By user_Profile_Dropdown = By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By sign_Out = By.xpath("//a[contains(text(),'Sign Out')]");

	public void verify_Close_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(close_Settings)));
	}

	public void verify_User_Profile_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Profile_Dropdown)));
	}

	public void verify_Sign_Out() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sign_Out)));
	}

	public void click_Close_Settings() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@id='settingsModalClose']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@id='settingsModalClose']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
		// DriverFactory.getInstance().getDriver().findElement(close_Settings).click();
	}

	public void click_User_Profile_Dropdown() {
		// DriverFactory.getInstance().getDriver().findElement(user_Profile_Dropdown).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	public void click_Sign_Out() {
		// DriverFactory.getInstance().getDriver().findElement(sign_Out).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	// --------------Function Being Called ---------------------------
	public void systemAdmin_Close_And_Logout() throws InterruptedException {
		this.verify_Close_Settings();
		this.click_Close_Settings();
		Thread.sleep(2000);
		this.verify_User_Profile_Dropdown();
		this.click_User_Profile_Dropdown();
		Thread.sleep(1000);
		this.verify_Sign_Out();
		this.click_Sign_Out();
		Thread.sleep(1500);
		System.out.println("------- Completed --> systemAdmin_Close_And_Logout() -----------");
	}
	
	// ---------------workroom_Admin_Not_See_Event_Due_To_Permissions---------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By library = By.xpath("//span[contains(text(),'Library')]");

	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void verify_Libary() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library)));
	}

	public void click_AutoBE() {
		// DriverFactory.getInstance().getDriver().findElement(autoBE).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'AutoBE')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	public void assert_Event_Not_Exist() throws InterruptedException {
		String element = "//span[contains(text(),'Events')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}

	// --------------Function Being Called ---------------------------
	public void workroom_Admin_Not_See_Event_Due_To_Permissions() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE_Library_Page();
		Thread.sleep(2000);
		this.assert_Event_Not_Exist();
		System.out.println("------- Completed --> workroom_Admin_Not_See_Event_Due_To_Permissions() -----------");
	}

	// --------------Function Being Called ---------------------------
	public void workroom_Member_Can_Logout() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.user_Can_Sign_Out();
		Thread.sleep(1500);
		System.out.println("------- Completed --> workroom_User_Can_Logout() -----------");
	}
	
	// --------------systemAdmin_Enable_Events_For_Workroom_Member---------------
	// --------------Function Being Called ---------------------------
	public void systemAdmin_Enable_Events_For_Workroom_Member() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.click_Workroom_Admin();
		Thread.sleep(2000);
		this.verify_Set_Permissions_Option();
		this.click_Set_Permissions_Option();
		Thread.sleep(2000);
		this.verify_Events();
		this.click_Events_2();
		Thread.sleep(2000);
		this.scoll_And_Click_SaveBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> systemAdmin_Enable_Events_For_Workroom_Member() -----------");
	}
	
	// ---------------------------------workroom_Member_Sees_Event_Due_To_Permissions--------------------------
	By Events = By.xpath("//span[contains(text(),'Events')]");

	public void verify_Events_Cat() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(Events)));
	}

	// --------------Function Being Called ---------------------------
	public void workroom_Member_Sees_Event_Due_To_Permissions() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE_Library_Page();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_Events_Cat();
		System.out.println("------- Completed --> workroom_Admin_Not_See_Event_Due_To_Permissions() -----------");
	}
	
	// ---------------systemAdmin_Set_User_As_Workroom_Admin-----------
	By make_Admin = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Make Admin')]");
	By make_Admin_Option_Workroom_Admin = By.xpath("(//a[contains(text(),'Workroom Admin')]/following::ul//child::a[contains(text(),'Make Admin')])[1]");

	By workroom_Admin = By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By workroom_Admin_Moved = By.xpath("//div[@class='col-sm-12 panel-section-heading'][contains(text(),'Workroom Administrators')]/following::tr[ starts-with (@id,'settings-users-info-')]/td[2]/a");
	By make_Admin_Option_WorkroomAdminEng = By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'workroom admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']/span/following::ul//child::a[contains(text(),'Make Admin')])[1]");
	By make_Admin_Option_WorkroomAdminEng2 = By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'workroom admineng2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']/span/following::ul//child::a[contains(text(),'Make Admin')])[1]");

	public void verify_Make_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(make_Admin)));
	}
	
	public void verify_Make_Admin_Option_Workroom_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(make_Admin_Option_Workroom_Admin)));
	}
	
	public void verify_Make_Admin_Option_WorkroomAdminEng() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(make_Admin_Option_WorkroomAdminEng)));
	}
	
	public void verify_Make_Admin_Option_WorkroomAdminEng2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(make_Admin_Option_WorkroomAdminEng2)));
	}

	public void verify_WorkroomAdmin_Under_WorkroomAdministrators() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Moved)));
	}

	public void click_Workroom_Admin() {
		// DriverFactory.getInstance().getDriver().findElement(workroom_Admin).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Test_User_Drp_Dwn() {
		// DriverFactory.getInstance().getDriver().findElement(workroom_Admin).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'Test Reset')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_Make_Admin() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Make Admin')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		// DriverFactory.getInstance().getDriver().findElement(make_Admin).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Make Admin')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Make_Admin_Option_WorkroomAdmin() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(make_Admin_Option_Workroom_Admin);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		// DriverFactory.getInstance().getDriver().findElement(make_Admin).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(make_Admin_Option_Workroom_Admin);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Make_Admin_Option_WorkroomAdminEng() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(make_Admin_Option_WorkroomAdminEng);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(make_Admin).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(make_Admin_Option_WorkroomAdminEng);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Make_Admin_Option_WorkroomAdminEng2() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(make_Admin_Option_WorkroomAdminEng2);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(make_Admin).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(make_Admin_Option_WorkroomAdminEng2);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	public void click_Workroom_Admin_Eng() {
		// DriverFactory.getInstance().getDriver().findElement(workroom_Admin).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'workroom admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Workroom_Admin_Eng_2() {
		// DriverFactory.getInstance().getDriver().findElement(workroom_Admin).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'workroom admineng2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}
	

	// ----------------------------workroom_Member_Open_Library_For_Workroom_Has_New_Book_Button----------------
	By new_Book = By.xpath("//a[@class='btn btn-success no-mobile'][contains(text(),'New Book')]");

	public void verify_New_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Book)));
	}

	public void click_Library() {
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(),'Library')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	// --------------Function Being Called ---------------------------
	public void workroom_Member_Open_Library_For_Workroom_Has_New_Book_Button() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE_Library_Page();
		Thread.sleep(2000);
		this.verify_New_Book();
		System.out.println("------- Completed --> workroom_Member_Open_Library_For_Workroom_Has_New_Book_Button() -----------");
	}
	
	// --------------systemAdmin_Set_User_As_Workroom_Member--------------------
	By workroom_Admin_Under_Workroom_Member = By.xpath("//div[starts-with(@id,'collapseWorkroomSettings_')]//div[@class='row bordered']//div[@class='col-sm-12 panel-section-heading'][contains(text(),'Workroom Members')]/following::tr[ starts-with(@id,'settings-users-info-')]/td[2]/a");
	By workroom_Admin_Under_Workroom_Member_Eng = By.xpath("//div[starts-with(@id,'collapseWorkroomSettings_')]//div[@class='row bordered']//div[@class='col-sm-12 panel-section-heading'][contains(text(),'Workroom Members')]/following::tr[ starts-with(@id,'settings-users-info-')]/td[2]/a[contains(text(),'workroom admineng')]");
	By workroom_Admin_Under_Workroom_Member_Eng_2 = By.xpath("//div[starts-with(@id,'collapseWorkroomSettings_')]//div[@class='row bordered']//div[@class='col-sm-12 panel-section-heading'][contains(text(),'Workroom Members')]/following::tr[ starts-with(@id,'settings-users-info-')]/td[2]/a[contains(text(),'workroom admineng2')]");

	public void verify_Workroom_Admin_Under_Workroom_Member() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Under_Workroom_Member)));
	}
		
	public void verify_Workroom_Admin_Under_Workroom_Member_Eng() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Under_Workroom_Member_Eng)));
	}

	public void verify_Workroom_Admin_2_Under_Workroom_Member_Eng_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Under_Workroom_Member_Eng_2)));
	}
	
	// --------------Function Being Called ---------------------------
	public void systemAdmin_Set_User_As_Workroom_Member() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.verify_Workroom_Admin_Dropdown();
		this.click_Workroom_Admin_Dropdown();
		Thread.sleep(1500);
		this.verify_Workroom_Admin_Remove_Admin_Option();
		this.click_Workroom_Admin_Remove_Admin_Option();
		Thread.sleep(3000);
		this.verify_Workroom_Admin_Under_Workroom_Member();
		System.out.println("------- Completed --> systemAdmin_Set_User_As_Workroom_Member() -----------");
	}
	
	public void systemAdmin_Set_User_As_Workroom_Admin() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.click_Workroom_Admin();
		Thread.sleep(1000);
		this.verify_Make_Admin_Option_Workroom_Admin();
		this.click_Make_Admin_Option_WorkroomAdmin();
		Thread.sleep(1500);
		// -----------
		DriverFactory.getInstance().getDriver().navigate().refresh();
		
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Opens_Site_Settings_Workrooms_And_Groups();
		Thread.sleep(1500);
		// -------------
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.verify_WorkroomAdmin_Under_WorkroomAdministrators();
		//this.click_AutoBE_Collapse();
		//Thread.sleep(1500);
		System.out.println("------- Completed --> systemAdmin_Set_User_As_Workroom_Admin() -----------");
	}
	
	public void systemAdmin_Set_User_WorkroomAdminEng_As_WorkroomAdmin() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.click_Workroom_Admin_Eng();
		Thread.sleep(1000);
		this.verify_Make_Admin_Option_WorkroomAdminEng();
		this.click_Make_Admin_Option_WorkroomAdminEng();
		Thread.sleep(1500);
		// -----------
		this.click_Close_Settings();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Opens_Site_Settings_Workrooms_And_Groups();
		// -------------
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.verify_WorkroomAdmin_Under_WorkroomAdministrators();
		this.click_AutoBE_Collapse();
		Thread.sleep(1500);
		System.out.println("------- Completed --> systemAdmin_Set_User_As_Workroom_Admin() -----------");
	}
	
	public void systemAdmin_Set_User_As_WorkroomAdminEng_As_Workroom_Member() throws InterruptedException {
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.verify_Workroom_Admin_Eng_Dropdown();
		this.click_Workroom_Admin_Eng_Dropdown();
		Thread.sleep(1500);
		this.verify_WorkroomAdminEng_Remove_Admin_Option();
		this.click_WorkroomAdminEng_Remove_Admin_Option();
		Thread.sleep(4000);
		this.verify_Workroom_Admin_Under_Workroom_Member_Eng();
		System.out.println("------- Completed --> systemAdmin_Set_User_As_Workroom_Member() -----------");
	}
	
	public void systemAdmin_Set_User_WorkroomAdminEng2_As_Workroom_Admin() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.click_Workroom_Admin_Eng_2();
		Thread.sleep(1000);
		this.verify_Make_Admin_Option_WorkroomAdminEng2();
		this.click_Make_Admin_Option_WorkroomAdminEng2();
		Thread.sleep(1500);
		// -----------
		this.click_Close_Settings();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1500);
		System.out.println("------- Completed --> systemAdmin_Set_User_As_Workroom_Admin() -----------");
	}
	
	
	public void systemAdmin_Set_User_WorkroomAdminEng2_As_Workroom_Member() throws InterruptedException {
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.verify_Workroom_Admin_Eng_2_Dropdown();
		this.click_Workroom_Admin_Eng_2_Dropdown();
		Thread.sleep(1500);
		this.verify_WorkroomAdminEng2_Remove_Admin_Option();
		this.click_WorkroomAdminEng2_Remove_Admin_Option();
		Thread.sleep(3000);
		this.verify_Workroom_Admin_2_Under_Workroom_Member_Eng_2();
		System.out.println("------- Completed --> systemAdmin_Set_User_WorkroomAdminEng2_As_Workroom_Member() -----------");
	}
}
