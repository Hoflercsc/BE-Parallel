package page_critical_scenarios;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import parallel.DriverFactory;
import tests_critical_scenarios.BaseTestCriticalScenarios;

public class EventPage extends BaseTestCriticalScenarios {
	
	
	// ----------- POM Page Object model -----------------------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By eventsMenu = By.xpath("//span[@class='icon icon_wr-events active-off']");
	By newEventBtn = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Event')]");
	By event_Form_Title = By.xpath("//input[@id='event_title']");

	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void verify_Events_Menu() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(eventsMenu)));
	}

	public void verify_New_Event_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newEventBtn)));
	}

	public void verify_Form_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Form_Title)));
	}

	public void click_AutoBE() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(autoBE).click();
	}

	public void click_Events_Menu() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(eventsMenu).click();
	}

	public void click_New_Event_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(newEventBtn).click();
	}

	// ---------Function being called ------
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		this.verify_Events_Menu();
		this.click_Events_Menu();
		this.verify_New_Event_Btn();
		System.out.println("------- Completed --> user_Can_Open_Events_for_Workroom() -----------");
	}
	// -------------Create Event populate Form---------------------------------
	By form_Location = By.xpath("//input[@id='event_location']");
	By form_Address1 = By.xpath("//input[@id='event_address1']");
	By form_Address2 = By.xpath("//input[@id='event_address2']");
	By form_City = By.xpath("//input[@id='event_city']");
	By country_Option = By.xpath(
			"//div[@class='btn-group bootstrap-select chosen country']//span[@class='filter-option pull-left'][contains(text(),'Select an Option')]");
	By state_Option = By
			.xpath("//div[@class='btn-group bootstrap-select chosen state']//span[@class='filter-option pull-left'][contains(text(),'State')]");
	By zipCode = By.xpath("//input[@id='event_zip']");
	By meeting_Option = By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']");
	By form_Top_SaveBtn = By.xpath("//aside//button[@name='button'][contains(text(),'Save')]");
	By eventCatagory = By.xpath(
			"//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']//*[contains(text(),'Select an Option')]");
	By meetings = By.xpath("//span[contains(text(),'Meetings')]");
	By event_Title = By.xpath("//h1[contains(text(),'Create Edit Delete Event')]");
	By facilitator_Name = By.xpath("//input[@id='event_contact']");
	By facilitator_Email = By.xpath("//input[@id='event_email']");
	By website = By.xpath("//input[@id='event_website']");
	String meeting = "Meeting";

	public void click_Form_SaveBtn_Top() throws InterruptedException {
		WebElement SaveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(form_Top_SaveBtn).click();
	}

	public void new_Event_Form_Populate() throws InterruptedException {
		String location = "cool location";
		String address_1 = "22 Smith Street";
		String address_2 = "apt 335";
		String city = "Charlotte";
		String zipcode = "28217";
		String facilitator = "Someone";
		String facilitator_email = "Someone@diligent.com";
		String Website = "https://www.diligent.com";
		String event_Name = "Create Edit Delete Event";
		
		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(event_Name);
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_Location).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_Address1).sendKeys(address_1);
		DriverFactory.getInstance().getDriver().findElement(form_Address2).sendKeys(address_2);
		DriverFactory.getInstance().getDriver().findElement(form_City).sendKeys(city);

		Select country = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_country']")));
		country.selectByVisibleText("United States");
		Thread.sleep(1000);

		Select state = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_state']")));
		state.selectByVisibleText("Virginia");
		Thread.sleep(1000);
		
		// ------------------------
		DriverFactory.getInstance().getDriver().findElement(zipCode).sendKeys(zipcode);
		// ---------------------switching to iframe-----------------
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("This is a new event");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		// --------------------select photo path -------------------------
		String input = "//input[@id='event_photo']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = DriverFactory.getInstance().getDriver().findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
		DriverFactory.getInstance().getDriver().findElement(facilitator_Name).sendKeys(facilitator);
		DriverFactory.getInstance().getDriver().findElement(facilitator_Email).sendKeys(facilitator_email);
		DriverFactory.getInstance().getDriver().findElement(website).sendKeys(Website);
		// ------------------- Event Category (Scroll into View)
		// --------------------------
		WebElement eventcatagory = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", eventcatagory);
		// ---Event Catagory
		DriverFactory.getInstance().getDriver().findElement(eventCatagory).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(meetings).click();
	}

	
	public void verify_New_Event_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title)));
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Event() throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_Form_Populate();
		Thread.sleep(2000);
		this.click_Form_SaveBtn_Top();
		this.verify_New_Event_Title();
		System.out.println("------- Completed --> user_Can_Create_New_Event() -----------");
	}
	
	// --------------User Can Edit Event---------------------------------
	By editOption = By.xpath("//a[@class='btn btn-info no-mobile'][contains(text(),'Edit')]");
	By event_Title_Updated_Message = By.xpath("//p[contains(text(),'This is an Edited Event Titl')]");
	String form_Title_Name_Update = " This is an Edited Event Title ";

	public void verify_Event_Title_Update_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title_Updated_Message)));
	}

	public void click_Edit_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(editOption).click();
	}

	public void new_Event_Form_Populate_2() throws InterruptedException {
		String location = "Hot location";
		String address_1 = "20 Becker Street";
		String address_2 = "apt 757";
		String city = "Concord";
		String zipcode = "28222";
		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).clear();
		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(form_Title_Name_Update);
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_Location).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		DriverFactory.getInstance().getDriver().findElement(form_Address1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_Address1).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Address1).sendKeys(address_1);
		DriverFactory.getInstance().getDriver().findElement(form_Address2).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_Address2).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Address2).sendKeys(address_2);
		DriverFactory.getInstance().getDriver().findElement(form_City).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_City).clear();
		DriverFactory.getInstance().getDriver().findElement(form_City).sendKeys(city);
		DriverFactory.getInstance().getDriver().findElement(zipCode).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(zipCode).clear();
		DriverFactory.getInstance().getDriver().findElement(zipCode).sendKeys(zipcode);
		// ---------------------switching to iframe-----------------
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("This is an Edited Event Title");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}

	public void verify_Address_Changes() throws InterruptedException {
		String updated_Location = "//div[@class='location']//*[contains(text(),'Hot location')]";
		String updated_Address = "//*[contains(text(),'20 Becker Street')]";
		String updated_Apt_Num = "//*[contains(text(),'apt 757')]";
		String updated_State_Zip = "//*[contains(text(),'VA 28222')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(updated_Location)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(updated_Address)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(updated_Apt_Num)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(updated_State_Zip)).size() > 0);
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Edit_Event() throws InterruptedException {
		this.click_Edit_Option();
		this.verify_Form_Title();
		this.new_Event_Form_Populate_2();
		this.click_Form_SaveBtn_Top();
		this.verify_Event_Title_Update_Message();
		Thread.sleep(2000);
		this.verify_Address_Changes();
		System.out.println("------- Completed --> user_Can_Edit_Event() -----------");
	}
	
	// --------------User Can Copy Event ---------------------------
	By copy_Event_Btn = By.xpath("//a[@class='btn btn-success no-mobile'][contains(text(),'Copy')]");
	By copy_Event_Message = By.xpath("//p[contains(text(),'This is an Edited Event Titl')]");
	By saveBtn = By.xpath("//aside//button[@name='button'][contains(text(),'Save')]");
	By edited_Event_Copy_Message = By.xpath("//p[contains(text(),'This is an Edited Event Titl')]");

	public void verify_Copy_Event_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(copy_Event_Message)));
	}

	public void verify_Edited_Event_Copy_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Event_Copy_Message)));
	}

	public void click_Copy_Event_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(copy_Event_Btn).click();
	}

	public void click_Save_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Copy_Event() throws InterruptedException {
		this.click_Copy_Event_Btn();
		this.verify_Copy_Event_Message();
		this.click_Save_Btn();
		this.verify_Edited_Event_Copy_Message();
		System.out.println("------- Completed --> user_Can_Copy_Event() -----------");
	}
	// --------------User Can Delete Copied Event ---------------------------
	By deleteBtn = By.xpath("//a[@class='btn btn-danger no-mobile'][contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");
	By delete_Event_Message = By.xpath("//p[contains(text(),'Successfully deleted Event')]");

	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void verify_Delete_Event_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Event_Message)));
	}

	public void click_DeleteBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(deleteBtn).click();
	}

	public void click_ContinueBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Delete_Copied_Event() throws InterruptedException {
		this.click_DeleteBtn();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		this.verify_Delete_Event_Message();
		System.out.println("------- Completed --> user_Can_Delete_Copied_Event() -----------");
	}
	
	// --------------User Can Delete Event ---------------------------
	By event_Dropdown_Arrow = By.xpath("(//a[contains(text(),'This is an Edited Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By delete_Option = By.xpath("//a[contains(.,'Delete')]");

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void click_Event_Dropdown_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_Dropdown_Arrow).click();
	}

	public void verify_Event_Deleted() throws InterruptedException {
		String event = "(//*[contains(text(),'This is an Edited Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}

	public void click_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(delete_Option).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Delete_Event() throws InterruptedException {
		this.click_Event_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(2000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		this.verify_Delete_Event_Message();
		Thread.sleep(3000);
		this.verify_Delete_Event_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2500);
		this.verify_Event_Deleted();
		System.out.println("------- Completed --> user_Delete_Event_And_Verify_Deleted() -----------");
	}
}
