package page_intergrations;

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

public class ZoomPage {
	static String homePage = "https://automation-ozzie.boardeffect.com/login";
	WebDriver driver;

	public ZoomPage(WebDriver driver) {
		this.driver = driver;
	}
	// --------------navigate_To_Video_Conferencing---------------------------
	By integrations = By.xpath("//li[13]");
	//By video_Conferencing = By.xpath("//a[contains(text(),'Video Conferencing')]");
	By single_Sign_On = By.xpath("//li[@class='active']//a[contains(text(),'Single Sign-On')]");

	public void verify_Integrations() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(integrations)));
	}

	public void verify_Single_Sign_On() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(single_Sign_On)));
	}

	public void click_Integrations() {
		driver.findElement(integrations).click();
	}

	public void click_Video_Conferencing() throws InterruptedException {
		//driver.findElement(video_Conferencing).click();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"settingsModal\"]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/ul/li[3]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	public void navigate_To_Video_Conferencing() throws InterruptedException {
		this.verify_Integrations();
		Thread.sleep(1000);
		this.click_Integrations();
		Thread.sleep(1500);
		this.verify_Single_Sign_On();
		Thread.sleep(1000);
		this.click_Video_Conferencing();
		Thread.sleep(1500);
		System.out.println("------- Completed --> navigate_To_Video_Conferencing() -----------");
	}
	// --------------configure_Zoom---------------------------
	By zoom_Configure = By.xpath("//div//div//div//div//div//div[3]//div[2]//div[1]//div[1]//a[1]//i[1]");
	By active_Intergration = By.xpath("//h2[contains(text(),'Activate Integration')]");
	By intergration_CheckBox = By.xpath("//input[@id='integration_active']");
	By saveBtn = By.xpath("//button[@class='btn btn-done pull-right']");
	By intergration_Name = By.xpath("//input[@id='config_name']");
	By zoom_Key_Field = By.xpath("//input[@id='config_key']");
	By Zoon_Secret_Field = By.xpath("//input[@id='config_secret']");
	String name = "Zoom";
	String zoomKey = "9QDfubziTvuMlj5G9U1-_Q";
	String zoomSecret = "GO3w5qOwT0dwJ5Ku4HyTQk12cjEYBi6Civ6g";

	public void verify_Zoom_Configure() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(zoom_Configure)));
	}

	public void verify_Active_Intergration() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(active_Intergration)));
	}

	public void click_Zoom_Configure() {
		driver.findElement(zoom_Configure).click();
	}

	public void click_Intergration_CheckBox() {
		// driver.findElement(intergration_CheckBox).click();
		String string = "//input[@id='integration_active']";
		WebElement box = driver.findElement(By.xpath(string));
		
		if(!box.isSelected()) {
			// driver.findElement(intergration_CheckBox).click();
			WebElement element = driver.findElement(By.xpath("//input[@id='integration_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
		
	}
	
	public void click_Deactivate_Intergration_CheckBox() {
		// driver.findElement(intergration_CheckBox).click();
		String string = "//input[@id='integration_active']";
		WebElement box = driver.findElement(By.xpath(string));
		
		if(box.isSelected()) {
			// driver.findElement(intergration_CheckBox).click();
			WebElement element = driver.findElement(By.xpath("//input[@id='integration_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
		
	}

	public void zoom_Fill_Form() {
		driver.findElement(intergration_Name).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(intergration_Name).clear();
		driver.findElement(intergration_Name).sendKeys(name);
		driver.findElement(zoom_Key_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(zoom_Key_Field).clear();
		driver.findElement(zoom_Key_Field).sendKeys(zoomKey);
		driver.findElement(Zoon_Secret_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(Zoon_Secret_Field).clear();
		driver.findElement(Zoon_Secret_Field).sendKeys(zoomSecret);
	}

	public void zoom_clear_Form() {
		driver.findElement(intergration_Name).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(intergration_Name).clear();
		driver.findElement(zoom_Key_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(zoom_Key_Field).clear();
		driver.findElement(Zoon_Secret_Field).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(Zoon_Secret_Field).clear();
	}

	public void click_SaveBtn() {
		driver.findElement(saveBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void configure_Zoom() throws InterruptedException {
		Thread.sleep(1000);
		this.click_Zoom_Configure();
		Thread.sleep(1500);
		this.verify_Active_Intergration();
		this.zoom_Fill_Form();
		this.click_Intergration_CheckBox();
		Thread.sleep(2000);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.click_Close_Modal();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(1500);
		System.out.println("------- Completed --> configure_Zoom() -----------");
	}
	// --------------clear_Zoom_Form---------------------------
	By close_Modal = By.xpath("//a[@id='settingsModalClose']");

	public void click_Close_Modal() {
		driver.findElement(close_Modal).click();
	}

	// --------------Function Being Called ---------------------------
	public void clear_Zoom_Form() throws InterruptedException {
		Thread.sleep(1000);
		this.click_Zoom_Configure();
		Thread.sleep(1500);
		this.verify_Active_Intergration();
		this.zoom_clear_Form();
		Thread.sleep(1000);
		this.click_Deactivate_Intergration_CheckBox();
		Thread.sleep(1500);
		this.click_SaveBtn();
		Thread.sleep(3000);
		System.out.println("------- Completed --> clear_Zoom_Form() -----------");
	}
	// --------------Function Being Called ---------------------------
	By zoom_Deactivate = By.xpath("//a[@id='deactivate-integration-zoom']");

	public void verify_Zoom_Deactivated() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(zoom_Deactivate)));
	}

	public void verify_Zoom_Deactivation() throws InterruptedException {
		this.verify_Single_Sign_On();
		Thread.sleep(1000);
		this.click_Video_Conferencing();
		Thread.sleep(1500);
		this.verify_Zoom_Deactivated();
		System.out.println("------- Completed --> verify_Zoom_Deactivation() -----------");
	}
}
