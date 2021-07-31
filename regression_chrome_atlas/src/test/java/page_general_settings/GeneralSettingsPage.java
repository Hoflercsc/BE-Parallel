package page_general_settings;

import static org.testng.Assert.assertTrue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page_common_functions.AtlasNavBar;

public class GeneralSettingsPage {
	WebDriver driver;

	public GeneralSettingsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// ---------------user_navigates and click edit icon/ workroom news()-----------------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By general_Settings = By.xpath("//a[contains(text(),'General Settings')]");
	By look_Feel = By.xpath("//*[@id='settingsModal']//div/a[contains(.,'Look and Feel')]");
	By title = By.xpath("//input[@id='client_title']");
	By organization = By.xpath("//input[@id='client_organization']");
	By contact = By.xpath("//input[@id='client_contact']");
	By address = By.xpath("//input[@id='client_address1']");
	By city = By.xpath("//input[@id='client_city']");
	By country_DropDown = By.xpath("//span[contains(text(),'Nothing selected')]");
	By country_DropDown_2 = By.xpath("//*[starts-with(@id,'edit_client_')]//div/button[contains(.,'United States')]");
	By country_Selection = By.xpath("//*[starts-with(@id,'edit_client_')]//div/ul/li[2]//span[contains(.,'United States')]");
	By country_Select_Null = By.xpath("//*[starts-with(@id,'edit_client_')]//div[8]/div/div/div[1]/div/div/ul/li[1]/a");

	By state_Dropdown = By.xpath("//*[@id='order_state_code_wrapper']/div/button/span[1]");
	By state_Selection = By.xpath("//*[@id='order_state_code_wrapper']//div/ul/li[56]/a[contains(.,'Virginia')]");
	By state_Select_Null = By.xpath("//*[@id='order_state_code_wrapper']/input");

	By zip = By.xpath("//input[@id='client_zip']");
	By phone = By.xpath("//input[@id='client_phone']");
	By fax = By.xpath("//input[@id='client_fax']");
	By website = By.xpath("//input[@id='client_website']");
	By email = By.xpath("//input[@id='client_email']");
	By form_SaveBtn = By.xpath("//*[starts-with(@id,'edit_client_')]/div/div/button[contains(.,'Save')]");
	By portal_Save_Message = By.xpath("//p[contains(text(),'Successfully saved portal settings.')]");
	
