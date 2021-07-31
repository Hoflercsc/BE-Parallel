package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class RespondToSchedulersReviewResults extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "create_Scheduler")
	public void create_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Scheduler();
	}

	@Test(priority = 3, description = "create_Schedulers_Option")
	public void create_Schedulers_Option() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Schedulers_Option();
	}

	@Test(priority = 4, description = "add_Survey_Respondents")
	public void add_Scheduler_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.clickManageRespondentsAddUserC();
	}
	
	@Test(priority = 5, description = "build_Scheduler_Make_Visible")
	public void build_Scheduler_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Schedulers_Make_Visible();
	}
	
	@Test(priority = 6, description = "sysAdmin_Logout")
	public void sysAdmin_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 7, description = "login_As_Automation_Tester")
	public void login_As_Automation_Tester() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 8, description = "nonAdmin_Navigates_To_Schedulers")
	public void nonAdmin_Navigates_To_Schedulers() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.nonAdmin_Navigates_To_Schedulers();
	}
	
	@Test(priority = 9, description = "respond_To_Scheduler")
	public void respond_To_Scheduler() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.respond_To_Scheduler();
	}
	
	@Test(priority = 10, description = "autoDirector_Logout")
	public void autoDirector_Logout() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 11, description = "autoTester_Login_Agian")
	public void autoTester_Login_Agian() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 12, description = "admin_Navigates_To_Schedulers")
	public void admin_Navigates_To_Schedulers() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.admin_Navigates_To_Schedulers();
	}
	
	@Test(priority = 13, description = "view_Scheduler_Reponses_Non_Admin")
	public void view_Scheduler_Reponses_Non_Admin() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.view_Schedulers_Reponses_Non_Admin();
	}
	
	@Test(priority = 14, description = "delete_Schedulers")
	public void delete_Schedulers() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Schedulers");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Schedulers();
	}

}