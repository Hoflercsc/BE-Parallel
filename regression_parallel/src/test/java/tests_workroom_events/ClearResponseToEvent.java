package tests_workroom_events;

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

public class ClearResponseToEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoAttend_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event14);
	}

	@Test(priority = 5, description = "Scenario Login AutoUser UserName Password.")
	public void a_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 6, description = "user_Login_To_BoardEffect")
	public void user_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(workroomAdmin,password);
	}

	@Test(priority = 7, description = "user_Response_Maybe_Event_14")
	public void user_Response_Maybe_Event_14() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Response_Maybe_Event_14();
	}

	@Test(priority = 8, description = "workroomAdmin_Can_Logout")
	public void workroomAdmin_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 9, description = "workroomAdmin_Can_Logout")
	public void autoDirector_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector,password);
	}

	@Test(priority = 10, description = "user_Response_Decline_Event_14")
	public void user_Response_Decline_Event_14() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Response_Decline_Event_14();
	}

	@Test(priority = 11, description = "AutoDirector_Can_Logout.")
	public void autoDirector_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 12, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester,password); 
	}
	
	@Test(priority = 13, description = "clear_AutoTester_Response_Event_14")
	public void clear_AutoTester_Response_Event_14() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.clear_AutoTester_Response_Event_14();
	}
	
	@Test(priority = 14, description = "clear_Workroom_Admin_Response")
	public void clear_Workroom_Admin_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.clear_Workroom_Admin_Response();
	}
	
	@Test(priority = 15, description = "clear_Auto_Director_Response")
	public void clear_Auto_Director_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.clear_Auto_Director_Response();
	}

	@Test(priority = 16, description = "Delete_Event_Verify_Deletion_While_In_Guest_List")
	public void delete_Event_14() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Clear-Response-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_14();
	}
}