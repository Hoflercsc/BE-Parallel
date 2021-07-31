package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class ViewHelpTextBlueIcon extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect_jhofler_Staging() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verifyworkroomSubnav();
		objCreateSurvey.clickSchedulersSubNav();
	}

	@Test(priority = 3, description = "navigate_To_Light_Bulb_Help_Text_In_Scheduler")
	public void navigate_To_Light_Bulb_Help_Text_In_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.navigate_To_Light_Bulb_Help_Text_In_Scheduler();
	}
	
	@Test(priority = 4, description = "verify_Help_Text_Shown")
	public void verify_Help_Text_Shown() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Help_Text_Shown();
	}

}