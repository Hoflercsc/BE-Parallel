package page_critical_scenarios;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
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
import parallel.DriverFactory;

public class ForeignLanguagePage {

	// --------------open_User_Profile_SystemAdmin ---------------------------
	By steveSystem_User_Dropdown= By.xpath("(//a[contains(text(),'steve System')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By autoAdminUserGS11_Dropdown= By.xpath("(//a[contains(text(),'Auto Admin User GS 11')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");

	By systemAdminEng_User_Dropdown= By.xpath("(//a[contains(text(),'system admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By workroomAdminEng_User_Dropdown= By.xpath("(//a[contains(text(),'workroom admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By workroomAdminEng2_User_Dropdown= By.xpath("(//a[contains(text(),'workroom admineng2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");

	By auto_Tester_Dropdown= By.xpath("(//a[contains(text(),'Automation Tester')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By workroom_Admin_Dropdown= By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_Director_Dropdown= By.xpath("(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By edit_Profile = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");
	By edit_Profile_Spanish = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Editar Perfil')]");
	
	public void verify_SystemAdminEng_User_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(systemAdminEng_User_Dropdown)));
	}
	
	public void verify_Steve_System_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(steveSystem_User_Dropdown)));
	}
	
	public void verify_AutoAdminUserGS11_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(autoAdminUserGS11_Dropdown)));
	}
	
	public void verify_Auto_Tester_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Tester_Dropdown)));
	}
	
