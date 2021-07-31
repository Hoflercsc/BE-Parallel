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
import parallel.DriverFactory;

public class EditResourceFolderPage {
	// ----------- POM Page Object model -----------------------------
	
	By libraries = By.xpath("//span[contains(text(),'Libraries')]");
	By new_Folder = By.xpath("//a[@class='new-folder']");
	By autoBE = By.xpath("//a[contains(@class,'break-name')][contains(text(),'AutoBE')]");

	// -------------user_Can_Open_Libraries_Form() -----------------------------
	public void verify_Libraries() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(libraries)));
	}

	public void verify_New_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder)));
	}
	
	public void verify_Library_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}
	

	public void click_Libraries() {
		//DriverFactory.getInstance().getDriver().findElement(libraries).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(),'Libraries')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
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
		this.verify_New_Library_Folder_1();
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
	By new_Folder_14 = By.xpath("//*[normalize-space(text()) ='New Library Folder 14']"); // need the //*


	public void verify_New_Folder_Name_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Folder_Name_Field)));
	}

	public void verify_New_Folder_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_Folder_Created)));
	}
	
	public void verify_RL_New_Folder_Button() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_Folder)));
	}
	
	public void verify_New_Folder_14_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_Folder_14)));
	}

	public void click_New_Folder() {
		//DriverFactory.getInstance().getDriver().findElement(new_Folder).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(new_Folder);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void folder_Name_SendKeys(String viewonlyfolder) {
		DriverFactory.getInstance().getDriver().findElement(new_Folder_Name_Field).sendKeys(viewonlyfolder);
	}
	
	
	public void click_SaveBtn() {
		DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}

	// --------------- Function being called --------------------
	public void user_Can_Create_New_Resource_Library_Folder(String newlibraryfolder20) throws InterruptedException {
		Thread.sleep(1500); // pause to make sure under folder
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder20);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_New_Folder_Created();
		System.out.println("------- Completed --> user_Can_Create_New_Resource_Library_Folder() -----------");
	}
	
	public void create_Non_View_Only_Resource_Library_Folder_14(String newlibraryfolder14) throws InterruptedException {
		Thread.sleep(1500); // wait to make sure under correct folder
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder14);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_New_Folder_14_Created();
		System.out.println("------- Completed --> create_Non_View_Only_Resource_Library_Folder_14() -----------");
	}
	
	
	// --------------- user_Attempts_Edit_Of_Library_Folder --------------------
	By edit_Option = By.xpath("//span[@class='translation_missing'][contains(text(),'Edit')]");
	By folder_Input_Field = By.xpath("//input[@id='efolder_name']");
	By cancel_Btn = By.xpath("//div[@id='newFolderModal']//button[@class='btn btn-default'][contains(text(),'Cancel')]");
	By close_Modal = By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']");
	By resource_Library_Folder_9_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 9']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_9_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 9']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	By resource_Library_Folder_10_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 10']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_10_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 10']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	By edited_Folder_10_Dropdown = By.xpath("(//*[normalize-space(text()) ='Edited Folder 10']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By edited_Folder_10_Delete_Option = By.xpath("//*[normalize-space(text()) ='Edited Folder 10']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	By resource_Library_Folder_17_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 17']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_17_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 17']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	By resource_Library_Folder_17_Edit_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 17']/following::div[@class='btn-group small open']//child::span[contains(text(),'Edit')]");
	By resource_Library_Folder_20_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 20']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_20_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 20']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_21_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 21']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_21_Edit_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 21']/following::div[@class='btn-group small open']//child::a[contains(.,'Edit')]");
	By resource_Library_Folder_21_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 21']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	
	By resource_Library_Folder_22_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 22']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_22_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 22']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");

	public void verify_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(edit_Option)));
	}

	public void verify_Resource_Library_Folder_17_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_17_Edit_Option)));
	}
	
	public void verify_Folder_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(folder_Input_Field)));
	}

	public void verify_Resource_Library_Folder_9_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_9_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_9_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_9_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_10_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_10_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_10_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_10_Delete_Option)));
	}
	
	public void verify_Edited_Folder_10_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(edited_Folder_10_Dropdown)));
	}
	
	public void verify_Edited_Folder_10_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(edited_Folder_10_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_17_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_17_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_17_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_17_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_20_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_20_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_20_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_20_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_21_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_21_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_21_Edit_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_21_Edit_Option)));
	}
	
	public void verify_Resource_Library_Folder_21_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_21_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_22_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_22_Dropdown)));
	}
	
	
	public void verify_Resource_Library_Folder_22_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_22_Delete_Option)));
	}
	
	public void click_New_Folder_Dropdown() {
		// DriverFactory.getInstance().getDriver().findElement(new_Folder_Created).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_New_Folder_Dropdown_2() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_New_View_Only_Folder_1_Dropdown() {
		String viewOnly = "//*[normalize-space(text()) ='New View Only Folder 1']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(viewOnly));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_New_View_Only_Folder_9_Dropdown() throws InterruptedException {
		WebElement str = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_9_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_9_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_New_View_Only_Folder_9_Delete_Option() throws InterruptedException {
		WebElement str = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_9_Delete_Option);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_9_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_10_Dropdown() throws InterruptedException {
		WebElement str = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_10_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_10_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_10_Delete_Option() throws InterruptedException {
		WebElement str = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_10_Delete_Option);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_10_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edited_Folder_10_Dropdown() throws InterruptedException {
		WebElement str = DriverFactory.getInstance().getDriver().findElement(edited_Folder_10_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(edited_Folder_10_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edited_Folder_10_Delete_Option() throws InterruptedException {
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(edited_Folder_10_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_17_Dropdown() throws InterruptedException {
		WebElement str = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_17_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_17_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_17_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_17_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_17_Edit_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_17_Edit_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edited_Folder_20_Dropdown() throws InterruptedException {
		WebElement str = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_20_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_20_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_20_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_20_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_21_Dropdown() throws InterruptedException {
		WebElement str = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_21_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_21_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_21_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_21_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_21_Edit_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_21_Edit_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_22_Dropdown() throws InterruptedException {
		WebElement str = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_22_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", str);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_22_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_22_Delete_Option() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_22_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	
	
	public void click_New_View_Only_Folder_2_Dropdown() throws InterruptedException {
		String viewOnly = "//*[normalize-space(text()) ='New View Only Folder 2']/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		
		WebElement vfolder = DriverFactory.getInstance().getDriver().findElement(By.xpath(viewOnly));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", vfolder);
		Thread.sleep(1000);
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(viewOnly));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edit_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[@class='translation_missing'][contains(text(),'Edit')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void sendkeys_Edit_Folder_Name() {
		DriverFactory.getInstance().getDriver().findElement(folder_Input_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(folder_Input_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(folder_Input_Field).sendKeys("New Library Folder 10");
	}
	
	public void sendkeys_Edit_Folder_Name_2(String newlibraryfolder22) {
		DriverFactory.getInstance().getDriver().findElement(folder_Input_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(folder_Input_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(folder_Input_Field).sendKeys(newlibraryfolder22);
	}
	
	public void sendkeys_Edit_Folder_Name_3() {
		DriverFactory.getInstance().getDriver().findElement(folder_Input_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(folder_Input_Field).clear();
		DriverFactory.getInstance().getDriver().findElement(folder_Input_Field).sendKeys("Edited Folder 10");
	}

	public void click_Cancel_Btn() {
		// DriverFactory.getInstance().getDriver().findElement(cancel_Btn).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='newFolderModal']//button[@class='btn btn-default'][contains(text(),'Cancel')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	public void close_Modal() {
		// DriverFactory.getInstance().getDriver().findElement(close_Modal).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='filesModal']//a[@class='atlas-close pull-right']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------- Function being called --------------------
	public void user_Attempts_Edit_Resource_Library_Folder_10() throws InterruptedException {
		this.verify_Resource_Library_Folder_10_Dropdown();
		this.click_Resource_Library_Folder_10_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1500);
		this.verify_Folder_Input_Field();
		this.sendkeys_Edit_Folder_Name();
		Thread.sleep(1000);
		this.click_Cancel_Btn();
		Thread.sleep(1500);
		this.close_Modal();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Edit_Library_Folder() -----------");
	}

	// --------------- user_Actually_Edits_Library_Folder --------------------
	// --------------- Function being called --------------------
	public void user_Actually_Edits_Library_Folder_10() throws InterruptedException {
		this.verify_Resource_Library_Folder_10_Dropdown();
		this.click_Resource_Library_Folder_10_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Option();
		this.click_Edit_Option();
		Thread.sleep(1500);
		this.verify_Folder_Input_Field();
		this.sendkeys_Edit_Folder_Name_3();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.close_Modal();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Actually_Edits_Library_Folder() -----------");
	}
	
	public void user_Actually_Edits_Library_Folder_21(String newlibraryfolder22) throws InterruptedException {
		this.click_Resource_Library_Folder_21_Dropdown();
		Thread.sleep(1500);
		this.verify_Resource_Library_Folder_21_Edit_Option();
		this.click_Resource_Library_Folder_21_Edit_Option();
		Thread.sleep(1500);
		this.verify_Folder_Input_Field();
		this.sendkeys_Edit_Folder_Name_2(newlibraryfolder22);
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Actually_Edits_Library_Folder_2() -----------");
	}
	
	// --------------- user_Verifies_New_Folder_Name --------------------
	By edited_Folder_10 = By.xpath("//a[contains(text(),'Edited Folder 10')]");

	public void verify_Edited_Folder_10() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(edited_Folder_10)));
	}

	
	// --------------- Edit-Existing-Folder-To-View-Only --------------------
	By view_Only_Label = By.xpath("//label[contains(text(),'View Only')]");
	By new_Library_Folder = By.xpath("//span[contains(text(),'New Library Folder')]");
	
	//----------new elements -------------------
	By new_View_Only_Folder_1 = By.xpath("//*[normalize-space(text()) ='New View Only Folder 1']");
	By new_View_Only_Folder_2 = By.xpath("//*[normalize-space(text()) ='New View Only Folder 2']");
	By copy_File_Link_Folder = By.xpath("//*[normalize-space(text()) ='Copy File Link Folder']");
	By copy_File_Link_Folder_2 = By.xpath("//*[normalize-space(text()) ='Copy File Link Folder 2']");
	By sub_Folders_In_View_Only = By.xpath("//*[normalize-space(text()) ='Sub Folders In View Only']");
	By resource_Libray_Folder_9_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 9']");
	By resource_Libray_Folder_10_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 10']");
	By resource_Libray_Folder_13_Created = By.xpath("//*[normalize-space(text()) ='New Library Folder 13']");
	By resource_Library_View_Only_Folder_13_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 13']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_View_Only_Folder_13_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 13']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");
	By resource_Library_Folder_14_Dropdown = By.xpath("(//*[normalize-space(text()) ='New Library Folder 14']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By resource_Library_Folder_14_Delete_Option = By.xpath("//*[normalize-space(text()) ='New Library Folder 14']/following::div[@class='btn-group small open']//child::a[contains(text(),'Delete')]");

	public void verify_New_Library_Folder_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_View_Only_Folder_1)));
	}
	
	public void verify_New_Library_Folder_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(new_View_Only_Folder_2)));
	}
	
	public void verify_Copy_File_Link_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_File_Link_Folder)));
	}
	
	public void verify_Copy_File_Link_Folder_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(copy_File_Link_Folder_2)));
	}
	
	public void verify_Folder_Sub_Folder_In_View_Only_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(sub_Folders_In_View_Only)));
	}
	
	public void verify_Resource_Libray_Folder_9_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_9_Created)));
	}
	
	public void verify_Resource_Libray_Folder_10_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_10_Created)));
	}
	
	public void verify_Resource_Libray_Folder_13_Created() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Libray_Folder_13_Created)));
	}
	
	public void verify_View_Only_Resource_Libray_Folder_13_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_View_Only_Folder_13_Dropdown)));
	}
	
	public void verify_View_Only_Resource_Libray_Folder_13_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_View_Only_Folder_13_Delete_Option)));
	}
	
	public void verify_Resource_Library_Folder_14_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_14_Dropdown)));
	}
	
	public void verify_Resource_Library_Folder_14_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(resource_Library_Folder_14_Delete_Option)));
	}
	
	public void click_View_Only_Resource_Library_Folder_13_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_View_Only_Folder_13_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_View_Only_Folder_13_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
		}
		
	public void click_View_Only_Resource_Library_Folder_13_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_View_Only_Folder_13_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Resource_Library_Folder_14_Dropdown() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_14_Dropdown);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_14_Dropdown);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
		}
		
	public void click_Resource_Library_Folder_14_Delete_Option() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(resource_Library_Folder_14_Delete_Option);
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	//----------new elements -------------------

	public void verify_View_Only_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(view_Only_Label)));
	}

	public void click_To_Enable_View_Only_Box() {
		String string = "//input[@id='efolder_view_only']";
		WebElement view_Only = DriverFactory.getInstance().getDriver().findElement(By.xpath(string));
		
		if(!view_Only.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", view_Only);
		}
	}
	
	public void click_To_Disable_View_Only_Box() {
		String string = "//input[@id='efolder_view_only']";
		WebElement view_Only = DriverFactory.getInstance().getDriver().findElement(By.xpath(string));
		
		if(view_Only.isSelected()) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", view_Only);
		}
	}
	
	public void create_View_Only_Resource_Library_Folder(String viewonlyfolder) throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(viewonlyfolder);
		this.click_To_Enable_View_Only_Box();
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.verify_New_Library_Folder_1();
		Thread.sleep(1500);
		this.close_Modal();
		System.out.println("------- Completed --> user_Can_Create_New_Resource_Library_Folder() -----------");
	}
	
	public void create_View_Only_Resource_Library_Folder2(String viewonlyfolder) throws InterruptedException {
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(viewonlyfolder);
		this.click_To_Enable_View_Only_Box();
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_New_Library_Folder_2();
		Thread.sleep(1000);
		this.close_Modal();
		System.out.println("------- Completed --> user_Can_Create_New_Resource_Library_Folder() -----------");
	}
	
	public void create_Resource_Library_Folder_Copy_File_Link_Folder(String viewonlyfolder) throws InterruptedException {
		Thread.sleep(1500);// add wait to make sure in folder category
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(viewonlyfolder);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Copy_File_Link_Folder();
		Thread.sleep(1000);
		this.close_Modal();
		System.out.println("------- Completed --> create_Resource_Library_Folder_Copy_File_Link() -----------");
	}
	
	public void create_View_Only_Resource_Library_Folder_Copy_File_Link_Folder_2(String viewonlyfolder) throws InterruptedException {
		Thread.sleep(2000);// add wait to make sure in folder category
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(viewonlyfolder);
		this.click_To_Enable_View_Only_Box();
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Copy_File_Link_Folder_2();
		Thread.sleep(1000);
		this.close_Modal();
		System.out.println("------- Completed --> create_View_Only_Resource_Library_Folder_Copy_File_Link_Folder_2() -----------");
	}
	
	public void create_View_Only_Resource_Library_SubFolders_In_View_Only_Folder(String viewonlyfolder) throws InterruptedException {
		Thread.sleep(1500);// add wait to make sure in folder category
		this.verify_RL_New_Folder_Button();
		this.click_New_Folder();
		Thread.sleep(1500);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(viewonlyfolder);
		this.click_To_Enable_View_Only_Box();
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Folder_Sub_Folder_In_View_Only_Folder();
		Thread.sleep(1000);
		this.close_Modal();
		System.out.println("------- Completed --> create_View_Only_Resource_Library_SubFolders_In_View_Only_Folder() -----------");
	}
	
	public void user_Create_View_Only_Resource_Library_Folder_9(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_To_Enable_View_Only_Box();
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_9_Created();
		System.out.println("------- Completed --> user_Create_Resource_Library_Folder_9() -----------");
	}
	
	public void user_Create_View_Only_Resource_Library_Folder_10(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_10_Created();
		System.out.println("------- Completed --> user_Create_View_Only_Resource_Library_Folder_10() -----------");
	}
	
	public void user_Create_View_Only_Resource_Library_Folder_13(String newlibraryfolder3) throws InterruptedException {
		Thread.sleep(2000); // need to wait to establish in autoattend workroom
		this.click_New_Folder();
		Thread.sleep(1000);
		this.verify_New_Folder_Name_Field();
		this.folder_Name_SendKeys(newlibraryfolder3);
		this.click_To_Enable_View_Only_Box();
		this.click_SaveBtn();
		Thread.sleep(1000);
		this.verify_Resource_Libray_Folder_13_Created();
		System.out.println("------- Completed --> user_Create_View_Only_Resource_Library_Folder_13() -----------");
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Changes_Folder_To_View_Only() -----------");
	}	
	
	public void user_Disables_View_Only_On_Folder_17() throws InterruptedException {
		this.click_Resource_Library_Folder_17_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_17_Edit_Option();
		this.click_Resource_Library_Folder_17_Edit_Option();
		Thread.sleep(1000);
		this.verify_View_Only_Label();
		this.click_To_Disable_View_Only_Box();
		Thread.sleep(1000);
		this.click_SaveBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Disables_View_Only_On_Folder() -----------");
	}	
		
	// --------------- user_Can_Delete_File--------------------
	By resource_Dropdown = By.xpath("//a[contains(text(),'steve System')]/following::td[@class='modal-cell dropdown-cell']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By delete_Option = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(delete_Option)));
	}

	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void click_Resource_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(resource_Dropdown).click();
	}

	public void click_Delete_Option() {
		DriverFactory.getInstance().getDriver().findElement(delete_Option).click();
	}

	public void click_ContinueBtn() {
		DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
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
		DriverFactory.getInstance().getDriver().findElement(folder_Dropdown).click();
	}
	
	public void click_Folder_Dropdown_2() {
		DriverFactory.getInstance().getDriver().findElement(folder_Dropdown_2).click();
	}
	
	
	// --------------- verify_Folder_Deleted --------------------

	public void verify_Folder_NOT_Present() throws InterruptedException {
		String file_Title = "//*[contains(text(),'Edited Folder Name')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Folder_NOT_Present_2() throws InterruptedException {
		String file_Title = "//a[contains(text(),'New Library Folder')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Folder_NOT_Present_3() throws InterruptedException {
		String file_Title = "//a[contains(text(),'New Library Folder 2')]/following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_New_View_Only_Folder_1_NOT_Present() throws InterruptedException {
		String file_Title = "//*[normalize-space(text()) ='New View Only Folder 1']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_New_View_Only_Folder_9_NOT_Present() throws InterruptedException {
		String file_Title = "(//*[normalize-space(text()) ='New Library Folder 9']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}

	public void verify_New_View_Only_Folder_2_NOT_Present() throws InterruptedException {
		String file_Title = "//*[normalize-space(text()) ='New View Only Folder 2']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_View_Only_Folder_13_NOT_Present() throws InterruptedException {
		String file_Title = "(//*[normalize-space(text()) ='New Library Folder 13']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Folder_14_NOT_Present() throws InterruptedException {
		String file_Title = "(//*[normalize-space(text()) ='New Library Folder 14']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Folder_17_NOT_Present() throws InterruptedException {
		String file_Title = "(//*[normalize-space(text()) ='New Library Folder 17']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Folder_Sub_Folders_In_View_Only_NOT_Present() throws InterruptedException {
		String file_Title = "//*[normalize-space(text()) ='Sub Folders In View Only']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Edited_Folder_10_NOT_Present() throws InterruptedException {
		String file_Title = "(//*[normalize-space(text()) ='Edited Folder 10']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Edited_Folder_20_NOT_Present() throws InterruptedException {
		Thread.sleep(1500);
		String file_Title = "(//*[normalize-space(text()) ='Edited Folder 20']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	public void verify_Folder_22_Present() throws InterruptedException {
		String file_Title = "(//*[normalize-space(text()) ='New Library Folder 22']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() > 0);
	}
	
	public void verify_Folder_22_NOT_Present() throws InterruptedException {
		String file_Title = "(//*[normalize-space(text()) ='New Library Folder 22']/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(file_Title)).size() < 1);
	}
	
	// --------------- Function being called --------------------
	
	public void user_Can_Delete_View_Only_Folder_2() throws InterruptedException {
		this.click_New_View_Only_Folder_2_Dropdown();// contains //span not //a
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Delete_View_Only_Folder_2() -----------");
	}
	
	public void user_Can_Delete_Boardmember_View_Only_Folder() throws InterruptedException {
		this.click_New_View_Only_Folder_1_Dropdown();// contains //span not //a
		Thread.sleep(1000);
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Delete_View_Only_Folder() -----------");
	}
	
	public void user_Can_Delete_View_Only_Folder_9() throws InterruptedException {
		this.verify_Resource_Library_Folder_9_Dropdown();
		this.click_New_View_Only_Folder_9_Dropdown();// contains //span not //a
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_9_Delete_Option();
		this.click_New_View_Only_Folder_9_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_Delete_View_Only_Folder_9() -----------");
	}
	
	// --------------- Function being called --------------------
	public void user_Can_Delete_Edited_Folder_10() throws InterruptedException {
		this.verify_Edited_Folder_10_Dropdown();
		this.click_Edited_Folder_10_Dropdown();
		Thread.sleep(1500);
		this.verify_Edited_Folder_10_Delete_Option();
		this.click_Edited_Folder_10_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Delete_Edited_Folder_10() -----------");
	}
	
	public void user_Can_Delete_View_Only_Library_Folder_13() throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.verify_View_Only_Resource_Libray_Folder_13_Dropdown();
		this.click_View_Only_Resource_Library_Folder_13_Dropdown();
		Thread.sleep(1000);
		this.verify_View_Only_Resource_Libray_Folder_13_Delete_Option();
		this.click_View_Only_Resource_Library_Folder_13_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	public void user_Can_Delete_Library_Folder_14() throws InterruptedException {
		Thread.sleep(1500); // need to wait to establish in autoattend workroom
		this.verify_Resource_Library_Folder_14_Dropdown();
		this.click_Resource_Library_Folder_14_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_14_Delete_Option();
		this.click_Resource_Library_Folder_14_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	public void user_Can_Delete_Library_Folder_17() throws InterruptedException {
		this.verify_Resource_Library_Folder_17_Dropdown();
		this.click_Resource_Library_Folder_17_Dropdown();
		Thread.sleep(1000);
		this.verify_Resource_Library_Folder_17_Delete_Option();
		this.click_Resource_Library_Folder_17_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Delete_Folder() -----------");
	}
	
	public void user_Can_Delete_Library_Folder_20() throws InterruptedException {
		this.verify_Resource_Library_Folder_20_Dropdown();
		this.click_Edited_Folder_20_Dropdown();
		Thread.sleep(1500);
		this.verify_Resource_Library_Folder_20_Delete_Option();
		this.click_Resource_Library_Folder_20_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Delete_Library_Folder_20() -----------");
	}
	
	public void user_Can_Delete_Library_Folder_22() throws InterruptedException {
		this.verify_Resource_Library_Folder_22_Dropdown();
		this.click_Resource_Library_Folder_22_Dropdown();
		Thread.sleep(1500);
		this.verify_Resource_Library_Folder_22_Delete_Option();
		this.click_Resource_Library_Folder_22_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Delete_Library_Folder_22() -----------");
	}
	
	// --------------- Function being called --------------------
	public void verify_View_Only_Folder_Deleted() throws InterruptedException {
		this.verify_New_View_Only_Folder_1_NOT_Present();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_View_Only_Folder_Deleted() -----------");
	}
	
	public void verify_View_Only_Folder_2_Deleted() throws InterruptedException {
		this.verify_New_View_Only_Folder_2_NOT_Present();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_View_Only_Folder_2_Deleted() -----------");
	}
}
