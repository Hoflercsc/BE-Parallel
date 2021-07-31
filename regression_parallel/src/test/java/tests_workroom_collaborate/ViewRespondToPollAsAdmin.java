package tests_workroom_collaborate;

import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class ViewRespondToPollAsAdmin extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "Scenario Login Username and Password.")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "Scenario - Create Workroom Poll.")
	public void create_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll(poll4);
	}

	@Test(priority = 3, description = "Scenario - Create Workroom Poll Question.")
	public void create_Poll_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll_Question();
	}

	@Test(priority = 4, description = "Scenario - Add Workroom Poll Respondents.")
	public void add_Poll_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objCreatePoll = new PollPage();
		objCreatePoll.manageRespondents_B();
	}
	
	@Test(priority = 5, description = "build_Survey_Make_Visible")
	public void build_Survey_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objCreatePoll = new PollPage();
		objCreatePoll.build_Poll_Make_Visible();
	}
	
	@Test(priority = 6, description = "login")
	public void user_Log_Out() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 7, description = "login_As_Automation_Tester")
	public void login_As_Automation_Tester() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}
	
	@Test(priority = 8, description = "user_Navigates_To_Poll_4")
	public void user_Navigates_To_Poll_4() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objCreatePoll = new PollPage();
		objCreatePoll.user_Navigates_To_Poll_4();
	}
	
	@Test(priority = 9, description = "respond_To_Poll_4")
	public void respond_To_Poll_4() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objCreatePoll = new PollPage();
		objCreatePoll.respond_To_Poll_4();
	}

	@Test(priority = 10, description = "automation_Tester_Log_Out")
	public void automation_Tester_Log_Out() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objAtlasNavBar = new AtlasNavBar();
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 11, description = "System_Admin_Log_In")
	public void System_Admin_Log_In() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 12, description = "user_Navigates_To_Poll")
	public void user_Navigates_To_Poll_Again() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objCreatePoll = new PollPage();
		objCreatePoll.user_Navigates_To_Poll_4();
	}
	
	@Test(priority = 13, description = "view_Poll_4_Reponses")
	public void view_Poll_4_Reponses() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objCreatePoll = new PollPage();
		objCreatePoll.view_Poll_4_Reponses();
	}
	
	@Test(priority = 14, description = "delete_Poll_4")
	public void delete_Poll_4() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> View-Respond-To-Poll-As-Admin");
		
		objCreatePoll = new PollPage();
		objCreatePoll.delete_Poll_4();
	}

}