	String title_ = "This is a Title";
	String organization_ = "Organization";
	String contact_ = "Bill Gates";
	String address_ = "6533 Diesel Ct";
	String city_ = "Norfolk";
	String state_ = "Virginia";
	String zip_ = "23513";
	String phone_ = "7578536731";
	String fax_ = "7578536731";
	String website_ = "www.cnn.com";
	String email_ = "someone@gmail.com";

	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}
	
	public void verify_General_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(general_Settings)));
	}
	
	public void verify_Look_Feel() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(look_Feel)));
	}
	
	public void verify_Country_Selection() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(country_Selection)));
	}
	
	public void verify_State_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(state_Dropdown)));
	}
	
	public void verify_Portal_Save_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(portal_Save_Message)));
	}
	
	public void verify_State_Select_Null() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(state_Select_Null)));
	}
	
	public void scroll_To_Settings_Header() {
		WebElement element = driver.findElement(By.xpath("//body/div[@id='settingsModal']/div[1]/div[1]/div[1]/h1[contains(.,'Settings')]]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void click_AutoBE() {
		driver.findElement(autoBE).click();
	}
	
	public void click_General_Settings() {
		driver.findElement(general_Settings).click();
	}
	
	public void click_Form_SaveBtn() {
		driver.findElement(form_SaveBtn).click();
	}

	public void navigate_To_General_Settings() throws InterruptedException {
		this.verify_General_Settings();
		this.click_General_Settings();
		Thread.sleep(1000);
		this.verify_Look_Feel();
		System.out.println("------- Completed --> user_Can_Fill_Out_Basic_Information() -----------");
	}
	
	public void fill_Basic_Information_Form() throws InterruptedException {
		//driver.findElement(title).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(title).clear();
		driver.findElement(title).sendKeys(title_);
		
		driver.findElement(organization).clear();
		driver.findElement(organization).sendKeys(organization_);
		
		driver.findElement(contact).clear();
		driver.findElement(contact).sendKeys(contact_);
		
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys(address_);
		
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(city_);
		//--------Country----------
		driver.findElement(country_DropDown).click();
		Thread.sleep(1000);
		this.verify_Country_Selection();
		driver.findElement(country_Selection).click();
		Thread.sleep(1000);
		//--------State------------
		this.verify_State_Dropdown();
		driver.findElement(state_Dropdown).click();
		Thread.sleep(1500);
		//scroll to Virginia
		WebElement element = driver.findElement(By.xpath("//*[@id='order_state_code_wrapper']//div/ul/li[56]/a[contains(.,'Virginia')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		driver.findElement(state_Selection).click();
		Thread.sleep(1000);
		
		driver.findElement(zip).clear();
		driver.findElement(zip).sendKeys(zip_);
		
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys(phone_);
		
		driver.findElement(fax).clear();
		driver.findElement(fax).sendKeys(fax_);
		
		driver.findElement(website).clear();
		driver.findElement(website).sendKeys(website_);
		
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(email_);
	}
	
	public void verify_Saved_Form_Data() throws InterruptedException {
		boolean Title = driver.findElement(title).getAttribute("value").contains(title_);
		boolean Organization = driver.findElement(organization).getAttribute("value").contains(organization_);
		boolean Address = driver.findElement(address).getAttribute("value").contains(address_);
		boolean City = driver.findElement(city).getAttribute("value").contains(city_);
		boolean Zip = driver.findElement(zip).getAttribute("value").contains(zip_);

		Assert.assertTrue(Title);
		Assert.assertTrue(Organization);
		Assert.assertTrue(Address);
		Assert.assertTrue(City);
		Assert.assertTrue(Zip);
	}
	
	public void clear_Information_Form() throws InterruptedException {
		
//		driver.findElement(title).sendKeys(Keys.chord(Keys.CONTROL, "a"));
//		driver.findElement(title).clear();

		driver.findElement(organization).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(organization).clear();
		
		driver.findElement(contact).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(contact).clear();

		driver.findElement(address).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(address).clear();

		
		driver.findElement(city).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(city).clear();
		
		//--------Country----------
		driver.findElement(country_DropDown_2).click();
		Thread.sleep(1000);
		this.verify_Country_Selection();
		driver.findElement(country_Select_Null).click();//--null
		Thread.sleep(1000);
		//--------State------------
		this.verify_State_Select_Null();//--null

		driver.findElement(zip).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(zip).clear();
		
		driver.findElement(phone).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(phone).clear();
		
		driver.findElement(fax).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(fax).clear();
		
		driver.findElement(website).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(website).clear();

		driver.findElement(email).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(email).clear();
		
		this.click_Form_SaveBtn();
	}
	
	// --------------------------Function Being Called--------------
	public void user_Can_Fill_Out_Basic_Information() throws InterruptedException {
		this.fill_Basic_Information_Form();
		this.click_Form_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		//this.scroll_To_Settings_Header();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Fill_Out_Basic_Information() -----------");
	}
	
	public void clear_Basic_Info_Form() throws InterruptedException {
		this.clear_Information_Form();
		Thread.sleep(1000);
		this.click_Form_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		System.out.println("------- Completed --> user_Can_Fill_Out_Basic_Information() -----------");
	}
	
	//----------Look_and_Feel---------
	By look_Feel_Header = By.xpath("//h1[contains(text(),'Look and Feel')]");
	By display_Directory_Columns = By.xpath("//body/div[@id='clientLookFeel']//div/form[1]/h4[1][contains(.,'Directory Display Columns')]");
	By lf_SaveBtn = By.xpath("//body//div[@id='clientLookFeel']//div/button[2][contains(.,'Save')]");
	By display_Columns_Btn = By.xpath("(//body/div[@id='clientLookFeel']//div/form[1]/h4[1][contains(.,'Directory Display Columns')]/following::button)[1]");
	//By display_Columns_Btn = By.xpath("//body/div[@id='clientLookFeel']//form[1]/div[9]//button[1]");
	//By display_Columns_Btn = By.xpath("//body/div[@id='clientLookFeel']//form[1]/div[9]//button[1]");

	//By display_Columns_PDF_Btn = By.xpath("//body/div[@id='clientLookFeel']//form[1]/div[10]//button[1]");
	//By display_Columns_PDF_Btn = By.xpath("//body/div[@id='clientLookFeel']//form[1]/div[10]//button[1]");
	By display_Columns_PDF_Btn = By.xpath("(//body/div[@id='clientLookFeel']//h4[contains(text(),'Directory Display Columns for PDF')]/following::button)[1]");

	By role = By.xpath("//*[starts-with(@id,'edit_client_')]/div[8]//ul/li[contains(.,'Role')]");
	//By role = By.xpath("//*[starts-with(@id,'edit_client_')]/div[9]//ul/li[contains(.,'Role')]");
	//By role_2 = By.xpath("//*[starts-with(@id,'edit_client_')]/div[10]//ul/li[contains(.,'Role')]");
	By role_2 = By.xpath("//*[starts-with(@id,'edit_client_')]/h4[contains(text(),'Directory Display Columns for PDF')]/following::div[@class='dropdown-menu open']/ul/li[contains(.,'Role')]");

	By role_Tag = By.xpath("//body/div[@id='clientLookFeel']//form[1]//div[8]//span[4][contains(.,'Role')]");
	//By role_Tag = By.xpath("//body/div[@id='clientLookFeel']//form[1]//div[9]//span[4][contains(.,'Role')]");
	By role_Tag_2 = By.xpath("//body/div[@id='clientLookFeel']//form[1]//div[9]//span[6][contains(.,'Role')]");

	By plus_Sign = By.xpath("//body/div[@id='clientLookFeel']//form[1]/div[8]//i[@class='fa fa-plus-circle fa-2x']");
	//By plus_Sign = By.xpath("//body/div[@id='clientLookFeel']//form[1]/div[9]//i[@class='fa fa-plus-circle fa-2x']");
	By plus_Sign_2 = By.xpath("//body/div[@id='clientLookFeel']//form[1]/div[9]//i[@class='fa fa-plus-circle fa-2x']");

	By column_Role = By.xpath("//th[contains(text(),'Role')]");

	
	public void verify_Look_Feel_Header() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(look_Feel_Header)));
	}
	
	public void verify_Role() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(role)));
	}
	
	public void verify_Role_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(role_2)));
	}
	
	public void verify_Role_Tag_2_Disabled() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(role_Tag_2)));
	}
	
	public void verify_Column_Role() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(column_Role)));
	}
	
	public void verify_Column_Role_Disable() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.invisibilityOfElementLocated(column_Role)));
	}
	
	public void scroll_To_Display_Columns() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//body/div[@id='clientLookFeel']//div/form[1]/h4[1][contains(.,'Directory Display Columns')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void click_Look_Feel() {
		driver.findElement(look_Feel).click();
	}
	
	public void click_Display_Directory_CheckBox() {
		WebElement box = driver.findElement(By.xpath("//input[@id='client_enable_directory_groups']"));

		if (!box.isSelected()) {
			//WebElement element = driver.findElement(By.xpath("//input[@id='feature_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", box);
		}
	}
	
	public void disable_Display_Directory_CheckBox() {
		WebElement box = driver.findElement(By.xpath("//input[@id='client_enable_directory_groups']"));

		if (box.isSelected()) {
			//WebElement element = driver.findElement(By.xpath("//input[@id='feature_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", box);
		}
	}
	
	public void enable_Directory_Excel_Export_Checkbox() {
		WebElement box = driver.findElement(By.xpath("//input[@id='client_directory_excel_export']"));

		if (!box.isSelected()) {
			//WebElement element = driver.findElement(By.xpath("//input[@id='feature_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", box);
		}
	}
	
	public void disable_Directory_Excel_Export_Checkbox() {
		WebElement box = driver.findElement(By.xpath("//input[@id='client_directory_excel_export']"));

		if (box.isSelected()) {
			//WebElement element = driver.findElement(By.xpath("//input[@id='feature_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", box);
		}
	}
	
	public void click_LF_SaveBtn() {
		driver.findElement(lf_SaveBtn).click();
	}
	
	public void click_Display_Columns_Btn() {
		driver.findElement(display_Columns_Btn).click();
	}
	
	public void click_Display_Columns_PDF_Btn() {
		driver.findElement(display_Columns_PDF_Btn).click();
	}
	
	public void click_Role_Option() {
		driver.findElement(role).click();
	}
	
	public void click_Role_Option_2() {
		driver.findElement(role_2).click();
	}
	
	public void click_Plus_Sign() {
		driver.findElement(plus_Sign).click();
	}
	
	public void click_Plus_Sign_2() {
		driver.findElement(plus_Sign_2).click();
	}
	
	public void click_Role_Tag() {
		driver.findElement(role_Tag).click();
	}
	
	public void click_Role_Tag_2() {
		driver.findElement(role_Tag_2).click();
	}
	
	public void verify_Each_User_Catergory() throws InterruptedException {
		String staffMember = "//a[contains(text(),'Staff Member')]";
		String boardMember = "//a[contains(text(),'Board Member')]";
		String guest = "//a[contains(text(),'Guest')]";
		Assert.assertTrue(driver.findElements(By.xpath(staffMember)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(boardMember)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(guest)).size() > 0);
		System.out.println("------- Completed --> verify_Each_User_Catergory() -----------");
	}
	
	public void navigate_To_General_Look_Feel() throws InterruptedException {
		this.verify_General_Settings();
		this.click_General_Settings();
		Thread.sleep(1000);
		this.verify_Look_Feel();
		this.click_Look_Feel();
		Thread.sleep(1000);
		this.verify_Look_Feel_Header();
		System.out.println("------- Completed --> navigate_To_General_Settings_2() -----------");
	}
	
	public void select_Display_Columns_By_User_Catergory() throws InterruptedException {
		this.scroll_To_Display_Columns();
		this.click_Display_Directory_CheckBox();
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> select_Display_Columns_By_User_Catergory() -----------");
	}
	
	public void set_Directory_Display_Columns() throws InterruptedException {
		this.scroll_To_Display_Columns();
		this.click_Display_Columns_Btn();
		Thread.sleep(1000);
		this.verify_Role();
		this.click_Role_Option();
		Thread.sleep(1000);
		this.click_Plus_Sign();
		Thread.sleep(2000);
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> set_Directory_Display_Columns() -----------");
	}
	
	public void disable_Directory_Display_Columns() throws InterruptedException {
		this.scroll_To_Display_Columns();
		Thread.sleep(1000);
		this.click_Role_Tag();
		Thread.sleep(1000);
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> set_Directory_Display_Columns() -----------");
	}
	
	public void set_Directory_Display_Columns_For_PDF() throws InterruptedException {
		this.scroll_To_Display_Columns();
		this.click_Display_Columns_PDF_Btn();
		Thread.sleep(1000);
		this.verify_Role_2();
		this.click_Role_Option_2();
		Thread.sleep(1000);
		this.click_Plus_Sign_2();
		Thread.sleep(2000);
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> set_Directory_Display_Columns_For_PDF() -----------");
	}
	
	public void disable_Directory_Display_Columns_For_PDF() throws InterruptedException {
		this.scroll_To_Display_Columns();
		this.click_Role_Tag_2();
		Thread.sleep(2000);
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> set_Directory_Display_Columns_For_PDF() -----------");
	}
	
	public void Enable_Directory_Excel_Export() throws InterruptedException {
		this.scroll_To_Display_Columns();
		this.enable_Directory_Excel_Export_Checkbox();
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> Enable_Directory_Excel_Export() -----------");
	}
	
	public void Disable_Directory_Excel_Export() throws InterruptedException {
		this.scroll_To_Display_Columns();
		this.disable_Directory_Excel_Export_Checkbox();
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> Enable_Directory_Excel_Export() -----------");
	}
	
	public void disable_Display_Columns_By_User_Catergory() throws InterruptedException {
		this.verify_General_Settings();
		this.scroll_To_Display_Columns();
		this.disable_Display_Directory_CheckBox();
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> disable_Display_Columns_By_User_Catergory() -----------");
	}
	
	public void verify_User_Categories() throws InterruptedException {
		this.verify_Each_User_Catergory();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_User_Categories() -----------");
	}
	
	public void verify_Role_Column() throws InterruptedException {
		this.verify_Column_Role();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_User_Categories() -----------");
	}
	
	public void verify_Role_Column_NOT_Present() throws InterruptedException {
		this.verify_Column_Role_Disable();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_User_Categories() -----------");
	}
	
	//-----------------------------------
	By download_Directory = By.xpath("//*[@id='directoryModal']//div/button[contains(.,'Download Directory')]");
	//By download_Directory = By.xpath("//button[contains(text(),'Download Directory')]");
	By download_Directory_At_Glance = By.xpath("//a[@class='ataglance-link']");
	By privacy_Policy = By.xpath("//body/div[@id='directoryModal']//div/a[1][contains(.,'Privacy Policy')]");

	
	public void verify_Download_Directory() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(download_Directory)));
	}
	
	public void verify_Download_Directory_At_Glance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(download_Directory_At_Glance)));
	}
	
	public void scroll_To_Privacy_Policy() {
		WebElement element = driver.findElement(By.xpath("//body/div[@id='directoryModal']//div/a[1][contains(.,'Privacy Policy')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void click_Download_Directory() {
		driver.findElement(download_Directory).click();
//		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Download Directory')]"));
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("arguments[0].click();", element);
	}
	
	public void verify_Download_As_Excel_Not_Displayed() {
		String element = "//a[@class='excel-link']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Download_As_Excel_Displayed() {
		String element = "//a[@class='excel-link']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}

	public void verify_Download_As_Excel_Disabled() throws InterruptedException {
		this.verify_Download_Directory();
		this.scroll_To_Privacy_Policy();
		Thread.sleep(1000);
		this.click_Download_Directory();
		Thread.sleep(1000);
		this.verify_Download_Directory_At_Glance();
		this.verify_Download_As_Excel_Not_Displayed();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Download_As_Excel_Disabled() -----------");
	}
	
	public void verify_Download_As_Excel_Enabled() throws InterruptedException {
		this.verify_Download_Directory();
		this.scroll_To_Privacy_Policy();
		Thread.sleep(1000);
		this.click_Download_Directory();
		Thread.sleep(1000);
		this.verify_Download_Directory_At_Glance();
		this.verify_Download_As_Excel_Displayed();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Download_As_Excel_Enabled() -----------");
	}
	
	//------------Logo/Print_Logo_Logo_URL---------------
	
	By input_remove_Logo = By.xpath("//input[@id='client_remove_logo']");
	By input_Logo_URL = By.xpath("//input[@id='client_header_logo_url']");
	String starTrek = "https://www.startrek.com/";
	
	public void add_Print_Logo_Image() {
		String input = "//input[@id='client_print_logo']";
		String filepath = "C:\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void add_Logo_Plus_Logo_URL() throws InterruptedException {
		String input = "//input[@id='client_logo']";
		String filepath = "C:\\uploadedFiles\\sisco.jpg";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
		
		driver.findElement(input_Logo_URL).clear();
		driver.findElement(input_Logo_URL).sendKeys(starTrek);
		Thread.sleep(1000);
	}
	
	public void remove_Print_Logo() {
		WebElement box = driver.findElement(By.xpath("//input[@id='client_remove_print_logo']"));

		if (!box.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", box);
		}
	}
	
	public void remove_Logo_And_Logo_Url() {
		WebElement box = driver.findElement(By.xpath("//input[@id='client_remove_logo']"));

		if (!box.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", box);
		}
		
		driver.findElement(input_Logo_URL).clear();
	}
	
	public void scroll_To_Save() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//body//div[@id='clientLookFeel']//div/button[2][contains(.,'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Print_Logo_Removed() throws InterruptedException {
		String image = "//*[starts-with(@id,'edit_client_')]/img";
		Assert.assertTrue(driver.findElements(By.xpath(image)).size() < 1);
	}
	
	public void verify_Home_Page_Logo_Removed() throws InterruptedException {
		String image = "//*[@id='wrap']/main//div/ul/li[1]/a[@class='logo']";
		//String imageHref = driver.findElement(By.xpath(image)).getAttribute("href");
		//Assert.assertFalse(imageHref.equals(null));
		Assert.assertTrue(driver.findElements(By.xpath(image)).size() < 1);

	}
	
	public void verify_Home_Page_Logo_And_URL_Added() throws InterruptedException {
		//-----verify_logo_and_href------
		String image = "//*[@id='wrap']/main//div/ul//a[@class='logo']";
		//String image = "//*[@id=atlas-leftnav-toggle']/div[@class='fl-right']";
		String imageHref = driver.findElement(By.xpath(image)).getAttribute("href");
		Assert.assertTrue(imageHref.contains(starTrek));
		Thread.sleep(1000);
		
		//-----click image go to site ----
		driver.findElement(By.xpath(image)).click();
		Thread.sleep(2000);
		
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		
		//-----verify page fully loads--
	    new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
	            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		
	    //---verify correct url and close----
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains(starTrek));
		driver.close();
		
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
	
	public void switch_Tabs_To_Web_Site() throws InterruptedException {
		Thread.sleep(2000);
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		
		//-----verify page fully loads--
	    new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
	            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		
	    //---verify correct url and close----
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains(starTrek));
		driver.close();
		
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	}
	
	public void add_Print_Logo() throws InterruptedException {
		this.add_Print_Logo_Image();
		this.scroll_To_Save();
		this.click_LF_SaveBtn();
		Thread.sleep(3000);
		//this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> select_Display_Columns_By_User_Catergory() -----------");
	}
	
	public void disable_Print_Logo() throws InterruptedException {
		this.remove_Print_Logo();
		this.scroll_To_Save();
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> disable_Print_Logo() -----------");
	}
	
	public void add_Logo_And_Logo_URL() throws InterruptedException {
		this.add_Logo_Plus_Logo_URL();
		this.scroll_To_Save();
		this.click_LF_SaveBtn();
		Thread.sleep(3000);
		//this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		Thread.sleep(1500);
		System.out.println("------- Completed --> add_Print_Logo_And_URL() -----------");
	}
	
	public void verify_Logo_And_URL_Added() throws InterruptedException {
		//this.verify_AutoBE();
		AtlasNavBar obj  = new AtlasNavBar(driver);
		obj.verify_Atlas_Left_Nav();
		this.verify_Home_Page_Logo_And_URL_Added();
	}
	
	public void disable_Logo_And_Logo_URL() throws InterruptedException {
		this.remove_Logo_And_Logo_Url();
		this.scroll_To_Save();
		this.click_LF_SaveBtn();
		Thread.sleep(1000);
		this.verify_Portal_Save_Message();
		driver.navigate().refresh();
		driver.navigate().refresh();
		System.out.println("------- Completed --> disable_Print_Logo() -----------");
	}
	
	public void verify_Logo_Removed() throws InterruptedException {
		//AtlasNavBar obj  = new AtlasNavBar(driver);
		//obj.verify_Atlas_Left_Nav();;
		this.verify_Print_Logo_Removed();
	}
	
	public void verify_HP_Logo_Removed() throws InterruptedException {
		//AtlasNavBar obj  = new AtlasNavBar(driver);
		//obj.verify_Atlas_Left_Nav();
		this.verify_Home_Page_Logo_Removed();
	}
	

}
