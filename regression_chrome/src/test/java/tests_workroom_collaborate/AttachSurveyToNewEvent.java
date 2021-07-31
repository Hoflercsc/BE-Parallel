package tests_workroom_collaborate;

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
import page_poll.PollPage;
import page_survey.SurveyPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class AttachSurveyToNewEvent extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Open_Events_for_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "navigate_To_Survey_Create_Survey")
	public void navigate_To_Survey_Create_Survey() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.user_navigates_To_Survey();
		objCreateSurvey.create_Survey_Condensed();
	}
	
	@Test(priority = 6, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 7, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}
	
	@Test(priority = 8, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.manage_Respondents();
	}

	@Test(priority = 9, description = "Scenario - Build Survey and Make Visible.")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	//---start here
	@Test(priority = 10, description = "attach_Event_To_Survey")
	public void attach_Event_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.attach_Event_To_Survey();
	}
	
	@Test(priority = 11, description = "verify_Event_Attached_To_Survey")
	public void verify_Event_Attached_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verify_Event_Attached_To_Survey();
	}

	@Test(priority = 12, description = "user_Delete_Event_And_Veirfied_Deleted")
	public void user_Delete_Event_And_Veirfied_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.Delete_Event_Verify_Deletion_In_Guest_List();
	}
	
	@Test(priority = 13, description = "user_navigates_To_Survey")
	public void user_navigates_To_Survey_Again() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.user_navigates_To_Survey();
	}
	
	@Test(priority = 14, description = "delete_Survey")
	public void delete_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Survey();
	}
	
//	@Test(priority = 15, description = "verify_Survey_Delete")
//	public void verify_Survey_Delete() throws InterruptedException {
//		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
//		
//		objCreateSurvey = new SurveyPage(driver);
//		objCreateSurvey.verify_Survey_NOT_Exist();
//	}
	
}