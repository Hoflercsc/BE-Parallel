package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class ViewRespondToSurveyNonAdmin extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "login")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "create_Survey")
	public void create_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_Survey_Additional_Options(survey18);
	}

	@Test(priority = 3, description = "create_TextField_Question")
	public void create_TextField_Question() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.create_TextField_Question();
	}

	@Test(priority = 4, description = "add_Survey_Respondents")
	public void add_Survey_Respondents() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		Thread.sleep(1500);
		objCreateSurvey.manage_Respondents_B();
	}
	
	@Test(priority = 5, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.build_Survey_Make_Visible();
	}
	
	@Test(priority = 6, description = "login")
	public void user_Log_Out() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "login_As_Automation_Tester")
	public void login_As_Automation_Tester() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 8, description = "user_Goes_To_Survey_18_Non_Admin")
	public void user_Goes_To_Survey_18_Non_Admin() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.user_Goes_To_Survey_18_Non_Admin();
	}
	
	@Test(priority = 9, description = "respond_To_Survey")
	public void respond_To_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.respond_To_Survey();
	}

	@Test(priority = 10, description = "automation_Tester_Log_Out")
	public void automation_Tester_Log_Out() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "System_Admin_Log_In")
	public void System_Admin_Log_In() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 12, description = "user_Goes_To_Survey_Agian")
	public void user_Goes_To_Survey_Agian() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.user_Goes_To_Survey_18_Non_Admin();
	}
	
	@Test(priority = 13, description = "view_Survey_Reponses_Non_Admin")
	public void view_Survey_Reponses_Non_Admin() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.view_Survey_Reponses_Non_Admin();
	}
	
	@Test(priority = 14, description = "delete_Survey")
	public void delete_Survey() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.delete_Survey_18();
	}
	
	@Test(priority = 15, description = "verify_Survey_18_Deleted")
	public void verify_Survey_18_Deleted() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> View-Respond-To-Survey-Non-Admin");
		
		objCreateSurvey = new SurveyPage();
		objCreateSurvey.verify_Survey_18_Deleted();
	}


}