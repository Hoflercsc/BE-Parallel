package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class CopyWorkroomEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event_RSVPS() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event15);
	}
	
	@Test(priority = 4, description = "user_Can_Copy_Workroom_Event_15")
	public void user_Can_Copy_Workroom_Event_15() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Copy_Workroom_Event_15(event16);
	}
	
	@Test(priority = 5, description = "user_Can_Open_Events_for_Workroom_Again")
	public void user_Can_Open_Events_for_Workroom_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Events();
	}
	
	@Test(priority = 6, description = "user_Delete_Go_To_Meeting_Event_Copy")
	public void delete_Event_15() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_15();
	}
	
	@Test(priority = 6, description = "delete_Event_16")
	public void delete_Event_16() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_16();
	}
	
	@Test(priority = 7, description = "verify_Event_15_16_Deleted")
	public void verify_Event_15_16_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_15_16_Deleted();
	}
	
}