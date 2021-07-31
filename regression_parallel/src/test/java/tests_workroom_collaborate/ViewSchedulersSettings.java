package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class ViewSchedulersSettings extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "create_Scheduler")
	public void create_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Scheduler(schedulers1);
	}

	@Test(priority = 3, description = "create_Schedulers_Option")
	public void create_Schedulers_Option() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Schedulers_Option();
	}

	@Test(priority = 4, description = "add_Survey_Respondents")
	public void add_Scheduler_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.clickManageRespondentsAddUserC();
	}
	
	@Test(priority = 5, description = "build_Scheduler_Make_Visible")
	public void build_Scheduler_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Schedulers_Make_Visible();
	}
	
	@Test(priority = 6, description = "view_Schedulers_1_Settings")
	public void view_Schedulers_1_Settings() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.view_Schedulers_1_Settings();
	}
	
	@Test(priority = 7, description = "delete_Schedulers_1")
	public void delete_Schedulers_1() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Schedulers_1();
	}
	
	@Test(priority = 8, description = "verify_Scheduler_1_Deleted")
	public void verify_Scheduler_1_Deleted() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Scheduler_1_Deleted();
	}

}