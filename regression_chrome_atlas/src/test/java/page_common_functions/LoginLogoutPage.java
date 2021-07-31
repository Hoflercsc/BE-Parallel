package page_common_functions;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.aventstack.extentreports.ExtentTest;

public class LoginLogoutPage {
	ExtentTest test;
	WebDriver driver;

	public LoginLogoutPage(WebDriver driver) {
		this.driver = driver;
	}
	// ----------- POM Page Object model -----------------------------
	By usernameinput = By.xpath("id(\"login_login\")");
	By passwordinput = By.xpath("id(\"login_password\")");
	By loginbutton = By.xpath("id(\"login\")/form[1]/button[1]");
	By labloginbutton = By.xpath("//button[@class='btn btn-success']");
	By loginlab = By.xpath("//button[@class='btn btn-success']");
	By disclaimerAcceptance = By.xpath("//span[@class='translation_missing'][contains(text(),'Disclaimer Acceptance')]");

	// --------------- Elements and Methods -------------------------------
	public void verify_Username_Field() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(usernameinput)));
	}
	
	public void verify_Disclaimer_Acceptance() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(disclaimerAcceptance)));
	}


	public void set_Username(String autoTester) {
		driver.findElement(usernameinput).sendKeys(autoTester);
	}

	public void set_Password(String password) {
		driver.findElement(passwordinput).sendKeys(password);
	}


	// ---------------------------------------------------
	public void click_BoardEffect_Login() {
		driver.findElement(loginbutton).click();
	}

	public void click_BoardEffect_Lab_Login() {
		driver.findElement(loginlab).click();
	}
	
	public void click_Disclaimer_Acceptance() {
		driver.findElement(disclaimerAcceptance).click();
	}
	
	// -------------------- Normal User Function --------------------------
	public void login_BE(String autoTester, String password) throws InterruptedException {
		String lab_Url = "https://lab.boardeffect.com/login/disclaimer";
		this.verify_Username_Field();
		this.set_Username(autoTester);
		this.set_Password(password);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean login = driver.findElements(labloginbutton).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (login == true) {
			driver.findElement(labloginbutton).click();
			Thread.sleep(1500);
		}else {
			this.click_BoardEffect_Login();
			Thread.sleep(1500);
		}
		
		if (driver.getCurrentUrl().contains(lab_Url)) {
			this.verify_Disclaimer_Acceptance();
			this.click_Disclaimer_Acceptance();
			Thread.sleep(1000);
			driver.findElement(labloginbutton).click();
			Thread.sleep(1500);
		}	 
		
		System.out.println("------- Completed -->  User_Can_Login() -----------");

	}

	// --------user can logout ------------
	By user_Profile_Dropdown = By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By sign_Out = By.xpath("//a[contains(text(),'Sign Out')]");

	public void verify_User_Profile_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Profile_Dropdown)));
	}

	public void verify_Sign_Out() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(sign_Out)));
	}

	public void click_User_Profile_Dropdown() {
		// driver.findElement(user_Profile_Dropdown).click();
		WebElement element2 = driver.findElement(By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}

	public void click_Sign_Out() {
		// driver.findElement(sign_Out).click();
		WebElement element2 = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element2);
	}

	// --------------Function Being called-------------------------------------
	public void user_Can_Logout() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_User_Profile_Dropdown();
		this.click_User_Profile_Dropdown();
		Thread.sleep(1000);
		this.verify_Sign_Out();
		this.click_Sign_Out();
		Thread.sleep(1500);
		System.out.println("------- Completed -->  User_Can_Logout() -----------");
	}
}
