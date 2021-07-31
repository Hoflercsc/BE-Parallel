package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class DownloadSummarySurveyExcel extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 1, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Survey-Excel");
		driver.get(HOME_PAGE_3);
	}
	
	@Test(priority = 2, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Survey-Excel");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 3, description = "user_navigates_To_Survey")
	public void user_navigates_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Survey-Excel");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.user_Goes_To_Survey_2();
	}
	
	@Test(priority = 4, description = "view_Survey_Responses")
	public void view_Survey_Responses() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Survey-Excel");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.view_Survey_Responses_2();
	}
	
	@Test(priority = 5, description = "download_Survey_As_Excel")
	public void download_Survey_As_Excel() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Survey-Excel");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.download_Survey_As_Excel();
	}


	

}