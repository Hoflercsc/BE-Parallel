package tests_workroom_events;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;
import java.awt.AWTException;

public class CreateEventAttendanceVirtual extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Virtual");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Virtual");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_Virtual")
	public void user_Can_Create_New_Event_With_Custom_VC_URL() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Virtual");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_Virtual();
	}
		
	@Test(priority = 4, description = "workroomAdmin_Can_Logout")
	public void workroomAdmin_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 5, description = "workroomAdmin_Can_Logout")
	public void autoDirector_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector,password);
	}

	@Test(priority = 6, description = "autoDirector_Response_Accept")
	public void autoDirector_Response_Accept() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objectEvent = new EventPage(driver);
		objectEvent.autoDirector_Response_Vitual();
	}

	@Test(priority = 7, description = "AutoDirector_Can_Logout.")
	public void autoDirector_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 8, description = "systemAdmin_Login_Again")
	public void systemAdmin_Login_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Virtual");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password); // autoUser Login
	}
	
	@Test(priority = 9, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Virtual");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}
	
	@Test(priority = 10, description = "verify_User_Response_To_Virtual_Event")
	public void verify_User_Response_To_Virtual_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Virtual");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_User_Response_To_Virtual_Event();
	}
	
	@Test(priority = 11, description = "user_Can_Delete_Event_")
	public void user_Can_Delete_Event_And_Verify_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Virtual");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Print_Upcoming_Event();
	}
	
	@Test(priority = 12, description = "verify_Event_Deleted")
	public void verify_Event_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Create-Event-Attendance-Virtual");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Event_Deleted_2();
	}
	
}