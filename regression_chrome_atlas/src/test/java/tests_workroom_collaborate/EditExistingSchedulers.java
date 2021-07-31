package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class EditExistingSchedulers extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "admin_Open_Workroom_AutoBE_Collaborate")
	public void admin_Open_Workroom_AutoBE_Collaborate() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verifyworkroomSubnav();
		objCreateSurvey.clickSchedulersSubNav();
	}

	@Test(priority = 3, description = "edit_Schedulers")
	public void edit_Schedulers() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.edit_Schedulers();
	}
	
	@Test(priority = 4, description = "edit_Schedulers_Back_To_Orginal")
	public void edit_Schedulers_Back_To_Orginal() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.edit_Schedulers_Back_To_Orginal();
	}
	
	@Test(priority = 5, description = "verify_Original_Schedulers_Title_DropDown")
	public void verify_Original_Schedulers_Title_DropDown() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Edit-Exsiting-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.verifySchedulersTitleDropDown();
	}

}