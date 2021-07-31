package test_critical_scenarios;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkroomPage;
import static constants.ConstantsFile.*;

public class CreateDeleteWorkroom extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Opens_Settings_Opens_Workroom_And_Group_Settings();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Workroom")
	public void user_Can_Create_New_Workroom() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Can_Create_New_Workroom();
	}

	@Test(priority = 4, description = "user_Can_Deactivate_Workroom")
	public void user_Can_Deactivate_Workroom() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Can_Deactivate_Workroom();
	}
	
	@Test(priority = 5, description = "close_Refresh_Go_Back")
	public void close_Refresh_Go_Back() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.close_Refresh_Go_Back();
	}

	@Test(priority = 6, description = "user_Can_Delete_Workroom")
	public void user_Can_Delete_Workroom() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.user_Can_Delete_Workroom();
	}

	@Test(priority = 7, description = "verify_Workroom_Deleted")
	public void verify_Workroom_Deleted() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");
		
		objectWorkroom = new WorkroomPage(driver);
		objectWorkroom.verify_Workroom_Deleted();
	}
}