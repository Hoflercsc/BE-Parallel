package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_workroom_events.EventPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class AttachAnApprovalToEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event9);
	}

	@Test(priority = 4, description = "user_Click_Event_9_Accept_As_Response")
	public void user_Click_Event_9_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Click_Event_9_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "switch_To_Attach_Approval_Event_9")
	public void switch_To_Attach_Approval_Event_9() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.switch_To_Attach_Approval_Event_9();
	}

	@Test(priority = 6, description = "verify_Event_9_Approval_Attached")
	public void verify_Event_9_Approval_Attached() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_9_Approval_Attached();
	}

	@Test(priority = 7, description = "navigate_Back_To_Events")
	public void navigate_Back_To_Events() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}
	
	@Test(priority = 8, description = "delete_Event_9")
	public void delete_Event_9() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_9();
	}
	
	@Test(priority = 9, description = "verify_Event_9_Deleted")
	public void verify_Event_9_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_9_Deleted();
	}
	
}
