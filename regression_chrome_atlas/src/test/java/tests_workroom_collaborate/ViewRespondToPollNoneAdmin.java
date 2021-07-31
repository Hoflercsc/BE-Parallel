package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class ViewRespondToPollNoneAdmin extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "Scenario Login Username and Password.")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "Scenario - Create Workroom Poll.")
	public void create_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.create_Poll();
	}

	@Test(priority = 3, description = "Scenario - Create Workroom Poll Question.")
	public void create_Poll_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.create_Poll_Question();
	}

	@Test(priority = 4, description = "Scenario - Add Workroom Poll Respondents.")
	public void add_Poll_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.manageRespondents_C();
	}
	
	@Test(priority = 5, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.build_Poll_Make_Visible();
	}
	
	@Test(priority = 6, description = "login")
	public void user_Log_Out() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "login_As_Automation_Tester")
	public void login_As_Automation_Tester() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 8, description = "user_Navigates_To_Poll")
	public void user_Navigates_To_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.user_Navigates_To_Poll_B();
	}
	
	@Test(priority = 9, description = "respond_To_Poll")
	public void respond_To_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.respond_To_Poll();
	}

	@Test(priority = 10, description = "automation_Tester_Log_Out")
	public void automation_Tester_Log_Out() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "System_Admin_Log_In")
	public void System_Admin_Log_In() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 12, description = "user_Navigates_To_Poll")
	public void user_Navigates_To_Poll_Again() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.user_Navigates_To_Poll_B();
	}
	
	@Test(priority = 13, description = "view_Poll_Individual_Reponses")
	public void view_Poll_Individual_Reponses() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.view_Poll_Individual_Reponses();
	}
	
	@Test(priority = 14, description = "delete_Survey")
	public void delete_Survey() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-Non-Admin");
		
		objCreatePoll = new PollPage(driver);
		objCreatePoll.delete_Poll();
	}

}