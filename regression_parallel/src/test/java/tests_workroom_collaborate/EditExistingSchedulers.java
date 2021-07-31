package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class EditExistingSchedulers extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect_jhofler_Staging() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verifyworkroomSubnav();
		objCreateSurvey.clickSchedulersSubNav();
	}

	@Test(priority = 3, description = "edit_Schedulers_On_Staging")
	public void edit_Schedulers_On_Staging() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.edit_Schedulers_On_Staging(editedSchedulersTitle);
	}
	
	@Test(priority = 4, description = "edit_Schedulers_Back_To_Orginal_On_Staging")
	public void edit_Schedulers_Back_To_Orginal_On_Staging() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.edit_Schedulers_Back_To_Orginal_On_Staging(schedulersTitle);
	}
	
	@Test(priority = 5, description = "verify_Original_Schedulers_Title_DropDown")
	public void verify_Original_Schedulers_Title_DropDown() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verifySchedulersTitleDropDown();
	}

}