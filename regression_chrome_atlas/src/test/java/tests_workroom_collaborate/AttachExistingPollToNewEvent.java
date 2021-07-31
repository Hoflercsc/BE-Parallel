package tests_workroom_collaborate;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class AttachExistingPollToNewEvent extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Existing-Poll-To-Event");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "autoUser_login")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Existing-Poll-To-Event");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Existing-Poll-To-Event");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Existing-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Existing-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}
	
	//---start here
	@Test(priority = 5, description = "switch_To_Attach_Poll")
	public void switch_To_Attach_Poll() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Collaborate >> Attach-Existing-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.switch_To_Attach_Poll();
	}
	
	@Test(priority = 6, description = "verify_Poll_Added_To_Event_2")
	public void verify_Poll_Added_To_Event_2() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Existing-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Poll_Added_To_Event_2();
	}

	@Test(priority = 7, description = "user_Can_Delete_Event_With_Survey")
	public void delete_Event() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Existing-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Print_Upcoming_Event();
	}
	
	@Test(priority = 8, description = "verify_Event_Deleted")
	public void verify_Event_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Existing-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Event_Deleted_2();
	}
	
	
	
}