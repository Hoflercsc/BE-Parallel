package test_critical_scenarios;

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
import page_critical_scenarios.AtlasNavBar;
import page_critical_scenarios.DiscussionPage;
import page_critical_scenarios.PollPage;
import page_critical_scenarios.SurveyPage;
import static constants.ConstantsFile.*;

public class CreateDiscussionSenarios1 extends BaseTestCriticalScenarios {	
	@Test(priority = 0, description = "Login Scenario with valid username and password.")
	public void login() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}
	
	@Test(priority = 1, description = "user_Can_Open_Library_Page_For_Workroom")
	public void Workroom_Admin_Can_Open_Library_Page_For_Workroom() throws InterruptedException {
		test.assignCategory("CreateBookSecuredCategory");
		
		objectAtlasNavBar = new AtlasNavBar(driver);
		objectAtlasNavBar.admin_Open_Workroom_AutoBE_Collaborate();
	}

	@Test(priority = 2, description = "Create Upcoming Discussion Future Date.")
	public void create_Upcoming_Discussion_Future_Date() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.create_Discussion_Future_Date();
	}

//	@Test(priority = 3, description = "Create Closed Discussion Past Date.")
//	public void create_Closed_Discussion_End_Date_Past() throws InterruptedException {
//		test.assignCategory("CreateDiscussionSenarios1");
//		
//		objCreateDiscussion = new DiscussionPage(driver);
//		objCreateDiscussion.create_Discussion_Future_Date_Past();
//	}

	@Test(priority = 4, description = "create_Open_Discussion_AssignUsers")
	public void create_Open_Discussion_Current_Date_AssignUsers() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.create_Open_Discussion_AssignUsers();
	}

	@Test(priority = 5, description = "Create_Discussion_MainTopic")
	public void create_Discussion_MainTopic() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.create_Discussion_MainTopic();
	}

	@Test(priority = 6, description = "create_Topic_Reply_And_Attachment")
	public void create_Topic_Reply_And_Attachment() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.create_Topic_Reply_And_Attachment();
	}

	@Test(priority = 7, description = "discussion_Search_4_Reply")
	public void discussion_Search_4_Reply() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.discussion_Search_4_Reply();
	}

	@Test(priority = 8, description = "edit_Discussion_Topic")
	public void edit_Discussion_Topic() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.edit_Discussion_Topic();
	}

	@Test(priority = 9, description = "edit_Discussion_Topic_Reply")
	public void edit_Discussion_Topic_Reply() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.edit_Discussion_Topic_Reply();
	}

	@Test(priority = 10, description = "delete_Reply_To_Discussion_Topic")
	public void delete_Reply_To_Discussion_Topic() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.delete_Reply_To_Discussion_Topic();
	}

	@Test(priority = 11, description = "delete_Discussion_Topic")
	public void delete_Discussion_Topic() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.delete_Discussion_Topic();
	}

	@Test(priority = 12, description = "archive_Discussion")
	public void archive_Discussion() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.archive_Discussion();
	}

	@Test(priority = 13, description = "restore_Archived_Discussion")
	public void restore_Archived_Discussion() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.restore_Archived_Discussion();
		
	}

	@Test(priority = 14, description = "verify_restored_Archived_Discussion")
	public void verify_restored_Archived_Discussion() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.verify_restored_Archived_Discussion();
	}

	@Test(priority = 15, description = "close_Open_Upcoming_And_Closed_Discussions")
	public void close_Open_Upcoming_Closed_Discussions() throws InterruptedException {
		test.assignCategory("CreateDiscussionSenarios1");
		
		objCreateDiscussion = new DiscussionPage(driver);
		objCreateDiscussion.close_Open_Upcoming_And_Closed_Discussions();
	}
}