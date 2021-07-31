package tests_workroom_collaborate;

import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLEngineResult.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import page_common_functions.LoginLogoutPage;
import page_poll.PollPage;
import page_survey.SurveyPage;
import static constants.ConstantsFile.*;

public class EditPollQuestions extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "Scenario Login Username and Password.")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Poll-Questions");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "Scenario - Create Workroom Poll.")
	public void create_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Poll-Questions");
		
		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll(poll2);
	}

	@Test(priority = 3, description = "Scenario - Create Workroom Poll Question.")
	public void create_Poll_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Poll-Questions");
		
		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll_Question();
	}

	@Test(priority = 4, description = "Scenario - Add Workroom Poll Respondents.")
	public void add_Poll_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Poll-Questions");
		
		objCreatePoll = new PollPage();
		objCreatePoll.manageRespondents_C();
	}
	
	@Test(priority = 5, description = "navigate_To_Edit_Poll")
	public void navigate_To_Edit_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreatePoll = new PollPage();
		objCreatePoll.navigate_To_Edit_Poll();
	}
	
	@Test(priority = 6, description = "edit_Poll_2_Question")
	public void edit_Poll_2_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Survey-Questions");
		
		objCreatePoll = new PollPage();
		objCreatePoll.edit_Poll_2_Question();
	}

	@Test(priority = 7, description = "build_Poll_Make_Visible")
	public void build_Poll_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Poll-Questions");
		
		objCreatePoll = new PollPage();
		objCreatePoll.build_Poll_Make_Visible();
	}
	
	@Test(priority = 8, description = "delete_Poll_2")
	public void delete_Poll_2() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Poll-Questions");
		
		objCreatePoll = new PollPage();
		objCreatePoll.delete_Poll_2();
	}
	
	@Test(priority = 9, description = "verify_Poll_2_NOT_EXIST")
	public void verify_Poll_2_NOT_EXIST() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Edit-Poll-Questions");
		
		objCreatePoll = new PollPage();
		objCreatePoll.verify_Poll_2_NOT_EXIST();
	}
	
}