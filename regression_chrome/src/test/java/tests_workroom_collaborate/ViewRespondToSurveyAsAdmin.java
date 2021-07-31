package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class ViewRespondToSurveyAsAdmin extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "create_Survey")
	public void create_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_Survey_Additional_Options();
	}

	@Test(priority = 3, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 4, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objCreateSurvey = new SurveyPage(driver);
		Thread.sleep(1500);
		objCreateSurvey.manage_Respondents();
	}
	
	@Test(priority = 5, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.build_Survey_Make_Visible_2();
	}
	
	@Test(priority = 6, description = "login")
	public void user_Log_Out() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 7, description = "login_As_Automation_Tester")
	public void login_As_Automation_Tester() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 8, description = "user_Goes_To_Survey")
	public void user_Goes_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.user_Goes_To_Survey();
	}
	
	@Test(priority = 9, description = "respond_To_Survey")
	public void respond_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.respond_To_Survey();
	}

	@Test(priority = 10, description = "automation_Tester_Log_Out")
	public void automation_Tester_Log_Out() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.user_Can_Logout();
	}
	
	@Test(priority = 11, description = "System_Admin_Log_In")
	public void System_Admin_Log_In() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 12, description = "user_Goes_To_Survey_Agian")
	public void user_Goes_To_Survey_Agian() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.user_Goes_To_Survey();
	}
	
	@Test(priority = 13, description = "view_Survey_Reponses")
	public void view_Survey_Reponses() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.view_Survey_Responses();
	}
	
	
	@Test(priority = 14, description = "delete_Survey")
	public void delete_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-As-Admin");
		
		objCreateSurvey = new SurveyPage(driver);
		objCreateSurvey.delete_Survey();
	}

}