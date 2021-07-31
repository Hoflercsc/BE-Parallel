package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_workroom_events.EventPage;
import page_workroom_library.BookPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class RemoveAnAttachedApprovalOnEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event24);
	}

	@Test(priority = 4, description = "user_Click_Event_24_Accept_As_Response")
	public void user_Click_Event_24_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Click_Event_24_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "switch_To_Attach_Approval_Event_24")
	public void switch_To_Attach_Approval_Event_24() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objectEvent = new EventPage();
		objectEvent.switch_To_Attach_Approval_Event_24();
	}

	@Test(priority = 6, description = "verify_Event_24_Approval_Attached")
	public void verify_Event_24_Approval_Attached() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_24_Approval_Attached();
	}
	
	@Test(priority = 7, description = "Remove_Attached_Approval_On_Event")
	public void Remove_Attached_Approval_On_Event() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objectEvent = new EventPage();
		objectEvent.Remove_Attached_Approval_On_Event();
	}
	
	@Test(priority = 8, description = "verify_Attached_Approval_Removed")
	public void verify_Attached_Approval_Removed() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Approval_Removed();
	}

	@Test(priority = 9, description = "delete_Event_24")
	public void delete_Event_24() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_8();
	}
	
	@Test(priority = 10, description = "verify_Event_24_Deleted")
	public void verify_Event_24_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-An-Attach-Approval-On-Event");
		
		objBook = new BookPage();
		objectEvent.verify_Event_24_Deleted();
	}
	

}
