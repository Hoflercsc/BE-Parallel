package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class CreateEditDeleteSchedulers extends BaseTestWorkroomCollaborate {
	
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Edit-Delete-Schedulers");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "create_Scheduler")
	public void create_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Edit-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Scheduler(schedulers4);
	}

	@Test(priority = 3, description = "create_Schedulers_Option")
	public void create_Schedulers_Option() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Edit-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Schedulers_Option();
	}

	@Test(priority = 4, description = "add_Survey_Respondents")
	public void add_Scheduler_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Edit-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.clickManageRespondentsAddUserC();
	}
	
	@Test(priority = 5, description = "build_Scheduler_Make_Visible")
	public void build_Scheduler_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Edit-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Schedulers_Make_Visible();
	}
	
	@Test(priority = 6, description = "edit_Schedulers")
	public void edit_Schedulers_4() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Edit-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.edit_Schedulers_4(schedulers4Edited);
	}
	
	@Test(priority = 7, description = "delete_Edited_Schedulers_4")
	public void delete_Edited_Schedulers_4() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Create-Edit-Delete-Schedulers");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Schedulers_4_Edited();
	}

}