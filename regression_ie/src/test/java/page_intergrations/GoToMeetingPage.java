package page_intergrations;

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
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;

public class GoToMeetingPage {
	static String homePage = "https://automation-ozzie.boardeffect.com/login";
	WebDriver driver;

	public GoToMeetingPage(WebDriver driver) {
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
	
	// --------------deactivate_GoTo_Meeting---------------------------
	By goto_Configure = By.xpath("//div//div[3]//div[1]//div[1]//div[1]//a[1]//i[1]");
	By active_Intergration = By.xpath("//h2[contains(text(),'Activate Integration')]");
	By intergration_CheckBox = By.xpath("//input[@id='integration_active']");
	By saveBtn = By.xpath("//button[@class='btn btn-done pull-right']");

	public void verify_GoTo_Meeting_Configure() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(goto_Configure)));
	}

	public void verify_Active_Intergration() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(active_Intergration)));
	}

	public void click_GoTo_Meeting_Configure() {
		driver.findElement(goto_Configure).click();
	}

	public void click_Intergration_CheckBox() {
		// driver.findElement(intergration_CheckBox).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='integration_active']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void click_SaveBtn() {
		driver.findElement(saveBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void deactivate_GoTo_Meeting() throws InterruptedException {
		Thread.sleep(1000);
		this.click_GoTo_Meeting_Configure();
		Thread.sleep(1500);
		this.verify_Active_Intergration();
		this.click_Intergration_CheckBox();
		Thread.sleep(2000);
		this.click_SaveBtn();
		Thread.sleep(1500);
		this.click_Close_Modal();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(1500);
		System.out.println("------- Completed --> deactivate_GoTo_Meeting() -----------");
	}
	
	// --------------reactivate_GoTo_Meeting---------------------------
	By close_Modal = By.xpath("//a[@id='settingsModalClose']");

	public void click_Close_Modal() {
		driver.findElement(close_Modal).click();
	}

	// --------------Function Being Called ---------------------------
	public void reactivate_GoTo_Meeting() throws InterruptedException {
		Thread.sleep(1000);
		this.click_GoTo_Meeting_Configure();
		Thread.sleep(1500);
		this.verify_Active_Intergration();
		Thread.sleep(1000);
		this.click_Intergration_CheckBox();
		Thread.sleep(1500);
		this.click_SaveBtn();
		System.out.println("------- Completed --> deactivate_GoTo_Meeting() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	By goto_reactivate = By.xpath("//a[@id='activate-integration-gtm']");

	public void verify_GoTo_Meeting_Activation() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(goto_reactivate)));
	}

	public void verify_GoTo_Meeting_Reactivation() throws InterruptedException {
		this.verify_Single_Sign_On();
		Thread.sleep(1000);
		this.click_Video_Conferencing();
		Thread.sleep(1500);
		this.verify_GoTo_Meeting_Activation();
		System.out.println("------- Completed --> verify_GoTo_Meeting_Reactivation() -----------");
	}
}
