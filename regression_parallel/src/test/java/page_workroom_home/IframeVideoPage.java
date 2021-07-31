package page_workroom_home;

import static org.testng.Assert.assertTrue;
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import page_common_functions.AtlasNavBar;
import parallel.DriverFactory;

public class IframeVideoPage {
	
	// ---------------user_navigates and click edit icon/ workroom news()-----------------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By pencil = By.xpath("//span[@class='glyphicon glyphicon-pencil']");
	//By workroom_News_Plus_Symbol = By.xpath("//h3[contains(text(),'Workroom News')]//i[@class='fa fa-plus']");
	By workroom_News_Plus_Symbol = By.xpath("//*[contains(text(),'Workroom News')]//a[@class='no-mobile']");


	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void verify_Edit_Icon() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(pencil)));
	}
	
	public void verify_Workroom_News_Plus_Symbol() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_News_Plus_Symbol)));
	}

	public void click_AutoBE() {
		DriverFactory.getInstance().getDriver().findElement(autoBE).click();
	}

	public void click_Edit_Icon() {
		DriverFactory.getInstance().getDriver().findElement(pencil).click();
	}
	
	public void click_Workroom_News_Plus_Symbol() {
		DriverFactory.getInstance().getDriver().findElement(workroom_News_Plus_Symbol).click();
	}

	// --------------------------Function Being Called--------------
	public void user_Clicks_On_Edit_Icon() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Edit_Icon();
		this.click_Edit_Icon();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Clicks_On_Edit_Icon() -----------");
	}
	
	public void user_Clicks_On_Edit_Icon_AutoAttend_WR() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoAttend();
		this.verify_Edit_Icon();
		this.click_Edit_Icon();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Clicks_On_Edit_Icon_AutoAttend_WR() -----------");
	}
	
	public void user_Clicks_On_Edit_Icon_DC_WR() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_DC();
		this.verify_Edit_Icon();
		this.click_Edit_Icon();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Clicks_On_Edit_Icon_DC_WR() -----------");
	}
		
	// --------------------------Function Being Called--------------
	public void user_Clicks_Workroom_News_Plus_Symbol() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		Thread.sleep(1500);
		this.verify_Workroom_News_Plus_Symbol();
		this.click_Workroom_News_Plus_Symbol();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Clicks_Workroom_News_Plus_Symbol() -----------");
	}
	

	// ----------------assign_Remove_Workroom_Admin--------------
	By workroom_Admin = By.xpath("//span[@class='account-name drop-target']//a[contains(text(),'Workroom Admin')]");
	By workroomAdminEng = By.xpath("//span[@class='account-name drop-target']//a[contains(text(),'workroom admineng')]");
	By auto_Director_WB_Column = By.xpath("//span[@class='account-name drop-target']//a[contains(text(),'Auto Director')]");
	By auto_Director_Promoted_To_Chair= By.xpath("//span[@class='account-name drop-target']//a[contains(text(),'Auto Director')]/following::span/child::i[@class='fa fa-gavel']");
	By testReset = By.xpath("//span[@class='account-name drop-target']//a[contains(text(),'Test Reset')]");

	By makeAdmin = By.cssSelector("#popover-body-109550 > div:nth-child(4) > div > a:nth-child(2)");
	By makeChair= By.xpath("//div[@id='popover-body-109550']//a[3]");
	//By workroomAdmin_Promoted_To_Admin= By.xpath("//a[contains(text(),'Workroom Admin')]/following::span[contains(text(),'Workroom Administrator')]");
	By workroomAdmin_Promoted_To_Admin= By.xpath("//div[contains(text(),'Workroom Administrators')]/following::a[contains(text(),'Workroom Admin')]");
	By testReset_Promoted_To_Admin= By.xpath("(//div[contains(text(),'Workroom Administrators')]/following::a[contains(text(),'Test Reset')]/following::span/child::i[@class='fa fa-star-o'])[1]");

	By workroomAdmin_Promoted_To_Chair= By.xpath("//a[contains(text(),'Workroom Admin')]/following::span[@class='medium-gray']//i[@class='fa fa-gavel']");
	
	
	public void verify_Workroom_Admin_Disabled_As_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Admin)));
	}
	
	public void verify_Test_Reset_WR_Column() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(testReset)));
	}
	
	public void verify_WorkroomAdminEng_WM_Column() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdminEng)));
	}
	
	public void verify_AutoDirector_Promoted_Chair() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director_Promoted_To_Chair)));
	}
	
	public void verify_Auto_Director_WM_Column() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(auto_Director_WB_Column)));
	}
	
	public void verify_Make_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(makeAdmin)));
	}
	
	public void verify_WorkroomAdmin_Promoted_To_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdmin_Promoted_To_Admin)));
	}
	
	public void verify_TestRest_Promoted_To_Admin() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(testReset_Promoted_To_Admin)));
	}
	
	public void verify_WorkroomAdmin_Promoted_To_Chair() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdmin_Promoted_To_Chair)));
	}

	public void hover_Over_WorkroomAdmin() {
		Actions builder = new Actions(DriverFactory.getInstance().getDriver());
		WebElement workroomAdmin = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[@class='account-name drop-target']//a[contains(text(),'Workroom Admin')]"));
		builder.moveToElement(workroomAdmin).perform();
	}
	
	public void hover_Over_TestReset() {
		Actions builder = new Actions(DriverFactory.getInstance().getDriver());
		WebElement workroomAdmin = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[@class='account-name drop-target']//a[contains(text(),'Test Reset')]"));
		builder.moveToElement(workroomAdmin).perform();
	}
	
	public void hover_Over_AutoDirector() {
		Actions builder = new Actions(DriverFactory.getInstance().getDriver());
		WebElement workroomAdmin = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[@class='account-name drop-target']//a[contains(text(),'Auto Director')]"));
		builder.moveToElement(workroomAdmin).perform();
	}
	
	public void hover_Over_WorkroomAdmin_Promoted_To_Admin() {
		Actions builder = new Actions(DriverFactory.getInstance().getDriver());
		WebElement workroomAdmin = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Workroom Administrators')]/following::a[contains(text(),'Workroom Admin')]"));
		builder.moveToElement(workroomAdmin).perform();
	}
	
	public void hover_Over_TestReset_Promoted_To_Admin() {
		Actions builder = new Actions(DriverFactory.getInstance().getDriver());
		WebElement workroomAdmin = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Workroom Administrators')]/following::a[contains(text(),'Test Reset')]"));
		builder.moveToElement(workroomAdmin).perform();
	}
	
	public void click_Make_Admin() {
		//DriverFactory.getInstance().getDriver().findElement(makeAdmin).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("#popover-body-109550 > div:nth-child(4) > div > a:nth-child(2)"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Make_Admin_Test_Reset() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("#popover-body-109552 > div:nth-child(4) > div > a:nth-child(2)"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_To_Enable_Make_Chair() {
		//DriverFactory.getInstance().getDriver().findElement(makeAdmin).click();
		WebElement makeChair = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("[title='Make Chair']"));
		WebElement chair = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("#popover-body-109550 > div:nth-child(4) > div > a:nth-child(3)"));
			
		if (!makeChair.isDisplayed() == true) {
		
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", chair);
			
		}
	}
	
	public void click_To_Enable_Make_Chair_AutoDirector() {
		//DriverFactory.getInstance().getDriver().findElement(makeAdmin).click();
		WebElement makeChair = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("[title='Make Chair']"));
		WebElement chair = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("#popover-body-109551 > div:nth-child(4) > div > a:nth-child(3)"));
			
		if (!makeChair.isDisplayed() == true) {
		
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", chair);
			
		}
	}
	
	public void click_To_Disable_Make_Chair() {
		//DriverFactory.getInstance().getDriver().findElement(makeAdmin).click();
		WebElement makeChair = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("[title^='Make Chair']"));
		WebElement chair = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("#popover-body-109550 > div:nth-child(4) > div > a:nth-child(3)"));
			
		if (makeChair.isDisplayed() == false) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", chair);
			
		}
	}
	
	public void click_To_Disable_Make_Chair_Auto_Director() {
		//DriverFactory.getInstance().getDriver().findElement(makeAdmin).click();
		WebElement makeChair = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("[title^='Make Chair']"));
		WebElement chair = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("#popover-body-109551 > div:nth-child(4) > div > a:nth-child(3)"));
			
		if (makeChair.isDisplayed() == false) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", chair);
			
		}
	}
	
	public void verify_WorkroomAdmin_Disabled_As_Chair() throws InterruptedException {
		String str = "[title^='Make Chair']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.cssSelector(str)).size() > 0);
	}
	
	public void verify_AutoDirector_Disabled_As_Chair() throws InterruptedException {
		String chair = "//span[@class='account-name drop-target']//a[contains(text(),'Auto Director')]/following::span/child::i[@class='fa fa-gavel']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(chair)).size() < 1);
	}
	
	// ------------------Function Being Called--------------------
	public void enable_Workroom_Admin_As_Admin() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Workroom_Admin_Disabled_As_Admin();
		Thread.sleep(1000);
		this.hover_Over_WorkroomAdmin();
		Thread.sleep(2000);
		//this.verify_Make_Admin();
		this.click_Make_Admin();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> enable_Workroom_Admin_As_Admin() -----------");
	}
	
	public void enable_Test_Reset_Admin_As_Admin() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Test_Reset_WR_Column();
		Thread.sleep(1000);
		this.hover_Over_TestReset();
		Thread.sleep(2000);
		this.click_Make_Admin_Test_Reset();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> enable_Workroom_Admin_As_Admin() -----------");
	}
	
	public void verify_WorkroomAdmin_Enabled_As_Admin() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_WorkroomAdmin_Promoted_To_Admin();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_WorkroomAdmin_Enabled_As_Admin() -----------");
	}
	
	public void verify_TestReset_Enabled_As_Admin() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_TestRest_Promoted_To_Admin();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_TestReset_Enabled_As_Admin() -----------");
	}
	
	public void disable_Workroom_Admin_As_Admin() throws InterruptedException {
		this.hover_Over_WorkroomAdmin_Promoted_To_Admin();
		Thread.sleep(2000);
		//this.verify_Make_Admin();
		this.click_Make_Admin();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> disable_Workroom_Admin_As_Admin() -----------");
	}
	
	public void disable_TestReset_As_Admin() throws InterruptedException {
		this.hover_Over_TestReset_Promoted_To_Admin();
		Thread.sleep(2000);
		//this.verify_Make_Admin();
		this.click_Make_Admin_Test_Reset();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> disable_TestReset_As_Admin() -----------");
	}
	
	public void verify_WorkroomAdmin_Disabled_As_Admin() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_Workroom_Admin_Disabled_As_Admin();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_WorkroomAdmin_Disabled_As_Admin() -----------");
	}
	
	// ------------------Workroom_Admin_As_Chair--------------------
	public void enable_Workroom_Admin_As_Chair() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Workroom_Admin_Disabled_As_Admin();
		Thread.sleep(1000);
		this.hover_Over_WorkroomAdmin();
		Thread.sleep(2000);
		//this.verify_Make_Admin();
		this.click_To_Enable_Make_Chair();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> enable_Workroom_Admin_As_Admin() -----------");
	}
	
	public void enable_Auto_Director_As_Chair() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Auto_Director_WM_Column();
		Thread.sleep(1000);
		this.hover_Over_AutoDirector();
		Thread.sleep(2000);
		this.click_To_Enable_Make_Chair_AutoDirector();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> enable_Auto_Director_As_Chair() -----------");
	}
	
	public void verify_WorkroomAdmin_Enabled_As_Chair() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Workroom_Admin_Disabled_As_Admin();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_WorkroomAdmin_Enabled_As_Admin() -----------");
	}
	
	public void verify_AutoDirector_Promoted_As_Chair() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_AutoDirector_Promoted_Chair();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_WorkroomAdmin_Enabled_As_Admin() -----------");
	}
	
	public void disable_Workroom_Admin_As_Chair() throws InterruptedException {
		this.hover_Over_WorkroomAdmin();
		Thread.sleep(2000);
		//this.verify_Make_Admin();
		this.click_To_Disable_Make_Chair();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> disable_Workroom_Admin_As_Admin() -----------");
	}
	
	public void disable_AutoDirector_As_Chair() throws InterruptedException {
		this.hover_Over_AutoDirector();
		Thread.sleep(2000);
		//this.verify_Make_Admin();
		this.click_To_Disable_Make_Chair_Auto_Director();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> disable_AutoDirector_As_Chair() -----------");
	}
	
	public void verify_Workroom_Admin_Disabled_As_Chair() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Workroom_News_Plus_Symbol();
		this.verify_WorkroomAdmin_Disabled_As_Chair();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_WorkroomAdmin_Disabled_As_Admin() -----------");
	}
	
	public void verify_Auto_Director_Disabled_As_Chair() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Workroom_News_Plus_Symbol();
		this.verify_AutoDirector_Disabled_As_Chair();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_AutoDirector_Disabled_As_Chair() -----------");
	}

	// ------------------Add_Remove_Workroom_Accounts--------------
	By addRemove_Accounts = By.xpath("//*[@id='wrap']/main//div/a[contains(.,'Edit Membership')]");
	By workroomAdmin_Minus_Sign = By.xpath("(//div[contains(text(),'Workroom Admin')]/following::span[@class='icon minus-sign-icon'])[1]");
	By testRest_Minus_Sign = By.xpath("(//div[contains(text(),'Test Reset')]/following::span[@class='icon minus-sign-icon'])[1]");
	By testReset_Plus_Sign = By.xpath("(//div[contains(text(),'Test Reset')]/following::span[@class='icon plus-sign-icon'])[1]");

	By workroomAdmin_Plus_Sign = By.xpath("(//div[contains(text(),'Workroom Admin')]/following::span[@class='icon plus-sign-icon'])[1]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verify_Add_Remove_Accounts() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addRemove_Accounts)));
	}
	
	public void verify_WorkroomAdmin_Minus_Sign() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdmin_Minus_Sign)));
	}
	
	public void verify_Test_Reset_Minus_Sign() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(testRest_Minus_Sign)));
	}
	
	public void verify_Test_Reset_Plus_Sign() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(testReset_Plus_Sign)));
	}
	
	public void verify_WorkroomAdmin_Plus_Sign() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomAdmin_Plus_Sign)));
	}
	
	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}
	
	public void click_Add_Remove_Accounts() {
		DriverFactory.getInstance().getDriver().findElement(addRemove_Accounts).click();
	}
	
	public void click_WorkroomAdmin_Minus_Sign() {
		DriverFactory.getInstance().getDriver().findElement(workroomAdmin_Minus_Sign).click();
	}
	
	public void click_Test_Reset_Minus_Sign() {
		DriverFactory.getInstance().getDriver().findElement(testRest_Minus_Sign).click();
	}
	public void click_WorkroomAdmin_Plus_Sign() {
		DriverFactory.getInstance().getDriver().findElement(workroomAdmin_Plus_Sign).click();
	}
		
	public void click_ContinueBtn() {
		DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
	}
	
	// --------------------Function Being Called-------------------
	public void user_Remove_Workroom_Account_Workroom_Admin() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Add_Remove_Accounts();
		this.click_Add_Remove_Accounts();
		Thread.sleep(1000);
		this.verify_WorkroomAdmin_Minus_Sign();
		this.click_WorkroomAdmin_Minus_Sign();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Remove_Workroom_Account_Workroom_Admin() -----------");
	}
	
	// --------------------Function Being Called-------------------
	public void verify_WorkroomAdmin_Account_Removed_From_Workroom() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		Thread.sleep(1500);
		this.verify_Add_Remove_Accounts();
		this.click_Add_Remove_Accounts();
		Thread.sleep(1000);
		this.verify_WorkroomAdmin_Plus_Sign(); // chnage to plus sign
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_WorkroomAdmin_Account_Removed_From_Workroom() -----------");
	}
	
	public void add_Back_WorkroomAdmin_Account() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		Thread.sleep(1500);
		this.verify_Add_Remove_Accounts();
		this.click_Add_Remove_Accounts();
		Thread.sleep(1000);
		this.verify_WorkroomAdmin_Plus_Sign(); // chnage to plus sign
		this.click_WorkroomAdmin_Plus_Sign();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> add_Back_WorkroomAdmin_Account() -----------");
	}
	
	public void verify_Account_Added_Back_To_Workroom() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		Thread.sleep(1000);
		this.verify_Add_Remove_Accounts();
		this.click_Add_Remove_Accounts();
		Thread.sleep(1000);
		this.verify_WorkroomAdmin_Minus_Sign(); // chnage to plus sign
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_Account_Added_Back_To_Workroom() -----------");

	}
	
	// ------------------Workroom_Admin_Visibility--------------------
	
	public void click_To_Unhide_WorkroomAdmin() {
		//DriverFactory.getInstance().getDriver().findElement(makeAdmin).click();
		WebElement makeHidden = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("[title^='Make Hidden']"));
		WebElement makeHiddenBtn = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("#popover-body-109550 > div:nth-child(4) > div > a:nth-child(4)"));
			
		if (!makeHidden.isDisplayed() == true) {
		
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", makeHiddenBtn);
		}
	}
	
	public void click_To_Hide_WorkroomAdmin() {
		//DriverFactory.getInstance().getDriver().findElement(makeAdmin).click();
		WebElement makeHidden = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("[title^='Make Hidden']"));
		WebElement makeHiddenBtn = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("#popover-body-109550 > div:nth-child(4) > div > a:nth-child(4)"));
			
		if (makeHidden.isDisplayed() == false) {
		
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", makeHiddenBtn);
		}
	}

	public void verify_WorkroomAdmin_Not_Hidden() throws InterruptedException {
		String str = "[title^='Make Hidden']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.cssSelector(str)).size() > 0);
	}
	
	public void verify_WorkroomAdmin_Is_Hidden() throws InterruptedException {
		String str = "[title^='Make Hidden']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.cssSelector(str)).size() > 0);
	}

	public void verify_WorkroomAdmin_Visibility_Enabled() {
		//DriverFactory.getInstance().getDriver().findElement(makeAdmin).click();
		WebElement makeHidden = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("[title^='Make Hidden']"));
		WebElement makeHiddenBtn = DriverFactory.getInstance().getDriver().findElement(By.cssSelector("#popover-body-109550 > div:nth-child(4) > div > a:nth-child(3)"));
			
		if (makeHidden.isDisplayed() == false) {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", makeHiddenBtn);
		}
	}
	
	public void enable_Workroom_Admin_Visibility() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Workroom_Admin_Disabled_As_Admin();
		Thread.sleep(1000);
		this.hover_Over_WorkroomAdmin();
		Thread.sleep(2000);
		//this.verify_Make_Admin();
		this.click_To_Unhide_WorkroomAdmin();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> enable_Workroom_Admin_Visibility() -----------");
	}
	
	public void verify_Workroom_Admin_Visibility_Enabled() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Workroom_Admin_Disabled_As_Admin();
		this.verify_WorkroomAdmin_Not_Hidden();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_WorkroomAdmin_NOT_Hidden() -----------");
	}
	
	public void disable_Workroom_Admin_Visibility() throws InterruptedException {
		this.hover_Over_WorkroomAdmin();
		Thread.sleep(2000);
		//this.verify_Make_Admin();
		this.click_To_Hide_WorkroomAdmin();
		Thread.sleep(2500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> disable_Workroom_Admin_Visibility() -----------");
	}
	
	public void verify_WorkroomAdmin_IS_Hidden() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Workroom_Admin_Disabled_As_Admin();
		this.verify_WorkroomAdmin_Not_Hidden();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_WorkroomAdmin_IS_Hidden() -----------");
	}
	
	// ------------------View_Workroom_Member_Profile--------------------
	By popup_Window_Dropdown = By.xpath("//h4[@class='modal-title']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By close_Profile_Top_X = By.xpath("//div[@id='profileModal']//a[@class='atlas-close pull-right']");

	public void verify_Popup_Window_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(popup_Window_Dropdown)));
	}
	
	public void verify_Member_Profile_Contents() {
		String companyInfo = "//span[contains(text(),'Company Information')]";
		String personalInfo = "//span[contains(text(),'Personal Information')]";
		String altContactInfo = "//a[contains(text(),'Alternate Contact Information')]";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(By.xpath(companyInfo)) instanceof WebElement);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(By.xpath(personalInfo)) instanceof WebElement);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(By.xpath(altContactInfo)) instanceof WebElement);
	}
	
	public void click_Workroom_Admin() {
		DriverFactory.getInstance().getDriver().findElement(workroom_Admin).click();
	}
	
	public void click_Workroom_Admin_2() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(workroom_Admin_2).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//*[@id='member-list']/div/span/a)[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
		
	}
	
	public void click_Workroom_AdminEng_Profile() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@id='member-list']/div/span/a[contains(., 'workroom admineng')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Close_Profile_Top() {
		DriverFactory.getInstance().getDriver().findElement(close_Profile_Top_X).click();
	}
	
	public void view_Workroom_Member_Profile() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_Workroom_Admin_Disabled_As_Admin();
		Thread.sleep(2000);
		this.click_Workroom_Admin_2();
		Thread.sleep(1500);
		this.verify_Popup_Window_Dropdown();
		System.out.println("------- Completed --> select_Workroom_Admin() -----------");
	}
	
	public void view_WorkroomAdminEng_Member_Profile() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_WorkroomAdminEng_WM_Column();
		this.click_Workroom_AdminEng_Profile();
		Thread.sleep(1000);
		this.verify_Popup_Window_Dropdown();
		System.out.println("------- Completed --> select_Workroom_Admin() -----------");
	}
	
	
	
	
	// ---------------user switches to message window Iframe()-------
	By saveBtn = By.xpath("//button[@name='button']");
	By horizontal_Line = By.xpath("//a[@id='cke_60']");
	/*  below elements dont work
	 *  ---------
		By source = By.xpath("//a[@id='cke_16']");
		By source = By.xpath("//span[@id='cke_18_label']");
		By source = By.xpath("//a[@id='cke_18']");
		---------
		does work for source icon -> By source = By.xpath("//span[@class='cke_button_icon cke_button__source_icon']");
	 */
	//By source = By.xpath("//a[@id='cke_16']");
	By source = By.xpath("//span[@class='cke_button_icon cke_button__source_icon']");
	By textarea = By.xpath("//textarea[@class='cke_source cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']");

	public void verify_SaveBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(saveBtn)));
	}

	public void switch_2_Iframe_Clear_Text() {
		// ---------------------switching to iframe-----------------
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and clearning text
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		// ---switch back to default content
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}
	
	public void switch_2_Iframe_Insert_Custom_Messsage() {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		String content = "Customize this area to greet your users with organizational information, photos, links and more!\n";
		// ---switch to iframe-----
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(content);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}

	public void click_source_Btn() {
		DriverFactory.getInstance().getDriver().findElement(source).click();
	}

	public void switch_2_Iframe_SendKeys() {
		// ---- content text ------
		String content = " <p style=\"text-align:center\"><span style=\"font-size:18px\"><strong>Welcome to My Test Workroom </strong></span></p>\r\n"
				+ "<p><iframe frameborder=\"0\" height=\"450\" src=\"https://www.youtube.com/embed/_IT_P1prwug\" width=\"760\"></iframe></p>\r\n"
				+ "<p style=\"text-align:center\">Learn more @<a href=\"http://prism-products.us\" target=\"_blank\">prism-products.us</a></p>\r\n"
				+ "<p style=\"text-align:center\">&nbsp;</p>\r\n" + "<p><em>Automation Test</em></p>";
		DriverFactory.getInstance().getDriver().findElement(textarea).sendKeys(content);
	}

	public void user_Enters_Text_and_Save() throws InterruptedException {
		// ---------------------switching to iframe-----------------
		this.verify_SaveBtn();
		this.click_source_Btn();
		Thread.sleep(1000);
		this.switch_2_Iframe_SendKeys();
		Thread.sleep(500);
		this.click_Save_Btn();
		System.out.println("------- Completed --> user_Enters_Text_and_Save() -----------");
	}

	// -----------------------Function Being Called---------------
	public void switch_To_Iframe_Insert_Iframe_Video() throws InterruptedException {
		this.switch_2_Iframe_Clear_Text();
		this.user_Enters_Text_and_Save();
		Thread.sleep(1000);
		System.out.println("------- Completed --> switch_To_Iframe_Insert_Line_Breaks() -----------");
	}
	
	// ---------------------Function Being Called----------------------------
	public void switch_To_Iframe_Insert_Custom_Message() throws InterruptedException {
		this.switch_2_Iframe_Clear_Text();
		this.switch_2_Iframe_Insert_Custom_Messsage();
		this.click_Save_Btn();
		Thread.sleep(1000);
		System.out.println("------- Completed --> switch_To_Iframe_Insert_Custom_Message() -----------");
	}
	
	// -----------------------add_workroom_news()--------------------------
	By news_Title = By.xpath("//input[@id='announcement_title']");
	By priority_Position = By.xpath("//label[contains(text(),'Move to Priority Position')]");
	By workroom_Message = By.xpath("//a[@class='modal-link'][contains(text(),'Insert Workroom News Here')]");
	String news = "Insert Workroom News Here";
	
	public void news_Title_SendKeys() {
		DriverFactory.getInstance().getDriver().findElement(news_Title).sendKeys(news);
	}
	
	public void click_Move_To_Priority_Position() {
		DriverFactory.getInstance().getDriver().findElement(priority_Position).click();
	}
	
	public void scroll_To_Title_Click() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Title')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		
		DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Title')]")).click();
		Thread.sleep(1000);

		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Move to Priority Position')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(1000);
	}
	
	public void verify_Workroom_News_Message() throws InterruptedException {
		String news = "//a[@class='modal-link'][contains(text(),'Insert Workroom News Here')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(By.xpath(news)) instanceof WebElement);
	}
	
	public void enter_News_Expiration_Date() throws InterruptedException {
		
		WebElement expiration_Date = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Expiration Date')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", expiration_Date);
		Thread.sleep(1000);
		
	    By calender = By.xpath("//div[@class='datepicker-days']//tbody");
		By EndDate = By.xpath("//input[@id='announcement_expires']");	
		By next = By.xpath("//div[@class='datepicker-days']//th[@class='next']");	

		DriverFactory.getInstance().getDriver().findElement(EndDate).click();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().findElement(next).click();

		String searchText = "1";
		
		 WebElement Days = DriverFactory.getInstance().getDriver().findElement(calender);
		 List<WebElement> days = Days.findElements(By.tagName("td"));
	  	 List<String> daysList = days.stream().map(WebElement::getText).collect(Collectors.toList());
		 System.out.println(daysList);
		 System.out.println("Testing -----------");
		 
		 for (WebElement d : days) {
			 
			 if (d.getText().equals(searchText)) {
				 d.click(); //clicks desired option
				 Thread.sleep(1500);
				 break;
			 }
			 
		 }
	}
	
	public void click_Workroom_News_Message() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(workroom_Message).click();
	}
	// ---------------------Function Being Called----------------------------
	public void Add_Title_Insert_Custom_Message() throws InterruptedException {
		this.news_Title_SendKeys();
		this.switch_2_Iframe_Insert_Custom_Messsage();
		this.enter_News_Expiration_Date();
		this.scroll_To_Title_Click();
		this.click_Move_To_Priority_Position();
		Thread.sleep(1000);
		this.click_Save_Btn();
		Thread.sleep(1000);
		AtlasNavBar obj  = new AtlasNavBar();
		obj.verify_Atlas_Left_Nav();
		System.out.println("------- Completed --> Add_Title_Insert_Custom_Message() -----------");
	}
	
	// ---------------------delete_Workroom_News_Message--------------------------
	By delete = By.xpath("//a[@class='btn btn-danger no-mobile']");
	
	public void verify_Delete() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(delete)));
	}

	public void click_Delete() {
		DriverFactory.getInstance().getDriver().findElement(delete).click();
	}
	
	public void verify_Workroom_News_NOT_Present() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.verify_Atlas_Left_Nav();
		String news = "//a[@class='modal-link'][contains(text(),'Insert Workroom News Here')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(news)).size() < 1);
	}
	
	// ---------------------Function Being Called----------------------------
	public void delete_Workroom_News_Message() throws InterruptedException {
		this.click_Workroom_News_Message();
		this.verify_Delete();
		this.click_Delete();
		Thread.sleep(2000);
		System.out.println("------- Completed --> delete_Workroom_News_Message() -----------");
	}
	
	// -----------------------verify_workroom_message()--------------------------
	By saved_Message = By.xpath("//div[@class='col-md-8 full main-content']//p[contains(text(),'AutoBE welcome message has been saved.')]");
	By video_Title = By.xpath("//strong[contains(text(),'Welcome to My Test Workroom')]");
	By customized_Message = By.xpath("//p[contains(text(),'Customize this area to greet your users with organ')]");
	By collapse = By.xpath("//a[@class='collapse-selection fl-right']");

	public void verify_Saved_Message_And_Content() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(video_Title)));
	}
	
	public void verify_Customized_Message_Content() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(customized_Message)));
	}
	
	public void click_Collapse() {
		DriverFactory.getInstance().getDriver().findElement(collapse).click();
	}
	
	public void verify_Cheveron_Arrow_Down_Present() throws InterruptedException {
		String file_Title = "//span[@class='glyphicon glyphicon-chevron-down']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElement(By.xpath(file_Title)) instanceof WebElement);
	}
	
	public void verify_Cheveron_Arrow_Up_Present() throws InterruptedException {
		String file_Title = "//span[@class='glyphicon glyphicon-chevron-up']";
		assertTrue(DriverFactory.getInstance().getDriver().findElement(By.xpath(file_Title)) instanceof WebElement);
	}

	// ----------------Function BeingCalled--------------------------------
	public void verify_Content_Appears() throws InterruptedException {
		this.verify_Saved_Message_And_Content();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_Content_Appears() -----------");
	}
	
	// ----------------Function BeingCalled--------------------------------
	public void verify_Customized_Content_Appears() throws InterruptedException {
		this.verify_Customized_Message_Content();
		Thread.sleep(1000);
		System.out.println("------- Completed --> verify_Content_Appears() -----------");
	}
	
	// ----------------Function BeingCalled--------------------------------
	public void collapse_Expand_Welcome_Message() throws InterruptedException {
		this.click_Collapse();
		Thread.sleep(1500);
		this.verify_Cheveron_Arrow_Down_Present();
		Thread.sleep(1000);
		this.click_Collapse();
		this.verify_Cheveron_Arrow_Up_Present();
		Thread.sleep(1000);
		System.out.println("------- Completed --> collapse_Expand_Welcome_Message() -----------");
	}

	// ---------------------delete insert previous message-----------------------
	public void switch_2_Iframe_SendKeys_Agian() {
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		String content = "Customize this area to greet your users with organizational information, photos, links and more!\n"
				+ "If you have questions, please contact your BoardEffect Administrator or the BoardEffect Support Team:\n" + "Name\n" + "Phone\n"
				+ "Email\n" + "BoardEffect Support 1-866-672-2666, option 1";
		// ---switch to iframe-----
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(content);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}
	
	public void click_Save_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(saveBtn).click();
	}

	// ---------------------Function Being Called----------------------------
	public void delete_Insert_Previous_Message() throws InterruptedException {
		this.click_Edit_Icon();
		Thread.sleep(1000);
		this.verify_SaveBtn();
		Thread.sleep(1000);
		this.switch_2_Iframe_SendKeys_Agian();
		Thread.sleep(1000);
		this.click_Save_Btn();
		System.out.println("------- Completed --> delete_Insert_Previous_Message() -----------");
	}
	
	// ----------------verify previous message--------------------------
	By message_Content_2 = By.xpath("//p[contains(text(),'Customize this area to greet your users with organ')]");

	public void verify_Saved_Message_And_Content_Again() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(saved_Message),
				ExpectedConditions.visibilityOfElementLocated(message_Content_2)));
	}

	// ----------------Function Being Called----------------------------------
	public void verify_Previous_Message() throws InterruptedException {
		this.verify_Saved_Message_And_Content_Again();
		System.out.println("------- Completed --> verify_Previous_Message() -----------");
		Thread.sleep(4000);
	}
}
