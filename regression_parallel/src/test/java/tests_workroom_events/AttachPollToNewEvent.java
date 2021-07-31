package tests_workroom_events;

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
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class AttachPollToNewEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event12);
	}

	@Test(priority = 4, description = "user_Click_Event_12_Accept_As_Response")
	public void user_Click_Event_12_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Click_Event_12_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "switch_To_Creating_Poll_On_Event_12")
	public void switch_To_Creating_Poll_On_Event_12() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage();
		objectEvent.switch_To_Creating_Poll_On_Event_12();
	}

	@Test(priority = 6, description = "Scenario - Create Workroom Poll.")
	public void creating_Poll_For_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.creating_Poll_For_Event(poll7);
	}
	
	@Test(priority = 7, description = "Scenario - Create Workroom Poll Question.")
	public void create_Poll_Question() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll_Question();
	}

	@Test(priority = 8, description = "Scenario - Add Workroom Poll Respondents.")
	public void add_Poll_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.manageRespondents();
	}

	@Test(priority = 9, description = "Scenario - Build Poll and Make Visible.")
	public void build_Poll_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.build_Poll_Make_Visible();
	}
	
	@Test(priority = 10, description = "verify_Poll_Added_To_Event_12")
	public void verify_Poll_Added_To_Event_12() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Poll_Added_To_Event_12();
	}

	@Test(priority = 11, description = "delete_Event_12")
	public void delete_Event_12() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_12();
		objectEvent.verify_Event_12_Deleted();
	}
	
	@Test(priority = 12, description = "user_navigates_To_Poll")
	public void user_navigates_To_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.user_navigates_To_Poll();
	}
	
	@Test(priority = 13, description = "delete_Poll_7")
	public void delete_Poll_7() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.delete_Poll_7();
	}
	
	@Test(priority = 14, description = "verify_Poll_7_NOT_EXIST")
	public void verify_Poll_7_NOT_EXIST() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage();
		objCreatePoll.verify_Poll_7_NOT_EXIST();
	}
}