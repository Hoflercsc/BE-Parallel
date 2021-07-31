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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.Select;
//static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

public class DiscussionPage {
	// ----------- POM Page Object model -----------------------------
	WebDriver driver;
	String formTitle = "This is a Open Discussion Title";
	String formTitle2 = "This is a Upcoming Discussion Title";
	String formTitle3 = "This is a Closed Discussion Title";
	By WelcomeHeader = By.xpath("//h1[contains(text(),'Welcome')]");
	By AutoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By collaborateActiveOff = By.xpath("//span[@class='icon icon_wr-collaboration active-off']");
	By workroomSubnav = By.xpath("//div[@class='center workroom-subnav']");
	By discussionsSubMenu = By.xpath("//a[contains(text(),'Discussions')]");
	By discussionsSubMenu2 = By.xpath("//span[@class='label label-default']//a[contains(text(),'Discussions')]");
	By newDiscussionBtn = By.xpath("//a[@class='btn btn-success no-mobile']");
	// By surveyDueDate = By.xpath("//input[@id='survey_expiration_date']");
	// By surveyReminderDate = By.xpath("//input[@id='survey_reminder_date']");
	By surveySucessMessage = By
			.xpath("//div[@class='col-md-10 narrow meeting-details']//div//p[contains(text(),'Successfully created This is a Title')]");
	By formTitleField = By.xpath("//input[@id='discussion_title']");
	By inputDiscussionStart = By.xpath("//input[@id='discussion_starts']");
	By inputDiscussionEnd = By.xpath("//input[@id='discussion_ends']");
	By saveBtn = By.xpath("//button[@name='button']");
	By addUsersSearchField = By.xpath("//input[@placeholder='Search']");
	By openDiscussions = By.xpath("//a[contains(text(),'Open Discussions')]");
	By upcomingDiscussions = By.xpath("//a[contains(text(),'Upcoming Discussions')]");
	By closeDiscussions = By.xpath("//a[contains(text(),'Closed Discussions')]");

	public DiscussionPage(WebDriver driver) {
		this.driver = driver;
	}

