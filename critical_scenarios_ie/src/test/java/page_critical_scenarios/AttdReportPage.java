package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
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
import com.aventstack.extentreports.ExtentTest;

public class AttdReportPage {
	WebDriver driver;

	public AttdReportPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// -------------------POM Page Object model-------------------------
	// -------------- user_Opens_Settings_Form_Open_Reports---------------------
	By settings = By.xpath("//span[contains(text(),'Settings')]");
	By workroom_Groups = By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]");
	By reports = By.xpath("//span[@class='translation_missing'][contains(text(),'Reports')]");

	public void verify_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings)));
	}

	public void verify_Reports() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(reports)));
	}

	public void click_Settings() {
		driver.findElement(settings).click();
	}

	public void click_Reports() {
		driver.findElement(reports).click();
	}

	// -------Function Being called -----------
	public void user_Opens_Settings_Form_Open_Reports() {
		this.click_Settings();
		this.verify_Reports();
		this.click_Reports();
		System.out.println("------- Completed --> user_Opens_Settings_Form_Open_Reports() -----------");
	}
	
	// -------user_Can_Run_Attendance_Reports -----------
	By attendance = By.xpath("//span[contains(text(),'Attendance')]");
	By workroom_Attd_Row = By.xpath("//td[contains(text(),'Workroom Admin')]");

	public void verify_Attendance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attendance)));
	}

	public void verify_Workroom_Attendance_Row() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Attd_Row)));
	}

	public void click_Attendance() {
		driver.findElement(attendance).click();
	}

	// -------Function Being called -----------
	public void user_Can_Open_Attendance_Menu() {
		this.verify_Attendance();
		this.click_Attendance();
		this.verify_Workroom_Attendance_Row();
		System.out.println("------- Completed --> user_Can_Run_Attendance_Reports() -----------");
	}
	
	// ------- user_Can_Configure_Attendence_Report -----------
	By ungrouped_Workrooms = By.xpath("//*[@id=\"attendance_form\"]/div[1]/div[2]/div/button");
	By autoAttend = By.xpath("//span[contains(text(),'AutoAttend')]");
	By filter = By.xpath("//button[@id='filter_button']");

	public void click_Ungrouped_Workroom_Dropdown() {
		driver.findElement(ungrouped_Workrooms).click();
	}

	public void click_AutoAttend() {
		driver.findElement(autoAttend).click();
	}

	public void click_Filter() {
		driver.findElement(filter).click();
	}

	// ------- Function Being called -----------
	public void user_Can_Configure_Attendence_Report() throws InterruptedException {
		this.click_Ungrouped_Workroom_Dropdown();
		Thread.sleep(1000);
		this.click_AutoAttend();
		this.click_Filter();
		Thread.sleep(3000);
		System.out.println("------- Completed --> user_Can_Configure_Attendence_Report() -----------");
	}
	
	// ------- user_Can_Verify_Filter_Change -----------
	By autoDirector_Row = By.xpath("//td[contains(text(),'100.00%')]/preceding::td[contains(text(),'Auto Director')]");

	public void verify_Auto_Director_Row() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoDirector_Row)));
	}

	// ------- Function Being called -----------
	public void user_Can_Verify_Filter_Change() throws InterruptedException {
		this.verify_Auto_Director_Row();
		System.out.println("------- Completed --> user_Can_Verify_Filter_Change() -----------");
	}
	
	// ------- user_Generate_And_Download_PDF_Report -----------
	// By generate_PDF_File = By.xpath("//a[@class='btn
	// btn-primary'][contains(text(),'Generate PDF File')]");
	By generate_PDF_File = By.xpath("//*[@id=\"attendance-report\"]/div[5]/div/span[1]/a");
	By download_report_Btn = By.xpath("//a[@id='download_report_button']");
	// By generate_Excel_File = By.xpath("//a[@class='excel-link btn
	// btn-primary'][contains(text(),' Generate Excel File')]");
	By generate_Excel_File = By.xpath("//*[@id=\"settingsModal\"]/div/div/div[2]/div/div[2]/div[2]/div/div[5]/div/span[2]/a");
	By closeBtn = By.xpath("//a[@id='settingsModalClose']");

	public void verify_Download_Report_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(download_report_Btn)));
	}

	public void verify_Generate_Excel_File_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(generate_Excel_File)));
	}

	public void verify_Close_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(closeBtn)));
	}

	public void click_Generate_PDF_File() throws InterruptedException {
		WebElement pdf = driver.findElement(By.xpath("//*[@id=\"attendance-report\"]/div[5]/div/span[1]/a"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pdf);
		Thread.sleep(1000);
		driver.findElement(generate_PDF_File).click();
	}

	public void click_Download_Report_Btn() {
		driver.findElement(download_report_Btn).click();
	}

	public void click_Excel_File_Btn() {
		driver.findElement(generate_Excel_File).click();
	}

	public void click_Close_Btn() {
		// driver.findElement(closeBtn).click();
		WebElement element = driver.findElement(By.xpath("//a[@id='settingsModalClose']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// ------- Function Being called -----------
	public void user_Generate_And_Download_PDF_Report() throws InterruptedException, AWTException {
		this.click_Generate_PDF_File();
		Thread.sleep(2000);
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		/*
		 * this.verify_Download_Report_Btn(); // this.click_Download_Report_Btn(); // --
		 * IE dose not automatically download the report it prompts you this is outside
		 * the browser
		 * 
		 * Thread.sleep(3000); driver.close(); //---close 2nd Tab----
		 */
		driver.close();
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		System.out.println("------- Completed --> user_Generate_And_Download_PDF_Report() -----------");
	}

	public void user_Generate_And_Download_Excel_Report() throws InterruptedException {
		this.verify_Generate_Excel_File_Btn();
		this.click_Excel_File_Btn();
		Thread.sleep(3000);
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		/*
		 * this.verify_Download_Report_Btn(); // this.click_Download_Report_Btn(); // --
		 * IE dose not automatically download the report it prompts you this is outside
		 * the browser Thread.sleep(2000); driver.close(); //---close 2nd Tab----
		 */
		driver.close();
		Thread.sleep(2000);
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(4000);
		// this.verify_Close_Btn(); --- expected condition failing
		this.click_Close_Btn();
		System.out.println("------- Completed --> user_Generate_And_Download_Excel_Report() -----------");
		Thread.sleep(3000);
	}
}
