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
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class AttachSurveyToNewEvent extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event7);
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Click_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "navigate_To_Survey_4_Create_Survey")
	public void navigate_To_Survey_4_Create_Survey() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.user_Navigates_To_Survey();
		objCreateSurvey.create_Survey_4_Condensed(survey4);
	}
	
	@Test(priority = 6, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 7, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}
	
	@Test(priority = 8, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.manage_Respondents();
	}

	@Test(priority = 9, description = "Scenario - Build Survey and Make Visible.")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	//---start here
	@Test(priority = 10, description = "attach_Event_7_To_Survey_4")
	public void attach_Event_7_To_Survey_4() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.attach_Event_7_To_Survey_4();
	}
	
	@Test(priority = 11, description = "verify_Event_Attached_To_Survey")
	public void verify_Event_Attached_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Event_7_Attached_To_Survey_4();
	}

	@Test(priority = 12, description = "delete_Event_7_Verify_Deletion")
	public void delete_Event_7_Verify_Deletion() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_7_Verify_Deletion();
	}
	
	@Test(priority = 13, description = "user_navigates_To_Survey")
	public void user_navigates_To_Survey_Again() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.user_Navigates_To_Survey();
	}
	
	@Test(priority = 14, description = "delete_Survey_4")
	public void delete_Survey_4() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_4();
	}
	
	@Test(priority = 15, description = "verify_Survey_4_NOT_Exist")
	public void verify_Survey_4_NOT_Exist() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Attach-Survey-To-New-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_4_NOT_Exist();
	}
	
}