//	public void verify_Workroom_Admin_Dropdown_2() {
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
//				.ignoring(NoSuchElementException.class);
//		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Dropdown)));
//	}
	
	public void verify_Workroom_Admin_Eng_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdminEng_User_Dropdown)));
	}
	
	public void verify_Workroom_Admin_Eng_2_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdminEng2_User_Dropdown)));
	}
	
	public void verify_Auto_Director_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director_Dropdown)));
	}
	
	public void verify_Edit_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(edit_Profile)));
	}
	
	public void verify_Edit_Profile_Spanish() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(edit_Profile_Spanish)));
	}
	
	public void click_Steve_System_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(steveSystem_User_Dropdown).click();
	}
	
	public void click_AutoAdminUserGS11_Dropdown_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(autoAdminUserGS11_Dropdown).click();
	}
	
	public void click_System_Admin_Eng_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(systemAdminEng_User_Dropdown).click();
	}
	
	public void click_Workroom_Admin_Eng_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(workroomAdminEng_User_Dropdown).click();
	}
	
	public void click_Workroom_Admin_Eng_2_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(workroomAdminEng2_User_Dropdown).click();
	}
	
	public void click_Auto_Tester_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(auto_Tester_Dropdown).click();
	}
	
	public void click_Auto_Director_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(auto_Director_Dropdown).click();
	}
	
	public void click_Workroom_Admin_2_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(workroom_Admin_Dropdown).click();
	}
	
	public void click_Edit_Profile() throws InterruptedException {
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edit_Profile_Spanish() throws InterruptedException {
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Editar Perfil')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Editar Perfil')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
		
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_Automation_Tester() throws InterruptedException {
		this.verify_Auto_Tester_Dropdown();
		Thread.sleep(1000);
		this.click_Auto_Tester_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_Automation_Tester -----------");
	}	
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_Workroom_Admin() throws InterruptedException {
		this.verify_Workroom_Admin_Eng_Dropdown();
		Thread.sleep(1000);
		this.click_Workroom_Admin_Eng_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_Workroom_Admin -----------");
	}
	
	public void open_User_Profile_Workroom_Admin_Eng_2(String workroomadmineng2) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(workroomadmineng2);
		this.verify_Workroom_Admin_Eng_2_Dropdown();
		Thread.sleep(1000);
		this.click_Workroom_Admin_Eng_2_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_Workroom_Admin -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_Automation_Tester_Spanish() throws InterruptedException {
		this.verify_Auto_Tester_Dropdown();
		Thread.sleep(1000);
		this.click_Auto_Tester_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile_Spanish();
		Thread.sleep(1000);
		this.click_Edit_Profile_Spanish();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_Automation_Tester_Spanish() -----------");
	}
	
	public void open_User_Profile_Workroom_Admin_Spanish() throws InterruptedException {
		this.verify_Workroom_Admin_Eng_Dropdown();
		Thread.sleep(1000);
		this.click_Workroom_Admin_Eng_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile_Spanish();
		Thread.sleep(1000);
		this.click_Edit_Profile_Spanish();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_Workroom_Admin_Spanish() -----------");
	}
	

	// --------------Function Being Called ---------------------------
	public void open_User_Profile_NonAdmin() throws InterruptedException {
		this.verify_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.click_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_NonAdmin() -----------");
	}
	

	By user_Search_Field = By.xpath("//input[@id='keyword']");
	By auto_User1 = By.xpath("(//a[contains(text(),'Auto User1')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");

	public void verify_User_Search_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Search_Field)));
	}
	
	public void enter_Name_In_Default_Search(String autouser1) throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(user_Search_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(user_Search_Field).sendKeys(autouser1);
		DriverFactory.getInstance().getDriver().findElement(user_Search_Field).sendKeys(Keys.RETURN);
		Thread.sleep(1000);	
	}
	
	public void verify_Auto_User_1_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(auto_User1)));
	}
	
	public void click_Auto_User_1_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(auto_User1);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void open_User_Profile_Non_Admin_Auto_User_1(String autouser1) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autouser1);
		Thread.sleep(1000);
		this.verify_Auto_User_1_Dropdown();
		this.click_Auto_User_1_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_Non_Admin_Auto_User_1_Profile() -----------");
	}
	
	public void open_Admin_Profile_SystemAdminEng(String systemadmineng) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(systemadmineng);
		this.verify_SystemAdminEng_User_Dropdown();
		Thread.sleep(1000);
		this.click_System_Admin_Eng_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_SystemAdminEng() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void open_Admin_Profile_AutoAdminUserGS11(String autoadminusergs11) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autoadminusergs11);
		this.verify_AutoAdminUserGS11_Dropdown();
		Thread.sleep(1000);
		this.click_AutoAdminUserGS11_Dropdown_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_SystemAdmin() -----------");
	}
	
	public void open_Admin_Profile_AutoAdminUserGS11_Spanish(String autoadminusergs11) throws InterruptedException {
		this.verify_User_Search_Field();
		this.enter_Name_In_Default_Search(autoadminusergs11);
		this.verify_AutoAdminUserGS11_Dropdown();
		Thread.sleep(1000);
		this.click_AutoAdminUserGS11_Dropdown_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile_Spanish();
		Thread.sleep(1000);
		this.click_Edit_Profile_Spanish();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_SystemAdmin_Spanish() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_NonAdmin_Spanish() throws InterruptedException {
		this.verify_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.click_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Profile_Spanish();
		Thread.sleep(1000);
		this.click_Edit_Profile_Spanish();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_Automation_Tester_Spanish() -----------");
	}
		
   // --------------verify_Foreign_Language---------------------------
	By settings_Tab = By.xpath("//body/div[@id='profileModal']//div/form/div/ul/li/a[contains(.,'Settings')]");
	By settings_Tab_Spanish = By.xpath("//a[contains(text(),'Ajustes')]");

	By first_Name_Field = By.xpath("//input[@id='user_firstname']");
	By save_Btn = By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']");
	By autoBE_Saved_Message = By.xpath("//p[contains(text(),'Profile for Automation Tester has been saved.')]");
	By steveSystem_Saved_Message = By.xpath("//p[contains(text(),'has been saved.')]");
	By steveSystem_Message_Spanish = By.xpath("//p[contains(text(),'ha guardado.')]");
	By spanish = By.xpath("//span[contains(text(),'Spanish')]");
	By english = By.xpath("//span[contains(text(),'English')]");

	public void verify_Settings_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_Tab)));
	}
	
	public void verify_Settings_Tab_Spanish() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_Tab_Spanish)));
	}
	
	public void verify_First_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(first_Name_Field)));
	}
	
	public void verify_AutoBE_Saved_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Saved_Message)));
	}
	
	public void verify_Steve_System_Saved_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(steveSystem_Saved_Message)));
	}
	
	public void verify_Steve_System_Saved_Message_Spanish() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(steveSystem_Message_Spanish)));
	}
	
	
	public void click_Settings_Tab() {
		//DriverFactory.getInstance().getDriver().findElement(settings_Tab).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//body/div[@id='profileModal']//div/form/div/ul/li/a[contains(.,'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Settings_Tab_Spanish() {
		//DriverFactory.getInstance().getDriver().findElement(settings_Tab).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Ajustes')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Save_Btn() {
		//DriverFactory.getInstance().getDriver().findElement(save_Btn).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void scroll_To_Language_Dropdown() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(edit_Profile).click();
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Interface Language')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
	}
	
	public void scroll_Click_Language_Dropdown() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(edit_Profile).click();
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Interface Language')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		String dropdown = "//div[@class='col-sm-5']//div[@class='btn-group bootstrap-select form-control chosen']//button[@class='btn dropdown-toggle btn-default']";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(dropdown));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void scroll_Click_Language_Dropdown_Spanish() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(edit_Profile).click();
		WebElement scroll = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Idioma de la Interfaz')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		String dropdown = "//div[@class='col-sm-5']//div[@class='btn-group bootstrap-select form-control chosen']//button[@class='btn dropdown-toggle btn-default']";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(dropdown));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Spanish_And_Save() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(spanish).click();
		Thread.sleep(1500);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_English_And_Save() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(english).click();
		Thread.sleep(1500);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	public void select_Foreign_Language_Spanish() throws InterruptedException {
		this.verify_Settings_Tab();
		this.click_Settings_Tab();
		Thread.sleep(1500);
		this.verify_First_Name_Field();
		Thread.sleep(1000);
		this.scroll_Click_Language_Dropdown();
		Thread.sleep(1000);
		this.click_Spanish_And_Save();
		//this.click_Save_Btn();
		Thread.sleep(1000);
		this.verify_Steve_System_Saved_Message();
		System.out.println("------- Completed --> enable_Hide_User_From_Directory() -----------");
	}	
	
	// --------------Function Being Called ---------------------------
	public void navigate_To_English_Language() throws InterruptedException {
		this.verify_Settings_Tab();
		this.click_Settings_Tab();
		Thread.sleep(1500);
		this.verify_First_Name_Field();
		Thread.sleep(1000);
		this.scroll_To_Language_Dropdown();
		this.click_Save_Btn();
		Thread.sleep(1000);
		this.verify_Steve_System_Saved_Message();
		System.out.println("------- Completed --> navigate_To_English_Language() -----------");
	}	
	
	
	// --------------Function Being Called ---------------------------
	public void select_Foreign_Language_English() throws InterruptedException {
		this.verify_Settings_Tab_Spanish();
		this.click_Settings_Tab_Spanish();
		Thread.sleep(1500);
		this.verify_First_Name_Field();
		Thread.sleep(1000);
		this.scroll_Click_Language_Dropdown_Spanish();
		Thread.sleep(1000);
		this.click_English_And_Save();
		//this.click_Save_Btn();
		Thread.sleep(1000);
		this.verify_Steve_System_Saved_Message_Spanish();
		System.out.println("------- Completed --> enable_Hide_User_From_Directory() -----------");
	}	
	
	// --------------close_Profile_And_Directory---------------------------
	public void close_Profile() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	By everybody = By.xpath("//a[contains(text(),'Everybody')]");
	
	public void verify_Everybody() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(everybody)));
	}
	
	public void click_Everybody() throws InterruptedException {
		Thread.sleep(1500);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Everybody')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void close_Profile_And_Directory() throws InterruptedException {
		this.close_Profile();
		Thread.sleep(2000);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(2000);
		HomeNavigationPage obj = new HomeNavigationPage();
		obj.user_Close_Directory();
		System.out.println("------- Completed --> close_Profile_And_Directory() -----------");
	}
	
	// --------------verify_Spanish_Welcome_Message---------------------------
	By spanish_Welcome_Heading = By.xpath("//h1[contains(text(),'Bienvenida')]");
	By english_Welcome_Heading = By.xpath("//h1[contains(text(),'Welcome')]");
	//By atlas_Left_Nav = By.xpath("//*[@id='wrap']//div[@class='atlas-leftnav expanded atlas-l']");
	By atlas_Left_Nav = By.xpath("//*[@id='wrap']//div[@class='atlas-leftnav atlas-l expanded']");

	
	public void verify_Spanish_Welcome() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(spanish_Welcome_Heading)));
	}
	
	public void verify_English_Welcome() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(english_Welcome_Heading)));
	}

	public void verify_Spanish_Welcome_Heading() throws InterruptedException {
		this.verify_Spanish_Welcome();
		System.out.println("------- Completed --> close_Profile_And_Directory() -----------");
	}
	
	public void verify_Atlas_Left_Nav() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(atlas_Left_Nav)));
	}
	
	public void verify_English_Welcome_Heading() throws InterruptedException {
		this.verify_English_Welcome();
		System.out.println("------- Completed --> close_Profile_And_Directory() -----------");
	}
	
	public void verify_Atlas_Left_Nav_Bar() throws InterruptedException {
		this.verify_Atlas_Left_Nav();
		System.out.println("------- Completed --> verify_Atlas_Left_Nav() -----------");
	}


}