	// ------------------ Expected Conditions Wait Methods ---------------------
	public void verifyWelcomeHeader() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(WelcomeHeader)));
	}

	public void verifyCollaborateActiveOff() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(collaborateActiveOff)));
	}

	public void verifyworkroomSubnav() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomSubnav)));
	}

	public void verifyFormTitleField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(formTitleField)));
	}

	public void verifyAddUsersSearchField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(addUsersSearchField)));
	}

	public void verifyOpenDiscussions() throws InterruptedException {
		Thread.sleep(3000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(openDiscussions)));
	}

	// ------------------ Elements ---------------------
	public void clickAutoBEWorkRoom() {
		driver.findElement(AutoBE).click();
	}

	public void clickCollaborateActiveOff() {
		driver.findElement(collaborateActiveOff).click();
	}

	public void clickDiscussionSubMenu() {
		driver.findElement(discussionsSubMenu).click();
	}

	public void clickDiscussionSubMenu2() {
		driver.findElement(discussionsSubMenu2).click();
	}

	public void clickNewDiscussionBtn() throws InterruptedException {
		driver.findElement(newDiscussionBtn).click();
		Thread.sleep(3000);
	}

	public void clickFormtitleFieldSendKeysSave() throws InterruptedException {
		driver.findElement(formTitleField).click();
		Thread.sleep(1000);
		driver.findElement(formTitleField).sendKeys(formTitle);
	}

	public void clickFormtitleFieldSendKeysSave2() throws InterruptedException {
		driver.findElement(formTitleField).click();
		Thread.sleep(1000);
		driver.findElement(formTitleField).sendKeys(formTitle2);
	}

	public void clickFormtitleFieldSendKeysSave3() throws InterruptedException {
		driver.findElement(formTitleField).click();
		Thread.sleep(1000);
		driver.findElement(formTitleField).sendKeys(formTitle3);
	}

	public void clickUpcomingDiscussions() throws InterruptedException {
		driver.findElement(upcomingDiscussions).click();
		Thread.sleep(2000);
	}

	public void clickClosedDiscussions() throws InterruptedException {
		driver.findElement(closeDiscussions).click();
		Thread.sleep(2000);
	}

	public void formCalendarOpenDate() throws InterruptedException {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		// manipulate date
		// c.add(Calendar.YEAR, 1);
		// c.add(Calendar.MONTH, 1);
		c2.add(Calendar.DATE, 2); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// c.add(Calendar.HOUR, 1);
		// c.add(Calendar.MINUTE, 1);
		// c.add(Calendar.SECOND, 1);
		// convert calendar to date
		Date CurrentDate = c1.getTime();
		;
		String strDateOne = (dateFormat.format(CurrentDate));
		Date currentDatePlusTwo = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTwo));
		System.out.println(dateFormat.format(CurrentDate));
		System.out.println(strDateOne);
		System.out.println(dateFormat.format(currentDatePlusTwo));
		System.out.println(strDateTwo);
		// driver.findElement(inputDiscussionStart).click();
		driver.findElement(inputDiscussionStart).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionStart).clear();
		driver.findElement(inputDiscussionStart).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(inputDiscussionEnd).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionEnd).clear();
		driver.findElement(inputDiscussionEnd).sendKeys(strDateTwo);
	}
	
	public void formCalendarOpenDate_2() throws InterruptedException {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		// manipulate date
		// c.add(Calendar.YEAR, 1);
		// c.add(Calendar.MONTH, 1);
		c2.add(Calendar.DATE, 2); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// c.add(Calendar.HOUR, 1);
		// c.add(Calendar.MINUTE, 1);
		// c.add(Calendar.SECOND, 1);
		// convert calendar to date
		Date CurrentDate = c1.getTime();
		;
		String strDateOne = (dateFormat.format(CurrentDate));
		Date currentDatePlusTwo = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTwo));
		System.out.println(dateFormat.format(CurrentDate));
		System.out.println(strDateOne);
		System.out.println(dateFormat.format(currentDatePlusTwo));
		System.out.println(strDateTwo);
		// driver.findElement(inputDiscussionStart).click();
		driver.findElement(inputDiscussionStart).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionStart).clear();
		driver.findElement(inputDiscussionStart).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(inputDiscussionEnd).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionEnd).clear();
		driver.findElement(inputDiscussionEnd).sendKeys(strDateTwo);
	}

	public void formCalendarUpComingDate() throws InterruptedException {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		// manipulate date
		// c.add(Calendar.YEAR, 1);
		// c.add(Calendar.MONTH, 1);
		c1.add(Calendar.DATE, 2); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.DATE, 5); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// c.add(Calendar.HOUR, 1);
		// c.add(Calendar.MINUTE, 1);
		// c.add(Calendar.SECOND, 1);
		// convert calendar to date
		Date currentDatePlusFive = c1.getTime();
		String strDateOne = (dateFormat.format(currentDatePlusFive));
		System.out.println(dateFormat.format(currentDatePlusFive));
		System.out.println(strDateOne);
		Date currentDatePlusTen = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTen));
		System.out.println(dateFormat.format(currentDatePlusTen));
		System.out.println(strDateTwo);
		// driver.findElement(inputDiscussionStart).click();
		driver.findElement(inputDiscussionStart).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionStart).clear();
		driver.findElement(inputDiscussionStart).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(inputDiscussionEnd).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionEnd).clear();
		driver.findElement(inputDiscussionEnd).sendKeys(strDateTwo);
	}
	
	public void formCalendarUpComingDate_2() throws InterruptedException {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		// manipulate date
		// c.add(Calendar.YEAR, 1);
		// c.add(Calendar.MONTH, 1);
		c1.add(Calendar.DATE, 2); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.DATE, 5); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// c.add(Calendar.HOUR, 1);
		// c.add(Calendar.MINUTE, 1);
		// c.add(Calendar.SECOND, 1);
		// convert calendar to date
		Date currentDatePlusFive = c1.getTime();
		String strDateOne = (dateFormat.format(currentDatePlusFive));
		System.out.println(dateFormat.format(currentDatePlusFive));
		System.out.println(strDateOne);
		Date currentDatePlusTen = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTen));
		System.out.println(dateFormat.format(currentDatePlusTen));
		System.out.println(strDateTwo);
		// driver.findElement(inputDiscussionStart).click();
		driver.findElement(inputDiscussionStart).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionStart).clear();
		driver.findElement(inputDiscussionStart).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(inputDiscussionEnd).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionEnd).clear();
		driver.findElement(inputDiscussionEnd).sendKeys(strDateTwo);
	}

	public void formCalendarClosedDate() throws InterruptedException {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date currentDate = new Date();
		// System.out.println(dateFormat.format(currentDate));
		// convert date to calendar
		Calendar c1 = Calendar.getInstance();
		c1.setTime(currentDate);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(currentDate);
		// manipulate date
		// c.add(Calendar.YEAR, 1);
		// c.add(Calendar.MONTH, 1);
		c1.add(Calendar.DATE, -7); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.DATE, -5); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		// c.add(Calendar.HOUR, 1);
		// c.add(Calendar.MINUTE, 1);
		// c.add(Calendar.SECOND, 1);
		// convert calendar to date
		Date currentDatePlusFive = c1.getTime();
		String strDateOne = (dateFormat.format(currentDatePlusFive));
		System.out.println(dateFormat.format(currentDatePlusFive));
		System.out.println(strDateOne);
		Date currentDatePlusTen = c2.getTime();
		String strDateTwo = (dateFormat.format(currentDatePlusTen));
		System.out.println(dateFormat.format(currentDatePlusTen));
		System.out.println(strDateTwo);
		// driver.findElement(inputDiscussionStart).click();
		driver.findElement(inputDiscussionStart).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionStart).clear();
		driver.findElement(inputDiscussionStart).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(inputDiscussionEnd).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputDiscussionEnd).clear();
		driver.findElement(inputDiscussionEnd).sendKeys(strDateTwo);
	}

	By startDate = By.xpath("//input[@id='discussion_starts']");
	By EndDate = By.xpath("//input[@id='discussion_ends']");
	
	public void startDateCalendarFuture() throws InterruptedException {
		WebElement element = driver.findElement(startDate);
		element.click();
		Thread.sleep(1500);
		
		DateFormat dateFormat = new SimpleDateFormat("d");
		Date currentDate = new Date();
		
		// --- get current date-----
	    String todaysDate = dateFormat.format(currentDate).toString();
        System.out.println(todaysDate);
        // ------------------------- 
        
		Calendar c1 = Calendar.getInstance();
	    c1.setTime(currentDate);
	    c1.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
	    Date CurrentDate = c1.getTime();;
        String strDateOne = (dateFormat.format(CurrentDate));
		 
       //--logic 
		WebElement calendar = driver.findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[1]"));
		List<WebElement> opt = calendar.findElements(By.tagName("td"));
		//List<String> d = opt.stream().map(WebElement::getText).collect(Collectors.toList());		 
		//System.out.println(d);

		for (WebElement DATE : opt) {
			
			 String DAY = DATE.getText().trim();
			 System.out.println(DAY);
			 
			 	if (todaysDate.equals("29") || todaysDate.equals("30") || todaysDate.equals("31"))  {
			 		driver.findElement(By.cssSelector("body > div.bootstrap-datetimepicker-widget.dropdown-menu.picker-open.bottom > ul > li.collapse.in > div > div.datepicker-days > table > thead > tr:nth-child(1) > th.next")).click();
					Thread.sleep(2000);
					
					WebElement calendarB = driver.findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[1]"));
					List<WebElement> optB = calendarB.findElements(By.tagName("td"));
					//List<String> dB = optB.stream().map(WebElement::getText).collect(Collectors.toList());		 
					//System.out.println(dB);
					
						for (WebElement DATEB : optB) {
							
							 String DAYB = DATEB.getText().trim();
							 System.out.println(DAYB);
							 
							if (DATEB.getText().equals(strDateOne)) {
								DATEB.click(); // clicks desired option
								break;
							}
								
						  }
						break;// break out for 4 loop	

			 	}else if (DATE.getText().equals(strDateOne)) {
						  DATE.click(); // clicks desired option
						   break;
				}
			 
			}
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//div[@class='col-md-8']")).click();
	}

	public void endDateCalendarFuture() throws InterruptedException {
		WebElement element = driver.findElement(EndDate);
		element.click();
		Thread.sleep(1500);
		
		DateFormat dateFormat = new SimpleDateFormat("d");
		Date currentDate = new Date();
		
		// --- get current date-----
	    String todaysDate = dateFormat.format(currentDate).toString();
        System.out.println(todaysDate);
        // ------------------------- 
        
		Calendar c2 = Calendar.getInstance();
	    c2.setTime(currentDate);
	    c2.add(Calendar.DATE, 2); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        Date currentDatePlusTwo = c2.getTime();
        String strDateTwo = (dateFormat.format(currentDatePlusTwo));
        
		WebElement calendar = driver.findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[2]"));
		List<WebElement> opt = calendar.findElements(By.tagName("td"));
		//List<String> d = opt.stream().map(WebElement::getText).collect(Collectors.toList());		 
		//System.out.println(d);

		for (WebElement DATE : opt) {
			
			 String DAY = DATE.getText().trim();
			 System.out.println(DAY);
			 
			 	if (todaysDate.equals("29") || todaysDate.equals("30") || todaysDate.equals("31"))  {
			 		driver.findElement(By.xpath("/html/body/div[44]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]")).click();
					Thread.sleep(2000);
					
					WebElement calendarB = driver.findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[2]"));
					List<WebElement> optB = calendarB.findElements(By.tagName("td"));
					//List<String> dB = optB.stream().map(WebElement::getText).collect(Collectors.toList());		 
					//System.out.println(dB);
					
						for (WebElement DATEB : optB) {
							
							 String DAYB = DATEB.getText().trim();
							 System.out.println(DAYB);
							 
							if (DATEB.getText().equals(strDateTwo)) {
								DATEB.click(); // clicks desired option
								break;
							}
								
						  }
						break;// break out for 4 loop	

			 	}else if (DATE.getText().equals(strDateTwo)) {
					DATE.click(); // clicks desired option
					break;
				}
			 
			}
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//div[@class='col-md-8']")).click();
	}
	
	public void startDateCalendarPast() throws InterruptedException {
		WebElement element = driver.findElement(startDate);
		element.click();
		Thread.sleep(1500);
		
		DateFormat dateFormat = new SimpleDateFormat("d");
		Date currentDate = new Date();
		Calendar c1 = Calendar.getInstance();
	    c1.setTime(currentDate);
	    c1.add(Calendar.DATE, -4); // same with c.add(Calendar.DAY_OF_MONTH, 1);
	    Date CurrentDate = c1.getTime();
        String minus4days = (dateFormat.format(CurrentDate));
		 
        WebElement calendar = driver.findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[1]"));
		List<WebElement> opt = calendar.findElements(By.tagName("td"));
		List<String> d = opt.stream().map(WebElement::getText).collect(Collectors.toList());		 
		System.out.println(d);

		for (WebElement DATE : opt) {
			
			 String DAY = DATE.getText().trim();
			 System.out.println(DAY);
			 
			 	if (DATE.getText().equals("1") || DATE.getText().equals("2") || DATE.getText().equals("3") || DATE.getText().equals("6"))  {
			 		
			 		String leftCalendarArrow = "body > div.bootstrap-datetimepicker-widget.dropdown-menu.bottom.picker-open > ul > li.collapse.in > div > div.datepicker-days > table > thead > tr:nth-child(1) > th.prev";
			 		driver.findElement(By.cssSelector(leftCalendarArrow)).click();
					Thread.sleep(2000);
					
					WebElement calendarB = driver.findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[1]"));
					List<WebElement> dates = calendarB.findElements(By.tagName("td"));
					List<String> dB = dates.stream().map(WebElement::getText).collect(Collectors.toList());		 
					System.out.println(dB);
					
						for (WebElement DATEB : dates) {
							
							 String DAYB = DATEB.getText().trim();
							 System.out.println(DAYB);
							 
							if (DATEB.getText().equals(minus4days)) {
								DATEB.click(); // clicks desired option
								break;
							}
								
						  }
						break;// break out for 4 loop	

			 	}else if (DATE.getText().equals(minus4days)) {
					DATE.click(); // clicks desired option
					break;
				}
			 
			}
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//div[@class='col-md-8']")).click();
	}
	
	
	public void endDateCalendarPast() throws InterruptedException {
		WebElement element = driver.findElement(EndDate);
		element.click();
		Thread.sleep(1500);
		
		DateFormat dateFormat = new SimpleDateFormat("d");
		Date currentDate = new Date();
		Calendar c2 = Calendar.getInstance();
	    c2.setTime(currentDate);
	    c2.add(Calendar.DATE, -1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        Date currentDateMinusOne = c2.getTime();
        String minus1day = (dateFormat.format(currentDateMinusOne));
        
	    WebElement calendar = driver.findElement(By.xpath(" (//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[2]"));
		List<WebElement> opt = calendar.findElements(By.tagName("td"));
		List<String> d = opt.stream().map(WebElement::getText).collect(Collectors.toList());		 
		System.out.println(d);

		for (WebElement DATE : opt) {
			
			 String DAY = DATE.getText().trim();
			 System.out.println(DAY);
			 
				if (DATE.getText().equals(minus1day)) {
					DATE.click(); // clicks desired option
					break;
				}
			}
			Thread.sleep(2000);
	}
	
	public void startDateCalendarOpen() throws InterruptedException {
		WebElement element = driver.findElement(startDate);
		element.click();
		Thread.sleep(1500);
		
		DateFormat dateFormat = new SimpleDateFormat("d");
		Date currentDate = new Date();
		Calendar c1 = Calendar.getInstance();
	    c1.setTime(currentDate);
	    Date CurrentDate = c1.getTime();;
        String strDateOne = (dateFormat.format(CurrentDate));
		 
		WebElement calendar = driver.findElement(By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//tbody"));

		List<WebElement> opt = calendar.findElements(By.tagName("td"));
		//List<String> d = opt.stream().map(WebElement::getText).collect(Collectors.toList());		 
		//System.out.println(d);

		for (WebElement DATE : opt) {
			
			 String DAY = DATE.getText().trim();
			 System.out.println(DAY);
			 
				if (DATE.getText().equals(strDateOne)) {
					DATE.click(); // clicks desired option
					break;
				}
			}
			Thread.sleep(2000);
		}
	
	public void endDateCalendarOpen() throws InterruptedException {
		WebElement element = driver.findElement(EndDate);
		element.click();
		Thread.sleep(1500);
		
		DateFormat dateFormat = new SimpleDateFormat("d");
		Date currentDate = new Date();
		Calendar c2 = Calendar.getInstance();
	    c2.setTime(currentDate);
	    c2.add(Calendar.DATE, 2); 
        Date currentDatePlusTwo = c2.getTime();
        String strDateTwo = (dateFormat.format(currentDatePlusTwo));
        
		WebElement calendar = driver.findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[2]"));
		List<WebElement> opt = calendar.findElements(By.tagName("td"));
		//List<String> d = opt.stream().map(WebElement::getText).collect(Collectors.toList());		 
		//System.out.println(d);
		
		for (WebElement DATE : opt) {
			
			 String DAY = DATE.getText().trim();
			 System.out.println(DAY);
			 
			 	if (DATE.getText().equals("29") || DATE.getText().equals("30") || DATE.getText().equals("31"))  {
			 		driver.findElement(By.xpath("/html/body/div[44]/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]")).click();
					Thread.sleep(2000);
					
					WebElement calendarB = driver.findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[2]"));
					List<WebElement> optB = calendarB.findElements(By.tagName("td"));
					
						for (WebElement DATEB : optB) {
							
							 String DAYB = DATEB.getText().trim();
							 System.out.println(DAYB);
							 
							if (DATEB.getText().equals(strDateTwo)) {
								DATEB.click(); // clicks desired option
								break;
							}
								
						  }
						break;// break out for 4 loop	

			 	}else if (DATE.getText().equals(strDateTwo)) {
					DATE.click(); // clicks desired option
					break;
				}
		  
			}
	
		}
	
	
	public void saveBtn() throws InterruptedException {
		driver.findElement(saveBtn).click();
	}

	// ------------------ Iframe Text Box Send Keys ---------------------
	public void discussionDescriptionTextBox() throws InterruptedException {
		WebElement descriptionLabel = driver.findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", descriptionLabel);
		Thread.sleep(1000);
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("This is a test that sending text through iframes work!");
		driver.switchTo().defaultContent();
	}

	// --------------Function Being Called ---------------------------
	public void addDiscussionRoomUsers() throws InterruptedException {
		// ------------- Div users------------------------
		String WAdiv = "//div[contains(text(),'Workroom Admin')]";
		String ADdiv = "//div[contains(text(),'Auto Director')]";
		String ATdiv = "//div[contains(text(),'Automation Tester')]";
		// ------------- span users ------------------------
		String WAspan = "//span[contains(text(),'Workroom Admin')]";
		String ADspan = "//span[contains(text(),'Auto Director')]";
		String ATspan = "//span[contains(text(),'Automation Tester')]";
		boolean workroom_Admin = driver.findElements(By.xpath(WAspan)).size() != 0;
		boolean Auto_Director = driver.findElements(By.xpath(ADspan)).size() != 0;
		boolean Automation_Tester = driver.findElements(By.xpath(ATspan)).size() != 0;
		if (workroom_Admin == false) {
			driver.findElement(By.xpath(WAdiv)).click();
		}
		if (Auto_Director == false) {
			driver.findElement(By.xpath(ADdiv)).click();
		}
		if (Automation_Tester == false) {
			driver.findElement(By.xpath(ATspan)).click();
		}
		String saveBtn = "//a[@class='btn btn-done']";
		driver.findElement(By.xpath(saveBtn)).click();
	}

	public void verifyOpenDiscussionExist() throws InterruptedException {
		String discussion = "(//*[contains(text(),'This is a Open Discussion Title')])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(discussion)).size() != 0);
		Thread.sleep(1000);
	}

	public void verifyUpcomingDiscussionExist() throws InterruptedException {
		String discussion = "(//*[contains(text(),'This is a Upcoming Discussion Title')])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(discussion)).size() != 0);
		Thread.sleep(1000);
	}

	public void verifyClosedDiscussionExist() throws InterruptedException {
		String discussion = "(//*[contains(text(),'This is a Closed Discussion Title')])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(discussion)).size() != 0);
		Thread.sleep(1000);
	}

	// --------------Function Being Called ---------------------------
	public void create_Discussion_Future_Date() throws InterruptedException {
		//this.verifyWelcomeHeader();
		//this.clickAutoBEWorkRoom();
		//this.verifyCollaborateActiveOff();
		//this.clickCollaborateActiveOff();
		this.verifyworkroomSubnav();
		this.clickDiscussionSubMenu();
		this.clickNewDiscussionBtn();
		this.verifyFormTitleField();
		this.clickFormtitleFieldSendKeysSave2();
		
		String url = driver.getCurrentUrl();
		String ozzie = "automation-ozzie.boardeffect.com";
		
		if (url.contains(ozzie)) {
			this.formCalendarUpComingDate();
		}else {
			this.formCalendarUpComingDate_2();
		}
		
		//this.startDateCalendarFuture();
		//this.endDateCalendarFuture();
		this.discussionDescriptionTextBox();
		this.saveBtn();
		this.verifyAddUsersSearchField();
		this.addDiscussionRoomUsers();
		this.verifyworkroomSubnav();
		this.clickDiscussionSubMenu2();
		this.verifyOpenDiscussions();
		this.clickUpcomingDiscussions();
		this.verifyUpcomingDiscussionExist();
		System.out.println("------- Completed --> Create_Discussion_Future_Date-----------");
	}

	// --------------Function Being Called ---------------------------
	public void create_Discussion_Future_Date_Past() throws InterruptedException {
		this.clickNewDiscussionBtn();
		this.verifyFormTitleField();
		this.clickFormtitleFieldSendKeysSave3();
		this.formCalendarClosedDate();
		//this.startDateCalendarPast();
		//this.endDateCalendarPast();
		this.discussionDescriptionTextBox();
		this.saveBtn();
		this.verifyAddUsersSearchField();
		this.addDiscussionRoomUsers();
		this.verifyworkroomSubnav();
		this.clickDiscussionSubMenu2();
		this.verifyOpenDiscussions();
		this.clickClosedDiscussions();
		this.verifyClosedDiscussionExist();
		System.out.println("------- Completed --> Create_Discussion_Future_Date_Past()-----------");
	}
	
	String newTopic = "This is a New Topic";
	String newReply = "This is a New Reply Topic";
	String newReply_2 = "This is a New Topic 4 Me Someone";
	By discussionTitle = By.xpath("(//*[contains(text(),'This is a Open Discussion Title')])[1]");
	By newtopicBtn = By.xpath("//a[@class='btn btn-success pull-right']");
	By inputTopicTitle = By.xpath("//input[@id='discussion_post_title']");
	By topicSubmitBtn = By.xpath("//div[@id='discussionModal']//button[@class='btn btn-done'][contains(text(),'Submit')]");
	By topicTitle = By.xpath("//a[contains(text(),'This is a New Topic')]");
	By newReplyBtn = By.xpath("//a[@class='btn btn-success fl-right margin-right-small']");

	public void clickDiscussionTitle() throws InterruptedException {
		driver.findElement(discussionTitle).click();
		Thread.sleep(2000);
	}

	public void clickNewTopicBtn() throws InterruptedException {
		driver.findElement(newtopicBtn).click();
	}

	public void topicTitleAndBodySendKeys() throws InterruptedException {
		driver.findElement(inputTopicTitle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputTopicTitle).clear();
		driver.findElement(inputTopicTitle).sendKeys(newTopic);
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys("What do you think about this topic for the meeting?");
		driver.switchTo().defaultContent();
		driver.findElement(topicSubmitBtn).click();
		Thread.sleep(2000);
	}

	public void clickTopicTitleHeading() throws InterruptedException {
		driver.findElement(topicTitle).click();
	}

	public void clickNewReplyBtn() throws InterruptedException {
		driver.findElement(newReplyBtn).click();
	}

	public void topicReplySendKeysAndAttach() throws InterruptedException {
		driver.findElement(inputTopicTitle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputTopicTitle).clear();
		driver.findElement(inputTopicTitle).sendKeys(newReply);
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys("I think its great here is some information that will help");
		driver.switchTo().defaultContent();
		String input = "//input[@id='files_']";
		String filepath = "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\Word_1.docx";
		WebElement fileInput = driver.findElement(By.xpath(input));
		fileInput.sendKeys(filepath);
		Thread.sleep(2000);
		driver.findElement(topicSubmitBtn).click();
	}

	public void verifyTopicReplyAndAttachmentExist() throws InterruptedException {
		String topicMessage = "//p[contains(text(),'I think its great here is some information that wi')]";
		String attachment = "//p[@class='no-bottom-margin']//a[contains(text(),'Word_1.docx')]";
		Assert.assertTrue(driver.findElements(By.xpath(topicMessage)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(attachment)).size() > 0);
		Thread.sleep(1000);
	}

	public void verifyTopicTitleInputField() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(inputTopicTitle)));
	}

	public void verifyCreatedTopicTitleHeading() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(topicTitle)));
	}

	public void verifyNewReplyBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newReplyBtn)));
	}

	public void verifyNewTopicBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newtopicBtn)));
	}

	public void verifyNewDiscussionBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newDiscussionBtn)));
	}

	// --------------Function Being Called ---------------------------
	public void create_Open_Discussion_AssignUsers() throws InterruptedException {
		this.clickNewDiscussionBtn();
		this.verifyFormTitleField();
		this.clickFormtitleFieldSendKeysSave();
		
		String url = driver.getCurrentUrl();
		String ozzie = "automation-ozzie.boardeffect.com";
		
		if (url.contains(ozzie)) {
			this.formCalendarOpenDate();
		}else {
			this.formCalendarOpenDate_2();
		}
		this.discussionDescriptionTextBox();
		this.saveBtn();
		this.verifyAddUsersSearchField();
		this.addDiscussionRoomUsers();
		this.verifyworkroomSubnav();
		this.clickDiscussionSubMenu2();
		this.verifyOpenDiscussions();
		this.verifyOpenDiscussionExist();
		System.out.println("------- Completed --> Create_Open_Discussion_AssignUsers()-----------");
	}

	// --------------Function Being Called ---------------------------
	public void create_Discussion_MainTopic() throws InterruptedException {
		this.clickDiscussionTitle();
		this.verifyNewTopicBtn();
		this.clickNewTopicBtn();
		this.verifyTopicTitleInputField();
		this.topicTitleAndBodySendKeys();
		this.verifyCreatedTopicTitleHeading();
		System.out.println("------- Completed --> Create_Discussion_MainTopic()-----------");
	}

	// --------------Function Being Called ---------------------------
	public void create_Topic_Reply_And_Attachment() throws InterruptedException {
		// -----reply to topic-----------
		this.clickTopicTitleHeading();
		this.verifyNewReplyBtn();
		this.clickNewReplyBtn();
		this.topicReplySendKeysAndAttach();
		this.verifyNewReplyBtn();
		// -----verify top reply and attachment exist-------
		this.verifyTopicReplyAndAttachmentExist();
		System.out.println("------- Completed --> Create_Topic_Reply_And_Attachment()-----------");
	}
	
	// ---------------------------------------------------------------------------
	String replyMessage = "I think its great here is some information that will help";
	By dropDown = By.xpath("//span[@class='filter-option pull-left']");
	By topicsReplies = By.xpath("//span[contains(text(),'Topics and Replies')]");
	By search = By.xpath("//input[@placeholder='Type in keyword to search within Discussions']");
	By submitBtn = By.xpath("//div[@class='btn-group discussion-search-bar']//button[@class='btn btn-done'][contains(text(),'Submit')]");

	public void clickDropDown() throws InterruptedException {
		driver.findElement(dropDown).click();
	}

	public void clickTopicsReplies() throws InterruptedException {
		driver.findElement(topicsReplies).click();
		Thread.sleep(2000);
	}

	public void searchForReply() throws InterruptedException {
		driver.findElement(search).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys(replyMessage);
		Thread.sleep(3000);
	}

	public void clickSubmitBtn() throws InterruptedException {
		driver.findElement(submitBtn).click();
	}

	public void verifyReplyMessageExist() throws InterruptedException {
		Thread.sleep(2000);
		String replyMessage = "//p[contains(text(),'I think its great here is some information that wi')]";
		Assert.assertTrue(driver.findElements(By.xpath(replyMessage)).size() > 0);
		Thread.sleep(1000);
	}

	public void verifyTopicsReplies() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(topicsReplies)));
	}

	// --------------Function Being Called ---------------------------
	public void discussion_Search_4_Reply() throws InterruptedException {
		this.clickDiscussionSubMenu2();
		this.verifyNewDiscussionBtn();
		this.clickDropDown();
		this.verifyTopicsReplies();
		this.clickTopicsReplies();
		this.searchForReply();
		this.clickSubmitBtn();
		this.verifyReplyMessageExist();
		System.out.println("-------Completed --> Discussion_Search_4_Reply()-----------");
	}

	// ------------------------Edit Discussion Topic---------------------------
	// By topicArrow = By.xpath("//div[@class='btn-group small
	// pull-right']//span[@class='caret']");
	By topicArrow = By.xpath("//div[@class='btn-group small pull-right']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By NewTopic = By.xpath("//a[contains(text(),'This is a New Topic 4 Me Someone')]");
	By editOption = By.xpath("//div[@class='btn-group small pull-right open']//a[contains(text(),'Edit')]");
	By editedTopic = By.xpath("//a[contains(text(),'This is a New Topic 4 Me')]");
	By deleteOption = By.xpath("//a[contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger']");

	public void verifyEditOption() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(editOption)));
	}

	public void verifyContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void clickTopicArrow() throws InterruptedException {
		driver.findElement(topicArrow).click();
	}

	public void clickEditOption() throws InterruptedException {
		driver.findElement(editOption).click();
	}

	public void clickDeleteOption() throws InterruptedException {
		driver.findElement(deleteOption).click();
	}

	public void clickContinueBtn() throws InterruptedException {
		driver.findElement(continueBtn).click();
	}

	public void editTopicTitleAndSave() throws InterruptedException {
		driver.findElement(inputTopicTitle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputTopicTitle).clear();
		driver.findElement(inputTopicTitle).sendKeys("This is a New Topic 4 Me Someone");
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("I am editing topic information for this meeting");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(topicSubmitBtn).click();
	}

	public void verifyNewTopic() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(NewTopic)));
	}

	public void verifyDeletedTopicIsNotVisible() throws InterruptedException {
		String newTopic = "//a[contains(text(),'This is a New Topic 4 Me')]";
		Assert.assertTrue(driver.findElements(By.xpath(newTopic)).size() < 1);
	}

	// --------------Function Being Called ---------------------------
	public void edit_Discussion_Topic() throws InterruptedException {
		this.clickDiscussionSubMenu2();
		this.verifyNewDiscussionBtn();
		this.clickDiscussionTitle();
		this.verifyNewTopicBtn();
		this.clickTopicArrow();
		this.verifyEditOption();
		this.clickEditOption();
		this.verifyTopicTitleInputField();
		this.editTopicTitleAndSave();
		// page resfresh occurs
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verifyNewTopic();
		System.out.println("--------Completed --> Edit_Discussion_Topic()--------");
	}

	// --------------Function Being Called ---------------------------
	public void delete_Discussion_Topic() throws InterruptedException {
		this.clickDiscussionSubMenu2();
		this.verifyNewDiscussionBtn();
		this.clickDiscussionTitle();
		this.verifyNewTopicBtn();
		Thread.sleep(3000);
		this.clickTopicArrow();
		this.verifyEditOption();
		this.clickDeleteOption();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		this.verifyNewTopicBtn();
		driver.navigate().refresh();
		driver.navigate().refresh();
		// --have to refresh so discussion topic will disapear
		Thread.sleep(2000);
		System.out.println("--------we are here1--------");
		this.verifyDeletedTopicIsNotVisible();
		System.out.println("--------we are here2--------");
		System.out.println("--------Completed --> Delete_Discussion_Topic()--------");
	}

	// ------------------------Edit Discussion Topic------------------------------
	String newReply2 = "My Suggestions";
	// By topicArrowBtn = By.xpath("//div[@class='btn-group small pull-right
	// open']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By topicArrowBtn = By.xpath("//div[@class='btn-group small pull-right']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By editedreplyMessage = By.xpath("//p[contains(text(),'I think its great these suggestions will help')]");
	By mySugestions = By.xpath(" //a[contains(text(),'My Suggestions')]");

	public void clickTopicArrowBtn() throws InterruptedException {
		driver.findElement(topicArrowBtn).click();
	}

	public void clickMySugestions() throws InterruptedException {
		driver.findElement(mySugestions).click();
	}

	public void topicReplySendKeysAndAttach2() throws InterruptedException {
		driver.findElement(inputTopicTitle).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(inputTopicTitle).clear();
		driver.findElement(inputTopicTitle).sendKeys(newReply2);
		// switching to iframe
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		// finding body of iframe and sending text to it
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys("I think its great these suggestions will help");
		driver.switchTo().defaultContent();
		/*
		 * String input ="//input[@id='files_']"; String filepath =
		 * "C:\\Jenkins_New\\workspace\\Tests\\Ozzie\\BoardEffect\\Smoke_Tests_2\\BoardEffectProject_New\\uploadedFiles\\Word_1.docx";
		 * 
		 * WebElement fileInput = driver.findElement(By.xpath(input));
		 * fileInput.sendKeys(filepath);
		 */
		Thread.sleep(2000);
		driver.findElement(topicSubmitBtn).click();
	}

	public void verifyEditedTopicReplyExist() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(editedreplyMessage)));
	}

	public void verifyTopicArrowBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(topicArrowBtn)));
	}

	// --------------Function Being Called ---------------------------
	public void edit_Discussion_Topic_Reply() throws InterruptedException {
		this.verifyTopicArrowBtn();
		this.clickTopicArrowBtn();
		this.verifyEditOption();
		this.clickEditOption();
		this.topicReplySendKeysAndAttach2();
		this.verifyNewTopicBtn();
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(3000);
		this.clickMySugestions();
		this.verifyEditedTopicReplyExist();
		System.out.println("-------Completed--> Edit_Discussion_Topic_Reply()-----------");
	}
	
	
	// --------------Delete Edited Discussion Topic Reply-----------------------
	public void verifyEditedTopicReplyMessageNOTExist() throws InterruptedException {
		// String MySuggestions = "//*[@class='discussion-dark-1
		// semibold'][contains(text(),'My Suggestions')]";
		String editedreplyMessage = "//p[contains(text(),'I think its great here is some information that wi')]";
		// Assert.assertTrue(driver.findElements(By.xpath(MySuggestions)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(editedreplyMessage)).size() < 1);
		Thread.sleep(1000);
	}

	// --------------Function Being Called ---------------------------
	public void delete_Reply_To_Discussion_Topic() throws InterruptedException {
		this.verifyTopicArrowBtn();
		this.clickTopicArrowBtn();
		this.verifyEditOption();
		this.clickDeleteOption();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		this.verifyNewReplyBtn();
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(3000);
		this.verifyEditedTopicReplyMessageNOTExist();
		System.out.println("------- Completed--> Delete_Reply_To_Discussion_Topic -----------");
	}
	
	// -----------------Archive Discussion----------------------------------
	By dropdownMenu = By.xpath("(//div//button[@id='dropdownMenu1'])[1]");
	By archive = By.xpath("//div[@class='dropdown header-actions no-mobile open']//a[contains(text(),'Archive')]");
	By archives = By.xpath("//a[@class='btn btn-default'][contains(text(),'Archives')]");
	By archiveDiscussionsHeading = By.xpath("//h1[contains(text(),'Archived Discussions')]");

	public void verifyArchiveOption() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archive)));
	}

	public void verifyArchivesBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archives)));
	}

	public void verifyArchiveDiscussionHeading() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(archiveDiscussionsHeading)));
	}

	public void clickDropDownMenu() throws InterruptedException {
		driver.findElement(dropdownMenu).click();
	}

	public void clickArchiveOption() throws InterruptedException {
		driver.findElement(archive).click();
	}

	public void clickArchivesBtn() throws InterruptedException {
		driver.findElement(archives).click();
	}

	public void verifyDiscussionTitle() throws InterruptedException {
		String discussion = "(//*[contains(text(),'This is a Open Discussion Title')])[1]";
		String body = "//p[contains(text(),'This is a test that sending text through iframes w')]";
		Assert.assertTrue(driver.findElements(By.xpath(discussion)).size() != 0);
		Assert.assertTrue(driver.findElements(By.xpath(body)).size() != 0);
	}

	// --------------Function Being Called ---------------------------
	public void archive_Discussion() throws InterruptedException {
		this.clickDiscussionSubMenu2();
		this.verifyNewDiscussionBtn();
		this.clickDropDownMenu();
		this.verifyArchiveOption();
		this.clickArchiveOption();
		this.verifyArchivesBtn();
		this.clickArchivesBtn();
		Thread.sleep(1000);
		this.verifyArchiveDiscussionHeading();
		this.verifyDiscussionTitle();
		System.out.println("------- Completed--> Archive_Discussion -----------");
	}
	
	// --------------Restore Archive Discussion-------------------------
	By archiveDropDown = By.xpath("//button[@id='dropdownMenu1']");
	By restore = By.xpath("//a[contains(text(),'Restore')]");

	public void verifyRestoreOption() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(restore)));
	}

	public void clickArchiveDropDown() throws InterruptedException {
		driver.findElement(archiveDropDown).click();
	}

	public void clickRestoreOption() throws InterruptedException {
		driver.findElement(restore).click();
	}

	// --------------Function Being Called ---------------------------
	public void restore_Archived_Discussion() throws InterruptedException {
		this.clickArchiveDropDown();
		Thread.sleep(1000);
		this.verifyRestoreOption();
		this.clickRestoreOption();
		Thread.sleep(3000);
		System.out.println("------- Completed--> restore_Archived_Discussion -----------");
	}

	// --------------Function Being Called ---------------------------
	public void verify_restored_Archived_Discussion() throws InterruptedException {
		this.verifyNewDiscussionBtn();
		this.verifyDiscussionTitle();
		System.out.println("------- Completed--> verify_restored_Archived_Discussion -----------");
	}
	
	By open_Discussion_Dropdown_Arrow = By.xpath("(//a[contains(text(),'This is a Open Discussion Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By delete = By.xpath("//div[@class='dropdown header-actions no-mobile open']//a[contains(text(),'Delete')]");
	By upcoming_Discussion_Dropdown_Arrow = By.xpath("(//a[contains(text(),'This is a Upcoming Discussion Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By closed_Discussion_Dropdown_Arrow = By.xpath("(//a[contains(text(),'This is a Closed Discussion Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By open_Discussions = By.xpath("//a[contains(text(),'Open Discussions')]");

	public void verify_DeleteOption() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete)));
	}

	public void verify_Upcoming_Discussions_Heading() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(upcomingDiscussions)));
	}

	public void verify_Closed_Discussions_Heading() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(closeDiscussions)));
	}

	// --open
	public void click_Open_Discussions_Dropdown_Arrow() throws InterruptedException {
		driver.findElement(open_Discussion_Dropdown_Arrow).click();
	}

	// --upcoming
	public void click_Upcoming_Discussions_Dropdown_Arrow() throws InterruptedException {
		driver.findElement(upcoming_Discussion_Dropdown_Arrow).click();
	}

	// --closed
	public void click_Closed_Discussions_Dropdown_Arrow() throws InterruptedException {
		driver.findElement(closed_Discussion_Dropdown_Arrow).click();
	}

	// ---delete option
	public void click_Delete_Option() throws InterruptedException {
		driver.findElement(delete).click();
	}

	public void click_Open_Discussions() throws InterruptedException {
		driver.findElement(open_Discussions).click();
	}

	public void close_Open_Upcoming_And_Closed_Discussions() throws InterruptedException {
		// ------open discussions-------
		this.click_Open_Discussions_Dropdown_Arrow();
		this.verify_DeleteOption();
		this.click_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		// ------upcoming discussions------
		this.verify_Upcoming_Discussions_Heading();
		this.clickUpcomingDiscussions();
		this.verifyUpcomingDiscussionExist();
		this.click_Upcoming_Discussions_Dropdown_Arrow();
		this.verify_DeleteOption();
		this.click_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(4000);
		// ------closed discussions----------
		// ---issue with date picker
	/*	this.verify_Closed_Discussions_Heading();
		this.clickClosedDiscussions();
		this.verifyClosedDiscussionExist();
		this.click_Closed_Discussions_Dropdown_Arrow();
		this.verify_DeleteOption();
		this.click_Delete_Option();
		this.verifyContinueBtn();
		this.clickContinueBtn();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.click_Open_Discussions();
		Thread.sleep(2000);
		this.clickUpcomingDiscussions();
		Thread.sleep(2000);
		this.clickClosedDiscussions();
		Thread.sleep(2000); */
		System.out.println("------- Completed--> close_Open_Upcoming_And_Closed_Discussions -----------");
	}
}
