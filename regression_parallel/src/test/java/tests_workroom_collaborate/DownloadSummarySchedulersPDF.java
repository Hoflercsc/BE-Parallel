package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class DownloadSummarySchedulersPDF extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 1, description = "home_Page_Redirect")
	public void home_Page_Redirect_jhofler_Staging() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Schedulers-PDF");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 2, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Schedulers-PDF");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 3, description = "admin_Navigates_To_Schedulers")
	public void admin_Navigates_To_Schedulers() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Schedulers-PDF");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.admin_Navigates_To_Schedulers();
	}
	
	@Test(priority = 4, description = "view_Schedulers_Reponses_As_Admin")
	public void view_Schedulers_Reponses_As_Admin() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Schedulers-PDF");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.view_Schedulers_Reponses_As_Admin();
	}
	
	@Test(priority = 5, description = "download_Schedulers_As_PDF")
	public void download_Schedulers_As_PDF() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Summary-Schedulers-PDF");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.download_Schedulers_As_PDF();
	}

}