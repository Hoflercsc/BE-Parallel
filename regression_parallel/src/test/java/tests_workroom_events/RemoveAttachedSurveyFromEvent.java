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
import page_poll.PollPage;
import page_survey.SurveyPage;
import page_workroom_events.EventPage;
import static constants.ConstantsFile.*;

public class RemoveAttachedSurveyFromEvent extends BaseTestWorkroomEvents {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Can_Create_New_Event_RSVPS(event26);
	}

	@Test(priority = 4, description = "user_Click_Event_26_Accept_As_Response")
	public void user_Click_Event_26_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage();
		objectEvent.user_Click_Event_26_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "switch_To_Event_26_Attach_Survey")
	public void switch_To_Event_26_Attach_Survey() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage();
		objectEvent.switch_To_Event_26_Attach_Survey();
	}

	@Test(priority = 6, description = "creating_Survey_For_Event")
	public void creating_Survey_For_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.creating_Survey_For_Event(survey20);
	}
	
	@Test(priority = 7, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 8, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}
	
	@Test(priority = 9, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.manage_Respondents();
	}

	@Test(priority = 10, description = "Scenario - Build Survey and Make Visible.")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 11, description = "verify_Survey_Added_To_Event_26")
	public void verify_Survey_Added_To_Event_26() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Survey_Added_To_Event_26();
	}
	
	@Test(priority = 12, description = "remove_Attached_Survey_From_Event_26")
	public void remove_Attached_Survey_From_Event_26() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage();
		objectEvent.remove_Attached_Survey_From_Event_26();
	}

	@Test(priority = 13, description = "delete_Event_26")
	public void delete_Event_26() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_8();
	}
	
	@Test(priority = 14, description = "verify_Event_26_Deleted")
	public void verify_Event_26_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_26_Deleted();
	}
	
	@Test(priority = 15, description = "user_navigates_To_Survey")
	public void user_navigates_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.user_Navigates_To_Survey();
	}
	
	@Test(priority = 16, description = "delete_Survey_20")
	public void delete_Survey_20() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_20();
	}
	
	@Test(priority = 17, description = "verify_Survey_19_Deleted")
	public void verify_Survey_20_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_19_Deleted();
	}
	
	
}