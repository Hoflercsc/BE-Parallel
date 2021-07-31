package page_critical_scenarios;

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

public class ForeignLanguagePage {
	static String homePage = "https://automation-ozzie.boardeffect.com/login";
	WebDriver driver;

	public ForeignLanguagePage(WebDriver driver) {
		this.driver = driver;
	}

	// --------------open_User_Profile_SystemAdmin ---------------------------
	By steveSystem_User_Dropdown= By.xpath("(//a[contains(text(),'steve System')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By systemAdminEng_User_Dropdown= By.xpath("(//a[contains(text(),'system admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By workroomAdminEng_User_Dropdown= By.xpath("(//a[contains(text(),'workroom admineng')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_Tester_Dropdown= By.xpath("(//a[contains(text(),'Automation Tester')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By workroom_Admin_Dropdown= By.xpath("(//a[contains(text(),'Workroom Admin')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By auto_Director_Dropdown= By.xpath("(//a[contains(text(),'Auto Director')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By edit_Profile = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");
	By edit_Profile_Spanish = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Editar Perfil')]");
	
	public void verify_SystemAdminEng_User_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(systemAdminEng_User_Dropdown)));
	}
	
	public void verify_Steve_System_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(steveSystem_User_Dropdown)));
	}
	
	public void verify_Auto_Tester_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Tester_Dropdown)));
	}
	
	public void verify_Workroom_Admin_Dropdown_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin_Dropdown)));
	}
	
	public void verify_Workroom_Admin_Eng_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdminEng_User_Dropdown)));
	}
	
	public void verify_Auto_Director_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director_Dropdown)));
	}
	
	public void verify_edit_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Profile)));
	}
	
	public void verify_edit_Profile_Spanish() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Profile_Spanish)));
	}
	
	public void click_Steve_System_Dropdown() {
		driver.findElement(steveSystem_User_Dropdown).click();
	}
	
	public void click_System_Admin_Eng_Dropdown() {
		driver.findElement(systemAdminEng_User_Dropdown).click();
	}
	
	public void click_Workroom_Admin_Eng_Dropdown() {
		driver.findElement(workroomAdminEng_User_Dropdown).click();
	}
	
	public void click_Auto_Tester_Dropdown() {
		driver.findElement(auto_Tester_Dropdown).click();
	}
	
	public void click_Auto_Director_Dropdown() {
		driver.findElement(auto_Director_Dropdown).click();
	}
	
	public void click_Workroom_Admin_2_Dropdown() {
		driver.findElement(workroom_Admin_Dropdown).click();
	}
	
	public void click_Edit_Profile() throws InterruptedException {
		//driver.findElement(edit_Profile).click();
		WebElement scroll = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edit_Profile_Spanish() throws InterruptedException {
		//driver.findElement(edit_Profile).click();
		WebElement scroll = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Editar Perfil')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Editar Perfil')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
		
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_SystemAdmin() throws InterruptedException {
		this.verify_Steve_System_Dropdown();
		Thread.sleep(1000);
		this.click_Steve_System_Dropdown();
		Thread.sleep(1000);
		this.verify_edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_SystemAdmin() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_SystemAdminEng() throws InterruptedException {
		this.verify_SystemAdminEng_User_Dropdown();
		Thread.sleep(1000);
		this.click_System_Admin_Eng_Dropdown();
		Thread.sleep(1000);
//		this.verify_edit_Profile();
//		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_SystemAdminEng() -----------");
	}
		
   // --------------Function Being Called ---------------------------
	public void open_User_Profile_SystemAdmin_Spanish() throws InterruptedException {
		this.verify_Steve_System_Dropdown();
		Thread.sleep(1000);
		this.click_Steve_System_Dropdown();
		Thread.sleep(1000);
		this.verify_edit_Profile_Spanish();
		Thread.sleep(1000);
		this.click_Edit_Profile_Spanish();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_SystemAdmin_Spanish() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_Automation_Tester() throws InterruptedException {
		this.verify_Auto_Tester_Dropdown();
		Thread.sleep(1000);
		this.click_Auto_Tester_Dropdown();
		Thread.sleep(1000);
		this.verify_edit_Profile();
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
		this.verify_edit_Profile();
		Thread.sleep(1000);
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
		this.verify_edit_Profile_Spanish();
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
		this.verify_edit_Profile_Spanish();
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
		this.verify_edit_Profile();
		Thread.sleep(1000);
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_User_Profile_NonAdmin() -----------");
	}	
	
	// --------------Function Being Called ---------------------------
	public void open_User_Profile_NonAdmin_Spanish() throws InterruptedException {
		this.verify_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.click_Auto_Director_Dropdown();
		Thread.sleep(1000);
		this.verify_edit_Profile_Spanish();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_Tab)));
	}
	
	public void verify_Settings_Tab_Spanish() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings_Tab_Spanish)));
	}
	
	public void verify_First_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(first_Name_Field)));
	}
	
	public void verify_AutoBE_Saved_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Saved_Message)));
	}
	
	public void verify_Steve_System_Saved_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(steveSystem_Saved_Message)));
	}
	
	public void verify_Steve_System_Saved_Message_Spanish() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(steveSystem_Message_Spanish)));
	}
	
	
	public void click_Settings_Tab() {
		//driver.findElement(settings_Tab).click();
		WebElement element = driver.findElement(By.xpath("//body/div[@id='profileModal']//div/form/div/ul/li/a[contains(.,'Settings')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Settings_Tab_Spanish() {
		//driver.findElement(settings_Tab).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Ajustes')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Save_Btn() {
		//driver.findElement(save_Btn).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void scroll_To_Language_Dropdown() throws InterruptedException {
		//driver.findElement(edit_Profile).click();
		WebElement scroll = driver.findElement(By.xpath("//label[contains(text(),'Interface Language')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
	}
	
	public void scroll_Click_Language_Dropdown() throws InterruptedException {
		//driver.findElement(edit_Profile).click();
		WebElement scroll = driver.findElement(By.xpath("//label[contains(text(),'Interface Language')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		String dropdown = "//div[@class='col-sm-5']//div[@class='btn-group bootstrap-select form-control chosen']//button[@class='btn dropdown-toggle btn-default']";
		WebElement element = driver.findElement(By.xpath(dropdown));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void scroll_Click_Language_Dropdown_Spanish() throws InterruptedException {
		//driver.findElement(edit_Profile).click();
		WebElement scroll = driver.findElement(By.xpath("//label[contains(text(),'Idioma de la Interfaz')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
		Thread.sleep(1500);
		String dropdown = "//div[@class='col-sm-5']//div[@class='btn-group bootstrap-select form-control chosen']//button[@class='btn dropdown-toggle btn-default']";
		WebElement element = driver.findElement(By.xpath(dropdown));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Spanish_And_Save() throws InterruptedException {
		driver.findElement(spanish).click();
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_English_And_Save() throws InterruptedException {
		driver.findElement(english).click();
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//button[@id='save-user']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
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
		WebElement element = driver.findElement(By.xpath("//div[@id='profileModal']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	By everybody = By.xpath("//a[contains(text(),'Everybody')]");
	
	public void verify_Everybody() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(everybody)));
	}
	
	public void click_Everybody() throws InterruptedException {
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Everybody')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void close_Profile_And_Directory() throws InterruptedException {
		this.close_Profile();
		Thread.sleep(2000);
		this.verify_Everybody();
		this.click_Everybody();
		Thread.sleep(2000);
		HomeNavigationPage obj = new HomeNavigationPage(driver);
		obj.user_Close_Directory();
		System.out.println("------- Completed --> close_Profile_And_Directory() -----------");
	}
	
	// --------------verify_Spanish_Welcome_Message---------------------------
	By spanish_Welcome_Heading = By.xpath("//h1[contains(text(),'Bienvenida')]");
	By english_Welcome_Heading = By.xpath("//h1[contains(text(),'Welcome')]");
	//By atlas_Left_Nav = By.xpath("//*[@id='wrap']//div[@class='atlas-leftnav expanded atlas-l']");
	By atlas_Left_Nav = By.xpath("//*[@id='wrap']//div[@class='atlas-leftnav atlas-l expanded']");

	
	public void verify_Spanish_Welcome() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(spanish_Welcome_Heading)));
	}
	
	public void verify_English_Welcome() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(english_Welcome_Heading)));
	}

	public void verify_Spanish_Welcome_Heading() throws InterruptedException {
		this.verify_Spanish_Welcome();
		System.out.println("------- Completed --> close_Profile_And_Directory() -----------");
	}
	
	public void verify_Atlas_Left_Nav() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
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
