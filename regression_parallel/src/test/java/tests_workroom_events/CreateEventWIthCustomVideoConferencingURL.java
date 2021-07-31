package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class CreateEventWIthCustomVideoConferencingURL extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_With_Custom_VC_URL")
	public void user_Can_Create_New_Event_With_Custom_VC_URL() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_With_Custom_VC_URL(event19);
	}
	
	@Test(priority = 4, description = "user_Can_Join_Custom_Meeting")
	public void user_Can_Join_Custom_Meeting() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Join_Custom_Meeting();
	}

	@Test(priority = 5, description = "delete_Event_19")
	public void delete_Event_19() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_8();
	}
	
	@Test(priority = 6, description = "verify_Event_19_Deleted")
	public void verify_Event_19_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_19_Deleted();
	}
	
}