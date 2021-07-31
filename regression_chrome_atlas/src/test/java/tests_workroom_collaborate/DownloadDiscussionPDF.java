package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.DiscussionPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class DownloadDiscussionPDF extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 1, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Discussion-PDF");
		driver.get(HOME_PAGE_3);
		Thread.sleep(1500);
	}
	
	@Test(priority = 2, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Discussion-PDF");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 3, description = "user_navigates_To_Discussions")
	public void user_navigates_To_Discussions() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Discussion-PDF");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.user_Navigates_To_Discussions();
	}
	
	@Test(priority = 4, description = "download_Discussion_As_PDF")
	public void download_Discussion_As_PDF() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Download-Discussion-PDF");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.download_Discussion_As_PDF();
	}
	
}
	
