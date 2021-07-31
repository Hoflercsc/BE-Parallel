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
import static constants.ConstantsFile.*;

public class ArchivePoll extends BaseTestWorkroomCollaborate {
	@Test(priority = 1, description = "Scenario Login Username and Password.")
	public void login() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Poll");
		
		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(automationTester, password);
	}

	@Test(priority = 2, description = "Scenario - Create Workroom Poll.")
	public void create_Poll() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Poll");
		
		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll(poll1);
	}

	@Test(priority = 3, description = "Scenario - Create Workroom Poll Question.")
	public void create_Poll_Question() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Poll");
		
		objCreatePoll = new PollPage();
		objCreatePoll.create_Poll_Question();
	}

	@Test(priority = 4, description = "Scenario - Add Workroom Poll Respondents.")
	public void add_Poll_Respondents() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Poll");
		
		objCreatePoll = new PollPage();
		objCreatePoll.manageRespondents_C();
	}

	@Test(priority = 5, description = "build_Poll_Make_Visible")
	public void build_Poll_Make_Visible() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Poll");
		
		objCreatePoll = new PollPage();
		objCreatePoll.build_Poll_Make_Visible();
	}
	
	@Test(priority = 6, description = "archive_Poll_1")
	public void archive_Poll_1() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Poll");
		
		objCreatePoll = new PollPage();
		objCreatePoll.archive_Poll_1();
	}
	
	@Test(priority = 7, description = "veirfy_Poll_1_Archived")
	public void veirfy_Poll_1_Archived() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Poll");
		
		objCreatePoll = new PollPage();
		objCreatePoll.veirfy_Poll_1_Archived();
	}

	@Test(priority = 8, description = "delete_Poll_1")
	public void delete_Poll_1() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Poll");
		
		objCreatePoll = new PollPage();
		objCreatePoll.delete_Poll_1();
	}
	
	@Test(priority = 9, description = "verify_Poll_1_NOT_EXIST")
	public void verify_Poll_1_NOT_EXIST() throws InterruptedException {
		test.assignCategory("Workroom-Collaborate >> Archive-Poll");
		
		objCreatePoll = new PollPage();
		objCreatePoll.verify_Poll_1_NOT_EXIST();
	}
	
}