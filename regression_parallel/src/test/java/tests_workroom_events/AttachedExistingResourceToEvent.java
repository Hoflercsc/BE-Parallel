package tests_workroom_events;

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
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class AttachedExistingResourceToEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event10);
	}

	@Test(priority = 4, description = "user_Click_Event_10_Accept_As_Response")
	public void user_Click_Event_10_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Click_Event_10_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "add_Resource_To_Event_10")
	public void add_Resource_To_Event_10() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.add_Resource_To_Event_10();
	}
	
	@Test(priority = 6, description = "verify_Event_10_Resource_Button_Appears")
	public void verify_Event_10_Resource_Button_Appears() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.refresh_Verify_Event_10_Resources_Btn();
	}
	
	@Test(priority = 7, description = "delete_Event_10")
	public void delete_Event_10() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_10();
	}
	
	@Test(priority = 8, description = "verify_Event_10_Deleted")
	public void verify_Event_10_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_10_Deleted();
	}
	
	
}