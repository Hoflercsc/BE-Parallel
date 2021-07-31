package tests_boardmember_access;

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
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class AttachCreateNewPolltoEventExistingSiteData extends BaseTestBoardMemberAccess {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Open_Events_for_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}
	
	@Test(priority = 5, description = "switch_To_Creating_Poll")
	public void switch_To_Creating_Poll() throws InterruptedException, AWTException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.switch_To_Creating_Poll();
	}

	@Test(priority = 6, description = "Scenario - Create Workroom Poll.")
	public void creating_Poll_For_Event() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.creating_Poll_For_Event();
	}
	
	@Test(priority = 7, description = "Scenario - Create Workroom Poll Question.")
	public void create_Poll_Question() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.create_Poll_Question();
	}

	@Test(priority = 8, description = "add_Poll_Respondents")
	public void add_Poll_Respondents() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");

		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.manage_Respondents_C();
	}

	@Test(priority = 9, description = "Scenario - Build Poll and Make Visible.")
	public void build_Poll_Make_Visible() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.build_Poll_Make_Visible();
	}
	
	@Test(priority = 10, description = "verify_Poll_Added_To_Event")
	public void verify_Poll_Added_To_Event() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Poll_Added_To_Event();
	}

	@Test(priority = 11, description = "user_Delete_Print_Upcoming_Event")
	public void user_Delete_Print_Upcoming_Event() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Print_Upcoming_Event();
	}
	
	@Test(priority = 12, description = "verify_Event_Deleted_2")
	public void verify_Event_Deleted_2() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Event_Deleted_2();
	}
	
	@Test(priority = 13, description = "user_navigates_To_Poll")
	public void user_navigates_To_Poll() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.user_navigates_To_Poll();
	}
	
	@Test(priority = 14, description = "delete_Poll")
	public void delete_Poll() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.delete_Poll();
	}
	
	@Test(priority = 15, description = "verify_Poll_Deletion")
	public void verify_Poll_Deletion() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.verify_Poll_NOT_Exist_By_Value();
	}
}