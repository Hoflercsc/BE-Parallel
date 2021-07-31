package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class CreateEventWithMicorsoftTeamsURL extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_With_Custom_VC_URL")
	public void user_Can_Create_New_Event_With_Custom_VC_URL() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_With_MS_Teams_URL();
	}
	
	@Test(priority = 4, description = "user_Can_Join_Microsoft_Teams_Meeting")
	public void user_Can_Join_Microsoft_Teams_Meeting() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Join_Microsoft_Teams_Meeting();
	}

	@Test(priority = 5, description = "user_Delete_Go_To_Meeting_Event")
	public void user_Delete_Go_To_Meeting_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Go_To_Meeting_Event();
	}
	
	@Test(priority = 6, description = "user_Delete_Go_To_Meeting_Event")
	public void verify_Go_To_Meeting_Event_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Custom-Video-Conference-URL");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Go_To_Meeting_Event_Deleted();
	}
	
}