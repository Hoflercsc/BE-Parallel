package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class ViewHelpTextBlueIcon extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verifyworkroomSubnav();
		objCreateSurvey.clickSchedulersSubNav();
	}

	@Test(priority = 3, description = "navigate_To_Light_Bulb_Help_Text_In_Scheduler")
	public void navigate_To_Light_Bulb_Help_Text_In_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.navigate_To_Light_Bulb_Help_Text_In_Scheduler();
	}
	
	@Test(priority = 4, description = "verify_Help_Text_Shown")
	public void verify_Help_Text_Shown() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Help-Text-Blue-Icon");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verify_Help_Text_Shown();
	}

}