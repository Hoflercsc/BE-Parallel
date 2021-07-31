package tests_critical_scenarios;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_common_functions.AtlasNavBar;
import page_common_functions.LoginLogoutPage;
import page_critical_scenarios.WorkroomPage;
import parallel.DriverFactory;
import static constants.ConstantsFile.*;


public class CreateDeleteWorkroom extends BaseTestCriticalScenarios {
	
	@Test(priority = 1, description = "Login System Admin UserName Password.")
	public void systemAdmin_login() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");

		objBELogin = new LoginLogoutPage();
		objBELogin.login_BE(systemAdmin, password);
	}

	@Test(priority = 2, description = "user opens setting form and open workroom & group settings")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Workroom")
	public void user_Can_Create_New_Workroom() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");

		objectWorkroom = new WorkroomPage();
		objectWorkroom.user_Can_Create_New_Workroom();
	}

	@Test(priority = 4, description = "user_Can_Deactivate_Workroom")
	public void user_Can_Deactivate_Workroom() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");

		objectWorkroom = new WorkroomPage();
		objectWorkroom.user_Can_Deactivate_Workroom();
		 DriverFactory.getInstance().getDriver().navigate().refresh();
	}
	
	@Test(priority = 5, description = "user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again")
	public void user_Opens_Settings_Opens_Workroom_And_Group_Settings_Again() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");

		objectAtlasNavBar = new AtlasNavBar();
		objectAtlasNavBar.admin_Opens_Site_Settings_Workrooms_And_Groups();
	}

	@Test(priority = 6, description = "user_Can_Delete_Workroom")
	public void user_Can_Delete_Workroom() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");

		objectWorkroom = new WorkroomPage();
		objectWorkroom.user_Can_Delete_Workroom();
	}

	@Test(priority = 7, description = "verify_Workroom_Deleted")
	public void verify_Workroom_Deleted() throws InterruptedException {
		test.assignCategory("CreateDeleteWorkroom");

		objectWorkroom = new WorkroomPage();
		objectWorkroom.verify_Workroom_Deleted();
	}
}