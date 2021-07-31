package tests_workroom_events;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class TakeEventAttendance extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event28);
	}

	@Test(priority = 5, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 6, description = "workroom_Admin_Login_To_BoardEffect")
	public void workroomAdmin_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser4,password);
	}
	
	@Test(priority = 7, description = "workroom_Member_Open_Workroom_AutoAttend_Events")
	public void user_Open_Workroom_AutoAttend_Events() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Workroom_AutoAttend_Events();
	}

	@Test(priority = 8, description = "user_Response_Accept_Event_28")
	public void user_Response_Accept_Event_28() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objectEvent = new EventPage();
		objectEvent.user_Click_Event_28_Accept_As_Response();
	}

	@Test(priority = 9, description = "workroomAdmin_Can_Logout")
	public void workroomAdmin_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 10, description = "autoUser5_Login_To_BoardEffect")
	public void autoUser5_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser25,password);
	}
	
	@Test(priority = 11, description = "user_Open_Workroom_AutoAttend_Events_Again")
	public void user_Open_Workroom_AutoAttend_Events_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Workroom_AutoAttend_Events();
	}

	@Test(priority = 12, description = "user_Click_Event_28_Accept_As_Response_2")
	public void user_Click_Event_28_Accept_As_Response_2() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objectEvent = new EventPage();
		objectEvent.user_Click_Event_28_Accept_As_Response();
	}

	@Test(priority = 13, description = "AutoDirector_Can_Logout.")
	public void autoDirector_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 14, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester,password); // autoUser Login
	}
	
	@Test(priority = 15, description = "take_User_Attendance_Event_28")
	public void take_User_Attendance_Event_28() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objectEvent = new EventPage();
		objectEvent.take_User_Attendance_Event_28();
	}
	
	@Test(priority = 16, description = "generate_Attendance_Report")
	public void generate_Attendance_Report() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objectEvent = new EventPage();
		objectEvent.generate_Attendance_Report();
	}

	@Test(priority = 17, description = "user_Can_Delete_Event_And_Verify_Deleted")
	public void delete_Event_8() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_8();
	}
	
	@Test(priority = 18, description = "verify_Event_28_Deleted")
	public void verify_Event_28_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Take-Event-Attendance-Report");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_28_Deleted();
	}
}