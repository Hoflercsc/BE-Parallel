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
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event_RSVPS();
	}

	@Test(priority = 4, description = "user_Can_Click_Accept_As_Response")
	public void user_Can_Click_Accept_As_Response() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Click_Accept_As_Response();
	}
	
	@Test(priority = 5, description = "switch_To_Creating_Survey")
	public void switch_To_Creating_Survey() throws InterruptedException, AWTException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.switch_To_Creating_Survey();
	}

	@Test(priority = 6, description = "creating_Survey_For_Event")
	public void creating_Survey_For_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.creating_Survey_For_Event();
	}
	
	@Test(priority = 7, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 8, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_CheckBox_Question();
	}
	
	@Test(priority = 9, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.manage_Respondents();
	}

	@Test(priority = 10, description = "Scenario - Build Survey and Make Visible.")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 11, description = "verify_Survey_Added_To_Event")
	public void verify_Survey_Added_To_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Survey_Added_To_Event();
	}
	
	@Test(priority = 12, description = "remove_Attched_Survey_From_Event")
	public void remove_Attached_Survey_From_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.remove_Attached_Survey_From_Event();
	}

	@Test(priority = 13, description = "delete_Event")
	public void delete_Event() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Print_Upcoming_Event();
	}
	
	@Test(priority = 14, description = "verify_Event_Deleted")
	public void verify_Event_Deleted() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objectEvent = new EventPage(driver);
		objectEvent.verify_Event_Deleted_2();
	}
	
	@Test(priority = 15, description = "user_navigates_To_Survey")
	public void user_navigates_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.user_navigates_To_Survey();
	}
	
	@Test(priority = 16, description = "delete_Survey")
	public void delete_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Events >> Remove-Attached-Survey-From-Event");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Survey();
	}
	
	
}