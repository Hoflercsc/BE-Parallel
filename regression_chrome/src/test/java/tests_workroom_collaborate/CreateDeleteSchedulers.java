package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class CreateDeleteSchedulers extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "create_Scheduler")
	public void create_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Scheduler();
	}

	@Test(priority = 3, description = "create_Schedulers_Option")
	public void create_Schedulers_Option() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Schedulers_Option();
	}

	@Test(priority = 4, description = "add_Survey_Respondents")
	public void add_Scheduler_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.clickManageRespondentsAddUserC();
	}
	
	@Test(priority = 5, description = "build_Scheduler_Make_Visible")
	public void build_Scheduler_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Schedulers_Make_Visible();
	}
	
	@Test(priority = 6, description = "delete_Schedulers")
	public void delete_Schedulers() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Schedulers();
	}

}