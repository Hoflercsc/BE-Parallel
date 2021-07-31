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
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class AttachPollToNewEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Open_Events_for_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "attach_And_Create_Poll")
	public void switch_To_Creating_Poll() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.switch_To_Creating_Poll();
	}

	@Test(priority = 6, description = "Scenario - Create Workroom Poll.")
	public void creating_Poll_For_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.creating_Poll_For_Event();
	}
	
	@Test(priority = 7, description = "Scenario - Create Workroom Poll Question.")
	public void create_Poll_Question() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.create_Poll_Question();
	}

	@Test(priority = 8, description = "Scenario - Add Workroom Poll Respondents.")
	public void add_Poll_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.manageRespondents();
	}

	@Test(priority = 9, description = "Scenario - Build Poll and Make Visible.")
	public void build_Poll_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.build_Poll_Make_Visible();
	}
	
	@Test(priority = 10, description = "verify_Poll_Added_To_Event")
	public void verify_Poll_Added_To_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Poll_Added_To_Event();
	}

	@Test(priority = 11, description = "user_Can_Delete_Event_With_Poll")
	public void user_Can_Delete_Event_With_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Go_To_Meeting_Event();
	}
	
	@Test(priority = 12, description = "user_navigates_To_Poll")
	public void user_navigates_To_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.user_navigates_To_Poll();
	}
	
	@Test(priority = 13, description = "delete_Poll")
	public void delete_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.delete_Poll();
	}
	
	@Test(priority = 14, description = "verify_Poll_Deletion")
	public void verify_Poll_Deletion() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Poll-New-Event");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.verify_Poll_Deletion();
	}
}