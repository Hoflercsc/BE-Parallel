package tests_critical_scenarios;

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
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.DiscussionPage;
import page_critical_scenarios.SurveyPage;
import page_critical_scenarios.TaskPage;
import static constants.ConstantsFile.*;

public class CreateTaskAndTaskGroup extends BaseTestCriticalScenarios {
	@Test(priority = 0, description = "Login Scenario with valid username and password.")
	public void login() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 1, description = "Add Task Group.")
	public void add_Task_Group() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objCreateTaskGroup = new TaskPage();
		objCreateTaskGroup.add_Task_Group();
	}

	@Test(priority = 2, description = "Create Task FillForm.")
	public void create_Task_FillForm() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objCreateTaskGroup = new TaskPage();
		objCreateTaskGroup.create_Task_FillForm();
	}

	@Test(priority = 3, description = "Create_Task_AttachFile.")
	public void create_Task_AttachFile() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objCreateTaskGroup = new TaskPage();
		objCreateTaskGroup.create_Task_AttachFile();
	}

	@Test(priority = 4, description = "Create Task Link Group.")
	public void create_Task_LinkGroup() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objCreateTaskGroup = new TaskPage();
		objCreateTaskGroup.create_Task_LinkGroup();
	}

	@Test(priority = 5, description = "Create Task Add Users.")
	public void create_Task_Add_Users() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objCreateTaskGroup = new TaskPage();
		objCreateTaskGroup.create_Task_Add_Users();
	}

	@Test(priority = 6, description = "verify_Task_Group_And_Task_Created.")
	public void verify_Task_Group_And_Task_Created() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objCreateTaskGroup = new TaskPage();
		objCreateTaskGroup.verify_Task_Group_And_Task_Created();
	}

	@Test(priority = 7, description = "Edit Task.")
	public void edit_Task() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objCreateTaskGroup = new TaskPage();
		objCreateTaskGroup.edit_Task();
	}

	@Test(priority = 8, description = "Delete Task.")
	public void delete_Task() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objCreateTaskGroup = new TaskPage();
		objCreateTaskGroup.delete_Task();
	}

	@Test(priority = 9, description = "Delete Group.")
	public void delete_Group() throws InterruptedException {
		test.assignCategory("CreateTaskAndTaskGroup");
		
		objCreateTaskGroup = new TaskPage();
		objCreateTaskGroup.delete_Group();
	}
}