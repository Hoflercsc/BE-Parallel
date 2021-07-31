package page_published_books;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import page_common_functions.AtlasNavBar;
import parallel.DriverFactory;

public class BooksPage {
	
	// ----------- POM Page Object model -----------------------------
	// ------------workroom_Admin_Not_See_Event_Due_To_Permissions---------------------------------------
	By workrooms_LN = By.xpath("//div[@id='wrap']/main/div/ul/li/a[contains(.,'Workrooms')]");
	By review_Board = By.xpath("//div[@id='wrap']/main/div/ul/li/a[contains(.,'Institutional Review Board')]");
	By adrian_Test = By.xpath("//a[contains(text(),'Adrian Test')]");
	By events = By.xpath("//span[@class='icon icon_wr-events active-off']");
	//By events = By.xpath("//div[@class='col-md-10 workroom-top-nav']//li[2]//a[1]");
	By all_Workroom_Events = By.xpath("//a[contains(text(),'View All Workroom Events')]");
	By callendar_Date = By.xpath("//div[@id='calendarModal']//div[@class='modal-header']//a[1]");
	By previous_Btn = By.xpath("//button[contains(text(),'< < Prev')]");
	By gtm_Test = By.xpath("//span[contains(@class,'pull-left event')]");

	public void verify_Workrooms_LN() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workrooms_LN)));
	}

	public void verify_Review_Board() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(review_Board)));
	}

	public void verify_Adrian_Test() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(adrian_Test)));
	}

	public void verify_Events() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(events)));
	}

	public void verify_All_Workroom_Events() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(all_Workroom_Events)));
	}

	public void verify_Calendar_Previous_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(previous_Btn)));
	}

	public void verify_GTM_Test() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(gtm_Test)));
	}
	
	public void click_Workrooms_LN() {
		DriverFactory.getInstance().getDriver().findElement(workrooms_LN).click();
	}

	public void click_Review_Board() {
		DriverFactory.getInstance().getDriver().findElement(review_Board).click();
	}

	public void click_Adrian_Test() {
		DriverFactory.getInstance().getDriver().findElement(adrian_Test).click();
	}

	public void click_Events() {
		DriverFactory.getInstance().getDriver().findElement(events).click();
	}

	public void click_All_Workroom_Events() {
		DriverFactory.getInstance().getDriver().findElement(all_Workroom_Events).click();
	}

	public void click_Previous_Btn() {
		DriverFactory.getInstance().getDriver().findElement(previous_Btn).click();
	}

	public void calendar_Logic() throws InterruptedException {
		By calendar_header = By.xpath("//div[@id='calendarModal']//div[@class='modal-header']");
		By monthdate = By.xpath("//span[@class='pull-right'][contains(text(),'25')]");
		String text = "December 2019";
		outsideloop:
		for (int i = 1; i > 0; i++) {
			WebElement Date = DriverFactory.getInstance().getDriver().findElement(calendar_header);
			List<WebElement> date = Date.findElements(By.tagName("h1"));
			for (WebElement x : date) {
				if (x.getText().contains(text)) {
					// System.out.println("inside loop if statement ");
					Thread.sleep(1000);
					//DriverFactory.getInstance().getDriver().findElement(monthdate).click(); // clicks desired option
					//-----
					WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//span[@class='pull-right'][contains(text(),'25')]"));
					JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
					executor.executeScript("arguments[0].click();", element);
					//------
					Thread.sleep(1000);
					verify_GTM_Test();
					DriverFactory.getInstance().getDriver().findElement(By.linkText("GTM Test")).click(); // clicks desired option
					Thread.sleep(4000);
					break outsideloop;
				} else {
					// System.out.println("inside loop else statement ");
					click_Previous_Btn();
					Thread.sleep(1200);
				}
			} // inner loop
				// System.out.println("outside if statment");
		} // outer loop
	}

	// -------------------Function Being called------------------------------------------
	public void user_Navigate_To_December_25th_Event() throws InterruptedException {
		AtlasNavBar  obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AgendaTab_Events();
		this.verify_All_Workroom_Events();
		this.click_All_Workroom_Events();
		Thread.sleep(1000);
		this.verify_Calendar_Previous_Btn();
		this.calendar_Logic();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Navigate_To_December_25th_Event() -----------");
	}
	// ---------------------------------verify_IEEE_Book_Agenda_Outline---------------------------------
	By IEEE_Book = By.xpath("//a[@class='book-navtab'][contains(text(),'IEEE Test')]");
	By agenda_Title = By.xpath("//p[@class='center meeting_title']");

	public void verify_IEEE_Test_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(IEEE_Book)));
	}

	public void verify_Agenda_Title_And_Outline() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(agenda_Title)));
		// --verify outline
		String info1 = "//a[contains(text(),'ieee board of directors - 17-18 february 2019-1525')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(info1)).size() > 0);
	}

	public void click_IEEE_Test_Book() {
		DriverFactory.getInstance().getDriver().findElement(IEEE_Book).click();
	}

	// ------------------------Function Being Called------------------------------------------
	public void verify_IEEE_Book_Agenda_Outline() throws InterruptedException {
		this.verify_IEEE_Test_Book();
		this.click_IEEE_Test_Book();
		Thread.sleep(1500);
		this.verify_Agenda_Title_And_Outline();
		System.out.println("------- Completed --> verify_IEEE_Book_Agenda_Outline() -----------");
	}
	// ---------------------------------open_IEEE_Meeting_Book---------------------------------
	By IEEE_Link = By.xpath("//a[contains(text(),'ieee board of directors - 17-18 february 2019-1525')]");
	By meeting_Book_Viewier_Btn = By.xpath("//a[@id='view_book']");
	By IEEE_Download = By.xpath("//div[contains(text(),'IEEE Download')]");
	By book_Window = By.xpath("//div[@class='modal-header no-border']//a[@class='atlas-close pull-right']");

	public void verify_Meeting_Book_Viewer_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(300)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(meeting_Book_Viewier_Btn)));
	}

	public void click_IEEE_Link() {
		DriverFactory.getInstance().getDriver().findElement(IEEE_Link).click();
	}

	public void switch_Tabs_Click_IEEE_Download() throws InterruptedException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		// switching to iframe
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/iframe[1]"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeThumbnail = DriverFactory.getInstance().getDriver().findElement(IEEE_Download);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(iframeThumbnail)));
		// iframeThumbnail.click();
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", iframeThumbnail);
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		DriverFactory.getInstance().getDriver().close();
		// ---close 2nd Tab----
		Thread.sleep(2000);
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
	}

	public void close_Meeting_Book_Window() {
		DriverFactory.getInstance().getDriver().findElement(book_Window).click();
	}

	// ----------------Function Being called------------------------------------------
	public void open_IEEE_Meeting_Book() throws InterruptedException {
		this.click_IEEE_Link();
		Thread.sleep(3000);
		this.switch_Tabs_Click_IEEE_Download();
		System.out.println("------- Completed --> open_IEEE_Meeting_Book() -----------");
	}

	// ----------------Function No Longer Being used For Agenda Tab---------------------------------
	public void close_IEEE_Meeting_Book() throws InterruptedException {
		Thread.sleep(3000);
		this.close_Meeting_Book_Window();
		Thread.sleep(3000);
		System.out.println("------- Completed --> close_IEEE_Meeting_Book() -----------");
	}
	
	// ----------------Function Being Called------------------------------------------
	public void verify_Back_To_Orginal_Tab() throws InterruptedException {
		Thread.sleep(3000);
		this.verify_Agenda_Title_And_Outline();
		Thread.sleep(3000);
		System.out.println("------- Completed --> close_IEEE_Meeting_Book() -----------");
	}
}