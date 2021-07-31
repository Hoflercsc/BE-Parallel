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
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "add_Resource_To_Event")
	public void add_Resource_To_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.add_Resource_To_Event();
	}
	
	@Test(priority = 6, description = "verify_Resource_Button_Appears")
	public void verify_Resource_Button_Appears() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.refresh_Verify_Event_Resources_Btn();
	}
	
	@Test(priority = 7, description = "user_Delete_Print_Upcoming_Event_2")
	public void delete_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Print_Upcoming_Event();
	}
	
	@Test(priority = 8, description = "user_Delete_Print_Upcoming_Event_2")
	public void verify_Event_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-Existing-Resource-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Event_Deleted();
	}
	
	
}