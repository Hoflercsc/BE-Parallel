package page_critical_scenarios;

import static org.testng.Assert.assertTrue;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import parallel.DriverFactory;

public class AttdReportPage {
	
	// --------POM Page Object model----------------
	// ------------ user_Opens_Settings_Form_Open_Reports ---------------------
	By settings = By.xpath("//span[contains(text(),'Settings')]");
	By workroom_Groups = By.xpath("//a[contains(text(),'Manage Workrooms and Groups')]");
	By reports = By.xpath("//span[@class='translation_missing'][contains(text(),'Reports')]");

	public void verify_Settings() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(settings)));
	}

	public void verify_Reports() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(reports)));
	}

	public void click_Settings() {
		DriverFactory.getInstance().getDriver().findElement(settings).click();
	}

	public void click_Reports() {
		DriverFactory.getInstance().getDriver().findElement(reports).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attendance)));
	}

	public void verify_Workroom_Attendance_Row() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Attd_Row)));
	}

	public void click_Attendance() {
		DriverFactory.getInstance().getDriver().findElement(attendance).click();
	}

	// -------Function Being called -----------
	public void user_Can_Open_Attendance_Menu() throws InterruptedException {
		this.verify_Attendance();
		this.click_Attendance();
		Thread.sleep(1000);
		this.verify_Workroom_Attendance_Row();
		System.out.println("------- Completed --> user_Can_Run_Attendance_Reports() -----------");
	}
	
	// ------- user_Can_Configure_Attendence_Report -----------
	By ungrouped_Workrooms = By.xpath("//*[@id=\"attendance_form\"]/div[1]/div[2]/div/button");
	By autoAttend = By.xpath("//span[contains(text(),'AutoAttend')]");
	By filter = By.xpath("//button[@id='filter_button']");

	public void click_Ungrouped_Workroom_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(ungrouped_Workrooms).click();
	}

	public void click_AutoAttend() {
		DriverFactory.getInstance().getDriver().findElement(autoAttend).click();
	}

	public void click_Filter() {
		DriverFactory.getInstance().getDriver().findElement(filter).click();
	}

	// ------- Function Being called -----------
	public void user_Can_Configure_Attendence_Report() throws InterruptedException {
		this.click_Ungrouped_Workroom_Dropdown();
		Thread.sleep(1000);
		this.click_AutoAttend();
		this.click_Filter();
		Thread.sleep(3000);// wait for rows to change
		System.out.println("------- Completed --> user_Can_Configure_Attendence_Report() -----------");
	}
	
	// ------- user_Can_Verify_Filter_Change -----------
	By autoDirector_Row = By.xpath("//td[contains(text(),'100.00%')]/preceding::td[contains(text(),'Auto Director')]");

	public void verify_Auto_Director_Row() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoDirector_Row)));
	}

	// ------- Function Being called -----------
	public void user_Can_Verify_Filter_Change() throws InterruptedException {
		this.verify_Auto_Director_Row();
		System.out.println("------- Completed --> user_Can_Verify_Filter_Change() -----------");
	}
	
	// ------- user_Generate_And_Download_PDF_Report -----------
	By generate_PDF_File = By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div/div[5]/div/span[1]/a");
	//By generate_PDF_File = By.xpath("//a[@class='btn btn-primary']");
	//By generate_PDF_File = By.xpath("//a[@class='btn btn-primary'][contains(text(),'Generate PDF File')]");
	By download_report_Btn = By.xpath("//a[@id='download_report_button'][contains(text(),'Download Report')]");
	By generate_Excel_File = By.xpath("//a[@class='excel-link btn btn-primary'][contains(text(),' Generate Excel File')]");
	By closeBtn = By.xpath("//a[@id='settingsModalClose']");

	public void verify_Download_Report_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(download_report_Btn)));
	}

	public void verify_Generate_Excel_File_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(generate_Excel_File)));
	}

	public void verify_Close_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(closeBtn)));
	}

	public void click_Generate_PDF_File() throws InterruptedException {
		WebElement pdf = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='btn btn-primary']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", pdf);
		Thread.sleep(1000);
		// https://stackoverflow.com/questions/12967541/how-to-avoid-staleelementreferenceexception-in-selenium
		// will ignore stale element keep trying to click for 15 seconds
		new WebDriverWait(DriverFactory.getInstance().getDriver(), 15)
        .ignoring(StaleElementReferenceException.class)
        .until((WebDriver d) -> {
            d.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
            return true;
        });
		/*WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div/div[5]/div/span[1]/a"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
		*/
	}

	public void click_Download_Report_Btn() {
		DriverFactory.getInstance().getDriver().findElement(download_report_Btn).click();
	}

	public void click_Excel_File_Btn() throws InterruptedException {
		WebElement Respondents = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='btn btn-primary']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", Respondents);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(generate_Excel_File).click();
	}

	public void click_Close_Btn() {
		DriverFactory.getInstance().getDriver().findElement(closeBtn).click();
	}

	// ------- Function Being called -----------
	public void user_Generate_And_Download_PDF_Report() throws InterruptedException {
		this.click_Generate_PDF_File();
		Thread.sleep(2000);
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(1000);
		this.verify_Download_Report_Btn();
		this.click_Download_Report_Btn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().close();
		// ---close 2nd Tab----
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		System.out.println("------- Completed --> user_Generate_And_Download_PDF_Report() -----------");
	}

	public void user_Generate_And_Download_Excel_Report() throws InterruptedException {
		this.verify_Generate_Excel_File_Btn();
		this.click_Excel_File_Btn();
		Thread.sleep(1000);
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		// ---switch to 2nd tab agian----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		this.verify_Download_Report_Btn();
		this.click_Download_Report_Btn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().close();
		// ---close 2nd Tab----
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		this.verify_Close_Btn();
		this.click_Close_Btn();
		System.out.println("------- Completed --> user_Generate_And_Download_Excel_Report() -----------");
	}
}
