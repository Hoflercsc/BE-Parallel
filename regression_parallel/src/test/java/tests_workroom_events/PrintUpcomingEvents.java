package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class PrintUpcomingEvents extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Print-Upcoming-Events");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Print-Upcoming-Events");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event_22() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Print-Upcoming-Events");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS_2(event22);
	}
	
	@Test(priority = 4, description = "user_Can_Create_New_Event_RSVPS_2")
	public void user_Can_Create_New_Event_23() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Print-Upcoming-Events");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS_2(event23);
	}
	
	@Test(priority = 5, description = "user_Can_Print_Upcoming_Events")
	public void print_Upcoming_Events() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Print-Upcoming-Events");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Print_Upcoming_Events();
	}

	@Test(priority = 6, description = "delete_Event_22")
	public void delete_Event_22() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Print-Upcoming-Events");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_22();
	}
	
	@Test(priority = 7, description = "delete_Event_23")
	public void delete_Event_23() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Print-Upcoming-Events");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_23();
	}
	
	@Test(priority = 8, description = "verify_Both_Events_Deleted")
	public void verify_Event_22_23_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Print-Upcoming-Events");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_22_23_Deleted();
	}
	
}