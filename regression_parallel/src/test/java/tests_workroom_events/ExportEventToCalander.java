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
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event_RSVPS() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS_2(event21);
	}
	
	@Test(priority = 4, description = "export_Event_21_To_Calendar")
	public void export_Event_21_To_Calendar() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objectEvent = new EventPage();
		objectEvent.export_Event_21_To_Calendar();
	}

	@Test(priority = 5, description = "delete_Event_21")
	public void delete_Event_21() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_21();
	}
	
	@Test(priority = 6, description = "verify_Event_21_Deleted")
	public void verify_Event_21_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Export-Event-To-Calander");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_21_Deleted();
	}
	
}