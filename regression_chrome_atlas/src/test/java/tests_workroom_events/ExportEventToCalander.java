package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class ExportEventToCalander extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event_RSVPS() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS_2();
	}
	
	@Test(priority = 4, description = "user_Can_View_Upcoming_Events_Expanded_View")
	public void export_Event_To_Calendar() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objectEvent = new EventPage(driver);
		objectEvent.export_Event_To_Calendar();
	}

	@Test(priority = 5, description = "user_Delete_Upcoming_Event_1")
	public void user_Delete_Upcoming_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Print_Upcoming_Event();
	}
	
	@Test(priority = 6, description = "verify_Both_Events_Deleted")
	public void verify_Event_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Event_Deleted();
	}
	
}