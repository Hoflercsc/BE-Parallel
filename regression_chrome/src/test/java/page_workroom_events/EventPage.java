package page_workroom_events;

import java.awt.AWTException;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
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
import page_common_functions.HomeNavigationPage;

public class EventPage {
	static String homePage = "https://automation-ozzie.boardeffect.com/login";
	WebDriver driver;
	// ----------- POM Page Object model ----------------------------
	// --------------Open_User_Profile---------------------------
	By system_Admin_User_Dropdown = By.xpath("(//a[contains(text(),'steve System')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By intergrations = By.xpath("//a[contains(text(),'Integrations')]");
	By edit = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");


	public void verify_System_Admin_User_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(system_Admin_User_Dropdown)));
	}

	public void verify_Edit_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit)));
	}
	
	public void verify_Intergrations() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(intergrations)));
	}

	public void click_System_Admin_Dropdown() {
		driver.findElement(system_Admin_User_Dropdown).click();
	}

	public void click_Intergrations() {
		//driver.findElement(intergrations).click();
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Integrations')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edit_Profile() {
		driver.findElement(edit).click();
	}

	// --------------Function Being Called ---------------------------
	public void open_User_Profile() throws InterruptedException {
		this.verify_System_Admin_User_Dropdown();
		Thread.sleep(1000);
		this.click_System_Admin_Dropdown();
		Thread.sleep(1500);
		this.verify_Edit_Profile();
		this.click_Edit_Profile();
		Thread.sleep(1000);
		System.out.println("------- Completed --> Open_User_Profile() -----------");
	}
	
	// --------------verify_G2M_Account_Connected---------------------------
	By g2m_Label = By.xpath("//label[contains(text(),'GoToMeeting')]");
	By connect_g2m_account = By.xpath("//a[@class='btn btn-default be-dark-blue'][contains(text(),'Connect your GoToMeeting Account')]");
	By email_Field = By.xpath("//input[@id='emailAddress']");
	By next_Btn = By.xpath("//input[@id='next-button']");
	By password_Field = By.xpath("//input[@id='password']");
	By sign_In = By.xpath("//input[@id='submit']");
	String email_Address = "jhofler@diligent.com ";
	String email_password = "Passw0rd";

	public void verify_G2M_Label() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(g2m_Label)));
	}
	
	public void verify_G2M_Email_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(email_Field)));
	}
	
	public void verify_Password_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(password_Field)));
	}
	
	public void click_Connect_G2M_Account() {
		driver.findElement(connect_g2m_account).click();
	}
	
	public void sendKeys_Email_Address() {
		driver.findElement(email_Field).sendKeys(email_Address);
	}
	
	public void sendKeys_Password_Field() {
		driver.findElement(password_Field).sendKeys(email_password);
	}
	
	public void click_Next_Btn() {
		driver.findElement(next_Btn).click();
	}
	
	public void click_Sign_In() {
		driver.findElement(sign_In).click();
	}
	
	public void g2m_Connection_Status_Check() throws InterruptedException {
		String connect_g2m_account = "//a[@class='btn btn-default be-dark-blue'][contains(text(),'Connect your GoToMeeting Account')]";
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean c_g2m_account = driver.findElements(By.xpath(connect_g2m_account)).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if(c_g2m_account == true) {
			this.click_Connect_G2M_Account();
			Thread.sleep(4000);
			String email_Field = "//input[@id='emailAddress']";
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Boolean email = driver.findElements(By.xpath(email_Field)).size() > 0;
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				if(email == true) {
					this.verify_G2M_Email_Field();
					this.sendKeys_Email_Address();
					this.click_Next_Btn();
					this.verify_Password_Field();
					this.sendKeys_Password_Field();
					this.click_Sign_In();
					Thread.sleep(6000);
						String allow = "//input[@id='submit-button']";
						driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
						Boolean cancelBtn = driver.findElements(By.xpath(allow)).size() > 0;
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							if(cancelBtn == true) {
								driver.findElement(By.xpath(allow)).click();
								this.verify_AutoBE();
							}
				}// end inner if
			}else {
				HomeNavigationPage obj = new HomeNavigationPage(driver);
				obj.user_Close_Directory_Profile();
				obj.user_Close_Directory();
				Thread.sleep(1500);
				driver.navigate().refresh();
			}//end else
		
		}// end function
	
	// --------------Function Being Called ---------------------------
	public void verify_G2M_Account_Connected() throws InterruptedException {
		this.verify_Intergrations();
		this.click_Intergrations();
		Thread.sleep(2000);
		this.verify_G2M_Label();
		this.g2m_Connection_Status_Check();
		System.out.println("------- Completed --> verify_G2M_Account_Connected() -----------");
	}
	
	//----------------------------------------------------------------
	By autoBE = By.xpath("//a[contains(text(),'AutoBE')]");
	By eventsMenu = By.xpath("//span[@class='icon icon_wr-events active-off']");
	By newEventBtn = By.xpath("//a[@class='btn btn-success pull-right no-mobile'][contains(text(),'New Event')]");
	By event_Form_Title = By.xpath("//input[@id='event_title']");
	String form_Title_Name = " This is a New Event Title ";
	String form_Title_Name_2 = " This is a New Event Title 2 ";

	public EventPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void verify_Events_Menu() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(eventsMenu)));
	}

	public void verify_New_Event_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newEventBtn)));
	}

	public void verify_Form_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Form_Title)));
	}

	public void click_AutoBE() throws InterruptedException {
		driver.findElement(autoBE).click();
	}

	public void click_Events_Menu() throws InterruptedException {
		driver.findElement(eventsMenu).click();
	}

	public void click_New_Event_Btn() throws InterruptedException {
		driver.findElement(newEventBtn).click();
	}

	// ---------Function being called ------
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		this.verify_Events_Menu();
		this.click_Events_Menu();
		this.verify_New_Event_Btn();
		System.out.println("------- Completed --> user_Can_Open_Events_for_Workroom() -----------");
	}
	public void go_To_Events_For_Workroom() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		this.verify_New_Event_Btn();
		System.out.println("------- Completed --> go_To_Events_For_Workroom() -----------");
	}
	
	// -------------Create Event Populate Form---------------------------------
	By form_Location = By.xpath("//input[@id='event_location']");
	By form_Address1 = By.xpath("//input[@id='event_address1']");
	By form_Address2 = By.xpath("//input[@id='event_address2']");
	By form_City = By.xpath("//input[@id='event_city']");
	By country_Option = By.xpath("//div[@class='btn-group bootstrap-select chosen country']//span[@class='filter-option pull-left'][contains(text(),'Select an Option')]");
	By state_Option = By.xpath("//div[@class='btn-group bootstrap-select chosen state']//span[@class='filter-option pull-left'][contains(text(),'State')]");
	By zipCode = By.xpath("//input[@id='event_zip']");
	By meeting_Option = By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']");
	By form_Top_SaveBtn = By.xpath("//aside//button[@name='button'][contains(text(),'Save')]");
	By eventCatagory = By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']//*[contains(text(),'Select an Option')]");
	By meetings = By.xpath("//span[contains(text(),'Meetings')]");
	By guestList = By.xpath("//label[contains(text(),'Private Guest List')]");
	By facilitator_Name = By.xpath("//input[@id='event_contact']");
	By facilitator_Email = By.xpath("//input[@id='event_email']");
	By website = By.xpath("//input[@id='event_website']");
	By rsvps = By.xpath("//label[contains(text(),'Track RSVPs')]");
	By go_To_Meeting_Invite = By.xpath("//div[19]//input[2]");
	By go_To_Meeting_Host = By.xpath("//div[@class='btn-group bootstrap-select chosen']//button[@class='btn dropdown-toggle btn-default']");
	By go_To_Account = By.xpath("//span[@class='text'][contains(text(),'steve System')]");
	By event_Success_Message = By.xpath("//*[contains(text(), 'Successfully')]");
	By workroom_Events_Crumb = By.xpath("//a[contains(text(),'Workroom Events')]");
	By notify = By.xpath("//input[@id='event_update_email']");
	By video_Conf_URL = By.xpath("//input[@id='event_custom_video_conference_url']");
	By startDate = By.xpath("//input[@id='event_datetime_start']");
	By EndDate = By.xpath("//input[@id='event_datetime_end']");

	String meeting = "Meeting";
	
	public void verify_SaveBtn_Top() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(form_Top_SaveBtn)));
	}

	public void click_Form_SaveBtn_Top() throws InterruptedException {
		WebElement SaveBtn = driver.findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(1500);
		driver.findElement(form_Top_SaveBtn).click();
	}

	// ------------------ Calendar Functions ---------------------
		public void startDateCalendar() throws InterruptedException {
			WebElement element = driver.findElement(startDate);
			element.click();
			Thread.sleep(1500);
			
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date currentDate = new Date();
			Calendar c1 = Calendar.getInstance();
		    c1.setTime(currentDate);
		    Date CurrentDate = c1.getTime();;
	        String strDateOne = (dateFormat.format(CurrentDate));
			 
			WebElement calendar = driver.findElement(By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//tbody"));

			List<WebElement> opt = calendar.findElements(By.tagName("td"));
			List<String> d = opt.stream().map(WebElement::getText).collect(Collectors.toList());		 
			System.out.println(d);

			for (WebElement DATE : opt) {
				
				 String DAY = DATE.getText().trim();
				 System.out.println(DAY);
				 
					if (DATE.getText().equals(strDateOne)) {
						DATE.click(); // clicks desired option
						break;
					}
				}
				Thread.sleep(2000);
				//driver.findElement(form_Location).click();// click to close calendar box
			}

		public void endDateCalendar() throws InterruptedException {
			WebElement element = driver.findElement(EndDate);
			//element.click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(1500);
			
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date currentDate = new Date();
			Calendar c2 = Calendar.getInstance();
		    c2.setTime(currentDate);
		    c2.add(Calendar.DATE, 2); //same with c.add(Calendar.DAY_OF_MONTH, 1);
	        Date currentDatePlusTwo = c2.getTime();
	        String strDateTwo = (dateFormat.format(currentDatePlusTwo));
	        
			WebElement calendar = driver.findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[2]"));
			List<WebElement> opt = calendar.findElements(By.tagName("td"));
			List<String> d = opt.stream().map(WebElement::getText).collect(Collectors.toList());		 
			System.out.println(d);

			for (WebElement DATE : opt) {
				
				 String DAY = DATE.getText().trim();
				 System.out.println(DAY);
				 
					if (DATE.getText().equals(strDateTwo)) {
						DATE.click(); // clicks desired option
						break;
					}
				}
				Thread.sleep(2000);
		}
		
	public void new_Event_Form_Populate() throws InterruptedException {
		String location = "cool location";
		String address_1 = "22 Smith Street";
		String address_2 = "apt 335";
		String city = "Charlotte";
		String zipcode = "28217";
		String facilitator = "Someone";
		String facilitator_email = "Someone@diligent.com";
		String Website = "https://www.diligent.com";
		driver.findElement(event_Form_Title).sendKeys(form_Title_Name);
		//----------
		this.formCalendarUpComingDate();
		//this.startDateCalendar();
		//this.endDateCalendar();
		//----------
		driver.findElement(form_Location).click();
		driver.findElement(form_Location).sendKeys(location);
		//driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement eventcatagory = driver.findElement(By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eventcatagory);
		// ---Event Catagory--
		driver.findElement(eventCatagory).click();
		Thread.sleep(1000);
		driver.findElement(meetings).click();
		// ---track rsvp------
		Thread.sleep(1000);
		driver.findElement(rsvps).click();
	}
	
	public void new_Event_Form_Populate_2() throws InterruptedException {
		String location = "cool location";
		String address_1 = "22 Smith Street";
		String address_2 = "apt 335";
		String city = "Charlotte";
		String zipcode = "28217";
		String facilitator = "Someone";
		String facilitator_email = "Someone@diligent.com";
		String Website = "https://www.diligent.com";
		driver.findElement(event_Form_Title).sendKeys(form_Title_Name_2);
		//----------
		this.formCalendarUpComingDate_2();
		//this.startDateCalendar();
		//this.endDateCalendar();
		//----------
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(form_Location).clear();
		driver.findElement(form_Location).sendKeys(location);
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement eventcatagory = driver.findElement(By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eventcatagory);
		// ---Event Catagory--
		driver.findElement(eventCatagory).click();
		Thread.sleep(1000);
		driver.findElement(meetings).click();
		// ---track rsvp------
		Thread.sleep(1500);
		driver.findElement(rsvps).click();
	}

	public void form_Country_State_Select() throws InterruptedException {
		// ----------COUNTRY---------------
		driver.findElement(country_Option).click();
		Thread.sleep(2000);
		// By countryList =
		// By.xpath("//*[@id=\"new_event\"]/div/div/div[8]/div/div/div[1]/div/div/ul");
		By countryList = By.xpath("(//ul[@class='dropdown-menu inner'])[2]");
		String country = "United States";
		WebElement dropdownlist = driver.findElement(countryList);
		List<WebElement> options = dropdownlist.findElements(By.tagName("li"));
		// System.out.println(options + ",");
		/*
		 * MAven compiler dosent like this List<String> optionsList =
		 * options.stream().map(WebElement::getText).collect(Collectors.toList());
		 * System.out.println(optionsList); System.out.println("Testing -----------");
		 */
		for (WebElement c_option : options) {
			if (c_option.getText().equals(country)) {
				c_option.click(); // clicks desired option
				break;
			}
		}
		// ----------STATE---------------
		driver.findElement(state_Option).click();
		Thread.sleep(1000);
		By stateList = By.xpath("//*[@id=\"order_state_code_wrapper\"]/div/div/ul");
		String searchText2 = "North Carolina";
		WebElement dropdownlist2 = driver.findElement(stateList);
		List<WebElement> optionTwo = dropdownlist2.findElements(By.tagName("li"));
		// System.out.println(optionTwo + ",");
		/*
		 * List<String> stateOptionsList =
		 * optionTwo.stream().map(WebElement::getText).collect(Collectors.toList());
		 * System.out.println(stateOptionsList);
		 * System.out.println("Testing -----------");
		 */
		for (WebElement s_option : optionTwo) {
			if (s_option.getText().equals(searchText2)) {
				s_option.click(); // clicks desired option
				break;
			}
		}
		Thread.sleep(1000);
	}
	
	public void formCalendarUpComingDate() throws InterruptedException {
		By startDate = By.xpath("//input[@id='event_datetime_start']");
		By EndDate = By.xpath("//input[@id='event_datetime_end']");

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
		c1.add(Calendar.DATE, 1); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.DATE, 3); // same with c.add(Calendar.DAY_OF_MONTH, 1);
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
		driver.findElement(startDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(startDate).clear();
		driver.findElement(startDate).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(EndDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(EndDate).clear();
		driver.findElement(EndDate).sendKeys(strDateTwo);
	}
	
	public void formCalendarUpComingDate_2() throws InterruptedException {
		By startDate = By.xpath("//input[@id='event_datetime_start']");
		By EndDate = By.xpath("//input[@id='event_datetime_end']");

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
		c1.add(Calendar.DATE, 3); // same with c.add(Calendar.DAY_OF_MONTH, 1);
		c2.add(Calendar.DATE, 6); // same with c.add(Calendar.DAY_OF_MONTH, 1);
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
		driver.findElement(startDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(startDate).clear();
		driver.findElement(startDate).sendKeys(strDateOne);
		Thread.sleep(1000);
		// driver.findElement(inputDiscussionEnd).click();
		driver.findElement(EndDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(EndDate).clear();
		driver.findElement(EndDate).sendKeys(strDateTwo);
	}


	public void new_Event_Form_Populate_Go_To_Meeting() throws InterruptedException {
		String location = "Chralott, NC";
		String description_Box = "This is a GoTo Meeting Event being created";

		driver.findElement(event_Form_Title).sendKeys(form_Title_Name);
		//------------------Enter Date for Boxes---------------------------------
		Thread.sleep(1500);
		//this.formCalendarUpComingDate();
		this.formCalendarUpComingDate_2();
		
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(form_Location).clear();
		driver.findElement(form_Location).sendKeys(location);
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		//----------------- Select City State Dropdown --------------------------
		this.form_Country_State_Select();
		// -----------------Scroll To Description Box --------------------------
		Thread.sleep(1200);
		WebElement description = driver.findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", description);
		Thread.sleep(1200);
		//---------------------Enter text in Description Box-----------------------
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(description_Box);
		// ---switch back to default content
		driver.switchTo().defaultContent();
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement eventcatagory = driver.findElement(By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eventcatagory);
		// ---Select Event Catagory----
		driver.findElement(eventCatagory).click();
		Thread.sleep(1200);
		driver.findElement(meetings).click();
		// ---Click Track RSVPs-------
		Thread.sleep(1200);
		driver.findElement(rsvps).click();
		// ---Click GoToMeeting Invite-------
		Thread.sleep(1200);
		driver.findElement(go_To_Meeting_Invite).click();
		// ---Click GoToMeeting Host-------
		Thread.sleep(1200);
		driver.findElement(go_To_Meeting_Host).click();
		Thread.sleep(1200);
		driver.findElement(go_To_Account).click();
	}
	
	public void new_Event_With_Custom_URL() throws InterruptedException {
		String location = "Chralott, NC";
		String description_Box = "This is a GoTo Meeting Event being created";
		String url ="https://hoflercsc.my.webex.com";
		String email = "jhofler@diligent.com";

		driver.findElement(event_Form_Title).sendKeys(form_Title_Name);
		//------------------Enter Date for Boxes---------------------------------
		Thread.sleep(1500);
		//this.formCalendarUpComingDate();
		this.formCalendarUpComingDate_2();
		
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(form_Location).clear();
		driver.findElement(form_Location).sendKeys(location);
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		//----------------- Select City State Dropdown --------------------------
		this.form_Country_State_Select();
		// -----------------Scroll To Description Box --------------------------
		Thread.sleep(1200);
		WebElement description = driver.findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", description);
		Thread.sleep(1200);
		//---------------------Enter text in Description Box-----------------------
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(description_Box);
		// ---switch back to default content
		driver.switchTo().defaultContent();
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement video_Url = driver.findElement(By.xpath("//input[@id='event_custom_video_conference_url']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", video_Url);
		//----notify email-------
		driver.findElement(notify).sendKeys(email);
		// ---Enter video Conferencing URL----
		driver.findElement(video_Conf_URL).sendKeys(url);
		// ---Select Event Catagory----
		driver.findElement(eventCatagory).click();
		Thread.sleep(1200);
		driver.findElement(meetings).click();
		// ---Click Track RSVPs-------
		Thread.sleep(1200);
		driver.findElement(rsvps).click();
		Thread.sleep(1200);
	}
	
	public void new_Event_With_Microsoft_Teams_URL() throws InterruptedException {
		String location = "Chralott, NC";
		String description_Box = "This is a GoTo Meeting Event being created";
		String url ="https://teams.microsoft.com";
		String email = "jhofler@diligent.com";

		driver.findElement(event_Form_Title).sendKeys(form_Title_Name);
		//------------------Enter Date for Boxes---------------------------------
		Thread.sleep(1500);
		//this.formCalendarUpComingDate();
		this.formCalendarUpComingDate_2();
		
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(form_Location).clear();
		driver.findElement(form_Location).sendKeys(location);
		driver.findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		//----------------- Select City State Dropdown --------------------------
		this.form_Country_State_Select();
		// -----------------Scroll To Description Box --------------------------
		Thread.sleep(1200);
		WebElement description = driver.findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", description);
		Thread.sleep(1200);
		//---------------------Enter text in Description Box-----------------------
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		WebElement iframeBody = driver.findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(description_Box);
		// ---switch back to default content
		driver.switchTo().defaultContent();
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement video_Url = driver.findElement(By.xpath("//input[@id='event_custom_video_conference_url']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", video_Url);
		//----notify email-------
		driver.findElement(notify).sendKeys(email);
		// ---Enter video Conferencing URL----
		driver.findElement(video_Conf_URL).sendKeys(url);
		// ---Select Event Catagory----
		driver.findElement(eventCatagory).click();
		Thread.sleep(1200);
		driver.findElement(meetings).click();
		// ---Click Track RSVPs-------
		Thread.sleep(1200);
		driver.findElement(rsvps).click();
		Thread.sleep(1200);
	}

	public void verify_Guest_List() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(guestList)));
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}

	public void verify_Workroom_Events_Crumb() throws InterruptedException {
		WebElement events = driver.findElement(By.xpath("//a[contains(text(),'Workroom Events')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", events);
		Thread.sleep(1000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Events_Crumb)));
	}

	public void click_Workroom_Events_Crumb() throws InterruptedException {
		WebElement SaveBtn = driver.findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(1500);
		driver.findElement(workroom_Events_Crumb).click();
	}
	
	public void verify_Event_Success_Message() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Success_Message)));
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Event_RSVPS() throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_Form_Populate();
		Thread.sleep(1500);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Guest_List();
		this.verify_Workroom_Events_Crumb();
		Thread.sleep(1000);
		this.click_Workroom_Events_Crumb();
		System.out.println("------- Completed --> user_Can_Create_New_Event() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Event_RSVPS_2() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_New_Event_Btn();
		this.click_New_Event_Btn();
		Thread.sleep(1000);
		this.verify_Form_Title();
		this.new_Event_Form_Populate_2();
		Thread.sleep(1500);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Guest_List();
		Thread.sleep(1500);
		this.verify_Workroom_Events_Crumb();
		Thread.sleep(1500);
		this.click_Workroom_Events_Crumb();
		System.out.println("------- Completed --> user_Can_Create_New_Event_2() -----------");
	}
	
	// --------------user_Can_Print_Upcoming/Workroom_Events-----------------
	By print_Upcoming_Events = By.xpath("//a[@class='pdf-link no-mobile pull-right'][contains(text(),'Print Upcoming Events')]");
	By view_All_Workroom_Events = By.xpath("//a[contains(text(),'View All Workroom Events')]");
	By expanded_View = By.xpath("//a[@class='btn btn-default default-view active'][@title='Expanded']");
	By default_View = By.xpath("//a[@class='btn btn-default default-view']");
	By tile_View = By.xpath("//a[contains(@class,'btn btn-default tile-view')]");
	By list_View = By.xpath("//a[contains(@class,'btn btn-default list-view')]");
	By workroomCalendar = By.xpath("//div[@id='calendarModal']//div[@class='modal-body']");
	By close_Calendar = By.xpath("//div[@id='calendarModal']//div[@class='modal-header']//a[1]");
	
	public void verify_Print_Upcoming_Events() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(print_Upcoming_Events)));
	}
	
	public void verify_View_All_Workroom_Events() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(view_All_Workroom_Events)));
	}
	
	public void verify_Workroom_Calendar() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomCalendar)));
	}
	
	public void click_Print_Upcoming_Events() throws InterruptedException {
		driver.findElement(print_Upcoming_Events).click();
	}
	
	public void click_View_All_Workroom_Events() throws InterruptedException {
		driver.findElement(view_All_Workroom_Events).click();
	}
	
	public void click_Expanded_View() throws InterruptedException {
		driver.findElement(expanded_View).click();
	}
	
	public void click_Default_View() throws InterruptedException {
		driver.findElement(default_View).click();
	}
	
	public void click_Tile_View() throws InterruptedException {
		driver.findElement(tile_View).click();
	}
	
	public void click_List_View() throws InterruptedException {
		driver.findElement(list_View).click();
	}

	public void click_Close_Calendar() throws InterruptedException {
		driver.findElement(close_Calendar).click();
	}
	
	public void verify_Tile_View_Visible() throws InterruptedException {
		String element = "//div[@class='card-body tile-card']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_List_View_Visible() throws InterruptedException {
		String element = "//table[@id='events-tablesorter']//tbody"; //---List view table
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void switch_To_Print_Events_Tab() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		//---wait a few seconds ---- 
		Thread.sleep(3000);
		driver.close();
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Print_Events_Tab() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Print_Upcoming_Events() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		this.verify_Print_Upcoming_Events();
		this.click_Print_Upcoming_Events();
		this.switch_To_Print_Events_Tab();
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Print_Upcoming_Events() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_View_All_Workroom_Events() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		this.verify_View_All_Workroom_Events();
		this.click_View_All_Workroom_Events();
		this.verify_Workroom_Calendar();
		Thread.sleep(3000);
		this.click_Close_Calendar();
		Thread.sleep(2500);
		driver.navigate().refresh();
		System.out.println("------- Completed --> user_Can_Print_Upcoming_Events() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_View_Upcoming_Events_Expanded_View() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		this.verify_View_All_Workroom_Events();
		this.click_Expanded_View();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_View_Upcoming_Events_Expanded_View() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_View_Upcoming_Events_Tile_View() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		this.verify_View_All_Workroom_Events();
		this.click_Tile_View();
		Thread.sleep(3000);
		this.verify_Tile_View_Visible();
		this.click_Default_View();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_View_Upcoming_Events_Expanded_View() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_View_Upcoming_Events_List_View() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		this.verify_View_All_Workroom_Events();
		this.click_List_View();
		Thread.sleep(3000);
		this.verify_List_View_Visible();
		this.click_Default_View();
		Thread.sleep(1500);
		System.out.println("------- Completed --> user_Can_View_Upcoming_Events_Expanded_View() -----------");
	}
	
	// --------------click_Export_To_Calendar---------------------------
	By export_Calendar = By.xpath("//div[@class='attached-buttons']//button[1]");
	By outlook = By.xpath("//a[contains(text(),'Outlook')]");

	public void verify_Export_To_Calendar() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(export_Calendar)));
	}
	
	public void verify_Outlook() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(outlook)));
	}
	
	public void click_Export_To_Calendar() throws InterruptedException {
		driver.findElement(export_Calendar).click();
	}
	
	public void click_Outlook() throws InterruptedException {
		driver.findElement(outlook).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void export_Event_To_Calendar() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		this.verify_Export_To_Calendar();
		this.click_Export_To_Calendar();
		Thread.sleep(1000);
		this.verify_Outlook();
		this.click_Outlook();
		System.out.println("------- Completed --> export_Event_To_Calendar() -----------");
	}
	
	public void verify_File_Downloaded_And_Deleted() throws InterruptedException, AWTException {
		//https://dzone.com/articles/folderlistfiles-may-produce-nullpointerexception
		/*
		 * *this will not work on VM becasue VM will not give access to Selenium Grid
		 */
		Thread.sleep(3000);//wait for download
		//String downloadPath = "C:\\Users\\qatester200\\Downloads\\";
		String home = System.getProperty("user.home");
		//String downloadPath = home + "\\Downloads";
		String downloadPath = "\\Downloads";

	   File folder = new File(downloadPath);
       File[] files = folder.listFiles();
 	   System.out.println(java.util.Arrays.toString(files));

	       if (files != null) {  
	    	   for (File file : files) {
	               if (file.getName().toString().endsWith(".ics")) {
	        		   Assert.assertTrue(file.exists());
	        		   file.delete(); 
	               }else {
	            	   Assert.assertFalse(file.exists());
	        		   System.out.println("------- ics file downloaded failed-----------");
	               }
	           }// end for loop      
	      } // end if statement 
      	System.out.println("------- Completed --> verify_File_Downloaded_And_Deleted() -----------");

	}// end method

	// --------------user_Can_Create_New_Event_RSVPS_B-----------------
	By workroomAdmin_Eng = By.xpath("(//div[@class='person-name'][contains(text(),'workroom admineng')]/following::span[@class='glyphicon glyphicon-remove remove-icon'])[3]");
	By systemAdmin_Eng = By.xpath("(//div[@class='person-name'][contains(text(),'system admineng')]/following::span[@class='glyphicon glyphicon-remove remove-icon'])[2]");
	By test_Reset = By.xpath("(//div[@class='person-name']/following::span[@class='glyphicon glyphicon-remove remove-icon'])[3]");

	public void deselect_Users() throws InterruptedException {
		driver.findElement(workroomAdmin_Eng).click();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		//----------------------------
		Thread.sleep(3500);
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_Guest_List();
		//----------------------------
		driver.findElement(systemAdmin_Eng).click();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		//----------------------------
		Thread.sleep(3500);
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_Guest_List();
		//----------------------------
		driver.findElement(test_Reset).click();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3500);
		driver.navigate().refresh();
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Event_RSVPS_B() throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_Form_Populate();
		Thread.sleep(1500);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Guest_List();
		this.deselect_Users();
		Thread.sleep(1500);
		this.verify_Workroom_Events_Crumb();
		Thread.sleep(1500);
		this.click_Workroom_Events_Crumb();
		System.out.println("------- Completed --> user_Can_Create_New_Event() -----------");
	}
	
	// --------------user_Can_Create_New_Event_GoTo_Meeting ---------------------------
	By saveBtn_Bottom = By.xpath("//div[@class='content']/fieldset/form[starts-with(@id,'edit_event')]/button[1]");
	By join_GoTo_Meeting = By.xpath("//a[@class='btn btn-default'][contains(., 'Join Go-To-Meeting')]");
	By join_Meeting = By.xpath("//a[@class='btn btn-default'][contains(., 'Join Meeting')]");
	
	public void scroll_Down_To_SaveBtn() throws InterruptedException {
		WebElement save_Button = driver.findElement(By.xpath("//div[@class='content']/fieldset/form[starts-with(@id,'edit_event')]/button[1]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save_Button);
	}
	
	public void click_SaveBtn_Bottom() throws InterruptedException {
		driver.findElement(saveBtn_Bottom).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Event_GoTo_Meeting() throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_Form_Populate_Go_To_Meeting();
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Event_Success_Message();
		this.scroll_Down_To_SaveBtn();
		Thread.sleep(1500);
		this.click_SaveBtn_Bottom();
		this.verify_Event_Success_Message();
		System.out.println("------- Completed --> user_Can_Create_New_Event_GoTo_Meeting() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Event_With_Custom_VC_URL() throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_With_Custom_URL();
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Event_Success_Message();
		this.scroll_Down_To_SaveBtn();
		Thread.sleep(1500);
		this.click_SaveBtn_Bottom();
		this.verify_Event_Success_Message();
		System.out.println("------- Completed --> user_Can_Create_New_Event_GoTo_Meeting() -----------");
	}
	
	public void user_Can_Create_New_Event_With_MS_Teams_URL() throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_With_Microsoft_Teams_URL();
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Event_Success_Message();
		this.scroll_Down_To_SaveBtn();
		Thread.sleep(1500);
		this.click_SaveBtn_Bottom();
		this.verify_Event_Success_Message();
		System.out.println("------- Completed --> user_Can_Create_New_Event_With_MS_Teams_URL() -----------");
	}
	
	// --------------user_Can_Join_GoTo_Meeting---------------------------
	public void verify_Event_Join_GoTo_Meeting() throws InterruptedException {
		WebElement string = driver.findElement(By.xpath("//a[@class='btn btn-default'][contains(., 'Join Go-To-Meeting')]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", string);
	    
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(join_GoTo_Meeting)));
	}
	
	public void verify_Join_Meeting() throws InterruptedException {
		WebElement string = driver.findElement(By.xpath("//a[@class='btn btn-default'][contains(., 'Join Meeting')]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", string);
	    
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(join_Meeting)));
	}
	
	public void click_Join_GoTo_Meeting() throws InterruptedException {
		driver.findElement(join_GoTo_Meeting).click();
	}
	
	public void click_Join_Meeting() throws InterruptedException {
		driver.findElement(join_Meeting).click();
	}
	
	public void verify_Joining_G2M_Sucessful() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		//---verify New GoTo Meeting Page ---- 
		String title = "//title[contains(text(),'GoToMeeting')]";
		Assert.assertTrue(driver.findElements(By.xpath(title)).size() > 0);
		Thread.sleep(1000);
		driver.close();
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Joining_G2M_Sucessful() -----------");
	}
	
	public void verify_Joining_Custom_Meeting_Sucessfull() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		//---verify New GoTo Meeting Page ---- 
		String title = "//title[contains(text(),'Cisco Webex Meetings')]";
		Assert.assertTrue(driver.findElements(By.xpath(title)).size() > 0);
		Thread.sleep(1000);
		driver.close();
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Joining_Custom_Meeting_Sucessfull() -----------");
	}
	
	By mst_Sign_In_Box = By.xpath("//div[@id='lightbox']");
	By my_Account = By.xpath("//div[contains(text(),'hoflercsc@gmail.com')]");
	By no_Account = By.xpath("//div[contains(text(),'No account?')]");
	By no_Button = By.xpath("//*[@class='button ext-button secondary ext-secondary']");

		
	By mst_Password = By.xpath("//*[@class='form-control input ext-input text-box ext-text-box']");
	By mst_UserName = By.xpath("//*[@class='form-control ltr_override input ext-input text-box ext-text-box']");
	By mst_Next_Btn = By.xpath("//*[@class='button ext-button primary ext-primary']");

	By mst_Sign_In_Button = By.xpath("//*[@class='button ext-button primary ext-primary']");
	By mst_Teams_Title = By.xpath("//div[@class='title']");
	
	public void verify_MST_Sign_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mst_Sign_In_Box)));
	}
	
	public void verify_MST_Password() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mst_Password)));
	}
	
	public void verify_MST_Title_Page() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mst_Teams_Title)));
	}
	
	public void verify_No_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(no_Button)));
	}
	
	
	public void click_My_Account() throws InterruptedException {
		driver.findElement(my_Account).click();
	}
	
	public void enter_MST_Password() throws InterruptedException {
		String psw = "Venus2010";
		driver.findElement(mst_Password).sendKeys(psw);
	}
	
	public void enter_MST_UserName() throws InterruptedException {
		String username = "hoflercsc@gmail.com";
		driver.findElement(mst_UserName).sendKeys(username);
	}
	
	public void click_MST_Next_Btn() throws InterruptedException {
		driver.findElement(mst_Next_Btn).click();
	}
	
	public void click_MST_Sign_In_Btn() throws InterruptedException {
		driver.findElement(mst_Sign_In_Button).click();
	}
	
	public void click_No_Btn() throws InterruptedException {
		driver.findElement(no_Button).click();
	}
	
	public void verify_If_Email_Account_Visible() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean myAccount = driver.findElements(my_Account).size() > 0;
		Boolean noAccount = driver.findElements(no_Account).size() > 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if (myAccount == true) {
			this.click_My_Account();
			Thread.sleep(500);
			this.verify_MST_Password();
			this.enter_MST_Password();
			Thread.sleep(500);
			this.click_MST_Sign_In_Btn();
			Thread.sleep(500);
			this.verify_MST_Title_Page();
		}
		
		if (noAccount == true) {
			this.enter_MST_UserName();
			Thread.sleep(500);
			this.click_MST_Next_Btn();
			Thread.sleep(500);
			this.verify_MST_Password();
			this.enter_MST_Password();
			Thread.sleep(500);
			this.click_MST_Sign_In_Btn();
			
		 try {
			Thread.sleep(500);
			this.verify_No_Btn();
			this.click_No_Btn();

		 } catch (Exception e) {
		 }
			Thread.sleep(3000);
			this.verify_MST_Title_Page();
		}
		
	}
	
	public void verify_Joining_Microsoft_Teams_Meeting_Sucessfull() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		//---verify Microsoft Teams Login ---- 
		this.verify_MST_Sign_Box();
		//this.verify_If_Email_Account_Visible(); disabled this to flaky
		driver.close();
		// ---switch back to orginal tab----
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Joining_Microsoft_Teams_Meeting_Sucessfull() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Join_GoTo_Meeting() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		this.verify_Event_Join_GoTo_Meeting();
		this.click_Join_GoTo_Meeting();
		this.verify_Joining_G2M_Sucessful();
		System.out.println("------- Completed --> user_Can_Join_GoTo_Meeting() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Join_Custom_Meeting() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		this.verify_Join_Meeting();
		this.click_Join_Meeting();
		this.verify_Joining_Custom_Meeting_Sucessfull();
		System.out.println("------- Completed --> user_Can_Join_GoTo_Meeting() -----------");
	}
	
	public void user_Can_Join_Microsoft_Teams_Meeting() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		this.verify_Join_Meeting();
		this.click_Join_Meeting();
		this.verify_Joining_Microsoft_Teams_Meeting_Sucessfull();
		System.out.println("------- Completed --> user_Can_Join_Microsoft_Teams_Meeting() -----------");
	}
	
	// --------------user_Can_Copy_Workroom_Event---------------------------
	By copy = By.xpath("//a[@class='btn btn-success no-mobile'][contains(text(),'Copy')]");
	By event_Copy_Title = By.xpath("//h1[contains(text(),'- Copy')]");

	public void verify_Copy() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(copy)));
	}

	public void verify_Event_Copy_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Copy_Title)));
	}
	
	public void click_Copy() throws InterruptedException {
		driver.findElement(copy).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Copy_Workroom_Event() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		this.verify_Copy();
		this.click_Copy();
		Thread.sleep(1000);
		this.verify_SaveBtn_Top();
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1000);
		this.verify_Event_Copy_Title();

		System.out.println("------- Completed --> user_Can_Copy_Workroom_Event() -----------");
	}
		
	// --------------User Click Accept to Respond ---------------------------------
	By acceptbtn_Not_Active = By.xpath("//a[@class='btn btn-default accept']");
	By acceptbtn_Active = By.xpath("//a[@class='btn btn-default accept active']");

	public void verify_AcceptBtn_Not_Active() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active)));
		
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-default accept']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void verify_AcceptBtn_Active() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(acceptbtn_Active)));
	}

	public void click_AcceptBtn_Not_Active() throws InterruptedException {
		//driver.findElement(acceptbtn_Not_Active).click();
		WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-default accept']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active();
		this.click_AcceptBtn_Not_Active();
		Thread.sleep(1500);
		this.verify_AcceptBtn_Active();
		System.out.println("------- Completed --> user_Can_Click_Accept_As_Response() -----------");
	}
	// --------------workroomAdmin_Response_Maybe ---------------------------
	By maybe_Btn = By.xpath("//a[@class='btn btn-default maybe']");
	By maybe_Btn_Active = By.xpath("//a[@class='btn btn-default maybe active']");

	public void verify_Maybe_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(maybe_Btn)));
	}

	public void click_MaybeBtn() throws InterruptedException {
		driver.findElement(maybe_Btn).click();
	}

	public void verify_Maybe_Btn_Active() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(maybe_Btn_Active)));
	}

	// --------------Function Being Called ---------------------------
	public void workroomAdmin_Response_Maybe() throws InterruptedException {
		this.verify_AutoBE();
		Thread.sleep(1500);
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_Maybe_Btn();
		this.click_MaybeBtn();
		Thread.sleep(1500);
		this.verify_Maybe_Btn_Active();
		System.out.println("------- Completed --> workroomAdmin_Response_Maybe() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void workroomAdmin_Response_Accept() throws InterruptedException {
		this.verify_AutoBE();
		Thread.sleep(1500);
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_AcceptBtn_Not_Active();
		Thread.sleep(1000);
		this.click_AcceptBtn_Not_Active();
		Thread.sleep(1500);
		this.verify_AcceptBtn_Active();
		System.out.println("------- Completed --> workroomAdmin_Response_Accept() -----------");
	}
	// --------------autoDirector_Response_Decline ---------------------------
	By decline_Btn_Not_Active = By.xpath("//div[ starts-with (@id,'rsvp')]//a[@class='btn btn-default decline']");
	By decline_Btn_Active = By.xpath("//a[@class='btn btn-default decline active']");

	public void verify_Decline_Btn_Not_Active() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(decline_Btn_Not_Active)));
	}

	public void verify_Decline_Btn_Active() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(decline_Btn_Active)));
	}

	public void click_Decline_Btn_Not_Active() throws InterruptedException {
		driver.findElement(decline_Btn_Not_Active).click();
	}

	public void autoDirector_Response_Decline() throws InterruptedException {
		this.verify_AutoBE();
		Thread.sleep(1500);
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_Decline_Btn_Not_Active();
		this.click_Decline_Btn_Not_Active();
		Thread.sleep(1500);
		this.verify_Decline_Btn_Active();
		System.out.println("------- Completed --> autoDirector_Response_Decline() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void autoDirector_Response_Accept() throws InterruptedException {
		this.verify_AutoBE();
		Thread.sleep(1500);
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_AcceptBtn_Not_Active();
		Thread.sleep(1000);
		this.click_AcceptBtn_Not_Active();
		Thread.sleep(1500);
		this.verify_AcceptBtn_Active();
		System.out.println("------- Completed --> autoDirector_Response_Accept() -----------");
	}
	
	// --------------autoTester_Clear_Responses---------------------------
	By new_Event_Title = By.xpath("//a[contains(text(),'This is a New Event Title')]");
	By guest_List = By.xpath("//h3[contains(text(),'Guest List')]");
	By dropdown_Position_1 = By.xpath("(//tr//button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By change_Response = By.xpath("//div[@class='btn-group small header-actions no-mobile open']//a[contains(text(),'Change Response')]");
	By clear_Response = By.xpath("//div[@class='popover-content']//a[@class='pull-left'][contains(text(),'Clear Response')]");
	By autmation_Tester_Row = By.xpath("//tr//button[@class='btn btn-default btn-xs dropdown-toggle']/preceding::tr//td//span[contains(text(),'Automation Tester')]");

	public void verify_New_Event_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Event_Title)));
	}
	
	public void verify_Guest_List_And_Scroll() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(guest_List)));
		
		Thread.sleep(1500);
		WebElement element = driver.findElement(By.xpath("//h3[contains(text(),'Guest List')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_Clear_response() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Event_Title)));
	}
	
	public void click_New_Event_Title() throws InterruptedException {
		driver.findElement(new_Event_Title).click();
	}
	
	public void click_Dropdown_Position_1() throws InterruptedException {
		driver.findElement(dropdown_Position_1).click();
	}
	
	public void click_Change_Response() throws InterruptedException {
		driver.findElement(change_Response).click();
	}
	
	public void click_Clear_Response() throws InterruptedException {
		driver.findElement(clear_Response).click();
	}
	
	public void verify_Not_Yet_Replied_AutoTester() throws InterruptedException {
		String element = " //th[contains(text(),'Not Yet Replied')]//following::text()[contains(., 'Automation Tester')]//following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Not_Yet_Replied_WorkroomAdmin() throws InterruptedException {
		String element = "//th[contains(text(),'Not Yet Replied')]//following::text()[contains(., 'Workroom Admin')]//following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Not_Yet_Replied_AutoDirector() throws InterruptedException {
		String element = "//th[contains(text(),'Not Yet Replied')]/following::text()[contains(., 'Auto Director')]//following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void autoTester_Clear_Response() throws InterruptedException {
		this.click_Dropdown_Position_1();//Automation Tester
		this.click_Change_Response();
		Thread.sleep(1000);
		this.click_Clear_Response();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_Not_Yet_Replied_AutoTester();
	}
	
	public void clear_AutoTester_Response() throws InterruptedException {
		this.verify_AutoBE();
		Thread.sleep(1500);
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_New_Event_Title();
		this.click_New_Event_Title();
		Thread.sleep(1500);
		this.verify_Guest_List_And_Scroll();
		this.autoTester_Clear_Response();
		System.out.println("------- Completed --> autoTester_Clear_Responses() -----------");
	}
	
	public void clear_Workroom_Admin_Response() throws InterruptedException {
		this.click_Dropdown_Position_1();//workrrom Admin
		this.click_Change_Response();
		Thread.sleep(1000);
		this.click_Clear_Response();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_Not_Yet_Replied_WorkroomAdmin();
	}
	
	public void clear_Auto_Director_Response() throws InterruptedException {
		this.click_Dropdown_Position_1();//auto director
		this.click_Change_Response();
		Thread.sleep(1000);
		this.click_Clear_Response();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_Not_Yet_Replied_AutoDirector();
	}

	//-------------------add notes to user reponses ------------------------
	By notes = By.xpath("//div[@class='btn-group small header-actions no-mobile open']//a[contains(text(),'Notes')]");
	By notes_TextArea = By.xpath("//textarea[@id='rsvps_users_notes']");
	By submit = By.xpath("//button[@id='continue']");
	By dropdown_Position_2 = By.xpath("(//tr//button[@class='btn btn-default btn-xs dropdown-toggle'])[2]");
	By dropdown_Position_3 = By.xpath("(//tr//button[@class='btn btn-default btn-xs dropdown-toggle'])[3]");
	String message = "this is a response";
	
	public void verify_Notes() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(notes)));
	}
	
	public void verify_Notes_TextArea() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(notes_TextArea)));
	}

	public void click_Notes() throws InterruptedException {
		driver.findElement(notes).click();
	}
	
	public void sendKeys_Notes_TextArea() throws InterruptedException {
		driver.findElement(notes_TextArea).sendKeys(message);
	}
	
	public void click_Submit() throws InterruptedException {
		driver.findElement(submit).click();
	}
	
	public void click_Dropdown_Position_2() throws InterruptedException {
		driver.findElement(dropdown_Position_2).click();
	}
	
	public void click_Dropdown_Position_3() throws InterruptedException {
		driver.findElement(dropdown_Position_3).click();
	}
	
	public void add_Notes_To_AutoTester() throws InterruptedException {
		this.click_Dropdown_Position_1();//Automation Tester
		this.verify_Notes();
		this.click_Notes();
		Thread.sleep(1500);
		this.verify_Notes_TextArea();
		this.sendKeys_Notes_TextArea();
		this.click_Submit();
		Thread.sleep(3000);
	}
	
	public void add_Notes_To_AutoTester_Response() throws InterruptedException {
		this.verify_AutoBE();
		Thread.sleep(1500);
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_New_Event_Title();
		this.click_New_Event_Title();
		Thread.sleep(1500);
		this.verify_Guest_List_And_Scroll();
		this.add_Notes_To_AutoTester();
		System.out.println("------- Completed --> autoTester_Clear_Responses() -----------");
	}
	
	public void add_Notes_To_Workroom_Admin() throws InterruptedException {
		this.click_Dropdown_Position_2();//Automation Tester
		this.verify_Notes();
		this.click_Notes();
		Thread.sleep(1500);
		this.verify_Notes_TextArea();
		this.sendKeys_Notes_TextArea();
		this.click_Submit();
		Thread.sleep(3000);
	}
	
	public void add_Notes_To_AutoDirector() throws InterruptedException {
		this.click_Dropdown_Position_3();//Automation Tester
		this.verify_Notes();
		this.click_Notes();
		Thread.sleep(1500);
		this.verify_Notes_TextArea();
		this.sendKeys_Notes_TextArea();
		this.click_Submit();
		Thread.sleep(3000);
	}
	
	public void verify_All_Three_Responses() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_Guest_List_And_Scroll();
		String automation_Tester = "(//tr//td[contains(text(),'this is a response')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroom_Admin = "(//tr//td[contains(text(),'this is a response')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[2]";
		String auto_Director = "(//tr//td[contains(text(),'this is a response')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[3]";
		Assert.assertTrue(driver.findElements(By.xpath(automation_Tester)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(workroom_Admin)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(auto_Director)).size() > 0);
	}
	
	// --------------take_Attendance---------------------------
	By guest_Dropdown = By.xpath("//div[@class='inline']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By take_Attendance = By.xpath("//a[@class='take-attendance']");
	By in_Attendance = By.xpath("(//tr[contains(., 'Workroom Admin')]//following::label[contains(text(),'In Attendance')])[1]");
	By done_Taking_Attendance = By.xpath("//a[@class='done-attendance']");
	By attendance_PDF = By.xpath("//a[contains(text(),'Attendance PDF')]");

	public void verify_Guest_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(guest_Dropdown)));
	}
	
	public void verify_Take_Attendance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(take_Attendance)));
	}
	
	public void verify_Done_Taking_Attendance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(done_Taking_Attendance)));
	}
	
	public void verify_Attendance_PDF() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attendance_PDF)));
	}
	
	public void click_Guest_Dropdown() throws InterruptedException {
		//driver.findElement(guest_Dropdown).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='inline']//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Take_Attendance() throws InterruptedException {
		//driver.findElement(take_Attendance).click();
		WebElement element = driver.findElement(By.xpath("//a[@class='take-attendance']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_In_Attendance() throws InterruptedException {
	    //driver.findElement(in_Attendance).click();
		WebElement element = driver.findElement(By.xpath("(//tr[contains(., 'Workroom Admin')]//following::label[contains(text(),'In Attendance')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Done_Taking_Attendance() throws InterruptedException {
		driver.findElement(done_Taking_Attendance).click();
	}
	
	public void click_Attendance_PDF() throws InterruptedException {
		driver.findElement(attendance_PDF).click();
	}
	
	public void take_Attendance() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Guest_Dropdown();
		this.click_Guest_Dropdown();
		Thread.sleep(1500);
		this.verify_Take_Attendance();
		this.click_Take_Attendance();
		Thread.sleep(2500);
		this.click_In_Attendance();
		Thread.sleep(3500);
		this.click_In_Attendance();
		Thread.sleep(3500);
		this.click_In_Attendance();
		Thread.sleep(3500);
		driver.navigate().refresh();
		//---------------------
		this.verify_Guest_List_And_Scroll();
		Thread.sleep(1000);
		this.click_Guest_Dropdown();
		Thread.sleep(1000);
		this.verify_Take_Attendance();
		this.click_Take_Attendance();
		Thread.sleep(2000);
		//---------------------
		//driver.navigate().refresh();
		//this.verify_Guest_List_And_Scroll();
		this.click_Guest_Dropdown();
		Thread.sleep(1000);
		this.verify_Done_Taking_Attendance();
		this.click_Done_Taking_Attendance();
		Thread.sleep(2000);
	}
	
	public void verify_Attendees() throws InterruptedException {
		String user1 = "//th[contains(text(),'Attending - In Person')]/following::span[contains(text(),'Workroom Admin')]";
		String user2 = "//th[contains(text(),'Attending - In Person')]/following::span[contains(text(),'Automation Tester')]";
		String user3 = "//th[contains(text(),'Attending - In Person')]/following::span[contains(text(),'Auto Director')]";
		Assert.assertTrue(driver.findElements(By.xpath(user1)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(user2)).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath(user3)).size() > 0);
	}
	
	// --------------Function Being Called ---------------------------
	public void autoUser_Take_Attendance() throws InterruptedException {
		this.verify_AutoBE();
		Thread.sleep(1500);
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_New_Event_Title();
		this.click_New_Event_Title();
		Thread.sleep(1500);
		this.verify_Guest_List_And_Scroll();
		this.take_Attendance();
		System.out.println("------- Completed --> autoUser_Take_Attendance() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void view_Attendees() throws InterruptedException {
		this.verify_AutoBE();
		Thread.sleep(1500);
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_New_Event_Title();
		this.click_New_Event_Title();
		Thread.sleep(1500);
		this.verify_Guest_List_And_Scroll();
		this.verify_Attendees();
		Thread.sleep(3500);
        this.scroll_To_My_BoardEffect();
		System.out.println("------- Completed --> view_Attendees() -----------");
	}
	
	public void scroll_To_My_BoardEffect() {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'My BoardEffect')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	// --------------Function Being Called ---------------------------
	public void generate_Attendance_Report() throws InterruptedException, AWTException {
		this.click_Guest_Dropdown();
		Thread.sleep(1000);
		this.verify_Attendance_PDF();
		this.click_Attendance_PDF();
		Thread.sleep(2000);
		System.out.println("------- Completed --> generate_Attendance_Report() -----------");
	}
	
	// --------------switch_To_Creating_Poll_Survey_Books ---------------------------
	By attachOrCreate = By.xpath("//a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')]");
	By attachOrCreate_3rd_Card = By.xpath("(//a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[3]");
	By polls_Tab = By.xpath("//a[contains(text(),'Polls')]");
	By surveys_Tab = By.xpath("//a[contains(text(),'Surveys')]");
	By createPoll = By.xpath("//div[@id='polls']//a[@class='btn attached-content create bigger']");
	By createSurvey = By.xpath("//div[@id='surveys']//span[@class='icon icon_em-addmeeting']");
	By books = By.xpath("//a[contains(text(),'Books')]");
	By createBook = By.xpath("//p[contains(text(),'Create Book')]");
	By approvals = By.xpath("//ul[@class='nav nav-tabs']//a[contains(text(),'Approvals')]");
	By approval_Item = By.xpath("//div[@class='col-md-12 no-left-padding']//div[@class='navlist']");
	By done_Button = By.xpath("//button[@id='attached_approval']");
	By survey_Card_2 = By.xpath("//span[contains(text(),'This is a Survey Title 2')]");
	By survey_Done_Button = By.xpath("//button[@id='attached_survey']");
	By poll_Card_2 = By.xpath("//span[contains(text(),'This is a Poll Title 2')]");
	By poll_Done_Button = By.xpath("//button[@id='attached_poll']");


	public void verify_Polls_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(polls_Tab)));
	}
	
	public void verify_Surveys_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(surveys_Tab)));
	}
	
	public void verify_Create_Poll() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(createPoll)));
	}
	
	public void verify_Create_Survey() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(createSurvey)));
	}
	
	public void verify_Create_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(createBook)));
	}
	
	public void verify_Books_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(books)));
	}
	
	public void verify_Approval_Item() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(approval_Item)));
	}
	
	public void verify_AttachOrCreate() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attachOrCreate)));
	}
	
	public void verify_AttachOrCreate_3rd_Card() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attachOrCreate_3rd_Card)));
		
		WebElement attachOrCreateCard3 = driver.findElement(By.xpath("(//a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[3]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", attachOrCreateCard3);
		
		Thread.sleep(2000);
	}
	
	public void verify_Survey_Card_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Card_2)));
	}
	
	public void verify_Poll_Card_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Card_2)));
	}
	
	public void click_AttachOrCreate() throws InterruptedException {
		driver.findElement(attachOrCreate).click();
	}
	
	public void click_AttachOrCreate_3rd_Card() throws InterruptedException {
		driver.findElement(attachOrCreate_3rd_Card).click();
	}
	
	public void click_Polls_Tab() throws InterruptedException {
		driver.findElement(polls_Tab).click();
	}
	
	public void click_Surveys_Tab() throws InterruptedException {
		driver.findElement(surveys_Tab).click();
	}
	
	public void click_CreatePoll() throws InterruptedException {
		driver.findElement(createPoll).click();
	}
	
	public void click_Poll_Card_2() throws InterruptedException {
		driver.findElement(poll_Card_2).click();
	}
	
	public void click_CreateSurvey() throws InterruptedException {
		driver.findElement(createSurvey).click();
	}
	
	public void click_Survey_Card_2() throws InterruptedException {
		driver.findElement(survey_Card_2).click();
	}
	
	public void click_CreateBook() throws InterruptedException {
		driver.findElement(createBook).click();
	}
	
	public void click_Books_Tab() throws InterruptedException {
		driver.findElement(books).click();
	}
	
	public void click_Approvals_Tab() throws InterruptedException {
		driver.findElement(approvals).click();
	}
	
	public void click_Approvals_Item() throws InterruptedException {
		driver.findElement(approval_Item).click();
	}
	
	public void click_Done() throws InterruptedException {
		driver.findElement(done_Button).click();
	}
	
	public void click_Survey_Done_Btn() throws InterruptedException {
		driver.findElement(survey_Done_Button).click();
	}
	
	public void click_Poll_Done_Btn() throws InterruptedException {
		driver.findElement(poll_Done_Button).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void switch_To_Creating_Poll() throws InterruptedException, AWTException {
		this.verify_AttachOrCreate();
		this.click_AttachOrCreate();
		Thread.sleep(2000);
		this.verify_Polls_Tab();
		this.click_Polls_Tab();
		Thread.sleep(2000);
		this.verify_Create_Poll();
		this.click_CreatePoll();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Poll() -----------");
	}
	
	public void switch_To_Attach_Poll() throws InterruptedException, AWTException {
		this.verify_AttachOrCreate();
		this.click_AttachOrCreate();
		Thread.sleep(2000);
		this.verify_Polls_Tab();
		this.click_Polls_Tab();
		Thread.sleep(2000);
		this.verify_Poll_Card_2();
		this.click_Poll_Card_2();
		Thread.sleep(1000);
		this.click_Poll_Done_Btn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> switch_To_Attach_Poll() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void switch_To_Creating_Survey() throws InterruptedException, AWTException {
		this.verify_AttachOrCreate();
		this.click_AttachOrCreate();
		Thread.sleep(2000);
		this.verify_Surveys_Tab();
		this.click_Surveys_Tab();
		Thread.sleep(2000);
		this.verify_Create_Survey();
		this.click_CreateSurvey();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Survey() -----------");
	}
	
	public void switch_To_Attach_Survey() throws InterruptedException, AWTException {
		this.verify_AttachOrCreate();
		this.click_AttachOrCreate();
		Thread.sleep(2000);
		this.verify_Surveys_Tab();
		this.click_Surveys_Tab();
		Thread.sleep(2000);
		this.verify_Survey_Card_2();
		this.click_Survey_Card_2();
		Thread.sleep(1000);
		this.click_Survey_Done_Btn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		System.out.println("------- Completed --> switch_To_Attach_Survey() -----------");
	}
	
	public void switch_To_Creating_Survey_3rd_Card() throws InterruptedException, AWTException {
		this.verify_AttachOrCreate_3rd_Card();
		this.click_AttachOrCreate_3rd_Card();
		Thread.sleep(1000);
		this.verify_Surveys_Tab();
		this.click_Surveys_Tab();
		Thread.sleep(1000);
		this.verify_Create_Survey();
		this.click_CreateSurvey();
		Thread.sleep(1000);
		System.out.println("------- Completed --> switch_To_Creating_Survey_3rd_Card() -----------");
	}
	
	public void switch_To_Creating_Poll_3rd_Card() throws InterruptedException, AWTException {
		this.verify_AttachOrCreate_3rd_Card();
		this.click_AttachOrCreate_3rd_Card();
		Thread.sleep(2000);
		this.verify_Polls_Tab();
		this.click_Polls_Tab();
		Thread.sleep(2000);
		this.verify_Create_Poll();
		this.click_CreatePoll();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Poll_3rd_Card() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void switch_To_Creating_Book() throws InterruptedException, AWTException {
		this.click_AttachOrCreate();
		Thread.sleep(1000);
		this.verify_Books_Tab();
		this.click_Books_Tab();
		Thread.sleep(1000);
		this.verify_Create_Book();
		this.click_CreateBook();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Book() -----------");
	}
	
	By handbook_Option = By.xpath("//span[contains(text(),'This is a Handbook')]");
	By done_HB = By.xpath("//button[@id='attached_book'][contains(.,'Done')]");


	public void verify_Handbook_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Option)));
	}
	
	public void click_Handbook_Option() throws InterruptedException {
		driver.findElement(handbook_Option).click();
	}
	
	public void click_Done_HB() throws InterruptedException {
		driver.findElement(done_HB).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void attach_Hand_Book() throws InterruptedException, AWTException {
		this.click_AttachOrCreate();
		Thread.sleep(2000);
		this.verify_Books_Tab();
		this.click_Books_Tab();
		Thread.sleep(1500);
		this.verify_Handbook_Option();
		this.click_Handbook_Option();
		Thread.sleep(1500);
		this.click_Done_HB();
		System.out.println("------- Completed --> attach_Hand_Book() -----------");
	}
	
	// --------------switch_To_Attach_Approval---------------------------
	By approvals_Heading = By.xpath("//h4[@class='heading-approvals']");
	By approvals_Message = By.xpath("//li[starts-with (@id,'approval')][contains(text(),'Do you approve this item?')]");
	By approvals_X_Btn = By.xpath("//li[starts-with (@id,'approval')]//following::a[contains(text(),'|')]");
	
	public void verify_Approvals_Heading() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(approvals_Heading),
				(ExpectedConditions.elementToBeClickable(approvals_Heading))));
	}
	
	public void click_Approvals_X_Btn() throws InterruptedException {
		driver.findElement(approvals_X_Btn).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void switch_To_Attach_Approval() throws InterruptedException, AWTException {
		this.click_AttachOrCreate();
		Thread.sleep(2000);
		this.verify_Books_Tab();
		this.click_Approvals_Tab();
		Thread.sleep(2000);
		this.verify_Approval_Item();
		this.click_Approvals_Item();
		Thread.sleep(1000);
		this.click_Done();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> switch_To_Attach_Approval() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Approval_Attached() throws InterruptedException, AWTException {
		this.verify_Event_Title_2();
		this.click_Event_Title_2();
		Thread.sleep(2000);
		this.verify_Approvals_Heading();
		System.out.println("------- Completed --> verify_Approval_Attached() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void Remove_Attached_Approval_On_Event() throws InterruptedException, AWTException {
		this.click_Approvals_X_Btn();
		Thread.sleep(2000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("------- Completed --> Remove_Attached_Approval_On_Event() -----------");
	}
	
	
	// --------------Function Being Called ---------------------------
	
	public void verify_Approval_Removed() throws InterruptedException, AWTException {
		String approvals_Heading = "//h4[@class='heading-approvals']";
		String approvals_Message = "//li[starts-with (@id,'approval')][contains(text(),'Do you approve this item?')]";
		Assert.assertTrue(driver.findElements(By.xpath(approvals_Heading)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(approvals_Message)).size() < 1);

		System.out.println("------- Completed --> verify_Approval_Removed() -----------");
	}
	
	// --------------verify_Poll/Survey/Book_Added_To_Event ---------------------------
	By poll_Btn = By.xpath("//a[@class='btn btn-default'][contains(text(),'Poll')]");
	By survey_Btn = By.xpath("//a[@class='btn btn-default'][contains(text(),'Survey')]");
	By survey_Polls_Btn = By.xpath("//div[@class='btn-group']/button[contains(.,' Surveys & Polls')]");
	By book_Btn = By.xpath("//a[@class='btn btn-default'][contains(text(),'Book')]");
	By attach_Create = By.xpath("//a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')]");
	By resource_Tab = By.xpath("//a[contains(text(),'Resources')]");
	By autoBE_Workroom = By.xpath("//form[@id='attach_book']//li[2]");
	By attach_Folder = By.xpath("//ul[@class='plain-list']//a[contains(text(),'Attach')]");
	By to_Attach_File = By.xpath("//a[@class='copy-file-to-event'][contains(text(),'ToAttach')]");
	By done_Btn = By.xpath("//button[@id='attached_resource'][contains(text(),'Done')]");
	By event_Resources_Btn = By.xpath("//a[@class='btn btn-default']//i[@class='fa fa-file']");

	public void verify_Resource_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Tab)));
	}
	
	public void verify_Auto_BE_Workroom() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Workroom)));
	}
	
	public void verify_Attach_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Workroom)));
	}
	
	public void verify_To_Attach_File() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(to_Attach_File)));
	}
	
	public void refresh_Verify_Event_Resources_Btn() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1500);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Resources_Btn)));
	}
	
	By event_Title = By.xpath("(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_Title_2 = By.xpath("//a[contains(text(),'This is a New Event Title')]");
	By remove_SurveyBtn = By.xpath("(//li[starts-with (@class,'survey-')]//a[contains(text(),'This is a Survey')]/following::a)[1]");
	By remove_BookBtn= By.xpath("(//li[starts-with (@class,'book-')]//a[contains(text(),'This is a Book Title')]/following::a)[1]");
	By eventsMenu2 = By.xpath("//ul[@class='workroom-buttons no-mobile']//li[@class='active']//a");

	public void verify_Remove_SurveyBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(remove_SurveyBtn)));
	}
	
	public void verify_Remove_BookBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(remove_BookBtn)));
	}
	
	public void verify_Event_Title_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title_2)));
	}

	public void click_Poll_Btn() throws InterruptedException {
		driver.findElement(poll_Btn).click();
	}
	
	public void click_Book_Btn() throws InterruptedException {
		driver.findElement(book_Btn).click();
	}
	
	public void click_Survey_Btn() throws InterruptedException {
		driver.findElement(survey_Btn).click();
	}
	
	public void click_Survey_And_Polls_Btn() throws InterruptedException {
		driver.findElement(survey_Polls_Btn).click();
	}
	
	public void click_Attach_Create() throws InterruptedException {
		driver.findElement(attach_Create).click();
	}
	
	public void click_Resource_Tab() throws InterruptedException {
		driver.findElement(resource_Tab).click();
	}
	
	public void click_AutoBE_Workroom() throws InterruptedException {
		driver.findElement(autoBE_Workroom).click();
	}
	
	public void click_Attach_Folder() throws InterruptedException {
		driver.findElement(attach_Folder).click();
	}
	
	public void click_To_Attach_File() throws InterruptedException {
		driver.findElement(to_Attach_File).click();
	}
	
	public void click_Done_Btn() throws InterruptedException {
		driver.findElement(done_Btn).click();
	}

	public void click_Event_Title_2() throws InterruptedException {
		driver.findElement(event_Title_2).click();
	}
	
	public void click_Remove_SurveyBtn() throws InterruptedException {
		driver.findElement(remove_SurveyBtn).click();
	}
	
	public void click_Remove_BookBtn() throws InterruptedException {
		driver.findElement(remove_BookBtn).click();
	}
	
	public void click_Events_Menus2() throws InterruptedException {
		driver.findElement(eventsMenu2).click();

	}
	
	public void verify_Poll_Button_Displayed() throws InterruptedException {
		String element = "//a[@class='btn btn-default'][contains(text(),'Poll')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Survey_Button_Displayed() throws InterruptedException {
		String element = "//a[@class='btn btn-default'][contains(text(),'Survey')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Survey_And_Polls_Button_Displayed() throws InterruptedException {
		String element = "//div[@class='btn-group']/button[contains(.,' Surveys & Polls')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Survey_Button_NOT_Displayed() throws InterruptedException {
		String element = "//a[@class='btn btn-default'][contains(text(),'Survey')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Book_Button_Displayed() throws InterruptedException {
		String element = "//a[@class='btn btn-default'][contains(text(),'Book')]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Survey_Button_NOT_Present() throws InterruptedException {
		String element = "(//li[starts-with (@class,'survey-')]//a[contains(text(),'This is a Survey')]/following::a)[1]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Book_Button_NOT_Present() throws InterruptedException {
		String element = "(//li[starts-with (@class,'book-')]//a[contains(text(),'This is a Book Title')]/following::a)[1]";
		Assert.assertTrue(driver.findElements(By.xpath(element)).size() < 1);
	}
	
	
	// --------------Function Being Called ---------------------------
	public void verify_Poll_Added_To_Event() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1500);
		this.verify_Event_Dropdown_Arrow();
		this.verify_Poll_Button_Displayed();
		this.click_Poll_Btn();
		Thread.sleep(3000);// allow attahced poll to be shown
		this.verify_AutoBE();
		Thread.sleep(3000);
		this.click_AutoBE();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Poll_Added_To_Event() -----------");
	}
	
	public void verify_Poll_Added_To_Event_2() throws InterruptedException {
		this.verify_Event_Dropdown_Arrow();
		this.verify_Poll_Button_Displayed();
		this.click_Poll_Btn();
		Thread.sleep(2000);// allow attahced poll to be shown
		this.verify_AutoBE();
		Thread.sleep(2000);
		this.click_AutoBE();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Poll_Added_To_Event() -----------");
	}
	
	public void verify_Poll_Added_To_Event_3rd_Card() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1000);
		this.verify_Event_Card3_Dropdown_Arrow_Scroll();
		this.verify_Poll_Button_Displayed();
		System.out.println("------- Completed --> verify_Poll_Added_To_Event_3rd_Card() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Survey_Added_To_Event() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1500);
		this.verify_Event_Dropdown_Arrow();
		this.verify_Survey_Button_Displayed();
		this.click_Survey_Btn();
		Thread.sleep(2500);// allow attahced poll to be shown
		this.verify_AutoBE();
		Thread.sleep(2500);
		this.click_AutoBE();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Survey_Added_To_Event() -----------");
	}
	
	public void verify_Survey_Added_To_Event_2() throws InterruptedException {
		this.verify_Event_Dropdown_Arrow();
		this.verify_Survey_Button_Displayed();
		this.click_Survey_Btn();
		Thread.sleep(2500);// allow attahced poll to be shown
		this.verify_AutoBE();
		Thread.sleep(2500);
		this.click_AutoBE();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Survey_Added_To_Event() -----------");
	}
	
	public void verify_Surveys_Added_To_Event_3rd_Card() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1000);
		this.verify_Event_Card3_Dropdown_Arrow_Scroll();
		this.verify_Survey_Button_Displayed();
		System.out.println("------- Completed --> verify_Surveys_Added_To_Event_3rd_Card() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void remove_Attached_Survey_From_Event() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1500);
		this.verify_Event_Title_2();
		this.click_Event_Title_2();
		Thread.sleep(2000);
		this.verify_Remove_SurveyBtn();
		this.click_Remove_SurveyBtn();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_Survey_Button_NOT_Present();
		this.click_Events_Menus2();
		Thread.sleep(2000);
		System.out.println("------- Completed --> remove_Attached_Survey_From_Event() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Book_Added_To_Event() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1500);
		this.verify_Event_Dropdown_Arrow();
		this.verify_Book_Button_Displayed();
		this.click_Book_Btn();
		Thread.sleep(2000);// allow attached book to be shown
		this.verify_AutoBE();
		Thread.sleep(2000);
		this.click_AutoBE();
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Poll_Added_To_Event() -----------");
	}
	
	By handbook_Title = By.xpath("//h1[contains(text(),'This is a Handbook')]");
	By handbook_Title_2 = By.xpath("//a[contains(text(),'This is a Handbook')]");
	By handbook_Crumb = By.xpath("//a[contains(text(),'Handbooks')]");

	
	public void verify_Handbook_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Title)));
	}

	public void verify_Handbook_Title_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Title_2)));
	}
	
	public void click_Handbook_Crumb() throws InterruptedException {
		driver.findElement(handbook_Crumb).click();
	}

	public void verify_Handbook_Added_To_Event() throws InterruptedException {
		this.verify_Event_Dropdown_Arrow();
		this.verify_Book_Button_Displayed();
		this.click_Book_Btn();
		Thread.sleep(2000);// allow attached book to be shown
		this.verify_Handbook_Title();
		Thread.sleep(2000);// allow attached book to be shown
		this.click_Handbook_Crumb();
		Thread.sleep(2000);
		this.verify_Handbook_Title_2();
		System.out.println("------- Completed --> verify_Handbook_Added_To_Event() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void remove_Attached_Book_From_Event() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1500);
		this.verify_Event_Title_2();
		this.click_Event_Title_2();
		Thread.sleep(2000);
		this.verify_Remove_BookBtn();
		this.click_Remove_BookBtn();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		this.verify_Book_Button_NOT_Present();
		this.click_Events_Menus2();
		Thread.sleep(2000);
		System.out.println("------- Completed --> remove_Attached_Book_From_Event() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void add_Resource_To_Event() throws InterruptedException {
		Thread.sleep(1500);
		this.click_Attach_Create();
		Thread.sleep(1000);
		this.verify_Resource_Tab();
		this.click_Resource_Tab();
		Thread.sleep(1000);
		this.verify_Auto_BE_Workroom();
		this.click_AutoBE_Workroom();
		Thread.sleep(1500);
		this.verify_Attach_Folder();
		this.click_Attach_Folder();
		Thread.sleep(1000);
		this.verify_To_Attach_File();
		this.click_To_Attach_File();
		Thread.sleep(1000);
		this.click_Done_Btn();
		Thread.sleep(3000);
		System.out.println("------- Completed --> add_Resource_To_Event() -----------");
	}
		
	// --------------User Can Delete Event ---------------------------
	By deleteBtn = By.xpath("//a[@class='btn btn-danger no-mobile'][contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");
	By delete_Event_Message = By.xpath("//div[@class='col-md-10 narrow']//p[contains(text(),'Successfully deleted Event')]");
	By event_Dropdown_Arrow = By.xpath("(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_Dropdown_Arrow_Card_3 = By.xpath("(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[3]");
	By event_Copy_Dropdown_Arrow = By.xpath("(//a[contains(text(),'- Copy')]/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By delete_Option_Card_3 = By.xpath("(//a[contains(text(),'Delete')])[3]");


	public void verify_Event_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Dropdown_Arrow)));
	}

	public void verify_Event_Card3_Dropdown_Arrow_Scroll() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Dropdown_Arrow_Card_3)));
		
		WebElement eventCard3 = driver.findElement(By.xpath("(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[3]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", eventCard3);
		Thread.sleep(2000);
	}
	
	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(continueBtn)));
	}

	public void click_DeleteBtn() throws InterruptedException {
		driver.findElement(deleteBtn).click();
	}

	public void click_ContinueBtn() throws InterruptedException {
		driver.findElement(continueBtn).click();
	}

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}
	
	public void verify_Delete_Option_Card_3() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option_Card_3)));
	}

	public void click_Event_Dropdown_Arrow() throws InterruptedException {
		driver.findElement(event_Dropdown_Arrow).click();
	}
	
	public void click_3rd_Event_Card_Dropdown_Arrow() throws InterruptedException {
		driver.findElement(event_Dropdown_Arrow_Card_3).click();
	}

	public void click_Event_Copy_Dropdown_Arrow() throws InterruptedException {
		driver.findElement(event_Copy_Dropdown_Arrow).click();
	}
	
	public void verify_Delete_Event_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Event_Message)));
	}
	
	public void verify_Event_Deleted() throws InterruptedException {
		String event = "(//a[contains(text(),'This is an Edited Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_3rd_Event_Deleted() throws InterruptedException {
		String event = "//h3//a[normalize-space(text())='This is a New Event Title']";
		Assert.assertTrue(driver.findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_Deleted_2() throws InterruptedException {
		String event = "(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]";
		Assert.assertTrue(driver.findElements(By.xpath(event)).size() < 1);
	}

	public void click_Delete_Option() throws InterruptedException {
		driver.findElement(delete_Option).click();
	}
	
	public void click_Delete_Option_Card_3() throws InterruptedException {
		driver.findElement(delete_Option_Card_3).click();
	}

	// --------------Function Being Called ---------------------------
	public void user_Delete_Event() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_AutoBE();
		Thread.sleep(1500);
		this.click_AutoBE();
		Thread.sleep(1500);
		this.verify_Event_Dropdown_Arrow();
		this.click_Event_Dropdown_Arrow();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(2000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		this.verify_Delete_Event_Message();
		Thread.sleep(3000);
		this.verify_Delete_Event_Message();
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(3000);
		this.verify_Event_Deleted();
		System.out.println("------- Completed --> user_Delete_Event_And_Verify_Deleted() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Delete_Print_Upcoming_Event() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_Dropdown_Arrow();
		this.click_Event_Dropdown_Arrow();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(2000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2500);
		driver.navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Print_Upcoming_Event() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Delete_Go_To_Meeting_Event() throws InterruptedException {
		this.verify_AutoBE();
		this.click_AutoBE();
		this.verify_Events_Menu();
		this.click_Events_Menu();
		this.verify_New_Event_Btn();
		this.verify_Event_Dropdown_Arrow();
		this.click_Event_Dropdown_Arrow();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(2000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		this.verify_Delete_Event_Message();
		System.out.println("------- Completed --> user_Delete_Go_To_Event() -----------");
	}
	
	public void delete_3rd_Event_Card() throws InterruptedException {
		this.click_3rd_Event_Card_Dropdown_Arrow();
		this.verify_Delete_Option_Card_3();
		this.click_Delete_Option_Card_3();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1000);
		this.verify_Delete_Event_Message();
		System.out.println("------- Completed --> delete_3rd_Event_Card() -----------");
	}
	
	public void verify_3rd_Event_Card_Deleted() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
		this.verify_3rd_Event_Deleted();
		System.out.println("------- Completed --> verify_Go_To_Meeting_Event_Deleted() -----------");
	}
	
	public void verify_Go_To_Meeting_Event_Deleted() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		this.verify_Event_Deleted();
		System.out.println("------- Completed --> verify_Go_To_Meeting_Event_Deleted() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Delete_Go_To_Meeting_Event_Copy() throws InterruptedException {
		this.verify_Event_Dropdown_Arrow();
		this.click_Event_Copy_Dropdown_Arrow();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(2000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		this.verify_Delete_Event_Message();
		System.out.println("------- Completed --> user_Delete_Go_To_Meeting_Event_Copy() -----------");
	}
	
	public void verify_Event_And_Copy_Deleted() throws InterruptedException {
		String event = "(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]";
		String event_Copy = "(//a[contains(text(),'- Copy')]/following::div[@class='dropdown header-actions no-mobile'])[1]";
		Thread.sleep(1500);
		Assert.assertTrue(driver.findElements(By.xpath(event)).size() < 1);
		Assert.assertTrue(driver.findElements(By.xpath(event_Copy)).size() < 1);
	}
	
	// --------------Delete_Event_While_In_Guest_List---------------------------
	public void scroll_To_Delete() throws InterruptedException {
		WebElement deleteBtn = driver.findElement(By.xpath("//a[@class='btn btn-danger no-mobile'][contains(text(),'Delete')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
	}
	
	public void Delete_Event_Verify_Deletion_In_Guest_List() throws InterruptedException {
		this.scroll_To_Delete();
		this.click_DeleteBtn();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3000);
		this.verify_Delete_Event_Message();
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(3000);
		this.verify_Event_Deleted();
		System.out.println("------- Completed --> Delete_Event_Verify_Deletion_In_Guest_List() -----------");
	}
	
}
