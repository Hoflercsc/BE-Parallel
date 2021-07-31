package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import parallel.DriverFactory;
import tests_critical_scenarios.BaseTestCriticalScenarios;

public class MessagePage {
		
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By library = By.xpath("//span[contains(text(),'Library')]");
	// -------------------- user_Open_Workroom() ---------------------------------
	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	// ------------------Function Being called-----------------------------------
	public void click_AutoBE() {
		DriverFactory.getInstance().getDriver().findElement(autoBE).click();
	}

	public void user_Open_Workroom() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		System.out.println("------- Completed --> user_Open_Workroom() -----------");
	}
	
	// ---------------user_Open_Message_Workroom_Window()-------------
	By mesage_Workroom = By.xpath("//a[contains(text(),'Message Workroom')]");
	By add_Recipients_Input_Field = By.xpath("//input[@placeholder='Search']");

	public void verify_Message_Workroom() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mesage_Workroom)));
	}

	public void verify_Add_Recipients_Input_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(add_Recipients_Input_Field)));
	}

	public void click_Message_Workroom() {
		DriverFactory.getInstance().getDriver().findElement(mesage_Workroom).click();
	}

	// ------------------Function Being called-----------------------------------
	public void user_Open_Message_Workroom_Window() throws InterruptedException {
		this.verify_Message_Workroom();
		this.click_Message_Workroom();
		this.verify_Add_Recipients_Input_Field();
		System.out.println("------- Completed --> user_Open_Message_Workroom_Window() -----------");
	}
	
	// -------------- user_Open_Message_Workroom_Window()------------
	By auto_Director = By.xpath("//div[contains(text(),'Auto Director')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");
	By auto_Director_Plus_Sign = By.xpath("(//div[contains(text(),'Auto Director')]/following::span[@class='icon plus-sign-icon'])[1]");

	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void verify_Auto_Director_Plus_Sign() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director_Plus_Sign)));
	}

	public void click_Auto_Director() {
		DriverFactory.getInstance().getDriver().findElement(auto_Director).click();
	}

	public void click_ContinueBtn() {
		DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
	}

	// ------------------Function Being called-----------------------------------
	public void user_Can_Remove_User_From_List() throws InterruptedException {
		Thread.sleep(4000);
		this.click_Auto_Director();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		this.verify_Auto_Director_Plus_Sign();
		System.out.println("------- Completed --> user_Can_Remove_User_From_List() -----------");
	}
	
	// ----------user_Can_Add_Manual_Email_To_List()------------
	By email_Field = By.xpath("//input[@id='emails_input']");
	By add_EmailBtn = By.xpath("//i[@class='fa fa-plus-circle']");
	By created_Email = By.xpath("//a[contains(text(),'someone@diligent.com')]");

	public void verify_Newly_Created_Email() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(created_Email)));
	}

	public void click_Email_Field_SendKeys() {
		String email = "someone@diligent.com";
		DriverFactory.getInstance().getDriver().findElement(email_Field).sendKeys(email);
	}

	public void click_Add_EmailBtn() {
		DriverFactory.getInstance().getDriver().findElement(add_EmailBtn).click();
	}

	public void verify_AD_TAG_NOT_Visible() throws InterruptedException {
		String discussion = "//a[@class='label label-primary'][contains(text(),'Auto Director')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(discussion)).size() < 1);
	}

	// ------------------Function Being called-----------------------------------
	public void user_Can_Add_Manual_Email_To_List() throws InterruptedException {
		this.click_Email_Field_SendKeys();
		this.click_Add_EmailBtn();
		Thread.sleep(1000);
		this.verify_Newly_Created_Email();
		// this.verify_AD_TAG_NOT_Visible();// check to make sure Auto Director Email
		// Tag NOT Visible
		System.out.println("------- Completed --> user_Can_Add_Manual_Email_To_List() -----------");
	}
	
	// --------------user_Populate_Email_Form_Send_Message()---------
	By email_Subject = By.xpath("//input[@id='email_subject']");
	By sendBtn = By.xpath("//button[@id='message_submit']");

	public void click_Email_Subject_SendKeys() {
		String subject = "This is a Subject";
		DriverFactory.getInstance().getDriver().findElement(email_Subject).sendKeys(subject);
	}

	public void email_Message() {
		// switching to iframe
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys("This is an email message");
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}

	public void scroll_To_SendBtn() throws InterruptedException {
		WebElement send = DriverFactory.getInstance().getDriver().findElement(By.xpath("//button[@id='message_submit']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", send);
	}

	public void click_SendBtn() {
		DriverFactory.getInstance().getDriver().findElement(sendBtn).click();
	}

	// ------------------Function Being called-----------------------------------
	public void user_Populate_Email_Form_Send_Message() throws InterruptedException {
		this.click_Email_Subject_SendKeys();
		this.email_Message();
		this.scroll_To_SendBtn();
		this.click_SendBtn();
		System.out.println("------- Completed --> user_Populate_Email_Form_Send_Message() -----------");
	}
	
	// ----------------user_Populate_Email_Form_Send_Message()---------------
	By sucess_Message_Container = By.xpath("//p[contains(text(),'This message was sent to the following recipients:')]");
	By message_Workroom_Sucess_Message = By.xpath("//p[contains(text(),'You will')]");

	By at_Message = By.xpath("//p[contains(text(),'Automation Tester')]");
	By wa_Message = By.xpath("//p[contains(text(),'Workroom Admin - workroomAdmin@diligent.com')]");
	By someone_Message = By.xpath("//p[contains(text(),'someone@diligent.com')]");
	By closeBtn = By.xpath("//div[@class='modal-dialog modal-lg']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]");

	public void verify_All_Success_Messages() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(message_Workroom_Sucess_Message)));
	}

	public void scroll_To_Sucess_Message_Container() throws InterruptedException {
		WebElement success = DriverFactory.getInstance().getDriver().findElement(By.xpath("//p[contains(text(),'You will')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", success);
	}

	public void scroll_To_CloseBtn() throws InterruptedException {
		WebElement close = DriverFactory.getInstance().getDriver().findElement(By.xpath(
				"//div[@class='modal-dialog modal-lg']//div[@class='modal-footer clear']//button[@class='btn btn-default'][contains(text(),'Close')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", close);
	}

	public void click_CloseBtn() {
		DriverFactory.getInstance().getDriver().findElement(closeBtn).click();
	}

	// --------------Function Being Called ---------------------------
	public void verify_Email_Sent_Verification_Messages() throws InterruptedException {
		Thread.sleep(3000);
		this.scroll_To_Sucess_Message_Container();
		this.verify_All_Success_Messages();
		this.scroll_To_CloseBtn();
		Thread.sleep(2000);
		this.click_CloseBtn();
		System.out.println("------- Completed --> verify_Email_Sent_Verification_Messages() -----------");
		Thread.sleep(3000);
	}
}
