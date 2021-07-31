package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;

public class CopyScheduler extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 0, description = "home_Page_Redirect")
	public void home_Page_Redirect() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Copy-Schedulers");
		DriverFactory.getInstance().getDriver().get(HOME_PAGE_STAGING);
	}
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Copy-Schedulers");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "navigate_To_Existing_Scheduler")
	public void navigate_To_Existing_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Copy-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.navigate_To_Existing_Scheduler();
	}

	@Test(priority = 3, description = "copy_Scheduler")
	public void copy_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Copy-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.copy_Scheduler();
	}
	
	@Test(priority = 4, description = "build_Schedulers_Make_Visible")
	public void build_Schedulers_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Copy-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Schedulers_Make_Visible();
	}
	
	@Test(priority = 5, description = "delete_Schedulers")
	public void delete_Copied_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Copy-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Copied_Scheduler();
	}
	
	@Test(priority = 5, description = "verify_Copied_Scheduler_Deleted")
	public void verify_Copied_Scheduler_Deleted() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Copy-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Copied_Scheduler_Deleted();
	}

}