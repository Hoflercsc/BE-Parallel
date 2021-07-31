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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import parallel.DriverFactory;

public class EventPage {
	
	// ----------- POM Page Object model ----------------------------
	// --------------Open_User_Profile---------------------------
	By system_Admin_User_Dropdown = By.xpath("(//a[contains(text(),'steve System')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By intergrations = By.xpath("//a[contains(text(),'Integrations')]");
	By edit = By.xpath("//div[@class='btn-group small open']//a[contains(text(),'Edit Profile')]");


	public void verify_System_Admin_User_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(system_Admin_User_Dropdown)));
	}

	public void verify_Edit_Profile() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(edit)));
	}
	
	public void verify_Intergrations() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(intergrations)));
	}

	public void click_System_Admin_Dropdown() {
		DriverFactory.getInstance().getDriver().findElement(system_Admin_User_Dropdown).click();
	}

	public void click_Intergrations() {
		//DriverFactory.getInstance().getDriver().findElement(intergrations).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Integrations')]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Edit_Profile() {
		DriverFactory.getInstance().getDriver().findElement(edit).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(g2m_Label)));
	}
	
	public void verify_G2M_Email_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(email_Field)));
	}
	
	public void verify_Password_Field() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(password_Field)));
	}
	
	public void click_Connect_G2M_Account() {
		DriverFactory.getInstance().getDriver().findElement(connect_g2m_account).click();
	}
	
	public void sendKeys_Email_Address() {
		DriverFactory.getInstance().getDriver().findElement(email_Field).sendKeys(email_Address);
	}
	
	public void sendKeys_Password_Field() {
		DriverFactory.getInstance().getDriver().findElement(password_Field).sendKeys(email_password);
	}
	
	public void click_Next_Btn() {
		DriverFactory.getInstance().getDriver().findElement(next_Btn).click();
	}
	
	public void click_Sign_In() {
		DriverFactory.getInstance().getDriver().findElement(sign_In).click();
	}
	
	public void g2m_Connection_Status_Check() throws InterruptedException {
		String connect_g2m_account = "//a[@class='btn btn-default be-dark-blue'][contains(text(),'Connect your GoToMeeting Account')]";
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean c_g2m_account = DriverFactory.getInstance().getDriver().findElements(By.xpath(connect_g2m_account)).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if(c_g2m_account == true) {
			this.click_Connect_G2M_Account();
			Thread.sleep(4000);
			String email_Field = "//input[@id='emailAddress']";
			DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Boolean email = DriverFactory.getInstance().getDriver().findElements(By.xpath(email_Field)).size() > 0;
			DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				if(email == true) {
					this.verify_G2M_Email_Field();
					this.sendKeys_Email_Address();
					this.click_Next_Btn();
					this.verify_Password_Field();
					this.sendKeys_Password_Field();
					this.click_Sign_In();
					Thread.sleep(6000);
						String allow = "//input[@id='submit-button']";
						DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
						Boolean cancelBtn = DriverFactory.getInstance().getDriver().findElements(By.xpath(allow)).size() > 0;
						DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
							if(cancelBtn == true) {
								DriverFactory.getInstance().getDriver().findElement(By.xpath(allow)).click();
								this.verify_AutoBE();
							}
				}// end inner if
			}else {
				HomeNavigationPage obj = new HomeNavigationPage();
				obj.user_Close_Directory_Profile();
				obj.user_Close_Directory();
				Thread.sleep(1500);
				DriverFactory.getInstance().getDriver().navigate().refresh();
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



	public void verify_AutoBE() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE)));
	}

	public void verify_Events_Menu() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(eventsMenu)));
	}

	public void verify_New_Event_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(newEventBtn)));
	}

	public void verify_Form_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Form_Title)));
	}

	public void click_AutoBE() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(autoBE).click();
	}

	public void click_Events_Menu() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(eventsMenu).click();
	}

	public void click_New_Event_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(newEventBtn).click();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(form_Top_SaveBtn)));
	}

	public void click_Form_SaveBtn_Top() throws InterruptedException {
		WebElement SaveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(form_Top_SaveBtn).click();
	}

	// ------------------ Calendar Functions ---------------------
		public void startDateCalendar() throws InterruptedException {
			WebElement element = DriverFactory.getInstance().getDriver().findElement(startDate);
			element.click();
			Thread.sleep(1500);
			
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date currentDate = new Date();
			Calendar c1 = Calendar.getInstance();
		    c1.setTime(currentDate);
		    Date CurrentDate = c1.getTime();;
	        String strDateOne = (dateFormat.format(CurrentDate));
			 
			WebElement calendar = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='datepicker-days']//table[@class='table-condensed']//tbody"));

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
				//DriverFactory.getInstance().getDriver().findElement(form_Location).click();// click to close calendar box
			}

		public void endDateCalendar() throws InterruptedException {
			WebElement element = DriverFactory.getInstance().getDriver().findElement(EndDate);
			//element.click();
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(1500);
			
			DateFormat dateFormat = new SimpleDateFormat("dd");
			Date currentDate = new Date();
			Calendar c2 = Calendar.getInstance();
		    c2.setTime(currentDate);
		    c2.add(Calendar.DATE, 2); //same with c.add(Calendar.DAY_OF_MONTH, 1);
	        Date currentDatePlusTwo = c2.getTime();
	        String strDateTwo = (dateFormat.format(currentDatePlusTwo));
	        
			WebElement calendar = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//div[@class='datepicker-days']//table[@class='table-condensed']//tbody)[2]"));
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
		
	public void new_Event_Form_Populate(String event4) throws InterruptedException {
		String location = "cool location";

		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(event4);
		//----------
		if(DriverFactory.getInstance().getDriver().getCurrentUrl().contains("lab")) {
			this.labFormCalendarUpComingDate();
		}else if(DriverFactory.getInstance().getDriver().getCurrentUrl().contains("staging")) {
			this.formCalendarUpComingDate();
		}else if(DriverFactory.getInstance().getDriver().getCurrentUrl().contains("ozzie")) {
			this.formCalendarUpComingDate();
		}
		
		Select country = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_country']")));
		country.selectByVisibleText("United States");
		Thread.sleep(1000);

		Select state = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_state']")));
		state.selectByVisibleText("Virginia");
		Thread.sleep(1000);

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_zip']")).sendKeys("23513");
		
		//----------
		DriverFactory.getInstance().getDriver().findElement(form_Location).click();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		//DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement eventcatagory = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", eventcatagory);
		// ---Event Catagory--
		DriverFactory.getInstance().getDriver().findElement(eventCatagory).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(meetings).click();
		// ---track rsvp------
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(rsvps).click();
	}
	
	public void populate_Event_Form_JH_Staging(String eventTitleStaging1) throws InterruptedException {
		String location = "cool location";

		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(eventTitleStaging1);
		//----------
		if(DriverFactory.getInstance().getDriver().getCurrentUrl().contains("lab")) {
			this.labFormCalendarUpComingDate();
		}else {
		  this.formCalendarUpComingDate();
		}
		
		Select country = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_country']")));
		country.selectByVisibleText("United States");
		Thread.sleep(1000);

		Select state = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_state']")));
		state.selectByVisibleText("Virginia");
		Thread.sleep(1000);

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_zip']")).sendKeys("23513");
		
		//----------
		DriverFactory.getInstance().getDriver().findElement(form_Location).click();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		//DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement eventcatagory = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", eventcatagory);
		// ---Event Catagory--
		DriverFactory.getInstance().getDriver().findElement(eventCatagory).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(meetings).click();
		// ---track rsvp------
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(rsvps).click();
	}
	
	
	public void new_Event_Form_Populate_2(String event21) throws InterruptedException {
		String location = "cool location";
		String address_1 = "22 Smith Street";
		String address_2 = "apt 335";
		String city = "Charlotte";
		String zipcode = "28217";
		String facilitator = "Someone";
		String facilitator_email = "Someone@diligent.com";
		String Website = "https://www.diligent.com";
		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(event21);
		//----------
		this.formCalendarUpComingDate_2();
		//this.startDateCalendar();
		//this.endDateCalendar();
		//----------
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_Location).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement eventcatagory = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", eventcatagory);
		// ---Event Catagory--
		DriverFactory.getInstance().getDriver().findElement(eventCatagory).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(meetings).click();
		// ---track rsvp------
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(rsvps).click();
	}

	public void form_Country_State_Select() throws InterruptedException {
		// ----------COUNTRY---------------
		DriverFactory.getInstance().getDriver().findElement(country_Option).click();
		Thread.sleep(2000);
		// By countryList =
		// By.xpath("//*[@id=\"new_event\"]/div/div/div[8]/div/div/div[1]/div/div/ul");
		By countryList = By.xpath("(//ul[@class='dropdown-menu inner'])[2]");
		String country = "United States";
		WebElement dropdownlist = DriverFactory.getInstance().getDriver().findElement(countryList);
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
		DriverFactory.getInstance().getDriver().findElement(state_Option).click();
		Thread.sleep(1000);
		By stateList = By.xpath("//*[@id=\"order_state_code_wrapper\"]/div/div/ul");
		String searchText2 = "North Carolina";
		WebElement dropdownlist2 = DriverFactory.getInstance().getDriver().findElement(stateList);
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
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionStart).click();
		DriverFactory.getInstance().getDriver().findElement(startDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(startDate).clear();
		DriverFactory.getInstance().getDriver().findElement(startDate).sendKeys(strDateOne);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionEnd).click();
		DriverFactory.getInstance().getDriver().findElement(EndDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(EndDate).clear();
		DriverFactory.getInstance().getDriver().findElement(EndDate).sendKeys(strDateTwo);
	}
	
	public void labFormCalendarUpComingDate() throws InterruptedException {
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
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionStart).click();
		DriverFactory.getInstance().getDriver().findElement(startDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(startDate).clear();
		DriverFactory.getInstance().getDriver().findElement(startDate).sendKeys(strDateOne);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionEnd).click();
		DriverFactory.getInstance().getDriver().findElement(EndDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(EndDate).clear();
		DriverFactory.getInstance().getDriver().findElement(EndDate).sendKeys(strDateTwo);
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
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionStart).click();
		DriverFactory.getInstance().getDriver().findElement(startDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(startDate).clear();
		DriverFactory.getInstance().getDriver().findElement(startDate).sendKeys(strDateOne);
		Thread.sleep(1000);
		// DriverFactory.getInstance().getDriver().findElement(inputDiscussionEnd).click();
		DriverFactory.getInstance().getDriver().findElement(EndDate).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(EndDate).clear();
		DriverFactory.getInstance().getDriver().findElement(EndDate).sendKeys(strDateTwo);
	}


	public void new_Event_Form_Populate_Go_To_Meeting() throws InterruptedException {
		String location = "Chralott, NC";
		String description_Box = "This is a GoTo Meeting Event being created";

		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(form_Title_Name);
		//------------------Enter Date for Boxes---------------------------------
		Thread.sleep(1500);
		//this.formCalendarUpComingDate();
		this.formCalendarUpComingDate_2();
		
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_Location).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		//----------------- Select City State Dropdown --------------------------
		//this.form_Country_State_Select();
		Select country = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_country']")));
		country.selectByVisibleText("United States");
		Thread.sleep(1000);

		Select state = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_state']")));
		state.selectByVisibleText("Virginia");
		Thread.sleep(1000);

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_zip']")).sendKeys("23513");
		// -----------------Scroll To Description Box --------------------------
		Thread.sleep(1200);
		WebElement description = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", description);
		Thread.sleep(1200);
		//---------------------Enter text in Description Box-----------------------
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(description_Box);
		// ---switch back to default content
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement eventcatagory = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='btn-group bootstrap-select']//button[@class='btn dropdown-toggle btn-default']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", eventcatagory);
		// ---Select Event Catagory----
		DriverFactory.getInstance().getDriver().findElement(eventCatagory).click();
		Thread.sleep(1200);
		DriverFactory.getInstance().getDriver().findElement(meetings).click();
		// ---Click Track RSVPs-------
		Thread.sleep(1200);
		DriverFactory.getInstance().getDriver().findElement(rsvps).click();
		// ---Click GoToMeeting Invite-------
		Thread.sleep(1200);
		DriverFactory.getInstance().getDriver().findElement(go_To_Meeting_Invite).click();
		// ---Click GoToMeeting Host-------
		Thread.sleep(1200);
		DriverFactory.getInstance().getDriver().findElement(go_To_Meeting_Host).click();
		Thread.sleep(1200);
		DriverFactory.getInstance().getDriver().findElement(go_To_Account).click();
	}
	
	public void new_Event_With_Custom_URL(String event19) throws InterruptedException {
		String location = "Chralott, NC";
		String description_Box = "This is a GoTo Meeting Event being created";
		String url ="https://hoflercsc.my.webex.com";
		String email = "jhofler@diligent.com";

		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(event19);
		//------------------Enter Date for Boxes---------------------------------
		Thread.sleep(1500);
		//this.formCalendarUpComingDate();
		this.formCalendarUpComingDate_2();
		
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_Location).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		
		//----------------- Select City State Dropdown --------------------------
		//this.form_Country_State_Select();
		Select country = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_country']")));
		country.selectByVisibleText("United States");
		Thread.sleep(1000);

		Select state = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_state']")));
		state.selectByVisibleText("Virginia");
		Thread.sleep(1000);

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_zip']")).sendKeys("23513");
		// -----------------Scroll To Description Box --------------------------
		Thread.sleep(1200);
		WebElement description = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", description);
		Thread.sleep(1200);
		//---------------------Enter text in Description Box-----------------------
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(description_Box);
		// ---switch back to default content
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement video_Url = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_custom_video_conference_url']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", video_Url);
		//----notify email-------
		DriverFactory.getInstance().getDriver().findElement(notify).sendKeys(email);
		// ---Enter video Conferencing URL----
		DriverFactory.getInstance().getDriver().findElement(video_Conf_URL).sendKeys(url);
		// ---Select Event Catagory----
		DriverFactory.getInstance().getDriver().findElement(eventCatagory).click();
		Thread.sleep(1200);
		DriverFactory.getInstance().getDriver().findElement(meetings).click();
		// ---Click Track RSVPs-------
		Thread.sleep(1200);
		DriverFactory.getInstance().getDriver().findElement(rsvps).click();
		Thread.sleep(1200);
	}
	
	public void new_Event_Attendance_Virtual(String event18) throws InterruptedException {
		String location = "Chralott, NC";
		String description_Box = "This Is A Virtual Event being created";
		String url ="https://hoflercsc.my.webex.com";
		String email = "jhofler@diligent.com";

		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(event18);
		//------------------Enter Date for Boxes---------------------------------
		Thread.sleep(1000);
		//this.formCalendarUpComingDate();
		this.formCalendarUpComingDate_2();
		
		DriverFactory.getInstance().getDriver().findElement(form_Location).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		
		//----------------- Select City State Dropdown --------------------------
		//this.form_Country_State_Select();
		
		Select country = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_country']")));
		country.selectByVisibleText("United States");
		Thread.sleep(1000);

		Select state = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_state']")));
		state.selectByVisibleText("Virginia");
		Thread.sleep(1000);

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_zip']")).sendKeys("23513");
		
		// -----------------Scroll To Description Box --------------------------
		Thread.sleep(1000);
		WebElement description = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", description);
		Thread.sleep(1200);
		//---------------------Enter text in Description Box-----------------------
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(description_Box);
		// ---switch back to default content
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement video_Url = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_custom_video_conference_url']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", video_Url);
		//----notify email-------
		DriverFactory.getInstance().getDriver().findElement(notify).sendKeys(email);
		// ---Enter video Conferencing URL----
		DriverFactory.getInstance().getDriver().findElement(video_Conf_URL).sendKeys(url);
		// ---Select Event Catagory----
		DriverFactory.getInstance().getDriver().findElement(eventCatagory).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(meetings).click();
		Thread.sleep(1000);

		//---Attendance Type -------------
		Select attendanceDropdown = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_meeting_type']")));
		attendanceDropdown.selectByVisibleText("Virtual");
				
		// ---Click Track RSVPs-------
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(rsvps).click();
		Thread.sleep(1000);
	}
	
	public void new_Event_Attendance_Hybrid(String event17) throws InterruptedException {
		String location = "Chralott, NC";
		String description_Box = "This Is A Virtual Event being created";
		String url ="https://hoflercsc.my.webex.com";
		String email = "jhofler@diligent.com";

		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(event17);
		//------------------Enter Date for Boxes---------------------------------
		Thread.sleep(1000);
		this.formCalendarUpComingDate(); // for autotester
		//this.formCalendarUpComingDate_2(); // for stevesystem
		
		DriverFactory.getInstance().getDriver().findElement(form_Location).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		
		//----------------- Select City State Dropdown --------------------------
		//this.form_Country_State_Select();
		
		Select country = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_country']")));
		country.selectByVisibleText("United States");
		Thread.sleep(1000);

		Select state = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_state']")));
		state.selectByVisibleText("Virginia");
		Thread.sleep(1000);

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_zip']")).sendKeys("23513");
		
		// -----------------Scroll To Description Box --------------------------
		Thread.sleep(1000);
		WebElement description = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", description);
		Thread.sleep(1200);
		//---------------------Enter text in Description Box-----------------------
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(description_Box);
		// ---switch back to default content
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement video_Url = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_custom_video_conference_url']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", video_Url);
		//----notify email-------
		DriverFactory.getInstance().getDriver().findElement(notify).sendKeys(email);
		// ---Enter video Conferencing URL----
		DriverFactory.getInstance().getDriver().findElement(video_Conf_URL).sendKeys(url);
		// ---Select Event Catagory----
		DriverFactory.getInstance().getDriver().findElement(eventCatagory).click();
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(meetings).click();
		Thread.sleep(1000);

		//---Attendance Type -------------
		Select attendanceDropdown = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_meeting_type']")));
		attendanceDropdown.selectByVisibleText("Hybrid");
				
		// ---Click Track RSVPs-------
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().findElement(rsvps).click();
		Thread.sleep(1000);
	}
	
	public void new_Event_With_Microsoft_Teams_URL(String event20) throws InterruptedException {
		String location = "Chralott, NC";
		String description_Box = "This is a GoTo Meeting Event being created";
		String url ="https://teams.microsoft.com";
		String email = "jhofler@diligent.com";

		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(event20);
		//------------------Enter Date for Boxes---------------------------------
		Thread.sleep(1500);
		//this.formCalendarUpComingDate();
		this.formCalendarUpComingDate_2();
		
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		DriverFactory.getInstance().getDriver().findElement(form_Location).clear();
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(location);
		DriverFactory.getInstance().getDriver().findElement(form_Location).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		
		//----------------- Select City State Dropdown --------------------------
		//this.form_Country_State_Select();
		Select country = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_country']")));
		country.selectByVisibleText("United States");
		Thread.sleep(1000);

		Select state = new Select(DriverFactory.getInstance().getDriver().findElement(By.xpath("//select[@id='event_state']")));
		state.selectByVisibleText("Virginia");
		Thread.sleep(1000);

		DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_zip']")).sendKeys("23513");
		// -----------------Scroll To Description Box --------------------------
		Thread.sleep(1200);
		WebElement description = DriverFactory.getInstance().getDriver().findElement(By.xpath("//label[contains(text(),'Description')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", description);
		Thread.sleep(1200);
		//---------------------Enter text in Description Box-----------------------
		WebElement iframe = DriverFactory.getInstance().getDriver().findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		DriverFactory.getInstance().getDriver().switchTo().frame(iframe);
		WebElement iframeBody = DriverFactory.getInstance().getDriver().findElement(By.tagName("body"));
		iframeBody.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		iframeBody.clear();
		iframeBody.sendKeys(description_Box);
		// ---switch back to default content
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
		// ------------------- Event Category (Scroll into View)// --------------------------
		WebElement video_Url = DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@id='event_custom_video_conference_url']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", video_Url);
		//----notify email-------
		DriverFactory.getInstance().getDriver().findElement(notify).sendKeys(email);
		// ---Enter video Conferencing URL----
		DriverFactory.getInstance().getDriver().findElement(video_Conf_URL).sendKeys(url);
		// ---Select Event Catagory----
		DriverFactory.getInstance().getDriver().findElement(eventCatagory).click();
		Thread.sleep(1200);
		DriverFactory.getInstance().getDriver().findElement(meetings).click();
		// ---Click Track RSVPs-------
		Thread.sleep(1200);
		DriverFactory.getInstance().getDriver().findElement(rsvps).click();
		Thread.sleep(1200);
	}

	public void verify_Guest_List() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(guestList)));
	}

	public void verify_Workroom_Events_Crumb() throws InterruptedException {
		WebElement events = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'Workroom Events')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", events);
		Thread.sleep(1000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroom_Events_Crumb)));
	}

	public void click_Workroom_Events_Crumb() throws InterruptedException {
		WebElement SaveBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//aside//button[@name='button'][contains(text(),'Save')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(workroom_Events_Crumb).click();
	}
	
	public void verify_Event_Success_Message() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Success_Message)));
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Event_RSVPS(String event4) throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_Form_Populate(event4);
		Thread.sleep(1000);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1000);
		this.verify_Workroom_Events_Crumb();
		this.click_Workroom_Events_Crumb();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Create_New_Event() -----------");
	}
	
	public void create_New_Event_On_JH_Staging_1(String eventTitleStaging1) throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.populate_Event_Form_JH_Staging(eventTitleStaging1);
		Thread.sleep(1500);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Guest_List();
		this.verify_Workroom_Events_Crumb();
		Thread.sleep(1000);
		this.click_Workroom_Events_Crumb();
		System.out.println("------- Completed --> create_New_Event_On_JH_Staging_1() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Create_New_Event_RSVPS_2(String event21) throws InterruptedException {
		Thread.sleep(1500);
		this.verify_New_Event_Btn();
		this.click_New_Event_Btn();
		Thread.sleep(1000);
		this.verify_Form_Title();
		this.new_Event_Form_Populate_2(event21);
		Thread.sleep(1500);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Guest_List();
		Thread.sleep(1500);
		this.verify_Workroom_Events_Crumb();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(print_Upcoming_Events)));
	}
	
	public void verify_View_All_Workroom_Events() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(view_All_Workroom_Events)));
	}
	
	public void verify_Workroom_Calendar() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(workroomCalendar)));
	}
	
	public void click_Print_Upcoming_Events() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(print_Upcoming_Events).click();
	}
	
	public void click_View_All_Workroom_Events() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(view_All_Workroom_Events).click();
	}
	
	public void click_Expanded_View() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(expanded_View).click();
	}
	
	public void click_Default_View() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(default_View).click();
	}
	
	public void click_Tile_View() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(tile_View).click();
	}
	
	public void click_List_View() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(list_View).click();
	}

	public void click_Close_Calendar() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(close_Calendar).click();
	}
	
	public void verify_Tile_View_Visible() throws InterruptedException {
		String element = "//div[@class='card-body tile-card']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_List_View_Visible() throws InterruptedException {
		String element = "//table[@id='events-tablesorter']//tbody"; //---List view table
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void switch_To_Print_Events_Tab() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		//---wait a few seconds ---- 
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().close();
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Print_Events_Tab() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Print_Upcoming_Events() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		this.verify_Print_Upcoming_Events();
		this.click_Print_Upcoming_Events();
		this.switch_To_Print_Events_Tab();
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> user_Can_Print_Upcoming_Events() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_View_Upcoming_Events_Expanded_View() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		this.verify_View_All_Workroom_Events();
		this.click_Expanded_View();
		Thread.sleep(1500);
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
	By event_21_Export_Calendar = By.xpath("(//*[normalize-space(text())='Event 21']/following::div[@class='attached-buttons']//button)[1]");
	By event_21_Outlook_Option = By.xpath("(//*[normalize-space(text())='Event 21']/following::div[@class='attached-buttons']//child::li[contains(.,'Outlook')])[1]");

	public void verify_Event_21_Export_To_Calendar() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_21_Export_Calendar)));
	}
	
	public void verify_Event_21_Outlook_Option() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_21_Outlook_Option)));
	}
	
	public void click_Event_21_Export_To_Calendar() throws InterruptedException {
		WebElement save_Button = DriverFactory.getInstance().getDriver().findElement(event_21_Export_Calendar);
	    ((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", save_Button);
		Thread.sleep(1000);

		DriverFactory.getInstance().getDriver().findElement(event_21_Export_Calendar).click();
	}
	
	public void click_Event_21_Outlook_Option() throws InterruptedException {
		WebElement save_Button = DriverFactory.getInstance().getDriver().findElement(event_21_Outlook_Option);
	    ((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", save_Button);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_21_Outlook_Option).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void export_Event_21_To_Calendar() throws InterruptedException, AWTException {
		Thread.sleep(1500);
		this.verify_Event_21_Export_To_Calendar();
		this.click_Event_21_Export_To_Calendar();
		Thread.sleep(1000);
		this.verify_Event_21_Outlook_Option();
		this.click_Event_21_Outlook_Option();
		Thread.sleep(1000); // wait for download
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> export_Event_21_To_Calendar() -----------");
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
		DriverFactory.getInstance().getDriver().findElement(workroomAdmin_Eng).click();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		//----------------------------
		Thread.sleep(3500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_Guest_List();
		//----------------------------
		DriverFactory.getInstance().getDriver().findElement(systemAdmin_Eng).click();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		//----------------------------
		Thread.sleep(3500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_Guest_List();
		//----------------------------
		DriverFactory.getInstance().getDriver().findElement(test_Reset).click();
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	// --------------user_Can_Create_New_Event_GoTo_Meeting ---------------------------
	By saveBtn_Bottom = By.xpath("//div[@class='content']/fieldset/form[starts-with(@id,'edit_event')]/button[1]");
	By join_GoTo_Meeting = By.xpath("//a[@class='btn btn-default'][contains(., 'Join Go-To-Meeting')]");
	By join_Meeting = By.xpath("//a[@class='btn btn-default'][contains(., 'Join Meeting')]");
	
	public void scroll_Down_To_SaveBtn() throws InterruptedException {
		WebElement save_Button = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='content']/fieldset/form[starts-with(@id,'edit_event')]/button[1]"));
	    ((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", save_Button);
	}
	
	public void click_SaveBtn_Bottom() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(saveBtn_Bottom).click();
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
	public void user_Can_Create_New_Event_With_Custom_VC_URL(String event19) throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_With_Custom_URL(event19);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Event_Success_Message();
		this.scroll_Down_To_SaveBtn();
		Thread.sleep(1500);
		this.click_SaveBtn_Bottom();
		this.verify_Event_Success_Message();
		System.out.println("------- Completed --> user_Can_Create_New_Event_GoTo_Meeting() -----------");
	}
	
	public void user_Can_Create_New_Event_Virtual(String event18) throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_Attendance_Virtual(event18);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Event_Success_Message();
		this.scroll_Down_To_SaveBtn();
		Thread.sleep(1500);
		this.click_SaveBtn_Bottom();
		this.verify_Event_Success_Message();
		System.out.println("------- Completed --> user_Can_Create_New_Event_Virtual() -----------");
	}
	
	public void user_Can_Create_New_Event_17_Hybrid(String event17) throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_Attendance_Hybrid(event17);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1500);
		this.verify_Event_Success_Message();
		this.scroll_Down_To_SaveBtn();
		Thread.sleep(1000);
		this.click_SaveBtn_Bottom();
		this.verify_Event_Success_Message();
		System.out.println("------- Completed --> user_Can_Create_New_Event_Hybrid() -----------");
	}
	
	public void user_Can_Create_New_Event_With_MS_Teams_URL(String event20) throws InterruptedException {
		this.click_New_Event_Btn();
		this.verify_Form_Title();
		this.new_Event_With_Microsoft_Teams_URL(event20);
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
		WebElement string = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='btn btn-default'][contains(., 'Join Go-To-Meeting')]"));
	    ((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", string);
	    
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(join_GoTo_Meeting)));
	}
	
	public void verify_Join_Meeting() throws InterruptedException {
		WebElement string = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='btn btn-default'][contains(., 'Join Meeting')]"));
	    ((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", string);
	    
		Thread.sleep(2000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(join_Meeting)));
	}
	
	public void click_Join_GoTo_Meeting() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(join_GoTo_Meeting).click();
	}
	
	public void click_Join_Meeting() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(join_Meeting).click();
	}
	
	public void verify_Joining_G2M_Sucessful() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		//---verify New GoTo Meeting Page ---- 
		String title = "//title[contains(text(),'GoToMeeting')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(title)).size() > 0);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().close();
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Joining_G2M_Sucessful() -----------");
	}
	
	public void verify_Joining_Custom_Meeting_Sucessfull() throws InterruptedException, AWTException {
		// ---switch to 2nd tab----
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		//---verify New GoTo Meeting Page ---- 
		String title = "//title[contains(text(),'Cisco Webex Meetings')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(title)).size() > 0);
		Thread.sleep(1000);
		DriverFactory.getInstance().getDriver().close();
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		System.out.println("------- Completed --> verify_Joining_Custom_Meeting_Sucessfull() -----------");
	}
	
	By mst_Sign_In_Box = By.xpath("//*[@id=\"lightbox\"]/div[2]/div[1]/img");
	By my_Account = By.xpath("//div[contains(text(),'hoflercsc@gmail.com')]");
	By no_Account = By.xpath("//div[contains(text(),'No account?')]");
	By no_Button = By.xpath("//*[@class='button ext-button secondary ext-secondary']");
		
	By mst_Password = By.xpath("//*[@class='form-control input ext-input text-box ext-text-box']");
	By mst_UserName = By.xpath("//*[@class='form-control ltr_override input ext-input text-box ext-text-box']");
	By mst_Next_Btn = By.xpath("//*[@class='button ext-button primary ext-primary']");

	By mst_Sign_In_Button = By.xpath("//*[@class='button ext-button primary ext-primary']");
	By mst_Teams_Title = By.xpath("//div[@class='title']");
	
	public void verify_MST_Sign_Box() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(mst_Sign_In_Box)));
	}
	
	public void verify_MST_Password() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mst_Password)));
	}
	
	public void verify_MST_Title_Page() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(mst_Teams_Title)));
	}
	
	public void verify_No_Btn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(no_Button)));
	}
	
	
	public void click_My_Account() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(my_Account).click();
	}
	
	public void enter_MST_Password() throws InterruptedException {
		String psw = "Venus2010";
		DriverFactory.getInstance().getDriver().findElement(mst_Password).sendKeys(psw);
	}
	
	public void enter_MST_UserName() throws InterruptedException {
		String username = "hoflercsc@gmail.com";
		DriverFactory.getInstance().getDriver().findElement(mst_UserName).sendKeys(username);
	}
	
	public void click_MST_Next_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(mst_Next_Btn).click();
	}
	
	public void click_MST_Sign_In_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(mst_Sign_In_Button).click();
	}
	
	public void click_No_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(no_Button).click();
	}
	
	public void verify_If_Email_Account_Visible() throws InterruptedException {
		
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean myAccount = DriverFactory.getInstance().getDriver().findElements(my_Account).size() > 0;
		Boolean noAccount = DriverFactory.getInstance().getDriver().findElements(no_Account).size() > 0;
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
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
		ArrayList<String> tabs = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().window().maximize();

		//---verify Microsoft Teams Login ---- 
		Thread.sleep(1000);
		String title = "//title[contains(text(),'Sign in to your account')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(title)).size() > 0);
		Thread.sleep(1000);				
		//this.verify_MST_Sign_Box();
		//this.verify_If_Email_Account_Visible(); disabled this to flaky
		DriverFactory.getInstance().getDriver().close();
		// ---switch back to orginal tab----
		DriverFactory.getInstance().getDriver().switchTo().window(tabs.get(0));
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(copy)));
	}

	public void verify_Event_Copy_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Copy_Title)));
	}
	
	public void change_Event_Title(String event16) {
		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).clear();
		DriverFactory.getInstance().getDriver().findElement(event_Form_Title).sendKeys(event16);
	}

	public void click_Copy() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(copy).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Can_Copy_Workroom_Event_15(String event16) throws InterruptedException, AWTException {
		this.verify_Event_15_Dropdown_Arrow();
		this.click_Event_15_Dropdown_Arrow();
		Thread.sleep(1000);
		this.click_Event_15_Copy_Option();
		Thread.sleep(1000);
		this.verify_SaveBtn_Top();
		this.change_Event_Title(event16);
		this.click_Form_SaveBtn_Top();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Can_Copy_Workroom_Event_15() -----------");
	}
		
	// --------------User Click Accept to Respond ---------------------------------
	By acceptbtn_Not_Active = By.xpath("//a[@class='btn btn-default accept']");
	By acceptbtn_Not_Active_Event_6 = By.xpath("//*[normalize-space(text())='Event 6']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_6 = By.xpath("//*[normalize-space(text())='Event 6']/following::a[@class='btn btn-default accept active']");
	
	By acceptbtn_Not_Active_Event_8 = By.xpath("//*[normalize-space(text())='Event 8']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_8 = By.xpath("//*[normalize-space(text())='Event 8']/following::a[@class='btn btn-default accept active']");
	By acceptbtn_Not_Active_Event_9 = By.xpath("//*[normalize-space(text())='Event 9']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_9 = By.xpath("//*[normalize-space(text())='Event 9']/following::a[@class='btn btn-default accept active']");
	By acceptbtn_Not_Active_Event_10 = By.xpath("//*[normalize-space(text())='Event 10']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_10 = By.xpath("//*[normalize-space(text())='Event 10']/following::a[@class='btn btn-default accept active']");
	By acceptbtn_Not_Active_Event_11 = By.xpath("//*[normalize-space(text())='Event 11']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_11 = By.xpath("//*[normalize-space(text())='Event 11']/following::a[@class='btn btn-default accept active']");

	By acceptbtn_Not_Active_Event_12 = By.xpath("//*[normalize-space(text())='Event 12']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_12 = By.xpath("//*[normalize-space(text())='Event 12']/following::a[@class='btn btn-default accept active']");

	By acceptbtn_Not_Active_Event_13 = By.xpath("//*[normalize-space(text())='Event 13']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_13 = By.xpath("//*[normalize-space(text())='Event 13']/following::a[@class='btn btn-default accept active']");

	By acceptbtn_Not_Active_Event_14 = By.xpath("//*[normalize-space(text())='Event 14']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_14 = By.xpath("//*[normalize-space(text())='Event 14']/following::a[@class='btn btn-default accept active']");

	By acceptbtn_Not_Active_Event_24 = By.xpath("//*[normalize-space(text())='Event 24']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_24 = By.xpath("//*[normalize-space(text())='Event 24']/following::a[@class='btn btn-default accept active']");

	By acceptbtn_Not_Active_Event_25 = By.xpath("//*[normalize-space(text())='Event 25']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_25 = By.xpath("//*[normalize-space(text())='Event 25']/following::a[@class='btn btn-default accept active']");

	By acceptbtn_Not_Active_Event_26 = By.xpath("//*[normalize-space(text())='Event 26']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_26 = By.xpath("//*[normalize-space(text())='Event 26']/following::a[@class='btn btn-default accept active']");

	By acceptbtn_Not_Active_Event_27 = By.xpath("//*[normalize-space(text())='Event 27']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_27 = By.xpath("//*[normalize-space(text())='Event 27']/following::a[@class='btn btn-default accept active']");

	By acceptbtn_Not_Active_Event_28 = By.xpath("//*[normalize-space(text())='Event 28']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_28 = By.xpath("//*[normalize-space(text())='Event 28']/following::a[@class='btn btn-default accept active']");

	By acceptbtn_Not_Active_Event_31 = By.xpath("//*[normalize-space(text())='Event 31']/following::a[@class='btn btn-default accept']");
	By acceptbtn_Active_Event_31 = By.xpath("//*[normalize-space(text())='Event 31']/following::a[@class='btn btn-default accept active']");

	
	By acceptbtn_Active = By.xpath("//a[@class='btn btn-default accept active']");
	
	By virtualBtn_Not_Active_Event_17 = By.xpath("(//*[normalize-space(text())='Event 17']/following::a[@class='btn btn-default remote'][contains(.,'Virtual')])[1]");
	By virtualBtn_Active_Event_17 = By.xpath("(//*[normalize-space(text())='Event 17']/following::a[@class='btn btn-default remote active'][contains(.,'Virtual')])[1]");
	
	By inPersonBtn_Not_Active_Event_17 = By.xpath("(//*[normalize-space(text())='Event 17']/following::a[@class='btn btn-default accept'][contains(.,'In Person')])[1]");
	By inPersonBtn_Active_Event_17 = By.xpath("(//*[normalize-space(text())='Event 17']/following::a[@class='btn btn-default accept active'][contains(.,'In Person')])[1]");

	By virtualBtn_Not_Active_Event_18 = By.xpath("(//*[normalize-space(text())='Event 18']/following::a[@class='btn btn-default remote'][contains(.,'Virtual')])[1]");
	By virtualBtn_Active_Event_18 = By.xpath("(//*[normalize-space(text())='Event 18']/following::a[@class='btn btn-default remote active'][contains(.,'Virtual')])[1]");
	

	public void verify_AcceptBtn_Not_Active() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='btn btn-default accept']"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Not_Active_Event_6() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_6)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_6);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_6() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_6)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_8() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_8)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_8);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_8() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_8)));
	}

	public void verify_AcceptBtn_Not_Active_Event_9() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_9)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_9);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_9() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_9)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_10() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_10)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_10);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_10() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_10)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_11() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_11)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_11);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_11() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_11)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_12() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_12)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_12);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_12() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_12)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_13() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_13)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_13);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_13() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_13)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_14() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_14)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_14);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_14() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_14)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_24() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_24)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_24);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_24() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_24)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_25() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_25)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_25);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_25() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_25)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_26() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_26)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_26);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_26() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_26)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_27() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_27)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_27);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_27() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_27)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_28() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_28)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_28);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_28() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_28)));
	}
	
	public void verify_AcceptBtn_Not_Active_Event_31() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Not_Active_Event_31)));
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_31);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_AcceptBtn_Active_Event_31() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active_Event_31)));
	}
	
	//------------------------------------------
	public void verify_AcceptBtn_Active() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(acceptbtn_Active)));
	}

	public void verify_VirtualBtn_Not_Active_On_Event_17() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(virtualBtn_Not_Active_Event_17)));
	}
	
	public void verify_VirtualBtn_Active_On_Event_17() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(virtualBtn_Active_Event_17)));
	}
	
	public void verify_InPersonBtn_Not_Active_On_Event_17() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(inPersonBtn_Not_Active_Event_17)));
	}
	
	public void verify_InPersonBtn_Active_On_Event_17() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(inPersonBtn_Active_Event_17)));
	}
	
	public void verify_VirtualBtn_Not_Active_On_Event_18() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(virtualBtn_Not_Active_Event_18)));
	}
	
	public void verify_VirtualBtn_Active_On_Event_18() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(virtualBtn_Active_Event_18)));
	}
	
	public void click_AcceptBtn_Not_Active() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='btn btn-default accept']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_6() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_6);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_8() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_8);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_9() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_9);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_10() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_10);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_11() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_11);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_12() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_12);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_13() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_13);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_14() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_14);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_24() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_24);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_25() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_25);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_26() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_26);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_27() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_27);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_28() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_28);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_AcceptBtn_Not_Active_Event_31() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(acceptbtn_Not_Active_Event_31);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	public void click_VirtualBtn_Not_Active_On_Event_17() throws InterruptedException {
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(virtualBtn_Not_Active_Event_17);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_InPersonBtn_Not_Active_On_Event_17() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(inPersonBtn_Not_Active_Event_17);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_VirtualBtn_Not_Active_On_Event_18() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(virtualBtn_Not_Active_Event_18);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

	// --------------Function Being Called ---------------------------
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active();
		this.click_AcceptBtn_Not_Active();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active();
		System.out.println("------- Completed --> user_Can_Click_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_6_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_6();
		this.click_AcceptBtn_Not_Active_Event_6();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_6();
		System.out.println("------- Completed --> user_Click_Event_6_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_8_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_8();
		this.click_AcceptBtn_Not_Active_Event_8();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_8();
		System.out.println("------- Completed --> user_Click_Event_8_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_9_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_9();
		this.click_AcceptBtn_Not_Active_Event_9();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_9();
		System.out.println("------- Completed --> user_Click_Event_9_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_10_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_10();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.click_AcceptBtn_Not_Active_Event_10();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_10();
		System.out.println("------- Completed --> user_Click_Event_10_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_11_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_11();
		this.click_AcceptBtn_Not_Active_Event_11();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_11();
		System.out.println("------- Completed --> user_Click_Event_11_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_12_Accept_As_Response() throws InterruptedException {
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_AcceptBtn_Not_Active_Event_12();
		this.click_AcceptBtn_Not_Active_Event_12();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_12();
		System.out.println("------- Completed --> user_Click_Event_13_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_13_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_13();
		this.click_AcceptBtn_Not_Active_Event_13();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_13();
		System.out.println("------- Completed --> user_Click_Event_13_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_14_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_14();
		this.click_AcceptBtn_Not_Active_Event_14();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_14();
		System.out.println("------- Completed --> user_Click_Event_14_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_24_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_24();
		this.click_AcceptBtn_Not_Active_Event_24();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_24();
		System.out.println("------- Completed --> user_Click_Event_24_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_25_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_25();
		this.click_AcceptBtn_Not_Active_Event_25();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_25();
		System.out.println("------- Completed --> user_Click_Event_25_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_26_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_26();
		this.click_AcceptBtn_Not_Active_Event_26();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_26();
		System.out.println("------- Completed --> user_Click_Event_26_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_27_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_27();
		this.click_AcceptBtn_Not_Active_Event_27();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_27();
		System.out.println("------- Completed --> user_Click_Event_27_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_28_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_28();
		this.click_AcceptBtn_Not_Active_Event_28();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_28();
		System.out.println("------- Completed --> user_Click_Event_28_Accept_As_Response() -----------");
	}
	
	public void user_Click_Event_31_Accept_As_Response() throws InterruptedException {
		this.verify_AcceptBtn_Not_Active_Event_31();
		this.click_AcceptBtn_Not_Active_Event_31();
		Thread.sleep(1000);
		this.verify_AcceptBtn_Active_Event_31();
		System.out.println("------- Completed --> user_Click_Event_31_Accept_As_Response() -----------");
	}
	
	
	
	// --------------workroomAdmin_Response_Maybe ---------------------------
	
	By maybe_Btn_Event_8 = By.xpath("//*[normalize-space(text())='Event 8']/following::a[@class='btn btn-default maybe']");
	By maybe_Btn_Active_Event_8 = By.xpath("(//*[normalize-space(text())='Event 8']/following::a[@class='btn btn-default maybe active'])[1]");

	By maybe_Btn_Event_14 = By.xpath("//*[normalize-space(text())='Event 14']/following::a[@class='btn btn-default maybe']");
	By maybe_Btn_Active_Event_14 = By.xpath("(//*[normalize-space(text())='Event 14']/following::a[@class='btn btn-default maybe active'])[1]");

	By maybe_Btn_Event_27 = By.xpath("//*[normalize-space(text())='Event 27']/following::a[@class='btn btn-default maybe']");
	By maybe_Btn_Active_Event_27 = By.xpath("//*[normalize-space(text())='Event 27']/following::a[@class='btn btn-default maybe active']");

	public void verify_Maybe_Btn_Event_8() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(maybe_Btn_Event_8)));
	}
	
	public void verify_Maybe_Btn_Active_Event_8() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(maybe_Btn_Active_Event_8)));
	}
	
	public void verify_Maybe_Btn_Event_14() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(maybe_Btn_Event_14)));
	}
	
	public void verify_Maybe_Btn_Active_Event_14() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(maybe_Btn_Active_Event_14)));
	}
	
	public void verify_Maybe_Btn_Event_27() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(maybe_Btn_Event_27)));
	}
	
	public void verify_Maybe_Btn_Active_Event_27() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(maybe_Btn_Active_Event_27)));
	}
	
	
	public void click_Maybe_Btn_Event_8() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(maybe_Btn_Event_8);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(maybe_Btn_Event_8).click();
	}	
	
	public void click_Maybe_Btn_Event_14() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(maybe_Btn_Event_14);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(maybe_Btn_Event_14).click();
	}	
	
	public void click_MaybeBtn_Event_27() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(maybe_Btn_Event_27);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		
		DriverFactory.getInstance().getDriver().findElement(maybe_Btn_Event_27).click();
	}
