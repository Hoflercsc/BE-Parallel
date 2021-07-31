package tests_boardmember_access;

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
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class AttachCreateNewSurveytoEventExistingSiteData extends BaseTestBoardMemberAccess {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Library_Page_For_Workroom")
	public void user_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Events();
	}
	
	@Test(priority = 3, description = "user_Can_Create_New_Event_RSVPS")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.create_New_Event_On_JH_Staging_1(eventTitleStaging3);
	}
	
	@Test(priority = 5, description = "switch_To_Create_Survey_For_Event_Title_On_Staging_3")
	public void switch_To_Create_Survey_For_Event_Title_On_Staging_3() throws InterruptedException, AWTException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.switch_To_Create_Survey_For_Event_Title_On_Staging_3();
	}

	@Test(priority = 6, description = "creating_Survey_For_Event")
	public void creating_Survey_For_Event() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.creating_Survey_For_Event(surveyTitleStaging1);
	}
	
	@Test(priority = 7, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 8, description = "create_CheckBox_Question")
	public void create_CheckBox_Question() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_CheckBox_Question();
	}
	
	@Test(priority = 9, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.manage_Respondents_C();
	}

	@Test(priority = 10, description = "build_Survey_Make_Visible_On_Staging_1")
	public void build_Survey_Make_Visible_On_Staging_1() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible_On_Staging_1();
	}
	
	@Test(priority = 11, description = "verify_Survey_Added_To_Event_Title_On_Staging_3")
	public void verify_Survey_Added_To_Event_Title_On_Staging_3() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Survey_Added_To_Event_Title_On_Staging_3();
	}

	@Test(priority = 12, description = "delete_Event_Title_On_Staging_3")
	public void delete_Event_Title_On_Staging_3() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.delete_Event_Title_On_Staging_3();
	}
	
	@Test(priority = 13, description = "verify_Event_Title_On_Staging_3_Deleted")
	public void verify_Event_Title_On_Staging_3_Deleted() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objectEvent = new EventPage();
		objectEvent.verify_Event_Title_On_Staging_3_Deleted();
	}
	
	@Test(priority = 14, description = "user_navigates_To_Survey")
	public void user_navigates_To_Survey() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.user_Navigates_To_Survey();
	}
	
	@Test(priority = 15, description = "delete_Survey_Board_Member_Access_1")
	public void delete_Survey_Board_Member_Access_1() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_Board_Member_Access_1();
	}
	
	@Test(priority = 16, description = "verify_Survey_Deleted")
	public void verify_Survey_Deleted() throws InterruptedException {
		test.assignCategory("Board-Member-Access >> Attach-Survey-To-Event");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_Board_Member_Access_1_NOT_VISIBLE();
	}
	
}