package page_set_permissions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	
	public void click_View_Profile() {
		driver.findElement(view_Profile).click();
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
	
	public void open_Auto_Director_User_Profile() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Set_Permissions();
		Thread.sleep(1000);
		System.out.println("------- Completed --> Open_User_Profile() -----------");
	}
	
	public void open_Edit_User_Profile() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> Open_User_Profile() -----------");
	}
	
	public void open_View_User_Profile() throws InterruptedException {
		this.verify_Test_User_Dropdown();
		Thread.sleep(1000);
		this.click_Test_User_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_View_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_View_User_Profile() -----------");
	}
	
	
	// --------------open_User_Profile_Deactivate_Resource---------------------------
	By company_Information = By.xpath("//span[contains(text(),'Company Information')]");
	By personal_Information = By.xpath("//span[contains(text(),'Personal Information')]");
	By address = By.xpath("//input[@id='user_address1']");
	By city = By.xpath("//input[@id='user_city']");
	By zip = By.xpath("//input[@id='user_zip']");
	By email = By.xpath("//input[@id='user_email']");
	By phone = By.xpath("//input[@id='user_phone']");
	By saveBtn_Profile = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By profile_Save_Message = By.xpath("//p[contains(text(),'has been saved.')]");
	
	String oldAddress = "11116 Willow Medow Lane"; 
	String oldCity = "Charlotte ";
	String oldZip = "28277";
	String oldPhone = "757764321";
	String oldEmail = "testReset@diligent.com";
	
	String newAddress = "3120 Ashwood Park Dr"; 
	String newCity = "Belmont";
	String newZip = "28012";
	String newPhone = "7571234567";
	String newEmail = "testReset@diligent.com";

	public void verify_Company_Information() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(company_Information)));
	}
	
	public void verify_Personal_Information() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(personal_Information)));
	}
	
	public void verify_Profile_Save_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(profile_Save_Message)));
	}
	
	public void click_Company_Information() throws InterruptedException {
		By compCollapse = By.xpath("//div[@id='headingFormCompany']//a[@class='collapsed']");
		By persCollapse = By.xpath("//div[@id='headingFormPersonal']//a[@class='collapsed']");
		By personalInfo = By.xpath("//span[contains(text(),'Personal Information')]");
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean compcollapse = driver.findElements(compCollapse).size() > 0;
		Boolean perscollapse = driver.findElements(persCollapse).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (!compcollapse == true) {
			driver.findElement(company_Information).click();
			Thread.sleep(1500);
			driver.findElement(personalInfo).click();
		}else if (compcollapse == true && perscollapse == true) {
			driver.findElement(personalInfo).click();
		}
	}
	
	public void click_SaveBtn_Profile() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		
		driver.findElement(saveBtn_Profile).click();
	}
	
	public void fill_New_Personal_Information_Form() {
		driver.findElement(address).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys(newAddress);
		
		driver.findElement(city).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(newCity);
		
		driver.findElement(zip).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(zip).clear();
		driver.findElement(zip).sendKeys(newZip);
		
		driver.findElement(email).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(newEmail);
		
		driver.findElement(phone).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys(newPhone);
	}
	
	public void fill_Old_Personal_Information_Form() {
		driver.findElement(address).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys(oldAddress);
		
		driver.findElement(city).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys(oldCity);
		
		driver.findElement(zip).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(zip).clear();
		driver.findElement(zip).sendKeys(oldZip);
		
		driver.findElement(email).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(oldEmail);
		
		driver.findElement(phone).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys(oldPhone);
	}
	
	public void verify_Personal_Info_Saved() {
		String address = "//p[contains(text(),'3120 Ashwood Park Dr')]";
		String cityAndZip = "//p[contains(text(),'Belmont, NC, 28012, US')]";
		String phone = "//p[contains(text(),'7571234567 (Phone)')]";
		String email = "//a[contains(text(),'testReset@diligent.com')]";

		Assert.assertTrue(driver.findElements(By.xpath(address)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(cityAndZip)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(phone)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(email)).size() > 0);
	}
	
	public void verify_Old_Personal_Info_Saved() {
		String address = "//p[contains(text(),'11116 Willow Medow Lane')]";
		String cityAndZip = "//p[contains(text(),'Charlotte , NC, 28277, US')]";
		String phone = "//p[contains(text(),'757764321 (Phone)')]";
		String email = "//a[contains(text(),'testReset@diligent.com')]";

		Assert.assertTrue(driver.findElements(By.xpath(address)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(cityAndZip)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(phone)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(email)).size() > 0);
	}
	
	public void edit_With_New_Contact_Information() throws InterruptedException {
		this.verify_Company_Information();
		Thread.sleep(1500);
		this.click_Company_Information();
		Thread.sleep(1000);
		this.verify_Personal_Information();
		this.fill_New_Personal_Information_Form();
		this.click_SaveBtn_Profile();
		Thread.sleep(1000);
		this.verify_Profile_Save_Message();
		System.out.println("------- Completed --> edit_Contact_Information() -----------");
	}
	
	public void edit_With_Old_Contact_Information() throws InterruptedException {
		this.verify_Company_Information();
		this.click_Company_Information();
		Thread.sleep(1000);
		this.verify_Personal_Information();
		this.fill_Old_Personal_Information_Form();
		this.click_SaveBtn_Profile();
		Thread.sleep(1000);
		this.verify_Profile_Save_Message();
		System.out.println("------- Completed --> edit_With_Old_Contact_Information() -----------");
	}
	
	public void verify_Contact_Info_Saved() throws InterruptedException {
		this.verify_Personal_Info_Saved();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Contact_Info_Saved() -----------");
	}
	
	public void verify_Old_Contact_Info_Saved() throws InterruptedException {
		this.verify_Old_Personal_Info_Saved();
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Old_Contact_Info_Saved() -----------");
	}
	
	public void test_User_Verify_Contact_Info_Saved() throws InterruptedException {
		this.verify_Personal_Information();
		this.verify_Personal_Info_Saved();
		driver.navigate().refresh();
		System.out.println("------- Completed --> edit_Contact_Information() -----------");
	}
	
	// --------------make_Preferred_Contact_Company---------------------------
	By statement_CPC = By.xpath("//*[@id='formCompany']/div/div/div[1]/div[2]/label[contains(text(),'Make this my preferred contact address.')]");
	By radio_Company_PC = By.xpath("//input[@id='user_preferred_contact_address_company']");
	By radio_Personal_PC = By.xpath("//input[@id='user_preferred_contact_address_personal']");
	By statement_PPC = By.xpath("//*[@id=\"formPersonal\"]/div/div/div[1]/div[2]/label[contains(text(),'Make this my preferred contact address.')]");

	public void verify_Statement_Company_Preferred_Contact() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(statement_CPC)));
	}
	
	public void verify_Statement_Company_Personal_Preferred_Contact() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(statement_PPC)));
	}
	
	public void click_Radio_Company_Preferred_Contact() throws InterruptedException {
		
		String string = "//input[@id='user_preferred_contact_address_company']";
		WebElement pc = driver.findElement(By.xpath(string));
		
		if(!pc.isSelected()) {
			//driver.findElement(deactivate_Resources).click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", pc);
		}	
	}
	
	public void click_CompanyInfo_Select_Preferred_Contact() throws InterruptedException {
		By compCollapse = By.xpath("//div[@id='headingFormCompany']//a[@class='collapsed']");
		By persCollapse = By.xpath("//div[@id='headingFormPersonal']//a[@class='collapsed']");
		By personalInfo = By.xpath("//span[contains(text(),'Personal Information')]");
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean compcollapse = driver.findElements(compCollapse).size() > 0;
		Boolean perscollapse = driver.findElements(persCollapse).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (compcollapse == false) {
			this.verify_Statement_Company_Preferred_Contact(); //verify that the radio button is there
			this.click_Radio_Company_Preferred_Contact();  //click radio button 
			Thread.sleep(1000);
		}
		if (compcollapse == true) {
			driver.findElement(company_Information).click();    //click company info
			Thread.sleep(1000);
			this.verify_Statement_Company_Preferred_Contact(); //verify that the radio button is there
			this.click_Radio_Company_Preferred_Contact();  //click radio button 
			Thread.sleep(1000);
		}
	}
	
	public void click_Radio_Personal_Preferred_Contact() throws InterruptedException {
			String string = "//input[@id='user_preferred_contact_address_personal']";
			WebElement ppc = driver.findElement(By.xpath(string));
			
			if(!ppc.isSelected()) {
				//driver.findElement(deactivate_Resources).click();
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", ppc);
			}	
		}
	
	public void click_PersonalInfo_Select_Preferred_Contact() throws InterruptedException {
		By compCollapse = By.xpath("//div[@id='headingFormCompany']//a[@class='collapsed']");
		By persCollapse = By.xpath("//div[@id='headingFormPersonal']//a[@class='collapsed']");
		By personalInfo = By.xpath("//span[contains(text(),'Personal Information')]");
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean compcollapse = driver.findElements(compCollapse).size() > 0;
		Boolean perscollapse = driver.findElements(persCollapse).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (perscollapse == false) {
			this.verify_Statement_Company_Personal_Preferred_Contact(); //verify that the radio button is there
			this.click_Radio_Personal_Preferred_Contact();  //click radio button 
			Thread.sleep(1000);
		}
		if (perscollapse == true) {
			driver.findElement(personal_Information).click();    //click company info
			Thread.sleep(1000);
			this.verify_Statement_Company_Personal_Preferred_Contact(); //verify that the radio button is there
			this.click_Radio_Personal_Preferred_Contact();  //click radio button 
			Thread.sleep(1000);
		}
	}
	
	public void make_Company_Info_Preferred_Contact() throws InterruptedException {
		this.verify_Company_Information();
		Thread.sleep(1500);
		this.click_CompanyInfo_Select_Preferred_Contact();
		this.click_SaveBtn_Profile();
		Thread.sleep(1000);
		this.verify_Profile_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> make_Company_Info_Preferred_Contact() -----------");
	}
	
	public void make_Personal_Info_Preferred_Contact() throws InterruptedException {
		this.verify_Company_Information();
		Thread.sleep(1500);
		this.click_PersonalInfo_Select_Preferred_Contact();
		this.click_SaveBtn_Profile();
		Thread.sleep(1000);
		this.verify_Profile_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> make_Personal_Info_Preferred_Contact() -----------");
	}
	
	
	By prefix_Drp_Dwn = By.xpath("//select[@id='user_altprefix']");
	By mr_Option = By.xpath("//option[contains(text(),'Mr.')]");
	By blank_Option = By.xpath("//*[@id='user_altprefix']/option[1]");

	public void verify_Prefix_Drp_Dwn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(prefix_Drp_Dwn)));
	}

	public void scroll_To_Alternate_Contact() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Alternate Contact Information')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void click_Prefix_Drp_Dwn_Select() throws InterruptedException {
		driver.findElement(prefix_Drp_Dwn).click();
		Thread.sleep(1000);
		driver.findElement(mr_Option).click();
	}
	
	public void click_And_Fill_Alternate_Contact_Information() throws InterruptedException {
		By alternateInfo = By.xpath("//div[@id='headingFormAlternate']//a[@class='collapsed']");
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean alternatecollapse = driver.findElements(alternateInfo).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (alternatecollapse == false) {
			this.fill_Alternate_Contact_Form();  //fill form
			Thread.sleep(500);
		}
		if (alternatecollapse == true) {
			driver.findElement(alternateInfo).click(); //click alternate info
			Thread.sleep(1000);
			this.verify_Prefix_Drp_Dwn();
			this.fill_Alternate_Contact_Form(); //fill form
			Thread.sleep(500);
		}
	}
	
	public void fill_Alternate_Contact_Form() throws InterruptedException {
		By alt_First_Name = By.xpath("//input[@id='user_altfirstname']");
		By alt_Middle_Name = By.xpath("//input[@id='user_altmiddlename']");
		By alt_Last_Name = By.xpath("//input[@id='user_altlastname']");
		By alt_Email = By.xpath("//input[@id='user_altemail']");
		By alt_Phone = By.xpath("//input[@id='user_altphone']");
		By alt_Cell = By.xpath("//input[@id='user_altcell']");
		
		String first = "Jim";
		String middle = "C";
		String last = "Jones";
		String email = "somthing@gmail.com";
		String phone = "704-123-4567";
		String cell = "222-123-4567";
		
		this.click_Prefix_Drp_Dwn_Select();
		driver.findElement(alt_First_Name).sendKeys(first);
		driver.findElement(alt_Middle_Name).sendKeys(middle);
		driver.findElement(alt_Last_Name).sendKeys(last);
		driver.findElement(alt_Email).sendKeys(email);
		driver.findElement(alt_Phone).sendKeys(phone);
		driver.findElement(alt_Cell).sendKeys(cell);
	}
	
	public void click_And_Remove_Alternate_Contact_Information() throws InterruptedException {
		By alternateInfo = By.xpath("//div[@id='headingFormAlternate']//a[@class='collapsed']");
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean alternatecollapse = driver.findElements(alternateInfo).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (alternatecollapse == false) {
			this.remove_Alternate_Contact_Form();  //fill form
			Thread.sleep(500);
		}
		if (alternatecollapse == true) {
			driver.findElement(alternateInfo).click(); //click alternate info
			Thread.sleep(1000);
			this.verify_Prefix_Drp_Dwn();
			this.remove_Alternate_Contact_Form(); //fill form
			Thread.sleep(500);
		}
	}
	
	public void click_Prefix_Drp_Dwn_Remove() throws InterruptedException {
		driver.findElement(prefix_Drp_Dwn).click();
		Thread.sleep(1000);
		driver.findElement(blank_Option).click();
	}
	
	public void remove_Alternate_Contact_Form() throws InterruptedException {
		By alt_First_Name = By.xpath("//input[@id='user_altfirstname']");
		By alt_Middle_Name = By.xpath("//input[@id='user_altmiddlename']");
		By alt_Last_Name = By.xpath("//input[@id='user_altlastname']");
		By alt_Email = By.xpath("//input[@id='user_altemail']");
		By alt_Phone = By.xpath("//input[@id='user_altphone']");
		By alt_Cell = By.xpath("//input[@id='user_altcell']");
		
		this.click_Prefix_Drp_Dwn_Remove();
		driver.findElement(alt_First_Name).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(alt_First_Name).clear();
		
		driver.findElement(alt_Middle_Name).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(alt_Middle_Name).clear();

		driver.findElement(alt_Last_Name).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(alt_Last_Name).clear();
		
		driver.findElement(alt_Email).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(alt_Email).clear();

		driver.findElement(alt_Phone).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(alt_Phone).clear();
		
		driver.findElement(alt_Cell).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(alt_Cell).clear();
		
	}
	
	public void save_Alternate_Contact_Information() throws InterruptedException {
		this.verify_Company_Information();
		this.scroll_To_Alternate_Contact();
		Thread.sleep(1000);
		this.click_And_Fill_Alternate_Contact_Information();
		this.click_SaveBtn_Profile();
		Thread.sleep(1000);
		this.verify_Profile_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> save_Alternate_Contact_Information() -----------");
	}
	
	public void remove_Alternate_Contact_Information() throws InterruptedException {
		this.verify_Company_Information();
		this.scroll_To_Alternate_Contact();
		Thread.sleep(1000);
		this.click_And_Remove_Alternate_Contact_Information();
		this.click_SaveBtn_Profile();
		Thread.sleep(1000);
		this.verify_Profile_Save_Message();
		driver.navigate().refresh();
		System.out.println("------- Completed --> remove_Alternate_Contact_Information() -----------");
	}
	
	// --------------open_User_Profile_Deactivate_Resource---------------------------
	By deactivate_Resources_Label = By.xpath("//label[contains(text(),'Deactivate Resources')]");

	public void verify_Deactivate_Resources_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivate_Resources_Label)));
	}
	
	public void verify_Resource_Library_Hidden() {
		this.verify_Directory();

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
	By settings_WR = By.xpath("//div[@class='btn-group small open']//li/a[contains(text(),'Settings')]");
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
	
	public void verify_Deactivate_Workroom_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deactivate_Workroom_Tab)));
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
		//this.verify_Introduction();
		//this.click_Manage_Workrooms_Groups_Active();
		Thread.sleep(1500);
		this.verify_Deactivate_Workroom_Tab();
		this.click_Deactivate_Workroom_Tab();
		Thread.sleep(1500);
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
		Thread.sleep(2000);
		System.out.println("------- Completed --> open_User_Profile_Enable_Workroom() -----------");
	}
	
	public void verify_Workroom_Access_Enabled() throws InterruptedException {
		this.verify_Deactivate_Workroom_Tab();
		this.click_Deactivate_Workroom_Tab();
		Thread.sleep(3500);
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean element = driver.findElements(autoAttend_Dropdown_Deactivate).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (element == true) {
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
		}
	
		System.out.println("------- Completed --> verify_Workroom_Access_Enabled() -----------");
	}
		
	// --------------enable_User_As_System_Administrator---------------------------
	By system_Admin_Check_Box = By.xpath("//label[contains(text(),'System Administrator')]");
	By mobile_Only_Check_Box = By.xpath("//label[contains(text(),'Mobile Only')]");
	By manage_Files_Check_Box = By.xpath("//label[contains(text(),'Manage Files')]");
	By deativate_Message_Check_Box = By.xpath("//input[@id='user_can_email']");
	By save_Btn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By everybody = By.xpath("//div[@class='col-md-2 sidebar-modal']//li[1]");
	By close_Directory_Btn = By.xpath("//div[@id='directoryModal']//a[@class='atlas-close pull-right']");
	By private_Directory_Check_Box = By.xpath("///input[@id='directory_view']");


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
	
	public void click_To_Enable_View_Only_Books() {
		//driver.findElement(mobile_Only_Check_Box).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='user_view_only_books']"));
		if(!element.isSelected()) {
			driver.findElement(By.xpath("//input[@id='user_view_only_books']")).click();
		}
	}
	
	public void click_To_Disable_View_Only_Books() {
		//driver.findElement(mobile_Only_Check_Box).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='user_view_only_books']"));
		if(element.isSelected()) {
			driver.findElement(By.xpath("//input[@id='user_view_only_books']")).click();
		}
	}
	
	public void click_Manage_Files() {
		WebElement element = driver.findElement(By.xpath("//input[@id='manage_resources']"));
		if(!element.isSelected()) {
			driver.findElement(manage_Files_Check_Box).click();
		}
	}
	
	public void disable_Manage_Files() {
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
	
	public void click_Private_Directory() {
		WebElement element = driver.findElement(By.xpath("//input[@id='directory_view']"));
		if(!element.isSelected()) {
			driver.findElement(private_Directory_Check_Box).click();
		}
	}
	
	public void click_Save_Btn() {
		//driver.findElement(save_Btn).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void scroll_To_Save_Button() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
	}
	
	
	public void click_Close_Directory_Btn() {
		driver.findElement(close_Directory_Btn).click();
	}
	
	public void click_Everybody() {
		//driver.findElement(everybody).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='col-md-2 sidebar-modal']//li[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
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
		this.verify_Manage_Files_Check_Box();
		this.click_Deactivate_Message_Check_Box();
		Thread.sleep(1000);
		this.click_Save_Btn();
		Thread.sleep(2500);
		System.out.println("------- Completed --> click_To_Activate_Deactivate_Messaging() -----------");
	}
	
	public void click_To_Deactivate_Messaging() throws InterruptedException {
		this.verify_Manage_Files_Check_Box();
		this.unclick_Deactivate_Message_Check_Box();
		Thread.sleep(1000);
		this.scroll_To_Save_Button();
		Thread.sleep(1000);
		this.click_Save_Btn();
		Thread.sleep(2000);
		System.out.println("------- Completed --> click_To_Deactivate_Messaging() -----------");
	}
	
	// --------------SetUserToViewOnlyBooks ---------------------------
	By meetig_Book_Viewer = By.xpath("//div[@class='sidebar-fixed-container']//a[@id='view_book']");
	By download_Agenda = By.xpath("//span[contains(text(),'Download This is an Agenda')]");
	By download_Full_PDF = By.xpath("//a[@class='btn btn-default no-mobile btn-sidebar secondary-action-btn left']");
	By scanned_Book_Visible = By.xpath("//a[contains(text(),'This is a Scanned Book')]");
	
	public void verify_Meeting_Book_Viewer() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meetig_Book_Viewer)));
	}

	public void verify_Download_Options_NOT_Shown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.and(ExpectedConditions.invisibilityOfElementLocated(download_Agenda),
		(ExpectedConditions.invisibilityOfElementLocated(download_Full_PDF))));
	}
	
	public void verify_Scanned_Book_Visible() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(scanned_Book_Visible)));
	}
	
	public void click_Scanned_Book_Title() {
		driver.findElement(scanned_Book_Visible).click();
	}
	
	
	// --------------Function Being Called ---------------------------
	public void enable_User_To_View_Only_Books() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.click_To_Enable_View_Only_Books();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		driver.navigate().refresh(); // back to main page
		System.out.println("------- Completed --> set_User_To_View_Only_Books() -----------");
	}
	
	public void disable_User_To_View_Only_Books() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.click_To_Disable_View_Only_Books();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		driver.navigate().refresh(); // back to main page
		System.out.println("------- Completed --> set_User_To_View_Only_Books() -----------");
	}
	
	public void verify_Only_Meeting_Book_Viewer_Shown() throws InterruptedException {
		this.verify_Scanned_Book_Visible();
		this.click_Scanned_Book_Title();
		Thread.sleep(1500);
		this.verify_Meeting_Book_Viewer();
		this.verify_Download_Options_NOT_Shown();
		driver.navigate().refresh(); // back to main page
		System.out.println("------- Completed --> verify_Only_Meeting_Book_Viewer_Shown() -----------");
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
		Thread.sleep(2500);
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
		this.disable_Manage_Files();
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
	public void deactivate_Messaging_For_User() throws InterruptedException {
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
	
	// --------------Function Being Called ---------------------------
	public void set_User_Directory_To_Private() throws InterruptedException {
		this.verify_Mobile_Only_Check_Box();
		this.click_Private_Directory();
		Thread.sleep(1500);
		this.click_Save_Btn();
		Thread.sleep(1500);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(3000);// wait for star to appear
		System.out.println("------- Completed --> set_User_Directory_To_Private() -----------");
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

		public void verify_AutoBE() {
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
		this.verify_AutoBE();
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
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Open_Settings_Then_Workroom_And_Group_Settings() -----------");
	}
	
	// ---------------Event Settings--------------------
	By event_Settings = By.xpath("//a[contains(text(),'Event Settings')]");
	By new_Event_Category = By.xpath("//span[contains(text(),'New Event Category')]");
	By event_Category_Input = By.xpath("//input[@id='eventcolor_title']");
	By save_EC = By.xpath("//span[contains(text(),'Save')]");
	By save_EC_2 = By.xpath("(//input[@id='eventcolor_title']/following::button[contains(.,'Save')])[1]");

	By created_Category = By.xpath("//div[contains(text(),'Category')]");
	By cat_Edit_Option = By.xpath("(//div[contains(text(),'Category')]/following::a[contains(.,'Edit')])[1]");
	
	By category_One = By.xpath("//div[contains(text(),'Category One')]");
	By delete_Category_One = By.xpath("(//div[contains(text(),'Category One')]/following::a[contains(.,'Delete')])[1]");

	String cat = "Category";
	String cat2 = "Category One";

	public void verify_Event_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Settings)));
	}
	
	public void verify_New_Event_Category() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Event_Category)));
	}
	
	public void verify_Event_Category_Input() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Category_Input)));
	}
	
	public void verify_Created_Category() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(created_Category)));
	}
	
	public void verify_Category_One() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(category_One)));
	}
	
	public void click_Event_Settings() {
		driver.findElement(event_Settings).click();
	}
	
	public void click_New_Event_Category() {
		driver.findElement(new_Event_Category).click();
	}
	
	public void input_Category_Name() {
		driver.findElement(event_Category_Input).sendKeys(cat);
	}
	
	public void input_Category_Name_2() {
		driver.findElement(event_Category_Input).clear();
		driver.findElement(event_Category_Input).sendKeys(cat2);
	}
	
	public void save_EC() {
		driver.findElement(save_EC).click();
	}
	
	public void save_EC_2() {
		driver.findElement(save_EC_2).click();
	}
	
	public void click_Cat_Edit_Option() {
		driver.findElement(cat_Edit_Option).click();
	}
	
	public void click_Delete_Category_One() {
		driver.findElement(delete_Category_One).click();
	}
	
	public void verify_Category_Not_Present() throws InterruptedException {
		String element = "//div[contains(text(),'Category One')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void open_Event_Settings() throws InterruptedException {
		this.verify_Event_Settings();
		this.click_Event_Settings();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Event_Settings() -----------");
	}
	
	public void create_Event_Category() throws InterruptedException {
		this.verify_New_Event_Category();
		this.click_New_Event_Category();
		Thread.sleep(1000);
		this.verify_Event_Category_Input();
		this.input_Category_Name();
		this.save_EC();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> open_Event_Settings() -----------");
	}
	
	public void edit_Created_Category() throws InterruptedException {
		this.verify_Created_Category();
		this.click_Cat_Edit_Option();
		Thread.sleep(1000);
		this.verify_Event_Category_Input();
		this.input_Category_Name_2();
		Thread.sleep(1000);
		this.save_EC_2();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> edit_Created_Category() -----------");
	}
	
	public void delete_Category_One() throws InterruptedException {
		this.verify_Category_One();
		this.click_Delete_Category_One();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3000);
		System.out.println("------- Completed --> delete_Category_One() -----------");
	}
	
	//----------------------User_Category/Manage_Users----------------------------------
	By manage_Users = By.xpath("//a[contains(text(),'Manage Users')]");
	By user_Categories = By.xpath("//a[contains(text(),'User Categories')]");
	By new_Category_Btn = By.xpath("//*[@id='user_categories']/div/a[contains(.,'New Category')]");
	By new_Cat_Title_Input = By.xpath("//input[@id='userclass_title']");
	By new_User_Cat_Dropdown = By.xpath("//a[@class='placeholder category-collapse'][contains(text(),'Category')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	//By new_User_Cat_Dropdown = By.xpath("//a[@class='placeholder category-collapse'][contains(text(),'Category')]/following::div[@class='btn-group small pull-right']");
	By edit_UC_Option = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Edit')]");
	By new_User_Cat_Dropdown_2 = By.xpath("//a[@class='placeholder category-collapse'][contains(.,'CategoryTwo')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By deleteBtn = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Delete')]");
	By delete_Input_Field = By.xpath("//body/div[ starts-with(@id,'confirm-modal-')]//input[@class='form-control']");

	String category = "Category";
	String categoryTwo = "CategoryTwo";

	public void verify_Manage_Users() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(manage_Users)));
	}
	
	public void verify_User_Categories() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Categories)));
	}
	
	public void verify_New_Category_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Category_Btn)));
	}
	
	public void verify_Newly_Created_Category() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_User_Cat_Dropdown)));
	}
	
	public void verify_Edited_Category() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_User_Cat_Dropdown_2)));
	}
	
	public void verify_New_Category_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Cat_Title_Input)));
	}
	
	public void verify_Edit_UC_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_UC_Option)));
	}
	
	public void verify_DeleteBtn_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(deleteBtn)));
	}
	
	public void verify_Delete_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Input_Field)));
	}
	
	public void click_Manage_Users() {
		//driver.findElement(manage_Users).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Manage Users')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_User_Categories() {
		driver.findElement(user_Categories).click();
	}
	
	public void click_New_Category() {
		driver.findElement(new_Category_Btn).click();
	}
	
	public void type_New_Cat_Title() {
		driver.findElement(new_Cat_Title_Input).sendKeys(category);
	}
	
	public void edit_New_Cat_Title() {
		driver.findElement(new_Cat_Title_Input).clear();
		driver.findElement(new_Cat_Title_Input).sendKeys(categoryTwo);
	}
	
	public void click_SaveBtn() {
		// driver.findElement(saveBtn).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog']//button[@id='formsSubmit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Newly_Created_User_Cat_Dropdown() {
		driver.findElement(new_User_Cat_Dropdown);
		WebElement element = driver.findElement(By.xpath("//a[@class='placeholder category-collapse'][contains(text(),'Category')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edit_UC_Option() {
		driver.findElement(edit_UC_Option).click();
	}
	
	public void click_Edited_User_Category_Dropdown() {
		driver.findElement(new_User_Cat_Dropdown_2).click();
	}
	
	public void click_DeleteBtn_2() {
		driver.findElement(deleteBtn).click();
	}
	
	public void sendKeys_Category_Two() {
		driver.findElement(delete_Input_Field).sendKeys(categoryTwo);
	}
	
	public void verify_Category_Two_Not_Present() throws InterruptedException {
		String element = "//a[@class='placeholder category-collapse'][contains(.,'CategoryTwo')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Category_Not_Present_B() throws InterruptedException {
		String element = "//a[@class='placeholder category-collapse'][contains(.,'Category')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	
	public void open_Manage_Users() throws InterruptedException {
		this.verify_Manage_Users();
		this.click_Manage_Users();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Manage_User() -----------");
	}
	
	public void open_Settings_Manage_Users() throws InterruptedException {
		this.verify_Settings();
		this.click_SettingsBtn();
		Thread.sleep(1000);
		this.verify_Manage_Users();
		this.click_Manage_Users();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Settings_Manage_Users() -----------");
	}
	
	public void open_Settings_Security_Summary() throws InterruptedException {
		this.verify_Settings();
		this.click_SettingsBtn();
		Thread.sleep(1000);
		this.verify_Security_Summary();
		this.click_Security_Summary();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Settings_Security_Summary() -----------");
	}
	
	public void create_User_Category() throws InterruptedException {
		this.verify_User_Categories();
		this.click_User_Categories();
		Thread.sleep(1000);
		this.verify_New_Category_Btn();
		this.click_New_Category();
		Thread.sleep(1000);
		this.verify_New_Category_Input_Field();
		this.type_New_Cat_Title();
		this.click_SaveBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> create_User_Category() -----------");
	}
	
	public void navigate_To_User_Catergories() throws InterruptedException {
		this.verify_User_Categories();
		this.click_User_Categories();
		Thread.sleep(1000);
		this.verify_New_Category_Btn();
		System.out.println("------- Completed --> navigate_To_User_Catergories() -----------");
	}
	
	public void verify_Category_Created_Edit_Category() throws InterruptedException {
		this.verify_Newly_Created_Category();
		this.click_Newly_Created_User_Cat_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_UC_Option();
		this.click_Edit_UC_Option();
		Thread.sleep(1000);
		this.verify_New_Category_Input_Field();
		this.edit_New_Cat_Title();
		this.click_SaveBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Category_Created_Edit_Category() -----------");
	}
	
	public void verify_Edited_User_Category_And_Delete() throws InterruptedException {
		this.verify_Edited_Category();
		this.click_Edited_User_Category_Dropdown();
		Thread.sleep(1000);
		this.verify_DeleteBtn_2();
		this.click_DeleteBtn_2();
		Thread.sleep(1000);
		this.verify_Delete_Input_Field();
		this.sendKeys_Category_Two();
		this.click_ContinueBtn();
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Edited_User_Category_And_Delete() -----------");
	}
	
	
	//------------Unlock_User_Profile----------------
	
	By locked_Users_Tab = By.xpath("//a[contains(text(),'Locked Users')]");
	By lockoutuser = By.xpath(" //a[contains(text(),'lockout user')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By unlock_Profile_Option = By.xpath("//tbody/tr[starts-with (@id,'inactive-user')]//td//div//a[contains(.,'Unlock Profile')]");
	By unlock_Profile_Message = By.xpath("//body/div[@id='profileModal']//div/p[contains(.,'Profile for lockout user has been unlocked.')]");

	public void verify_Locked_Users_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(locked_Users_Tab)));
	}
	
	public void verify_Lockoutuser() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(lockoutuser)));
	}
	
	public void verify_Unlock_Profile_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(unlock_Profile_Option)));
	}
	
	public void verify_Unlock_Profile_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(unlock_Profile_Message)));
	}
	
	public void click_Locked_Users_Tab() {
		driver.findElement(locked_Users_Tab).click();
	}
	
	public void click_Lockoutuser_Dropdown() {
		driver.findElement(lockoutuser).click();
	}
	
	public void click_Unlock_Profile_Option() {
		driver.findElement(unlock_Profile_Option).click();
	}
	
	public void unlock_Locked_User_Profile() throws InterruptedException {
		this.verify_Locked_Users_Tab();
		this.click_Locked_Users_Tab();
		Thread.sleep(1000);
		this.verify_Lockoutuser();
		this.click_Lockoutuser_Dropdown();
		Thread.sleep(1000);
		this.verify_Unlock_Profile_Option();
		this.click_Unlock_Profile_Option();
		Thread.sleep(1500);
		this.verify_Unlock_Profile_Message();
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("------- Completed --> unlock_Locked_User_Profile() -----------");
	}
	
	
	//------------Add_Edit_Delete_Officer_Role----------------

	
	By term_Info = By.xpath("//a[contains(text(),'Term Info')]");
	By settings_TI = By.xpath("//*[@id='term_info']/a[contains(.,'Settings')]");
	By new_Officer_Role_Btn = By.xpath("//a[contains(text(),'New Officer Role')]");
	By Input_Field_OR = By.xpath("//input[@id='officer_role_role']");
	By saveBtn_OR = By.xpath("//body/div[@id='officer_roles_form']//div/button[2][contains(.,'Save')]");
	By new_OR_Dropdown = By.xpath("//body/div[@id='officer_roles']//div/ul/li[3]//div/a[contains(.,'ROLE')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By edit_OR = By.xpath("//body/div[@id='officer_roles']//div/ul/li[3]//div/ul/li/a[contains(.,'Edit')]");
	By edited_OR_Dropdown = By.xpath("//body/div[@id='officer_roles']//div/ul/li[3]//div/a[contains(.,'EDITED ROLE')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By delete_OR = By.xpath("//body/div[@id='officer_roles']//div/ul/li[3]//div/ul/li/a[contains(.,'Delete')]");
	By inputBox_OR = By.xpath("//*[starts-with (@id,'confirm-modal-')]/div/div/div[2]/input");


	public void verify_Settings_TI() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_TI)));
	}
	
	public void verify_New_Officer_Role_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Officer_Role_Btn)));
	}
	
	public void verify_Input_Field_OR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(Input_Field_OR)));
	}
	
	public void verify_New_Officer_Role_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_OR_Dropdown)));
	}
	
	public void verify_Edit_OR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_OR)));
	}
	
	public void verify_Delete_OR() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_OR)));
	}
	
	public void verify_Edited_OR_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_OR_Dropdown)));
	}
	
	
	public void click_Term_Info() {
		driver.findElement(term_Info).click();
	}
	
	public void click_Settings_TI() {
		driver.findElement(settings_TI).click();
	}
	
	public void click_New_Officer_Role() {
		driver.findElement(new_Officer_Role_Btn).click();
	}
	
	public void sendKeys_Input_OR() {
		String role = "ROLE";
		driver.findElement(Input_Field_OR).sendKeys(role);
	}
	
	public void click_SaveBtn_OR() {
		driver.findElement(saveBtn_OR).click();
	}

	public void click_New_Role_Dropdown() {
		driver.findElement(new_OR_Dropdown).click();
	}
	
	public void click_Edit_OR() {
		driver.findElement(edit_OR).click();
	}
	
	public void sendKeys_Edit_Input_OR() {
		String edit_Role = "EDITED ROLE";
		driver.findElement(Input_Field_OR).clear();
		driver.findElement(Input_Field_OR).sendKeys(edit_Role);
	}
	
	public void click_Edited_OR_Dropdown() {
		driver.findElement(edited_OR_Dropdown).click();
	}
	
	public void click_Delete_OR() {
		driver.findElement(delete_OR).click();
	}
	
	public void sendKeys_Role_Name() {
		String edited_Role = "EDITED ROLE";
		driver.findElement(inputBox_OR).sendKeys(edited_Role);
	}
	
	public void verify_Edited_Officer_Role_Deleted() throws InterruptedException {
		String element = "//body/div[@id='officer_roles']//div/ul/li[3]//div/a[contains(.,'EDITED ROLE')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void add_Officer_Role() throws InterruptedException {
		this.verify_Locked_Users_Tab();
		this.click_Term_Info();
		Thread.sleep(1000);
		this.verify_Settings_TI();
		this.click_Settings_TI();
		Thread.sleep(1000);
		this.verify_New_Officer_Role_Btn();
		this.click_New_Officer_Role();
		Thread.sleep(1000);
		this.verify_Input_Field_OR();
		this.sendKeys_Input_OR();
		this.click_SaveBtn_OR();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> add_Officer_Role() -----------");
	}
	
	public void edit_Officer_Role() throws InterruptedException {
		this.verify_Locked_Users_Tab();
		this.click_Term_Info();
		Thread.sleep(1000);
		this.verify_Settings_TI();
		this.click_Settings_TI();
		Thread.sleep(1000);
		this.verify_New_Officer_Role_Btn();
		this.verify_New_Officer_Role_Created();
		this.click_New_Role_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_OR();
		this.click_Edit_OR();
		Thread.sleep(1000);
		this.verify_Input_Field_OR();
		this.sendKeys_Edit_Input_OR();
		this.click_SaveBtn_OR();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> edit_Officer_Role() -----------");
	}
	
	public void delete_Officer_Role() throws InterruptedException {
		this.verify_Locked_Users_Tab();
		this.click_Term_Info();
		Thread.sleep(1000);
		this.verify_Settings_TI();
		this.click_Settings_TI();
		Thread.sleep(1000);
		this.verify_New_Officer_Role_Btn();
		this.verify_Edited_OR_Dropdown();
		this.click_Edited_OR_Dropdown();
		Thread.sleep(1000);
		this.verify_Delete_OR();
		this.click_Delete_OR();
		Thread.sleep(2500);
		//this.verify_ContinueBtn();
		this.sendKeys_Role_Name();
		Thread.sleep(1000);
		this.click_ContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> delete_Officer_Role() -----------");
	}

	public void verify_New_Role_Deleted() throws InterruptedException {
		this.verify_Locked_Users_Tab();
		this.click_Term_Info();
		Thread.sleep(1000);
		this.verify_Settings_TI();
		this.click_Settings_TI();
		Thread.sleep(1000);
		this.verify_New_Officer_Role_Btn();
		this.verify_Edited_Officer_Role_Deleted();
		System.out.println("------- Completed --> verify_New_Role_Deleted() -----------");
	}
	

	
	/* 
	By category_Expand = By.xpath("//a[@class='placeholder category-collapse'][contains(text(),'Category')]");
	By add_Remove_Users = By.xpath("//body/div[@id='settingsModal']//div/ul[1]/li[4]//div/a[contains(.,'Add/Remove Users')]");
	By add_Remove_Users_Modal = By.xpath("//h4[contains(text(),'Add/Remove Users to Category')]");
	By workroom_Admin_User = By.xpath("//div[contains(text(),'Workroom Admin')]");
	By continueBtn_MU = By.xpath("/html[1]/body[1]/div[47]/div[1]/div[1]/div[3]/button[2]");

	By delete_Input_Field_2 = By.xpath("(//body/div[ starts-with(@id,'confirm-modal-')]//input[@class='form-control'])[2]"); 

	public void verify_Category_Expand() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(category_Expand)));
	}
	
	public void verify_Add_Remove_Users() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_Remove_Users)));
	}
	
	public void verify_Add_Remove_Users_Modal() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_Remove_Users_Modal)));
	}
	
	public void verify_Delete_Input_Field_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Input_Field_2)));
	}
	
	public void verify_ContinueBtn_MU() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(continueBtn_MU)));
	}
	
	public void click_Category_Expand() {
		driver.findElement(category_Expand).click();
	}
	
	public void click_Add_Remove_Users() {
		driver.findElement(add_Remove_Users).click();
	}
	
	public void click_Workroom_Admin_User() {
		driver.findElement(workroom_Admin_User).click();
	}
	
	public void click_ContinueBtn_MU() {
		driver.findElement(continueBtn_MU).click();
	}
	
	public void sendKeys_Category() {
		driver.findElement(delete_Input_Field_2).click();
	}
	
	
	public void add_User_To_User_Category() throws InterruptedException {
		this.verify_Category_Expand();
		this.click_Category_Expand();
		Thread.sleep(1500);
		this.verify_Add_Remove_Users();
		this.click_Add_Remove_Users();
		Thread.sleep(1500);
		this.verify_Add_Remove_Users_Modal();
		this.click_Workroom_Admin_User();
		Thread.sleep(5000);
		this.verify_ContinueBtn_MU(); //------------------Selenium cant find this nested/layered continue button exhausted all solutions. confirmation has number atatched to it
		this.click_ContinueBtn_MU();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_Category_Created_Edit_Category() -----------");
	}
	
	public void verify_User_Added_Then_Delete() throws InterruptedException {
		this.verify_Category_Expand();
		this.click_Category_Expand();
		Thread.sleep(1000);
		this.verify_Add_Remove_Users();
		this.verify_Workroom_Admin();
		this.click_Newly_Created_User_Cat_Dropdown();
		this.verify_DeleteBtn_2();
		this.click_DeleteBtn_2();
		Thread.sleep(1000);
		this.verify_ContinueBtn_MU();
		this.sendKeys_Category();
		this.click_ContinueBtn_MU();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> verify_User_Added_Then_Delete() -----------");
	}
	*/
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
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Test_User();
		this.check_Workroom_Admin_Not_Visible();
		System.out.println("------- Completed --> verify_Workroom_Admin_Hidden() -----------");
	}
	
	public void verify_Workroom_Admin_Visible() throws InterruptedException {
		this.verify_AutoBE();
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
		this.verify_AutoBE();
		this.check_Marvel_Workroom_Visible();
		System.out.println("------- Completed --> verify_Marvel_Workroom() -----------");
	}
	
	// ---------------add_Users/Files_To_A_Workroom-----------
	By events = By.xpath("//div[starts-with (@id,'collapseWorkroom_')]//div[@class='row small-left']//label[contains(text(),'Events')]");
	By library = By.xpath("//span[contains(text(),'Library')]");
	By other_Files = By.xpath("//a[contains(text(),'Other Files')]");
	By autoBE_In_Res_Lib = By.xpath("//a[@class='active break-name'][contains(.,'AutoBE')]");
	By attach_Folder = By.xpath("//a[contains(text(),'Attach')]");
	By click_For_More_Options = By.xpath("//a[contains(text(),'click for more options')]");
	By browseBtn = By.xpath("//div[@class='form-group']//span[@class='input-group-btn']");
	By save_FileBtn = By.xpath("//button[@id='newResourceSubmit']");
	By document_Drp_Dwn = By.xpath("//a[contains(text(),'Word_1.docx')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By delete = By.xpath("//li[@class='delete']//a");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_Events() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(events)));
		
		WebElement element = driver.findElement(By.xpath("//a[@class='active'][contains(text(),'AutoBE')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Workroom_Admin_Dropdown() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Dropdown)));
		
		WebElement element = driver.findElement(By.xpath("(//table[@class='modal-table-list']//tbody//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Library() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(library)));
	}
	
	public void verify_Other_Files() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(other_Files)));
	}
	
	public void verify_AutoBE_In_Res_Lib() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_In_Res_Lib)));
	}
	
	public void verify_Attach_Folder() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Folder)));
	}
	
	public void verify_Click_For_More_Options() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(click_For_More_Options)));
	}
	
	public void verify_BrowseBtn() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(browseBtn)));
	}
	
	public void verify_DeleteBtn() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete)));
	}
	
	public void verify_ContinueBtn() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}
	
	public void scroll_To_Add_Files_To_Workroom() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[@id='collapseWorkroom_2305']//label[contains(text(),'Add Files to this Workroom')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void click_Add_Files_To_Workroom_Check_Box() {
		WebElement element = driver.findElement(By.xpath("//input[@id='advanced_2305_disable_files']"));
		if(!element.isSelected()) {
			driver.findElement(By.xpath("//input[@id='advanced_2305_disable_files']")).click();
		}
	}
	
	public void add_File_Resource() {
		String input = "//input[@id='files_']";
		String filepath = "C:\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
	}
	
	public void verify_Document_Visible() {
		String file = "//a[contains(text(),'Word_1.docx')]";
		Assert.assertTrue(driver.findElements(By.xpath(file)).size() > 0);
	}
	
	public void verify_Document_NOT_Visible() {
		String file = "//a[contains(text(),'Word_1.docx')]";
		Assert.assertTrue(driver.findElements(By.xpath(file)).size() < 1);
	}
	
	public void click_Libary() {
		driver.findElement(library).click();
	}
	
	public void click_Other_Files() {
		driver.findElement(other_Files).click();
	}
	
	public void click_AutoBE_In_Res_Lib() {
		//driver.findElement(autoBE_In_Res_Lib).click();
		WebElement element2 = driver.findElement(By.xpath("//a[@class='active break-name'][contains(.,'AutoBE')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Attach_Folder() {
		//driver.findElement(attach_Folder).click();
		WebElement element2 = driver.findElement(By.xpath("//a[contains(text(),'Attach')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_Save_FileBtn() {
		driver.findElement(save_FileBtn).click();
	}
	
	public void click_Click_For_More_Options() {
		driver.findElement(click_For_More_Options).click();
	}
	
	public void click_Document_Drp_Dwn() {
		driver.findElement(document_Drp_Dwn).click();
	}
	
	public void click_DeleteBtn() {
		//driver.findElement(delete).click();
		WebElement element2 = driver.findElement(By.xpath("//li[@class='delete']//a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void click_ContinueBtn() {
		//driver.findElement(continueBtn).click();
		WebElement element2 = driver.findElement(By.xpath("//button[@class='btn commit btn-danger']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}
	
	public void enable_Add_Files_To_Workroom_For_User() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.verify_Workroom_Admin_Dropdown();
		this.click_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.verify_Set_Permissions();
		this.click_Set_Permissions(); //make hidden
		this.verify_Mobile_Only_Check_Box();
		this.click_Manage_Files();
		Thread.sleep(1000);
		this.scroll_To_Add_Files_To_Workroom();
		this.click_Add_Files_To_Workroom_Check_Box();
		this.click_SaveBtn_Profile();
		Thread.sleep(3000);
		driver.navigate().refresh();
		this.verify_Settings();
		System.out.println("------- Completed --> add_Auto_Director_To_A_Workroom() -----------");
	}
	
	public void disable_Add_Files_To_Workroom_For_User() throws InterruptedException {
		this.verify_AutoBE_Expand();
		this.click_AutoBE_Expand();
		Thread.sleep(2000);
		this.verify_Workroom_Admin_Dropdown();
		this.click_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.verify_Set_Permissions();
		this.click_Set_Permissions(); //make hidden
		this.verify_Mobile_Only_Check_Box();
		this.disable_Manage_Files();
		Thread.sleep(1000);
		this.scroll_To_Add_Files_To_Workroom();
		this.click_Add_Files_To_Workroom_Check_Box();
		this.click_SaveBtn_Profile();
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> disable_Add_Files_To_Workroom_For_User() -----------");
	}
	
	public void user_Can_Open_Other_Files() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1000);
		this.verify_Library();
		this.click_Libary();
		Thread.sleep(1000);
		this.verify_Other_Files();
		this.click_Other_Files();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Open_Other_Files() -----------");
	}
	
	public void user_Can_Add_File_To_Workroom() throws InterruptedException {
		this.verify_AutoBE_In_Res_Lib();
		this.click_AutoBE_In_Res_Lib();
		Thread.sleep(1000);
		this.verify_Attach_Folder();
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		Thread.sleep(1000);
		this.verify_BrowseBtn();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.click_Save_FileBtn();
		Thread.sleep(2000);
		this.verify_Click_For_More_Options();
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_File_To_Workroom() -----------");
	}
	
	public void boardmember_Can_Add_File_To_Workroom() throws InterruptedException {
		this.verify_AutoBE_In_Res_Lib();
		this.click_AutoBE_In_Res_Lib();
		Thread.sleep(1000);
		this.verify_Attach_Folder();
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.click_Click_For_More_Options();
		Thread.sleep(1000);
		this.verify_BrowseBtn();
		this.add_File_Resource();
		Thread.sleep(1000);
		this.click_Save_FileBtn();
		Thread.sleep(2000);
		this.verify_Click_For_More_Options();
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Add_File_To_Workroom() -----------");
	}
	
	public void user_Can_Verify_File_Added() throws InterruptedException {
		this.verify_AutoBE_In_Res_Lib();
		this.click_AutoBE_In_Res_Lib();
		Thread.sleep(1000);
		this.verify_Attach_Folder();
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.verify_Document_Visible();
		System.out.println("------- Completed --> veirfy_File_Added() -----------");
	}
	
	public void user_Can_Delete_Document() throws InterruptedException {
		this.click_Document_Drp_Dwn();
		Thread.sleep(1000);
		this.verify_DeleteBtn();
		this.click_DeleteBtn();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_Document() -----------");
	}
	
	public void user_Can_Verify_File_Deleted() throws InterruptedException {
		this.verify_AutoBE_In_Res_Lib();
		this.click_AutoBE_In_Res_Lib();
		Thread.sleep(1000);
		this.verify_Attach_Folder();
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_Click_For_More_Options();
		this.verify_Document_NOT_Visible();
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Verify_File_Deleted() -----------");
	}
	
	//-----------"Validate-User-Role-Permissions"------------
	//By add_Remove_Accounts = By.xpath("//div[@class='account-name'][contains(.,'Add/Remove Accounts')]");
	By add_Remove_Accounts = By.xpath("//*[@id='wrap']/main//div/a[contains(.,'Edit Membership')]");
	By add_Remove_Accounts_Modal = By.xpath("//div[@id='addUsersModal']//div[@class='modal-header']");
	By group1 = By.xpath("//a[@class='workroom-name'][contains(.,'Group1')]");
	By nebula = By.xpath("//a[contains(text(),'Nebula')]");
	By galaxy = By.xpath("//a[contains(text(),'Galaxy')]");
	//By auto_User_Admin_1_Workroom_Admin = By.xpath("//a[contains(text(),'Auto User Admin1')]/following::span[contains(.,'Workroom Administrator')]");
	By auto_User_Admin_1_Workroom_Admin = By.xpath("//div[contains(text(),'Workroom Administrators')]/following::a[contains(text(),'Auto User Admin1')]");


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
		this.verify_AutoBE();
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
	
	// --------------Enable_Disable_Disclaimer--------------------------
	By security_Summary = By.xpath("//a[contains(text(),'Security Summary')]");
	By disclaimer = By.xpath("//a[contains(text(),'Disclaimer')]");
	By disclaimer_Check_Box = By.xpath("//input[@id='client_use_disclaimer']");
	By disclaimer_Label = By.xpath("//label[contains(text(),'Enable Disclaimer')]");
	By disclaimer_TextArea = By.xpath("//textarea[@id='client_login_disclaimer']");
	By saveBtn_DC = By.xpath("//div[@id='settingsModal']//button[@class='btn btn-done pull-right'][contains(text(),'Save')]");
	By disclaimer_Acceptance = By.xpath("//span[contains(text(),'Disclaimer Acceptance')]");
	By loginBtn = By.xpath("//button[contains(text(),'Log in to BoardEffect')]");

	
	public void verify_Security_Summary() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(security_Summary)));
	}
	
	public void verify_Disclaimer() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(disclaimer)));
	}
	
	public void verify_Disclaimer_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(disclaimer_Label)));
	}
	
	public void verify_Disclaimer_Acceptance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(disclaimer_Acceptance)));
	}
	
	public void click_Security_Summary() {
		driver.findElement(security_Summary).click();
	}
	
	public void click_SaveBtn_DC() {
		driver.findElement(saveBtn_DC).click();
	}
	
	public void click_Disclaimer() {
		driver.findElement(disclaimer).click();
	}
	
	public void click_Disclaimer_CheckBox() {
		driver.findElement(disclaimer_Check_Box).click();
	}

	public void enable_Disclaimer() throws InterruptedException {
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='client_use_disclaimer']"));
		String message = "disclaimer test message";
		
		if(!checkbox.isSelected()) {
			driver.findElement(disclaimer_Check_Box).click();
			Thread.sleep(1000);
			driver.findElement(disclaimer_TextArea).sendKeys(message);
		}
	}
	
	public void disable_Disclaimer() throws InterruptedException {
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='client_use_disclaimer']"));
		
		if(checkbox.isSelected()) {
			this.verify_Disclaimer_Label();
			driver.findElement(disclaimer_TextArea).clear();
			this.click_SaveBtn_DC();
			Thread.sleep(3000);
			this.click_Disclaimer();
			Thread.sleep(1000);
			this.click_Disclaimer_CheckBox();
			Thread.sleep(1000);
			this.click_SaveBtn_DC();
			Thread.sleep(3000);
		}
		
	}
	
	public void click_Disclaimer_Acceptance() {
		driver.findElement(disclaimer_Acceptance).click();
	}
	
	public void click_Login_Btn() {
		driver.findElement(loginBtn).click();
	}
	
	public void verify_Custom_Disclaimer_Message() {
		String message = "//p[contains(text(),'disclaimer test message')]";
		Assert.assertTrue(driver.findElements(By.xpath(message)).size() > 0);
	}
	
	public void enable_Disclaimer_Option() throws InterruptedException {
		this.verify_Disclaimer();
		this.click_Disclaimer();
		Thread.sleep(1000);
		this.verify_Disclaimer_Label();
		this.enable_Disclaimer();
		Thread.sleep(1000);
		this.click_SaveBtn_DC();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> enable_Disclaimer() -----------");
	}
	
	public void verify_Login_Disclaimer() throws InterruptedException {
		this.verify_Disclaimer_Acceptance();
		this.verify_Custom_Disclaimer_Message();
		this.click_Disclaimer_Acceptance();
		Thread.sleep(1000);
		this.click_Login_Btn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_Login_Disclaimer() -----------");
	}
	
	public void disable_Disclaimer_Option() throws InterruptedException {
		this.verify_Disclaimer();
		this.click_Disclaimer();
		Thread.sleep(1000);
		this.disable_Disclaimer();
		driver.navigate().refresh();
		System.out.println("------- Completed -->  disable_Disclaimer() -----------");
	}
	
	public void verify_Disclaimer_Disabled() throws InterruptedException {
		this.verify_Disclaimer();
		this.click_Disclaimer();
		Thread.sleep(2000);
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='client_use_disclaimer']"));
		Assert.assertNull(checkbox.getAttribute("checked"));

	}
	
	// --------------Password_Settings--------------------------
		By password_Settings = By.xpath("//a[contains(text(),'Password Settings')]");
		By allow_Repeated_Characters = By.xpath("//label[contains(text(),'Allow Repeated Characters')]");
		
		By min_Password_Length = By.xpath("//input[@id='pw_length']"); 		//Minimum Password Length 8
		By min_Letters = By.xpath("//input[@id='pw_letters']");				//Minimum Letters 1
		By min_Lowercase_Letters = By.xpath("//input[@id='pw_lowers']");	//Minimum Lowercase Letters 0
		By min_Uppercase_Letters = By.xpath("//input[@id='pw_uppers']");	//Minimum Uppercase Letters 0
		By min_Special_Characters = By.xpath("//input[@id='pw_specials']");	//Minimum Special Characters 0 
		By min_Digits = By.xpath("//input[@id='pw_digits']");				//Minimum Digits 1
		
		public void verify_Password_Settings() {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(password_Settings)));
		}
		
		public void verify_Allow_Repeated_Characters() {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(allow_Repeated_Characters)));
		}
		
		public void click_Password_Settings() {
			driver.findElement(password_Settings).click();
		}
		
		public void change_Password_Settings() {
			driver.findElement(min_Password_Length).clear();
			driver.findElement(min_Password_Length).sendKeys("9");
			
			driver.findElement(min_Letters).clear();
			driver.findElement(min_Letters).sendKeys("2");
			
			driver.findElement(min_Lowercase_Letters).clear();
			driver.findElement(min_Lowercase_Letters).sendKeys("1");
			
			driver.findElement(min_Uppercase_Letters).clear();
			driver.findElement(min_Uppercase_Letters).sendKeys("1");
			
			driver.findElement(min_Special_Characters).clear();
			driver.findElement(min_Special_Characters).sendKeys("1");
			
			driver.findElement(min_Digits).clear();
			driver.findElement(min_Digits).sendKeys("2");
		}
		
		public void default_Password_Settings() {
			driver.findElement(min_Password_Length).clear();
			driver.findElement(min_Password_Length).sendKeys("8");
			
			driver.findElement(min_Letters).clear();
			driver.findElement(min_Letters).sendKeys("1");
			
			driver.findElement(min_Lowercase_Letters).clear();
			driver.findElement(min_Lowercase_Letters).sendKeys("0");
			
			driver.findElement(min_Uppercase_Letters).clear();
			driver.findElement(min_Uppercase_Letters).sendKeys("0");
			
			driver.findElement(min_Special_Characters).clear();
			driver.findElement(min_Special_Characters).sendKeys("0");
			
			driver.findElement(min_Digits).clear();
			driver.findElement(min_Digits).sendKeys("1");
		}
		
		public void modify_Password_Settings() throws InterruptedException {
			this.verify_Password_Settings();
			this.click_Password_Settings();
			Thread.sleep(1000);
			this.verify_Allow_Repeated_Characters();
			this.change_Password_Settings();
			this.click_SaveBtn_DC();
			Thread.sleep(4000);
			driver.navigate().refresh();
		}
		
		public void back_To_Original_Password_Settings() throws InterruptedException {
			this.verify_Password_Settings();
			this.click_Password_Settings();
			Thread.sleep(1000);
			this.verify_Allow_Repeated_Characters();
			this.default_Password_Settings();
			this.click_SaveBtn_DC();
			Thread.sleep(2500);
			driver.navigate().refresh();
		}
	
}
