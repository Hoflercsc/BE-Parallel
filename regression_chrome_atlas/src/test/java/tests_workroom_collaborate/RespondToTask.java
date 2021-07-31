package tests_workroom_collaborate;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extentreports.ExtentFactory;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.DiscussionPage;
import page_critical_scenarios.SurveyPage;
import page_critical_scenarios.TaskPage;
import static constants.ConstantsFile.*;

public class RespondToTask extends BaseTestWorkroomCollaborate {
	@Test(priority = 0, description = "Login Scenario with valid username and password.")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 1, description = "Add Task Group.")
	public void add_Task_Group() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.add_Task_Group();
	}

	@Test(priority = 2, description = "Create Task FillForm.")
	public void create_Task_FillForm() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.create_Task_FillForm();
	}

	@Test(priority = 3, description = "Create_Task_AttachFile.")
	public void create_Task_AttachFile() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.create_Task_AttachFile();
	}

	@Test(priority = 4, description = "Create Task Link Group.")
	public void create_Task_LinkGroup() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.create_Task_LinkGroup();
	}

	@Test(priority = 5, description = "Create Task Add Users.")
	public void create_Task_Add_Users() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.create_Task_Add_Users_B();
	}

	@Test(priority = 6, description = "verify_Task_Group_And_Task_Created.")
	public void verify_Task_Group_And_Task_Created() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.verify_Task_Group_And_Task_Created();
	}

	@Test(priority = 7, description = "login")
	public void user_Log_Out() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 8, description = "login_As_Automation_Tester")
	public void login_As_Automation_Tester() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoDirector, password);
	}
	
	@Test(priority = 9, description = "Delete Task.")
	public void navigate_To_Task() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.navigate_To_Tasks();
	}
	
	@Test(priority = 10, description = "respond_To_Task")
	public void respond_To_Task() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.respond_To_Task();
	}
	
	@Test(priority = 11, description = "user_Log_Out_Again")
	public void user_Log_Out_Again() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objAtlasNavBar = new AtlasNavBar(driver);
		objAtlasNavBar.user_Can_Sign_Out();
	}
	
	@Test(priority = 12, description = "login_As_SystemAdmin")
	public void login_As_SystemAdmin() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}
	
	@Test(priority = 13, description = "Delete Task.")
	public void navigate_To_Task_Again() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.navigate_To_Tasks();
	}

	@Test(priority = 14, description = "verify_Response_To_Task Task.")
	public void verify_Response_To_Task() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.verify_Response_To_Task();
	}
	
	@Test(priority = 15, description = "Delete Task.")
	public void delete_Task() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.delete_Task();
	}
	
	@Test(priority = 16, description = "Delete Group.")
	public void delete_Group() throws InterruptedException {
		test.assignCategory("Workroom Collaborate >> Respond-To-Task");
		
		objCreateTaskGroup = new TaskPage(driver);
		objCreateTaskGroup.delete_Group();
	}
}