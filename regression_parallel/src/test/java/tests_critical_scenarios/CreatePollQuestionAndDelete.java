package tests_critical_scenarios;

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
import page_critical_scenarios.PollPage;
import static constants.ConstantsFile.*;

public class CreatePollQuestionAndDelete extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Scenario Login Username and Password.")
	public void login() throws InterruptedException {
		test.assignCategory("CreatePollQuestionAndDelete");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "Scenario - Create Workroom Poll.")
	public void create_Poll() throws InterruptedException {
		test.assignCategory("CreatePollQuestionAndDelete");

		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll();
	}

	@Test(priority = 3, description = "Scenario - Create Workroom Poll Question.")
	public void create_Poll_Question() throws InterruptedException {
		test.assignCategory("CreatePollQuestionAndDelete");
		
		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll_Question();
	}

	@Test(priority = 4, description = "Scenario - Add Workroom Poll Respondents.")
	public void add_Poll_Respondents() throws InterruptedException {
		test.assignCategory("CreatePollQuestionAndDelete");
		
		objCreatePoll = new PollPage();
		objCreatePoll.manageRespondents();
	}

	@Test(priority = 5, description = "Scenario - Build Poll and Make Visible.")
	public void build_Poll_Make_Visible() throws InterruptedException {
		test.assignCategory("CreatePollQuestionAndDelete");
		
		objCreatePoll = new PollPage();
		objCreatePoll.build_Poll_Make_Visible();
	}

	@Test(priority = 6, description = "Scenario - Delete Poll.")
	public void delete_Poll() throws InterruptedException {
		test.assignCategory("CreatePollQuestionAndDelete");
		
		objCreatePoll = new PollPage();
		objCreatePoll.delete_Poll();
	}
}