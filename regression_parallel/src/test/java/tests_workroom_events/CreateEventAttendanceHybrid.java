package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class CreateEventAttendanceHybrid extends BaseTestWorkroomEvents {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect_JHofler_Staging() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objBELogin = new LoginLogoutPage();
		//objBELogin.login_BE(systemAdmin, password); // autoUser Login
		objBELogin.login_BE(automationTester, password); // autoUser Login

	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_17_Hybrid")
	public void user_Can_Create_New_Event_17_Hybrid() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_17_Hybrid(event17);
	}
		
	@Test(priority = 4, description = "workroomAdmin_Can_Logout")
	public void workroomAdmin_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 5, description = "autoUser17r_Login_To_BoardEffect")
	public void autoUser17_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser17,password);
	}

	@Test(priority = 6, description = "user_Event_17_Response_Vitual")
	public void user_Event_17_Response_Vitual() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objectEvent = new EventPage();
		objectEvent.user_Event_17_Response_Vitual();
	}
	//-----start here

	@Test(priority = 7, description = "AutoDirector_Can_Logout.")
	public void autoDirector_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 8, description = "autoUser20_Login_Again")
	public void autoUser20_Login_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser20, password); // autoUser Login
	}
	
	@Test(priority = 9, description = "user_Event_17_Response_InPerson")
	public void user_Event_17_Response_InPerson() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objectEvent = new EventPage();
		objectEvent.user_Event_17_Response_InPerson();
	}
	
	@Test(priority = 10, description = "testReset_Logout")
	public void testReset_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_Login_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}
	
	@Test(priority = 12, description = "admin_Open_Workroom_AutoAttend_Events")
	public void admin_Open_Workroom_AutoAttend_Events() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Events();
	}
	
	@Test(priority = 13, description = "open_Event_17_Verify_Responses")
	public void open_Event_17_Verify_Responses() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objectEvent = new EventPage();
		objectEvent.open_Event_17_Verify_Responses();
	}
	
	@Test(priority = 14, description = "delete_Event_17")
	public void delete_Event_17() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_8();
	}
	
	@Test(priority = 15, description = "verify_Event_Deleted")
	public void verify_Event_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Hybrid");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_17_Deleted();
	}
	
}