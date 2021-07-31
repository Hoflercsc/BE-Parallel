package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class RespondToSchedulersAsNonAdminReviewResults extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "create_Scheduler")
	public void create_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Scheduler(schedulers6);
	}

	@Test(priority = 3, description = "create_Schedulers_Option")
	public void create_Schedulers_Option() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Schedulers_Option();
	}

	@Test(priority = 4, description = "add_Survey_Respondents")
	public void add_Scheduler_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.clickManageRespondentsAddUserC();
	}
	
	@Test(priority = 5, description = "build_Scheduler_Make_Visible")
	public void build_Scheduler_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Schedulers_Make_Visible();
	}
	
	@Test(priority = 6, description = "sysAdmin_Logout")
	public void sysAdmin_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "login_As_Automation_Tester")
	public void login_As_Automation_Tester() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 8, description = "nonAdmin_Navigates_To_Schedulers")
	public void nonAdmin_Navigates_To_Schedulers() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.nonAdmin_Navigates_To_Schedulers();
	}
	
	@Test(priority = 9, description = "respond_To_Scheduler_6")
	public void respond_To_Scheduler_6() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.respond_To_Scheduler_6();
	}
	
	@Test(priority = 10, description = "autoDirector_Logout")
	public void autoDirector_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "autoTester_Login_Agian")
	public void autoTester_Login_Agian() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 12, description = "admin_Navigates_To_Schedulers")
	public void admin_Navigates_To_Schedulers() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.admin_Navigates_To_Schedulers();
	}
	
	@Test(priority = 13, description = "view_Schedulers_6_Reponses_Non_Admin")
	public void view_Schedulers_6_Reponses_Non_Admin() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.view_Schedulers_6_Reponses_Non_Admin();
	}
	
	@Test(priority = 14, description = "delete_Schedulers_6")
	public void delete_Schedulers_6() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers-As-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Schedulers_6();
	}

}