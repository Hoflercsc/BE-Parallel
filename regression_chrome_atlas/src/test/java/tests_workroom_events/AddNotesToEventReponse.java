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

public class AddNotesToEventReponse extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password); // autoUser Login
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}

	@Test(priority = 5, description = "Scenario Login AutoUser UserName Password.")
	public void autoTester_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 6, description = "workroom_Admin_Login_To_BoardEffect")
	public void workroomAdmin_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(workroomAdmin,password);
	}

	@Test(priority = 7, description = "workroomAdmin_Response_Maybe")
	public void workroomAdmin_Response_Maybe() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objectEvent = new EventPage(driver);
		objectEvent.workroomAdmin_Response_Maybe();
	}

	@Test(priority = 8, description = "workroomAdmin_Can_Logout")
	public void workroomAdmin_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 9, description = "workroomAdmin_Can_Logout")
	public void autoDirector_Login_To_BoardEffect() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector,password);
	}

	@Test(priority = 10, description = "workroomAdmin_Can_Logout")
	public void autoDirector_Response_Decline() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objectEvent = new EventPage(driver);
		objectEvent.autoDirector_Response_Decline();
	}

	@Test(priority = 11, description = "AutoDirector_Can_Logout.")
	public void autoDirector_logout() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}

	@Test(priority = 12, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login_Again() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester,password); 
	}
	
	@Test(priority = 13, description = "add_Notes_To_AutoTester_Response")
	public void add_Notes_To_AutoTester_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objectEvent = new EventPage(driver);
		objectEvent.add_Notes_To_AutoTester_Response();
	}
	
	@Test(priority = 14, description = "add_Notes_To_Workroom_Admin")
	public void add_Notes_To_Workroom_Admin() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objectEvent = new EventPage(driver);
		objectEvent.add_Notes_To_Workroom_Admin();
	}
	
	@Test(priority = 15, description = "add_Notes_To_AutoDirector")
	public void add_Notes_To_AutoDirector() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objectEvent = new EventPage(driver);
		objectEvent.add_Notes_To_AutoDirector();
	}
	
	@Test(priority = 16, description = "verify_All_Three_Responses")
	public void verify_All_Three_Responses() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_All_Three_Responses();
	}

	@Test(priority = 17, description = "Delete_Event_Verify_Deletion_While_In_Guest_List")
	public void delete_Event_Verify_Deletion_In_Guest_List() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Add-Notes-To-Event-Response");
		
		objectEvent = new EventPage(driver);
		objectEvent.Delete_Event_Verify_Deletion_In_Guest_List();
	}
}