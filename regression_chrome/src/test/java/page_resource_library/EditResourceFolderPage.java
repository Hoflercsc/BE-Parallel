package page_resource_library;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class EditResourceFolderPage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;

	public EditResourceFolderPage(WebDriver driver) {
		this.driver = driver;
	}
	By libraries = By.xpath("//span[contains(text(),'Libraries')]");
	By new_Folder = By.xpath("//a[@class='new-folder']");
	By autoBE = By.xpath("//a[contains(@class,'break-name')][contains(text(),'AutoBE')]");

	// -------------user_Can_Open_Libraries_Form() -----------------------------
	public void verify_Libraries() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(libraries)));
	}

	public void verify_New_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder)));
	}
	
	public void verify_Library_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}
	

	public void click_Libraries() {
		//driver.findElement(libraries).click();
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Libraries')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------- Function being called --------------------
	public void user_Can_Open_Libraries_Form() throws InterruptedException {
		this.verify_Libraries();
		this.click_Libraries();
		Thread.sleep(1500);
		this.verify_New_Folder();
		System.out.println("------- Completed --> user_Can_Open_Libraries_Form() -----------");
	}
	
	public void user_Can_Open_Libraries_Form_2() throws InterruptedException {
		this.verify_Libraries();
		this.click_Libraries();
		Thread.sleep(1500);
		this.verify_New_Lib_Folder();
		System.out.println("------- Completed --> user_Can_Open_Libraries_Form() -----------");
	}
	
	public void user_Can_Open_Libraries_Form_3() throws InterruptedException {
		this.verify_Libraries();
		this.click_Libraries();
		Thread.sleep(1500);
		this.verify_Library_AutoBE();
		System.out.println("------- Completed --> user_Can_Open_Libraries_Form() -----------");
	}
	// --------------- user_User_Create_New__Resource_Library_Folder
	// --------------------
	By new_Folder_Name_Field = By.xpath("//input[@id='efolder_name']");
	By saveBtn = By.xpath("//button[@id='newFolderSubmit']");
	By new_Folder_Created = By.xpath("//a[contains(text(),'New Library Folder')]");
	By new_Folder_Created_2 = By.xpath("//a[contains(text(),'New Library Folder 2')]");

	public void verify_New_Folder_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Name_Field)));
	}

	public void verify_New_Folder_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Created)));
	}
	
	public void verify_New_Folder_Created_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Created_2)));
	}

	public void click_New_Folder() {
		driver.findElement(new_Folder).click();
	}

	public void folder_Name_SendKeys() {
		String folder_Name = "New Library Folder";
		driver.findElement(new_Folder_Name_Field).sendKeys(folder_Name);
	}
	
	public void folder_Name_SendKeys_2() {
		String folder_Name = "New Library Folder 2";
		driver.findElement(new_Folder_Name_Field).sendKeys(folder_Name);
	}

	public void click_SaveBtn() {
		driver.findElement(saveBtn).click();
	}

	// --------------- Function being called --------------------
	public void user_Can_Create_New_Resource_Library_Folder() throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys();
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_New_Folder_Created();
		System.out.println("------- Completed --> user_Can_Create_New_Resource_Library_Folder() -----------");
	}
	
	public void create_Non_View_Only_Resource_Library_Folder() throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys_2();
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_New_Folder_Created_2();
		System.out.println("------- Completed --> create_Non_View_Only_Resource_Library_Folder() -----------");
	}
	
	
	// --------------- user_Attempts_Edit_Of_Library_Folder --------------------
	By edit_Option = By.xpath("//span[@class='translation_missing'][contains(text(),'Edit')]");
	By folder_Input_Field = By.xpath("//input[@id='efolder_name']");
	By cancel_Btn = By.xpath("//div[@id='newFolderModal']//button[@class='btn btn-default'][contains(text(),'Cancel')]");
	By close_Modal = By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']");

	public void verify_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit_Option)));
	}

	public void verify_Folder_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(folder_Input_Field)));
	}

	public void click_New_Folder_Dropdown() {
		// driver.findElement(new_Folder_Created).click();
		WebElement element = driver.findElement(By.xpath("//td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_View_Only_Folder_Dropdown() {
		// driver.findElement(new_Folder_Created).click();
		String viewOnly = "//span[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		WebElement element = driver.findElement(By.xpath(viewOnly));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	

	public void click_Edit_Option() {
		// driver.findElement(edit_Option).click();
		WebElement element = driver.findElement(By.xpath("//span[@class='translation_missing'][contains(text(),'Edit')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void sendkeys_Folder_Input_Field() {
		driver.findElement(folder_Input_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(folder_Input_Field).clear();
		driver.findElement(folder_Input_Field).sendKeys("Edited Folder Name");
	}

	public void click_Cancel_Btn() {
		// driver.findElement(cancel_Btn).click();
		WebElement element = driver.findElement(By.xpath("//div[@id='newFolderModal']//button[@class='btn btn-default'][contains(text(),'Cancel')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void close_Modal() {
		// driver.findElement(close_Modal).click();
		WebElement element = driver.findElement(By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------- Function being called --------------------
	public void user_Attempts_Edit_Of_Library_Folder() throws InterruptedException {
		this.click_New_Folder_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1500);
		this.verify_Folder_Input_Field();
		this.sendkeys_Folder_Input_Field();
		Thread.sleep(1000);
		this.click_Cancel_Btn();
		Thread.sleep(1500);
		this.close_Modal();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Edit_Library_Folder() -----------");
	}

	// --------------- user_Actually_Edits_Library_Folder --------------------
	// --------------- Function being called --------------------
	public void user_Actually_Edits_Library_Folder() throws InterruptedException {
		this.click_New_Folder_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1500);
		this.verify_Folder_Input_Field();
		this.sendkeys_Folder_Input_Field();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.close_Modal();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Actually_Edits_Library_Folder() -----------");
	}
	// --------------- user_Verifies_New_Folder_Name --------------------
	By edited_Folder_Name = By.xpath("//a[contains(text(),'Edited Folder Name')]");

	public void verify_Folder_Name() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edited_Folder_Name)));
	}

	// --------------- Function being called --------------------
	public void user_Verifies_New_Folder_Name() throws InterruptedException {
		this.verify_Folder_Name();
		System.out.println("------- Completed --> user_Verifies_New_Folder_Name() -----------");
	}
	
	// --------------- Edit-Existing-Folder-To-View-Only --------------------
	By view_Only_Label = By.xpath("//label[contains(text(),'View Only')]");
	By new_Library_Folder = By.xpath("//span[contains(text(),'New Library Folder')]");

	public void verify_View_Only_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(view_Only_Label)));
	}
	
	public void verify_New_Lib_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Library_Folder)));
	}
	
	public void click_To_Enable_View_Only_Box() {
		String string = "//input[@id='efolder_view_only']";
		WebElement view_Only = driver.findElement(By.xpath(string));
		
		if(!view_Only.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", view_Only);
		}
	}
	
	public void click_To_Disable_View_Only_Box() {
		String string = "//input[@id='efolder_view_only']";
		WebElement view_Only = driver.findElement(By.xpath(string));
		
		if(view_Only.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", view_Only);
		}
	}
	
	public void create_View_Only_New_Resource_Library_Folder() throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys();
		this.click_To_Enable_View_Only_Box();
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_New_Lib_Folder();
		Thread.sleep(1500);
		this.close_Modal();
		System.out.println("------- Completed --> user_Can_Create_New_Resource_Library_Folder() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Changes_Folder_To_View_Only() throws InterruptedException {
		this.click_New_Folder_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1500);
		this.verify_View_Only_Label();
		this.click_To_Enable_View_Only_Box();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.close_Modal();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Changes_Folder_To_View_Only() -----------");
	}	
	
	public void user_Disables_View_Only_On_Folder() throws InterruptedException {
		this.click_New_Folder_Dropdown();
		Thread.sleep(1000);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1000);
		this.verify_View_Only_Label();
		this.click_To_Disable_View_Only_Box();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.close_Modal();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Disables_View_Only_On_Folder() -----------");
	}	
		
	// --------------- user_Can_Delete_File--------------------
	By resource_Dropdown = By.xpath("//a[contains(text(),'steve System')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By delete_Option = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void click_Resource_Dropdown() {
		driver.findElement(resource_Dropdown).click();
	}

	public void click_Delete_Option() {
		driver.findElement(delete_Option).click();
	}

	public void click_ContinueBtn() {
		driver.findElement(continueBtn).click();
	}

	// --------------- Function being called --------------------
	public void user_Can_Delete_File() throws InterruptedException {
		this.click_Resource_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		System.out.println("------- Completed --> user_Can_Delete_File() -----------");
	}
	// --------------- user_Can_Delete_Folder --------------------
	By folder_Dropdown = By.xpath("//a[contains(text(),'Edited Folder Name')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By folder_Dropdown_2 = By.xpath("//a[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");
	By folder_Dropdown_3 = By.xpath("//a[contains(text(),'New Library Folder 2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']");

	public void click_Folder_Dropdown() {
		driver.findElement(folder_Dropdown).click();
	}
	
	public void click_Folder_Dropdown_2() {
		driver.findElement(folder_Dropdown_2).click();
	}
	
	public void click_Folder_Dropdown_3() {
		driver.findElement(folder_Dropdown_3).click();
	}

	// --------------- Function being called --------------------
	public void user_Can_Delete_Folder() throws InterruptedException {
		this.click_Folder_Dropdown();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	public void user_Can_Delete_Folder_2() throws InterruptedException {
		this.click_Folder_Dropdown_2();
		Thread.sleep(1500);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	public void user_Can_Delete_Folder_3() throws InterruptedException {
		this.click_Folder_Dropdown_3();
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	// --------------- verify_Folder_Deleted --------------------

	public void verify_Folder_NOT_Present() throws InterruptedException {
		String file_Title = "//*[contains(text(),'Edited Folder Name')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Folder_NOT_Present_2() throws InterruptedException {
		String file_Title = "//a[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Folder_NOT_Present_3() throws InterruptedException {
		String file_Title = "//a[contains(text(),'New Library Folder 2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_View_Only_Folder_NOT_Present() throws InterruptedException {
		String file_Title = "//span[contains(text(),'New Library Folder')]";
		Assert.assertTrue(driver.findElements(By.xpath(file_Title)).size() < 1);
	}

	// --------------- Function being called --------------------
	public void verify_Folder_Deleted() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Folder_NOT_Present();
		this.close_Modal();
		Thread.sleep(1500);
		System.out.println("------- Completed --> verify_Folder_Deleted() -----------");
	}
	
	public void verify_Folder_Deleted_2() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Folder_NOT_Present_2();
		this.close_Modal();
		Thread.sleep(1500);
		System.out.println("------- Completed --> verify_Folder_Deleted() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Delete_View_Only_Folder() throws InterruptedException {
		this.click_New_Folder_Dropdown();// contains //span not //a
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Delete_View_Only_Folder() -----------");
	}
	
	public void user_Can_Delete_Boardmember_View_Only_Folder() throws InterruptedException {
		this.click_View_Only_Folder_Dropdown();// contains //span not //a
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Delete_View_Only_Folder() -----------");
	}
	
	// --------------- Function being called --------------------
	public void verify_View_Only_Folder_Deleted() throws InterruptedException {
		this.verify_View_Only_Folder_NOT_Present();
		this.close_Modal();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_View_Only_Folder_Deleted() -----------");
	}
}
