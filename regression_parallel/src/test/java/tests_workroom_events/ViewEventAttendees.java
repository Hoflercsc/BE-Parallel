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

public class ViewEventAttendees extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_Constellation_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event31);
	}

	@Test(priority = 4, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 5, description = "workroom_Admin_Login_To_BoardEffect")
	public void workroomAdmin_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser11,password);
	}
	
	@Test(priority = 6, description = "workroom_Member_Open_Constellation_Events")
	public void workroom_Member_Open_Constellation_Events() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Workroom_Constellation_Events();
	}

	@Test(priority = 7, description = "user_Click_Event_31_Accept_As_Response")
	public void user_Click_Event_31_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage();
		objectEvent.user_Click_Event_31_Accept_As_Response();
	}

	@Test(priority = 8, description = "workroomAdmin_Can_Logout")
	public void workroomAdmin_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 9, description = "workroomAdmin_Can_Logout")
	public void autoDirector_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoUser12,password);
	}
	
	@Test(priority = 10, description = "workroom_Member_Open_Constellation_Events_Again")
	public void workroom_Member_Open_Constellation_Events_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.workroom_Member_Open_Workroom_Constellation_Events();
	}

	@Test(priority = 11, description = "user_Click_Event_31_Accept_As_Response_Again")
	public void user_Click_Event_31_Accept_As_Response_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage();
		objectEvent.user_Click_Event_31_Accept_As_Response();
	}

	@Test(priority = 12, description = "AutoDirector_Can_Logout.")
	public void autoDirector_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 12, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester,password); // autoUser Login
	}
	
	@Test(priority = 13, description = "view_Attendees_Event_31")
	public void view_Attendees_Event_31() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage();
		objectEvent.view_Attendees_Event_31();
	}

	@Test(priority = 14, description = "user_Can_Delete_Event_And_Verify_Deleted")
	public void user_Can_Delete_Event_And_Verify_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_8();
	}
	
	@Test(priority = 15, description = "verify_Event_31_Deleted")
	public void verify_Event_31_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_31_Deleted();
	}
}