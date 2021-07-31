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
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "switch_To_Attach_Approval")
	public void switch_To_Attach_Approval() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.switch_To_Attach_Approval();
	}

	@Test(priority = 6, description = "verify_Approval_Attached")
	public void verify_Approval_Attached() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Approval_Attached();
	}

	@Test(priority = 7, description = "user_Can_Delete_Event_With_Approval")
	public void user_Can_Delete_Event_With_Approval() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Go_To_Meeting_Event();
	}
	
	@Test(priority = 8, description = "verify_Go_To_Meeting_Event_Deleted")
	public void verify_Go_To_Meeting_Event_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Attach-An-Approval-To-Event");
		
		objBook = new BookPage(driver);
		objBook.verify_Book_Deleted();
	}
	

}
