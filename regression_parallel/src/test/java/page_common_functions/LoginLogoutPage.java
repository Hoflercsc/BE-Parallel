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
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import parallel.DriverFactory;
import tests_critical_scenarios.BaseTestCriticalScenarios;

public class LoginLogoutPage extends BaseTestCriticalScenarios {
	
	
	// ----------- POM Page Object model -----------------------------
	By usernameInput = By.xpath("id(\"login_login\")");
	By passwordInput = By.xpath("id(\"login_password\")");
	By loginButton = By.xpath("id(\"login\")/form[1]/button[1]");
	By newLoginButton = By.xpath("//button[@class='signin-button']");
	By labLoginButton = By.xpath("//button[@class='btn btn-success']");
	By loginLab = By.xpath("//button[@class='btn btn-success']");
	By disclaimerAcceptance = By.xpath("//span[@class='translation_missing'][contains(text(),'Disclaimer Acceptance')]");

	// --------------- Elements and Methods -------------------------------
	public void verify_Username_Field() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(usernameInput)));
	}
	
	public void verify_Disclaimer_Acceptance() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(disclaimerAcceptance)));
	}

	public void set_Username(String autoTester) {
		DriverFactory.getInstance().getDriver().findElement(usernameInput).sendKeys(autoTester);
	}

	public void set_Password(String password) {
		DriverFactory.getInstance().getDriver().findElement(passwordInput).sendKeys(password);
	}
	
	public void clear_Login_Username_Password_Fields() {
		DriverFactory.getInstance().getDriver().findElement(usernameInput).clear();
		DriverFactory.getInstance().getDriver().findElement(passwordInput).clear();
	}


	// ---------------------------------------------------
	public void click_BoardEffect_Login() {
		DriverFactory.getInstance().getDriver().findElement(loginButton).click();
	}
	
	public void click_New_Log_In_Button() {
		DriverFactory.getInstance().getDriver().findElement(newLoginButton).click();
	}

	public void click_BoardEffect_Lab_Login() {
		DriverFactory.getInstance().getDriver().findElement(loginLab).click();
	}
	
	public void click_Disclaimer_Acceptance() {
		DriverFactory.getInstance().getDriver().findElement(disclaimerAcceptance).click();
	}
	
	// -------------------- Normal User Function --------------------------
	public void login_BE(String autoTester, String password) throws InterruptedException {
		String lab_Url = "https://lab.boardeffect.com/login/disclaimer";
		this.verify_Username_Field();
		this.set_Username(autoTester);
		this.set_Password(password);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean login = DriverFactory.getInstance().getDriver().findElements(labLoginButton).size() > 0;
		Boolean newSignIn = DriverFactory.getInstance().getDriver().findElements(newLoginButton).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (login == true) {
			  DriverFactory.getInstance().getDriver().findElement(labLoginButton).click();
			  Thread.sleep(1500);
			} else if (newSignIn == true) {
			  this.click_New_Log_In_Button();
			  Thread.sleep(1500);
			} else {
			  this.click_BoardEffect_Login();
			  Thread.sleep(1500);
			}
		
		if (DriverFactory.getInstance().getDriver().getCurrentUrl().contains(lab_Url)) {
			this.verify_Disclaimer_Acceptance();
			this.click_Disclaimer_Acceptance();
			Thread.sleep(1000);
			DriverFactory.getInstance().getDriver().findElement(labLoginButton).click();
			Thread.sleep(1500);
		}	 
		
		System.out.println("------- Completed -->  User_Can_Login() -----------");

	}

	// --------user can logout ------------
	By user_Profile_Dropdown = By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By sign_Out = By.xpath("//a[contains(text(),'Sign Out')]");

	public void verify_User_Profile_Dropdown() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Profile_Dropdown)));
	}

	public void verify_Sign_Out() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 10);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(user_Profile_Dropdown)));
	}

	public void click_User_Profile_Dropdown() {
		// driver.findElement(user_Profile_Dropdown).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element2);
	}

	public void click_Sign_Out() {
		// driver.findElement(sign_Out).click();
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
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
