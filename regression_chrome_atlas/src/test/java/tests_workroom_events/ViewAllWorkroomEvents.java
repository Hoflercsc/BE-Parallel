package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class ViewAllWorkroomEvents extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event_RSVPS() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS_2();
	}
	
	@Test(priority = 4, description = "user_Can_Create_New_Event_RSVPS_2")
	public void user_Can_Create_New_Event_RSVPS_2() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS_2();
	}
	
	@Test(priority = 5, description = "user_Can_View_All_Workroom_Events")
	public void user_Can_View_All_Workroom_Events() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_View_All_Workroom_Events();
	}

	@Test(priority = 6, description = "user_Delete_Upcoming_Event_1")
	public void user_Delete_Upcoming_Event_1() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Print_Upcoming_Event();
	}
	
	@Test(priority = 7, description = "user_Delete_Upcoming_Event_2")
	public void user_Delete_Upcoming_Event_2() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Print_Upcoming_Event();
	}
	
	@Test(priority = 8, description = "verify_Both_Events_Deleted")
	public void verify_Both_Events_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-All-Workroom-Events");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Event_Deleted();
	}
	
}