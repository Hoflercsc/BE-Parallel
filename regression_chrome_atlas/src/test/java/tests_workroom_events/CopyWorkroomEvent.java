package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class CopyWorkroomEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_With_Custom_VC_URL")
	public void user_Can_Create_New_Event_With_Custom_VC_URL() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_With_Custom_VC_URL();
	}
	
	@Test(priority = 4, description = "user_Can_Join_Custom_Meeting")
	public void user_Can_Join_Custom_Meeting() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Copy_Workroom_Event();
	}

	@Test(priority = 5, description = "user_Delete_Go_To_Meeting_Event")
	public void user_Delete_Go_To_Meeting_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Go_To_Meeting_Event();
		driver.navigate().refresh();
		driver.navigate().refresh();
	}
	
	@Test(priority = 6, description = "user_Delete_Go_To_Meeting_Event_Copy")
	public void user_Delete_Go_To_Meeting_Event_Copy() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Go_To_Meeting_Event_Copy();
		driver.navigate().refresh();
		driver.navigate().refresh();
	}
	
	@Test(priority = 7, description = "verify_Event_And_Copy_Deleted")
	public void verify_Event_And_Copy_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Copy-Workroom-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Event_And_Copy_Deleted();
	}
	
}