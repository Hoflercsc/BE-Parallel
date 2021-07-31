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
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import page_workroom_events.EventPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AttachCreateNewPolltoEventExistingSiteData extends BaseTestBoardMemberAccess {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.create_New_Event_On_JH_Staging_1(eventTitleStaging2);
	}
	
	@Test(priority = 5, description = "switch_To_Creating_Poll")
	public void switch_To_Creating_Poll() throws InterruptedException, AWTException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.switch_To_Creating_Poll_For_Event_Title_On_Staging_2();
	}

	@Test(priority = 6, description = "creating_Poll_For_Event")
	public void creating_Poll_For_Event() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.creating_Poll_For_Event(pollTitleStaging1);
	}
	
	@Test(priority = 7, description = "Scenario - Create Workroom Poll Question.")
	public void create_Poll_Question() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll_Question();
	}

	@Test(priority = 8, description = "add_Poll_Respondents")
	public void add_Poll_Respondents() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");

		objCreateSurvey = new SurveyPage();
		objCreateSurvey.manage_Respondents_C();
	}

	@Test(priority = 9, description = "Scenario - Build Poll and Make Visible.")
	public void build_Poll_Make_Visible() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.build_Poll_Make_Visible_On_Staging_1();
	}
	
	@Test(priority = 10, description = "verify_Poll_Added_To_Event_On_Staging_2")
	public void verify_Poll_Added_To_Event_On_Staging_2() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Poll_Added_To_Event_On_Staging_2();
	}

	@Test(priority = 11, description = "delete_Event_Title_On_Staging_2")
	public void delete_Event_Title_On_Staging_2() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_Title_On_Staging_2();
	}
	
	@Test(priority = 12, description = "verify_Event_Title_On_Staging_2_Deleted")
	public void verify_Event_Title_On_Staging_2_Deleted() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_Title_On_Staging_2_Deleted();
	}
	
	@Test(priority = 13, description = "user_navigates_To_Poll")
	public void user_navigates_To_Poll() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.user_navigates_To_Poll();
	}
	
	@Test(priority = 14, description = "delete_Poll_On_Staging_Board_Member_Access_1")
	public void delete_Poll_On_Staging_Board_Member_Access_1() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.delete_Poll_On_Staging_Board_Member_Access_1();
	}
	
	@Test(priority = 15, description = "verify_Poll_Board_Member_Access_1_NOT_EXIST")
	public void verify_Poll_Board_Member_Access_1_NOT_EXIST() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Poll-To-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.verify_Poll_Board_Member_Access_1_NOT_EXIST();
	}
}