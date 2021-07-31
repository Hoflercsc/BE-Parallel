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
import page_critical_scenarios.EventPage;
import static constants.ConstantsFile.*;

public class CreateEditCopyDeleteEvent extends BaseTestCriticalScenarios {
	@Test(priority = 1, description = "Scenario Login AutoUser UserName Password.")
	public void autoUser_login() throws InterruptedException {
		test.assignCategory("CreateEditCopyDeleteEvent");
		
		objBELogin = new LoginLogoutPage(driver);
		objBELogin.login_BE(autoTester, password);
	}

	@Test(priority = 2, description = "user_Can_Open_Events_for_Workroom")
	public void user_Can_Open_Events_for_Workroom() throws InterruptedException {
		test.assignCategory("CreateEditCopyDeleteEvent");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Open_Events_for_Workroom();
	}

	@Test(priority = 3, description = "user_Can_Create_New_Event")
	public void user_Can_Create_New_Event() throws InterruptedException {
		test.assignCategory("CreateEditCopyDeleteEvent");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Create_New_Event();
	}

	@Test(priority = 4, description = "user_Can_Edit_Event")
	public void user_Can_Edit_Event() throws InterruptedException {
		test.assignCategory("CreateEditCopyDeleteEvent");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Edit_Event();
	}

	@Test(priority = 5, description = "user_Can_Copy_Event")
	public void user_Can_Copy_Event() throws InterruptedException {
		test.assignCategory("CreateEditCopyDeleteEvent");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Copy_Event();
	}

	@Test(priority = 6, description = "user_Can_Delete_Copied_Event")
	public void user_Can_Delete_Copied_Event() throws InterruptedException {
		test.assignCategory("CreateEditCopyDeleteEvent");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Can_Delete_Copied_Event();
	}

	@Test(priority = 7, description = "user_Delete_Event")
	public void user_Delete_Event() throws InterruptedException {
		test.assignCategory("CreateEditCopyDeleteEvent");
		
		objectEvent = new EventPage(driver);
		objectEvent.user_Delete_Event();
	}
}