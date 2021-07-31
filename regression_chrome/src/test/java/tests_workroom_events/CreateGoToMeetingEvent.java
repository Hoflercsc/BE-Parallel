package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.HomeNavigationPage;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class CreateGoToMeetingEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-GoTo-Meeting-Event");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}
	

	@Test(priority = 2, description = "user_Can_Open_Directory")
	public void user_Can_Open_Directory() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-GoTo-Meeting-Event");
	
		obj_navigation = new HomeNavigationPage(driver);
		obj_navigation.user_Can_Open_Directory();
	}
	
	@Test(priority = 3, description = "open_User_Profile")
	public void open_User_Profile() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-GoTo-Meeting-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.open_User_Profile();
	}
	
	@Test(priority = 4, description = "verify_G2M_Account_Connected")
	public void verify_G2M_Account_Connected() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-GoTo-Meeting-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_G2M_Account_Connected();
	}

	@Test(priority = 5, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-GoTo-Meeting-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Open_Events_for_Workroom();
	}

	@Test(priority = 6, description = "user_Can_Create_New_Event_GoTo_Meeting")
	public void user_Can_Create_New_Event_GoTo_Meeting() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-GoTo-Meeting-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_GoTo_Meeting();
	}
	
//	@Test(priority = 7, description = "user_Can_Join_GoTo_Meeting")
//	public void user_Can_Join_GoTo_Meeting() throws InterruptedException, AWTException {
//		test.assignCategory("Workroom-Events >> Create-GoTo-Meeting-Event");
//		
//		objectEvent = new EventPage(driver);
//		objectEvent.user_Can_Join_GoTo_Meeting();
//	}

	@Test(priority = 8, description = "user_Delete_Go_To_Meeting_Event")
	public void user_Delete_Go_To_Meeting_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-GoTo-Meeting-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Go_To_Meeting_Event();
	}
	
	@Test(priority = 9, description = "user_Delete_Go_To_Meeting_Event")
	public void verify_Go_To_Meeting_Event_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-GoTo-Meeting-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Go_To_Meeting_Event_Deleted();
	}
	
}