//-------------------------------------------------------------------------------
	
	
	public void user_Response_Maybe_Event_8() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE_Events();
		this.verify_Maybe_Btn_Event_8();
		this.click_Maybe_Btn_Event_8();
		Thread.sleep(1500);
		this.verify_Maybe_Btn_Active_Event_8();
		System.out.println("------- Completed --> user_Response_Maybe_Event_8() -----------");
	}
	
	public void user_Response_Maybe_Event_14() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoAttend_Events();
		this.verify_Maybe_Btn_Event_14();
		this.click_Maybe_Btn_Event_14();
		Thread.sleep(1500);
		this.verify_Maybe_Btn_Active_Event_14();
		System.out.println("------- Completed --> workroomAdmin_Response_Maybe_Event_14() -----------");
	}
	
	public void user_Response_Maybe_Event_27() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE_Events();
		this.verify_Maybe_Btn_Event_27();
		this.click_MaybeBtn_Event_27();
		Thread.sleep(1500);
		this.verify_Maybe_Btn_Active_Event_27();
		System.out.println("------- Completed --> user_Response_Maybe_Event_27() -----------");
	}
	
	// --------------autoDirector_Response_Decline ---------------------------
	By decline_Btn_Not_Active_Event_27 = By.xpath("//*[normalize-space(text())='Event 27']/following::a[@class='btn btn-default decline']");
	By decline_Btn_Active_Event_27 = By.xpath("//*[normalize-space(text())='Event 27']/following::a[@class='btn btn-default decline active']");
	
	By decline_Btn_Not_Active_Event_8 = By.xpath("(//*[normalize-space(text())='Event 8']/following::a[@class='btn btn-default decline'])[1]");
	By decline_Btn_Active_Event_8 = By.xpath("(//*[normalize-space(text())='Event 8']/following::a[@class='btn btn-default decline active'])[1]");

	By decline_Btn_Not_Active_Event_14 = By.xpath("(//*[normalize-space(text())='Event 14']/following::a[@class='btn btn-default decline'])[1]");
	By decline_Btn_Active_Event_14 = By.xpath("(//*[normalize-space(text())='Event 14']/following::a[@class='btn btn-default decline active'])[1]");


	public void verify_Decline_Btn_Not_Active_Event_27() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(decline_Btn_Not_Active_Event_27)));
	}

	public void verify_Decline_Btn_Active_Event_27() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(decline_Btn_Active_Event_27)));
	}
	
	public void verify_Decline_Btn_Not_Active_Event_8() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(decline_Btn_Not_Active_Event_8)));
	}

	public void verify_Decline_Btn_Active_Event_8() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(decline_Btn_Active_Event_8)));
	}
	
	public void click_Decline_Btn_Not_Active_Event_8() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(decline_Btn_Not_Active_Event_8);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(decline_Btn_Not_Active_Event_8).click();
	}
	
	public void verify_Decline_Btn_Not_Active_Event_14() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(decline_Btn_Not_Active_Event_14)));
	}

	public void verify_Decline_Btn_Active_Event_14() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(decline_Btn_Active_Event_14)));
	}
	
	public void click_Decline_Btn_Not_Active_Event_14() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(decline_Btn_Not_Active_Event_14);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(decline_Btn_Not_Active_Event_14).click();
	}
	
	public void click_Decline_Btn_Not_Active_Event_27() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(decline_Btn_Not_Active_Event_27);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		
		DriverFactory.getInstance().getDriver().findElement(decline_Btn_Not_Active_Event_27).click();
	}
	
 //---------------------------------------------------------------------
	public void user_Response_Decline_Event_27() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE_Events();
		this.verify_Decline_Btn_Not_Active_Event_27();
		this.click_Decline_Btn_Not_Active_Event_27();
		Thread.sleep(1000);
		this.verify_Decline_Btn_Active_Event_27();
		System.out.println("------- Completed --> user_Response_Decline_Event_27() -----------");
	}
	
	public void user_Response_Decline_Event_8() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE_Events();
		this.verify_Decline_Btn_Not_Active_Event_8();
		this.click_Decline_Btn_Not_Active_Event_8();
		Thread.sleep(1000);
		this.verify_Decline_Btn_Active_Event_8();
		System.out.println("------- Completed --> user_Response_Decline_Event_8() -----------");
	}
	
	public void user_Response_Decline_Event_14() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoAttend_Events();
		this.verify_Decline_Btn_Not_Active_Event_14();
		this.click_Decline_Btn_Not_Active_Event_14();
		Thread.sleep(1000);
		this.verify_Decline_Btn_Active_Event_14();
		System.out.println("------- Completed --> user_Response_Decline_Event_14() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	
	
	public void user_Event_17_Response_Vitual() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoAttend_Events();
		this.verify_VirtualBtn_Not_Active_On_Event_17();
		Thread.sleep(1000);
		this.click_VirtualBtn_Not_Active_On_Event_17();
		Thread.sleep(1500);
		this.verify_VirtualBtn_Active_On_Event_17();
		System.out.println("------- Completed --> user_Event_17_Response_Vitual() -----------");
	}
	
	public void user_Event_17_Response_InPerson() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoAttend_Events();
		this.verify_InPersonBtn_Not_Active_On_Event_17();
		Thread.sleep(1000);
		this.click_InPersonBtn_Not_Active_On_Event_17();
		Thread.sleep(1500);
		this.verify_InPersonBtn_Active_On_Event_17();
		System.out.println("------- Completed --> user_Event_17_Response_InPerson() -----------");
	}
	
	public void user_Event_18_Response_Vitual() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoAttend_Events();
		this.verify_VirtualBtn_Not_Active_On_Event_18();
		Thread.sleep(1000);
		this.click_VirtualBtn_Not_Active_On_Event_18();
		Thread.sleep(1500);
		this.verify_VirtualBtn_Active_On_Event_18();
		System.out.println("------- Completed --> user_Event_18_Response_Vitual() -----------");
	}
	
	// --------------autoTester_Clear_Responses---------------------------
	By new_Event_Title = By.xpath("//a[contains(text(),'This is a New Event Title')]");
	By guest_List = By.xpath("//h3[contains(text(),'Guest List')]");
	By dropdown_Position_1 = By.xpath("(//tr//button[@class='btn btn-default btn-xs dropdown-toggle'])[1]");
	By change_Response = By.xpath("//div[@class='btn-group small header-actions no-mobile open']//a[contains(text(),'Change Response')]");
	By clear_Response = By.xpath("//div[@class='popover-content']//a[@class='pull-left'][contains(text(),'Clear Response')]");
	By autmation_Tester_Row = By.xpath("//tr//button[@class='btn btn-default btn-xs dropdown-toggle']/preceding::tr//td//span[contains(text(),'Automation Tester')]");

	public void verify_New_Event_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Event_Title)));
	}
	
	public void verify_Guest_List_And_Scroll() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(guest_List)));
		
		Thread.sleep(1500);
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//h3[contains(text(),'Guest List')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void verify_Clear_response() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(new_Event_Title)));
	}
	
	public void click_New_Event_Title() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(new_Event_Title).click();
	}
	
	public void click_Dropdown_Position_1() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(dropdown_Position_1).click();
	}
	
	public void click_Change_Response() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(change_Response).click();
	}
	
	public void click_Clear_Response() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(clear_Response).click();
	}
	
	public void verify_Not_Yet_Replied_AutoTester() throws InterruptedException {
		String element = " //*[contains(text(),'Not Yet Replied')]//following::text()[contains(., 'Automation Tester')]//following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Not_Yet_Replied_WorkroomAdmin() throws InterruptedException {
		String element = "//*[contains(text(),'Not Yet Replied')]//following::text()[contains(., 'Workroom Admin')]//following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Not_Yet_Replied_AutoDirector() throws InterruptedException {
		String element = "//*[contains(text(),'Not Yet Replied')]/following::text()[contains(., 'Auto Director')]//following::button[@class='btn btn-default btn-xs dropdown-toggle']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void autoTester_Clear_Response() throws InterruptedException {
		this.click_Dropdown_Position_1();//Automation Tester
		this.click_Change_Response();
		Thread.sleep(1000);
		this.click_Clear_Response();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		//this.verify_Not_Yet_Replied_AutoTester();
	}
	
	public void clear_AutoTester_Response_Event_14() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoAttend_Events();
		this.verify_Event_14_Title();
		this.click_Event_14_Title();
		Thread.sleep(1500);
		this.verify_Guest_List_And_Scroll();
		this.autoTester_Clear_Response();
		System.out.println("------- Completed --> clear_AutoTester_Response_Event_14() -----------");
	}
	
	public void clear_Workroom_Admin_Response() throws InterruptedException {
		this.click_Dropdown_Position_1();//workrrom Admin
		this.click_Change_Response();
		Thread.sleep(1000);
		this.click_Clear_Response();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		this.verify_Not_Yet_Replied_WorkroomAdmin();
	}
	
	public void clear_Auto_Director_Response() throws InterruptedException {
		this.click_Dropdown_Position_1();//auto director
		this.click_Change_Response();
		Thread.sleep(1000);
		this.click_Clear_Response();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(notes)));
	}
	
	public void verify_Notes_TextArea() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(notes_TextArea)));
	}

	public void click_Notes() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(notes).click();
	}
	
	public void sendKeys_Notes_TextArea() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(notes_TextArea).sendKeys(message);
	}
	
	public void click_Submit() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(submit).click();
	}
	
	public void click_Dropdown_Position_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(dropdown_Position_2).click();
	}
	
	public void click_Dropdown_Position_3() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(dropdown_Position_3).click();
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
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		this.verify_New_Event_Title();
		this.click_New_Event_Title();
		Thread.sleep(1500);
		this.verify_Guest_List_And_Scroll();
		this.add_Notes_To_AutoTester();
		System.out.println("------- Completed --> autoTester_Clear_Responses() -----------");
	}
	
	public void add_Notes_To_AutoTester_Response_Event_8_Title() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Events();
		this.verify_Event_8_Title();
		this.click_Event_8_Title();
		Thread.sleep(1500);
		this.verify_Guest_List_And_Scroll();
		this.add_Notes_To_AutoTester();
		System.out.println("------- Completed --> add_Notes_To_AutoTester_Response_Event_8_Title() -----------");
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_Guest_List_And_Scroll();
		String automation_Tester = "(//tr//td[contains(text(),'this is a response')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[1]";
		String workroom_Admin = "(//tr//td[contains(text(),'this is a response')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[2]";
		String auto_Director = "(//tr//td[contains(text(),'this is a response')]/following::button[@class='btn btn-default btn-xs dropdown-toggle'])[3]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(automation_Tester)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(workroom_Admin)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(auto_Director)).size() > 0);
	}
	
	// --------------take_Attendance---------------------------
	By guest_Dropdown = By.xpath("//div[@class='inline']//button[@class='btn btn-default btn-xs dropdown-toggle']");
	By take_Attendance = By.xpath("//a[@class='take-attendance']");
	By in_Attendance = By.xpath("(//tr[contains(., 'Workroom Admin')]//following::label[contains(text(),'In Attendance')])[1]");
	By done_Taking_Attendance = By.xpath("//a[@class='done-attendance']");
	By attendance_PDF = By.xpath("//a[contains(text(),'Attendance PDF')]");

	public void verify_Guest_Dropdown() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(guest_Dropdown)));
	}
	
	public void verify_Take_Attendance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(take_Attendance)));
	}
	
	public void verify_Done_Taking_Attendance() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(done_Taking_Attendance)));
	}
	
	public void verify_Attendance_PDF() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attendance_PDF)));
	}
	
	public void click_Guest_Dropdown() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(guest_Dropdown).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@class='inline']//button[@class='btn btn-default btn-xs dropdown-toggle']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Take_Attendance() throws InterruptedException {
		//DriverFactory.getInstance().getDriver().findElement(take_Attendance).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='take-attendance']"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_In_Attendance() throws InterruptedException {
	    //DriverFactory.getInstance().getDriver().findElement(in_Attendance).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//tr[contains(., 'Workroom Admin')]//following::label[contains(text(),'In Attendance')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_In_Attendance_Auto_User_4() throws InterruptedException {
	    //DriverFactory.getInstance().getDriver().findElement(in_Attendance).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//tr[contains(., 'Auto User4')]//following::label[contains(text(),'In Attendance')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_In_Attendance_Auto_User_5() throws InterruptedException {
	    //DriverFactory.getInstance().getDriver().findElement(in_Attendance).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//tr[contains(., 'Auto User5')]//following::label[contains(text(),'In Attendance')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_In_Attendance_Auto_User_25() throws InterruptedException {
	    //DriverFactory.getInstance().getDriver().findElement(in_Attendance).click();
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//tr[contains(., 'Auto User25')]//following::label[contains(text(),'In Attendance')])[1]"));
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void click_Done_Taking_Attendance() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(done_Taking_Attendance).click();
	}
	
	public void click_Attendance_PDF() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attendance_PDF).click();
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
		DriverFactory.getInstance().getDriver().navigate().refresh();
		//---------------------
		this.verify_Guest_List_And_Scroll();
		Thread.sleep(1000);
		this.click_Guest_Dropdown();
		Thread.sleep(1000);
		this.verify_Take_Attendance();
		this.click_Take_Attendance();
		Thread.sleep(2000);
		//---------------------
		//DriverFactory.getInstance().getDriver().navigate().refresh();
		//this.verify_Guest_List_And_Scroll();
		this.click_Guest_Dropdown();
		Thread.sleep(1000);
		this.verify_Done_Taking_Attendance();
		this.click_Done_Taking_Attendance();
		Thread.sleep(2000);
	}
	
	public void take_Attendance_Event_28() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Guest_Dropdown();
		this.click_Guest_Dropdown();
		Thread.sleep(1500);
		this.verify_Take_Attendance();
		this.click_Take_Attendance();
		Thread.sleep(2500);
		//----------------------
		this.click_In_Attendance_Auto_User_4();
		Thread.sleep(3000);
		this.click_In_Attendance_Auto_User_25();
		Thread.sleep(3000);
		this.click_In_Attendance();
		Thread.sleep(3000);
		this.click_In_Attendance();
		Thread.sleep(3000);
		this.click_In_Attendance();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		//---------------------
		this.verify_Guest_List_And_Scroll();
		Thread.sleep(1000);
		this.click_Guest_Dropdown();
		Thread.sleep(1000);
		this.verify_Take_Attendance();
		this.click_Take_Attendance();
		Thread.sleep(2000);
		//---------------------
		//DriverFactory.getInstance().getDriver().navigate().refresh();
		//this.verify_Guest_List_And_Scroll();
		this.click_Guest_Dropdown();
		Thread.sleep(1000);
		this.verify_Done_Taking_Attendance();
		this.click_Done_Taking_Attendance();
		Thread.sleep(2000);
	}
	
	public void verify_Attendees_Event_31() throws InterruptedException {
		String user1 = "//th[contains(text(),'Attending - In Person')]/following::span[contains(text(),'Auto User11')]";
		String user2 = "//th[contains(text(),'Attending - In Person')]/following::span[contains(text(),'Auto User12')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user1)).size() > 0);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user2)).size() > 0);
	}
	
	// --------------Function Being Called ---------------------------
	public void take_User_Attendance_Event_28() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoAttend_Events();
		this.verify_Event_28_Title();
		this.click_Event_28_Title();
		Thread.sleep(1500);
		this.verify_Guest_List_And_Scroll();
		this.take_Attendance_Event_28();
		System.out.println("------- Completed --> take_User_Attendance_Event_28() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void view_Attendees_Event_31() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_Constellation_Events();
		this.verify_Event_31_Title();
		this.click_Event_31_Title();
		Thread.sleep(1500);
		this.verify_Guest_List_And_Scroll();
		this.verify_Attendees_Event_31();
		System.out.println("------- Completed --> view_Attendees_Event_31() -----------");
	}
	
	public void scroll_To_My_BoardEffect() {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[contains(text(),'My BoardEffect')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	// --------------Function Being Called ---------------------------
	public void generate_Attendance_Report() throws InterruptedException, AWTException {
		this.click_Guest_Dropdown();
		Thread.sleep(1000);
		this.verify_Attendance_PDF();
		this.click_Attendance_PDF();
		Thread.sleep(5000);
		System.out.println("------- Completed --> generate_Attendance_Report() -----------");
	}
	
	// --------------switch_To_Creating_Poll_Survey_Books ---------------------------
	By attach_Create_Event_4 = By.xpath("(//*[normalize-space(text())='Event 4']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");
	By attach_Create_Event_6 = By.xpath("(//*[normalize-space(text())='Event 6']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");
	By attach_Create_Event_11 = By.xpath("(//*[normalize-space(text())='Event 11']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");
	By attach_Create_Event_12 = By.xpath("(//*[normalize-space(text())='Event 12']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");
	By attach_Create_Event_13 = By.xpath("(//*[normalize-space(text())='Event 13']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");
	By attach_Create_Event_26 = By.xpath("(//*[normalize-space(text())='Event 26']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");
	By attach_Create_Event_38 = By.xpath("(//*[normalize-space(text())='Event 38']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");

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

	
	//---------------------------------------------
	public void verify_Polls_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(polls_Tab)));
	}
	
	public void verify_Surveys_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(surveys_Tab)));
	}
	
	public void verify_Create_Poll() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(createPoll)));
	}
	
	public void verify_Create_Survey() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(createSurvey)));
	}
	
	public void verify_Create_Book() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(createBook)));
	}
	
	public void verify_Books_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(books)));
	}
	
	public void verify_Approval_Item() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(approval_Item)));
	}
	
	public void verify_AttachOrCreate_3rd_Card() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attachOrCreate_3rd_Card)));
		
		WebElement attachOrCreateCard3 = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[3]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", attachOrCreateCard3);
		
		Thread.sleep(1000);
	}
	
	public void verify_Attach_Create_Event_4() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Event_4)));
		
		WebElement event = DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_4);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", event);
		
		Thread.sleep(1000);
	}
	
	public void verify_Attach_Create_Event_6() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Event_6)));
		
		WebElement event = DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_6);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", event);
		
		Thread.sleep(1000);
	}
	
	public void verify_Attach_Create_Event_12() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Event_12)));
		
		WebElement event = DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_12);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", event);
		
		Thread.sleep(1000);
	}
	
	public void verify_Attach_Create_Event_13() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Event_13)));
		
		WebElement event = DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_13);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", event);
		
		Thread.sleep(1000);
	}
	
	public void verify_Attach_Create_Event_26() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Event_26)));
		
		WebElement event = DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_26);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", event);
		
		Thread.sleep(1000);
	}
	
	public void verify_Attach_Create_Event_38() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Event_38)));
		
		WebElement event = DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_38);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", event);
		
		Thread.sleep(1000);
	}
	
	public void verify_Survey_Card_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(survey_Card_2)));
	}
	
	public void verify_Poll_Card_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(poll_Card_2)));
	}
	
	public void click_Event_4_Attach_Create() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_4).click();
	}
	
	public void click_Event_6_Attach_Create() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_6).click();
	}
	
	public void click_Event_11_Attach_Create() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_11).click();
	}
	
	public void click_Event_12_Attach_Create() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_12).click();
	}
	
	public void click_Event_13_Attach_Create() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_13).click();
	}
	
	public void click_Event_26_Attach_Create() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_26).click();
	}
	
	public void click_Event_38_Attach_Create() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_38).click();
	}
	
	public void click_AttachOrCreate_3rd_Card() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attachOrCreate_3rd_Card).click();
	}
	
	public void click_Polls_Tab() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(polls_Tab).click();
	}
	
	public void click_Surveys_Tab() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(surveys_Tab).click();
	}
	
	public void click_CreatePoll() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(createPoll).click();
	}
	
	public void click_Poll_Card_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(poll_Card_2).click();
	}
	
	public void click_CreateSurvey() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(createSurvey).click();
	}
	
	public void click_Survey_Card_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_Card_2).click();
	}
	
	public void click_CreateBook() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(createBook).click();
	}
	
	public void click_Books_Tab() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(books).click();
	}
	
	public void click_Approvals_Tab() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(approvals).click();
	}
	
	public void click_Approvals_Item() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(approval_Item).click();
	}
	
	public void click_Done() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(done_Button).click();
	}
	
	public void click_Survey_Done_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_Done_Button).click();
	}
	
	public void click_Poll_Done_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(poll_Done_Button).click();
	}
	
	// --------------Function Being Called --------------------------
	
	public void switch_To_Creating_Book_For_Event_Title_Staging_1() throws InterruptedException, AWTException {
		this.verify_Attach_Create_Event_Title_On_Staging_1();
		this.scroll_Attach_Create_Event_Title_On_Staging_1();
		this.click_Attach_Create_Event_Title_On_Staging_1();
		this.verify_Books_Tab();
		this.click_Books_Tab();
		Thread.sleep(1000);
		this.verify_Create_Book();
		this.click_CreateBook();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Book_For_Event_Title_Staging_1() -----------");
	}
	
	public void switch_To_Creating_Poll_For_Event_Title_On_Staging_2() throws InterruptedException, AWTException {
		this.verify_Attach_Create_Event_Title_On_Staging_2();
		this.scroll_Attach_Create_Event_Title_On_Staging_2();
		this.click_Attach_Create_Event_Title_On_Staging_2();
		Thread.sleep(2000);
		this.verify_Polls_Tab();
		this.click_Polls_Tab();
		Thread.sleep(2000);
		this.verify_Create_Poll();
		this.click_CreatePoll();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Poll() -----------");
	}
	
	public void switch_To_Create_Survey_For_Event_Title_On_Staging_3() throws InterruptedException, AWTException {
		this.verify_Attach_Create_Event_Title_On_Staging_3();
		this.scroll_Attach_Create_Event_Title_On_Staging_3();
		this.click_Attach_Create_Event_Title_On_Staging_3();
		Thread.sleep(1500);
		this.verify_Surveys_Tab();
		this.click_Surveys_Tab();
		Thread.sleep(1500);
		this.verify_Create_Survey();
		this.click_CreateSurvey();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Attach_For_Event_Title_On_Staging_3() -----------");
	}
	
	
	public void switch_To_Event_4_Attach_Poll() throws InterruptedException, AWTException {
		this.verify_Attach_Create_Event_4();
		this.click_Event_4_Attach_Create();
		Thread.sleep(2000);
		this.verify_Polls_Tab();
		this.click_Polls_Tab();
		Thread.sleep(2000);
		this.verify_Poll_Card_2();
		this.click_Poll_Card_2();
		Thread.sleep(1000);
		this.click_Poll_Done_Btn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> switch_To_Attach_Poll() -----------");
	}
	
	public void switch_To_Creating_Poll_On_Event_12() throws InterruptedException, AWTException {
		this.verify_Attach_Create_Event_12();
		this.click_Event_12_Attach_Create();
		Thread.sleep(2000);
		this.verify_Polls_Tab();
		this.click_Polls_Tab();
		Thread.sleep(2000);
		this.verify_Create_Poll();
		this.click_CreatePoll();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Poll_On_Event_12() -----------");
	}
	
	public void switch_To_Event_6_Attach_Survey() throws InterruptedException, AWTException {
		this.verify_Attach_Create_Event_6();
		this.click_Event_6_Attach_Create();
		Thread.sleep(2000);
		this.verify_Surveys_Tab();
		this.click_Surveys_Tab();
		Thread.sleep(2000);
		this.verify_Survey_Card_2();
		this.click_Survey_Card_2();
		Thread.sleep(1000);
		this.click_Survey_Done_Btn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		System.out.println("------- Completed --> switch_To_Attach_Survey() -----------");
	}
	
	public void switch_To_Event_13_Attach_Survey() throws InterruptedException, AWTException {
		this.verify_Attach_Create_Event_13();
		this.click_Event_13_Attach_Create();
		Thread.sleep(2000);
		this.verify_Surveys_Tab();
		this.click_Surveys_Tab();
		Thread.sleep(2000);
		this.verify_Create_Survey();
		this.click_CreateSurvey();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Event_13_Attach_Survey() -----------");
	}
	
	public void switch_To_Event_26_Attach_Survey() throws InterruptedException, AWTException {
		this.verify_Attach_Create_Event_26();
		this.click_Event_26_Attach_Create();
		Thread.sleep(2000);
		this.verify_Surveys_Tab();
		this.click_Surveys_Tab();
		Thread.sleep(2000);
		this.verify_Create_Survey();
		this.click_CreateSurvey();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Event_26_Attach_Survey() -----------");
	}
	
	
	// --------------Function Being Called ---------------------------
	public void switch_To_Creating_Survey() throws InterruptedException, AWTException {
		this.verify_AttachOrCreate_3rd_Card();
		this.click_Attach_Create();
		Thread.sleep(2000);
		this.verify_Surveys_Tab();
		this.click_Surveys_Tab();
		Thread.sleep(2000);
		this.verify_Create_Survey();
		this.click_CreateSurvey();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Survey() -----------");
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
		this.click_Attach_Create();
		Thread.sleep(1000);
		this.verify_Books_Tab();
		this.click_Books_Tab();
		Thread.sleep(1000);
		this.verify_Create_Book();
		this.click_CreateBook();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Book() -----------");
	}
	
	public void switch_To_Creating_Meeting_Book_3() throws InterruptedException, AWTException {
		this.click_Event_11_Attach_Create();
		Thread.sleep(1000);
		this.verify_Books_Tab();
		this.click_Books_Tab();
		Thread.sleep(1000);
		this.verify_Create_Book();
		this.click_CreateBook();
		Thread.sleep(2000);
		System.out.println("------- Completed --> switch_To_Creating_Meeting_Book_3() -----------");
	}
	
	By handbook_2_Option_ = By.xpath("//span[contains(text(),'Hand Book 2')]");
	By done_HB = By.xpath("//button[@id='attached_book'][contains(.,'Done')]");

	public void verify_Handbook_2_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(handbook_2_Option_)));
	}
	
	public void click_Handbook_2_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_2_Option_).click();
	}
	
	public void click_Done_HB() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(done_HB).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void attach_Hand_Book_to_Event_38() throws InterruptedException, AWTException {
		this.verify_Attach_Create_Event_38();
		this.click_Event_38_Attach_Create();
		Thread.sleep(2000);
		this.verify_Books_Tab();
		this.click_Books_Tab();
		Thread.sleep(1500);
		this.verify_Handbook_2_Option();
		this.click_Handbook_2_Option();
		Thread.sleep(1500);
		this.click_Done_HB();
		System.out.println("------- Completed --> attach_Hand_Book_to_Event_38() -----------");
	}
	
	// --------------switch_To_Attach_Approval---------------------------
	By approvals_Heading = By.xpath("//h4[@class='heading-approvals']");
	By approvals_Message = By.xpath("//li[starts-with (@id,'approval')][contains(text(),'Do you approve this item?')]");
	By approvals_X_Btn = By.xpath("//li[starts-with (@id,'approval')]//following::a[contains(text(),'|')]");
	
	public void verify_Approvals_Heading() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.and(ExpectedConditions.elementToBeClickable(approvals_Heading)));
	}
	
	public void click_Approvals_X_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(approvals_X_Btn).click();
	}
	
	// --------------Function Being Called ---------------------------
	public void switch_To_Attach_Approval() throws InterruptedException, AWTException {
		this.click_Attach_Create();
		Thread.sleep(2000);
		this.verify_Books_Tab();
		this.click_Approvals_Tab();
		Thread.sleep(2000);
		this.verify_Approval_Item();
		this.click_Approvals_Item();
		Thread.sleep(1000);
		this.click_Done();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> switch_To_Attach_Approval() -----------");
	}
	
	public void switch_To_Attach_Approval_Event_9() throws InterruptedException, AWTException {
		this.click_Attach_Create_Event_9();
		Thread.sleep(2000);
		this.verify_Books_Tab();
		this.click_Approvals_Tab();
		Thread.sleep(2000);
		this.verify_Approval_Item();
		this.click_Approvals_Item();
		Thread.sleep(1000);
		this.click_Done();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> switch_To_Attach_Approval_Event_9() -----------");
	}
	
	public void switch_To_Attach_Approval_Event_24() throws InterruptedException, AWTException {
		this.click_Attach_Create_Event_24();
		Thread.sleep(2000);
		this.verify_Books_Tab();
		this.click_Approvals_Tab();
		Thread.sleep(2000);
		this.verify_Approval_Item();
		this.click_Approvals_Item();
		Thread.sleep(1000);
		this.click_Done();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> switch_To_Attach_Approval_Event_24() -----------");
	}
	
	public void verify_Event_9_Approval_Attached() throws InterruptedException, AWTException {
		this.verify_Event_9_Title();
		this.click_Event_9_Title();
		Thread.sleep(2000);
		this.verify_Approvals_Heading();
		System.out.println("------- Completed --> verify_Event_9_Approval_Attached() -----------");
	}
	
	public void verify_Event_24_Approval_Attached() throws InterruptedException, AWTException {
		this.verify_Event_24_Title();
		this.click_Event_24_Title();
		Thread.sleep(1500);
		this.verify_Approvals_Heading();
		System.out.println("------- Completed --> verify_Event_9_Approval_Attached() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Approval_Attached() throws InterruptedException, AWTException {
		this.verify_Events_Menu();
		this.click_New_Event_Title();
		Thread.sleep(2000);
		this.verify_Approvals_Heading();
		System.out.println("------- Completed --> verify_Approval_Attached() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void Remove_Attached_Approval_On_Event() throws InterruptedException, AWTException {
		this.click_Approvals_X_Btn();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> Remove_Attached_Approval_On_Event() -----------");
	}
	
	
	// --------------Function Being Called ---------------------------
	
	public void verify_Approval_Removed() throws InterruptedException, AWTException {
		String approvals_Heading = "//h4[@class='heading-approvals']";
		String approvals_Message = "//li[starts-with (@id,'approval')][contains(text(),'Do you approve this item?')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(approvals_Heading)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(approvals_Message)).size() < 1);

		System.out.println("------- Completed --> verify_Approval_Removed() -----------");
	}
	
	// --------------verify_Poll/Survey/Book_Added_To_Event ---------------------------
	By poll_Btn_Event_4 = By.xpath("(//*[normalize-space(text())='Event 4']/following::a[@class='btn btn-default'][contains(text(),'Poll')])[1]");
	By poll_Btn_Event_12 = By.xpath("(//*[normalize-space(text())='Event 12']/following::a[@class='btn btn-default'][contains(text(),'Poll')])[1]");

	By attach_Create_Event_9 = By.xpath("(//*[normalize-space(text())='Event 9']/following::a[contains(text(),'Attach or Create')])[1]");
	By attach_Create_Event_10 = By.xpath("(//*[normalize-space(text())='Event 10']/following::a[contains(text(),'Attach or Create')])[1]");
	By attach_Create_Event_24 = By.xpath("(//*[normalize-space(text())='Event 24']/following::a[contains(text(),'Attach or Create')])[1]");

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
	By event_10_Resources_Btn = By.xpath("(//*[normalize-space(text())='Event 10']/following::a[@class='btn btn-default']//i[@class='fa fa-file'])[1]");


	public void verify_Resource_Tab() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(resource_Tab)));
	}
	
	public void verify_Auto_BE_Workroom() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Workroom)));
	}
	
	public void verify_Attach_Folder() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(autoBE_Workroom)));
	}
	
	public void verify_To_Attach_File() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(to_Attach_File)));
	}
	
	public void verify_To_Attach_Or_Create() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create)));
	}
	
	public void refresh_Verify_Event_10_Resources_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_10_Resources_Btn)));
	}
	
	By event_Title = By.xpath("(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By remove_Survey_20 = By.xpath("(//li[starts-with (@class,'survey-')]//a[contains(text(),'Survey 20')]/following::a)[1]");
	By remove_BookBtn= By.xpath("(//li[starts-with (@class,'book-')]//a[contains(text(),'This is a Book Title')]/following::a)[1]");
	By remove_Meeting_Book_5= By.xpath("(//li[starts-with (@class,'book-')]//a[contains(text(),'Meeting Book 5')]/following::a)[1]");

	By eventsMenu2 = By.xpath("//ul[@class='workroom-buttons no-mobile']//li[@class='active']//a");

	public void verify_Remove_Survey_20_Heading() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(remove_Survey_20)));
	}
	
	public void verify_Meeting_Book_5_Heading() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(remove_Meeting_Book_5)));
	}

	public void click_Event_4_Poll_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(poll_Btn_Event_4).click();
	}
	
	public void click_Event_12_Poll_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(poll_Btn_Event_12).click();
	}
	
	public void click_Book_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(book_Btn).click();
	}
	
	public void click_Survey_And_Polls_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_Polls_Btn).click();
	}
	
	public void click_Attach_Create() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create).click();
	}
	
	public void click_Attach_Create_Event_9() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_9).click();
	}
	
	public void click_Attach_Create_Event_10() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_10).click();
	}
	
	public void click_Attach_Create_Event_24() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_24).click();
	}
	
	public void click_Resource_Tab() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(resource_Tab).click();
	}
	
	public void click_AutoBE_Workroom() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(autoBE_Workroom).click();
	}
	
	public void click_Attach_Folder() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Folder).click();
	}
	
	public void click_To_Attach_File() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(to_Attach_File).click();
	}
	
	public void click_Done_Btn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(done_Btn).click();
	}

	
	public void click_Remove_Survey_20() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(remove_Survey_20).click();
	}
	
	public void click_Remove_Meeting_Book_5() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(remove_Meeting_Book_5).click();
	}
	
	public void click_Events_Menus2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(eventsMenu2).click();

	}
	
	public void verify_Event_5_Scheduler_Button_Displayed() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Event 5']/following::a[@class='btn btn-default'][contains(text(),'Scheduler')])[1]";

		WebElement scheduler = DriverFactory.getInstance().getDriver().findElement(By.xpath(element));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", scheduler);
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Event_6_Survey_Button_Displayed() throws InterruptedException {
		String element = "(//a[contains(text(),'Event 6')]/following::a[@class='btn btn-default'][contains(text(),'Survey')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Event_13_Survey_Button_Displayed() throws InterruptedException {
		String element = "(//a[contains(text(),'Event 13')]/following::a[@class='btn btn-default'][contains(text(),'Survey')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Event_26_Survey_Button_Displayed() throws InterruptedException {
		String element = "(//a[contains(text(),'Event 26')]/following::a[@class='btn btn-default'][contains(text(),'Survey')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Survey_And_Polls_Button_Displayed() throws InterruptedException {
		String element = "//div[@class='btn-group']/button[contains(.,' Surveys & Polls')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Survey_Button_NOT_Displayed() throws InterruptedException {
		String element = "//a[@class='btn btn-default'][contains(text(),'Survey')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Book_Button_Displayed() throws InterruptedException {
		String element = "//a[@class='btn btn-default'][contains(text(),'Book')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}

	public void verify_Survey_Button_NOT_Present() throws InterruptedException {
		String element = "(//li[starts-with (@class,'survey-')]//a[contains(text(),'This is a Survey')]/following::a)[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Book_Button_NOT_Present() throws InterruptedException {
		String element = "(//li[starts-with (@class,'book-')]//a[contains(text(),'This is a Book Title')]/following::a)[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Meeting_Book_5_Title_NOT_Present() throws InterruptedException {
		String element = "(//li[starts-with (@class,'book-')]//a[contains(text(),'Meeting Book 5')]/following::a)[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() < 1);
	}
	
	public void verify_Book_Added_To_Event_Staging_1() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Events();
		this.verify_Event_Title_On_Staging_1_Dropdown_Arrow();
		this.scroll_Book_Button_Event_Title_On_Staging_1();
		this.click_Book_Button_For_Event_Title_On_Staging_1();
		Thread.sleep(2000);// allow attached book to be shown
		obj.admin_Open_Workroom_AutoBE_Events();
		System.out.println("------- Completed --> verify_Book_Added_To_Event_Staging_1() -----------");
	}
	
	public void verify_Meeting_Book_3_Added_To_Event_On_Ozzie() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Events();
		this.verify_Event_11_Dropdown_Arrow();
		this.scroll_Event_11_Book_Button_On_Ozzie();
		this.verify_Book_Button_Displayed_For_Event_11_On_Ozzie();
		this.click_Book_Button_For_Event_11_On_Ozzie();
		Thread.sleep(1500);// allow attahced poll to be shown
		obj.admin_Open_Workroom_AutoBE_Events();
		System.out.println("------- Completed --> verify_Meeting_Book_3_Added_To_Event_On_Ozzie() -----------");
	}
	
	public void verify_Handbook_Added_To_Event_38() throws InterruptedException {
		this.verify_Event_38_Dropdown_Arrow();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		this.verify_Book_Button_Displayed_For_Event_38_On_Ozzie();
		this.click_Book_Button_For_Event_38_On_Ozzie();
		Thread.sleep(2000);// allow attached book to be shown
		this.verify_Hand_Book_Title_2();	
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_Constellation_Events();
		System.out.println("------- Completed --> verify_Handbook_Added_To_Event() -----------");
	}
	
	public void verify_Meeting_Book_5_Added_To_Event_25_On_Ozzie() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_Marvel_Events();
		this.verify_Event_25_Dropdown_Arrow();
		DriverFactory.getInstance().getDriver().navigate().refresh(); // need to refresh since running in parrallel
		this.verify_Book_Button_Displayed_For_Event_25_On_Ozzie();
		this.click_Book_Button_For_Event_25_On_Ozzie();
		Thread.sleep(1500);// allow inside book to be shown
		obj.admin_Open_Workroom_Marvel_Events();
		System.out.println("------- Completed --> verify_Meeting_Book_5_Added_To_Event_25_On_Ozzie() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Poll_Added_To_Event_On_Staging_2() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Events();
		this.verify_Event_Title_On_Staging_2_Dropdown_Arrow();
		this.scroll_Poll_Button_Event_Title_On_Staging_2();
		this.verify_Poll_Button_Displayed_For_Event_Title_On_Staging_2();
		this.click_Poll_For_Event_Title_On_Staging_2();
		Thread.sleep(1500);// allow attahced poll to be shown
		obj.admin_Open_Workroom_AutoBE_Events();
		System.out.println("------- Completed --> verify_Poll_Added_To_Event_On_Staging_2() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void verify_Survey_Added_To_Event_Title_On_Staging_3() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Events();
		this.verify_Event_Title_On_Staging_3_Dropdown_Arrow();
		this.scroll_Survey_Button_Event_Title_On_Staging_3();
		this.verify_Survey_Button_Event_Title_On_Staging_3();
		this.click_Survey_Button_Event_Title_On_Staging_3();
		Thread.sleep(1500);// allow attahced poll to be shown
		obj.admin_Open_Workroom_AutoBE_Events();
		System.out.println("------- Completed --> verify_Survey_Added_To_Event_Title_On_Staging_3() -----------");
	}
	
	public void verify_Poll_Added_To_Event_2() throws InterruptedException {
		this.verify_Event_Title_On_Staging_1_Dropdown_Arrow();
		this.verify_Poll_Button_Displayed_For_Event_Title_On_Staging_2();
		this.click_Event_4_Poll_Btn();
		Thread.sleep(2000);// allow attahced poll to be shown
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		System.out.println("------- Completed --> verify_Poll_Added_To_Event() -----------");
	}
	
	public void verify_Poll_Added_To_Event_4() throws InterruptedException {
		this.verify_Event_4_Dropdown_Arrow();
		this.verify_Poll_Button_Displayed_For_Event_4_On_Staging();
		this.click_Event_4_Poll_Btn();
		Thread.sleep(2000);// allow attahced poll to be shown
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		System.out.println("------- Completed --> verify_Poll_Added_To_Event_4() -----------");
	}
	
	public void verify_Poll_Added_To_Event_12() throws InterruptedException {
		this.click_Events_Menu();
		Thread.sleep(1000);// allow attahced poll to be shown
		this.verify_Event_12_Dropdown_Arrow();
		this.verify_Poll_Button_Displayed_For_Event_12_On_Ozzie();
		this.scroll_Event_12_Poll_Button_On_Ozzie();
		this.click_Event_12_Poll_Btn();
		Thread.sleep(2000);// allow attahced poll to be shown
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Events();
		System.out.println("------- Completed --> verify_Poll_Added_To_Event_12() -----------");
	}
	
	public void verify_Survey_Added_To_Event_6() throws InterruptedException {
		this.verify_Event_6_Dropdown_Arrow();
		this.verify_Event_6_Survey_Button_Displayed();
		this.click_Survey_Button_Event_6();
		Thread.sleep(2500);// allow attahced poll to be shown
		AtlasNavBar obj  = new AtlasNavBar();
		obj.workroom_Member_Open_Workroom_AutoBE();
		System.out.println("------- Completed --> verify_Survey_Added_To_Event_6() -----------");
	}
	
	public void verify_Survey_Added_To_Event_13() throws InterruptedException {
		this.click_Events_Menu();
		Thread.sleep(1000);
		this.verify_Event_13_Dropdown_Arrow();
		this.verify_Event_13_Survey_Button_Displayed();
		this.click_Survey_Button_Event_13();
		Thread.sleep(2500);// allow attahced poll to be shown
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Events();
		System.out.println("------- Completed --> verify_Survey_Added_To_Event_13() -----------");
	}
	
	public void verify_Survey_Added_To_Event_26() throws InterruptedException {
		this.click_Events_Menu();
		Thread.sleep(1000);
		this.verify_Event_26_Dropdown_Arrow();
		this.verify_Event_26_Survey_Button_Displayed();
		this.click_Survey_Button_Event_26();
		Thread.sleep(2500);// allow attahced poll to be shown
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Events();
		System.out.println("------- Completed --> verify_Survey_Added_To_Event_26() -----------");
	}
	
	public void verify_Poll_Added_To_Event_3rd_Card() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1000);
		this.verify_Event_Card3_Dropdown_Arrow_Scroll();
		this.verify_Poll_Button_Displayed_For_Event_Title_On_Staging_2();
		System.out.println("------- Completed --> verify_Poll_Added_To_Event_3rd_Card() -----------");
	}
	
	public void verify_Surveys_Added_To_Event_3rd_Card() throws InterruptedException {
		this.verify_Events_Menu();
		this.click_Events_Menu();
		Thread.sleep(1000);
		this.verify_Event_Card3_Dropdown_Arrow_Scroll();
		this.verify_Event_6_Survey_Button_Displayed();
		System.out.println("------- Completed --> verify_Surveys_Added_To_Event_3rd_Card() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void remove_Attached_Survey_From_Event_26() throws InterruptedException {
		this.click_Event_26_Title();
		Thread.sleep(2000);
		this.verify_Remove_Survey_20_Heading();
		this.click_Remove_Survey_20();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(2000);
		this.verify_Survey_Button_NOT_Present();
		System.out.println("------- Completed --> remove_Attached_Survey_From_Event_26() -----------");
	}
	
	public void open_Event_17_Verify_Responses() throws InterruptedException {
		this.click_Event_17_Title();
		Thread.sleep(1000);
		this.verify_Guest_List_And_Scroll();
		this.verify_AutoUser17_Virtualy_Attending();
		this.verify_AutoUser20_InPerson_Attending();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Event_17_Verify_Responses() -----------");
	}
	
	public void open_Event_18_Verify_Responses() throws InterruptedException {
		this.click_Event_18_Title();
		Thread.sleep(1000);
		this.verify_Guest_List_And_Scroll();
		this.verify_AutoUser21_Virtualy_Attending();
		Thread.sleep(1000);
		System.out.println("------- Completed --> open_Event_18_Verify_Responses() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	
	
	By handbook_Title = By.xpath("//h1[contains(text(),'This is a Handbook')]");
	By handbook_Title_2 = By.xpath("//a[contains(text(),'This is a Handbook')]");
	By handbook_Crumb = By.xpath("//a[contains(text(),'Handbooks')]");

	
	public void verify_Handbook_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Title)));
	}

	public void verify_Handbook_Title_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(handbook_Title_2)));
	}
	
	public void click_Handbook_Crumb() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(handbook_Crumb).click();
	}


	
	// --------------Function Being Called ---------------------------
	public void remove_Attached_Book_From_Event_25() throws InterruptedException {
		this.click_Event_25_Title();
		Thread.sleep(1500);
		this.verify_Meeting_Book_5_Heading();
		this.click_Remove_Meeting_Book_5();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(2000);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1500);
		this.verify_Meeting_Book_5_Title_NOT_Present();
		System.out.println("------- Completed --> remove_Attached_Book_From_Event_25() -----------");
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
	
	public void add_Resource_To_Event_10() throws InterruptedException {
		Thread.sleep(1500);
		this.click_Attach_Create_Event_10();
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
		Thread.sleep(2000);
		System.out.println("------- Completed --> add_Resource_To_Event_10() -----------");
	}
		
	// --------------User Can Delete Event ---------------------------
	By deleteBtn = By.xpath("//a[@class='btn btn-danger no-mobile'][contains(text(),'Delete')]");
	By continueBtn = By.xpath("//button[@class='btn commit btn-danger'][contains(text(),'Continue')]");
	By delete_Event_Message = By.xpath("//p[contains(text(),'Successfully deleted Event')]");
	By event_Dropdown_Arrow_Card_3 = By.xpath("(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[3]");
	By event_Copy_Dropdown_Arrow = By.xpath("(//a[contains(text(),'- Copy')]/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By delete_Option = By.xpath("//a[contains(text(),'Delete')]");
	By delete_Option_Card_3 = By.xpath("(//a[contains(text(),'Delete')])[3]");
	
	
	//---------------switch to creating poll----------------------------
	By attach_Create_Event_Title_On_Staging_1 = By.xpath("(//*[normalize-space(text())='Event Title On Staging 1']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");

	By attach_Create_Event_Title_On_Staging_2 = By.xpath("(//*[normalize-space(text())='Event Title On Staging 2']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");
	By attach_Create_Event_Title_On_Staging_3 = By.xpath("(//*[normalize-space(text())='Event Title On Staging 3']/following::a[@class='btn btn-primary no-mobile'][contains(text(),'Attach or Create')])[1]");
	
	By book_Button_Event_Title_On_Staging_1 = By.xpath("(//*[normalize-space(text())='Event Title On Staging 1']/following::a[@class='btn btn-default'][contains(text(),'Book')])[1]");
	By book_Button_On_Event_11_Ozzie = By.xpath("(//*[normalize-space(text())='Event 11']/following::a[@class='btn btn-default'][contains(text(),'Book')])[1]");
	By book_Button_On_Event_25_Ozzie = By.xpath("(//*[normalize-space(text())='Event 25']/following::a[@class='btn btn-default'][contains(text(),'Book')])[1]");
	By book_Button_On_Event_38_Ozzie = By.xpath("(//*[normalize-space(text())='Event 38']/following::a[@class='btn btn-default'][contains(text(),'Book')])[1]");

	By poll_Button_Event_Title_On_Staging_2 = By.xpath("(//*[normalize-space(text())='Event Title On Staging 2']/following::a[@class='btn btn-default'][contains(text(),'Poll')])[1]");
	
	By survey_Button_Event_Title_On_Staging_3 = By.xpath("(//*[normalize-space(text())='Event Title On Staging 3']/following::a[@class='btn btn-default'][contains(text(),'Survey')])[1]");
	By survey_Button_Event_6 = By.xpath("(//*[normalize-space(text())='Event 6']/following::a[@class='btn btn-default'][contains(text(),'Survey')])[1]");
	By survey_Button_Event_13 = By.xpath("(//*[normalize-space(text())='Event 13']/following::a[@class='btn btn-default'][contains(text(),'Survey')])[1]");
	By survey_Button_Event_26 = By.xpath("(//*[normalize-space(text())='Event 26']/following::a[@class='btn btn-default'][contains(text(),'Survey')])[1]");
	
	public void verify_Attach_Create_Event_Title_On_Staging_1() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Event_Title_On_Staging_1)));
	}
	
	public void verify_Attach_Create_Event_Title_On_Staging_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Event_Title_On_Staging_2)));
	}
	
	public void verify_Attach_Create_Event_Title_On_Staging_3() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(attach_Create_Event_Title_On_Staging_3)));
	}
	
	public void scroll_Attach_Create_Event_Title_On_Staging_3() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_Title_On_Staging_3);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
	}
	

	public void scroll_Attach_Create_Event_Title_On_Staging_2() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_Title_On_Staging_2);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
	}
	
	public void scroll_Attach_Create_Event_Title_On_Staging_1() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_Title_On_Staging_1);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
	}
	
	public void click_Attach_Create_Event_Title_On_Staging_3() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_Title_On_Staging_3).click();
	}
	
	public void click_Attach_Create_Event_Title_On_Staging_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_Title_On_Staging_2).click();
	}
	
	public void click_Attach_Create_Event_Title_On_Staging_1() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(attach_Create_Event_Title_On_Staging_1).click();
	}
	
	public void scroll_Poll_Button_Event_Title_On_Staging_2() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_Button_Event_Title_On_Staging_2);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void scroll_Book_Button_Event_Title_On_Staging_1() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(book_Button_Event_Title_On_Staging_1);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void scroll_Event_11_Book_Button_On_Ozzie() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(book_Button_On_Event_11_Ozzie);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void scroll_Event_12_Poll_Button_On_Ozzie() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(poll_Btn_Event_12);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Poll_Button_Displayed_For_Event_Title_On_Staging_2() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Event Title On Staging 2']/following::a[@class='btn btn-default'][contains(text(),'Poll')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Poll_Button_Displayed_For_Event_4_On_Staging() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Event 4']/following::a[@class='btn btn-default'][contains(text(),'Poll')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Poll_Button_Displayed_For_Event_12_On_Ozzie() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Event 12']/following::a[@class='btn btn-default'][contains(text(),'Poll')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Book_Button_Displayed_For_Event_11_On_Ozzie() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Event 11']/following::a[@class='btn btn-default'][contains(text(),'Book')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	public void verify_Book_Button_Displayed_For_Event_25_On_Ozzie() throws InterruptedException {
		String element1 = "(//*[normalize-space(text())='Event 25']/following::a[@class='btn btn-default'][contains(text(),'Book')])[1]";
		String element2 = "(//*[normalize-space(text())='Event 25']/following::a[@class='btn btn-default'][contains(text(),'Book')])[1]";

		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(element1));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element2)).size() > 0);
	}
	
	public void verify_Book_Button_Displayed_For_Event_38_On_Ozzie() throws InterruptedException {
		String element1 = "(//*[normalize-space(text())='Event 38']/following::a[@class='btn btn-default'][contains(text(),'Book')])[1]";

		WebElement element = DriverFactory.getInstance().getDriver().findElement(By.xpath(element1));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element1)).size() > 0);
	}
	
	public void click_Book_Button_For_Event_Title_On_Staging_1() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(book_Button_Event_Title_On_Staging_1).click();
	}
	
	public void click_Poll_For_Event_Title_On_Staging_2() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(poll_Button_Event_Title_On_Staging_2).click();
	}
	
	public void click_Book_Button_For_Event_11_On_Ozzie() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(book_Button_On_Event_11_Ozzie).click();
	}
	
	public void click_Book_Button_For_Event_25_On_Ozzie() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(book_Button_On_Event_25_Ozzie).click();
	}
	
	public void click_Book_Button_For_Event_38_On_Ozzie() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(book_Button_On_Event_38_Ozzie).click();
	}
	
	public void click_Survey_Button_Event_Title_On_Staging_3() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_Button_Event_Title_On_Staging_3).click();
	}
	
	public void click_Survey_Button_Event_6() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_Button_Event_6).click();
	}
	
	public void click_Survey_Button_Event_13() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_Button_Event_13).click();
	}
	
	public void click_Survey_Button_Event_26() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(survey_Button_Event_26).click();
	}
	
	public void verify_Survey_Button_Event_Title_On_Staging_3() throws InterruptedException {
		String element = "(//*[normalize-space(text())='Event Title On Staging 3']/following::a[@class='btn btn-default'][contains(text(),'Survey')])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(element)).size() > 0);
	}
	
	//---------------------------------
	By event_Dropdown_Arrow = By.xpath("(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]");

	By event_Title_On_Staging_1_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event Title On Staging 1']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_Title_On_Staging_1_Delete_Option = By.xpath("//*[normalize-space(text())='Event Title On Staging 1']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_Title_On_Staging_2_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event Title On Staging 2']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_Title_On_Staging_2_Delete_Option = By.xpath("//*[normalize-space(text())='Event Title On Staging 2']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");

	By event_Title_On_Staging_3_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event Title On Staging 3']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_Title_On_Staging_3_Delete_Option = By.xpath("//*[normalize-space(text())='Event Title On Staging 3']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_4_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 4']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_4_Delete_Option = By.xpath("//*[normalize-space(text())='Event 4']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_5_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 5']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_5_Delete_Option = By.xpath("//*[normalize-space(text())='Event 5']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_6_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 6']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_6_Delete_Option = By.xpath("//*[normalize-space(text())='Event 6']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_7_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 7']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_7_Delete_Option = By.xpath("//*[normalize-space(text())='Event 7']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_8_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 8']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_8_Delete_Option = By.xpath("//*[normalize-space(text())='Event 8']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	By event_8_Title = By.xpath("//*[normalize-space(text())='Event 8']");

	By event_9_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 9']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_9_Delete_Option = By.xpath("//*[normalize-space(text())='Event 9']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	By event_9_Title = By.xpath("//*[normalize-space(text())='Event 9']");

	By event_10_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 10']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_10_Delete_Option = By.xpath("//*[normalize-space(text())='Event 10']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_11_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 11']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_11_Delete_Option = By.xpath("//*[normalize-space(text())='Event 11']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_12_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 12']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_12_Delete_Option = By.xpath("//*[normalize-space(text())='Event 12']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_13_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 13']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_13_Delete_Option = By.xpath("//*[normalize-space(text())='Event 13']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_14_Title = By.xpath("//*[normalize-space(text())='Event 14']");
	By event_14_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 14']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_14_Delete_Option = By.xpath("//*[normalize-space(text())='Event 14']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_15_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 15']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_15_Copy_Option = By.xpath("//*[normalize-space(text())='Event 15']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Copy')]");

	By event_15_Delete_Option = By.xpath("//*[normalize-space(text())='Event 15']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_16_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 16']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_16_Delete_Option = By.xpath("//*[normalize-space(text())='Event 16']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_21_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 21']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_21_Delete_Option = By.xpath("//*[normalize-space(text())='Event 21']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_22_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 22']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_22_Delete_Option = By.xpath("//*[normalize-space(text())='Event 22']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_23_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 23']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_23_Delete_Option = By.xpath("//*[normalize-space(text())='Event 23']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_25_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 25']/following::div[@class='dropdown header-actions no-mobile'])[1]");

	By event_26_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 26']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_26_Delete_Option = By.xpath("//*[normalize-space(text())='Event 26']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_27_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 27']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_27_Delete_Option = By.xpath("//*[normalize-space(text())='Event 27']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_29_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 29']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_29_Delete_Option = By.xpath("//*[normalize-space(text())='Event 29']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_30_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 30']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_30_Delete_Option = By.xpath("//*[normalize-space(text())='Event 30']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_32_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 32']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_32_Delete_Option = By.xpath("//*[normalize-space(text())='Event 32']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_33_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 33']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_33_Delete_Option = By.xpath("//*[normalize-space(text())='Event 33']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	
	By event_34_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 34']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_34_Delete_Option = By.xpath("//*[normalize-space(text())='Event 34']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_35_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 35']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_35_Delete_Option = By.xpath("//*[normalize-space(text())='Event 35']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_36_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 36']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_36_Delete_Option = By.xpath("//*[normalize-space(text())='Event 36']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_37_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 37']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_37_Delete_Option = By.xpath("//*[normalize-space(text())='Event 37']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	By event_38_Dropdown_Arrow = By.xpath("(//*[normalize-space(text())='Event 38']/following::div[@class='dropdown header-actions no-mobile'])[1]");
	By event_38_Delete_Option = By.xpath("//*[normalize-space(text())='Event 38']/following::div[@class='dropdown header-actions no-mobile open']//child::a[contains(text(),'Delete')]");
	
	
	By event_17_Title = By.xpath("//*[normalize-space(text())='Event 17']");
	By event_18_Title = By.xpath("//*[normalize-space(text())='Event 18']");
	By event_24_Title = By.xpath("//*[normalize-space(text())='Event 24']");
	By event_25_Title = By.xpath("//*[normalize-space(text())='Event 25']");
	By event_26_Title = By.xpath("//*[normalize-space(text())='Event 26']");
	By event_28_Title = By.xpath("//*[normalize-space(text())='Event 28']");
	By event_31_Title = By.xpath("//*[normalize-space(text())='Event 31']");
	By hand_Book_Title_2 = By.xpath("//h1[contains(text(),'Hand Book 2')]");

	
	public void verify_Event_Title_On_Staging_1_Dropdown_Arrow() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title_On_Staging_1_Dropdown_Arrow)));
	}
	
	public void scroll_Survey_Button_Event_Title_On_Staging_3() throws InterruptedException {
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_3_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		WebElement element2 = DriverFactory.getInstance().getDriver().findElement(survey_Button_Event_Title_On_Staging_3);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(1000);
	}
	
	public void verify_Event_Title_On_Staging_2_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title_On_Staging_2_Dropdown_Arrow)));
	}
	
	public void verify_Event_Title_On_Staging_3_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title_On_Staging_3_Dropdown_Arrow)));
	}
	
	public void verify_Event_Title_On_Staging_1_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title_On_Staging_1_Delete_Option)));
	}
	
	public void verify_Event_Title_On_Staging_2_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title_On_Staging_2_Delete_Option)));
	}
	
	public void verify_Event_Title_On_Staging_3_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Title_On_Staging_3_Delete_Option)));
	}
	
	public void verify_Event_4_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_4_Dropdown_Arrow)));
	}
	
	public void verify_Event_4_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_4_Delete_Option)));
	}
	
	public void verify_Event_5_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_5_Dropdown_Arrow)));
	}
	
	public void verify_Event_5_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_5_Delete_Option)));
	}
	
	public void verify_Event_6_Dropdown_Arrow() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_6_Dropdown_Arrow)));
		
		
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_6_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
	}
	
	public void verify_Event_6_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_6_Delete_Option)));
	}
	
	public void verify_Event_7_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_7_Dropdown_Arrow)));
	}
	
	public void verify_Event_7_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_7_Delete_Option)));
	}
	
	public void verify_Event_8_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_8_Title)));
	}
	
	public void verify_Event_8_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_8_Dropdown_Arrow)));
	}
	
	public void verify_Event_8_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_8_Delete_Option)));
	}
	
	public void verify_Event_9_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_9_Title)));
	}
	
	public void verify_Event_9_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_9_Dropdown_Arrow)));
	}
	
	public void verify_Event_9_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_9_Delete_Option)));
	}
	
	public void verify_Event_10_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_10_Dropdown_Arrow)));
	}
	
	public void verify_Event_10_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_10_Delete_Option)));
	}
	
	public void verify_Event_11_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_11_Dropdown_Arrow)));
	}
	
	public void verify_Event_11_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_11_Delete_Option)));
	}
	
	public void verify_Event_12_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_12_Dropdown_Arrow)));
	}
	
	public void verify_Event_12_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_12_Delete_Option)));
	}
	
	public void verify_Event_13_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_13_Dropdown_Arrow)));
	}
	
	public void verify_Event_26_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_26_Dropdown_Arrow)));
	}
	
	public void verify_Event_13_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_13_Delete_Option)));
	}
	
	
	public void verify_Event_14_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_14_Title)));
	}
	
	public void verify_Event_14_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_14_Dropdown_Arrow)));
	}
	
	public void verify_Event_14_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_14_Delete_Option)));
	}
	
	public void verify_Event_15_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_15_Dropdown_Arrow)));
	}
	
	public void verify_Event_15_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_15_Delete_Option)));
	}
	
	public void verify_Event_16_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_16_Dropdown_Arrow)));
	}
	
	public void verify_Event_16_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_16_Delete_Option)));
	}
	
	public void verify_Event_21_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_21_Dropdown_Arrow)));
	}
	
	public void verify_Event_21_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_21_Delete_Option)));
	}
	
	public void verify_Event_22_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_22_Dropdown_Arrow)));
	}
	
	public void verify_Event_22_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_22_Delete_Option)));
	}
	
	public void verify_Event_23_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_23_Dropdown_Arrow)));
	}
	
	public void verify_Event_24_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_24_Title)));
	}
	
	public void verify_Event_23_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_23_Delete_Option)));
	}
	
	public void verify_Event_25_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_25_Dropdown_Arrow)));
	}
	
	public void verify_Event_27_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_27_Dropdown_Arrow)));
	}
	
	public void verify_Event_27_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_27_Delete_Option)));
	}
	
	public void verify_Event_28_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_28_Title)));
	}
	
	public void verify_Event_29_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_29_Dropdown_Arrow)));
	}
	
	public void verify_Event_29_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_29_Delete_Option)));
	}
	
	public void verify_Event_30_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_30_Dropdown_Arrow)));
	}
	
	public void verify_Event_30_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_30_Delete_Option)));
	}
	
	public void verify_Event_31_Title() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_31_Title)));
	}
	
	public void verify_Event_32_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_32_Dropdown_Arrow)));
	}
	
	public void verify_Event_32_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_32_Delete_Option)));
	}
	
	public void verify_Event_33_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_33_Dropdown_Arrow)));
	}
	
	public void verify_Event_33_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_33_Delete_Option)));
	}
	
	public void verify_Event_34_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_34_Dropdown_Arrow)));
	}
	
	public void verify_Event_34_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_34_Delete_Option)));
	}
	
	public void verify_Event_35_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_35_Dropdown_Arrow)));
	}
	
	public void verify_Event_35_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_35_Delete_Option)));
	}
	
	public void verify_Event_36_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_36_Dropdown_Arrow)));
	}
	
	public void verify_Event_36_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_36_Delete_Option)));
	}
	
	public void verify_Event_37_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_37_Dropdown_Arrow)));
	}
	
	public void verify_Event_37_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_37_Delete_Option)));
	}
	
	public void verify_Event_38_Dropdown_Arrow() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_38_Dropdown_Arrow)));
	}
	
	public void verify_Event_38_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(event_38_Delete_Option)));
	}
	
	public void verify_Hand_Book_Title_2() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(hand_Book_Title_2)));
	}
	
	
	public void click_Event_Title_On_Staging_1_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_1_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		
		DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_1_Dropdown_Arrow).click();
	}
	
	public void click_Event_Title_On_Staging_2_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_2_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_2_Dropdown_Arrow).click();
	}
	
	public void click_Event_Title_On_Staging_3_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_3_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_3_Dropdown_Arrow).click();
	}
	
	public void click_Event_4_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_4_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_4_Dropdown_Arrow).click();
	}
	
	public void click_Event_5_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_5_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_5_Dropdown_Arrow).click();
	}
	
	public void click_Event_6_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_6_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_6_Dropdown_Arrow).click();
	}
	
	public void click_Event_7_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_7_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_7_Dropdown_Arrow).click();
	}
	
	public void click_Event_8_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_8_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_8_Dropdown_Arrow).click();
	}
	
	public void click_Event_9_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_9_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_9_Dropdown_Arrow).click();
	}
	
	public void click_Event_10_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_10_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_10_Dropdown_Arrow).click();
	}
	
	public void click_Event_11_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_11_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_11_Dropdown_Arrow).click();
	}
	
	public void click_Event_12_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_12_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_12_Dropdown_Arrow).click();
	}
	
	public void click_Event_13_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_13_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_13_Dropdown_Arrow).click();
	}
	
	public void click_Event_14_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_14_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_14_Dropdown_Arrow).click();
	}
	
	public void click_Event_15_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_15_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_15_Dropdown_Arrow).click();
	}
	
	public void click_Event_16_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_16_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_16_Dropdown_Arrow).click();
	}
	
	public void click_Event_21_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_21_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_21_Dropdown_Arrow).click();
	}
	
	public void click_Event_22_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_22_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_22_Dropdown_Arrow).click();
	}
	
	public void click_Event_23_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_23_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_23_Dropdown_Arrow).click();
	}
	
	public void click_Event_27_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_27_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_27_Dropdown_Arrow).click();
	}
	
	public void click_Event_29_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_29_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_29_Dropdown_Arrow).click();
	}
	
	public void click_Event_30_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_30_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_30_Dropdown_Arrow).click();
	}
	
	public void click_Event_32_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_32_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_32_Dropdown_Arrow).click();
	}
	
	public void click_Event_33_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_33_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_33_Dropdown_Arrow).click();
	}
	
	public void click_Event_34_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_34_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_34_Dropdown_Arrow).click();
	}
	
	public void click_Event_35_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_35_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_35_Dropdown_Arrow).click();
	}
	
	public void click_Event_36_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_36_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_36_Dropdown_Arrow).click();
	}
	
	public void click_Event_37_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_37_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_37_Dropdown_Arrow).click();
	}
	
	public void click_Event_38_Dropdown_Arrow() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_38_Dropdown_Arrow);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().findElement(event_38_Dropdown_Arrow).click();
	}
	
	public void click_Event_Title_On_Staging_1_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_1_Delete_Option).click();
	}

	public void click_Event_Title_On_Staging_2_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_2_Delete_Option).click();
	}
	
	public void click_Event_Title_On_Staging_3_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_Title_On_Staging_3_Delete_Option).click();
	}
	
	public void click_Event_4_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_4_Delete_Option).click();
	}
	
	public void click_Event_5_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_5_Delete_Option).click();
	}
	
	public void click_Event_6_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_6_Delete_Option).click();
	}
	
	public void click_Event_7_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_7_Delete_Option).click();
	}
	
	public void click_Event_8_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_8_Delete_Option).click();
	}

	public void click_Event_9_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_9_Delete_Option).click();
	}
	
	public void click_Event_10_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_10_Delete_Option).click();
	}
	
	public void click_Event_11_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_11_Delete_Option).click();
	}
	
	public void click_Event_12_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_12_Delete_Option).click();
	}
	
	public void click_Event_13_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_13_Delete_Option).click();
	}
	
	public void click_Event_14_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_14_Delete_Option).click();
	}
	
	public void click_Event_15_Copy_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_15_Copy_Option).click();
	}
	
	public void click_Event_15_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_15_Delete_Option).click();
	}
	
	public void click_Event_16_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_16_Delete_Option).click();
	}
	
	public void click_Event_21_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_21_Delete_Option).click();
	}
	
	public void click_Event_22_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_22_Delete_Option).click();
	}
	
	public void click_Event_23_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_23_Delete_Option).click();
	}
	
	public void click_Event_27_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_27_Delete_Option).click();
	}
	
	public void click_Event_29_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_29_Delete_Option).click();
	}
	
	public void click_Event_30_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_30_Delete_Option).click();
	}
	
	public void click_Event_32_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_32_Delete_Option).click();
	}
	
	public void click_Event_33_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_33_Delete_Option).click();
	}
	
	public void click_Event_34_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_34_Delete_Option).click();
	}
	
	public void click_Event_35_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_35_Delete_Option).click();
	}
	
	public void click_Event_36_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_36_Delete_Option).click();
	}
	
	public void click_Event_37_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_37_Delete_Option).click();
	}
	
	public void click_Event_38_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_38_Delete_Option).click();
	}
	
	public void click_Event_8_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_8_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_8_Title).click();
	}
	
	public void click_Event_9_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_9_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_9_Title).click();
	}
	
	public void click_Event_14_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_14_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_14_Title).click();
	}
	
	public void click_Event_17_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_17_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_17_Title).click();
	}
	
	public void click_Event_18_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_18_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_18_Title).click();
	}
	
	public void click_Event_24_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_24_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_24_Title).click();
	}
	
	public void click_Event_25_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_25_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_25_Title).click();
	}
	
	public void click_Event_26_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_26_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_26_Title).click();
	}
	
	public void click_Event_28_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_28_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_28_Title).click();
	}
	
	public void click_Event_31_Title() throws InterruptedException {
		WebElement element = DriverFactory.getInstance().getDriver().findElement(event_31_Title);
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		
		DriverFactory.getInstance().getDriver().findElement(event_31_Title).click();
	}
	
	//---------------------------------

	
	public void verify_Event_Card3_Dropdown_Arrow_Scroll() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(event_Dropdown_Arrow_Card_3)));
		
		WebElement eventCard3 = DriverFactory.getInstance().getDriver().findElement(By.xpath("(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[3]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", eventCard3);
		Thread.sleep(2000);
	}
	
	public void verify_ContinueBtn() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(continueBtn)));
	}	
	

	public void click_DeleteBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(deleteBtn).click();
	}

	public void click_ContinueBtn() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(continueBtn).click();
	}

	public void verify_Delete_Option() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option)));
	}
	
	public void verify_Delete_Option_Card_3() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Option_Card_3)));
	}

	public void click_Event_Dropdown_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_Dropdown_Arrow).click();
	}

	public void click_3rd_Event_Card_Dropdown_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_Dropdown_Arrow_Card_3).click();
	}

	public void click_Event_Copy_Dropdown_Arrow() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(event_Copy_Dropdown_Arrow).click();
	}
	
	public void verify_Delete_Event_Message() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverFactory.getInstance().getDriver()).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(600))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.or(ExpectedConditions.elementToBeClickable(delete_Event_Message)));
	}
	
	public void verify_Event_Deleted() throws InterruptedException {
		String event = "(//a[contains(text(),'This is an Edited Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}

	public void verify_AutoUser17_Virtualy_Attending() throws InterruptedException {
		String user = "//*[contains(.,'Attending - Virtual')]/following::td/span[contains(.,'Auto User17')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user)).size() > 0);
	}
	
	public void verify_AutoUser20_InPerson_Attending() throws InterruptedException {
		String user = "//*[contains(.,'Attending - In Person')]/following::td/span[contains(.,'Auto User20')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user)).size() > 0);
	}
	
	public void verify_AutoUser21_Virtualy_Attending() throws InterruptedException {
		String user = "//*[contains(.,'Attending - Virtual')]/following::td/span[contains(.,'Auto User21')]";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(user)).size() > 0);
	}
	
	public void click_Delete_Option() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(delete_Option).click();
	}
	
	public void click_Delete_Option_Card_3() throws InterruptedException {
		DriverFactory.getInstance().getDriver().findElement(delete_Option_Card_3).click();
	}

	
	// --------------Function Being Called ---------------------------
	public void user_Delete_Print_Upcoming_Event() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_Title_On_Staging_1_Dropdown_Arrow();
		this.click_Event_Dropdown_Arrow();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(2000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> user_Delete_Print_Upcoming_Event() -----------");
	}
	
	public void delete_Event_Title_On_Staging_1() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_Title_On_Staging_1_Dropdown_Arrow();
		this.click_Event_Title_On_Staging_1_Dropdown_Arrow();
		this.verify_Event_Title_On_Staging_1_Delete_Option();
		this.click_Event_Title_On_Staging_1_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_Title_On_Staging_1() -----------");
	}
	
	public void delete_Event_Title_On_Staging_2() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_Title_On_Staging_2_Dropdown_Arrow();
		this.click_Event_Title_On_Staging_2_Dropdown_Arrow();
		this.verify_Event_Title_On_Staging_2_Delete_Option();
		this.click_Event_Title_On_Staging_2_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_Title_On_Staging_2() -----------");
	}
	

	public void delete_Event_Title_On_Staging_3() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_Title_On_Staging_3_Dropdown_Arrow();
		this.click_Event_Title_On_Staging_3_Dropdown_Arrow();
		this.verify_Event_Title_On_Staging_3_Delete_Option();
		this.click_Event_Title_On_Staging_3_Delete_Option();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_Title_On_Staging_2() -----------");
	}
	
	public void delete_Event_4_On_Staging() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_4_Dropdown_Arrow();
		this.click_Event_4_Dropdown_Arrow();
		this.verify_Event_4_Delete_Option();
		this.click_Event_4_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_Title_On_Staging_2() -----------");
	}
	
	public void delete_Event_5_On_Staging() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_5_Dropdown_Arrow();
		this.click_Event_5_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_5_Delete_Option();
		this.click_Event_5_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_5_On_Staging() -----------");
	}
	
	public void delete_Event_6_On_Staging() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_6_Dropdown_Arrow();
		this.click_Event_6_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_6_Delete_Option();
		this.click_Event_6_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_6_On_Staging() -----------");
	}
	
	public void delete_Event_7_On_Staging() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_7_Dropdown_Arrow();
		this.click_Event_7_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_7_Delete_Option();
		this.click_Event_7_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_6_On_Staging() -----------");
	}
	
	public void delete_Event_7_Verify_Deletion() throws InterruptedException {
		this.scroll_To_Delete();
		this.click_DeleteBtn();
		Thread.sleep(1500);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(3000);
		this.verify_Delete_Event_Message();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_Event_7_Deleted();
		System.out.println("------- Completed --> delete_Event_7_Verify_Deletion() -----------");
	}
	
	public void delete_Event_8() throws InterruptedException {
		//already inside of event card
		this.scroll_To_Delete();
		this.click_DeleteBtn();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_8() -----------");
	}
	
	public void delete_Event_9() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_9_Dropdown_Arrow();
		this.click_Event_9_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_9_Delete_Option();
		this.click_Event_9_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_9() -----------");
	}
	
	public void delete_Event_10() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_10_Dropdown_Arrow();
		this.click_Event_10_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_10_Delete_Option();
		this.click_Event_10_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_10() -----------");
	}
	
	public void delete_Event_11() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_11_Dropdown_Arrow();
		this.click_Event_11_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_11_Delete_Option();
		this.click_Event_11_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_11() -----------");
	}
	
	public void delete_Event_12() throws InterruptedException {
		Thread.sleep(1500);
		this.verify_Event_12_Dropdown_Arrow();
		this.click_Event_12_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_12_Delete_Option();
		this.click_Event_12_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_12() -----------");
	}
	
	public void delete_Event_13() throws InterruptedException {
		Thread.sleep(1000);
		this.verify_Event_13_Dropdown_Arrow();
		this.click_Event_13_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_13_Delete_Option();
		this.click_Event_13_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_13() -----------");
	}
	
	public void delete_Event_14() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoAttend_Events();
		this.verify_Event_14_Dropdown_Arrow();
		this.click_Event_14_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_14_Delete_Option();
		this.click_Event_14_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_14() -----------");
	}
	
	public void delete_Event_15() throws InterruptedException {
		this.verify_Event_15_Dropdown_Arrow();
		this.click_Event_15_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_15_Delete_Option();
		this.click_Event_15_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_14() -----------");
	}
	
	public void delete_Event_16() throws InterruptedException {
		this.verify_Event_16_Dropdown_Arrow();
		this.click_Event_16_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_16_Delete_Option();
		this.click_Event_16_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_14() -----------");
	}
	
	public void delete_Event_21() throws InterruptedException {
		this.verify_Event_21_Dropdown_Arrow();
		this.click_Event_21_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_21_Delete_Option();
		this.click_Event_21_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_21() -----------");
	}
	
	public void delete_Event_22() throws InterruptedException {
		this.verify_Event_22_Dropdown_Arrow();
		this.click_Event_22_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_22_Delete_Option();
		this.click_Event_22_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_22() -----------");
	}
	
	public void delete_Event_23() throws InterruptedException {
		this.verify_Event_23_Dropdown_Arrow();
		this.click_Event_23_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_23_Delete_Option();
		this.click_Event_23_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_23() -----------");
	}
	
	public void delete_Event_27() throws InterruptedException {
		this.verify_Event_27_Dropdown_Arrow();
		this.click_Event_27_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_27_Delete_Option();
		this.click_Event_27_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_27() -----------");
	}
	
	public void delete_Event_29() throws InterruptedException {
		this.verify_Event_29_Dropdown_Arrow();
		this.click_Event_29_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_29_Delete_Option();
		this.click_Event_29_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_29() -----------");
	}
	
	public void delete_Event_30() throws InterruptedException {
		this.verify_Event_30_Dropdown_Arrow();
		this.click_Event_30_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_30_Delete_Option();
		this.click_Event_30_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_30() -----------");
	}
	
	
	public void delete_Event_32() throws InterruptedException {
		this.verify_Event_32_Dropdown_Arrow();
		this.click_Event_32_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_32_Delete_Option();
		this.click_Event_32_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_30() -----------");
	}
	
	public void delete_Event_33() throws InterruptedException {
		this.verify_Event_33_Dropdown_Arrow();
		this.click_Event_33_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_33_Delete_Option();
		this.click_Event_33_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_30() -----------");
	}
	
	public void delete_Event_34() throws InterruptedException {
		this.verify_Event_34_Dropdown_Arrow();
		this.click_Event_34_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_34_Delete_Option();
		this.click_Event_34_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_34() -----------");
	}
	
	public void delete_Event_35() throws InterruptedException {
		this.verify_Event_35_Dropdown_Arrow();
		this.click_Event_35_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_35_Delete_Option();
		this.click_Event_35_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_35() -----------");
	}
	
	public void delete_Event_36() throws InterruptedException {
		this.verify_Event_36_Dropdown_Arrow();
		this.click_Event_36_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_36_Delete_Option();
		this.click_Event_36_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_36() -----------");
	}
	
	public void delete_Event_37() throws InterruptedException {
		this.verify_Event_37_Dropdown_Arrow();
		this.click_Event_37_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_37_Delete_Option();
		this.click_Event_37_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_37() -----------");
	}
	
	public void delete_Event_38() throws InterruptedException {
		this.verify_Event_38_Dropdown_Arrow();
		this.click_Event_38_Dropdown_Arrow();
		Thread.sleep(1000);
		this.verify_Event_38_Delete_Option();
		this.click_Event_38_Delete_Option();
		Thread.sleep(1000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		Thread.sleep(1500);
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		System.out.println("------- Completed --> delete_Event_38() -----------");
	}
	
	// --------------Function Being Called ---------------------------
	public void user_Delete_Go_To_Meeting_Event() throws InterruptedException {
		AtlasNavBar obj  = new AtlasNavBar();
		obj.admin_Open_Workroom_AutoBE_Events();
		this.verify_New_Event_Btn();
		this.verify_Event_Title_On_Staging_1_Dropdown_Arrow();
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
	
	// --------------Function Being Called ---------------------------
	public void user_Delete_Go_To_Meeting_Event_Copy() throws InterruptedException {
		this.verify_Event_Title_On_Staging_1_Dropdown_Arrow();
		this.click_Event_Copy_Dropdown_Arrow();
		this.verify_Delete_Option();
		this.click_Delete_Option();
		Thread.sleep(2000);
		this.verify_ContinueBtn();
		this.click_ContinueBtn();
		this.verify_Delete_Event_Message();
		System.out.println("------- Completed --> user_Delete_Go_To_Meeting_Event_Copy() -----------");
	}
	
	// --------------Delete_Event_While_In_Guest_List---------------------------
	public void scroll_To_Delete() throws InterruptedException {
		WebElement deleteBtn = DriverFactory.getInstance().getDriver().findElement(By.xpath("//a[@class='btn btn-danger no-mobile'][contains(text(),'Delete')]"));
		((JavascriptExecutor) DriverFactory.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
	}
	
	//----------verify deleted--------------
		
	public void verify_Event_Title_On_Staging_1_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event Title On Staging 1']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_Title_On_Staging_2_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event Title On Staging 2']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_Title_On_Staging_3_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event Title On Staging 3']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_3rd_Event_Deleted() throws InterruptedException {
		String event = "//h3//a[normalize-space(text())='This is a New Event Title']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_4_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 4']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_5_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 5']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_6_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 6']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_7_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 7']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_8_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 8']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_9_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 9']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_10_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 10']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_11_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 11']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_12_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 12']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_13_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 13']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_15_16_Deleted() throws InterruptedException {
		String event15 = "//*[normalize-space(text())='Event 15']/following::div[@class='dropdown header-actions no-mobile']";
		String event16 = "//*[normalize-space(text())='Event 16']/following::div[@class='dropdown header-actions no-mobile']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event15)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event16)).size() < 1);
	}
	
	public void verify_Event_17_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 17']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_18_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 18']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_19_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 19']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_20_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 20']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_21_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 21']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_22_23_Deleted() throws InterruptedException {
		String event22 = "//*[normalize-space(text())='Event 22']/following::div[@class='dropdown header-actions no-mobile']";
		String event23 = "//*[normalize-space(text())='Event 23']/following::div[@class='dropdown header-actions no-mobile']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event22)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event23)).size() < 1);
	}
	
	public void verify_Event_24_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 24']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_25_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 25']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_26_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 26']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_27_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 27']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_28_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 28']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_29_30_Deleted() throws InterruptedException {
		String event22 = "//*[normalize-space(text())='Event 29']/following::div[@class='dropdown header-actions no-mobile']";
		String event23 = "//*[normalize-space(text())='Event 30']/following::div[@class='dropdown header-actions no-mobile']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event22)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event23)).size() < 1);
	}
	
	public void verify_Event_31_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 31']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_32_33_Deleted() throws InterruptedException {
		String event22 = "//*[normalize-space(text())='Event 32']/following::div[@class='dropdown header-actions no-mobile']";
		String event23 = "//*[normalize-space(text())='Event 33']/following::div[@class='dropdown header-actions no-mobile']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event22)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event23)).size() < 1);
	}
	
	public void verify_Event_34_35_Deleted() throws InterruptedException {
		String event22 = "//*[normalize-space(text())='Event 34']/following::div[@class='dropdown header-actions no-mobile']";
		String event23 = "//*[normalize-space(text())='Event 35']/following::div[@class='dropdown header-actions no-mobile']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event22)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event23)).size() < 1);
	}
	
	public void verify_Event_36_37_Deleted() throws InterruptedException {
		String event22 = "//*[normalize-space(text())='Event 36']/following::div[@class='dropdown header-actions no-mobile']";
		String event23 = "//*[normalize-space(text())='Event 37']/following::div[@class='dropdown header-actions no-mobile']";

		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event22)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event23)).size() < 1);
	}
	
	public void verify_Event_38_Deleted() throws InterruptedException {
		String event = "//*[normalize-space(text())='Event 38']/following::div[@class='dropdown header-actions no-mobile']";
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
	}
	
	public void verify_Event_And_Copy_Deleted() throws InterruptedException {
		String event = "(//a[contains(text(),'This is a New Event Title')]/following::div[@class='dropdown header-actions no-mobile'])[1]";
		String event_Copy = "(//a[contains(text(),'- Copy')]/following::div[@class='dropdown header-actions no-mobile'])[1]";
		Thread.sleep(1500);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event)).size() < 1);
		Assert.assertTrue(DriverFactory.getInstance().getDriver().findElements(By.xpath(event_Copy)).size() < 1);
	}
	
	
	
	public void verify_3rd_Event_Card_Deleted() throws InterruptedException {
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(1000);
		this.verify_3rd_Event_Deleted();
		System.out.println("------- Completed --> verify_Go_To_Meeting_Event_Deleted() -----------");
	}
	
	public void verify_Go_To_Meeting_Event_Deleted() throws InterruptedException {
		DriverFactory.getInstance().getDriver().navigate().refresh();
		Thread.sleep(3000);
		this.verify_Event_Deleted();
		System.out.println("------- Completed --> verify_Go_To_Meeting_Event_Deleted() -----------");
	}
	
	
}
