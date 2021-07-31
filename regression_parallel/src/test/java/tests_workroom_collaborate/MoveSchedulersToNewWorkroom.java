package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class MoveSchedulersToNewWorkroom extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Schedulers-To-New-Workroom");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "create_Scheduler")
	public void create_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Schedulers-To-New-Workroom");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Scheduler(schedulers5);
	}

	@Test(priority = 3, description = "create_Schedulers_Option")
	public void create_Schedulers_Option() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Schedulers-To-New-Workroom");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Schedulers_Option();
	}

	@Test(priority = 4, description = "add_Survey_Respondents")
	public void add_Scheduler_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Schedulers-To-New-Workroom");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.clickManageRespondentsAddUserC();
	}
	
	@Test(priority = 5, description = "build_Scheduler_Make_Visible")
	public void build_Scheduler_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Schedulers-To-New-Workroom");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Schedulers_Make_Visible();
	}
	
	@Test(priority = 6, description = "move_Schedulers_To_Another_Workroom")
	public void move_Schedulers_To_Another_Workroom() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Schedulers-To-New-Workroom");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.move_Schedulers_To_Another_Workroom();
	}
	
	@Test(priority = 7, description = "verify_Move_Scheduler_5_To_Workroom_AutoAttend")
	public void verify_Move_Scheduler_5_To_Workroom_AutoAttend() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Schedulers-To-New-Workroom");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Move_Scheduler_5_To_Workroom_AutoAttend();
	}
	
	@Test(priority = 8, description = "delete_Schedulers")
	public void delete_Schedulers_5() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Schedulers-To-New-Workroom");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Schedulers_5();
	}
	
	@Test(priority = 9, description = "verify_Schedulers_3_Deleted")
	public void verify_Schedulers_5_Deleted() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Move-Schedulers-To-New-Workroom");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Schedulers_5_Deleted();
	}

}