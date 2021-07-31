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
import page_common_functions.LoginLogoutPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class ViewEventAttendees extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Open_Events_for_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS_B();
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}

	@Test(priority = 5, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout(); // autoUser Login
	}

	@Test(priority = 6, description = "workroom_Admin_Login_To_BoardEffect")
	public void workroomAdmin_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(workroomAdmin,password);
	}

	@Test(priority = 7, description = "workroomAdmin_Response_Accept")
	public void workroomAdmin_Response_Accept() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage(driver);
		objectEvent.workroomAdmin_Response_Accept();
	}

	@Test(priority = 8, description = "workroomAdmin_Can_Logout")
	public void workroomAdmin_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout(); // autoUser Login
	}

	@Test(priority = 9, description = "workroomAdmin_Can_Logout")
	public void autoDirector_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector,password);
	}

	@Test(priority = 10, description = "autoDirector_Response_Accept")
	public void autoDirector_Response_Accept() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage(driver);
		objectEvent.autoDirector_Response_Accept();
	}

	@Test(priority = 11, description = "AutoDirector_Can_Logout.")
	public void autoDirector_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout(); // autoUser Login
	}

	@Test(priority = 12, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester,password); // autoUser Login
	}
	
	@Test(priority = 13, description = "autoUser_View_Attendees")
	public void autoUser_View_Attendees() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage(driver);
		objectEvent.view_Attendees();
	}

	@Test(priority = 14, description = "user_Can_Delete_Event_And_Verify_Deleted")
	public void user_Can_Delete_Event_And_Verify_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> View-Event-Attendees");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Event();
	}
}