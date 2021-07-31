package page_intergrations;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import parallel.DriverFactory;

public class GoToMeetingPage {
	
	// --------------navigate_To_Video_Conferencing---------------------------
	By integrations = By.xpath("//li[13]");
	//By video_Conferencing = By.xpath("//a[contains(text(),'Video Conferencing')]");
	By single_Sign_On = By.xpath("//li[@class='active']//a[contains(text(),'Single Sign-On')]");

	public void verify_Integrations() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(integrations)));
	}

	public void verify_Single_SignOn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(single_Sign_On)));
	}

	public void click_Integrations() {
		DriverFactory.getInstance().getDriver().findElement(integrations).click();
	}

	public void click_Video_Conferencing() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(video_Conferencing).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id=\"settingsModal\"]/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/ul/li[3]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	public void navigate_To_Video_Conferencing() throws InterruptedException {
		this.verify_Integrations();
		Thread.sleep(1000);
		this.click_Integrations();
		Thread.sleep(1500);
		this.verify_Single_SignOn();
		Thread.sleep(1000);
		this.click_Video_Conferencing();
		Thread.sleep(1500);
		System.out.println("------- Completed --> navigate_To_Video_Conferencing() -----------");
	}
	// --------------deactivate_GoTo_Meeting---------------------------
	//By goto_Configure = By.xpath("//div//div[3]//div[1]//div[1]//div[1]//a[1]//i[1]");
	By goto_Configure = By.xpath("//body/div[@id='settingsModal']/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/i[1]");
	By active_Intergration = By.xpath("//h2[contains(text(),'Activate Integration')]");
	By intergration_CheckBox = By.xpath("//input[@id='integration_active']");
	By saveBtn = By.xpath("//button[@class='btn btn-done pull-right']");

	public void verify_GoTo_Meeting_Configure() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(goto_Configure)));
	}

	public void verify_Active_Intergration() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(active_Intergration)));
	}

	public void click_GoTo_Meeting_Configure() {
		DriverFactory.getInstance().getDriver().findElement(goto_Configure).click();
	}

	public void click_To_Deactivate_Intergration_CheckBox() {
		String string = "//input[@id='integration_active']";
		WebElement box = DriverFactory.getInstance().getDriver().findElement(By.xpath(string));
		
		if(box.isSelected()) {
			// DriverFactory.getInstance().getDriver().findElement(intergration_CheckBox).click();
			WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='integration_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
		}
	}
	
	public void click_To_Activate_Intergration_CheckBox() {
		String string = "//input[@id='integration_active']";
		WebElement box = DriverFactory.getInstance().getDriver().findElement(By.xpath(string));
		
		if(!box.isSelected()) {
			// DriverFactory.getInstance().getDriver().findElement(intergration_CheckBox).click();
			WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='integration_active']"));
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
		}
	}

	public void click_SaveBtn() {
		DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void deactivate_GoTo_Meeting() throws InterruptedException {
		Thread.sleep(1000);
		this.click_GoTo_Meeting_Configure();
		Thread.sleep(1500);
		this.verify_Active_Intergration();
		this.click_To_Deactivate_Intergration_CheckBox();
		Thread.sleep(2000);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.click_Close_Modal();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1500);
		System.out.println("------- Completed --> deactivate_GoTo_Meeting() -----------");
	}
	
	// --------------reactivate_GoTo_Meeting---------------------------
	By close_Modal = By.xpath("//a[@id='settingsModalClose']");

	public void click_Close_Modal() {
		DriverFactory.getInstance().getDriver().findElement(close_Modal).click();
	}

	// --------------Function Being Called ---------------------------
	public void reactivate_GoTo_Meeting() throws InterruptedException {
		Thread.sleep(1000);
		this.click_GoTo_Meeting_Configure();
		Thread.sleep(1500);
		this.verify_Active_Intergration();
		Thread.sleep(1000);
		this.click_To_Activate_Intergration_CheckBox();
		Thread.sleep(1500);
		this.click_SaveBtn();
		System.out.println("------- Completed --> reactivate_GoTo_Meeting() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	By goto_reactivate = By.xpath("//a[@id='activate-integration-gtm']");

	public void verify_GoTo_Meeting_Activation() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(goto_reactivate)));
	}

	public void verify_GoTo_Meeting_Reactivation() throws InterruptedException {
		this.verify_Single_SignOn();
		Thread.sleep(1000);
		this.click_Video_Conferencing();
		Thread.sleep(1500);
		this.verify_GoTo_Meeting_Activation();
		System.out.println("------- Completed --> verify_GoTo_Meeting_Reactivation() -----------");
	}
}
